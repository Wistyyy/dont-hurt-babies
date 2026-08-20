package xyz.xenoo.dont_hurt_babies

import net.fabricmc.fabric.api.entity.event.v1.ServerLivingEntityEvents
import net.minecraft.network.chat.Component
import net.minecraft.server.level.ServerPlayer
import net.minecraft.world.entity.EntityTypes

class BeNiceToAnimals {
    fun asshole() {
        ServerLivingEntityEvents.ALLOW_DAMAGE.register { entity, source, _ ->
            if (source.entity?.`is`(EntityTypes.PLAYER) == true && entity.isBaby) {
                (source.entity as ServerPlayer).sendSystemMessage(
                    Component.literal("Don't hurt baby animals!")
                )
                false
            } else {
                true
            }
        }
    }
}