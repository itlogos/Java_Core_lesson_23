package ua.lviv.lgs.part1;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;


public class Faction {

    private String factionName;

    public Faction(String factionName) {
        this.factionName = factionName;
    }

    public String getFactionName() {
        return factionName;
    }

    public void setFactionName(String factionName) {
        this.factionName = factionName;
    }

    ArrayList<Deputy> factionArray = new ArrayList<Deputy>();

    Supplier<Deputy> createDeputy = () -> {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the last name of the deputy:");
        String surname = scanner.next();
        System.out.println("Enter the name of the deputy:");
        String name = scanner.next();
        System.out.println("Enter the age of the deputy:");
        int age = scanner.nextInt();
        System.out.println("Enter the height of the deputy:");
        int height = scanner.nextInt();
        System.out.println("Enter the weight of the deputy:");
        int weight = scanner.nextInt();
        System.out.println("Does the deputy take bribes (true/false):");
        boolean bribeTaker = scanner.nextBoolean();
        
        return new Deputy(surname, name, age, height, weight, bribeTaker);
    };

    Supplier<Deputy> getDeputy = () -> {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the last name of the deputy:");
        String surname = scanner.next();
        System.out.println("Enter the name of the deputy:");
        String name = scanner.next();
        
        return new Deputy(surname, name);
    };

    private int bribeSize;

    public void addDeputy() {
        Deputy deputy = createDeputy.get();

        if (deputy.isBribeTaker()) {
            deputy.giveBribe();
        }

        factionArray.add(deputy);
        System.out.println("Deputy " + deputy.toString() + " successfully added to faction!");
    }

    public void addAllDeputy(String surname, String name) {

        int age = getRandomValue(25, 82);
        boolean isBriber = getCorruptValue(age);
        bribeSize = getRandomValue(3000, 7000);
        int weight = getRandomValue(50, 110);
        int height = getRandomValue(160, 200);
 
        Deputy deputy = new Deputy(surname, name, age, height, weight, isBriber);
        factionArray.add(deputy);

    }
 
    public void removeDeputy() {
        Deputy DeputyTyped = getDeputy.get();
        
        Predicate<Deputy> isEqualSurnameName = deputy -> deputy.getSurname().equalsIgnoreCase(DeputyTyped.getSurname()) && deputy.getName().equalsIgnoreCase(DeputyTyped.getName());
        Optional<Deputy> deputyFound = factionArray.stream().filter(isEqualSurnameName).findFirst();

        if (deputyFound.isPresent()) {
            factionArray.remove(deputyFound.get());
            System.out.println("Deputy " + deputyFound.get().toString() + " successfully removed from faction!");

        } else {
            System.out.println("The introduced deputy does not exist in this faction!");
        }
    }

    public void getBribeTakers() {
        System.out.println("Deputies of the faction taking bribes:");
        List<Deputy> bribeTakers = factionArray.stream().filter(Deputy::isBribeTaker).collect(Collectors.toList());
        bribeTakers.forEach(System.out::println);
    }

    public void getLargestBribeTaker() {
        Comparator<Deputy> deputyBribeSizeComparator = (deputy1,
                deputy2) -> (deputy1.getBribeSize() > deputy2.getBribeSize()) ? 1
                        : (deputy1.getBribeSize() == deputy2.getBribeSize()) ? 0 : -1;
        Optional<Deputy> largestBribeTaker = factionArray.stream().filter(Deputy::isBribeTaker)
                .max(deputyBribeSizeComparator);

        if (largestBribeTaker.isPresent()) {
            System.out.println("Faction's biggest bribe taker " + largestBribeTaker.get().toString());
        } else {
            System.out.println("There are no bribe-takers in this party!");
        }
    }

    public void getAllDeputies() {
        System.out.println("Members of this faction:");
        factionArray.forEach(System.out::println);
    }

    public void clearFaction() {
        factionArray.clear();
        System.out.println("All deputies have been successfully removed from the faction!");
    }

    public int getRandomValue(int min, int max) {

        if (min >= max) {
            throw new IllegalArgumentException("min value must be smaller than max value");
        }

        Random r = new Random();
        return r.nextInt(max - min + 1) + min;
    }

    public boolean getCorruptValue(int age) {
        if (age % 2 == 0) {
            return false;
        } else {
            return true;
        }
    }
    
    @Override
    public String toString() {
        return " \"" + factionName + "\"";
    }

}