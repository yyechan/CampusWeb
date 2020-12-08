package shop.dongguktime.web.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import shop.dongguktime.web.dto.BoardDTO;
import shop.dongguktime.web.dto.ClassDTO;
import shop.dongguktime.web.dto.TimeTableDTO;

public class TimeTableDAO {


	private static TimeTableDAO dao = new TimeTableDAO();
	

	private DataSource dataSource;
	private Connection connection;
	private Statement statement;
	private ResultSet resultSet;
	private PreparedStatement prestat;
	
	
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
	
	
	public ArrayList<TimeTableDTO> getTimeTableFromId(String userId) {
		
		ArrayList<TimeTableDTO> dtos = new ArrayList<TimeTableDTO>();
		
		try {
			
			connection = dataSource.getConnection();
			statement = connection.createStatement();
			
			String query; 
			
			query = "select * from timetable where userId = '" + userId + "'";
			
			resultSet = statement.executeQuery(query);
			
			while(resultSet.next()) {
				
				String timetableName = resultSet.getString("timetableName");
		
				String classId = resultSet.getString("classId");
				
				TimeTableDTO dto = new TimeTableDTO(timetableName,userId,classId);

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
	
	public void timetableInsert(TimeTableDTO dto) {
		
		
		
		try
		{
			connection = dataSource.getConnection();
			String query = "insert into timetable values (?,?,?)";
			prestat = connection.prepareStatement(query);
			
			prestat.setString(1, dto.getTimeTableName());
			prestat.setString(2, dto.getUserId());
			prestat.setString(3, dto.getClassId());

		
			prestat.executeUpdate();
			
			
		}catch(Exception e)		{
			
			System.out.println(e.toString());
			
		}
		finally	{
			
			try {
				if(!prestat.isClosed()) prestat.close();
				if(!connection.isClosed()) connection.close();
			}
			catch(Exception e) {
				System.out.println(e.toString());
			}
		}
		
		
	}
	
	
	public boolean isExistedTitle (String title,String userId) {
			
			boolean duplication = false;
			
			try {
				
				connection = dataSource.getConnection();
				statement = connection.createStatement();
				String query = "select timetableName from timetable where timetableName = '" + title + "' and userId = '" + userId + "'" ;
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
