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

## 59.TextField
* a text field is a UI component that allows the user to enter or edit text
* please pay attention to the order of adding components
```java
public class MyFrame extends JFrame implements ActionListener {
    JButton button;
    JTextField textField;
    MyFrame(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new FlowLayout());

        button = new JButton("submit");
        button.addActionListener((ActionListener) this); // add action listener

        textField = new JTextField();
        textField.setPreferredSize(new Dimension(200,30));
        textField.setBackground(Color.pink);
        textField.setFont(new Font("Consolas",Font.BOLD,20));
        textField.setForeground(Color.BLACK);
        textField.setText("username");

        this.add(button);
        this.add(textField);
        this.setSize(500,500);
        this.setVisible(true);
        // pack() method sizes the frame so that all its contents are at or above their preferred sizes.
        this.pack();
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==button){
            System.out.println("hello "+textField.getText());
            // set the button to be disabled after clicking
            button.setEnabled(false);
            // set the text field to be uneditable after clicking
            textField.setEditable(false);
        }
    }
}
```
## 60.JCheckBox
* a checkbox is a UI component that allows the user to choose between two opposite states, checked and unchecked
```java
public class MyFrame extends JFrame implements ActionListener {
    JButton button;
    JCheckBox checkBox;
    MyFrame(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new FlowLayout());

        button = new JButton();
        button.setText("submit");
        button.addActionListener((ActionListener) this); // add action listener

        ImageIcon icon = new ImageIcon("cat.png");
        ImageIcon checkIcon = new ImageIcon("dream.png");

        checkBox = new JCheckBox();
        checkBox.setText("I'm not a rabbit");
        // remove the focus from the checkbox
        checkBox.setFocusable(false);
        checkBox.setFont(new Font("Consolas",Font.PLAIN,25));
        // set icon when not selected
        checkBox.setIcon(icon);
        // set icon when selected
        checkBox.setSelectedIcon(checkIcon);

        this.add(button);
        this.add(checkBox);
        this.setSize(500,500);
        this.setVisible(true);
        // pack() method sizes the frame so that all its contents are at or above their preferred sizes.
        this.pack();
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==button){
            // .isSelected() returns a boolean value
            System.out.println(checkBox.isSelected());
        }
    }
}
```

## 61.JRadioButton
* a radio button is a UI component that allows the user to choose only one option from a predefined set of options
```java
public class MyFrame extends JFrame implements ActionListener {
    JRadioButton pizzaButton;
    JRadioButton hamburgerButton;
    JRadioButton hotDogButton;

    MyFrame(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new FlowLayout());

        pizzaButton = new JRadioButton("pizzaButton");
        hamburgerButton = new JRadioButton("hamburgerButton");
        hotDogButton = new JRadioButton("hotDogButton");

        // add these buttons to a group so that only one can be selected at a time
        ButtonGroup group = new ButtonGroup();
        group.add(pizzaButton);
        group.add(hamburgerButton);
        group.add(hotDogButton);

        pizzaButton.addActionListener((ActionListener) this);
        hamburgerButton.addActionListener((ActionListener) this);
        hotDogButton.addActionListener((ActionListener) this);

        this.add(pizzaButton);
        this.add(hamburgerButton);
        this.add(hotDogButton);
        this.setVisible(true);
        // pack() method sizes the frame so that all its contents are at or above their preferred sizes.
        this.pack();
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==pizzaButton){
            System.out.println("you ordered pizzaButton");
        }
        else if(e.getSource()==hamburgerButton){
            System.out.println("you ordered hamburger");
        }
        else if(e.getSource()==hotDogButton){
            System.out.println("you ordered hotDog");
        }
    }
}
```
## 62.JComboBox
* we need to pass in an array of _**references data type**_ to the objects we want to display in the combo box
```java
public class MyFrame extends JFrame implements ActionListener {
    JComboBox comboBox;

    MyFrame(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new FlowLayout());

        String[] family = {"Jennie","Rustin","white","Turkey"};
        comboBox = new JComboBox(family);
        comboBox.addActionListener((ActionListener)this);

        // there are some relative method about comboBox
        // setEditable(true) will allow user to input their own value
        comboBox.setEditable(true);
        // get the number of items in the comboBox
        comboBox.getItemCount();
        // add an item to the comboBox
        comboBox.addItem("horse");
        comboBox.insertItemAt("rabbit",0);
        // set the selected item by the value
        comboBox.setSelectedItem("horse");
        // set the selected item by the index
        comboBox.setSelectedIndex(5);

        comboBox.removeItem("horse");
        comboBox.removeItemAt(0);
        // comboBox.removeAll();

        this.add(comboBox);
        this.setVisible(true);
        this.pack();
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==comboBox){
            // get the selected item and index
            System.out.println(comboBox.getSelectedItem());
            System.out.println(comboBox.getSelectedIndex());
        }

    }
}

```
## 63.slider
* a GUI component that lets the user select a value from a range of values
```java
public class SliderDemo implements ChangeListener {
    JFrame frame;
    JPanel panel;
    JLabel label;
    JSlider slider;
    SliderDemo(){
        frame = new JFrame();
        panel = new JPanel();
        label = new JLabel();
        label.setFont(new Font("MV Boli",Font.PLAIN,25));

        // create a slider with a range from 0 to 100 and a starting value of 50
        slider = new JSlider(0,100,50);
        slider.addChangeListener(this);

        slider.setPreferredSize(new Dimension(400,200));
        slider.setOrientation(SwingConstants.VERTICAL);
        // 设置那个一长条的滑轨
        slider.setPaintTrack(true);
        // 当你调用setPaintTicks(true)时，它会启用在滑块上绘制刻度标记。
        // 如果你调用setPaintTicks(false)，它会禁用在滑块上绘制刻度标记。
        slider.setPaintTicks(true);
        // 然后设置标记间隔
        slider.setMinorTickSpacing(10);
        slider.setMajorTickSpacing(20);

        slider.setPaintLabels(true);
        slider.setFont(new Font("MV Boli",Font.PLAIN,15));
        label.setFont(new Font("MV Boli",Font.PLAIN,25));
        // 注意getValue的位置，必须有value才能使用
        label.setText("C = "+slider.getValue());


        panel.add(slider);
        panel.add(label);
        frame.add(panel);
        frame.setSize(420,420);
        frame.setVisible(true);
    }
    @Override
    public void stateChanged(ChangeEvent e){
        label.setText("C = "+slider.getValue());
    }
}
```

## 64.progress bar
* 为什么颜色设置不起效果
```java
public class ProgressBarDemo {
    JFrame frame = new JFrame();
    JProgressBar bar = new JProgressBar();

    ProgressBarDemo(){
        bar.setValue(0);
        bar.setBounds(0,0,420,300);
        // set the string to be displayed
        bar.setStringPainted(true);
        bar.setFont(new Font("MV Boli",Font.BOLD,25));
        bar.setForeground(Color.red);
        bar.setBackground(Color.pink);

        frame.add(bar);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);
        frame.setSize(420,420);
        frame.setVisible(true);

        fill();
    }
    public void fill(){
        int counter = 0;
        while(counter<=100){
            bar.setValue(counter);
            // set the bar to sleep for 100 milliseconds
            try{
                Thread.sleep(100);
            }
            // catch the exception when the thread is interrupted
            catch (InterruptedException e){
                e.printStackTrace();
            }
            counter +=1;
        }
        // set the string to be displayed when the progress bar is full
        bar.setString("Done!!!");
    }
}
```
## 65.menu bar
three main steps:
* create a menu bar
* create a menu(add menu to the menu bar)
* create a menu item(add menu item to the menu)
```java
public class MenuBar extends JFrame implements ActionListener {
    JMenuBar menuBar;
    JMenu fileMenu;
    JMenu editMenu;
    JMenu helpMenu;
    JMenuItem loadItem;
    JMenuItem saveItem;
    JMenuItem exitItem;

    MenuBar(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(500,500);
        this.setLayout(new FlowLayout());

        menuBar = new JMenuBar();
        fileMenu = new JMenu("file");
        editMenu = new JMenu("edit");
        helpMenu = new JMenu("help");


        loadItem = new JMenuItem("load");
        saveItem = new JMenuItem("save");
        exitItem = new JMenuItem("exit");
        loadItem.addActionListener(this);
        saveItem.addActionListener(this);
        exitItem.addActionListener(this);
        
        // set the mnemonic/shortcut for the menu 但是不知道为啥不起作用
        fileMenu.setMnemonic(KeyEvent.VK_F);// Alt+F for file
        editMenu.setMnemonic(KeyEvent.VK_E);// Alt+E for edit
        helpMenu.setMnemonic(KeyEvent.VK_H);// Alt+H for help
        loadItem.setMnemonic(KeyEvent.VK_L);// Alt+L for load
        saveItem.setMnemonic(KeyEvent.VK_S);// Alt+S for save
        exitItem.setMnemonic(KeyEvent.VK_E);// Alt+E for exit

        fileMenu.add(loadItem);
        fileMenu.add(saveItem);
        fileMenu.add(exitItem);

        menuBar.add(fileMenu);
        menuBar.add(editMenu);
        menuBar.add(helpMenu);
        this.add(menuBar);
        this.setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource()==loadItem){
            System.out.println("loadItem");
        }
        if(e.getSource()==saveItem){
            System.out.println("saveItem");
        }
        if(e.getSource()==exitItem){
            System.out.println("exitItem");
        }
    }
}
```
## 66.select a file
```java
public class SelectFile extends JFrame implements ActionListener {
    JButton button;

    SelectFile(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new FlowLayout());

        button = new JButton("Select File");
        button.addActionListener(this);

        this.add(button);
        this.pack();
        this.setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource() == button){
            JFileChooser fileChooser = new JFileChooser();
            // set the current directory of the file chooser,it means which directory the file chooser will open
            fileChooser.setCurrentDirectory(new File("C:\\Users\\Desktop"));
            // null is used to open the file chooser at the default location(in the center of the screen)
            int response = fileChooser.showOpenDialog(null);
            // int response = fileChooser.showSaveDialog(null);

            // JFileChooser.APPROVE_OPTION is a constant that is used to check if the user has selected a file or saved a file
            // it returns an integer value of 0
            if(response == JFileChooser.APPROVE_OPTION){
                // getSelectedFile() returns the file that the user selected
                File file = new File(fileChooser.getSelectedFile().getAbsolutePath());
                System.out.println(file);
            }
        }
    }
}
```

## 67.ColorChooser
* a GUI component that allows the user to select a color from a color palette
```java
public class ColorChooser extends JFrame implements ActionListener {
    JButton button;
    JLabel label;
    ColorChooser(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new FlowLayout());

        button = new JButton("select a color");
        button.addActionListener(this);
        label = new JLabel();
        label.setText("the current color");
        label.setFont(new Font("MV Boli",Font.PLAIN,15));
        label.setForeground(Color.PINK);
        // if we want to change the background color of the label, we need to setOpaque(true)
        // or else the background color will not be displayed
        label.setOpaque(true);
        label.setBackground(Color.BLACK);

        this.add(button);
        this.add(label);
        this.pack();
        this.setVisible(true);
    }
    public void actionPerformed(ActionEvent e){
        if(e.getSource() == button){
            // create a color chooser
            JColorChooser colorChooser = new JColorChooser();
            // Color.pink is the default color of the color chooser
            // save the selected color in a variable
            Color color = JColorChooser.showDialog(null,"Pick a color",Color.pink);
            label.setForeground(color);
        }
    }

}
```

## 68.key listener
* the frame of KeyListener:
* keyTyped() = invoked when a key is typed,uses keyChar,char output
* keyPressed() = invoked when a physical key is pressed down,uses keycodes,int output
* keyReleased() = invoked when a key is released,uses keycodes,int output
```java
public class KeyboardListener extends JFrame implements KeyListener {
    JLabel label;
    KeyboardListener(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(500,500);
        this.setLayout(null);
        this.addKeyListener(this);

        label = new JLabel();
        label.setBounds(0,0,100,100);
        label.setOpaque(true);
        label.setBackground(Color.pink);

        this.add(label);
        this.setVisible(true);
    }
    @Override
    public void keyTyped(KeyEvent e){
        // 按下并释放键盘上的某个键时调用
        // keyTyped() = invoked when a key is typed,uses keyChar,char output
        switch (e.getKeyChar()){
            case 'a':label.setLocation(label.getX()-10,label.getY());
                break;
            case 'd':label.setLocation(label.getX()+10,label.getY());
                break;
            case 's':label.setLocation(label.getX(),label.getY()+10);
                break;
            case 'w':label.setLocation(label.getX(),label.getY()-10);
                break;
        }
    }

    @Override
    public void keyPressed(KeyEvent e){
        // keyPressed() = invoked when a physical key is pressed down,uses keycodes,int output
        // 键盘上的每一个键都对应着一个code，是一个int
        switch (e.getKeyCode()){
            // KeyEvent.VK_A是Java的一个常量，表示键盘上的"A"键。KeyEvent类中的每个VK_常量都对应一个键盘按键。这些常量通常用于键盘事件处理，如键盘按键的监听
            case KeyEvent.VK_A:label.setLocation(label.getX()-10,label.getY());
                break;
            case KeyEvent.VK_D:label.setLocation(label.getX()+10,label.getY());
                break;
            case KeyEvent.VK_S:label.setLocation(label.getX(),label.getY()+10);
                break;
            case KeyEvent.VK_W:label.setLocation(label.getX(),label.getY()-10);
                break;
        }
    }

    @Override
    public void keyReleased(KeyEvent e){
        // e.getKeyChar() represent the char that was released
        System.out.println("you released key char " + e.getKeyChar());
        //
        System.out.println("you released key code " + e.getKeyCode());
    }
}
```

