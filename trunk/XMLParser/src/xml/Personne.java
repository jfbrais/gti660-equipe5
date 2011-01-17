package xml;

public class Personne {

	private int id;
	private String nom, anniversaire, lieu, photo, bio;

	public Personne(){}

	public int getId(){return id;}
	public String getNom(){return nom;}
	public String getAnniversaire(){return anniversaire;}
	public String getLieu(){return lieu;}
	public String getBio(){return bio;}
	public String getPhoto(){return photo;}


	public void setId(int id){this.id = id;}
	public void setNom(String nom){this.nom = nom;}
	public void setAnniversaire(String anniversaire){this.anniversaire = anniversaire;}
	public void setLieu(String lieu){this.lieu = lieu;}
	public void setPhoto(String photo){this.photo = photo;}
	public void setBio(String bio){this.bio = bio;}


	public String toString(){
		return new StringBuffer("Nom : ").append(nom).append(", ")
			.append("anniversaire : ").append(anniversaire).append(", ")
			.append("lieu : ").append(lieu).append(", ")
			.append("photo : ").append(photo).append(", ")
			.append("bio : ").append(bio)
			.toString();
	}

}
