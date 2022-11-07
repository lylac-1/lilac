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
    public settingNumber numSet = (settingNumber)s;
    private boolean sliding = false;
    public slider(setting s, modButton p, int offset) {
        super(s, p, offset);
        this.numSet = (settingNumber)s;
    }

    @Override
    public void render(MatrixStack matrices, int mouseX, int mouseY, float delta) {
        DrawableHelper.fill(matrices, p.parent.x, p.parent.y + p.offset + offset, p.parent.x  + p.parent.width, p.parent.y + p.offset + offset + p.parent.height, new Color(0, 0, 0, 160).getRGB());

        double diff = Math.min(p.parent.width, Math.max(0, mouseX - p.parent.x));
        int renderWidth = (int) (p.parent.width * (numSet.getValue() - numSet.getMin()) / (numSet.getMax() - numSet.getMin()));

        DrawableHelper.fill(matrices, p.parent.x, p.parent.y + p.offset + offset, p.parent.x  + renderWidth, p.parent.y + p.offset + offset + p.parent.height, new Color(40, 40, 0).getRGB());

        if (sliding) {
            if (diff == 0) {
                numSet.setValue(numSet.getMin());
            } else {
                numSet.setValue(roundToPlace(((diff / p.parent.width) * (numSet.getMax() - numSet.getMin()) + numSet.getMin()), 2));
            }
        }

        float offsetY = ((float)p.parent.height / 2) - ((float)clientInstance.textRenderer.fontHeight / 2);
        String name = numSet.getName() + ": " + roundToPlace(numSet.getValue(), 1);
        float offsetX = ((float)p.parent.width / 2) - ((float)clientInstance.textRenderer.getWidth(name) / 2);

        clientInstance.textRenderer.drawWithShadow(matrices, name, p.parent.x + offsetX, p.parent.y + offsetY + p.offset + offsetX, -1);

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

    private double roundToPlace(double value, int place) {
        if (place < 0 ) {
            return value;
        }
        BigDecimal bd = new BigDecimal(value);
        bd = bd.setScale(place, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }
}
