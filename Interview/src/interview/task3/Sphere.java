package interview.task3;

/**
 *
 * @author Dominik
 */
public class Sphere implements Figure, Block
{
    public double r;

    public Sphere(double r) {
        this.r = r;
    }
    
    @Override
    public double getArea() {
        return 4.0*Math.PI*Math.pow(r, 2.0);
    }

    @Override
    public double getVolume() {
       return (4.0/3.0)*Math.PI*Math.pow(r, 3.0);
    }
    
}

