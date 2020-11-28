package shop.dongguktime.web.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;


import shop.dongguktime.web.dto.MessageDTO;

public class MessageDAO {
	
	
private static MessageDAO dao = new MessageDAO();
	

	private DataSource dataSource;
	private Connection connection;
	private Statement statement;
	private ResultSet resultSet;
	private PreparedStatement prestat;
	
	
	private MessageDAO() {
		
		try	{
			Context context = new InitialContext();
			dataSource = (DataSource)context.lookup("java:comp/env/jdbc/orcl");
		
		}catch(Exception e) {
			System.out.println(e.toString());
		}
	}
	
	public static MessageDAO getInstance() {
		return dao;
	}
	
	
	public boolean SendMessage(MessageDTO dto) {
		
		
		
		boolean insertResult = false;
		
		int mNum = 0;
		
		
		String mToId = dto.getmToId();
		String mFromId = dto.getmFromId();
		String mContent = dto.getmContent();
		
		
		
		
		try	{
			
			
			connection = dataSource.getConnection();
			statement = connection.createStatement();
			
			String query = "select COUNT(mNum) as cnt, MAX(mNum) as max_num from message where mToId = ? and mFromId = ?";
			
			prestat = connection.prepareStatement(query);
			
			prestat.setString(1, mToId);
			prestat.setString(2, mFromId);
		
			
			resultSet = prestat.executeQuery();

			
			while(resultSet.next()){
				
				if(Integer.parseInt(resultSet.getString("cnt")) != 0)
					mNum = Integer.parseInt(resultSet.getString("max_num"));
			}
			
			mNum++;
			
			
			query = "insert into message values (?,?,?,?)";
			prestat = connection.prepareStatement(query);
			
			
			prestat.setInt(1, mNum);
			prestat.setString(2, mToId);
			prestat.setString(3, mFromId);
			prestat.setString(4, mContent);
			
			prestat.executeUpdate();
				
			insertResult = true;
			
			
		}catch(Exception e)	{
			System.out.println(e.toString() + "insert 오류");
		}
		finally
		{
			try {
				
			if(!prestat.isClosed()) prestat.close();
			if(!connection.isClosed()) connection.close();
			
			}
			catch(Exception e)
			{
				System.out.println(e.toString() + "insert finally");
			}
		}
		
		return insertResult;
	}
	
	
	
	public ArrayList<MessageDTO> getMessages(String mToId){
		
		ArrayList<MessageDTO> dtos = new ArrayList<MessageDTO>();

		try {

			connection = dataSource.getConnection();
			String query = "select * from message where mToId = ? order by mNum asc";
			prestat = connection.prepareStatement(query);
			prestat.setString(1,mToId);
			
			resultSet = prestat.executeQuery();
			
			while (resultSet.next()) {
				
				MessageDTO dto = new MessageDTO(
						resultSet.getInt(1),
						resultSet.getString(2),
						resultSet.getString(3),
						resultSet.getString(4));
					
				dtos.add(dto);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.toString()+"get message 오류");
		} finally {
			try {
				if (!connection.isClosed())
					connection.close();
				if (!prestat.isClosed())
					prestat.close();
				if (!resultSet.isClosed())
					resultSet.close();
			} catch (Exception e) {
				System.out.println(e.toString()+ "get message finally");
			}
		}

		return dtos;
	}	
	
	
	public MessageDTO getMessage(String mToId, String mFromId,int mNum) {
		
		MessageDTO dto = new MessageDTO();

		try {

			connection = dataSource.getConnection();
			String query = "select * from message where mNum = ? and mToId = ? and mFrom Id = ? order by mNum desc";
			prestat = connection.prepareStatement(query);
			prestat.setInt(1,mNum);
			prestat.setString(2,mToId);
			prestat.setString(3, mFromId);
			
			resultSet = prestat.executeQuery();
			
			if(resultSet.next()) {
				
				dto.setmNum(resultSet.getInt(1));
				dto.setmToId(resultSet.getString(2));
				dto.setmFromId(resultSet.getString(3));		
				dto.setmContent(resultSet.getString(4));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.toString()+"get message 오류");
		} finally {
			try {
				if (!connection.isClosed())
					connection.close();
				if (!prestat.isClosed())
					prestat.close();
				if (!resultSet.isClosed())
					resultSet.close();
			} catch (Exception e) {
				System.out.println(e.toString()+ "get message finally");
			}
		}
		
		return dto;
		
		
	}
	
	
	
	
	
	
	

}
