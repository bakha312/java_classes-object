package org.example;

public class Dog extends Animal {
    public Dog(String name, int age){
        super(name, age);
    }

    @Override
    public String toString(){
        return "org.example.Dog name = " + getName() + ", age = " + getAge();
    }
}
