package dev.lylac.lilac.gui.screens.clickGUI;

import dev.lylac.lilac.gui.screens.clickGUI.setting.*;
import dev.lylac.lilac.mods.mod;
import dev.lylac.lilac.settings.*;
import net.minecraft.client.gui.DrawableHelper;
import net.minecraft.client.util.math.MatrixStack;
import java.util.ArrayList;
import java.util.List;
import java.awt.*;

public class modButton {
    // values
    public mod mod;
    public frame parent;
    public int offset;
    public List<component> components;
    public boolean extended;
    // constructor
    public modButton(mod mod, frame parent, int offset) {
        this.mod = mod;
        this.parent = parent;
        this.offset = offset;
        this.components = new ArrayList<>();
        this.extended = false;

        int setOffset = parent.height;
        for (setting s : mod.getSettings()) {
            if (s instanceof settingBoolean) {
                components.add(new checkBox(s, this, setOffset));
            } else if (s instanceof settingMode) {
                components.add(new modeBox(s, this, setOffset));
            } else if (s instanceof settingNumber) {
                components.add(new slider(s, this, setOffset));
            }
            setOffset += parent.height;
        }
    }
    // methods
    public void render(MatrixStack matrices, int mouseX, int mouseY, float delta) {
        DrawableHelper.fill(matrices, parent.x, parent.y + offset, parent.x  + parent.width, parent.y + offset + parent.height, new Color(0, 0, 0, 160).getRGB());
        if (isHovered(mouseX, mouseY)) {
            DrawableHelper.fill(matrices, parent.x, parent.y + offset, parent.x  + parent.width, parent.y + offset + parent.height, new Color(0, 0, 0, 160).getRGB());
        }
        String catName = parent.category.name + (parent.extended ? "  -" : "  +");
        float offsetY = ((float)parent.height / 2) - ((float)parent.clientInstance.textRenderer.fontHeight / 2);
        float offsetX = ((float)parent.width / 2) - ((float)parent.clientInstance.textRenderer.getWidth(catName) / 2);
        parent.clientInstance.textRenderer.drawWithShadow(matrices, mod.getName(), parent.x + offsetX, parent.y + offset + offsetY, mod.isEnabled() ? Color.blue.getRGB() : -1);
        if (extended) {
            for (component c : components) {
                c.render(matrices, mouseX, mouseY, delta);
            }
        }
    }
    public void mouseClicked(double mouseX, double mouseY, int button) {
        if(isHovered(mouseX, mouseY)) {
            if(button == 0) {
                mod.toggle();
            } else if (button == 1) {
                extended = !extended;
                parent.updateButtons();
            }
        }
        for (component c : components) {
            c.mouseClicked(mouseX, mouseY, button);
        }
    }
    public void mouseReleased(double mouseX, double mouseY, int button) {
        for (component c : components) {
            c.mouseReleased(mouseX, mouseY, button);
        }
    }
    public boolean isHovered(double mouseX, double mouseY) {
        return mouseX > parent.x && mouseX < parent.x + parent.width && mouseY > parent.y + offset && mouseY < parent.y + offset + parent.height;
    }
}
