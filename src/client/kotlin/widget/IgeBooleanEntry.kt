package net.bluehill.ingameeditor.widget

import net.bluehill.ingameeditor.screen.IgeScrollableScreen
import net.fabricmc.api.EnvType
import net.fabricmc.api.Environment
import net.minecraft.client.gui.DrawContext
import net.minecraft.client.gui.widget.ButtonWidget
import net.minecraft.text.OrderedText
import net.minecraft.text.Text

@Environment(EnvType.CLIENT)
class IgeBooleanEntry(
    name: Text,
    description: List<OrderedText>?,
    screen: IgeScrollableScreen,
    private val getter: () -> Boolean,
    private val setter: (Boolean) -> Unit
) : IgeAbstractEntry(name, description, screen) {
    private val tb: ButtonWidget = ButtonWidget.builder(Text.of(getter().toString())) {
        setter(!getter())
        it.message = Text.of(getter().toString())
    }.dimensions(10, 5, 50, 20).build()

    init {
        children.add(tb)
    }

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

        tb.x = x + entryWidth - 51
        tb.y = y

        tb.render(context, mouseX, mouseY, tickProgress)
    }
}
