package io.github.chuan81.wordbook.common.quiz

import io.github.chuan81.wordbook.common.data.WordRepository
import net.minecraft.world.entity.player.Player

object QuizGenerator {

    fun generate(player: Player): Quiz {
        val word = WordRepository.random()
        val options = WordRepository.randomOptions(word, 4)
        println("Quiz Generator generated successfully!")
        return Quiz(word.word, word.phonetic, word.meaning, options, player = player)
    }
}