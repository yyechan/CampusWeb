package shop.dongguktime.web.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import shop.dongguktime.web.dto.CommentDTO;

public class CommentDAO {


	
	
	private static CommentDAO dao = new CommentDAO();
	
	private DataSource dataSource;
	private Connection connection;
	private Statement statement;
	private ResultSet resultSet;
	private PreparedStatement prestat;
	
	private CommentDAO() {
		
		try {
			Context context = new InitialContext();
			dataSource = (DataSource)context.lookup("java:comp/env/jdbc/orcl");
		
		}catch(Exception e) {
			System.out.println(e.toString());
		}
		
	}
	
	public static CommentDAO getInstance()	{
		return dao;
	}
	
	
	public ArrayList<CommentDTO> getComments(int bNum)	{
		
		ArrayList<CommentDTO> dtos = new ArrayList<CommentDTO>();
				
		try {
			
			connection = dataSource.getConnection();			
			String query = "Select * from Comments where bNum = ? order by cDate asc";
			prestat = connection.prepareStatement(query);
			prestat.setInt(1, bNum);
			
			resultSet = prestat.executeQuery();
						
			while(resultSet.next())	{
				CommentDTO dto = new CommentDTO();
				
				dto.setcContent(resultSet.getString("cContent"));
				dto.setcDate(resultSet.getString("cDate"));
				dto.setcId(resultSet.getString("cId"));
				dto.setbNum(resultSet.getInt("bNum"));
				dtos.add(dto);
			}
			
		}catch(Exception e)	{
			
			e.printStackTrace();
		}
		finally		{	
			try {
			connection.close();
			prestat.close();
			resultSet.close();
			}
			catch(Exception e)	{
				e.printStackTrace();
			}
			
		}
		return dtos;
	}
	
	public int insertComment(CommentDTO dto) {	
		
		int result = -1;
		
		try	{
			
			connection = dataSource.getConnection();
			String query = "insert into Comments values (?,?,?,to_char(sysdate,'yyyy.mm.dd hh24:mi:ss'))";			
			prestat = connection.prepareStatement(query);
			
			prestat.setInt(1,dto.getbNum());
			prestat.setString(2, dto.getcId());
			prestat.setString(3, dto.getcContent());
			
			result = prestat.executeUpdate();
			
			connection.close();
			prestat.close();
		}
		catch(Exception e)	{
			e.printStackTrace();
		}
				
		return result;
	}
	
	
	
}


