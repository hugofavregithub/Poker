package test;

import java.util.ArrayList;

import pokerController.Combination;
import pokerController.Card;

public class CombinationMain {
    public static void main(String[] args) {
        ArrayList<Card> listOfCard = new ArrayList<>();
        listOfCard.add(new Card("H", "5"));
        listOfCard.add(new Card("S", "5"));
        listOfCard.add(new Card("S", "3"));
        listOfCard.add(new Card("H", "J"));
        listOfCard.add(new Card("T", "J"));
        Combination firstCombination = new Combination(listOfCard);
        System.out.println("first combination :");
        for (Card card : firstCombination) {
            System.out.println(card.getColor() + " " + card.getValue() + " hash value : " + card.hashCode());
        }
        System.out.println("value of hashcode : " + firstCombination.hashCode());
        System.out.println(firstCombination.pair()[0] + firstCombination.pair()[1] + firstCombination.pair()[2] + firstCombination.pair()[3]);

        ArrayList<Card> listOfCard2 = new ArrayList<>();
        listOfCard2.add(new Card("H", "K"));
        listOfCard2.add(new Card("S", "J"));
        listOfCard2.add(new Card("S", "2"));
        listOfCard2.add(new Card("H", "2"));
        listOfCard2.add(new Card("T", "J"));
        Combination secondCombination = new Combination(listOfCard2);
        System.out.println("second combination :");
        for (Card card : secondCombination) {
            System.out.println(card.getColor() + " " + card.getValue());
        }
        System.out.println("value of hashcode : " + secondCombination.hashCode());
        System.out.println(secondCombination.pair()[0] + secondCombination.pair()[1] + secondCombination.pair()[2] + secondCombination.pair()[3]);


        System.out.println(firstCombination.compareTo(secondCombination));

    }
}
