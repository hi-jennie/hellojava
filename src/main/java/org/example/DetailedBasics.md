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