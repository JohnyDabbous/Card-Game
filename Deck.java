import java.util.LinkedList;
import java.util.Random;
public class Deck{
    public LinkedList<Card> m_cards;
    /**
     * Default constructor initializing a deck to 52 cards
     */
    public Deck(){
        m_cards = new LinkedList<>();
        for(int i = 0; i <= 3; ++i){
            for(int j = 2; j <= 14; ++j){
                Card newCard = new Card(j, i);
                m_cards.add(newCard);
            }
        }
    }
    /**
     * Copy constructor which creates the same deck as the one you input
     * @param deckToCopy
     */
    public Deck(Deck deckToCopy){
        m_cards = new LinkedList<>();
        for (Card card: deckToCopy.m_cards){ // done to access the member variable allowing us to iterate over the deck object as a list
            m_cards.add(card);

        }
    }
    /**
     * Calls upon the toString in Card for each card object in the deck
     */
    public String toString(){
        String s = "";
        for (Card card: m_cards){
            s += card.toString();
        }
        return s;

    }
    /**
     * Returns the amount of cards in a deck
     */
    public int size(){
        int size = 0;
        for (Card card: m_cards){
            size += 1;
        }
        return size;
    }
    /**
     * Takes out a card and returns its value
     */
    public Card deal(){
        Random randNumGenerator = new Random();
        int randNum = randNumGenerator.nextInt(m_cards.size());
        return m_cards.remove(randNum);
    }
    
}