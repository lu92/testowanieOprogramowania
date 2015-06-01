package Inspection;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lucjan on 01.06.15.
 */
public class InspectionCalculator {

//    kalkulator podaje ilosc bledow wedlug ustalonego procentu
    private static final int procentZnalezieniaBledu = 15;

    private List<Uczestnik> uczestnikList = new ArrayList<Uczestnik>();
    private int czasInspekcji;
    private int liczbaPrzeanalizowanychLiniKodow;
    private double cenaDefektu;

    public InspectionCalculator() {
    }

    public InspectionCalculator(int czasInspekcji, int liczbaPrzeanalizowanychLiniKodow, double cenaDefektu) {
        this.czasInspekcji = czasInspekcji;
        this.liczbaPrzeanalizowanychLiniKodow = liczbaPrzeanalizowanychLiniKodow;
        this.cenaDefektu = cenaDefektu;
    }

    public Wynik wykonajObliczenia() {
        double koszt = 0;

//        koszt przygotowania do inspekcji
        for (Uczestnik uczestnik : getUczestnikList())
            koszt += uczestnik.getKosztJednejGodzinyPracy() * uczestnik.getCzasPoswieconyNaPrzygotowanieDoInspekcji();

//        koszt samej inspekcji
        for (Uczestnik uczestnik : getUczestnikList())
            koszt += uczestnik.getKosztJednejGodzinyPracy() * czasInspekcji;

        return new Wynik(koszt,(liczbaPrzeanalizowanychLiniKodow/procentZnalezieniaBledu) * 100/ liczbaPrzeanalizowanychLiniKodow ,liczbaPrzeanalizowanychLiniKodow/procentZnalezieniaBledu, liczbaPrzeanalizowanychLiniKodow/procentZnalezieniaBledu * cenaDefektu);

    }

    public class Wynik {
        private double calkowityKosztInspekcji;
        private double liczbaBledowDoIlosciKodu;
        private int iloscDefektow;
        private double kosztDefektowBezDokonanejInspekcji;


        public Wynik(double calkowityKosztInspekcji, double liczbaBledowDoIlosciKodu, int iloscDefektow, double kosztDefektowBezDokonanejInspekcji) {
            this.calkowityKosztInspekcji = calkowityKosztInspekcji;
            this.liczbaBledowDoIlosciKodu = liczbaBledowDoIlosciKodu;
            this.iloscDefektow = iloscDefektow;
            this.kosztDefektowBezDokonanejInspekcji = kosztDefektowBezDokonanejInspekcji;
        }

        public double getCalkowityKosztInspekcji() {
            return calkowityKosztInspekcji;
        }

        public double getLiczbaBledowDoIlosciKodu() {
            return liczbaBledowDoIlosciKodu;
        }

        public int getIloscDefektow() {
            return iloscDefektow;
        }

        public double getKosztDefektowBezDokonanejInspekcji() {
            return kosztDefektowBezDokonanejInspekcji;
        }
    }


    public void addUczestnik(Uczestnik ... ListaUczestników) {
        for (Uczestnik uczestnik : ListaUczestników)
            uczestnikList.add(uczestnik);
    }

    public List<Uczestnik> getUczestnikList() {
        return uczestnikList;
    }

    public void setUczestnikList(List<Uczestnik> uczestnikList) {
        this.uczestnikList = uczestnikList;
    }

    public int getCzasInspekcji() {
        return czasInspekcji;
    }

    public void setCzasInspekcji(int czasInspekcji) {
        this.czasInspekcji = czasInspekcji;
    }

    public int getLiczbaPrzeanalizowanychLiniKodow() {
        return liczbaPrzeanalizowanychLiniKodow;
    }

    public void setLiczbaPrzeanalizowanychLiniKodow(int liczbaPrzeanalizowanychLiniKodow) {
        this.liczbaPrzeanalizowanychLiniKodow = liczbaPrzeanalizowanychLiniKodow;
    }

    public static int getProcentZnalezieniaBledu() {
        return procentZnalezieniaBledu;
    }

    public double getCenaDefektu() {
        return cenaDefektu;
    }

    public void setCenaDefektu(double cenaDefektu) {
        this.cenaDefektu = cenaDefektu;
    }
}
