package service;

import javax.servlet.http.HttpServletRequest;

import util.EMail;
import bean.RegBean;
import converter.RegConverter;
import db.DAOQuire;

public class RegService {

	public boolean insertData(HttpServletRequest request) {
		// TODO Auto-generated method stub
		RegConverter rc=new RegConverter();
		RegBean bean=rc.getBean(request);
		DAOQuire db=new DAOQuire();
		System.out.println(bean.getFname());
		boolean isSuccess=db.insertReg(bean);
		if(isSuccess==true){
			EMail mail =new EMail();
			isSuccess=mail.sendMail(bean);
		}
		return isSuccess;
		
	}

}
