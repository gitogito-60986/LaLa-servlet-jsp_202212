package ex5;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Ex5_1")
public class Exercise1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	    // リクエストパラメータを取得
	    request.setCharacterEncoding("UTF-8");
	    String name = request.getParameter("name");
	    
	    // 表示するメッセージを設定
	    String msg = name + "さんを登録しました";

	    // HTMLを出力
	    response.setContentType("text/html; charset=UTF-8");
	    PrintWriter out = response.getWriter();
	    out.println("<!DOCTYPE html >");
	    out.println("<html>");
	    out.println("<head>");
	    out.println("<meta charset=\"UTF-8\">");
	    out.println("<title>ユーザー登録結果</title>");
	    out.println("</head>");
	    out.println("<body>");
	    out.println("<p>" + msg + "</p>");
	    out.println("</body>");
	    out.println("</html>");
	}

}
