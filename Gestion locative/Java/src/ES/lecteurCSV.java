package ES;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.swing.JFileChooser;

public class lecteurCSV {
	
	public static void main(String[] args) {
	    List<ArrayList<String>> resultats = lireCSV();

	    // Utilisez la liste complète des listes selon vos besoins
	    for (ArrayList<String> ligneDonnees : resultats) {
	        System.out.println(ligneDonnees);
	    }
	}
	

	public static List<ArrayList<String>> lireCSV() {
	    List<ArrayList<String>> lignes = new ArrayList<>();

	    JFileChooser fileChooser = new JFileChooser();
	    int result = fileChooser.showOpenDialog(null);

	    if (result == JFileChooser.APPROVE_OPTION) {
	        String adresse = fileChooser.getSelectedFile().getAbsolutePath();
	        String ligne;
	        try (BufferedReader br = new BufferedReader(new FileReader(adresse))) {

	            while ((ligne = br.readLine()) != null) {
	                String[] donnees = ligne.split(";");
	                if (donnees.length > 0 && !donnees[0].isEmpty()) {
	                    ArrayList<String> ligneListe = new ArrayList<>(Arrays.asList(donnees));
	                    lignes.add(ligneListe);
	                }
	            }

	            System.out.println("Fichier extrait avec succès");
	        } catch (IOException e) {
	            e.printStackTrace();
	            System.out.println("Erreur lors de la lecture du fichier CSV.");
	        }
	    } else {
	        System.out.println("Opération annulée par l'utilisateur.");
	    }

	    return lignes;
	}
	
}








	

