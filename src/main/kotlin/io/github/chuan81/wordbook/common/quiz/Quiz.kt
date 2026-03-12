package io.github.chuan81.wordbook.common.quiz

data class Quiz(
    val word: String,
    val phonetic: String,
    val correct: String,
    val options: List<String>
)