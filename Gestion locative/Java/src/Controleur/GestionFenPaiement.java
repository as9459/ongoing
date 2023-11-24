package Controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import Vue.FenPaiement;

public class GestionFenPaiement implements ActionListener{

	private FenPaiement pyt;
	
	public GestionFenPaiement(FenPaiement pyt) {
		this.pyt = pyt;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		pyt.dispose();
		JButton botonn = (JButton) e.getSource();
		switch (botonn.getText()) {
			case "Retourner":
				pyt.dispose();
		break;
		}
	}
}