package xml;

import java.util.LinkedList;
import java.util.List;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;


public class ClientHandler extends DefaultHandler{
	//résultats de notre parsing
	private List<Client> annuaire;
	private Client client;
	
	//flags nous indiquant la position du parseur
	private boolean inAnnuaire, inPersonne, inNom, inPrenom, inAdresse, inCourriel, 
					inTel, inAnniversaire, inVille, inProvince, inMDP, inCP, inForfait;
	
	//buffer nous permettant de récupérer les données 
	private StringBuffer buffer;

	// simple constructeur
	public ClientHandler(){
		super();
	}
	
	//détection d'ouverture de balise
	public void startElement(String uri, String localName,String qName, Attributes attributes) throws SAXException {
		if (qName.equals("clients")) {
			annuaire = new LinkedList<Client>();
			inAnnuaire = true;
		} else if(qName.equals("client")){
			client = new Client();
			try{
				int id = Integer.parseInt(attributes.getValue("id"));
				client.setID(id);
			}catch(Exception e){
				//erreur, le contenu de id n'est pas un entier
				throw new SAXException(e);
			}
			inPersonne = true;
		} else {
			buffer = new StringBuffer();
			if (qName.equals("nom-famille")) {
				inNom = true;
			} else if (qName.equals("prenom")) {
				inPrenom = true;
			} else if (qName.equals("courriel")) {
				inCourriel = true;
			} else if (qName.equals("tel")) {
				inTel = true;
			} else if (qName.equals("anniversaire")) {
				inAnniversaire = true;
			} else if (qName.equals("adresse")) {
				inAdresse = true;
			} else if (qName.equals("ville")) {
				inVille = true;
			} else if (qName.equals("province")) {
				inProvince = true;
			} else if (qName.equals("code-postal")) {
				inCP = true;
			} else if (qName.equals("mot-de-passe")) {
				inMDP = true;
			} else if (qName.equals("forfait")) {
				inForfait = true;
			} else{
				//erreur, on peut lever une exception
//				throw new SAXException("Balise "+qName+" inconnue.");
			}
		}
	}
	//détection fin de balise
	public void endElement(String uri, String localName, String qName)
			throws SAXException{
		if (qName.equals("clients")) {
			inAnnuaire = false;
		} else if (qName.equals("client")) {
			annuaire.add(client);
			client = null;
			inPersonne = false;
		} else if (qName.equals("nom-famille")) {
			client.setNom(buffer.toString());
			buffer = null;
			inNom = false;
		} else if (qName.equals("prenom")) {
			client.setPrenom(buffer.toString());
			buffer = null;
			inPrenom = false;
		} else if (qName.equals("courriel")) {
			client.setCourriel(buffer.toString());
			buffer = null;
			inCourriel = false;
		} else if (qName.equals("tel")) {
			client.setTelephone(buffer.toString());
			buffer = null;
			inTel = false;
		} else if (qName.equals("anniversaire")) {
			client.setAnniversaire(buffer.toString());
			buffer = null;
			inAnniversaire = false;
		} else if (qName.equals("adresse")) {
			client.setAdresse(buffer.toString());
			buffer = null;
			inAdresse = false;
		} else if (qName.equals("ville")) {
			client.setVille(buffer.toString());
			buffer = null;
			inVille = false;
		} else if (qName.equals("province")) {
			client.setProvince(buffer.toString());
			buffer = null;
			inProvince = false;
		} else if (qName.equals("code-postal")) {
			client.setCP(buffer.toString());
			buffer = null;
			inCP = false;
		} else if (qName.equals("mot-de-passe")) {
			client.setMDP(buffer.toString());
			buffer = null;
			inMDP = false;
		} else {
			//erreur, on peut lever une exception
//			throw new SAXException("Balise "+qName+" inconnue.");
		}          
	}
	//détection de caract�res
	public void characters(char[] ch,int start, int length)
			throws SAXException{
		String lecture = new String(ch,start,length);
		if(buffer != null) buffer.append(lecture);       
	}
	//début du parsing
	public void startDocument() throws SAXException {
		System.out.println("Début du parsing");
	}
	//fin du parsing
	public void endDocument() throws SAXException {
		System.out.println("Fin du parsing");
		System.out.println("Resultats du parsing :\n");
		for(Client p : annuaire){
			System.out.println(p);
		}
	}
}