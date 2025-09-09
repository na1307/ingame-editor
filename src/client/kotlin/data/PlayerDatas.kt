package net.bluehill.ingameeditor.data

import net.bluehill.ingameeditor.screen.IgeEditPlayerAbilitiesScreen
import net.minecraft.client.MinecraftClient
import net.minecraft.entity.player.PlayerEntity
import net.minecraft.text.Text

class PlayerDatas(private val playerDatas: PlayerEntity) : Iterable<AbstractData> {
    override fun iterator(): Iterator<AbstractData> =
        sequence {
            yield(
                SubScreenData(Text.literal("Abilities"), Text.literal("abilities")) {
                    IgeEditPlayerAbilitiesScreen(MinecraftClient.getInstance().currentScreen, playerDatas.abilities)
                }
            )
        }.iterator()
}
