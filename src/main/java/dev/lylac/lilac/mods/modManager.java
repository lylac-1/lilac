package dev.lylac.lilac.mods;

import dev.lylac.lilac.mods.movement.*;

import java.util.ArrayList;
import java.util.List;

public class modManager {
    public static final modManager INSTANCE = new modManager();

    private List<mod> mods = new ArrayList<>();


    public void addMods() {
        mods.add(new boatFly());
        mods.add(new sprint());
        System.out.println("mods added");
    }

    public modManager() {
        System.out.println("modManager made");
        addMods();
    }

    public List<mod> getMods() {
        return mods;
    }
    public List<mod> getEnabledMods() {
        List<mod> enabled = new ArrayList<>();
        for(mod m : mods) {
           if(m.isEnabled()) enabled.add(m);
        }
        return enabled;
    }
}
