package com.bridgelabz.jdbcdemo;

import java.sql.*;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class BatchStmt {
	private static Logger log = LogManager.getLogger(BatchStmt.class);
	public static void main(String[] args) {
Connection con = null;
Statement stmt = null;
String qry = "insert into mydatabase.employee values('Chethan','c1' , 22)";
String qry2 = "delete from mydatabase.employee where empid='a1'";
try
{
	con=DriverManager.getConnection("jdbc:mysql://localhost:3306?useSSL=false","root","root");
	stmt=con.createStatement();
	stmt.addBatch(qry);
	stmt.addBatch(qry2);
	int [] a = stmt.executeBatch();
	for(int i : a)
		log.info("Number of data affected:"+i);
	
}catch(SQLException e)
{
	log.error("Connection not possible");
}
finally
{
	if(stmt!=null)
	{
		try
		{
			stmt.close();
		}catch(SQLException e)
		{
			log.error("Error"+e);
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
