package si.feri.opj.fras.zagonska;

import java.time.LocalDate;

//import com.sun.tools.javap.TryBlockWriter;

import si.feri.opj.fras.exceptioni.CepivoNeuporabnoException;
import si.feri.opj.fras.exceptioni.KapacitetaPresezenaException;
import si.feri.opj.fras.exceptioni.TipCepivaException;
import si.feri.opj.fras.razredi.Ambulanta;
import si.feri.opj.fras.razredi.Avto;
import si.feri.opj.fras.razredi.CepilniCenter;
import si.feri.opj.fras.razredi.Cepivo;
import si.feri.opj.fras.razredi.Kombi;
import si.feri.opj.fras.razredi.Kraj;
import si.feri.opj.fras.razredi.PrevoznoSredstvo;
import si.feri.opj.fras.razredi.TipCepiva;
import si.feri.opj.fras.razredi.Ustanova;
import si.feri.opj.fras.razredi.Zdravnik;

/**
 * 
 * @author Gregor
 * @version 2
 */


public class Zagonski {

	public static void main(String[] args) {
		
		//LocalDate rokUporabe;
		//rokUporabe = LocalDate.of(2021, 4, 11);			//Spremeni da dokažeš
		
		Cepivo cepivo1 = new Cepivo(1,null);
		Cepivo cepivo2 = new Cepivo(2,null);
		Cepivo cepivo3 = new Cepivo(3,null);
		Cepivo cepivo4 = new Cepivo(4,null);
		Cepivo cepivo5 = new Cepivo(5,null);
		Cepivo cepivo6 = new Cepivo(6,null);
		Cepivo cepivo7 = new Cepivo(7,null);
		Cepivo cepivo8 = new Cepivo(8,null);
		Cepivo cepivo9 = new Cepivo(9,null);
		Cepivo cepivo10 = new Cepivo(10,null);
		
		CepilniCenter cepilniCenter1 = new CepilniCenter("Adolf Drolc");
		cepilniCenter1.dodajCepivo(cepivo1);
		cepilniCenter1.dodajCepivo(cepivo2);
		cepilniCenter1.dodajCepivo(cepivo3);
		cepilniCenter1.dodajCepivo(cepivo4);
		cepilniCenter1.dodajCepivo(cepivo5);
		cepilniCenter1.dodajCepivo(cepivo6);
		cepilniCenter1.dodajCepivo(cepivo7);
		cepilniCenter1.dodajCepivo(cepivo8);
		cepilniCenter1.dodajCepivo(cepivo9);
		cepilniCenter1.dodajCepivo(cepivo10);
		
		
		Zdravnik zdravnik1 = new Zdravnik("Joze", "Nekaj", cepilniCenter1);
		Zdravnik zdravnik2 = new Zdravnik("Marko", "Nekaj", cepilniCenter1);
		Zdravnik zdravnik3 = new Zdravnik("Vili", "Nekaj", cepilniCenter1);
		
		Thread t1 = new Thread(zdravnik1);
		Thread t2 = new Thread(zdravnik2);
		Thread t3 = new Thread(zdravnik3);
		
		
		t1.start();
		t2.start();
		t3.start();
		
		//cepilniCenter1.dodajCepivo(cepivo1);
	
	
	
}
}
