package com.example.countwords;

import com.example.countwords.model.CountWordsResponse;
import com.example.countwords.service.WordService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@SpringBootApplication
public class CountwordsApplication {

	public static void main(String[] args) {
		SpringApplication.run(CountwordsApplication.class, args);

		List<String> words;
		try (BufferedReader reader = new BufferedReader(
				new InputStreamReader(CountwordsApplication.class.getResourceAsStream("/words.txt")))
		) {
			words = reader.lines()
					.flatMap(line -> Stream.of(line.trim().split("\\s+")))
					.filter(word -> !word.isBlank())
					.collect(Collectors.toList());
		} catch (Exception e) {
			System.err.println("Failed to read input file: " + e.getMessage());
			return;
		}

		WordService service = new WordService();
		CountWordsResponse result = service.processWords(words);

		System.out.println("Number of words starting with 'M' or 'm': " + result.getCountStartingWithM());
		System.out.println("Words longer than 5 characters: " + result.getWordsLongerThanFiveChars());
	}

}
