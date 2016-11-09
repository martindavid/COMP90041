import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * This class provide methods used for calculate points for cribbage game
 *
 * Created by Martin Valentino on 9/21/16.
 * StudentID : 825178
 *
 * @author Martin Valentino <mvalentino@student.unimelb.edu.au>
 */
public class CribbageValuation {

    /**
     * Calculate "one for his noob" rules. 1 point scores if the hand contains the jack of the same suit
     * as the start card
     * @return result score from this rule valuation
     */
    public int getOneForHisNoobScore(CribbageCard cards) {
        String[] suits = cards.getSuits();
        String[] ranks = cards.getRanks();
        for (int i = 0; i < suits.length - 1; i++) {
            if (suits[i].equals(suits[suits.length - 1]) &&
                    ranks[i].charAt(0) == CribbageRank.JACK.abbrev()) {
                return 1;
            }
        }
        return 0;
    }

    /**
     * Evaluate if all the cards in the hand are of the same suit
     * @return 4 if all cards is in the same suits, 5 if the start card also has the same suit as the others
     */
    public int getFlushScore(CribbageCard cards) {
        String[] suits = cards.getSuits();
        String checkSuit = suits[0];
        int score = 1;
        for (int i = 1; i < suits.length; i++) {
            if (checkSuit.equals(suits[i])) {
                score++;
            }
        }

        return score < 4 ? 0 : score;
    }

    /**
     * Evaluate if there's a run of 3 or more consecutive cards (no need to consider suit)
     * Each of card will be score 1
     * @return The total of card in a consecutive order
     */
    public int getRunsScore(CribbageCard cards) {
        String[] ranks = cards.getRanks();
        String[][] ranksCombination = cards.getRanksCombination();

        // array to store a number of sequence we got from the combination
        // array index will represent a number of cards that make a runs (3,4,5)
        int[] counterCount = new int[ranks.length + 1];
        for (String[] rankArr : ranksCombination) {
            if (rankArr.length >= 3) {
                int[] sortedArray = constructSortedArray(rankArr);
                if (isSequenceExists(sortedArray)) {
                    counterCount[rankArr.length] += 1;
                }
            }
        }

        // Loop from the largest position,
        // because we only need to sum up the longest run
        for (int i = ranks.length; i > 0; i--) {
            if (counterCount[i] > 0) {
                return counterCount[i] * i;
            }
        }
        return 0;
    }

    /**
     * Evaluate if the combination of the card can have a pairs.
     * 2 scores for each pairs from the combination
     * @return The total number of pairs * 2
     */
    public int getPairsScore(CribbageCard cards) {
        String[][] ranksCombination = cards.getRanksCombination();
        int score = 0;
        for (String[] ranks : ranksCombination) {
            // Compare only pair element (n = 2)
            if (ranks.length == 2 && Array.get(ranks,0).equals(Array.get(ranks, 1))) {
                score += 2;
            }
        }
        return score;
    }

    /**
     * Evaluate if the combination of the card can sum up to 15
     * @return The total score for combination
     */
    public int get15sScore(CribbageCard cards) {
        String[][] ranksCombination = cards.getRanksCombination();
        int maxScore = 15;
        int score = 0;
        for (String[] ranks : ranksCombination) {
            int tempScore = 0;
            for (String rank : ranks) {
                tempScore += CribbageRank.getString(rank).faceValue();
            }
            if (tempScore == maxScore) {
                score += 2;
            }
        }
        return score;
    }

    /**
     * Determine whether the given array is a sequence array
     * @param arr Array contain combination of cribbage cards rank need to check
     * @return true if there's any sequence and false if there's no sequence
     */
    private boolean isSequenceExists(int[] arr) {
        int checkVal = arr[0];
        int checkCount = 1;

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] == checkVal + 1) {
                checkCount += 1;
            }
            checkVal = arr[i];
        }

        if (checkCount == arr.length) {
            return true;
        }

        return false;
    }

    /**
     * Construct a sorted integer array from a given unsorted array
     * This method will also Jack, Queen, King to its associate value
     * so we can determine the sequence from this array
     * @param arr array contain cribbage card ranks need to be mapped and sorted
     * @return a sorted integer array
     */
    private int[] constructSortedArray(String[] arr) {
        int[] result = new int[arr.length];

        for (int i = 0; i < arr.length; i++) {
            if (CribbageRank.getString(arr[i]).equals(CribbageRank.JACK)) {
                result[i] = 11;
            }else if (CribbageRank.getString(arr[i]).equals(CribbageRank.QUEEN)) {
                result[i] = 12;
            } else if (CribbageRank.getString(arr[i]).equals(CribbageRank.KING)) {
                result[i] = 13;
            }else {
                result[i] = CribbageRank.getString(arr[i]).faceValue();
            }
        }

        Arrays.sort(result);
        return result;
    }
}
