package net.bluehill.ingameeditor.data

import net.bluehill.ingameeditor.screen.IgeScreen
import net.minecraft.text.Text

class SubScreenData(name: Text, description: Text?, val screenCreator: () -> IgeScreen) :
    AbstractData(name, description)
