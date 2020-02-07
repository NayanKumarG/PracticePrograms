package com.bridgelabz.jdbcdemo;

import java.sql.*;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class PreparedStmtInsertMultiple {
	private static Logger log = LogManager.getLogger(PreparedStmtInsertMultiple.class);
	public static void main(String[] args) {

		Connection con = null;
		PreparedStatement pstmt = null;
		String qry = "insert into mydatabase.employee values(?,?,?)";
		try
		{
			log.info("class loaded and registered");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306?useSSL=false","root","root");
			log.info("Connection established");
			pstmt=con.prepareStatement(qry);
			log.info("platform created");
			pstmt.setString(1, "Akshay");
			pstmt.setString(2, "a1");
			pstmt.setInt(3, 22);
			pstmt.executeUpdate();	
			pstmt.setString(1, "srijan");
			pstmt.setString(2, "s1");
			pstmt.setInt(3, 22);
			pstmt.executeUpdate();
			log.info("Data inserted");
		} catch (SQLException e) {
			log.error("Inserting not possible"+e);
		} 
		finally
		{
			if(pstmt!=null)
			{
				try
				{
					pstmt.close();
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
