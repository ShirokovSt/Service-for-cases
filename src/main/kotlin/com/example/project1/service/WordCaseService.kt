package com.example.project1.service

interface WordCaseService {
    fun spell(word: String): List<String>
}