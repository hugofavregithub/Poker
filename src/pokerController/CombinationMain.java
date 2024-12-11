package pokerController;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class CombinationBisMain {

    public static void main(String[] args) {

        List<Card> combinationPlayer = new ArrayList<Card>();
        combinationPlayer.add(new Card("H", "6"));
        combinationPlayer.add(new Card("H", "6"));
        combinationPlayer.add(new Card("H", "10"));
        combinationPlayer.add(new Card("H", "5"));
        combinationPlayer.add(new Card("H", "7"));
        Combination combination = new Combination(combinationPlayer);

        // Testing we get the right Combination
        System.out.print("[");
        System.out.print(combinationPlayer.get(0).getValue() + " " + combinationPlayer.get(0).getColor());
        System.out.print(", ");
        System.out.print(combinationPlayer.get(1).getValue() + " " + combinationPlayer.get(1).getColor());
        System.out.print(", ");
        System.out.print(combinationPlayer.get(2).getValue() + " " + combinationPlayer.get(2).getColor());
        System.out.print(", ");
        System.out.print(combinationPlayer.get(3).getValue() + " " + combinationPlayer.get(3).getColor());
        System.out.print(", ");
        System.out.print(combinationPlayer.get(4).getValue() + " " + combinationPlayer.get(4).getColor());
        System.out.println("]");

        
        // Testing for a straightFlush.
        String[] str1 = combination.straightFlush();
        System.out.print("Testing for a straight flush: ");
        System.out.println("[" + str1[0] + ", " + str1[1] + ", " + str1[2] + "]");

        // Testing for quads.
        String[] str2 = combination.quad();
        System.out.print("Testing for quads: ");
        System.out.println("[" + str2[0] + ", " + str2[1] + "]");

        // Testing for a full house.
        String[] str3 = combination.fullHouse();
        System.out.print("Testing for a full house: ");
        System.out.println("[" + str3[0] + ", " + str3[1] + ", " + str3[2] + "]");

        // Testing for a flush.
        String[] str4 = combination.flush();
        System.out.print("Testing for a flush: ");
        System.out.println("[" + str4[0] + ", " + str4[1] + ", " + str4[2] + "]");

        // Testing for a straight.
        String[] str5 = combination.straight();
        System.out.print("Testing for a straight: ");
        System.out.println("[" + str5[0] + ", " + str5[1] + "]");

        // Testing for a set.
        String[] str6 = combination.set();
        System.out.print("Testing for a set: ");
        System.out.println("[" + str6[0] + ", " + str6[1] + "]");

        // Testing for a pair.
        String[] str7 = combination.pair();
        System.out.print("Testing for one or multiple pairs: ");
        System.out.println("[" + str7[0] + ", " + str7[1] + ", " + str7[2] + ", " + str7[3] + "]");

        // Getting the hashcode of the combination
        System.out.println("hashArray of combination 1 : " + Arrays.toString(combination.getHashArray()));

        List<Card> combinationPlayer2 = new ArrayList<Card>();
        combinationPlayer2.add(new Card("H", "6"));
        combinationPlayer2.add(new Card("H", "6"));
        combinationPlayer2.add(new Card("S", "10"));
        combinationPlayer2.add(new Card("H", "5"));
        combinationPlayer2.add(new Card("H", "7"));
        Combination combination2 = new Combination(combinationPlayer2);
        System.out.println("hashArray of combination 2 : " + Arrays.toString(combination2.getHashArray()));

        List<Card> combinationPlayer3 = new ArrayList<Card>();
        combinationPlayer3.add(new Card("H", "6"));
        combinationPlayer3.add(new Card("D", "6"));
        combinationPlayer3.add(new Card("S", "6"));
        combinationPlayer3.add(new Card("C", "7"));
        combinationPlayer3.add(new Card("H", "7"));
        Combination combination3 = new Combination(combinationPlayer3);
        System.out.println("hashArray of combination 3 : " + Arrays.toString(combination3.getHashArray()));

        List<Card> combinationPlayer4 = new ArrayList<Card>();
        combinationPlayer4.add(new Card("H", "6"));
        combinationPlayer4.add(new Card("D", "6"));
        combinationPlayer4.add(new Card("S", "6"));
        combinationPlayer4.add(new Card("C", "6"));
        combinationPlayer4.add(new Card("H", "7"));
        Combination combination4 = new Combination(combinationPlayer4);
        System.out.println("hashArray of combination 4 : " + Arrays.toString(combination4.getHashArray()));

        List<Card> combinationPlayer5 = new ArrayList<Card>();
        combinationPlayer5.add(new Card("H", "10"));
        combinationPlayer5.add(new Card("H", "K"));
        combinationPlayer5.add(new Card("H", "Q"));
        combinationPlayer5.add(new Card("H", "J"));
        combinationPlayer5.add(new Card("H", "A"));
        Combination combination5 = new Combination(combinationPlayer5);
        System.out.println("hashArray of combination 5 : " + Arrays.toString(combination5.getHashArray()));

        System.out.println("Comparing combination 1 and 2 : " + combination.compareTo(combination2));
        System.out.println("Comparing combination 2 and 3 : " + combination2.compareTo(combination3));
        System.out.println("Comparing combination 3 and 4 : " + combination3.compareTo(combination4));
        System.out.println("Comparing combination 4 and 5 : " + combination4.compareTo(combination5));
        System.out.println("Comparing combination 3 and 5 : " + combination3.compareTo(combination5));

        List<Combination> combinations = new ArrayList<Combination>();
        combinations.add(combination);
        combinations.add(combination2);
        combinations.add(combination3);
        combinations.add(combination4);
        combinations.add(combination5);
        Collections.sort(combinations);
        for (Combination currentCombination : combinations) {
            System.out.println(Arrays.toString(currentCombination.getHashArray()));
        }
    }
}

