package service;

import java.util.ArrayList;

import javax.security.auth.login.LoginContext;
import javax.servlet.http.HttpServletRequest;

import converter.LoginConverter;
import db.DAOQuire;

import bean.AccessList;
import bean.RegBean;

public class LoginService {

	public ArrayList<AccessList> getUserAccessList()
	{
		DAOQuire db = new DAOQuire();
		return db.getAccessList();
	}
	public String checkCredintials(HttpServletRequest request) {
		// TODO Auto-generated method stub
		LoginConverter lc=new LoginConverter();
		RegBean bean=lc.getLoginData(request);
		DAOQuire db=new DAOQuire();
		String userName=db.checkLogin(bean);
		return userName;
		
	}
	public int changePwd(HttpServletRequest request,String emailid) {
		// TODO Auto-generated method stub
		LoginConverter lc=new LoginConverter();
		RegBean rb=lc.getChangepwd(request);
		DAOQuire db=new DAOQuire();
		return db.Changepwd(rb,emailid);
		
	}
	public ArrayList<String> getBlockList() {
		// TODO Auto-generated method stub
		DAOQuire db = new DAOQuire();
		return db.getBlockList();
	}
	public void unblock(HttpServletRequest request) {
		// TODO Auto-generated method stub
		DAOQuire db = new DAOQuire();
		String ip=(String)request.getParameter("ip");
		System.out.println(ip);
		 db.unblock((ip));
		
	}

}
