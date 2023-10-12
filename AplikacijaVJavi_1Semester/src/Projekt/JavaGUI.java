package Projekt;

import java.awt.List;
import java.awt.Toolkit;
import java.io.File;
import java.io.FileFilter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.DatabaseMetaData;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.DefaultCellEditor;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.ListModel;
import javax.swing.RowSorter;
import javax.swing.SortOrder;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.*;

/**
 *
 * @author Gregor
 */
public class JavaGUI extends javax.swing.JFrame {

    /**
     * Creates new form JavaGUI
     */
    Scanner stdin = new Scanner(System.in);
    int stevec = 0, N = 100;

    boolean TabelaSeznam = false;         //Preverjanje ali okno za urejanje izvajama iz 2. ali 3. taba
    boolean TabelaRedovalnica = false;

    boolean ComboBoxVariacija = false;    //false=Ocene semestrov, true=Ocene obveznosti

    Predmeti[] polje = new Predmeti[N];    //Polje objektov

    String ImeDatoteke = null;            //Izbrana datoteka za shranjevanje

    
    
    
    public JavaGUI() {                                  //Nastavitve ob zagonu
        initComponents();
        this.setLocationRelativeTo(null);
        SetIcon();

        jTabbedPane.setEnabledAt(1, false);
        jTabbedPane.setEnabledAt(2, false);
        jTabbedPane.setEnabledAt(3, false);

        //jTableRedovalnica.setFocusable(false);
        //jTableRedovalnica.setCellSelectionEnabled(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroupLetnik = new javax.swing.ButtonGroup();
        jDialogUrejanje = new javax.swing.JDialog();
        jPanelDialog = new javax.swing.JPanel();
        jLabelID = new javax.swing.JLabel();
        jTextFieldECTS = new javax.swing.JTextField();
        jLabelLetnik = new javax.swing.JLabel();
        jLabelImeNosilca = new javax.swing.JLabel();
        jLabelImePredmeta = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTableUrejanje = new javax.swing.JTable();
        jLabelECTS = new javax.swing.JLabel();
        jTextFieldID = new javax.swing.JTextField();
        jTextFieldImePredmeta = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jTextFieldImeNosilca = new javax.swing.JTextField();
        jButtonOdstraniObveznostTabbela = new javax.swing.JButton();
        jButtonDodajObveznostTabela = new javax.swing.JButton();
        jLabelOcenaPredmeta = new javax.swing.JLabel();
        jSliderLetnikUrejanje = new javax.swing.JSlider();
        jTextFieldOcena = new javax.swing.JTextField();
        jComboBoxSemester = new javax.swing.JComboBox<>();
        jToggleButtonShraniSpremembe = new javax.swing.JToggleButton();
        jTextFieldZaokrozenaOcena = new javax.swing.JTextField();
        jLabelPredmetOpravljen = new javax.swing.JLabel();
        jCheckBoxPredmetOpravljen = new javax.swing.JCheckBox();
        jButtonGor = new javax.swing.JButton();
        jButtonDol = new javax.swing.JButton();
        buttonGroupSeznamSemester = new javax.swing.ButtonGroup();
        buttonGroupRedovalnicaSemester = new javax.swing.ButtonGroup();
        jFileChooser = new javax.swing.JFileChooser();
        jTabbedPane = new javax.swing.JTabbedPane();
        jPanelDatoteka = new javax.swing.JPanel();
        jButtonIzberiDatoteko = new javax.swing.JButton();
        jButtonNovaDatoteka = new javax.swing.JButton();
        jButtonUvoziDatoteko = new javax.swing.JButton();
        jButtonNaloziIzbranoDatoteko = new javax.swing.JButton();
        jLabelLogo = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTextAreaAbout = new javax.swing.JTextArea();
        jPanelSeznam = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jListPredmetov = new javax.swing.JList<>();
        jButtonUredi = new javax.swing.JButton();
        jButtonDodajPredmet = new javax.swing.JButton();
        jButtonOdstraniPredmet = new javax.swing.JButton();
        jButtonShrani = new javax.swing.JButton();
        jButtonSeznamGor = new javax.swing.JButton();
        jButtonSeznamDol = new javax.swing.JButton();
        jCheckBoxSeznamFiltriranje = new javax.swing.JCheckBox();
        jPanelSeznamFiltriranje = new javax.swing.JPanel();
        jLabelLetnikSeznam = new javax.swing.JLabel();
        jSliderLetnikFilter = new javax.swing.JSlider();
        jLabelSeznamSemester = new javax.swing.JLabel();
        jRadioButtonSeznamSemesterOba = new javax.swing.JRadioButton();
        jRadioButtonSeznamSemesterZimski = new javax.swing.JRadioButton();
        jRadioButtonSeznamSemesterPoletni = new javax.swing.JRadioButton();
        jPanelRedovalnica = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTableRedovalnica = new javax.swing.JTable();
        jComboBoxRedovalnica = new javax.swing.JComboBox<>();
        jLabelPredmeti = new javax.swing.JLabel();
        jPanelDinamicna = new javax.swing.JPanel();
        jPanelUrediOcene = new javax.swing.JPanel();
        jButtonRedovalnicaUredi = new javax.swing.JButton();
        jPanelRedovalnicaSemester = new javax.swing.JPanel();
        jRadioButtonSemesterOba = new javax.swing.JRadioButton();
        jRadioButtonSemesterZimski = new javax.swing.JRadioButton();
        jRadioButtonSemesterPoletni = new javax.swing.JRadioButton();
        jPanelRedovalnicaPredmetOpravljen = new javax.swing.JPanel();
        jSliderRedovalnicaPredmetOpravljen = new javax.swing.JSlider();
        jLabelRedovalnicaSlider1 = new javax.swing.JLabel();
        jLabelRedovalnicaSlider2 = new javax.swing.JLabel();
        jLabelRedovalnicaSlider3 = new javax.swing.JLabel();
        jButtonRedovalnicaSortOcene = new javax.swing.JButton();
        jButtonRedovalnicaReset = new javax.swing.JButton();
        jPanelDoloceneObveznosti = new javax.swing.JPanel();
        jButtonRedovalnicaSortOceneObveznosti = new javax.swing.JButton();
        jButtonRedovalnicaUrediObveznosti = new javax.swing.JButton();
        jButtonRedovalnicaResetObveznosti = new javax.swing.JButton();
        jLabelIzpisObveznosti = new javax.swing.JLabel();
        jToggleButtonRedovalnica = new javax.swing.JToggleButton();
        jTextFieldRedovalnicaPodTabelo = new javax.swing.JTextField();
        jLabelRedovalnicaPodTabelo = new javax.swing.JLabel();
        jLabelDinamicniComboBox = new javax.swing.JLabel();
        jTextFieldRedovalnicaNajboljsaOcena = new javax.swing.JTextField();
        jLabelRedovalnicaBestOcena = new javax.swing.JLabel();
        jCheckBoxRedovalnicaLetnikOpravljen = new javax.swing.JCheckBox();
        jTextFieldPridobljenECTS = new javax.swing.JTextField();
        jLabelRedovalnicaPridobljenECTS = new javax.swing.JLabel();
        jPanelPovprecnaOcenaIzbraneObveznosti = new javax.swing.JPanel();
        jComboBoxIzbiraObveznosti = new javax.swing.JComboBox<>();
        jTextFieldPovprecnaOcenaObveznosti = new javax.swing.JTextField();
        jLabelPovprecnaOcenaObveznosti = new javax.swing.JLabel();
        jLabelObveznostPovprecnaOcena = new javax.swing.JLabel();

        jDialogUrejanje.setTitle("Urejanje");
        jDialogUrejanje.setAlwaysOnTop(true);
        jDialogUrejanje.setBounds(new java.awt.Rectangle(0, 0, 0, 0));
        jDialogUrejanje.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jDialogUrejanje.setModalityType(java.awt.Dialog.ModalityType.APPLICATION_MODAL);
        jDialogUrejanje.setName("Urejanje"); // NOI18N
        jDialogUrejanje.setResizable(false);

        jLabelID.setText("ID:");

        jLabelLetnik.setText("Letnik:");

        jLabelImeNosilca.setText("Ime nosilca:");

        jLabelImePredmeta.setText("Ime predmeta:");

        jTableUrejanje.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Obveznosti", "Teža predmetov", "Ocene", "Vrsta obveznosti"
            }
        ));
        jScrollPane2.setViewportView(jTableUrejanje);
        if (jTableUrejanje.getColumnModel().getColumnCount() > 0) {
            jTableUrejanje.getColumnModel().getColumn(0).setResizable(false);
            jTableUrejanje.getColumnModel().getColumn(1).setResizable(false);
            jTableUrejanje.getColumnModel().getColumn(2).setResizable(false);
            jTableUrejanje.getColumnModel().getColumn(3).setResizable(false);
        }

        jLabelECTS.setText("ECTS:");

        jLabel3.setText("Semester");

        jButtonOdstraniObveznostTabbela.setText("Odstrani obveznost");
        jButtonOdstraniObveznostTabbela.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonOdstraniObveznostTabbelaActionPerformed(evt);
            }
        });

        jButtonDodajObveznostTabela.setText("Dodaj obveznost");
        jButtonDodajObveznostTabela.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDodajObveznostTabelaActionPerformed(evt);
            }
        });

        jLabelOcenaPredmeta.setText("Ocena predmeta:");

        jSliderLetnikUrejanje.setMajorTickSpacing(1);
        jSliderLetnikUrejanje.setMaximum(3);
        jSliderLetnikUrejanje.setMinimum(1);
        jSliderLetnikUrejanje.setPaintLabels(true);
        jSliderLetnikUrejanje.setPaintTicks(true);
        jSliderLetnikUrejanje.setSnapToTicks(true);

        jTextFieldOcena.setEditable(false);

        jComboBoxSemester.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Zimski", "Poletni" }));
        jComboBoxSemester.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxSemesterActionPerformed(evt);
            }
        });

        jToggleButtonShraniSpremembe.setText("Shrani spremembe");
        jToggleButtonShraniSpremembe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButtonShraniSpremembeActionPerformed(evt);
            }
        });

        jTextFieldZaokrozenaOcena.setEditable(false);

        jLabelPredmetOpravljen.setText("Predmet opravljen:");

        jCheckBoxPredmetOpravljen.setEnabled(false);
        jCheckBoxPredmetOpravljen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBoxPredmetOpravljenActionPerformed(evt);
            }
        });

        jButtonGor.setText("Gor");
        jButtonGor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonGorActionPerformed(evt);
            }
        });

        jButtonDol.setText("Dol");
        jButtonDol.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDolActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelDialogLayout = new javax.swing.GroupLayout(jPanelDialog);
        jPanelDialog.setLayout(jPanelDialogLayout);
        jPanelDialogLayout.setHorizontalGroup(
            jPanelDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelDialogLayout.createSequentialGroup()
                .addGroup(jPanelDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanelDialogLayout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addGroup(jPanelDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanelDialogLayout.createSequentialGroup()
                                .addGap(11, 11, 11)
                                .addComponent(jLabelID))
                            .addGroup(jPanelDialogLayout.createSequentialGroup()
                                .addGroup(jPanelDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabelOcenaPredmeta)
                                    .addComponent(jLabelPredmetOpravljen))
                                .addGap(18, 18, 18)
                                .addGroup(jPanelDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jCheckBoxPredmetOpravljen)
                                    .addComponent(jTextFieldZaokrozenaOcena, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextFieldOcena, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanelDialogLayout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addGroup(jPanelDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelImePredmeta)
                            .addComponent(jLabel3)
                            .addComponent(jLabelImeNosilca)
                            .addComponent(jLabelECTS)
                            .addComponent(jLabelLetnik))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanelDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextFieldID, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanelDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jTextFieldImePredmeta, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jTextFieldECTS, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 149, Short.MAX_VALUE)
                                .addComponent(jSliderLetnikUrejanje, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                .addComponent(jTextFieldImeNosilca, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jComboBoxSemester, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 59, Short.MAX_VALUE)
                .addGroup(jPanelDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelDialogLayout.createSequentialGroup()
                        .addComponent(jButtonOdstraniObveznostTabbela)
                        .addGap(19, 19, 19)
                        .addGroup(jPanelDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jToggleButtonShraniSpremembe, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButtonDodajObveznostTabela, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelDialogLayout.createSequentialGroup()
                        .addGroup(jPanelDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jButtonGor)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanelDialogLayout.createSequentialGroup()
                                .addGap(2, 2, 2)
                                .addComponent(jButtonDol)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(19, 19, 19))
        );
        jPanelDialogLayout.setVerticalGroup(
            jPanelDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelDialogLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanelDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelDialogLayout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 303, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanelDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButtonOdstraniObveznostTabbela)
                            .addComponent(jButtonDodajObveznostTabela))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanelDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jToggleButtonShraniSpremembe)
                            .addComponent(jLabelPredmetOpravljen)))
                    .addGroup(jPanelDialogLayout.createSequentialGroup()
                        .addGroup(jPanelDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextFieldID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelID))
                        .addGap(18, 18, 18)
                        .addGroup(jPanelDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelImePredmeta)
                            .addComponent(jTextFieldImePredmeta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButtonGor))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanelDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelLetnik)
                            .addComponent(jSliderLetnikUrejanje, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanelDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(jComboBoxSemester, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanelDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelImeNosilca)
                            .addComponent(jTextFieldImeNosilca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanelDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelECTS)
                            .addComponent(jTextFieldECTS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButtonDol))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanelDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelOcenaPredmeta)
                            .addComponent(jTextFieldOcena, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextFieldZaokrozenaOcena, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jCheckBoxPredmetOpravljen)))
                .addContainerGap())
        );

        javax.swing.GroupLayout jDialogUrejanjeLayout = new javax.swing.GroupLayout(jDialogUrejanje.getContentPane());
        jDialogUrejanje.getContentPane().setLayout(jDialogUrejanjeLayout);
        jDialogUrejanjeLayout.setHorizontalGroup(
            jDialogUrejanjeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelDialog, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jDialogUrejanjeLayout.setVerticalGroup(
            jDialogUrejanjeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelDialog, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jFileChooser.setDialogTitle("");
        jFileChooser.setFileFilter(null);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Moja evidenca");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setResizable(false);

        jPanelDatoteka.setMaximumSize(new java.awt.Dimension(125, 80));
        jPanelDatoteka.setPreferredSize(new java.awt.Dimension(944, 637));

        jButtonIzberiDatoteko.setBackground(new java.awt.Color(51, 51, 255));
        jButtonIzberiDatoteko.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jButtonIzberiDatoteko.setText("Naloži privzeto datoteko(datoteka.dat)");
        jButtonIzberiDatoteko.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonIzberiDatotekoActionPerformed(evt);
            }
        });

        jButtonNovaDatoteka.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jButtonNovaDatoteka.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Slike/Dodaj.png"))); // NOI18N
        jButtonNovaDatoteka.setText("Nova datoteka");
        jButtonNovaDatoteka.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        jButtonNovaDatoteka.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonNovaDatotekaActionPerformed(evt);
            }
        });

        jButtonUvoziDatoteko.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jButtonUvoziDatoteko.setText("Izberi datoteko");
        jButtonUvoziDatoteko.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonUvoziDatotekoActionPerformed(evt);
            }
        });

        jButtonNaloziIzbranoDatoteko.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jButtonNaloziIzbranoDatoteko.setText("Naloži izbrano datoteko");
        jButtonNaloziIzbranoDatoteko.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonNaloziIzbranoDatotekoActionPerformed(evt);
            }
        });

        jLabelLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Slike/ferilogo.png"))); // NOI18N
        jLabelLogo.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jTextAreaAbout.setEditable(false);
        jTextAreaAbout.setColumns(20);
        jTextAreaAbout.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jTextAreaAbout.setRows(5);
        jTextAreaAbout.setText("Projektna naloga\n\nNaslov: Moja evidenca\nPredmet: Programiranje za telekomunikacije\n\nProfesorica predmeta: izr. prof. dr. MIRJAM SEPESY MAUČEC \nAsistent predmeta: doc. dr. Damjan Vlaj\n\n\n\n\n\n\n\n\n\nAvtor: Gregor Fras");
        jTextAreaAbout.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jTextAreaAbout.setFocusable(false);
        jScrollPane4.setViewportView(jTextAreaAbout);

        javax.swing.GroupLayout jPanelDatotekaLayout = new javax.swing.GroupLayout(jPanelDatoteka);
        jPanelDatoteka.setLayout(jPanelDatotekaLayout);
        jPanelDatotekaLayout.setHorizontalGroup(
            jPanelDatotekaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelDatotekaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelDatotekaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelDatotekaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanelDatotekaLayout.createSequentialGroup()
                            .addComponent(jButtonUvoziDatoteko, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jButtonNaloziIzbranoDatoteko, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addComponent(jButtonNovaDatoteka, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jButtonIzberiDatoteko, javax.swing.GroupLayout.PREFERRED_SIZE, 430, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanelDatotekaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanelDatotekaLayout.createSequentialGroup()
                        .addGap(231, 231, 231)
                        .addComponent(jLabelLogo))
                    .addGroup(jPanelDatotekaLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane4)))
                .addGap(234, 234, 234))
        );
        jPanelDatotekaLayout.setVerticalGroup(
            jPanelDatotekaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelDatotekaLayout.createSequentialGroup()
                .addGroup(jPanelDatotekaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanelDatotekaLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabelLogo)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 334, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanelDatotekaLayout.createSequentialGroup()
                        .addGap(122, 122, 122)
                        .addComponent(jButtonIzberiDatoteko, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanelDatotekaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButtonNaloziIzbranoDatoteko, javax.swing.GroupLayout.DEFAULT_SIZE, 151, Short.MAX_VALUE)
                            .addComponent(jButtonUvoziDatoteko, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonNovaDatoteka, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(89, 89, 89))
        );

        jTabbedPane.addTab("Datoteka", jPanelDatoteka);

        jListPredmetov.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jListPredmetov.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jScrollPane1.setViewportView(jListPredmetov);

        jButtonUredi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Slike/EditFile.png"))); // NOI18N
        jButtonUredi.setText("Uredi");
        jButtonUredi.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        jButtonUredi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonUrediActionPerformed(evt);
            }
        });

        jButtonDodajPredmet.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Slike/Plus.png"))); // NOI18N
        jButtonDodajPredmet.setText("Dodaj predmet");
        jButtonDodajPredmet.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jButtonDodajPredmet.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        jButtonDodajPredmet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDodajPredmetActionPerformed(evt);
            }
        });

        jButtonOdstraniPredmet.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Slike/Minus.png"))); // NOI18N
        jButtonOdstraniPredmet.setText("Odstrani predmet");
        jButtonOdstraniPredmet.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jButtonOdstraniPredmet.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        jButtonOdstraniPredmet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonOdstraniPredmetActionPerformed(evt);
            }
        });

        jButtonShrani.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Slike/Save.png"))); // NOI18N
        jButtonShrani.setText("Shrani");
        jButtonShrani.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        jButtonShrani.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonShraniActionPerformed(evt);
            }
        });

        jButtonSeznamGor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Slike/UpArrow.png"))); // NOI18N
        jButtonSeznamGor.setText("Gor");
        jButtonSeznamGor.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jButtonSeznamGor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSeznamGorActionPerformed(evt);
            }
        });

        jButtonSeznamDol.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Slike/DownArrow.png"))); // NOI18N
        jButtonSeznamDol.setText("Dol");
        jButtonSeznamDol.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSeznamDolActionPerformed(evt);
            }
        });

        jCheckBoxSeznamFiltriranje.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jCheckBoxSeznamFiltriranje.setText("Vklopi filtriranje");
        jCheckBoxSeznamFiltriranje.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBoxSeznamFiltriranjeActionPerformed(evt);
            }
        });

        jPanelSeznamFiltriranje.setBorder(javax.swing.BorderFactory.createTitledBorder("Filtriranje"));
        jPanelSeznamFiltriranje.setEnabled(false);

        jLabelLetnikSeznam.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabelLetnikSeznam.setText("Letnik:");
        jLabelLetnikSeznam.setEnabled(false);

        jSliderLetnikFilter.setMajorTickSpacing(1);
        jSliderLetnikFilter.setMaximum(3);
        jSliderLetnikFilter.setPaintLabels(true);
        jSliderLetnikFilter.setPaintTicks(true);
        jSliderLetnikFilter.setSnapToTicks(true);
        jSliderLetnikFilter.setValue(0);
        jSliderLetnikFilter.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jSliderLetnikFilter.setEnabled(false);
        jSliderLetnikFilter.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jSliderLetnikFilterPropertyChange(evt);
            }
        });

        jLabelSeznamSemester.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabelSeznamSemester.setText("Semester:");
        jLabelSeznamSemester.setEnabled(false);

        buttonGroupSeznamSemester.add(jRadioButtonSeznamSemesterOba);
        jRadioButtonSeznamSemesterOba.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jRadioButtonSeznamSemesterOba.setText("Oba");
        jRadioButtonSeznamSemesterOba.setEnabled(false);
        jRadioButtonSeznamSemesterOba.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonSeznamSemesterObaActionPerformed(evt);
            }
        });

        buttonGroupSeznamSemester.add(jRadioButtonSeznamSemesterZimski);
        jRadioButtonSeznamSemesterZimski.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jRadioButtonSeznamSemesterZimski.setText("Zimski");
        jRadioButtonSeznamSemesterZimski.setEnabled(false);
        jRadioButtonSeznamSemesterZimski.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonSeznamSemesterZimskiActionPerformed(evt);
            }
        });

        buttonGroupSeznamSemester.add(jRadioButtonSeznamSemesterPoletni);
        jRadioButtonSeznamSemesterPoletni.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jRadioButtonSeznamSemesterPoletni.setText("Poletni");
        jRadioButtonSeznamSemesterPoletni.setEnabled(false);
        jRadioButtonSeznamSemesterPoletni.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonSeznamSemesterPoletniActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelSeznamFiltriranjeLayout = new javax.swing.GroupLayout(jPanelSeznamFiltriranje);
        jPanelSeznamFiltriranje.setLayout(jPanelSeznamFiltriranjeLayout);
        jPanelSeznamFiltriranjeLayout.setHorizontalGroup(
            jPanelSeznamFiltriranjeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelSeznamFiltriranjeLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelSeznamFiltriranjeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelSeznamFiltriranjeLayout.createSequentialGroup()
                        .addComponent(jLabelSeznamSemester)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanelSeznamFiltriranjeLayout.createSequentialGroup()
                        .addGroup(jPanelSeznamFiltriranjeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelSeznamFiltriranjeLayout.createSequentialGroup()
                                .addComponent(jRadioButtonSeznamSemesterOba)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 102, Short.MAX_VALUE)
                                .addComponent(jRadioButtonSeznamSemesterZimski)
                                .addGap(90, 90, 90)
                                .addComponent(jRadioButtonSeznamSemesterPoletni))
                            .addGroup(jPanelSeznamFiltriranjeLayout.createSequentialGroup()
                                .addComponent(jLabelLetnikSeznam, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(jSliderLetnikFilter, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap())))
        );
        jPanelSeznamFiltriranjeLayout.setVerticalGroup(
            jPanelSeznamFiltriranjeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelSeznamFiltriranjeLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelLetnikSeznam)
                .addGap(34, 34, 34)
                .addComponent(jSliderLetnikFilter, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(55, 55, 55)
                .addComponent(jLabelSeznamSemester)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 58, Short.MAX_VALUE)
                .addGroup(jPanelSeznamFiltriranjeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jRadioButtonSeznamSemesterOba)
                    .addComponent(jRadioButtonSeznamSemesterZimski)
                    .addComponent(jRadioButtonSeznamSemesterPoletni))
                .addGap(91, 91, 91))
        );

        javax.swing.GroupLayout jPanelSeznamLayout = new javax.swing.GroupLayout(jPanelSeznam);
        jPanelSeznam.setLayout(jPanelSeznamLayout);
        jPanelSeznamLayout.setHorizontalGroup(
            jPanelSeznamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelSeznamLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelSeznamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelSeznamLayout.createSequentialGroup()
                        .addGroup(jPanelSeznamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButtonUredi, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButtonShrani, javax.swing.GroupLayout.DEFAULT_SIZE, 166, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanelSeznamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButtonOdstraniPredmet, javax.swing.GroupLayout.DEFAULT_SIZE, 188, Short.MAX_VALUE)
                            .addComponent(jButtonDodajPredmet, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(641, 641, 641))
                    .addGroup(jPanelSeznamLayout.createSequentialGroup()
                        .addComponent(jScrollPane1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanelSeznamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButtonSeznamDol, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButtonSeznamGor))
                        .addGap(78, 78, 78)
                        .addGroup(jPanelSeznamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanelSeznamFiltriranje, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jCheckBoxSeznamFiltriranje))
                        .addGap(24, 24, 24))))
        );
        jPanelSeznamLayout.setVerticalGroup(
            jPanelSeznamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelSeznamLayout.createSequentialGroup()
                .addGap(69, 69, 69)
                .addGroup(jPanelSeznamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelSeznamLayout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 395, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanelSeznamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButtonUredi, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButtonDodajPredmet, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(2, 2, 2)
                        .addGroup(jPanelSeznamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButtonOdstraniPredmet, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButtonShrani, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanelSeznamLayout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(jCheckBoxSeznamFiltriranje)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanelSeznamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanelSeznamLayout.createSequentialGroup()
                                .addComponent(jButtonSeznamGor)
                                .addGap(163, 163, 163)
                                .addComponent(jButtonSeznamDol))
                            .addComponent(jPanelSeznamFiltriranje, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
        );

        jTabbedPane.addTab("Seznam", jPanelSeznam);

        jTableRedovalnica.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        )

    );
    jScrollPane3.setViewportView(jTableRedovalnica);

    jComboBoxRedovalnica.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            jComboBoxRedovalnicaActionPerformed(evt);
        }
    });
    jComboBoxRedovalnica.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
        public void propertyChange(java.beans.PropertyChangeEvent evt) {
            jComboBoxRedovalnicaPropertyChange(evt);
        }
    });

    jLabelPredmeti.setText("Ocene/Obveznosti");

    jPanelDinamicna.setLayout(new java.awt.CardLayout());

    jButtonRedovalnicaUredi.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
    jButtonRedovalnicaUredi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Slike/edit.png"))); // NOI18N
    jButtonRedovalnicaUredi.setText("Uredi");
    jButtonRedovalnicaUredi.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
    jButtonRedovalnicaUredi.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            jButtonRedovalnicaUrediActionPerformed(evt);
        }
    });

    jPanelRedovalnicaSemester.setBorder(javax.swing.BorderFactory.createTitledBorder("Semester"));

    buttonGroupRedovalnicaSemester.add(jRadioButtonSemesterOba);
    jRadioButtonSemesterOba.setSelected(true);
    jRadioButtonSemesterOba.setText("Oba semestra");
    jRadioButtonSemesterOba.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            jRadioButtonSemesterObaActionPerformed(evt);
        }
    });

    buttonGroupRedovalnicaSemester.add(jRadioButtonSemesterZimski);
    jRadioButtonSemesterZimski.setText("Zimski semester");
    jRadioButtonSemesterZimski.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            jRadioButtonSemesterZimskiActionPerformed(evt);
        }
    });

    buttonGroupRedovalnicaSemester.add(jRadioButtonSemesterPoletni);
    jRadioButtonSemesterPoletni.setText("Poletni semester");
    jRadioButtonSemesterPoletni.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            jRadioButtonSemesterPoletniActionPerformed(evt);
        }
    });

    javax.swing.GroupLayout jPanelRedovalnicaSemesterLayout = new javax.swing.GroupLayout(jPanelRedovalnicaSemester);
    jPanelRedovalnicaSemester.setLayout(jPanelRedovalnicaSemesterLayout);
    jPanelRedovalnicaSemesterLayout.setHorizontalGroup(
        jPanelRedovalnicaSemesterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(jPanelRedovalnicaSemesterLayout.createSequentialGroup()
            .addGroup(jPanelRedovalnicaSemesterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jRadioButtonSemesterOba)
                .addComponent(jRadioButtonSemesterZimski)
                .addComponent(jRadioButtonSemesterPoletni))
            .addGap(0, 7, Short.MAX_VALUE))
    );
    jPanelRedovalnicaSemesterLayout.setVerticalGroup(
        jPanelRedovalnicaSemesterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(jPanelRedovalnicaSemesterLayout.createSequentialGroup()
            .addContainerGap()
            .addComponent(jRadioButtonSemesterOba)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(jRadioButtonSemesterZimski)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(jRadioButtonSemesterPoletni)
            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
    );

    jPanelRedovalnicaPredmetOpravljen.setBorder(javax.swing.BorderFactory.createTitledBorder("Predmet opravljen"));

    jSliderRedovalnicaPredmetOpravljen.setMajorTickSpacing(1);
    jSliderRedovalnicaPredmetOpravljen.setMaximum(3);
    jSliderRedovalnicaPredmetOpravljen.setMinimum(1);
    jSliderRedovalnicaPredmetOpravljen.setPaintTicks(true);
    jSliderRedovalnicaPredmetOpravljen.setSnapToTicks(true);
    jSliderRedovalnicaPredmetOpravljen.setValue(1);
    jSliderRedovalnicaPredmetOpravljen.addChangeListener(new javax.swing.event.ChangeListener() {
        public void stateChanged(javax.swing.event.ChangeEvent evt) {
            jSliderRedovalnicaPredmetOpravljenStateChanged(evt);
        }
    });
    jSliderRedovalnicaPredmetOpravljen.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mouseReleased(java.awt.event.MouseEvent evt) {
            jSliderRedovalnicaPredmetOpravljenMouseReleased(evt);
        }
    });
    jSliderRedovalnicaPredmetOpravljen.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
        public void propertyChange(java.beans.PropertyChangeEvent evt) {
            jSliderRedovalnicaPredmetOpravljenPropertyChange(evt);
        }
    });
    jSliderRedovalnicaPredmetOpravljen.addKeyListener(new java.awt.event.KeyAdapter() {
        public void keyReleased(java.awt.event.KeyEvent evt) {
            jSliderRedovalnicaPredmetOpravljenKeyReleased(evt);
        }
    });

    jLabelRedovalnicaSlider1.setFont(new java.awt.Font("Dialog", 1, 10)); // NOI18N
    jLabelRedovalnicaSlider1.setText("Vsi predmeti");

    jLabelRedovalnicaSlider2.setFont(new java.awt.Font("Dialog", 1, 10)); // NOI18N
    jLabelRedovalnicaSlider2.setText("Da");

    jLabelRedovalnicaSlider3.setFont(new java.awt.Font("Dialog", 1, 10)); // NOI18N
    jLabelRedovalnicaSlider3.setText("Ne");

    javax.swing.GroupLayout jPanelRedovalnicaPredmetOpravljenLayout = new javax.swing.GroupLayout(jPanelRedovalnicaPredmetOpravljen);
    jPanelRedovalnicaPredmetOpravljen.setLayout(jPanelRedovalnicaPredmetOpravljenLayout);
    jPanelRedovalnicaPredmetOpravljenLayout.setHorizontalGroup(
        jPanelRedovalnicaPredmetOpravljenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(jPanelRedovalnicaPredmetOpravljenLayout.createSequentialGroup()
            .addContainerGap()
            .addComponent(jSliderRedovalnicaPredmetOpravljen, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
        .addGroup(jPanelRedovalnicaPredmetOpravljenLayout.createSequentialGroup()
            .addComponent(jLabelRedovalnicaSlider1)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(jLabelRedovalnicaSlider2)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 49, Short.MAX_VALUE)
            .addComponent(jLabelRedovalnicaSlider3))
    );
    jPanelRedovalnicaPredmetOpravljenLayout.setVerticalGroup(
        jPanelRedovalnicaPredmetOpravljenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(jPanelRedovalnicaPredmetOpravljenLayout.createSequentialGroup()
            .addGap(46, 46, 46)
            .addComponent(jSliderRedovalnicaPredmetOpravljen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
            .addGroup(jPanelRedovalnicaPredmetOpravljenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jLabelRedovalnicaSlider1)
                .addComponent(jLabelRedovalnicaSlider2)
                .addComponent(jLabelRedovalnicaSlider3))
            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
    );

    jButtonRedovalnicaSortOcene.setText("Razvrsti po oceni");
    jButtonRedovalnicaSortOcene.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            jButtonRedovalnicaSortOceneActionPerformed(evt);
        }
    });

    jButtonRedovalnicaReset.setText("Reset");
    jButtonRedovalnicaReset.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            jButtonRedovalnicaResetActionPerformed(evt);
        }
    });

    javax.swing.GroupLayout jPanelUrediOceneLayout = new javax.swing.GroupLayout(jPanelUrediOcene);
    jPanelUrediOcene.setLayout(jPanelUrediOceneLayout);
    jPanelUrediOceneLayout.setHorizontalGroup(
        jPanelUrediOceneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(jPanelUrediOceneLayout.createSequentialGroup()
            .addGap(6, 6, 6)
            .addGroup(jPanelUrediOceneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jButtonRedovalnicaUredi, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanelUrediOceneLayout.createSequentialGroup()
                    .addGroup(jPanelUrediOceneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jPanelRedovalnicaSemester, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButtonRedovalnicaSortOcene, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(jPanelUrediOceneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jButtonRedovalnicaReset, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanelRedovalnicaPredmetOpravljen, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
    );
    jPanelUrediOceneLayout.setVerticalGroup(
        jPanelUrediOceneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelUrediOceneLayout.createSequentialGroup()
            .addContainerGap()
            .addGroup(jPanelUrediOceneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                .addComponent(jPanelRedovalnicaSemester, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanelRedovalnicaPredmetOpravljen, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
            .addGroup(jPanelUrediOceneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                .addComponent(jButtonRedovalnicaSortOcene, javax.swing.GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
                .addComponent(jButtonRedovalnicaReset, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
            .addComponent(jButtonRedovalnicaUredi, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(12, 12, 12))
    );

    jPanelDinamicna.add(jPanelUrediOcene, "card2");

    jButtonRedovalnicaSortOceneObveznosti.setText("Razvrsti po oceni");
    jButtonRedovalnicaSortOceneObveznosti.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            jButtonRedovalnicaSortOceneObveznostiActionPerformed(evt);
        }
    });

    jButtonRedovalnicaUrediObveznosti.setText("Uredi");
    jButtonRedovalnicaUrediObveznosti.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            jButtonRedovalnicaUrediObveznostiActionPerformed(evt);
        }
    });

    jButtonRedovalnicaResetObveznosti.setText("Reset");
    jButtonRedovalnicaResetObveznosti.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            jButtonRedovalnicaResetObveznostiActionPerformed(evt);
        }
    });

    jLabelIzpisObveznosti.setFont(new java.awt.Font("Dialog", 1, 36)); // NOI18N
    jLabelIzpisObveznosti.setText("Izpis obveznosti:");

    javax.swing.GroupLayout jPanelDoloceneObveznostiLayout = new javax.swing.GroupLayout(jPanelDoloceneObveznosti);
    jPanelDoloceneObveznosti.setLayout(jPanelDoloceneObveznostiLayout);
    jPanelDoloceneObveznostiLayout.setHorizontalGroup(
        jPanelDoloceneObveznostiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(jPanelDoloceneObveznostiLayout.createSequentialGroup()
            .addContainerGap()
            .addGroup(jPanelDoloceneObveznostiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jLabelIzpisObveznosti)
                .addComponent(jButtonRedovalnicaUrediObveznosti, javax.swing.GroupLayout.PREFERRED_SIZE, 297, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanelDoloceneObveznostiLayout.createSequentialGroup()
                    .addComponent(jButtonRedovalnicaSortOceneObveznosti, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(jButtonRedovalnicaResetObveznosti, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addContainerGap(8, Short.MAX_VALUE))
    );
    jPanelDoloceneObveznostiLayout.setVerticalGroup(
        jPanelDoloceneObveznostiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(jPanelDoloceneObveznostiLayout.createSequentialGroup()
            .addGap(16, 16, 16)
            .addComponent(jLabelIzpisObveznosti, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(80, 80, 80)
            .addGroup(jPanelDoloceneObveznostiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                .addComponent(jButtonRedovalnicaSortOceneObveznosti, javax.swing.GroupLayout.DEFAULT_SIZE, 119, Short.MAX_VALUE)
                .addComponent(jButtonRedovalnicaResetObveznosti, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jButtonRedovalnicaUrediObveznosti, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(16, 16, 16))
    );

    jPanelDinamicna.add(jPanelDoloceneObveznosti, "card3");

    jToggleButtonRedovalnica.setText("Ocene");
    jToggleButtonRedovalnica.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            jToggleButtonRedovalnicaActionPerformed(evt);
        }
    });

    jLabelRedovalnicaPodTabelo.setText("Povprečna ocena letnika:");

    jLabelDinamicniComboBox.setText("Izberite letnik:");

    jLabelRedovalnicaBestOcena.setText("Najboljša ocena:");

    jCheckBoxRedovalnicaLetnikOpravljen.setText("Letnik opravljen");
    jCheckBoxRedovalnicaLetnikOpravljen.setEnabled(false);

    jLabelRedovalnicaPridobljenECTS.setText("Pridobljen ECTS:");

    javax.swing.GroupLayout jPanelRedovalnicaLayout = new javax.swing.GroupLayout(jPanelRedovalnica);
    jPanelRedovalnica.setLayout(jPanelRedovalnicaLayout);
    jPanelRedovalnicaLayout.setHorizontalGroup(
        jPanelRedovalnicaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(jPanelRedovalnicaLayout.createSequentialGroup()
            .addContainerGap()
            .addGroup(jPanelRedovalnicaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                .addComponent(jToggleButtonRedovalnica, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabelPredmeti, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanelRedovalnicaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanelRedovalnicaLayout.createSequentialGroup()
                    .addGap(22, 22, 22)
                    .addComponent(jLabelDinamicniComboBox)
                    .addGap(0, 0, Short.MAX_VALUE))
                .addGroup(jPanelRedovalnicaLayout.createSequentialGroup()
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addComponent(jComboBoxRedovalnica, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
            .addGap(496, 496, 496))
        .addGroup(jPanelRedovalnicaLayout.createSequentialGroup()
            .addGroup(jPanelRedovalnicaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanelRedovalnicaLayout.createSequentialGroup()
                    .addGap(35, 35, 35)
                    .addComponent(jCheckBoxRedovalnicaLetnikOpravljen)
                    .addGap(18, 18, 18)
                    .addGroup(jPanelRedovalnicaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabelRedovalnicaPridobljenECTS)
                        .addComponent(jTextFieldPridobljenECTS, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addComponent(jPanelDinamicna, javax.swing.GroupLayout.PREFERRED_SIZE, 311, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanelRedovalnicaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanelRedovalnicaLayout.createSequentialGroup()
                    .addGap(18, 18, 18)
                    .addGroup(jPanelRedovalnicaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanelRedovalnicaLayout.createSequentialGroup()
                            .addComponent(jLabelRedovalnicaBestOcena)
                            .addGap(0, 0, Short.MAX_VALUE))
                        .addComponent(jTextFieldRedovalnicaNajboljsaOcena))
                    .addGroup(jPanelRedovalnicaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanelRedovalnicaLayout.createSequentialGroup()
                            .addGap(61, 61, 61)
                            .addComponent(jTextFieldRedovalnicaPodTabelo, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelRedovalnicaLayout.createSequentialGroup()
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jLabelRedovalnicaPodTabelo, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelRedovalnicaLayout.createSequentialGroup()
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 690, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addContainerGap())
    );
    jPanelRedovalnicaLayout.setVerticalGroup(
        jPanelRedovalnicaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(jPanelRedovalnicaLayout.createSequentialGroup()
            .addGap(19, 19, 19)
            .addGroup(jPanelRedovalnicaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jLabelPredmeti)
                .addComponent(jLabelDinamicniComboBox))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addGroup(jPanelRedovalnicaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanelRedovalnicaLayout.createSequentialGroup()
                    .addGroup(jPanelRedovalnicaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jComboBoxRedovalnica, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jToggleButtonRedovalnica))
                    .addGap(9, 9, 9)
                    .addComponent(jPanelDinamicna, javax.swing.GroupLayout.PREFERRED_SIZE, 445, Short.MAX_VALUE))
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGap(18, 18, 18)
            .addGroup(jPanelRedovalnicaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jLabelRedovalnicaPodTabelo)
                .addComponent(jLabelRedovalnicaBestOcena)
                .addComponent(jLabelRedovalnicaPridobljenECTS))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanelRedovalnicaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jTextFieldRedovalnicaPodTabelo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(jTextFieldRedovalnicaNajboljsaOcena, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(jCheckBoxRedovalnicaLetnikOpravljen)
                .addComponent(jTextFieldPridobljenECTS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGap(20, 20, 20))
    );

    jTabbedPane.addTab("Redovalnica", jPanelRedovalnica);

    jComboBoxIzbiraObveznosti.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
    jComboBoxIzbiraObveznosti.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
        public void propertyChange(java.beans.PropertyChangeEvent evt) {
            jComboBoxIzbiraObveznostiPropertyChange(evt);
        }
    });

    jTextFieldPovprecnaOcenaObveznosti.setEditable(false);
    jTextFieldPovprecnaOcenaObveznosti.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
    jTextFieldPovprecnaOcenaObveznosti.setHorizontalAlignment(javax.swing.JTextField.CENTER);

    jLabelPovprecnaOcenaObveznosti.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
    jLabelPovprecnaOcenaObveznosti.setText("Izberite obveznost, za katero želite izvedeti povprečno oceno");

    jLabelObveznostPovprecnaOcena.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
    jLabelObveznostPovprecnaOcena.setText("Povprečna ocena:");

    javax.swing.GroupLayout jPanelPovprecnaOcenaIzbraneObveznostiLayout = new javax.swing.GroupLayout(jPanelPovprecnaOcenaIzbraneObveznosti);
    jPanelPovprecnaOcenaIzbraneObveznosti.setLayout(jPanelPovprecnaOcenaIzbraneObveznostiLayout);
    jPanelPovprecnaOcenaIzbraneObveznostiLayout.setHorizontalGroup(
        jPanelPovprecnaOcenaIzbraneObveznostiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(jPanelPovprecnaOcenaIzbraneObveznostiLayout.createSequentialGroup()
            .addGroup(jPanelPovprecnaOcenaIzbraneObveznostiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanelPovprecnaOcenaIzbraneObveznostiLayout.createSequentialGroup()
                    .addGap(43, 43, 43)
                    .addGroup(jPanelPovprecnaOcenaIzbraneObveznostiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabelPovprecnaOcenaObveznosti, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jComboBoxIzbiraObveznosti, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(jPanelPovprecnaOcenaIzbraneObveznostiLayout.createSequentialGroup()
                    .addGap(173, 173, 173)
                    .addGroup(jPanelPovprecnaOcenaIzbraneObveznostiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabelObveznostPovprecnaOcena)
                        .addComponent(jTextFieldPovprecnaOcenaObveznosti, javax.swing.GroupLayout.PREFERRED_SIZE, 620, javax.swing.GroupLayout.PREFERRED_SIZE))))
            .addContainerGap(220, Short.MAX_VALUE))
    );
    jPanelPovprecnaOcenaIzbraneObveznostiLayout.setVerticalGroup(
        jPanelPovprecnaOcenaIzbraneObveznostiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(jPanelPovprecnaOcenaIzbraneObveznostiLayout.createSequentialGroup()
            .addGap(25, 25, 25)
            .addComponent(jLabelPovprecnaOcenaObveznosti)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
            .addComponent(jComboBoxIzbiraObveznosti, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(173, 173, 173)
            .addComponent(jLabelObveznostPovprecnaOcena)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(jTextFieldPovprecnaOcenaObveznosti, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addContainerGap(227, Short.MAX_VALUE))
    );

    jTabbedPane.addTab("Povprečna ocena izbrane obveznosti", jPanelPovprecnaOcenaIzbraneObveznosti);

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(
        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addComponent(jTabbedPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
    );
    layout.setVerticalGroup(
        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addComponent(jTabbedPane, javax.swing.GroupLayout.DEFAULT_SIZE, 637, Short.MAX_VALUE)
    );

    pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jToggleButtonShraniSpremembeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButtonShraniSpremembeActionPerformed

        //Shramba sprememb iz jDialogUrejanje
        //Shramba obveznosti
        
        boolean napaka = false;
        String Obveznosti = "", Teza_pred = "", Ocene = "", Vrste_obveznosti = "";

        for (int i = 0; i < jTableUrejanje.getModel().getRowCount(); i++) {                         //Preverjanje napak

            if (jTableUrejanje.getValueAt(i, 0) == "" || jTableUrejanje.getValueAt(i, 1) == "") {
                final JDialog Opozorilo = new JDialog();
                Opozorilo.setAlwaysOnTop(true);
                JOptionPane.showMessageDialog(Opozorilo, "Napaka, najprej izbrišite ali uredite prazno vrstico!");
                napaka = true;
            }

            if (napaka = false) {
                if (((Integer.parseInt(String.valueOf(jTableUrejanje.getValueAt(i, 1))) > 100) || (Integer.parseInt(String.valueOf(jTableUrejanje.getValueAt(i, 1))) <= 0))
                        || ((Integer.parseInt(String.valueOf(jTableUrejanje.getValueAt(i, 2))) > 100) || (Integer.parseInt(String.valueOf(jTableUrejanje.getValueAt(i, 2))) <= 0))) {
                    System.out.println("napaka");
                    final JDialog Opozorilo2 = new JDialog();
                    Opozorilo2.setAlwaysOnTop(true);
                    JOptionPane.showMessageDialog(Opozorilo2, "Ocene in teže ocen morajo biti med 0 in 100");
                    napaka = true;
                }
            }
        }

        if (napaka == false) {          //Če napake ni se izvede shramba

            PrintWriter izhod = null;

            try {
                izhod = new PrintWriter(new FileWriter(ImeDatoteke));
            } catch (FileNotFoundException e) {
                JOptionPane.showMessageDialog(null, "Napaka pri shranjevanju!");
            } catch (IOException ex) {
                Logger.getLogger(JavaGUI.class.getName()).log(Level.SEVERE, null, ex);
            }

            if (TabelaSeznam == true)                                   //If zaradi klica jDialogUrejanje iz dveh mest v GUI. Izvede se shranjevanje glede na to od kje to odpiramo
            {
                int index = jListPredmetov.getSelectedIndex();
                //polje[index].setStObveznosti(jTableUrejanje.getRowCount());

                //System.out.println(jTableUrejanje.getModel().getRowCount());
                if (jTableUrejanje.getModel().getRowCount() == 0) {
                    Obveznosti = "0";
                    Teza_pred = "0";
                    Ocene = "0";
                    Vrste_obveznosti = "0";
                } else {
                    Obveznosti = "";
                    Teza_pred = "";
                    Ocene = "";
                    Vrste_obveznosti = "";

                    for (int i = 0; i < jTableUrejanje.getModel().getRowCount(); i++) {
                        Obveznosti += jTableUrejanje.getValueAt(i, 0) + ",";
                        Teza_pred += jTableUrejanje.getValueAt(i, 1) + ",";

                        if (jTableUrejanje.getValueAt(i, 2) == "") {
                            Ocene += "0" + ",";
                        } else {
                            Ocene += jTableUrejanje.getValueAt(i, 2) + ",";
                        }

                        if (jTableUrejanje.getValueAt(i, 3) == "") {
                            Vrste_obveznosti += "0" + ",";
                        } else {
                            Vrste_obveznosti += jTableUrejanje.getValueAt(i, 3) + ",";
                        }

                    }

                    Obveznosti = Obveznosti.substring(0, Obveznosti.length() - 1);
                    Teza_pred = Teza_pred.substring(0, Teza_pred.length() - 1);
                    Ocene = Ocene.substring(0, Ocene.length() - 1);
                    Vrste_obveznosti = Vrste_obveznosti.substring(0, Vrste_obveznosti.length() - 1);
                }

                polje[index].setID(jTextFieldID.getText());
                polje[index].setImePredmeta(jTextFieldImePredmeta.getText());
                polje[index].setLetnik(jSliderLetnikUrejanje.getValue());
                polje[index].setSemester(jComboBoxSemester.getSelectedItem().toString());
                polje[index].setImeNosilca(jTextFieldImeNosilca.getText());
                polje[index].setECTS(Integer.parseInt(jTextFieldECTS.getText()));
                //System.out.println(Obveznosti + "\n" + Teza_pred + "\n" + Ocene);
                //System.out.print(polje[index].getStObveznosti());

                polje[index].setObveznosti(Obveznosti);
                polje[index].setTezaPredmetov(Teza_pred);
                polje[index].setVrstaObveznosti(Vrste_obveznosti);
                polje[index].setOcene(Ocene);
                polje[index].getOcene();

                //System.out.println(stevec + " " + polje.length);
                for (int i = 0; i < stevec; i++) {
                    String vsebina = polje[i].getID() + "\t" + polje[i].getImePredmeta() + "\t" + polje[i].getLetnik() + "\t" + polje[i].getSemester() + "\t" + polje[i].getImeNosilca()
                            + "\t" + polje[i].getECTS() + "\t" + polje[i].getObveznosti() + "\t" + polje[i].getTezaPredmetov() + "\t" + polje[i].getOcene() + "\t" + polje[i].getVrstaObveznosti();
                    izhod.println(vsebina);
                }

                izhod.close();
                jDialogUrejanje.dispose();
                
            } else if (TabelaRedovalnica == true) {         //Drugi del if stavka

                int IzbranaVrsticaTabele = jTableRedovalnica.getSelectedRow();

                for (int j = 0; j < stevec; j++) {
                    if (String.valueOf(jTableRedovalnica.getValueAt(IzbranaVrsticaTabele, 0)).compareTo(polje[j].getID()) == 0) {

                        if (jTableUrejanje.getModel().getRowCount() == 0) {
                            Obveznosti = "0";
                            Teza_pred = "0";
                            Ocene = "0";
                            Vrste_obveznosti = "0";
                        } else {
                            Obveznosti = "";
                            Teza_pred = "";
                            Ocene = "";
                            Vrste_obveznosti = "";

                            for (int i = 0; i < jTableUrejanje.getModel().getRowCount(); i++) {
                                Obveznosti += jTableUrejanje.getValueAt(i, 0) + ",";
                                Teza_pred += jTableUrejanje.getValueAt(i, 1) + ",";

                                if (jTableUrejanje.getValueAt(i, 2) == "") {
                                    Ocene += "0" + ",";
                                } else {
                                    Ocene += jTableUrejanje.getValueAt(i, 2) + ",";
                                }

                                if (jTableUrejanje.getValueAt(i, 3) == "") {
                                    Vrste_obveznosti += "0" + ",";
                                } else {
                                    Vrste_obveznosti += jTableUrejanje.getValueAt(i, 3) + ",";
                                }

                            }

                            Obveznosti = Obveznosti.substring(0, Obveznosti.length() - 1);
                            Teza_pred = Teza_pred.substring(0, Teza_pred.length() - 1);
                            Ocene = Ocene.substring(0, Ocene.length() - 1);
                            Vrste_obveznosti = Vrste_obveznosti.substring(0, Vrste_obveznosti.length() - 1);
                        }

                        polje[j].setID(jTextFieldID.getText());
                        polje[j].setImePredmeta(jTextFieldImePredmeta.getText());
                        polje[j].setLetnik(jSliderLetnikUrejanje.getValue());
                        polje[j].setSemester(jComboBoxSemester.getSelectedItem().toString());
                        polje[j].setImeNosilca(jTextFieldImeNosilca.getText());
                        polje[j].setECTS(Integer.parseInt(jTextFieldECTS.getText()));
                        //System.out.println(Obveznosti + "\n" + Teza_pred + "\n" + Ocene);
                        //System.out.print(polje[index].getStObveznosti());

                        polje[j].setObveznosti(Obveznosti);
                        polje[j].setTezaPredmetov(Teza_pred);
                        polje[j].setVrstaObveznosti(Vrste_obveznosti);
                        polje[j].setOcene(Ocene);

                        //System.out.println(stevec + " " + polje.length);
                        for (int i = 0; i < stevec; i++) {
                            String vsebina = polje[i].getID() + "\t" + polje[i].getImePredmeta() + "\t" + polje[i].getLetnik() + "\t" + polje[i].getSemester() + "\t" + polje[i].getImeNosilca()
                                    + "\t" + polje[i].getECTS() + "\t" + polje[i].getObveznosti() + "\t" + polje[i].getTezaPredmetov() + "\t" + polje[i].getOcene() + "\t" + polje[i].getVrstaObveznosti();
                            izhod.println(vsebina);
                        }

                        izhod.close();
                        jDialogUrejanje.dispose();
                    } else {
                    }
                }

            }

        } else if (napaka == true);


    }//GEN-LAST:event_jToggleButtonShraniSpremembeActionPerformed

    private void jButtonOdstraniObveznostTabbelaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonOdstraniObveznostTabbelaActionPerformed

        IzbrisiDelArraya();     //Klic funkcije odstranitve obveznosti

    }//GEN-LAST:event_jButtonOdstraniObveznostTabbelaActionPerformed

    private void jButtonDodajObveznostTabelaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDodajObveznostTabelaActionPerformed
        DodajVrstico();     //Klic funkcije za dodajanje obveznosti, oziroma nove vrstice v tabeli urejanja
    }//GEN-LAST:event_jButtonDodajObveznostTabelaActionPerformed

    private void jToggleButtonRedovalnicaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButtonRedovalnicaActionPerformed
       
        if (jToggleButtonRedovalnica.isSelected() == true) {        //Dinamični jPanel v 3. tabu, sprememba strani glede na ToggleButton
            
            DefaultTableModel model = new DefaultTableModel();
            jTableRedovalnica.setModel(model);

            ComboBoxVariacija = true;

            jPanelUrediOcene.setVisible(false);
            jPanelDoloceneObveznosti.setVisible(true);
            jToggleButtonRedovalnica.setText("Ocene določenih obveznosti");

            //jLabelRedovalnicaBestOcena.setVisible(false);
            //jTextFieldRedovalnicaNajboljsaOcena.setVisible(false);
            jLabelRedovalnicaBestOcena.setText("Najboljša ocena obveznosti");
            jLabelRedovalnicaPodTabelo.setVisible(false);
            jTextFieldRedovalnicaPodTabelo.setVisible(false);

            jComboBoxRedovalnica.removeAllItems();

            jComboBoxRedovalnica.updateUI();
            jTextFieldRedovalnicaNajboljsaOcena.removeAll();

            jLabelRedovalnicaPridobljenECTS.setVisible(false);
            jTextFieldPridobljenECTS.setVisible(false);
            jCheckBoxRedovalnicaLetnikOpravljen.setVisible(false);

            NapolniComboBoxObveznosti();
            NajboljsaObveznost();

        } else {
            
            DefaultTableModel model = new DefaultTableModel();
            jTableRedovalnica.setModel(model);

            ComboBoxVariacija = false;

            jPanelUrediOcene.setVisible(true);
            jPanelDoloceneObveznosti.setVisible(false);
            jToggleButtonRedovalnica.setText("Ocene");

            //jLabelRedovalnicaBestOcena.setVisible(true);
            //jTextFieldRedovalnicaNajboljsaOcena.setVisible(true);
            jLabelRedovalnicaBestOcena.setText("Najboljša ocena");

            jLabelRedovalnicaPodTabelo.setVisible(true);
            jTextFieldRedovalnicaPodTabelo.setVisible(true);

            jLabelRedovalnicaPridobljenECTS.setVisible(true);
            jTextFieldPridobljenECTS.setVisible(true);
            jCheckBoxRedovalnicaLetnikOpravljen.setVisible(true);

            jComboBoxRedovalnica.removeAllItems();

            jComboBoxRedovalnica.updateUI();

            NapolniComboBox();
            NajboljsaOcena();
            PridobljenECTS();
        }
    }//GEN-LAST:event_jToggleButtonRedovalnicaActionPerformed

    private void jComboBoxRedovalnicaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxRedovalnicaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBoxRedovalnicaActionPerformed

    private void jButtonShraniActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonShraniActionPerformed

        PrintWriter izhod = null;           //Gumb za shrambo sprememb v 2.tabu

        //System.out.println(ImeDatoteke);
        try {
            izhod = new PrintWriter(new FileWriter(ImeDatoteke));
        } catch (FileNotFoundException e) {
            JOptionPane.showMessageDialog(null, "Napaka pri shranjevanju!");
        } catch (IOException ex) {
            Logger.getLogger(JavaGUI.class.getName()).log(Level.SEVERE, null, ex);
        }

        for (int i = 0; i < stevec; i++) {
            String vsebina = polje[i].getID() + "\t" + polje[i].getImePredmeta() + "\t" + polje[i].getLetnik() + "\t" + polje[i].getSemester() + "\t" + polje[i].getImeNosilca()
                    + "\t" + polje[i].getECTS() + "\t" + polje[i].getObveznosti() + "\t" + polje[i].getTezaPredmetov() + "\t" + polje[i].getOcene() + "\t" + polje[i].getVrstaObveznosti();
            izhod.println(vsebina);

            // System.out.println(polje[0].getID());
            // System.out.println(polje[1].getID());
        }

        izhod.close();

    }//GEN-LAST:event_jButtonShraniActionPerformed

    private void jButtonOdstraniPredmetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonOdstraniPredmetActionPerformed
        stevec = OdstraniPredmet(stevec);       //Gumb na 2.tabu za odstranitev predmeta
    }//GEN-LAST:event_jButtonOdstraniPredmetActionPerformed

    private void jButtonDodajPredmetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDodajPredmetActionPerformed

        stevec = DodajPredmet(stevec);          //Gumb na 2.tabu za dodajanje predmeta
    }//GEN-LAST:event_jButtonDodajPredmetActionPerformed

    private void jButtonUrediActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonUrediActionPerformed

        TabelaRedovalnica = false;                                  //JDialogUrejanje se prikaže in napolni s podatki
        TabelaSeznam = true;

        int index = jListPredmetov.getSelectedIndex();
        String vrednostIndexa = jListPredmetov.getSelectedValue();
        if (index < 0) {
            JOptionPane.showMessageDialog(null, "Niste označili predmeta!");
        } else {

            for (int i = 0; i < stevec; i++) {
                if (vrednostIndexa.compareTo(polje[i].getImePredmeta()) == 0) {
                    index = i;
                }
            }

            DefaultTableModel vrstica = (DefaultTableModel) jTableUrejanje.getModel();
            vrstica.setRowCount(0);

            jTextFieldID.setText(polje[index].getID());
            jTextFieldImePredmeta.setText(polje[index].getImePredmeta());
            jSliderLetnikUrejanje.setValue(polje[index].getLetnik());

            if (polje[index].getSemester().compareTo("Zimski") == 0) {
                jComboBoxSemester.setSelectedIndex(0);
            } else if (polje[index].getSemester().compareTo("Poletni") == 0) {
                jComboBoxSemester.setSelectedIndex(1);
            }

            jTextFieldImeNosilca.setText(polje[index].getImeNosilca());
            jTextFieldECTS.setText(String.valueOf(polje[index].getECTS()));

            String ocena = String.valueOf(polje[index].getOcena());

            jTextFieldOcena.setText(ocena);

            double zacasna = polje[index].getOcena();
            int ZaokrozenaOcena = 0;
            if (zacasna > 0 && zacasna < 10) {
                ZaokrozenaOcena = 1;
            } else if (zacasna >= 10 && zacasna < 20) {
                ZaokrozenaOcena = 2;
            } else if (zacasna >= 20 && zacasna < 30) {
                ZaokrozenaOcena = 3;
            } else if (zacasna >= 30 && zacasna < 40) {
                ZaokrozenaOcena = 4;
            } else if (zacasna >= 40 && zacasna < 50) {
                ZaokrozenaOcena = 5;
            } else if (zacasna >= 50 && zacasna < 60) {
                ZaokrozenaOcena = 6;
            } else if (zacasna >= 60 && zacasna < 70) {
                ZaokrozenaOcena = 7;
            } else if (zacasna >= 70 && zacasna < 80) {
                ZaokrozenaOcena = 8;
            } else if (zacasna >= 80 && zacasna < 90) {
                ZaokrozenaOcena = 9;
            } else if (zacasna >= 90 && zacasna <= 100) {
                ZaokrozenaOcena = 10;
            } else {
                ZaokrozenaOcena = 0;
            }

            jTextFieldZaokrozenaOcena.setText(String.valueOf(ZaokrozenaOcena));

            if (polje[index].getPredmetOpravljen() == true) {
                jCheckBoxPredmetOpravljen.setSelected(true);
            } else {
                jCheckBoxPredmetOpravljen.setSelected(false);
            }

            /*
            Tabela

            String[] poljeObveznosti=(polje[index].getObveznosti()).split(",");
            String[] TezePredmetov=(polje[index].getTezaPredmetov()).split(",");
            String[] OcenePredmetov=(polje[index].getOcene()).split(",");

             */
            NapolniTabelo();

            jDialogUrejanje.setSize(800, 425);
            jDialogUrejanje.setLocationRelativeTo(null);
            jDialogUrejanje.setVisible(true);
            jDialogUrejanje.setModal(true);

        }
    }//GEN-LAST:event_jButtonUrediActionPerformed

    private void jComboBoxRedovalnicaPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jComboBoxRedovalnicaPropertyChange

        if (ComboBoxVariacija == false) {                       //Sprememba ComboBoxa, glede na boolean vrednost
            DefaultTableModel model = new DefaultTableModel();
            jTableRedovalnica.setModel(model);

            NapolniTabeloRedovalnica();
            NajboljsaOcena();
            PridobljenECTS();

        } else if (ComboBoxVariacija == true) {
            DefaultTableModel model = new DefaultTableModel();
            jTableRedovalnica.setModel(model);
            NapolniTabeloRedovalnicaObveznosti();
            NajboljsaObveznost();
        }
    }//GEN-LAST:event_jComboBoxRedovalnicaPropertyChange

    private void jButtonGorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonGorActionPerformed

        int index = jTableUrejanje.getSelectedRow();        //Premikanje gor v jDialogUrejanje(obveznosti)
        DefaultTableModel model;
        model = (DefaultTableModel) jTableUrejanje.getModel();
        if (index == 0) {
            final JDialog Opozorilo = new JDialog();
            Opozorilo.setAlwaysOnTop(true);
            JOptionPane.showMessageDialog(Opozorilo, "Obveznosti ne morete premakniti višje", "Napaka", JOptionPane.ERROR_MESSAGE);
        } else {
            model.moveRow(index, index, index - 1);
            jTableUrejanje.setRowSelectionInterval(index - 1, index - 1);
        }

    }//GEN-LAST:event_jButtonGorActionPerformed

    private void jButtonDolActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDolActionPerformed

        int index = jTableUrejanje.getSelectedRow();     //Premikanje dol v jDialogUrejanje(obveznosti)
        DefaultTableModel model;
        model = (DefaultTableModel) jTableUrejanje.getModel();
        if (index == jTableUrejanje.getRowCount() - 1) {
            final JDialog Opozorilo = new JDialog();
            Opozorilo.setAlwaysOnTop(true);
            JOptionPane.showMessageDialog(Opozorilo, "Obveznosti ne morete premakniti nižje", "Napaka", JOptionPane.ERROR_MESSAGE);
        } else {
            model.moveRow(index, index, index + 1);
            jTableUrejanje.setRowSelectionInterval(index + 1, index + 1);
        }
    }//GEN-LAST:event_jButtonDolActionPerformed

    private void jButtonSeznamGorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSeznamGorActionPerformed

        int index = jListPredmetov.getSelectedIndex();          //Premikanje gor po seznamu v 2. tabu

        if (index == 0) {
            final JDialog Opozorilo = new JDialog();
            Opozorilo.setAlwaysOnTop(true);
            JOptionPane.showMessageDialog(Opozorilo, "Obveznosti ne morete premakniti višje", "Napaka", JOptionPane.ERROR_MESSAGE);
        } else {
            ZamenjajPolji(index, index - 1);

            DefaultListModel nov_model = new DefaultListModel();

            for (int i = 0; i < stevec; i++) {
                String zacasni = polje[i].getImePredmeta();
                nov_model.addElement(zacasni);

            }
            jListPredmetov.setModel(nov_model);
            jListPredmetov.setSelectedIndex(index - 1);

        }

    }//GEN-LAST:event_jButtonSeznamGorActionPerformed

    private void jButtonSeznamDolActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSeznamDolActionPerformed

        int index = jListPredmetov.getSelectedIndex();      //Premikanje dol po seznamu v 2. tabu

        if (index == jListPredmetov.getModel().getSize() - 1) {
            final JDialog Opozorilo = new JDialog();
            Opozorilo.setAlwaysOnTop(true);
            JOptionPane.showMessageDialog(Opozorilo, "Obveznosti ne morete premakniti nižje", "Napaka", JOptionPane.ERROR_MESSAGE);
        } else {
            ZamenjajPolji(index, index + 1);

            DefaultListModel nov_model = new DefaultListModel();

            for (int i = 0; i < stevec; i++) {
                String zacasni = polje[i].getImePredmeta();
                nov_model.addElement(zacasni);

            }
            jListPredmetov.setModel(nov_model);
            jListPredmetov.setSelectedIndex(index + 1);

        }
    }//GEN-LAST:event_jButtonSeznamDolActionPerformed

    private void jComboBoxSemesterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxSemesterActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBoxSemesterActionPerformed

    private void jCheckBoxPredmetOpravljenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBoxPredmetOpravljenActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckBoxPredmetOpravljenActionPerformed

    private void jRadioButtonSemesterObaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonSemesterObaActionPerformed
        NapolniTabeloRedovalnica();
    }//GEN-LAST:event_jRadioButtonSemesterObaActionPerformed

    private void jRadioButtonSemesterZimskiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonSemesterZimskiActionPerformed

        NapolniTabeloRedovalnica();

        for (int i = 0; i < stevec; i++) {
            if (polje[i].getSemester().compareTo("Poletni") == 0) {
                for (int j = 0; j < jTableRedovalnica.getRowCount(); j++) {
                    if (polje[i].getID().compareTo(String.valueOf(jTableRedovalnica.getValueAt(j, 0))) == 0) {
                        //System.out.println(j);
                        ((DefaultTableModel) jTableRedovalnica.getModel()).removeRow(j);
                    }
                }
            }
        }

        NajboljsaOcena();

    }//GEN-LAST:event_jRadioButtonSemesterZimskiActionPerformed

    private void jRadioButtonSemesterPoletniActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonSemesterPoletniActionPerformed

        NapolniTabeloRedovalnica();

        for (int i = 0; i < stevec; i++) {
            if (polje[i].getSemester().compareTo("Zimski") == 0) {
                for (int j = 0; j < jTableRedovalnica.getRowCount(); j++) {
                    if (polje[i].getID().compareTo(String.valueOf(jTableRedovalnica.getValueAt(j, 0))) == 0) {
                        //System.out.println(j);
                        ((DefaultTableModel) jTableRedovalnica.getModel()).removeRow(j);
                    }
                }
            }
        }

        NajboljsaOcena();

    }//GEN-LAST:event_jRadioButtonSemesterPoletniActionPerformed

    private void jSliderRedovalnicaPredmetOpravljenPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jSliderRedovalnicaPredmetOpravljenPropertyChange

        jTextFieldRedovalnicaNajboljsaOcena.setVisible(true);
        jLabelRedovalnicaBestOcena.setVisible(true);

        if (jRadioButtonSemesterOba.isSelected()) {
            jRadioButtonSemesterOba.updateUI();
        }
        if (jRadioButtonSemesterPoletni.isSelected()) {
            jRadioButtonSemesterPoletni.updateUI();
        }
        if (jRadioButtonSemesterZimski.isSelected()) {
            jRadioButtonSemesterZimski.updateUI();
        }

        int vrednost_sliderja = jSliderRedovalnicaPredmetOpravljen.getValue();    // 1-Vsi predmeti 2-Opravljeni 3-Neopravljeni

        if (vrednost_sliderja == 2) {

            for (int j = 0; j < jTableRedovalnica.getModel().getRowCount(); j++) {
                if (String.valueOf(jTableRedovalnica.getValueAt(j, 4)).compareTo("NE") == 0) {
                    //System.out.println(String.valueOf(jTableRedovalnica.getValueAt(j,4)));
                    ((DefaultTableModel) jTableRedovalnica.getModel()).removeRow(j);
                    j = 0;
                }
            }
        } else if (vrednost_sliderja == 3) {

            jTextFieldRedovalnicaNajboljsaOcena.setVisible(false);
            jLabelRedovalnicaBestOcena.setVisible(false);

            for (int j = 0; j < jTableRedovalnica.getModel().getRowCount(); j++) {
                if (String.valueOf(jTableRedovalnica.getValueAt(j, 4)).compareTo("DA") == 0) {
                    //System.out.println(String.valueOf(jTableRedovalnica.getValueAt(j,4)));
                    ((DefaultTableModel) jTableRedovalnica.getModel()).removeRow(j);
                    j = 0;
                }
            }
        }

        NajboljsaOcena();

    }//GEN-LAST:event_jSliderRedovalnicaPredmetOpravljenPropertyChange

    private void jSliderRedovalnicaPredmetOpravljenKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jSliderRedovalnicaPredmetOpravljenKeyReleased

    }//GEN-LAST:event_jSliderRedovalnicaPredmetOpravljenKeyReleased

    private void jSliderRedovalnicaPredmetOpravljenStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jSliderRedovalnicaPredmetOpravljenStateChanged

    }//GEN-LAST:event_jSliderRedovalnicaPredmetOpravljenStateChanged

    private void jSliderRedovalnicaPredmetOpravljenMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jSliderRedovalnicaPredmetOpravljenMouseReleased

    }//GEN-LAST:event_jSliderRedovalnicaPredmetOpravljenMouseReleased

    private void jButtonRedovalnicaUrediActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRedovalnicaUrediActionPerformed

        TabelaSeznam = false;                   //Odpre jDialogUrejanje v 3.tabu 
        TabelaRedovalnica = true;

        int rowTabele = 0;
        int index = jTableRedovalnica.getSelectedRow();

        String ID = "";
        String ID_tabele = "";

        //System.out.println(index);
        System.out.println(jTableRedovalnica.getValueAt(index, 0));

        if (index < 0) {
            JOptionPane.showMessageDialog(null, "Niste označili predmeta!");
        } else {

            for (int i = 0; i < stevec; i++) {
                ID = "";
                ID_tabele = "";

                ID = polje[i].getID();
                ID_tabele = String.valueOf(jTableRedovalnica.getValueAt(index, 0));

                if (ID.compareTo(ID_tabele) == 0) {

                    System.out.println(polje[i].getID() + "   " + String.valueOf(jTableRedovalnica.getValueAt(index, 0)));

                    rowTabele = i;

                    DefaultTableModel vrstica = (DefaultTableModel) jTableUrejanje.getModel();
                    vrstica.setRowCount(0);

                    jTextFieldID.setText(polje[i].getID());
                    jTextFieldImePredmeta.setText(polje[i].getImePredmeta());
                    jSliderLetnikUrejanje.setValue(polje[i].getLetnik());

                    if (polje[i].getSemester().compareTo("Zimski") == 0) {
                        jComboBoxSemester.setSelectedIndex(0);
                    } else if (polje[i].getSemester().compareTo("Poletni") == 0) {
                        jComboBoxSemester.setSelectedIndex(1);
                    }

                    jTextFieldImeNosilca.setText(polje[i].getImeNosilca());
                    jTextFieldECTS.setText(String.valueOf(polje[i].getECTS()));

                    String ocena = String.valueOf(polje[i].getOcena());

                    jTextFieldOcena.setText(ocena);

                    double zacasna = polje[i].getOcena();
                    int ZaokrozenaOcena = 0;
                    if (zacasna > 0 && zacasna < 10) {
                        ZaokrozenaOcena = 1;
                    } else if (zacasna >= 10 && zacasna < 20) {
                        ZaokrozenaOcena = 2;
                    } else if (zacasna >= 20 && zacasna < 30) {
                        ZaokrozenaOcena = 3;
                    } else if (zacasna >= 30 && zacasna < 40) {
                        ZaokrozenaOcena = 4;
                    } else if (zacasna >= 40 && zacasna < 50) {
                        ZaokrozenaOcena = 5;
                    } else if (zacasna >= 50 && zacasna < 60) {
                        ZaokrozenaOcena = 6;
                    } else if (zacasna >= 60 && zacasna < 70) {
                        ZaokrozenaOcena = 7;
                    } else if (zacasna >= 70 && zacasna < 80) {
                        ZaokrozenaOcena = 8;
                    } else if (zacasna >= 80 && zacasna < 90) {
                        ZaokrozenaOcena = 9;
                    } else if (zacasna >= 90 && zacasna <= 100) {
                        ZaokrozenaOcena = 10;
                    } else {
                        ZaokrozenaOcena = 0;
                    }

                    jTextFieldZaokrozenaOcena.setText(String.valueOf(ZaokrozenaOcena));

                    if (polje[i].getPredmetOpravljen() == true) {
                        jCheckBoxPredmetOpravljen.setSelected(true);
                    } else {
                        jCheckBoxPredmetOpravljen.setSelected(false);
                    }
                    break;
                }

            }

            DefaultTableModel nova_vrstica = (DefaultTableModel) jTableUrejanje.getModel();

            String[] a = (polje[rowTabele].getObveznosti()).split(",");
            String[] b = (polje[rowTabele].getTezaPredmetov()).split(",");
            String[] c = (polje[rowTabele].getOcene()).split(",");
            String[] d = (polje[rowTabele].getVrstaObveznosti()).split(",");

            for (int j = 0; j < a.length; j++) {
                if (a[j].compareTo("0") == 0 && b[j].compareTo("0") == 0 && c[j].compareTo("0") == 0 && d[j].compareTo("0") == 0); else {
                    nova_vrstica.addRow(new Object[]{a[j], b[j], c[j], d[j]});
                }
            }

            jDialogUrejanje.setSize(800, 425);
            jDialogUrejanje.setLocationRelativeTo(null);
            jDialogUrejanje.setVisible(true);
            jDialogUrejanje.setModal(true);

        }

    }//GEN-LAST:event_jButtonRedovalnicaUrediActionPerformed

    private void jButtonRedovalnicaSortOceneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRedovalnicaSortOceneActionPerformed

        TableRowSorter<TableModel> sorter = new TableRowSorter<TableModel>(jTableRedovalnica.getModel());       //Sortira ocene
        jTableRedovalnica.setRowSorter(sorter);

        ArrayList<RowSorter.SortKey> Sortiraj = new ArrayList<RowSorter.SortKey>();

        int SortiranStolpec = 3;
        Sortiraj.add(new RowSorter.SortKey(SortiranStolpec, SortOrder.DESCENDING));

        sorter.setSortKeys(Sortiraj);
        sorter.sort();


    }//GEN-LAST:event_jButtonRedovalnicaSortOceneActionPerformed

    private void jButtonRedovalnicaResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRedovalnicaResetActionPerformed

        jSliderRedovalnicaPredmetOpravljen.setValue(1);
        jRadioButtonSemesterOba.setSelected(true);

        NapolniTabeloRedovalnica();
        NajboljsaOcena();
        PridobljenECTS();

    }//GEN-LAST:event_jButtonRedovalnicaResetActionPerformed

    private void jButtonRedovalnicaSortOceneObveznostiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRedovalnicaSortOceneObveznostiActionPerformed

        TableRowSorter<TableModel> sorter = new TableRowSorter<TableModel>(jTableRedovalnica.getModel());       //Sortira ocene obveznosti
        jTableRedovalnica.setRowSorter(sorter);

        ArrayList<RowSorter.SortKey> Sortiraj = new ArrayList<RowSorter.SortKey>();

        int SortiranStolpec = 5;
        Sortiraj.add(new RowSorter.SortKey(SortiranStolpec, SortOrder.DESCENDING));

        sorter.setSortKeys(Sortiraj);
        sorter.sort();


    }//GEN-LAST:event_jButtonRedovalnicaSortOceneObveznostiActionPerformed

    private void jButtonRedovalnicaUrediObveznostiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRedovalnicaUrediObveznostiActionPerformed

        TabelaSeznam = false;           //Urejevanje obveznosti v jDialogUrejanje iz dinamičnega jPannela
        TabelaRedovalnica = true;

        int rowTabele = 0;
        int index = jTableRedovalnica.getSelectedRow();

        String ID = "";
        String ID_tabele = "";

        //System.out.println(index);
        //System.out.println(jTableRedovalnica.getValueAt(index, 0));
        if (index < 0) {
            JOptionPane.showMessageDialog(null, "Niste označili predmeta!");
        } else {

            for (int i = 0; i < stevec; i++) {
                ID = "";
                ID_tabele = "";

                ID = polje[i].getID();
                ID_tabele = String.valueOf(jTableRedovalnica.getValueAt(index, 0));

                if (ID.compareTo(ID_tabele) == 0) {

                    //System.out.println(polje[i].getID() + "   " + String.valueOf(jTableRedovalnica.getValueAt(index, 0)));
                    rowTabele = i;

                    DefaultTableModel vrstica = (DefaultTableModel) jTableUrejanje.getModel();
                    vrstica.setRowCount(0);

                    jTextFieldID.setText(polje[i].getID());
                    jTextFieldImePredmeta.setText(polje[i].getImePredmeta());
                    jSliderLetnikUrejanje.setValue(polje[i].getLetnik());

                    if (polje[i].getSemester().compareTo("Zimski") == 0) {
                        jComboBoxSemester.setSelectedIndex(0);
                    } else if (polje[i].getSemester().compareTo("Poletni") == 0) {
                        jComboBoxSemester.setSelectedIndex(1);
                    }

                    jTextFieldImeNosilca.setText(polje[i].getImeNosilca());
                    jTextFieldECTS.setText(String.valueOf(polje[i].getECTS()));

                    String ocena = String.valueOf(polje[i].getOcena());

                    jTextFieldOcena.setText(ocena);

                    double zacasna = polje[i].getOcena();
                    int ZaokrozenaOcena = 0;
                    if (zacasna > 0 && zacasna < 10) {
                        ZaokrozenaOcena = 1;
                    } else if (zacasna >= 10 && zacasna < 20) {
                        ZaokrozenaOcena = 2;
                    } else if (zacasna >= 20 && zacasna < 30) {
                        ZaokrozenaOcena = 3;
                    } else if (zacasna >= 30 && zacasna < 40) {
                        ZaokrozenaOcena = 4;
                    } else if (zacasna >= 40 && zacasna < 50) {
                        ZaokrozenaOcena = 5;
                    } else if (zacasna >= 50 && zacasna < 60) {
                        ZaokrozenaOcena = 6;
                    } else if (zacasna >= 60 && zacasna < 70) {
                        ZaokrozenaOcena = 7;
                    } else if (zacasna >= 70 && zacasna < 80) {
                        ZaokrozenaOcena = 8;
                    } else if (zacasna >= 80 && zacasna < 90) {
                        ZaokrozenaOcena = 9;
                    } else if (zacasna >= 90 && zacasna <= 100) {
                        ZaokrozenaOcena = 10;
                    } else {
                        ZaokrozenaOcena = 0;
                    }

                    jTextFieldZaokrozenaOcena.setText(String.valueOf(ZaokrozenaOcena));

                    if (polje[i].getPredmetOpravljen() == true) {
                        jCheckBoxPredmetOpravljen.setSelected(true);
                    } else {
                        jCheckBoxPredmetOpravljen.setSelected(false);
                    }
                    break;
                }

            }

            DefaultTableModel nova_vrstica = (DefaultTableModel) jTableUrejanje.getModel();

            String[] a = (polje[rowTabele].getObveznosti()).split(",");
            String[] b = (polje[rowTabele].getTezaPredmetov()).split(",");
            String[] c = (polje[rowTabele].getOcene()).split(",");
            String[] d = (polje[rowTabele].getVrstaObveznosti()).split(",");

            for (int j = 0; j < a.length; j++) {
                if (a[j].compareTo("0") == 0 && b[j].compareTo("0") == 0 && c[j].compareTo("0") == 0 && d[j].compareTo("0") == 0); else {
                    nova_vrstica.addRow(new Object[]{a[j], b[j], c[j], d[j]});
                }
            }

            jDialogUrejanje.setSize(800, 425);
            jDialogUrejanje.setLocationRelativeTo(null);
            jDialogUrejanje.setVisible(true);
            jDialogUrejanje.setModal(true);

        }


    }//GEN-LAST:event_jButtonRedovalnicaUrediObveznostiActionPerformed

    private void jButtonRedovalnicaResetObveznostiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRedovalnicaResetObveznostiActionPerformed

        jComboBoxRedovalnica.updateUI();

    }//GEN-LAST:event_jButtonRedovalnicaResetObveznostiActionPerformed

    private void jCheckBoxSeznamFiltriranjeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBoxSeznamFiltriranjeActionPerformed

        if (jCheckBoxSeznamFiltriranje.isSelected() == true) {      //Izklop in vklop filtriranja v 2.tabu
            jButtonShrani.setEnabled(false);
            jButtonDodajPredmet.setEnabled(false);
            jButtonOdstraniPredmet.setEnabled(false);

            jSliderLetnikFilter.setEnabled(true);
            jLabelLetnikSeznam.setEnabled(true);
            jLabelSeznamSemester.setEnabled(true);
            jRadioButtonSeznamSemesterOba.setEnabled(true);
            jRadioButtonSeznamSemesterZimski.setEnabled(true);
            jRadioButtonSeznamSemesterPoletni.setEnabled(true);
            jPanelSeznamFiltriranje.setEnabled(true);
            jRadioButtonSeznamSemesterOba.setSelected(true);

            jButtonSeznamGor.setEnabled(false);
            jButtonSeznamDol.setEnabled(false);
        } else if (jCheckBoxSeznamFiltriranje.isSelected() == false) {

            jButtonShrani.setEnabled(true);
            jButtonDodajPredmet.setEnabled(true);
            jButtonOdstraniPredmet.setEnabled(true);

            jSliderLetnikFilter.setEnabled(false);
            jLabelLetnikSeznam.setEnabled(false);
            jLabelSeznamSemester.setEnabled(false);
            jRadioButtonSeznamSemesterOba.setEnabled(false);
            jRadioButtonSeznamSemesterZimski.setEnabled(false);
            jRadioButtonSeznamSemesterPoletni.setEnabled(false);
            jPanelSeznamFiltriranje.setEnabled(false);

            jSliderLetnikFilter.setValue(0);
            jRadioButtonSeznamSemesterOba.setSelected(true);

            jButtonSeznamGor.setEnabled(true);
            jButtonSeznamDol.setEnabled(true);

            NapolniList();

        }

    }//GEN-LAST:event_jCheckBoxSeznamFiltriranjeActionPerformed

    private void jButtonNaloziIzbranoDatotekoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonNaloziIzbranoDatotekoActionPerformed

        Scanner vhod;           //Naložimo izbrano datoteko

        try {
            vhod = new Scanner(new FileReader(ImeDatoteke));
        } catch (FileNotFoundException e) {
            JOptionPane.showMessageDialog(null, "Napaka pri odpiranju datoteke!", "Napaka", ERROR);
            return;
        }

        while (vhod.hasNextLine()) {

            String vsebina = vhod.nextLine();
            String poljeVsebine[] = vsebina.split("\t");

            polje[stevec] = new Predmeti();

            polje[stevec].setID(poljeVsebine[0]);
            polje[stevec].setImePredmeta(poljeVsebine[1]);
            polje[stevec].setLetnik(Integer.parseInt(poljeVsebine[2]));
            polje[stevec].setSemester(poljeVsebine[3]);
            polje[stevec].setImeNosilca(poljeVsebine[4]);
            polje[stevec].setECTS(Integer.parseInt(poljeVsebine[5]));

            int st_obveznosti = 1;
            for (int i = 0; i < poljeVsebine[6].length() - 1; i++) {
                if ((poljeVsebine[6].charAt(i) == ',') && (poljeVsebine[6].charAt(i + 1) != ',')) {
                    st_obveznosti++;
                }
            }

            polje[stevec].setStObveznosti(st_obveznosti);

            polje[stevec].setObveznosti(poljeVsebine[6]);
            polje[stevec].setTezaPredmetov(poljeVsebine[7]);
            polje[stevec].setOcene(poljeVsebine[8]);
            polje[stevec].setVrstaObveznosti(poljeVsebine[9]);

            stevec++;
        }

        vhod.close();
        //System.out.print(stevec + " " + N);
        DefaultListModel model = new DefaultListModel();
        for (int i = 0; i < stevec; i++) {
            String zacasni = polje[i].getImePredmeta();
            model.addElement(zacasni);

        }
        jListPredmetov.setModel(model);
        NapolniComboBox();
        NapolniTabeloRedovalnica();
        NajboljsaOcena();
        PridobljenECTS();

        jTabbedPane.setEnabledAt(1, true);
        jTabbedPane.setEnabledAt(2, true);
        jTabbedPane.setEnabledAt(3, true);
        
        NapolniSeznamObveznosti();
        

    }//GEN-LAST:event_jButtonNaloziIzbranoDatotekoActionPerformed

    private void jButtonUvoziDatotekoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonUvoziDatotekoActionPerformed

        jFileChooser.setDialogTitle("Uvoz datoteke");       //Uvoz datoteke

        jFileChooser.setAcceptAllFileFilterUsed(false);
        FileNameExtensionFilter txt = new FileNameExtensionFilter("Txt datoteke", "txt");
        FileNameExtensionFilter dat = new FileNameExtensionFilter("Dat datoteke", "dat");

        jFileChooser.addChoosableFileFilter(txt);
        jFileChooser.addChoosableFileFilter(dat);

        jFileChooser.showOpenDialog(null);

        File f = jFileChooser.getSelectedFile();
        ImeDatoteke = f.getAbsolutePath();

        //System.out.println(ImeDatoteke);
    }//GEN-LAST:event_jButtonUvoziDatotekoActionPerformed

    private void jButtonNovaDatotekaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonNovaDatotekaActionPerformed

        jFileChooser.setDialogTitle("Ustvarite novo datoteko");     //Kreiranje nove datoteke

        int IzbiraUporabnika = jFileChooser.showSaveDialog(null);

        if (IzbiraUporabnika == jFileChooser.APPROVE_OPTION) {
            File f = jFileChooser.getSelectedFile();
            ImeDatoteke = f.getAbsolutePath() + ".dat";

            //System.out.println(ImeDatoteke);
            try (FileWriter Shrani = new FileWriter(jFileChooser.getSelectedFile() + ".dat")) {
                Shrani.write("");
                jButtonNaloziIzbranoDatoteko.setEnabled(false);
                jButtonIzberiDatoteko.setEnabled(false);
                jButtonUvoziDatoteko.setEnabled(false);

                jTabbedPane.setEnabledAt(1, true);
                jTabbedPane.setEnabledAt(2, true);

            } catch (IOException ex) {
                Logger.getLogger(JavaGUI.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }//GEN-LAST:event_jButtonNovaDatotekaActionPerformed

    private void jButtonIzberiDatotekoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonIzberiDatotekoActionPerformed

        Path pot = Paths.get("datoteka.dat");       //Naložimo "Default" datoteko

        ImeDatoteke = String.valueOf(pot);

        Scanner vhod;

        try {
            vhod = new Scanner(new FileReader(ImeDatoteke));
        } catch (FileNotFoundException e) {
            JOptionPane.showMessageDialog(null, "Napaka pri odpiranju datoteke!", "Napaka", ERROR);
            return;
        }

        while (vhod.hasNextLine()) {

            String vsebina = vhod.nextLine();
            String poljeVsebine[] = vsebina.split("\t");

            polje[stevec] = new Predmeti();

            polje[stevec].setID(poljeVsebine[0]);
            polje[stevec].setImePredmeta(poljeVsebine[1]);
            polje[stevec].setLetnik(Integer.parseInt(poljeVsebine[2]));
            polje[stevec].setSemester(poljeVsebine[3]);
            polje[stevec].setImeNosilca(poljeVsebine[4]);
            polje[stevec].setECTS(Integer.parseInt(poljeVsebine[5]));

            int st_obveznosti = 1;
            for (int i = 0; i < poljeVsebine[6].length() - 1; i++) {
                if ((poljeVsebine[6].charAt(i) == ',') && (poljeVsebine[6].charAt(i + 1) != ',')) {
                    st_obveznosti++;
                }
            }

            polje[stevec].setStObveznosti(st_obveznosti);

            polje[stevec].setObveznosti(poljeVsebine[6]);
            polje[stevec].setTezaPredmetov(poljeVsebine[7]);
            polje[stevec].setOcene(poljeVsebine[8]);
            polje[stevec].setVrstaObveznosti(poljeVsebine[9]);

            stevec++;
        }

        vhod.close();
        //System.out.print(stevec + " " + N);

        NapolniList();
        NapolniComboBox();
        NapolniTabeloRedovalnica();
        NajboljsaOcena();
        PridobljenECTS();

        jTabbedPane.setEnabledAt(1, true);
        jTabbedPane.setEnabledAt(2, true);
        jTabbedPane.setEnabledAt(3, true);
        
        
        NapolniSeznamObveznosti();          //Napolni seznam obveznosti z vrednostimi
        

        
    }//GEN-LAST:event_jButtonIzberiDatotekoActionPerformed

    private void jRadioButtonSeznamSemesterPoletniActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonSeznamSemesterPoletniActionPerformed

        int velikost = jListPredmetov.getModel().getSize();

        for (int i = 0; i < velikost; i++) {

            for (int j = 0; j < stevec; j++) {

                if (String.valueOf(jListPredmetov.getModel().getElementAt(i)).compareTo(polje[j].getImePredmeta()) == 0) {
                    if (polje[j].getSemester().compareTo("Poletni") != 0) {
                        //System.out.println(velikost);
                        ((DefaultListModel) jListPredmetov.getModel()).removeElementAt(i);

                        velikost = jListPredmetov.getModel().getSize();

                        i = 0;

                    }
                }

            }
        }

    }//GEN-LAST:event_jRadioButtonSeznamSemesterPoletniActionPerformed

    private void jSliderLetnikFilterPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jSliderLetnikFilterPropertyChange

        if (jSliderLetnikFilter.getValue() == 0) {      //Filtriranje letnika v 2.tabu
            NapolniList();
        } else if (jSliderLetnikFilter.getValue() == 1) {
            NapolniList();
            int velikost = jListPredmetov.getModel().getSize();

            for (int i = 0; i < velikost; i++) {

                for (int j = 0; j < stevec; j++) {

                    if (String.valueOf(jListPredmetov.getModel().getElementAt(i)).compareTo(polje[j].getImePredmeta()) == 0) {
                        if (polje[j].getLetnik() != 1) {
                            //System.out.println(velikost);
                            ((DefaultListModel) jListPredmetov.getModel()).removeElementAt(i);

                            velikost = jListPredmetov.getModel().getSize();

                            i = 0;

                        }
                    }

                }
            }
        } else if (jSliderLetnikFilter.getValue() == 2) {
            NapolniList();
            int velikost = jListPredmetov.getModel().getSize();

            for (int i = 0; i < velikost; i++) {

                for (int j = 0; j < stevec; j++) {

                    if (String.valueOf(jListPredmetov.getModel().getElementAt(i)).compareTo(polje[j].getImePredmeta()) == 0) {
                        if (polje[j].getLetnik() != 2) {
                            //System.out.println(velikost);
                            ((DefaultListModel) jListPredmetov.getModel()).removeElementAt(i);

                            velikost = jListPredmetov.getModel().getSize();

                            i = 0;

                        }
                    }

                }
            }
        } else if (jSliderLetnikFilter.getValue() == 3) {
            NapolniList();
            int velikost = jListPredmetov.getModel().getSize();

            for (int i = 0; i < velikost; i++) {

                for (int j = 0; j < stevec; j++) {

                    if (String.valueOf(jListPredmetov.getModel().getElementAt(i)).compareTo(polje[j].getImePredmeta()) == 0) {
                        if (polje[j].getLetnik() != 3) {
                            //System.out.println(velikost);
                            ((DefaultListModel) jListPredmetov.getModel()).removeElementAt(i);

                            velikost = jListPredmetov.getModel().getSize();

                            i = 0;

                        }
                    }

                }
            }
        }


    }//GEN-LAST:event_jSliderLetnikFilterPropertyChange

    private void jRadioButtonSeznamSemesterObaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonSeznamSemesterObaActionPerformed

        NapolniList();
        jSliderLetnikFilter.updateUI();

    }//GEN-LAST:event_jRadioButtonSeznamSemesterObaActionPerformed

    private void jRadioButtonSeznamSemesterZimskiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonSeznamSemesterZimskiActionPerformed

        //NapolniList();
        //jSliderLetnikFilter.updateUI();
        int velikost = jListPredmetov.getModel().getSize();

        for (int i = 0; i < velikost; i++) {

            for (int j = 0; j < stevec; j++) {

                if (String.valueOf(jListPredmetov.getModel().getElementAt(i)).compareTo(polje[j].getImePredmeta()) == 0) {
                    if (polje[j].getSemester().compareTo("Zimski") != 0) {
                        //System.out.println(velikost);
                        ((DefaultListModel) jListPredmetov.getModel()).removeElementAt(i);

                        velikost = jListPredmetov.getModel().getSize();

                        i = 0;

                    }
                }

            }
        }


    }//GEN-LAST:event_jRadioButtonSeznamSemesterZimskiActionPerformed

    private void jComboBoxIzbiraObveznostiPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jComboBoxIzbiraObveznostiPropertyChange
        
        IzpisPovprecneOceneObveznosti();        //Ko se spremeni vrednost se na novo(posodobi) izpiše povprečna ocena te obveznosti
        
        
    }//GEN-LAST:event_jComboBoxIzbiraObveznostiPropertyChange

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(JavaGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JavaGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JavaGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JavaGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JavaGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroupLetnik;
    private javax.swing.ButtonGroup buttonGroupRedovalnicaSemester;
    private javax.swing.ButtonGroup buttonGroupSeznamSemester;
    private javax.swing.JButton jButtonDodajObveznostTabela;
    private javax.swing.JButton jButtonDodajPredmet;
    private javax.swing.JButton jButtonDol;
    private javax.swing.JButton jButtonGor;
    private javax.swing.JButton jButtonIzberiDatoteko;
    private javax.swing.JButton jButtonNaloziIzbranoDatoteko;
    private javax.swing.JButton jButtonNovaDatoteka;
    private javax.swing.JButton jButtonOdstraniObveznostTabbela;
    private javax.swing.JButton jButtonOdstraniPredmet;
    private javax.swing.JButton jButtonRedovalnicaReset;
    private javax.swing.JButton jButtonRedovalnicaResetObveznosti;
    private javax.swing.JButton jButtonRedovalnicaSortOcene;
    private javax.swing.JButton jButtonRedovalnicaSortOceneObveznosti;
    private javax.swing.JButton jButtonRedovalnicaUredi;
    private javax.swing.JButton jButtonRedovalnicaUrediObveznosti;
    private javax.swing.JButton jButtonSeznamDol;
    private javax.swing.JButton jButtonSeznamGor;
    private javax.swing.JButton jButtonShrani;
    private javax.swing.JButton jButtonUredi;
    private javax.swing.JButton jButtonUvoziDatoteko;
    private javax.swing.JCheckBox jCheckBoxPredmetOpravljen;
    private javax.swing.JCheckBox jCheckBoxRedovalnicaLetnikOpravljen;
    private javax.swing.JCheckBox jCheckBoxSeznamFiltriranje;
    private javax.swing.JComboBox<String> jComboBoxIzbiraObveznosti;
    private javax.swing.JComboBox<String> jComboBoxRedovalnica;
    private javax.swing.JComboBox<String> jComboBoxSemester;
    private javax.swing.JDialog jDialogUrejanje;
    private javax.swing.JFileChooser jFileChooser;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabelDinamicniComboBox;
    private javax.swing.JLabel jLabelECTS;
    private javax.swing.JLabel jLabelID;
    private javax.swing.JLabel jLabelImeNosilca;
    private javax.swing.JLabel jLabelImePredmeta;
    private javax.swing.JLabel jLabelIzpisObveznosti;
    private javax.swing.JLabel jLabelLetnik;
    private javax.swing.JLabel jLabelLetnikSeznam;
    private javax.swing.JLabel jLabelLogo;
    private javax.swing.JLabel jLabelObveznostPovprecnaOcena;
    private javax.swing.JLabel jLabelOcenaPredmeta;
    private javax.swing.JLabel jLabelPovprecnaOcenaObveznosti;
    private javax.swing.JLabel jLabelPredmetOpravljen;
    private javax.swing.JLabel jLabelPredmeti;
    private javax.swing.JLabel jLabelRedovalnicaBestOcena;
    private javax.swing.JLabel jLabelRedovalnicaPodTabelo;
    private javax.swing.JLabel jLabelRedovalnicaPridobljenECTS;
    private javax.swing.JLabel jLabelRedovalnicaSlider1;
    private javax.swing.JLabel jLabelRedovalnicaSlider2;
    private javax.swing.JLabel jLabelRedovalnicaSlider3;
    private javax.swing.JLabel jLabelSeznamSemester;
    private javax.swing.JList<String> jListPredmetov;
    private javax.swing.JPanel jPanelDatoteka;
    private javax.swing.JPanel jPanelDialog;
    private javax.swing.JPanel jPanelDinamicna;
    private javax.swing.JPanel jPanelDoloceneObveznosti;
    private javax.swing.JPanel jPanelPovprecnaOcenaIzbraneObveznosti;
    private javax.swing.JPanel jPanelRedovalnica;
    private javax.swing.JPanel jPanelRedovalnicaPredmetOpravljen;
    private javax.swing.JPanel jPanelRedovalnicaSemester;
    private javax.swing.JPanel jPanelSeznam;
    private javax.swing.JPanel jPanelSeznamFiltriranje;
    private javax.swing.JPanel jPanelUrediOcene;
    private javax.swing.JRadioButton jRadioButtonSemesterOba;
    private javax.swing.JRadioButton jRadioButtonSemesterPoletni;
    private javax.swing.JRadioButton jRadioButtonSemesterZimski;
    private javax.swing.JRadioButton jRadioButtonSeznamSemesterOba;
    private javax.swing.JRadioButton jRadioButtonSeznamSemesterPoletni;
    private javax.swing.JRadioButton jRadioButtonSeznamSemesterZimski;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JSlider jSliderLetnikFilter;
    private javax.swing.JSlider jSliderLetnikUrejanje;
    private javax.swing.JSlider jSliderRedovalnicaPredmetOpravljen;
    private javax.swing.JTabbedPane jTabbedPane;
    private javax.swing.JTable jTableRedovalnica;
    private javax.swing.JTable jTableUrejanje;
    private javax.swing.JTextArea jTextAreaAbout;
    private javax.swing.JTextField jTextFieldECTS;
    private javax.swing.JTextField jTextFieldID;
    private javax.swing.JTextField jTextFieldImeNosilca;
    private javax.swing.JTextField jTextFieldImePredmeta;
    private javax.swing.JTextField jTextFieldOcena;
    private javax.swing.JTextField jTextFieldPovprecnaOcenaObveznosti;
    private javax.swing.JTextField jTextFieldPridobljenECTS;
    private javax.swing.JTextField jTextFieldRedovalnicaNajboljsaOcena;
    private javax.swing.JTextField jTextFieldRedovalnicaPodTabelo;
    private javax.swing.JTextField jTextFieldZaokrozenaOcena;
    private javax.swing.JToggleButton jToggleButtonRedovalnica;
    private javax.swing.JToggleButton jToggleButtonShraniSpremembe;
    // End of variables declaration//GEN-END:variables

    public void ShraniDatoteko() {  //Funkcija za shrambo

        PrintWriter izhod = null;

        try {
            izhod = new PrintWriter(new FileWriter(ImeDatoteke));
        } catch (FileNotFoundException e) {
            JOptionPane.showMessageDialog(null, "Napaka pri shranjevanju!");
        } catch (IOException ex) {
            Logger.getLogger(JavaGUI.class.getName()).log(Level.SEVERE, null, ex);
        }

        for (int i = 0; i < stevec; i++) {
            String vsebina = polje[i].getID() + "\t" + polje[i].getImePredmeta() + "\t" + polje[i].getLetnik() + "\t" + polje[i].getSemester() + "\t" + polje[i].getImeNosilca()
                    + "\t" + polje[i].getECTS() + "\t" + polje[i].getObveznosti() + "\t" + polje[i].getTezaPredmetov() + "\t" + polje[i].getOcene() + "\t" + polje[i].getVrstaObveznosti();
            izhod.println(vsebina);
        }
        izhod.close();
    }

    public void NapolniList() {         //Napolni list predmetov na 2.tabu
        
        DefaultListModel model = new DefaultListModel();
        for (int i = 0; i < stevec; i++) {
            String zacasni = polje[i].getImePredmeta();
            model.addElement(zacasni);

        }
        jListPredmetov.setModel(model);
    }

    public void NapolniTabelo() {   //Napolni tabelo v jDialogUrejanje
        
        int index = jListPredmetov.getSelectedIndex();
        DefaultTableModel vrstica = (DefaultTableModel) jTableUrejanje.getModel();

        String[] a = (polje[index].getObveznosti()).split(",");
        String[] b = (polje[index].getTezaPredmetov()).split(",");
        String[] c = (polje[index].getOcene()).split(",");
        String[] d = (polje[index].getVrstaObveznosti()).split(",");

        for (int i = 0; i < a.length; i++) {
            if (a[i].compareTo("0") == 0 && b[i].compareTo("0") == 0 && c[i].compareTo("0") == 0 && d[i].compareTo("0") == 0); else {
                vrstica.addRow(new Object[]{a[i], b[i], c[i], d[i]});
            }
        }
    }

    public void DodajVrstico() //Doda obveznost v jDialogUrejanje
    {
        String VrstaObveznosti = "";

        while (!VrstaObveznosti.matches("1") && !VrstaObveznosti.matches("2") && !VrstaObveznosti.matches("3") && !VrstaObveznosti.matches("4") && !VrstaObveznosti.matches("5") && !VrstaObveznosti.matches("6") && !VrstaObveznosti.matches("7") && !VrstaObveznosti.matches("8") && !VrstaObveznosti.matches("9") && !VrstaObveznosti.matches("10")) {
            //jDialogUrejanje.setVisible(false);
            VrstaObveznosti = JOptionPane.showInputDialog(null, "Izberite vrsto obveznosti\n1 - Kolokvij\n2 - Izpit\n3 - Pisni/Dodatni izpit\n4 - Ustni izpit\n5 - Računalniške vaje\n6 - Laboratorijske vaje\n7 - Domače naloge\n8 - Kviz\n9 - Projekt\n10 - Drugo", "Izbira vrste obveznosti", JOptionPane.QUESTION_MESSAGE);
            //jDialogUrejanje.setVisible(true);
//System.out.println(VrstaObveznosti);
        }
        //System.out.println(VrstaObveznosti);
        if (VrstaObveznosti.compareTo("") == 0) {
            return;
        }

        int index = 0;

        if (TabelaSeznam == true) {
            index = jListPredmetov.getSelectedIndex();
        } else if (TabelaRedovalnica == true) {
            for (int i = 0; i < stevec; i++) {
                if (polje[i].getID().compareTo(String.valueOf(jTableRedovalnica.getValueAt(index, 0))) == 0) {
                    index = i;
                }
            }
        }

        DefaultTableModel vrstica = (DefaultTableModel) jTableUrejanje.getModel();
        vrstica.addRow(new Object[]{"", "", "", VrstaObveznosti});
        int dodaj_obveznost = polje[index].getStObveznosti() + 1;
        polje[index].setStObveznosti(dodaj_obveznost);
    }

    public void IzbrisiDelArraya() //Odstrani eno obveznost + teza + ocene + vrsta obveznosti
    {
        int index = jListPredmetov.getSelectedIndex();
        int vrstica = jTableUrejanje.getSelectedRow();

        String original = polje[index].getObveznosti() + "\t" + polje[index].getTezaPredmetov() + "\t" + polje[index].getOcene() + "\t" + polje[index].getVrstaObveznosti();
        String[] Original, Obveznosti, TezaPredmetov, Ocene, VrsteObveznosti;

        Original = original.split("\t");

        //System.out.println("Delam");
        //System.out.println(Original[3]);
        Obveznosti = Original[0].split(",");
        TezaPredmetov = Original[1].split(",");
        Ocene = Original[2].split(",");
        VrsteObveznosti = Original[3].split(",");

        //System.out.println("delam");
        int logicna_velikost = jTableUrejanje.getRowCount();
        int tarca = vrstica;

        for (int i = tarca; i < logicna_velikost - 1; i++) {
            Obveznosti[i] = Obveznosti[i + 1];
            TezaPredmetov[i] = TezaPredmetov[i + 1];
            Ocene[i] = Ocene[i + 1];
            VrsteObveznosti[i] = VrsteObveznosti[i + 1];
        }

        logicna_velikost = logicna_velikost - 1;

        String[] NovObveznosti = new String[logicna_velikost];
        String[] NovTezaPredmetov = new String[logicna_velikost];
        String[] NovOcene = new String[logicna_velikost];
        String[] NovVrsteObveznosti = new String[logicna_velikost];

        //System.out.print("Delujem");
        for (int j = 0; j < logicna_velikost; j++) {
            NovObveznosti[j] = Obveznosti[j];
            NovTezaPredmetov[j] = TezaPredmetov[j];
            NovOcene[j] = Ocene[j];
            NovVrsteObveznosti[j] = VrsteObveznosti[j];
        }

        //for(int j=0;j<logicna_velikost;j++)System.out.println(NovObveznosti[j]);
        ((DefaultTableModel) jTableUrejanje.getModel()).removeRow(vrstica);

        polje[index].setStObveznosti(logicna_velikost);

        polje[index].setObveznosti(String.join(",", NovObveznosti));
        polje[index].setTezaPredmetov(String.join(",", NovTezaPredmetov));
        polje[index].setOcene(String.join(",", NovOcene));
        polje[index].setVrstaObveznosti(String.join(",", NovVrsteObveznosti));

    }

    public int DodajPredmet(int x) {        //Doda predmet na listu v 2.tabu

        String nov_predmet;
        nov_predmet = JOptionPane.showInputDialog("Vpišite ime novega predmeta.");
        //System.out.println(nov_predmet);

        if (nov_predmet == null) {
            return x;
        } else {

            polje[x] = new Predmeti();

            polje[stevec].setID("");
            polje[stevec].setImePredmeta(nov_predmet);
            polje[stevec].setLetnik(0);
            polje[stevec].setSemester("");
            polje[stevec].setImeNosilca("");
            polje[stevec].setECTS(0);
            polje[stevec].setStObveznosti(0);
            polje[stevec].setObveznosti("0");
            polje[stevec].setTezaPredmetov("0");
            polje[stevec].setVrstaObveznosti("0");
            polje[stevec].setOcene("0");

            x++;
            DefaultListModel model = new DefaultListModel();

            for (int i = 0; i < x; i++) {
                String zacasni = polje[i].getImePredmeta();
                model.addElement(zacasni);
            }
            jListPredmetov.setModel(model);

            return x;
        }
    }

    public int OdstraniPredmet(int x) { //Odstrani predmet v 2.tabu

        String tarca = jListPredmetov.getSelectedValue();

        for (int j = 0; j < x; j++) {
            if (polje[j].getImePredmeta().compareTo(tarca) == 0) {
                polje[j] = polje[x - 1];
                polje[x - 1] = null;
                x--;
                break;
            }
        }

        DefaultListModel model = new DefaultListModel();

        for (int i = 0; i < x; i++) {

            String zacasni = polje[i].getImePredmeta();
            model.addElement(zacasni);

        }
        jListPredmetov.setModel(model);

        return x;

    }

    public void ZamenjajPolji(int IzbranoPolje, int ZamenjanoPolje) {   //Zamenja 2 polji, uporaba za premikanje predmetov gor/dol
        Predmeti[] ZacasnoPolje = new Predmeti[1];

        ZacasnoPolje[0] = polje[ZamenjanoPolje];

        polje[ZamenjanoPolje] = polje[IzbranoPolje];
        polje[IzbranoPolje] = ZacasnoPolje[0];

    }

    public void NapolniComboBox() {
        for (int i = 1; i <= 3; i++) {
            jComboBoxRedovalnica.addItem(i + ". Letnik");
        }

    }

    public void NapolniComboBoxObveznosti() {
        jComboBoxRedovalnica.addItem("Kolokvij");
        jComboBoxRedovalnica.addItem("Izpit");
        jComboBoxRedovalnica.addItem("Pisni/Dodatni izpit");
        jComboBoxRedovalnica.addItem("Ustni izpit");
        jComboBoxRedovalnica.addItem("Računalniške vaje");
        jComboBoxRedovalnica.addItem("Laboratorijske vaje");
        jComboBoxRedovalnica.addItem("Domače naloge");
        jComboBoxRedovalnica.addItem("Kviz");
        jComboBoxRedovalnica.addItem("Projekt");
        jComboBoxRedovalnica.addItem("Drugo");
    }

    public void NapolniTabeloRedovalnica() {        //Napolni tabelo v 3. tabu z predmetami
        int OpravljenPredmet = 0;
        DefaultTableModel model = new DefaultTableModel();
        String column[] = {"ID predmeta", "Ime predmeta", "Ime nosilca predmeta", "Skupna ocena", "Opravljeno"};

        String zacasni_letnik = String.valueOf(jComboBoxRedovalnica.getSelectedIndex());
        //System.out.println(zacasni_letnik);
        int letnik = Integer.parseInt(zacasni_letnik) + 1;

        for (int x = 0; x < column.length; x++) {
            model.addColumn(column[x]);
        }

        for (int i = 0; i < stevec; i++) {
            if (polje[i].getLetnik() == letnik) {
                String Opravljen = "";
                if (polje[i].getPredmetOpravljen() == true) {
                    Opravljen = "DA";
                } else {
                    Opravljen = "NE";
                }

                model.addRow(new Object[]{polje[i].getID(), polje[i].getImePredmeta(), polje[i].getImeNosilca(), polje[i].getOcena(), Opravljen});
            }
        }

        String zacasna = "";
        double povprecna_ocena = 0;

        for (int j = 0; j < model.getRowCount(); j++) {
            zacasna = String.valueOf(model.getValueAt(j, 3));
            povprecna_ocena += Double.parseDouble(zacasna);
        }

        povprecna_ocena = povprecna_ocena / model.getRowCount();

        jTableRedovalnica.setModel(model);
        jTextFieldRedovalnicaPodTabelo.setText(String.valueOf(povprecna_ocena) + "%");
        //jRadioButtonSemesterOba.setSelected(true);

        jTableRedovalnica.getColumnModel().getColumn(1).setPreferredWidth(200);
        jTableRedovalnica.getColumnModel().getColumn(2).setPreferredWidth(200);
        jTableRedovalnica.getColumnModel().getColumn(3).setPreferredWidth(90);

        for (int j = 0; j < jTableRedovalnica.getRowCount(); j++) {
            if (String.valueOf(jTableRedovalnica.getValueAt(j, 4)).compareTo("DA") == 0) {
                OpravljenPredmet++;
            }
        }

        //System.out.println(OpravljenPredmet);
        //System.out.println(jTableRedovalnica.getRowCount());
        if (jTableRedovalnica.getRowCount() == 0) {

        } else {
            if (OpravljenPredmet == jTableRedovalnica.getRowCount()) {
                jCheckBoxRedovalnicaLetnikOpravljen.setSelected(true);
            } else {
                jCheckBoxRedovalnicaLetnikOpravljen.setSelected(false);
            }

        }
    }

    public void NapolniTabeloRedovalnicaObveznosti() {  //Napolni tabelo v 3. tabu z obveznostimi
        
        DefaultTableModel model = new DefaultTableModel();
        String IzbranaObveznost = String.valueOf(jComboBoxRedovalnica.getSelectedItem());
        String index = String.valueOf(jComboBoxRedovalnica.getSelectedIndex() + 1);
        //System.out.println(index);

        String[] VrsteObveznosti;

        String column[] = {"ID predmeta", "Ime predmeta", "Ime nosilca predmeta", "Izbrana obveznost", "Teža izbrane obveznosti", "Ocena obveznosti"};

        String[] polja = new String[polje.length];

        for (int x = 0; x < stevec; x++) {
            polja[x] = "";
        }

        for (int z = 0; z < column.length; z++) {
            model.addColumn(column[z]);
        }

        for (int i = 0; i < stevec; i++) {
            int uspesnost = 0;
            VrsteObveznosti = polje[i].getVrstaObveznosti().split(",");

            String sTezaPredmetov = "";
            String sOcene = "";

            for (int j = 0; j < VrsteObveznosti.length; j++) {
                if (index.compareTo(VrsteObveznosti[j]) == 0) //mogoce narobe
                {

                    polja[i] += String.valueOf(j) + ",";
                    uspesnost++;

                }

            }

            if (uspesnost != 0) {
                polja[i] = polja[i].substring(0, polja[i].length() - 1);
                String[] IzbranaPolja = polja[i].split(",");

                String[] TezaPredmetov = polje[i].getTezaPredmetov().split(",");
                String[] Ocene = polje[i].getOcene().split(",");

                for (int m = 0; m < polje[i].getStObveznosti(); m++) {
                    for (int n = 0; n < IzbranaPolja.length; n++) {
                        if (String.valueOf(m).compareTo(IzbranaPolja[n]) == 0) {
                            sTezaPredmetov += TezaPredmetov[m] + ",";
                            sOcene += Ocene[m] + ",";
                        }
                    }
                }

                sTezaPredmetov = sTezaPredmetov.substring(0, sTezaPredmetov.length() - 1);
                sOcene = sOcene.substring(0, sOcene.length() - 1);

                model.addRow(new Object[]{polje[i].getID(), polje[i].getImePredmeta(), polje[i].getImeNosilca(), IzbranaObveznost, sTezaPredmetov, sOcene});
            }

        }

        jTableRedovalnica.setModel(model);

        //String column[]={"ID predmeta","Ime predmeta","Ime nosilca predmeta",IzbranaObveznost,TezaIzbraneObveznosti,OcenaIzbraneObveznosti};
    }

    public void NajboljsaOcena() {  //Izpiše najboljšo oceno
        double max = 0;
        String predmet = "";
        for (int i = 0; i < jTableRedovalnica.getModel().getRowCount(); i++) {
            String pomozna = String.valueOf(jTableRedovalnica.getValueAt(i, 3));
            double zacasna = Double.parseDouble(pomozna);

            if (zacasna > max) {
                max = zacasna;
                predmet = String.valueOf(max) + " -> " + String.valueOf(jTableRedovalnica.getValueAt(i, 1));
            } else if (zacasna == max) {
                predmet += ", " + String.valueOf(jTableRedovalnica.getValueAt(i, 1));
            }
        }

        jTextFieldRedovalnicaNajboljsaOcena.setText(predmet);
    }

    public void NajboljsaObveznost() {  //Izpiše najboljšo obveznost
        //5. mesto
        String pomozniTab[];

        double max = 0;
        String predmet = "";
        for (int i = 0; i < jTableRedovalnica.getModel().getRowCount(); i++) {
            String pomozna = String.valueOf(jTableRedovalnica.getValueAt(i, 5));
            pomozniTab = pomozna.split(",");

            for (int j = 0; j < pomozniTab.length; j++) {
                if (Double.valueOf(pomozniTab[j]) > max) {
                    max = Double.valueOf(pomozniTab[j]);
                    predmet = String.valueOf(max) + " -> " + String.valueOf(jTableRedovalnica.getValueAt(i, 1));
                } else if (Double.valueOf(pomozniTab[j]) == max) {
                    predmet += ", " + String.valueOf(jTableRedovalnica.getValueAt(i, 1));
                }
            }

        }

        jTextFieldRedovalnicaNajboljsaOcena.setText(predmet);

    }

    public void PridobljenECTS() {  //Pridobljen ECTS letnika

        int pridobljenECTS = 0;

        //System.out.println(jTableRedovalnica.getRowCount());
        for (int i = 0; i < jTableRedovalnica.getRowCount(); i++) {
            for (int j = 0; j < stevec; j++) {
                if (polje[j].getPredmetOpravljen() == true) {
                    if (String.valueOf(jTableRedovalnica.getValueAt(i, 0)).compareTo(polje[j].getID()) == 0 && String.valueOf(jTableRedovalnica.getValueAt(i, 1)).compareTo(polje[j].getImePredmeta()) == 0) {
                        pridobljenECTS += polje[j].getECTS();
                    }
                }
            }

        }

        jTextFieldPridobljenECTS.setText(String.valueOf(pridobljenECTS));

    }

    public void SetIcon() {     //Nastavitev glavne ikone

        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("../Slike/logo.png")));

    }
    
    public void NapolniSeznamObveznosti()       //Napolnim ComboBox(seznam obveznosti) z vsemimi obveznostmi
    {
        
        jComboBoxIzbiraObveznosti.addItem("Kolokvij");
        jComboBoxIzbiraObveznosti.addItem("Izpit");
        jComboBoxIzbiraObveznosti.addItem("Pisni/Dodatni izpit");
        jComboBoxIzbiraObveznosti.addItem("Ustni izpit");
        jComboBoxIzbiraObveznosti.addItem("Računalniške vaje");
        jComboBoxIzbiraObveznosti.addItem("Laboratorijske vaje");
        jComboBoxIzbiraObveznosti.addItem("Domače naloge");
        jComboBoxIzbiraObveznosti.addItem("Kviz");
        jComboBoxIzbiraObveznosti.addItem("Projekt");
        jComboBoxIzbiraObveznosti.addItem("Drugo");
        
    }
    
    public void IzpisPovprecneOceneObveznosti()         //Izračun in vpis povprečne ocene določene obveznosti, ki je vzeta iz Seznama Obveznosti
    {
        int steviloObveznosti=0;
        double povprecje=0;
        
        int index = jComboBoxIzbiraObveznosti.getSelectedIndex()+1;     //Obveznosti imam zastavljene po številkah od 1-10, zato jih primerjam kar z indexom
        
        String obveznost=String.valueOf(jComboBoxIzbiraObveznosti.getSelectedItem());
        //System.out.println(index);
        
        String[] Obveznosti;
        String[] Ocene;
        
        for(int i=0;i<stevec;i++)
        {
            
            Obveznosti=(polje[i].getVrstaObveznosti()).split(",");  //Iz objekta "getam" vse vrste obveznosti, ki jih ta objekt ima(ocene,teze,vrste obveznosti so v istem vrstem redu)
            Ocene=(polje[i].getOcene()).split(",");                 //"getam" tudi ocene, ki jih rabim za izračun. Prvotno so v obliki stringa z vejicami, zato jih raje dam v polje
            
            for(int j=0;j<polje[i].getStObveznosti();j++)
            {
                if(Obveznosti[j].compareTo(String.valueOf(index))==0)
                {
                    povprecje+=Double.valueOf(Ocene[j]);            //Seštevanje ocen
                    steviloObveznosti++;                            //Štetje pojavitve obveznosti
                }
            }
        }
        
        if(steviloObveznosti>0)povprecje=povprecje/steviloObveznosti;                                      //Končen izračun povprečja
        else jTextFieldPovprecnaOcenaObveznosti.setText("Trenutno ni ocen za obveznost: "+obveznost);      //Če ni ocene za tako obveznost
        
        jTextFieldPovprecnaOcenaObveznosti.setText("Povprečna ocena od "+obveznost+" je -> "+String.valueOf(povprecje)+"%");    //Vpis povprečja v TextField  
       
    }
}
