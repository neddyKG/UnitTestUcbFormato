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

    /*@Before
    public void setUp() throws InvalidPasswordException, IOException {
        try {
            pdfdocument = PDDocument.load(new File("./target/Perfil.pdf"));
            pagesFinder = new PagesFinder(pdfdocument);
        } finally {
            if (pdfdocument != null) {
                pdfdocument.close();
            }
        }
    }

    @After
	public void tearDown() throws IOException {
		pdfdocument.close();
	}*/

    @Test
    public void isTheCoverInThePage() throws IOException {
        pdfdocument = PDDocument.load(new File("./target/Perfil.pdf"));
        pagesFinder = new PagesFinder(pdfdocument);
        assertTrue(pagesFinder.isTheCoverInThePage(1));
        pdfdocument.close();
    }

    @Test
    public void getCoverPage() throws InvalidPasswordException, IOException {
        pdfdocument = PDDocument.load(new File("./target/Perfil.pdf"));
        pagesFinder = new PagesFinder(pdfdocument);
        assertEquals(1, pagesFinder.getCoverPage());
        pdfdocument.close();
    }

    @Test
    public void isTheGeneralIndexInThePage() throws InvalidPasswordException, IOException {
        pdfdocument = PDDocument.load(new File("./target/Perfil.pdf"));
        pagesFinder = new PagesFinder(pdfdocument);
        assertTrue(pagesFinder.isTheGeneralIndexInThePage(2));
        pdfdocument.close();
    }

    @Test
    public void getGeneralIndexStartPage() throws InvalidPasswordException, IOException {
        pdfdocument = PDDocument.load(new File("./target/Perfil.pdf"));
        pagesFinder = new PagesFinder(pdfdocument);
        assertEquals(2, pagesFinder.getGeneralIndexStartPage());
        pdfdocument.close();
    }

    @Test
    public void isTheFigureTableIndexInThePage() throws InvalidPasswordException, IOException {
        pdfdocument = PDDocument.load(new File("./target/Perfil.pdf"));
        pagesFinder = new PagesFinder(pdfdocument);
        assertTrue(pagesFinder.isTheFigureTableIndexInThePage(3));
        pdfdocument.close();
    }

    @Test
    public void isTheFigureIndexInThePage() throws InvalidPasswordException, IOException {
        pdfdocument = PDDocument.load(new File("./target/Perfil.pdf"));
        pagesFinder = new PagesFinder(pdfdocument);
        assertTrue(pagesFinder.isTheFigureIndexInThePage(4));
        pdfdocument.close();
    }

    @Test
    public void isTheTableIndexInThePage() throws InvalidPasswordException, IOException {
        pdfdocument = PDDocument.load(new File("./target/Perfil.pdf"));
        pagesFinder = new PagesFinder(pdfdocument);
        assertTrue(pagesFinder.isTheTableIndexInThePage(3));
        pdfdocument.close();
    }

    @Test
    public void getGeneralIndexEndPage() throws InvalidPasswordException, IOException {
        pdfdocument = PDDocument.load(new File("./target/Perfil.pdf"));
        pagesFinder = new PagesFinder(pdfdocument);
        assertEquals(2, pagesFinder.getGeneralIndexEndPage(2, 2));
        pdfdocument.close();
    }

    @Test
    public void getFigureIndexStartPage() throws InvalidPasswordException, IOException {
        pdfdocument = PDDocument.load(new File("./target/Perfil.pdf"));
        pagesFinder = new PagesFinder(pdfdocument);
        assertEquals(4, pagesFinder.getFigureIndexStartPage(2, 4));
        pdfdocument.close();
    }

    @Test
    public void getFigureIndexEndPage() throws InvalidPasswordException, IOException {
        pdfdocument = PDDocument.load(new File("./target/Perfil.pdf"));
        pagesFinder = new PagesFinder(pdfdocument);
        assertEquals(4, pagesFinder.getFigureIndexEndPage(4, 4));
        pdfdocument.close();
    }

    @Test
    public void getTableIndexStartPage() throws InvalidPasswordException, IOException {
        pdfdocument = PDDocument.load(new File("./target/Perfil.pdf"));
        pagesFinder = new PagesFinder(pdfdocument);
        assertEquals(3, pagesFinder.getTableIndexStartPage(2, 4));
        pdfdocument.close();
    }

    @Test
    public void getTableIndexEndPage() throws InvalidPasswordException, IOException {
        pdfdocument = PDDocument.load(new File("./target/Perfil.pdf"));
        pagesFinder = new PagesFinder(pdfdocument);
        assertEquals(3, pagesFinder.getTableIndexEndPage(3, 4));
        pdfdocument.close();
    }

    @Test
    public void getLastIndexPage() throws InvalidPasswordException, IOException {
        pdfdocument = PDDocument.load(new File("./target/Perfil.pdf"));
        pagesFinder = new PagesFinder(pdfdocument);
        assertEquals(4, pagesFinder.getLastIndexPage(2));
        pdfdocument.close();
    }

    @Test
    public void isTheBibliographyInThePage() throws InvalidPasswordException, IOException {
        pdfdocument = PDDocument.load(new File("./target/Perfil.pdf"));
        pagesFinder = new PagesFinder(pdfdocument);
        assertTrue(pagesFinder.isTheBibliographyInThePage(20));
        pdfdocument.close();
    }

    @Test
    public void getBibliographyStartPage() throws InvalidPasswordException, IOException {
        pdfdocument = PDDocument.load(new File("./target/Perfil.pdf"));
        pagesFinder = new PagesFinder(pdfdocument);
        assertEquals(20, pagesFinder.getBibliographyStartPage());
        pdfdocument.close();
    }

    @Test
    public void getBibliographyEndPage() throws InvalidPasswordException, IOException {
        pdfdocument = PDDocument.load(new File("./target/Perfil.pdf"));
        pagesFinder = new PagesFinder(pdfdocument);
        assertEquals(21, pagesFinder.getBibliographyEndPage(20, 22));
        pdfdocument.close();
    }

    @Test
    public void isTheAnnexesStartInThePage() throws InvalidPasswordException, IOException {
        pdfdocument = PDDocument.load(new File("./target/Perfil.pdf"));
        pagesFinder = new PagesFinder(pdfdocument);
        assertTrue(pagesFinder.isTheAnnexesStartInThePage(22));
        pdfdocument.close();
    }

    @Test
    public void getAnnexesStartPage() throws InvalidPasswordException, IOException {
        pdfdocument = PDDocument.load(new File("./target/Perfil.pdf"));
        pagesFinder = new PagesFinder(pdfdocument);
        assertEquals(22, pagesFinder.getAnnexesStartPage());
        pdfdocument.close();
    }

    @Test
    public void getAnnexesEndPage() throws InvalidPasswordException, IOException {
        pdfdocument = PDDocument.load(new File("./target/Perfil.pdf"));
        pagesFinder = new PagesFinder(pdfdocument);
        assertEquals(23, pagesFinder.getAnnexesEndPage(22));
        pdfdocument.close();
    }
}