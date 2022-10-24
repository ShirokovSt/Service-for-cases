package com.example.project1.service

import com.github.demidko.aot.WordformMeaning.lookupForMeanings
import org.springframework.stereotype.Service


@Service
class WordCaseServiceImpl : WordCaseService {

    override fun spell(word: String): List<String> {
        val listWords = arrayListOf<String>()
        val meanings = lookupForMeanings(word)
        for ((counter, currentValue) in meanings[0].transformations.withIndex()) {
            if (counter == 6) break;
            listWords.add(currentValue.toString())
        }
        return listWords
    }
}
