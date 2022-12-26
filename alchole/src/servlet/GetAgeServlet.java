package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.GetAgeLogic;
import model.User;

@WebServlet("/ask")
public class GetAgeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	  protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			  throws ServletException, IOException {
		    // フォワード先
		    String forwardPath = "あああああ";

		    // リクエストパラメータからユーザー情報を取得
		    HttpSession session = request.getSession();
		    User user = (User) session.getAttribute("user");
		    
		    // 年齢認証の結果を格納する文字列変数を定義
		    String msg = "";

		    // サーブレットのWebアノテーションをリクエストされたときの処理
		    if (user == null) {
				// ユーザー情報がnullの場合のフォワード先（フォーム入力画面）を設定
				forwardPath = "/WEB-INF/jsp/question.jsp";
		    } else {
			    // 年齢認証処理の呼び出し
			    if(GetAgeLogic.execute(user)) {
			    	msg = user.getName() + "さん、飲み過ぎに注意しましょう";
			    } else {
			    	msg = user.getName() + "はお酒を飲めません";
			    }

			    // 不要となったセッションスコープ内のインスタンスを削除
			    session.removeAttribute("user");
	
			    // 年齢認証の結果をリクエストスコープへ格納
			    request.setAttribute("msg", msg);
			      
			    // 年齢認証の結果画面をフォワード先として設定
			    forwardPath = "/WEB-INF/jsp/result.jsp";
		    }

		    // 設定されたフォワード先にフォワード
		    RequestDispatcher dispatcher = request.getRequestDispatcher(forwardPath);
		    dispatcher.forward(request, response);
	  }
	  
	  protected void doPost(HttpServletRequest request, HttpServletResponse response)
		      throws ServletException, IOException {

		    // リクエストパラメータの取得
		    request.setCharacterEncoding("UTF-8");
		    String name = request.getParameter("name");
		    int age = Integer.parseInt(request.getParameter("age"));

		    // 年齢認証するユーザーの情報を設定
		    User user = new User(name, age);

		    // セッションスコープにユーザー情報を保存
		    HttpSession session = request.getSession();
		    session.setAttribute("user", user);

		    // リダイレクト: 開始URLへget通信でアクセス
		    String redirectPath = "/alchole/ask";
		    response.sendRedirect(redirectPath);
	  }
	
}
