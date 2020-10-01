package shop.dongguktime.web.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class MemberDAO {
	
	private static MemberDAO dao = new MemberDAO();
	

	private DataSource dataSource;
	private Connection connection;
	private Statement statement;
	private ResultSet resultSet;
	private PreparedStatement prestat;
	
	//db ¿¬µ¿ 
	private MemberDAO() {
		
		try	{
			Context context = new InitialContext();
			dataSource = (DataSource)context.lookup("java:comp/env/jdbc/orcl");
		
		}catch(Exception e) {
			System.out.println(e.toString());
		}
	}
	
	public boolean existsID (String id) {
		
		boolean duplication = false;
		
		try {
			
			connection = dataSource.getConnection();
			statement = connection.createStatement();
			String query = "select id from members where id = '" + id + "'";
			resultSet = statement.executeQuery(query);
			
			if(resultSet.next()) 
				duplication = true;
			else 
				duplication = false;
				
		}catch (Exception e) {
			System.out.println(e.toString());
		}finally {
			
			try {
				if(!connection.isClosed()) connection.close();
				if(!statement.isClosed()) statement.close();
				if(!resultSet.isClosed()) resultSet.close();
			}
			catch(Exception e) {
				System.out.println(e.toString());
			}	
		}
		
		
		return duplication;
	}
	
	
	
	
	

}
