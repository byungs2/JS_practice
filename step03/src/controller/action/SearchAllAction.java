package controller.action;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.entity.Dictionary;
import model.entity.DictionaryDAO;
public class SearchAllAction implements Action{
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("listall", DictionaryDAO.getList());
		request.getRequestDispatcher("listall.jsp").forward(request, response);
	}
}