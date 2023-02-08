package ua.lviv.lgs.part1;

import java.util.Scanner;
import java.util.function.Supplier;

public class Deputy extends Human{

    private String surname;
    private String name;
    private int age;
    private boolean bribeTaker;
    private int bribeSize;

    public Deputy(String surname, String name) {
        this.surname = surname;
        this.name = name;
    }

    public Deputy(String surname, String name, int age, int height, int weight, boolean bribeTaker) {
        super(weight, height);
        this.surname = surname;
        this.name = name;
        this.age = age;
        this.bribeTaker = bribeTaker;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean isBribeTaker() {
        return bribeTaker;
    }

    public String bribeTakerToString() {
        if (this.bribeTaker) {
            return "briber";
        } else { return "honest person";
        }
    }
    
    public void setBribeTaker(boolean bribeTaker) {
        this.bribeTaker = bribeTaker;
    }

    public int getBribeSize() {
        return bribeSize;
    }

    public void setBribeSize(int bribeSize) {
        this.bribeSize = bribeSize;
    }

    public void giveBribe() {
        if (this.bribeTaker == false) {
            System.out.println("No!");
        }

        if (this.bribeTaker == true) {
            System.out.println("Enter the amount of the bribe:");
            int bribeAmount = getBribeAmount.get();
            
            if (bribeAmount > 5000) {
                System.out.println("Police officers are already leaving to arrest the bribe-taker!");
            } else {
                this.bribeSize = bribeAmount;
            }
        }
    }

    Supplier<Integer> getBribeAmount = () -> {
        Scanner scanner = new Scanner(System.in);
        int bribeAmount = scanner.nextInt();
        
        return bribeAmount;
    };  
    
    @Override
    public String toString() {
        return "[" + surname + " " + name + ", " + age + " years, height: " + super.getHeight() + " см, weight: " + super.getWeight()
                + " kg, " + bribeTakerToString() + "]";
    }

}