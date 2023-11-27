package Vue;

import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.Font;
import java.awt.Color;
import javax.swing.border.TitledBorder;
import javax.swing.text.MaskFormatter;

import Controleur.GestionFenPaiement;
import Controleur.GestionSaisirBatiement;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import java.awt.SystemColor;
import java.text.ParseException;

import javax.swing.JSpinner;
import javax.swing.JFormattedTextField;
import javax.swing.SpinnerNumberModel;

@SuppressWarnings("serial")
public class SaisirBatiment extends JInternalFrame{
	private JTextField Fd_Adresse;
	private JTextField Fd_Ville;
	private GestionSaisirBatiement gsb;
	private JButton btn_Inserer;
	private JButton btn_Annuler;
	private JSpinner sp_CodePostal;
	private JSpinner sp_RegimeJuridique;
	private JFormattedTextField Fd_DateConstruction;
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
	public SaisirBatiment() throws ParseException {
		setBorder(new LineBorder(SystemColor.activeCaption, 2));
		setTitle("Saisie des informations");
		setBounds(100, 100, 471, 567);
		getContentPane().setLayout(null);
		this.gsb = new GestionSaisirBatiement(this);
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(14, 49, 439, 479);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel labelDebsemc = new JLabel("Adresse :");
		labelDebsemc.setFont(new Font("Tahoma", Font.BOLD, 10));
		labelDebsemc.setBounds(28, 31, 113, 13);
		panel.add(labelDebsemc);
		
		Fd_Adresse = new JTextField();
		Fd_Adresse.setBounds(186, 20, 231, 35);
		panel.add(Fd_Adresse);
		Fd_Adresse.setColumns(10);
		
		JLabel labelCP = new JLabel("Code Postal :");
		labelCP.setFont(new Font("Tahoma", Font.BOLD, 10));
		labelCP.setBounds(28, 113, 113, 13);
		panel.add(labelCP);
		
		JLabel labelVille = new JLabel("Ville :");
		labelVille.setFont(new Font("Tahoma", Font.BOLD, 10));
		labelVille.setBounds(28, 195, 113, 13);
		panel.add(labelVille);
		
		Fd_Ville = new JTextField();
		Fd_Ville.setColumns(10);
		Fd_Ville.setBounds(186, 184, 231, 35);
		panel.add(Fd_Ville);
		
		JLabel label_Id_GrpC = new JLabel("Regime Juridique :");
		label_Id_GrpC.setFont(new Font("Tahoma", Font.BOLD, 10));
		label_Id_GrpC.setBounds(28, 277, 113, 13);
		panel.add(label_Id_GrpC);
		
		JLabel labelHeureFC = new JLabel("Date Construction : ");
		labelHeureFC.setFont(new Font("Tahoma", Font.BOLD, 10));
		labelHeureFC.setBounds(28, 359, 113, 13);
		panel.add(labelHeureFC);
		
		
		btn_Inserer = new JButton("Inserer");
		btn_Inserer.addActionListener(this.gsb);
		btn_Inserer.setBounds(263, 436, 85, 21);
		panel.add(btn_Inserer);
		
		btn_Annuler = new JButton("Annuler");
		btn_Annuler.addActionListener(this.gsb);
		btn_Annuler.setBounds(89, 436, 85, 21);
		panel.add(btn_Annuler);
		
		sp_CodePostal = new JSpinner();
		sp_CodePostal.setModel(new SpinnerNumberModel(0, 0, 99999, 1));
		sp_CodePostal.setBounds(186, 102, 231, 35);
		panel.add(sp_CodePostal);
		
		sp_RegimeJuridique = new JSpinner();
		sp_RegimeJuridique.setModel(new SpinnerNumberModel(Float.valueOf(0), Float.valueOf(0), null, Float.valueOf(1)));
		sp_RegimeJuridique.setBounds(186, 266, 231, 35);
		panel.add(sp_RegimeJuridique);

        MaskFormatter dateFormatter = new MaskFormatter("####-##-##");
		Fd_DateConstruction = new JFormattedTextField(dateFormatter);
		Fd_DateConstruction.setText("0000-00-00");
		Fd_DateConstruction.setColumns(10);
		Fd_DateConstruction.setBounds(186, 348, 231, 35);
		panel.add(Fd_DateConstruction);
		
		JLabel lblNewLabel = new JLabel("Saisir les informations du batiment");
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 13));
		lblNewLabel.setBounds(115, 26, 236, 13);
		getContentPane().add(lblNewLabel);
	}


	public String getTextFieldDebsemc() {
		return this.Fd_Adresse.getText();
	}


	public int getTextFieldCP() {
		return (int)this.sp_CodePostal.getValue();
	}


	public String getTextFieldVille() {
		return this.Fd_Ville.getText();
	}


	public float getTextFieldRegimeJuridique() {
		return (float)this.sp_RegimeJuridique.getValue();
	}

	public String getTextFieldDateConstruction() {
		return this.Fd_DateConstruction.getText();
	}
	
	
	public GestionSaisirBatiement getGsb() {
		return gsb;
	}
	
	
}

