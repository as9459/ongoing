package Vue;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.Font;
import java.awt.Color;
import java.awt.Component;

import javax.swing.border.TitledBorder;
import javax.swing.text.DefaultFormatterFactory;
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
	private GestionSaisirLocataire gslo;
	private FenetrePrincipale parent;
	private FenLocataire fenloca;
	private JButton btnAnnuler;
	private JButton btnInserer;
	private JButton btnModifier;
	private JTextField nom;
	private JTextField prenom;
	private JFormattedTextField tel;
	private JFormattedTextField dateN;
	private JComboBox statut;
	private JTextField mail;
	

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
	public SaisirLocataire(FenetrePrincipale mere, FenLocataire fenloca) throws ParseException {
		this.parent = mere;
		this.fenloca =fenloca;
        MaskFormatter dateFormatter = new MaskFormatter("##-##-####");
        MaskFormatter telephoneFormatter = new MaskFormatter("##-##-##-##-##");
        
		setBorder(new LineBorder(SystemColor.activeCaption, 2));
		setTitle("Saisie des informations");
		setBounds(100, 100, 463, 641);
		getContentPane().setLayout(null); 
		this.gslo = new GestionSaisirLocataire(this, this.parent, this.fenloca);
		
		JLabel lblNewLabel = new JLabel("Saisir les informations du locataire");
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 13));
		lblNewLabel.setBounds(125, 26, 236, 13);
		getContentPane().add(lblNewLabel);
		
		JLabel nom_label = new JLabel("Nom");
		nom_label.setFont(new Font("Tahoma", Font.BOLD, 11));
		nom_label.setBounds(47, 110, 46, 14);
		getContentPane().add(nom_label);
		
		nom = new JTextField();
		nom.setBounds(209, 103, 200, 28);
		getContentPane().add(nom);
		nom.setColumns(10);
		
		JLabel prenom_label = new JLabel("Prenom");
		prenom_label.setFont(new Font("Tahoma", Font.BOLD, 11));
		prenom_label.setBounds(47, 161, 46, 14);
		getContentPane().add(prenom_label);
		
		prenom = new JTextField();
		prenom.setBounds(209, 154, 197, 28);
		getContentPane().add(prenom);
		prenom.setColumns(10);
		
		JLabel telephone_label = new JLabel("Numéro de télephone");
		telephone_label.setFont(new Font("Tahoma", Font.BOLD, 11));
		telephone_label.setBounds(47, 212, 147, 14);
		getContentPane().add(telephone_label);
		
		tel = new JFormattedTextField();
		tel.setFormatterFactory(new DefaultFormatterFactory(telephoneFormatter));
		tel.setBounds(209, 205, 197, 28);
		getContentPane().add(tel);
		
		JLabel dateNaissance_label = new JLabel("Date de Naissance");
		dateNaissance_label.setFont(new Font("Tahoma", Font.BOLD, 11));
		dateNaissance_label.setBounds(47, 266, 131, 14);
		getContentPane().add(dateNaissance_label);
		
		dateN = new JFormattedTextField();
		dateN.setFormatterFactory(new DefaultFormatterFactory(dateFormatter));
		dateN.setBounds(209, 259, 197, 28);
		getContentPane().add(dateN);
		
		JLabel statut_label = new JLabel("Statut");
		statut_label.setFont(new Font("Tahoma", Font.BOLD, 11));
		statut_label.setBounds(47, 322, 46, 14);
		getContentPane().add(statut_label);
		
		statut = new JComboBox();
		statut.setModel(new DefaultComboBoxModel(new String[] {"Etudiant", "Salarié"}));
		statut.setBounds(209, 315, 197, 28);
		getContentPane().add(statut);
		
		JLabel email_label = new JLabel("E-mail");
		email_label.setFont(new Font("Tahoma", Font.BOLD, 11));
		email_label.setBounds(47, 370, 46, 14);
		getContentPane().add(email_label);
		
		mail = new JTextField();
		mail.setBounds(209, 363, 197, 28);
		getContentPane().add(mail);
		mail.setColumns(10);
		
		btnInserer = new JButton("Inserer");
		btnInserer.setBounds(68, 495, 124, 28);
		getContentPane().add(btnInserer);
		
		btnAnnuler = new JButton("Annuler");
		btnAnnuler.setBounds(271, 495, 124, 28);
		getContentPane().add(btnAnnuler);
		
		btnModifier = new JButton("Modifier");
		btnModifier.setBounds(184, 550, 94, 28);
		getContentPane().add(btnModifier);
		
		
		
		
		btnAnnuler.addActionListener(this.gslo);
		btnInserer.addActionListener(this.gslo);
		btnModifier.addActionListener(this.gslo);
	}

	public String getNom() {
		return this.nom.getText();
	}
	
	public String getPrenom() {
		return this.prenom.getText();
	}
	
	public String getTel() {
		return this.tel.getText();
	}
	
	public String getDate() {
		return this.dateN.getText();
	}
	
	public String getMail() {
		return this.mail.getText();
	}
	
	public String getStatut() {
		return this.statut.getItemAt(this.statut.getSelectedIndex()).toString();
	}
	
	
	

	public GestionSaisirLocataire getGslo() {
		return gslo;
	}
	
	public void loadLocataireInfo(String sNom, String sPrenom, String sTele, String sDateNaissance, String sStatut, String mail2) {
		// TODO Auto-generated method stub
		nom.setText(sNom);
		prenom.setText(sPrenom);
		tel.setText(sTele);
		dateN.setText(sDateNaissance);
		statut.getModel().setSelectedItem(sStatut);
		mail.setText(mail2);
	}
}

