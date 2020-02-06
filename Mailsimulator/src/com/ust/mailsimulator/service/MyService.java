package com.ust.mailsimulator.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.ust.mailsimulator.model.Mailinfo;
import com.ust.mailsimulator.model.Userinfo;

public interface MyService {
	 public boolean register(Userinfo dto);
	 public Userinfo login(Userinfo dto);
     public List<Mailinfo> inbox();
     public List<Mailinfo> sentitem();
     public List<Mailinfo> deleteitem();
     public List<Mailinfo> draft();
     public boolean composeEmail(HttpServletRequest req);
     public boolean delete(int id);
     public boolean forgotpasswword(HttpServletRequest req);
     public boolean changePass(HttpServletRequest req);
     public List<Mailinfo> mail(int id);
     public Mailinfo composeDraft(int id);
     public boolean composeDraftemail(HttpServletRequest req);
     public boolean sentdelete(int id);
     public boolean inboxdelete(int id);
     public boolean draftdelete(int id);
}



