package Inspection;

/**
 * Created by lucjan on 01.06.15.
 */
public class Uczestnik {
    private String name;
    private String lastname;
    private int czasPoswieconyNaPrzygotowanieDoInspekcji;
    private double kosztJednejGodzinyPracy;

    public Uczestnik() {
    }

    public Uczestnik(String name, String lastname, int czasPoswieconyNaPrzygotowanieDoInspekcji, double kosztJednejGodzinyPracy) {
        this.name = name;
        this.lastname = lastname;
        this.czasPoswieconyNaPrzygotowanieDoInspekcji = czasPoswieconyNaPrzygotowanieDoInspekcji;
        this.kosztJednejGodzinyPracy = kosztJednejGodzinyPracy;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public int getCzasPoswieconyNaPrzygotowanieDoInspekcji() {
        return czasPoswieconyNaPrzygotowanieDoInspekcji;
    }

    public void setCzasPoswieconyNaPrzygotowanieDoInspekcji(int czasPoswieconyNaPrzygotowanieDoInspekcji) {
        this.czasPoswieconyNaPrzygotowanieDoInspekcji = czasPoswieconyNaPrzygotowanieDoInspekcji;
    }

    public double getKosztJednejGodzinyPracy() {
        return kosztJednejGodzinyPracy;
    }

    public void setKosztJednejGodzinyPracy(double kosztJednejGodzinyPracy) {
        this.kosztJednejGodzinyPracy = kosztJednejGodzinyPracy;
    }
}
