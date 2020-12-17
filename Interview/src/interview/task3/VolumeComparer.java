package interview.task3;

/**
 *
 * @author Dominik
 */
public class VolumeComparer 
{
    public int compare(Block b1, Block b2)
    {
        double volume1 = b1.getVolume();
        double volume2 = b2.getVolume();
        return Double.compare(volume2, volume1);
    }
}
