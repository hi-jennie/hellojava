package pet;

/**
 * @author rd_qinglin_mu
 * @description test
 * @单据标识
 * @date 2024/5/22 15:24
 **/
public class Test {
    public static void main(String[] args) {
        Keeper keeper = new Keeper("Jennie",24);
        Animal cat = new Cat("black",2);
        keeper.myPet(cat,"cat food");

    }
}
