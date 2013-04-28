package clinique.mapping;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class Entreprise {
	
	private  int entrepriseId;
	private  String nomEntreprise;
	private  String adresse;

	private  String statut;
	private  String operateur;
	
	private  Assureur assureur;
	private List <Categorie> categories=new ArrayList<Categorie>();
	
	public int getEntrepriseId() {
		return entrepriseId;
	}
	public void setEntrepriseId(int entrepriseId) {
		this.entrepriseId = entrepriseId;
	}
	public String getNomEntreprise() {
		return nomEntreprise;
	}
	public void setNomEntreprise(String nomEntreprise) {
		this.nomEntreprise = nomEntreprise;
	}
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	
	public String getStatut() {
		return statut;
	}
	public void setStatut(String statut) {
		this.statut = statut;
	}
	public String getOperateur() {
		return operateur;
	}
	public void setOperateur(String operateur) {
		this.operateur = operateur;
	}
	
	public Assureur getAssureur() {
		return assureur;
	}
	public void setAssureur(Assureur assureur) {
		this.assureur = assureur;
	}
	public List<Categorie> getCategories() {
		return categories;
	}
	public void setCategories(List<Categorie> categories) {
		this.categories = categories;
	}
}
