package org.example;

import java.util.List;

public class AnimalIterator implements BaseIterator<Animal> {
    private List<Animal> animals;
    private int currentIndex;

    public AnimalIterator(List<Animal> animals) {
        this.animals = animals;
        this.currentIndex = 0;
    }

    @Override
    public Animal next() {
        Animal current = animals.get(currentIndex);
        currentIndex++;
        return current;
    }

    @Override
    public boolean hasNext() {
        return currentIndex < animals.size();
    }

    @Override
    public void reset() {
        currentIndex = 0;
    }
}