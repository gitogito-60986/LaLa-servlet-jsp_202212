package servlet;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Divination;

@WebServlet("/SampleServlet")
public class SampleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		// 運勢をランダムで決定
	    String[] luckArray = { "超スッキリ", "モヤっと", "最悪" };
	    int index = (int) (Math.random() * 3);
	    String luck = luckArray[index];
//	    divination.setDivResult(luck);

	    // 実行日を取得
	    Date date = new Date();
	    SimpleDateFormat sdf = new SimpleDateFormat("MM月dd日");
	    String today = sdf.format(date);
//	    divination.setToday(today);


		// 占いクラス(Divination)を生成
		Divination divination = new Divination(today, luck);		
	    
//	    request.setAttribute("luck", luck);
//	    request.setAttribute("today", today);
	    request.setAttribute("divination", divination);
	    
	    String url = "/WEB-INF/jsp/today.jsp";
	    RequestDispatcher dispatcher = request.getRequestDispatcher(url);
	    dispatcher.forward(request, response);

	}

}
