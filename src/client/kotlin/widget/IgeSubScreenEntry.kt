package net.bluehill.ingameeditor.widget

import net.bluehill.ingameeditor.screen.IgeScreen
import net.bluehill.ingameeditor.screen.IgeScrollableScreen
import net.fabricmc.api.EnvType
import net.fabricmc.api.Environment
import net.minecraft.client.MinecraftClient
import net.minecraft.client.gui.DrawContext
import net.minecraft.client.gui.widget.ButtonWidget
import net.minecraft.text.OrderedText
import net.minecraft.text.Text

@Environment(EnvType.CLIENT)
class IgeSubScreenEntry(
    name: Text,
    description: List<OrderedText>?,
    screen: IgeScrollableScreen,
    private val screenCreator: () -> IgeScreen
) : IgeAbstractEntry(name, description, screen) {
    override fun render(
        context: DrawContext,
        index: Int,
        y: Int,
        x: Int,
        entryWidth: Int,
        entryHeight: Int,
        mouseX: Int,
        mouseY: Int,
        hovered: Boolean,
        tickProgress: Float
    ) {
        drawName(context, x, y)

        val scb = ButtonWidget.builder(Text.literal("Edit")) {
            MinecraftClient.getInstance().setScreen(screenCreator())
        }.dimensions(10, 5, 50, 20).build()

        children.add(scb)

        scb.x = x + entryWidth - 51
        scb.y = y

        scb.render(context, mouseX, mouseY, tickProgress)
    }
}
