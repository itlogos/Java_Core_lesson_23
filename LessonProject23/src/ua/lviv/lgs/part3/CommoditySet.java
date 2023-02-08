package ua.lviv.lgs.part3;

import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Random;
import java.util.Scanner;
import java.util.TreeSet;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class CommoditySet {

    Scanner scan = new Scanner(System.in);

    LinkedHashSet<Commodity> commodity = new LinkedHashSet<>();

    Commodity com = new Commodity();

    public void addAllProduct() {

        commodity.add(new Commodity("toy", 250, 40, 12));
        commodity.add(new Commodity("pillow", 210, 10, 93));
        commodity.add(new Commodity("pen", 76, 15, 34));
        commodity.add(new Commodity("chair", 54, 8, 9));
        commodity.add(new Commodity("armchair", 12, 34, 10));
        commodity.add(new Commodity("table", 32, 5, 22));
        commodity.add(new Commodity("suitcase", 45, 3, 1));
        commodity.add(new Commodity("book", 98, 6, 32));
        System.out.println("Before sort elements :");

        commodity.forEach(System.out::println);

    }

    public void addProduct() {

        int length = getRandomValue(20, 150);
        int wide = getRandomValue(3, 40);
        int weight = getRandomValue(3, 55);

        String text = "Enter name of product (the rest of the data will be generated randomly): ";
        String name = readText(text);

        commodity.add(new Commodity(name, length, wide, weight));
        System.out.println("After the element is added :");
        commodity.forEach(System.out::println);

    }

    public void removeProduct() {

        Iterator<Commodity> iterator = commodity.iterator();
        String text = "Enter name of product";

        String name1 = readText(text);

        while (iterator.hasNext()) {
            Commodity line = iterator.next();
            if (line.getName().equals(name1)) {
                iterator.remove();
            }
        }

        System.out.println("After the element is removed :");
        commodity.forEach(System.out::println);
    }

    public void replaceProduct() {
        Iterator<Commodity> iterator = commodity.iterator();
        int length = getRandomValue(20, 150);
        int wide = getRandomValue(3, 40);
        int weight = getRandomValue(3, 55);

        String text = "Enter name of product for replacement: ";
        String name1 = readText(text);
        String text1 = "Enter name of product to be inserted (the rest of the data will be generated randomly): ";
        String name2 = readText(text1);
        while (iterator.hasNext()) {
            Commodity line = iterator.next();
            if (line.getName().equals(name1)) {
                iterator.remove();
            }
        }
        commodity.add(new Commodity(name2, length, wide, weight));
        System.out.println("After :");
        commodity.forEach(System.out::println);
    }

    public void sortName() {
        System.out.println("\nAfter sort elements :");
        commodity.stream().sorted(Comparator.comparing(Commodity::getName)).forEach(System.out::println);

    }

    public void sortLength() {
        System.out.println("\nAfter sort elements :");
        commodity.stream().sorted(Comparator.comparing(Commodity::getLength)).forEach(System.out::println);

    }

    public void sortWidth() {
        System.out.println("\nAfter sort elements :");
        commodity.stream().sorted(Comparator.comparing(Commodity::getWidth)).forEach(System.out::println);

    }

    public void sortWeight() {
        System.out.println("\nAfter sort elements :");        
        commodity.stream().sorted(Comparator.comparing(Commodity::getWeight)).forEach(System.out::println);

    }

    public void displayElement() {

        String text = "Enter index: ";
        int index = readText2(text);

        Iterator<Commodity> it = commodity.iterator();

        int currIndex = 0;
        Commodity CurrentElement = null;

        while (it.hasNext()) {

            CurrentElement = it.next();

            if (currIndex == index - 1) {
                System.out.println("Element at index " + index + " is : " + CurrentElement);
                break;
            }

            currIndex++;
        }
    }

    public void exit() {
        System.out.println("exit...");
        System.exit(0);
    }

    public String readText(String text) {
        System.out.println(text);
        String input = scan.next();
        return input;
    }

    public int readText2(String text) {
        System.out.println(text);
        int input = scan.nextInt();
        return input;
    }

    public int getRandomValue(int min, int max) {

        if (min >= max) {
            throw new IllegalArgumentException("min value must be smaller than max value");
        }

        Random r = new Random();
        return r.nextInt(max - min + 1) + min;
    }

}


