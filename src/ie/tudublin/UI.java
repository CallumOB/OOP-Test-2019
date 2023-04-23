package ie.tudublin;

import java.util.ArrayList;

import processing.core.PApplet;
import processing.data.Table;
import processing.data.TableRow;

public class UI extends PApplet {

	ArrayList<Colour> colours = new ArrayList<Colour>();
	ArrayList<Resistor> resistors = new ArrayList<Resistor>();

	public void settings() {
		size(500, 800);

		loadColours();
		loadResistors();
		printResistors();
	}
	
	public void setup() {

	}

	public void draw() {
		background(0);
		stroke(255);

		for (int i = 0; i < resistors.size(); i++) {
			float y = map(i, 0, resistors.size(), 100, height - 100);
			resistors.get(i).render(width / 2, y);
		}
	}

	public void loadResistors() {
		Table t = loadTable("resistors.csv");
		for (TableRow tr : t.rows()) {
			resistors.add(new Resistor(this, tr.getInt(0)));
		}
	}

	public void loadColours() {
		Table t = loadTable("colours.csv", "header");
		for (TableRow tr : t.rows()) {
			colours.add(new Colour(tr));
		}
	}

	public Colour findColour(int colour) {
		for (Colour c : colours) {
			if (colour == c.value) {
				return c;
			}
		}
		return null;
	}

	public void printResistors() {
		for (Resistor res : resistors) {
			int i = res.resistance;
			int h = i / 100;
			int t = (i - (h * 100)) / 10;
			int o = i - ((h * 100) + (t + 10));
			
			System.out.println(h + ", " + t + ", " + o);
 		}
	}
}
