package dev.lylac.lilac.mods;

import dev.lylac.lilac.settings.setting;
import net.minecraft.client.MinecraftClient;

import java.util.ArrayList;
import java.util.List;

public class mod {
    // values
    private final String name;
    private final String description;
    private final Category category;
    private int key;
    private boolean enabled;
    protected final MinecraftClient clientInstance = MinecraftClient.getInstance();
    private final List<setting> settings = new ArrayList<>();
    public enum Category {
        MOVEMENT("Movement"),
        RENDER("Render");
        public final String name;
        Category(String name) {
            this.name = name;
        }
    }
    // constructor
    public mod(String name, String description, Category category) {
        this.name = name;
        this.description = description;
        this.category = category;
    }

    // template functions
    public void onTick() {}
    public void onEnable() {}
    public void onDisable() {}
    
    // setters / updaters
    public void addSetting(setting setting) {
        settings.add(setting);
    }
    public void addSettings(setting... settings) {
        for (setting setting : settings) {
            addSetting(setting);
        }
    }
    public void setKey(int key) {this.key = key;}

    public void toggle() {
        this.enabled = !this.enabled;
        if(enabled) onEnable(); else onDisable();
    }
    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
        if(enabled) onEnable(); else onDisable();
    }

    // getters
    public String getName() {return this.name;}
    public String getDescription() {return this.description;}
    public Category getCategory() {return this.category;}
    public int getKey() {return this.key;}
    public boolean isEnabled() {return enabled;}
    public List<setting> getSettings() {return settings;}
    
    
}
