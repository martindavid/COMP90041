/**
 * This class provide a data structure for cribbage cards
 * Hold ranks, suits and combination of ranks
 *
 * Created by Martin Valentino on 9/25/16.
 * StudentID : 825178
 *
 * @author Martin Valentino <mvalentino@student.unimelb.edu.au>
 */
public final class CribbageCard {
    private String[] ranks;
    private String[] suits;
    private String[][] ranksCombination;

    /**
     * Create new instance of CribbageCard class and process cardAtHand parameter
     * @param cardAtHand array contains cardAtHand
     */
    public CribbageCard(String[] cardAtHand) {
        ranks = new String[cardAtHand.length];
        suits = new String[cardAtHand.length];

        for (int i = 0; i < cardAtHand.length; i++){
            // Break the given input to rank and the suit
            ranks[i] = cardAtHand[i].substring(0,1);
            suits[i] = cardAtHand[i].substring(1);
        }
        ranksCombination = Combinations.combinations(ranks);
    }

    /**
     * Return array contains ranks of cards at hand
     * @return array of ranks
     */
    public String[] getRanks() {
        return this.ranks;
    }

    /**
     * Return array contains suits of cards at hand
     * @return array of suits
     */
    public String[] getSuits() {
        return this.suits;
    }

    /**
     * Return arrays contain combination of ranks use for cribbage calculation
     * @return multidimensional string array contain ranks combination
     */
    public String[][] getRanksCombination() {
        return this.ranksCombination;
    }
}
