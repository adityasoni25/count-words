package com.example.countwords.service;

import com.example.countwords.model.CountWordsResponse;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

public class WordService {

    public CountWordsResponse processWords(List<String> words) {
        long count = words.stream()
                .filter(word -> word.toLowerCase().startsWith("m"))
                .count();

        List<String> longerThanFive = words.stream()
                .filter(word -> word.length() > 5)
                .collect(Collectors.toList());

        return new CountWordsResponse(count, longerThanFive);
    }
}