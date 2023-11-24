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
import Controleur.GestionSaisirBatiement;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import java.awt.SystemColor;

@SuppressWarnings("serial")
public class SaisirBatiment extends JInternalFrame{
	private JTextField textFieldDebsemc;
	private JTextField textFieldCP;
	private JTextField textFieldVille;
	private JTextField textFieldIdGrpC;
	private JTextField textFieldDateConstruction;
	private GestionSaisirBatiement gsb;
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
	public SaisirBatiment() {
		setBorder(new LineBorder(SystemColor.activeCaption, 2));
		setTitle("Saisie des informations");
		setBounds(100, 100, 471, 567);
		getContentPane().setLayout(null);
		this.gsb = new GestionSaisirBatiement(this);
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(10, 49, 439, 479);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel labelDebsemc = new JLabel("Adresse :");
		labelDebsemc.setFont(new Font("Tahoma", Font.BOLD, 10));
		labelDebsemc.setBounds(10, 40, 61, 13);
		panel.add(labelDebsemc);
		
		textFieldDebsemc = new JTextField();
		textFieldDebsemc.setBounds(133, 27, 231, 35);
		panel.add(textFieldDebsemc);
		textFieldDebsemc.setColumns(10);
		
		JLabel labelCP = new JLabel("Code Postal :");
		labelCP.setFont(new Font("Tahoma", Font.BOLD, 10));
		labelCP.setBounds(10, 109, 61, 13);
		panel.add(labelCP);
		
		textFieldCP = new JTextField();
		textFieldCP.setColumns(10);
		textFieldCP.setBounds(133, 96, 231, 35);
		panel.add(textFieldCP);
		
		JLabel labelVille = new JLabel("Ville :");
		labelVille.setFont(new Font("Tahoma", Font.BOLD, 10));
		labelVille.setBounds(10, 179, 61, 13);
		panel.add(labelVille);
		
		textFieldVille = new JTextField();
		textFieldVille.setColumns(10);
		textFieldVille.setBounds(133, 166, 231, 35);
		panel.add(textFieldVille);
		
		JLabel label_Id_GrpC = new JLabel("Regime Juridique :");
		label_Id_GrpC.setFont(new Font("Tahoma", Font.BOLD, 10));
		label_Id_GrpC.setBounds(10, 253, 113, 13);
		panel.add(label_Id_GrpC);
		
		textFieldIdGrpC = new JTextField();
		textFieldIdGrpC.setColumns(10);
		textFieldIdGrpC.setBounds(133, 240, 231, 35);
		panel.add(textFieldIdGrpC);
		
		JLabel labelHeureFC = new JLabel("Date Construction : ");
		labelHeureFC.setFont(new Font("Tahoma", Font.BOLD, 10));
		labelHeureFC.setBounds(10, 317, 61, 13);
		panel.add(labelHeureFC);
		
		textFieldDateConstruction = new JTextField();
		textFieldDateConstruction.setColumns(10);
		textFieldDateConstruction.setBounds(133, 304, 231, 35);
		panel.add(textFieldDateConstruction);
		
		
		JButton btnInserer = new JButton("Inserer");
		btnInserer.addActionListener(this.gsb);
		btnInserer.setBounds(119, 436, 85, 21);
		panel.add(btnInserer);
		
		JButton btnAnnuler = new JButton("Annuler");
		btnAnnuler.addActionListener(this.gsb);
		btnAnnuler.setBounds(246, 436, 85, 21);
		panel.add(btnAnnuler);
		
		JLabel lblNewLabel = new JLabel("Saisir les informations du batiment");
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 13));
		lblNewLabel.setBounds(125, 26, 236, 13);
		getContentPane().add(lblNewLabel);
	}


	public JTextField getTextFieldDebsemc() {
		return textFieldDebsemc;
	}


	public JTextField getTextFieldCP() {
		return textFieldCP;
	}


	public JTextField getTextFieldVille() {
		return textFieldVille;
	}


	public JTextField getTextFieldIdGrpC() {
		return textFieldIdGrpC;
	}


	public JTextField getTextFieldDateConstruction() {
		return textFieldDateConstruction;
	}


	public GestionSaisirBatiement getGsb() {
		return gsb;
	}
}

