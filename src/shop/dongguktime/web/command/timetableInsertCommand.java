package shop.dongguktime.web.command;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import shop.dongguktime.web.dao.ClassDAO;
import shop.dongguktime.web.dao.TimeTableDAO;
import shop.dongguktime.web.dto.ClassDTO;
import shop.dongguktime.web.dto.TimeTableDTO;

public class timetableInsertCommand implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		
		ClassDAO dao = ClassDAO.getInstance();

		String title = request.getParameter("timetableTitle");
		String str = request.getParameter("classIds");
		
		TimeTableDAO tdao = TimeTableDAO.getInstance();
		
		
		HttpSession session = request.getSession();
		

		if(tdao.isExistedTitle(title,(String)session.getAttribute("id")) == true ) 	{
			out.println("<script>");
			out.println("alert('이미 존재하는 시간표이름 입니다.')");
			out.println("location.href = 'timetableView.do'");
			out.println("</script>");
			out.flush();
			
			return;
		}
		
		
		
		
		
		
		
		
		
		
		
		String[] classIds = str.split(",");
		
		ArrayList<ClassDTO> dtos = new ArrayList<ClassDTO>();
		
		for(String s : classIds) {
			
			dtos.addAll(dao.getTimeTablesFromClassName(s, false));
			
		}

		
		

	}

}
