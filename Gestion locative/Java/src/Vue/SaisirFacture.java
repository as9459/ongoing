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

import Controleur.GestionSaisirBatiement;
import Controleur.GestionSaisirFacture;

import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import java.awt.SystemColor;
import java.text.ParseException;

import javax.swing.JSpinner;
import javax.swing.JFormattedTextField;
import javax.swing.SpinnerNumberModel;

@SuppressWarnings("serial")
public class SaisirFacture extends JInternalFrame{
	private FenetrePrincipale mere;
	private FenFacture fac;
	private JTextField ID_Facture;
	private JTextField Description;
	private JSpinner MontantHT;
	private GestionSaisirFacture gsf;
	private JButton btn_Inserer;
	private JButton btn_Annuler;
	private JFormattedTextField dateFacture;
	private JTextField typeFacture;
	private JTextField tva;
	private JTextField siren;
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
	 * @param fac 
	 * @param mere 
	 * @throws ParseException 
	 */
	public SaisirFacture(FenetrePrincipale mere, FenFacture fac) throws ParseException {
		this.mere = mere;
		this.fac = fac;
		setBorder(new LineBorder(SystemColor.activeCaption, 2));
		setTitle("Saisie des informations");
		setBounds(100, 100, 471, 567);
		getContentPane().setLayout(null);
		this.gsf = new GestionSaisirFacture(this, this.mere, this.fac);
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(14, 49, 439, 479);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblIdFacture = new JLabel("ID Facture");
		lblIdFacture.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblIdFacture.setBounds(28, 52, 113, 35);
		panel.add(lblIdFacture);
		
		ID_Facture = new JTextField();
		ID_Facture.setBounds(186, 52, 231, 35);
		panel.add(ID_Facture);
		ID_Facture.setColumns(10);
		
		JLabel lblType = new JLabel("Type");
		lblType.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblType.setBounds(28, 290, 113, 13);
		panel.add(lblType);
		
		typeFacture = new JTextField();
		typeFacture.setBounds(186, 282, 231, 28);
		panel.add(typeFacture);
		typeFacture.setColumns(10);
		
		JLabel lblRfrenceDuPaiement = new JLabel("Description");
		lblRfrenceDuPaiement.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblRfrenceDuPaiement.setBounds(29, 162, 132, 13);
		panel.add(lblRfrenceDuPaiement);
		
		Description = new JTextField();
		Description.setColumns(10);
		Description.setBounds(186, 151, 231, 35);
		panel.add(Description);
		
		JLabel lblMontantHt = new JLabel("Montant HT");
		lblMontantHt.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblMontantHt.setBounds(28, 208, 113, 13);
		panel.add(lblMontantHt);
		
		MontantHT = new JSpinner();
		MontantHT.setBounds(186, 197, 231, 35);
		panel.add(MontantHT);
		
		JLabel lblTva = new JLabel("TVA");
		lblTva.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblTva.setBounds(28, 253, 113, 14);
		panel.add(lblTva);
		
		tva = new JTextField();
		tva.setBounds(186, 243, 231, 28);
		panel.add(tva);
		tva.setColumns(10);
		
		JLabel labelHeureFC = new JLabel("Date Facture");
		labelHeureFC.setFont(new Font("Tahoma", Font.BOLD, 11));
		labelHeureFC.setBounds(28, 116, 113, 13);
		panel.add(labelHeureFC);
		
		
		btn_Inserer = new JButton("Inserer");
		btn_Inserer.addActionListener(this.gsf);
		
		JLabel lblNewLabel_1 = new JLabel("SIREN");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_1.setBounds(28, 335, 46, 14);
		panel.add(lblNewLabel_1);
		
		siren = new JTextField();
		siren.setBounds(186, 327, 231, 28);
		panel.add(siren);
		siren.setColumns(10);
		btn_Inserer.setBounds(263, 436, 85, 21);
		panel.add(btn_Inserer);
		
		btn_Annuler = new JButton("Annuler");
		btn_Annuler.addActionListener(this.gsf);
		btn_Annuler.setBounds(89, 436, 85, 21);
		panel.add(btn_Annuler);

        MaskFormatter dateFormatter = new MaskFormatter("####-##-##");
		dateFacture = new JFormattedTextField(dateFormatter);
		dateFacture.setText("0000-00-00");
		dateFacture.setColumns(10);
		dateFacture.setBounds(186, 105, 231, 35);
		panel.add(dateFacture);
		
		JLabel lblNewLabel = new JLabel("Saisir les informations de la facture");
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 13));
		lblNewLabel.setBounds(115, 26, 236, 13);
		getContentPane().add(lblNewLabel);
	}


	public int getIDfacture() {
		String text = this.ID_Facture.getText();
		return Integer.parseInt(text);
	}

	public String getDateFacture() {
		return this.dateFacture.getText();
	}
	
	public float getmontantHT() {
		return (int) this.MontantHT.getValue();
	}
	
	public float getTVA() {
		String text = this.tva.getText();
		return Float.parseFloat(text);
	}
	
	public String getDescription() {
		return this.Description.getText();
	}
	
	public String getTypeFacture() {
		return this.typeFacture.getText();
	}
	
	public int getSiren() {
		String text = this.siren.getText();
		return Integer.parseInt(text);
	}
	
	public GestionSaisirFacture getGsf() {
		return gsf;
	}


	public void loadFactureInfo(String idfacture, String idbatiment, String refpaiement, String paiement, String type, String date) {
		// TODO Auto-generated method stub
		ID_Facture.setText(idfacture);
		typeFacture.setText(idbatiment);
		Description.setText(refpaiement);
		MontantHT.setValue(Double.parseDouble(paiement));
		tva.setText(type);
		dateFacture.setValue(date);
	}
}

