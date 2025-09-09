package net.bluehill.ingameeditor

import net.bluehill.ingameeditor.screen.IgeMainScreen
import net.fabricmc.api.ClientModInitializer
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper
import net.minecraft.client.MinecraftClient
import net.minecraft.client.option.KeyBinding
import net.minecraft.client.util.InputUtil
import org.lwjgl.glfw.GLFW

object InGameEditorClient : ClientModInitializer {
    private lateinit var f12Kb: KeyBinding

    override fun onInitializeClient() {
        // This entrypoint is suitable for setting up client-specific logic, such as rendering.
        f12Kb = KeyBindingHelper.registerKeyBinding(
            KeyBinding(
                "key.bh.test",
                InputUtil.Type.KEYSYM,
                GLFW.GLFW_KEY_F12,
                "category.bh.test"
            )
        )

        ClientTickEvents.END_CLIENT_TICK.register {
            if (f12Kb.isPressed) {
                val mc = MinecraftClient.getInstance()
                val cs = mc.currentScreen

                if (cs !is IgeMainScreen) {
                    mc.setScreen(IgeMainScreen(cs))
                }
            }
        }
    }
}
