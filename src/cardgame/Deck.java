package cardgame;

import java.util.ArrayList;
import java.util.List;

public class Deck {
	
	public List<Card> createDeck() {
		
		List<Card> deck = new ArrayList<>();
		for (Rank r: Rank.values()) {
			for (Suit s: Suit.values()) {
				deck.add(new Card(r,s));
			}
		}
		
		return deck;
	}
	
	
	

}
