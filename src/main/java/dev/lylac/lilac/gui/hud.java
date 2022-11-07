package dev.lylac.lilac.gui;

import java.awt.*;
import java.util.Comparator;
import java.util.List;
import dev.lylac.lilac.mods.mod;
import dev.lylac.lilac.mods.modManager;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.util.math.MatrixStack;

public class hud {
    private static final MinecraftClient clientInstance = MinecraftClient.getInstance();
    public static void render(MatrixStack matrices, float tickDelta) {
        renderArrayList(matrices);
        clientInstance.textRenderer.drawWithShadow(matrices, "lilac v0.0.1b", 4, 4, Color.white.getRGB());
    }
    public static void renderArrayList(MatrixStack matrices) {
        List<mod> enabled = modManager.INSTANCE.getEnabledMods();
        enabled.sort(Comparator.comparingInt(mod -> clientInstance.textRenderer.getWidth(((mod)mod).getName())).reversed());
        int index = 0;
        int sWidth = clientInstance.getWindow().getScaledWidth();
        for (mod mod : enabled) {
            clientInstance.textRenderer.drawWithShadow(matrices, mod.getName(), (sWidth - 4) - clientInstance.textRenderer.getWidth(mod.getName()), 4 + index * clientInstance.textRenderer.fontHeight, Color.white.getRGB());
            index++;
        }
    }
}
