package dev.lylac.lilac.gui.screens.clickGUI.setting;

import dev.lylac.lilac.gui.screens.clickGUI.modButton;
import dev.lylac.lilac.settings.setting;
import dev.lylac.lilac.settings.settingNumber;
import net.minecraft.client.gui.DrawableHelper;
import net.minecraft.client.util.math.MatrixStack;

import java.awt.*;
import java.math.BigDecimal;
import java.math.RoundingMode;

public class slider extends component {
    // values
    public settingNumber numSet;
    private boolean sliding = false;
    // constructor
    public slider(setting setting, modButton parent, int offset) {
        super(setting, parent, offset);
        this.numSet = (settingNumber)setting;
    }
    // local use only function
    private double roundToPlace(double value, int place) {
        if (place < 0 ) {
            return value;
        }
        BigDecimal bd = new BigDecimal(value);
        bd = bd.setScale(place, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }
    // function specifics
    @Override
    public void render(MatrixStack matrices, int mouseX, int mouseY, float delta) {
        DrawableHelper.fill(matrices, parent.parent.x, parent.parent.y + parent.offset + offset, parent.parent.x  + parent.parent.width, parent.parent.y + parent.offset + offset + parent.parent.height, new Color(0, 0, 0, 160).getRGB());
        double diff = Math.min(parent.parent.width, Math.max(0, mouseX - parent.parent.x));
        int renderWidth = (int) (parent.parent.width * (numSet.getValue() - numSet.getMin()) / (numSet.getMax() - numSet.getMin()));
        DrawableHelper.fill(matrices, parent.parent.x, parent.parent.y + parent.offset + offset, parent.parent.x  + renderWidth, parent.parent.y + parent.offset + offset + parent.parent.height, new Color(40, 40, 0).getRGB());
        if (sliding) {
            if (diff == 0) {
                numSet.setValue(numSet.getMin());
            } else {
                numSet.setValue(roundToPlace(((diff / parent.parent.width) * (numSet.getMax() - numSet.getMin()) + numSet.getMin()), 2));
            }
        }
        float offsetY = ((float) parent.parent.height / 2) - ((float)clientInstance.textRenderer.fontHeight / 2);
        String name = numSet.getName() + ": " + roundToPlace(numSet.getValue(), 1);
        float offsetX = ((float) parent.parent.width / 2) - ((float)clientInstance.textRenderer.getWidth(name) / 2);
        clientInstance.textRenderer.drawWithShadow(matrices, name, parent.parent.x + offsetX, parent.parent.y + offsetY + parent.offset + offsetX, -1);
        super.render(matrices, mouseX, mouseY, delta);
    }
    @Override
    public void mouseClicked(double mouseX, double mouseY, int button) {
        if (isHovered(mouseX, mouseY)) sliding = true;
        super.mouseClicked(mouseX, mouseY, button);
    }
    @Override
    public void mouseReleased(double mouseX, double mouseY, int button) {
        sliding = false;
        super.mouseReleased(mouseX, mouseY, button);
    }
}
