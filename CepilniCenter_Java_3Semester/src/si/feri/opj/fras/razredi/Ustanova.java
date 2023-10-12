package si.feri.opj.fras.razredi;

import java.io.Serializable;
import java.util.Arrays;

public abstract class Ustanova implements Serializable,Comparable<Ustanova>{

	protected String naziv;
	protected Kraj kraj;
	
	public Ustanova() {
		
	}
		
	public Ustanova(String naziv,Kraj kraj)
	
	{
		this.naziv=naziv;
		this.kraj=kraj;
	
	}

	
	public String getNaziv() {
		return naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	public Kraj getKraj() {
		return kraj;
	}

	public void setKraj(Kraj kraj) {
		this.kraj = kraj;
	}

	@Override
	public String toString() {
		return "Ustanova [naziv=" + naziv + ", kraj=" + kraj + "]";
	}
/*
	@Override
	public int compareTo(Ustanova o) {
		return super.toString() + " [email=" + email + "cepiva=" + Arrays.toString(cepiva) + "]";
		return 0;
	}
*/
	
	
	
}
