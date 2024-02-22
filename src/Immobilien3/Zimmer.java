package Immobilien3;

import java.util.ArrayList;

public class Zimmer {
	private int schlafzimmer;
	private int wohnzimmer;
	private int bad;
	private int küche;

	public Zimmer(int schlafzimmer, int wohnzimmer, int bad, int küche) {
		super();
		this.schlafzimmer = schlafzimmer;
		this.wohnzimmer = wohnzimmer;
		this.bad = bad;
		this.küche = küche;
	}

	public static void main(String[] args) {
		Zimmer w1 = new Zimmer(12, 0, 8, 10);
		Zimmer w2 = new Zimmer(20, 30, 10, 10);
		Zimmer w3 = new Zimmer(80, 60, 10, 10);

		ArrayList<Zimmer> zimmer = new ArrayList<Zimmer>();
		zimmer.add(w1);
		zimmer.add(w2);
		zimmer.add(w3);
		// print alle wohnungen
		for (int i = 0; i < zimmer.size(); i++) {
			zimmer.get(i).printWohnung();
			System.out.println();
		}

	}

	private void printWohnung() {
		System.out.println("Schlafzimmer:\t\t" + this.getSchlafzimmer());
		System.out.println("Zimmer:\t\t" + this.getWohnzimmer());
		System.out.println("Wohnzimmer:\t\t" + this.getBad());
		System.out.println("Küche:\t\t" + this.getKüche());
		System.out.println("Quadratmeter:\t\t" + this.getQuadratMeter());
	}

	public int getSchlafzimmer() {
		return schlafzimmer;
	}

	public void setSchlafzimmer(int schlafzimmer) {
		this.schlafzimmer = schlafzimmer;
	}

	public int getWohnzimmer() {
		return wohnzimmer;
	}

	public void setWohnzimmer(int wohnzimmer) {
		this.wohnzimmer = wohnzimmer;
	}

	public int getBad() {
		return bad;
	}

	public void setBad(int bad) {
		this.bad = bad;
	}

	public int getKüche() {
		return küche;
	}

	public void setKüche(int küche) {
		this.küche = küche;
	}

//	Der Quadratmeter berechnet sich aus der Summe die Zimmer
	public int getQuadratMeter() {
		return this.getSchlafzimmer() + this.getWohnzimmer() + this.getBad() + this.getKüche();
	}

}
