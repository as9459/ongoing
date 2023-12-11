package Vue;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.table.TableColumn;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import Controleur.GestionFenBatiment;
import Controleur.GestionTabBatiment;

public class FenBatiment extends JInternalFrame {

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

	
	
	private GestionTabBatiment gestionTable;
	private GestionFenBatiment gestionClic;
	private FenetrePrincipale parent;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FenBatiment frame = new FenBatiment(new FenetrePrincipale());
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
	public FenBatiment(FenetrePrincipale parent) {
		this.parent = parent;  
		setTitle("Fenètre Batiment");
		setDefaultCloseOperation(JInternalFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 710, 303);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));					/******/
        this.gestionClic = new GestionFenBatiment(this, this.parent);	/******/		
        JScrollPane scrollPane = new JScrollPane();						/******/
		contentPane.add(scrollPane);									/******/
		
		table = new JTable();
		table.setBounds(5, 5, 684, 373);
		table.setModel(new DefaultTableModel(
				this.gestionClic.updateTable(),
			new String[] {
				"IdBatiment","Adresse", "Code Postal", "Ville", "Regime Juridique", "Date Construction", "Logement", "Documents"
			}
		));
		scrollPane.setViewportView(table);
		
		// cacher la collone IdBatiment
        TableColumn idLogementColumn = table.getColumnModel().getColumn(0); // Assuming IdLogement is the first column
        idLogementColumn.setMinWidth(0);
        idLogementColumn.setMaxWidth(0);
        idLogementColumn.setWidth(0);
        idLogementColumn.setPreferredWidth(0);
        idLogementColumn.setResizable(false);
		
		
		gestionTable = new GestionTabBatiment(this);
		this.table.getSelectionModel().addListSelectionListener(this.gestionTable);
		
		panel = new JPanel();
		contentPane.add(panel, BorderLayout.NORTH);
		
		lblNewLabel = new JLabel("Liste des batiments");
		panel.add(lblNewLabel);
		
		panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.SOUTH);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		btnNewButton = new JButton("Ajouter");
		panel_1.add(btnNewButton, BorderLayout.WEST);
		btnNewButton.addActionListener(this.gestionClic);
		
		btnNewButton_1 = new JButton("Retourner");
		panel_1.add(btnNewButton_1, BorderLayout.EAST);
		btnNewButton_1.addActionListener(this.gestionClic);
		
		splitPane = new JSplitPane();
		panel_1.add(splitPane, BorderLayout.CENTER);
		
		btnNewButton_2 = new JButton("Modifier");
		splitPane.setRightComponent(btnNewButton_2);
		btnNewButton_2.addActionListener(this.gestionClic);
		
		btnNewButton_3 = new JButton("Supprimer");
		splitPane.setLeftComponent(btnNewButton_3);
		btnNewButton_3.addActionListener(this.gestionClic);
		
		
		
	}
	
	public JTable getTableBatiment() {
		return this.table;
	}

}
