package Vue;

import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.Font;
import java.awt.Color;
import javax.swing.border.TitledBorder;

import Controleur.GestionFenPaiement;
import Controleur.GestionSaisirLogement;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import java.awt.SystemColor;

@SuppressWarnings("serial")
public class SaisirLogement extends JInternalFrame{
	private JTextField textFieldTypeLogement;
	private JTextField textFieldLoyer;
	private JTextField textFieldEtage;
	private JTextField textFieldICC;
	private JTextField textFieldGarage;
	private JTextField textFieldJardin;
	private GestionSaisirLogement gsl;
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
	public SaisirLogement() {
		setBorder(new LineBorder(SystemColor.activeCaption, 2));
		setTitle("Saisie des informations");
		setBounds(100, 100, 471, 567);
		getContentPane().setLayout(null);
		this.gsl = new GestionSaisirLogement(this);
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(10, 49, 439, 479);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel labelDebsemc = new JLabel("Type logement :");
		labelDebsemc.setFont(new Font("Tahoma", Font.BOLD, 10));
		labelDebsemc.setBounds(10, 40, 61, 13);
		panel.add(labelDebsemc);
		
		textFieldTypeLogement = new JTextField();
		textFieldTypeLogement.setBounds(133, 27, 231, 35);
		panel.add(textFieldTypeLogement);
		textFieldTypeLogement.setColumns(10);
		
		JLabel labelCP = new JLabel("loyer :");
		labelCP.setFont(new Font("Tahoma", Font.BOLD, 10));
		labelCP.setBounds(10, 109, 61, 13);
		panel.add(labelCP);
		
		textFieldLoyer = new JTextField();
		textFieldLoyer.setColumns(10);
		textFieldLoyer.setBounds(133, 96, 231, 35);
		panel.add(textFieldLoyer);
		
		JLabel labelVille = new JLabel("Etage :");
		labelVille.setFont(new Font("Tahoma", Font.BOLD, 10));
		labelVille.setBounds(10, 179, 61, 13);
		panel.add(labelVille);
		
		textFieldEtage = new JTextField();
		textFieldEtage.setColumns(10);
		textFieldEtage.setBounds(133, 166, 231, 35);
		panel.add(textFieldEtage);
		
		JLabel label_Id_GrpC = new JLabel("ICC :");
		label_Id_GrpC.setFont(new Font("Tahoma", Font.BOLD, 10));
		label_Id_GrpC.setBounds(10, 253, 113, 13);
		panel.add(label_Id_GrpC);
		
		textFieldICC = new JTextField();
		textFieldICC.setColumns(10);
		textFieldICC.setBounds(133, 240, 231, 35);
		panel.add(textFieldICC);
		
		JLabel labelHeureFC = new JLabel("Garage : ");
		labelHeureFC.setFont(new Font("Tahoma", Font.BOLD, 10));
		labelHeureFC.setBounds(10, 317, 61, 13);
		panel.add(labelHeureFC);
		
		textFieldGarage = new JTextField();
		textFieldGarage.setColumns(10);
		textFieldGarage.setBounds(133, 304, 231, 35);
		panel.add(textFieldGarage);
		
		JLabel labelTypeC = new JLabel("Jardin :");
		labelTypeC.setFont(new Font("Tahoma", Font.BOLD, 10));
		labelTypeC.setBounds(10, 386, 61, 13);
		panel.add(labelTypeC);
		
		textFieldJardin = new JTextField();
		textFieldJardin.setColumns(10);
		textFieldJardin.setBounds(133, 373, 231, 35);
		panel.add(textFieldJardin); 
		
		
		JButton btnInserer = new JButton("Inserer");
		btnInserer.addActionListener(this.gsl);
		btnInserer.setBounds(119, 436, 85, 21);
		panel.add(btnInserer);
		
		JButton btnAnnuler = new JButton("Annuler");
		btnAnnuler.addActionListener(this.gsl);
		btnAnnuler.setBounds(246, 436, 85, 21);
		panel.add(btnAnnuler);
		
		JLabel lblNewLabel = new JLabel("Saisir les informations du Logement");
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 13));
		lblNewLabel.setBounds(125, 26, 236, 13);
		getContentPane().add(lblNewLabel);
	}


	public JTextField getTextFieldTypeLogement() {
		return textFieldTypeLogement;
	}


	public JTextField getTextFieldLoyer() {
		return textFieldLoyer;
	}


	public JTextField getTextFieldEtage() {
		return textFieldEtage;
	}


	public JTextField getTextFieldICC() {
		return textFieldICC;
	}


	public JTextField getTextFieldGarage() {
		return textFieldGarage;
	}


	public JTextField getTextFieldJardin() {
		return textFieldJardin;
	}


	public GestionSaisirLogement getGsl() {
		return gsl;
	}
}

