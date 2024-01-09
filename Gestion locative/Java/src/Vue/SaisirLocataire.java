package Vue;

import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.Font;
import java.awt.Color;
import java.awt.Component;

import javax.swing.border.TitledBorder;
import javax.swing.text.MaskFormatter;

import Controleur.GestionFenLocataire;
import Controleur.GestionSaisirLocataire;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import java.awt.SystemColor;
import java.text.ParseException;

import javax.swing.JTabbedPane;
import javax.swing.border.EmptyBorder;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.JCheckBox;

@SuppressWarnings("serial")
public class SaisirLocataire extends JInternalFrame{
	private JTextField Fd_Nom;
	private JTextField Fd_Prenom;
	private JTextField Fd_Statut;
	private GestionSaisirLocataire gslo;
	private JButton btnAnnuler;
	// private JTable tableC;
	private JComboBox CB_NbBatement;
	private JComboBox CB_NbLogement;
	private JFormattedTextField Fd_dateFebut;
	private JFormattedTextField Fd_dateFin;
	private JSpinner sp_loyer;
	private JSpinner sp_chargeFixes;
	private JSpinner sp_JourPaiment;
	private JSpinner sp_FraisAgence;
	private JCheckBox chckbxNewCheckBox;
	private JButton btnInserer;
	private JTextField Fd_GarantNom;
	private JTextField Fd_GarantMail;
	private JTextField Fd_GarantAdresse;
	private JFormattedTextField Fd_DateNaissance;
	private JFormattedTextField Fd_GarantTel;
	private JCheckBox chckbx_AddGarant;
	

	/**
	 * Launch the application.
	 */
	/*
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SaisirCreneau frame = new SaisirCreneau(null);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	*/

	/**
	 * Create the frame.
	 * @throws ParseException 
	 */
	public SaisirLocataire() throws ParseException {
        MaskFormatter dateFormatter = new MaskFormatter("####-##-##");
        MaskFormatter telephoneFormatter = new MaskFormatter("## ## ## ## ##");
        
		setBorder(new LineBorder(SystemColor.activeCaption, 2));
		setTitle("Saisie des informations");
		setBounds(100, 100, 464, 707);
		getContentPane().setLayout(null); 
		this.gslo = new GestionSaisirLocataire(this);
		
		JLabel lblNewLabel = new JLabel("Saisir les informations du locataire");
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 13));
		lblNewLabel.setBounds(125, 26, 236, 13);
		getContentPane().add(lblNewLabel);



		

		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(10, 49, 439, 495);
		getContentPane().add(tabbedPane);
		
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("Locataire", null, panel_1, null);
		tabbedPane.setEnabledAt(0, true);
		panel_1.setLayout(null);
		
		Fd_Nom = new JTextField();
		Fd_Nom.setBounds(170, 27, 231, 35);
		panel_1.add(Fd_Nom);
		Fd_Nom.setColumns(10);
		
		JLabel labelDebsemc = new JLabel("Nom :");
		labelDebsemc.setBounds(47, 40, 61, 13);
		panel_1.add(labelDebsemc);
		labelDebsemc.setFont(new Font("Tahoma", Font.BOLD, 10));
		
		Fd_Prenom = new JTextField();
		Fd_Prenom.setBounds(170, 95, 231, 35);
		panel_1.add(Fd_Prenom);
		Fd_Prenom.setColumns(10);
		
		JLabel labelCP = new JLabel("Prenom :");
		labelCP.setBounds(47, 108, 61, 13);
		panel_1.add(labelCP);
		labelCP.setFont(new Font("Tahoma", Font.BOLD, 10));
		
		JLabel labelVille = new JLabel("Telephone :");
		labelVille.setBounds(47, 178, 61, 13);
		panel_1.add(labelVille);
		labelVille.setFont(new Font("Tahoma", Font.BOLD, 10));
		
		JLabel label_Id_GrpC = new JLabel("Date naissance :");
		label_Id_GrpC.setBounds(47, 252, 113, 13);
		panel_1.add(label_Id_GrpC);
		label_Id_GrpC.setFont(new Font("Tahoma", Font.BOLD, 10));
		
		Fd_Statut = new JTextField();
		Fd_Statut.setBounds(170, 303, 231, 35);
		panel_1.add(Fd_Statut);
		Fd_Statut.setColumns(10);
		
		JLabel labelStatut = new JLabel("Statut : ");
		labelStatut.setBounds(47, 316, 61, 13);
		panel_1.add(labelStatut);
		labelStatut.setFont(new Font("Tahoma", Font.BOLD, 10));

		JFormattedTextField Fd_telephone = new JFormattedTextField(telephoneFormatter);
		Fd_telephone.setBounds(170, 167, 231, 35);
		panel_1.add(Fd_telephone);
		
		Fd_DateNaissance = new JFormattedTextField(dateFormatter);
		Fd_DateNaissance.setText("0000-00-00");
		Fd_DateNaissance.setBounds(170, 241, 231, 35);
		panel_1.add(Fd_DateNaissance);
		
		JPanel panel_2 = new JPanel();
		tabbedPane.addTab("Contrat", null, panel_2, null);
		tabbedPane.setEnabledAt(1, true);
		panel_2.setLayout(null);
		
		CB_NbBatement = new JComboBox();
		CB_NbBatement.setBounds(32, 75, 126, 22);
		panel_2.add(CB_NbBatement);
		
		CB_NbLogement = new JComboBox();
		CB_NbLogement.setBounds(223, 75, 126, 22);
		panel_2.add(CB_NbLogement);

		Fd_dateFebut = new JFormattedTextField(dateFormatter);
		Fd_dateFebut.setText("0000-00-00");
		Fd_dateFebut.setBounds(32, 149, 126, 20);
		panel_2.add(Fd_dateFebut);
		
		Fd_dateFin = new JFormattedTextField(dateFormatter);
		Fd_dateFin.setText("0000-00-00");
		Fd_dateFin.setBounds(223, 149, 126, 20);
		panel_2.add(Fd_dateFin);
		
		JLabel lblNewLabel_1 = new JLabel("Le numero du batement :");
		lblNewLabel_1.setBounds(32, 42, 126, 22);
		panel_2.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Le numero du logement :");
		lblNewLabel_2.setBounds(223, 42, 126, 22);
		panel_2.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Date debut :");
		lblNewLabel_3.setBounds(32, 123, 126, 22);
		panel_2.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Date fin :");
		lblNewLabel_4.setBounds(223, 123, 126, 22);
		panel_2.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Loyer :");
		lblNewLabel_5.setBounds(32, 190, 126, 22);
		panel_2.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("charfes fixes :");
		lblNewLabel_6.setBounds(223, 190, 126, 22);
		panel_2.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("Frais d'agence :");
		lblNewLabel_7.setBounds(32, 270, 126, 22);
		panel_2.add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("Jour paiement :");
		lblNewLabel_8.setBounds(223, 270, 126, 22);
		panel_2.add(lblNewLabel_8);
		
		sp_loyer = new JSpinner();
		sp_loyer.setModel(new SpinnerNumberModel(Float.valueOf(0), Float.valueOf(0), null, Float.valueOf(1)));
		sp_loyer.setBounds(32, 211, 126, 20);
		panel_2.add(sp_loyer);
		
		sp_chargeFixes = new JSpinner();
		sp_chargeFixes.setModel(new SpinnerNumberModel(Float.valueOf(0), Float.valueOf(0), null, Float.valueOf(1)));
		sp_chargeFixes.setBounds(223, 211, 126, 20);
		panel_2.add(sp_chargeFixes);
		
		sp_JourPaiment = new JSpinner();
		sp_JourPaiment.setModel(new SpinnerNumberModel(1, 1, 30, 1));
		sp_JourPaiment.setBounds(223, 292, 126, 20);
		panel_2.add(sp_JourPaiment);
		
		sp_FraisAgence = new JSpinner();
		sp_FraisAgence.setModel(new SpinnerNumberModel(Float.valueOf(0), Float.valueOf(0), null, Float.valueOf(1)));
		sp_FraisAgence.setBounds(32, 292, 126, 20);
		panel_2.add(sp_FraisAgence);
		
		chckbxNewCheckBox = new JCheckBox("solod TC");
		chckbxNewCheckBox.setBounds(32, 420, 97, 23);
		panel_2.add(chckbxNewCheckBox);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new EmptyBorder(0, 0, 0, 0));
		tabbedPane.addTab("Garant", null, panel_3, null);
		tabbedPane.setEnabledAt(2, true);
		panel_3.setLayout(null);
		
		chckbx_AddGarant = new JCheckBox("avoir un Garant");
		chckbx_AddGarant.setBounds(19, 7, 132, 23);
		panel_3.add(chckbx_AddGarant);
		
		Fd_GarantNom = new JTextField();
		Fd_GarantNom.setColumns(10);
		Fd_GarantNom.setBounds(142, 57, 231, 35);
		panel_3.add(Fd_GarantNom);
		
		JLabel labelNom = new JLabel("Nom :");
		labelNom.setFont(new Font("Tahoma", Font.BOLD, 10));
		labelNom.setBounds(56, 68, 61, 13);
		panel_3.add(labelNom);
		
		JLabel labelVille_1 = new JLabel("Telephone :");
		labelVille_1.setFont(new Font("Tahoma", Font.BOLD, 10));
		labelVille_1.setBounds(56, 192, 61, 13);
		panel_3.add(labelVille_1);
		
		Fd_GarantMail = new JTextField();
		Fd_GarantMail.setColumns(10);
		Fd_GarantMail.setBounds(142, 252, 231, 35);
		panel_3.add(Fd_GarantMail);
		
		JLabel labelStatut_1 = new JLabel("Statut : ");
		labelStatut_1.setFont(new Font("Tahoma", Font.BOLD, 10));
		labelStatut_1.setBounds(56, 263, 61, 13);
		panel_3.add(labelStatut_1);
		
		Fd_GarantAdresse = new JTextField();
		Fd_GarantAdresse.setColumns(10);
		Fd_GarantAdresse.setBounds(142, 117, 231, 35);
		panel_3.add(Fd_GarantAdresse);
		
		JLabel labelVille_1_1 = new JLabel("Adresse :");
		labelVille_1_1.setFont(new Font("Tahoma", Font.BOLD, 10));
		labelVille_1_1.setBounds(56, 128, 61, 13);
		panel_3.add(labelVille_1_1);
		
		Fd_GarantTel = new JFormattedTextField(telephoneFormatter);
		Fd_GarantTel.setText("00 00 00 00 00");
		Fd_GarantTel.setBounds(144, 188, 231, 35);
		panel_3.add(Fd_GarantTel);
		
		btnInserer = new JButton("Inserer");
		btnInserer.setBounds(70, 617, 124, 28);
		getContentPane().add(btnInserer);
		
		btnAnnuler = new JButton("Annuler");
		btnAnnuler.setBounds(285, 617, 124, 28);
		getContentPane().add(btnAnnuler);
		btnAnnuler.addActionListener(this.gslo);
		btnInserer.addActionListener(this.gslo);
	}


	public JTextField getTextFieldNom() {
		return Fd_Nom;
	}


	public JTextField getTextFieldPrenom() {
		return Fd_Prenom;
	}



	public JTextField getTextFieldIdDateNaissance() {
		return Fd_DateNaissance;
	}


	public JTextField getTextFieldStatut() {
		return Fd_Statut;
	}

	public GestionSaisirLocataire getGslo() {
		return gslo;
	}
	
	
	
	
}

