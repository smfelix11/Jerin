package com.nissan.project;

import java.util.Scanner;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.*;

public class Admin {
	
	private String username="AirAdmin";
	private String password="Admin123";
	public int res=0;
	Scanner in=new Scanner(System.in);
	Connection con;
	Statement stmt;
	
	Admin()
	{
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
		
		
	
void authorize()
	{	int ch;
		System.out.println("Enter Username : ");
		String user=in.next();
		System.out.println("Enter Password : ");
		String pass=in.next();
		if(user.equals(username)&&pass.equals(password)) {
			System.out.println("1.Add Regulation\n2.Remove Regulation\n3.Check User Comment\n4.Exit\nEnter your choice:");
			switch(ch=in.nextInt()) {
			
			case 1: AddReg();
					break;
			case 2:
					RemReg();
					break;
			case 3:
					CheckCom();
					break;
			case 4:
					System.exit(0);
					break;
			default:
					System.out.println("Wrong choice");
					break;
			}
		}
	}
void AddReg() {
	
	Scanner sc=new Scanner(System.in);
	System.out.println("Enter the regulation number");
	int regno=sc.nextInt();
	System.out.println("Enter the regulation");
	String reg=sc.next();
	System.out.println("Enter the department to which to be sent");
	String dep=sc.next();
	System.out.println("Enter today's date in YYYY-MM-DD format");
	String day=sc.next();
		try
		{
		stmt=con.createStatement();
		PreparedStatement stmt=con.prepareStatement("insert into Adminreg values(?,?,?,?,?,?,?,?);");
		stmt.setInt(1,regno);
		stmt.setString(2,reg);
		stmt.setString(3,dep);
		stmt.setString(4,day);
		stmt.setString(5,"no");
		stmt.setInt(6,0);
		stmt.setString(7, "no");
		stmt.setString(8,"Valid");
		stmt.executeUpdate();
		}
		catch(Exception e)
		{
			System.out.println("Exception: "+e);
		}
	
	}

void RemReg() 
{
	System.out.println("**********************************************************************************************************************");
	try {
		stmt=con.createStatement();
		ResultSet rs=stmt.executeQuery("select num,regulation,Dept,day from Adminreg where status='valid';");
		System.out.println("N0: REGULATION               DEPARTMENT   DATE");
		while(rs.next())
		{
	System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3)+"  "+rs.getString(4));
		}
	}
		catch(Exception e)
		{
			System.out.println("Exception: "+e);
		}
	System.out.println("**********************************************************************************************************************");
Scanner sc=new Scanner(System.in);
System.out.println("Enter the Regulation number to be removed");
int rgnum=sc.nextInt();
String del="delete from Adminreg where num="+rgnum+";";
int i=0;;
try
{
stmt=con.createStatement();
i=stmt.executeUpdate(del);
}
catch(Exception e)
{
	System.out.println("Exception: "+e);
}
if(i==0)
{
	System.out.println("The regulation does not exist");
}
else
	System.out.println("The regulation has been removed");
	


}
	
void CheckCom() 
{
	Scanner sc=new Scanner(System.in);
	
	try {
		stmt=con.createStatement();
		ResultSet rs=stmt.executeQuery("select num,regulation,Dept,day from Adminreg where status='valid' AND Adminrec='Yes';");
		System.out.println("N0: REGULATION");
		while(rs.next())
		{
	System.out.println(rs.getInt(1)+" "+rs.getString(2));
		}
	}
		catch(Exception e)
		{
			System.out.println("Exception: "+e);
		}
	
	System.out.println("Enter the Regulation Number of the review to be read :");
	int regno=sc.nextInt();
	
	try {
		stmt=con.createStatement();
		ResultSet rs=stmt.executeQuery("select name,email,department,review from comments where num="+regno+";");
		System.out.println("NAME EMAIL REVIEW");
		while(rs.next())
		{
	System.out.println(rs.getString(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getString(4));
		}
	}
		catch(Exception e)
		{
			System.out.println("Exception: "+e);
		}

	

}	

}
