# ** java notes——basic knowledge 41- 81**

## 41. interface
a template that can be applied to a class. An interface can contain methods and variables, but the methods in an interface are abstract by default. The interface is used to specify what a class must do 
```java
public interface Prey {
    // abstract method,can not have a body
    void flee();
}
public interface Predator {
    void hunt();
}

public class fish implements Prey,Predator{
    @Override
    public void flee(){
        System.out.println("Fish is fleeing");
    }
    @Override
    public void hunt(){
        System.out.println("Fish is hunting");
    }
}

public class Main {
    public static void main(String[] args) {
        fish myFish = new fish();
        // call the methods of two interfaces
        myFish.flee();
        myFish.hunt();
    }
}
```

## 42.polymorphism
* an ability of an object to identify as more than one type
* for example: car is identified as a Vehicle and a Car
```java
public class Car extends Vehicle{
    @Override
    void go(){
        System.out.println("The car begins moving");
    }
}

public class Boat extends Vehicle{
    @Override
    void go(){
        System.out.println("The boat begins moving");
    }
}

public class Vehicle(){
    void go(){
        System.out.println("This vehicle begins moving");
    }
}

public class Main {
    public static void main(String[] args) {
        Car car = new Car();
        Boat boat = new Boat();
        
        // Car[] racers = {car,boat};
        // because both car and boat belong to vehicle,so it's better to contain them in a Vehicle date type
        Vehicle[] racers = {car,boat};
        
        // we can use for-each loop to call go method one by one
        for(Vehicle x : racers) {
            x.go();
        }
    }
}
```
