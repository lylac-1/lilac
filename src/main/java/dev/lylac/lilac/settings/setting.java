package dev.lylac.lilac.settings;

public class setting {
    // values
    private final String name;
    private boolean visible = true;
    // constructor
    public setting(String name) {
        this.name = name;
    }
    // setters
    public void setVisible(boolean visible) {this.visible = visible;}
    // getters
    public boolean isVisible() {return visible;}
    public String getName() {return name;}
}
