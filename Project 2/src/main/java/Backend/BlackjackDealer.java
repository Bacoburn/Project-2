package Backend;
import java.util.ArrayList;
import java.util.Collections;
public class BlackjackDealer {
    public ArrayList<Card> deck;

    public void generateDeck() {
        deck = new ArrayList<>();
        String[] suits = {"Hearts", "Diamonds", "Clubs", "Spades"};

        for (String suit : suits) {
            for (int value = 1; value <= 13; value++) {
                deck.add(new Card(suit, value));
            }
        }
    }

    public ArrayList<Card> dealHand() {
        ArrayList<Card> hand = new ArrayList<>();
        hand.add(drawOne());
        hand.add(drawOne());
        return hand;
    }

    public Card drawOne() {
        return deck.remove(0);
    }

    public void shuffleDeck() {
        Collections.shuffle(deck);
    }

    public int deckSize() {
        return deck.size();
    }
}
