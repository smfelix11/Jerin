package com.nissan.project;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class Emp {
	Scanner sc = new Scanner(System.in);
	Statement stmt;
	Connection con;
	Emp(){
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			 con=DriverManager.getConnection("jdbc:mysql://localhost:3306/Emp","root","java12345");
		}
		catch(Exception e)
		{
			System.out.println("Exception: "+e);
		}
		
	}

	public void Signup()
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter your Name:");
		String ename=sc.next();
		System.out.println("Enter employee ID");
		String eid = sc.next();
		System.out.println("Enter your email ID:");
		String em=sc.next();
		System.out.println("Enter your password:");
		String epass=sc.next();
		System.out.println("Enter your department name:");
		String dname=sc.next();
			try
			{
			stmt=con.createStatement();
			PreparedStatement stmt=con.prepareStatement("insert into empdat values(?,?,?,?,?);");
			stmt.setString(1,ename);
			stmt.setString(2,eid);
			stmt.setString(3,em);
			stmt.setString(4,epass);
			stmt.setString(5,dname);
			stmt.executeUpdate();
			}
			catch(Exception e)
			{
				System.out.println("Exception: "+e);
			}
		
	}
	
	void Signin() 
	{
		String Edept="",Ename="",Pass="",Eid="";
	System.out.println("Enter Employee ID:");
	String eid=sc.next();
	System.out.println("Enter Password:");
	String epass=sc.next();
	try
	{
	stmt=con.createStatement();
	ResultSet rs=stmt.executeQuery("select * from empdat where eid='"+eid+"';");
	while(rs.next())
	{
		Ename=rs.getString(1);
		Pass=rs.getString(3);
		Edept=rs.getString(4);
		Eid = rs.getString(2);
	}
	}
	catch(Exception e)
	{
		System.out.println("Exception: "+e);
	}
	if(Pass.equalsIgnoreCase(epass))
	{
		System.out.println("\nREVIEW PORTAL\n1.Write Review\n2.Edit Review\n3.Back to main\nEnter choice:");
		int ch = sc.nextInt();
		switch(ch) 
		{
			case 1: WriteCom(Ename,Eid,Edept);
					break;
			case 2: EditCom();
					break;
			case 3:
					break;
		}
	}
	else {
		System.out.println("Wrong Employee ID or Email ID");
	}
	}
	
	void WriteCom(String name,String Eid,String Dept) {
		
		int num=0;
		String reg="";
		int flag=0;
		System.out.println("**********************************************************************************************************************");
		try {
			stmt=con.createStatement();
			ResultSet rs=stmt.executeQuery("select num,regulation,response from Adminreg where status='valid' AND dept='"+Dept+"' AND empsend='yes' AND adminrec='No';");
			System.out.println("N0: REGULATION");
			while(rs.next())
			{
				flag=rs.getInt(3);
		System.out.println(rs.getInt(1)+" "+rs.getString(2));
			}
		}
			catch(Exception e)
			{
				System.out.println("Exception: "+e);
			}
		System.out.println("**********************************************************************************************************************");	
		System.out.println("Enter the regulation number which you want to write the review");
		int rno=sc.nextInt();
		int i=0;
		try {
			stmt=con.createStatement();
			ResultSet rs=stmt.executeQuery("select num,regulation,response from Adminreg where status='valid' AND dept='"+Dept+"' AND empsend='yes' AND adminrec='No' AND num="+rno+";");
			while(rs.next())
			{
				
				i++;
				num=rs.getInt(1);
				reg=rs.getString(2);
				flag=rs.getInt(3);
			}
		}
			catch(Exception e)
			{
				System.out.println("Exception: "+e);
			}
		if(i==0)
			System.out.println("You have entered the wrong regulation number");
		else
		{
			System.out.println("Write your review about the regulation:");
			String review=sc.next();
			flag++;
				try
				{
				stmt=con.createStatement();
				PreparedStatement stmt=con.prepareStatement("insert into comments values(?,?,?,?,?,?);");
				stmt.setInt(1,rno);
				stmt.setString(2,reg);
				stmt.setString(3,name);
				stmt.setString(4,Eid);
				stmt.setString(5,Dept);
				stmt.setString(6,review);
				stmt.executeUpdate();
				}
				catch(Exception e)
				{
					System.out.println("Exception: "+e);
				}
				try
				{
					stmt=con.createStatement();
					stmt.executeUpdate("update Adminreg set response="+flag+" where num="+rno+";");
					}
					catch(Exception e)
					{
						System.out.println(e);
					}
		}
		
		
	}
	
	void EditCom() {
		
		
		
	}


}
