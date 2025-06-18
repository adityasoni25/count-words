package com.example.countwords.model;

import java.util.List;

public class CountWordsResponse {
    private final long countStartingWithM;
    private final List<String> wordsLongerThanFiveChars;

    public CountWordsResponse(long countStartingWithM, List<String> wordsLongerThanFiveChars) {
        this.countStartingWithM = countStartingWithM;
        this.wordsLongerThanFiveChars = wordsLongerThanFiveChars;
    }

    public long getCountStartingWithM() {
        return countStartingWithM;
    }

    public List<String> getWordsLongerThanFiveChars() {
        return wordsLongerThanFiveChars;
    }
}
