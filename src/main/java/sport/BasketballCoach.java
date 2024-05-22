package sport;

/**
 * @author rd_qinglin_mu
 * @description subclass of coach
 * @单据标识
 * @date 2024/5/22 21:44
 **/
public class BasketballCoach extends Person{
    public BasketballCoach(String name, int age){
        super(name, age);
    }

    public void teach(){
        System.out.println("I am a basketball coach, I teach basketball.");
    }

}
