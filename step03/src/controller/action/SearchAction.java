package controller.action;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.entity.Dictionary;
import model.entity.DictionaryDAO;
public class SearchAction implements Action{
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("entity",DictionaryDAO.getEntity(request.getParameter("search")));
		System.out.println(request.getParameter("search"));
		System.out.println(request.getAttribute("entity"));
		request.getRequestDispatcher("searchView.jsp").forward(request, response);
	}
}