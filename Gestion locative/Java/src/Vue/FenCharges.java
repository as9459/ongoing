package Vue;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import java.math.RoundingMode;  
import java.text.DecimalFormat;  

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FenCharges extends JInternalFrame implements ActionListener {

	private JPanel contentPane;
	private JTable table;
	
	
	private static final DecimalFormat decfor = new DecimalFormat("0.00");  

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FenCharges frame = new FenCharges(new FenetrePrincipale());
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	/**
	 * Create the frame.
	 * @param fen 
	 */
	public FenCharges(FenetrePrincipale fen) {
		setBounds(100, 100, 892, 393);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Tableau des charges");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1.setBounds(10, 9, 222, 30);
		panel.add(lblNewLabel_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 68, 861, 116);
		panel.add(scrollPane);
		
	    JTable table = new JTable(new DefaultTableModel(
	    	new Object[][] {
	    		{"Compteur eau", null, null, null, null, null, "0.0", null, null},
	    		{"Ordure menagere", null, null, null, null, null, null, null, null},
	    		{"Electricite", null, null, null, null, null, null, null, null},
	    		{null, null, null, null, null, null, null, "Total:", null},
	    	},
	    	new String[] {
	    		"", "Partie Fixe", "Quotite", "Nombre mois", "Ancien index", "Nouvelle index", "Volume", "Prix unitaire", "Total"
	    	}
	    ));
	    
		scrollPane.setViewportView(table);
		
		JButton btnRetour = new JButton("Retour");
		btnRetour.addActionListener(this);
		btnRetour.setBounds(202, 239, 85, 21);
		panel.add(btnRetour);
		
		btnRetour.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
            	dispose();
            }
            });
		
		JButton btnValider = new JButton("Valider");
		btnValider.setBounds(551, 239, 85, 21);
		panel.add(btnValider);
		
		btnValider.addActionListener(new ActionListener(){
	            public void actionPerformed(ActionEvent e) {
	            	double waterFixCost = Double.valueOf((String)GetData(table, 0, 1));
	            	double garbageFixCost = Double.valueOf((String)GetData(table, 1, 1));
	            	double electricityFixCost = Double.valueOf((String)GetData(table, 2, 1));
	            	double waterQuotité = Double.valueOf((String)GetData(table, 0, 2));
	            	double garbageQuotité = Double.valueOf((String)GetData(table, 1, 2));
	            	double electricityQuotité = Double.valueOf((String)GetData(table, 2, 2));
	            	double months = Double.valueOf((String)GetData(table, 0, 3));
	            	
	            	double waterOldIndex = Double.valueOf((String)GetData(table, 0, 4));
	            	double waterNewIndex = Double.valueOf((String)GetData(table, 0, 5));
	            	
	            	double waterVolume = Double.valueOf(waterNewIndex - waterOldIndex);
	            	double waterPrixUnitaire = Double.valueOf((String)GetData(table, 0, 7));
	            	double waterCost = Double.valueOf(waterFixCost * waterQuotité/ 100.0 * (months/12) + waterVolume * waterPrixUnitaire);
	            	double garbageCost = Double.valueOf(garbageFixCost *garbageQuotité/100 * (months/12));
	            	double electricityCost = (electricityFixCost * electricityQuotité/100.0 * (months/12));
	            	double Total = Double.valueOf(waterCost + garbageCost + electricityCost);
	            	table.setValueAt(decfor.format(waterVolume), 0, 6);
	            	table.setValueAt(decfor.format(waterCost), 0, 8);
	            	table.setValueAt(decfor.format(garbageCost), 1, 8);
	            	table.setValueAt(decfor.format(electricityCost), 2, 8);
	            	table.setValueAt(decfor.format(Total), 3, 8);
	            	
	            }
	        });
		
	}
	//recup valeur du tableau
	public Object GetData(JTable table, int row_index, int col_index){
		return table.getModel().getValueAt(row_index, col_index);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}