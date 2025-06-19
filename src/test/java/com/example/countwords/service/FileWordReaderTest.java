package com.example.countwords.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class FileWordReaderTest {

    private FileWordReader fileWordReader;

    @BeforeEach
    void setUp() {
        fileWordReader = new FileWordReader();
    }

    @Test
    void shouldReadWordsFromFileSuccessfully() throws Exception {
        List<String> words = fileWordReader.readWords();

        assertNotNull(words, "Words list should not be null");
        assertFalse(words.isEmpty(), "Words list should not be empty");
        assertTrue(words.contains("Monkey"), "Should contain 'Monkey'");
        assertTrue(words.contains("banana"), "Should contain 'banana'");
    }

    @Test
    void shouldReadCorrectNumberOfWords() throws Exception {
        List<String> words = fileWordReader.readWords();

        // Adjust expected count based on test file
        assertEquals(9, words.size(), "Should read 8 words from the file");
    }

}
