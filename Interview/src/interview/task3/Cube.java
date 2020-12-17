package interview.task3;

/**
 *
 * @author Dominik
 */
public class Cube implements Figure, Block
{
    public double a;

    public Cube(double a) {
        this.a = a;
    }
    
    @Override
    public double getArea() {
        return 6.0*Math.pow(a, 2.0);
    }

    @Override
    public double getVolume() {
        return Math.pow(a, 3.0);
    }
    
}
