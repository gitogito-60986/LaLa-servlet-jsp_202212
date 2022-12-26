package servlet;

import java.io.IOException;
import java.util.Random;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ex62")
public class Ex6_2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		Integer randomNum = new Random().nextInt(10);
		System.out.println(randomNum);
		
		request.setAttribute("randomNum", randomNum);
		
		if(randomNum % 2 == 0) {
		    RequestDispatcher dispatcher =
			        request.getRequestDispatcher("/WEB-INF/jsp/forward.jsp");
			dispatcher.forward(request, response);
		} else {
			response.sendRedirect("/mvc/redirect.jsp");
		}
		
	}
}
