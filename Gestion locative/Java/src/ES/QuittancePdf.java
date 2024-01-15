package ES;

import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.FileOutputStream;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class QuittancePdf {

    public static void main(String[] args) {
        imprimerQuittance("nom", "prenom", "adresse", "date", "ref", "type", "somme", "loyer", "charges", "total", "reste", "periode");
    }

    public static void imprimerQuittance(String nomLocataire,
    									 String prenomLocataire,
    									 String adresseLocataire,
    									 String datePaiement,
    									 String refPaiement,
    									 String typePaiement,
    									 String sommePaiement,
    									 String montantLoyer,
    									 String montantCharges,
    									 String montantTotal,
    									 String reste,
    									 String periodeLocation) {
    	
	    LocalDate dateActuelle = LocalDate.now();
        DateTimeFormatter format = DateTimeFormatter.ofPattern("DD-MM-YYYY");
        String dateFormatee = dateActuelle.format(format);

        Font yourFont = new Font(Font.FontFamily.TIMES_ROMAN, 24);
       
    	Document Quittance = new Document();

        try {
            PdfWriter.getInstance(Quittance, new FileOutputStream("C:\\Users\\hp\\Documents\\GitHub\\ongoing\\Gestion locative\\Quittance\\Quittance"+periodeLocation+".pdf"));

            Quittance.open();

            Paragraph bailleur = new Paragraph("Bailleur: Nom & Prenom du Bailleur. \n Adresse du bailleur \n\n");
            Paragraph locataire = new Paragraph("Locataire: "+nomLocataire+" "+prenomLocataire+"\n Adresse locataire :"+adresseLocataire+"\n\n\n\n\n");
            Paragraph titre = new Paragraph();
            Chunk chunk = new Chunk("Quittance de loyer", yourFont);
            titre.add(chunk);
            Paragraph periode = new Paragraph(periodeLocation+"\n\n\n");
            Paragraph objet = new Paragraph("Reçu de : \n\n\n");
            Paragraph corps = new Paragraph("La somme de "+sommePaiement+" € \n "+
            								"Le "+datePaiement+"\n"+
            								"Par : "+typePaiement+"\n"+
            								"Réfèrence du paiement : "+refPaiement+"\n"+
            								"Pour loyer et acessoires des locaux . \n\n"+
            								"Détail :\n"+
            								"        -Loyer : "+montantLoyer+" €\n"+
            								"        -Charges : "+montantCharges+" €\n\n"+
            								"        - Total : "+montantTotal+" €\n"+
            								"        - Reste à payer : "+reste+" €\n\n\n\n");
            Paragraph conclusion = new Paragraph("Fait à Toulouse, le "+dateFormatee);
            
            locataire.setAlignment(Paragraph.ALIGN_RIGHT);
            titre.setAlignment(Paragraph.ALIGN_CENTER);
            periode.setAlignment(Paragraph.ALIGN_CENTER);
            conclusion.setAlignment(Paragraph.ALIGN_RIGHT);
            float indentationGauche = 20f; 
            corps.setIndentationLeft(indentationGauche);
            
            Quittance.add(bailleur);
            Quittance.add(locataire);
            Quittance.add(titre);
            Quittance.add(periode);
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
