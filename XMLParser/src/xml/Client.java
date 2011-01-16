package xml;

public class Client {

	private int id;
	private String nom, prenom, courriel, telephone, anniversaire, adresse, ville, prov, codePostal, motDePasse;
	private String cc, ccEmetteur, ccMois, ccAnnee;

	public Client(){}

	// Informations du client.
	public int getId(){return id;}
	public String getNom(){return nom;}
	public String getPrenom(){return prenom;}
	public String getCourriel(){return courriel;}
	public String getTelephone(){return telephone;}
	public String Anniversaire(){return anniversaire;}
	public String getAdresse(){return adresse;}
	public String getVille(){return ville;}
	public String getProvince(){return prov;}
	public String getCP(){return codePostal;}
	public String getMDP(){return motDePasse;}
	
	// Informations de la carte de crédit.
	public String getCC(){return cc;}
	public String getCCEmetteur() {return ccEmetteur;}
	public String getCCMois() {return ccMois;}
	public String getCCAnnee() {return ccAnnee;}
	
	public void setID (int id) {
		this.id = id;
	}
	
	public void setNom (String nom) {
		this.nom = nom;
	}
	
	public void setPrenom (String prenom) {
		this.prenom = prenom;
	}
	
	public void setCourriel (String courriel) {
		this.courriel = courriel;
	}
	
	public void setTelephone (String telephone) {
		this.telephone = telephone;
	}
	
	public void setAnniversaire (String anniversaire) {
		this.anniversaire = anniversaire;
	}
	
	public void setAdresse (String adresse) {
		this.adresse = adresse;
	}
	
	public void setVille (String ville) {
		this.ville = ville;
	}
	
	public void setProvince(String prov) {
		this.prov = prov;
	}
	
	public void setCP (String CP) {
		this.codePostal = CP;
	}
	
	public void setMDP (String mdp) {
		this.motDePasse = mdp;
	}
	
	public void setCC(String cc) {
		this.cc = cc;
	}
	
	public void setCCEmetteur(String emetteur) {
		ccEmetteur = emetteur;
	}
	
	public void setCCMois(String mois) {
		ccMois = mois;
	}
	
	public void setCCAnnee(String annee) {
		ccAnnee = annee;
	}
	
	public String toString(){
		return new StringBuffer
			("Client : " + id).append("\tNom : " + nom + ", " + prenom)
			.append("\nAdresse : " + adresse)
			.append("\nVille : " + ville + ", (" + prov + "), " + codePostal)
			.append("\n****")
			.append("\nCC : " + cc).append(" - " + ccEmetteur)
			.append("\nExp.: " + ccMois + "/" + ccAnnee)
			.append("\n")
			.toString();
	}
}