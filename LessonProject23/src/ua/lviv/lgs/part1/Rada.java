package ua.lviv.lgs.part1;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Optional;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.function.Supplier;

public final class Rada {

    private static Rada instance = new Rada();

    public static Rada getInstance() {
        if (instance == null) {
            instance = new Rada();
        }

        return instance;
    }

    ArrayList<Faction> radaArray = new ArrayList<Faction>();


    public void addAllDeputyToFaction() {
 
        Optional<Faction> factionFound1 = CheсkFaction("Green");
        if (factionFound1.isPresent()) {
            factionFound1.get().addAllDeputy("Petrenko", "Igor");
            factionFound1.get().addAllDeputy("Semenenko", "Ulia");
            factionFound1.get().addAllDeputy("Mavenko", "Oleg");
            factionFound1.get().addAllDeputy("Sonko", "Aleks");
        }
        Optional<Faction> factionFound2 = CheсkFaction("White");
        if (factionFound2.isPresent()) {
            factionFound2.get().addAllDeputy("Savchenko", "Oleg");
            factionFound2.get().addAllDeputy("Poronko", "Aleks");
        }
        Optional<Faction> factionFound3 = CheсkFaction("Neutral");
        if (factionFound3.isPresent()) {
            factionFound3.get().addAllDeputy("Franko", "Igor");
            factionFound3.get().addAllDeputy("Drim", "Luda");
        }

        System.out.println(" Before :\n Fractions registered in Verkhona Rada:");
        for (Faction facty : radaArray) {
            System.out.println("Faction - " + facty);
            facty.getAllDeputies();
        }
    }

    public Optional<Faction> CheсkFaction(String fact) {

        Predicate<Faction> isEqualFactionName = faction -> faction.getFactionName().equalsIgnoreCase(fact);
        Optional<Faction> factionFound = radaArray.stream().filter(isEqualFactionName).findFirst();

        return factionFound;
    }

    Supplier<Faction> getFaction = () -> {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter name of the faction : ");
        String factionName = scanner.next();

        return new Faction(factionName);
    };

    public Optional<Faction> findFaction() {
        Faction FactionTyped = getFaction.get();

        Predicate<Faction> isEqualFactionName = faction -> faction.getFactionName()
                .equalsIgnoreCase(FactionTyped.getFactionName());
        Optional<Faction> factionFound = radaArray.stream().filter(isEqualFactionName).findFirst();

        return factionFound;
    }

    public void addFaction() {
        Faction faction = getFaction.get();

        radaArray.add(faction);
        System.out.println(faction.toString() + " successfully added to the Verkhovna Rada!");
    }

    public void removeFaction() {
        Optional<Faction> factionFound = findFaction();

        if (factionFound.isPresent()) {
            radaArray.remove(factionFound.get());
            System.out.println(factionFound.get().toString() + " successfully removed from the Verkhovna Rada!");
        } else {
            System.out.println("There is no introduced faction in the Verkhovna Rada!");
        }
    }

    public void getAllFactions() {
        System.out.println("Fractions registered in Verkhona Rada:");
        radaArray.forEach(System.out::println);
    }

    public void clearFaction() {
        Optional<Faction> factionFound = findFaction();

        if (factionFound.isPresent()) {
            factionFound.get().clearFaction();
        } else {
            System.out.println("There is no introduced faction in the Verkhovna Rada!");
        }
    }

    public void getFaction() {
        Optional<Faction> factionFound = findFaction();

        if (factionFound.isPresent()) {
            System.out.println(factionFound.get().toString());
            factionFound.get().getAllDeputies();
        } else {
            System.out.println("There is no introduced faction in the Verkhovna Rada!");
        }
    }

    public void addDeputyToFaction() {
        Optional<Faction> factionFound = findFaction();

        if (factionFound.isPresent()) {
            factionFound.get().addDeputy();
        } else {
            System.out.println("There is no introduced faction in the Verkhovna Rada!");
        }
    }

    public void removeDeputyFromFaction() {
        Optional<Faction> factionFound = findFaction();

        if (factionFound.isPresent()) {
            factionFound.get().removeDeputy();
        } else {
            System.out.println("There is no introduced faction in the Verkhovna Rada!");
        }
    }

    public void getBribeTakersFromFaction() {
        Optional<Faction> factionFound = findFaction();

        if (factionFound.isPresent()) {
            factionFound.get().getBribeTakers();
        } else {
            System.out.println("There is no introduced faction in the Verkhovna Rada!");
        }
    }

    public void getLargestBribeTakerFromFaction() {
        Optional<Faction> factionFound = findFaction();

        if (factionFound.isPresent()) {
            factionFound.get().getLargestBribeTaker();
        } else {
            System.out.println("There is no introduced faction in the Verkhovna Rada!");
        }
    }

    public void getAllDeputiesFromFaction() {
        Optional<Faction> factionFound = findFaction();

        if (factionFound.isPresent()) {
            factionFound.get().getAllDeputies();
        } else {
            System.out.println("There is no introduced faction in the Verkhovna Rada!");
        }
    }

    public Rada() {

        radaArray.add(new Faction("Green"));
        radaArray.add(new Faction("White"));
        radaArray.add(new Faction("Neutral"));
    }
}
