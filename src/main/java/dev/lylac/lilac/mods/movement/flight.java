package dev.lylac.lilac.mods.movement;

import dev.lylac.lilac.mods.mod;
import dev.lylac.lilac.settings.settingNumber;

public class flight extends mod {
    public settingNumber speed = new settingNumber("Speed", 0, 10, 1, 0.1);
    public flight() {
        super("Flight", "enables vanilla fly mode", Category.MOVEMENT);
        addSetting(speed);
    }
    @Override
    public void onTick() {
        assert clientInstance.player != null;
        clientInstance.player.getAbilities().flying = true;
        clientInstance.player.getAbilities().setFlySpeed(speed.getValueFloat());
        super.onTick();
    }
    @Override
    public void onDisable() {
        assert clientInstance.player != null;
        clientInstance.player.getAbilities().flying = false;
        super.onDisable();
    }
}
