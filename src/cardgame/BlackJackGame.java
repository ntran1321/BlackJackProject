package cardgame;

import java.util.List;
import java.util.Scanner;

public class BlackJackGame {

	public static void main(String[] args) {
		BlackJackGame start = new BlackJackGame();
		start.Game();
	}

	public void Game() {
		Player player = new Player();
		Dealer dealer = new Dealer();
		PlayerMoves playermove = new PlayerMoves();
		int turn = 0;

		Deck deck = new Deck();
		List<Card> cards = deck.createDeck();

		int dealertotal = 0;
		int playertotal = 0;

		// start game
		System.out.println("Welcome to Black Jack.");
		System.out.println("The dealer will now shuffle and deal.");
		dealer.initialDeal(cards);
		turn++;

		// dealer shows one card
		player.setPlayerhand(dealer.initialDeal(cards));

		// show player cards
		dealer.showinitialHand(cards);
		System.out.println("You have: ");
		System.out.println(player.getPlayerhand());

		// calculate hand totals
		dealertotal = calcHandValue(dealer.getDealerhand());
		playertotal = calcHandValue(player.getPlayerhand());

		// initial check for blackjack
		boolean keepGoing = true;
		keepGoing = checkInitialBlackJack(dealertotal, playertotal);

		// games goes on until player decides hit or stay
		// then dealer stays or deals self
		while (keepGoing) {

			// player decides to hit or stay
			String move = playermove.playerHitOrStay(cards, playertotal, turn);
			if (move.equals("HIT")) {
				turn++;
				dealer.dealPlayer(cards);
				System.out.println("You have: ");
				System.out.println(player.getPlayerhand());
				playertotal = calcHandValue(player.getPlayerhand());
				System.err.println("Your total is: " + playertotal);
				if (playertotal > 21) {
					System.out.println("Bust");
					break;
				}

			} else {
				System.out.println("Dealer's turn.");
				dealertotal = calcHandValue(dealer.getDealerhand());
				while (dealertotal < 17) {
					System.out.println("Dealer is now dealing self...");
					dealer.dealSelf(cards);
					dealertotal = calcHandValue(dealer.getDealerhand());
				}
				checkForWinLose(dealer.getDealerhand(), player.getPlayerhand(), dealertotal, playertotal);
				keepGoing = false;
			}
		}
		System.out.println("Dealer hand is " + dealer.getDealerhand());
		System.out.println();
		System.out.println();
		System.out.print("Would you like to play again? (Y/N) ");
		Scanner kb = new Scanner(System.in);
		String input = kb.next();
		if (input.toUpperCase().equals("Y")) {
			System.out.println();
			System.out.println();
			Game();
		}
		kb.close();
	}

	// check if there are any aces

	public int calcHandValue(List<Card> hand) {
		int handtotal = 0;
		for (Card card : hand) {
			handtotal = handtotal + card.getRank().getCardValue();
		}

		if (handtotal > 21) {
			for (int i = 0; i < hand.size(); i++) {
				if (handtotal > 21 && hand.get(i).getRank().equals(Rank.ACE)) {
					handtotal = handtotal - 10;
				}
			}
		}
		return handtotal;
	}

	// check for initial blackjack
	public boolean checkInitialBlackJack(int dealertotal, int playertotal) {
		if (playertotal == 21) {
			if (dealertotal == 21) {
				System.out.println("Push.");
				return false;
			} else {
				System.out.println("Congrats, you got a blackjack");
				return false;
			}
		}
		else if (dealertotal == 21) {
			System.out.println("Dealer has blackjack, you lose.");
			return false;
		}
		return true;
	}

	//check for wins or loss after each deal
	public void checkForWinLose(List<Card> dealerhand, List<Card> playerhand, int dealertotal, int playertotal) {
		// System.out.println("Dealer: " + dealertotal);
		// System.out.println("Player: " + playertotal);
		if (playertotal == 21 && dealertotal == 21) {
			System.out.println("Push.");
		} else if (playertotal == 21 && dealertotal != 21) {
			System.out.println("Dealer has " + dealerhand);
			System.out.println("Congrats, you got Blackjack!");
		} else if (playertotal != 21 && dealertotal == 21) {
			System.out.println("Dealer has blackjack!");
			System.out.println(dealerhand);
		} else if (playertotal > 21) {
			System.out.println("Bust");
			System.out.println(dealerhand);
		} else if (dealertotal > 21) {
			System.out.println("Dealer Bust");
			System.out.println(dealerhand);
		} else if (dealertotal == playertotal) {
			System.out.println("Dealer total: " + dealertotal);
			System.out.println("Player total: " + playertotal);
			System.out.println("Push.");
		} else if (playertotal < dealertotal && dealertotal < 21 && playertotal != dealertotal) {
			System.out.println("You lose.");
		} else if (playertotal > dealertotal && playertotal < 21) {
			System.out.println("You win.");
		} 
	}
}
