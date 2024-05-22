package pet;

/**
 * @author rd_qinglin_mu
 * @description superclass
 * @单据标识
 * @date 2024/5/22 15:25
 **/
public class Animal {
    private String color;
    private int age;

    Animal(){

    }
    Animal(String color, int age){
        this.color = color;
        this.age = age;
    }

    public void setColor(String color){
        this.color = color;
    }
    public String getColor(){
        return color;
    }
    public void setAge(int age){
        this.age = age;
    }
    public int getAge(){
        return age;
    }
    public void eat(String food){
        System.out.println("this animal is eating"+food);
    }
}
