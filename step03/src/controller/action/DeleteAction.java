package controller.action;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.entity.Dictionary;
import model.entity.DictionaryDAO;
public class DeleteAction implements Action{
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			boolean result = DictionaryDAO.delete(Dictionary.builder().kor(request.getParameter("kor")).en(request.getParameter("eng")).build());
			
			if (result) {
				response.sendRedirect("controller?command=getall");
			} else {
				throw new Exception("삭제 오류");
			}
		} catch (Exception e) {
			request.setAttribute("errorMsg", e.getMessage());
			request.getRequestDispatcher("error.jsp").forward(request, response);
		}
	}
}