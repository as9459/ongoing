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
	private JTextField Fd_ReferenceF;
	private GestionSaisirPaiement gsb;
	private JButton btn_Inserer;
	private JButton btn_Annuler;
	private JSpinner sp_MontantP;
	private JFormattedTextField Fd_DateF;
	private JComboBox CB_TypeP;
	private JComboBox BatimentcomboBox;
	private JComboBox LogementcomboBox;
	private JComboBox LocatairecomboBox;
	private JTextField ReftextField;
	private JSpinner Montantspinner;
	private JComboBox TypecomboBox;
	private JFormattedTextField DateformattedTextField;
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
		this.gsb = new GestionSaisirPaiement(this, this.parent, fenepaie);
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(10, 50, 439, 479);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLayeredPane layeredPane = new JLayeredPane();
		layeredPane.setBounds(89, 157, 1, 1);
		panel.add(layeredPane);
		
		JLabel lblNewLabel = new JLabel("Saisir les informations du paiement");
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 13));
		lblNewLabel.setBounds(115, 26, 236, 13);
		getContentPane().add(lblNewLabel);
		
		JLabel labelDebsemc = new JLabel("ID Facture");
		labelDebsemc.setFont(new Font("Tahoma", Font.BOLD, 11));
		labelDebsemc.setBounds(28, 23, 113, 13);
		panel.add(labelDebsemc);
		
		id_facture = new JTextField();
		id_facture.setBounds(186, 12, 231, 35);
		panel.add(id_facture);
		id_facture.setColumns(10);
		
		
		btn_Inserer = new JButton("Inserer");
		btn_Inserer.addActionListener(this.gsb);
		
		JLabel lblNewLabel_1 = new JLabel("ID Batiment");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_1.setBounds(28, 66, 85, 14);
		panel.add(lblNewLabel_1);
		
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
		BatimentcomboBox.setBounds(186, 58, 231, 33);
		panel.add(BatimentcomboBox);
		
		JLabel lblNewLabel_2 = new JLabel("ID Logement");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_2.setBounds(28, 117, 113, 14);
		panel.add(lblNewLabel_2);
		
		LogementcomboBox = new JComboBox();
		try {
			ArrayList<String> values = this.parent.getConnectionBD().getTableData("LOGEMENT", "ID_LOGEMENT");
			String[] idValuesArray = values.toArray(new String[0]);
			DefaultComboBoxModel<String> model = new DefaultComboBoxModel<>(idValuesArray);
			LogementcomboBox.setModel(model);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		LogementcomboBox.setBounds(186, 102, 231, 35);
		panel.add(LogementcomboBox);
		
		JLabel lblNewLabel_3 = new JLabel("ID Locataire");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_3.setBounds(29, 170, 97, 14);
		panel.add(lblNewLabel_3);
		
		LocatairecomboBox = new JComboBox();
		try {
			ArrayList<String> values = this.parent.getConnectionBD().getTableData("LOCATAIRE", "ID_LOCATAIRE");
			String[] idValuesArray = values.toArray(new String[0]);
			DefaultComboBoxModel<String> model = new DefaultComboBoxModel<>(idValuesArray);
			LocatairecomboBox.setModel(model);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		LocatairecomboBox.setBounds(186, 149, 231, 37);
		panel.add(LocatairecomboBox);
		
		JLabel lblNewLabel_4 = new JLabel("Reference de paiement");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_4.setBounds(28, 213, 133, 14);
		panel.add(lblNewLabel_4);
		
		ReftextField = new JTextField();
		ReftextField.setBounds(186, 198, 231, 35);
		panel.add(ReftextField);
		ReftextField.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("Montant");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_5.setBounds(28, 255, 90, 14);
		panel.add(lblNewLabel_5);
		
		Montantspinner = new JSpinner();
		Montantspinner.setBounds(186, 246, 231, 35);
		panel.add(Montantspinner);
		
		JLabel lblNewLabel_6 = new JLabel("Type de paiement");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_6.setBounds(28, 302, 113, 14);
		panel.add(lblNewLabel_6);
		
		TypecomboBox = new JComboBox();
		TypecomboBox.setModel(new DefaultComboBoxModel(new String[] {"Prélèvement automatique", "Espèces", "Carte de crédit", "Virement bancaire", "Chèque"}));
		TypecomboBox.setBounds(186, 293, 231, 35);
		panel.add(TypecomboBox);
		
		JLabel lblNewLabel_7 = new JLabel("Date de paiement");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_7.setBounds(28, 352, 113, 14);
		panel.add(lblNewLabel_7);
		
		DateformattedTextField = new JFormattedTextField();
		DateformattedTextField.setBounds(186, 341, 231, 35);
		panel.add(DateformattedTextField);
		btn_Inserer.setBounds(263, 436, 85, 21);
		panel.add(btn_Inserer);
		
		btn_Annuler = new JButton("Annuler");
		btn_Annuler.addActionListener(this.gsb);
		btn_Annuler.setBounds(89, 436, 85, 21);
		panel.add(btn_Annuler);
		
		JLabel lblRrferenceDuPaiement = new JLabel("Batiment");
		lblRrferenceDuPaiement.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblRrferenceDuPaiement.setBounds(28, 99, 146, 13);
		
	}


	public int getIdFacture() {
		String text = this.id_facture.getText();
		return Integer.parseInt(text);
	}
	
	public int getIdBatiment() {
		return (int) Integer.valueOf(this.BatimentcomboBox.getItemAt(this.BatimentcomboBox.getSelectedIndex()).toString());
	}
	
	public int getIdLogement() {
		return (int) Integer.valueOf(this.LogementcomboBox.getItemAt(this.LogementcomboBox.getSelectedIndex()).toString());
	}
	
	public int getIdLocataire() {
		return (int) Integer.valueOf(this.LocatairecomboBox.getItemAt(this.LocatairecomboBox.getSelectedIndex()).toString());
	}
		
	public String getRefPaiement() {
			return this.ReftextField.getText();
	}
		
	public float getMontantPaiement() {
			return (int) this.Montantspinner.getValue();
	}
	
	public String getTypePaiement() {
		return this.TypecomboBox.getItemAt(this.TypecomboBox.getSelectedIndex()).toString();
	}
	
	public String getTextFieldDebsemc() {
		return this.Fd_ReferenceF.getText();
	}

	public String getDatePaiement() {
		return this.DateformattedTextField.getText();
	}
	
	
	public GestionSaisirPaiement getGsb() {
		return gsb;
	}


	public void loadPaiementInfo(String idfacture, String idbatiment, String idlogement, String idlocataire, String refpaiement, String paiement, String type, String date) {

		Fd_ReferenceF.setText(idfacture);
		BatimentcomboBox.getModel().setSelectedItem(idbatiment);
		LogementcomboBox.getModel().setSelectedItem(idlogement);
		LocatairecomboBox.getModel().setSelectedItem(idlocataire);
		ReftextField.setText(refpaiement);
		Montantspinner.setValue(Double.parseDouble(paiement));
		TypecomboBox.getModel().setSelectedItem(type);
		DateformattedTextField.setText(date);
	
	}


		
	
}

