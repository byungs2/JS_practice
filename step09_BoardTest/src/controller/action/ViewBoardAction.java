package controller.action;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.guestbook.GuestBook;
import model.guestbook.GuestBookDAO;

public class ViewBoardAction implements Action{

	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = null;
		String strNum=request.getParameter("num");
		
		try{
			if(strNum==null || strNum.length() == 0){
				throw new Exception("입력값이 충분하지 않습니다.");
			}
			
			int num=Integer.parseInt(strNum);
			GuestBook gContent = GuestBookDAO.getContent(num, true);
			
			if(gContent == null){
				throw new Exception("게시물이 존재하지 않습니다.");
			}else{
				request.setAttribute("resultContent", gContent);
				url = "read.jsp";
			}
		}catch (SQLException e) {
			request.setAttribute("errorMsg", e.getMessage());
			url = "error.jsp";
		}catch (Exception e) {
			request.setAttribute("errorMsg", e.getMessage());
			url = "error.jsp";
		}
		request.getRequestDispatcher(url).forward(request, response);
	}
}
