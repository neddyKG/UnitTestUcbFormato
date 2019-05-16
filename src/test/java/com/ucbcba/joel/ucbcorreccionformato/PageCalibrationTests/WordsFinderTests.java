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
    public void successfulSearchOfWordUniversidadOnPage1() throws IOException {
        String seekWord = "UNIVERSIDAD";
        int page = 1;
        assertEquals(wordsFinder.isTheWordInThePage(page, seekWord), true);
    }

    @Test
    public void unsuccessfulSearchOfWordUniversidadOnPage2() throws IOException {
        String seekWord = "UNIVERSIDAD";
        int page = 2;
        assertEquals(wordsFinder.isTheWordInThePage(page, seekWord), false);
    }

    @Test
    public void successfulAdvancedSearchOfWordUniversidadOnPage1() throws IOException {
        String seekWord = "UNIVERSIDAD";
        int page = 1;
        assertEquals(wordsFinder.isTheWordInThePageAdvanced(page, seekWord), true);
    }

    @Test
    public void unsuccessfulAdvancedSearchOfWordUniversidadOnPage2() throws IOException {
        String seekWord = "UNiVErSIdAD";
        int page = 2;
        assertEquals(wordsFinder.isTheWordInThePageAdvanced(page, seekWord), false);
    }

    @Test
    public void successfulSearchOfWordElementosOnPagesRange1To4() throws IOException {
        String seekWord = "Elementos";
        int initialPageIndex = 1;
        int finalPageIndex = 4;
        System.out.println(wordsFinder.findWordsFromPages(initialPageIndex, finalPageIndex, seekWord));
        assertEquals(wordsFinder.findWordsFromPages(initialPageIndex, finalPageIndex, seekWord), true);
    }

    @Test
    public void unsuccessfulSearchOfWordCesarOnPagesRange4To6() throws IOException {
        String seekWord = "Cesar";
        int initialPageIndex = 4;
        int finalPageIndex = 6;
        assertEquals(wordsFinder.findWordsFromPages(initialPageIndex, finalPageIndex, seekWord), false);
    }
}
