package org.plate.web.pdf;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.itextpdf.text.Document;
import com.itextpdf.text.Image;
import com.itextpdf.text.pdf.PdfImportedPage;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfWriter;

public class DocBuilder extends AbstractITextPdfView {
	@SuppressWarnings("unused")
	private static final Logger log = Logger.getLogger(DocBuilder.class);
 
    @Override
    protected void buildPdfDocument(Map<String, Object> model, Document doc,
            PdfWriter writer, HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        // get data model which is passed by the Spring container
    	@SuppressWarnings("unchecked")
		HashMap<String,Object> details= (HashMap<String, Object>) model.get("details");
    	String pdfPath = (String) details.get("pdfPath");
    	String pdfDoc = (String) details.get("pdfDoc");
    	PdfReader reader = new PdfReader(pdfPath + "/" + pdfDoc); 
    	int n = reader.getNumberOfPages();
    	PdfPTable table = new PdfPTable(1);
        PdfImportedPage page;
        for (int i = 1; i <= n; i++) {
            page = writer.getImportedPage(reader, i);
            table.addCell(Image.getInstance(page));
        }
        doc.add(table);
        
 /*       
		 
		 String url0 = imagePath + "Boats&Sailors_logo_01_222x130.png";
		 String url1 = imagePath + "captain.jpeg";
		 String url2 = imagePath + boat.getPics().get(0);
		 String url21 = imagePath + boat.getPics().get(1);
		 String url22 = imagePath + boat.getPics().get(2);
		 String url23 = imagePath + boat.getPics().get(3);
		 String url3 = imagePath + agent.getImage();
		 
		 Image image = Image.getInstance(url0);
		 image.scaleAbsolute(180f,100f);
		 // image.setAbsolutePosition(450f, 700f);
		 doc.add(image);
	 
		 image = Image.getInstance(url3);
		 image.scaleAbsolute(100f,100f);
		 image.setAbsolutePosition(450f, 700f);
		 doc.add(image);
		 
		 image = Image.getInstance(url2);
		 image.scaleAbsolute(100f,100f);
		 image.setAbsolutePosition(450f, 575f);
		 doc.add(image);
		 
		 image = Image.getInstance(url21);
		 image.scaleAbsolute(100f,100f);
		 image.setAbsolutePosition(450f, 450f);
		 doc.add(image);
		 
		 image = Image.getInstance(url22);
		 image.scaleAbsolute(100f,100f);
		 image.setAbsolutePosition(450f, 325f);
		 doc.add(image);
		 
		 image = Image.getInstance(url23);
		 image.scaleAbsolute(100f,100f);
		 image.setAbsolutePosition(450f, 200f);
		 doc.add(image);
		 
		 image = Image.getInstance(url1);
		 image.scaleAbsolute(100f,100f);
		 image.setAbsolutePosition(450f, 70f);
		 doc.add(image);
		 
		 Paragraph p1 = new Paragraph("Bill of Sale for Boat : " + boat.getName());
		 doc.add(p1);
		 p1 = new Paragraph("Facilitated by : " + agent.getFirstname() + " " + agent.getSurname()
				 	+ " (" + agent.getEmail() + ")");
		 doc.add(p1);
	
		
       // doc.add(new Paragraph("Bill of Sale"));
        
        p1 = new Paragraph(
        					"I _________________________________________________");  
        p1.setSpacingBefore(10);
        doc.add(p1);
        
        p1 = new Paragraph(	"Of ________________________________________________");
        p1.setSpacingBefore(10);
        doc.add(p1);
        p1 = new Paragraph(	" __________________________________________________");
        p1.setSpacingBefore(10);
        doc.add(p1);
        p1 = new Paragraph(	" __________________________________________________");
        p1.setSpacingBefore(10);
        doc.add(p1);
        
        p1 = new Paragraph("Do hereby transfer my boat"); 
        p1.setSpacingBefore(10);
        p1 = new Paragraph(
							"To ________________________________________________"); 
        p1.setSpacingBefore(10);
        doc.add(p1);

        p1 = new Paragraph(	"Of ________________________________________________");
        p1.setSpacingBefore(10);
        doc.add(p1);
        p1 = new Paragraph(	" __________________________________________________");
        p1.setSpacingBefore(10);
        doc.add(p1);
        p1 = new Paragraph(	" __________________________________________________");
        p1.setSpacingBefore(10);
        doc.add(p1);
        
        p1 = new Paragraph( "For the sum of ____________________ Currency_________");
        p1.setSpacingBefore(10);
        doc.add(p1); 
        p1 = new Paragraph("Being free from any encumberance.");
        p1.setSpacingBefore(10);
        doc.add(p1); 
        p1 = new Paragraph("All relevant papers were exchanged, e.g. registration etc.");
        p1.setSpacingBefore(10);
        doc.add(p1);
        
        p1 = new Paragraph("Signed seller _____________________________");
        p1.setSpacingBefore(10);
        doc.add(p1);
        p1 = new Paragraph("Signed buyer ______________________________");
        p1.setSpacingBefore(10);
        doc.add(p1);
        p1 = new Paragraph("Date _____/______/_______  (day/month/year)");
        p1.setSpacingBefore(10);
        doc.add(p1);
        p1 = new Paragraph("Witnessed by ______________________________");
        p1.setSpacingBefore(10);
        doc.add(p1);
        
        p1 = new Paragraph("Boat Particulars:");
        p1.setSpacingBefore(10);
        doc.add(p1);
        p1 = new Paragraph("Name _____________________________________________________");
        p1.setSpacingBefore(10);
        doc.add(p1);
        p1 = new Paragraph("Registration Number__________________________________________");
        p1.setSpacingBefore(10);
        doc.add(p1);
        p1 = new Paragraph("Where Registered ___________________________________________");
        p1.setSpacingBefore(10);
        doc.add(p1);
        p1 = new Paragraph("Make_____________________Model__________________Year______");
        p1.setSpacingBefore(10);
        doc.add(p1);
        p1 = new Paragraph("Completed form to be scanned and emailed to <joe@boatsandsailors.com>");
        p1.setSpacingBefore(10);
        doc.add(p1);
      */
    }
}
