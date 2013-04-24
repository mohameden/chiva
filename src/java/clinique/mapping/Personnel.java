package clinique.mapping;

import java.util.ArrayList;
import java.util.List;



public class Personnel {
	
	private  int personnelId ;
	private  String nom;
	private  String prenom;
	private String isActeur;
	private Acteur acteur;
	
	private  String statut;
	private  String operateur;
	

	private List <Compte> comptes=new ArrayList<Compte>();

	
	public int getPersonnelId() {
		return personnelId;
	}
	public void setPersonnelId(int personnelId) {
		this.personnelId = personnelId;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
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
	public String getIsActeur() {
		return isActeur;
	}
	public void setIsActeur(String isActeur) {
		this.isActeur = isActeur;
	}
	public Acteur getActeur() {
		return acteur;
	}
	public void setActeur(Acteur acteur) {
		this.acteur = acteur;
	}
	public List<Compte> getComptes() {
		return comptes;
	}
	public void setComptes(List<Compte> comptes) {
		this.comptes = comptes;
	}
	
	
	
	
}
