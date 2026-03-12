package io.github.chuan81.wordbook.common.quiz

import net.minecraft.world.entity.player.Player

data class Quiz(
    val word: String,
    val phonetic: String,
    val correct: String,
    val options: List<String>,
    val player: Player
)