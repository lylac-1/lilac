package dev.lylac.lilac.mixins;

import dev.lylac.lilac.gui.hud;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.client.gui.hud.InGameHud;

@Mixin(InGameHud.class)
public class hudMixin {
    @Inject(method = "render", at = @At("RETURN"), cancellable = true)
    public void renderHud(MatrixStack matrices, float tickDelta, CallbackInfo ci) {
        hud.render(matrices, tickDelta);
    }
}
