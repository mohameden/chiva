package clinique.mapping;

import java.util.Date;

public class ParametresClinique {
	
	private  String parametreId;
	private  String parametre;
	private  String valeur;
	
	private  String operateur;
	private  String statut;
	private  Date dateDebut;
	private  Date dateFin;
	
	public String getParametreId() {
		return parametreId;
	}
	public void setParametreId(String parametreId) {
		this.parametreId = parametreId;
	}
	public String getParametre() {
		return parametre;
	}
	public void setParametre(String parametre) {
		this.parametre = parametre;
	}
	public String getValeur() {
		return valeur;
	}
	public void setValeur(String valeur) {
		this.valeur = valeur;
	}
	public String getOperateur() {
		return operateur;
	}
	public void setOperateur(String operateur) {
		this.operateur = operateur;
	}
	public String getStatut() {
		return statut;
	}
	public void setStatut(String statut) {
		this.statut = statut;
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
	
	
}
