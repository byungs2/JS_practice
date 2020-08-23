package controller.action;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.guestbook.GuestBook;
import model.guestbook.GuestBookDAO;

public class UpdateBoardAction implements Action {
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String strNum = request.getParameter("num");
		String title = request.getParameter("title");
		String author = request.getParameter("author");				
		String email = request.getParameter("email");				
		String content = request.getParameter("content");
		String password = request.getParameter("password");
		
		try{
			if(strNum == null || strNum.trim().length() == 0 ||
					title == null || title.trim().length() == 0 ||
					author == null || author.trim().length() == 0 ||
					email == null || email.trim().length() == 0 ||
					content == null || content.trim().length() == 0 ||
					password == null || password.trim().length() == 0 ){
				throw new Exception("입력값이 충분하지 않습니다.");
			}
			
			int num = Integer.parseInt(strNum);
			GuestBook gBook = GuestBookDAO.getContent(num);
			
			if (gBook == null || !gBook.getPassword().equals(password)) {
				throw new Exception("이미 삭제된 게시물이거나, 비밀번호가 올바르지 않습니다.");
			}
			
			gBook.setAuthor(author);
			gBook.setTitle(title);
			gBook.setEmail(email);
			gBook.setContent(content);
			
			boolean result = GuestBookDAO.updateContent(gBook);
			
			if(result){
				response.sendRedirect("board?command=view&num=" + num);
			}else{
				throw new Exception("게시물이 존재하지 않거나, 비밀번호가 올바르지 않습니다.");
			}
		}catch (SQLException e) {
			request.setAttribute("errorMsg", e.getMessage());
			request.getRequestDispatcher("error.jsp").forward(request, response);
		}catch (Exception e) {
			request.setAttribute("errorMsg", e.getMessage());
			request.getRequestDispatcher("error.jsp").forward(request, response);
		}
	}
}
