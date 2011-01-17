import java.util.ArrayList;


public class Film {
		private int idFilm;
		private String titre, annee, pays, langue, duree,resume, acteur, personnage;
		private ArrayList<String> genre = new ArrayList<String>();
		private ArrayList<String> realisateur = new ArrayList<String>();
		private ArrayList<String> scenariste = new ArrayList<String>();
		private ArrayList<Integer> idActeur = new ArrayList<Integer>();
		private ArrayList<String[]> role = new ArrayList<String[]>();
		private String infoRole[] = new String [2];

		public int getIdFilm(){return idFilm;}
		public String getTitre(){return titre;}
		public String getAnnee(){return annee;}
		public String getPays(){return pays;}
		public String getLangue (){return langue;}
		public String getDuree(){return duree;}
		public String getResume(){return resume;}
		public ArrayList<String> getGenre(){return genre;}
		public ArrayList<String> getRealisateur(){return realisateur;}
		public ArrayList<String> getScenariste(){return scenariste;}
		public ArrayList<Integer> getIdActeur(){return idActeur;}
		public String getActeur(){return acteur;}
		public String getPersonnage(){return personnage;}
		
		
		public void setIdFilm(int idFilm){this.idFilm = idFilm;}
		public void setTitre(String titre){this.titre = titre;}
		public void setAnnee(String annee){this.annee = annee;}
		public void setPays(String pays){this.pays = pays;}
		public void setLangue(String langue){this.langue = langue;}
		public void setDuree(String duree){this.duree = duree;}
		public void setResume(String resume){this.resume = resume;}
		public void setGenre(String genre){this.genre.add(genre);}
		public void setRealisateur(String realisateur){this.realisateur.add(realisateur);}
		public void setScenariste(String scenariste){this.scenariste.add(scenariste);}
		public void setIdActeur(int idActeur){this.idActeur.add(idActeur);}
		public void setActeur(String acteur){this.infoRole[0] = acteur;}
		public void setPersonnage(String personnage){
			this.infoRole[1] = personnage;
			role.add(infoRole);}	
		

		public String toString(){
			return new StringBuffer("titre : ").append(titre).append(", ")
				.append("annee : ").append(annee).append(", ")
				.append("pays : ").append(pays).append(", ")
				.append("langue : ").append(langue).append(", ")
				.append("idActeur : ").append(idActeur).append(", ")
				.append("genre : ").append(genre).append(", ")
				.toString();
		}
}
