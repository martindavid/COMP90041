/**
 * Created by Martin Valentino on 8/30/16.
 * StudentID : 825178
 *
 * Class that implement BackgammonBoard class and test whether logic in BackgammonBoard class
 * implemented correctly or not
 */

public class BackgammonTest {

    public static void main(String[] args) {
        // If one of the test return false, print BUG otherwise print CORRECT
        if (!shouldNotMoveMoreThanSixPoints() ||
                !shouldNotMovePointOutside23() ||
                !whiteManShouldNotMoveAntiClockwise() ||
                !blackManShouldNotMoveClockwise() ||
                !shouldNotMoveToPointWithMoreThanOneOpponent() ||
                !hitWhiteManShouldGoToBar() ||
                !hitBlackManShouldGoToBar() ||
                !shouldOkMoveToSameColorMan() ||
                !shouldOkMoveToEmptySpace() ||
                hitWhiteManShouldGoToBarFromEmptySpace()
        )
        {
            System.out.println("BUG");
        } else {
            System.out.println("CORRECT");
        }
    }

    // Test whether we can move man to empty space correctly
    private static boolean shouldOkMoveToEmptySpace(){
        BackgammonBoard board = setupBoard();

        board.move(16,14); // Move 1 black man to empty point in 14

        return board.getPointCount(14) > 0;
    }

    // Test whether we can move man to the point with same color
    private static boolean shouldOkMoveToSameColorMan(){
        BackgammonBoard board = setupBoard();

        // Move 1 black man to 11, point 11 should have 6 black man
        board.move(16, 11);

        return board.getPointCount(11) == 6;
    }

    // Test whether we can move more than 6 points
    private static boolean shouldNotMoveMoreThanSixPoints(){
        BackgammonBoard board = setupBoard();

        board.move(5,7);
        board.move(5,7);
        board.move(5,7);
        board.move(5,7);

        // Try move more than 6 points, now point 5 should have 0 man
        board.move(5, 12);

        return board.getPointCount(5) > 0;
    }

    // Test whether we can move man to a point with more than one opponent man
    private static boolean shouldNotMoveToPointWithMoreThanOneOpponent(){
        BackgammonBoard board = setupBoard();

        // Move 1 black man from point 11 to 7
        // this not suppose to work, point 7 should still has 3 man
        board.move(11, 7);

        return board.getPointCount(7) == 3;
    }

    // Move 1 white man first and black man next, white man should go to bar
    private static boolean hitWhiteManShouldGoToBarFromEmptySpace(){
        BackgammonBoard board = setupBoard();

        board.move(12, 13);
        board.move(18, 13);

        return board.getPointCount(13) == 2;
    }

    // Test whether we can move to point outside of 0 - 23 bound
    private static boolean shouldNotMovePointOutside23(){
        BackgammonBoard board = setupBoard();
        board.move(12, 17);
        board.move(12, 17);
        board.move(17, 20);
        board.move(17, 20);
        board.move(20, 24);

        return board.getPointCount(20) != 1;
    }

    // Test whether white man can move anti-clockwise
    private static boolean whiteManShouldNotMoveAntiClockwise(){
        BackgammonBoard board = setupBoard();
        board.move(5,4);
        return board.getPointCount(4) != 1;
    }

    // Test whether black man can move clockwise
    private static boolean blackManShouldNotMoveClockwise(){
        BackgammonBoard board = setupBoard();
        board.move(18, 19);
        return board.getPointCount(19) != 1;
    }

    // Test whether black man hit white man make white goes to bar
    private static boolean hitWhiteManShouldGoToBar(){
        BackgammonBoard board = setupBoard();

        board.move(7, 9);
        board.move(7, 9);
        board.move(11, 7);

        return board.getBarWhiteCount() != 0;
    }

    // Test whether white man hit black man make black goes to bar
    private static boolean hitBlackManShouldGoToBar(){
        BackgammonBoard board = setupBoard();
        board.move(16, 14);
        board.move(16, 15);
        board.move(12, 16);

        return board.getBarBlackCount() != 0;
    }

    // Setup a new backgammon board with predefined man
    private static BackgammonBoard setupBoard(){
        BackgammonBoard board = new BackgammonBoard();
        board.setPoint(0, 2, true);     // Set 2 black man on location 0
        board.setPoint(5, 5, false);    // Set 5 white man on location 5
        board.setPoint(7, 3, false);    // Set 3 white man on location 7
        board.setPoint(11, 5, true);    // Set 5 black man on location 11
        board.setPoint(12, 5, false);   // Set 5 white man on location 12
        board.setPoint(16, 3, true);    // Set 3 black man on location 16
        board.setPoint(18, 5, true);    // Set 5 black man on location 18
        board.setPoint(23, 2, false);   // Set 2 white man on location 23

        return board;
    }

}
