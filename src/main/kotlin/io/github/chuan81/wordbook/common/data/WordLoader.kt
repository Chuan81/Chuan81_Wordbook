package io.github.chuan81.wordbook.common.data

object WordLoader {

    fun load() {
        // 清空旧数据
        WordRepository.words.clear()

        // 硬编码测试数据（后续可从 Excel/JSON 导入）
        WordRepository.words.add(Word("apple", "[ˈæpl]", "苹果"))
        WordRepository.words.add(Word("banana", "[bəˈnɑːnə]", "香蕉"))
        WordRepository.words.add(Word("cat", "[kæt]", "猫"))
        WordRepository.words.add(Word("dog", "[dɔg]", "狗"))
        WordRepository.words.add(Word("orange", "[ˈɔrɪndʒ]", "橙子"))

        println("WordLoader: ${WordRepository.words.size} words loaded")
    }
}