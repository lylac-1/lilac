package dev.lylac.lilac;

import dev.lylac.lilac.gui.screens.clickGUI.clickGUI;
import dev.lylac.lilac.mods.mod;
import dev.lylac.lilac.mods.modManager;
import net.fabricmc.api.ModInitializer;
import net.minecraft.client.MinecraftClient;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.lwjgl.glfw.GLFW;

public class Lilac implements ModInitializer {
    public static Lilac INSTANCE = new Lilac();
    public Logger logger = LogManager.getLogger(Lilac.class);
    private MinecraftClient clientInstance = MinecraftClient.getInstance();

    @Override
    public void onInitialize() {
        logger.info("Lilac Initalize start");
    }

    public void onKeyPress(int key, int action) {
        if (action == GLFW.GLFW_PRESS) {
            for (mod m : modManager.INSTANCE.getMods()) {
                if (key == m.getKey()) m.toggle();
            }

            if (key == GLFW.GLFW_KEY_RIGHT_SHIFT) clientInstance.setScreen(clickGUI.INSTANCE);
        }
    }
    public void onTick() {
        if (clientInstance.player != null) {
            for(mod m : modManager.INSTANCE.getEnabledMods()) {
                m.onTick();
            }
        }
    }
}
