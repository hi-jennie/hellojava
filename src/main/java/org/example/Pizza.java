package org.example;


public class Pizza {
    // attributes
    String name = "Margherita";
    String size = "Medium";
    String crust = "Thin";
    double price = 10.00;

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
