package com.ucbcba.joel.ucbcorreccionformato.FormatControl.FormatErrors.FormatControl;

import com.ucbcba.joel.ucbcorreccionformato.FormatControl.GetterWordLines;
import com.ucbcba.joel.ucbcorreccionformato.FormatControl.WordsProperties;
import org.apache.pdfbox.pdmodel.PDDocument;
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
public class TittleFormatTest {
    PDDocument pdfDocument;
    private String CORRECT_DOCUMENT_PATH="./uploads/documentoCompleto.pdf";
    Format tittleFormat;
    List<WordsProperties> wordsLines;
    int GENERAL_INDEX_PAGE = 2;
    List<WordsProperties> wrongWordsLines;

    @Before
    public void setUp() throws IOException {
        File file = new File(CORRECT_DOCUMENT_PATH);
        pdfDocument = PDDocument.load(file);
        GetterWordLines getterWordLines = new GetterWordLines(pdfDocument);
        wordsLines = getterWordLines.getWordLinesWithoutAnyNumeration(GENERAL_INDEX_PAGE);
        wrongWordsLines = getterWordLines.getWordLinesWithoutAnyNumeration(GENERAL_INDEX_PAGE - 1);
    }

    @Test
    public void generalIndexPageTittleFollowingFormat(){
        float pageWidth = pdfDocument.getPage(GENERAL_INDEX_PAGE-1).getMediaBox().getWidth();
        tittleFormat =  new TittleFormat(12,"Centrado",pageWidth,true,"INDICE GENERAL");
        int pageLineIndex = 0;
        WordsProperties currentWordLine = wordsLines.get(pageLineIndex);
        List<String> output = tittleFormat.getFormatErrorComments(currentWordLine);
        List<String> emptyList = new ArrayList<>();

        assertEquals(output, emptyList);
    }

    @Test
    public void generalIndexPageTittleNotFollowingFormat(){
        String errorComment = "El título sea: INDICEk GENERAL";

        float pageWidth = pdfDocument.getPage(GENERAL_INDEX_PAGE-1).getMediaBox().getWidth();
        tittleFormat =  new TittleFormat(12,"Centrado",pageWidth,true,"INDICEk GENERAL");
        int pageLineIndex = 0;
        WordsProperties currentWordLine = wordsLines.get(pageLineIndex);
        List<String> output = tittleFormat.getFormatErrorComments(currentWordLine);
        List<String> expectedList = new ArrayList<>();
        expectedList.add(errorComment);

        assertEquals(output, expectedList);
    }

    @Test
    public void generalIndexPageTittleNotFollowingBoldFormat(){
        String errorComment = "No tenga negrilla";
        float pageWidth = pdfDocument.getPage(GENERAL_INDEX_PAGE-1).getMediaBox().getWidth();
        tittleFormat =  new TittleFormat(12,"Centrado",pageWidth,false,"INDICE GENERAL");
        int pageLineIndex = 0;
        WordsProperties currentWordLine = wordsLines.get(pageLineIndex);
        List<String> output = tittleFormat.getFormatErrorComments(currentWordLine);
        List<String> expectedList = new ArrayList<>();
        expectedList.add(errorComment);

        assertEquals(output, expectedList);
    }

    @Test
    public void nonGeneralIndexPageTittleNotFollowingBoldFormat(){
        String errorComment = "Tenga Negrilla";
        float pageWidth = pdfDocument.getPage(GENERAL_INDEX_PAGE-1).getMediaBox().getWidth();
        tittleFormat =  new TittleFormat(12,"Centrado",pageWidth,true,"Cochabamba – Bolivia");
        int pageLineIndex = 9;
        WordsProperties currentWordLine = wrongWordsLines.get(pageLineIndex);
        List<String> output = tittleFormat.getFormatErrorComments(currentWordLine);
        List<String> expectedList = new ArrayList<>();
        expectedList.add(errorComment);

        assertEquals(output, expectedList);
    }

    @Test
    public void generalIndexPageTittleNotFollowingAlignmentFormat(){
        String errorComment = "Alineado al margen izquierdo";
        float pageWidth = pdfDocument.getPage(GENERAL_INDEX_PAGE-1).getMediaBox().getWidth();
        tittleFormat =  new TittleFormat(12,"Izquierdo",pageWidth,true,"INDICE GENERAL");
        int pageLineIndex = 0;
        WordsProperties currentWordLine = wordsLines.get(pageLineIndex);
        List<String> output = tittleFormat.getFormatErrorComments(currentWordLine);
        List<String> expectedList = new ArrayList<>();
        expectedList.add(errorComment);

        assertEquals(output, expectedList);
    }

    @Test
    public void nonGeneralIndexPageTittleNotFollowingAlignmentFormat(){
        String errorComment = "Tenga alineación centrada";
        float pageWidth = pdfDocument.getPage(GENERAL_INDEX_PAGE-1).getMediaBox().getWidth();
        tittleFormat =  new TittleFormat(12,"Centrado",pageWidth,false,"Perfil de Proyecto de Grado de Licenciatura en Ingenieria de Sistemas");
        int pageLineIndex = 7;
        WordsProperties currentWordLine = wrongWordsLines.get(pageLineIndex);
        List<String> output = tittleFormat.getFormatErrorComments(currentWordLine);
        List<String> expectedList = new ArrayList<>();
        expectedList.add(errorComment);

        assertEquals(output, expectedList);
    }
}
