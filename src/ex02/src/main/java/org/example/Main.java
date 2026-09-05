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
                case "hamster":
                    String nameH = scanner.next();
                    int ageH = readInt(scanner);
                    if (ageH <= 0) {
                        System.out.println("Incorrect input. Age <= 0");
                    } else {
                        pets.add(new Hamster(nameH, ageH));
                    }
                    break;
                case "guinea":
                    String nameG = scanner.next();
                    int ageG = readInt(scanner);
                    if (ageG <= 0) {
                        System.out.println("Incorrect input. Age <= 0");
                    } else {
                        pets.add(new GuineaPig(nameG, ageG));
                    }
                    break;
                default:
                    System.out.println("Incorrect input. Unsupported pet type");
                    break;

            }

        }
        for (Animal pet : pets) {
            if(pet instanceof Herbivore){
                System.out.println(pet);
            }
        }
        for(Animal pet: pets){
            if(pet instanceof Omnivore){
                System.out.println(pet);
            }
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