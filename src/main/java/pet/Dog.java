package pet;

/**
 * @author rd_qinglin_mu
 * @description dog
 * @单据标识
 * @date 2024/5/22 15:35
 **/
public class Dog extends Animal implements Swim{
    public Dog(){

    }
    public Dog(String color,int age){
        super(color,age);
    }

    @Override
    public void eat(String food){
        System.out.println(super.getAge()+" years old "+super.getColor()+" dog"+" is eating "+food);
    }

    public void watchHome(){
        System.out.println("this dog is able to watch home");
    }

    @Override
    public void swim(){
        System.out.println("this dog is able to swim");
    }
}
