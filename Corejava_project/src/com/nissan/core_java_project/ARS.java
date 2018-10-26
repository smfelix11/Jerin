/**
 * 
 */
package com.nissan.core_java_project;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

/**
 * @author JP
 *
 */

class Admin{
	private String username="AirMarshal";
	private String password="Air123";
	Scanner sc = new Scanner(System.in);
	private int flightid;
	private String flightname;
	
	private String destination;
	private String source;
	java.util.Date date;
	
	void AddAFlight() {

	    
		Scanner scan=new Scanner(System.in);
		System.out.println(" ADD FLIGHT ");
		System.out.println("Enter Flight.id : ");
		int flightid=sc.nextInt();
		System.out.println("Enter Flight.name : ");
		String flightname=scan.next();
		System.out.println("Enter date :  ");
		
		String date1=sc.next();
		System.out.println("Enter Source : ");
		String source=sc.next();
		System.out.println("Enter destination : ");
		String destination=sc.next();
		System.out.println("Departure : ");
		String depart=sc.next();
		System.out.println("Arrival : ");
		String arrival=sc.next();
		System.out.println("Fare : ");
		int fare=sc.nextInt();
		
		
		try {
			date=new SimpleDateFormat("dd/MM/yyyy").parse(date1);
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		try{  
			Class.forName("com.mysql.cj.jdbc.Driver");  
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/airres?autoReconnect=true&useSSL=false","root","java12345");  
			Statement stmt=con.createStatement();
			PreparedStatement pstmt=con.prepareStatement("insert into flightdetails values(?,?,?,?,?,?,?,?)");
			pstmt.setInt(1, flightid);
			pstmt.setString(2, flightname);
			java.sql.Date sqldate=new java.sql.Date(date.getTime());
			pstmt.setDate(3, sqldate);
			pstmt.setString(4, source);
			pstmt.setString(5, destination);
			pstmt.setString(6, depart);
			pstmt.setString(7, arrival);
			pstmt.setInt(8,fare);
			int i=pstmt.executeUpdate();
		  
		}catch(Exception e){ System.out.println(e);}
		System.out.println("FLIGHT DETAILS ADDED");
	}

		
	
	
	void RemoveAFlight() {
		System.out.println("Enter flight id : ");
		Scanner sc=new Scanner(System.in);
		int flightid=sc.nextInt();
		try{  
			Class.forName("com.mysql.cj.jdbc.Driver");  
			Connection con=DriverManager.getConnection(  
			"jdbc:mysql://localhost:3306/airres?autoReconnect=true&useSSL=false","root","java12345");  
			Statement stmt=con.createStatement();
			String delete="DELETE FROM flightdetails WHERE fid="+flightid;
			stmt.executeUpdate(delete);
			System.out.println("Flight Deleted");
			
			
		  
		}catch(Exception e){ System.out.println(e);}
		
	}
		
		
	void changedate()
	{
		System.out.println("Enter Flight id : ");
		int flightid=sc.nextInt();
		System.out.println("Enter Date : ");
		String date1=sc.next();
		
		java.util.Date daten = null;
		try {
			 daten = new SimpleDateFormat("dd/MM/yyyy").parse(date1);
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		java.sql.Date sqldate=new java.sql.Date(daten.getTime());
		
		try{  
			Class.forName("com.mysql.cj.jdbc.Driver");  
			Connection con=DriverManager.getConnection(  
			"jdbc:mysql://localhost:3306/airres?autoReconnect=true&useSSL=false","root","java12345");  
			Statement stmt=con.createStatement();
			String update="UPDATE flightdetails SET date ='"+sqldate+"' WHERE fid ="+flightid;
			stmt.executeUpdate(update);
			System.out.println("Flight Details updated");
			
			
		  
		}catch(Exception e){ System.out.println(e);}
	}
	
	void changedestination()
	{
		System.out.println("Enter Flight id : ");
		int flightid=sc.nextInt();
		System.out.println("Enter destination : ");
		String destination=sc.next();
		
		
		try{  
			Class.forName("com.mysql.cj.jdbc.Driver");  
			Connection con=DriverManager.getConnection(  
			"jdbc:mysql://localhost:3306/AirRes?autoReconnect=true&useSSL=false","root","java12345");  
			Statement stmt=con.createStatement();
			String update="UPDATE flightdetails SET destination ='"+destination+"' WHERE fid ="+flightid;
			stmt.executeUpdate(update);
			System.out.println("Flight Details updated");
			
			
		  
		}catch(Exception e){ System.out.println(e);}
	}
	
	void changesource()
	{
		System.out.println("Enter Flight id : ");
		int flightid=sc.nextInt();
		System.out.println("Enter Source : ");
		String source=sc.next();
		
		
		
		try{  
			Class.forName("com.mysql.cj.jdbc.Driver");  
			Connection con=DriverManager.getConnection(  
			"jdbc:mysql://localhost:3306/airres?autoReconnect=true&useSSL=false","root","java12345");  
			Statement stmt=con.createStatement();
			String update="UPDATE flightdetails SET source ='"+source+"' WHERE fid ="+flightid;
			stmt.executeUpdate(update);
			System.out.println("Flight Details updated");
			
			
		  
		}catch(Exception e){ System.out.println(e);}
	}
	
	void changedeparture()
	{
		System.out.println("Enter Flight id : ");
		int flightid=sc.nextInt();
		System.out.println("Enter departure : ");
		String source=sc.next();
		
		
		
		try{  
			Class.forName("com.mysql.cj.jdbc.Driver");  
			Connection con=DriverManager.getConnection(  
			"jdbc:mysql://localhost:3306/airres?autoReconnect=true&useSSL=false","root","java12345");  
			Statement stmt=con.createStatement();
			String update="UPDATE flightdetails SET departure ='"+source+"' WHERE fid ="+flightid;
			stmt.executeUpdate(update);
			System.out.println("Flight Details updated");
			
			
		  
		}catch(Exception e){ System.out.println(e);}
	}
	
	void changearrival()
	{
		System.out.println("Enter Flight id : ");
		int flightid=sc.nextInt();
		System.out.println("Enter Arrival : ");
		String source=sc.next();
		
		
		
		try{  
			Class.forName("com.mysql.cj.jdbc.Driver");  
			Connection con=DriverManager.getConnection(  
			"jdbc:mysql://localhost:3306/airres?autoReconnect=true&useSSL=false","root","java12345");  
			Statement stmt=con.createStatement();
			String update="UPDATE flightdetails SET arrival ='"+source+"' WHERE fid ="+flightid;
			stmt.executeUpdate(update);
			System.out.println("Flight Details updated");
			
			
		  
		}catch(Exception e){ System.out.println(e);}


}
	
	void changefare()
	{
		System.out.println("Enter Flight id : ");
		int flightid=sc.nextInt();
		System.out.println("Enter fare : ");
		int source=sc.nextInt();
		
		
		
		try{  
			Class.forName("com.mysql.cj.jdbc.Driver");  
			Connection con=DriverManager.getConnection(  
			"jdbc:mysql://localhost:3306/airres?autoReconnect=true&useSSL=false","root","java12345");  
			Statement stmt=con.createStatement();
			String update="UPDATE flightdetails SET fare ='"+source+"' WHERE fid ="+flightid;
			stmt.executeUpdate(update);
			System.out.println("Flight Details updated");
			
			
		  
		}catch(Exception e){ System.out.println(e);}

}
	
	void EditDet() {
		int c=0;
		do {
			System.out.println("\t\tEDIT MENU\n");
			System.out.println("1.CHANGE DATE \t2.CHANGE SOURCE \n3.CHANGE DESTINATION \t4.CHANGE DEPARTURE \n5.CHANGE ARRIVAL \t6.CHANGE FARE \n\t7.LOGOUT");
			int i=sc.nextInt();
			switch(i) {
			case 1:
					changedate();
					break;
			case 2:
					changesource();
					break;
			case 3:
					changedestination();
					break;
			case 4:
					changedeparture();
					break;
			case 5:
					changearrival();
					break;
			case 6:
					changefare();
					break;
					
			case 7:
					ARS a = new ARS();
					String[] b = new String[1];
					a.main(b);
				
			
			}
			
		}while(c==1);
		
	}
	
	void DispDet() {
		System.out.println("Enter flight id : ");
		Scanner scan=new Scanner(System.in);
		int n=scan.nextInt();
		
		try{  
			Class.forName("com.mysql.cj.jdbc.Driver");  
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/airres?autoReconnect=true&useSSL=false","root","java12345");  
			Statement stmt=con.createStatement();  
			ResultSet rs=stmt.executeQuery("select * from reservation");  
			System.out.println("\t\tPASSENGER DETAILS\n");
			while(rs.next()) 
			{
					if((rs.getInt(4))==n)
					{
							
							
							
							System.out.println("Reservation id :"+rs.getInt(1)+" Name : "+rs.getString(3)+" Flight id :"+rs.getString(4)+" Flight name : "+rs.getString(5)+" Source : "+rs.getString(6)+" Destination : "+rs.getString(7)+" Date : "+rs.getDate(8)+" Departure time : "+rs.getString(9)+" Arrival time : "+rs.getString(10)+" Phone : "+rs.getString(11)+" Fare : "+rs.getInt(12)); 
							
					}	
							
				
				
			}
			
			
			con.close();  
			}catch(Exception e){ System.out.println(e);} 
		
		
	}
	void login() {
		System.out.println("Enter Username : ");
		String user=sc.next();
		System.out.println("Enter Password : ");
		String pass=sc.next();
		if(user.equals(username)&&pass.equals(password)) {
			System.out.println("You have successfully logged in. Please enter your choice to continue...\n\n");
			
			while(true)
			{
			System.out.println("1.ADD A FLIGHT \t\t2.REMOVE A FLIGHT \n3.EDIT FLIGHT DETAILS \t4.DISPLAY PASSENGER DETAILS \n5.BACK TO MAIN MENU");
			int opt=sc.nextInt();
			switch(opt) {
					case 1:
						AddAFlight();
						break;
					case 2:
						RemoveAFlight();
						break;
					case 3:
						EditDet();
						break;
					case 4:
						DispDet();
						break;
					case 5:
						ARS a =new ARS();
						String b[]=new String[1];
						a.main(b);
						break;
						
			
			}
		  }
		}
		
	  }
		
	}
	
	


class User{
	private String fname;
	private String lname;
	private String phone;
	private String address;
	private String mailid;
	private String username;
	private String password;
	private String password1;
	private int i;
	
	
	void Signup() {
		Scanner scan=new Scanner(System.in);
		System.out.println("Enter your details : ");
		System.out.println("Enter first name : ");
		fname=scan.next();
		System.out.println("Enter last name : ");
		lname=scan.next();
		System.out.println("Enter phone number : ");
		phone=scan.next();
		System.out.println("Enter address : ");
		address=scan.next();
		System.out.println("Enter date of birth : ");
		String date1=scan.next();
		java.util.Date date = null;
		try {
			date=new SimpleDateFormat("dd/MM/yyyy").parse(date1);
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		java.sql.Date dob=new java.sql.Date(date.getTime());
		System.out.println("Enter mail id : ");
		mailid=scan.next();
		System.out.println("Enter user name : ");
		username=scan.next();
		System.out.println("Enter password : ");
		password=scan.next();
		System.out.println("Confirm password : ");
		password1=scan.next();
		try{  
			Class.forName("com.mysql.cj.jdbc.Driver");  
			Connection con=DriverManager.getConnection(  
			"jdbc:mysql://localhost:3306/airres?autoReconnect=true&useSSL=false","root","java12345");  
			Statement stmt=con.createStatement();  
			ResultSet rs=stmt.executeQuery("select * from userdetails");  
			while(rs.next())  
			i=rs.getInt(1);
			
			con.close();  
			}catch(Exception e){ System.out.println(e);}  
		
		
		if(password.equals(password1))
		{
			System.out.println("Password match successfull");
		}
		else
		{
			System.out.println("Password doesn't match");
		}
		
		try{  
			Class.forName("com.mysql.cj.jdbc.Driver");  
			Connection con=DriverManager.getConnection(  
			"jdbc:mysql://localhost:3306/airres?autoReconnect=true&useSSL=false","root","java12345");  
			Statement stmt=con.createStatement();
			PreparedStatement pstmt=con.prepareStatement("insert into userdetails values(?,?,?,?,?,?,?,?,?)");
			i=i+1;
			pstmt.setInt(1, i);
			pstmt.setString(2, fname);
			pstmt.setString(3, lname);
			
			pstmt.setString(4, phone);
			pstmt.setString(5, address);
			pstmt.setDate(6, dob);
			pstmt.setString(7, mailid);
			pstmt.setString(8, username);
			pstmt.setString(9,password);
			int i=pstmt.executeUpdate();
		  
		}catch(Exception e){ System.out.println(e);}
		System.out.println("REGISTRATION SUCCESSFUL");
		System.out.println("PLEASE LOGIN TO YOUR ACCOUNT");
		SignIn();
		
		
		
		
		
		
	}
	
	void SignIn() {
		int res =0;
		
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter username : ");
		String username=sc.next();
		System.out.println("Enter password : ");
		String password=sc.next();
		
		try{  
			Class.forName("com.mysql.cj.jdbc.Driver");  
			Connection con=DriverManager.getConnection(  
			"jdbc:mysql://localhost:3306/airres?autoReconnect=true&useSSL=false","root","java12345");  
			Statement stmt=con.createStatement();  
			ResultSet rs=stmt.executeQuery("select * from userdetails");  
			while(rs.next())  
			if(username.equals(rs.getString(8))&&password.equals(rs.getString(9)))
			{
				System.out.println("Welcome to Airlines");
				res=1;
				while(true)
				{
					menu(rs.getInt(1));
				}
				
				
			}
			if(res==0)
			{
				System.out.println("Login failed...try again");
			}
			
			con.close();  
			}catch(Exception e){ System.out.println(e);}  
	}
	void menu(int id)
	{
		System.out.println("\n1.BOOK TICKET \t2.CANCEL TICKET \n3.RESCHEDULE \t4.BOOKING HISTORY \n5.PROFILE \t6.BACK");
		Scanner sc=new Scanner(System.in);
		
		
		
		
		int ch=sc.nextInt();
		switch(ch) {
		case 1:
			BookTicket(id);
			break;
		case 2:
			CancelTicket();
			break;
		case 3:
			Reschedule();
			break;
		case 4:
			BookingHistory(id);
			break;
		case 5:
			ViewProfile(id);
			break;
		case 6:
			ARS a = new ARS();
			String[] b = new String[1];
			a.main(b);
			break;
		default:
			System.out.println("Wrong choice...");
			break;
		}
		}
	
	void CancelTicket() {
		System.out.println("Enter Reservation id : ");
		Scanner sc=new Scanner(System.in);
		int sum = 0;
		int rid=sc.nextInt();
		try{  
			Class.forName("com.mysql.cj.jdbc.Driver");  
			Connection con=DriverManager.getConnection(  
			"jdbc:mysql://localhost:3306/airres?autoReconnect=true&useSSL=false","root","java12345");  
			Statement stmt=con.createStatement();
			ResultSet rs=stmt.executeQuery("select * from reservation");  
			while(rs.next())
			{
				 sum=(rs.getInt(12));
				
			}
			String delete="DELETE FROM reservation WHERE rid="+rid;
			stmt.executeUpdate(delete);
			System.out.println("Ticket Cancelled");
			System.out.println((sum*.7)+"\t will be refunded ");
			
			
		  
		}catch(Exception e){ System.out.println(e);}
	}
	
	void Reschedule() {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter Reservation id : ");
		int uid=sc.nextInt();
		String source=null;
		String destination=null;
		String departure=null;
		String arrival=null;
		int faren = 0;
		int flag=0;
		int fid=0;

		try{  
			Class.forName("com.mysql.cj.jdbc.Driver");  
			Connection con=DriverManager.getConnection(  
			"jdbc:mysql://localhost:3306/airres?autoReconnect=true&useSSL=false","root","java12345");  
			Statement stmt=con.createStatement();  
			ResultSet rs=stmt.executeQuery("select * from reservation");  
			System.out.println("\t\tRESERVATION DETAILS\n");
			while(rs.next()) 
			{
					if((rs.getInt(1))==uid)
					{
							
							
							source=rs.getString(6);
							destination=rs.getString(7);
							System.out.println("Reservation id : "+rs.getInt(1)+"\tUser id : "+rs.getInt(2)+"\tName : "+rs.getString(3)+"\tFlight id : "+rs.getInt(4)+"\tFlight name : "+rs.getString(5)+"\tSource : "+rs.getString(6)+"\tDestination : "+rs.getString(7)+"\tDate : "+rs.getDate(8)+"\tDeparture : "+rs.getString(9)+"\tArrival : "+rs.getString(10)+"\tPhone : "+rs.getString(11)+"\t fare : "+rs.getInt(12));
							
					}	
							
				
				
			}
			
			
			con.close();  
			}catch(Exception e){ System.out.println(e);}  
		System.out.println("");
		System.out.println("Enter Date of travelling : ");
		String date1=sc.next();
		
		java.util.Date daten = null;
		try {
			 daten = new SimpleDateFormat("dd/MM/yyyy").parse(date1);
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		java.sql.Date sqldate=new java.sql.Date(daten.getTime());
		
		try{  
			Class.forName("com.mysql.cj.jdbc.Driver");  
			Connection con=DriverManager.getConnection(  
			"jdbc:mysql://localhost:3306/airres?autoReconnect=true&useSSL=false","root","java12345");  
			Statement stmt=con.createStatement();  
			ResultSet rs=stmt.executeQuery("select * from flightdetails");  
			Scanner scan=new Scanner(System.in);
			while(rs.next()) 
			{
				if((rs.getDate(3)).compareTo(sqldate)==0)
				{
					
														
							System.out.println("..........Available flights..........");
							System.out.println("flightid : flightname : date : source : destination : departure : arrival : fare");
							System.out.println(rs.getInt(1)+" : "+rs.getString(2)+" : "+rs.getDate(3)+" : "+rs.getString(4)+" : "+rs.getString(5)+" : "+rs.getString(6)+" : "+rs.getString(7)+" : "+rs.getInt(8));
							
							System.out.println("Choose flight : \nEnter flight id : ");
							fid=scan.nextInt();
							flag=1;
							
							
						
				}
				
				
			}
			if(flag==0)
			{
				System.out.println("No flights available....");
			}
			
			
			con.close();  
			}catch(Exception e){ System.out.println(e);}  
		
		String flightname=null;
	    
		try{  
			Class.forName("com.mysql.cj.jdbc.Driver");  
			Connection con=DriverManager.getConnection(  
			"jdbc:mysql://localhost:3306/airres?autoReconnect=true&useSSL=false","root","java12345");  
			Statement stmt=con.createStatement();  
			ResultSet rs=stmt.executeQuery("select * from flightdetails");  
			Scanner scan=new Scanner(System.in);
			while(rs.next()) 
			{
				if((rs.getInt(1))==fid)
				
						{
						flightname=rs.getString(2);
													
							faren=rs.getInt(8);
							departure=rs.getString(6);
							arrival=rs.getString(7);
							
							
							
						}
				
				
			}
			
			
			con.close();  
			}catch(Exception e){ System.out.println(e);}  
		
		
		
		
		
		
		try{  
			
			Class.forName("com.mysql.cj.jdbc.Driver");  
			Connection con=DriverManager.getConnection(  
			"jdbc:mysql://localhost:3306/airres?autoReconnect=true&useSSL=false","root","java12345");  
			Statement stmt=con.createStatement();
			String update="UPDATE reservation SET fname  ='"+flightname+"', fid ="+fid+" ,date ='"+sqldate+"' ,departuretime ='"+departure+"' ,arrivaltime ='"+arrival+"' ,fare ="+faren+" WHERE rid ="+uid;
			stmt.executeUpdate(update);
			System.out.println("Flight Rescheduled...");
			
			
		  
		}catch(Exception e){ System.out.println(e);}
	
	}
	
	void BookingHistory(int id) {
		try{  
			Class.forName("com.mysql.cj.jdbc.Driver");  
			Connection con=DriverManager.getConnection(  
			"jdbc:mysql://localhost:3306/airres?autoReconnect=true&useSSL=false","root","java12345");  
			Statement stmt=con.createStatement();  
			ResultSet rs=stmt.executeQuery("select * from reservation");  
			System.out.println("\t\tBOOKING HISTORY\n");
			while(rs.next()) 
			{
					if((rs.getInt(2))==id)
					{
							
							
							
							System.out.println("Reservation id :"+rs.getInt(1)+" Name : "+rs.getString(3)+" Flight id :"+rs.getString(4)+" Flight name : "+rs.getString(5)+" Source : "+rs.getString(6)+" Destination : "+rs.getString(7)+" Date : "+rs.getDate(8)+" Departure time : "+rs.getString(9)+" Arrival time : "+rs.getString(10)+" Phone : "+rs.getString(11)+" Fare : "+rs.getInt(12)); 
							
					}	
							
				
				
			}
			
			
			con.close();  
			}catch(Exception e){ System.out.println(e);} 
	
		
	}
	void ViewProfile(int id) {
		try{  
			Class.forName("com.mysql.cj.jdbc.Driver");  
			Connection con=DriverManager.getConnection(  
			"jdbc:mysql://localhost:3306/airres?autoReconnect=true&useSSL=false","root","java12345");  
			Statement stmt=con.createStatement();  
			ResultSet rs=stmt.executeQuery("select * from userdetails");  
			System.out.println("\t\tPERSONAL DETAILS\n");
			while(rs.next()) 
			{
					if((rs.getInt(1))==id)
					{
							
							
							
							System.out.println("First name : "+rs.getString(2)+"\tLast name : "+rs.getString(3)+"\nPhone number : "+rs.getString(4)+"\tAddress : "+rs.getString(5)+"\ndob : "+rs.getString(6)+"\tmail id : "+rs.getString(7));
							
					}	
							
				
				
			}
			
			
			con.close();  
			}catch(Exception e){ System.out.println(e);}
		
	}
	void BookTicket(int id) {
		
		 String source;
		 String destination;
		 String date1;
		 int status=0;
		 
		 
		 Scanner scan=new Scanner(System.in);
			System.out.println("Enter Source : ");
			source =scan.next();
			System.out.println("Enter Destination : ");
			destination=scan.next();
			System.out.println("Enter Date : ");
			date1=scan.next();
			
			java.util.Date date = null;
			try {
				date=new SimpleDateFormat("dd/MM/yyyy").parse(date1);
			} catch (ParseException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			java.sql.Date dob=new java.sql.Date(date.getTime());
			
			
			
			try{  
				Class.forName("com.mysql.cj.jdbc.Driver");  
				Connection con=DriverManager.getConnection(  
				"jdbc:mysql://localhost:3306/airres?autoReconnect=true&useSSL=false","root","java12345");  
				Statement stmt=con.createStatement();  
				ResultSet rs=stmt.executeQuery("select * from flightdetails");  
				while(rs.next()) 
				{
					if((rs.getDate(3)).compareTo(dob)==0)
					{
						if((rs.getString(4)).equals(source))
						{
							if((rs.getString(5)).equals(destination))
							{
								status=1;
								System.out.println("\t\tAvailable flights\n");
								System.out.println("flightid : flightname : date : source : destination : departure : arrival : fare");
								System.out.println(rs.getInt(1)+" : "+rs.getString(2)+" : "+rs.getDate(3)+" : "+rs.getString(4)+" : "+rs.getString(5)+" : "+rs.getString(6)+" : "+rs.getString(7)+" : "+rs.getInt(8));
								
								System.out.println("Choose flight : \nEnter flight id : ");
								int fid=scan.nextInt();
								sendflightdetails(id,fid);
								
							}
						}
					}
					
					
				}
				if(status==0) {
					System.out.println("Flight from source to destination is not available on the selected date");
				}
				
				
				con.close();  
				}catch(Exception e){ System.out.println(e);}  
			
		}



		void sendflightdetails(int id,int fid)
		{
			try{  
				Class.forName("com.mysql.cj.jdbc.Driver");  
				Connection con=DriverManager.getConnection(  
				"jdbc:mysql://localhost:3306/airres?autoReconnect=true&useSSL=false","root","java12345");  
				Statement stmt=con.createStatement();  
				ResultSet rs=stmt.executeQuery("select * from flightdetails");  
				while(rs.next()) 
				{
					if((rs.getInt(1))==fid)
					{
						
								int flightid=fid;
								String fname=rs.getString(2);
								Date date=rs.getDate(3);
								String source=rs.getString(4);
								String destination=rs.getString(5);
								String departure=rs.getString(6);
								String arrival=rs.getString(7);
								int fare=rs.getInt(8);
								
								flightreserve(id, flightid, fname, source, destination, date, departure, arrival,fare);
								
							
					}
					
					
				}
				
				
				con.close();  
				}catch(Exception e){ System.out.println(e);}  
			
		}


		void flightreserve(int uid,int fid,String fname,String source,String destination,Date date,String depart,String arrive,int fare)
		{
			System.out.println("Enter number of passengers : ");
			
			Scanner in=new Scanner(System.in);
			int number=in.nextInt();
			int booked=0;
			int i=0;
			int rid = 0;
			while(i<number)
			{
				String name;i++;
				String num;
				System.out.println("Enter passenger details : ");
				System.out.println("Enter name : ");
				
				name=in.next();
				System.out.println("Enter phone number : ");
				num=in.next();
				try{  
					Class.forName("com.mysql.cj.jdbc.Driver");  
					Connection con=DriverManager.getConnection(  
					"jdbc:mysql://localhost:3306/airres?autoReconnect=true&useSSL=false","root","java12345");  
					Statement stmt=con.createStatement();  
					ResultSet rs=stmt.executeQuery("select * from reservation");  
					while(rs.next())  
					rid=rs.getInt(1);
					
					con.close();  
					}catch(Exception e){ System.out.println(e);}  
				
				try{  
					Class.forName("com.mysql.cj.jdbc.Driver");  
					Connection con=DriverManager.getConnection(  
					"jdbc:mysql://localhost:3306/airres?autoReconnect=true&useSSL=false","root","java12345");  
					Statement stmt=con.createStatement();
					PreparedStatement pstmt=con.prepareStatement("insert into reservation values(?,?,?,?,?,?,?,?,?,?,?,?)");
					rid=rid+1;
					pstmt.setInt(1, rid);
					pstmt.setInt(2, uid);
					pstmt.setString(3, name);
					
					pstmt.setInt(4, fid);
					pstmt.setString(5, fname);
					pstmt.setString(6,source );
					pstmt.setString(7, destination);
					pstmt.setDate(8, (java.sql.Date) date);
					pstmt.setString(9,depart);
					pstmt.setString(10, arrive);
					pstmt.setString(11, num);
					pstmt.setInt(12, fare);
					int k=pstmt.executeUpdate();
				  
				}catch(Exception e){ System.out.println(e);}
				
				booked=booked+1;
			}
			System.out.println("Proceed to payment : \n1.Yes \n2.NO");
			int opt=in.nextInt();
			if(opt==1)
			{
				if(number==booked)
				{
					int Total=booked*fare;
					System.out.println("Total amount : "+Total);
					
					payment(Total,uid);
				}
			}
			else
			{
				System.out.println("Booking aborted...");
				
				menu(uid);
			}
			
		}


		
		void payment(int amount,int uid) {
			
			System.out.println("Choose payment option : \n1.Card \n2.Cash");
			Scanner opt=new Scanner(System.in);
			int option=opt.nextInt();
			if(option==1)
			{
				System.out.println("\nEnter cardnumber : ");
				int card=opt.nextInt();
				System.out.println("\nEnter pin : ");
				int pin=opt.nextInt();
				System.out.println("Amount "+amount+" received");
				System.out.println("Booking done");
				
				generate(uid);
			}
			else
			{
				System.out.println("Amount "+amount+" received");
				System.out.println("Booking done");
				generate(uid);
			}
		}
		void generate(int uid)
		{
			
			try{  
				Class.forName("com.mysql.cj.jdbc.Driver");  
				Connection con=DriverManager.getConnection(  
				"jdbc:mysql://localhost:3306/airres?autoReconnect=true&useSSL=false","root","java12345");  
				Statement stmt=con.createStatement();  
				ResultSet rs=stmt.executeQuery("select * from reservation");  
				System.out.println("\t\tTICKET DETAILS\n");
				while(rs.next()) 
				{
						if((rs.getInt(2))==uid)
						{
								
								
								
								System.out.println("Reservation id : "+rs.getInt(1)+"\tUser id : "+rs.getInt(2)+"\tName : "+rs.getString(3)+"\tFlight id : "+rs.getInt(4)+"\tFlight name : "+rs.getString(5)+"\tSource : "+rs.getString(6)+"\tDestination : "+rs.getString(7)+"\tDate : "+rs.getDate(8)+"\tDeparture : "+rs.getString(9)+"\tArrival : "+rs.getString(10)+"\tPhone : "+rs.getString(11));
								
						}	
								
					
					
				}
				
				
				con.close();  
				}catch(Exception e){ System.out.println(e);}  
		}
			
		
}



public class ARS {
	
	


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int ch,c;
		while(true) {
		System.out.println("\t\tAIR TICKET RESERVATION SYSTEM\n\n1.Administrator\n2.User\n3.Exit\nPlease Enter your choice:");
		ch = sc.nextInt();
		switch(ch) {
		
		case 1:
			Admin a = new Admin();
			a.login();
			break;
		case 2:
			User u = new User();
			System.out.println("\t\tUSER PORTAL\n1.Sign in\n2.Don't have an account? Sign up.\nEnter choice");
			c=sc.nextInt();
			switch(c) {
			case 1:
					u.SignIn();
					break;
			case 2:
					u.Signup();
					break;
			}
		case 3:
				System.exit(0);
				break;
		}
	  }
	}

}
