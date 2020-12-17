package interview.task3;

/**
 *
 * @author Dominik
 */
public class Circle implements Figure
{
    public double r;

    public Circle(double r) {
        this.r = r;
    }

    @Override
    public double getArea() {
        return Math.PI*Math.pow(r, 2.0);
    }
    
}
