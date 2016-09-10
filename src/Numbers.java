/**
 * Created by Martin Valentino on 8/2/16.
 * StudentID : 825178
 * Solution to week 2 assessed lab question Question 2
 *
 * Programs that prints out the sum, difference, product, quotient (integer part) and remainder on division (mod)
 * of the two integer command line arguments, one number per output line.
 */
public class Numbers {
    
    public static void main(String[] args){

        // if there is no argument passed, return a warning message and exit
        if (args.length < 2) {
            System.out.println("Please provide first and second number");
            return;
        }

        int firstNumber = Integer.parseInt(args[0].trim());
        int secondNumber = Integer.parseInt(args[1].trim());

        System.out.println(firstNumber + secondNumber); // sum
        System.out.println(firstNumber - secondNumber); // difference
        System.out.println(firstNumber * secondNumber); // product
        System.out.println(firstNumber / secondNumber); // quotient
        System.out.println(firstNumber % secondNumber); // modulus

    }
}
