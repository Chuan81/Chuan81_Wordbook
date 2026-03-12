package io.github.chuan81.wordbook

import net.neoforged.fml.common.Mod
import io.github.chuan81.wordbook.common.data.WordLoader

@Mod(Wordbook.ID)
object Wordbook {
    const val ID: String = "wordbook"
    init {
        println("Chuan81 Wordbook Neoforge 1.21.1 0.0.1 loaded!")

        // 加载单词
        WordLoader.load()
    }
}