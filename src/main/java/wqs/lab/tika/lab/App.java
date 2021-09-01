package wqs.lab.tika.lab;

import java.io.InputStream;

import org.apache.tika.metadata.Metadata;
import org.apache.tika.parser.ParseContext;
import org.apache.tika.sax.BodyContentHandler;
import org.apache.tika.parser.pdf.PDFParser;
import org.apache.tika.parser.pdf.PDFParserConfig; 

/**
 * Hello world!
 *
 */
public class App {
	
	
	public App() {
		
		BodyContentHandler handler = new BodyContentHandler();
		PDFParser parser = new PDFParser();
		Metadata metadata = new Metadata();
		ParseContext pcontext = new ParseContext();
		
		PDFParserConfig cfg = new PDFParserConfig();

		try (InputStream stream = getClass().getClassLoader().getResourceAsStream("CLDF_ASSEL_DAS.pdf")) {

			parser.parse(stream, handler, metadata, pcontext);
			System.out.println("Document Content:" + handler.toString());
			System.out.println("Document Metadata:");
			String[] metadatas = metadata.names();

			for (String data : metadatas) {
				System.out.println(data + ":   " + metadata.get(data));
			}

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Exception message: " + e.getMessage());
		}
		
	}
	
	public static void main(String[] args) {
		System.out.println("Hello World!");

		App app = new App();
	}
	
}
