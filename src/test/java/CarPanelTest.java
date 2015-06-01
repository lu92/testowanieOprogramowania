import CarPanelHomework.CarPanel;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by lucjan on 31.05.15.
 */
public class CarPanelTest {

    @Test
    public void PT1() {
        CarPanel carPanel = new CarPanel(0, 0);
        CarPanel.Response response = carPanel.getResult();
        Assert.assertEquals(0, response.getV(), 0.1);
        Assert.assertFalse(response.isWARN());
    }

    @Test
    public void PT2() {
        CarPanel carPanel = new CarPanel(120, 1);
        CarPanel.Response response = carPanel.getResult();
        Assert.assertEquals(120, response.getV(), 0.1);
        Assert.assertFalse(response.isWARN());
    }

    @Test
    public void PT3() {
        CarPanel carPanel = new CarPanel(Double.POSITIVE_INFINITY, 1);
        CarPanel.Response response = carPanel.getResult();
        Assert.assertEquals(Double.POSITIVE_INFINITY, response.getV(), 0.1);
        Assert.assertTrue(response.isWARN());
    }

    @Test
    public void PT4() {
        CarPanel carPanel = new CarPanel(1, 0.01);
        CarPanel.Response response = carPanel.getResult();
        Assert.assertEquals(100, response.getV(), 0.01);
//        Assert.assertEquals(0.01, response.getV(), 0.01);     //  test Adama Romana
        Assert.assertFalse(response.isWARN());
    }

    @Test
    public void PT5() {
        CarPanel carPanel = new CarPanel(120.01, 1);
        CarPanel.Response response = carPanel.getResult();
        Assert.assertEquals(120.01, response.getV(), 0.1);
        Assert.assertTrue(response.isWARN());
    }

    @Test
    public void PT6() {
        CarPanel carPanel = new CarPanel(Double.NEGATIVE_INFINITY, 2);
        CarPanel.Response response = carPanel.getResult();
        Assert.assertEquals(Double.NEGATIVE_INFINITY/2, response.getV(), 0.01);
        Assert.assertFalse(response.isWARN());
    }

    @Test
    public void PT7() {
        CarPanel carPanel = new CarPanel(-0.01, 0.02);
        CarPanel.Response response = carPanel.getResult();
//        Assert.assertEquals(-2, response.getV(), 0.01);    //  test Adama Romana
        Assert.assertEquals(-0.5, response.getV(), 0.01);
        Assert.assertFalse(response.isWARN());
    }

    @Test
    public void PT8() {
        CarPanel carPanel = new CarPanel(2, Double.NEGATIVE_INFINITY);
        CarPanel.Response response = carPanel.getResult();
        Assert.assertEquals(2 / Double.NEGATIVE_INFINITY, response.getV(), 0.01);
        Assert.assertFalse(response.isWARN());
    }

    @Test
    public void PT9() {
        CarPanel carPanel = new CarPanel(-40, -0.01);
        CarPanel.Response response = carPanel.getResult();
//        Assert.assertEquals(0.4, response.getV(), 0.1);   //  test Adama Romana
//        Assert.assertEquals(4000, response.getV(), 0.1);
        Assert.assertFalse(response.isWARN());
    }

    @Test
    public void PT10() {
        CarPanel carPanel = new CarPanel(120, 1.01);
        CarPanel.Response response = carPanel.getResult();
//        Assert.assertEquals(121.2, response.getV(), 0.1);   //  test Adama Romana
//        Assert.assertTrue(response.isWARN());   //  test Adama Romana
        Assert.assertEquals(120/1.01, response.getV(), 0.01);
        Assert.assertFalse(response.isWARN());
    }

    @Test
    public void PT11() {
        CarPanel carPanel = new CarPanel(2, Double.POSITIVE_INFINITY);
        CarPanel.Response response = carPanel.getResult();
        Assert.assertEquals(2/Double.POSITIVE_INFINITY, response.getV(), 0.1);
        Assert.assertFalse(response.isWARN());
    }

    @Test
    public void PT12() {
        CarPanel carPanel = new CarPanel(2*Double.NEGATIVE_INFINITY, 2);
        CarPanel.Response response = carPanel.getResult();
        Assert.assertEquals(Double.NEGATIVE_INFINITY, response.getV(), 0.1);
        Assert.assertFalse(response.isWARN());
    }

    @Test
    public void PT13() {
        CarPanel carPanel = new CarPanel(-0.02, 2);
        CarPanel.Response response = carPanel.getResult();
        Assert.assertEquals(-0.01, response.getV(), 0.1);
        Assert.assertFalse(response.isWARN());
    }

}
