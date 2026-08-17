package xyz.xenoo.harder_earlygame

import net.fabricmc.api.ModInitializer

class HarderEarlygame : ModInitializer {

    override fun onInitialize() {
        HurtWhileMining().act()
        BeNiceToAnimals().asshole()
    }
}
