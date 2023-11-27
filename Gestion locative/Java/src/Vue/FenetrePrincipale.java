package Vue;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Controleur.GestionFenetrePrincipale;
import JDBC.CictOracleDataSource;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class FenetrePrincipale extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private CictOracleDataSource bd;
	private JPanel contentPane;
	protected boolean estConnecte;
	private JMenuItem mntm_Déconnecter;
	private JMenuItem mntm_Connecter;
	private JMenu mn_Affichage;
	
	private GestionFenetrePrincipale gestionClic;
	

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
		
		mntm_Connecter = new JMenuItem("Connecter");
		mntm_Connecter.addActionListener(this.gestionClic);
		this.gestionClic = new GestionFenetrePrincipale(this);
		menu2.add(mntm_Connecter);
		
		mntm_Déconnecter = new JMenuItem("Déconnecter");
		mntm_Déconnecter.addActionListener(this.gestionClic);
		this.gestionClic = new GestionFenetrePrincipale(this);
		mntm_Déconnecter.setEnabled(false);
		menu2.add(mntm_Déconnecter);
		
		mn_Affichage = new JMenu("Affichage");
		mn_Affichage.setEnabled(false);
		menuBar.add(mn_Affichage);
		
		JMenuItem mntm_Locataire = new JMenuItem("Locataire");
		mntm_Locataire.addActionListener(this.gestionClic);
		this.gestionClic = new GestionFenetrePrincipale(this);
		
		JMenu mntm_Batiment = new JMenu("Batiment");
		mn_Affichage.add(mntm_Batiment);
		
		JMenuItem item4 = new JMenuItem("Logement");
		item4.addActionListener(this.gestionClic);
		this.gestionClic = new GestionFenetrePrincipale(this);
		
		JMenuItem item7 = new JMenuItem("Batiment");
		item7.addActionListener(this.gestionClic);
		this.gestionClic = new GestionFenetrePrincipale(this);
		mntm_Batiment.add(item7);
		mntm_Batiment.add(item4);
		mn_Affichage.add(mntm_Locataire);
		
		JMenuItem mntm_Paiement = new JMenuItem("Paiement");
		mntm_Paiement.setBackground(new Color(240, 240, 240));
		mntm_Paiement.addActionListener(this.gestionClic);
		this.gestionClic = new GestionFenetrePrincipale(this);
		mn_Affichage.add(mntm_Paiement);
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
		boolean param1,param2;
		if(param) { param1 = true ;param2 = false; } else {param1 = false ;param2 = true; }
			mntm_Déconnecter.setEnabled(param1);
			mn_Affichage.setEnabled(param1);
			
			mntm_Connecter.setEnabled(param2);
			
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	

	/**
	 * Create the méthodes.
	 */


	public boolean isEstConnecte() {
		return estConnecte;
	}

	public void setEstConnecte(boolean estConnecte) {
		this.estConnecte = estConnecte;
	}
	
	public void setAcces(CictOracleDataSource con) {
		this.bd = con;
	}
	
    public void deconnecter() {
        this.bd.close();
    }


    public CictOracleDataSource getConnectionBD() {
        return this.bd;
    }
	
	
}