package net.bluehill.ingameeditor.data

import net.minecraft.text.Text

class BooleanData(
    name: Text,
    description: Text?,
    val getter: () -> Boolean,
    val setter: (Boolean) -> Unit
) : AbstractData(name, description)
