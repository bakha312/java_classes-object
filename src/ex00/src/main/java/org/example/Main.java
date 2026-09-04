package org.example;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
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
        for (Animal pet : pets) {
            System.out.println(pet);
        }

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