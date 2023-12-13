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
import java.text.ParseException;

import javax.swing.JSpinner;
import javax.swing.JFormattedTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JLayeredPane;

@SuppressWarnings("serial")
public class SaisirPaiement extends JInternalFrame{
	private JTextField Fd_ReferenceF;
	private GestionSaisirPaiement gsb;
	private JButton btn_Inserer;
	private JButton btn_Annuler;
	private JSpinner sp_MontantP;
	private JFormattedTextField Fd_DateF;
	private JTextField Fd_RrferenceP;
	private JTextField Fd_MontantF;
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
	public SaisirPaiement() throws ParseException {
        MaskFormatter dateFormatter = new MaskFormatter("####-##-##");
		setBorder(new LineBorder(SystemColor.activeCaption, 2));
		setTitle("Saisie des informations");
		setBounds(100, 100, 471, 567);
		getContentPane().setLayout(null);
		this.gsb = new GestionSaisirPaiement(this);
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(14, 49, 439, 479);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel labelDebsemc = new JLabel("Reference :");
		labelDebsemc.setFont(new Font("Tahoma", Font.BOLD, 10));
		labelDebsemc.setBounds(28, 31, 113, 13);
		panel.add(labelDebsemc);
		
		Fd_ReferenceF = new JTextField();
		Fd_ReferenceF.setEditable(false);
		Fd_ReferenceF.setBounds(186, 20, 231, 35);
		panel.add(Fd_ReferenceF);
		Fd_ReferenceF.setColumns(10);
		
		JLabel labelCP = new JLabel("Date facture :");
		labelCP.setFont(new Font("Tahoma", Font.BOLD, 10));
		labelCP.setBounds(28, 88, 113, 13);
		panel.add(labelCP);
		
		JLabel lblMontantDuPaiement = new JLabel("Montant du paiement :");
		lblMontantDuPaiement.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblMontantDuPaiement.setBounds(28, 366, 113, 13);
		panel.add(lblMontantDuPaiement);
		
		
		btn_Inserer = new JButton("Inserer");
		btn_Inserer.addActionListener(this.gsb);
		btn_Inserer.setBounds(263, 436, 85, 21);
		panel.add(btn_Inserer);
		
		btn_Annuler = new JButton("Annuler");
		btn_Annuler.addActionListener(this.gsb);
		btn_Annuler.setBounds(89, 436, 85, 21);
		panel.add(btn_Annuler);
		
		sp_MontantP = new JSpinner();
		sp_MontantP.setModel(new SpinnerNumberModel(Float.valueOf(0), Float.valueOf(0), null, Float.valueOf(1)));
		sp_MontantP.setBounds(186, 355, 231, 35);
		panel.add(sp_MontantP);

		Fd_DateF = new JFormattedTextField(dateFormatter);
		Fd_DateF.setEditable(false);
		Fd_DateF.setText("0000-00-00");
		Fd_DateF.setColumns(10);
		Fd_DateF.setBounds(186, 77, 231, 35);
		panel.add(Fd_DateF);
		
		Fd_RrferenceP = new JTextField();
		Fd_RrferenceP.setColumns(10);
		Fd_RrferenceP.setBounds(186, 134, 231, 35);
		panel.add(Fd_RrferenceP);
		
		JLabel lblRrferenceDuPaiement = new JLabel("Rrference du paiement :");
		lblRrferenceDuPaiement.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblRrferenceDuPaiement.setBounds(28, 145, 146, 13);
		panel.add(lblRrferenceDuPaiement);
		
		JLabel lblDateDuPaiement = new JLabel("Date du paiement :");
		lblDateDuPaiement.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblDateDuPaiement.setBounds(28, 203, 113, 13);
		panel.add(lblDateDuPaiement);
		
		JFormattedTextField Fd_DateP = new JFormattedTextField(dateFormatter);
		Fd_DateP.setText("0000-00-00");
		Fd_DateP.setColumns(10);
		Fd_DateP.setBounds(186, 192, 231, 35);
		panel.add(Fd_DateP);
		
		Fd_MontantF = new JTextField();
		Fd_MontantF.setEditable(false);
		Fd_MontantF.setColumns(10);
		Fd_MontantF.setBounds(186, 309, 231, 35);
		panel.add(Fd_MontantF);
		
		JLabel lblMontantTotal = new JLabel("Montant total :");
		lblMontantTotal.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblMontantTotal.setBounds(28, 320, 113, 13);
		panel.add(lblMontantTotal);
		
		JComboBox CB_TypeP = new JComboBox();
		CB_TypeP.setModel(new DefaultComboBoxModel(new String[] {"Prélèvement automatique", "Espèces", "Carte de crédit", "Virement bancaire", "Chèque"}));
		CB_TypeP.setBounds(186, 252, 231, 35);
		panel.add(CB_TypeP);
		
		JLabel lblModeDePaiement = new JLabel("Mode de paiement :");
		lblModeDePaiement.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblModeDePaiement.setBounds(28, 262, 113, 13);
		panel.add(lblModeDePaiement);
		
		JLayeredPane layeredPane = new JLayeredPane();
		layeredPane.setBounds(89, 157, 1, 1);
		panel.add(layeredPane);
		
		JLabel lblNewLabel = new JLabel("Saisir les informations du paiement");
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 13));
		lblNewLabel.setBounds(115, 26, 236, 13);
		getContentPane().add(lblNewLabel);
	}


	public String getTextFieldDebsemc() {
		return this.Fd_ReferenceF.getText();
	}



	public float getTextFieldRegimeJuridique() {
		return (float)this.sp_MontantP.getValue();
	}

	public String getTextFieldDateConstruction() {
		return this.Fd_DateF.getText();
	}
	
	
	public GestionSaisirPaiement getGsb() {
		return gsb;
	}
}

