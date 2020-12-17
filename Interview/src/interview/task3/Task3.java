package interview.task3;

/**
 *
 * @author Dominik
 */
//﻿Należy stworzyć program do porównywania pól powierzchni i objętości obiektów (figur, brył).
//
//Przykład użycia programu:
//var areaComparer = new AreaComparer();
//var result1 = areaComparer.Compare(new Square(a: 80.0), new Cylinder(radius: 20.0, height: 10.0));
//var result2 = areaComparer.Compare(new Cube(a: 30.0), new Triangle(a: 13.0, height: 60.0));
//var volumeComparer = new VolumeComparer();
//var result3 = volumeComparer.Compare(new Cube(a: 30.0), new Cylinder(radius: 20.0, height: 10.0));
//
//W celu realizacji zadania:
//1. Zaimplementuj następujące figury płaskie: Square, Circle i bryły: Cube, Sphere. 
//Figury płaskie mają mieć wyliczalne property Area.
//Bryły mają mieć wyliczalne property Area oraz wyliczalne property Volume.
//2. Zaimplementuj dwie klasy:
//- AreaComparer z jedną metodą Compare do porównywania pola powierzchni dwóch obiektów. 
//Jeżeli pierwszy obiekt ma większą powierzchnię metoda ma zwracać -1, jeżeli drugi to 1, a jeżeli są równe to 0.
//- VolumeComparer z jedną metodą Compare do porównywania objętości dwóch obiektów.
//AreaComparer powinien umieć porównywać zarówno bryły i figury płaskie.
//VolumeComparer powinien umieć porównywać tylko bryły.
public class Task3 {
    public static void run()
    {
        AreaComparer areaComparer = new AreaComparer();
        int result1 = areaComparer.compare(new Square(80.0), new Square(80.0));
        int result2 = areaComparer.compare(new Square(80.0), new Cube(80.0));
        int result3 = areaComparer.compare(new Square(80.0), new Circle(80.0));
        int result4 = areaComparer.compare(new Cube(80.0), new Sphere(80.0));
        
        VolumeComparer volumeComparer = new VolumeComparer();
        int result5 = volumeComparer.compare(new Cube(80.0), new Sphere(80.0));
        int result6 = volumeComparer.compare(new Sphere(80.0), new Cube(80.0));
        int result7 = volumeComparer.compare(new Sphere(80.0), new Sphere(80.0));
        
        System.out.println("Area Comparator: ");
        System.out.println("Square(80.0), Square(80.0) result: "+result1);
        System.out.println("Square(80.0), Cube(80.0) result: "+result2);
        System.out.println("Square(80.0), Circle(80.0) result: "+result3);
        System.out.println("Cube(80.0), Sphere(80.0) result: "+result4);
        System.out.println("Volume Comparator: ");
        System.out.println("Cube(80.0), Sphere(80.0) result: "+result5);
        System.out.println("Sphere(80.0), Cube(80.0) result: "+result6);
        System.out.println("Sphere(80.0), Sphere(80.0) result: "+result7);
        
    }
    
}
