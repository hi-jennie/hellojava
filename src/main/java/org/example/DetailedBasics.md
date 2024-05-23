## 1.三元表达式
格式：`条件表达式 ? 表达式1 : 表达式2`
```java
int a = 2;
int b = 3;
// if a > b = true, c = a, else c = b
// the result has to be used(assigned) to a variable or printed
int c = a > b ? a : b;
System.out.println(c); // 3
```
## 2. case 穿透
* `case穿透' is allowed, which means if there is no `break` statement, 
the program will continue to execute the next `case` statement.
* situation to use `case穿透`:
    * when there are multiple `case` statements that need to execute the same code block.
    * when there are multiple `case` statements that need to execute the same code block, 
    and the code block is at the end of the `switch` statement.
  
* difference between switch and if-else:
    * `switch` is more suitable for a **single variable** that needs to compare multiple values.
    * `if-else` is more suitable for a **scope** that needs to compare multiple conditions.
```java
int a = 2;
switch (a) {
    case 1:
        System.out.println("1");
    case 2:
        System.out.println("2");
    case 3:
        System.out.println("3");
    default:
        System.out.println("default");
}

switch(a){
        // if there is only one line of code, there is no need to use {}
        // case 1->System.out.println("1");
        case 1->{
        // in this case, there is no need to use break statement to avoid case穿透
        System.out.

println("1");
    }
            case 2->{
            System.out.

println("2");
    }
}
```
## 3. difference between for and while
* `for` loop is more suitable for a **fixed number of iterations**.
* `while` loop is more suitable for a **variable number of iterations**,but you know the condition to stop the loop.
```java
int[] arr = {1, 2, 3, 4, 5};
int i = 0;
// for loop
for (int j = 0; j < arr.length; j++) {
    System.out.println(arr[j]);
}
// while loop
while (i < arr.length) {
    System.out.println(arr[i]);
    i++;
}
```
## 4.infinitive loop
how to control the infinitive loop:
* continue: skip the current iteration and continue to the next iteration.
* break: stop the whole loop.
```java
for (int i = 1; i < 6; i++){
    if (i == 3) {
        // skip the current iteration when i = 3,
        // continue means stop the current iteration and continue to the next iteration
        // so the output will be 1, 2, 4, 5
        continue;
    }
    System.out.println(i);
}

for (int i = 1; i < 6; i++){
    System.out.println(i);
    if (i == 3) {
        // break means stop the loop
        // so the output will be 1, 2
        break;
    }
    
}
```
## 5.Random
*  is a method that generates a random number between 0 and 1.
```java
import java.util.Random;
Random random = new Random();
// generate a random number between 0 and 15, including 0 but not including 15
int a = random.nextInt(11)+5;
```

## 6.array
* 数组的初始化就是给数组分配内存空间，并将数据存入容器的过程
* format: `type[] arr = new type[length]——动态初始化;`
* format: `type[] arr = new type[]{value1, value2, value3}——静态初始化;`
* once the array is created, the length of the array cannot be changed.
```java
// create an array with a fixed size
int[] arr = new int[5];
// create an array with initial values
int[] arr2 = new int[]{1, 2, 3, 4, 5};
// to simplify
int[] arr1 = {1, 2, 3, 4, 5};
// get the length of the array
int length = arr1.length;
// arr represents the memory address of the array
System.out.println(arr1); // [I@1b6d3586
// [ means it is an array, I means it is an integer array, @ means it is a memory address

// access the element of the array
int a = arr1[0];

// change the element of the array
arr1[0] = 10;

// how to iterate the array
for (int i = 0; i < arr1.length; i++) {
    System.out.println(arr1[i]);
}
// for each loop
for (int i : arr1) {
    System.out.println(i);
}
```
* 索引越界：当访问数组中不存在的索引时，会抛出ArrayIndexOutOfBoundsException异常

## 7.swap
* swap an array
```java
public class Main {
    public static void main(String[] args) {
       int[] arr = {1,2,3,4,5};
       int len = arr.length;
       int[] temp = new int[len];

       for(int i=0;i < arr.length;i++){
           temp[len-1] = arr[i];
           len--;
       }
       for(int i : temp){
           System.out.println(i);
       }
    }
}
// another way to swap an array
public class Main {
  public static void main(String[] args) {
    int[] arr = {1, 2, 3, 4, 5};
    for (int i = 0, j = arr.length - 1; i < j; i++, j--) {
      int temp = arr[i];
      arr[i] = arr[j];
      arr[j] = temp;
    }
    for (int i : arr) {
      System.out.println(i);
    }
  }
}
```
## 8.stack(栈) and heap(堆)
* stack: store the local variables and method calls.
* heap: store the objects and the reference variables.——use `new` to create objects.
```java
// stack
int a = 10;
int b = 20;
int c = a + b;
// heap
int[] arr = new int[5];
```

## 9. overload
* overload: the subclass has the same method as the superclass.
* 参数不同：类型不同，**顺序不同**，个数不同都会被认为是方法重载。

## 10.primitive type and reference type as method parameters
* primitive type: pass by value
* reference type: pass by reference
```java
public class Main {
    public static void main(String[] args) {
        int a = 10;
        int b = 20;
        swap(a, b);
        System.out.println("a: " + a + ", b: " + b); // a: 10, b: 20

        int[] arr = {1, 2, 3, 4, 5};
        change(arr);
        for (int i : arr) {
            System.out.println(i); // 10, 2, 3, 4, 5
        }
    }

    public static void swap(int a, int b) {
        int temp = a;
        a = b;
        b = temp;
    }
    // change the element of the array
    // arr was passed by reference
    public static void change(int[] arr) {
        arr[0] = 10;
    }
}
```
## 11.2D array
* 2D array: an array of arrays.
* format: `type[][] arr = new type[row][col];——动态初始化`
* format: `type[][] arr = new type[row][];——动态一维初始化`
* format: `type[][] arr = new type[][]{{value1, value2, value3}, {value4, value5, value6}};——静态初始化`
```java
int[][] arr = new int[3][4];
int[][] arr2 = new int[][]{{1, 2, 3}, {4, 5, 6}};
int[][] arr3 = {
        {1, 2, 3}, 
        {4, 5, 6}
};
// get the length of the 2D array
int row = arr3.length;
int col = arr3[0].length;
// access the element of the 2D array
int a = arr3[0][0];
// change the element of the 2D array
arr3[0][0] = 10;
```
## 12.private
* private: only the class itself can access the private members——to protect the data from being modified by other classes
* getter and setter: use getter and setter to access the private members.
* advantage of private: encapsulation.(封装：隐藏对象的属性和实现细节，仅对外提供公共访问方式)
* setter(parameters): set the value of the private member
* getter(): get the value of the private member
```java
public class Main {
    public static void main(String[] args) {
        Person person = new Person();
        person.setName("Tom");
        // person.name = "Tom"; // error
        // we can't access the private member directly by person.name ;
        System.out.println(person.getName());
    }
}
public class Person {
    private String name;
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
}
```
## 13.constructor
* 创造对象的时候，虚拟机会自动调用构造方法/constructor，作用是给成员变量初始化的
* if we don't define a constructor, the compiler will generate a default constructor.
* if we define a constructor, the compiler will not generate a default constructor.
* overload:has the same name but different parameters.在任何时候，最好是写上空参和带全部参数的构造方法/constructor
```java
public class Main {
    public static void main(String[] args) {
        Person person = new Person("Tom", 20);
        System.out.println(person.getName());
        System.out.println(person.getAge());
    }
}
public class Person {
    private String name;
    private int age;
    // constructor overloading-without parameters
    public Person() {
        
    }
    // constructor overloading-with parameters
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
}
```
## 14.标准的javaBean类
* 成员变量使用private修饰
* 提供至少两个构造方法
  * 无参构造方法
  * 带全部参数构造方法
  
* 成员方法
  * 提供每一个成员变量对应的set和get方法（alt+insert）快捷键/装PTG插件


## 15.一个对象中的内存图
seven steps：
* 加载class文件到方法区
* 声明局部变量
* 在堆内寸中开辟新空间
* 默认初始化
* 显示初始化
* 构造方法初始化（有参数的构造方法）
* 将堆内存地址赋值给局部变量
```java
Student student = new Student();

```
primitive data type:
  * 数据值是存储在自己的空间
  * 复制给其他变量，也是赋的真实的值
```java
int a = 10;
int b = a; // b = 10
```
reference data type:
  * 数据值是存储在堆内存中
  * 复制给其他变量，赋的是地址值
```java
Student student = new Student();
Student student2 = student; // student2 = student
```
## 16.scanner
* the next three methods :when there are whitespace,tabs,or enter, the method will stop reading the input.
  * nextInt(): get the next integer
  * nextDouble(): get the next double
  * next(): get the next string

* nextLine(): get the next line

## 17.API(学会使用API帮助文档)
* API: Application Programming Interface

## 18.String
* Java程序中的所有的字符串文字，都被看作是String类的实例/对象
* String类是final类，不能被继承
* String类是不可变的，一旦创建，不能被修改
```java
// 是省略了new关键字的写法
// 直接赋值时，会在字符串常量池（stringtable存在于堆内存中）中创建一个字符串对象，如果字符串常量池中已经存在该字符串，则直接返回该字符串的引用
String str = "hello";
// 也可以使用new关键字
String str2 = new String();
String str2 = new String("hello");
// 字符串的拼接
String str3 = "hello" + "world";
// 将字符数组转换为字符串
char[] arr = {'a', 'b', 'c'};
String str4 = new String(arr);// abc
// 将字节数组转换为字符串
byte[] arr2 = {97, 98, 99};// 转换对应的ASCII码
String str5 = new String(arr2);// abc
```
```java
// 字符串的比较
String str1 = "hello";
String str2 = "hello";
String str3 = "Hello";
System.out.println(str1 == str2); // true
System.out.println(str1 == str3); // false
System.out.println(str1.equals(str3)); 
System.out.println(str1.equalsIgnoreCase(str3)); // true
```
```java
// new关键字创建的字符串对象，会在堆内存中开辟新空间
String str4 = new String("hello");
String str5 = new String("hello");
System.out.println(str4 == str5);
// false,因为new关键字创建的字符串对象，会在堆内存中开辟新空间，所以比较的是·地址值
```
```java
// how to iterate the string
String str = "hello";
for (int i = 0; i < str.length(); i++) {
    System.out.println(str.charAt(i));
}
```
```java
// how to count the number of a character in a string
String str = "hellisgfwieu0826491USGuwDGuw";
int uppercaseCount = 0;
int lowercaseCount = 0;
int digitCount = 0;
for (int i = 0; i < str.length(); i++) {
    char c = str.charAt(i);
    // char 类型的变量在参与计算时，会自动转换为ASCII码
    if(c >= 'A' && c <= 'Z'){
        uppercaseCount++}
    else if(c >= 'a' && c <= 'z'){
        lowercaseCount++;
    }
    // 所以即使是数字本身也是跟0-9的ASCII码进行比较
    else if(c >= '0' && c <= '9'){
        digitCount++;
    }
}
```
```java
// convert the string to char array
public class Main {
    public static void main(String[] args) {
    int[] array = {1,2,3,4};
    System.out.println(arrToString(array));;

    }
    public static String arrToString(int[] arr) {
        if (arr == null) {
            return "";
        }
        if (arr.length == 0) {
            return "[]";
        }
        String result = "[";
        for(int i=0;i<arr.length;i++){
            if(i==arr.length-1){
                result = result+arr[i];
            }else {
                result = result+arr[i]+",";
            }
        }
        return result+"]";
    }
}
```
```java
// reverse a string
// 学会倒着遍历嗷
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("enter a string");
        String str = scanner.next();
        int len = str.length();
        String reverseStr = "";
        // 倒着遍历，还比较实用
        for(int i=len-1;i>=0;i--){
            reverseStr = reverseStr+str.charAt(i);
        }
        System.out.println(reverseStr);
    }
}
```
```java
// subString
String phoneNum = "12345678901";
String subPhoneNum = phoneNum.substring(3, 7);// 3 is included, 7 is not included
System.out.println(subPhoneNum); // 4567
phoneNum.substring(3);// 3 is included, the rest of the string
```
```java
// replace
String str = "hello";
String newStr = str.replace('l', 'w');
System.out.println(newStr); // hewwo
```
```java
// StringBuilder——create a mutable string
// method: append, insert, delete, reverse
// 应用场景：字符串的拼接与反转
StringBuilder sb = new StringBuilder();
sb.append("hello");
sb.append("world");
sb.toString();
sb.insert(5, " ");
sb.delete(5, 6);
sb.reverse();
```
```java
// SrringJoiner
// join the elements of the array with a delimiter
String[] arr = {"hello", "world", "java"};
// StringJoiner(",") represent how to join the elements
StringJoiner sj = new StringJoiner(",");
for (String s : arr) {
    sj.add(s);
}
// represent the length of the StringJoiner
int len = sj.length();
// convert a StringJoiner object to a string
System.out.println(sj.toString()); // hello,world,java
```
字符串拼接基本原理：
* 如果没有变量参与运算，编译器会直接将字符串拼接成一个字符串（触发常量优化机制），直接复用字符串常量池中的字符串
* 如果有变量参与运算，编译器会使用StringBuilder进行拼接，最后调用toString()方法生成一个新的字符串对象，所以每次相加都会创建一个新的对象，浪费内存
* 因此，对于字符串拼接，可以自己主动去使用StringBuilder进行拼接，减少内存的浪费
* 默认情况下，StringBuilder的初始容量是16，如果超过了16，会自动扩容，扩容的方式是原来的容量*2+2
```java
// StringBuider
String str = "hello";
// 系统会先将"hello"和"world"拼接成一个新的字符串对象，然后赋值给str2
String str2 = "hello"+"world";
str.toCharArry();// 将一个字符串变成一个字符数组
// 系统会自动创建一个StringBuilder对象，然后调用append方法进行拼接，最后调用toString方法生成一个新的字符串对象
String str3 = str+"world";
System.out.println(str2 == str3);// false

StringBuilder sb = new StringBuilder();
sb.append("hello");
sb.append("world");
str = sb.toString();
```
how to change a fixed String 
* substring
* convert to char array

## 19.ArrayList(集合)(add,delete,set,get)
* ArrayList: a dynamic array that can store **multiple** elements.（动态数组）
* it can expand or shrink automatically but the length of the array is fixed after it is created.
* unable to store primitive data type, only reference data type.(convert int->Integer,char->Character)
```java
// create an ArrayList
// <Integer> represents the type of the ArrayList,it's not int
ArrayList<String> list = new ArrayList<>();
System.println(list);// []
// add 
list.add("1");
list.add("2");
list.add("3");
// get 
int a = list.get(0);
// set
list.set(0, 10);// set the element of the ArrayList
// delete 
list.remove("1");// return boolean
list.remove(0);// return the element that is deleted

// get the size of the ArrayList(not length())
int size = list.size();// 2

// iterate the ArrayList
for (int i = 0; i < list.size(); i++) {
    System.out.println(list.get(i));
}
```

## 20.static
* 静态变量
  * **静态变量是随着的类的加载而加载的，优先于对象出现**
  * 被该类所有对象共享可以通过**类名**访问（也可以通过对象名调用）
  * 不属于对象而是属于class
* 静态方法
  * 静态方法只能访问静态变量和静态方法，不能访问成员变量和成员方法
  * 非静态方法可以访问所有（可以访问成员方法和成员变量和静态变量和静态方法）
  * 没有this关键字：this表示当前调用对象的地址值（普通的成员方法是有this作为隐藏的参数的）
  * 多用在测试类或者工具类：
    * 工具类：帮助完成一些功能，但是不描述事物特征的类（例如Math class）
    * 工具类类名要表达明确的功能
      * 私有化构造方法——不让外界创建对象
      * 方法定义为static
  
## 21.OOP——encapsulation
*  encapsulation——封装为一个类：对象代表什么，就得封装相对应的数据（attribute），并提供数据对应的行为（method）
*  继承：可以把subclass中的重复的代码抽取到superclass中，提高代码的复用性，同时增加其他的function，是subclass更强大
  * 什么时候用继承：当类与类之间，存在相同共性的内容是，**并满足子类是父类的一种**，就可以考虑使用继承，来优化代码
  * 一个子类只能继承一个父类，不能继承多个父类（只支持单继承，不支持多继承——子、父、间接父类）
  * 所有类都继承与Object类
  * 子类只能访问父类中的非私有的成员（public and protected）
  * constructor不能被继承，子类只能自己写
  * 不管私有还是非私有的成员变量，子类都能继承，但私有的不能直接使用
  * 不是所有父类方法都能被继承，只有父类中的虚方法（非private，非static，非final）才能被继承
  * @override方法的重写：当父类中的方法不能满足子类中需求是，需要进行方法重写。
  * 重写的方法会覆盖方法表中继承下来的方法（覆盖和拓展）
  * 子类重写父类方法时，访问权限必须大于父类且返回值类型必须小于等于父类

```java
public class Animal{
    String name;
    String enemy;
}
public class Cat extends Animal{
  String name;
  int age;
}

public class Main {
  public static void main(String[] args) {
      // 在加载Cat时，其父类也会被加载出来
      Cat cat = new Cat();
      // 赋值时采取就近原则，赋值给了cat的子类
      cat.name = "turkey";
      cat.age = 2;
      // enemy 没有被private修饰所以可以直接用.调用
      // 即使有private，能继承但无法使用和赋值，可以用getter和setter
      cat.enemy = "human";
  }
```
```java
public class Student extends person{
    public Student{
        // 首先访问父类的constructor，因为可能会用到父类中的数据，是默认的
        super();
        // 然后再是子类自己独特的constructor
    }
    // 访问父类中的有参构造，通过子类传进去
//    public Student(String args){
//       super(String args); 
    }
    public Student(){
    // 在本类内部调用有参构造，然后为其设了一个默认值
      this(0,"sichuan university");
    }
    public Student(int age,String school){
        this.age = age;
        this.school = school;
    }
}
```
* polymorphism：同类型的对象，表现出的不同形态
  * 父类类型 对象名称 = 子类对象
  * 有继承关系，有父类引用指向子类对象，有方法重写
  * 使用父类型作为参数，可以接收所有子类对象
* 优势：
  * 便于维护
  * 接收不同子类的参数
* 弊端：
  * 不能调用子类的特有方法
  * 解决方法：将父类转回子类
  * Cat c = (cat)cat,然后再去调用子类方法就行了
```java
public class Animal{
    String name = "animal";
    public void info(){
        sout("animal")
    }
}
public class Cat extends Animal{
    String name;
    @Override
    public void info(){
      sout("cat")
    }
    public void catchMouse(){
        sout("catch mouse")
    }
}

public class Main {
    public static void main(String[] args) {
       // 多态格式
      // auto type conversion
      Animal cat = new Cat();
      // 调用成员变量
      // 编译看左边：会首先看左边的父类时候是否有name这个变量，如果有，编译成功，否则失败
      // 运行也看左边：运行代码时，实际获取的就是左边父类成员变量的值
      sout(cat.name) // 打印animal
      
      // 调用成员方法
      // 编译看左边：会首先看左边的父类时候是否info()这个方法，如果有，编译成功，否则失败
      // 运行看右边：运行子类中的方法
      // 所以，多态必须有方法重写
      cat.info();// cat
      // compulsory type conversion
      Cat c = (cat)cat;
      c.catchMouse();
      // how to judge the type of the object
      if(cat instanceof Cat){
          Cat c = (Cat)cat;
          c.catchMouse();
      }else if (cat instanceof Dog){
          Dog d = (Dog)cat;
          d.watchHouse();
      }
      // another way to judge the type of the object
      if(cat instanceof Cat c){
          c.catchMouse();
          // if the object is a Cat object, then assign the object to c
      }
  }
```

## 22. package
* situations that no need to import:
  * the class is in the same package
  * the class is in the java.lang package
* if the two different packages have the same class name, we need to use the full class name to avoid ambiguity.
* principle of package:
  * package name is in lowercase
  * the domain name is reversed
  
## 23.final
* class: cannot be inherited 
* method: cannot be overridden (stand for a principle that cannot be changed)
* **variable**: cannot be modified and can be assigned a value only once
   * how to name a final variable: **all uppercase** and use `_` to separate the words
   * if a final variable is a reference type, **the reference cannot be changed, but the content of the reference can be changed.**
   * if a final variable is a primitive type, the value cannot be changed.

## 24. abstract
* abstract class: a class that contains abstract method **(it can't be instantiated)**
  * **(it can't be instantiated)**
  * it can have **constructors** because when the subclass is instantiated, the constructor of the superclass will be called.
  * the subclass of an abstract class must **override** **all the abstract methods** of the superclass
* abstract method: a method that has no implementation

## 25. interface
* can't be instantiated(**no constructor**)
* all the **methods** in the interface are **abstract methods**(public abstract by default)
* all the **variables** in the interface are **final variables**(public static final by default)
```java
public interface MyInterface {
    // all the variables in the interface are final variables
    int NUM = 10;
    String NAME = "Tom";
    // all the methods in the interface are abstract methods
    void method1();
    void method2();
    void method3();
    
    
}
public interface MyInterface2 {
    default void method4();
}
public interface MyInterface4 {
    default void method4();
}
public class MyClass1 implements MyInterface2, MyInterface4 {
    @Override
    // default method of these two interfaces have the same name
    // so the subclass has to override the default method
    public void method4() {
        System.out.println("method4");
    }
}

    
}
// 接口可以多继承
public interface MyInterface3 extends MyInterface, MyInterface2 {
    void method5();
}
// Myclass has to rewrite all the methods in the interface inlcude the methods of the parent interface 
public class MyClass implements MyInterface3 {
    @Override
    public void method1() {
        System.out.println("method1");
    }
    @Override
    public void method2() {
        System.out.println("method2");
    }
    @Override
    public void method3() {
        System.out.println("method3");
    }
    }
    @Override
    public void method5() {
        System.out.println("method5");
    }
}

``` 
JDK8 后新增的方法（default method和static method——带方法体的方法）
(接口中默认的方法是抽象方法，如果不写default，则、、)
* **default method**: a method that has a default implementation
  * the subclass can choose to override the default method **or not**
  * the default method is not an abstract method, so the subclass can choose to override it **or not**
  * if the subclass wants to override the default method, the default keyword must be removed
  * the default method can call the **static private default** method

* **static method**: can't be overridden(因为没被添加到虚方法表中)
  * the static method can be only called by the interface name
  
* **private method** :服务于默认和私有方法，抽取其中重复代码
```java
public interface MyInterface {
    void method1();
    void method2();
    void method3();
    default void method4() {
        System.out.println("default method");
        method6();
    }
    static void method5() {
        System.out.println("static method");
        method7()；
    }
    // 抽取重复代码在本接口中调用，对外界没有作用所以用private修饰
    // 普通私有方法是给default method服务的
    private void method6() {
        System.out.println("private method");
    }
    // 静态方法要使用加上static
    private static void method7() {
      System.out.println("private method");
    }
}
```

## 26. interface 的运用
接口类型 变量名 = new 实现类();
```java
public class Main {
    public static void main(String[] args) {
        MyInterface myInterface = new MyClass();
        myInterface.method1();
        
    }
}
```
adapter design pattern:适配器设计模式
```java
public interface MyInterface {
    void method1();

    void method2();

    void method3();
}
// 加入我只想用其中的method3,必须要重写所有的方法
public class MyClass implements MyInterface {
    @Override
    public void method1() {
        System.out.println("method1");
    }
    @Override
    public void method2() {
        System.out.println("method2");
    }
    @Override
    public void method3() {
        System.out.println("method3");
    }
}
// 适配器设计模式
// 创建一个抽象类，实现接口，然后重写所有的方法，这样在实现类中就可以只重写需要的方法
// abstract 避免其他类创建适配器类对象
public abstract class MyAdapter implements MyInterface {
    @Override
    public void method1() {
        // 空实现
    }
    @Override
    public void method2() {
    }
    @Override
    public void method3() {
        System.out.println("method3");
    }
}
// 然后让我的真正实现类继承我的适配器，就可以选择性重写了，因为如果直接implemet MyInterface的话，就必须重写所有的抽象方法
public class MyClass extends MyAdapter {
    @Override
    public void method3() {
        System.out.println("method3");
    }
}
```
## 27. inner class
内部类表示的事物是外部类的一部分，内部类单独出现没有意义，具有强相关性
* inner class: a class that is defined inside another class
  * inner class can access the members of the outer class
  * the outer class can access the members of the inner class by creating an object of the inner class
  * the inner class can be private, protected, public, or default
  
```java
public class Car {
    private String carName;
    private private int age = 10;
    // inner class
    public class Engine {
        private String name;
        private int age = 20;
        public void info() {
            private int age = 30
            System.out.println("name: " + name + ", power: " + power);
            // the inner class can access the members of the outer class
            System.out.println(carName);
            // there are three age variables
            System.out.println(age);// 30
            System.out.println(this.age);// 20
            // Car.this记录的就是外部类的地址值
            System.out.println(Car.this.age);// 10
        }
    // create a public method to return the innner object
    private class Engine1 {
      private String name;
      private double power;
      public void info() {
        System.out.println("name: " + name + ", power: " + power);
        // the inner class can access the members of the outer class
        System.out.println(carName);
      }    
    }
    public Engine getEngine1() {
      return new Engine();
    }
    // the outer class can access the members of the inner class by creating an object of the inner class
    public void test() {
        Engine engine = new Engine();
        engine.name = "engine";
        engine.power = 100;
        engine.info();
    }
    
}
// how to create an object of the inner class
public class Main {
    public static void main(String[] args) {
        Car car = new Car();
        Car.Engine engine = car.new Engine();
        // 内部类会记录外部类的地址
        // Car.Engine engine = new Car().new Engine();
        engine.info();
        // if the inner class is private, the outer class can't access the inner class
        
    }
}
```
内部类的分类：
* 成员内部类：写在成员位置，属于外部类的成员
* 局部内部类：定义在方法里面，类似于方法里面的局部变量
  * 外部无法使用，虚压在方法内部创建对象并使用
  * 该类可以直接访问外部类成员，也不可以访问方法内的局部变量
* 匿名内部类：没有名字的内部类
* **静态内部类**：static修饰的内部类，只能访问外部类中用static修饰的成员，如果想访问非静态成员，需要创建外部类对象
```java
public class Outer{
    int a = 10;
    static int b = 20;
    
    static class Inner{
        public void method(){
            // 只能访问外部类中用static修饰的成员
            System.out.println(b);
            System.out.println(a);// error
            // 因为a是非静态成员，只有才创建外部类对象时才存在
            Outer outer = new Outer();
            System.out.println(outer.a);
        }
        public static void method2(){
            System.out.println(b);
            // System.out.println(a);// error
        }
    }
}

public class Main {
    public static void main(String[] args) {
        // 不用创建外部类对象，直接创建内部类对象
        Outer.Inner inner = new Outer.Inner();
        inner.method();
        // 直接不用对象调用静态内部类中的静态方法，推荐
        Outer.Inner.method2();
    }
}
```
**局部内部类**
```java
public class Outer{
    int a = 10;
    public void method(){
        int b = 20;
        class Inner{
            public void show(){
                // 可以访问外部类的成员变量
                System.out.println(a);
                // 可以访问方法内的局部变量
                System.out.println(b);
            }
        }
        Inner inner = new Inner();
        inner.show();
    }
}
```
**匿名内部类**
```java
public abstract class Animal{
    public abstract void eat();
        
}

public abstract interface Swim{
    public abstract void swim();
}

public class Main {
    public static void main(String[] args) {
        // 花括号里面的才是一个真正的匿名内部类，前面写的一个类名，表示继承与Animal
        new Animal(){
            public void eat(){
                System.out.println("eat");
            }
        }.eat(); // new是新创建的一个对象，表示可以之久调用里面的方法
        // 前面写的是一个接口名，表示实现了这个接口，也叫接口实现类
        new Swim(){
            public void swim(){
                System.out.println("swim");
            }
        }.swim();
    }
}
// circumstances that need to use anonymous inner class
public class Main {
  public static void main(String[] args) {
      test(
           new Animal(){
               // 直接创建一个匿名类调用test，因为这个匿名类只使用一次
               // there is no need to create a seperate class 
               @Override
               System.out.println("this animal is eating"); 
           }   
      );
  }
  
  public void test(Animal animal) {
    animal.eat();
  }
}
```