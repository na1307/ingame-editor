package net.bluehill.ingameeditor.widget

import net.bluehill.ingameeditor.screen.IgeScrollableScreen
import net.fabricmc.api.EnvType
import net.fabricmc.api.Environment
import net.minecraft.client.gui.DrawContext
import net.minecraft.client.gui.Element
import net.minecraft.client.gui.Selectable
import net.minecraft.client.gui.widget.ClickableWidget
import net.minecraft.client.gui.widget.ElementListWidget
import net.minecraft.text.OrderedText
import net.minecraft.text.Text

@Environment(EnvType.CLIENT)
abstract class IgeAbstractEntry(
    name: Text,
    val description: List<OrderedText>?,
    protected val screen: IgeScrollableScreen
) : ElementListWidget.Entry<IgeAbstractEntry>() {
    protected val children = ArrayList<ClickableWidget>()
    private val name = screen.textRenderer.wrapLines(name, 175)

    final override fun children(): List<Element> = children

    final override fun selectableChildren(): List<Selectable> = children

    protected fun drawName(context: DrawContext, x: Int, y: Int) {
        if (name.size == 1) {
            context.drawTextWithShadow(screen.textRenderer, name[0], x, y + 5, -1)
        } else if (name.size >= 2) {
            context.drawTextWithShadow(screen.textRenderer, name[0], x, y, -1)
            context.drawTextWithShadow(screen.textRenderer, name[1], x, y + 10, -1)
        }
    }
}
