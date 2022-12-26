package ex5;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Ex5_2")
public class Exercise2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	    // リクエストパラメータを取得
	    request.setCharacterEncoding("UTF-8");
	    String name = request.getParameter("name");
	    
	    String[] qtypeList = {"会社について", "製品について", "アフターサポートについて"};
	    String strQtype = request.getParameter("qtype");
	    int numQtype = Integer.parseInt(strQtype);
	    String qtype = qtypeList[numQtype];
	    
	    String body = request.getParameter("body");
	    
	    // 表示するメッセージを設定
	    String msg = name + "さんのお問い合わせ内容";

	    // HTMLを出力
	    response.setContentType("text/html; charset=UTF-8");
	    PrintWriter out = response.getWriter();
	    out.println("<!DOCTYPE html >");
	    out.println("<html>");
	    out.println("<head>");
	    out.println("<meta charset=\"UTF-8\">");
	    out.println("<title>ユーザーお問い合わせ状況</title>");
	    out.println("</head>");
	    out.println("<body>");
	    out.println("<p>" + msg + "</p>");
	    out.println("<p>お問い合わせカテゴリー:<br>" + qtype + "</p>");
	    out.println("<p>お問い合わせ内容:<br>" + body + "</p>");
	    out.println("</body>");
	    out.println("</html>");
	}

}
