package com.example.countwords.service;

import com.example.countwords.exceptions.WordFileReadException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.stream.Stream;

@Service
public class FileWordReader {

    @Value("${words.file-path}")
    Resource wordsFile;

    public List<String> readWords() {
        try (BufferedReader reader = new BufferedReader(
                new InputStreamReader(wordsFile.getInputStream()))) {

            return reader.lines()
                    .flatMap(line -> Stream.of(line.trim().split("\\s+")))
                    .filter(word -> !word.isBlank())
                    .toList();

        } catch (IOException e) {
            throw new WordFileReadException("Failed to read words from file", e);
        }
    }

}
