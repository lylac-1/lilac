package dev.lylac.lilac.mods;

import net.minecraft.client.MinecraftClient;

public class mod {
    private String name;
    private String description;
    private Category category;
    private int key;
    private boolean enabled;

    public enum Category {
        MOVEMENT,
        RENDER
    }

    protected MinecraftClient clientInstance = MinecraftClient.getInstance();

    public mod(String name, String description, Category category) {
        this.name = name;
        this.description = description;
        this.category = category;
        this.key = 0;
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
