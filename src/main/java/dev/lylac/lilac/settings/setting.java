package dev.lylac.lilac.settings;

public class setting {
    private String name;
    private boolean visible = true;

    public boolean isVisible() {
        return visible;
    }
    public void setVisible(boolean visible) {
        this.visible = visible;
    }
    public String getName() {
        return name;
    }

    public setting(String name) {
        this.name = name;
    }
}
