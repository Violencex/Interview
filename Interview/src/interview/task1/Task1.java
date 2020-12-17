package interview.task1;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Dominik
 */

//Napisz program, który:
//1. wypełni 200 elementową tablicę losowymi liczbami z zakresu <0 - 100>,
//2. przepisze co trzecią liczbę z tablicy do listy generycznej w kolejności od końca do początku tablicy. Np. dla tablicy [1, 2, 3, 4, 5, 6, 7, 8] lista powinna zawierać elementy 8, 5, 2,
//3. przepisze wartości z tablicy do listy generycznej w taki sposób, że element w liście odpowiadający elementowi w tablicy będzie średnią arytmetyczną elementu z tablicy oraz jego sąsiadów - tj. elementu poprzedzającego i kolejnego. Uwaga - dla pierwszego elementu tablicy należy przyjąć, że poprzedza go element o wartości 50, a dla ostatniego należy przyjąć, że następuje po nim element o wartości 50.
//4. przepisze elementy tablicy większe od 90 do listy generycznej
//5. wymnoży elementy tablicy na zasadzie każdy z każdym (także z samym sobą) i wyświetli bez powtórzeń pary indeksów tych elementów, dla których iloczyn jest większy od 9000
//   np. dla tablicy [0, 91, 100] powinny zostać wyświetlone pary (1, 2), (2, 2)
public class Task1 {

    public static void run()
    {
        int[] tab = new int[200];
        
        fillTabWithRandom(tab);
        List<Integer> list1 = getEveryThird(tab);
        List<Double> list2 = getArithmeticAverage(tab);
        List<Integer> list3 = getHigherThan(tab, 90);
        multiplyEachAndShow(tab, 9000.0);
    }
    
    public static void fillTabWithRandom(int[] tab)
    {
        for (int i = 0; i < tab.length; i++) 
        {
            tab[i] = (int)(Math.random()*100);
            System.out.println("tab["+i+"]: "+tab[i]);
        }
    }
    
    public static List<Integer> getEveryThird(int[] tab)
    {
        List<Integer> list = new ArrayList<>();
        int j = 0;
        for (int i = tab.length-1; i > 0; i-=3) 
        {
            list.add(tab[i]);
            System.out.println("List1["+j+"]: "+tab[i]);
            j++;
        }
        
        return list;
    }
    
    public static List<Double> getArithmeticAverage(int[] tab)
    {
        List<Double> list = new ArrayList<>();
        
        for (int i = 0; i < tab.length; i++) 
        {
            int previous;
            int next;
            if (i == 0)
            {
                previous = 50;
            }
            else
            {
                previous = tab[i-1];
            }
            
            if (i == tab.length-1)
            {
                next = 50;
            }
            else
            {
                next = tab[i+1];
            }
            
            double average = (previous+tab[i]+next)/3;
            list.add(average);
            
            System.out.println("List2["+i+"]: "+average);
        }
        return list;
    }
    
    public static List<Integer> getHigherThan(int[] tab, int a)
    {
        List<Integer> list = new ArrayList<>();
        int j = 0;
        for (int i = 0; i < tab.length; i++) 
        {
            if(tab[i] > a)
            {
                list.add(tab[i]);
                System.out.println("List3["+j+"]: "+tab[i]);
                j++;
            }
        }
        
        return list;
    }
    
    public static void multiplyEachAndShow(int[] tab, double a)
    {
        for (int i = 0; i < tab.length; i++) 
        {
            for (int j = i; j < tab.length; j++) 
            {
                double result = tab[i]*tab[j];
                if( result > a){
                    System.out.println("("+i+", "+j+")");
                }
            }

        }
        
    }
}
