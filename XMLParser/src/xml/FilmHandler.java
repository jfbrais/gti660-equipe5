package xml;

import java.util.LinkedList;
import java.util.List;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;


public class FilmHandler extends DefaultHandler{
	//r�sultats de notre parsing
	private List<Film> annuaire;
	private Film film;
	//flags nous indiquant la position du parseur
	private boolean inAnnuaire, inFilm, inTitre, inAnnee, inPays, inLangue, inDuree, inResume, inGenre, inRealisateur, inRole, inActeur, inPersonnage;
	//buffer nous permettant de r�cup�rer les donn�es
	private StringBuffer buffer;

	// simple constructeur
	public FilmHandler(){
		super();
	}
	//d�tection d'ouverture de balise
	public void startElement(String uri, String localName,
			String qName, Attributes attributes) throws SAXException{
		if(qName.equals("films")){
			annuaire = new LinkedList<Film>();
			inAnnuaire = true;
		}else if(qName.equals("film")){
			film = new Film();
			try{
				int idFilm = Integer.parseInt(attributes.getValue("id"));
				film.setIdFilm(idFilm);
			}catch(Exception e){
				//erreur, le contenu de id n'est pas un entier
				throw new SAXException(e);
			}
			inFilm = true;
		}else {
			buffer = new StringBuffer();
			if(qName.equals("titre")){
				inTitre = true;
			}else if(qName.equals("annee")){
				inAnnee = true;
			}else if(qName.equals("pays")){
				inPays = true;
			}else if(qName.equals("langue")){
				inLangue = true;
			}else if(qName.equals("duree")){
				inDuree = true;
			}else if(qName.equals("resume")){
				inResume = true;
			}else if(qName.equals("genre")){
				inGenre = true;
			}else if(qName.equals("realisateur")){
				inRealisateur = true;
			}else if(qName.equals("role")){
					inRole = true;
			}else if(qName.equals("acteur")){
				try{
					int idActeur = Integer.parseInt(attributes.getValue("id"));
					film.setIdActeur(idActeur);
				}catch(Exception e){
					//erreur, le contenu de id n'est pas un entier
					throw new SAXException(e);
				}
				inActeur = true;
			}else if(qName.equals("personnage")){
				inPersonnage = true;
			}else{
				//erreur, on peut lever une exception
//					throw new SAXException("Balise "+qName+" inconnue.");
			}
		}
	}
	//d�tection fin de balise
	public void endElement(String uri, String localName, String qName)
			throws SAXException{
		if(qName.equals("films")){
			inAnnuaire = false;
		}else if(qName.equals("film")){
			annuaire.add(film);
			film = null;
			inFilm = false;
		}else if(qName.equals("titre")){
			film.setTitre(buffer.toString());
			buffer = null;
			inTitre = false;
		}else if(qName.equals("annee")){
			film.setAnnee(buffer.toString());
			buffer = null;
			inAnnee = false;
		}else if(qName.equals("pays")){
			film.setPays(buffer.toString());
			buffer = null;
			inPays = false;
		}else if(qName.equals("langue")){
			film.setLangue(buffer.toString());
			buffer = null;
			inLangue = false;
		}else if(qName.equals("duree")){
			film.setDuree(buffer.toString());
			buffer = null;
			inDuree = false;
		}else if(qName.equals("resume")){
			film.setResume(buffer.toString());
			buffer = null;
			inResume = false;
		}else if(qName.equals("genre")){
			film.setGenre(buffer.toString());
			buffer = null;
			inGenre = false;
		}else if(qName.equals("realisateur")){
			film.setRealisateur(buffer.toString());
			buffer = null;
			inRealisateur = false;
		}else if(qName.equals("role")){
			buffer = null;
			inRole = false;
		}else if(qName.equals("acteur")){
			film.setActeur(buffer.toString());
			buffer = null;
			inActeur = false;
		}else if(qName.equals("personnage")){
			film.setPersonnage(buffer.toString());
			buffer = null;
			inPersonnage = false;
		}else{
			//erreur, on peut lever une exception
//				throw new SAXException("Balise "+qName+" inconnue.");
		}
	}
	//d�tection de caract�res
	public void characters(char[] ch,int start, int length)
			throws SAXException{
		String lecture = new String(ch,start,length);
		if(buffer != null) buffer.append(lecture);
	}
	//d�but du parsing
	public void startDocument() throws SAXException {
		System.out.println("D�but du parsing");
	}
	//fin du parsing
	public void endDocument() throws SAXException {
		System.out.println("Fin du parsing");
		System.out.println("Resultats du parsing");
		for(Film  p : annuaire){
			System.out.println(p);
		}
	}
}
