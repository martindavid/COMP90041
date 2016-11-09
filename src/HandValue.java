/**
 * Main class that receives 5 cards on the command
 * line and will print out only the number of points
 * the hand comprising the first four of those cards
 * would score if the fifth card were the start card
 *
 * Created by Martin Valentino on 9/21/16.
 * StudentID : 825178
 *
 * @author Martin Valentino <mvalentino@student.unimelb.edu.au>
 */
public class HandValue {

    public static void main(String[] args) {
        String[] arr = {"2H", "3H", "5H", "10H", "KH"};
        CribbageCard cards = new CribbageCard(arr);
        CribbageValuation score = new CribbageValuation();
        int fifteen = score.get15sScore(cards);
        System.out.println(fifteen);
        int noob = score.getOneForHisNoobScore(cards);
        int pairs = score.getPairsScore(cards);
        int runs = score.getRunsScore(cards);
        int flush = score.getFlushScore(cards);
        int atHandScore = fifteen + noob + pairs + runs + flush;
        System.out.println(atHandScore);
    }
}
