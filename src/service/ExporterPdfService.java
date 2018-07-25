package service;

import java.io.FileOutputStream;
import java.util.Scanner;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.pdf.PdfWriter;

import fr.pizzeria.MemDao.IPizzaDao;
import fr.pizzeria.exception.StockageException;

public class ExporterPdfService extends MenuService {

	@Override
	public void executeUC(Scanner scanner, IPizzaDao interfacePizza) throws StockageException {

		Document document = new Document();
		PdfWriter.getInstance(document, new FileOutputStream("ListePizza.pdf"));
		 
		document.open();
		Font font = FontFactory.getFont(FontFactory.COURIER, 16, BaseColor.BLACK);
		Chunk chunk = new Chunk("Hello World", font);
		 
		document.add(chunk);
		document.close();

	}

}
