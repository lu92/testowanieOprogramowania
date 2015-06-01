/**
 * Created by lucjan on 01.06.15.
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("min " + Double.MIN_VALUE);
        System.out.println("max " + Double.MAX_VALUE);
        System.out.println(Double.NEGATIVE_INFINITY);
        if (Double.MIN_VALUE < 0)
            System.out.println("Less");
        else
            System.out.println("More");
    }
}
