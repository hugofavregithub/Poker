package pokerController;
import java.util.List;
import java.util.ArrayList;

public class CombinationBisMain {

    public static void main(String[] args) {

        List<Card> combinationPlayer = new ArrayList<Card>();
        combinationPlayer.add(new Card("H", "6"));
        combinationPlayer.add(new Card("H", "3"));
        combinationPlayer.add(new Card("H", "4"));
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
    }
}

