package Vue;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Controleur.GestionFenetrePrincipale;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class FenetrePrincipale extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	protected boolean estConnecte;
	private JMenuItem item3;
	private JMenu menu4;
	private JMenuItem item5;
	private JMenuItem item6;
	
	private GestionFenetrePrincipale gestionClic;
	

	public boolean isEstConnecte() {
		return estConnecte;
	}

	public void setEstConnecte(boolean estConnecte) {
		this.estConnecte = estConnecte;
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FenetrePrincipale frame = new FenetrePrincipale();
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
	public FenetrePrincipale() {
		setTitle("Fenetre Principale");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 908, 662);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setToolTipText("");
		menuBar.setBounds(0, 0, 1000, 22);
		contentPane.add(menuBar);
		
		JMenu menu1 = new JMenu("Fichier");
		menuBar.add(menu1);
		
		JMenuItem item1 = new JMenuItem("Quitter");
		this.gestionClic = new GestionFenetrePrincipale(this);
		item1.addActionListener(this.gestionClic);
		menu1.add(item1);
		
		JMenu menu2 = new JMenu("Connecter");
		menuBar.add(menu2);
		
		JMenuItem item2 = new JMenuItem("Connecter");
		item2.addActionListener(this.gestionClic);
		this.gestionClic = new GestionFenetrePrincipale(this);
		menu2.add(item2);
		
		item3 = new JMenuItem("Déconnecter");
		item3.addActionListener(this.gestionClic);
		this.gestionClic = new GestionFenetrePrincipale(this);
		item3.setEnabled(false);
		menu2.add(item3);
		
		JMenu menu3 = new JMenu("Affichage");
		menuBar.add(menu3);
		
		item5 = new JMenuItem("Locataire");
		item5.addActionListener(this.gestionClic);
		this.gestionClic = new GestionFenetrePrincipale(this);
		item5.setEnabled(false);
		
		menu4 = new JMenu("Batiment");
		menu3.add(menu4);
		menu4.setEnabled(false);
		
		JMenuItem item4 = new JMenuItem("Logement");
		item4.addActionListener(this.gestionClic);
		this.gestionClic = new GestionFenetrePrincipale(this);
		
		JMenuItem item7 = new JMenuItem("Batiment");
		item7.addActionListener(this.gestionClic);
		this.gestionClic = new GestionFenetrePrincipale(this);
		menu4.add(item7);
		menu4.add(item4);
		menu3.add(item5);
		
		item6 = new JMenuItem("Paiement");
		item6.setBackground(new Color(240, 240, 240));
		item6.addActionListener(this.gestionClic);
		this.gestionClic = new GestionFenetrePrincipale(this);
		item6.setEnabled(false);
		menu3.add(item6);
	}
	/*public void actionPerformed(ActionEvent e) {
		JMenuItem itemm = (JMenuItem) e.getSource();
		switch (itemm.getText()) {
			case "Quitter":
				dispose();
				break;
			case "Connecter":
				Connexion cn = new Connexion();
				JLayeredPane layeredPane0 = getLayeredPane();
				layeredPane0.add(cn, JLayeredPane.DEFAULT_LAYER);
				cn.setVisible(true);
				break;
			case "Déconnecter":
				this.setEstConnecte(true);
				this.activerItems(false);
				break;
			case "Locataire":
				FenLocataire loca = new FenLocataire();
				JLayeredPane layeredPane1 = getLayeredPane();
				layeredPane1.add(loca, JLayeredPane.DEFAULT_LAYER);
				loca.setVisible(true);
				break;
			case "Paiement":
				FenPaiement pmt = new FenPaiement();
				JLayeredPane layeredPane2 = getLayeredPane();
				layeredPane2.add(pmt, JLayeredPane.DEFAULT_LAYER);
				pmt.setVisible(true);
				break;
			case "Logement":
				FenLogement lgt = new FenLogement();
				JLayeredPane layeredPane3 = getLayeredPane();
				layeredPane3.add(lgt, JLayeredPane.DEFAULT_LAYER);
				lgt.setVisible(true);
				break;
			case "Batiment":
				FenBatiment bat = new FenBatiment();
				JLayeredPane layeredPane4 = getLayeredPane();
				layeredPane4.add(bat, JLayeredPane.DEFAULT_LAYER);
				bat.setVisible(true);
				break;
		}
	} */
	public void activerItems(boolean param){
			item3.setEnabled(param);
			menu4.setEnabled(param);
			item5.setEnabled(param);
			item6.setEnabled(param);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}
