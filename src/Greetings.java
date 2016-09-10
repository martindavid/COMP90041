/**
 * Created by Martin Valentino on 8/2/16.
 * Student ID: 825178
 * Solution to week 2 assessed lab question Question 1
 *
 * A program that expects two string command line arguments, the first a name, and the second a place.
 * The program prints out on one line Hello name from place." and on the next line, I'VE ALWAYS WANTED TO GO TO PLACE."
 * where name and place are the first and second command line arguments, respectively, and PLACEis the second printed
 * in all upper case letters
 */
public class Greetings {

    public static void main(String[] args) {

        // if there is no argument passed, return a warning message and exit
        if (args.length < 2) {
            System.out.println("Please provide name and place arguments");
            return;
        }

        // place the arguments in the variable and trim it to remove any space from it
        String name = args[0].trim();
        String place = args[1].trim();

        System.out.printf("Hello %s from %s.\n", name, place);
        System.out.printf("I'VE ALWAYS WANTED TO GO TO %s.\n", place.toUpperCase());

    }
}
