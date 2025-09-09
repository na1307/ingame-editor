package net.bluehill.ingameeditor.screen

import net.bluehill.ingameeditor.data.PlayerAbilityDatas
import net.fabricmc.api.EnvType
import net.fabricmc.api.Environment
import net.minecraft.client.gui.screen.Screen
import net.minecraft.entity.player.PlayerAbilities
import net.minecraft.text.Text

@Environment(EnvType.CLIENT)
class IgeEditPlayerAbilitiesScreen(parent: Screen?, playerAbilities: PlayerAbilities) :
    IgeScrollableScreen(
        Text.literal("IGEEditPlayerAbilities"),
        parent,
        PlayerAbilityDatas(playerAbilities)
    )
