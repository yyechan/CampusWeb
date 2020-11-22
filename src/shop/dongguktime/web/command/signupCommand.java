package shop.dongguktime.web.command;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import shop.dongguktime.web.dao.MemberDAO;
import shop.dongguktime.web.dto.MemberDTO;
import shop.dongguktime.web.sha256.SHA256;

public class signupCommand implements Command {

	
	
@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	
	request.setCharacterEncoding("EUC-KR");
	response.setCharacterEncoding("EUC-KR");
	PrintWriter out = response.getWriter();
	
	MemberDAO dao = MemberDAO.getInstance();
	
	String id = request.getParameter("id");
	String pw = SHA256.encrypt(request.getParameter("pw"));
	String name = request.getParameter("name");
	String eMail = request.getParameter("eMail");
	//String isAuthenticated = request.getParameter("isAuthenticated");
	
	
	if(dao.isExistedId(id) == true ) 	{
		out.println("<script>");
		out.println("alert('이미 존재하는 아이디 입니다.')");
		out.println("location.href = 'join.html'");
		out.println("</script>");
		out.flush();
	}
	
	
	MemberDTO dto = new MemberDTO(id,pw,name,eMail,0);
	boolean insertResult = dao.InsertMembers(dto);
	

	if( insertResult == true) {

		out.println("<script>");
		out.println("alert('회원가입이 완료되었습니다.')");
		HttpSession session = request.getSession();
		session.setAttribute("id", id);			
		out.println("location.href = 'loginView.jsp'");
		out.println("</script>");
		out.flush();
	}
	else {
		out.println("<script>");
		out.println("alert('회원가입에 실패하였습니다.')");
		out.println("location.href = 'join.html'");
		out.println("</script>");
		out.flush();
	}
	
	
	out.close();
	
	}
}
