package com.example.countwords.service;

import com.example.countwords.model.CountWordsResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WordService {

    public CountWordsResponse processWords(List<String> words) {
        long count = words.stream()
                .filter(word -> word.toLowerCase().startsWith("m"))
                .count();

        List<String> longerThanFive = words.stream()
                .filter(word -> word.length() > 5)
                .toList();

        return new CountWordsResponse(count, longerThanFive);
    }
}