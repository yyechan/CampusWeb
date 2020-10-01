package shop.dongguktime.web.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Command {

	//command 인터페이스 

	void execute(HttpServletRequest request,HttpServletResponse response);

}
