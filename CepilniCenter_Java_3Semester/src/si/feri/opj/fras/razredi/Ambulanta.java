package si.feri.opj.fras.razredi;

import java.io.Serializable;
import java.text.Collator;
import java.time.LocalDate;
//import java.time.temporal.ChronoUnit;
import java.util.Locale;

import si.feri.opj.fras.exceptioni.CepivoNeuporabnoException;


public class Ambulanta extends Ustanova implements ILogistika,Serializable{

	private String telefon;
	

	/**
	 * Osnovni konstruktor
	 */
	
	
	public Ambulanta()		
	{
		super();
	}
	
	/**
	 * 
	 * @param naziv Naziv ambulante
	 * @param kraj Objekt razreda Kraj
	 */
	
	private Ambulanta(String naziv,Kraj kraj)
	
	{
		super(naziv,kraj);
	
	}
	 
	/**
	 * 
	 * @param naziv Naziv ambulante
	 * @param kraj Objekt razreda Kraj
	 * @param telefon Telefonska stevilka tipa String
	 */
	
	public Ambulanta(String naziv,Kraj kraj,String telefon)
	{
		this(naziv,kraj);
		this.telefon=telefon;
	}
	
	
	@Override
	public boolean prevzamiCepiva(PrevoznoSredstvo prevoznoSredstvo) throws CepivoNeuporabnoException {			//Tu še nekaj
		
		for(int i=0;i<prevoznoSredstvo.getCepiva().size();i++)
		{	
			if(((prevoznoSredstvo.getCepiva().get(i)).getRokUporabe())!=null)
				cepivoUporabno(prevoznoSredstvo.getCepiva().get(i));
		}
					
		
		
		prevoznoSredstvo.raztovoriCepiva();
		return true;
	}

	
	/**
	 * 
	 * @param cepivo Objekt razreda Cepivo
	 * @return Vrne true ce je cepivo se uporabno en teden, sicer vrne false
	 */
	
	public boolean cepivoUporabno(Cepivo cepivo) throws CepivoNeuporabnoException
	{
		LocalDate danes = LocalDate.now();
		LocalDate rokUporabe=cepivo.getRokUporabe();
		//long razlika = ChronoUnit.DAYS.between(rokUporabe, danes.plusDays(7));
		
		if(rokUporabe.isAfter(danes.plusDays(6))==true)
			//System.out.println(naslednjiTeden.plusDays(1));
			
			return true;
		
		else 
			
			throw new CepivoNeuporabnoException();
			//return false;
		
	}
	

	/**
	 * 
	 * @return Vrne String telefonske stevilke
	 */
	
	public String getTelefon() {
		return telefon;
	}

	/**
	 * Nastavi vrednost telefon
	 * @param telefon String telefonske stevilke
	 */
	
	public void setTelefon(String telefon) {
		this.telefon = telefon;
	}

	@Override
	public String toString() {
		return "Ambulanta [telefon=" + telefon + ", naziv=" + naziv + ", kraj=" + kraj + "]";
	}
/*
	@Override
	public int compareTo(Ambulanta o) {
		
		return Collator.getInstance(Locale.getDefault()).compare(naziv, o.naziv);
		
	}
*/

	@Override
	public int compareTo(Ustanova o) {
		// TODO Auto-generated method stub
		return Collator.getInstance(Locale.getDefault()).compare(naziv, o.naziv);
	}
	
	
	
	
	
	
	
}
