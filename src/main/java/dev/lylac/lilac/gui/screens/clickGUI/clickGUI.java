package dev.lylac.lilac.gui.screens.clickGUI;


import dev.lylac.lilac.mods.mod.Category;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.text.Text;

import java.util.ArrayList;
import java.util.List;

public class clickGUI extends Screen{

    public static final clickGUI INSTANCE = new clickGUI();
    private List<frame> frames;
    private clickGUI() {
        super(Text.literal("Click GUI"));

        frames = new ArrayList<>();
        int offset = 20;
        for (Category c : Category.values()) {
            frames.add(new frame(c, offset, 20, 100, 20));
            offset += 120;
        }
    }

    @Override
    public void render(MatrixStack matrices, int mouseX, int mouseY, float delta) {
        for (frame f : frames) {
            f.render(matrices, mouseX, mouseY, delta);
            f.updatePosition(mouseX, mouseY);
        }
        super.render(matrices, mouseX, mouseY, delta);
    }
    @Override
    public boolean mouseClicked(double mouseX, double mouseY, int button) {
        for (frame f : frames) {
            f.mouseClicked(mouseX, mouseY, button);
        }
        return super.mouseClicked(mouseX, mouseY, button);
    }

    @Override
    public boolean mouseReleased(double mouseX, double mouseY, int button) {
        for (frame f : frames) {
            f.mouseReleased(mouseX, mouseY, button);
        }
        return super.mouseReleased(mouseX, mouseY, button);
    }
    @Override
    public boolean shouldPause() {
        return false;
    }
}
