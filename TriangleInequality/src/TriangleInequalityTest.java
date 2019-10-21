import org.junit.Test;

import static org.junit.Assert.*;

public class TriangleInequalityTest {
    @Test
    public void equilateralTriangle() {
        assertTrue(TriangleInequality.isTriangleExists(7.18, 7.18, 7.18));
    }

    @Test
    public void isoscelesTriangle() {
        assertTrue(TriangleInequality.isTriangleExists(7.18, 7.18, 10));
    }

    @Test
    public void rightTriangle() {
        assertTrue(TriangleInequality.isTriangleExists(3, 4, 5));
    }

    @Test
    public void arbitraryTriangle() {
        assertTrue(TriangleInequality.isTriangleExists(6, 7, 8));
    }

    @Test
    public void allSidesAreMaxDouble() {
        assertTrue(TriangleInequality.isTriangleExists(Double.MAX_VALUE, Double.MAX_VALUE, Double.MAX_VALUE));
    }

    @Test(expected = IllegalArgumentException.class)
    public void oneSideIsNegative() {
        TriangleInequality.isTriangleExists(-3, 4, 5);
    }

    @Test(expected = IllegalArgumentException.class)
    public void oneSideIsZero() {
        TriangleInequality.isTriangleExists(0, 1, 2);
    }

    @Test
    public void sumOfTwoSidesIsLessThanThird() {
        assertFalse(TriangleInequality.isTriangleExists(1, 2, 10));
    }

    @Test
    public void sumOfTwoSidesEqualsThird() {
        assertFalse(TriangleInequality.isTriangleExists(5.5, 5.5, 11));
    }

    @Test
    public void allSidesArePositiveInfinity() {
        assertFalse(TriangleInequality.isTriangleExists(Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY));
    }

}
