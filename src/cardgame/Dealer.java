package cardgame;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Dealer {
	List<Card> currentDeck;
	List<Card> dealerhand = new ArrayList<>();
	List<Card> playerhand = new ArrayList<>();
	int dealertotal = 0;
	
	public List<Card> initialDeal(List<Card> deck) {
		currentDeck = deck;
		Collections.shuffle(deck);
		for (int i = 0; i < 1; i++) {
			playerhand.add(deck.get(i));
			deck.remove(i);
			dealerhand.add(deck.get(i + 1));
			deck.remove(i+1);
		}
		return playerhand;
	}
	
	public List<Card> getCurrentDeck() {
		return currentDeck;
	}

	public void setCurrentDeck(List<Card> currentDeck) {
		this.currentDeck = currentDeck;
	}

	public List<Card> getPlayerhand() {
		return playerhand;
	}

	public void setPlayerhand(List<Card> playerhand) {
		this.playerhand = playerhand;
	}

	public void showinitialHand(List<Card> dealerhand) {
		System.out.println("Dealer has: " + dealerhand.get(0));
		System.out.println();
	}
	
	public List<Card> dealPlayer(List<Card> deck){
		playerhand.add(currentDeck.get(0));
		currentDeck.remove(0);
		return playerhand;
	}
	
	public List<Card> dealSelf(List<Card> deck) {
		dealerhand.add(currentDeck.get(0));
		currentDeck.remove(0);
		return dealerhand;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Dealer [currentDeck=");
		builder.append(currentDeck);
		builder.append(", dealerhand=");
		builder.append(dealerhand);
		builder.append(", playerhand=");
		builder.append(playerhand);
		builder.append(", dealertotal=");
		builder.append(dealertotal);
		builder.append("]");
		return builder.toString();
	}
	
	
	public List<Card> getDealerhand() {
		return dealerhand;
	}
	public void setDealerhand(List<Card> dealerhand) {
		this.dealerhand = dealerhand;
	}
	public int getDealertotal() {
		return dealertotal;
	}
	public void setDealertotal(int dealertotal) {
		this.dealertotal = dealertotal;
	}
	
	
}

