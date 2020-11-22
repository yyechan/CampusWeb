package shop.dongguktime.web.command;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import shop.dongguktime.web.dao.BoardDAO;
import shop.dongguktime.web.dto.BoardDTO;

public class searchViewCommand implements Command {

	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		BoardDAO dao = BoardDAO.getInstance();
		
		String pattern = request.getParameter("pattern");
		
		ArrayList<BoardDTO> dtos = dao.getBoardsSearch(pattern);
		
		request.setAttribute("pattern", dtos);	
			
	}


}
