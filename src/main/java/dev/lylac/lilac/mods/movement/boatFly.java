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
        if(clientInstance.player.getVehicle() != null) {
            Entity vehicle = clientInstance.player.getVehicle();
            Vec3d velocity = vehicle.getVelocity();
            double motionY;
            if(clientInstance.options.jumpKey.isPressed()) {
                motionY = 0.5;
            } else if(clientInstance.options.sprintKey.isPressed()) {
                motionY = -0.5;
            } else {
                motionY = 0.04;
            }
            vehicle.setVelocity(new Vec3d(velocity.x, motionY, velocity.z));
        }
        super.onTick();
    }
}
