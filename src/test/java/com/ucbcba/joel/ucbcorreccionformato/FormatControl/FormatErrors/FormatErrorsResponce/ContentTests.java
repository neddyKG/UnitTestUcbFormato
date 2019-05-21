package com.ucbcba.joel.ucbcorreccionformato.FormatControl.FormatErrors.FormatErrorsResponce;

import com.ucbcba.joel.ucbcorreccionformato.FormatControl.FormatErrors.FormatErrorResponse.Content;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ContentTests {

    private Content content;

    @Before
    public void setUp() {
        content = new Content("text");
    }

    @Test
    public void getText() {
        assertEquals("text", content.getText());
    }

    @Test
    public void setText() {
        content.setText("textSet");
        assertEquals("textSet", content.getText());
    }
}
