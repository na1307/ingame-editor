package net.bluehill.ingameeditor.widget

import net.bluehill.ingameeditor.screen.IgeScrollableScreen
import net.fabricmc.api.EnvType
import net.fabricmc.api.Environment
import net.minecraft.client.gui.DrawContext
import net.minecraft.client.gui.widget.TextFieldWidget
import net.minecraft.text.OrderedText
import net.minecraft.text.Text

@Environment(EnvType.CLIENT)
class IgeFloatEntry(
    name: Text,
    description: List<OrderedText>?,
    screen: IgeScrollableScreen,
    private val getter: () -> Float,
    private val setter: (Float) -> Unit
) : IgeAbstractEntry(name, description, screen) {
    private val tf = TextFieldWidget(screen.textRenderer, 10, 5, 50, 20, Text.empty())

    init {
        tf.setTextPredicate {
            it.toFloatOrNull() !== null
        }

        tf.text = getter().toString()

        tf.setChangedListener {
            val value = it.toFloatOrNull()

            if (value !== null) {
                setter(value)
            }
        }

        children.add(tf)
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

        tf.x = x + entryWidth - 51
        tf.y = y

        tf.render(context, mouseX, mouseY, tickProgress)
    }
}
