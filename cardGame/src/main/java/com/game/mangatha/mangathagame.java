package com.game.mangatha;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.WebContext;
import org.thymeleaf.templatemode.TemplateMode;
import org.thymeleaf.templateresolver.WebApplicationTemplateResolver;
import org.thymeleaf.web.IWebExchange;
import org.thymeleaf.web.servlet.JakartaServletWebApplication;

import com.game.controller.Card;
import com.game.controller.Deck;
import com.game.controller.MangathaGame;
import com.game.controller.Player;
import com.learning.hello.contoller.OdometerController;

@WebServlet("/mangathaGame")
public class mangathagame extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	  
	  private JakartaServletWebApplication application;
	  private TemplateEngine templateEngine;
	  
	  private Player player1;
	  private Player player2;
	  private MangathaGame maG;
	  
	  @Override
	  public void init(ServletConfig config) throws ServletException {
	    super.init(config);
	
//	    odc = new OdometerController(5);
//	    odc.reset();
	    application = JakartaServletWebApplication.buildApplication(getServletContext());
	    final WebApplicationTemplateResolver templateResolver = 
	        new WebApplicationTemplateResolver(application);
	    templateResolver.setTemplateMode(TemplateMode.HTML);
	    templateResolver.setPrefix("/WEB-INF/templates/");
	    templateResolver.setSuffix(".html");
	    templateEngine = new TemplateEngine();
	    templateEngine.setTemplateResolver(templateResolver);
	  }
	  
	  @Override
	  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//
		  String player1name = req.getParameter("player1name");
		  String bet1val = req.getParameter("bet1val");
		  String p1choosecard = req.getParameter("p1choosecard");
		  String p1position = req.getParameter("p1position");
		  
		  String player2name = req.getParameter("player2name");
		  String bet2val = req.getParameter("bet2val");
		  String p2choosecard = req.getParameter("p2choosecard");
		  String p2position = req.getParameter("p2position");
		  
		  req.setAttribute("player1name", player1name);
		  req.setAttribute("bet1val", bet1val);
		  req.setAttribute("p1choosecard", p1choosecard);
		  req.setAttribute("p1position", p1position);
		  
		  req.setAttribute("player2name", player2name);
		  req.setAttribute("bet2val", bet2val);
		  req.setAttribute("p2choosecard", p2choosecard);
		  req.setAttribute("p2position", p2position);
		  
		  
		  player1 = new Player(player1name, bet1val, p1position, p1choosecard);
		  player2 = new Player(player2name, bet2val, p2position, p2choosecard);
		  
		  maG = new MangathaGame();
		  
		  maG.Winner(player1, player2,req);
		  
		  List<List<Card>> listOfListOfCards = maG.split();
		  
		  var out = resp.getWriter();
	      final IWebExchange webExchange = this.application.buildExchange(req, resp);
	      final WebContext ctx = new WebContext(webExchange);
	      
//	      req.setAttribute("listOfListOfCards", listOfListOfCards);
	      
	      

//	      if ("playername".equals(playerName)) {
//	    	  req.setAttribute("playername", p1.name  );
//	      } 
	      
	      
//	      ctx.setVariable("increment", odc.nextReading().getReading());
//	      ctx.setVariable("decrement", odc.prevReading().getReading());
//	      ctx.setVariable("current", odc.getReading());
	      
	      req.setAttribute("winnerMessage", req.getAttribute("winnerMessage"));
	      templateEngine.process("mangathaGame", ctx, out);
	     
	  }
	  
	  
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        final IWebExchange webExchange = this.application.buildExchange(req, resp);
        final WebContext ctx = new WebContext(webExchange);
        templateEngine.process("mangathaGame", ctx, resp.getWriter());
      }

}
