import Inspection.InspectionCalculator;
import Inspection.Uczestnik;
import junit.framework.Assert;
import org.junit.Test;

/**
 * Created by lucjan on 01.06.15.
 */
public class InspectionCalculatorTest {

    @Test
    public void test() {
        InspectionCalculator inspectionCalculator = new InspectionCalculator(2, 250, 3000);

        inspectionCalculator.addUczestnik(new Uczestnik("Jan", "Kowalski", 2, 50));
        inspectionCalculator.addUczestnik(new Uczestnik("Adam", "Skiba", 2, 60));
        inspectionCalculator.addUczestnik(new Uczestnik("Łukasz", "Małek", 2, 40));
        inspectionCalculator.addUczestnik(new Uczestnik("Anna", "Hałas", 2, 30));
        inspectionCalculator.addUczestnik(new Uczestnik("Justyna", "Las", 2, 500));

        Assert.assertEquals(5, inspectionCalculator.getUczestnikList().size());
        InspectionCalculator.Wynik wynik = inspectionCalculator.wykonajObliczenia();

        org.junit.Assert.assertEquals(2720, wynik.getCalkowityKosztInspekcji(), 0.01);
        org.junit.Assert.assertEquals(6, wynik.getLiczbaBledowDoIlosciKodu(), 0.01);
        org.junit.Assert.assertEquals(250/15, wynik.getIloscDefektow(), 0.01);
        org.junit.Assert.assertEquals(48000, wynik.getKosztDefektowBezDokonanejInspekcji(), 0.01);
    }

}
