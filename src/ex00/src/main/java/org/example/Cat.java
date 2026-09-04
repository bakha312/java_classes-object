package org.example;

public class Cat extends Animal{
    public Cat(String name, int age){
        super(name,age);
    }

    @Override
    public String toString() {
        return "org.example.Cat name = " + getName() + ", age = " + getAge();
    }
}
