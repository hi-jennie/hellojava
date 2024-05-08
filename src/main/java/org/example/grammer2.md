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
        // 我的理解是：将这个文件转换为一个可以被播放的音频流
        AudioInputStream audioStream = AudioSystem.getAudioInputStream(file);
    
        // Create a Clip to play the audio
        // 我的理解是：创建一个可以播放音频的对象
        Clip clip = AudioSystem.getClip();
    
        // Open the audio clip
        // 我的理解是：将音频流放入这个对象中
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
## 49. GUI
```java
import javax.swing.*;
import java.awt.*;
public class JennieFrame extends JFrame {
    JennieFrame() {
        this.setSize(500, 500);// set the size of the frame
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// set the close button to exit the program
        this.setVisible(true);// make this visible
        this.setTitle("first GUI of Jennie");// set the title of the frame
        this.setResizable(false);// make it so that the frame cannot be resized

        ImageIcon image = new ImageIcon("cat.png");// create an ImageIcon
        this.setIconImage(image.getImage());// set the icon of the frame
        this.getContentPane().setBackground(Color.pink);// set the background color of the frame

    }
}
public class Main {
  public static void main(String[] args) {
    new JennieFrame();
    // JennieFrame jennieFrame = new JennieFrame();
  }
}
```

## 50. JLabel
```java
import java.awt.*;
import javax.swing.*;
import javax.swing.border.Border;
public class Main {
  public static void main(String[] args) {
    JLabel label = new JLabel();
    ImageIcon image = new ImageIcon("cat.png");// create an ImageIcon
    label.setIcon(image);

    Border border = BorderFactory.createLineBorder(Color.pink,3);// create a border
    label.setBorder(border);// set the border of the label

    label.setText("Jennie likes cats very much");
    label.setHorizontalTextPosition(JLabel.CENTER); // set text LEFT, CENTER, RIGHT of image icon
    label.setVerticalTextPosition(JLabel.TOP); // set text TOP, CENTER, BOTTOM of image icon

    label.setForeground(Color.pink); // set the color of the text
    label.setFont(new Font("MV Boli",Font.PLAIN,50)); // set the font of the text

    label.setIconTextGap(-5); // set gap of text to image
    label.setBackground(Color.white); // set background color
    label.setOpaque(true); // display background color

    label.setVerticalAlignment(JLabel.CENTER); // set vertical position of icon+text within label
    label.setHorizontalAlignment(JLabel.CENTER); // set horizontal position of icon+text within label



    JFrame frame = new JFrame();
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setVisible(true);
    frame.add(label); // add label to frame
    frame.pack(); // set size to fit all components
  }
}
```
