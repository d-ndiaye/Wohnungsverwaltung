package Immobilien2;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;

public class WohnungsVerwaltung2 {

	public static Wohnung2 createWohnung1() {
		Zimmer z1 = new Zimmer(8, "Küche");
		ArrayList<Zimmer> zimmer = new ArrayList<Zimmer>();
		zimmer.add(z1);
		Wohnung2 w = new Wohnung2("Wohnung 1", "Leipzig", false, 400, 100, 1920, zimmer);
		return w;
	}

	public static Wohnung2 createWohnung2() {
		ArrayList<Zimmer> zimmer = new ArrayList<Zimmer>();
		zimmer.add(new Zimmer(10, "Bad"));
		zimmer.add(new Zimmer(10, "Küche"));
		zimmer.add(new Zimmer(20, "Schlafzimmer"));
		zimmer.add(new Zimmer(10, "Schlafzimmer"));
		zimmer.add(new Zimmer(30, "Wohnzimmer"));
		Wohnung2 w = new Wohnung2("Wohnung 2", "Hamburg", true, 1440, 360, 2000, zimmer);
		return w;
	}

	public static Wohnung2 createWohnung3() {
		ArrayList<Zimmer> zimmer = new ArrayList<Zimmer>();
		zimmer.add(new Zimmer(10, "Bad"));
		zimmer.add(new Zimmer(10, "Küche"));
		zimmer.add(new Zimmer(20, "Schlafzimmer"));
		zimmer.add(new Zimmer(20, "Schlafzimmer"));
		zimmer.add(new Zimmer(40, "Schlafzimmer"));

		zimmer.add(new Zimmer(60, "Wohnzimmer"));
		Wohnung2 w = new Wohnung2("Wohnung 3", "Berlin", false, 2000, 500, 2020, zimmer);
		return w;
	}

	public static void main(String[] args) {
		Wohnung2 w1 = createWohnung1();
		Wohnung2 w2 = createWohnung2();
		Wohnung2 w3 = createWohnung3();
		ArrayList<Wohnung2> wohnungen = new ArrayList<Wohnung2>();
		wohnungen.add(w1);
		wohnungen.add(w2);
		wohnungen.add(w3);

		// print alle wohnungen
		for (int i = 0; i < wohnungen.size(); i++) {
			wohnungen.get(i).printWohnung();
			System.out.println();
		}

		// finde die größte Wohnung
		Wohnung2 groessteWohnung = findeGroessteWohnung(wohnungen);
		System.out.println("Die größte Wohnung ist " + groessteWohnung.getName() + " mit "
				+ groessteWohnung.getQuadratMeter() + " Quadratmetern.");

		ArrayList<Wohnung2> mitBalkonList = findeWohnungenMitBalkon(wohnungen);
		System.out.println("*** Wohnungen mit Balkon");
		printWohnungen(mitBalkonList);

		ArrayList<Wohnung2> wohnungenVor2000 = findeWohnungVorJahr(wohnungen, 2000);
		System.out.println("*** Wohnungen vor 2000");
		printWohnungen(wohnungenVor2000);
//		++++++++++++++++++++++++++++++++++++

		File file = new File("fichier.csv");
		if (!file.exists()) {
			try {
				file.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		try (PrintWriter print = new PrintWriter(new FileOutputStream(file))) {
			print.println("Name, Quadratmeter, Stadt, Balkon, Baujahr, Gesamtmiete");
			for (int i = 0; i < wohnungen.size(); i++) {
				String str = wohnungen.get(i).getName() + "," + wohnungen.get(i).getQuadratMeter() + ","
						+ wohnungen.get(i).getStadt() + "," + wohnungen.get(i).isBalkon() + ","
						+ wohnungen.get(i).getBaujahr() + "," + wohnungen.get(i).getGesamtMiete() + "\n";
				print.print(str);
			}

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	/**
	 * findet die größte Wohnung
	 * 
	 * @param wohnungen die liste an wohnungen
	 * @return die größte wohnung
	 */
	public static Wohnung2 findeGroessteWohnung(ArrayList<Wohnung2> wohnungen) {
		// noch keine Wohnung gefunden, daher ist die erste Wohnung die größte
		// (ergebnis)
		Wohnung2 ergebnis = wohnungen.get(0);
		for (Wohnung2 w : wohnungen) {
			// prüfe, ob die wohnung größer ist
			if (w.getQuadratMeter() > ergebnis.getQuadratMeter()) {
				ergebnis = w;
			}
		}
		return ergebnis;
	}

	/**
	 * findet alle wohnungen mit balkon
	 * 
	 * @param wohnungen
	 * @return
	 */
	public static ArrayList<Wohnung2> findeWohnungenMitBalkon(ArrayList<Wohnung2> wohnungen) {
		ArrayList<Wohnung2> wohnungenMitBalkon = new ArrayList<Wohnung2>();
		for (Wohnung2 wohnung : wohnungen) {
			// falls ein Balkon vorhanden ist, füge die wohnungen den Wohnungen mit Balkon
			// hinzu
			if (wohnung.isBalkon()) {
				wohnungenMitBalkon.add(wohnung);
			}
		}
		// sende ergebnis mit Wohnugnen mit Balkon
		return wohnungenMitBalkon;
	}

	public static ArrayList<Wohnung2> findeWohnungVorJahr(ArrayList<Wohnung2> wohnungen, int year) {
		ArrayList<Wohnung2> ergebnisse = new ArrayList<Wohnung2>();
		for (Wohnung2 w : wohnungen) {
			// prüfe ob die wohnung vor dem Jahr gebaut wurde
			if (w.getBaujahr() < year) {
				ergebnisse.add(w);
			}
		}
		return ergebnisse;
	}

	/**
	 * schreibt alle wohnung (hilfsmethode)
	 * 
	 * @param wohnungen
	 */
	public static void printWohnungen(ArrayList<Wohnung2> wohnungen) {
		for (Wohnung2 w : wohnungen) {
			w.printWohnung();
			System.out.println();
		}
	}

}
