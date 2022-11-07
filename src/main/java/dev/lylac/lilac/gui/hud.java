package dev.lylac.lilac.gui;

import dev.lylac.lilac.mods.mod;
import dev.lylac.lilac.mods.modManager;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.util.math.MatrixStack;

import java.util.Comparator;
import java.util.List;

public class hud {
    private static MinecraftClient clientInstance = MinecraftClient.getInstance();
    public static void render(MatrixStack matrices, float tickDelta) {
        renderArrayList(matrices);
        clientInstance.textRenderer.drawWithShadow(matrices, "lilac lol", 10, 10, -1);
    }

    public static void renderArrayList(MatrixStack matrices) {
        List<mod> enabled = modManager.INSTANCE.getEnabledMods();
        enabled.sort(Comparator.comparingInt(m -> clientInstance.textRenderer.getWidth(((mod)m).getName())).reversed());
        int count = 0;
        int sWidth = clientInstance.getWindow().getScaledWidth();
        int sHeight = clientInstance.getWindow().getScaledHeight();
        for (mod m : enabled) {
            clientInstance.textRenderer.drawWithShadow(matrices, m.getName(), (sWidth - 6) - clientInstance.textRenderer.getWidth(m.getName()), 10 + count * clientInstance.textRenderer.fontHeight, -1);
            count++;
        }
    }
}
