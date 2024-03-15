import Backend.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

public class BlackjackTest {
	private BlackjackDealer dealer;
	private BlackjackGame game;
	private BlackjackGameLogic gameLogic;


	@BeforeEach
	public void setUp() {
		dealer = new BlackjackDealer();
		game = new BlackjackGame();
		gameLogic = new BlackjackGameLogic();
	}

	// Test cases for BlackjackDealer class
	@Test
	public void testGenerateDeck() {
		dealer.generateDeck();
		assertEquals(52, dealer.deckSize());
	}

	@Test
	public void testDealHand() {
		dealer.generateDeck();
		ArrayList<Card> hand = dealer.dealHand();
		assertEquals(2, hand.size());
	}

	@Test
	public void testShuffleDeck() {
		dealer.generateDeck();
		ArrayList<Card> originalDeck = new ArrayList<>(dealer.deck);
		dealer.shuffleDeck();
		assertNotEquals(originalDeck, dealer.deck);
	}
/*
	// Test cases for BlackjackGame class
	@Test
	public void testEvaluateWinningsWithZeroBet() {
		game.currentBet = 0;
		double initialWinnings = game.totalWinnings;
		game.evaluateWinnings();
		assertEquals(initialWinnings, game.totalWinnings);
	}

	@Test
	public void testEvaluateWinningsWithPositiveBet() {
		game.currentBet = 10;
		game.totalWinnings = 50;
		game.evaluateWinnings();
		assertEquals(60, game.totalWinnings);
	}

	@Test
	public void testEvaluateWinningsWithNegativeBet() {
		ArrayList<Card> playerHand = new ArrayList<>();
		ArrayList<Card> dealerHand = new ArrayList<>();
		game.currentBet = 10;
		game.totalWinnings = 50;
		game.evaluateWinnings();
		playerHand.add(new Card("Hearts", 10)); // Total: 10
		playerHand.add(new Card("Diamonds", 10)); // Total: 20
		dealerHand.add(new Card("Clubs", 10)); // Total: 10
		dealerHand.add(new Card("Spades", 5)); // Total: 15
		assertEquals(40, game.totalWinnings);
	} */

	// Test cases for BlackjackGameLogic class
	@Test
	public void testWhoWonWithEmptyHands() {
		ArrayList<Card> playerHand = new ArrayList<>();
		ArrayList<Card> dealerHand = new ArrayList<>();
		assertEquals("push", gameLogic.whoWon(playerHand, dealerHand));
	}

	@Test
	public void testWhoWonWithBustedHand() {
		ArrayList<Card> playerHand = new ArrayList<>();
		ArrayList<Card> dealerHand = new ArrayList<>();
		playerHand.add(new Card("Hearts", 10)); // Total: 10
		playerHand.add(new Card("Diamonds", 10)); // Total: 20
		dealerHand.add(new Card("Clubs", 10)); // Total: 10
		dealerHand.add(new Card("Spades", 10)); // Total: 20
		dealerHand.add(new Card("Hearts", 5)); // Total: 25 (busted)
		assertEquals("player", gameLogic.whoWon(playerHand, dealerHand));
	}

	@Test
	public void testWhoWonWithPlayerWin() {
		ArrayList<Card> playerHand = new ArrayList<>();
		ArrayList<Card> dealerHand = new ArrayList<>();
		playerHand.add(new Card("Hearts", 10)); // Total: 10
		playerHand.add(new Card("Diamonds", 10)); // Total: 20
		dealerHand.add(new Card("Clubs", 10)); // Total: 10
		dealerHand.add(new Card("Spades", 5)); // Total: 15
		assertEquals("player", gameLogic.whoWon(playerHand, dealerHand));
	}

	@Test
	public void testWhoWonWithDealerWin() {
		ArrayList<Card> playerHand = new ArrayList<>();
		ArrayList<Card> dealerHand = new ArrayList<>();
		playerHand.add(new Card("Hearts", 10)); // Total: 10
		playerHand.add(new Card("Diamonds", 5)); // Total: 15
		dealerHand.add(new Card("Clubs", 10)); // Total: 10
		dealerHand.add(new Card("Spades", 10)); // Total: 20
		assertEquals("dealer", gameLogic.whoWon(playerHand, dealerHand));
	}

	@Test
	public void testWhoWonWithPush() {
		ArrayList<Card> playerHand = new ArrayList<>();
		ArrayList<Card> dealerHand = new ArrayList<>();
		playerHand.add(new Card("Hearts", 10)); // Total: 10
		playerHand.add(new Card("Diamonds", 5)); // Total: 15
		dealerHand.add(new Card("Clubs", 10)); // Total: 10
		dealerHand.add(new Card("Spades", 6)); // Total: 16
		assertEquals("dealer", gameLogic.whoWon(playerHand, dealerHand));
	}

	@Test
	public void testHandTotalWithAces() {
		ArrayList<Card> hand = new ArrayList<>();
		hand.add(new Card("Hearts", 1)); // Ace worth 11
		hand.add(new Card("Diamonds", 5)); // Total: 16
		assertEquals(16, gameLogic.handTotal(hand));
	}

	@Test
	public void testHandTotalWithBustedAces() {
		ArrayList<Card> hand = new ArrayList<>();
		hand.add(new Card("Hearts", 1)); // Ace worth 11
		hand.add(new Card("Diamonds", 10)); // Total: 21
		hand.add(new Card("Clubs", 10)); // Total: 31 (busted)
		assertEquals(21, gameLogic.handTotal(hand));
	}
}
