package ie.tudublin;

import processing.core.PApplet;

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
        int ones = resistance - ((hundreds * 100) + (tens * 10));
        h = ui.findColour(hundreds);
        t = ui.findColour(tens);
        o = ui.findColour(ones);
    }

    public void render(float x, float y) {
        ui.pushMatrix();
        ui.translate(x, y);
        ui.stroke(255);
        ui.line(-100, 0, -50, 0);
        ui.line(-50, 0, -50, -50);
        ui.line(-50, -50, 50, -50);
        
        ui.line(50, -50, 50, 0);
        ui.line(50, 0, 100, 0);
        ui.line(50, 0, 50, 50);
        ui.line(50, 50, -50, 50);
        ui.line(-50, 50, -50, 0);

        // Draw the color bars
        ui.noStroke();
        ui.fill(h.r, h.g, h.b);
        ui.rect(-40, -49, 10, 99);
        
        ui.fill(t.r, t.g, t.b);
        ui.rect(-20, -49, 10, 99);
        
        ui.fill(o.r, o.g, o.b);
        ui.rect(0, -49, 10, 99);
        ui.fill(255);
        ui.textAlign(PApplet.CENTER, PApplet.CENTER);
        ui.textSize(30);
        ui.text(resistance, 200, 0);
        ui.popMatrix();
    }
}