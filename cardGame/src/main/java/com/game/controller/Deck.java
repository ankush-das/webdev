package com.game.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Deck {
	
	private List<Card> cards;
	
	public Deck() {
		cards = new ArrayList<>();
		for (int rank = Card.MIN_RANK; rank <= Card.MAX_RANK; rank++)
			for (int suit = Card.MIN_SUIT; suit <= Card.MAX_SUIT; suit++)
				cards.add(new Card(rank, suit));
	}
	
	public Card removeFromTop() {
		if (cards.isEmpty()) {
			System.out.println("No more cards left!");
			return null;
		}
		return cards.remove(0);
	}
	
//	public void addToTop(Card c) {
//		cards.add(0, c);
//	}
	
	public void shuffle() {
		Collections.shuffle(cards);
	}
	
	 public List<List<Card>> splitDeckRandomly() {
	        List<Card> copyOfCards = new ArrayList<>(cards); // Create a copy to avoid modifying the original list
	        Collections.shuffle(copyOfCards, new Random()); // Shuffle the copied list randomly

	        int splitIndex = copyOfCards.size() / 2;

	        List<Card> firstHalf = copyOfCards.subList(0, splitIndex);
	        List<Card> secondHalf = copyOfCards.subList(splitIndex, copyOfCards.size());

	        List<List<Card>> splitDecks = new ArrayList<>();
	        splitDecks.add(firstHalf);
	        splitDecks.add(secondHalf);

	        return splitDecks;
	    }

	
	@Override
	public String toString() {
		return cards.toString();
	}

}
