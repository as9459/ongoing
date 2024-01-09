package Vue;

import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.Font;
import java.awt.Color;
import java.awt.Component;

import javax.swing.border.TitledBorder;

import Controleur.GestionSaisirLogement;
import jdbc.CictOracleDataSource;

import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import java.awt.SystemColor;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.AbstractButton;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;

@SuppressWarnings("serial")
public class SaisirLogement extends JInternalFrame{
	private FenetrePrincipale parent;
	private FenLogement fenelog;
	private GestionSaisirLogement gsl;
	private AbstractButton btn_Inserer;
	private JButton btn_Annuler;
	private JCheckBox chckbx_Garage;
	private JCheckBox chckbx_Jardin;
	private JCheckBox chckbx_Balcon;
	private JComboBox CB_TypeLogement;
	private JSpinner sp_Icc;
	private JSpinner sp_Surface;
	private JSpinner sp_nbLogment;
	private JSpinner sp_Etage;
	private JComboBox CB_NbBatiment;
	private JLabel lblLeNumeroDu_1;
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
	public SaisirLogement(FenetrePrincipale parent, FenLogement fenelog) {
		this.parent = parent;
		this.fenelog = fenelog;
		setBorder(new LineBorder(SystemColor.activeCaption, 2));
		setTitle("Saisie des informations");
		setBounds(100, 100, 471, 567);
		getContentPane().setLayout(null);
		this.gsl = new GestionSaisirLogement(this, this.parent, this.fenelog);
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(14, 49, 439, 479);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Saisir les informations du Logement");
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 13));
		lblNewLabel.setBounds(115, 26, 236, 13);
		getContentPane().add(lblNewLabel);
		
		lblLeNumeroDu_1 = new JLabel("Le numero du batiment ");
		lblLeNumeroDu_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblLeNumeroDu_1.setBounds(20, 34, 149, 13);
		panel.add(lblLeNumeroDu_1);
		
		CB_NbBatiment = new JComboBox();
		try {
			ArrayList<String> values = this.parent.getConnectionBD().getTableData("BATIMENT", "ID_BATIMENT");
			String[] idValuesArray = values.toArray(new String[0]);
			DefaultComboBoxModel<String> model = new DefaultComboBoxModel<>(idValuesArray);
			CB_NbBatiment.setModel(model);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		/*ArrayList<String> idValuesList = GestionFenBatiment.getIdvalues();
		String[] idValuesArray = idValuesList.toArray(new String[0]);*/
		
		CB_NbBatiment.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4"}));
		CB_NbBatiment.setBounds(179, 23, 236, 35);
		panel.add(CB_NbBatiment);
		
		JLabel lblLeNumeroDu = new JLabel("Le numero du logement ");
		lblLeNumeroDu.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblLeNumeroDu.setBounds(20, 90, 149, 13);
		panel.add(lblLeNumeroDu);
		
		sp_nbLogment = new JSpinner();
		sp_nbLogment.setModel(new SpinnerNumberModel(0, 0, null, 1));
		sp_nbLogment.setBounds(179, 79, 236, 35);
		panel.add(sp_nbLogment);
		
		JLabel labelVille = new JLabel("Etage");
		labelVille.setFont(new Font("Tahoma", Font.BOLD, 11));
		labelVille.setBounds(20, 152, 129, 13);
		panel.add(labelVille);
		
		sp_Etage = new JSpinner();
		sp_Etage.setModel(new SpinnerNumberModel(0, 0, 20, 1));
		sp_Etage.setBounds(179, 141, 236, 35);
		panel.add(sp_Etage);
		
		JLabel labelDebsemc = new JLabel("Type logement");
		labelDebsemc.setFont(new Font("Tahoma", Font.BOLD, 11));
		labelDebsemc.setBounds(20, 214, 129, 13);
		panel.add(labelDebsemc);
		
		CB_TypeLogement = new JComboBox();
		CB_TypeLogement.setModel(new DefaultComboBoxModel(new String[] {"T1", "T2", "T3", "T4", "T5", "T6"}));
		CB_TypeLogement.setBounds(179, 203, 236, 35);
		panel.add(CB_TypeLogement);
		
		JLabel lblSurface = new JLabel("Surface");
		lblSurface.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblSurface.setBounds(20, 276, 129, 13);
		panel.add(lblSurface);
		
		sp_Surface = new JSpinner();
		sp_Surface.setModel(new SpinnerNumberModel(Float.valueOf(0), Float.valueOf(0), Float.valueOf(100), Float.valueOf(1)));
		sp_Surface.setBounds(179, 265, 236, 35);
		panel.add(sp_Surface);
		
		JLabel lblIcc = new JLabel("ICC");
		lblIcc.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblIcc.setBounds(20, 338, 129, 13);
		panel.add(lblIcc);
		
		sp_Icc = new JSpinner();
		sp_Icc.setModel(new SpinnerNumberModel(Float.valueOf(0), Float.valueOf(0), null, Float.valueOf(1)));
		sp_Icc.setBounds(179, 327, 236, 35);
		panel.add(sp_Icc);
		
		chckbx_Garage = new JCheckBox("Garage");
		chckbx_Garage.setBounds(40, 382, 97, 23);
		panel.add(chckbx_Garage);
		
		chckbx_Jardin = new JCheckBox("Jardin");
		chckbx_Jardin.setBounds(174, 382, 97, 23);
		panel.add(chckbx_Jardin);
		
		chckbx_Balcon = new JCheckBox("Balcon");
		chckbx_Balcon.setBounds(308, 382, 97, 23);
		panel.add(chckbx_Balcon);
		
		btn_Inserer = new JButton("Inserer");
		btn_Inserer.addActionListener(this.gsl);
		btn_Inserer.setBounds(263, 436, 85, 21);
		panel.add(btn_Inserer);
		
		btn_Annuler = new JButton("Annuler");
		btn_Annuler.addActionListener(this.gsl);
		btn_Annuler.setBounds(89, 436, 85, 21);
		panel.add(btn_Annuler);
	}

	public int getTextFieldNbBatement() {
	    return (int) Integer.valueOf(this.CB_NbBatiment.getItemAt(this.CB_NbBatiment.getSelectedIndex()).toString());
	}

	public int getTextFieldNbLogement() {
		return (int) this.sp_nbLogment.getValue();
	}
	
	public int getTextFieldEtage() {
		return (int) this.sp_Etage.getValue();
	}

	public String getTextFieldTypeLogement() {
		return this.CB_TypeLogement.getItemAt(this.CB_TypeLogement.getSelectedIndex()).toString();
	}

	public int getTextFieldSurface() {
		Number surfaceValue = (Number) this.sp_Surface.getValue();
		return surfaceValue != null ? surfaceValue.intValue() : 0;
	}

	public int getTextFieldICC() {
		Number ICCValue = (Number) this.sp_Icc.getValue();
		return ICCValue != null ? ICCValue.intValue() : 0;
	}


	public int getTextFieldGarage() {
		int i =0;
		if (this.chckbx_Garage.isSelected())
			i=1;
			return i ;
	}


	public int getTextFieldJardin() {
		int i =0;
		if (this.chckbx_Jardin.isSelected())
			i=1;
			return i ;
	}
	
	public int getTextFieldBalcon() {
		int i =0;
		if (this.chckbx_Balcon.isSelected())
			i=1;
			return i;
	}


	public GestionSaisirLogement getGsl() {
		return gsl;
	}
	
	public void loadLogementInfo(String idBatiment, String idLogement, String etage, String typeLog, String surface, String icc, String garage, String jardin, String balcon) {
		// Charger les informations dans les champs
		CB_NbBatiment.getModel().setSelectedItem(idBatiment);
		sp_nbLogment.setValue(Integer.parseInt(idLogement));
		sp_Etage.setValue(Integer.parseInt(etage));
		CB_TypeLogement.getModel().setSelectedItem(typeLog);
		sp_Surface.setValue(Double.parseDouble(surface));
		sp_Icc.setValue(Integer.parseInt(icc));
		
		boolean isGarage = "1".equals(garage);
	    boolean isJardin = "1".equals(jardin);
	    boolean isBalcon = "1".equals(balcon);

	    chckbx_Garage.setSelected(isGarage);
	    chckbx_Jardin.setSelected(isJardin);
	    chckbx_Balcon.setSelected(isBalcon);

	}
}

