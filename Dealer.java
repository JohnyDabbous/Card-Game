import java.util.LinkedList;
import java.util.Random;
public class Dealer{

    public Deck m_deck;
    /**
     * Default constructor which initializes a member variable of the type Deck to a new Deck
     */
    public Dealer(){
        m_deck = new Deck();
    }
    /**
     * Returns a linked list of cards that were dealt from the dealers deck
     * @param n
     */
    public LinkedList<Card> deals(int n){
        LinkedList<Card> randList = new LinkedList<>();
        int i = 0;
        while (i < n){
            randList.add(m_deck.deal());
            ++i;
        }
        return randList;
    }
    
    /**
     * Returns the amount of cards left in a deck
     */
    public int size(){
        int size = 0;
        for (Card card: m_deck.m_cards){ // done to access the member variables of the m_deck as an array
            size += 1;
        }
        return size;
    }
    /**
     * Calls upon the toString method of Cards for each card object in the deck
     */
    public String toString(){
        String s = "";
        for (Card card: m_deck.m_cards){
            s += card.toString();
        }
        return s;
    }

}