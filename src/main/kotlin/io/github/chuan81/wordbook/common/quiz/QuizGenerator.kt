package io.github.chuan81.wordbook.common.quiz

import io.github.chuan81.wordbook.common.data.WordRepository
import kotlin.random.Random

object QuizGenerator {

    fun generate(): Quiz {
        val word = WordRepository.random()
        val options = WordRepository.randomOptions(word, 4)
        println("Quiz Generator generated successfully!")
        return Quiz(word.word, word.phonetic, word.meaning, options)
    }
}