package shop.dongguktime.web.command;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import shop.dongguktime.web.dao.BoardDAO;
import shop.dongguktime.web.dto.BoardDTO;

public class boardListViewCommand implements Command {

		@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
		int bType = Integer.parseInt(request.getParameter("bType"));
		BoardDAO dao = BoardDAO.getInstance();			
		ArrayList<BoardDTO> dtos = dao.getBoardsFromType(bType);
		request.setAttribute("dtos", dtos);		
	}
		
}
