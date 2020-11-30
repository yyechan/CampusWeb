package shop.dongguktime.web.command;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import shop.dongguktime.web.dao.ClassDAO;
import shop.dongguktime.web.dao.TimeTableDAO;
import shop.dongguktime.web.dto.ClassDTO;
import shop.dongguktime.web.dto.TimeTableDTO;

public class timetableViewCommand implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
		TimeTableDAO tdao = TimeTableDAO.getInstance();
		ClassDAO cdao = ClassDAO.getInstance();
		HttpSession session = request.getSession();
		String userId = (String)session.getAttribute("id");
		
		
		
		ArrayList<TimeTableDTO> tdtos = tdao.getTimeTableFromId(userId);
		
		
		String[] classList = {};
		
		
		if(request.getParameter("timetableName") == null) {
		
			if(!tdtos.isEmpty()) {
				
				classList = tdtos.get(0).getClassId().split(",");
				
			}
		
		
		}else {
			
			int index = 0;
			
			for(TimeTableDTO dto : tdtos) {
				
				if(dto.getTimeTableName().equals(request.getParameter("timetableName"))) 
					break;
				else
					index++;
				
			}
			
			
			classList = tdtos.get(index).getClassId().split(",");
			
			
		}
		
		
		
		
		for(String classId : classList) {
			
			ArrayList<ClassDTO> dtos;
			
			classId = classId.trim();
			
			dtos = cdao.getTimeTablesFromClassName(classId,false);
			
			
			
			for(ClassDTO d : dtos) {
				
				String day = d.getClassDay();
				int startTime = (int)(Double.parseDouble(d.getStartTime())*2 -1);
				int endTime = (int)(Double.parseDouble(d.getEndTime())*2 -1);
	
				
				for(int i = startTime ; i <= endTime ; i++) {
					
					String str = day+i;
				
					
					request.setAttribute(str, d.getClassName()+"\n"+d.getProfessorName());
				}
			
			}
			
		}
		
		
		
		
		
		
		
				

	}

}
