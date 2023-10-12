package si.feri.opj.fras.razredi;

import java.awt.desktop.ScreenSleepEvent;

import com.sun.source.tree.YieldTree;


public class Zdravnik implements Runnable{

	private String ime;
	private String priimek;
	private CepilniCenter cepilniCenter;
	
	public Zdravnik(String ime,String priimek,CepilniCenter cepilniCenter)
	{
		this.ime=ime;
		this.priimek=priimek;
		this.cepilniCenter=cepilniCenter;
	}
	
	@Override
	public void run() {
			
		
			while(cepilniCenter.vrniSteviloCepiv()!=0)
			{
				
				
				Cepivo cepivo = cepilniCenter.pripraviCepivo();
				if(cepivo==null)break;
				
				
				System.out.println("Zdravnik " + ime + " " + priimek + " je cepil s cepivom " + cepivo.getSerijskaStevilka() + " iz cepilnega centra " + cepilniCenter.getNaziv());
				
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				
				//Thread.yield();
			}		
			
	}

	
	
}
