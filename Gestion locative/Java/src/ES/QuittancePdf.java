package ES;

import com.itextpdf.text.BadElementException;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

import Controleur.GestionFenPaiement;

import java.io.FileOutputStream;
import java.io.IOException;

import com.itextpdf.text.Image;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


public class QuittancePdf {
	public GestionFenPaiement gdp;
	public QuittancePdf quittance;
	
	public QuittancePdf(GestionFenPaiement gdp) {
		this.gdp = gdp;
	}

    public void imprimerQuittance(String nomLocataire,
								  String prenomLocataire,
								  String adresseLocataire,
								  String datePaiement,
								  String refPaiement,
								  String typePaiement,
								  String sommePaiement) {
    	
	    LocalDate dateActuelle = LocalDate.now();
        DateTimeFormatter format = DateTimeFormatter.ofPattern("DD-MM-YYYY");
        String dateFormatee = dateActuelle.format(format);

        Font yourFont = new Font(Font.FontFamily.TIMES_ROMAN, 24);

        
        
    	Document Quittance = new Document();

        try {
            PdfWriter.getInstance(Quittance, new FileOutputStream("C:\\Users\\hp\\Documents\\GitHub\\ongoing\\Gestion locative\\Quittance\\Quittance"+refPaiement+".pdf"));

            Quittance.open();
            
			Image logo = Image.getInstance("C:\\Users\\hp\\Documents\\GitHub\\ongoing\\Gestion locative\\Java\\src\\image\\logo.png");


            Paragraph bailleur = new Paragraph("\n\n\nBailleur: Nom & Prenom du Bailleur. \n Adresse du bailleur \n\n");
            Paragraph locataire = new Paragraph("Locataire: "+nomLocataire+" "+prenomLocataire+"\n Adresse locataire :"+adresseLocataire+"\n\n\n\n\n");
            Paragraph titre = new Paragraph();
            Chunk chunk = new Chunk("Quittance de loyer", yourFont);
            titre.add(chunk);
            Paragraph objet = new Paragraph("\n\n\nReçu de : \n\n\n");
            Paragraph corps = new Paragraph("La somme de "+sommePaiement+" € \n "+
            								"Le "+datePaiement+"\n"+
            								"Par : "+typePaiement+"\n"+
            								"Réfèrence du paiement : "+refPaiement+"\n"+
            								"Pour loyer et acessoires des locaux . \n\n\n\n");
            Paragraph conclusion = new Paragraph("Fait à Toulouse, le "+dateFormatee);
            
            logo.scaleToFit(100, 200);
            locataire.setAlignment(Paragraph.ALIGN_RIGHT);
            titre.setAlignment(Paragraph.ALIGN_CENTER);
            conclusion.setAlignment(Paragraph.ALIGN_RIGHT);
            float indentationGauche = 20f; 
            corps.setIndentationLeft(indentationGauche);
            
            Quittance.add(logo);
            Quittance.add(bailleur);
            Quittance.add(locataire);
            Quittance.add(titre);
            Quittance.add(objet);
            Quittance.add(corps);
            Quittance.add(conclusion);
         
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            Quittance.close();
        }
    }
}
