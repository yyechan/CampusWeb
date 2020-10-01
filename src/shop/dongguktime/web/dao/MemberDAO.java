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

import shop.dongguktime.web.dto.MemberDTO;

public class MemberDAO {
	
	private static MemberDAO dao = new MemberDAO();
	

	private DataSource dataSource;
	private Connection connection;
	private Statement statement;
	private ResultSet resultSet;
	private PreparedStatement prestat;
	
	//db 연동 
	private MemberDAO() {
		
		try	{
			Context context = new InitialContext();
			dataSource = (DataSource)context.lookup("java:comp/env/jdbc/orcl");
		
		}catch(Exception e) {
			System.out.println(e.toString());
		}
	}
	
	public static MemberDAO getInstance() {
		return dao;
	}
	
	public boolean existsId (String id) { // 아이디 중복체크
		
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
	
	public MemberDTO getMembersFromId(String m_id) { //id로 유저정보 획득
		 
		MemberDTO dto = null;
		
		try {
			

			connection = dataSource.getConnection();
			statement = connection.createStatement();
			String query = "select * from members where id ='" +m_id+ "'";
			
			resultSet = statement.executeQuery(query);
			
			if(resultSet.next()) {
				
				String id = resultSet.getString("id");
				String pw = resultSet.getString("pw");
				String eMail = resultSet.getString("eMail");
				boolean isAuthenticated = resultSet.getBoolean("isAuthenticated");
				
				dto = new MemberDTO(id,pw,eMail,isAuthenticated);
				
			}
			
			
		}catch (Exception e) {
			
			System.out.println(e.toString());
			
		}finally {
			
			try {
				if(!connection.isClosed()) connection.close();
				if(!statement.isClosed()) statement.close();
				if(!resultSet.isClosed()) resultSet.close();
			}
			catch(Exception e)	{
				System.out.println(e.toString());
			}
		
		}
		
		return dto;
	}
	
	public boolean InsertMembers(MemberDTO dto) {
		
		boolean insertResult = false;
		
		
		try
		{
			connection = dataSource.getConnection();
			String query = "insert into members values (?,?,?,?)";
			prestat = connection.prepareStatement(query);
			
			prestat.setString(1, dto.getId());
			prestat.setString(2, dto.getPw());
			prestat.setString(3, dto.geteMail());
			prestat.setBoolean(4, dto.getIsAuthenticated());
		
			prestat.executeUpdate();
			
			insertResult = true;
			
			
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
		
		
		return insertResult;
		
	}
	
	public boolean ModifyMembers (MemberDTO dto) { // 사용자 정보 수정
		
		boolean modifyResult = false;
		
		try {
			
			connection = dataSource.getConnection();
			String query = "update members set pw = ?, eMail = ?, isAuthenticated = ? where id = ?";
			prestat = connection.prepareStatement(query);
			
			prestat.setString(1, dto.getPw());
			prestat.setString(2, dto.geteMail());
			prestat.setBoolean(3,dto.getIsAuthenticated());
			prestat.setString(4,dto.getId());
		
			int cnt = prestat.executeUpdate();
			
			if(cnt>0) {
				modifyResult = true;
			}
			
		}catch(Exception e) {
			
			System.out.println(e.toString());
			
		}finally {
			
			try {
				if(!prestat.isClosed()) prestat.close();
				if(!connection.isClosed()) connection.close();
			}catch(Exception e) {
				System.out.println(e.toString());
			}
			
		}
		
		return modifyResult;
		
	}
	

}
