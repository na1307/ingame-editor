package net.bluehill.ingameeditor.widget

import net.bluehill.ingameeditor.screen.IgeScrollableScreen
import net.fabricmc.api.EnvType
import net.fabricmc.api.Environment
import net.minecraft.client.MinecraftClient
import net.minecraft.client.gui.DrawContext
import net.minecraft.client.gui.widget.ElementListWidget

@Environment(EnvType.CLIENT)
class IgeElementsWidget(
    client: MinecraftClient,
    screen: IgeScrollableScreen
) : ElementListWidget<IgeAbstractEntry>(
    client,
    screen.width,
    screen.layout.contentHeight,
    screen.layout.headerHeight,
    30
) {
    override fun renderWidget(context: DrawContext, mouseX: Int, mouseY: Int, deltaTicks: Float) {
        super.renderWidget(context, mouseX, mouseY, deltaTicks)

        if (hoveredEntry?.description !== null) {
            context.drawTooltip(hoveredEntry!!.description, mouseX, mouseY)
        }
    }
}
