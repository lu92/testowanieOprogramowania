package Triangle;

/**
 * Created by lucjan on 24.03.15.
 */
public class Triangle {
    private int side1, side2, side3;

    public Triangle(int s1, int s2, int s3) throws IllegalArgumentException {

        if (s1 <= 0 || s2 <= 0|| s3 <= 0)
            throw new IllegalArgumentException("invalid arguments - negative numbers");
        else if (s1 > s2 + s3)
            throw new IllegalArgumentException("invalid arguments - second and third sides of the triangle are too short");


        side1 = s1;
        side2 = s2;
        side3 = s3;
    }

    public boolean is_right () {
        if (((side1*side1) == ((side2*side2) + (side3*side3))) ||
                ((side2*side2) == ((side1*side1) + (side3*side3))) ||
                ((side3*side3) == ((side1*side1) + (side2*side2))))
            return true;
        else
            return false;
    }

    public boolean is_scalene () {
        if ((side1 != side2) && (side1 != side3) && (side2 != side3))
            return true;
        else
            return false;
    }

    public boolean is_isosceles () {
        if (((side1 == side2) && (side1 != side3)) ||
                ((side1 == side3) && (side1 != side2)) ||
                ((side2 == side3) && (side2 != side1)))
            return true;
        else
            return false;
    }

    public boolean is_equilateral () {
        if ((side1 == side2) && (side1 == side3))
            return true;
        else
            return false;
    }

    public int getSide1() {
        return side1;
    }

    public int getSide2() {
        return side2;
    }

    public int getSide3() {
        return side3;
    }
}
