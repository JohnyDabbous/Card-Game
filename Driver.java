import java.util.LinkedList;
import java.util.ArrayList;
import java.util.Random;

public class Driver{

    public static void main(String[] args){
        Game game = new Game(3);
        System.out.println(game.getPlayers());
        System.out.println(game.play());

    }
}