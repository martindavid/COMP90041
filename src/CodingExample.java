/* An example Java program showing how commenting and good choices for names
   and methods makes it much easier for humans to read
   Remember, your tutor is a human, and humans don't give good marks if they
   can't read your code!
   Try to figure out what the bad code is doing before you read the good code,
   and have some comfort food next to you while you do :)

   Author: 	Matthew De Bono
   Date:	27/7/2015
*/

import java.util.Scanner;

public class CodingExample {

    public static void main(String args[]) {

        // A bad, tear inducing method
        myBadMethod();

        // A good, happiness inducing method
        myGoodMethod();
    }

	/* Bad code starts here; readers beware */

    public static void myBadMethod()
    {
        Scanner duvh = new Scanner(System.in);


        int pakib = doSomething(duvh);
        int oc99p = doSomething(duvh);

        {bLaHbLaH(pakib, oc99p);}
    }

    public static int doSomething(Scanner skbi) {int kcal=skbi.nextInt();return kcal;}

    public static void bLaHbLaH(int Mario, int Luigi) {
        System
                .out
                .println(
                        Mario
                                *
                                Luigi
                );
    }

	/* 	Good code starts here; readers are permitted to celebrate loudly.

		Important things to notice:
			- Long names for methods or variables have upper case letters for
			  each "word", and lower case letters otherwise; no '_' or '-'
			- Every {} means one level of indentation
			- Braces {} are aligned vertically, makes code easy to read
			- Variable names are descriptive, and consistent
			- Method names are descriptive
			- Code is well commented, so even a non-coder can understand it
			- White space to separate operators and names or definitions
			- White-space to separate steps in the process to allow comments
			- At most one line of white-space to separate statements (don't make
			  your code twice as long by hitting enter...)
			- Lines at most 80 characters lone (standard console size)
			- Statements are written on separated by new lines

		Lessons to learn:
			- Most of these guidelines are common sense but lots of people don't
			  follow them...
			- While you don't need to comment every step, you absolutely need to
			  comment your code
			- Make sure you choose useful and descriptive names for methods and
			  variables
			- If you write code that is more similar to the first version,
			  you will not receive many marks in the projects for "code quality"
			- Start practicing writing good code now, so it is automatic when
			  we get to the projects!
	*/

    // This method asks for two numbers, then prints the multiple of the two
    public static void myGoodMethod() {

        // Create a new scanner object for user input
        Scanner scanner = new Scanner(System.in);

        // Get the two numbers from the user
        int n1 = getNextNumber(scanner);
        int n2 = getNextNumber(scanner);

        // Print the output to the console
        printMultiple(n1, n2);
    }

    // This method is purely an example, you don't need to do this with scanner
    public static int getNextNumber(Scanner scanner) {
        // Asks the user for input, without this the user won't know what to do!
        System.out.print("Please enter a number: ");
        // uses the scanner to read the number from the command line
        return scanner.nextInt();
    }

    // Again, an example just to show you to properly write methods and comments
    // Notice how the variable names for the integers are consistent
    public static void printMultiple(int n1, int n2) {
        // Print the desired output
        System.out.println("Result of " + n1 + " * " + n2 + " is: " + n1 * n2);
    }
}
