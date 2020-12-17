package interview.task3;

/**
 *
 * @author Dominik
 */
public class AreaComparer 
{
    public int compare(Figure f1, Figure f2)
    {
        double area1 = f1.getArea();
        double area2 = f2.getArea();
        return Double.compare(area2, area1);
    }
}
