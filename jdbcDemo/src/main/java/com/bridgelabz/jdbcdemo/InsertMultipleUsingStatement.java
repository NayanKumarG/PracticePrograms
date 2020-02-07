package com.bridgelabz.jdbcdemo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class InsertMultipleUsingStatement {

	private static Logger log = LogManager.getLogger(InsertMultipleUsingStatement.class);
	public static void main(String[] args) {
		Connection con = null;
		Statement stmt = null;
		String qry = "insert into mydatabase.employee values('Nayan' , 'nn1' , 22)";
		String qry1 = "insert into mydatabase.employee values('kumar' , 'nn2' , 22)";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			log.info("class loaded and registered");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mydatabase?useSSL=false","root","root");
			log.info("Connection established");
			stmt=con.createStatement();
			log.info("Statement created");
			stmt.executeUpdate(qry);
			stmt.executeUpdate(qry1);
			log.info("Data inserted");

		}catch(ClassNotFoundException e)
		{
			log.error("class not fond"+e);
		}
		catch(SQLException e)
		{
			log.error("insertion not possible");
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


