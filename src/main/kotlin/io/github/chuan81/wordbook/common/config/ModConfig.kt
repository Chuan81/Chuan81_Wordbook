package io.github.chuan81.wordbook.common.config

object ModConfig {
    // 攻击触发单词题的概率 0.0~1.0
    var attackTriggerProbability: Double = 1.0 // 测试100%

    // 单词表文件路径
    var wordFile: String = "config/wordbook.xlsx"
}