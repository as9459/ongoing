package Vue;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import Controleur.GestionFenBatiment;
import Controleur.GestionFenPaiement;

import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JSplitPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FenPaiement extends JInternalFrame {

	private JPanel contentPane;
	private JTable table;
	private JPanel panel;
	private JPanel panel_1;
	private JButton btnNewButton;
	private JButton btnNewButton_1;
	private JLabel lblNewLabel;
	private JSplitPane splitPane;
	private JButton btnNewButton_2;
	private JButton btnNewButton_3;
	
	private GestionFenPaiement gestionClic;
	private FenetrePrincipale parent;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FenPaiement frame = new FenPaiement(new FenetrePrincipale());
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public FenPaiement(FenetrePrincipale parent) {
		this.parent = parent;
		setTitle("Fenètre Paiement");
		setDefaultCloseOperation(JInternalFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 757, 303);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		this.gestionClic = new GestionFenPaiement(this,  this.parent);
		JScrollPane scrollPane = new JScrollPane();
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setBounds(5, 5, 684, 373);
		table.setModel(new DefaultTableModel(
			this.gestionClic.updateTable(),
			new String[] {
				"ID facture", "Batiment", "Logement", "Locataire", "Reference du paiement", "Paiement", "Type de paiement", "Date de paiement" 
			}
		));
		table.getColumnModel().getColumn(1).setPreferredWidth(95);
		table.getColumnModel().getColumn(4).setPreferredWidth(136);
		table.getColumnModel().getColumn(5).setPreferredWidth(102);
		scrollPane.setViewportView(table);
		
		panel = new JPanel();
		contentPane.add(panel, BorderLayout.NORTH);
		
		lblNewLabel = new JLabel("Liste des paiements");
		panel.add(lblNewLabel);
		
		panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.SOUTH);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		btnNewButton = new JButton("Ajouter");
		btnNewButton.addActionListener(this.gestionClic);
		panel_1.add(btnNewButton, BorderLayout.WEST);
		
		btnNewButton_1 = new JButton("Retourner");
		btnNewButton_1.addActionListener(this.gestionClic);
		panel_1.add(btnNewButton_1, BorderLayout.EAST);
		
		splitPane = new JSplitPane();
		panel_1.add(splitPane, BorderLayout.CENTER);
		
		btnNewButton_2 = new JButton("Modifier");
		btnNewButton_2.addActionListener(this.gestionClic);
		splitPane.setRightComponent(btnNewButton_2);
		
		btnNewButton_3 = new JButton("Suprimer");
		btnNewButton_1.addActionListener(this.gestionClic);
		splitPane.setLeftComponent(btnNewButton_3);
		
		
	}

}
