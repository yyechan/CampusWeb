package shop.dongguktime.web.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import shop.dongguktime.web.dto.TimeTableDTO;

public class TimeTableDAO {

	
	private static TimeTableDAO dao = new TimeTableDAO();
	

	private DataSource dataSource;
	private Connection connection;
	private Statement statement;
	private ResultSet resultSet;
	
	//db ¿¬µ¿ 
	private TimeTableDAO() {
		
		try	{
			Context context = new InitialContext();
			dataSource = (DataSource)context.lookup("java:comp/env/jdbc/orcl");
		
		}catch(Exception e) {
			System.out.println(e.toString());
		}
	}
	
	public static TimeTableDAO getInstance() {
		return dao;
	}
	
	public ArrayList<TimeTableDTO> getTimeTables(String keywords) {
		
		ArrayList<TimeTableDTO> dtos = new ArrayList<TimeTableDTO>();
		
		keywords = keywords.trim();
		
		try {
			
			connection = dataSource.getConnection();
			statement = connection.createStatement();
			String query; 
			
			if(keywords=="") {
				query = "select * from timetable";
			}else {
				query = "select * from timetable where courseName = '" + keywords + "'";
			}
			resultSet = statement.executeQuery(query);
			
			
			while(resultSet.next()) {
				
				String courseNum = resultSet.getString("courseNum");
				String courseName = resultSet.getString("courseName");
				String courseTime = resultSet.getString("courseTime");
				String courseLecturer = resultSet.getString("courseLecturer");
				String courseLocation = resultSet.getString("courseLocation");
				int courseScore = resultSet.getInt("courseScore");
				
				TimeTableDTO dto = new TimeTableDTO(courseNum, courseName, courseTime, courseLecturer, courseLocation, courseScore);
				
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
