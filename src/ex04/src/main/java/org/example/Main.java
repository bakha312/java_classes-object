package org.example;


import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;
import java.util.concurrent.CompletableFuture;

public class Main {
    public static void main(String[] args) {
        long programStart = System.currentTimeMillis();
        Scanner scanner = new Scanner(System.in);
        int count = readInt(scanner);
        List<Animal> pets = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            String type = scanner.next();
            switch (type) {
                case "dog":
                    String nameD = scanner.next();
                    int ageD = readInt(scanner);
                    if (ageD <= 0) {
                        System.out.println("Incorrect input. Age <= 0");
                    } else {
                        pets.add(new Dog(nameD, ageD));
                    }
                    break;
                case "cat":
                    String nameC = scanner.next();
                    int ageC = readInt(scanner);
                    if (ageC <= 0) {
                        System.out.println("Incorrect input. Age <= 0");
                    } else {
                        pets.add(new Cat(nameC, ageC));
                    }
                    break;
                default:
                    System.out.println("Incorrect input. Unsupported pet type");
                    break;
            }
        }
        List<CompletableFuture<Void>> futures = new ArrayList<>();
        for (Animal pet: pets){
            CompletableFuture<Void> future = CompletableFuture.runAsync(() -> {
                double startTime = (System.currentTimeMillis() - programStart) / 1000.0;
                try {
                    double walkTime = pet.goToWalk();
                    double endTime = (System.currentTimeMillis() - programStart) / 1000.0;
                    System.out.println(pet + ", start time = " + String.format(Locale.US, "%.2f", startTime)
                            + ", end time = " + String.format(Locale.US, "%.2f", endTime));
                } catch (InterruptedException e) {
                    System.out.println("Walk was interrupted");
                }
            });
            futures.add(future);
        }
        CompletableFuture.allOf(futures.toArray(new CompletableFuture[0])).join();


    }

    static int readInt(Scanner scanner) {
        while (true) {
            try {
                return Integer.parseInt(scanner.next());
            } catch (NumberFormatException e) {
                System.out.println("Could not parse a number. Please, try again");
            }
        }
    }
}