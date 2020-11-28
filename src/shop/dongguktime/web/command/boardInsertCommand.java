package shop.dongguktime.web.command;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import shop.dongguktime.web.dao.BoardDAO;
import shop.dongguktime.web.dto.BoardDTO;

public class boardInsertCommand implements Command {
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		
				
		BoardDAO dao = BoardDAO.getInstance();
		
		BoardDTO dto = new BoardDTO();
		
		String bId = request.getParameter("bId");
		String bTitle = request.getParameter("bTitle");
		String bContent = request.getParameter("bContent"); 
		
		String bType = request.getParameter("bType");
		String bImageUri = request.getParameter("bImageUri");
		
		dto.setbContent(bContent);
		dto.setbId(bId);
		dto.setbImageUri(bImageUri);
		dto.setbTitle(bTitle);
		dto.setbType(Integer.parseInt(bType));
		
		dao.InsertBoard(dto);
		
	
	}
}
