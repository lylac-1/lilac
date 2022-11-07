package dev.lylac.lilac.gui.screens.clickGUI;

import dev.lylac.lilac.mods.mod.Category;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawableHelper;
import net.minecraft.client.util.math.MatrixStack;

import java.awt.*;

public class frame {
    public int x, y, width, height;
    public Category category;
    public boolean dragging;
    public frame(Category category, int x, int y, int width, int height) {
        this.category = category;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.dragging = false;
    }

    private MinecraftClient clientInstance = MinecraftClient.getInstance();

    public void render(MatrixStack matrices, int mouseX, int mouseY, float delta) {
        DrawableHelper.fill(matrices, x, y, x +width, y + height, -1);
        clientInstance.textRenderer.drawWithShadow(matrices, category.name, x + 2, y +2, Color.black.getRGB());
    }

    public void mouseClicked(double mouseX, double mouseY, int button) {

    }
}
