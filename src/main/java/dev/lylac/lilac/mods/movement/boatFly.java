package dev.lylac.lilac.mods.movement;

import dev.lylac.lilac.mods.mod;
import dev.lylac.lilac.settings.settingNumber;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.Vec3d;
import org.lwjgl.glfw.GLFW;

public class boatFly extends mod {
    public settingNumber speed = new settingNumber("Speed", 0, 3, 0.3, 0.1);
    public boatFly() {
        super("boat fly", "jumping in boats moves upwards", Category.MOVEMENT);
        this.setKey(GLFW.GLFW_KEY_G);
        addSetting(speed);
    }
    @Override
    public void onTick() {
        assert clientInstance.player != null;
        if(clientInstance.player.getVehicle() != null) {
            Entity vehicle = clientInstance.player.getVehicle();
            Vec3d velocity = vehicle.getVelocity();
            double motionY;
            if(clientInstance.options.jumpKey.isPressed() && speed.getValueFloat() != 0) {
                motionY = speed.getValueFloat();
            } else if(clientInstance.options.sprintKey.isPressed() && speed.getValueFloat() != 0) {
                motionY = -speed.getValueFloat();
            } else { // boats seem to fall 0.04 bpt
                motionY = 0.04;
            }
            vehicle.setVelocity(new Vec3d(velocity.x, motionY, velocity.z));
        }
        super.onTick();
    }
}
