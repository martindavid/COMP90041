import java.util.Arrays;

/**
 * Created by Martin Valentino on 10/4/16.
 * StudentID : 825178
 */
public class CalculateCard {

    public String[] rankArray;
    public String[] suitArray;


    /**
     *
     * @return
     */
    public int Calculate15s() {
        String[][] lines = Combinations.combinations(rankArray);
        int score = 0;
        for (String[] line : lines) {
            Arrays.sort(line);
            int sum = 0;
            for (String str : line) {
                sum += Integer.parseInt(str);
            }

            if (sum == 15){
                score += 2;
            }
        }

        return score;
    }

    public int CalculateOneForHisNoob() {
        return 0;
    }

    public int CalculateFlush() {
        return 0;
    }

    public int CalculatePairs() {
        return 0;
    }

    public int CalculateRuns() {
        return 0;
    }

}
