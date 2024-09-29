/**
 * @see Card
 * @see Deck
 * @see Dealer
 * the see at tag links java docs together
 * @author Johny Dabbous
 * @version 1.2
 */
public class Card{
    public static final int HEARTS = 0;
    public static final int SPADES = 1;
    public static final int CLUBS = 2;
    public static final int DIAMONDS = 3;
    public static final int JACK = 11;
    public static final int QUEEN = 12;
    public static final int KING = 13;
    public static final int ACE = 14;
    private int m_rank;
    private int m_suit;
    /**
     * Default Constructor
     */
    public Card(){
        m_rank = ACE;
        m_suit = SPADES;
    }
    /**
     * Fully loaded Constructor
   * @param rank
   * @param suit
   */
    public Card(int rank, int suit){
        m_rank = rank;
        m_suit = suit;
    }
    /**
     * @param carToCopy
     */
    public Card(Card cardToCopy){
        this.m_rank = cardToCopy.m_rank;
        this.m_suit = cardToCopy.m_suit;
    }
    /**
     * toString
     * Returns your cards in an organized string
     */
    public String toString(){
        String s = "";
        if (m_suit == 0){
            if(m_rank == 14){
                s += "Ace of Hearts, ";
            }
            else if(m_rank == 13){
                s += "King of Hearts, ";
            }
            else if(m_rank == 12){
                s += "Queen of Hearts, ";
            }
            else if(m_rank == 11){
                s += "Jack of Hearts, ";
            }
            else{
                s += m_rank + " of Hearts, ";
            }
        }
        
        else if(m_suit == 1){
            if(m_rank == 14){
                s += "Ace of Spades, ";
            }
            else if(m_rank == 13){
                s += "King of Spades, ";
            }
            else if(m_rank == 12){
                s += "Queen of Spades, ";
            }
            else if(m_rank == 11){
                s += "Jack of Spades, ";
            }
            else{
                s += m_rank + " of Spades, ";
            }
        }
        else if(m_suit == 2){
            if(m_rank == 14){
                s += "Ace of Clubs, ";
            }
            else if(m_rank == 13){
                s += "King of Clubs, ";
            }
            else if(m_rank == 12){
                s += "Queen of Clubs, ";
            }
            else if(m_rank == 11){
                s += "Jack of Clubs, ";
            }
            else{
                s += m_rank + " of Clubs, ";
            }
        }
        else{
            if(m_rank == ACE){
                s += "Ace of Diamonds, ";
            }
            else if(m_rank == KING){
                s += "King of Diamonds, ";
            }
            else if(m_rank == QUEEN){
                s += "Queen of Diamonds, ";
            }
            else if(m_rank == JACK){
                s += "Jack of Diamonds, ";
            }
            else{
                s += m_rank + " of Diamonds, ";
            }
        }
        return s;
    }
    /**
     * Equals method to check if two cards are equal
     * @param o
     */
    public boolean equals(Object o){
        if (this == o) {return true;}
        if(!(o instanceof Card)) {return false;}
        Card c = (Card) o;
        return this.m_rank == c.m_rank;
    }
    /**
     * Mutator for the rank
     * @param newRank
     */
    public void setRank(int newRank){
        m_rank = newRank;
    }
    /**
     * Mutator for the suit
     * @param newSuit
     */
    public void setSuit(int newSuit){
        m_suit = newSuit;
    }
    /**
     * Accessor of the card's rank
     */
    public int getRank(){
        return m_rank;
    }
    /**
     * Accessor of the card's suit
     */
    public int getSuit(){
        return m_suit;
    }
}