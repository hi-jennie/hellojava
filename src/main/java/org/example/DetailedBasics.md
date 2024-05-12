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