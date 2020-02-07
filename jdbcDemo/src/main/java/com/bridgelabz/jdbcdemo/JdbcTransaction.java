package com.bridgelabz.jdbcdemo;

import java.sql.*;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.bridgelabz.util.MyUtility;

public class JdbcTransaction {
	private static Logger log = LogManager.getLogger(JdbcTransaction.class);
	public static void main(String[] args) {
Connection con = null;
PreparedStatement pstmt1 = null;
PreparedStatement pstmt2 = null;
String qry1 = "insert into mydatabase.employee values(?,?,?)";
String qry2 = "insert into mydatabase.employee2 values(?,?,?)";
log.info("Enter name:");
String name = MyUtility.inputWord();
log.info("Enter id");
String id = MyUtility.inputWord();
log.info("Enter city:");
String city = MyUtility.inputWord();
log.info("Enter age");
int age = MyUtility.inputInteger();
try
{
	con = DriverManager.getConnection("jdbc:mysql://localhost:3306?useSSL=false","root","root");
	con.setAutoCommit(false);
	pstmt1 = con.prepareStatement(qry1);
	pstmt1.setString(1, name);
	pstmt1.setString(2, id);
	pstmt1.setInt(3, age);
	pstmt1.executeUpdate();
	log.info("Inserted to table 1 successfull");
	pstmt2 = con.prepareStatement(qry2);
	pstmt2.setString(1, name);
	pstmt2.setString(2, id);
	pstmt2.setString(3, city);
	pstmt2.executeUpdate();
	log.info("Inserted to table 2 successfull");
	
	con.commit();
}catch(SQLException e)
{
try{
	con.rollback();
	log.info("Operations rolled back");
}catch(SQLException e1)
{
	log.error("Error:" +e1);
}
log.error("Error:"+e);
	}
finally
{
	if(pstmt2!=null)
	{
		try
		{
			pstmt2.close();
		}catch(SQLException e)
		{
			log.error("Error:"+e);
		}
	}
	if(pstmt1!=null)
	{
		try
		{
			pstmt1.close();
		}catch(SQLException e)
		{
			log.error("Error:"+e);
		}
	}
	if(con!=null)
	{
		try
		{
			con.close();
		}catch(SQLException e)
		{
			log.error("Error"+e);
		}
	}
}
		
	}

}
