package com.ucbcba.joel.ucbcorreccionformato.PageCalibrationTests;

import static org.junit.Assert.assertEquals;

import com.ucbcba.joel.ucbcorreccionformato.PageCalibration.WordsFinder;
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
    private String CORRECT_DOCUMENT_PATH="./uploads/documentoCompleto.pdf";
    private WordsFinder wordsFinder;

    @Before
    public void setUp() throws IOException {
        File file = new File(CORRECT_DOCUMENT_PATH);
        pdf = PDDocument.load(file);
        wordsFinder = new WordsFinder(pdf);
    }

    @Test
    public void succesfulSearchOfWordUniversidadOnPage1() throws IOException {
        String seekedWord = "UNIVERSIDAD";
        int page = 1;
        assertEquals(wordsFinder.isTheWordInThePage(page, seekedWord), true);
    }

    @Test
    public void succesfulSearchOfWordUniversidadOnPage2() throws IOException {
        String seekedWord = "UNIVERSIDAD";
        int page = 2;
        assertEquals(wordsFinder.isTheWordInThePage(page, seekedWord), false);
    }
}
