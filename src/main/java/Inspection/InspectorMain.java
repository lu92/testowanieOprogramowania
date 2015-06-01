package Inspection;

import java.util.Scanner;

/**
 * Created by lucjan on 01.06.15.
 */
public class InspectorMain {

    private static Scanner scanner = new Scanner(System.in);
    private static InspectionCalculator inspectionCalculator = new InspectionCalculator();

    public static void main(String[] args) {

    }

    private static  void uruchomKalkulator() {
        System.out.println("Podaj liczbe uczestnikow : ");
        int liczbaUczestnikow = scanner.nextInt();

        while (liczbaUczestnikow-- > 0)
            inspectionCalculator.addUczestnik(dodajUczestnika());


        System.out.println("Podaj Czas Inspekcji : ");
        int czasInspekcji = scanner.nextInt();


        System.out.println("Podaj ilosc przeanalizowanych lini kodu : ");
        int iloscLiniKodu = scanner.nextInt();

        System.out.println("Podaj cene jednego defektu : ");
        double cenaDefektu = scanner.nextDouble();

        inspectionCalculator.setCzasInspekcji(czasInspekcji);
        inspectionCalculator.setLiczbaPrzeanalizowanychLiniKodow(iloscLiniKodu);
        inspectionCalculator.setCenaDefektu(cenaDefektu);

        pokazWynik(inspectionCalculator.wykonajObliczenia());

    }

    private static void pokazWynik(InspectionCalculator.Wynik wynik) {
        System.out.println("Calkowity koszt inspekcji : " + wynik.getCalkowityKosztInspekcji());
        System.out.println("Liczba bledow do ilosci kodu : " + wynik.getLiczbaBledowDoIlosciKodu());
        System.out.println("Ilosc defektow : " + wynik.getIloscDefektow());
        System.out.println("Koszt samych defektow : " + wynik.getKosztDefektowBezDokonanejInspekcji());
    }


    private static Uczestnik dodajUczestnika() {

        Uczestnik uczestnik = new Uczestnik();

        System.out.println("Podaj imie");
        uczestnik.setName(scanner.nextLine());

        System.out.println("Podaj nazwisko");
        uczestnik.setLastname(scanner.nextLine());

        System.out.println("Podaj czas poswiecony na przygotowanie do inspekcji");
        uczestnik.setCzasPoswieconyNaPrzygotowanieDoInspekcji(scanner.nextInt());

        System.out.println("Podaj koszt jednej godziny pracy");
        uczestnik.setKosztJednejGodzinyPracy(scanner.nextInt());

        return uczestnik;
    }
}
