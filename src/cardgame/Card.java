package cardgame;

public class Card {

	private Rank rank;
	private Suit suit;
	
	
	public Card(Rank r, Suit s) {
		super();
		rank = r;
		suit = s;
	}

	public Rank getRank() {
		return rank;
	}

	public void setRank(Rank rank) {
		this.rank = rank;
	}

	public Suit getSuit() {
		return suit;
	}

	public void setSuit(Suit suit) {
		this.suit = suit;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
//		builder.append("Card [rank=");
		builder.append(rank);
		builder.append(" of ");
		builder.append(suit);
//		builder.append("]");
		return builder.toString();
	}




}