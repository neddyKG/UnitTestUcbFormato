package com.ucbcba.joel.ucbcorreccionformato.FormatControl.FormatErrors.FormatRules;

import com.ucbcba.joel.ucbcorreccionformato.PageCalibration.PdfDocument;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.IOException;

import static org.junit.Assert.assertEquals;

/**
 * Created by Jp on 19/05/2019.
 */
public class BibliographyPageFormatTest {

    private PDDocument pdf;
    private String CORRECT_DOCUMENT_PATH="./uploads/documentoCompleto.pdf";
    BibliographyPageFormat bibliographyPageFormat;

    @Before
    public void setUp() throws IOException {
        File file = new File(CORRECT_DOCUMENT_PATH);
        pdf = PDDocument.load(file);
        bibliographyPageFormat = new BibliographyPageFormat(pdf);
    }

}
