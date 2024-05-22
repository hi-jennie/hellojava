package pet;

/**
 * @author rd_qinglin_mu
 * @description subclass
 * @单据标识
 * @date 2024/5/22 15:25
 **/
public class Cat extends Animal{

    public Cat(){

    }
    public Cat(String color,int age){
        super(color,age);
    }
    @Override
    public void eat(String food){
        System.out.println(super.getAge()+" years old "+super.getColor()+" cat"+" is eating "+food);
    }

    public void catMouse(){
        System.out.println("this cat can catch mouse");
    }
}
