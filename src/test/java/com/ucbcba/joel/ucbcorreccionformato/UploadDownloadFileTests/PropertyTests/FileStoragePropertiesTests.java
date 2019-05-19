package com.ucbcba.joel.ucbcorreccionformato.UploadDownloadFileTests.PropertyTests;

import com.ucbcba.joel.ucbcorreccionformato.PageCalibration.WordsFinder;
import com.ucbcba.joel.ucbcorreccionformato.UploadDownloadFile.Property.FileStorageProperties;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.IOException;

import static org.junit.Assert.assertEquals;


public class FileStoragePropertiesTests {
    private String PATH="./uploads/documentoCompleto.pdf";
    private FileStorageProperties fileStorageProperties;

    @Before
    public void setUp() {
         fileStorageProperties = new FileStorageProperties();
    }

        @Test
    public void succesfulGetPath() throws IOException {
        fileStorageProperties.setUploadDir(PATH);
        assertEquals(fileStorageProperties.getUploadDir(), "./uploads/documentoCompleto.pdf");
    }


}
