package CarPanelHomework;

/**
 * Created by lucjan on 30.05.15.
 */
public class CarPanel {

//    zdefiniowane dwie stale bo Double.MIN_VALUE zwraca najmniejsza dodatnia wartosc
//    public static final double MAX_DOUBLE = Double.MAX_VALUE;
//    public static final double MIN_DOUBLE = Double.MAX_VALUE * -1;

    private double s;   //  jednostka metry
    private double t;   //  jednostka sekundy

    public CarPanel(double s, double t) {
        this.s = s;
        this.t = t;
    }

    public Response getResult() {
        Response response = null;
//        if (s/t <= 120)
//            return new Response(s/t, false);
//
//        if (s/t > 120)
//            return new Response(s/t, true);

        if (s == 0 && t ==0)
            return new Response(0, false);

        if (s > 0 && t > 0 && t <=1 && s/t <= 120 )
            return new Response(s/t, false);

        if (s > 0 && t > 0 && t <=1 && s/t > 120 )
            return new Response(s/t, true);

        if (s < 0 && t > 0 && s/t <= 120 )
            return new Response(s/t, false);

        if (s < 0 && t < 0 )
            return new Response(s/t, false);

        if ( s/t <=120)
            return new Response(s/t, false);

        if ( s/t >120)
            return new Response(s/t, true);



        return response;
    }

    public class Response {
        private double v;   //  jednostka km/s
        private boolean WARN = false;   // alarm o przekroczeniu predkosci

        public Response(double v, boolean WARN) {
            this.v = v;
            this.WARN = WARN;
        }

        public double getV() {
            return v;
        }

        public boolean isWARN() {
            return WARN;
        }
    }


}
