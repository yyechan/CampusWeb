package shop.dongguktime.web.command;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import shop.dongguktime.web.dao.BoardDAO;
import shop.dongguktime.web.dto.BoardDTO;

public class boardInsertCommand implements Command {
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		int size = 1024*1024*10;
		String savePath = request.getServletContext().getRealPath("image");
		MultipartRequest multi = new MultipartRequest(request,savePath,size, "UTF-8",new DefaultFileRenamePolicy());
		
			
				
		BoardDAO dao = BoardDAO.getInstance();
		
		BoardDTO dto = new BoardDTO();
		
		String bId = multi.getParameter("bId");
		String bTitle = multi.getParameter("bTitle");
		String bContent = multi.getParameter("bContent"); 
		String bType = multi.getParameter("bType");
		String bImageUri = "";
		
		if(bType.equals("3")) {
		
			
			String fileName = multi.getFilesystemName("file");
			bImageUri = savePath + "/" + fileName;

		}
		
		
		dto.setbContent(bContent);
		dto.setbId(bId);
		dto.setbImageUri(bImageUri);
		dto.setbTitle(bTitle);
		dto.setbType(Integer.parseInt(bType));
		
		dao.InsertBoard(dto);
		
	
	}
}
