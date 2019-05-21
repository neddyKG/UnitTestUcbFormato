package com.ucbcba.joel.ucbcorreccionformato.FormatControl.FormatErrors.FormatErrorsResponce;

import com.ucbcba.joel.ucbcorreccionformato.FormatControl.FormatErrors.FormatErrorResponse.Comment;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CommentTests {

    private Comment comment;

    @Before
    public void setUp() {
        comment = new Comment("text", ":v");
    }

    @Test
    public void getText() {
        assertEquals("text", comment.getText());
    }

    @Test
    public void setText() {
        comment.setText("textSet");
        assertEquals("textSet", comment.getText());
    }

    @Test
    public void getEmoji() {
        assertEquals(":v", comment.getEmoji());
    }

    @Test
    public void setEmoji() {
        comment.setEmoji(">:v");
        assertEquals(">:v", comment.getEmoji());
    }
}
