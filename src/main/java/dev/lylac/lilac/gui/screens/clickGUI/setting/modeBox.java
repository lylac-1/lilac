package dev.lylac.lilac.gui.screens.clickGUI.setting;

import dev.lylac.lilac.gui.screens.clickGUI.modButton;
import dev.lylac.lilac.settings.setting;
import dev.lylac.lilac.settings.settingMode;
import net.minecraft.client.gui.DrawableHelper;
import net.minecraft.client.util.math.MatrixStack;

import java.awt.*;

public class modeBox extends component {
    private settingMode modeSet = (settingMode)s;
    public modeBox(setting s, modButton p, int offset) {
        super(s, p, offset);
        this.modeSet = (settingMode)s;
    }

    @Override
    public void render(MatrixStack matrices, int mouseX, int mouseY, float delta) {
        DrawableHelper.fill(matrices, p.parent.x, p.parent.y + p.offset + offset, p.parent.x  + p.parent.width, p.parent.y + p.offset + offset + p.parent.height, new Color(0, 0, 0, 160).getRGB());

        float offsetY = ((float)p.parent.height / 2) - ((float)clientInstance.textRenderer.fontHeight / 2);
        String name = modeSet.getName() + ": " + modeSet.getMode();
        float offsetX = ((float)p.parent.width / 2) - ((float)clientInstance.textRenderer.getWidth(name) / 2);

        clientInstance.textRenderer.drawWithShadow(matrices, name, p.parent.x + offsetX, p.parent.y + offsetY + p.offset + offsetX, -1);
        super.render(matrices, mouseX, mouseY, delta);
    }

    @Override
    public void mouseClicked(double mouseX, double mouseY, int button) {
        if(isHovered(mouseX, mouseY) && button == 0) modeSet.cycle();
        super.mouseClicked(mouseX, mouseY, button);
    }
}
