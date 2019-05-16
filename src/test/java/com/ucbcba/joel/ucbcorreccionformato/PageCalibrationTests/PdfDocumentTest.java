package com.ucbcba.joel.ucbcorreccionformato.PageCalibrationTests;

import com.ucbcba.joel.ucbcorreccionformato.PageCalibration.PdfDocument;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.IOException;

import static org.junit.Assert.assertEquals;

/**
 * Created by Jp on 15/05/2019.
 */
public class PdfDocumentTest {
    private PDDocument pdf;
    private String CORRECT_DOCUMENT_PATH="./uploads/documentoCompleto.pdf";
    PdfDocument pdfDocument;

    @Before
    public void setUp() throws IOException {
        File file = new File(CORRECT_DOCUMENT_PATH);
        pdf = PDDocument.load(file);
        pdfDocument = new PdfDocument(pdf);
    }

    @Test
    public void coverPageOnPage1(){
        int expectedCoverPage = 1;

        assertEquals(pdfDocument.getCoverPage(), expectedCoverPage);
    }

    @Test
    public void startOfGeneralIndexOnPage2(){
        int expectedGeneralIndexStartPage = 2;

        assertEquals(pdfDocument.getGeneralIndexStartPage(), expectedGeneralIndexStartPage);
    }

    @Test
    public void endOfGeneralIndexOnPage2(){
        int expectedGeneralIndexEndPage = 2;

        assertEquals(pdfDocument.getGeneralIndexEndPage(), expectedGeneralIndexEndPage);
    }

    @Test
    public void startOfAnnexesOnPage26(){
        int notFound = 26;

        assertEquals(pdfDocument.getAnnexesStartPage(), notFound);
    }

    @Test
    public void endOfAnnexesOnPage26(){
        int notFound = 26;

        assertEquals(pdfDocument.getAnnexesEndPage(), notFound);
    }

    @Test
    public void startOfBibliographyOnPage22(){
        int expectedBibliographyStartPage = 22;

        assertEquals(pdfDocument.getBibliographyStartPage(), expectedBibliographyStartPage);
    }

    @Test
    public void endOfBibliographyOnPage25(){
        int expecetedBibliographyEndPage = 25;

        assertEquals(pdfDocument.getBibliographyEndPage(), expecetedBibliographyEndPage);
    }

    @Test
    public void startOfFigureIndexOnPage4(){
        int expectedFigureIndexStartPage = 4;

        assertEquals(pdfDocument.getFigureIndexStartPage(), expectedFigureIndexStartPage);
    }

    @Test
    public void endOfFigureIndexOnPage4(){
        int expectedFigureIndexEndPage = 4;

        assertEquals(pdfDocument.getFigureIndexEndPage(), expectedFigureIndexEndPage);
    }

    @Test
    public void startOfTableIndexOnPage3(){
        int expectedTableIndexStartPage = 3;

        assertEquals(pdfDocument.getTableIndexStartPage(), expectedTableIndexStartPage);
    }

    @Test
    public void endOfTableIndexOnPage3(){
        int expectedTableIndexEndPage = 3;

        assertEquals(pdfDocument.getTableIndexEndPage(), expectedTableIndexEndPage);
    }

    @Test
    public void getSameInstanceOfPdfDocument(){
        assertEquals(pdfDocument.getPdfdocument(), pdf);
    }

    @Test
    public void setCoverPageFrom1To10(){
        int expectedCoverPage = 1;
        int newCoverPage = 10;

        assertEquals(pdfDocument.getCoverPage(), expectedCoverPage);
        pdfDocument.setCoverPage(newCoverPage);
        assertEquals(pdfDocument.getCoverPage(), newCoverPage);
    }

    @Test
    public void setGeneralIndexStartPageFrom2To10(){
        int expectedGeneralIndexStartPage = 2;
        int newGeneralIndexStartPage = 10;

        assertEquals(pdfDocument.getGeneralIndexStartPage(), expectedGeneralIndexStartPage);
        pdfDocument.setGeneralIndexStartPage(newGeneralIndexStartPage);
        assertEquals(pdfDocument.getGeneralIndexStartPage(), newGeneralIndexStartPage);
    }

    @Test
    public void setGeneralIndexEndPageFrom2To10(){
        int expectedGeneralIndexEndPage = 2;
        int newGeneralIndexEndPage = 10;

        assertEquals(pdfDocument.getGeneralIndexEndPage(), expectedGeneralIndexEndPage);
        pdfDocument.setGeneralIndexEndPage(newGeneralIndexEndPage);
        assertEquals(pdfDocument.getGeneralIndexEndPage(), newGeneralIndexEndPage);
    }

    @Test
    public void setAnnexesStartPageFrom26To10(){
        int expectedAnnexesStartPage = 26;
        int newAnnexesStartPage = 10;

        assertEquals(pdfDocument.getAnnexesStartPage(), expectedAnnexesStartPage);
        pdfDocument.setAnnexesStartPage(newAnnexesStartPage);
        assertEquals(pdfDocument.getAnnexesStartPage(), newAnnexesStartPage);
    }

    @Test
    public void setBibliographyStartPageFrom22To10(){
        int expectedBibliographyStartPage = 22;
        int newBibliographyStartPage = 10;

        assertEquals(pdfDocument.getBibliographyStartPage(), expectedBibliographyStartPage);
        pdfDocument.setBibliographyStartPage(newBibliographyStartPage);
        assertEquals(pdfDocument.getBibliographyStartPage(), newBibliographyStartPage);
    }
}
