package cardgame;

import java.util.List;
import java.util.Scanner;

public class PlayerMoves extends Player {
	Scanner kb = new Scanner(System.in);
	
	public String playerHitOrStay(List<Card> playerhand, int playertotal, int turn){
		String input = null;
		System.out.print("Would you like to HIT or STAY: ");
		input = kb.next();
			if (input.toUpperCase().equals("HIT")) {
				turn++;
				return "HIT";
			} else {
				return "STAY";
			}
	}
}
