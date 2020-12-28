package todo;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import todo.dao.TodoDao;

/**
 * Servlet implementation class TodoServlet
 */
@WebServlet("/type")
public class TodoTypeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TodoTypeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String idStr = request.getParameter("id");
		String type = request.getParameter("type");
		System.out.println("type) " + idStr + ", " + type);
		long id = Long.parseLong(idStr);
		TodoDao todoDao = new TodoDao();
		int updateCount = todoDao.updateTodo(id, type);
		if (updateCount == 1) {
			response.setStatus(200);
		}
		else {
			response.sendError(400, "해당하는 ID값이 없습니다.");
		}
	}

}
