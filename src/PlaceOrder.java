import java.util.Scanner;

/**
 * Created by Martin Valentino on 8/16/16.
 * StudentID : 825178
 *
 * A program that will prompt user with a set of question to make an order
 * and print out the order information along with the total price
 */
public class PlaceOrder {

    public static void main(String[] args){
        // Instantiate new scanner object to parse user input
        Scanner io = new Scanner(System.in);

        System.out.print("Quantity: ");
        int quantity = io.nextInt();
        io.nextLine(); // discard \n

        System.out.print("Description: ");
        String description = io.nextLine();

        System.out.print("Unit price: ");
        // Use double data type, because somehow float doesn't work in the verify
        Double unitPrice = io.nextDouble();

        Double totalPrice = quantity * unitPrice;

        // print out the result, make the description all uppercase
        System.out.printf("Order for %d %s\n", quantity, description.toUpperCase());
        System.out.printf("Total price %14.2f\n", totalPrice);

    }
}
