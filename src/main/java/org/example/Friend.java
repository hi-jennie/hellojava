package org.example;

/**
 * @author rd_qinglin_mu
 * @description static modifier
 * @单据标识
 * @date 2024/4/24 16:48
 **/
public class Friend {
    String name;
    // with static modifier, this attribute belongs to the class
    // therefore it isn't unique to each object, but shared by all objects
    // but we cat access it without creating an object
    static int numberOfFriends;

    Friend(String name){
        this.name = name;
        numberOfFriends++;
    }

    static void displayFriends(){
        System.out.println("You have "+numberOfFriends+" friends");
    }
}
