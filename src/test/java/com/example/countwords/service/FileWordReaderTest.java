package com.example.countwords.service;

import com.example.countwords.exceptions.WordFileReadException;
import org.junit.jupiter.api.Test;
import org.springframework.core.io.Resource;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class FileWordReaderTest {

    @Test
    void readWords_returnsWordListFromResourceFile() throws IOException {
        // Arrange
        String mockContent = "Monkey mango\nmelon Maple";
        InputStream mockInputStream = new ByteArrayInputStream(mockContent.getBytes());

        Resource mockResource = mock(Resource.class);
        when(mockResource.getInputStream()).thenReturn(mockInputStream);

        FileWordReader reader = new FileWordReader();
        reader.wordsFile = mockResource; // manually inject mock

        // Act
        List<String> result = reader.readWords();

        // Assert
        assertEquals(List.of("Monkey", "mango", "melon", "Maple"), result);
    }

    @Test
    void readWords_throwsCustomExceptionOnIOException() throws IOException {
        // Arrange
        Resource mockResource = mock(Resource.class);
        when(mockResource.getInputStream()).thenThrow(new IOException("Simulated failure"));

        FileWordReader reader = new FileWordReader();
        reader.wordsFile = mockResource;

        // Act & Assert
        WordFileReadException ex = assertThrows(
                WordFileReadException.class,
                reader::readWords
        );

        assertTrue(ex.getMessage().contains("Failed to read words"));
    }
}
