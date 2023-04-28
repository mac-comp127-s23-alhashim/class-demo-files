package pdfdemo;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
 
/**
 * This class is used to create a pdf file using iText jar.
 * @author w3spoint
 */
public class PDFCreateExample {
  public static void main(String args[]) throws FileNotFoundException, DocumentException{
    Document document = new Document();
    PdfWriter.getInstance(document, new FileOutputStream("iTextHelloWorld.pdf"));

    document.open();
    Font font = FontFactory.getFont(FontFactory.COURIER, 16, BaseColor.BLACK);
    Chunk chunk = new Chunk("Hello COMP127", font);

    document.add(chunk);
    document.close();
  }
}