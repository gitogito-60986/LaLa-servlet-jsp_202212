package servlet.find;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Employee;
import model.logic.GetEmpListLogic;

@WebServlet("/list")
public class GetEmpListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		GetEmpListLogic logic = new GetEmpListLogic();
		List<Employee> empList = logic.execute();
		
		request.setAttribute("empList", empList);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/find/empList.jsp");
		dispatcher.forward(request, response);
	}

}
