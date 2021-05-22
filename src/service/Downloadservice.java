package service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import db.DAOQuire;

public class Downloadservice {

	

	public boolean insertNetworkaddress(HttpServletRequest request) {
		// TODO Auto-generated method stub
		String ipAddress =  request.getRemoteHost();
		System.out.println("IP Address: "+ipAddress);
		DAOQuire db = new DAOQuire();
		boolean checkifblocked=db.checkIfBlocked(ipAddress);
		if(checkifblocked==true){
			System.out.println("\n True");
		
			return true;
		}
		boolean isattacker=db.checkIsAttacker(ipAddress);
		if(isattacker==true){
			System.out.println("\n Attacker");
			return true;
		}
		db.insertNetworkdetails(ipAddress);
		return false;
		
	}
	

}
