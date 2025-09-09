package net.bluehill.ingameeditor.data

import net.minecraft.text.Text

class FloatData(
    name: Text,
    description: Text?,
    val getter: () -> Float,
    val setter: (Float) -> Unit
) : AbstractData(name, description)
