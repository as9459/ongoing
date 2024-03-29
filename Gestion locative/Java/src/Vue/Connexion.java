package Vue;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JTextPane;

import Controleur.GestionConnexion;
import Controleur.GestionFenBatiment;
import jdbc.CictOracleDataSource;

import javax.swing.JPasswordField;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.SwingConstants;

public class Connexion extends JInternalFrame {

	private static final long serialVersionUID = 1L;
	private static FenetrePrincipale parent;
	private JPasswordField Fd_password;
	private GestionConnexion GestionClic;
	private JTextField Fd_user;
	private JLabel lbl_MsgErrur;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Connexion frame = new Connexion(parent);
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
	public Connexion(FenetrePrincipale parent) {
		this.parent = parent;
		setTitle("Connexion");
		setBounds(100, 100, 550, 300);
		getContentPane().setLayout(null);
		
		Fd_password = new JPasswordField();
		Fd_password.setHorizontalAlignment(SwingConstants.LEFT);
		Fd_password.setText("Ps1052");
		Fd_password.setBounds(256, 130, 153, 20);
		getContentPane().add(Fd_password);
		
		JLabel lblNewLabel = new JLabel("Login:");
		lblNewLabel.setBounds(178, 92, 46, 14);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Mots de passe:");
		lblNewLabel_1.setBounds(141, 132, 83, 14);
		getContentPane().add(lblNewLabel_1);
		
		JButton btn_Connecter = new JButton("Connecter");
		this.GestionClic = new GestionConnexion(this, this.parent);
		btn_Connecter.addActionListener(this.GestionClic);
		btn_Connecter.setBounds(116, 224, 108, 23);
		getContentPane().add(btn_Connecter);
		
		JButton btn_Annuler = new JButton("Annuler");
		this.GestionClic = new GestionConnexion(this, this.parent);
		btn_Annuler.addActionListener(this.GestionClic);
		btn_Annuler.setBounds(301, 224, 108, 23);
		getContentPane().add(btn_Annuler);
		
		Fd_user = new JTextField();
		Fd_user.setBounds(256, 90, 153, 20);
		Fd_user.setText("LHB3409A");
		getContentPane().add(Fd_user);
		Fd_user.setColumns(10);
		
		lbl_MsgErrur = new JLabel("");
		lbl_MsgErrur.setVerticalAlignment(SwingConstants.TOP);
		lbl_MsgErrur.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_MsgErrur.setForeground(Color.RED);
		lbl_MsgErrur.setBounds(10, 157, 518, 45);
		getContentPane().add(lbl_MsgErrur);

	}




	/**
	 * Create the méthodes.
	 */
	
	public String getValeurChLogin() {
		return this.Fd_user.getText();
		
	}
	
	public String getValeurPassword() {
		return this.Fd_password.getText();
		
	}
	
	public void setMsgAcces(String msg) {
		
		if(msg == "Connexion etablie") {
			lbl_MsgErrur.setForeground(Color.GREEN);
		}
		lbl_MsgErrur.setText(msg);
		
	}
}