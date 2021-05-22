package controller;

import java.io.*;  

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;  
import javax.servlet.http.*;  

import service.Downloadservice;
  
public class FileDownloader extends HttpServlet {  
  
public void doGet(HttpServletRequest request, HttpServletResponse response)  
            throws ServletException, IOException {  
  HttpSession session= request.getSession(true);
  String nextPath;
  
	Downloadservice ds = new Downloadservice();
	
	if(ds.insertNetworkaddress(request)==true){
		System.out.println("\n True");
		System.out.println("blocked");
		nextPath="/JSP/IPBlock.jsp";
		RequestDispatcher rd= request.getRequestDispatcher(nextPath);
		rd.forward(request, response);
				
	}
	else{
	
response.setContentType("text/html");  
PrintWriter out = response.getWriter();  
System.out.println(":In get");
String filename = (String)request.getParameter("filename");
System.out.println("in"+filename);
String filepath = "E://Java//Swing//";  
response.setContentType("APPLICATION/OCTET-STREAM");   
response.setHeader("Content-Disposition","attachment; filename=\"" + filename + "\"");   
  
FileInputStream fileInputStream = new FileInputStream(filepath + filename);  
            
int i;   
while ((i=fileInputStream.read()) != -1) {  
out.write(i);   
}   
fileInputStream.close();   
out.close();   
}  
}

}
