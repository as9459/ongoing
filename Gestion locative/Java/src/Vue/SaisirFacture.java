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

import Controleur.GestionSaisirBatiement;
import Controleur.GestionSaisirFacture;

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

@SuppressWarnings("serial")
public class SaisirFacture extends JInternalFrame{
	private JTextField ID_Facture;
	private JTextField Ref;
	private JComboBox LabelIDcomboBox;
	private GestionSaisirFacture gsf;
	private FenetrePrincipale parent;
	private FenFacture fenefac;
	private JButton btn_Inserer;
	private JButton btn_Annuler;
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
	public SaisirFacture(FenetrePrincipale parent, FenFacture fenefac) throws ParseException {
		this.parent = parent;
		this.fenefac = fenefac;
		setBorder(new LineBorder(SystemColor.activeCaption, 2));
		setTitle("Saisie des informations");
		setBounds(100, 100, 471, 567);
		getContentPane().setLayout(null);
		this.gsf = new GestionSaisirFacture(this, this.parent, this.fenefac);
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
		
		JLabel label_IDb = new JLabel("ID Batiment");
		label_IDb.setFont(new Font("Tahoma", Font.BOLD, 11));
		label_IDb.setBounds(28, 132, 113, 13);
		panel.add(label_IDb);
		
		LabelIDcomboBox = new JComboBox();
		try {
			ArrayList<String> values = this.parent.getConnectionBD().getTableData("BATIMENT", "ID_BATIMENT");
			String[] idValuesArray = values.toArray(new String[0]);
			DefaultComboBoxModel<String> model = new DefaultComboBoxModel<>(idValuesArray);
			LabelIDcomboBox.setModel(model);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		LabelIDcomboBox.setBounds(186, 121, 231, 35);
		panel.add(LabelIDcomboBox);
		
		JLabel lblRfrenceDuPaiement = new JLabel("Réfèrence du paiement");
		lblRfrenceDuPaiement.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblRfrenceDuPaiement.setBounds(28, 194, 132, 13);
		panel.add(lblRfrenceDuPaiement);
		
		Ref = new JTextField();
		Ref.setColumns(10);
		Ref.setBounds(186, 183, 231, 35);
		panel.add(Ref);
		
		JLabel label_Paiement = new JLabel("Paiement");
		label_Paiement.setFont(new Font("Tahoma", Font.BOLD, 11));
		label_Paiement.setBounds(28, 254, 113, 13);
		panel.add(label_Paiement);
		
		JSpinner spinner = new JSpinner();
		spinner.setBounds(186, 244, 231, 35);
		panel.add(spinner);
		
		JLabel label_TypP = new JLabel("Type de paiement");
		label_TypP.setFont(new Font("Tahoma", Font.BOLD, 11));
		label_TypP.setBounds(28, 318, 113, 14);
		panel.add(label_TypP);
		
		JComboBox TypePaiementcomboBox_1 = new JComboBox();
		TypePaiementcomboBox_1.setModel(new DefaultComboBoxModel(new String[] {"Virement Bancaire", "Espèces", "Carte de crédit", "Prélèvement automatique"}));
		TypePaiementcomboBox_1.setBounds(186, 308, 231, 35);
		panel.add(TypePaiementcomboBox_1);
		
		JLabel labelHeureFC = new JLabel("Date de paiement");
		labelHeureFC.setFont(new Font("Tahoma", Font.BOLD, 11));
		labelHeureFC.setBounds(28, 385, 113, 13);
		panel.add(labelHeureFC);
		
		
		btn_Inserer = new JButton("Inserer");
		btn_Inserer.addActionListener(this.gsf);
		btn_Inserer.setBounds(263, 436, 85, 21);
		panel.add(btn_Inserer);
		
		btn_Annuler = new JButton("Annuler");
		btn_Annuler.addActionListener(this.gsf);
		btn_Annuler.setBounds(89, 436, 85, 21);
		panel.add(btn_Annuler);

        MaskFormatter dateFormatter = new MaskFormatter("####-##-##");
		Fd_DateConstruction = new JFormattedTextField(dateFormatter);
		Fd_DateConstruction.setText("0000-00-00");
		Fd_DateConstruction.setColumns(10);
		Fd_DateConstruction.setBounds(186, 374, 231, 35);
		panel.add(Fd_DateConstruction);
		
		JLabel lblNewLabel = new JLabel("Saisir les informations de la facture");
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 13));
		lblNewLabel.setBounds(115, 26, 236, 13);
		getContentPane().add(lblNewLabel);
	}


	public String getTextFieldDebsemc() {
		return this.ID_Facture.getText();
	}


	


	public String getTextFieldVille() {
		return this.Ref.getText();
	}


	

	public String getTextFieldDateConstruction() {
		return this.Fd_DateConstruction.getText();
	}
	
	
	public GestionSaisirFacture getGsf() {
		return gsf;
	}
}

