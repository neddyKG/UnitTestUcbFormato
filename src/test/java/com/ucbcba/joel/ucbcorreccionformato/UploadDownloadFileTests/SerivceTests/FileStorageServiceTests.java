package com.ucbcba.joel.ucbcorreccionformato.UploadDownloadFileTests.SerivceTests;

import com.ucbcba.joel.ucbcorreccionformato.FormatControl.GetterWordLines;
import com.ucbcba.joel.ucbcorreccionformato.PageCalibration.WordsFinder;
import com.ucbcba.joel.ucbcorreccionformato.UploadDownloadFile.Exception.FileStorageException;
import com.ucbcba.joel.ucbcorreccionformato.UploadDownloadFile.Property.FileStorageProperties;
import com.ucbcba.joel.ucbcorreccionformato.UploadDownloadFile.Service.FileStorageService;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.springframework.mock.web.MockMultipartFile;

import java.io.IOException;

import static org.junit.Assert.assertEquals;


public class FileStorageServiceTests {
    private PDDocument pdf;
    private String CORRECT_DOCUMENT_PATH="./uploads";
    private WordsFinder wordsFinder;
    private FileStorageProperties fileStorageProperties;
    private FileStorageService fileStorageService;

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Before
    public void setUp() {
        fileStorageProperties = new FileStorageProperties();
        fileStorageProperties.setUploadDir(CORRECT_DOCUMENT_PATH);
        fileStorageService = new FileStorageService(fileStorageProperties);
    }

    @Test
    public void succesfulPdfFileUpload() {
        MockMultipartFile mockMultipartFile = new MockMultipartFile("file", "documentoVacio.pdf", "application/pdf", "informe".getBytes());
        assertEquals(fileStorageService.storeFile(mockMultipartFile), "documentoVacio.pdf");

    }
    @Test(expected = FileStorageException.class)
    public void unsuccesfulExcelFileUpload() {
        MockMultipartFile mockMultipartFile = new MockMultipartFile("file", "excel.xlsx", "multipart/form-data", "informe".getBytes());
        fileStorageService.storeFile(mockMultipartFile);
        thrown.expectMessage("¡Lo siento! Seleccione un archivo PDF por favor.");

    }


}
