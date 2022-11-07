package dev.lylac.lilac.settings;

public class settingNumber extends setting {
    // values
    private final double min, max, increment;
    private double value;
    // constructor
    public settingNumber(String name, double min, double max, double defaultValue, double increment) {
        super(name);
        this.min = min;
        this.max = max;
        this.value = defaultValue;
        this.increment = increment;
    }
    // local use only functions
    public static double clamp(double value, double min, double max) {
        value = Math.max(min, value);
        value = Math.min(max, value);
        return value;
    }
    // setters
    public void setValue(double value) {
        value = clamp(value, this.min, this.max);
        value = Math.round(value * (1.0 / this.increment)) / (1.0 / this.increment);
        this.value = value;
    }
    public void increment(boolean positive) {
        if (positive) setValue(getValue() + getIncrement());
        else setValue(getValue() - getIncrement());
    }
    // getters
    public double getValue() {return value;}
    public float getValueFloat() {return (float)value;}
    public int getValueInt() {return (int)value;}
    public double getMin() {
        return min;
    }
    public double getMax() {
        return max;
    }
    public double getIncrement() {return increment;}
}
