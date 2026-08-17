package xyz.xenoo.harder_earlygame

import net.fabricmc.fabric.api.event.player.PlayerBlockBreakEvents
import net.minecraft.world.effect.MobEffectInstance
import net.minecraft.world.effect.MobEffects
import net.minecraft.world.level.GameType
import net.minecraft.server.level.ServerLevel

class HurtWhileMining {
    fun act() {
        PlayerBlockBreakEvents.AFTER.register { level, player, pos, state, entity ->
            if (player.gameMode() != GameType.CREATIVE && !player.hasCorrectToolForDrops(state)) {
                var damage = state.getDestroySpeed(level, pos)
                if (damage > 0) {
                    damage += 0.7f
                }
                player.hurtServer(level as ServerLevel, player.damageSources().generic(), damage)
                player.addEffect(MobEffectInstance(MobEffects.MINING_FATIGUE, (damage * 40).toInt(), 1))
            }
        }



    }
}