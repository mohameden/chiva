package clinique.mapping;

import java.util.Date;

public class BlackListe {
	
	private  int blacklisteId;
	private  String numeroBadge;
	private  String statut;
	private  String operateur;
	private  Date dateDebut;
	private  Date dateFin;

	private Categorie categorie;
	
	public int getBlacklisteId() {
		return blacklisteId;
	}
	public void setBlacklisteId(int blacklisteId) {
		this.blacklisteId = blacklisteId;
	}
	public String getNumeroBadge() {
		return numeroBadge;
	}
	public void setNumeroBadge(String numeroBadge) {
		this.numeroBadge = numeroBadge;
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
	public Categorie getCategorie() {
		return categorie;
	}
	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
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
