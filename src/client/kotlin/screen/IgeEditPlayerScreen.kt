package net.bluehill.ingameeditor.screen

import net.bluehill.ingameeditor.data.PlayerDatas
import net.fabricmc.api.EnvType
import net.fabricmc.api.Environment
import net.minecraft.client.MinecraftClient
import net.minecraft.client.gui.screen.Screen
import net.minecraft.text.Text

@Environment(EnvType.CLIENT)
class IgeEditPlayerScreen(parent: Screen?) : IgeScrollableScreen(
    Text.literal("IGEEditPlayer"), parent, PlayerDatas(MinecraftClient.getInstance().player!!)
)
