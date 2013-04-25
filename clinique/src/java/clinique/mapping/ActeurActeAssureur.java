package clinique.mapping;

import java.util.Date;

public class ActeurActeAssureur {
	
	private  String acteurActeAsureurId;
	private  int pourcentage;
	private  String statut;
	private  String operateur;
	private int pourcentageUrg;
	private String isException;
	private double prix;
	private double prixUrg;
	private  Date dateDebut;
	private  Date dateFin;
	
	
	private Categorie categorie;
	private Acte acte;
	private Acteur acteur;

	public int getPourcentage() {
		return pourcentage;
	}
	public Acte getActe() {
		return acte;
	}
	public void setActe(Acte acte) {
		this.acte = acte;
	}
	public void setPourcentage(int pourcentage) {
		this.pourcentage = pourcentage;
	}
	public Acteur getActeur() {
		return acteur;
	}
	public void setActeur(Acteur acteur) {
		this.acteur = acteur;
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
	public int getPourcentageUrg() {
		return pourcentageUrg;
	}
	public void setPourcentageUrg(int pourcentageUrg) {
		this.pourcentageUrg = pourcentageUrg;
	}
	public String getIsException() {
		return isException;
	}
	public void setIsException(String isException) {
		this.isException = isException;
	}
	public double getPrix() {
		return prix;
	}
	public void setPrix(double prix) {
		this.prix = prix;
	}
	public double getPrixUrg() {
		return prixUrg;
	}
	public void setPrixUrg(double prixUrg) {
		this.prixUrg = prixUrg;
	}
	public Date getDateDebut() {
		return dateDebut;
	}
	public void setDateDebut(Date dateDebut) {
		this.dateDebut = dateDebut;
	}
	public Date getDateFin() {
		return dateFin;
	}
	public void setDateFin(Date dateFin) {
		this.dateFin = dateFin;
	}
	public String getActeurActeAsureurId() {
		return acteurActeAsureurId;
	}
	public void setActeurActeAsureurId(String acteurActeAsureurId) {
		this.acteurActeAsureurId = acteurActeAsureurId;
	}
	public Categorie getCategorie() {
		return categorie;
	}
	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}
	


}
