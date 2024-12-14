package pokerController;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Game {
        private Player[] players; //Players names and stacks
        private int gameSpeed;
        private Deck deck ;
        private int defaultStack;
        private int dealerPos;


        public Game(String[] players, int gameSpeed, int defaultStack) {
            this.players = new Player[players.length];
            for(int i=0; i< players.length; i++) {
                this.players[i] = new Player(players[i], new ArrayList<Card>(), defaultStack);
            }
            this.gameSpeed = gameSpeed;
            this.deck = deck;
            this.defaultStack = defaultStack;
            this.dealerPos = 0;
        }


    private void turn() throws FileNotFoundException, IOException{
        int pot = 0;
        Integer[] putMoney = new Integer[players.length];
        this.deck = new Deck(true);
        //Distribution des cartes
        for (int idx = 0; idx < players.size(); idx++) {

            playersCards[idx][0] = this.deck.getFirst();
            this.deck.removeFirst();
            playersCards[idx][1] = this.deck.getFirst();
            this.deck.removeFirst();
        }
        //Prise des ante
        for(Ste)


    }


    
}
