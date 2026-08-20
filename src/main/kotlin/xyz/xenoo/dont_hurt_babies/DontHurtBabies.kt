package xyz.xenoo.dont_hurt_babies

import net.fabricmc.api.ModInitializer

class DontHurtBabies : ModInitializer {

    override fun onInitialize() {
        HurtWhileMining().act()
        BeNiceToAnimals().asshole()
    }
}
