package com.game.controller;

import java.util.List;

import jakarta.servlet.http.HttpServletRequest;

public class MangathaGame {
	Player player1;
	Player player2;
	
	Deck d;
	public MangathaGame() {
		d = new Deck();
		d.shuffle();
	}
	
	
	public List<List<Card>> split(){
		return d.splitDeckRandomly();
	}
	
	public void Winner(Player p1, Player p2,HttpServletRequest req) {
	    List<List<Card>> splitLists = d.splitDeckRandomly();
	    List<Card> in = splitLists.get(0);
	    List<Card> out = splitLists.get(1);

	    String winnerMessage = "";

	    if ((p1.getposition().equals("IN") && in.contains(p1.getchosenCard())) ||
	    	    (p1.getposition().equals("OUT") && out.contains(p1.getchosenCard()))) {
	    	    winnerMessage = "Winner is player 1";
	    	} else if ((p2.getposition().equals("IN") && in.contains(p2.getchosenCard())) ||
	    	           (p2.getposition().equals("OUT") && out.contains(p2.getchosenCard()))) {
	    	    winnerMessage = "Winner is player 2";
	    	}
	    System.out.println(winnerMessage);
	    req.setAttribute("winnerMessage", winnerMessage);
	}
}
