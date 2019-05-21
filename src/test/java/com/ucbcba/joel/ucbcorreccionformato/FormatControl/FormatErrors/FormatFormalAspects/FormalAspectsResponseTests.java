package com.ucbcba.joel.ucbcorreccionformato.FormatControl.FormatErrors.FormatFormalAspects;

import org.junit.Test;

import com.ucbcba.joel.ucbcorreccionformato.FormatControl.FormatFormalAspects.FormalAspectsResponse;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Before;

public class FormalAspectsResponseTests {

    private FormalAspectsResponse formalAspectsResponse;

    @Before
    public void setUp() {
        this.formalAspectsResponse = new FormalAspectsResponse("format", true);
    }

    @Test
    public void getFormat() {
        assertEquals("format", formalAspectsResponse.getFormat());
    }
    
    @Test 
    public void setFormat() {
    	formalAspectsResponse.setFormat("formatSet");
    	assertEquals("formatSet", formalAspectsResponse.getFormat());
    }
    
    @Test
    public void isCorrect() {
        assertTrue(formalAspectsResponse.isCorrect());
    }
    
    @Test
    public void setCorrect() {
    	formalAspectsResponse.setCorrect(false);
    	assertEquals(false, formalAspectsResponse.isCorrect());
    }
}