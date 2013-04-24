package clinique.mapping;

import java.util.ArrayList;
import java.util.List;

public class Assureur {
	
	private  int assureurId;
	private  String   nomAssureur;
	private  String   adresse;
	private  String   statut;
	private  String   operateur;
	private List <Entreprise> entreprises=new ArrayList<Entreprise>();
	

	public int getAssureurId() {
		return assureurId;
	}
	public void setAssureurId(int assureurId) {
		this.assureurId = assureurId;
	}
	public String getNomAssureur() {
		return nomAssureur;
	}
	public void setNomAssureur(String nomAssureur) {
		this.nomAssureur = nomAssureur;
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
	public List<Entreprise> getEntreprises() {
		return entreprises;
	}
	public void setEntreprises(List<Entreprise> entreprises) {
		this.entreprises = entreprises;
	}
	
	
}
