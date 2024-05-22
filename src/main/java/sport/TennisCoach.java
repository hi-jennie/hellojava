package sport;

/**
 * @author rd_qinglin_mu
 * @description subclass of coach
 * @单据标识
 * @date 2024/5/22 21:43
 **/
public class TennisCoach extends Coach implements Language{
    public TennisCoach(String name, int age)
    {
        super(name, age);
    }

    @Override
    public void teach()
    {
        System.out.println("TennisCoach teach");
    }

    @Override
    public void speak()
    {
        System.out.println("TennisCoach speak");
    }
}
