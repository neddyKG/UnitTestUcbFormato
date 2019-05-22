package com.ucbcba.joel.ucbcorreccionformato.FormatControl.FormatErrors.FormatErrorsResponce;

import com.ucbcba.joel.ucbcorreccionformato.FormatControl.FormatErrors.FormatErrorResponse.*;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.unitils.reflectionassert.ReflectionAssert.assertReflectionEquals;

public class FormatErrorResponseTests {

    private BoundingRect boundingRect;
    private List<BoundingRect> rects;
    private Position position;
    private Content content;
    private Comment comment;
    private FormatErrorResponse formatErrorResponse;

    @Before
    public void setUp() {
        comment = new Comment("text", ":v");
        content = new Content("text");
        boundingRect = new BoundingRect(0.1f, 0.1f, 0.1f, 0.1f, 0.1f, 0.1f);
        rects = new ArrayList<>();
        rects.add(boundingRect);
        position = new Position(boundingRect, rects, 1);
        formatErrorResponse = new FormatErrorResponse(content, position, comment, "a1", true, "type");
    }

    @Test
    public void getId() {
        assertEquals("a1", formatErrorResponse.getId());
    }

    @Test
    public void getContent() {
        Content content = new Content("text");
        assertReflectionEquals(content, formatErrorResponse.getContent());
    }

    @Test
    public void setContent() {
        Content content = new Content("textFixed");
        formatErrorResponse.setContent(content);
        assertReflectionEquals(content, formatErrorResponse.getContent());
    }

    @Test
    public void getPosition() {
        BoundingRect boundingRect = new BoundingRect(0.1f, 0.1f, 0.1f, 0.1f, 0.1f, 0.1f);
        List<BoundingRect> rects = new ArrayList<>();
        rects.add(boundingRect);
        Position position = new Position(boundingRect, rects, 1);
        assertReflectionEquals(position, formatErrorResponse.getPosition());
    }

    @Test
    public void setPosition() {
        BoundingRect boundingRect1 = new BoundingRect(0.3f, 0.1f, 0.3f, 0.1f, 0.3f, 0.1f);
        BoundingRect boundingRect2 = new BoundingRect(0.1f, 0.3f, 0.1f, 0.3f, 0.1f, 0.3f);
        List<BoundingRect> rects = new ArrayList<>();
        rects.add(boundingRect1);
        rects.add(boundingRect2);
        Position position = new Position(boundingRect, rects, 2);
        formatErrorResponse.setPosition(position);
        assertReflectionEquals(position, formatErrorResponse.getPosition());
    }

    @Test
    public void getComment() {
        Comment comment = new Comment("text", ":v");
        assertReflectionEquals(comment, formatErrorResponse.getComment());
    }

    @Test
    public void setComment() {
        Comment comment = new Comment("textChanged", ">:v");
        formatErrorResponse.setComment(comment);
        assertReflectionEquals(comment, formatErrorResponse.getComment());
    }

    @Test
    public void isError() {
        assertTrue(formatErrorResponse.isError());
    }

    @Test
    public void setError() {
        formatErrorResponse.setError(false);
        assertFalse(formatErrorResponse.isError());
    }

    @Test
    public void getType() {
        assertEquals("type", formatErrorResponse.getType());
    }

    @Test
    public void setType() {
        formatErrorResponse.setType("typeChanged");
        assertEquals("typeChanged", formatErrorResponse.getType());
    }
}
