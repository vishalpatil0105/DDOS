package converter;

import javax.servlet.http.HttpServletRequest;

import bean.RegBean;

public class RegConverter {

	public RegBean getBean(HttpServletRequest request) {
		// TODO Auto-generated method stub
		
		RegBean rb=new RegBean();
		rb.setFname(request.getParameter("FNAME"));
		rb.setLname(request.getParameter("LNAME"));
		rb.setAddress(request.getParameter("ADDRESS"));
		rb.setEmailid(request.getParameter("EMAILID"));
		if(request.getParameter("GENDER").equals("m"))
			rb.setGender("m");
		else
			rb.setGender("f");
		
		
		return rb;
		
		
		
		
	}

}
