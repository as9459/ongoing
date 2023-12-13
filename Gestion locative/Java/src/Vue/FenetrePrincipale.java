package Vue;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Controleur.GestionFenetrePrincipale;
import jdbc.CictOracleDataSource;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Component;

import javax.swing.JLabel;

public class FenetrePrincipale extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private CictOracleDataSource bd;
	private JPanel contentPane;
	protected boolean estConnecte;
	private JMenuItem mntm_Déconnecter;
	private JMenuItem mntm_Connecter;
	private JMenu menu_AdLoc;
	private JMenu menu_AdProp;
	
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
		
		JMenu menu_Fch = new JMenu("Fichier");
		menuBar.add(menu_Fch);
		
		JMenuItem item1 = new JMenuItem("Quitter");
		this.gestionClic = new GestionFenetrePrincipale(this);
		item1.addActionListener(this.gestionClic);
		menu_Fch.add(item1);
		
		JMenu menu_Cnt = new JMenu("Connecter");
		menuBar.add(menu_Cnt);
		
		mntm_Connecter = new JMenuItem("Connecter");
		mntm_Connecter.addActionListener(this.gestionClic);
		this.gestionClic = new GestionFenetrePrincipale(this);
		menu_Cnt.add(mntm_Connecter);
		
		mntm_Déconnecter = new JMenuItem("Déconnecter");
		mntm_Déconnecter.addActionListener(this.gestionClic);
		this.gestionClic = new GestionFenetrePrincipale(this);
		mntm_Déconnecter.setEnabled(false);
		menu_Cnt.add(mntm_Déconnecter);
		
		menu_AdLoc = new JMenu("Administration locataires");
		menu_AdLoc.setEnabled(false);
		menuBar.add(menu_AdLoc);
		
		JMenuItem mntm_Locataire = new JMenuItem("Locataire");
		mntm_Locataire.addActionListener(this.gestionClic);
		this.gestionClic = new GestionFenetrePrincipale(this);
		menu_AdLoc.add(mntm_Locataire);
		

		
		JMenuItem mntm_Paiement = new JMenuItem("Paiement");
		mntm_Paiement.setBackground(new Color(240, 240, 240));
		mntm_Paiement.addActionListener(this.gestionClic);
		this.gestionClic = new GestionFenetrePrincipale(this);
		menu_AdLoc.add(mntm_Paiement);
		
		menu_AdProp = new JMenu("Administration propriétés");
		menu_AdProp.setEnabled(false);
		menuBar.add(menu_AdProp);
		
		JMenuItem mntmBatiment = new JMenuItem("Batiment");
		mntmBatiment.addActionListener(this.gestionClic);
		this.gestionClic = new GestionFenetrePrincipale(this);
		menu_AdProp.add(mntmBatiment);
		
		JMenuItem mntmLogement = new JMenuItem("Logement");
		mntmLogement.addActionListener(this.gestionClic);
		this.gestionClic = new GestionFenetrePrincipale(this);
		menu_AdProp.add(mntmLogement);
		
		JMenuItem mntmFacture = new JMenuItem("Factures");
		mntmLogement.addActionListener(this.gestionClic);
		this.gestionClic = new GestionFenetrePrincipale(this);
		menu_AdProp.add(mntmFacture);
		
	}

	
	public void activerItems(boolean param){
		boolean param1,param2;
		if(param) { param1 = true ;param2 = false; } else {param1 = false ;param2 = true; }
			mntm_Déconnecter.setEnabled(param1);
			menu_AdLoc.setEnabled(param1);
			menu_AdProp.setEnabled(param1);
			
			mntm_Connecter.setEnabled(param2);
				
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	


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
    
    
	

    public void removeFen() {
        JLayeredPane layeredPane = this.getLayeredPane();
	    Component[] components = layeredPane.getComponentsInLayer(JLayeredPane.DEFAULT_LAYER);
	    for (Component component : components) {
            component.setVisible(false);
            layeredPane.remove(component);
	    }
    }
}
