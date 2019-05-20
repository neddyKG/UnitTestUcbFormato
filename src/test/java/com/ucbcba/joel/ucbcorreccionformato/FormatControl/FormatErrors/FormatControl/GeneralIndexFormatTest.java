package com.ucbcba.joel.ucbcorreccionformato.FormatControl.FormatErrors.FormatControl;

import com.ucbcba.joel.ucbcorreccionformato.FormatControl.GetterWordLines;
import com.ucbcba.joel.ucbcorreccionformato.FormatControl.WordsProperties;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Created by Jp on 20/05/2019.
 */
public class GeneralIndexFormatTest {
    PDDocument pdfDocument;
    private String CORRECT_DOCUMENT_PATH="./uploads/documentoCompleto.pdf";
    Format generalIndexFormat;
    List<WordsProperties> wordsLines;
    List<WordsProperties> wrongWordsLines;
    int GENERAL_INDEX_PAGE = 2;

    @Before
    public void setUp() throws IOException {
        File file = new File(CORRECT_DOCUMENT_PATH);
        pdfDocument = PDDocument.load(file);
        GetterWordLines getterWordLines = new GetterWordLines(pdfDocument);
        wordsLines = getterWordLines.getWordLinesWithoutAnyNumeration(GENERAL_INDEX_PAGE);
        wrongWordsLines = getterWordLines.getWordLinesWithoutAnyNumeration(GENERAL_INDEX_PAGE - 1);
    }

    @Test
    public void generalIndexPageLine1FollowingFormat(){
        float pageWidth = pdfDocument.getPage(GENERAL_INDEX_PAGE-1).getMediaBox().getWidth();
        generalIndexFormat =  new GeneralIndexFormat(12,"Izquierdo",pageWidth,true,false,true,0);
        int pageLineIndex = 1;
        WordsProperties currentWordLine = wordsLines.get(pageLineIndex);
        List<String> output = generalIndexFormat.getFormatErrorComments(currentWordLine);
        List<String> emptyList = new ArrayList<>();

        assertEquals(output, emptyList);
    }

    @Test
    public void generalIndexPageLine1NotFollowingBoldFormat(){
        String errorComment = "No tenga negrilla";

        float pageWidth = pdfDocument.getPage(GENERAL_INDEX_PAGE-1).getMediaBox().getWidth();
        generalIndexFormat =  new GeneralIndexFormat(12,"Izquierdo",pageWidth,false,false,true,0);
        int pageLineIndex = 1;
        WordsProperties currentWordLine = wordsLines.get(pageLineIndex);
        List<String> output = generalIndexFormat.getFormatErrorComments(currentWordLine);
        List<String> expectedErrors = new ArrayList<>();
        expectedErrors.add(errorComment);

        assertEquals(output, expectedErrors);
    }

    @Test
    public void nonGeneralIndexPageLine10NotFollowingBoldFormat(){
        String errorComment = "Tenga Negrilla";

        float pageWidth = pdfDocument.getPage(GENERAL_INDEX_PAGE-1).getMediaBox().getWidth();
        generalIndexFormat =  new GeneralIndexFormat(12,"Centrado",pageWidth,true,false,false,0);
        int pageLineIndex = 10;
        WordsProperties currentWordLine = wrongWordsLines.get(pageLineIndex);
        List<String> output = generalIndexFormat.getFormatErrorComments(currentWordLine);
        List<String> expectedErrors = new ArrayList<>();
        expectedErrors.add(errorComment);

        assertEquals(output, expectedErrors);
    }

    @Test
    public void generalIndexPageLine1NotFollowingCursiveFormat(){
        String errorComment = "Tenga Cursiva";

        float pageWidth = pdfDocument.getPage(GENERAL_INDEX_PAGE-1).getMediaBox().getWidth();
        generalIndexFormat =  new GeneralIndexFormat(12,"Izquierdo",pageWidth,true,true,true,0);
        int pageLineIndex = 1;
        WordsProperties currentWordLine = wordsLines.get(pageLineIndex);
        List<String> output = generalIndexFormat.getFormatErrorComments(currentWordLine);
        List<String> expectedErrors = new ArrayList<>();
        expectedErrors.add(errorComment);

        assertEquals(output, expectedErrors);
    }

    @Test
    public void nonGeneralIndexPageLine7NotFollowingCursiveFormat(){
        String errorComment = "No tenga cursiva";

        float pageWidth = pdfDocument.getPage(GENERAL_INDEX_PAGE-1).getMediaBox().getWidth();
        generalIndexFormat =  new GeneralIndexFormat(12,"Centrado",pageWidth,false,false,false,0);
        int pageLineIndex = 7;
        WordsProperties currentWordLine = wrongWordsLines.get(pageLineIndex);
        List<String> output = generalIndexFormat.getFormatErrorComments(currentWordLine);
        List<String> expectedErrors = new ArrayList<>();
        expectedErrors.add(errorComment);

        assertEquals(output, expectedErrors);
    }

    @Test
    public void generalIndexPageLine1NotFollowingCaseFormat(){
        String errorComment = "No todo esté en mayúscula";

        float pageWidth = pdfDocument.getPage(GENERAL_INDEX_PAGE-1).getMediaBox().getWidth();
        generalIndexFormat =  new GeneralIndexFormat(12,"Izquierdo",pageWidth,true,false,false,0);
        int pageLineIndex = 1;
        WordsProperties currentWordLine = wordsLines.get(pageLineIndex);
        List<String> output = generalIndexFormat.getFormatErrorComments(currentWordLine);
        List<String> expectedErrors = new ArrayList<>();
        expectedErrors.add(errorComment);

        assertEquals(output, expectedErrors);
    }

    @Test
    public void generalIndexPageLine23NotFollowingCaseFormat(){
        String errorComment = "Todo esté en mayúsculas";

        float pageWidth = pdfDocument.getPage(GENERAL_INDEX_PAGE-1).getMediaBox().getWidth();
        generalIndexFormat =  new GeneralIndexFormat(12,"Centrado",pageWidth,true,false,true,0);
        int pageLineIndex = 23;
        WordsProperties currentWordLine = wordsLines.get(pageLineIndex);
        List<String> output = generalIndexFormat.getFormatErrorComments(currentWordLine);
        List<String> expectedErrors = new ArrayList<>();
        expectedErrors.add(errorComment);

        assertEquals(output, expectedErrors);
    }

    @Test
    public void generalIndexPageLine1NotFollowingAlignmentFormat(){
        String errorComment = "Alineado al margen izquierdo";

        float pageWidth = pdfDocument.getPage(GENERAL_INDEX_PAGE-1).getMediaBox().getWidth();
        generalIndexFormat =  new GeneralIndexFormat(12,"Izquierdo",pageWidth,true,false,true,0);
        int pageLineIndex = 0;
        WordsProperties currentWordLine = wordsLines.get(pageLineIndex);
        List<String> output = generalIndexFormat.getFormatErrorComments(currentWordLine);
        List<String> expectedErrors = new ArrayList<>();
        expectedErrors.add(errorComment);

        assertEquals(output, expectedErrors);
    }

    @Test
    public void generalIndexPageLine1NotFollowingBleedingLv1Format(){
        String errorComment = "Tenga una sangría pequeña";
        int bleedingLevel=1;

        float pageWidth = pdfDocument.getPage(GENERAL_INDEX_PAGE-1).getMediaBox().getWidth();
        generalIndexFormat =  new GeneralIndexFormat(12,"Izquierdo",pageWidth,true,false,true,bleedingLevel);
        int pageLineIndex = 0;
        WordsProperties currentWordLine = wordsLines.get(pageLineIndex);
        List<String> output = generalIndexFormat.getFormatErrorComments(currentWordLine);
        List<String> expectedErrors = new ArrayList<>();
        expectedErrors.add(errorComment);

        assertEquals(output, expectedErrors);
    }

    @Test
    public void generalIndexPageLine1NotFollowingBleedingLv2Format(){
        String errorComment = "Tenga dos sangrías pequeñas";
        int bleedingLevel=2;

        float pageWidth = pdfDocument.getPage(GENERAL_INDEX_PAGE-1).getMediaBox().getWidth();
        generalIndexFormat =  new GeneralIndexFormat(12,"Izquierdo",pageWidth,true,false,true,bleedingLevel);
        int pageLineIndex = 0;
        WordsProperties currentWordLine = wordsLines.get(pageLineIndex);
        List<String> output = generalIndexFormat.getFormatErrorComments(currentWordLine);
        List<String> expectedErrors = new ArrayList<>();
        expectedErrors.add(errorComment);

        assertEquals(output, expectedErrors);
    }

    @Test
    public void generalIndexPageLine1NotFollowingBleedingLv3Format(){
        String errorComment = "Tenga tres sangrías pequeñas";
        int bleedingLevel=3;

        float pageWidth = pdfDocument.getPage(GENERAL_INDEX_PAGE-1).getMediaBox().getWidth();
        generalIndexFormat =  new GeneralIndexFormat(12,"Izquierdo",pageWidth,true,false,true,bleedingLevel);
        int pageLineIndex = 0;
        WordsProperties currentWordLine = wordsLines.get(pageLineIndex);
        List<String> output = generalIndexFormat.getFormatErrorComments(currentWordLine);
        List<String> expectedErrors = new ArrayList<>();
        expectedErrors.add(errorComment);

        assertEquals(output, expectedErrors);
    }


    @After
    public void tearDown() throws IOException {
        pdfDocument.close();
    }
}
