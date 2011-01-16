package xml;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;


public class Application {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			SAXParserFactory fabrique = SAXParserFactory.newInstance();
			SAXParser parseur = fabrique.newSAXParser();

			File fichier = new File("etc/clients.xml");
			DefaultHandler gestionnaire = (DefaultHandler) new ClientHandler();
			parseur.parse(fichier, gestionnaire);
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}