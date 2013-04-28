package clinique.mapping;

import java.util.Date;


public class ChambresHospitalisation {
	
	private  String chambreHospitalisationId;
	private Date dateEntree;
	private Date dateSortie;
	private  String statut;
	private  String operateur;
	private int heureEntree;
	private int heureSortie;
	private double total;
	private double totalReel;

	private Hospitalisation hospitalisation;
	private Chambre chambre;
	
	public String getChambreHospitalisationId() {
		return chambreHospitalisationId;
	}
	public void setChambreHospitalisationId(String chambreHospitalisationId) {
		this.chambreHospitalisationId = chambreHospitalisationId;
	}
	public Date getDateEntree() {
		return dateEntree;
	}
	public void setDateEntree(Date dateEntree) {
		this.dateEntree = dateEntree;
	}
	public Date getDateSortie() {
		return dateSortie;
	}
	public void setDateSortie(Date dateSortie) {
		this.dateSortie = dateSortie;
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
	public Hospitalisation getHospitalisation() {
		return hospitalisation;
	}
	public void setHospitalisation(Hospitalisation hospitalisation) {
		this.hospitalisation = hospitalisation;
	}
	public Chambre getChambre() {
		return chambre;
	}
	public void setChambre(Chambre chambre) {
		this.chambre = chambre;
	}
	public int getHeureEntree() {
		return heureEntree;
	}
	public void setHeureEntree(int heureEntree) {
		this.heureEntree = heureEntree;
	}
	public int getHeureSortie() {
		return heureSortie;
	}
	public void setHeureSortie(int heureSortie) {
		this.heureSortie = heureSortie;
	}
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}
	public double getTotalReel() {
		return totalReel;
	}
	public void setTotalReel(double totalReel) {
		this.totalReel = totalReel;
	}
	
	
	
   
}
