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

## 50. JLabel / 51. JPanel
* JLabel: a display area for a short text string or an image, or both
* JPanel: a generic lightweight container that hold other components like buttons, labels, and text fields
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
    
    JPanel panel = new JPanel();
    panel.setBackground(Color.pink);
    panel.setLayout(new BorderLayout());
    panel.add(label);
  }
}
```

## 52. JButton
setBounds(100,100,250,100);
* 100 是 x 坐标，表示按钮的左上角在其容器的水平方向上距离左边界的距离。
* 100 是 y 坐标，表示按钮的左上角在其容器的垂直方向上距离上边界的距离。
* 250 是按钮的宽度。
* 100 是按钮的高度。
```java
package org.example;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyFrame extends JFrame implements ActionListener {
    JButton button;
    JLabel dreamLabel;
    MyFrame(){
         dreamLabel = new JLabel();
         button = new JButton();

        ImageIcon dreamIcon = new ImageIcon("Dream.png");
        dreamLabel.setIcon(dreamIcon);
        dreamLabel.setVisible(false);
        dreamLabel.setBounds(0,0,500,500);


        button.setBounds(500,250,500,600);
        button.setBackground(Color.pink);
        button.setFocusable(false); // remove the blue border
        button.setBorder(BorderFactory.createEtchedBorder()); // add border
        button.addActionListener((ActionListener) this); // add action listener

        button.setText("what's matter with you?");
        button.setHorizontalTextPosition(JButton.CENTER);
        button.setVerticalTextPosition(JButton.TOP);
        button.setFont(new Font("Comic Sans",Font.BOLD,25));
        button.setForeground(Color.pink);

        ImageIcon icon = new ImageIcon("cat.png");
        button.setIcon(icon);
        button.setIconTextGap(10);


        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.setSize(1000,1000);
        this.setResizable(false);
        this.setVisible(true);
        this.add(button);
        this.add(dreamLabel);
    }
    @Override
    // this method is called when the button is clicked
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==button){
            dreamLabel.setVisible(true);
        }
    }
}
public class Main {
  public static void main(String[] args) {
    new MyFrame();
  }
}
```

## 53.BorderLayout
* BorderLayout divides the container into five regions: North, South, East, West, and Center
* we can also add a sub-panel to each region,it's like a container in a container
```java
import java.awt.*;
import javax.swing.*;
public class Main {
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1000,1000);
        // 这意味着组件之间的水平和垂直间距都是 10 像素。 
        frame.setLayout(new BorderLayout(10,10));
        frame.setVisible(true);

        JPanel panel1 = new JPanel();
        JPanel panel2 = new JPanel();
        JPanel panel3 = new JPanel();
        JPanel panel4 = new JPanel();
        JPanel panel5 = new JPanel();

        panel1.setBackground(Color.pink);
        panel2.setBackground(Color.green);
        panel3.setBackground(Color.blue);
        panel4.setBackground(Color.yellow);
        panel5.setBackground(Color.orange);

        panel1.setPreferredSize(new Dimension(100,100));
        panel2.setPreferredSize(new Dimension(100,100));
        panel3.setPreferredSize(new Dimension(100,100));
        panel4.setPreferredSize(new Dimension(100,100));
        panel5.setPreferredSize(new Dimension(100,100));
        
        // BorderLayout 布局管理器将尝试将组件放置在容器的边界区域，并尽可能地接近组件的首选大小。 
        //因此，靠近边界的一侧的距离是固定的，这是由 BorderLayout 布局管理器和组件的首选大小共同决定的。
        frame.add(panel1,BorderLayout.NORTH);
        frame.add(panel2,BorderLayout.WEST);
        frame.add(panel3,BorderLayout.CENTER);
        frame.add(panel4,BorderLayout.EAST);
        frame.add(panel5,BorderLayout.SOUTH);
    }
}
```
## 54. FlowLayout
* place components in a row, sized at their preferred size
* if the horizontal space in the container is too small to put all the components in one row, the FlowLayout class uses multiple rows
```java
public class Main {
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setVisible(true);
        frame.setSize(500,500);
        // 设置了组件之间的水平和垂直间距为 10，以及组件的对齐方式为居中对齐
        frame.setLayout(new FlowLayout(FlowLayout.CENTER,10,10));

        frame.add(new Button("0"));
        frame.add(new Button("1"));
        frame.add(new Button("2"));
        frame.add(new Button("3"));
        frame.add(new Button("4"));
        frame.add(new Button("5"));
        frame.add(new Button("6"));
        frame.add(new Button("7"));
        frame.add(new Button("8"));
        frame.add(new Button("9"));
    }
}
```
## 55.GridLayout
* places components in a grid of cells
* each component takes all the available space within its cell, and each cell is the same size
```java
public class Main {
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setVisible(true);
        frame.setSize(500,500);
        // set the layout of the frame in a 3x3 grid
        // the last two parameters are the horizontal and vertical gaps between the buttons
        frame.setLayout(new GridLayout(3,3,10,10));

        frame.add(new Button("0"));
        frame.add(new Button("1"));
        frame.add(new Button("2"));
        frame.add(new Button("3"));
        frame.add(new Button("4"));
        frame.add(new Button("5"));
        frame.add(new Button("6"));
        frame.add(new Button("7"));
        frame.add(new Button("8"));
        frame.add(new Button("9"));
        frame.add(new Button("10"));
        // if there are more than 9 buttons, the layout will automatically add a new column
    }
}
```
## 56.JLayeredPane
* a Swing container that provides a third dimension for positioning components
* the depth of the z-axis is defined by an integer
```java
public class Main {
    public static void main(String[] args) {
        JLabel label1 = new JLabel();
        label1.setBounds(0,0,200,200);
        label1.setOpaque(true);
        label1.setBackground(Color.pink);

        JLabel label2 = new JLabel();
        label2.setBounds(50,50,200,200);
        label2.setOpaque(true);
        label2.setBackground(Color.blue);

        JLabel label3 = new JLabel();
        label3.setBounds(100,100,200,200);
        label3.setOpaque(true);
        label3.setBackground(Color.cyan);

        JLayeredPane layeredPane = new JLayeredPane();
        layeredPane.setBounds(0,0,500,500);
        // we can add the labels to different layers by setting the integer value of the specific layer
        layeredPane.add(label1, Integer.valueOf(0));
        layeredPane.add(label2, Integer.valueOf(1));
        layeredPane.add(label3, Integer.valueOf(2));

        // set the title of the frame to "JLayeredPane"
        JFrame frame = new JFrame("JLayeredPane");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setSize(new Dimension(1000,1000));
        frame.add(layeredPane);
        // if we don't set the layout of the frame to null,
        // then we need to set bounds for the layeredPane manually
        frame.setLayout(null);
    }
}
```
## 57.open a new GUI window
```java
public class Homepage extends JFrame implements ActionListener {
    JFrame frame = new JFrame();
    JButton button =  new JButton("click to see your cats");

    Homepage(){
        button.setBounds(150,150,200,100);
        button.setFocusable(false);
        button.addActionListener((ActionListener)this);
        button.setOpaque(true);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500,500);
        frame.setVisible(true);
        frame.setLayout(null);
        frame.add(button);
    }
    // this method is called when the button is clicked and it will open a new GUI window
    @Override
    public void actionPerformed(ActionEvent e){
        if (e.getSource() == button){
            frame.dispose();
            FamilyMember familyMember = new FamilyMember();
        }
    }
}
public class FamilyMember {
  JFrame frame = new JFrame();
  FamilyMember(){
    JLabel label1 =  new JLabel();
    ImageIcon icon1 = new ImageIcon("cat.png");
    label1.setSize(1000,1000);
    label1.setIcon(icon1);
    label1.setText("Turkey");
    label1.setHorizontalAlignment(JLabel.CENTER);
    label1.setHorizontalTextPosition(JLabel.CENTER);
    label1.setVerticalTextPosition(JLabel.TOP);
    label1.setIconTextGap(20);

    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(500,500);
    frame.setVisible(true);
    frame.setLayout(new GridLayout());
    frame.add(label1);
  }
}
public class Main {
  public static void main(String[] args) {
    Homepage homepage = new Homepage();
  }
}
```
## 58.JOptionPane
* pop up a standard dialog box that prompts users for a value or informs them of something
```java
public class Main {
    public static void main(String[] args) {
        
        JOptionPane.showMessageDialog(null,"Hello,Jennie!","say hello",JOptionPane.PLAIN_MESSAGE);
        JOptionPane.showMessageDialog(null,"This is useless info","information",JOptionPane.INFORMATION_MESSAGE);
        JOptionPane.showMessageDialog(null,"really?","question",JOptionPane.QUESTION_MESSAGE);
        JOptionPane.showMessageDialog(null,"your computer has a Virus","Warning",JOptionPane.WARNING_MESSAGE);
        JOptionPane.showMessageDialog(null,"call tech support or else!!!","title",JOptionPane.ERROR_MESSAGE);
        
        // returns an integer which is the index of the option selected
        int answer = JOptionPane.showConfirmDialog(null,"DO you like code", "questionnaire",JOptionPane.YES_NO_OPTION);

        String name = JOptionPane.showInputDialog("What's your name?");

        String[] response = {"cat","dog","rabbit","fish"};
        ImageIcon icon = new ImageIcon("cat.png");

        // Option dialog returns an integer which is the index of the option selected
        JOptionPane.showOptionDialog(null,
                "my favorite animal",
                "favorite animal",
                JOptionPane.YES_NO_OPTION, // yes no option
                JOptionPane.INFORMATION_MESSAGE,
                icon,
                response,
                0);
    }
}
```