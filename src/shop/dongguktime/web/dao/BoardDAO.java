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

import shop.dongguktime.web.dto.BoardDTO;


public class BoardDAO {


	private static BoardDAO dao = new BoardDAO();
	

	private DataSource dataSource;
	private Connection connection;
	private Statement statement;
	private ResultSet resultSet;
	private PreparedStatement prestat;
	
	
	private BoardDAO() {
		
		try	{
			Context context = new InitialContext();
			dataSource = (DataSource)context.lookup("java:comp/env/jdbc/orcl");
		
		}catch(Exception e) {
			System.out.println(e.toString());
		}
	}
	
	public static BoardDAO getInstance() {
		return dao;
	}
	
	
	public boolean InsertBoard(BoardDTO dto) {
		boolean insertResult = false;
		int bNum = 0;
		
				
		try	{
			
			
			connection = dataSource.getConnection();
			statement = connection.createStatement();
			
			String query = "select COUNT(bNum) as cnt, MAX(bNum) as max_num from board";
			
			resultSet = statement.executeQuery(query);

			
			while(resultSet.next()){
				
				if(Integer.parseInt(resultSet.getString("cnt")) != 0)
					bNum = Integer.parseInt(resultSet.getString("max_num"));
			}
			
			bNum++;
			
			
			query = "insert into board values (?,?,?,?,?,?,?)";
			prestat = connection.prepareStatement(query);
			
			
			prestat.setInt(1, bNum);
			prestat.setString(2, dto.getbId());
			prestat.setString(3, dto.getbTitle());
			prestat.setString(4, dto.getbContent());
			prestat.setTimestamp(5, new Timestamp(System.currentTimeMillis()));
			prestat.setInt(6, dto.getbType());
			prestat.setString(7, dto.getbImageUri());
			
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
	
	public ArrayList<BoardDTO> getBoardsFromType(int bType){
			
			ArrayList<BoardDTO> dtos = new ArrayList<BoardDTO>();
	
			try {

				connection = dataSource.getConnection();
				String query = "select * from board where bType = ? order by bNum desc";
				prestat = connection.prepareStatement(query);
				prestat.setInt(1,bType);
				
				resultSet = prestat.executeQuery();
				
				while (resultSet.next()) {
					
					BoardDTO dto = new BoardDTO(
							resultSet.getInt(1),
							resultSet.getString(2),
							resultSet.getString(3),
							resultSet.getString(4),
							resultSet.getTimestamp(5),
							resultSet.getInt(6),	
							resultSet.getString(7));
					dtos.add(dto);
				}
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println(e.toString()+"getboards 오류");
			} finally {
				try {
					if (!connection.isClosed())
						connection.close();
					if (!prestat.isClosed())
						prestat.close();
					if (!resultSet.isClosed())
						resultSet.close();
				} catch (Exception e) {
					System.out.println(e.toString()+ "getboards finally");
				}
			}
	
			return dtos;
		}	
	
	
	public BoardDTO getBoardFrombNum(int bNum)	{
		BoardDTO dto = new BoardDTO();
		
		try {
			
			connection = dataSource.getConnection();
			String query = "select * from board where bNum = ?";
			prestat = connection.prepareStatement(query);
			prestat.setInt(1, bNum);
			
			resultSet = prestat.executeQuery();
			
			if(resultSet.next())
			{
				dto.setbType(resultSet.getInt("bType"));
				dto.setbContent(resultSet.getString("bContent"));
				dto.setbDate(resultSet.getTimestamp("bDate"));
				dto.setbId(resultSet.getString("bId"));
				dto.setbNum(resultSet.getInt("bNum"));
				dto.setbTitle(resultSet.getString("bTitle"));
				dto.setbImageUri(resultSet.getString("bImageUri"));
				
			}
			
			connection.close();
			prestat.close();
			
			
			
			
		}catch(Exception e)	{
			e.printStackTrace();
		}

		return dto;
	}
	
	public boolean ModifyBoard(BoardDTO dto)
	{
		boolean modifyResult = false;
		
		try {
			connection = dataSource.getConnection();
			
			String query = "update members set bTitle = ?, bContent = ?, bImageUri = ? where bNum = ?";
			prestat = connection.prepareStatement(query);
			
			prestat.setString(1, dto.getbTitle());
			prestat.setString(2, dto.getbContent());
			prestat.setString(3, dto.getbImageUri());
			prestat.setInt(4, dto.getbNum());
			
			
			
			int i = prestat.executeUpdate();
			
			
			if(i>0)	{
				modifyResult = true;
			}
		}catch(Exception e) {
			
			System.out.println(e.toString());
		}
		finally {
			try {
				if(!prestat.isClosed()) prestat.close();
				if(!connection.isClosed()) connection.close();	
			}catch(Exception e) {
					System.out.println(e.toString());
			}
		}
		return modifyResult;
	}
	
	public ArrayList<BoardDTO> getBoardsSearch(String pattern){
		
		ArrayList<BoardDTO> dtos = new ArrayList<BoardDTO>();

		try {

			connection = dataSource.getConnection();
			String query = "select * from board where bContent = %?% ";
			prestat.setString(1,pattern);
			prestat = connection.prepareStatement(query);
			resultSet = prestat.executeQuery();
			
			while (resultSet.next()) {
				
				BoardDTO dto = new BoardDTO(
						resultSet.getInt(1),
						resultSet.getString(2),
						resultSet.getString(3),
						resultSet.getString(4),
						resultSet.getTimestamp(5),
						resultSet.getInt(6),	
						resultSet.getString(7));
				dtos.add(dto);
			}
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.toString()+"getboards 오류");
		} finally {
			try {
				if (!connection.isClosed())
					connection.close();
				if (!prestat.isClosed())
					prestat.close();
				if (!resultSet.isClosed())
					resultSet.close();
			} catch (Exception e) {
				System.out.println(e.toString()+ "getboards finally");
			}
		}

		return dtos;
	}	
	
}
