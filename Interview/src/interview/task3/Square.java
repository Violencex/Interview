package interview.task3;

/**
 *
 * @author Dominik
 */
public class Square implements Figure
{
    public double a;

    public Square(double a) {
        this.a = a;
    }
    
    @Override
    public double getArea() {
        return Math.pow(a, 2.0);
    }
}
