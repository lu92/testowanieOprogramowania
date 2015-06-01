import org.junit.Assert;
import org.junit.Test;
import Triangle.Triangle;

public class testowanieOparteOFunkcjonalnoscTriangle {

    @Test
    public void isScalene() {
        Triangle triangle = new Triangle(2, 5, 6);
        Assert.assertTrue("czy trojkat jest roznoboczny?", triangle.is_scalene());
    }

    @Test
    public void isIsoscelesButNotEquilateral() {
        Triangle triangle = new Triangle(3, 7, 7);
        Assert.assertTrue("czy trojkat jest rownoramienny ale nie rownoboczny?", triangle.is_isosceles());
    }

    @Test
    public void isEquilateral() {
        Triangle triangle = new Triangle(4, 4, 4);
        Assert.assertTrue("czy trojkat jest rownoboczny?", triangle.is_equilateral());
    }

    @Test(expected = IllegalArgumentException.class)
    public void InValidTriangle() {
        Triangle triangle = new Triangle(4, 5, 0);
    }

    @Test
    public void isRight() {
        //      permutacje trojkate o bokach (3, 4, 5) ktory jest prostokatny
        Assert.assertTrue("czy trojkat jest prostokatny?", new Triangle(3, 4, 5).is_right());
        Assert.assertTrue("czy trojkat jest prostokatny?", new Triangle(4, 5, 3).is_right());
        Assert.assertTrue("czy trojkat jest prostokatny?", new Triangle(5, 3, 4).is_right());

        Assert.assertTrue("czy trojkat jest prostokatny?", new Triangle(5, 4, 3).is_right());
        Assert.assertTrue("czy trojkat jest prostokatny?", new Triangle(4, 3, 5).is_right());
        Assert.assertTrue("czy trojkat jest prostokatny?", new Triangle(3, 5, 4).is_right());
    }

    //      Reverse of Tests

    @Test
    public void isNotScalene() {
        Assert.assertFalse("czy trojkat(2, 5, 5) jest roznoboczny", new Triangle(2, 5, 5).is_scalene());
        Assert.assertFalse("czy trojkat(5, 2, 5) jest roznoboczny", new Triangle(5, 2, 5).is_scalene());
        Assert.assertFalse("czy trojkat(5, 5, 2) jest roznoboczny", new Triangle(5, 5, 2).is_scalene());
    }


    @Test(expected = IllegalArgumentException.class)
    public void isNotRight() {
        //      permutacje trojkate o bokach (1, 4, 5) ktory nie jest prostokatny
        Assert.assertFalse("czy trojkat(1, 4, 5) jest prostokatny?", new Triangle(1, 4, 5).is_right());
        Assert.assertFalse("czy trojkat(1, 4, 5) jest prostokatny?", new Triangle(4, 5, 1).is_right());

        //  cause exception during creation Triangle
        Assert.assertFalse("czy trojkat(1, 4, 5) jest prostokatny?", new Triangle(5, 3, 1).is_right());

        Assert.assertFalse("czy trojkat(1, 4, 5) jest prostokatny?", new Triangle(5, 4, 1).is_right());
        Assert.assertFalse("czy trojkat(1, 4, 5) jest prostokatny?", new Triangle(4, 1, 5).is_right());
        Assert.assertFalse("czy trojkat(1, 4, 5) jest prostokatny?", new Triangle(1, 5, 4).is_right());
    }

    @Test
    public void isNotEquilateral() {
        Assert.assertFalse(new Triangle(1, 4, 4).is_equilateral());
        Assert.assertFalse(new Triangle(4, 1, 4).is_equilateral());
        Assert.assertFalse(new Triangle(4, 4, 1).is_equilateral());
    }

    @Test
    public void LargeArguments() {

    }


}
