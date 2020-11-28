package shop.dongguktime.web.command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import shop.dongguktime.web.dao.CommentDAO;
import shop.dongguktime.web.dto.CommentDTO;

public class commentWriteCommand implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		HttpSession session = request.getSession();
		
		int bNum = Integer.parseInt(request.getParameter("bNum"));
		String cId = (String)session.getAttribute("id");
		String cContent = request.getParameter("cContent");
		
		
		CommentDAO dao = CommentDAO.getInstance();
		CommentDTO dto = new CommentDTO();
		
		dto.setbNum(bNum);
		dto.setcId(cId);
		dto.setcContent(cContent);

		dao.insertComment(dto);
		
		
		
	}

}
