package net.bluehill.ingameeditor.screen

import net.bluehill.ingameeditor.data.AbstractData
import net.bluehill.ingameeditor.data.BooleanData
import net.bluehill.ingameeditor.data.FloatData
import net.bluehill.ingameeditor.data.SubScreenData
import net.bluehill.ingameeditor.widget.IgeAbstractEntry
import net.bluehill.ingameeditor.widget.IgeBooleanEntry
import net.bluehill.ingameeditor.widget.IgeElementsWidget
import net.bluehill.ingameeditor.widget.IgeFloatEntry
import net.bluehill.ingameeditor.widget.IgeSubScreenEntry
import net.fabricmc.api.EnvType
import net.fabricmc.api.Environment
import net.minecraft.client.gui.screen.Screen
import net.minecraft.client.gui.widget.ButtonWidget
import net.minecraft.client.gui.widget.ThreePartsLayoutWidget
import net.minecraft.text.Text

@Environment(EnvType.CLIENT)
abstract class IgeScrollableScreen(title: Text, parent: Screen?, private val datas: Iterable<AbstractData>) :
    IgeScreen(title, parent) {
    lateinit var layout: ThreePartsLayoutWidget
    lateinit var elements: IgeElementsWidget

    companion object {
        @JvmStatic
        private fun refine(datas: Iterable<AbstractData>, screen: IgeScrollableScreen): Iterable<IgeAbstractEntry> =
            datas.map {
                when (it) {
                    is BooleanData -> {
                        IgeBooleanEntry(
                            it.name,
                            screen.textRenderer.wrapLines(it.description, 100),
                            screen,
                            it.getter,
                            it.setter
                        )
                    }

                    is FloatData -> {
                        IgeFloatEntry(
                            it.name,
                            screen.textRenderer.wrapLines(it.description, 100),
                            screen,
                            it.getter,
                            it.setter
                        )
                    }

                    is SubScreenData -> {
                        IgeSubScreenEntry(
                            it.name,
                            screen.textRenderer.wrapLines(it.description, 100),
                            screen,
                            it.screenCreator
                        )
                    }

                    else -> {
                        throw NotImplementedError()
                    }
                }
            }
    }

    override fun init() {
        layout = ThreePartsLayoutWidget(this)
        elements = layout.addBody(IgeElementsWidget(client!!, this))

        elements.children().addAll(refine(datas, this))

        layout.addHeader(title, textRenderer)

        layout.addFooter(
            ButtonWidget.builder(Text.literal("Back")) {
                close()
            }.dimensions(0, 0, 250, 20).build()
        )

        layout.forEachChild {
            addDrawableChild(it)
        }

        layout.refreshPositions()
        elements.position(width, layout)
    }
}
