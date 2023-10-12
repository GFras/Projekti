package si.feri.opj.fras.razredi;


import java.io.Serializable;
import java.text.Collator;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Locale;

import si.feri.opj.fras.exceptioni.KapacitetaPresezenaException;
import si.feri.opj.fras.exceptioni.TipCepivaException;

public class CepilniCenter extends Ustanova implements ILogistika,Serializable{

	private String email;
	private ArrayList<Cepivo> cepiva;
	
	/**
	 * Osnovni konstruktor
	 */
	/*
	public CepilniCenter()
	{
		super();
	}
	*/
	/**
	 * 
	 * @param naziv String imena cepilnega centra
	 */
	
	public CepilniCenter(String naziv)
	{
		super.naziv=naziv;
		cepiva=new ArrayList<Cepivo>();
	}
	
	/**
	 * Konstruktor, ki se sklicuje na zgornji konstruktor
	 * @param naziv String imena cepilnega centra
	 * @param kraj Objekt razreda Kraj
	 */
	
	public CepilniCenter(String naziv,Kraj kraj)
	{
		this(naziv);
		super.kraj=kraj;
	}
	 
	/**
	 * Konstruktor, ki se sklicuje na zgornja konstruktorja
	 * @param naziv String imena cepilnega centra
	 * @param kraj Objekt razreda Kraj
	 * @param email String vrednost emaila
	 */
	
	public CepilniCenter(String naziv,Kraj kraj,String email)	
	{
		this(naziv,kraj);
		this.email=email;
	}
	
	
	
	@Override
	public boolean prevzamiCepiva(PrevoznoSredstvo prevoznoSredstvo) throws KapacitetaPresezenaException,TipCepivaException{
		
		if((prevoznoSredstvo.vrniKapaciteto()-((prevoznoSredstvo.vrniKapaciteto()*prevoznoSredstvo.vrniZasedenost())))>=vrniSteviloCepiv())		//Gleda koliko še je prostora v polju, ne pa samo velikost polja
		{
			if(prevoznoSredstvo instanceof Kombi)
			{
				
				for(int i=0;i<cepiva.size();i++)
				prevoznoSredstvo.natovoriCepivo(cepiva.get(i));
				return true;
			}
			
			else if(prevoznoSredstvo instanceof Avto)
			{
				
				for(int i=0;i<cepiva.size();i++)
				{
					
					//System.out.println("Delam");
					
					if(((Avto) prevoznoSredstvo).getTipCepiva()!=null)				
					{
						
						if(cepiva.get(i)!=null)
							
						{
							if(((Avto) prevoznoSredstvo).getTipCepiva()!=cepiva.get(i).getTipCepiva())
							{
								throw new TipCepivaException("Tip cepiva ne ustreza za vozilo: " + prevoznoSredstvo.getNaziv());
							}
						}
						
					}
				}
				
				
				prevoznoSredstvo.natovoriCepivo(cepiva);
				
				//System.out.println(prevoznoSredstvo.toString());
				
				return true;
			}
		}
		
		//else
		//{
			throw new KapacitetaPresezenaException("Kapaciteta je presežena za vozilo: " + prevoznoSredstvo.getNaziv());
			//return false;
		//}
			
		
	}

	public Cepivo pripraviCepivo()
	{
		
		synchronized (this) {
			
			for(int i=0;i<cepiva.size();i++)
			{
				if(cepiva.get(i)!=null)
				{
					Cepivo cepivo = cepiva.get(i);
					odstraniCepivo(cepivo);
					return cepivo;
				}
			}
		}
			
		return null;
		
	}
	
	/*
	
	public synchronized Cepivo pripraviCepivo()
	{
		for(int i=0;i<cepiva.size();i++)
		{
			if(cepiva.get(i)!=null)
			{
				Cepivo cepivo = cepiva.get(i);
				odstraniCepivo(cepivo);
				return cepivo;
			}
	}
		return null;
	}
	
	*/
	
	/**
	 * Metoda, ki doda cepivo
	 * @param cepivo Objekt razreda Cepivo
	 * @return Vrne true/false glede na uspesnost dodajanja cepiva
	 */
	
	public boolean dodajCepivo(Cepivo cepivo)
	{
		
		if(cepiva.size()<=10) {
			cepiva.add(cepivo);
			return true;
		}
		
		else
			return false;
		
	}
	
	/**
	 * Metoda, ki odstrani cepivo glede na objekt
	 * @param cepivo Objekt razreda Cepivo
	 */
	
	public void odstraniCepivo(Cepivo cepivo)
	{
		
		if(cepiva.contains(cepivo))
		{
			cepiva.remove(cepivo);
		}
		
		
		
	}
	
	/**
	 * Metoda, ki vrne stevilo vseh cepiv
	 * @return Vrne int vrednost stevila vseh cepiv
	 */
	
	public int vrniSteviloCepiv()
	{
		
		int i=0;
		
		for(int a=0;a<cepiva.size();a++)
		{
			i++;
		}
		
		return i;
	}
	
	
	
	
	/**
	 * Vrne vrednost emaila
	 * @return Vrne String vrednost emaila
	 */
	
	public String getEmail() {
		return email;
	}
	
	/**
	 * Nastavi vrednost emailu
	 * @param email String vrednost emaila
	 */
	
	public void setEmail(String email) {
		this.email = email;
	}

	public ArrayList<Cepivo> getCepiva() {
		return cepiva;
	}

	public void setCepiva(ArrayList<Cepivo> cepiva) {
		this.cepiva = cepiva;
	}

	@Override
	public String toString() {
		return "CepilniCenter [email=" + email + ", cepiva=" + cepiva + ", naziv=" + naziv + ", kraj=" + kraj
				+ ", getNaziv()=" + getNaziv() + ", getKraj()=" + getKraj() + ", toString()=" + super.toString()
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + "]";
	}
/*
	@Override
	public int compareTo(CepilniCenter o) {
		
		return Collator.getInstance(Locale.getDefault()).compare(naziv, o.naziv);
		
	}
*/
	@Override
	public int compareTo(Ustanova o) {
		// TODO Auto-generated method stub
		return Collator.getInstance(Locale.getDefault()).compare(naziv, o.naziv);
	}

	

	
	
	
	

}
	  
	  
	  
