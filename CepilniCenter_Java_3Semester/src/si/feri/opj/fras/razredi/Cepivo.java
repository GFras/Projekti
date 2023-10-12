package si.feri.opj.fras.razredi;
import java.io.Serializable;
import java.text.Collator;
import java.time.LocalDate;
import java.util.Comparator;
import java.util.Locale;

public class Cepivo implements Comparable<Cepivo>,Serializable{

	private int serijskaStevilka;
	private LocalDate rokUporabe;
	private boolean vecOdmerkov;
	private TipCepiva tipCepiva;
	
	
	public Cepivo()
	{
		
	}
	
	public Cepivo(int serijskaStevilka,LocalDate rokUporabe)
	{
		this.serijskaStevilka=serijskaStevilka;
		this.rokUporabe=rokUporabe;
	}
	
	public int getSerijskaStevilka() {
		return serijskaStevilka;
	}
	public void setSerijskaStevilka(int serijskaStevilka) {
		this.serijskaStevilka = serijskaStevilka;
	}
	public LocalDate getRokUporabe() {
		return rokUporabe;
	}
	public void setRokUporabe(LocalDate rokUporabe) {
		this.rokUporabe = rokUporabe;
	}
	
	public void setVecOdmerkov(boolean vecOdmerkov)
	{
		this.vecOdmerkov=vecOdmerkov;
	}
	public boolean getVecOdmerkov() {
		return vecOdmerkov;
	}
	
	public TipCepiva getTipCepiva() {
		return tipCepiva;
	}

	public void setTipCepiva(TipCepiva tipCepiva) {
		this.tipCepiva = tipCepiva;
	}

	@Override
	public String toString() {
		return "Cepivo "+getSerijskaStevilka();
	}

	@Override
	public int compareTo(Cepivo o) {
		
		//return Collator.getInstance(Locale.getDefault()).compare(serijskaStevilka, o.serijskaStevilka);
		
		if(serijskaStevilka>o.serijskaStevilka)return 1;
		else return -1;
		
	}

	

	
	
	
}
