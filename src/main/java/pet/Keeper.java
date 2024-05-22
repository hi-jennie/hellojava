package pet;

/**
 * @author rd_qinglin_mu
 * @description keeper
 * @单据标识
 * @date 2024/5/22 15:26
 **/
public class Keeper implements Swim{
    private String name;
    private int age;

    public Keeper(String name,int age){
        this.name = name;
        this.age = age;
    }

    public void myPet(Animal animal,String food){
        System.out.println(this.name+" is "+this.age+" years old");
        animal.eat(food);
    }

    @Override
    public void swim(){
        System.out.println("this keeper is able to swim");
    }
}
