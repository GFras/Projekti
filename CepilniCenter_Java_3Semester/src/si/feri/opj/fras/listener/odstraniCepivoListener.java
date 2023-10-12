package si.feri.opj.fras.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JList;

import si.feri.opj.fras.razredi.Cepivo;

public class odstraniCepivoListener implements ActionListener{

	private JList listCepiv;
	private ArrayList<Cepivo>cepiva;
	private DefaultListModel<Cepivo> modelCepiva;
	
	
	public odstraniCepivoListener(JList listCepiv,ArrayList<Cepivo>cepiva,DefaultListModel<Cepivo>modelCepiva) {
	
		this.listCepiv=listCepiv;
		this.cepiva=cepiva;
		this.modelCepiva=modelCepiva;
		
		//System.out.println(cepiva);
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		int index = listCepiv.getSelectedIndex();
		
		//System.out.println(cepiva);
		
		modelCepiva.remove(index);
		cepiva.remove(index);
		
	}
	
}
