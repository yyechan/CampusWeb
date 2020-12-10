package shop.dongguktime.web.command;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import shop.dongguktime.web.dao.MemberDAO;
import shop.dongguktime.web.dto.MemberDTO;
import shop.dongguktime.web.sha256.SHA256;


public class loginCommand implements Command {
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int loginResult = 0;
		
		PrintWriter out = response.getWriter();
		
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		
		pw = SHA256.encrypt(pw);
		
		MemberDAO dao = MemberDAO.getInstance();
		MemberDTO dto = dao.getMembersFromId(id);
		
		if(dto == null)	{
			out.println("<script>");
			out.println("alert('아이디 또는 비밀번호를 확인해 주세요.')");
			out.println("location.href = 'loginView.jsp'");
			out.println("</script>");
			out.flush();
		}
		else if(dto.getId().equals(id) && dto.getPw().equals(pw)) {
				
				HttpSession session = request.getSession();
				session.setAttribute("id", dto.getId());
				session.setAttribute("pw", dto.getPw());
				session.setAttribute("name",dto.getName());
				session.setAttribute("LoginSession",1);
				
				out.println("<script>");
				out.println("location.href = 'index.jsp'");
				out.println("</script>");
				out.flush();
		}
		
		if(loginResult == 0) {
			out.println("<script>");
			out.println("alert('아이디 또는 비밀번호를 확인해 주세요.')");
			out.println("location.href = 'loginView.jsp'");
			out.println("</script>");
			out.flush();
			
		}
		
		out.close();
		
		return;
		
	}
}
