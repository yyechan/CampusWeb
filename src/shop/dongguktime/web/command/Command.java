package shop.dongguktime.web.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Command {

	//command �������̽� 

	void execute(HttpServletRequest request,HttpServletResponse response);

}