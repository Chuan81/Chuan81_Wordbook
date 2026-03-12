package io.github.chuan81.wordbook.client

import io.github.chuan81.wordbook.Wordbook
import net.neoforged.bus.api.SubscribeEvent
import net.neoforged.neoforge.client.event.ClientTickEvent
import net.neoforged.fml.common.EventBusSubscriber

// NeoForge 1.21.1 客户端事件注册
@EventBusSubscriber(modid = Wordbook.ID)
object ClientEventHandler {

    @SubscribeEvent
    fun onClientEndTick(event: ClientTickEvent.Post) {
        GuiTaskQueue.executeAll()
    }
}