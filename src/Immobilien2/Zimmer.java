package Immobilien2;

public class Zimmer {
	int quadratMeter;
	String typ;

	public Zimmer(int quadratMeter, String typ) {
		super();
		this.quadratMeter = quadratMeter;
		this.typ = typ;
	}

	public int getQuadratMeter() {
		return quadratMeter;
	}

	public void setQuadratMeter(int quadratMeter) {
		this.quadratMeter = quadratMeter;
	}

	public String getTyp() {
		return typ;
	}

	public void setTyp(String typ) {
		this.typ = typ;
	}

	public void printzimmmer() {
		System.out.println(this.getTyp() + " " + this.quadratMeter + " qm");
	}
}