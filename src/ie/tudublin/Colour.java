package ie.tudublin;

import processing.data.TableRow;

public class Colour {
    int r, g, b, value;

    public Colour (int r, int g, int b, int value) {
        this.r = r;
        this.g = g;
        this.b = b;
        this.value = value;
    }

    public Colour (TableRow tr) {
        this(tr.getInt("r"), tr.getInt("g"), tr.getInt("b"), tr.getInt("value"));
    }

    public String toString() {
        return this.r + ", " + this.g + ", " + this.b + ", " + this.value;
    }
}
