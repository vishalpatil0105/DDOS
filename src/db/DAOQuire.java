package db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import service.GeneratePassword;
import util.DateTime;
import bean.AccessList;
import bean.RegBean;

public class DAOQuire {

	public boolean insertReg(RegBean bean) {
		// TODO Auto-generated method stub
		DAO dao=new DAO();
		int rows=0;
		System.out.println("In DB"+bean.getFname());
		Connection conn = dao.getConnection();
		String password=GeneratePassword.randomPasswordIs();
		String insertquery="insert into registration values(?,?,?,?,?,?)";
		bean.setPassword(password);
		PreparedStatement pstmt=null;
		try {
			pstmt=conn.prepareStatement(insertquery);;
			
			pstmt.setString(1, bean.getFname());
			pstmt.setString(2, bean.getLname());
			pstmt.setString(3, bean.getAddress());
			pstmt.setString(4, bean.getEmailid());
			pstmt.setString(5, bean.getGender());
			pstmt.setString(6, password);
			

			rows=pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e);
		}
		if(rows==0)
			return false;
		return true;
		
	}

	public String checkLogin(RegBean bean) {
		// TODO Auto-generated method stub
		DAO data=new DAO();
		Connection conn=data.getConnection();
		String validateUser = "select * from  registration where emailid=? and password = ?";
		PreparedStatement preparedStatement;
		try {
			preparedStatement = conn.prepareStatement(validateUser);
			preparedStatement.setString(1, bean.getEmailid());
			preparedStatement.setString(2, bean.getPassword());
			
			// execute insert SQL statement
			ResultSet result=preparedStatement.executeQuery();
			if(result.next())
			{
				return result.getString(1);
			}
			

		}
		
		
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
		// TODO Auto-generated method stub

		return null;
	}
	public int Changepwd(RegBean rb, String emailid) {
		// TODO Auto-generated method stub
		DAO data=new DAO();
		Connection conn=data.getConnection();
		String validateUser = "select password from  registration where emailid=? ";
		PreparedStatement preparedStatement;
		try {
			preparedStatement = conn.prepareStatement(validateUser);
			preparedStatement.setString(1, emailid);
			
			System.out.println("Email id"+emailid+rb.getPassword());
			// execute insert SQL statement
			ResultSet result=preparedStatement.executeQuery();
			
			if(result.next())
			{
				System.out.println(result.getString(1));
				if(result.getString(1).equals(rb.getPassword()))
				{
					validateUser="update registration set password=? where emailid=?";
					preparedStatement=conn.prepareStatement(validateUser);
					preparedStatement.setString(1,rb.getChangepwd());
					preparedStatement.setString(2, emailid);
					return preparedStatement.executeUpdate();
				}
				else
				{
					return 0;
				}
			}
			

		}
		
		
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		

		// TODO Auto-generated method stub
		return 0;
		
	}

	public boolean insertNetworkdetails(String ipAddress) {
		// TODO Auto-generated method stub
		DAO dao=new DAO();
		int rows=0;
		Connection conn = dao.getConnection();
		//Check if IP is already blocked

String		 insertquery="insert into accessdetails values(?,?,?)";
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date = new Date();
		System.out.println(dateFormat.format(date));
		PreparedStatement pstmt=null;
		try {
			pstmt=conn.prepareStatement(insertquery);;
			
			pstmt.setString(1,ipAddress);
			pstmt.setString(2,dateFormat.format(date));
			pstmt.setString(3,"t");
			rows=pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e);
		}
		/*ArrayList<String> time=new ArrayList<String>();
		 insertquery="select * from accessdetails where ipaddress=?";
		try {
			preparedStatement = conn.prepareStatement(insertquery);
			preparedStatement.setString(1, ipAddress);
			
			// execute insert SQL statement
			ResultSet result=preparedStatement.executeQuery();
			while(result.next())
			{
				time.add(result.getString(2));
			}
			

		}
		
		
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		*/
		
		
		return true;
		
		
		
	}

	public ArrayList<AccessList> getAccessList() {
		// TODO Auto-generated method stub
		DAO dao=new DAO();
		int rows=0;
		System.out.println("In accessList");
		Connection conn = dao.getConnection();
		ArrayList<AccessList> accesslist= new ArrayList<AccessList>();
		//Check if IP is already blocked
		String insertquery="select * from accessdetails";
		PreparedStatement preparedStatement;
		try {
			preparedStatement = conn.prepareStatement(insertquery);
			
			
			// execute insert SQL statement
			ResultSet result=preparedStatement.executeQuery();
			while(result.next())
			{
				AccessList bean = new AccessList();
				bean.setIpaddress(result.getString(1));
				bean.setTime(result.getString(2));
				accesslist.add(bean);
			}
			

		}
		
		
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return accesslist;
	}

	public boolean checkIsAttacker(String ipAddress) {
		// TODO Auto-generated method stub
		DAO dao=new DAO();
		int rows=0;
		String secondaccess=null,lastaccess=null;
SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date = new Date();
		String currentaccess=dateFormat.format(date);
		System.out.println("Check Attacker");
		Connection conn = dao.getConnection();
		ArrayList<AccessList> accesslist= new ArrayList<AccessList>();
		//Check if IP is already blocked
		String maxquery="SELECT mAX(TIME) FROM `dos`.`accessdetails` WHERE IPADDRESS=? AND time <>( SELECT mAX(TIME) FROM `dos`.`accessdetails` WHERE IPADDRESS=?);";
		PreparedStatement preparedStatement;
		try {
			preparedStatement = conn.prepareStatement(maxquery);
			preparedStatement.setString(1, ipAddress);
			preparedStatement.setString(2, ipAddress);
			// execute insert SQL statement
			ResultSet result=preparedStatement.executeQuery();
			if(result.next())
			{
				secondaccess=result.getString(1);
			}
			

		}
		
		
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String max="SELECT mAX(TIME) FROM `dos`.`accessdetails` WHERE IPADDRESS=?";
		try {
			preparedStatement = conn.prepareStatement(max);
			preparedStatement.setString(1, ipAddress);
			
			// execute insert SQL statement
			ResultSet result=preparedStatement.executeQuery();
			if(result.next())
			{
				lastaccess=result.getString(1);
			}
			
		}
		
		
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//Compare last three access
		DateTime dt= new DateTime();
		System.out.println(secondaccess);
		System.out.println(lastaccess);
		System.out.println(currentaccess);
		System.out.println(dt.getDifference(secondaccess, lastaccess));
		System.out.println(dt.getDifference(lastaccess, currentaccess));
		if(dt.getDifference(secondaccess, lastaccess)<60)
		{
			if(dt.getDifference(lastaccess, currentaccess)<60){
				String		 insertquery="insert into ipblocked values(?)";
				PreparedStatement pstmt=null;
				try {
					pstmt=conn.prepareStatement(insertquery);;
					
					pstmt.setString(1,ipAddress);
					
					rows=pstmt.executeUpdate();
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					System.out.println(e);
				}
			}
		}
		
		return false;
	}

	public boolean checkIfBlocked(String ipAddress) {
		// TODO Auto-generated method stub
		DAO data=new DAO();
		Connection conn=data.getConnection();
		String validateUser = "select * from  ipblocked where ipaddress=? ";
		PreparedStatement preparedStatement;
		try {
			preparedStatement = conn.prepareStatement(validateUser);
			preparedStatement.setString(1, ipAddress);
			
			// execute insert SQL statement
			ResultSet result=preparedStatement.executeQuery();
			if(result.next())
			{
				return true;
			}
			

		}
		
		
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
		// TODO Auto-generated method stub

		return false;
	}

	public ArrayList<String> getBlockList() {
		// TODO Auto-generated method stub
		DAO dao=new DAO();
		int rows=0;
		System.out.println("In Blocked list");
		Connection conn = dao.getConnection();
		ArrayList<String> accesslist= new ArrayList<String>();
		//Check if IP is already blocked
		String insertquery="select * from ipblocked";
		PreparedStatement preparedStatement;
		try {
			preparedStatement = conn.prepareStatement(insertquery);
			
			
			// execute insert SQL statement
			ResultSet result=preparedStatement.executeQuery();
			while(result.next())
			{
				
				accesslist.add(result.getString(1));
			}
			

		}
		
		
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return accesslist;
	}

	public void unblock(String ipaddress) {
		// TODO Auto-generated method stub
		DAO dao=new DAO();
		int rows=0;
		Connection conn = dao.getConnection();
System.out.println("Unblock"+ipaddress);
String		 insertquery="delete from ipblocked where ipaddress=?";
		PreparedStatement pstmt=null;
		try {
			pstmt=conn.prepareStatement(insertquery);;
			
			pstmt.setString(1,ipaddress);
			rows=pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e);
		}
	}
	

}
