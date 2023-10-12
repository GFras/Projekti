package si.feri.opj.fras.razredi;

import java.util.ArrayList;
import java.util.Arrays;

public class Avto extends PrevoznoSredstvo{

	private TipCepiva tipCepiva;
	
	public Avto() {
		super();
	}

	public Avto(String naziv, int kapaciteta,String registrskaStevilka) {
		super(naziv, kapaciteta,registrskaStevilka);
		this.cepiva= new ArrayList<Cepivo>(getKapaciteta());
	}

	
	
	public TipCepiva getTipCepiva() {
		return tipCepiva;
	}

	public void setTipCepiva(TipCepiva tipCepiva) {
		this.tipCepiva = tipCepiva;
	}

	@Override
	public int vrniKapaciteto() {
		
		return getKapaciteta();
			
	}

	@Override
	public String toString() {
		return "Avto [tipCepiva=" + tipCepiva + ", cepiva=" + cepiva + "]";
	}

	

	

	

	
	
}
