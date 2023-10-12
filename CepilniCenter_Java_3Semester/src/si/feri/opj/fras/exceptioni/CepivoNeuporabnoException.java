package si.feri.opj.fras.exceptioni;

public class CepivoNeuporabnoException extends Exception {

	public CepivoNeuporabnoException() {
		super("Cepivo ni več uporabno, rok trajanja je potekel.");
	}

	
	
}
