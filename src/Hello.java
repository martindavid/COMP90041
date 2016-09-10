import java.util.Scanner;

public class Hello {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("What's your name: ");
        String name;
        name = s.next().toString();
	    System.out.println("Hello World. Howdy " + name);
    }
}
