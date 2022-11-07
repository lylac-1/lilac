package dev.lylac.lilac.gui.screens.clickGUI.setting;

import dev.lylac.lilac.gui.screens.clickGUI.modButton;
import dev.lylac.lilac.settings.setting;
import dev.lylac.lilac.settings.settingMode;
import net.minecraft.client.gui.DrawableHelper;
import net.minecraft.client.util.math.MatrixStack;
import java.awt.*;

public class modeBox extends component {
    // values
    private final settingMode modeSet;
    // constructor
    public modeBox(setting setting, modButton parent, int offset) {
        super(setting, parent, offset);
        this.modeSet = (settingMode)setting;
    }
    // function specifics
    @Override
    public void render(MatrixStack matrices, int mouseX, int mouseY, float delta) {
        DrawableHelper.fill(matrices, parent.parent.x, parent.parent.y + parent.offset + offset, parent.parent.x  + parent.parent.width, parent.parent.y + parent.offset + offset + parent.parent.height, new Color(0, 0, 0, 160).getRGB());

        float offsetY = ((float) parent.parent.height / 2) - ((float)clientInstance.textRenderer.fontHeight / 2);
        String name = modeSet.getName() + ": " + modeSet.getMode();
        float offsetX = ((float) parent.parent.width / 2) - ((float)clientInstance.textRenderer.getWidth(name) / 2);

        clientInstance.textRenderer.drawWithShadow(matrices, name, parent.parent.x + offsetX, parent.parent.y + offsetY + parent.offset + offsetX, -1);
        super.render(matrices, mouseX, mouseY, delta);
    }
    @Override
    public void mouseClicked(double mouseX, double mouseY, int button) {
        if(isHovered(mouseX, mouseY) && button == 0) modeSet.cycle();
        super.mouseClicked(mouseX, mouseY, button);
    }
}
