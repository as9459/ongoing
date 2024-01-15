import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;

public class CreatePDF {

    public static void main(String[] args) {
        // Spécifiez le chemin du fichier PDF que vous souhaitez créer
        String pdfFilePath = "chemin/vers/votre/fichier.pdf";

        // Créez un objet PdfWriter pour écrire dans le fichier PDF
        try (PdfWriter writer = new PdfWriter(pdfFilePath)) {
            // Créez un objet PdfDocument avec le writer
            try (PdfDocument pdf = new PdfDocument(writer)) {
                // Créez un objet Document pour ajouter des éléments au PDF
                try (Document document = new Document(pdf)) {
                    // Ajoutez du texte au document
                    document.add(new Paragraph("Bonjour, ceci est un exemple de document PDF créé en Java."));
                    document.add(new Paragraph("Vous pouvez ajouter plus de contenu ici."));
                }
            }

            System.out.println("Le fichier PDF a été créé avec succès à : " + pdfFilePath);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

