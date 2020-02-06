package com.ust.mailsimulator.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ust.mailsimulator.dao.MyDAO;
import com.ust.mailsimulator.model.Mailinfo;
import com.ust.mailsimulator.model.Userinfo;

@Component
public class MyServiceimp1 implements MyService {
	@Autowired
	MyDAO mdao;

	@Override
	public boolean register(Userinfo dto) {
		// TODO Auto-generated method stub
		System.out.println("inside service");
		boolean b =mdao.register(dto);
		return b;
	}

	@Override
	public Userinfo login(Userinfo dto) {
		// TODO Auto-generated method stub
		System.out.println("inside service");
		Userinfo udto=mdao.login(dto);
		return udto;
	}

	@Override
	public List<Mailinfo> inbox() {
		// TODO Auto-generated method stub
		List<Mailinfo> From_id=mdao.inbox();
		return From_id;
	}

	@Override
	public List<Mailinfo> sentitem() {
		// TODO Auto-generated method stub
		List<Mailinfo> From_id=mdao.sentitem();
		return From_id;
	}

	@Override
	public List<Mailinfo> deleteitem() {
		// TODO Auto-generated method stub
		List<Mailinfo> From_id=mdao.deleteitem();
		return From_id;
	}

	@Override
	public List<Mailinfo> draft() {
		// TODO Auto-generated method stub
		List<Mailinfo> From_id=mdao.draft();
		return From_id;
	}

	@Override
	public boolean composeEmail(HttpServletRequest req) {
		// TODO Auto-generated method stub
		return mdao.composeEmail(req);
	}

	@Override
	public boolean delete(int id) {
		// TODO Auto-generated method stub
		boolean b=mdao.delete(id);
		return b;
	}

	@Override
	public boolean forgotpasswword(HttpServletRequest req) {
		// TODO Auto-generated method stub
		System.out.println("inside service");
		return mdao.forgotpassword(req);
	}

	@Override
	public boolean changePass(HttpServletRequest req) {
		// TODO Auto-generated method stub
		boolean b= mdao.changePass(req);
		return b;
	}

	@Override
	public List<Mailinfo> mail(int id) {
		// TODO Auto-generated method stub
		List<Mailinfo> From_id=mdao.mail(id);
		return From_id;
	}

	@Override
	public Mailinfo composeDraft(int id) {
		// TODO Auto-generated method stub
		Mailinfo From_id=mdao.composeDraft(id);
		
		return From_id;
	}

	@Override
	public boolean composeDraftemail(HttpServletRequest req) {
		// TODO Auto-generated method stub
		return mdao.composeDraftemail(req);
	}

	@Override
	public boolean sentdelete(int id) {
		// TODO Auto-generated method stub
		boolean b=mdao.sentdelete(id);
		return b;
	}

	@Override
	public boolean inboxdelete(int id) {
		// TODO Auto-generated method stub
		boolean b=mdao.inboxdelete(id);
		return b;
	}

	@Override
	public boolean draftdelete(int id) {
		// TODO Auto-generated method stub
		boolean b=mdao.draftdelete(id);
		return b;
	}
}
