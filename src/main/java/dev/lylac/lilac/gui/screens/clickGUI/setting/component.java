package dev.lylac.lilac.gui.screens.clickGUI.setting;

import dev.lylac.lilac.gui.screens.clickGUI.modButton;
import dev.lylac.lilac.settings.setting;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.util.math.MatrixStack;

public class component {
    // values
    public setting setting;
    public modButton parent;
    public int offset;
    protected MinecraftClient clientInstance = MinecraftClient.getInstance();
    // constructor
    public component(setting setting, modButton parent, int offset) {
        this.setting = setting;
        this.parent = parent;
        this.offset = offset;
    }
    // template functions
    public void render(MatrixStack matrices, int mouseX, int mouseY, float delta) {}
    public void mouseClicked(double mouseX, double mouseY, int button) {}
    public void mouseReleased(double mouseX, double mouseY, int button) {}
    public boolean isHovered(double mouseX, double mouseY) {
        return mouseX > parent.parent.x && mouseX < parent.parent.x + parent.parent.width && mouseY > parent.parent.y + parent.offset + offset && mouseY < parent.parent.y + parent.offset + offset + parent.parent.height;
    }
}
