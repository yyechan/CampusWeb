package shop.dongguktime.web.command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import shop.dongguktime.web.dao.MessageDAO;
import shop.dongguktime.web.dto.MessageDTO;

public class messageWriteCommand implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		
		MessageDAO dao = MessageDAO.getInstance();
		MessageDTO dto = new MessageDTO();

		
		String mFromId = request.getParameter("mFromId");
		String mToId = request.getParameter("mToId");
		String mContent = request.getParameter("mContent");
		
		
		dto.setmFromId(mFromId);
		dto.setmToId(mToId);
		dto.setmContent(mContent);
		
		dao.SendMessage(dto);
		
		
		
	}

}
