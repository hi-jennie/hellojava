package sport;

/**
 * @author rd_qinglin_mu
 * @description subclass of athlete
 * @单据标识
 * @date 2024/5/22 21:42
 **/
public class TennisAthlete extends Athlete implements Language{
    public TennisAthlete(String name,int age){
        super(name,age);
    }
    @Override
    public void learn() {
        System.out.println("TennisAthlete learn");
    }
    @Override
    public void speak() {
        System.out.println("TennisAthlete speak");
    }
}
