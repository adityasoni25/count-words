package com.example.countwords.service;

import com.example.countwords.exceptions.WordFileReadException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.stream.Stream;

@Service
@Slf4j
public class FileWordReader {

    @Value("${words.file-path}")
    Resource wordsFile;

    public List<String> readWords() {
        log.info("Attempting to read words from file: {}", wordsFile.getFilename());
        try (BufferedReader reader = new BufferedReader(
                new InputStreamReader(wordsFile.getInputStream()))) {

            List<String> words = reader.lines()
                    .flatMap(line -> Stream.of(line.trim().split("\\s+")))
                    .filter(word -> !word.isBlank())
                    .toList();

            log.debug("Words read: {}", words);
            return words;

        } catch (IOException e) {
            log.error("Error reading from file: {}", wordsFile.getFilename(), e);
            throw new WordFileReadException("Failed to read words from file", e);
        }
    }
}
