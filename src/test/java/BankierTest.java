import BankierHomework.Bankier;
import org.junit.Assert;
import org.junit.Test;


/**
 * Created by lucjan on 31.05.15.
 */
public class BankierTest {

    @Test
    public void PT1 () {
        Bankier bankier = new Bankier(6000, true, true);
        Bankier.Result result =  bankier.getResponse();
        Assert.assertFalse(result.isOfertaKarty());
        Assert.assertFalse(result.isOfertaKredytu());
        Assert.assertTrue(result.isPrzyznanieKredytu());
    }

    @Test
    public void PT2 () {
        Bankier bankier = new Bankier(3500, true, false);
        Bankier.Result result =  bankier.getResponse();
        Assert.assertFalse(result.isOfertaKarty());
        Assert.assertTrue(result.isOfertaKredytu());
        Assert.assertFalse(result.isPrzyznanieKredytu());
    }

    @Test
    public void PT3 () {
        Bankier bankier = new Bankier(5000.01, false, true);
        Bankier.Result result =  bankier.getResponse();
        Assert.assertTrue(result.isOfertaKarty());
        Assert.assertTrue(result.isOfertaKredytu());
        Assert.assertTrue(result.isPrzyznanieKredytu());
    }

    @Test
    public void PT4 () {
        Bankier bankier = new Bankier(12832, false, false);
        Bankier.Result result =  bankier.getResponse();
        Assert.assertTrue(result.isOfertaKarty());
        Assert.assertTrue(result.isOfertaKredytu());
        Assert.assertFalse(result.isPrzyznanieKredytu());
    }

    @Test
    public void PT5 () {
        Bankier bankier = new Bankier(2004.22, true, true);
        Bankier.Result result =  bankier.getResponse();
        Assert.assertFalse(result.isOfertaKarty());
        Assert.assertFalse(result.isOfertaKredytu());
        Assert.assertFalse(result.isPrzyznanieKredytu());
    }

    @Test
    public void PT6 () {
        Bankier bankier = new Bankier(0, false, false);
        Bankier.Result result =  bankier.getResponse();
        Assert.assertFalse(result.isOfertaKarty());
        Assert.assertTrue(result.isOfertaKredytu());
        Assert.assertFalse(result.isPrzyznanieKredytu());
    }

}
