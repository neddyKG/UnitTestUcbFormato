package com.ucbcba.joel.ucbcorreccionformato.FormatControl.FormatErrors.FormatErrorsResponce;

import com.ucbcba.joel.ucbcorreccionformato.FormatControl.FormatErrors.FormatErrorResponse.BoundingRect;
import com.ucbcba.joel.ucbcorreccionformato.FormatControl.FormatErrors.FormatErrorResponse.Position;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import static org.unitils.reflectionassert.ReflectionAssert.assertReflectionEquals;

public class PositionTests {

    private BoundingRect boundingRect;
    private List<BoundingRect> rects;
    private int pageNumber;
    private Position position;

    @Before
    public void setUp() {
        boundingRect = new BoundingRect(0.1f, 0.1f, 0.1f, 0.1f, 0.1f, 0.1f);
        rects = new ArrayList<>();
        rects.add(boundingRect);
        pageNumber = 1;
        position = new Position(boundingRect, rects, pageNumber);
    }

    @Test
    public void getBoundingRect() {
        BoundingRect boundingRect = new BoundingRect(0.1f, 0.1f, 0.1f, 0.1f, 0.1f, 0.1f);
        assertReflectionEquals(boundingRect, position.getBoundingRect());
    }

    @Test
    public void setBoundingRect() {
        BoundingRect boundingRect = new BoundingRect(0.3f, 0.1f, 0.3f, 0.1f, 0.3f, 0.1f);
        position.setBoundingRect(boundingRect);
        assertReflectionEquals(boundingRect, position.getBoundingRect());
    }

    @Test
    public void getPageNumber() {
        assertEquals(1, position.getPageNumber());
    }

    @Test
    public void setPageNumber() {
        position.setPageNumber(5);
        assertEquals(5, position.getPageNumber());
    }

    @Test
    public void getRects() {
        BoundingRect boundingRect = new BoundingRect(0.1f, 0.1f, 0.1f, 0.1f, 0.1f, 0.1f);
        List<BoundingRect> rects = new ArrayList<>();
        rects.add(boundingRect);
        assertReflectionEquals(rects, position.getRects());
    }

    @Test
    public void setRects() {
        BoundingRect boundingRect1 = new BoundingRect(0.1f, 0.3f, 0.1f, 0.3f, 0.1f, 0.3f);
        BoundingRect boundingRect2 = new BoundingRect(0.3f, 0.1f, 0.3f, 0.1f, 0.3f, 0.1f);
        List<BoundingRect> rects = new ArrayList<>();
        rects.add(boundingRect1);
        rects.add(boundingRect2);
        position.setRects(rects);
        assertReflectionEquals(rects, position.getRects());
    }
}
