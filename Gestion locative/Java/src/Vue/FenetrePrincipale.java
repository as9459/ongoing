package Vue;

import java.awt.EventQueue;

import javax.swing.ImageIcon;
import java.awt.Image;
import java.io.File;
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
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;

public class FenetrePrincipale extends JFrame{

	private static final long serialVersionUID = 1L;
	private CictOracleDataSource bd;
	private JPanel contentPane;
	protected boolean estConnecte;
	private JMenuItem mntm_Déconnecter;
	private JMenuItem mntm_Connecter;
	private JMenu menu_AdLoc;
	private JMenu menu_AdProp;
    private JLabel lblImage;
    private JButton btnConnceter;
    private JLabel lbltxt1;
    private JLabel lbltxt2;
    private JLabel lbltxt3;
    private JLabel lbltxt4;
    private JLabel lbltxt5;
    private JLabel lbltxt6;
    private JLabel lbltxt7;
    private JLabel lbltxt8;



	
	private GestionFenetrePrincipale gestionClic;
	private JMenuItem mntmCharges;
	

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
		
		JMenuItem mntmEntreprise = new JMenuItem("Entreprise");
		mntmEntreprise.addActionListener(this.gestionClic);
		this.gestionClic = new GestionFenetrePrincipale(this);
		menu_AdProp.add(mntmEntreprise);
		
		JMenuItem mntmFacture = new JMenuItem("Facture");
		mntmFacture.addActionListener(this.gestionClic);
		this.gestionClic = new GestionFenetrePrincipale(this);
		menu_AdProp.add(mntmFacture);
		
		mntmCharges = new JMenuItem("Calcul charges");
		mntmCharges.addActionListener(this.gestionClic);
		menu_AdProp.add(mntmCharges);
		
		ImageIcon imageIcon = new ImageIcon(getClass().getResource("/image/home.PNG"));
        Image image = imageIcon.getImage().getScaledInstance(400, 700, Image.SCALE_SMOOTH);
        imageIcon = new ImageIcon(image);

        
        lblImage = new JLabel(imageIcon);
        lblImage.setBounds(10, 33, 421, 579);
        contentPane.add(lblImage);
        
        lbltxt1 = new JLabel("Bienvenue sur GererBien");
        lbltxt1.setFont(new Font("Tahoma", Font.BOLD, 16));
        lbltxt1.setBounds(546, 185, 210, 14);
        contentPane.add(lbltxt1);
        
        lbltxt2 = new JLabel("Optimisez votre gestion immobilière avec notre logiciel intuitif et puissant. Profitez d'une ");
        lbltxt2.setBounds(441, 250, 441, 14);
        contentPane.add(lbltxt2);
        
        lbltxt3 = new JLabel("expérience simplifiée grâce à nos fonctionnalités d'automatisation avancées.");
        lbltxt3.setBounds(441, 275, 366, 14);
        contentPane.add(lbltxt3);
        
        lbltxt4 = new JLabel("Automatisation Sans Effort.");
        lbltxt4.setFont(new Font("Tahoma", Font.BOLD, 11));
        lbltxt4.setBounds(469, 313, 200, 14);
        contentPane.add(lbltxt4);
        
        lbltxt5 = new JLabel("Suivi Intelligente des Propriétés.");
        lbltxt5.setFont(new Font("Tahoma", Font.BOLD, 11));
        lbltxt5.setBounds(469, 338, 200, 14);
        contentPane.add(lbltxt5);
        
        lbltxt6 = new JLabel("Analyses Perspicaces.");
        lbltxt6.setFont(new Font("Tahoma", Font.BOLD, 11));
        lbltxt6.setBounds(469, 363, 148, 14);
        contentPane.add(lbltxt6);
        
        lbltxt7 = new JLabel("Profitez de la tranquillité d'esprit grâce à une gestion efficace de vos propriétés. ");
        lbltxt7.setBounds(441, 401, 393, 14);
        contentPane.add(lbltxt7);
        
        lbltxt8 = new JLabel("GererBien vous offre la clé d'une gestion immobilière moderne et sans soucis.");
        lbltxt8.setBounds(441, 425, 441, 14);
        contentPane.add(lbltxt8);
        
        btnConnceter = new JButton("Connecter");
        btnConnceter.addActionListener(this.gestionClic);
        btnConnceter.setBounds(768, 496, 114, 23);
        contentPane.add(btnConnceter);
	}

	
	public void activerItems(boolean param){
		boolean param1,param2;
		if(param) { param1 = true ;param2 = false; } else {param1 = false ;param2 = true; }
			mntm_Déconnecter.setEnabled(param1);
			menu_AdLoc.setEnabled(param1);
			menu_AdProp.setEnabled(param1);
			
			mntm_Connecter.setEnabled(param2);
				
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

    public void effacerPhoto() {
        lblImage.setIcon(null);
    }

    public void effacerTexte() {
        lbltxt1.setText("");
        lbltxt2.setText("");
        lbltxt3.setText("");
        lbltxt4.setText("");
        lbltxt5.setText("");
        lbltxt6.setText("");
        lbltxt7.setText("");
        lbltxt8.setText("");
        
    }

    public void effacerBoutonConnecter() {
        btnConnceter.setVisible(false); 
    }

}
