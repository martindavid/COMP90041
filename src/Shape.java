/**
 * An abstract class that represents a geometric shape
 *
 * @author Martin Valentino<mvalentino@student.unimelb.au />
 * StudentID : 825178
 */
public abstract class Shape {

    public abstract Double perimeter();
    public abstract Double area();

    @Override
    public String toString() {
        return this.getClass().getName();
    }
}
