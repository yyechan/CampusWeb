package shop.dongguktime.web.frontcontroller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import shop.dongguktime.web.command.*;


@WebServlet("*.do")
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;


	public FrontController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doGet Method");
		actionDo(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doPost Method");
		actionDo(request,response);
	}
	
	
	private void actionDo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("actionDo Method");
		
		request.setCharacterEncoding("UTF-8");	
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");

		
		String viewPage = null;
		Command command = null;
		
		String uri = request.getRequestURI();
		String conPath = request.getContextPath();
		String context = uri.substring(conPath.length());
		
		if(context.equals("/login.do")) {
			command = new loginCommand();
			command.execute(request, response);
			viewPage = "mainView.jsp";
		}else if(context.equals("/logout.do")) {
			command = new logoutCommand();
			command.execute(request, response);
			viewPage = "mainView.jsp";
		}else if(context.equals("/signup.do")) {
			command = new signupCommand();
			command.execute(request, response);
			viewPage = "mainView.jsp";
		}else if(context.equals("/boardListView.do")) {
			command = new boardListViewCommand();
			command.execute(request, response);
			
			String type = request.getParameter("bType");
			
			switch (type) {
			case "1":
				viewPage = "fboardListView.jsp";
				break;
			case "2" :
				viewPage = "aboardListView.jsp";
				break;
			case "3" :
				viewPage = "mboardListView.jsp";
				break;
			}
			
		}else if(context.equals("/boardView.do")) {
			
			command = new boardViewCommand();
			command.execute(request, response);
			
			viewPage = "boardView.jsp";
			
		}
		
		else if(context.equals("/search.do")) {
			
			command = new searchViewCommand();
			command.execute(request, response);
			
			viewPage = "searchView.jsp";		
			
			
		}else if(context.equals("/boardInsert.do")) {
			
			command = new boardInsertCommand();
				
			command.execute(request, response);
			
			String type = (String)request.getAttribute("bType");
			
			viewPage = "mainView.jsp";
			
			
			
		}else if(context.equals("/commentWrite.do")) {
			
			command = new commentWriteCommand();
			command.execute(request, response);
			viewPage = "boardView.jsp?bNum="+request.getParameter("bNum");
			
		}else if(context.equals("/messageWrite.do")) {
			
			command = new messageWriteCommand();
			command.execute(request,response);
			
			viewPage = "mainView.jsp";
			
		}
		
		
		
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
		dispatcher.forward(request, response);
		
		return;
		
	}

}
