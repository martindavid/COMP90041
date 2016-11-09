/**
 * A class represents a game in the ancient Persian board game of Backgammon,
 *
 * @author  Martin Valentino - 825178
 * @version 1.0
 * @since   2016-09-12
 *
 */
public class BackgammonBoard {

    // A mark for black man
    private static final int BLACK_MAN = 1;
    // A mark for white man
    private static final int WHITE_MAN = 2;
    // A minimum point user can move to
    private static final int MIN_POINT = 0;
    // A maximum point user can move to
    private static final int MAX_POINT = 23;

    // Initial variable to store number of man, color on each point and number of man in the bar
    private int[] man;
    private int[] color;
    private int[] bar;

    // Initialize new board
    public BackgammonBoard(){
        man = new int[24];
        color = new int[24];
        bar = new int[2];
    }

    // Returns the number of men on the point
    public int getPointCount(int point){
        // Return 0 if the given point outside of bound 0 - 23
        if (point < MIN_POINT || point > MAX_POINT){
            return 0;
        }

        return man[point];
    }

    // Returns true if the man on the specified point are black, or false if it's white.
    // If there's no man on that point, it maybe either true or false
    public boolean getPointBlack(int point) {
        // return false if the given point outside of bound 0 - 23
        if (point < MIN_POINT || point > MAX_POINT){
            return false;
        }
        return color[point] == BLACK_MAN;
    }

    // Sets the number of men on the specified point to the specified count, and sets their colour
    // to black if black is true, or white if it is false
    public void setPoint(int point, int count, boolean black) {
        // Do nothing if the given point outside of bound 0 - 23
        if (point < MIN_POINT || point > MAX_POINT){
            return;
        }

        man[point] = count;
        color[point] = black ? BLACK_MAN : WHITE_MAN;
    }

    // Returns the number of black men on the bar
    public int getBarBlackCount() {
        return bar[BLACK_MAN - 1];
    }

    // Returns the number of white men on the bar
    public int getBarWhiteCount() {
        return bar[WHITE_MAN - 1];
    }

    // Moves one man from the specified fromPoint to the specified toPoint, if the move is legal
    // if it's illegal this method does nothing
    public void move(int fromPoint, int toPoint) {

        if (!isValidMove(fromPoint, toPoint)) {
            return;
        }

        // If black man hit white man, white man should go to bar
        if (getPointBlack(fromPoint) && !getPointBlack(toPoint) && getPointCount(toPoint) == 1){
            man[fromPoint]--;
            color[toPoint] = BLACK_MAN;
            // Need to subtract by 1 because we use value 2 for mark White man
            bar[WHITE_MAN - 1] += 1;
        }
        // If white man hit black man, black man should go to bar
        else if (!getPointBlack(fromPoint) && getPointBlack(toPoint) && getPointCount(toPoint) == 1){
            man[fromPoint]--;
            color[toPoint] = WHITE_MAN;

            // Need to subtract by 1 because we use value 1 for mark Black man
            bar[BLACK_MAN - 1] += 1;
        }
        else {
            man[fromPoint]--;
            if (getPointCount(toPoint) > 0) {
                man[toPoint]++;
            }
            else
            {
                man[toPoint]++;
                color[toPoint] = color[fromPoint];

                if (getPointCount(fromPoint) == 0)
                {
                    color[fromPoint] = 0;
                }
            }
        }
    }

    private boolean isValidMove(int fromPoint, int toPoint){
        // Return false if move to point outside of bound. The only valid move is between 0 - 23
        if (fromPoint < MIN_POINT || fromPoint > MAX_POINT || toPoint < MIN_POINT || toPoint > MAX_POINT){
            return false;
        }

        // Can not move more than 6 points
        if (Math.abs(fromPoint - toPoint) > 6) {
            return false;
        }

        // White men always move from lower to higher numbered
        // points (clockwise), and black men move from higher to lower numbered point (anti-clockwise)
        if ((color[fromPoint] == BLACK_MAN && toPoint > fromPoint) || (color[fromPoint] == WHITE_MAN && toPoint < fromPoint)) {
            return false;
        }

        // Man can only move to a point where has the same color or it's only occupied by one opponents man
        // TODO: this logic can be refactored
        if ((getPointBlack(fromPoint) && !getPointBlack(toPoint) && getPointCount(toPoint) > 1) ||
                (!getPointBlack(fromPoint) && getPointBlack(toPoint) && getPointCount(toPoint) > 1)){
            return false;
        }

        return true;
    }
}
