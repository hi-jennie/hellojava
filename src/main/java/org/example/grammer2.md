# ** java notes——basic knowledge 41- 81**

## 41. interface
a template that can be applied to a class. An interface can contain methods and variables, but the methods in an interface are abstract by default. The interface is used to specify what a class must do 
```java
interface Prey {
    // abstract method,can not have a body
    void flee();
}
interface Predator {
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
