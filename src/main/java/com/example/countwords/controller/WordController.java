package com.example.countwords.controller;

import com.example.countwords.model.CountWordsResponse;
import com.example.countwords.service.FileWordReader;
import com.example.countwords.service.WordService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/words")
@Tag(name = "Word Processing", description = "APIs for processing word list based on business rules")
public class WordController {

    private final WordService wordService;
    private final FileWordReader fileWordReader;

    public WordController(WordService wordService, FileWordReader fileWordReader) {
        this.wordService = wordService;
        this.fileWordReader = fileWordReader;
    }

    @Operation(
            summary = "Get word statistics",
            description = "Returns the number of words starting with 'M' or 'm' and all words longer than 5 characters",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Successfully processed words"),
                    @ApiResponse(responseCode = "500", description = "Internal server error")
            }
    )
    @GetMapping("/start")
    public CountWordsResponse processWords(){
        return wordService.processWords(fileWordReader.readWords());
    }

}
