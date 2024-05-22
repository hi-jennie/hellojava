package sport;

/**
 * @author rd_qinglin_mu
 * @description subclass of person
 * @单据标识
 * @date 2024/5/22 21:41
 **/
public abstract class Coach extends Person{
    public Coach(String name, int age){
        super(name, age);
    }

    public abstract void teach();
}
