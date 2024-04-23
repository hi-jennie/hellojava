# ** java notes——basic knowledge**

## 1. Java tutorial for beginner

```java
public class Main {
    // main method

    public static void main(String[] args) {
        // display on console within one line
        System.out.print("What's your favorite programming language?");
        System.out.print("I love java");

        // print in individual newline
        System.out.println("What's your favorite programming language?");
        System.out.println("I love java");

        // \n also stand for a new line,display in individual line
        System.out.print("What's your favorite programming language?\n");
        System.out.print("I love java\n");


        // \t means a tab
        System.out.print("\tWhat's your favorite programming language?\n");
        System.out.print("I love java\n");
        // \ stand for reverse the punctuation literally
        System.out.println("\"What's your favorite programming language\"");
        System.out.println("I love java");

        /*
        how to write multiple line of comment



         */
        // System.out.println(); ——sot（shortcut）
        System.out.println();
    }
}
```

## 2. variables

| primitive date type          | reference date type        |
|------------------------------|----------------------------|
| 8 types (boolean, byte,etc.) | user defined               |
| store date                   | store an address           |
| can only hold 1 value        | can hold more than 1 value |
| less memory                  | more memory                |
| faster                       | slower                     |

* how to initialize a variable 
    ```java
    public static void main(String[] args) {
        int x; //declaration
        x = 123; // assignment
        int y = 123; // initialization

        // when print x,there are no quotes,because x is a variable
        System.out.println(x);

        // print a string literally
        System.out.println("x");

        // how to format
        System.out.println("how much is this: "+x);

        byte n = 127;
        long m = 178387371849795L;

        float i = 3.14F;
        double k = 3.14;

        boolean l = true;

        char symbol = 'z';
        String name = "Jennie";
        System.out.println(name);
    }
    ```
## 3. swap two variables
  ```java
  public static void main(String[] args) {
      String x = "Rustin";
      String y = "Jennie";
      String temp;
      
      temp = x;
      x = y;
      y=temp;
      System.out.println(x);
      System.out.println(y);
}
  ```

## 4. user input
three main steps:
* import java.util.Scanner;
* Scanner scanner = new Scanner(System.in);
* String name = scanner.nextLine();
```java
import java.util.Scanner;
public static void main(String[] args) {
        // create a scanner object
        Scanner scanner = new Scanner(System.in);

        System.out.println("what's your name?");
        String name = scanner.nextLine();

        System.out.println("what's your age?");
        int age = scanner.nextInt();
        // after call nextInt(),\n won't be erased,so
        scanner.nextLine();

        System.out.println("what's your favorite color?");
        String color = scanner.nextLine();

        System.out.println("hello "+name);
        System.out.println("you are "+age+"years old");
        System.out.println("you like "+color);
    }
```

## 5. expressions(operands and operators)
operands = values, variables, numbers, quantity
operators = + - * / %
```java
public static void main(String[] args) {
    int friends = 10;
    friends = friends + 1;
    friends++;
    friends--;
    System.out.println(friends);
    
    // in this way can store the decimal, or else the decimal will be made redundant
    double age = 10;
    age = age / 3;
    System.out.println(age);
}
```

## 6. GUI introduction (Graphical User Interface)
```java
public static void main(String[] args) {
    String name = JOptionPane.showInputDialog("What is your name?");
    JOptionPane.showMessageDialog(null, "Hell0"+name);

    // Integer.parseInt() change a string to an int
    int age = Integer.parseInt(JOptionPane.showInputDialog("What is your age?"));
    JOptionPane.showMessageDialog(null, "you are"+age+" years old");

    //Double.parseDouble() change a string to a double
    double height = Double.parseDouble(JOptionPane.showInputDialog("What is your height?"));
    JOptionPane.showMessageDialog(null, "you are"+height+" cm tall");
    }
```


## 7. Math class
Math.abs(): 返回参数的绝对值。  <pre>int a = Math.abs(-10); // a = 10 </pre>
Math.max(a, b): 返回两个参数中的最大值。  <pre>int b = Math.max(3, 9); // b = 9 </pre>
Math.min(a, b): 返回两个参数中的最小值。  <pre>int c = Math.min(3, 9); // c = 3 </pre>
Math.sqrt(a): 返回参数的平方根。  <pre>double d = Math.sqrt(16); // d = 4.0 </pre>
Math.cbrt(a): 返回参数的立方根。  <pre>double e = Math.cbrt(27); // e = 3.0 </pre>
Math.pow(a, b): 返回第一个参数的第二个参数次方。  <pre>double f = Math.pow(2, 3); // f = 8.0 </pre>
Math.round(a): 返回最接近参数的整数。  <pre>long g = Math.round(3.6); // g = 4 </pre>
Math.ceil(a): 返回大于或等于参数的最小整数。  <pre>double h = Math.ceil(3.2); // h = 4.0 </pre>
Math.floor(a): 返回小于或等于参数的最大整数。  <pre>double i = Math.floor(3.8); // i = 3.0 </pre>
Math.random(): 返回一个介于0.0（包含）和1.0（不包含）之间的随机数。  <pre>double j = Math.random(); 

## 8. random number

```java
public static void main(String[] args) {

    // create a random instance
    Random random = new Random();

    // generate a random number between 0 and 99
    int x = random.nextInt(100);

    // generate a random double between 0 and 1
    double y = random.nextDouble();

    boolean z = random.nextBoolean();
    System.out.println(x);
    }
```

## 9. if statement
if(condition){
    // code block
}


```java
public static void main(String[] args) {
    int age = 20;

    if(age >= 75) {
        System.out.println("You are a senior");
    }
    else if(age >= 18){
        System.out.println("You are an adult");
    }
    else if(age >= 13){
        System.out.println("You are a teenager");
    }
    else {
        System.out.println("You are not an adult");
    }
}
```

## 10. switches
switch is used to select one of many code blocks to be executed
switch(expression){
    case value1:
        // code block
        break;
    case value2:
        // code block
        break;
    default:
        // code block
}
```java
public static void main(String[] args) {
    String day = "Monday";

    // compare values of day with each case
    // if day is equal to "Monday", print "Today is Monday"
    // if not, check the next case
    switch (day) {
        case "Monday":
            System.out.println("Today is Monday");
            break;
        case "Tuesday":
            System.out.println("Today is Tuesday");
            break;
        case "Wednesday":
            System.out.println("Today is Wednesday");
            break;
        case "Thursday":
            System.out.println("Today is Thursday");
            break;
        case "Friday":
            System.out.println("Today is Friday");
            break;
        case "Saturday":
            System.out.println("Today is Saturday");
            break;
        case "Sunday":
            System.out.println("Today is Sunday");
            break;
        default:
            System.out.println("Invalid day");
            break;
    }
}
```

## 11. logical operators
&&: and both conditions must be true
||: or at least one condition must be true
!: not reverses boolean value of a condition
```java
public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    System.out.println("Enter temperature: ");
    int temp = scanner.nextInt();

    if(temp > 30 && temp < 50){
        System.out.println("It's hot outside");
    }
}
```
```java
public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    System.out.println("press q or Q to quit: ");
    String response = scanner.next();

    if(response.equals("q") || response.equals("Q")){
        System.out.println("you quit the game");
    }
    else {
        System.out.println("you are still playing the game");
    }
}
```
```java
public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    System.out.println("press q or Q to quit: ");
    String response = scanner.next();

    if(!response.equals("q") && !response.equals("Q")){
        System.out.println("you are still playing the game");
    }
    else {
        System.out.println("you quit the game");
    }
}
```

## 12. while loop
```java
public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    String name = "";
    
    // check and ask for name
    while (name.isBlank()) {
        System.out.println("enter your name");
        name = scanner.next();
    }
    System.out.println("hello "+name);
    }
```
```java
public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    String name = "";
    
    // do while loop will execute the code block once, before checking if the condition is true
    do{
        System.out.println("enter your name");
        name = scanner.next();
    }while (name.isBlank());
    System.out.println("hello "+name);
    }
```

## 13. for loop
before begin the loop,we already know how many times we want to loop to iterate
```java
public static void main(String[] args) {
    for(int i = 10; i>=0;i--) {
        System.out.println(i);
    }
    System.out.println("happy new year");
}
```

## 14. nested loops
print: display on the same line
println: display on the next line
```java
public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int rows ;
    int columns;
    String symbols;

    System.out.println("enter the rows");
    rows = scanner.nextInt();
    System.out.println("enter the columns");
    columns = scanner.nextInt();
    System.out.println("enter the symbols");
    symbols = scanner.next();

    for(int i = 1; i<=rows;i++){
        System.out.println();
        for(int j = 1; j<=columns;j++){
            System.out.print(symbols);
        }
    }
}
```

## 15. arrays
arrays:used to store multiple values in a single variable
```java
public static void main(String[] args) {
    String[] cars = {"Camaro","Tesla","BMW"};

    // use index to change the value of an element
    cars[0] = "Mustang";

    // another way to declare an array
    String[] newCars = new String[5];
    cars[0] = "Volvo";
    cars[1] = "BMW";
    cars[2] = "Ford";
    System.out.println(cars[0]);
    
    // how to iterate through an array
    for(int i = 0;i<cars.length;i++){
        System.out.println(cars[i]);
    }
    
    // a new way to iterate through an array
    for (String car : cars) {
        System.out.println(car);
    }
}
```

## 16. 2D arrays

```java
public static void main(String[] args) {
    String[][] info = new String[4][3];

    info[0][0] = "Jennie";
    info[0][1] = "Mom";
    info[0][2] = "24";
    info[1][0] = "Rustin";
    info[1][1] = "Papa";
    info[1][2] = "27";
    info[2][0] = "aobai";
    info[2][1] = "son";
    info[2][2] = "2";
    info[3][0] = "turkey";
    info[3][1] = "son";
    info[3][2] = "2";

    // print the 2D array
    for(int i = 0;i< info.length;i++){
        System.out.println();
        // info[i].length is the length of the inner array
        for(int j = 0;j<info[i].length;j++){
            System.out.print(info[i][j]+" ");
        }
    }

    for (String[] strings : info) {
        System.out.println();
        for (String string : strings) {
            System.out.print(string + " ");
        }
    }
}
```
```java
// another way to create a 2D array
String[][] info = {
                    {"Jennie", "Mom", "24"},
                    {"Rustin", "Papa", "27"},
                    {"aobai", "son", "2"},
                    {"turkey", "son", "2"}
                  };
```

## 17. String methods
```java
public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    boolean result = scanner.nextline().equals("hello world");
    boolean result2 = scanner.nextline().equalsIgnoreCase("hello world");

    // check if the string is empty
    boolean result3 = str.isEmpty();

    int len = str.length(); // returns the length of the string

    // returns the character at the specified index "H"
    char ch = str.charAt(0);

    // returns the index of the first occurrence of the specified character
    int index = str.indexOf("o");

    // to uppercase
    String upper = str.toUpperCase();
    // to lowercase
    String lower = str.toLowerCase();

    // remove white spaces before and after the string
    String str2 = "    Hello World    ";
    String trimmed = str2.trim();

    // replace characters
    String newStr = str.replace("H", "W");
}


```

## 18. wrapper classes
provide a way to use primitive data types as objects(reference data types)
advantages of reference data types
* contain useful methods,
* can be used with collections
```java
public static void main(String[] args) {
    // autoboxing: converting primitive data type to object
    // unboxing: converting object to primitive data type
    Boolean a = true;
    Character b = '@';
    Integer c = 123;
    Double d = 3.14;

    // for String is reference type,so it use capital S
    String e = "Jennie";

    // so we can treat a,b, c, d as primitive value or object

    // unboxing: converting reference type a to primitive type
    if (a == true) {
        System.out.println("This is true");
    }
}
```

## 19. ArrayList
import java.util.ArrayList;
* a resizable array
* elements can be added and removed after compilation
* store reference data types (so we can use wrapper classes like Integer, Double, etc.)
```java
public static void main(String[] args) {
    // initialize a variable named food which store String
    ArrayList<String> food = new ArrayList<String>();

    food.add("pizza");
    food.add("hamburger");
    food.add("beef");

    // we can also use set() to change the value of the object(only change)
    food.set(1, "sushi");
    // we can also use remove() to remove the object
    food.remove(2);
    // use clear() to remove all the objects
    food.clear();  // now food is empty
    
    food.add("pizza");
    
    // food is an object, so we use.size() to get the length of the object
    for(int i = 0; i<food.size();i++){
        System.out.println(food.get(i));
    }
}
```

## 20. 2D ArrayList
a list of lists
```java
 public static void main(String[] args) {
    ArrayList<ArrayList<String>> groceryList = new ArrayList<>();

    ArrayList<String> fruits = new ArrayList<>();
    fruits.add("Banana");
    fruits.add("Apple");
    fruits.add("Orange");

    ArrayList<String> vegetables = new ArrayList<>();
    vegetables.add("Carrot");
    vegetables.add("Broccoli");
    vegetables.add("Potato");

    groceryList.add(fruits);
    groceryList.add(vegetables);

    System.out.println(groceryList.get(1));
    System.out.println(groceryList.get(1).get(0));
    }
```

## 21. for-each loop
* iterate through the elements in an array or a collection
* less steps,more readable
* less flexible

array
```java
public static void main(String[] args) {
    String[] animals = {"dog","cat","bird"};
    
    // i is a variable that represents the current element in the animals array
    // :stand for in 
    // for each String i in animals
    for(String i : animals){
        System.out.print(i+" ");
    }
}
```
collection
```java
public static void main(String[] args) {
    ArrayList<String> animals = new ArrayList<String>();
    animals.add("dog");
    animals.add("bird");
    animals.add("cat");
    for(String i : animals){
        System.out.print(i+" ");
    }
}
```

## 22. methods in java
```java
public class Main {
    public static void main(String[] args) {
        String name = "Jennie";
        int age = 24;
        // call hello() in main method ,we have to pass in 2 arguments
        hello(name,age);
        System.out.println(sum(3,4));
    }

    // hello() method accept 2 parameters String name and int age
    static void hello(String name, int age) {
        System.out.println("hello "+name);
        System.out.println("you are "+age);
    }
    // when method has a return value,we have to declare the date type of this return value
    static int sum(int x, int y){
        return x + y;
    }
}
```

## 23. overloaded methods
methods that have the same name but different parameters
method name + parameters = method signature
**when pass in different parameters, the method will identify and execute different code block**
```java
public class Main {
    public static void main(String[] args) {
        // overloaded method
        int x = sum(1, 2);
    }
    static int sum(int a, int b) {
        return a + b;
    }
    static int sum(int a, int b, int c) {
        return a + b + c;
    }
    static int sum(int a, int b, int c, int d) {
        return a + b + c + d;
    }
    static double sum(double a, double b) {
        return a + b;
    }
    static double sum(double a, double b, double c) {
        return a + b + c;
    }
}
```

## 24. printf() method
printf() = an optional method to control, format, and display text to the console window
* accept two arguments: format string and arguments
* % flags, precision, width, conversion-character
```java
public static void main(String[] args) {
    boolean myBoolean = true;
    char myChar = 'J';
    String myString = "Jennie";
    int myInt = 50;
    double myDouble = 1000;

    // [conversion-character]
    System.out.printf("%b ", myBoolean);
    System.out.printf("%c ", myChar);
    System.out.printf("%s ", myString);
    System.out.printf("%d ", myInt);
    System.out.printf("%f ", myDouble);

    // [width]:this present the width of the output
    System.out.printf("%5d ", myInt); // right justify
    System.out.printf("%-5f ", myDouble); // left justify

    // [precision]:this present the number of decimal places
    System.out.printf("%.2f ", myDouble); // 1000.00

    // [flags]:this present the flags
    System.out.printf("%+d ", myInt); // +:output will always be positive
    System.out.printf("%,f ", myDouble); // 1,000.000000
    System.out.printf("%020d ", myInt); // 00000000000000000050
    }
```

## 25. final keyword
anything declared with the final keyword cannot be changed
```java
public static void main(String[] args) {
        final double PI = 3.14;
        // PI can't be changed
    }
```

## 26. objects(OOP)
object: an instance of a class that may contain attributes and methods
```java
public class Car {
    // attributes
    String brand = "Tesla";
    int year = 2020;
    String colour = "blue";
    double price = 5000.00;

    // methods
    void drive() {
        System.out.println("you drive the car");
    }
    void brake() {
        System.out.println("you step on the brakes");
    }
}

public class Main {
    public static void main(String[] args) {
        Car mycar = new Car();
        System.out.println(mycar.year);
        mycar.drive();
        mycar.brake();

        // create another instance of Car class
        Car ldpCar = new Car();
        ldpCar.brake();
        System.out.println(ldpCar.brand);
    }
}
```

## 27. constructors
* constructor: a special method that is called when an object is instantiated
* advantages:allow us to assign different values to objects

```java
public class Human {
    String name;
    int age;
    double weight;
    
    // constructor
    Human(String name, int age, double weight) {
        this.name = name;
        this.age = age;
        this.weight = weight;
    }
    // how to gain access to the attributes of the class
    void eat() {
        System.out.println(this.name + " is eating");
    }
}

public class Main {
    public static void main(String[] args) {
        // create 2 different persons
        Human human1 = new Human("Jennie",24,43);
        Human human2 = new Human("Rustin",27,65);

        // then we can gain access to their respective attributes
        System.out.println(human1.name);
        System.out.println(human2.name);
    }
}
```

## 28. variable scope
| local                          | global                        |
|--------------------------------|-------------------------------|
| declared inside a method       | declared outside a method     |
| visible only to current method | visible to all parts of class |
| destroyed when method finishes | destroyed when program ends   |

```java
public class DiceRoller {
    // create a random object
    // it's a global variable, so all methods(include constructor) can access it 
    Random random;
    int number;
    

    Diceroller() {
        random = new Random();
        // actually, if we don't declare random as a global variable
        // we can also declare inside and pass in the random object as a parameter
        roller();
        // roller(random);
    }
    void roller() {
        number = random.nextInt(6)+1;
        System.out.println(number);
    }
}
```

## 29. overloaded constructors

* overloaded constructors: multiple constructors within a class with the same name but different parameters
```java
public class Pizza {
    // attributes
    String name;
    String size;
    String crust;
    double price;

    // overloaded constructor
    // when create a pizza object, we can pass different arguments 
    // and overload the constructor will create different objects
    Pizza(String name, String size, String crust) {
        this.name = name;
        this.size = size;
        this.crust = crust;
    }
    Pizza(String name, String size, String crust, double price) {
        this.name = name;
        this.size = size;
        this.crust = crust;
        this.price = price;
    }
    
    
}
```

## 30. toString() method
* toString() method: returns a string representation of the object
* when we print an object, it will call the toString() method
```java

```