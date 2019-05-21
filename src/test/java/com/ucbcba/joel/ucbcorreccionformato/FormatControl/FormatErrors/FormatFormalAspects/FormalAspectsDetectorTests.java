package com.ucbcba.joel.ucbcorreccionformato.FormatControl.FormatErrors.FormatFormalAspects;

import com.ucbcba.joel.ucbcorreccionformato.FormatControl.FormatFormalAspects.FormalAspectsDetector;
import com.ucbcba.joel.ucbcorreccionformato.FormatControl.FormatFormalAspects.FormalAspectsResponse;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class FormalAspectsDetectorTests {

    private FormalAspectsDetector formalAspectsDetector;
    private PDDocument pdDocument;
    private FormalAspectsResponse formalAspectsResponse;

    @Before
    public void setUp() throws IOException {
        pdDocument = PDDocument.load(new File("./uploads/Perfil.pdf"));
        formalAspectsDetector = new FormalAspectsDetector(pdDocument);
    }

    @After
    public void tearDown() throws IOException {
        pdDocument.close();
    }

    @Test
    public void getFormalAspectsResponses() throws IOException {
        FormalAspectsResponse formalAspectsResponse1 = new FormalAspectsResponse("Tamaño de hoja carta", true);
        FormalAspectsResponse formalAspectsResponse2 = new FormalAspectsResponse("Margen 3cm (derecho, inferior y superior) 3.5cm (izquierdo)", true);
        FormalAspectsResponse formalAspectsResponse3 = new FormalAspectsResponse("Tipo de letra: Times New Roman 12", true);
        FormalAspectsResponse formalAspectsResponse4 = new FormalAspectsResponse("Numeración parte inferior", true);
        FormalAspectsResponse formalAspectsResponse5 = new FormalAspectsResponse("Espaciado entre lineas 1,5", true);
        List<FormalAspectsResponse> resp = new ArrayList<FormalAspectsResponse>();
        resp.add(formalAspectsResponse1);
        resp.add(formalAspectsResponse3);
        resp.add(formalAspectsResponse5);
        resp.add(formalAspectsResponse2);
        resp.add(formalAspectsResponse4);
        assertEquals(resp.get(0).getFormat(), formalAspectsDetector.getFormalAspectsResponses(4, 22).get(0).getFormat());
        assertEquals(resp.get(0).isCorrect(), formalAspectsDetector.getFormalAspectsResponses(4, 22).get(0).isCorrect());
        assertEquals(resp.get(1).getFormat(), formalAspectsDetector.getFormalAspectsResponses(4, 22).get(1).getFormat());
        assertEquals(resp.get(1).isCorrect(), formalAspectsDetector.getFormalAspectsResponses(4, 22).get(1).isCorrect());
        assertEquals(resp.get(2).getFormat(), formalAspectsDetector.getFormalAspectsResponses(4, 22).get(2).getFormat());
        assertEquals(resp.get(2).isCorrect(), formalAspectsDetector.getFormalAspectsResponses(4, 22).get(2).isCorrect());
        assertEquals(resp.get(3).getFormat(), formalAspectsDetector.getFormalAspectsResponses(4, 22).get(3).getFormat());
        assertEquals(resp.get(3).isCorrect(), formalAspectsDetector.getFormalAspectsResponses(4, 22).get(3).isCorrect());
        assertEquals(resp.get(4).getFormat(), formalAspectsDetector.getFormalAspectsResponses(4, 22).get(4).getFormat());
        assertEquals(resp.get(4).isCorrect(), formalAspectsDetector.getFormalAspectsResponses(4, 22).get(4).isCorrect());
        }

    @Test
    public void getFormatSheetSize() {
        formalAspectsResponse = new FormalAspectsResponse("Tamaño de hoja carta", true);
        assertEquals(formalAspectsResponse.getFormat(), formalAspectsDetector.getFormatSheetSize(13).getFormat());
        assertEquals(formalAspectsResponse.isCorrect(), formalAspectsDetector.getFormatSheetSize(13).isCorrect());
    }

    @Test
    public void getFormatMargin() throws IOException {
        formalAspectsResponse = new FormalAspectsResponse("Margen 3cm (derecho, inferior y superior) 3.5cm (izquierdo)", true);
        assertEquals(formalAspectsResponse.getFormat(), formalAspectsDetector.getFormatMargin(13).getFormat());
        assertEquals(formalAspectsResponse.isCorrect(), formalAspectsDetector.getFormatMargin(13).isCorrect());
    }

    @Test
    public void getFormatFont() throws IOException {
        formalAspectsResponse = new FormalAspectsResponse("Tipo de letra: Times New Roman 12", true);
        assertEquals(formalAspectsResponse.getFormat(), formalAspectsDetector.getFormatFont(13).getFormat());
        assertEquals(formalAspectsResponse.isCorrect(), formalAspectsDetector.getFormatFont(13).isCorrect());
    }

    @Test
    public void getFormatNumeration() throws IOException {
        formalAspectsResponse = new FormalAspectsResponse("Numeración parte inferior", true);
        assertEquals(formalAspectsResponse.getFormat(), formalAspectsDetector.getFormatNumeration(13).getFormat());
        assertEquals(formalAspectsResponse.isCorrect(), formalAspectsDetector.getFormatNumeration(13).isCorrect());
    }

    @Test
    public void getFormatLineSpacing() throws IOException {
        formalAspectsResponse = new FormalAspectsResponse("Espaciado entre lineas 1,5", true);
        assertEquals(formalAspectsResponse.getFormat(), formalAspectsDetector.getFormatLineSpacing(13).getFormat());
        assertEquals(formalAspectsResponse.isCorrect(), formalAspectsDetector.getFormatLineSpacing(13).isCorrect());
    }
}