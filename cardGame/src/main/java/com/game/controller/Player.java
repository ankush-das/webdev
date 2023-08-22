package com.game.controller;

public class Player {
	
	 private String name;
	    private String bet;
	    private String position;
	    private String chosenCard;

	    public Player(String name, String bet, String position, String chosenCard) {
	        this.name = name;
	        this.bet = bet;
	        this.position = position;
	        this.chosenCard = chosenCard;
	    }
	    
	    public String getName() {
	    	return name;
	    }
	
	public String getBet() {
		return bet;
	}
	
	public String getposition() {
		return position;
	}
	
	public String getchosenCard() {
		return chosenCard;
	}

}
