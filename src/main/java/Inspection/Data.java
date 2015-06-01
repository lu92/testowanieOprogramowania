package Inspection;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lucjan on 01.06.15.
 */
public class Data {
    private List<Uczestnik> uczestnikList = new ArrayList<Uczestnik>();
    private int czasInspekcji;
    private int liczbaPrzeanalizowanychLiniKodow;
    private int iloscDefektow;

    public Data() {
    }

    public Data(List<Uczestnik> uczestnikList, int czasInspekcji, int liczbaPrzeanalizowanychLiniKodow, int iloscDefektow) {
        this.uczestnikList = uczestnikList;
        this.czasInspekcji = czasInspekcji;
        this.liczbaPrzeanalizowanychLiniKodow = liczbaPrzeanalizowanychLiniKodow;
        this.iloscDefektow = iloscDefektow;
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

    public int getIloscDefektow() {
        return iloscDefektow;
    }

    public void setIloscDefektow(int iloscDefektow) {
        this.iloscDefektow = iloscDefektow;
    }
}
