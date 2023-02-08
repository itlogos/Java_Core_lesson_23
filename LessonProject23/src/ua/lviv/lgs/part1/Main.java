package ua.lviv.lgs.part1;

import java.util.Scanner;
import java.util.function.Supplier;
 

public class Main {

        public static void main(String[] args) {
            Supplier<Integer> menu = () -> {
                
                String text = "Enter values:"

                    + "\n 1-For add a faction, " + "\n 2-For remove a faction, "
                    + "\n 3-For withdrawal of all faction, " + "\n 4-For clear a specific faction, "
                    + "\n 5-For withdrawal of a specific faction, " + "\n 6-For add a deputy to a faction, "
                    + "\n 7-For remove a deputy from a faction," + "\n 8-For withdrawal of all bribe-takers,"
                    + "\n 9-For withdrawal of the largest bribe-taker, ";
                
                System.out.println(text);


                Scanner scanner = new Scanner(System.in);
                int menuChoise = scanner.nextInt();
                
                return menuChoise;
            };
            Rada rada = new Rada();
            rada.getInstance().addAllDeputyToFaction();
            while (true) {
                switch (menu.get()) {

                case 1: {
                    Rada.getInstance().addFaction();
                    break;
                }

                case 2: {
                    Rada.getInstance().removeFaction();
                    break;
                }

                case 3: {
                    Rada.getInstance().getAllFactions();
                    break;
                }

                case 4: {
                    Rada.getInstance().clearFaction();
                    break;
                }

                case 5: {
                    Rada.getInstance().getFaction();
                    break;
                }

                case 6: {
                    Rada.getInstance().addDeputyToFaction();
                    break;
                }

                case 7: {
                    Rada.getInstance().removeDeputyFromFaction();
                    break;
                }

                case 8: {
                    Rada.getInstance().getBribeTakersFromFaction();
                    break;
                }

                case 9: {
                    Rada.getInstance().getLargestBribeTakerFromFaction();
                    break;
                }

                default: {
                    System.out.println("Enter a number from 1 to 9!");
                    break;
                }
                }
            }
        }
    }