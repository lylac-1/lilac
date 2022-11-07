package dev.lylac.lilac.mods;

import dev.lylac.lilac.mods.movement.*;
import java.util.ArrayList;
import java.util.List;

public class modManager {
    // values
    public static final modManager INSTANCE = new modManager();
    private final List<mod> mods = new ArrayList<>();

    // constructor for instance
    public modManager() {
        mods.add(new boatFly());
        mods.add(new sprint());
        mods.add(new flight());
    }

    // "getters"
    public List<mod> getMods() {
        return mods;
    }
    // returns list of mods where enabled is true
    public List<mod> getEnabledMods() {
        List<mod> enabled = new ArrayList<>();
        for (mod mod : mods) {
           if (mod.isEnabled()) {
               enabled.add(mod);
           }
        }
        return enabled;
    }
    // returns list of mods where category matches input "category"
    public List<mod> getModsInCategory(mod.Category category) {
        List<mod> categoryModules = new ArrayList<>();
        for (mod mod : mods) {
            if (mod.getCategory() == category) {
                categoryModules.add(mod);
            }
        }
        return categoryModules;
    }
}
