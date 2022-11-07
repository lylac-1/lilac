package dev.lylac.lilac.mods.movement;

import dev.lylac.lilac.mods.mod;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.Vec3d;
import org.lwjgl.glfw.GLFW;

public class boatFly extends mod {
    public boatFly() {
        super("boat fly", "jumping in boats moves upwards", Category.MOVEMENT);
        this.setKey(GLFW.GLFW_KEY_G);
    }
    @Override
    public void onTick() {
        if(clientInstance.player.hasVehicle()) {
            Entity vehicle = clientInstance.player.getVehicle();
            Vec3d velocity = vehicle.getVelocity();
            double motionY = clientInstance.options.jumpKey.isPressed() ? 0.5 : 0;
            vehicle.setVelocity(new Vec3d(velocity.x, motionY, velocity.z));
        }
        super.onTick();
    }
}
