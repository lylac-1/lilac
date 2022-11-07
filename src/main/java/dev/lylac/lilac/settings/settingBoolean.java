package dev.lylac.lilac.settings;

public class settingBoolean extends setting {
    // values
    private boolean enabled;
    // constructor
    public settingBoolean(String name, boolean defaultValue) {
        super(name);
        this.enabled = defaultValue;
    }
    // setters
    public void toggle() {this.enabled = !this.enabled;}
    public void setEnabled(boolean enabled) {this.enabled = enabled;}
    // getters
    public boolean isEnabled() {return enabled;}
}
