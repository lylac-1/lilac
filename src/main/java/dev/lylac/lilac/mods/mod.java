package dev.lylac.lilac.mods;

import dev.lylac.lilac.settings.setting;
import net.minecraft.client.MinecraftClient;

import java.util.ArrayList;
import java.util.List;

public class mod {
    private String name;
    private String description;
    private Category category;
    private int key;
    private boolean enabled;

    private List<setting> settings = new ArrayList<>();

    public enum Category {
        MOVEMENT("Movement"),
        RENDER("Render");
        public String name;
        Category(String name) {
            this.name = name;
        }
    }

    protected MinecraftClient clientInstance = MinecraftClient.getInstance();

    public mod(String name, String description, Category category) {
        this.name = name;
        this.description = description;
        this.category = category;
    }

    public List<setting> getSettings() {
        return settings;
    }
    public void addSetting(setting s) {
        settings.add(s);
    }
    public void addSettings(setting... sc) {
        for (setting s : sc) addSetting(s);
    }
    
    // template functions, no need to do anything by default
    public void onTick() {}
    public void onEnable() {}
    public void onDisable() {}
    
    // setters
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
    
    
    
}
