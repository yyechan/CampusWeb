package shop.dongguktime.web.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import shop.dongguktime.web.dto.ClassDTO;

public class ClassDAO {

	
	private static ClassDAO dao = new ClassDAO();
	

	private DataSource dataSource;
	private Connection connection;
	private Statement statement;
	private ResultSet resultSet;
	
	
	private ClassDAO() {
		
		try	{
			Context context = new InitialContext();
			dataSource = (DataSource)context.lookup("java:comp/env/jdbc/orcl");
		
		}catch(Exception e) {
			System.out.println(e.toString());
		}
	}
	
	public static ClassDAO getInstance() {
		return dao;
	}
	
	public ArrayList<ClassDTO> getTimeTablesFromClassName(String keywords,boolean isSearch) {
		
		ArrayList<ClassDTO> dtos = new ArrayList<ClassDTO>();
		
		keywords = keywords.trim();
		
		try {
			
			connection = dataSource.getConnection();
			statement = connection.createStatement();
			String query; 
			
			if(keywords.equals("")) {
				query = "select * from class";
			}else if(isSearch == false){
				query = "select * from class where classId = '" + keywords + "'";
			}else {
				query = "select * from class where className LIKE '%" + keywords + "%'";
			}
			resultSet = statement.executeQuery(query);
			
			
			while(resultSet.next()) {
				
				String classId = resultSet.getString("classId");
				String className = resultSet.getString("className");
				String professorName = resultSet.getString("professorName");
				String classLocation = resultSet.getString("classLocation");
				String classDay = resultSet.getString("classDay");
				String startTime = resultSet.getString("startTime");
				String endTime = resultSet.getString("endTime");
				int classScore = resultSet.getInt("classScore");
				ClassDTO dto = new ClassDTO(classId,className,professorName,classLocation,classDay,startTime,endTime,classScore);

				dtos.add(dto);
			}
		
		}catch(Exception e) {
		
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
		
		return dtos;
	}
	
}
