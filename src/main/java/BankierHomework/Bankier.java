package BankierHomework;

/**
 * Created by lucjan on 30.05.15.
 */
public class Bankier {
    private double dochody;
    private boolean maKarteKredytowa;
    private boolean zlozylWniosek;

    public Bankier(double dochody, boolean maKarteKredytowa, boolean zlozylWniosek) {
        this.dochody = dochody;
        this.maKarteKredytowa = maKarteKredytowa;
        this.zlozylWniosek = zlozylWniosek;
    }

    public Result getResponse() {
        Result result = null;
        if (dochody >= 5000 && maKarteKredytowa == true && zlozylWniosek == true)
            result = new Result(false, false, true);

        if (maKarteKredytowa == true && zlozylWniosek == false)
            result = new Result(false, true, false);

        if (dochody >= 5000 && maKarteKredytowa == false && zlozylWniosek == true)
            result = new Result(true, true, true);

        if (dochody >= 5000 && maKarteKredytowa == false && zlozylWniosek == false)
            result = new Result(true, true, false);

        if (dochody < 5000 && zlozylWniosek == true)
            result = new Result(false, false, false);

        if (dochody < 5000 && maKarteKredytowa == false && zlozylWniosek == false)
            result = new Result(false, true, false);

        return result;
    }



    public class Result {
        private boolean ofertaKarty;
        private boolean ofertaKredytu;
        private boolean przyznanieKredytu;

        public Result(boolean ofertaKarty, boolean ofertaKredytu, boolean przyznanieKredytu) {
            this.ofertaKarty = ofertaKarty;
            this.ofertaKredytu = ofertaKredytu;
            this.przyznanieKredytu = przyznanieKredytu;
        }

        public boolean isOfertaKarty() {
            return ofertaKarty;
        }

        public boolean isOfertaKredytu() {
            return ofertaKredytu;
        }

        public boolean isPrzyznanieKredytu() {
            return przyznanieKredytu;
        }
    }

}
