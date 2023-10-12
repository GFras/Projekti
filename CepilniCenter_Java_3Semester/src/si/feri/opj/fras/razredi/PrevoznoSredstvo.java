package si.feri.opj.fras.razredi;

import java.io.Serializable;
import java.text.Collator;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Locale;

public abstract class PrevoznoSredstvo implements Serializable,Comparable<PrevoznoSredstvo> {

	protected String registrskaStevilka;
	protected String znamka;
	
	protected String naziv;
	protected ArrayList<Cepivo> cepiva;
	protected int kapaciteta;
	
	public PrevoznoSredstvo(){
	
}

	
	protected PrevoznoSredstvo(String naziv,int kapaciteta,String registrskaStevilka) throws java.lang.IllegalArgumentException{	//Dodaj več takih
		
		if(kapaciteta<=0)
		{
			throw new java.lang.IllegalArgumentException();
		}
		
		else
			
		{	
		this.naziv=naziv;
		this.kapaciteta=kapaciteta;
		this.registrskaStevilka=registrskaStevilka;
		
		}
			
		
	}

	protected void natovoriCepivo(Cepivo cepivo){
		
		this.cepiva.add(cepivo);
	}
	
	protected void natovoriCepivo(ArrayList<Cepivo> cepiva) 	
	{
		
		for(int i=0;i<cepiva.size();i++)
		{
			if(cepiva.get(i)!=null)								
				natovoriCepivo(cepiva.get(i));
		}
		
	}
	

	public void raztovoriCepiva()
	
	{
		for(int i=0;i<cepiva.size();i++)
		{
			
			cepiva.remove(i);
			
		}
	}
	
	public double vrniZasedenost()
	{
		
		return cepiva.size()/getKapaciteta();
		
	}
	
	public abstract int vrniKapaciteto();
		
	
	
	public String getRegistrskaStevilka() {
		return registrskaStevilka;
	}

	public void setRegistrskaStevilka(String registrskaStevilka) {
		this.registrskaStevilka = registrskaStevilka;
	}

	public String getZnamka() {
		return znamka;
	}

	public void setZnamka(String znamka) {
		this.znamka = znamka;
	}
	
	

	public String getNaziv() {
		return naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}
	
	public int getKapaciteta() {
		return kapaciteta;
	}

	public void setKapaciteta(int kapaciteta) {
		this.kapaciteta = kapaciteta;
	}

	

	public ArrayList<Cepivo> getCepiva() {
		return cepiva;
	}


	@Override
	public String toString() {
		return "PrevoznoSredstvo [cepiva=" + cepiva + "]";
	}


	@Override
	public int compareTo(PrevoznoSredstvo o) {
		
		return Collator.getInstance(Locale.getDefault()).compare(naziv, o.naziv);
		
	}



	

	

	
	
	
	
	
}