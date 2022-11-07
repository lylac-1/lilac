package dev.lylac.lilac.gui.screens.clickGUI.setting;

import dev.lylac.lilac.gui.screens.clickGUI.modButton;
import dev.lylac.lilac.settings.setting;
import dev.lylac.lilac.settings.settingNumber;
import net.minecraft.client.util.math.MatrixStack;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class slider extends component {
    public settingNumber numSet = (settingNumber)s;
    public slider(setting s, modButton p, int offset) {
        super(s, p, offset);
        this.numSet = (settingNumber)s;
    }

    @Override
    public void render(MatrixStack matrices, int mouseX, int mouseY, float delta) {
        super.render(matrices, mouseX, mouseY, delta);
    }

    @Override
    public void mouseClicked(double mouseX, double mouseY, int button) {
        super.mouseClicked(mouseX, mouseY, button);
    }

    @Override
    public void mouseReleased(double mouseX, double mouseY, int button) {
        super.mouseReleased(mouseX, mouseY, button);
    }

    private double roundToPlace(double value, int place) {
        if (place < 0 ) {
            return value;
        }
        BigDecimal bd = new BigDecimal(value);
        bd = bd.setScale(place, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }
}
