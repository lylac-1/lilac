package dev.lylac.lilac.gui.screens.clickGUI.setting;

import dev.lylac.lilac.gui.screens.clickGUI.modButton;
import dev.lylac.lilac.settings.setting;
import dev.lylac.lilac.settings.settingBoolean;
import net.minecraft.client.gui.DrawableHelper;
import net.minecraft.client.util.math.MatrixStack;

import java.awt.*;

public class checkBox extends component {

    private settingBoolean boolset = (settingBoolean)s;

    public checkBox(setting s, modButton p, int offset) {
        super(s, p, offset);
        this.boolset = (settingBoolean)s;
    }
    @Override
    public void render(MatrixStack matrices, int mouseX, int mouseY, float delta) {
        DrawableHelper.fill(matrices, p.parent.x, p.parent.y + p.offset + offset, p.parent.x  + p.parent.width, p.parent.y + p.offset + offset + p.parent.height, new Color(0, 0, 0, 160).getRGB());

        super.render(matrices, mouseX, mouseY, delta);
    }
    @Override
    public void mouseClicked(double mouseX, double mouseY, int button) {
        super.mouseClicked(mouseX, mouseY, button);
    }
}
