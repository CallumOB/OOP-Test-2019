package ie.tudublin;

public class Resistor {
    int resistance;
    UI ui;
    Colour o;
    Colour t;
    Colour h;

    public Resistor(UI ui, int resistance) {
        this.ui = ui;
        this.resistance = resistance;
        int hundreds = resistance / 100;
        int tens = (resistance - (hundreds * 100)) / 10;
        int ones = resistance - ((hundreds * 100) + (tens + 10));
        o = ui.findColour(ones);
        t = ui.findColour(tens);
        h = ui.findColour(hundreds);
    }
}
