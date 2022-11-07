package dev.lylac.lilac.gui.screens.clickGUI;

import dev.lylac.lilac.gui.screens.clickGUI.setting.component;
import dev.lylac.lilac.mods.mod;
import dev.lylac.lilac.mods.mod.Category;
import dev.lylac.lilac.mods.modManager;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawableHelper;
import net.minecraft.client.util.math.MatrixStack;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class frame {
    // values
    public int x, y, width, height, dragX, dragY;
    public Category category;
    public boolean dragging;
    public boolean extended;
    private final List<modButton> buttons;
    protected MinecraftClient clientInstance = MinecraftClient.getInstance();
    // constructor
    public frame(Category category, int x, int y, int width, int height) {
        this.category = category;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.dragging = false;
        this.extended = false;
        buttons = new ArrayList<>();
        int offset = height;
        for(mod m : modManager.INSTANCE.getModsInCategory(category)) {
            buttons.add(new modButton(m, this, offset));
            offset += height;
        }
    }
    // methods
    public void render(MatrixStack matrices, int mouseX, int mouseY, float delta) {
        DrawableHelper.fill(matrices, x, y, x +width, y + height, Color.blue.getRGB());
        String catName = category.name + (extended ? "  -" : "  +");
        float offsetY = ((float)height / 2) - ((float)clientInstance.textRenderer.fontHeight / 2);
        float offsetX = ((float)width / 2) - ((float)clientInstance.textRenderer.getWidth(catName) / 2);
        clientInstance.textRenderer.drawWithShadow(matrices, catName, x + offsetX, y + offsetY, Color.white.getRGB());
        if(extended) {
            for (modButton b : buttons) {
                b.render(matrices, mouseX, mouseY, delta);
            }
        }
    }
    public void mouseClicked(double mouseX, double mouseY, int button) {
        if (isHovered(mouseX, mouseY)) {
            if(button == 0) {
                dragging = true;
                dragX = (int) mouseX - x;
                dragY = (int) mouseY - y;
            } else if (button == 1) {
                extended = !extended;
            }
        }
        if (extended) {
            for (modButton b : buttons) {
                b.mouseClicked(mouseX, mouseY, button);
            }
        }
    }
    public void mouseReleased(double mouseX, double mouseY, int button) {
        if (button == 0 && dragging) dragging = false;
        for (modButton mb : buttons) {
            mb.mouseReleased(mouseX, mouseY, button);
        }
    }
    public void updatePosition(double mouseX, double mouseY) {
        if (dragging) {
            x = (int)mouseX - dragX;
            y = (int)mouseY - dragY;
        }
    }
    public void updateButtons() {
        int offset = height;
        for (modButton button : buttons) {
            button.offset = offset;
            offset += height;
            if (button.extended) {
                for (component c : button.components) {
                    if (c.setting.isVisible()) offset += height;
                }
            }
        }
    }
    public boolean isHovered(double mouseX, double mouseY) {
        return mouseX > x && mouseX < x + width && mouseY > y && mouseY < y + height;
    }
}
