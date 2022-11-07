package dev.lylac.lilac.settings;

public class settingBoolean extends setting {
    private boolean enabled;
    public settingBoolean(String name, boolean defaultValue) {
        super(name);
        this.enabled = defaultValue;
    }
    public void toggle() {
        this.enabled = !this.enabled;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }
}
