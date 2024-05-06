package org.example;

public class Hero extends Person{
    String power;

    // constructor
    Hero(String name,int age,String power){
        // in this case, the constructor from the parent class is called.super() = Person(
        super(name,age);
        this.power = power;
    }

    public String toString(){
        // in this case, the toString method from the parent class is called
        return super.toString() + " Power: " + this.power;
    }
}
