package dev.lylac.lilac;

import net.fabricmc.api.ModInitializer;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import net.minecraft.client.MinecraftClient;
import dev.lylac.lilac.mods.modManager;
import dev.lylac.lilac.mods.mod;
import dev.lylac.lilac.gui.screens.clickGUI.clickGUI;
import org.lwjgl.glfw.GLFW;

public class Lilac implements ModInitializer {
    // values
    public static Lilac INSTANCE = new Lilac();
    public Logger logger = LogManager.getLogger(Lilac.class);
    private final MinecraftClient clientInstance = MinecraftClient.getInstance();

    // called once on client start
    @Override
    public void onInitialize() {
        logger.info("Lilac Initialize start");
    }

    // called for every key press event
    public void onKeyPress(int key, int action) {
        if (action == GLFW.GLFW_PRESS) {
            for (mod mod : modManager.INSTANCE.getMods()) {
                if (key == mod.getKey()) mod.toggle();
            }
            if (key == GLFW.GLFW_KEY_RIGHT_SHIFT) {
                clientInstance.setScreen(clickGUI.INSTANCE);
            }
        }
    }
    // called every client tick
    public void onTick() {
        if (clientInstance.player != null) {
            for(mod mod : modManager.INSTANCE.getEnabledMods()) {
                mod.onTick();
            }
        }
    }
}
