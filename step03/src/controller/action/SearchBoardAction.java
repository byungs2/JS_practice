package controller.action;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.entity.DictionaryDAO;

public class SearchBoardAction implements Action {

	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (request.getParameter("data").matches(".*[ㄱ-ㅎㅏ-ㅣ가-힣]+.*")) { //입력받는 검색어가 한글인지 아닌지 확인.
			request.setAttribute("lanType", 1); //한글이면 1
		} else {
			request.setAttribute("lanType", 2); //영어이면 2
		}
		request.setAttribute("words", DictionaryDAO.getLikeList(request.getParameter("data")));
		request.getRequestDispatcher("list.jsp").forward(request, response);
//		System.out.println(request.getParameter("data"));
	}
}
