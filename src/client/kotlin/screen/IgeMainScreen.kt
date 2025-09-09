package net.bluehill.ingameeditor.screen

import net.fabricmc.api.EnvType
import net.fabricmc.api.Environment
import net.minecraft.client.gui.screen.Screen
import net.minecraft.client.gui.widget.ButtonWidget
import net.minecraft.text.Text

@Environment(EnvType.CLIENT)
class IgeMainScreen(parent: Screen?) : IgeScreen(Text.literal("IGEMain"), parent) {
    override fun init() {
        super.init()

        val editPlayerButton = ButtonWidget.builder(Text.literal("Edit Player")) {
            client?.setScreen(IgeEditPlayerScreen(this))
        }.dimensions(100, 100, 100, 20).build()

        addDrawableChild(editPlayerButton)
    }
}
