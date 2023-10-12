package si.feri.opj.fras.ui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import java.io.FileWriter;

//import jdk.internal.org.objectweb.asm.tree.TryCatchBlockNode;

import javax.swing.JList;
import javax.swing.JTextField;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import javax.swing.AbstractListModel;
import java.awt.CardLayout;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import javax.swing.SpringLayout;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Locale;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import java.awt.GridLayout;
import java.awt.GridBagConstraints;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.TitledBorder;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;

import java.awt.Font;
import javax.swing.SwingConstants;
import net.miginfocom.swing.MigLayout;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JTextArea;

import si.feri.opj.fras.exceptioni.CepivoNeuporabnoException;
import si.feri.opj.fras.exceptioni.KapacitetaPresezenaException;
import si.feri.opj.fras.exceptioni.TipCepivaException;
import si.feri.opj.fras.listener.odstraniCepivoListener;
import si.feri.opj.fras.razredi.*;
import si.feri.opj.fras.listener.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.text.Collator;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class GUI {	
	
	
	
	
	private JFrame frmUpravljanjeCepilnihStoritev;
	private JTable tablePrevoznaSredstva;
	private JTextField textFieldPrevoznaSrestvaNaziv;
	private JTextField textFieldPrevoznaSrestvaZnamka;
	private JTextField textFieldPrevoznaSrestvaKapaciteta;
	private JTextField textFieldSerijskaStevilka;
	private JTable tableCepilnihCentrov;
	private JTextField textFieldCepilniCenterNaziv;
	private JTextField textFieldCepilniCenterKraj;
	private JTextField textFieldCepilniCenterEmail;
	private JTable tableAmbulanta;
	private JTextField textFieldAmbulantaNaziv;
	private JTextField textFieldAmbulantaKraj;
	private JTextField textFieldAmbulantaTelefonska;
	private JTable tableLogistikaVozila;
	private JTable tableLogistikaCep;
	
	private DefaultListModel<Cepivo> modelCepiva = new DefaultListModel<Cepivo>();
	private DefaultListModel<CepilniCenter> modelListCepilniCenter = new DefaultListModel<CepilniCenter>();
	private DefaultListModel<Cepivo> modelCepivaCepilniCenter = new DefaultListModel<Cepivo>();
	private DefaultTableModel modelCepilnihCentrov = new DefaultTableModel();
	private DefaultTableModel modelAmbulant = new DefaultTableModel();
	private DefaultTableModel modelVozil = new DefaultTableModel();
	
	
	private ArrayList<Cepivo> arrayCepiv = new ArrayList<Cepivo>();
	private ArrayList<Ustanova> arrayCepilnihCentrov = new ArrayList<Ustanova>();
	private ArrayList<Ustanova> arrayAmbulant = new ArrayList<Ustanova>();
	private ArrayList<PrevoznoSredstvo> arrayVozil = new ArrayList<PrevoznoSredstvo>();
	//private ArrayList<> arrayCepivCepilniCenter = new ArrayList<Cepivo>();
	private JTextField textFieldCepilniCenterDrzava;
	private JTextField textFieldAmbulantaDrzava;
	private JTable tableLogistikaAmb;
	
	JRadioButton rdbtnAvto = new JRadioButton("Avto");
	JCheckBox chckbxImaTipCepiva = new JCheckBox("Ima tip cepiva");
	JComboBox comboBoxTipov = new JComboBox();
	DefaultComboBoxModel<TipCepiva> modelTipCepiv = new DefaultComboBoxModel<TipCepiva>(TipCepiva.values());
	JRadioButton rdbtnKombi = new JRadioButton("Kombi");
	JCheckBox chckbxMoznostRazsiritve = new JCheckBox("Moznost razsiritve");
	JTextField textFieldPrevoznaSrestvaRegisterska = new JTextField();
	
	/**
	 * Launch the application.
	 */
	
	
	
	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI window = new GUI();
					window.frmUpravljanjeCepilnihStoritev.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
				
					
				
			}
		});
	}

	/**
	 * Create the application.
	 */
	public GUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		
		frmUpravljanjeCepilnihStoritev = new JFrame();
		
		
		
		frmUpravljanjeCepilnihStoritev.setTitle("Upravljanje cepilnih storitev");
		frmUpravljanjeCepilnihStoritev.setBounds(100, 100, 810, 462);
		frmUpravljanjeCepilnihStoritev.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		frmUpravljanjeCepilnihStoritev.getContentPane().add(tabbedPane, BorderLayout.CENTER);
		
		JPanel panelUpravljanjeCepiv = new JPanel();
		tabbedPane.addTab("Upravljanje cepiv", null, panelUpravljanjeCepiv, null);
		panelUpravljanjeCepiv.setLayout(new CardLayout(0, 0));
		
		JPanel panelUpravljanjeCep = new JPanel();
		panelUpravljanjeCepiv.add(panelUpravljanjeCep, "1");
		
		JLabel lblNewLabelSerijska = new JLabel("Serijska stevilka:");
		
		JList listCepiv = new JList();
	
		listCepiv.setModel(modelCepiva);
		
		JButton btnNewButtonPojdiNaCepilniCenter = new JButton("Pojdi na upravljanjej cepiv v cepilnem centru");
		
		
		JPanel panelRokUporabe = new JPanel();
		panelRokUporabe.setBorder(new TitledBorder(null, "Rok uporabe:", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		
		JComboBox comboBoxTipCepiva = new JComboBox();
		comboBoxTipCepiva.setEnabled(false);
		comboBoxTipCepiva.setModel(modelTipCepiv);
		
		
		
		
		JLabel lblNewLabelTipCepiva = new JLabel("Tip cepiva:");
		
		JCheckBox chckbxVecOdmerkov = new JCheckBox("Vec odmerkov");
		
		JButton btnDodajCepivo = new JButton("Dodaj cepivo");
		
		
		
		JButton btnShraniSpremembe = new JButton("Shrani");
		
		
		JButton btnOdstraniCepivo = new JButton("Odstrani cepivo");
		btnOdstraniCepivo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int index = listCepiv.getSelectedIndex();
				
				//System.out.println(cepiva);
				
				String opis="Izbrisano cepivo: " + arrayCepiv.get(index).getSerijskaStevilka();
				
				modelCepiva.remove(index);
				arrayCepiv.remove(index);
				
				try {
					belezenjeDogodkov(VrstaDogodka.OPOZORILO, opis);
				} catch (IOException e2) {
					e2.printStackTrace();
				}
				
				
				
			}
		});
		
		textFieldSerijskaStevilka = new JTextField();
		textFieldSerijskaStevilka.setColumns(10);
		
		JCheckBox chckbxCepivaImaTip = new JCheckBox("Ima tip cepiva:");
		chckbxCepivaImaTip.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(chckbxCepivaImaTip.isSelected())
					comboBoxTipCepiva.setEnabled(true);
				else
					comboBoxTipCepiva.setEnabled(false);;
				
			}
		});
		GroupLayout gl_panelUpravljanjeCep = new GroupLayout(panelUpravljanjeCep);
		gl_panelUpravljanjeCep.setHorizontalGroup(
			gl_panelUpravljanjeCep.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panelUpravljanjeCep.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panelUpravljanjeCep.createParallelGroup(Alignment.TRAILING)
						.addComponent(btnNewButtonPojdiNaCepilniCenter, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 769, Short.MAX_VALUE)
						.addGroup(gl_panelUpravljanjeCep.createSequentialGroup()
							.addGroup(gl_panelUpravljanjeCep.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panelUpravljanjeCep.createSequentialGroup()
									.addComponent(panelRokUporabe, GroupLayout.PREFERRED_SIZE, 196, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addGroup(gl_panelUpravljanjeCep.createParallelGroup(Alignment.LEADING)
										.addGroup(gl_panelUpravljanjeCep.createParallelGroup(Alignment.LEADING)
											.addGroup(gl_panelUpravljanjeCep.createSequentialGroup()
												.addComponent(lblNewLabelTipCepiva)
												.addPreferredGap(ComponentPlacement.UNRELATED)
												.addComponent(comboBoxTipCepiva, 0, 131, Short.MAX_VALUE))
											.addComponent(chckbxVecOdmerkov, GroupLayout.PREFERRED_SIZE, 107, GroupLayout.PREFERRED_SIZE))
										.addComponent(chckbxCepivaImaTip)))
								.addGroup(gl_panelUpravljanjeCep.createParallelGroup(Alignment.LEADING, false)
									.addGroup(gl_panelUpravljanjeCep.createSequentialGroup()
										.addComponent(lblNewLabelSerijska)
										.addGap(22)
										.addComponent(textFieldSerijskaStevilka))
									.addGroup(gl_panelUpravljanjeCep.createSequentialGroup()
										.addComponent(btnDodajCepivo, GroupLayout.PREFERRED_SIZE, 123, GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(btnShraniSpremembe, GroupLayout.PREFERRED_SIZE, 135, GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(btnOdstraniCepivo, GroupLayout.PREFERRED_SIZE, 123, GroupLayout.PREFERRED_SIZE))))
							.addGap(12)
							.addComponent(listCepiv, GroupLayout.PREFERRED_SIZE, 364, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap())
		);
		gl_panelUpravljanjeCep.setVerticalGroup(
			gl_panelUpravljanjeCep.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelUpravljanjeCep.createSequentialGroup()
					.addGap(5)
					.addComponent(btnNewButtonPojdiNaCepilniCenter, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panelUpravljanjeCep.createParallelGroup(Alignment.LEADING)
						.addComponent(listCepiv, GroupLayout.DEFAULT_SIZE, 330, Short.MAX_VALUE)
						.addGroup(gl_panelUpravljanjeCep.createSequentialGroup()
							.addGap(13)
							.addGroup(gl_panelUpravljanjeCep.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblNewLabelSerijska)
								.addComponent(textFieldSerijskaStevilka, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(18)
							.addGroup(gl_panelUpravljanjeCep.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panelUpravljanjeCep.createSequentialGroup()
									.addGroup(gl_panelUpravljanjeCep.createParallelGroup(Alignment.TRAILING)
										.addComponent(comboBoxTipCepiva, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(lblNewLabelTipCepiva, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE))
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(chckbxCepivaImaTip)
									.addPreferredGap(ComponentPlacement.RELATED, 70, Short.MAX_VALUE)
									.addComponent(chckbxVecOdmerkov, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE))
								.addComponent(panelRokUporabe, GroupLayout.PREFERRED_SIZE, 148, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_panelUpravljanjeCep.createParallelGroup(Alignment.TRAILING)
								.addComponent(btnOdstraniCepivo, GroupLayout.PREFERRED_SIZE, 119, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_panelUpravljanjeCep.createParallelGroup(Alignment.LEADING, false)
									.addComponent(btnDodajCepivo, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addComponent(btnShraniSpremembe, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 119, Short.MAX_VALUE)))))
					.addContainerGap())
		);
		panelRokUporabe.setLayout(null);
		
		JComboBox comboBoxDan = new JComboBox();
		comboBoxDan.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"}));
		comboBoxDan.setBounds(10, 44, 32, 22);
		panelRokUporabe.add(comboBoxDan);
		
		JComboBox comboBoxMesec = new JComboBox();
		comboBoxMesec.setModel(new DefaultComboBoxModel(new String[] {"Januar ", "Februar", "Marec", "April", "Maj", "Junij", "Julij", "August", "September", "Oktober", "November", "December"}));
		comboBoxMesec.setBounds(52, 44, 70, 22);
		panelRokUporabe.add(comboBoxMesec);
		
		JComboBox comboBoxLeto = new JComboBox();
		comboBoxLeto.setBounds(132, 44, 54, 22);
		panelRokUporabe.add(comboBoxLeto);
		comboBoxLeto.setModel(new DefaultComboBoxModel(new String[] {"2020", "2021", "2022", "2023", "2024", "2025", "2026", "2027", "2028", "2029", "2030"}));
		
		JLabel lblNewLabel_4 = new JLabel("Dan:");
		lblNewLabel_4.setBounds(10, 24, 46, 14);
		panelRokUporabe.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Mesec:");
		lblNewLabel_5.setBounds(52, 24, 46, 14);
		panelRokUporabe.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Leto:");
		lblNewLabel_6.setBounds(132, 24, 46, 14);
		panelRokUporabe.add(lblNewLabel_6);
		panelUpravljanjeCep.setLayout(gl_panelUpravljanjeCep);
		
		JPanel panelUpravljanjeCepCepilniCenter = new JPanel();
		panelUpravljanjeCepiv.add(panelUpravljanjeCepCepilniCenter, "2");
		
		JButton btnNewButtonPojdiNaUpravljanjeCepiv = new JButton("Pojdi na upravljanje cepiv");
		btnNewButtonPojdiNaUpravljanjeCepiv.setBounds(10, 11, 769, 38);
		btnNewButtonPojdiNaUpravljanjeCepiv.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CardLayout c1 = (CardLayout) panelUpravljanjeCepiv.getLayout();
				c1.show(panelUpravljanjeCepiv, "1");
			}
		});
		
		JButton btnDodajCepivoCepilniCenter = new JButton("Dodaj cepivo");
		btnDodajCepivoCepilniCenter.setBounds(10, 287, 162, 96);
		
		
		JButton btnOdstraniCepivoCepilniCenter = new JButton("Odstrani cepivo");
		
		btnOdstraniCepivoCepilniCenter.setBounds(190, 286, 170, 98);
		
		JList listCepivCepilniCenter = new JList();
		listCepivCepilniCenter.setBounds(370, 193, 409, 190);
		listCepivCepilniCenter.setModel(modelCepivaCepilniCenter);
		
		
		JPanel panelCepiv = new JPanel();
		panelCepiv.setBounds(10, 74, 350, 201);
		
		JLabel lblUpravljanjeCepCenterCepiva = new JLabel("Cepiva ki so na voljo:");
		lblUpravljanjeCepCenterCepiva.setBounds(10, 60, 190, 14);
		
		JLabel lblUpravljanjeCepCenter = new JLabel("Cepiva v cepilnem centru:");
		lblUpravljanjeCepCenter.setBounds(369, 168, 196, 14);
		panelCepiv.setLayout(null);
		
		JList listVsehCepiv = new JList();
		listVsehCepiv.setBounds(0, 0, 350, 201);
		
		
		
		panelCepiv.add(listVsehCepiv);
		panelUpravljanjeCepCepilniCenter.setLayout(null);
		panelUpravljanjeCepCepilniCenter.add(btnNewButtonPojdiNaUpravljanjeCepiv);
		panelUpravljanjeCepCepilniCenter.add(btnDodajCepivoCepilniCenter);
		panelUpravljanjeCepCepilniCenter.add(btnOdstraniCepivoCepilniCenter);
		panelUpravljanjeCepCepilniCenter.add(panelCepiv);
		panelUpravljanjeCepCepilniCenter.add(lblUpravljanjeCepCenterCepiva);
		panelUpravljanjeCepCepilniCenter.add(listCepivCepilniCenter);
		panelUpravljanjeCepCepilniCenter.add(lblUpravljanjeCepCenter);
		
		JLabel lblCepilniCenterCenter = new JLabel("Cepilni center:");
		lblCepilniCenterCenter.setBounds(370, 60, 89, 14);
		panelUpravljanjeCepCepilniCenter.add(lblCepilniCenterCenter);
		
		JList listIzbiraCepilniCenter = new JList();
		
		listIzbiraCepilniCenter.setBounds(370, 74, 409, 83);
		panelUpravljanjeCepCepilniCenter.add(listIzbiraCepilniCenter);
		
		listIzbiraCepilniCenter.setModel(modelListCepilniCenter);
		
		JPanel panelUpravljanjeUstanov = new JPanel();
		tabbedPane.addTab("Upravljanje ustanov", null, panelUpravljanjeUstanov, null);
		panelUpravljanjeUstanov.setLayout(new CardLayout(0, 0));
		
		JPanel panelUstanove = new JPanel();
		panelUpravljanjeUstanov.add(panelUstanove, "1");
		panelUstanove.setLayout(new CardLayout(0, 0));
		
		JPanel panelCepilniCenter = new JPanel();
		panelUstanove.add(panelCepilniCenter, "1");
		panelCepilniCenter.setLayout(new BorderLayout(0, 0));
		
		tableCepilnihCentrov = new JTable();
		
		modelCepilnihCentrov.addColumn("Naziv");
		modelCepilnihCentrov.addColumn("Kraj");
		modelCepilnihCentrov.addColumn("Email");
		tableCepilnihCentrov.setModel(modelCepilnihCentrov);
		panelCepilniCenter.add(tableCepilnihCentrov, BorderLayout.CENTER);
		
		
		JPanel panelSkoka = new JPanel();
		panelCepilniCenter.add(panelSkoka, BorderLayout.NORTH);
		panelSkoka.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JButton btnCepilniCenterPojdiNaAmbulanto = new JButton("Pojdi na ambulanto");
		btnCepilniCenterPojdiNaAmbulanto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CardLayout c1 = (CardLayout) panelUstanove.getLayout();
				c1.show(panelUstanove, "2");
			}
		});
		panelSkoka.add(btnCepilniCenterPojdiNaAmbulanto);
		
		JPanel panelCepilniCenterLevo = new JPanel();
		panelCepilniCenter.add(panelCepilniCenterLevo, BorderLayout.WEST);
		
		JLabel lblCepilniCenterNaziv = new JLabel("Naziv cepilnega centra:");
		
		textFieldCepilniCenterNaziv = new JTextField();
		textFieldCepilniCenterNaziv.setColumns(10);
		
		JCheckBox chckbxCepilniCenterKraj = new JCheckBox("Kraj:");
		
		JCheckBox chckbxCepilneCenterEmail = new JCheckBox("Email:");
		
		textFieldCepilniCenterKraj = new JTextField();
		textFieldCepilniCenterKraj.setColumns(10);
		
		textFieldCepilniCenterEmail = new JTextField();
		textFieldCepilniCenterEmail.setColumns(10);
		
		JButton btnCepilniCenterDodaj = new JButton("Dodaj");
		
		
		JButton btnCepilniCenterOdstrani = new JButton("Odstrani");
		
		
		JButton btnCepilniCenterShrani = new JButton("Shrani");
		
		
		textFieldCepilniCenterDrzava = new JTextField();
		textFieldCepilniCenterDrzava.setColumns(10);
		
		JLabel lblCepilniCenterDrzava = new JLabel("Država:");
		GroupLayout gl_panelCepilniCenterLevo = new GroupLayout(panelCepilniCenterLevo);
		gl_panelCepilniCenterLevo.setHorizontalGroup(
			gl_panelCepilniCenterLevo.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelCepilniCenterLevo.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panelCepilniCenterLevo.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panelCepilniCenterLevo.createSequentialGroup()
							.addComponent(chckbxCepilniCenterKraj, GroupLayout.PREFERRED_SIZE, 57, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(textFieldCepilniCenterKraj, 197, 197, 197))
						.addGroup(gl_panelCepilniCenterLevo.createSequentialGroup()
							.addComponent(lblCepilniCenterNaziv)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(textFieldCepilniCenterNaziv, GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panelCepilniCenterLevo.createSequentialGroup()
							.addComponent(btnCepilniCenterDodaj, GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnCepilniCenterShrani, GroupLayout.PREFERRED_SIZE, 75, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnCepilniCenterOdstrani, GroupLayout.PREFERRED_SIZE, 89, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panelCepilniCenterLevo.createSequentialGroup()
							.addGroup(gl_panelCepilniCenterLevo.createParallelGroup(Alignment.LEADING)
								.addComponent(chckbxCepilneCenterEmail)
								.addComponent(lblCepilniCenterDrzava))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_panelCepilniCenterLevo.createParallelGroup(Alignment.LEADING)
								.addComponent(textFieldCepilniCenterEmail, GroupLayout.DEFAULT_SIZE, 197, Short.MAX_VALUE)
								.addComponent(textFieldCepilniCenterDrzava, GroupLayout.DEFAULT_SIZE, 197, Short.MAX_VALUE))))
					.addContainerGap())
		);
		gl_panelCepilniCenterLevo.setVerticalGroup(
			gl_panelCepilniCenterLevo.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelCepilniCenterLevo.createSequentialGroup()
					.addGroup(gl_panelCepilniCenterLevo.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblCepilniCenterNaziv, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
						.addComponent(textFieldCepilniCenterNaziv, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panelCepilniCenterLevo.createParallelGroup(Alignment.BASELINE)
						.addComponent(chckbxCepilniCenterKraj)
						.addComponent(textFieldCepilniCenterKraj, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panelCepilniCenterLevo.createParallelGroup(Alignment.BASELINE)
						.addComponent(textFieldCepilniCenterDrzava, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblCepilniCenterDrzava))
					.addGap(10)
					.addGroup(gl_panelCepilniCenterLevo.createParallelGroup(Alignment.BASELINE)
						.addComponent(chckbxCepilneCenterEmail)
						.addComponent(textFieldCepilniCenterEmail, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(165)
					.addGroup(gl_panelCepilniCenterLevo.createParallelGroup(Alignment.TRAILING)
						.addComponent(btnCepilniCenterShrani, GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)
						.addComponent(btnCepilniCenterOdstrani, GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)
						.addComponent(btnCepilniCenterDodaj, GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE))
					.addContainerGap())
		);
		panelCepilniCenterLevo.setLayout(gl_panelCepilniCenterLevo);
		
		JPanel panelAmbulanta = new JPanel();
		panelUstanove.add(panelAmbulanta, "2");
		
		JPanel panelAmbulantaSkoki = new JPanel();
		
		JButton btnAmbulantaPojdiNaCepilniCenter = new JButton("Pojdi na cepilni center");
		btnAmbulantaPojdiNaCepilniCenter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CardLayout c1 = (CardLayout) panelUstanove.getLayout();
				c1.show(panelUstanove, "1");
			}
		});
		panelAmbulantaSkoki.add(btnAmbulantaPojdiNaCepilniCenter);
		
		JPanel panelAmbulantaLevo = new JPanel();
		
		
		JLabel lblAmbulantaNaziv = new JLabel("Naziv ambulante:");
		
		textFieldAmbulantaNaziv = new JTextField();
		textFieldAmbulantaNaziv.setColumns(10);
		
		JLabel lblAmbulantaKraj = new JLabel("Kraj ambulante:");
		
		textFieldAmbulantaKraj = new JTextField();
		textFieldAmbulantaKraj.setColumns(10);
		
		textFieldAmbulantaTelefonska = new JTextField();
		textFieldAmbulantaTelefonska.setColumns(10);
		
		JButton btnAmbulantaNova = new JButton("Dodaj");
		
		
		JButton btnAmbulantaShrani = new JButton("Shrani");
		
		
		JButton btnAmbulantaOdstrani = new JButton("Odstrani");
		
		
		JLabel lblAmbulantaTelefonska = new JLabel("Telefonska številka:");
		
		JLabel lblNewLabel_7 = new JLabel("Država:");
		
		textFieldAmbulantaDrzava = new JTextField();
		textFieldAmbulantaDrzava.setColumns(10);
		GroupLayout gl_panelAmbulantaLevo = new GroupLayout(panelAmbulantaLevo);
		gl_panelAmbulantaLevo.setHorizontalGroup(
			gl_panelAmbulantaLevo.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelAmbulantaLevo.createSequentialGroup()
					.addGroup(gl_panelAmbulantaLevo.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panelAmbulantaLevo.createSequentialGroup()
							.addContainerGap()
							.addComponent(btnAmbulantaNova, GroupLayout.PREFERRED_SIZE, 89, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnAmbulantaShrani, GroupLayout.PREFERRED_SIZE, 79, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnAmbulantaOdstrani, GroupLayout.DEFAULT_SIZE, 91, Short.MAX_VALUE))
						.addGroup(gl_panelAmbulantaLevo.createSequentialGroup()
							.addGap(5)
							.addGroup(gl_panelAmbulantaLevo.createParallelGroup(Alignment.LEADING)
								.addComponent(lblAmbulantaNaziv)
								.addComponent(lblAmbulantaKraj)
								.addComponent(lblAmbulantaTelefonska)
								.addComponent(lblNewLabel_7))
							.addGap(5)
							.addGroup(gl_panelAmbulantaLevo.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panelAmbulantaLevo.createParallelGroup(Alignment.TRAILING)
									.addGroup(gl_panelAmbulantaLevo.createSequentialGroup()
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(textFieldAmbulantaTelefonska, GroupLayout.DEFAULT_SIZE, 176, Short.MAX_VALUE))
									.addComponent(textFieldAmbulantaDrzava, GroupLayout.DEFAULT_SIZE, 176, Short.MAX_VALUE))
								.addGroup(gl_panelAmbulantaLevo.createParallelGroup(Alignment.LEADING)
									.addComponent(textFieldAmbulantaKraj, GroupLayout.DEFAULT_SIZE, 176, Short.MAX_VALUE)
									.addComponent(textFieldAmbulantaNaziv, GroupLayout.DEFAULT_SIZE, 176, Short.MAX_VALUE)))))
					.addContainerGap())
		);
		gl_panelAmbulantaLevo.setVerticalGroup(
			gl_panelAmbulantaLevo.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelAmbulantaLevo.createSequentialGroup()
					.addGroup(gl_panelAmbulantaLevo.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panelAmbulantaLevo.createSequentialGroup()
							.addGap(8)
							.addComponent(lblAmbulantaNaziv))
						.addGroup(gl_panelAmbulantaLevo.createSequentialGroup()
							.addGap(5)
							.addComponent(textFieldAmbulantaNaziv, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panelAmbulantaLevo.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblAmbulantaKraj)
						.addComponent(textFieldAmbulantaKraj, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panelAmbulantaLevo.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_7)
						.addComponent(textFieldAmbulantaDrzava, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(11)
					.addGroup(gl_panelAmbulantaLevo.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblAmbulantaTelefonska)
						.addComponent(textFieldAmbulantaTelefonska, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(159)
					.addGroup(gl_panelAmbulantaLevo.createParallelGroup(Alignment.LEADING)
						.addComponent(btnAmbulantaOdstrani, GroupLayout.DEFAULT_SIZE, 83, Short.MAX_VALUE)
						.addComponent(btnAmbulantaShrani, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 83, Short.MAX_VALUE)
						.addComponent(btnAmbulantaNova, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 83, Short.MAX_VALUE))
					.addContainerGap())
		);
		panelAmbulantaLevo.setLayout(gl_panelAmbulantaLevo);
		
		tableAmbulanta = new JTable();
		
		GroupLayout gl_panelAmbulanta = new GroupLayout(panelAmbulanta);
		gl_panelAmbulanta.setHorizontalGroup(
			gl_panelAmbulanta.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelAmbulanta.createSequentialGroup()
					.addGroup(gl_panelAmbulanta.createParallelGroup(Alignment.LEADING)
						.addComponent(panelAmbulantaSkoki, GroupLayout.PREFERRED_SIZE, 789, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_panelAmbulanta.createSequentialGroup()
							.addComponent(panelAmbulantaLevo, GroupLayout.PREFERRED_SIZE, 291, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(tableAmbulanta, GroupLayout.PREFERRED_SIZE, 480, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap())
		);
	
		
		
		modelAmbulant.addColumn("Naziv");
		modelAmbulant.addColumn("Kraj");
		modelAmbulant.addColumn("Telefonska številka");
		
		tableAmbulanta.setModel(modelAmbulant);
		
		gl_panelAmbulanta.setVerticalGroup(
			gl_panelAmbulanta.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelAmbulanta.createSequentialGroup()
					.addComponent(panelAmbulantaSkoki, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGroup(gl_panelAmbulanta.createParallelGroup(Alignment.LEADING)
						.addComponent(panelAmbulantaLevo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(tableAmbulanta, GroupLayout.PREFERRED_SIZE, 362, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
		);
		panelAmbulanta.setLayout(gl_panelAmbulanta);
		
		JPanel panelUpravljanjePrevoznihSredstev = new JPanel();
		tabbedPane.addTab("Upravljanje prevoznih sredstev", null, panelUpravljanjePrevoznihSredstev, null);
		SpringLayout sl_panelUpravljanjePrevoznihSredstev = new SpringLayout();
		panelUpravljanjePrevoznihSredstev.setLayout(sl_panelUpravljanjePrevoznihSredstev);
		
		tablePrevoznaSredstva = new JTable();
		
		sl_panelUpravljanjePrevoznihSredstev.putConstraint(SpringLayout.NORTH, tablePrevoznaSredstva, 10, SpringLayout.NORTH, panelUpravljanjePrevoznihSredstev);
		sl_panelUpravljanjePrevoznihSredstev.putConstraint(SpringLayout.EAST, tablePrevoznaSredstva, -10, SpringLayout.EAST, panelUpravljanjePrevoznihSredstev);
		
		modelVozil.addColumn("Vrsta vozila");
		modelVozil.addColumn("Znamka");
		modelVozil.addColumn("Naziv");
		modelVozil.addColumn("Registerska številka");
		modelVozil.addColumn("Tip cepiva");
		modelVozil.addColumn("Možnost razžiritve");
		modelVozil.addColumn("Kapaciteta");
		
		tablePrevoznaSredstva.setModel(modelVozil);
		
		sl_panelUpravljanjePrevoznihSredstev.putConstraint(SpringLayout.SOUTH, tablePrevoznaSredstva, -10, SpringLayout.SOUTH, panelUpravljanjePrevoznihSredstev);
		panelUpravljanjePrevoznihSredstev.add(tablePrevoznaSredstva);
		
		JButton btnDodajPrevoznoSredstvo = new JButton("Dodaj vozilo");
		
		sl_panelUpravljanjePrevoznihSredstev.putConstraint(SpringLayout.WEST, btnDodajPrevoznoSredstvo, 10, SpringLayout.WEST, panelUpravljanjePrevoznihSredstev);
		sl_panelUpravljanjePrevoznihSredstev.putConstraint(SpringLayout.SOUTH, btnDodajPrevoznoSredstvo, -10, SpringLayout.SOUTH, panelUpravljanjePrevoznihSredstev);
		panelUpravljanjePrevoznihSredstev.add(btnDodajPrevoznoSredstvo);
		
		JButton btnShraniSpremembePrevoznaSredstva = new JButton("Shrani spremembe");
		
		sl_panelUpravljanjePrevoznihSredstev.putConstraint(SpringLayout.SOUTH, btnShraniSpremembePrevoznaSredstva, -10, SpringLayout.SOUTH, panelUpravljanjePrevoznihSredstev);
		sl_panelUpravljanjePrevoznihSredstev.putConstraint(SpringLayout.EAST, btnDodajPrevoznoSredstvo, -6, SpringLayout.WEST, btnShraniSpremembePrevoznaSredstva);
		sl_panelUpravljanjePrevoznihSredstev.putConstraint(SpringLayout.WEST, btnShraniSpremembePrevoznaSredstva, 142, SpringLayout.WEST, panelUpravljanjePrevoznihSredstev);
		sl_panelUpravljanjePrevoznihSredstev.putConstraint(SpringLayout.EAST, btnShraniSpremembePrevoznaSredstva, -526, SpringLayout.EAST, panelUpravljanjePrevoznihSredstev);
		panelUpravljanjePrevoznihSredstev.add(btnShraniSpremembePrevoznaSredstva);
		
		JButton btnOdstraniPrevoznoSredstvo = new JButton("Odstrani vozilo");
		
		sl_panelUpravljanjePrevoznihSredstev.putConstraint(SpringLayout.NORTH, btnOdstraniPrevoznoSredstvo, 323, SpringLayout.NORTH, panelUpravljanjePrevoznihSredstev);
		sl_panelUpravljanjePrevoznihSredstev.putConstraint(SpringLayout.SOUTH, btnOdstraniPrevoznoSredstvo, -10, SpringLayout.SOUTH, panelUpravljanjePrevoznihSredstev);
		sl_panelUpravljanjePrevoznihSredstev.putConstraint(SpringLayout.EAST, btnOdstraniPrevoznoSredstvo, -396, SpringLayout.EAST, panelUpravljanjePrevoznihSredstev);
		sl_panelUpravljanjePrevoznihSredstev.putConstraint(SpringLayout.WEST, tablePrevoznaSredstva, 6, SpringLayout.EAST, btnOdstraniPrevoznoSredstvo);
		sl_panelUpravljanjePrevoznihSredstev.putConstraint(SpringLayout.WEST, btnOdstraniPrevoznoSredstvo, 6, SpringLayout.EAST, btnShraniSpremembePrevoznaSredstva);
		panelUpravljanjePrevoznihSredstev.add(btnOdstraniPrevoznoSredstvo);
		
		textFieldPrevoznaSrestvaNaziv = new JTextField();
		sl_panelUpravljanjePrevoznihSredstev.putConstraint(SpringLayout.EAST, textFieldPrevoznaSrestvaNaziv, -31, SpringLayout.WEST, tablePrevoznaSredstva);
		panelUpravljanjePrevoznihSredstev.add(textFieldPrevoznaSrestvaNaziv);
		textFieldPrevoznaSrestvaNaziv.setColumns(10);
		
		textFieldPrevoznaSrestvaZnamka = new JTextField();
		sl_panelUpravljanjePrevoznihSredstev.putConstraint(SpringLayout.WEST, textFieldPrevoznaSrestvaZnamka, -275, SpringLayout.WEST, tablePrevoznaSredstva);
		sl_panelUpravljanjePrevoznihSredstev.putConstraint(SpringLayout.EAST, textFieldPrevoznaSrestvaZnamka, -31, SpringLayout.WEST, tablePrevoznaSredstva);
		panelUpravljanjePrevoznihSredstev.add(textFieldPrevoznaSrestvaZnamka);
		textFieldPrevoznaSrestvaZnamka.setColumns(10);
		
		
		
		
		
		JLabel lblNewLabel = new JLabel("Naziv:");
		sl_panelUpravljanjePrevoznihSredstev.putConstraint(SpringLayout.NORTH, textFieldPrevoznaSrestvaNaziv, -3, SpringLayout.NORTH, lblNewLabel);
		sl_panelUpravljanjePrevoznihSredstev.putConstraint(SpringLayout.WEST, textFieldPrevoznaSrestvaNaziv, 84, SpringLayout.EAST, lblNewLabel);
		sl_panelUpravljanjePrevoznihSredstev.putConstraint(SpringLayout.NORTH, lblNewLabel, 84, SpringLayout.NORTH, panelUpravljanjePrevoznihSredstev);
		sl_panelUpravljanjePrevoznihSredstev.putConstraint(SpringLayout.WEST, lblNewLabel, 0, SpringLayout.WEST, btnDodajPrevoznoSredstvo);
		panelUpravljanjePrevoznihSredstev.add(lblNewLabel);
		
		JLabel lblPrevoznaSredstvaZnamka = new JLabel("Znamka:");
		sl_panelUpravljanjePrevoznihSredstev.putConstraint(SpringLayout.NORTH, lblPrevoznaSredstvaZnamka, 9, SpringLayout.SOUTH, lblNewLabel);
		sl_panelUpravljanjePrevoznihSredstev.putConstraint(SpringLayout.NORTH, textFieldPrevoznaSrestvaZnamka, -3, SpringLayout.NORTH, lblPrevoznaSredstvaZnamka);
		sl_panelUpravljanjePrevoznihSredstev.putConstraint(SpringLayout.WEST, lblPrevoznaSredstvaZnamka, 0, SpringLayout.WEST, btnDodajPrevoznoSredstvo);
		panelUpravljanjePrevoznihSredstev.add(lblPrevoznaSredstvaZnamka);
		
		JLabel lblPrevoznaSredstvaRegisterska = new JLabel("Registerska stevilka:");
		sl_panelUpravljanjePrevoznihSredstev.putConstraint(SpringLayout.NORTH, lblPrevoznaSredstvaRegisterska, 12, SpringLayout.SOUTH, lblPrevoznaSredstvaZnamka);
		sl_panelUpravljanjePrevoznihSredstev.putConstraint(SpringLayout.WEST, lblPrevoznaSredstvaRegisterska, 0, SpringLayout.WEST, btnDodajPrevoznoSredstvo);
		panelUpravljanjePrevoznihSredstev.add(lblPrevoznaSredstvaRegisterska);
		
		JLabel lblPrevoznaSredstvaKapaciteta = new JLabel("Kapaciteta:");
		sl_panelUpravljanjePrevoznihSredstev.putConstraint(SpringLayout.NORTH, lblPrevoznaSredstvaKapaciteta, 12, SpringLayout.SOUTH, lblPrevoznaSredstvaRegisterska);
		//sl_panelUpravljanjePrevoznihSredstev.putConstraint(SpringLayout.WEST, textFieldPrevoznaSrestvaKapaciteta, 59, SpringLayout.EAST, lblPrevoznaSredstvaKapaciteta);
		sl_panelUpravljanjePrevoznihSredstev.putConstraint(SpringLayout.WEST, lblPrevoznaSredstvaKapaciteta, 0, SpringLayout.WEST, btnDodajPrevoznoSredstvo);
		panelUpravljanjePrevoznihSredstev.add(lblPrevoznaSredstvaKapaciteta);
		
		
		
		sl_panelUpravljanjePrevoznihSredstev.putConstraint(SpringLayout.NORTH, rdbtnAvto, 8, SpringLayout.NORTH, panelUpravljanjePrevoznihSredstev);
		sl_panelUpravljanjePrevoznihSredstev.putConstraint(SpringLayout.SOUTH, rdbtnAvto, 46, SpringLayout.NORTH, panelUpravljanjePrevoznihSredstev);
		sl_panelUpravljanjePrevoznihSredstev.putConstraint(SpringLayout.EAST, rdbtnAvto, 68, SpringLayout.WEST, btnDodajPrevoznoSredstvo);
		rdbtnAvto.setFont(new Font("Tahoma", Font.PLAIN, 18));
		sl_panelUpravljanjePrevoznihSredstev.putConstraint(SpringLayout.WEST, rdbtnAvto, 0, SpringLayout.WEST, btnDodajPrevoznoSredstvo);
		panelUpravljanjePrevoznihSredstev.add(rdbtnAvto);
		
		
		
		sl_panelUpravljanjePrevoznihSredstev.putConstraint(SpringLayout.NORTH, rdbtnKombi, 0, SpringLayout.NORTH, tablePrevoznaSredstva);
		sl_panelUpravljanjePrevoznihSredstev.putConstraint(SpringLayout.WEST, rdbtnKombi, 6, SpringLayout.EAST, rdbtnAvto);
		sl_panelUpravljanjePrevoznihSredstev.putConstraint(SpringLayout.SOUTH, rdbtnKombi, 0, SpringLayout.SOUTH, rdbtnAvto);
		sl_panelUpravljanjePrevoznihSredstev.putConstraint(SpringLayout.EAST, rdbtnKombi, -216, SpringLayout.WEST, tablePrevoznaSredstva);
		rdbtnKombi.setFont(new Font("Tahoma", Font.PLAIN, 18));
		panelUpravljanjePrevoznihSredstev.add(rdbtnKombi);
		
		
		sl_panelUpravljanjePrevoznihSredstev.putConstraint(SpringLayout.NORTH, chckbxMoznostRazsiritve, 6, SpringLayout.SOUTH, lblPrevoznaSredstvaKapaciteta);
		sl_panelUpravljanjePrevoznihSredstev.putConstraint(SpringLayout.WEST, chckbxMoznostRazsiritve, 0, SpringLayout.WEST, btnDodajPrevoznoSredstvo);
		panelUpravljanjePrevoznihSredstev.add(chckbxMoznostRazsiritve);
		
		
		sl_panelUpravljanjePrevoznihSredstev.putConstraint(SpringLayout.NORTH, btnShraniSpremembePrevoznaSredstva, 85, SpringLayout.SOUTH, comboBoxTipov);
		sl_panelUpravljanjePrevoznihSredstev.putConstraint(SpringLayout.EAST, comboBoxTipov, 0, SpringLayout.EAST, textFieldPrevoznaSrestvaNaziv);
		sl_panelUpravljanjePrevoznihSredstev.putConstraint(SpringLayout.WEST, comboBoxTipov, 0, SpringLayout.WEST, textFieldPrevoznaSrestvaNaziv);
		panelUpravljanjePrevoznihSredstev.add(comboBoxTipov);
		comboBoxTipov.setModel(modelTipCepiv);
		
		comboBoxTipov.setEnabled(false);
		
		
		chckbxImaTipCepiva.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(chckbxImaTipCepiva.isSelected())
					comboBoxTipov.setEnabled(true);
				else
					comboBoxTipov.setEnabled(false);
				
			}
		});
		sl_panelUpravljanjePrevoznihSredstev.putConstraint(SpringLayout.SOUTH, chckbxImaTipCepiva, -156, SpringLayout.SOUTH, panelUpravljanjePrevoznihSredstev);
		sl_panelUpravljanjePrevoznihSredstev.putConstraint(SpringLayout.NORTH, btnDodajPrevoznoSredstvo, 84, SpringLayout.SOUTH, chckbxImaTipCepiva);
		sl_panelUpravljanjePrevoznihSredstev.putConstraint(SpringLayout.NORTH, comboBoxTipov, 0, SpringLayout.NORTH, chckbxImaTipCepiva);
		sl_panelUpravljanjePrevoznihSredstev.putConstraint(SpringLayout.WEST, chckbxImaTipCepiva, 0, SpringLayout.WEST, btnDodajPrevoznoSredstvo);
		panelUpravljanjePrevoznihSredstev.add(chckbxImaTipCepiva);
		
		
		
		
		JPanel panelLogistika = new JPanel();
		panelLogistika.setLayout(null);
		tabbedPane.addTab("Logistika", null, panelLogistika, null);
		
		JLabel lblLogistikaPrikazCepiv = new JLabel("Prikaz cepiv v vozilu:");
		lblLogistikaPrikazCepiv.setBounds(524, 11, 137, 14);
		panelLogistika.add(lblLogistikaPrikazCepiv);
		
		JTextArea textAreaCepivVVozilu = new JTextArea();
		textAreaCepivVVozilu.setLineWrap(true);
		textAreaCepivVVozilu.setWrapStyleWord(true);
		textAreaCepivVVozilu.setRows(10);
		textAreaCepivVVozilu.setEditable(false);
		textAreaCepivVVozilu.setBounds(524, 36, 255, 177);
		panelLogistika.add(textAreaCepivVVozilu);
		
		JButton btnLogistikaNatovoriCepiva = new JButton("Natovori cepiva v cepilnem centru");
		
		btnLogistikaNatovoriCepiva.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnLogistikaNatovoriCepiva.setBounds(267, 238, 247, 146);
		panelLogistika.add(btnLogistikaNatovoriCepiva);
		
		JButton btnLogistikaRaztovoriCepiva = new JButton("Raztovori cepiva v ambulanti");
		
		btnLogistikaRaztovoriCepiva.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnLogistikaRaztovoriCepiva.setBounds(524, 238, 255, 146);
		panelLogistika.add(btnLogistikaRaztovoriCepiva);
		
		JLabel lblLogistikaVozila = new JLabel("Vozila:");
		lblLogistikaVozila.setBounds(267, 11, 46, 14);
		panelLogistika.add(lblLogistikaVozila);
		
		tableLogistikaVozila = new JTable();
		
		tableLogistikaVozila.setBounds(267, 36, 247, 177);
		panelLogistika.add(tableLogistikaVozila);
		tableLogistikaVozila.setModel(modelVozil);
		
		tableLogistikaCep = new JTable();
		tableLogistikaCep.setBounds(10, 36, 247, 177);
		panelLogistika.add(tableLogistikaCep);
		tableLogistikaCep.setModel(modelCepilnihCentrov);
		
		JLabel lblLogistikaCepilniCenter = new JLabel("Cepilni center:");
		lblLogistikaCepilniCenter.setBounds(10, 11, 89, 14);
		panelLogistika.add(lblLogistikaCepilniCenter);
		
		tableLogistikaAmb = new JTable();
		tableLogistikaAmb.setBounds(10, 238, 247, 146);
		panelLogistika.add(tableLogistikaAmb);
		tableLogistikaAmb.setModel(modelAmbulant);
		
		JLabel lblNewLabel_1 = new JLabel("Ambulante:");
		lblNewLabel_1.setBounds(10, 223, 72, 14);
		panelLogistika.add(lblNewLabel_1);
		
		
		sl_panelUpravljanjePrevoznihSredstev.putConstraint(SpringLayout.NORTH, textFieldPrevoznaSrestvaRegisterska, 6, SpringLayout.SOUTH, textFieldPrevoznaSrestvaZnamka);
		sl_panelUpravljanjePrevoznihSredstev.putConstraint(SpringLayout.WEST, textFieldPrevoznaSrestvaRegisterska, 0, SpringLayout.WEST, textFieldPrevoznaSrestvaNaziv);
		sl_panelUpravljanjePrevoznihSredstev.putConstraint(SpringLayout.EAST, textFieldPrevoznaSrestvaRegisterska, 0, SpringLayout.EAST, textFieldPrevoznaSrestvaNaziv);
		panelUpravljanjePrevoznihSredstev.add(textFieldPrevoznaSrestvaRegisterska);
		textFieldPrevoznaSrestvaRegisterska.setColumns(10);
		
		textFieldPrevoznaSrestvaKapaciteta = new JTextField();
		sl_panelUpravljanjePrevoznihSredstev.putConstraint(SpringLayout.NORTH, textFieldPrevoznaSrestvaKapaciteta, 6, SpringLayout.SOUTH, textFieldPrevoznaSrestvaRegisterska);
		sl_panelUpravljanjePrevoznihSredstev.putConstraint(SpringLayout.WEST, textFieldPrevoznaSrestvaKapaciteta, 0, SpringLayout.WEST, textFieldPrevoznaSrestvaNaziv);
		sl_panelUpravljanjePrevoznihSredstev.putConstraint(SpringLayout.EAST, textFieldPrevoznaSrestvaKapaciteta, 0, SpringLayout.EAST, textFieldPrevoznaSrestvaNaziv);
		panelUpravljanjePrevoznihSredstev.add(textFieldPrevoznaSrestvaKapaciteta);
		textFieldPrevoznaSrestvaKapaciteta.setColumns(10);
		  
		ButtonGroup group = new ButtonGroup();
		group.add(rdbtnAvto);
		group.add(rdbtnKombi);
		
		
		btnDodajCepivo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				LocalDate rokUporabe = LocalDate.of(comboBoxLeto.getSelectedIndex()+2019, comboBoxMesec.getSelectedIndex()+1,comboBoxDan.getSelectedIndex()+1 );
				
				Cepivo cepivo = new Cepivo((Integer.parseInt(textFieldSerijskaStevilka.getText())),rokUporabe);
				
				int index = comboBoxTipCepiva.getSelectedIndex();
				
				if(chckbxCepivaImaTip.isSelected())
				cepivo.setTipCepiva(modelTipCepiv.getElementAt(index));
				
				if(chckbxVecOdmerkov.isSelected())
					cepivo.setVecOdmerkov(true);
				else
					cepivo.setVecOdmerkov(false);
				
				
				arrayCepiv.add(cepivo);
				modelCepiva.addElement(cepivo);
				
				String opis="Dodano cepivo: " + cepivo.getSerijskaStevilka();
				
				try {
					belezenjeDogodkov(VrstaDogodka.OPOZORILO, opis);
				} catch (IOException e2) {
					e2.printStackTrace();
				}
				
				
			
			}
		});
		
		btnShraniSpremembe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int index = listCepiv.getSelectedIndex();
				
				LocalDate rokUporabe = LocalDate.of(comboBoxLeto.getSelectedIndex()+2019, comboBoxMesec.getSelectedIndex()+1,comboBoxDan.getSelectedIndex()+1 );
				
				Cepivo cepivo = new Cepivo((Integer.parseInt(textFieldSerijskaStevilka.getText())),rokUporabe);
				
				int indexTip = comboBoxTipCepiva.getSelectedIndex();
				
				if(chckbxCepivaImaTip.isSelected())
				cepivo.setTipCepiva(modelTipCepiv.getElementAt(indexTip));
				
				if(chckbxVecOdmerkov.isSelected())
					cepivo.setVecOdmerkov(true);
				else
					cepivo.setVecOdmerkov(false);
				
				arrayCepiv.set(index, cepivo);
				modelCepiva.setElementAt(cepivo, index);
				
				String opis="Podatki cepiva spremenjeni: " + cepivo.getSerijskaStevilka();
				
				try {
					belezenjeDogodkov(VrstaDogodka.ZAZNAMEK, opis);
				} catch (IOException e2) {
					e2.printStackTrace();
				}
				
			}
		});
		
		
		listCepiv.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				int index = listCepiv.getSelectedIndex();
				Cepivo cepivo = modelCepiva.getElementAt(index);
				
				textFieldSerijskaStevilka.setText(String.valueOf(cepivo.getSerijskaStevilka()));
				
				if(cepivo.getTipCepiva()!=null) {
					comboBoxTipCepiva.setEnabled(true);
					chckbxCepivaImaTip.setSelected(true);
					comboBoxTipCepiva.setSelectedItem(cepivo.getTipCepiva());
				}
				
				else
					chckbxCepivaImaTip.setSelected(false);
					comboBoxTipCepiva.setEnabled(false);
				
				if(cepivo.getVecOdmerkov()==true)
					chckbxVecOdmerkov.setSelected(true);
				else
					chckbxVecOdmerkov.setSelected(false);
				
				LocalDate date = cepivo.getRokUporabe();
				
				comboBoxDan.setSelectedIndex(date.getDayOfMonth()-1);
				comboBoxMesec.setSelectedIndex(date.getMonthValue()-1);
				comboBoxLeto.setSelectedIndex(date.getYear()-2019);
			}
		});
		
		btnNewButtonPojdiNaCepilniCenter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CardLayout c1 = (CardLayout) panelUpravljanjeCepiv.getLayout();
				c1.show(panelUpravljanjeCepiv, "2");
				
				DefaultListModel<Cepivo>modelCepivCepilniCenter = new DefaultListModel<Cepivo>();
				modelCepivCepilniCenter = modelCepiva;
				
				listVsehCepiv.setModel(modelCepivCepilniCenter);
			}
		});
		
		
		//Upravljanje ustanov
		
		btnCepilniCenterDodaj.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				CepilniCenter cepilniCenter = new CepilniCenter(textFieldCepilniCenterNaziv.getText());
				
				//System.out.println(cepilniCenter);
				
				//System.out.println(textFieldCepilniCenterNaziv.getText());
				
				//cepilniCenter.setNaziv(textFieldCepilniCenterNaziv.getText());
				
				if(chckbxCepilniCenterKraj.isSelected())
				{
					//textFieldCepilniCenterKraj.setEnabled(true);
					//textFieldCepilniCenterDrzava.setEnabled(true);
					
					Kraj kraj = new Kraj(textFieldCepilniCenterKraj.getText(), textFieldCepilniCenterDrzava.getText());
					cepilniCenter.setKraj(kraj);
				}
					
				if(chckbxCepilneCenterEmail.isSelected())
				{
					cepilniCenter.setEmail(textFieldCepilniCenterEmail.getText());
				}
				
				arrayCepilnihCentrov.add(cepilniCenter);
				modelCepilnihCentrov.addRow(new Object[]{cepilniCenter.getNaziv(),cepilniCenter.getKraj(),cepilniCenter.getEmail()});
				modelListCepilniCenter.addElement(cepilniCenter);
				//System.out.println(cepilniCenter);
			}
		});
		
		btnCepilniCenterOdstrani.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int index = tableCepilnihCentrov.getSelectedRow();
				
				modelCepilnihCentrov.removeRow(index);
				arrayCepilnihCentrov.remove(index);
				modelListCepilniCenter.remove(index);
				
				String opis="Ukinitev ustanove";
				
				try {
					belezenjeDogodkov(VrstaDogodka.OPOZORILO, opis);
				} catch (Exception e2) {
					e2.printStackTrace();
				}
				
			}
		});
		
		
		btnCepilniCenterShrani.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int index = tableCepilnihCentrov.getSelectedRow();
				
				CepilniCenter cepilniCenter = new CepilniCenter(textFieldCepilniCenterNaziv.getText());
				
				if(chckbxCepilniCenterKraj.isSelected())
				{
					Kraj kraj = new Kraj(textFieldCepilniCenterKraj.getText(), textFieldCepilniCenterDrzava.getText());
					cepilniCenter.setKraj(kraj);
				}
					
				if(chckbxCepilneCenterEmail.isSelected())
				{
					cepilniCenter.setEmail(textFieldCepilniCenterEmail.getText());
				}
				
				arrayCepilnihCentrov.set(index, cepilniCenter);
				modelListCepilniCenter.setElementAt(cepilniCenter, index);
				modelCepilnihCentrov.setValueAt(cepilniCenter.getNaziv(), index, 0);
				modelCepilnihCentrov.setValueAt(cepilniCenter.getKraj(), index, 1);
				modelCepilnihCentrov.setValueAt(cepilniCenter.getEmail(), index, 2);
				
				tableCepilnihCentrov.setModel(modelCepilnihCentrov);
			}
		});
		
		tableCepilnihCentrov.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				int index = tableCepilnihCentrov.getSelectedRow();
				
				textFieldCepilniCenterNaziv.setText(String.valueOf(modelCepilnihCentrov.getValueAt(index, 0)));
				
				CepilniCenter cepilniCenter = (CepilniCenter)arrayCepilnihCentrov.get(index);
				
				if(cepilniCenter.getKraj()!=null)
				{
					chckbxCepilniCenterKraj.setSelected(true);
					textFieldCepilniCenterKraj.setText(cepilniCenter.getKraj().getKraj());
					textFieldCepilniCenterDrzava.setText(cepilniCenter.getKraj().getDrzava());
				}
				
				else
					chckbxCepilniCenterKraj.setSelected(false);
				
				if(cepilniCenter.getEmail()!=null)
				{
					chckbxCepilneCenterEmail.setSelected(true);
					textFieldCepilniCenterEmail.setText(cepilniCenter.getEmail());
				}
				
				else
					chckbxCepilneCenterEmail.setSelected(false);
				
			}
		});
		
		//Ambulanta
		
		btnAmbulantaNova.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Kraj kraj = new Kraj(textFieldAmbulantaKraj.getText(), textFieldAmbulantaDrzava.getText());
				
				//System.out.println(textFieldAmbulantaNaziv.getText());
				String naziv = textFieldAmbulantaNaziv.getText();
				String telefonska = textFieldAmbulantaTelefonska.getText();
				
				Ambulanta ambulanta = new Ambulanta(naziv, kraj, telefonska);
				
				//System.out.println(ambulanta);
				
				//ambulanta.setNaziv(textFieldAmbulantaNaziv.getText());
				
				arrayAmbulant.add(ambulanta);
				modelAmbulant.addRow(new Object[] {ambulanta.getNaziv(),ambulanta.getKraj(),ambulanta.getTelefon()});
				
			}
		});
		
		btnAmbulantaOdstrani.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int index = tableAmbulanta.getSelectedRow();
				modelAmbulant.removeRow(index);
				arrayAmbulant.remove(index);
				
				String opis="Ukinitev ustanove";
				
				try {
					belezenjeDogodkov(VrstaDogodka.OPOZORILO, opis);
				} catch (Exception e2) {
					e2.printStackTrace();
				}
				
			}
		});
		
		btnAmbulantaShrani.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int index = tableAmbulanta.getSelectedRow();
				
				Kraj kraj = new Kraj(textFieldAmbulantaKraj.getText(), textFieldAmbulantaDrzava.getText());
				
				Ambulanta ambulanta = new Ambulanta(textFieldAmbulantaNaziv.getText(), kraj, textFieldAmbulantaTelefonska.getText());
				
				
				
				arrayAmbulant.set(index, ambulanta);
				modelCepilnihCentrov.setValueAt(ambulanta.getNaziv(), index, 0);
				modelCepilnihCentrov.setValueAt(ambulanta.getKraj(), index, 1);
				modelCepilnihCentrov.setValueAt(ambulanta.getTelefon(), index, 2);
				tableAmbulanta.setModel(modelAmbulant);
				
			}
		});
	
		tableAmbulanta.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				int index = tableAmbulanta.getSelectedRow();
				
				Ambulanta ambulanta = (Ambulanta)arrayAmbulant.get(index);
				Kraj kraj = ambulanta.getKraj();
				
				
				textFieldAmbulantaNaziv.setText(ambulanta.getNaziv());
				textFieldAmbulantaKraj.setText(kraj.getKraj());
				textFieldAmbulantaDrzava.setText(kraj.getDrzava());
				textFieldAmbulantaTelefonska.setText(ambulanta.getTelefon());
				
				
			}
		});
		
		//Cepiva v cepilnem centru
		
		btnDodajCepivoCepilniCenter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int indexCepiva = listVsehCepiv.getSelectedIndex();
				Cepivo cepivo = arrayCepiv.get(indexCepiva);
				
				
				int indexCenter = listIzbiraCepilniCenter.getSelectedIndex();
				CepilniCenter cepilniCenter = (CepilniCenter)arrayCepilnihCentrov.get(indexCenter);
				
				cepilniCenter.dodajCepivo(cepivo);
				ArrayList<Cepivo> cepivaCenter = cepilniCenter.getCepiva();
				
				
				
				modelCepivaCepilniCenter.clear();
				
				for(int i=0;i<cepilniCenter.vrniSteviloCepiv();i++)
				{
					modelCepivaCepilniCenter.addElement(cepivaCenter.get(i));
				}
				
				
				
			}
		});
		
		
		//Prevozna sredstva
		
		rdbtnAvto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				chckbxMoznostRazsiritve.setEnabled(false);
				
			}
		});
		
		rdbtnKombi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				chckbxMoznostRazsiritve.setEnabled(true);
				
			}
		});
		
		btnDodajPrevoznoSredstvo.addActionListener(new dodajVozilo());	//Notranji poslu
			
				
				
		
		btnOdstraniPrevoznoSredstvo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int index = tablePrevoznaSredstva.getSelectedRow();
				
				modelVozil.removeRow(index);
				arrayVozil.remove(index);
				
			}
		});
		
		btnShraniSpremembePrevoznaSredstva.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int index = tablePrevoznaSredstva.getSelectedRow();
				
				if(rdbtnAvto.isSelected())
				{
					
					Avto avto = new Avto(textFieldPrevoznaSrestvaNaziv.getText(), Integer.parseInt(textFieldPrevoznaSrestvaKapaciteta.getText()), textFieldPrevoznaSrestvaRegisterska.getText());
					avto.setKapaciteta(Integer.parseInt(textFieldPrevoznaSrestvaKapaciteta.getText()));
					
					if(chckbxImaTipCepiva.isSelected())
					{
						
						int index1 = comboBoxTipov.getSelectedIndex();
						avto.setTipCepiva(modelTipCepiv.getElementAt(index1));
					}
					
					avto.setZnamka(textFieldPrevoznaSrestvaZnamka.getText());
					
					//moznosti razsiritve ni
					
					//System.out.println(modelVozil.getColumnCount());
					
					arrayVozil.set(index, avto);
					
					modelVozil.setValueAt("Avto", index, 0);
					modelVozil.setValueAt(avto.getZnamka(), index, 1);
					modelVozil.setValueAt(avto.getNaziv(), index, 2);
					modelVozil.setValueAt(avto.getRegistrskaStevilka(), index, 3);
					modelVozil.setValueAt(avto.getTipCepiva(), index, 4);
					modelVozil.setValueAt("/", index, 5);
					modelVozil.setValueAt(avto.getKapaciteta(), index, 6);
					
					
				}
				
				else if(rdbtnKombi.isSelected())
				{
					
					boolean razsiritev;
					String moznost;
					
					if(chckbxMoznostRazsiritve.isSelected())
					{
						razsiritev=true;
						moznost="Da";
					}
						
					else 
					{
						razsiritev=false;
						moznost="Ne";
					}
						
					
					
					Kombi kombi = new Kombi(textFieldPrevoznaSrestvaNaziv.getText(),Integer.parseInt(textFieldPrevoznaSrestvaKapaciteta.getText()) , textFieldPrevoznaSrestvaRegisterska.getText() , razsiritev);
					
					if(chckbxImaTipCepiva.isSelected())
					{
						
						int index2 = comboBoxTipov.getSelectedIndex();
						kombi.setTipCepiva(modelTipCepiv.getElementAt(index2));
						
					}
					
					kombi.setZnamka(textFieldPrevoznaSrestvaZnamka.getText());
					
					arrayVozil.set(index, kombi);
					modelVozil.setValueAt("Kombi", index, 0);
					modelVozil.setValueAt(kombi.getZnamka(), index, 1);
					modelVozil.setValueAt(kombi.getNaziv(), index, 2);
					modelVozil.setValueAt(kombi.getRegistrskaStevilka(), index, 3);
					modelVozil.setValueAt(kombi.getTipCepiva(), index, 4);
					modelVozil.setValueAt(moznost, index, 5);
					modelVozil.setValueAt(kombi.getKapaciteta(), index, 6);
				}
			}
					});
				
				tablePrevoznaSredstva.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						
						int index = tablePrevoznaSredstva.getSelectedRow();
						
						//System.out.println("Delam");
						
						
						if(modelVozil.getValueAt(index, 0)=="Avto")
						{
							
							//System.out.println("Delam");
							
							rdbtnAvto.setSelected(true);
							textFieldPrevoznaSrestvaZnamka.setText(arrayVozil.get(index).getZnamka());
							textFieldPrevoznaSrestvaNaziv.setText(arrayVozil.get(index).getNaziv());
							textFieldPrevoznaSrestvaRegisterska.setText(arrayVozil.get(index).getRegistrskaStevilka());
							textFieldPrevoznaSrestvaKapaciteta.setText((String.valueOf(arrayVozil.get(index).getKapaciteta())));
							
							if(modelVozil.getValueAt(index, 4)=="")
								chckbxImaTipCepiva.setSelected(false);
							else
							{
								chckbxImaTipCepiva.setSelected(true);
								comboBoxTipov.setSelectedItem(modelVozil.getValueAt(index, 4));
							}
							
								comboBoxTipov.setEnabled(false);
								chckbxMoznostRazsiritve.setSelected(false);
							
							
						}
						
						else if(arrayVozil.get(index) instanceof Kombi)
						{
							
							rdbtnKombi.setSelected(true);
							textFieldPrevoznaSrestvaZnamka.setText(arrayVozil.get(index).getZnamka());
							textFieldPrevoznaSrestvaNaziv.setText(arrayVozil.get(index).getNaziv());
							textFieldPrevoznaSrestvaRegisterska.setText(arrayVozil.get(index).getRegistrskaStevilka());
							textFieldPrevoznaSrestvaKapaciteta.setText((String.valueOf(arrayVozil.get(index).getKapaciteta())));
							
							if(modelVozil.getValueAt(index, 4)=="")
								chckbxImaTipCepiva.setSelected(false);
							else
							{
								chckbxImaTipCepiva.setSelected(true);
								comboBoxTipov.setSelectedItem(modelVozil.getValueAt(index, 4));
							}
							
							if(modelVozil.getValueAt(index, 5)=="Da")
								chckbxMoznostRazsiritve.setSelected(true);
							else
								chckbxMoznostRazsiritve.setSelected(false);
						}
						
					}
					
			});
		
				tableLogistikaVozila.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						
						int index = tableLogistikaVozila.getSelectedRow();
						
						textAreaCepivVVozilu.setText(arrayVozil.get(index).toString());
						
					}
				});
				
				btnLogistikaNatovoriCepiva.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						
						int index = tableLogistikaCep.getSelectedRow();
						int indexAvto = tableLogistikaVozila.getSelectedRow();
						
						if(arrayVozil.get(indexAvto) instanceof Avto)
						{
							try {
								CepilniCenter center = (CepilniCenter)arrayCepilnihCentrov.get(index);
								System.out.println(center.prevzamiCepiva(arrayVozil.get(indexAvto)));		
								} 
								catch (KapacitetaPresezenaException a) {
									a.printStackTrace();
									
									String opis="Kapaciteta presezena";
									
									try {
										belezenjeDogodkov(VrstaDogodka.NAPAKA, opis);
									} catch (IOException e2) {
										e2.printStackTrace();
									}
									
								}
							
								catch (TipCepivaException a) {
									a.printStackTrace();
									
									String opis="Napacen tip cepiva";
									
									try {
										belezenjeDogodkov(VrstaDogodka.OPOZORILO, opis);
									} catch (IOException e2) {
										e2.printStackTrace();
									}
									
								}
						}
						
						else if(arrayVozil.get(indexAvto) instanceof Kombi)
						{
							
							try {
								CepilniCenter center = (CepilniCenter)arrayCepilnihCentrov.get(index);
								System.out.println(center.prevzamiCepiva(arrayVozil.get(indexAvto)));
								} 
								catch (KapacitetaPresezenaException a) {
									a.printStackTrace();
									
									String opis="Kapaciteta presezena";
									
									try {
										belezenjeDogodkov(VrstaDogodka.NAPAKA, opis);
									} catch (IOException e2) {
										e2.printStackTrace();
									}
									
								}
								catch (TipCepivaException a) {
									a.printStackTrace();
									
									String opis="Napacen tip cepiva";
									
									try {
										belezenjeDogodkov(VrstaDogodka.NAPAKA, opis);
									} catch (IOException e2) {
										e2.printStackTrace();
									}
									
								}
							
						}
						
						
					}
				});
		
				btnLogistikaRaztovoriCepiva.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						
						int index = tableLogistikaAmb.getSelectedRow();
						int indexAvto = tableLogistikaVozila.getSelectedRow();
						
						try {
							Ambulanta ambulanta = (Ambulanta)arrayAmbulant.get(index);
							System.out.println(ambulanta.prevzamiCepiva(arrayVozil.get(indexAvto)));
						} catch (CepivoNeuporabnoException a) {
							a.printStackTrace();
							
							String opis="Cepivno ni vec uporabno";
							
							try {
								belezenjeDogodkov(VrstaDogodka.KRITICNO, opis);
							} catch (IOException e2) {
								e2.printStackTrace();
							}
							
						}
						
					}
				});
				
				listIzbiraCepilniCenter.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						
						modelCepivaCepilniCenter.clear();
						
						int indexCepiva = listVsehCepiv.getSelectedIndex();
						Cepivo cepivo = arrayCepiv.get(indexCepiva);
						
						
						int indexCenter = listIzbiraCepilniCenter.getSelectedIndex();
						CepilniCenter cepilniCenter = (CepilniCenter)arrayCepilnihCentrov.get(indexCenter);
						
						//cepilniCenter.dodajCepivo(cepivo);
						
					}
				});
				
				btnOdstraniCepivoCepilniCenter.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						
						int indexCenter = listIzbiraCepilniCenter.getSelectedIndex();
						CepilniCenter cepilniCenter = (CepilniCenter)arrayCepilnihCentrov.get(indexCenter);
						
						ArrayList<Cepivo> cepivaCentra = cepilniCenter.getCepiva();
						
						int indexCepivaCep = listCepivCepilniCenter.getSelectedIndex();
						Cepivo cepivo = cepivaCentra.get(indexCepivaCep);
						
						cepilniCenter.odstraniCepivo(cepivo);
						modelCepivaCepilniCenter.remove(indexCepivaCep);
						
					}
				});
			
				//Zapisovanje in shranjevanje!!!
				
				frmUpravljanjeCepilnihStoritev.addWindowListener(new WindowAdapter() {
					@Override
					public void windowClosing(WindowEvent e) {
						
						ObjectOutputStream pisiCepiva = null;
						ObjectOutputStream pisiCentre = null;
						ObjectOutputStream pisiAmbulante = null;
						ObjectOutputStream pisiPrevoznaSredstva = null;
						
						try {
							
							pisiCepiva = new ObjectOutputStream(new GZIPOutputStream(new FileOutputStream("cepiva.ser")));
							pisiCentre = new ObjectOutputStream(new GZIPOutputStream(new FileOutputStream("center.ser")));
							pisiAmbulante = new ObjectOutputStream(new GZIPOutputStream(new FileOutputStream("ambulanta.ser")));
							pisiPrevoznaSredstva = new ObjectOutputStream(new GZIPOutputStream(new FileOutputStream("vozila.ser")));

							//System.out.println(arrayCepiv);
							System.out.println(arrayCepilnihCentrov);
							System.out.println(arrayAmbulant);
							
							
							pisiCepiva.writeObject(arrayCepiv);
							pisiCentre.writeObject(arrayCepilnihCentrov);
							pisiAmbulante.writeObject(arrayAmbulant);
							pisiPrevoznaSredstva.writeObject(arrayVozil);
							
						} catch (IOException e2) {
							e2.printStackTrace();
						}
						
						//flushaj in closaj posebaj zaradi napak
						
						finally
						{
							
							try {
								pisiCepiva.flush();
								
							} catch (IOException e3) {
								e3.printStackTrace();
							}
							
							try {
								pisiCentre.flush();
								
							} catch (IOException e3) {
								e3.printStackTrace();
							}
							
							try {
								pisiAmbulante.flush();
								
							} catch (IOException e3) {
								e3.printStackTrace();
							}
							
							try {
								pisiPrevoznaSredstva.flush();
							} catch (Exception e3) {
								e3.printStackTrace();
							}
							
							try {
								pisiCepiva.close();
								
							} catch (IOException e3) {
								e3.printStackTrace();
							}
							
							try {
								pisiCentre.close();
								
							} catch (IOException e3) {
								e3.printStackTrace();
							}
							
							
							
							try {
								pisiAmbulante.close();
								
							} catch (IOException e3) {
								e3.printStackTrace();
							}
							
							
							
							try {
								pisiPrevoznaSredstva.close();
							} catch (IOException e3) {
								e3.printStackTrace();
							}
							
						}
						
					}
					
				
				
					@Override
					public void windowActivated(WindowEvent e) {
						
						ObjectInputStream beriCepiva = null;
						ObjectInputStream beriCentre = null;
						ObjectInputStream beriAmbulante = null;
						ObjectInputStream beriPrevoznaSredstva = null;
						
						try {
							
							beriCepiva = new ObjectInputStream(new GZIPInputStream(new FileInputStream("cepiva.ser")));
							beriCentre = new ObjectInputStream(new GZIPInputStream(new FileInputStream("center.ser")));
							beriAmbulante = new ObjectInputStream(new GZIPInputStream(new FileInputStream("ambulanta.ser")));
							beriPrevoznaSredstva = new ObjectInputStream(new GZIPInputStream(new FileInputStream("vozila.ser")));
							
							arrayCepiv = (ArrayList<Cepivo>)beriCepiva.readObject();
							arrayCepilnihCentrov = (ArrayList<Ustanova>)beriCentre.readObject();
							arrayAmbulant = (ArrayList<Ustanova>)beriAmbulante.readObject();
							arrayVozil = (ArrayList<PrevoznoSredstvo>)beriPrevoznaSredstva.readObject();
						
							//System.out.println(arrayCepiv);
							System.out.println(arrayAmbulant);
							
							System.out.println(arrayCepilnihCentrov);
							
							Collections.sort(arrayCepiv);
							Collections.sort(arrayCepilnihCentrov);
							Collections.sort(arrayAmbulant);
							Collections.sort(arrayVozil);
							
							//System.out.println(arrayCepilnihCentrov);
							
							for(int i = 0;i<arrayCepiv.size();i++)
							{
								modelCepiva.addElement(arrayCepiv.get(i));
							}
							
							for(int i = 0;i<arrayCepilnihCentrov.size();i++)
							{
								//Ustanova ustanova = arrayCepilnihCentrov.get(i);
								//System.out.println(ustanova + "ja");
								CepilniCenter cepilniCenter = (CepilniCenter)arrayCepilnihCentrov.get(i);
								modelCepilnihCentrov.addRow(new Object[]{cepilniCenter.getNaziv(),cepilniCenter.getKraj(),cepilniCenter.getEmail()});
								modelListCepilniCenter.addElement(cepilniCenter);
							}
							
							for(int i = 0;i<arrayAmbulant.size();i++)
							{
								Ambulanta ambulanta = (Ambulanta)arrayAmbulant.get(i);
								//System.out.println(ambulanta);
								modelAmbulant.addRow(new Object[]{ambulanta.getNaziv(),ambulanta.getKraj(),ambulanta.getTelefon()});
							}
							
							for(int i = 0;i<arrayVozil.size();i++)
							{
								
								if(arrayVozil.get(i) instanceof Avto)
								{
									Avto avto = (Avto)arrayVozil.get(i);
									modelVozil.addRow(new Object[]{"Avto",avto.getZnamka(),avto.getNaziv(),avto.getRegistrskaStevilka(),avto.getTipCepiva(),"/",avto.getKapaciteta()});

								}
								else if(arrayVozil.get(i) instanceof Kombi)
								{
									Kombi kombi = (Kombi)arrayVozil.get(i);
									String moznost;
									
									if(kombi.isMoznostRazsiritve())moznost="DA";
									else moznost="NE";
									
									modelVozil.addRow(new Object[]{"Kombi",kombi.getZnamka(),kombi.getNaziv(),kombi.getRegistrskaStevilka(),kombi.getTipCepiva(),moznost,kombi.getKapaciteta()});

								}
							}
							
						} catch (IOException e1) {
							e1.printStackTrace();
						}
						
						catch (ClassNotFoundException e2)
						{
							e2.printStackTrace();
						}
						
						//Zapri posebaj zaradi napak
						
						finally {
							
							try {
								
								beriCepiva.close();
								
							} catch (IOException e2) {
								
								e2.printStackTrace();
								
							}
							
							try {
								
								beriCentre.close();
								
							} catch (IOException e3) {
								// TODO: handle exception
							}
							
							try {
								
								beriAmbulante.close();
								
							} catch (IOException e3) {
								// TODO: handle exception
							}
							
							try {
								
								beriPrevoznaSredstva.close();
								
							} catch (IOException e3) {
								// TODO: handle exception
							}
							
						}
						
					}
				});			
				
				//btnOdstraniCepivo.addActionListener(new odstraniCepivoListener(listCepiv, arrayCepiv, modelCepiva));
				//System.out.println(arrayCepiv);
	}
	
	public class dodajVozilo implements ActionListener
	{
		
		
		@Override
		public void actionPerformed(ActionEvent e) {
			

			if(rdbtnAvto.isSelected())
			{
				
				Avto avto = new Avto(textFieldPrevoznaSrestvaNaziv.getText(), Integer.parseInt(textFieldPrevoznaSrestvaKapaciteta.getText()), textFieldPrevoznaSrestvaRegisterska.getText());
				avto.setKapaciteta(Integer.parseInt(textFieldPrevoznaSrestvaKapaciteta.getText()));
				
				if(chckbxImaTipCepiva.isSelected())
				{
					
					int index = comboBoxTipov.getSelectedIndex();
					avto.setTipCepiva(modelTipCepiv.getElementAt(index));
				}
				
				avto.setZnamka(textFieldPrevoznaSrestvaZnamka.getText());
				
				//moznosti razsiritve ni
				
				arrayVozil.add(avto);
				modelVozil.addRow(new Object[]{"Avto",avto.getZnamka(),avto.getNaziv(),avto.getRegistrskaStevilka(),avto.getTipCepiva(),"/",avto.getKapaciteta()});
				
			}
			
			else if(rdbtnKombi.isSelected())
			{
				
				boolean razsiritev;
				String moznost;
				
				if(chckbxMoznostRazsiritve.isSelected())
				{
					razsiritev=true;
					moznost="Da";
				}
					
				else 
				{
					razsiritev=false;
					moznost="Ne";
				}
					
				
				
				Kombi kombi = new Kombi(textFieldPrevoznaSrestvaNaziv.getText(),Integer.parseInt(textFieldPrevoznaSrestvaKapaciteta.getText()) , textFieldPrevoznaSrestvaRegisterska.getText() , razsiritev);
				
				if(chckbxImaTipCepiva.isSelected())
				{
					
					int index = comboBoxTipov.getSelectedIndex();
					kombi.setTipCepiva(modelTipCepiv.getElementAt(index));
					
				}
				
				kombi.setZnamka(textFieldPrevoznaSrestvaZnamka.getText());
				
				arrayVozil.add(kombi);
				modelVozil.addRow(new Object[]{"Kombi",kombi.getZnamka(),kombi.getNaziv(),kombi.getRegistrskaStevilka(),kombi.getTipCepiva(),moznost,kombi.getKapaciteta()});
			}
			
		}
			
		}
		
	
	
	public void belezenjeDogodkov(VrstaDogodka dogodek, String opisDogodka) throws IOException
	{
		
		DateTimeFormatter formatCasa = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
		
		LocalDateTime cas = LocalDateTime.now();
		String zapisCasa = cas.format(formatCasa);
		
		FileWriter pisi = null;
		
		try {
			pisi = new FileWriter("log.txt",true);
			pisi.write(zapisCasa + " " + opisDogodka + " " + dogodek + "\n");
		} catch (IOException e) {
			e.printStackTrace();
		}
		finally {
			pisi.close();
		}
	}
	
	}
	



