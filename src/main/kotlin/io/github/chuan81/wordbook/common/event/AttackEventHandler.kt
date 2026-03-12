package io.github.chuan81.wordbook.common.event

import io.github.chuan81.wordbook.Wordbook
import io.github.chuan81.wordbook.common.config.ModConfig
import io.github.chuan81.wordbook.common.quiz.QuizGenerator
import io.github.chuan81.wordbook.client.screen.QuizScreen
import io.github.chuan81.wordbook.client.GuiTaskQueue

import net.minecraft.world.entity.LivingEntity
import net.minecraft.world.entity.player.Player
import net.neoforged.neoforge.event.entity.living.LivingDamageEvent
import net.neoforged.bus.api.SubscribeEvent
import net.neoforged.fml.common.EventBusSubscriber
import net.minecraft.network.chat.Component
import kotlin.random.Random

@EventBusSubscriber(modid = Wordbook.ID)  // 不再指定bus
object AttackEventHandler {

    @SubscribeEvent
    fun onPlayerAttack(event: LivingDamageEvent.Post) {
        val attacker = event.source.entity
        if (attacker !is Player) return

        val target = event.entity as LivingEntity
        val damage = event.newDamage

        val whoBeDamaged = target.name.string

        //println("Player ${attacker.name.string} attacked ${whoBeDamaged}, damaged: $damage !")
        attacker.sendSystemMessage(
            Component.literal("§a[提示]§f 你对 §e${whoBeDamaged}§f 造成了 §c$damage§f 点伤害")
        )

        // 概率触发
        if (Random.nextDouble(0.0, 1.0) > ModConfig.attackTriggerProbability) return
        //else println("random go!")

        // 生成单词题
        val quiz = QuizGenerator.generate()

        // 放入客户端 GUI 队列，延迟到客户端 tick 执行
        GuiTaskQueue.add {
            net.minecraft.client.Minecraft.getInstance().setScreen(QuizScreen(quiz))
        }


    }
}