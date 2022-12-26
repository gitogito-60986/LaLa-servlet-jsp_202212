package servlet;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Dragon;
import model.Hero;

@WebServlet("/game")
public class GameServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String heroName1 = "ミナト";
		int heroHp1 = 50;
		int heroAttackHp1 = 50;
		int heroCrHitRate1 = 30;
		int heroMp1 = 15;
		Hero hero = new Hero(heroName1, heroHp1, heroAttackHp1, heroCrHitRate1, heroMp1);

		String monsterType1 = "ドラゴン";
		int dragonHp1 = 60;
		int dragonAttackHp1 = 50;
		int dragonCrHitRate1 = 30;
		int breathStock1 = 20;
		Dragon dragon = new Dragon(monsterType1, dragonHp1, dragonAttackHp1, dragonCrHitRate1, breathStock1);
				
		ServletContext application = this.getServletContext();
		application.setAttribute("hero", hero);
		application.setAttribute("dragon", dragon);
		
		String url = "/WEB-INF/jsp/game.jsp";
		request.getRequestDispatcher(url).forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getParameter("action");
		if(action == null || action.length() == 0) {
			;
		} else if(action.equals("attack")) {
			ServletContext application = this.getServletContext();
			Hero hero = (Hero)application.getAttribute("hero");
			Dragon dragon = (Dragon)application.getAttribute("dragon");
			
			String heroAttack = hero.attack(dragon);
			request.setAttribute("heroAttack", heroAttack);
			String dragonAttack = dragon.attack(hero);
			request.setAttribute("dragonAttack", dragonAttack);
		} else {
			;
		}
		


		String url = "/WEB-INF/jsp/game.jsp";
		request.getRequestDispatcher(url).forward(request, response);
	}

}
