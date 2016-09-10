
/**
 * Created by Martin Valentino on 8/16/16.
 * StudentID : 825178
 *
 * A program that takes two integer arguments
 * on the command line, and prints out the prime numbers from the
 * first command line argument up to the second (inclusive), one number per line
 *
 */
public class Primes {

    public static void main(String[] args){
        // Make sure that command argument exists
        if (args.length < 2){
            System.out.println("Please input two number arguments");
            return;
        }

        int beginRange = Integer.parseInt(args[0]);
        int endRange = Integer.parseInt(args[1]);

        for (int i = beginRange; i <= endRange; i++){
            if (IsPrime(i)){
                System.out.println(i);
            }
        }
    }

    // A method to check whether a given number is prime number or not
    public static boolean IsPrime(int n){
        // 1 is not a prime number, exit immediately
        if (n == 1){
            return false;
        }

        for (int i = 2; i < n - 1;i++){
            // Check if n can be divided by other number in this loop, it's not a prime number
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}
