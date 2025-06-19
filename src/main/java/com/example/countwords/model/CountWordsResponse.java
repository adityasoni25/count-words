package com.example.countwords.model;

import lombok.Data;

import java.util.List;

@Data
public class CountWordsResponse {
    private final long countStartingWithM;
    private final List<String> wordsLongerThanFiveChars;

    public CountWordsResponse(long countStartingWithM, List<String> wordsLongerThanFiveChars) {
        this.countStartingWithM = countStartingWithM;
        this.wordsLongerThanFiveChars = wordsLongerThanFiveChars;
    }
}
