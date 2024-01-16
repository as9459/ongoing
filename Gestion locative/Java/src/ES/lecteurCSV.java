package ES;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JFileChooser;

public class lecteurCSV {
	
	public static void main(String[] args) {
        lireCSV();
	}
	
	public static void lireCSV() {
		
		JFileChooser fileChooser = new JFileChooser();
        int result = fileChooser.showOpenDialog(null);

        if (result == JFileChooser.APPROVE_OPTION) {
            String adresse = fileChooser.getSelectedFile().getAbsolutePath();
            String ligne = " ";
    		try (BufferedReader br = new BufferedReader(new FileReader(adresse))){
    			
    			while((ligne = br.readLine()) != null) {
    				System.out.println(ligne);
    			}
    			
    			System.out.println("Fichier extrait avec succés");
    		} catch (IOException e) {
    			e.printStackTrace();
    			System.out.println("erreur.")	;
    			}
        } else {
            System.out.println("Opération annulée par l'utilisateur.");
        }
		
		
	}
	
}
