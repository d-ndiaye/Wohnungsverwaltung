package Immobilien;

public class Wohnung {
	private String name;
	private int zimmer;
	private int quadratmeter;
	private String stadt;
	private boolean balkon;
	private int kaltmeter;
	private int nebenkosten;
	private int baujahr;

	public Wohnung(String name, int zimmer, int quadratmeter, String stadt, boolean balkon, int kaltmeter,
			int nebenkostet, int baujahr) {
		super();
		this.name = name;
		this.zimmer = zimmer;
		this.quadratmeter = quadratmeter;
		this.stadt = stadt;
		this.balkon = balkon;
		this.kaltmeter = kaltmeter;
		this.nebenkosten = nebenkostet;
		this.baujahr = baujahr;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getZimmer() {
		return zimmer;
	}

	public void setZimmer(int zimmer) {
		this.zimmer = zimmer;
	}

	public int getQuadratmeter() {
		return quadratmeter;
	}

	public void setQuadratmeter(int quadratmeter) {
		this.quadratmeter = quadratmeter;
	}

	public String getStadt() {
		return stadt;
	}

	public void setStadt(String stadt) {
		this.stadt = stadt;
	}

	public boolean isBalkon() {
		return balkon;
	}

	public void setBalkon(boolean balkon) {
		this.balkon = balkon;
	}

	public int getKaltmeter() {
		return kaltmeter;
	}

	public void setKaltmeter(int kaltmeter) {
		this.kaltmeter = kaltmeter;
	}

	public int getNebenkosten() {
		return nebenkosten;
	}

	public void setNebenkostet(int nebenkostet) {
		this.nebenkosten = nebenkostet;
	}

	public int getBaujahr() {
		return baujahr;
	}

	public void setBaujahr(int baujahr) {
		this.baujahr = baujahr;
	}

	public int getGesamtMiete() {
		int gesamtMiete = getKaltmeter() + getNebenkosten();
		return gesamtMiete;
	}

	public double getKaltmieteProQuadratmeter() {
		double kaltmieteProQuadratmeter = (double) (getKaltmeter() / (double) getQuadratmeter());
		return (double) kaltmieteProQuadratmeter;
	}

	public int getNebenkostenProQuadratmeter() {
		int nebenkostenProQuadratmeter = getNebenkosten() / getQuadratmeter();
		return nebenkostenProQuadratmeter;
	}

	public int getMieteProQuadratmeter() {
		int nebenkostenProQuadratmeter = getGesamtMiete() / getQuadratmeter();
		return nebenkostenProQuadratmeter;
	}

	public String getprintWohnung() {
		String text = "";
		text += "Name: " + getName();
		text += "\nZimmer: " + getZimmer();
		text += "\nQuadratmeter: " + getQuadratmeter();
		text += "\nStadt: " + getStadt();
		text += "\nBalkon: " + isBalkon();
		text += "\nKaltmiete: " + getZimmer();
		text += "\nNebenkosten: " + getStadt();
		text += "\nBaujahr: " + getBaujahr();
		text += "\nAlter: " + getAlter();
		text += "\n";
		return text;
	}

	public boolean findAlteWohnung(Wohnung wohnung) {
		return wohnung.getBaujahr() < this.getBaujahr();
	}

	public boolean findKleinsteWohnung(Wohnung wohnung) {
		return wohnung.getQuadratmeter() > this.getQuadratmeter();
	}

//	public boolean findeWohnungenOhneBalkon(Wohnung wohnung) {
//		balkon = false;
//		return balkon;
//	}
	public boolean findeWohnungenMitBalkon(Wohnung wohnung) {
		balkon = false;
		return balkon;
	}
	
	public int getAlter() {
		int alter  = 2021 - getBaujahr();
		return alter;
	}
	public boolean getWohnungenVorJahr(Wohnung wohnung) {
		int jahr = 2000;
		boolean vorjahr2000 =  getBaujahr() < jahr;
		return vorjahr2000;
	}
}
