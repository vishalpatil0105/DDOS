package controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.AccessList;
import bean.FileBean;

import service.LoginService;
import service.RegService;

/**
 * Servlet implementation class Servlet
 */
public class Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public Servlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
doPost(request, response);	
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String action=request.getParameter("action");
		HttpSession session =null;
		String nextPath="";
		if("registration".equalsIgnoreCase(action))
		{
		RegService rs= new RegService();
		boolean isSuccess=rs.insertData(request);
		

		if(isSuccess==false)
		request.setAttribute("message", " This might happen because of the below errors <br><br>1.Duplicate Email-Id<br> <br>2.Unable to connect Database<br><br>3.Unable to connect Internet"); 
		else
		{
		request.setAttribute("message", "Account created successfully<br> Please visit your "+request.getParameter("EMAILID")+" for the credential");
		}
		nextPath="/JSP/RegistrationResult.jsp";
		}
		else if("login".equalsIgnoreCase(action))
		{
			LoginService ls=new LoginService();
			String adminname=request.getParameter("EMAILID");
			String password=request.getParameter("PASSWORD");
			if("a".equals(adminname) && "abc".equals(password))
			{
				session = request.getSession(true);
				 session.setAttribute("username", "Admin");
				 session.setAttribute("emailid", "Admin");;
				nextPath="/JSP/Admin.jsp";
				ArrayList<AccessList> userlist=ls.getUserAccessList();
				request.setAttribute("userlist", userlist);
				
			}
			else{
			
			String username=ls.checkCredintials(request);
			request.setAttribute("username", username);
			System.out.println(username);
			if(username==null){
				request.setAttribute("username", "invalid");			
				nextPath="/JSP/Login.jsp";
			}
			else{
				 session = request.getSession(true);
				 session.setAttribute("username", username);
					session.setAttribute("emailid", request.getParameter("EMAILID"));;
				File folder = new File("E://Java//Swing");
				File[] listOfFiles = folder.listFiles();
				ArrayList<FileBean> filelist=new ArrayList<FileBean>();
				    for (int i = 0; i < listOfFiles.length; i++) {
				      if (listOfFiles[i].isFile()) {
				    	  FileBean bean= new FileBean();
				    	  System.out.println(listOfFiles[i].getName());
				    	  bean.setFilename(listOfFiles[i].getName());
				    	  bean.setFilesize(listOfFiles[i].length()/(1024L * 1024L)+1);
				    	  filelist.add(bean);
				        
				      } 
				    }
			
request.setAttribute("filelist", filelist);				
				nextPath="/JSP/Portal.jsp";
			}
			}
		}
			else if("download".equals(action)){
				File folder = new File("E://Java//Swing");
				File[] listOfFiles = folder.listFiles();
				ArrayList<FileBean> filelist=new ArrayList<FileBean>();
				    for (int i = 0; i < listOfFiles.length; i++) {
				      if (listOfFiles[i].isFile()) {
				    	  FileBean bean= new FileBean();
				    	  System.out.println(listOfFiles[i].getName());
				    	  bean.setFilename(listOfFiles[i].getName());
				    	  bean.setFilesize(listOfFiles[i].length()/(1024L * 1024L)+1);
				    	  filelist.add(bean);
				      }
				    	  request.setAttribute("filelist", filelist);				
							nextPath="/JSP/Portal.jsp";
			
			}
		}else if("blockip".equals(action)){
			LoginService ls=new LoginService();
			nextPath="/JSP/Block.jsp";
			ArrayList<String> userlist=ls.getBlockList();
			System.out.println(userlist.size());
			request.setAttribute("userlist", userlist);
		}
		else if("block".equals(action)){
			LoginService ls=new LoginService();
			nextPath="/JSP/Block.jsp";
			ls.unblock(request);
			ArrayList<String> userlist=ls.getBlockList();
			System.out.println(userlist.size());
			request.setAttribute("userlist", userlist);
		}
		else if("showfiles".equals(action)){
			LoginService ls=new LoginService();
			nextPath="/JSP/Admin.jsp";
			ArrayList<AccessList> userlist=ls.getUserAccessList();
			System.out.println(userlist.size());
			request.setAttribute("userlist", userlist);
		}
		else if("ChangePWD".equals(action)){
			System.out.println("In Change Password");
			 session = request.getSession(true);
			LoginService ls = new LoginService();
			int noofrowsaffected=ls.changePwd(request,(String)session.getAttribute("emailid"));
			System.out.println(session.getAttribute("emailid"));
			if(noofrowsaffected>0){
				request.setAttribute("message", "Password Change Successfully");
			}
			else{
				request.setAttribute("message", "Current Password does not match");
			}

			nextPath="/JSP/Changepassword.jsp";
			
		}
		RequestDispatcher rd=getServletContext().getRequestDispatcher(nextPath);
		rd.forward(request, response);
	}

}
