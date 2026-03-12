package io.github.chuan81.wordbook.client.screen

import net.minecraft.client.gui.components.Button
import net.minecraft.client.gui.screens.Screen
import net.minecraft.network.chat.Component
import io.github.chuan81.wordbook.common.quiz.Quiz

class QuizScreen(val quiz: Quiz) : Screen(Component.literal("单词测试")) {

    override fun init() {
        super.init()

        val startY = 50
        val spacing = 25
        val buttonWidth = 200
        val buttonHeight = 20
        var currentY = startY

        // 单词
        addRenderableWidget(Button.builder(
            Component.literal("Word: ${quiz.word} ${quiz.phonetic}")
        ) {}.bounds(50, currentY, buttonWidth, buttonHeight).build())
        currentY += spacing

        // 选项按钮
        quiz.options.forEach { option ->
            addRenderableWidget(Button.builder(
                Component.literal(option)
            ) {
                if (option == quiz.correct) {
                    println("答对了: $option")
                } else {
                    println("答错了: $option, 正确答案: ${quiz.correct}")
                }
                minecraft?.setScreen(null) // 关闭界面
            }.bounds(50, currentY, buttonWidth, buttonHeight).build())
            currentY += spacing
        }
    }
}