package dev.lylac.lilac.gui.screens.clickGUI;

import dev.lylac.lilac.mods.mod.Category;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.text.Text;
import java.util.ArrayList;
import java.util.List;

public class clickGUI extends Screen{
    // values
    public static final clickGUI INSTANCE = new clickGUI();
    private final List<frame> frames;
    // constructor
    private clickGUI() {
        super(Text.literal("Click GUI"));
        frames = new ArrayList<>();
        int offset = 20;
        for (Category c : Category.values()) {
            frames.add(new frame(c, offset, 20, 100, 20));
            offset += 120;
        }
    }
    // top level methods pass through
    @Override
    public void render(MatrixStack matrices, int mouseX, int mouseY, float delta) {
        for (frame frame : frames) {
            frame.render(matrices, mouseX, mouseY, delta);
            frame.updatePosition(mouseX, mouseY);
        }
        super.render(matrices, mouseX, mouseY, delta);
    }
    @Override
    public boolean mouseClicked(double mouseX, double mouseY, int button) {
        for (frame frame : frames) {
            frame.mouseClicked(mouseX, mouseY, button);
        }
        return super.mouseClicked(mouseX, mouseY, button);
    }
    @Override
    public boolean mouseReleased(double mouseX, double mouseY, int button) {
        for (frame frame : frames) {
            frame.mouseReleased(mouseX, mouseY, button);
        }
        return super.mouseReleased(mouseX, mouseY, button);
    }
    @Override
    public boolean shouldPause() {
        return false;
    } // prevents attempts to pause the game on custom menu
}
