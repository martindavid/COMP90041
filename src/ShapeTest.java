/**
 * Created by Martin Valentino on 11/9/16.
 * StudentID : 825178
 */
public class ShapeTest {

    public static void main(String[] args){
        Shape circle = new Circle(7.0);
        Shape rectangle = new Rectangle(10.0, 8.0);

        System.out.println(circle.toString());
        System.out.println(rectangle.toString());
    }
}
