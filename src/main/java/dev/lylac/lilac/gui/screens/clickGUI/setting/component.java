package dev.lylac.lilac.gui.screens.clickGUI.setting;

import dev.lylac.lilac.gui.screens.clickGUI.modButton;
import dev.lylac.lilac.settings.setting;
import net.minecraft.client.util.math.MatrixStack;

public class component {
    public setting s;
    public modButton p;
    public int offset;

    public component(setting s, modButton p, int offset) {
        this.s = s;
        this.p = p;
        this.offset = offset;
    }
    public void render(MatrixStack matrices, int mouseX, int mouseY, float delta) {

    }
    public void mouseClicked(double mouseX, double mouseY, int button) {

    }
    public void mouseReleased(double mouseX, double mouseY, int button) {

    }

    public boolean isHovered(double mouseX, double mouseY) {
        return mouseX > p.parent.x && mouseX < p.parent.x + p.parent.width && mouseY > p.parent.y + p.offset + offset && mouseY < p.parent.y + p.offset + offset + p.parent.height;
    }
}
