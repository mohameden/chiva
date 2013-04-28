package clinique.mapping;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ChambreH {
	
	private  String chambreHId;
	
	private  String chambreNum;
	private  String chambreLibelle;
	private  double tarif;
	private  String etat;
	private  String statut;
	private  Date dateDebut;
	private  Date dateFin;
	
	private Chambre chambre;
	
	

	public String getChambreNum() {
		return chambreNum;
	}
	public void setChambreNum(String chambreNum) {
		this.chambreNum = chambreNum;
	}
	public String getChambreLibelle() {
		return chambreLibelle;
	}
	public void setChambreLibelle(String chambreLibelle) {
		this.chambreLibelle = chambreLibelle;
	}
	public double getTarif() {
		return tarif;
	}
	public void setTarif(double tarif) {
		this.tarif = tarif;
	}
	public String getEtat() {
		return etat;
	}
	public void setEtat(String etat) {
		this.etat = etat;
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
	public String getChambreHId() {
		return chambreHId;
	}
	public void setChambreHId(String chambreHId) {
		this.chambreHId = chambreHId;
	}
	public Chambre getChambre() {
		return chambre;
	}
	public void setChambre(Chambre chambre) {
		this.chambre = chambre;
	}
	
	


}
