package com.ucbcba.joel.ucbcorreccionformato.FormatControl.FormatErrors.FormatControl;

import com.ucbcba.joel.ucbcorreccionformato.FormatControl.GetterWordLines;
import com.ucbcba.joel.ucbcorreccionformato.FormatControl.WordsProperties;
import com.ucbcba.joel.ucbcorreccionformato.PageCalibration.PdfDocument;
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
public class CoverFormatTest {
    PDDocument pdfDocument;
    private String CORRECT_DOCUMENT_PATH="./uploads/documentoCompleto.pdf";
    Format coverFormat;
    List<WordsProperties> wordsLines;
    int COVER_PAGE = 1;
    int NOT_COVER_PAGE = 8;

    @Before
    public void setUp() throws IOException {
        File file = new File(CORRECT_DOCUMENT_PATH);
        pdfDocument = PDDocument.load(file);
        GetterWordLines getterWordLines = new GetterWordLines(pdfDocument);
        wordsLines = getterWordLines.getWordLinesWithoutAnyNumeration(COVER_PAGE);
    }

    @Test
    public void line1FollowingAllCoverFormatRules(){
        float pageWidth = pdfDocument.getPage(COVER_PAGE-1).getMediaBox().getWidth();
        coverFormat =  new CoverFormat(18, "Centrado", pageWidth,true, false, true,false);
        int pageLineIndex = 0;
        WordsProperties currentWordLine = wordsLines.get(pageLineIndex);
        List<String> output = coverFormat.getFormatErrorComments(currentWordLine);
        List<String> emptyList = new ArrayList<>();

        assertEquals(output, emptyList);
    }

    @Test
    public void line1NotFollowingFontSizeFormat(){
        String fontSizeErrorComment = "Tamaño de la letra: 19 puntos";

        float pageWidth = pdfDocument.getPage(COVER_PAGE-1).getMediaBox().getWidth();
        coverFormat =  new CoverFormat(19, "Centrado", pageWidth,true, false, true,false);
        int pageLineIndex = 0;
        WordsProperties currentWordLine = wordsLines.get(pageLineIndex);
        List<String> output = coverFormat.getFormatErrorComments(currentWordLine);
        List<String> errorComments = new ArrayList<>();
        errorComments.add(fontSizeErrorComment);

        assertEquals(output, errorComments);
    }

    @Test
    public void line1NotFollowingBoldFormat(){
        String boldErrorComment = "No tenga negrilla";

        float pageWidth = pdfDocument.getPage(COVER_PAGE-1).getMediaBox().getWidth();
        coverFormat =  new CoverFormat(18, "Derecha", pageWidth,false, false, true,false);
        int pageLineIndex = 0;
        WordsProperties currentWordLine = wordsLines.get(pageLineIndex);
        List<String> output = coverFormat.getFormatErrorComments(currentWordLine);
        List<String> errorComments = new ArrayList<>();
        errorComments.add(boldErrorComment);

        assertEquals(output, errorComments);
    }

    @Test
    public void line9NotFollowingBoldFormat(){
        String boldErrorComment = "Tenga Negrilla";
        String fontSizeErrorComment = "Tamaño de la letra: 16 puntos";

        float pageWidth = pdfDocument.getPage(COVER_PAGE-1).getMediaBox().getWidth();
        coverFormat =  new CoverFormat(16, "Derecha", pageWidth,true, false, false,false);
        int pageLineIndex = 9;
        WordsProperties currentWordLine = wordsLines.get(pageLineIndex);
        List<String> output = coverFormat.getFormatErrorComments(currentWordLine);
        List<String> errorComments = new ArrayList<>();
        errorComments.add(fontSizeErrorComment);
        errorComments.add(boldErrorComment);

        assertEquals(output, errorComments);
    }

    @Test
    public void line1NotFollowingItalicFormat(){
        String italicsErrorComment = "Tenga Cursiva";

        float pageWidth = pdfDocument.getPage(COVER_PAGE-1).getMediaBox().getWidth();
        coverFormat =  new CoverFormat(18, "Derecha", pageWidth,true, true, true,false);
        int pageLineIndex = 0;
        WordsProperties currentWordLine = wordsLines.get(pageLineIndex);
        List<String> output = coverFormat.getFormatErrorComments(currentWordLine);
        List<String> errorComments = new ArrayList<>();
        errorComments.add(italicsErrorComment);

        assertEquals(output, errorComments);
    }

    @Test
    public void line7NotFollowingItalicFormat(){
        String italicsErrorComment = "No tenga cursiva";

        float pageWidth = pdfDocument.getPage(COVER_PAGE-1).getMediaBox().getWidth();
        coverFormat =  new CoverFormat(12, "Derecha", pageWidth,false, false, false,false);
        int pageLineIndex = 7;
        WordsProperties currentWordLine = wordsLines.get(pageLineIndex);
        System.out.println(currentWordLine.toString());
        List<String> output = coverFormat.getFormatErrorComments(currentWordLine);
        List<String> errorComments = new ArrayList<>();
        errorComments.add(italicsErrorComment);

        assertEquals(output, errorComments);
    }

    @Test
    public void line7NotFollowingIPositionFormat(){
        String errorComment = "Tenga alineación centrada";

        float pageWidth = pdfDocument.getPage(COVER_PAGE-1).getMediaBox().getWidth();
        coverFormat =  new CoverFormat(12, "Centrado", pageWidth,false, true, false,false);
        int pageLineIndex = 7;
        WordsProperties currentWordLine = wordsLines.get(pageLineIndex);
        System.out.println(currentWordLine.toString());
        List<String> output = coverFormat.getFormatErrorComments(currentWordLine);
        List<String> errorComments = new ArrayList<>();
        errorComments.add(errorComment);

        assertEquals(output, errorComments);
    }

    @Test
    public void line9NotFollowingIPositionFormat(){
        String errorComment = "Tenga alineación al margen derecho";

        float pageWidth = pdfDocument.getPage(COVER_PAGE-1).getMediaBox().getWidth();
        coverFormat =  new CoverFormat(12, "Derecho", pageWidth,false, false, false,false);
        int pageLineIndex = 9;
        WordsProperties currentWordLine = wordsLines.get(pageLineIndex);
        System.out.println(currentWordLine.toString());
        List<String> output = coverFormat.getFormatErrorComments(currentWordLine);
        List<String> errorComments = new ArrayList<>();
        errorComments.add(errorComment);

        assertEquals(output, errorComments);
    }

    @Test
    public void line1NotFollowingCaseFormat(){
        String UpperCaseErrorComment = "Las letras iniciales tenga mayúscula";

        float pageWidth = pdfDocument.getPage(COVER_PAGE-1).getMediaBox().getWidth();
        coverFormat =  new CoverFormat(18, "Derecha", pageWidth,true, false, true,true);
        int pageLineIndex = 0;
        WordsProperties currentWordLine = wordsLines.get(pageLineIndex);
        List<String> output = coverFormat.getFormatErrorComments(currentWordLine);
        List<String> errorComments = new ArrayList<>();
        errorComments.add(UpperCaseErrorComment);

        assertEquals(output, errorComments);
    }

    @Test
    public void line9NotFollowingCaseFormat(){
        String errorComment = "Todo esté en mayúsculas";

        float pageWidth = pdfDocument.getPage(COVER_PAGE-1).getMediaBox().getWidth();
        coverFormat =  new CoverFormat(12, "Centrado", pageWidth,false, false, true,false);
        int pageLineIndex = 9;
        WordsProperties currentWordLine = wordsLines.get(pageLineIndex);
        System.out.println(currentWordLine.toString());
        List<String> output = coverFormat.getFormatErrorComments(currentWordLine);
        List<String> errorComments = new ArrayList<>();
        errorComments.add(errorComment);

        assertEquals(output, errorComments);
    }
}
