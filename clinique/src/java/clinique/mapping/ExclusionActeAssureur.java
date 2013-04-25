package clinique.mapping;

import java.util.Date;

public class ExclusionActeAssureur {
	
	private  int exclusionId;
	
	private  String statut;
	private  String operateur;
	private  Date dateDebut;
	private  Date dateFin;

	private Categorie categorie;
	private Acte acte;

	
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
	
	public int getExclusionId() {
		return exclusionId;
	}
	public void setExclusionId(int exclusionId) {
		this.exclusionId = exclusionId;
	}
	public Acte getActe() {
		return acte;
	}
	public void setActe(Acte acte) {
		this.acte = acte;
	}
    
}
