package Vue;

import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.Font;
import java.awt.Color;
import javax.swing.border.TitledBorder;

import Controleur.GestionFenLocataire;
import Controleur.GestionSaisirLocataire;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import java.awt.SystemColor;

@SuppressWarnings("serial")
public class SaisirLocataire extends JInternalFrame{
	private JTextField textFieldNom;
	private JTextField textFieldPrenom;
	private JTextField textFieldTelephone;
	private JTextField textFieldIdDateNaissance;
	private JTextField textFieldEmail;
	private GestionSaisirLocataire gslo;
	// private JTable tableC;
	

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
	 */
	public SaisirLocataire() {
		setBorder(new LineBorder(SystemColor.activeCaption, 2));
		setTitle("Saisie des informations");
		setBounds(100, 100, 471, 567);
		getContentPane().setLayout(null); 
		this.gslo = new GestionSaisirLocataire(this);
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(10, 49, 439, 479);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel labelDebsemc = new JLabel("Nom :");
		labelDebsemc.setFont(new Font("Tahoma", Font.BOLD, 10));
		labelDebsemc.setBounds(10, 40, 61, 13);
		panel.add(labelDebsemc);
		
		textFieldNom = new JTextField();
		textFieldNom.setBounds(133, 27, 231, 35);
		panel.add(textFieldNom);
		textFieldNom.setColumns(10);
		
		JLabel labelCP = new JLabel("Prenom :");
		labelCP.setFont(new Font("Tahoma", Font.BOLD, 10));
		labelCP.setBounds(10, 109, 61, 13);
		panel.add(labelCP);
		
		textFieldPrenom = new JTextField();
		textFieldPrenom.setColumns(10);
		textFieldPrenom.setBounds(133, 96, 231, 35);
		panel.add(textFieldPrenom);
		
		JLabel labelVille = new JLabel("Telephone :");
		labelVille.setFont(new Font("Tahoma", Font.BOLD, 10));
		labelVille.setBounds(10, 179, 61, 13);
		panel.add(labelVille);
		
		textFieldTelephone = new JTextField();
		textFieldTelephone.setColumns(10);
		textFieldTelephone.setBounds(133, 166, 231, 35);
		panel.add(textFieldTelephone);
		
		JLabel label_Id_GrpC = new JLabel("Date naissance :");
		label_Id_GrpC.setFont(new Font("Tahoma", Font.BOLD, 10));
		label_Id_GrpC.setBounds(10, 253, 113, 13);
		panel.add(label_Id_GrpC);
		
		textFieldIdDateNaissance = new JTextField();
		textFieldIdDateNaissance.setColumns(10);
		textFieldIdDateNaissance.setBounds(133, 240, 231, 35);
		panel.add(textFieldIdDateNaissance);
		
		JLabel labelHeureFC = new JLabel("Email : ");
		labelHeureFC.setFont(new Font("Tahoma", Font.BOLD, 10));
		labelHeureFC.setBounds(10, 317, 61, 13);
		panel.add(labelHeureFC);
		
		textFieldEmail = new JTextField();
		textFieldEmail.setColumns(10);
		textFieldEmail.setBounds(133, 304, 231, 35);
		panel.add(textFieldEmail);
		
		JButton btnInserer = new JButton("Inserer");
		btnInserer.addActionListener(this.gslo);
		btnInserer.setBounds(119, 436, 85, 21);
		panel.add(btnInserer);
		
		JButton btnAnnuler = new JButton("Annuler");
		btnAnnuler.addActionListener(this.gslo);
		btnAnnuler.setBounds(246, 436, 85, 21);
		panel.add(btnAnnuler);
		
		JLabel lblNewLabel = new JLabel("Saisir les informations du locataire");
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 13));
		lblNewLabel.setBounds(125, 26, 236, 13);
		getContentPane().add(lblNewLabel);
	}


	public JTextField getTextFieldNom() {
		return textFieldNom;
	}


	public JTextField getTextFieldPrenom() {
		return textFieldPrenom;
	}


	public JTextField getTextFieldTelephone() {
		return textFieldTelephone;
	}


	public JTextField getTextFieldIdDateNaissance() {
		return textFieldIdDateNaissance;
	}


	public JTextField getTextFieldEmail() {
		return textFieldEmail;
	}

	public GestionSaisirLocataire getGslo() {
		return gslo;
	}
}

