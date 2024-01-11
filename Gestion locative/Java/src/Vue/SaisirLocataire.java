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
	private GestionSaisirLocataire gslo;
	private JButton btnAnnuler;
	private JButton btnInserer;
	private JTextField idLocataire;
	private JTextField nom;
	private JTextField prenom;
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
		
		JLabel idLocataire_label = new JLabel("idLocataire");
		idLocataire_label.setFont(new Font("Tahoma", Font.BOLD, 11));
		idLocataire_label.setBounds(47, 105, 78, 14);
		getContentPane().add(idLocataire_label);
		
		idLocataire = new JTextField();
		idLocataire.setBounds(206, 100, 203, 28);
		getContentPane().add(idLocataire);
		idLocataire.setColumns(10);
		
		JLabel nom_label = new JLabel("Nom");
		nom_label.setFont(new Font("Tahoma", Font.BOLD, 11));
		nom_label.setBounds(47, 152, 46, 14);
		getContentPane().add(nom_label);
		
		nom = new JTextField();
		nom.setBounds(209, 145, 200, 28);
		getContentPane().add(nom);
		nom.setColumns(10);
		
		JLabel prenom_label = new JLabel("Prenom");
		prenom_label.setFont(new Font("Tahoma", Font.BOLD, 11));
		prenom_label.setBounds(47, 198, 46, 14);
		getContentPane().add(prenom_label);
		
		prenom = new JTextField();
		prenom.setBounds(212, 190, 197, 28);
		getContentPane().add(prenom);
		prenom.setColumns(10);
		
		JLabel telephone_label = new JLabel("Numéro de télephone");
		telephone_label.setFont(new Font("Tahoma", Font.BOLD, 11));
		telephone_label.setBounds(47, 252, 147, 14);
		getContentPane().add(telephone_label);
		
		JFormattedTextField tel = new JFormattedTextField();
		tel.setBounds(212, 243, 197, 28);
		getContentPane().add(tel);
		
		JLabel dateNaissance_label = new JLabel("Date de Naissance");
		dateNaissance_label.setFont(new Font("Tahoma", Font.BOLD, 11));
		dateNaissance_label.setBounds(47, 298, 131, 14);
		getContentPane().add(dateNaissance_label);
		
		JFormattedTextField dateN = new JFormattedTextField();
		dateN.setBounds(212, 292, 197, 28);
		getContentPane().add(dateN);
		
		JLabel statut_label = new JLabel("Statut");
		statut_label.setFont(new Font("Tahoma", Font.BOLD, 11));
		statut_label.setBounds(47, 346, 46, 14);
		getContentPane().add(statut_label);
		
		JComboBox statut = new JComboBox();
		statut.setBounds(212, 340, 197, 28);
		getContentPane().add(statut);
		
		JLabel email_label = new JLabel("E-mail");
		email_label.setFont(new Font("Tahoma", Font.BOLD, 11));
		email_label.setBounds(47, 392, 46, 14);
		getContentPane().add(email_label);
		
		mail = new JTextField();
		mail.setBounds(212, 389, 197, 28);
		getContentPane().add(mail);
		mail.setColumns(10);
		
		btnInserer = new JButton("Inserer");
		btnInserer.setBounds(68, 495, 124, 28);
		getContentPane().add(btnInserer);
		
		btnAnnuler = new JButton("Annuler");
		btnAnnuler.setBounds(271, 495, 124, 28);
		getContentPane().add(btnAnnuler);
		btnAnnuler.addActionListener(this.gslo);
		btnInserer.addActionListener(this.gslo);
	}


	

	public GestionSaisirLocataire getGslo() {
		return gslo;
	}
}

