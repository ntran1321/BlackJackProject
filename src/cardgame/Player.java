package cardgame;

import java.util.ArrayList;
import java.util.List;

public class Player {
	List<Card> playerhand = new ArrayList<>();
	int playertotal = 0;
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Player [playerhand=");
		builder.append(playerhand);
		builder.append(", playertotal=");
		builder.append(playertotal);
		builder.append("]");
		return builder.toString();
	}
	public List<Card> getPlayerhand() {
		return playerhand;
	}
	public void setPlayerhand(List<Card> playerhand) {
		this.playerhand = playerhand;
	}
	public int getPlayertotal() {
		return playertotal;
	}
	public void setPlayertotal(int playertotal) {
		this.playertotal = playertotal;
	}
	
}
