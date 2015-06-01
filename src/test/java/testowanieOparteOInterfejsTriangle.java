import org.junit.Assert;
import org.junit.Test;
import Triangle.Triangle;

public class testowanieOparteOInterfejsTriangle {

    @Test
    public void creatingValidTriangle() {
        Triangle triangle = new Triangle(2, 5, 6);
        Assert.assertEquals(2, triangle.getSide1());
        Assert.assertEquals(5, triangle.getSide2());
        Assert.assertEquals(6, triangle.getSide3());
    }

    @Test(expected = IllegalArgumentException.class)
    public void creatingInValidTriangle_0_4_5() {
        new Triangle(0, 4, 5);
    }

    @Test(expected = IllegalArgumentException.class)
    public void creatingInValidTriangle_4_0_5() {
        new Triangle(4, 0, 5);
    }

    @Test(expected = IllegalArgumentException.class)
    public void creatingInValidTriangle_4_5_0() {
        new Triangle(4, 5, 0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void creatingInValidTriangle_minus1_4_4() {
        new Triangle(-1, 4, 4);
    }

    @Test(expected = IllegalArgumentException.class)
    public void creatingInValidTriangle_4_minus1_4() {
        new Triangle(4, -1, 4);
    }

    @Test(expected = IllegalArgumentException.class)
    public void creatingInValidTriangle_4_4_minus1() {
        new Triangle(4, 4, -1);
    }

}
