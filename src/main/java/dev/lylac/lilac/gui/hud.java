package dev.lylac.lilac.gui;

import dev.lylac.lilac.mods.mod;
import dev.lylac.lilac.mods.modManager;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.util.math.MatrixStack;

public class hud {
    private static MinecraftClient clientInstance = MinecraftClient.getInstance();
    public static void render(MatrixStack matrices, float tickDelta) {
        renderArrayList(matrices);
        clientInstance.textRenderer.drawWithShadow(matrices, "lilac lol", 10, 10, -1);
    }

    public static void renderArrayList(MatrixStack matrices) {
        int count = 0;
        int sWidth = clientInstance.getWindow().getScaledWidth();
        int sHeight = clientInstance.getWindow().getScaledHeight();
        for (mod m : modManager.INSTANCE.getEnabledMods()) {
            clientInstance.textRenderer.drawWithShadow(matrices, m.getName(), (sWidth - 6) - clientInstance.textRenderer.getWidth(m.getName()), 10 + count * clientInstance.textRenderer.fontHeight, -1);
            count++;
        }
    }
}
