package com.example.countwords.service;

import com.example.countwords.model.CountWordsResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class WordService {

    public CountWordsResponse processWords(List<String> words) {
        log.info("Processing {} words", words.size());

        long count = words.stream()
                .filter(word -> word.toLowerCase().startsWith("m"))
                .count();
        log.debug("Number of words starting with 'm' or 'M': {}", count);

        List<String> longerThanFive = words.stream()
                .filter(word -> word.length() > 5)
                .toList();
        log.debug("Words longer than 5 characters: {}", longerThanFive);

        return new CountWordsResponse(count, longerThanFive);
    }
}
