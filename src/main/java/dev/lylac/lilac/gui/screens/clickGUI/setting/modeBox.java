package dev.lylac.lilac.gui.screens.clickGUI.setting;

import dev.lylac.lilac.gui.screens.clickGUI.modButton;
import dev.lylac.lilac.settings.setting;
import dev.lylac.lilac.settings.settingMode;
import net.minecraft.client.util.math.MatrixStack;

public class modeBox extends component {
    private settingMode modeSet = (settingMode)s;
    public modeBox(setting s, modButton p, int offset) {
        super(s, p, offset);
        this.modeSet = (settingMode)s;
    }

    @Override
    public void render(MatrixStack matrices, int mouseX, int mouseY, float delta) {
        super.render(matrices, mouseX, mouseY, delta);
    }

    @Override
    public void mouseClicked(double mouseX, double mouseY, int button) {
        super.mouseClicked(mouseX, mouseY, button);
    }
}
