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
## 43.dynamic polymorphism

```java
public class Animal {
    void speak(){
        System.out.println("Animal is *bu*");
    }
}
public class Cat extends Animal{
    @Override
    void speak(){
        System.out.println("This cat is meow");
    }
}
public class Dog extends Animal{ @Override
void speak(){
    System.out.println("This dog is bark");
}
}
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // advantage of dynamic polymorphism
        // you can declare an object and make space for it even you don't know what kind of object it is
        Animal animal;

        System.out.println("what kind of animal do you prefer?");
        System.out.print("1 represent dog and 2 represent cat");
        int choice = scanner.nextInt();

        if(choice==1){
            animal = new Dog();
            animal.speak();
        }
        else if(choice==2){
            animal = new Cat();
            animal.speak();
        }
        else{
            animal = new Animal();
            System.out.println("your choice is invalid");
        }
    }
}
```
## 44. exception handling
* exception: an event that occurs during the execution of a program that disrupts the normal flow of instructions
* three steps:
  * try{}
  * catch(){}: there is still a priority of error,try to write the more specific error first
  * finally{}: this block will always be executed no matter what happens

```java
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.println("Enter a whole number to divide");
            int x = scanner.nextInt();
            System.out.println("Enter a whole number to divide by");
            int y  = scanner.nextInt();

            int z = x/y;
            System.out.println("result"+z);
        }
        catch(ArithmeticException a){
            System.out.println("zero division error");
        }
        catch(InputMismatchException i){
            System.out.println("please enter a number");
        }
        catch(Exception e){
            System.out.println("something goes wrong");
        }
        
        finally {
            scanner.close();
            System.out.println("this block will always be executed");
        }
    }
}
```

## 45.File class
how to create a .txt file
import java.io.File;
```java
import java.io.File;
public class Main {
    public static void main(String[] args) {
        // 相对路径：这个文件在这个project里就可以直接用文件名
        File file = new File("Jennie.txt");

        if(file.exists()){
            System.out.println("This file exists!");
            // other useful method
            System.out.println(file.getPath());
            System.out.println(file.getAbsoluteFile());
            System.out.println(file.isFile()); // return boolean
            file.delete(); // delete file after finishing this execution
        }
        else{
            System.out.println("This file doesn't exist!");
        }

    }
}
```
## 46. FileWriter
```java
import java.io.FileWriter;
import java.io.IOException;
public static void main(String[] args) {
  try {
    FileWriter writer = new FileWriter("Jennie.txt");
    writer.write("My name is Jennie\nI'm 24 years old");
    // append at the end of the file
    writer.append("Jennie's information");
    writer.close();
  }
  catch (IOException e){
    e.printStackTrace();
  }
}
```

## 47. FileReader
* read the content of a file as a stream of characters one by one
* read() return an int value which is the ASCII value of the character
* when the end of the file is reached, it will return -1
```java
import java.io.FileReader;
import java.io.IOException;
public class Main {
  public static void main(String[] args) {
    try {
      FileReader reader = new FileReader("Jennie.txt");
      int data = reader.read();
      while (data != -1) {
        // When you cast this integer to a char, it gets converted to the corresponding character as per the ASCII table.
        // For example, if data is 65, (char) data would be 'A', because 65 is the ASCII value for 'A'. 
        System.out.print((char) data);
        data = reader.read();
      }
      reader.close();
    }
    catch (IOException e){
      e.printStackTrace();
    }
  }
}
```
## 48.audio
```java
import javax.sound.sampled.*;
import java.io.File;
import java.io.scanner;
public class Main {
    public static void main(String[] args) throws IOException, UnsupportedAudioFileException, LineUnavailableException{
        // Create a Scanner object for user input
        Scanner scanner = new Scanner(System.in);
    
        // Create a File object for the audio file
        File file = new File("audio.wav");
    
        // Create an AudioInputStream from the audio file
        AudioInputStream audioStream = AudioSystem.getAudioInputStream(file);
    
        // Create a Clip to play the audio
        Clip clip = AudioSystem.getClip();
    
        // Open the audio clip
        clip.open(audioStream);
        String response = "";
    
        while(!response.equals("Q")) {
          System.out.println("P = play,S = stop,R = reset,Q = quit");
          System.out.println("enter your choice");
    
          response = scanner.next();
          response = response.toUpperCase();
    
          switch (response) {
            case ("P"):
              clip.start();
              break;
            case ("S"):
              clip.stop();
              break;
            case ("R"):
              clip.setMicrosecondPosition(0);
              break;
            case ("Q"):
              clip.close();
              break;
            default:
              System.out.println("Not a valid response");
          }
        }
      }
}

```
