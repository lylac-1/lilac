package dev.lylac.lilac.settings;

import java.util.Arrays;
import java.util.List;

public class settingMode extends setting {
    // values
    private String mode;
    private final List<String> modes;
    private int index;
    // constructor
    public settingMode(String name, String defaultMode, String... modes) {
        super(name);
        this.mode = defaultMode;
        this.modes = Arrays.asList(modes);
        this.index = this.modes.indexOf(defaultMode);
    }
    // setters
    public void setMode(String mode) {
        this.mode = mode;
        this.index = modes.indexOf(mode);
    }
    public void setIndex(int index) {
        this.index = index;
        this.mode = modes.get(index);
    }
    // getters
    public void cycle() {
        if (index < modes.size() - 1) {
            index++;
            mode = modes.get(index);
        } else if (index >= modes.size() - 1) {
            index = 0;
            mode = modes.get(0);
        }
    }
    public String getMode() {return mode;}
    public List<String> getModes() {return this.modes;}
    public int getIndex() {return index;}
    public boolean inMode(String mode) {return this.mode.equals(mode);}
}
