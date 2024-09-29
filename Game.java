import java.util.LinkedList;
import java.util.ArrayList;
import java.util.Random;
public class Game{

    private LinkedList<Player> players;
    private LinkedList<Card> pile;
    private Dealer dealer;
    private ArrayList<String> patterns;
    private int indexOfCurrentPlayer;

    public Game(){
        indexOfCurrentPlayer = 0;
        Random rndm = new Random();
        patterns = new ArrayList<>();
        players = new LinkedList<>();
        dealer = new Dealer();
        pile = new LinkedList<>();
        int eachPlayerHandSize = 52 / 2;
        for (int i = 1; i < 3; ++i){
            int randInt = rndm.nextInt(3);
            String playerPattern;
            if (randInt == 0){
                playerPattern = "sandwhich";
            }
            else if (randInt == 1){
                playerPattern = "doubles";
            }
            else{
                playerPattern = "top-bottom";
            }
            LinkedList<Card> hand = new LinkedList<>();
            for (int j = 0; j < eachPlayerHandSize; ++j){
                hand.add(dealer.m_deck.deal());
            }
            Player newPlayer = new Player(i, hand, playerPattern);
            players.add(newPlayer);
            patterns.add(playerPattern);
        }

    }

    public Game(int num){
        Random rndm = new Random();
        pile = new LinkedList<>();
        patterns = new ArrayList<>();
        players = new LinkedList<>();
        dealer = new Dealer();
        int eachPlayerHandSize = 52 / num;
        for (int i = 1; i <= num; ++i){
            int randInt = rndm.nextInt(3);
            String playerPattern;
            if (randInt == 0){
                playerPattern = "sandwhich";
            }
            else if (randInt == 1){
                playerPattern = "doubles";
            }
            else{
                playerPattern = "top-bottom";
            }
            LinkedList<Card> hand = new LinkedList<>();
            for (int j = 0; j < eachPlayerHandSize; ++j){
                hand.add(dealer.m_deck.deal());
            }
            Player newPlayer = new Player(i, hand, playerPattern);
            players.add(newPlayer);
            patterns.add(playerPattern);
        }
        if (dealer.size() != 0){
            int randPlayerCard;
            while (dealer.size() != 0){
                randPlayerCard = rndm.nextInt(dealer.size());
                Card tempHolder = dealer.m_deck.m_cards.get(0);
                Player playerWithNewCard = players.get(randPlayerCard);
                playerWithNewCard.hand.add(tempHolder);
                dealer.m_deck.m_cards.remove(tempHolder);
            }
        }
    }

    private boolean checkForFace(Card card){
        int cardRank = card.getRank();
        boolean isFace = false;
        if (cardRank == Card.ACE){
            isFace = true;
        }
        else if (cardRank == card.QUEEN){
            isFace = true;
        }
        else if (cardRank == Card.KING){
            isFace = true;
        }

        else if (cardRank == Card.JACK){
            isFace = true;

        }

        else {
            isFace = false;
        }
        return isFace;

    }
    public LinkedList<Player> getPlayers(){
        return players;
    }

    public LinkedList<Card> getPile(){
        return pile;
    }

    public Dealer getDealer(){
        return dealer;
    }

    public ArrayList<String> getPatterns(){
        return patterns;
    }

    public int play(){
        int gameWinner = 0;
        while (players.size()!= 1){  
            Player currentPlayer = players.getFirst();
            while(players.size() != 1){
                boolean pattern = false;
                while(!pattern){
                    Card playedCard = currentPlayer.playCard();
                    System.out.println("Player #" + currentPlayer.getPlayerNum() + " Played " + playedCard);
                    pile.add(playedCard);
                    System.out.println(pile + "\n");
                    if (checkForFace(playedCard)){
                        switch(playedCard.getRank()){
                            case 11:
                                if(currentPlayer.getHand().isEmpty() == false){
                                    currentPlayer = nextPlayer();
                                    currentPlayer.playCard();
                                    System.out.println(pile + "\n");
                                    break;
                                }

                            case 12:
                                if(currentPlayer.getHand().isEmpty() == false){
                                    currentPlayer.playCard();
                                    System.out.println(pile + "\n");
                                    if(currentPlayer.getHand().isEmpty() == false){
                                        currentPlayer = nextPlayer();
                                        currentPlayer.playCard();
                                        System.out.println(pile + "\n");
                                    }
                                }
                                break;
                            case 13:
                                if(currentPlayer.getHand().isEmpty() == false){
                                    currentPlayer.playCard();
                                    System.out.println(pile + "\n");
                                    if(currentPlayer.getHand().isEmpty() == false){
                                        currentPlayer = nextPlayer();
                                        currentPlayer.playCard();
                                        System.out.println(pile + "\n");
                                    }
                                    if(currentPlayer.getHand().isEmpty() == false){
                                        currentPlayer = nextPlayer();
                                        currentPlayer.playCard();
                                        System.out.println(pile + "\n");
                                    } 
                                }
                                break;

                            case 14:
                                if(currentPlayer.getHand().isEmpty() == false){
                                    currentPlayer.playCard();
                                    System.out.println(pile + "\n");
                                    if(currentPlayer.getHand().isEmpty() == false){
                                        currentPlayer = nextPlayer();
                                        currentPlayer.playCard();
                                        System.out.println(pile + "\n");
                                    }
                                    if(currentPlayer.getHand().isEmpty() == false){
                                        currentPlayer = nextPlayer();
                                        currentPlayer.playCard();
                                        System.out.println(pile + "\n");
                                    }
                                    if(currentPlayer.getHand().isEmpty() == false){
                                        currentPlayer = nextPlayer();
                                        currentPlayer.playCard();
                                        System.out.println(pile + "\n");
                                    } 
                                }
                                break;

                        } 
                    }
                    else {
                        currentPlayer = nextPlayer();
                        break;
                    }
                    pattern = currentPlayer.slaps(pile);
                    if (pattern == true){
                        System.out.println("Player #" + currentPlayer.getPlayerNum() + " slapped. The cards go to him.");
                        currentPlayer.getHand().addAll(pile);
                        pile.clear();
                        currentPlayer = nextPlayer();
                        break;
                    }

                    if(currentPlayer.getHand().size() == 0){
                        System.out.println("Player #" + currentPlayer.getPlayerNum() + " is out of cards and is no longer in the game.");
                        players.remove(currentPlayer);
                        break;
                    }
                    if (players.size() == 1){
                        gameWinner = players.getFirst().getPlayerNum();

                    }  
                }
            }
        } 
        System.out.println("The Number of the player who won is... ");
        return gameWinner = players.getFirst().getPlayerNum();
    }

    public Player nextPlayer() {
        indexOfCurrentPlayer = (indexOfCurrentPlayer + 1) % players.size();
        return players.get(indexOfCurrentPlayer);
    }


    static boolean topBottom(LinkedList<Card> pile){
        for (int i = 0; i < pile.size(); ++i){
            if (pile.get(0) == pile.get(pile.size() - 1)){
                return true;
            } 

        } return false;

    }

    static boolean doubles(LinkedList<Card> pile){
        for (int i = 0; i < pile.size() - 1; ++i){
            if (pile.get(i) == pile.get(i + 1)){
                return true;
            }

        } return false;

    }

    static boolean sandwich(LinkedList<Card> pile){
        for (int i = 0; i < pile.size() - 2; ++i){
            if (pile.get(i) == pile.get(i + 2)){
                return true;

            }

        } return false;

    }

}