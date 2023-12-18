package Vue;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import Controleur.GestionFenLogement;
import Controleur.GestionFenPaiement;

import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JSplitPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FenLogement extends JInternalFrame {

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
	
	private GestionFenLogement gestionClic;
	private FenetrePrincipale parent;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FenLogement frame = new FenLogement(new FenetrePrincipale());
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
	public FenLogement(FenetrePrincipale parent) {
		this.parent = parent;
		setTitle("Fenètre Logement");
		setDefaultCloseOperation(JInternalFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 775, 303);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		this.gestionClic = new GestionFenLogement(this, this.parent);
		JScrollPane scrollPane = new JScrollPane();
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setBounds(5, 5, 684, 373);
		table.setModel(new DefaultTableModel(
				this.gestionClic.updateTable(),
			new String[] {
				"ID Batiment", "ID Logement", "Etage", "Type", "Surface", "ICC", "Garage", "Jardin", "Balcon", "State", "Documents"
			}
		));
		scrollPane.setViewportView(table);
		
		panel = new JPanel();
		contentPane.add(panel, BorderLayout.NORTH);
		
		lblNewLabel = new JLabel("Liste des logements");
		panel.add(lblNewLabel);
		
		panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.SOUTH);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		btnNewButton = new JButton("Ajouter");
		panel_1.add(btnNewButton, BorderLayout.WEST);
		btnNewButton.addActionListener(this.gestionClic);
		
		btnNewButton_1 = new JButton("Retourner");
		btnNewButton_1.addActionListener(this.gestionClic);
		panel_1.add(btnNewButton_1, BorderLayout.EAST);
		
		splitPane = new JSplitPane();
		panel_1.add(splitPane, BorderLayout.CENTER);
		
		btnNewButton_2 = new JButton("Modifier");
		splitPane.setRightComponent(btnNewButton_2);
		btnNewButton_2.addActionListener(this.gestionClic);
		
		btnNewButton_3 = new JButton("Supprimer");
		splitPane.setLeftComponent(btnNewButton_3);
		btnNewButton_3.addActionListener(this.gestionClic);
		
	}

	public JTable getTableLogement() {
		// TODO Auto-generated method stub
		return table;
	}

}

