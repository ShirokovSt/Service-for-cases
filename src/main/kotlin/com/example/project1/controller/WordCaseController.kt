package com.example.project1.controller

import com.example.project1.service.WordCaseService
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/spell")
class WordCaseController(
    private val caseService: WordCaseService
) {

    @GetMapping("{word}", produces = ["application/json;charset=UTF-8"])
    @ResponseStatus(HttpStatus.FOUND)
    fun getWordCases(@PathVariable word: String) = caseService.spell(word)
}