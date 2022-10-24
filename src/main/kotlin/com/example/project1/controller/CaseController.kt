package com.example.project1.controller

import com.example.project1.service.CaseServiceImpl
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/spell")
class CaseController (
    private val caseService : CaseServiceImpl
        ) {

    @GetMapping("{word}")
    fun getCases(@PathVariable word : String) = caseService.spell(word)
}