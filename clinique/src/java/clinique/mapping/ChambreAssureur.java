package clinique.mapping;

import java.util.Date;

public class ChambreAssureur {
	
	private  String chambreAssureurId;
	
	private  double tarif;

	private  String statut;
	private  Date dateDebut;
	private  Date dateFin;
	
	private Chambre chambre;
	private Categorie categorie;
	
	
	public double getTarif() {
		return tarif;
	}
	public void setTarif(double tarif) {
		this.tarif = tarif;
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
	public Chambre getChambre() {
		return chambre;
	}
	public void setChambre(Chambre chambre) {
		this.chambre = chambre;
	}
	public Categorie getCategorie() {
		return categorie;
	}
	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}
	public String getChambreAssureurId() {
		return chambreAssureurId;
	}
	public void setChambreAssureurId(String chambreAssureurId) {
		this.chambreAssureurId = chambreAssureurId;
	}
	


}
