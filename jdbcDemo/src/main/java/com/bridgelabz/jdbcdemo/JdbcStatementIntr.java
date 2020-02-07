package com.bridgelabz.jdbcdemo;

import java.sql.*;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class JdbcStatementIntr {
	private static Logger log = LogManager.getLogger(JdbcStatementIntr.class);
	public static void main(String[] args) {
		Connection con = null;
		Statement stmt = null;
		String qry = "insert into mydatabase.employee values('Nayan' , 'nn1' , 22)";
		//String qry1 = "delete from mydatabase.employee where empid='nn1'";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			log.info("class loaded and registered");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mydatabase?useSSL=false","root","root");
			log.info("Connection established");
stmt=con.createStatement();
log.info("Statement created");
stmt.execute(qry);
log.info("Data inserted");

		}catch(ClassNotFoundException | SQLException e)
		{
			log.error("class not fond"+e);
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
					log.error("Error");
				}
			}
			if(con!=null)
			{
				try
				{
					con.close();
				}catch(SQLException e)
				{
					log.error("error");
				}
			}
		}
	}

}
