package dev.lylac.lilac.mods.movement;

import dev.lylac.lilac.mods.mod;
import dev.lylac.lilac.settings.settingBoolean;
import dev.lylac.lilac.settings.settingMode;
import dev.lylac.lilac.settings.settingNumber;

public class flight extends mod {
    public settingNumber speed = new settingNumber("Speed", 0, 100, 1, 0.0001);
    public settingBoolean testbool = new settingBoolean("Check", true);
    public settingMode testmode = new settingMode("mode", "test", "test2", "test3");
    public flight() {
        super("Flight", "enables vanilla fly mode", Category.MOVEMENT);
        addSettings(speed, testbool, testmode);;
    }

    @Override
    public void onTick() {
        clientInstance.player.getAbilities().flying = true;
        clientInstance.player.getAbilities().setFlySpeed(speed.getValueFloat());
        super.onTick();
    }

    @Override
    public void onDisable() {
        clientInstance.player.getAbilities().flying = false;
        super.onDisable();
    }
}
