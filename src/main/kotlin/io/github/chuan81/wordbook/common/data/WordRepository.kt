package io.github.chuan81.wordbook.common.data

import kotlin.random.Random

object WordRepository {

    val words = mutableListOf<Word>()

    fun random(): Word = words.random()

    fun randomOptions(correct: Word, optionCount: Int = 4): List<String> {
        val options = mutableSetOf(correct.meaning)
        while (options.size < optionCount) {
            val w = words.random()
            if (w != correct) options.add(w.meaning)
        }
        return options.shuffled(Random(System.currentTimeMillis()))
    }
}