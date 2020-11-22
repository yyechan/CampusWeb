package shop.dongguktime.web.command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import shop.dongguktime.web.dao.BoardDAO;
import shop.dongguktime.web.dto.BoardDTO;

public class boardViewCommand implements Command {
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		BoardDAO dao = BoardDAO.getInstance();
		BoardDTO dto = dao.getBoardFrombNum(Integer.parseInt(request.getParameter("bNum")));
		request.setAttribute("dto", dto);	
	}
	
}
