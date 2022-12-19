package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/SampleServlet")
public class SampleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String luck = "超スッキリ";
		
		// SimpleDateFormat と Date を使用したパターン
//		Date date = new Date();
//		SimpleDateFormat sdf = new SimpleDateFormat("MM月dd日");
//		String today = sdf.format(date);
		
		// DateTimeFormatter と LocalDate を使用したパターン
		DateTimeFormatter fmt = DateTimeFormatter.ofPattern("yyyy年MM月dd日");
		LocalDate now = LocalDate.now();
		String strNow = now.format(fmt);
//		System.out.println(strNow);
		
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println("<html><body>");
		out.println("<p>" + strNow + luck + "</p>");
		out.println("</html></body>");
	}
}
