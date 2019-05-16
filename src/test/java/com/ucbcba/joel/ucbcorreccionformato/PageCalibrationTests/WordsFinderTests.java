package com.ucbcba.joel.ucbcorreccionformato.PageCalibrationTests;

import static org.junit.Assert.assertEquals;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.File;
import java.io.IOException;

/**
 * Created by Jp on 15/05/2019.
 */
public class WordsFinderTests {
    private PDDocument pdf;

    @Before
    public void setUp() throws IOException {
        File file = new File("./uploads/documentoCompleto.pdf");
        pdf = PDDocument.load(file);
    }

    @Test
    public void testOne() {
        System.out.println("Test One");
    }
}
