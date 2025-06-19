//package com.example.countwords.service;
//
//import com.example.countwords.model.CountWordsResponse;
//import org.junit.jupiter.api.Test;
//
//import java.util.Arrays;
//import java.util.List;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.junit.jupiter.api.Assertions.assertTrue;
//
//public class WordServiceTest {
//    private final WordService service = new WordService();
//
//    @Test
//    void testProcessWords() {
//        List<String> input = Arrays.asList(
//                "Monkey", "Mountain", "banana", "elephant",
//                "momentum", "Magnify", "matter", "sun", "sky"
//        );
//
//        CountWordsResponse response = service.processWords(input);
//
//        // Validate count of words starting with 'M' or 'm'
//        assertEquals(5, response.getCountStartingWithM());
//
//        // Validate words longer than 5 characters
//        List<String> expectedLongWords = Arrays.asList(
//                "Monkey", "Mountain", "banana", "elephant", "momentum", "Magnify", "matter"
//        );
//
//        assertEquals(expectedLongWords.size(), response.getWordsLongerThanFiveChars().size());
//        assertTrue(response.getWordsLongerThanFiveChars().containsAll(expectedLongWords));
//    }
//}
