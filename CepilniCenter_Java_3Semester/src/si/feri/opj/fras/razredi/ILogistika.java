package si.feri.opj.fras.razredi;

import si.feri.opj.fras.exceptioni.CepivoNeuporabnoException;
import si.feri.opj.fras.exceptioni.KapacitetaPresezenaException;
import si.feri.opj.fras.exceptioni.TipCepivaException;

public interface ILogistika {

	public boolean prevzamiCepiva(PrevoznoSredstvo prevoznoSredstvo) throws KapacitetaPresezenaException,TipCepivaException,CepivoNeuporabnoException;
	
}
