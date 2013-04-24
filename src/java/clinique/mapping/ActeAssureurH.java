package clinique.mapping;

import java.util.Date;

public class ActeAssureurH {
	
	private  String acteAssureurHId ;
	private  String nomActe;
	private  double prix;
	private  double prixUrg;
	private  double prixDepl;
	private  int pck;
	private  String coef;
	
	private  String statut;
	private  String operateur;
	private  Date dateDebut;
	private  Date dateFin;
	
	private ActeAssureur acteAssureur;
    private Acte acte;
    private Categorie categorie;


	public String getNomActe() {
		return nomActe;
	}

	public void setNomActe(String nomActe) {
		this.nomActe = nomActe;
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

	public double getPrixDepl() {
		return prixDepl;
	}

	public void setPrixDepl(double prixDepl) {
		this.prixDepl = prixDepl;
	}

	public int getPck() {
		return pck;
	}

	public void setPck(int pck) {
		this.pck = pck;
	}

	public String getCoef() {
		return coef;
	}

	public void setCoef(String coef) {
		this.coef = coef;
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


	

	public ActeAssureur getActeAssureur() {
		return acteAssureur;
	}

	public void setActeAssureur(ActeAssureur acteAssureur) {
		this.acteAssureur = acteAssureur;
	}

	public String getActeAssureurHId() {
		return acteAssureurHId;
	}

	public void setActeAssureurHId(String acteAssureurHId) {
		this.acteAssureurHId = acteAssureurHId;
	}

	public Acte getActe() {
		return acte;
	}

	public void setActe(Acte acte) {
		this.acte = acte;
	}

	public Categorie getCategorie() {
		return categorie;
	}

	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}
	
	
	
	

}
