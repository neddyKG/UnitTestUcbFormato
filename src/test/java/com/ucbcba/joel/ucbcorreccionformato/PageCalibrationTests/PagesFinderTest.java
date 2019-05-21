package com.ucbcba.joel.ucbcorreccionformato.PageCalibrationTests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.IOException;

import com.ucbcba.joel.ucbcorreccionformato.PageCalibration.PagesFinder;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.encryption.InvalidPasswordException;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class PagesFinderTest {

    private PDDocument pdfdocument = null;
    private PagesFinder pagesFinder; 

    @Before
    public void setUp() throws IOException {
        pdfdocument = PDDocument.load(new File("./uploads/Perfil.pdf"));
        pagesFinder = new PagesFinder(pdfdocument);
    }

    @After
	public void tearDown() throws IOException {
		pdfdocument.close();
	}

    @Test
    public void isTheCoverInThePage() throws IOException {
        assertTrue(pagesFinder.isTheCoverInThePage(1));
    }

    @Test
    public void getCoverPage() throws InvalidPasswordException, IOException {
        assertEquals(1, pagesFinder.getCoverPage());
    }

    @Test
    public void isTheGeneralIndexInThePage() throws InvalidPasswordException, IOException {
        assertTrue(pagesFinder.isTheGeneralIndexInThePage(2));
    }

    @Test
    public void getGeneralIndexStartPage() throws InvalidPasswordException, IOException {
        assertEquals(2, pagesFinder.getGeneralIndexStartPage());
    }

    @Test
    public void isTheFigureTableIndexInThePage() throws InvalidPasswordException, IOException {
        assertTrue(pagesFinder.isTheFigureTableIndexInThePage(3));
    }

    @Test
    public void isTheFigureIndexInThePage() throws InvalidPasswordException, IOException {
        assertTrue(pagesFinder.isTheFigureIndexInThePage(4));
    }

    @Test
    public void isTheTableIndexInThePage() throws InvalidPasswordException, IOException {
        assertTrue(pagesFinder.isTheTableIndexInThePage(3));
    }

    @Test
    public void getGeneralIndexEndPage() throws InvalidPasswordException, IOException {
        assertEquals(2, pagesFinder.getGeneralIndexEndPage(2, 2));
    }

    @Test
    public void getFigureIndexStartPage() throws InvalidPasswordException, IOException {
        assertEquals(4, pagesFinder.getFigureIndexStartPage(2, 4));
    }

    @Test
    public void getFigureIndexEndPage() throws InvalidPasswordException, IOException {
        assertEquals(4, pagesFinder.getFigureIndexEndPage(4, 4));
    }

    @Test
    public void getTableIndexStartPage() throws InvalidPasswordException, IOException {
        assertEquals(3, pagesFinder.getTableIndexStartPage(2, 4));
    }

    @Test
    public void getTableIndexEndPage() throws InvalidPasswordException, IOException {
        assertEquals(3, pagesFinder.getTableIndexEndPage(3, 4));
    }

    @Test
    public void getLastIndexPage() throws InvalidPasswordException, IOException {
        assertEquals(4, pagesFinder.getLastIndexPage(2));
    }

    @Test
    public void isTheBibliographyInThePage() throws InvalidPasswordException, IOException {
        assertTrue(pagesFinder.isTheBibliographyInThePage(20));
    }

    @Test
    public void getBibliographyStartPage() throws InvalidPasswordException, IOException {
        assertEquals(20, pagesFinder.getBibliographyStartPage());
    }

    @Test
    public void getBibliographyEndPage() throws InvalidPasswordException, IOException {
        assertEquals(21, pagesFinder.getBibliographyEndPage(20, 22));
    }

    @Test
    public void isTheAnnexesStartInThePage() throws InvalidPasswordException, IOException {
        assertTrue(pagesFinder.isTheAnnexesStartInThePage(22));
    }

    @Test
    public void getAnnexesStartPage() throws InvalidPasswordException, IOException {
        assertEquals(22, pagesFinder.getAnnexesStartPage());
    }

    @Test
    public void getAnnexesEndPage() throws InvalidPasswordException, IOException {
        assertEquals(23, pagesFinder.getAnnexesEndPage(22));
    }
}