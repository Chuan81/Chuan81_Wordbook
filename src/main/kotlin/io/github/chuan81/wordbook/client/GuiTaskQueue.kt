package io.github.chuan81.wordbook.client

object GuiTaskQueue {
    private val tasks = mutableListOf<() -> Unit>()

    fun add(task: () -> Unit) {
        tasks.add(task)
    }

    fun executeAll() {
        tasks.forEach { it() }
        tasks.clear()
    }
}