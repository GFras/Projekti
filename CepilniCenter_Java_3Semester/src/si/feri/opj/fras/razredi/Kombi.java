package si.feri.opj.fras.razredi;

import java.util.ArrayList;
import java.util.Arrays;

public class Kombi extends PrevoznoSredstvo {

	private boolean moznostRazsiritve;
	private TipCepiva tipCepiva;
	
	public Kombi() {
		super();
	}
	

	public Kombi(String naziv, int kapaciteta, String registerskaStevilka,boolean moznostRazsiritve) {
		super(naziv, kapaciteta,registerskaStevilka);
		this.moznostRazsiritve=moznostRazsiritve;
		this.cepiva = new ArrayList<Cepivo>(getKapaciteta());
	}
	
	//Konstruktor samo z registersko
	
	public TipCepiva getTipCepiva() {
		return tipCepiva;
	}


	public void setTipCepiva(TipCepiva tipCepiva) {
		this.tipCepiva = tipCepiva;
	}


	
	public boolean isMoznostRazsiritve() {
		return moznostRazsiritve;
	}


	@Override
	public int vrniKapaciteto() {	//Spremeni velikost polja
			
			if(moznostRazsiritve==true)return getKapaciteta()*2;
			else
				return getKapaciteta();
	}


	@Override
	public String toString() {
		return "Kombi [moznostRazsiritve=" + moznostRazsiritve + ", tipCepiva=" + tipCepiva + ", registrskaStevilka="
				+ registrskaStevilka + ", znamka=" + znamka + ", naziv=" + naziv + ", cepiva=" + cepiva
				+ ", kapaciteta=" + kapaciteta + ", vrniZasedenost()=" + vrniZasedenost() + ", getRegistrskaStevilka()="
				+ getRegistrskaStevilka() + ", getZnamka()=" + getZnamka() + ", getNaziv()=" + getNaziv()
				+ ", getKapaciteta()=" + getKapaciteta() + ", toString()=" + super.toString() + ", getClass()="
				+ getClass() + ", hashCode()=" + hashCode() + "]";
	}


	


	


	
	
	
	
	
}
