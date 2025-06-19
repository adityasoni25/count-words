package com.example.countwords.service;

import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class FileWordReader {

    public List<String> readWords() throws Exception {
        try (BufferedReader reader = new BufferedReader(
                new InputStreamReader(this.getClass().getResourceAsStream("/words.txt")))) {

            return reader.lines()
                    .flatMap(line -> Stream.of(line.trim().split("\\s+")))
                    .filter(word -> !word.isBlank())
                    .collect(Collectors.toList());
        }
    }

}
