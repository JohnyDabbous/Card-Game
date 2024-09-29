import java.util.LinkedList;
import java.util.ArrayList;
import java.util.Random;

public class Player{
    private int playerNum;
    public LinkedList<Card> hand;
    private String pattern;

    public Player(int num, LinkedList<Card> yourHand, String patternOfChoice){
        playerNum = num;
        hand = new LinkedList<>();
        for (Card card: yourHand){
            hand.add(card);
        }
        pattern = patternOfChoice;
    }

    public Card playCard(){
        return hand.remove(0);
    }

    public boolean slaps(LinkedList<Card> pile){
        for (int i = 0; i < pile.size() - 2; ++i){
            if (pile.get(i).equals(pile.get(i + 1)) || pile.get(i).equals(pile.get(i + 2)) || pile.get(0).equals(pile.get(pile.size() - 1))){
                return true;
            }

        } return false;

    }

    public int getPlayerNum(){
        return playerNum;
    }

    public LinkedList<Card> getHand(){
        return hand;
    }

    public String getPattern(){
        return pattern;
    }

    public String toString(){
        String s = "";
        s += "Player: " + playerNum + "\n";
        s += "Pattern: " + pattern + "\n";
        s += "Your Deck: " + "\n";
        for (Card card: hand){
            s += card.toString();
        }
        return s;
    }
    public int size(){
        int i = 0;
        for (Card card: hand){
            i += 1;
        } return i;
    }

}