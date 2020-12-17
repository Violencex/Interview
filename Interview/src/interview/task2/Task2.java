package interview.task2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

/**
 *
 * @author Dominik
 */
//﻿Napisz program, który pozwoli wczytać dowolny plik tekstowy z dysku, a następnie policzy i wyświetli liczbę wystąpień każdego znaku - ilościowo
//i procentowo względem całego tekstu.
//Przykład:
//Aaabbbcdef
//A - 1 / 10%
//a - 2 / 20%
//b - 3 / 30%
//itd.
//Program powinien zapewnić możliwość sortowania wyniku alfabetycznie oraz ilościowo.
public class Task2 {

    public static void run() throws IOException {
        System.out.println("Podaj ścieżkę do pliku: ");
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        String path = read.readLine();
//        String path = "C:\\Users\\Dominik\\Documents\\text.txt";

        File file = new File(path);
        int all = 0;
        HashMap<Character, Integer> charMap = new HashMap<Character, Integer>();
        try {
            Scanner in = new Scanner(file);
            while (in.hasNext()) {
                String inputString = in.nextLine();
                inputString = inputString.replace(" ", "");
                char[] strArray = inputString.toCharArray();
                all += strArray.length;
                for (char c : strArray) {
                    if (charMap.containsKey(c)) {
                        charMap.put(c, charMap.get(c) + 1);
                    } else {
                        charMap.put(c, 1);
                    }
                }
            }

            Set<Map.Entry<Character, Integer>> entries = charMap.entrySet();
            List<Map.Entry<Character, Integer>> listOfEntries = new ArrayList<Map.Entry<Character, Integer>>(entries);
            Collections.sort(listOfEntries, keyComparator);
            LinkedHashMap<Character, Integer> sortedByKey = new LinkedHashMap<Character, Integer>(listOfEntries.size());

            for (Map.Entry<Character, Integer> entry : listOfEntries) {
                sortedByKey.put(entry.getKey(), entry.getValue());
            }

            System.out.println("Liczba wystąpień alfabetycznie: ");
            Set<Map.Entry<Character, Integer>> entrySetSortedByKey = sortedByKey.entrySet();
            for (Map.Entry<Character, Integer> mapping : entrySetSortedByKey) {
                System.out.println(mapping.getKey() + " - " + mapping.getValue()+ " / "+getPercent(mapping.getValue(), all)+"%");
            }

            Collections.sort(listOfEntries, valueComparator);
            LinkedHashMap<Character, Integer> sortedByValue = new LinkedHashMap<Character, Integer>(listOfEntries.size());

            for (Map.Entry<Character, Integer> entry : listOfEntries) {
                sortedByValue.put(entry.getKey(), entry.getValue());
            }

            System.out.println("Liczba wystąpień ilościowo: ");
            Set<Map.Entry<Character, Integer>> entrySetSortedByValue = sortedByValue.entrySet();
            for (Map.Entry<Character, Integer> mapping : entrySetSortedByValue) {
                System.out.println(mapping.getKey() + " - " + mapping.getValue()+ " / "+getPercent(mapping.getValue(), all)+"%");
            }

        } catch (FileNotFoundException e) {
            System.out.println("Nie znaleziono pliku z podaną ścieżką");
        }
    }
    
    public static Comparator<Map.Entry<Character, Integer>> keyComparator = new Comparator<Map.Entry<Character, Integer>>() {
        @Override
        public int compare(Map.Entry<Character, Integer> e1, Map.Entry<Character, Integer> e2) {
            String v1 = e1.getKey().toString();
            String v2 = e2.getKey().toString();
            return v1.toUpperCase().compareTo(v2.toUpperCase());
        }
    };

    public static Comparator<Map.Entry<Character, Integer>> valueComparator = new Comparator<Map.Entry<Character, Integer>>() {
        @Override
        public int compare(Map.Entry<Character, Integer> e1, Map.Entry<Character, Integer> e2) {
            Integer v1 = e1.getValue();
            Integer v2 = e2.getValue();
            return v2.compareTo(v1);
        }
    };

    public static int getPercent(int a, int b){
        double percent = (double)a/(double)b*100.0;
        percent = Math.round(percent);
        return (int)percent;
    }
}
