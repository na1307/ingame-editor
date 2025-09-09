package net.bluehill.ingameeditor.screen

import net.fabricmc.api.EnvType
import net.fabricmc.api.Environment
import net.minecraft.client.gui.screen.Screen
import net.minecraft.client.gui.widget.ButtonWidget
import net.minecraft.text.Text

@Environment(EnvType.CLIENT)
abstract class IgeScreen(title: Text, private val parent: Screen?) : Screen(title) {
    override fun init() {
        val backButton = ButtonWidget.builder(Text.literal("Back")) {
            close()
        }.dimensions(width - 250, height - 30, 250, 20).build()

        addDrawableChild(backButton)
    }

    final override fun close() {
        client?.setScreen(parent)
    }
}
