package interview;

import interview.task1.Task1;
import interview.task2.Task2;
import interview.task3.Task3;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author Dominik
 */
public class Interview {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {

        int task = -1;
        while (task != 0) 
        {
            System.out.println("Podaj nr zadania 1-3 (0 - zamyka program): ");
            Scanner sc = new Scanner(System.in);
            try {
                task = sc.nextInt();
            } catch (Exception e) {
                System.out.println("Wprowadzono niedozwoloną wartość");
            }
            
            switch (task){
                case 1:{
                    System.out.println("TASK 1");
                    Task1.run();
                    task = -1;
                    break;
                }
                case 2:{
                    System.out.println("TASK 2");
                    Task2.run();
                    task = -1;
                    break;
                }
                case 3:{
                    System.out.println("TASK 3");
                    Task3.run();
                    task = -1;
                    break;
                }
            }
            System.out.println("");
        }
    }
}
