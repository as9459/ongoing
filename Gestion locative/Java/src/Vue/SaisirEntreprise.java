package Vue;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.Font;
import java.awt.Color;
import javax.swing.border.TitledBorder;
import javax.swing.text.MaskFormatter;

import Controleur.GestionSaisirEntreprise;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import java.awt.SystemColor;
import java.text.ParseException;

import javax.swing.JSpinner;
import javax.swing.JFormattedTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.JTextPane;
import javax.swing.JComboBox;

@SuppressWarnings("serial")
public class SaisirEntreprise extends JInternalFrame{
	private JTextField nom;
	private JTextField FdAdresse;
	private JTextField siren;
	private GestionSaisirEntreprise gse;
	private FenetrePrincipale parent;
	private FenEntreprise fenee;
	private JButton btn_Inserer;
	private JButton btn_Annuler;
	private JTextField textFieldNom;
	private JTextField textFieldServes;
	private JTextField textFieldCP;
	private JTextField textFieldIban;
	private JTextField textFieldVille;
	private JTextField textFieldEmail;
	private JTextField textFieldTelephone;
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
	 * @throws ParseException 
	 */
	public SaisirEntreprise(FenetrePrincipale parent, FenEntreprise fenee) throws ParseException {
		this.parent = parent;
		this.fenee = fenee;
		setBorder(new LineBorder(SystemColor.activeCaption, 2));
		setTitle("Saisie des informations");
		setBounds(100, 100, 471, 567);
		getContentPane().setLayout(null);
		this.gse = new GestionSaisirEntreprise(this, this.parent, this.fenee);
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(14, 49, 439, 479);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel labelNom = new JLabel("Nom");
		labelNom.setFont(new Font("Tahoma", Font.BOLD, 11));
		labelNom.setBounds(28, 64, 113, 13);
		panel.add(labelNom);
		
		FdAdresse = new JTextField();
		FdAdresse.setColumns(10);
		FdAdresse.setBounds(186, 91, 231, 35);
		panel.add(FdAdresse);
		
		textFieldNom = new JTextField();
		textFieldNom.setBounds(186, 54, 231, 30);
		panel.add(textFieldNom);
		textFieldNom.setColumns(10);
		
		JLabel labelserves = new JLabel("SERVES");
		labelserves.setFont(new Font("Tahoma", Font.BOLD, 11));
		labelserves.setBounds(28, 101, 113, 13);
		panel.add(labelserves);
		
		textFieldServes = new JTextField();
		textFieldServes.setBounds(186, 95, 231, 30);
		panel.add(textFieldServes);
		textFieldServes.setColumns(10);
		
		JLabel labelAdresse = new JLabel("Adresse");
		labelAdresse.setFont(new Font("Tahoma", Font.BOLD, 11));
		labelAdresse.setBounds(28, 141, 113, 13);
		panel.add(labelAdresse);
		
		FdAdresse = new JTextField();
		FdAdresse.setColumns(10);
		FdAdresse.setBounds(186, 133, 231, 28);
		panel.add(FdAdresse);
		
		JLabel labelCP = new JLabel("CP");
		labelCP.setFont(new Font("Tahoma", Font.BOLD, 11));
		labelCP.setBounds(28, 183, 113, 13);
		panel.add(labelCP);
		
		textFieldCP = new JTextField();
		textFieldCP.setBounds(186, 172, 231, 27);
		panel.add(textFieldCP);
		textFieldCP.setColumns(10);
		
		JLabel labeliban = new JLabel("IBAN");
		labeliban.setFont(new Font("Tahoma", Font.BOLD, 11));
		labeliban.setBounds(28, 220, 113, 13);
		panel.add(labeliban);
		
		
		btn_Inserer = new JButton("Inserer");
		btn_Inserer.addActionListener(this.gse);
		
		textFieldIban = new JTextField();
		textFieldIban.setBounds(186, 212, 231, 28);
		panel.add(textFieldIban);
		textFieldIban.setColumns(10);
		
		JLabel lblVille = new JLabel("Ville");
		lblVille.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblVille.setBounds(28, 259, 46, 14);
		panel.add(lblVille);
		
		textFieldVille = new JTextField();
		textFieldVille.setBounds(186, 252, 231, 28);
		panel.add(textFieldVille);
		textFieldVille.setColumns(10);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblEmail.setBounds(28, 300, 46, 14);
		panel.add(lblEmail);
		
		textFieldEmail = new JTextField();
		textFieldEmail.setBounds(186, 295, 231, 28);
		panel.add(textFieldEmail);
		textFieldEmail.setColumns(10);
		
		JLabel lbltelephone = new JLabel("Telephone");
		lbltelephone.setFont(new Font("Tahoma", Font.BOLD, 11));
		lbltelephone.setBounds(28, 342, 74, 14);
		panel.add(lbltelephone);
		
		textFieldTelephone = new JTextField();
		textFieldTelephone.setBounds(186, 336, 231, 28);
		panel.add(textFieldTelephone);
		textFieldTelephone.setColumns(10);
		btn_Inserer.setBounds(263, 436, 85, 21);
		panel.add(btn_Inserer);
		
		btn_Annuler = new JButton("Annuler");
		btn_Annuler.addActionListener(this.gse);
		btn_Annuler.setBounds(89, 436, 85, 21);
		panel.add(btn_Annuler);
		
		JLabel lblIdSIREN = new JLabel("SIREN");
		lblIdSIREN.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblIdSIREN.setBounds(28, 29, 85, 14);
		panel.add(lblIdSIREN);
		
		siren = new JTextField();
		siren.setBounds(186, 18, 231, 28);
		panel.add(siren);
		
		JLabel lblNewLabel = new JLabel("Saisir les informations du Entreprise");
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 13));
		lblNewLabel.setBounds(115, 26, 236, 13);
		getContentPane().add(lblNewLabel);
	}


	public String getTextFdAdresse() {
		return this.FdAdresse.getText();
	}
	
	public String getTextFieldServes() {
		return this.textFieldServes.getText();
	}
	
	public String getTextFieldNom() {
		return this.textFieldNom.getText();
	}
	
	public String getTextFieldCP() {
		return this.textFieldCP.getText();
	}
	public String getTextFieldIban() {
		return this.textFieldIban.getText();
	}
	public String getTextFieldVille() {
		return this.textFieldVille.getText();
	}
	public String getTextFieldEmail() {
		return this.textFieldEmail.getText();
	}
	public String getTextFieldTelephone() {
		return this.textFieldTelephone.getText();
	}
	
	public String getsiren() {
		return this.siren.getText();
	}
	
	
	public GestionSaisirEntreprise getgse() {
		return gse;
	}

	
	
}

