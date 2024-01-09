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
import Controleur.GestionSaisirPaiement;

import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import java.awt.SystemColor;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;

import javax.swing.JSpinner;
import javax.swing.JFormattedTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JLayeredPane;

@SuppressWarnings("serial")
public class SaisirPaiement extends JInternalFrame{
	private FenetrePrincipale parent;
	private FenPaiement fenepaie;
	private JTextField id_facture;
	private GestionSaisirPaiement gsb;
	private JButton btn_Inserer;
	private JButton btn_Annuler;
	private JSpinner montantPaiement;
	private JTextField refPaiement;
	private JComboBox BatimentcomboBox;
	private JComboBox LogementcomboBox_1;
	private JComboBox LocatairecomboBox_2;
	private JSpinner sp_MontantP;
	private JFormattedTextField Fd_DateF;
	private JTextField Fd_RrferenceP;
	private JTextField Fd_MontantF;
	private JComboBox CB_TypeP;
	private JFormattedTextField Fd_DateP;
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
	 * @param fene 
	 * @param mere 
	 * @throws ParseException 
	 */
	
	public SaisirPaiement(FenetrePrincipale parent, FenPaiement fenepaie) throws ParseException {
		this.parent = parent;
		this.fenepaie = fenepaie;
        MaskFormatter dateFormatter = new MaskFormatter("####-##-##");
		setBorder(new LineBorder(SystemColor.activeCaption, 2));
		setTitle("Saisie des informations");
		setBounds(100, 100, 471, 567);
		getContentPane().setLayout(null);
		this.gsb = new GestionSaisirPaiement(this, this.parent, this.fenepaie);
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(14, 49, 439, 479);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel labelDebsemc = new JLabel("ID Facture");
		labelDebsemc.setFont(new Font("Tahoma", Font.BOLD, 11));
		labelDebsemc.setBounds(28, 52, 113, 13);
		panel.add(labelDebsemc);
		
		id_facture = new JTextField();
		id_facture.setBounds(186, 41, 231, 35);
		panel.add(id_facture);
		id_facture.setColumns(10);
		
		JLabel lblMontantDuPaiement = new JLabel("Montant du paiement :");
		lblMontantDuPaiement.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblMontantDuPaiement.setBounds(28, 283, 146, 13);
		panel.add(lblMontantDuPaiement);
		
		
		btn_Inserer = new JButton("Inserer");
		btn_Inserer.addActionListener(this.gsb);
		btn_Inserer.setBounds(263, 436, 85, 21);
		panel.add(btn_Inserer);
		
		btn_Annuler = new JButton("Annuler");
		btn_Annuler.addActionListener(this.gsb);
		btn_Annuler.setBounds(89, 436, 85, 21);
		panel.add(btn_Annuler);
		
		montantPaiement = new JSpinner();
		montantPaiement.setModel(new SpinnerNumberModel(Float.valueOf(0), Float.valueOf(0), null, Float.valueOf(1)));
		montantPaiement.setBounds(186, 272, 231, 35);
		panel.add(montantPaiement);
		
		JLabel lblRrferenceDuPaiement = new JLabel("Batiment");
		lblRrferenceDuPaiement.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblRrferenceDuPaiement.setBounds(28, 99, 146, 13);
		Fd_RrferenceP = new JTextField();
		Fd_RrferenceP.setColumns(10);
		Fd_RrferenceP.setBounds(186, 134, 231, 35);
		panel.add(Fd_RrferenceP);
		
		JLabel lblRrferenceDuPaiement1 = new JLabel("Reference du paiement :");
		lblRrferenceDuPaiement1.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblRrferenceDuPaiement1.setBounds(28, 145, 146, 13);
		panel.add(lblRrferenceDuPaiement1);
		
		BatimentcomboBox = new JComboBox();
		try {
			ArrayList<String> values = this.parent.getConnectionBD().getTableData("BATIMENT", "ID_BATIMENT");
			String[] idValuesArray = values.toArray(new String[0]);
			DefaultComboBoxModel<String> model = new DefaultComboBoxModel<>(idValuesArray);
			BatimentcomboBox.setModel(model);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		BatimentcomboBox.setBounds(186, 88, 231, 35);
		panel.add(BatimentcomboBox);
		
		JLabel lblNewLabel_1 = new JLabel("Logement");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_1.setBounds(30, 144, 94, 14);
		panel.add(lblNewLabel_1);
		
		LogementcomboBox_1 = new JComboBox();
		try {
			ArrayList<String> values = this.parent.getConnectionBD().getTableData("LOGEMENT", "ID_LOGEMENT");
			String[] idValuesArray = values.toArray(new String[0]);
			DefaultComboBoxModel<String> model = new DefaultComboBoxModel<>(idValuesArray);
			LogementcomboBox_1.setModel(model);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		LogementcomboBox_1.setBounds(186, 134, 231, 35);
		panel.add(LogementcomboBox_1);
		
		JLabel lblNewLabel_2 = new JLabel("Locataire");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_2.setBounds(28, 190, 62, 14);
		panel.add(lblNewLabel_2);
		
		LocatairecomboBox_2 = new JComboBox();
		try {
			ArrayList<String> values = this.parent.getConnectionBD().getTableData("LOCATAIRE", "ID_LOCATAIRE");
			String[] idValuesArray = values.toArray(new String[0]);
			DefaultComboBoxModel<String> model = new DefaultComboBoxModel<>(idValuesArray);
			LocatairecomboBox_2.setModel(model);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		LocatairecomboBox_2.setBounds(186, 180, 232, 35);
		panel.add(LocatairecomboBox_2);
		
		JLabel lblNewLabel_3 = new JLabel("Référence du paiement");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_3.setBounds(28, 236, 146, 14);
		panel.add(lblNewLabel_3);
		
		refPaiement = new JTextField();
		refPaiement.setBounds(186, 226, 231, 35);
		panel.add(refPaiement);
		refPaiement.setColumns(10);
		
		JLabel lblDateDuPaiement = new JLabel("Date du paiement :");
		lblDateDuPaiement.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblDateDuPaiement.setBounds(28, 375, 113, 13);
		panel.add(lblDateDuPaiement);
		
		Fd_DateP = new JFormattedTextField(dateFormatter);
		Fd_DateP.setText("0000-00-00");
		Fd_DateP.setColumns(10);
		Fd_DateP.setBounds(186, 364, 231, 35);
		panel.add(Fd_DateP);
		CB_TypeP = new JComboBox();
		CB_TypeP.setModel(new DefaultComboBoxModel(new String[] {"Prélèvement automatique", "Espèces", "Carte de crédit", "Virement bancaire", "Chèque"}));
		CB_TypeP.setBounds(186, 318, 231, 35);
		Fd_MontantF = new JTextField();
		Fd_MontantF.setEditable(false);
		Fd_MontantF.setColumns(10);
		Fd_MontantF.setBounds(186, 309, 231, 35);
		panel.add(Fd_MontantF);
		
		JLabel lblMontantTotal = new JLabel("Montant total :");
		lblMontantTotal.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblMontantTotal.setBounds(28, 320, 113, 13);
		panel.add(lblMontantTotal);
		
		CB_TypeP = new JComboBox();
		CB_TypeP.setModel(new DefaultComboBoxModel(new String[] {"Prelevement automatique", "Especes", "Carte de credit", "Virement bancaire", "Cheque"}));
		CB_TypeP.setBounds(186, 252, 231, 35);
		panel.add(CB_TypeP);
		
		JLabel lblModeDePaiement = new JLabel("Mode de paiement :");
		lblModeDePaiement.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblModeDePaiement.setBounds(28, 329, 113, 13);
		panel.add(lblModeDePaiement);
		
		JLayeredPane layeredPane = new JLayeredPane();
		layeredPane.setBounds(89, 157, 1, 1);
		panel.add(layeredPane);
		
		JLabel lblNewLabel = new JLabel("Saisir les informations du paiement");
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 13));
		lblNewLabel.setBounds(115, 26, 236, 13);
		getContentPane().add(lblNewLabel);
	}


	public int getIdFacture() {
		String text = this.id_facture.getText();
		return Integer.parseInt(text);
	}
	
	public int getIdBatiment() {
		return (int) Integer.valueOf(this.BatimentcomboBox.getItemAt(this.BatimentcomboBox.getSelectedIndex()).toString());
	}
	
	public int getIdLogement() {
		return (int) Integer.valueOf(this.LogementcomboBox_1.getItemAt(this.LogementcomboBox_1.getSelectedIndex()).toString());
	}
	
	public int getIdLocataire() {
		return (int) Integer.valueOf(this.LocatairecomboBox_2.getItemAt(this.LocatairecomboBox_2.getSelectedIndex()).toString());
	}

	public String getRefPaiement() {
		return this.refPaiement.getText();
	}
	
	public float getMontantPaiement() {
		return (int) this.montantPaiement.getValue();
	}


	public float getTextFieldRegimeJuridique() {
		return (float)this.montantPaiement.getValue();
	}
	
	public String getTypePaiement() {
		return this.CB_TypeP.getItemAt(this.CB_TypeP.getSelectedIndex()).toString();
	}

	public String getDatePaiement() {
		return this.Fd_DateP.getText();
	}
	
	
	public GestionSaisirPaiement getGsb() {
		return gsb;
	}


	public void loadPaiementInfo(String idfacture, String date, String refpaiement, String paiement, String type) {
		/*Fd_ReferenceF.setText(idfacture);*/
		Fd_DateP.setText(date);
		Fd_RrferenceP.setText(refpaiement);
		sp_MontantP.setValue(Double.parseDouble(paiement));
		CB_TypeP.getModel().setSelectedItem(type);
		
	}
}

