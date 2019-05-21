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
public class TableFormatTest {

    PDDocument pdfDocument;
    private String CORRECT_DOCUMENT_PATH="./uploads/documentoCompleto.pdf";
    Format tableFormat;
    List<WordsProperties> wordsLines;
    int TABLE_INDEX_PAGE = 3;

    @Before
    public void setUp() throws IOException {
        File file = new File(CORRECT_DOCUMENT_PATH);
        pdfDocument = PDDocument.load(file);
        GetterWordLines getterWordLines = new GetterWordLines(pdfDocument);
        wordsLines = getterWordLines.getWordLinesWithoutAnyNumeration(TABLE_INDEX_PAGE);
    }

    @Test
    public void tableIndexPageFollowingFormat(){
        float pageWidth = pdfDocument.getPage(TABLE_INDEX_PAGE-1).getMediaBox().getWidth();
        tableFormat =  new TableFormat(12,"Centrado",pageWidth,false, 1);
        int pageLineIndex = 1;
        WordsProperties currentWordLine = wordsLines.get(pageLineIndex);
        List<String> output = tableFormat.getFormatErrorComments(currentWordLine);
        List<String> emptyList = new ArrayList<>();

        assertEquals(output, emptyList);
    }

    @Test
    public void tableIndexPageNotFollowingBoldFormat(){
        String errorComment = "Tenga Negrilla";

        float pageWidth = pdfDocument.getPage(TABLE_INDEX_PAGE-1).getMediaBox().getWidth();
        tableFormat =  new TableFormat(12,"Centrado",pageWidth,true, 1);
        int pageLineIndex = 1;
        WordsProperties currentWordLine = wordsLines.get(pageLineIndex);
        List<String> output = tableFormat.getFormatErrorComments(currentWordLine);
        List<String> expectedErrors = new ArrayList<>();
        expectedErrors.add(errorComment);

        assertEquals(output, expectedErrors);
    }

    @Test
    public void tableIndexPageNotFollowingNameFormat(){
        String errorComment = "Número de tabla debería ser 0";

        float pageWidth = pdfDocument.getPage(TABLE_INDEX_PAGE-1).getMediaBox().getWidth();
        tableFormat =  new TableFormat(12,"Centrado",pageWidth,false, 0);
        int pageLineIndex = 1;
        WordsProperties currentWordLine = wordsLines.get(pageLineIndex);
        List<String> output = tableFormat.getFormatErrorComments(currentWordLine);
        List<String> expectedErrors = new ArrayList<>();
        expectedErrors.add(errorComment);

        assertEquals(output, expectedErrors);
    }

    @Test
    public void nonTableIndexPageNotFollowingBoldFormat(){
        String errorComment = "No tenga negrilla";

        float pageWidth = pdfDocument.getPage(TABLE_INDEX_PAGE-1).getMediaBox().getWidth();
        tableFormat =  new TableFormat(12,"Izquierdo",pageWidth,false, 0);
        int pageLineIndex = 0;
        WordsProperties currentWordLine = wordsLines.get(pageLineIndex);
        List<String> output = tableFormat.getFormatErrorComments(currentWordLine);
        List<String> expectedErrors = new ArrayList<>();
        expectedErrors.add(errorComment);
        expectedErrors.add("Número de tabla debería ser 0");

        assertEquals(output, expectedErrors);
    }

    @Test
    public void nonTableIndexPageNotFollowingAlignmentFormat(){
        String errorComment = "Tenga alineación centrada";

        float pageWidth = pdfDocument.getPage(TABLE_INDEX_PAGE-1).getMediaBox().getWidth();
        tableFormat =  new TableFormat(12,"Centrado",pageWidth,true, 0);
        int pageLineIndex = 0;
        WordsProperties currentWordLine = wordsLines.get(pageLineIndex);
        List<String> output = tableFormat.getFormatErrorComments(currentWordLine);
        List<String> expectedErrors = new ArrayList<>();
        expectedErrors.add(errorComment);
        expectedErrors.add("Número de tabla debería ser 0");

        assertEquals(output, expectedErrors);
    }

    @After
    public void tearDown() throws IOException {
        pdfDocument.close();
    }
}
