package it.polito.tdp.bar;

public class Statistiche {
	private int numTotClienti ;
	private int numClientiIns ;
	private int numClientiSod ;
	
	public Statistiche(int numTotClienti, int numClientiIns, int numClientiSod) {
		super();
		this.numTotClienti = numTotClienti;
		this.numClientiIns = numClientiIns;
		this.numClientiSod = numClientiSod;
	}

	public int getNumTotClienti() {
		return numTotClienti;
	}

	public void setNumTotClienti(int numTotClienti) {
		this.numTotClienti = numTotClienti;
	}

	public int getNumClientiIns() {
		return numClientiIns;
	}

	public void setNumClientiIns(int numClientiIns) {
		this.numClientiIns = numClientiIns;
	}

	public int getNumClientiSod() {
		return numClientiSod;
	}

	public void setNumClientiSod(int numClientiSod) {
		this.numClientiSod = numClientiSod;
	}
	
	

}
