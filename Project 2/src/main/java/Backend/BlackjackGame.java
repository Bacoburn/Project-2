package Backend;
import java.util.ArrayList;
public class BlackjackGame {
    ArrayList<Card> playerHand;
    ArrayList<Card> bankerHand;
    BlackjackDealer theDealer;
    BlackjackGameLogic gameLogic;
    public double currentBet;
    public double totalWinnings;

    public BlackjackGame() {
        this.gameLogic = new BlackjackGameLogic();
    }
    public void evaluateWinnings() {
        String winner = gameLogic.whoWon(playerHand, bankerHand);
        if (winner.equals("Player")) {
            totalWinnings += currentBet;
        } else if (winner.equals("Dealer")) {
            totalWinnings -= currentBet;
        } else {
            totalWinnings = 0;
        }
    }
}
