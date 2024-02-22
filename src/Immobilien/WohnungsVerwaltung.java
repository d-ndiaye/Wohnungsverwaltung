package Immobilien;

import java.util.ArrayList;

public class WohnungsVerwaltung {

	public static Wohnung findAlteWohnung(Wohnung[] wohnungen) {
		Wohnung AlteWohnung = null;
		for (int i = 0; i < wohnungen.length; i++) {
			Wohnung wohnung = wohnungen[i];
			if (AlteWohnung == null) {
				AlteWohnung = wohnung;
			} else {
				if (AlteWohnung.findAlteWohnung(wohnung)) {
					AlteWohnung = wohnung;
				}
			}
		}
		return AlteWohnung;

	}

	public static Wohnung findKleinsteWohnung(Wohnung[] wohnungen) {
		Wohnung KleinsteWohnung = null;
		for (int i = 0; i < wohnungen.length; i++) {
			Wohnung wohnung = wohnungen[i];
			if (KleinsteWohnung == null) {
				KleinsteWohnung = wohnung;
			} else {
				if (KleinsteWohnung.findAlteWohnung(wohnung)) {
					KleinsteWohnung = wohnung;
				}
			}
		}
		return KleinsteWohnung;

	}
	public static ArrayList<Wohnung> findeWohnungenMitBalkon(Wohnung[] wohnungen) {
        ArrayList<Wohnung> wohnungenMitBalkon = new ArrayList<Wohnung>();
        for (Wohnung wohnung: wohnungen) {
            if (wohnung.isBalkon()) {
                wohnungenMitBalkon.add(wohnung);
            }
        }
        return wohnungenMitBalkon;    
    }
	public static Wohnung WohnungenVorJahr(Wohnung[] wohnungen) {
		Wohnung WohnungenVorJahr = null;
		for (int i = 0; i < wohnungen.length; i++) {
			Wohnung wohnung = wohnungen[i];
			if (WohnungenVorJahr == null) {
				WohnungenVorJahr = wohnung;
			} else {
				if (WohnungenVorJahr.findAlteWohnung(wohnung)) {
					WohnungenVorJahr = wohnung;
				}
			}
		}
		return WohnungenVorJahr;

	}

//	public static Wohnung findeWohnungenOhneBalkon(Wohnung[] wohnungen) {
//		findeWohnungenOhneBalkon = false;
//				if (false) {
//				
//			}
//		
//		return findeWohnungenOhneBalkon;
//}

	public static void main(String[] args) {
		Wohnung[] wohnungListe = new Wohnung[3];
		Wohnung wohnung1 = new Wohnung("Wohnung 1", 1, 40, "Leipzig", false, 400, 100, 1920);
		Wohnung wohnung2 = new Wohnung("Wohnung 2", 4, 96, "Hamburg", true, 1440, 360, 1999);
		Wohnung wohnung3 = new Wohnung("Wohnung 3", 6, 180, "Berlin", false, 2000, 500, 2018);

		wohnungListe[0] = wohnung1;
		wohnungListe[1] = wohnung2;
		wohnungListe[2] = wohnung3;
		for (int i = 0; i < wohnungListe.length; i++) {
			System.out.println(wohnungListe[i].getprintWohnung());

		}


		/*
		 * boolean findeWohnungenOhneBalkon = false; for (int i = 0; i <
		 * wohnungListe.length; i++) { if (true) {
		 * System.out.println(wohnungListe[i].isBalkon()); } }
		 */
		System.out.println("Die älteste Wohnung ist: " + findAlteWohnung(wohnungListe).getName()
				+ ". Die Wohnung wurde  " + findAlteWohnung(wohnungListe).getBaujahr() + " erbaut.\n");

		System.out.println("Die kleinste Wohnung hat: " + findKleinsteWohnung(wohnungListe).getQuadratmeter()
				+ " Qaudratmeter und heißt " + findKleinsteWohnung(wohnungListe).getName());
//		System.out.println("d" + findeWohnungenOhneBalkon(wohnungListe).isBalkon());
//		System.out.println(findeWohnungenMitBalkon(wohnungListe);
		System.out.println(WohnungenVorJahr(wohnungListe).getBaujahr());
	}

}
