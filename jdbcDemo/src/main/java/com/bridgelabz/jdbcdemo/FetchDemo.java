package com.bridgelabz.jdbcdemo;

import java.sql.*;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.bridgelabz.util.MyUtility;

public class FetchDemo {
	private static Logger log = LogManager.getLogger(FetchDemo.class);
	public static void main(String[] args) {

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String qry = "select * from mydatabase.employee where empid=?";
		log.info("Enter employee id:");
		String str = MyUtility.inputWord();
		try
		{
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mydatabase?useSSL=false","root","root");
			pstmt=con.prepareStatement(qry);
			pstmt.setString(1, str);
			rs=pstmt.executeQuery();
			while(rs.next())
			{
				String name = rs.getString(1);
				int age = rs.getInt(3);
				log.info("Name:"+name+"\n Age:"+age);
			}
		}catch (SQLException e) {
			log.error("Inserting not possible"+e);
		} 
		finally
		{
			if(rs!=null)
			{
				try
				{
					rs.close();
				}catch(SQLException e)
				{
					log.error("Error");
				}
			}
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
