package Backend;
import java.util.ArrayList;
public class BlackjackGameLogic {
    public String whoWon(ArrayList<Card> playerHand1, ArrayList<Card> dealerHand) {
        int plTotal = handTotal(playerHand1);
        int dTotal = handTotal(dealerHand);

        if (plTotal > 21) {
            return "dealer";
        } else if (dTotal > 21) {
            return "player";
        } else if (plTotal > dTotal) {
            return "player";
        } else if (dTotal > plTotal) {
            return "dealer";
        } else {
            return "push";
        }
    }

    public int handTotal(ArrayList<Card> hand) {
        int total = 0;
        int numAces = 0;

        for (Card card : hand) {
            if (card.value == 1) {
                numAces++;
                total += 11; // Assume ace as 11
            } else if (card.value > 10) {
                total += 10; // Face cards are worth 10
            } else {
                total += card.value;
            }
        }

        // Adjust ace values if needed
        while (total > 21 && numAces > 0) {
            total -= 10; 
            numAces--;
        }

        return total;
    }

    public boolean evaluateBankerDraw(ArrayList<Card> hand) {
        return handTotal(hand) <= 16;
    }
}
