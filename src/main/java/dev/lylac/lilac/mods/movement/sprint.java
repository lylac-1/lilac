package dev.lylac.lilac.mods.movement;

import dev.lylac.lilac.mods.mod;
import org.lwjgl.glfw.GLFW;

public class sprint extends mod {
    public sprint() {
        super("Sprint", "keeps your sprint", Category.MOVEMENT);
        this.setKey(GLFW.GLFW_KEY_V);
    }
    @Override
    public void onTick() {
        assert clientInstance.player != null;
        clientInstance.player.setSprinting(true);
        super.onTick();
    }
}
