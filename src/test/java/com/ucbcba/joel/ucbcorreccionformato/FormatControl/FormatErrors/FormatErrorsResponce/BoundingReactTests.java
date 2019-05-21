package com.ucbcba.joel.ucbcorreccionformato.FormatControl.FormatErrors.FormatErrorsResponce;

import com.ucbcba.joel.ucbcorreccionformato.FormatControl.FormatErrors.FormatErrorResponse.BoundingRect;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BoundingReactTests {

    private BoundingRect boundingRect;

    @Before
    public void setUp() {
        boundingRect = new BoundingRect(1, 1, 2, 2, 3, 3);
    }

    @Test
    public void getX1() {
        assertEquals(1.0f , boundingRect.getX1(), 0.0f);
    }

    @Test
    public void getY1() {
        assertEquals(1.0f , boundingRect.getY1(), 0.0f);
    }

    @Test
    public void getX2() {
        assertEquals(2.0f , boundingRect.getX2(), 0.0f);
    }

    @Test
    public void getY2() {
        assertEquals(2.0f , boundingRect.getY2(), 0.0f);
    }

    @Test
    public void getWidth() {
        assertEquals(3.0f , boundingRect.getWidth(), 0.0f);
    }

    @Test
    public void getHeight() {
        assertEquals(3.0f , boundingRect.getHeight(), 0.0f);
    }

    @Test
    public void setX1() {
        boundingRect.setX1(2.0f);
        assertEquals(2.0f, boundingRect.getX1(), 0.0f);
    }

    @Test
    public void setY1() {
        boundingRect.setY1(2.0f);
        assertEquals(2.0f, boundingRect.getY1(), 0.0f);
    }

    @Test
    public void setX2() {
        boundingRect.setX2(2.0f);
        assertEquals(2.0f, boundingRect.getX2(), 0.0f);
    }

    @Test
    public void setY2() {
        boundingRect.setY2(2.0f);
        assertEquals(2.0f, boundingRect.getY2(), 0.0f);
    }

    @Test
    public void setWidth() {
        boundingRect.setWidth(2.0f);
        assertEquals(2.0f, boundingRect.getWidth(), 0.0f);
    }

    @Test
    public void setHeight() {
        boundingRect.setHeight(2.0f);
        assertEquals(2.0f, boundingRect.getHeight(), 0.0f);
    }
}
