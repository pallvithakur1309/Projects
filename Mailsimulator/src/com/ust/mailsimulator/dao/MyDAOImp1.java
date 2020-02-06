package com.ust.mailsimulator.dao;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ust.mailsimulator.model.Mailinfo;
import com.ust.mailsimulator.model.Userinfo;

@Component
public class MyDAOImp1 implements MyDAO{
	@Autowired 
	SessionFactory sf;
    @Autowired
    HttpSession h;
    
	@Override
	public boolean register(Userinfo dto) {
	System.out.println("inside dao");
	Session ss=sf.openSession();
	Criteria cr=ss.createCriteria(Userinfo.class);
	cr.add(Restrictions.eq("Email", dto.getEmail()));
	Userinfo udto=(Userinfo) cr.uniqueResult();
	System.out.println("udto"+udto);
    if(udto==null){                                                                           
	ss.save(dto);
	ss.beginTransaction().commit();
	ss.close();
	return true;
	}else{
		ss.close();
		return false;
	}
	}
	@Override
	public Userinfo login(Userinfo dto) {
	System.out.println("inside dao");
	Session ss=sf.openSession();
	Criteria cr=ss.createCriteria(Userinfo.class);
	cr.add(Restrictions.eq("Email", dto.getEmail()));
	cr.add(Restrictions.eq("Password", dto.getPassword()));
	Userinfo udto=(Userinfo) cr.uniqueResult();
	ss.close();
	return udto;
	}
     @Override
	public List<Mailinfo> inbox() {
		// TODO Auto-generated method stub
		System.out.println("inside dao");
		Session ss=sf.openSession();
		String email=(String) h.getAttribute("email");
		Criteria cr =ss.createCriteria(Userinfo.class);
		cr.add(Restrictions.eq("Email",email));
		Userinfo udto1= (Userinfo) cr.uniqueResult();
		int id=udto1.getId();
		Criteria cr1=ss.createCriteria(Mailinfo.class);
		cr1.add(Restrictions.eq("To_id",id));
		Criterion status=Restrictions.ne("Status","draft");
		Criterion status1=Restrictions.ne("Status","inboxdeleted");
		Criterion status2=Restrictions.eq("Status","sentdeleted");
		Criterion oneCondition=
				Restrictions.conjunction().add(status).add(status1);
		Criterion completeCondition=
				Restrictions.disjunction().add(oneCondition).add(status2);
		cr1.add(completeCondition);
		List<Mailinfo> mlist=cr1.list();
		ss.close();
		return mlist;
	}
 @Override
	public List<Mailinfo> sentitem() {
		System.out.println("inside dao");
		Session ss=sf.openSession();
		String email=(String) h.getAttribute("email");
		Criteria cr =ss.createCriteria(Userinfo.class);
		cr.add(Restrictions.eq("Email",email));
		Userinfo udto1= (Userinfo) cr.uniqueResult();
		int id=udto1.getId();
		Criteria cr1 =ss.createCriteria(Mailinfo.class);
		Criterion sentby=Restrictions.eq("sentby",email);
		Criterion status=Restrictions.eq("Status","sent");
		Criterion status2=Restrictions.ne("Status","sentdeleted");
		Criterion status1=Restrictions.eq("Status","inboxdeleted");
		Criterion oneCondition=
				Restrictions.conjunction().add(status).add(sentby).add(status2);//and
		Criterion completeCondition=
				Restrictions.disjunction().add(oneCondition).add(status1);//or
		cr1.add(completeCondition);
       List<Mailinfo> mlist=cr1.list();
		ss.close();
		return mlist;
	}
     @Override
	public List<Mailinfo> deleteitem() {
		// TODO Auto-generated method stub
		System.out.println("inside dao");
		Session ss=sf.openSession();
		String email=(String) h.getAttribute("email");
       Criteria cr1 =ss.createCriteria(Mailinfo.class);
		cr1.add(Restrictions.eq("sentto",email));
		Query q=ss.createQuery("from Mailinfo where (Status=? OR Status=? OR Status=?)and (sentby=?OR sentto=?)");
		q.setParameter(0,"sentdeleted");
		q.setParameter(1,"inboxdeleted");
		q.setParameter(2,"draftdeleted");
		q.setParameter(3,email);
		q.setParameter(4,email);
		List<Mailinfo> mlist=q.list();
		for(Mailinfo dto:mlist){
			System.out.println("Id="+dto.getId()+"Msg="+dto.getMessage()+"Sentby="+dto.getSentby()+"Sentto="+dto.getSentto());
		}
           ss.close();
		return mlist;
	}
     @Override
	public List<Mailinfo> draft() {
		// TODO Auto-generated method stub
		System.out.println("inside dao");
		Session ss=sf.openSession();
		String email=(String) h.getAttribute("email");
       int id=0;
		Criteria cr1 =ss.createCriteria(Mailinfo.class);
		cr1.add(Restrictions.eq("To_id",id));
		cr1.add(Restrictions.eq("sentby",email));
		cr1.add(Restrictions.ne("Status","draftdeleted"));
		List<Mailinfo> mlist=cr1.list();
		ss.close();
		return mlist;
	}
    @Override
	public boolean composeEmail(HttpServletRequest req) {
		// TODO Auto-generated method stub
		Session ss=sf.openSession();
		String to=req.getParameter("To");
		String subject=req.getParameter("Subject");
		String message= req.getParameter("Message");
		this.h = req.getSession(false);
		String from = (String) h.getAttribute("email");
		Mailinfo mdto= null;
		Mailinfo mdto1= null;
		Criteria cr=ss.createCriteria(Userinfo.class);
		cr.add(Restrictions.eq("Email",to));
		Userinfo udto= (Userinfo) cr.uniqueResult();
	if(udto!=null){
			int toid=udto.getId();
			mdto=new Mailinfo();
			mdto.setMessage(message);
			mdto.setSubject(subject);
			mdto.setSentto(from);
			mdto.setTo_id(toid);
		mdto.setStatus("sent");
		mdto.setSentto(to);
		mdto.setSentby(from);
			Criteria cr1 = ss.createCriteria(Userinfo.class);
			cr1.add(Restrictions.eq("Email",from));
			Userinfo udto1= (Userinfo) cr1.uniqueResult();
			List<Mailinfo> From_id = udto1.getFrom_id();
			From_id.add(mdto);
			ss.saveOrUpdate(udto1);
			ss.beginTransaction().commit();
			ss.close();
			return true;
			}else{
			mdto =new Mailinfo();
			mdto.setMessage(message);
			mdto.setSubject(subject);
			mdto.setTo_id(0);
			mdto.setSentto(from);
		mdto.setStatus("draft");
			mdto.setSentto(to);
			mdto.setSentby(from);
			Criteria cr1 =ss.createCriteria(Userinfo.class);
			cr1.add(Restrictions.eq("Email",from));
			Userinfo udto1=(Userinfo) cr1.uniqueResult();
			int toid1=udto1.getId();
			List<Mailinfo> From_id=udto1.getFrom_id();
			From_id.add(mdto);
			ss.saveOrUpdate(udto1);
			ss.beginTransaction().commit();
			mdto1 =new Mailinfo();
			mdto1.setMessage("Mail Delivery Failed");
			mdto1.setSubject("Mail Delivery Failed");
			mdto1.setStatus("Mail Delivery failed");
			mdto1.setSentby("google@gmail.com");
			mdto1.setTo_id(toid1);
            mdto1.setSentto(from);
			Criteria cr2 =ss.createCriteria(Userinfo.class);
			cr2.add(Restrictions.eq("Email","google@gmail.com"));
			Userinfo udto2=(Userinfo) cr2.uniqueResult();
			List<Mailinfo> Fromid=udto2.getFrom_id();
			Fromid.add(mdto1);
			ss.saveOrUpdate(udto2);
			ss.beginTransaction().commit();
			ss.close();
			return false;
		}	
	}
@Override
	public boolean delete(int id) {
		Session ss=sf.openSession();
		Criteria cr=ss.createCriteria(Mailinfo.class);
		cr.add(Restrictions.eq("Id", id));
		Mailinfo dto=(Mailinfo) cr.uniqueResult();
		boolean b=false;
		if(dto!=null) {
			Mailinfo mdto=(Mailinfo) cr.uniqueResult();
			String status = mdto.getStatus();
			System.out.println(status+"status");
			id =mdto.getId();
			if(status.equalsIgnoreCase("Deleted Mail")){
				Mailinfo rdto=ss.load(Mailinfo.class,id);
				System.out.println(rdto+"rdto");
				ss.delete(rdto);
				ss.beginTransaction().commit();
				b=true;
			}else{
			dto.setStatus("Deleted Mail");
			ss.saveOrUpdate(dto);
			ss.beginTransaction().commit();
			ss.close();
			b= true;
		}
		}else {
		b= false;
		}
		return b;
	}
@Override
	public boolean forgotpassword(HttpServletRequest req) {
		// TODO Auto-generated method stub
		Session ss=sf.openSession();
		String email=req.getParameter("email");
		String question=req.getParameter("Questions");
		String answer=req.getParameter("answer");
		Criteria cr1 =ss.createCriteria(Userinfo.class);
		cr1.add(Restrictions.eq("Email",email));
		cr1.add(Restrictions.eq("questions",question));
		cr1.add(Restrictions.eq("answer",answer));
		Userinfo dto=(Userinfo) cr1.uniqueResult();
		if(dto!=null){
			return true;
		}else{
			return false;
		}
	}

	@Override
	public boolean changePass(HttpServletRequest req) {
		Session ss=sf.openSession();
		String email=req.getParameter("email");
		boolean b=false;
		String confirmpass=req.getParameter("confirmpassword");
		String newpass=req.getParameter("newpassword");
		if(!confirmpass.equals(newpass)){
			 b=false;
		}else{
		Criteria cr=ss.createCriteria(Userinfo.class);
		cr.add(Restrictions.eq("Email", email));
		Userinfo udto=(Userinfo) cr.uniqueResult();
		if (udto!=null) {
			udto.setPassword(newpass);
			ss.saveOrUpdate(udto);
			ss.beginTransaction().commit();
			ss.close();
			b=true;
		} else {
			b= false;
		}
	  }
		return b;
	}
@Override
	public List<Mailinfo> mail(int id) {
		Session ss=sf.openSession();
		Criteria cr=ss.createCriteria(Mailinfo.class);
		cr.add(Restrictions.eq("Id", id));
		List<Mailinfo> mlist=cr.list();
		ss.close();
		return mlist;
}
@Override
	public boolean composeDraftemail(HttpServletRequest req) {
		Session ss=sf.openSession();
		String to=req.getParameter("To");
		String subject=req.getParameter("Subject");
		String message= req.getParameter("Message");
		String id=req.getParameter("Id");
		int id1=Integer.parseInt(id);
		this.h = req.getSession(false);
		String from = (String) h.getAttribute("email");
		Mailinfo mdto= null;
		Mailinfo mdto1= null;
		Criteria cr=ss.createCriteria(Userinfo.class);
		cr.add(Restrictions.eq("Email",to));
		Userinfo udto= (Userinfo) cr.uniqueResult();
	if(udto!=null){
			int toid=udto.getId();
			Mailinfo mdto11=ss.load(Mailinfo.class,id1);
			mdto11.setMessage(message);
			mdto11.setSubject(subject);
			mdto11.setSentby(from);
			mdto11.setTo_id(toid);
		mdto11.setStatus("sent");
		mdto11.setSentto(to);
			Criteria cr1 = ss.createCriteria(Userinfo.class);
			cr1.add(Restrictions.eq("Email",from));
			Userinfo udto1= (Userinfo) cr1.uniqueResult();
			List<Mailinfo> From_id = udto1.getFrom_id();
			From_id.add(mdto11);
			ss.saveOrUpdate(udto1);
			ss.beginTransaction().commit();
			ss.close();
			return true;
			}else{
			Mailinfo mdto2=ss.load(Mailinfo.class,id1);
			mdto2.setMessage(message);
			mdto2.setSubject(subject);
			mdto2.setTo_id(0);
			mdto2.setSentby(from);
		mdto2.setStatus("draft");
			mdto2.setSentto(to);
			Criteria cr1 =ss.createCriteria(Userinfo.class);
			cr1.add(Restrictions.eq("Email",from));
			Userinfo udto1=(Userinfo) cr1.uniqueResult();
			int toid1=udto1.getId();
			List<Mailinfo> From_id=udto1.getFrom_id();
			From_id.add(mdto2);
			ss.saveOrUpdate(udto1);
			ss.beginTransaction().commit();
			mdto1 =new Mailinfo();
			mdto1.setMessage("Mail Delivery Failed");
			mdto1.setSubject("Mail Delivery Failed");
			mdto1.setStatus("Mail Delivery failed");
			mdto1.setSentby("google@gmail.com");
			mdto1.setTo_id(toid1);
            mdto1.setSentto(from);
			Criteria cr2 =ss.createCriteria(Userinfo.class);
			cr2.add(Restrictions.eq("Email","google@gmail.com"));
			Userinfo udto2=(Userinfo) cr2.uniqueResult();
			List<Mailinfo> Fromid=udto2.getFrom_id();
			Fromid.add(mdto1);
			ss.saveOrUpdate(udto2);
			ss.beginTransaction().commit();
			ss.close();
			return false;
		}	
}
@Override
	public Mailinfo composeDraft(int id) {
		Session ss=sf.openSession();
		Criteria cr=ss.createCriteria(Mailinfo.class);
		cr.add(Restrictions.eq("Id", id));
		Mailinfo mlist=(Mailinfo) cr.uniqueResult();
		ss.close();
		return mlist;
	}
@Override
	public boolean sentdelete(int id) {
		// TODO Auto-generated method stub
		Session ss=sf.openSession();
		Criteria cr=ss.createCriteria(Mailinfo.class);
		cr.add(Restrictions.eq("Id", id));
		Mailinfo m=(Mailinfo) cr.uniqueResult();
		boolean b=false;
		if(m!=null){
			m.setStatus("sentdeleted");
			ss.saveOrUpdate(m);
			ss.beginTransaction().commit();
			ss.close();
			b=true;
		}
		return b;
	}
@Override
	public boolean inboxdelete(int id) {
		// TODO Auto-generated method stub
		Session ss=sf.openSession();
		Criteria cr=ss.createCriteria(Mailinfo.class);
		cr.add(Restrictions.eq("Id", id));
		Mailinfo m=(Mailinfo) cr.uniqueResult();
		boolean b=false;
		if(m!=null){
			m.setStatus("inboxdeleted");
			ss.saveOrUpdate(m);
			ss.beginTransaction().commit();
			ss.close();
			b=true;
		}
		return b;
	}

	@Override
	public boolean draftdelete(int id) {
		// TODO Auto-generated method stub
		Session ss=sf.openSession();
		Criteria cr=ss.createCriteria(Mailinfo.class);
		cr.add(Restrictions.eq("Id", id));
		Mailinfo m=(Mailinfo) cr.uniqueResult();
		boolean b=false;
		if(m!=null){
			m.setStatus("draftdeleted");
			ss.saveOrUpdate(m);
			ss.beginTransaction().commit();
			ss.close();
			b=true;
		}
		return b;
	}

}



