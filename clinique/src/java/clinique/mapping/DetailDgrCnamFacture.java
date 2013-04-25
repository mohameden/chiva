package clinique.mapping;

import java.util.Date;

public class DetailDgrCnamFacture {

	private String detailDrgCnamId;
	private Facture facture;
	private Patient patient;
	private DrgCnam drgCnam;
	
	private  String statut;
	private  String operateur;
	private double petitMonnaie=0;
	
	private  Date dateDetail;
	
	
	public String getDetailDrgCnamId() {
		return detailDrgCnamId;
	}
	public void setDetailDrgCnamId(String detailDrgCnamId) {
		this.detailDrgCnamId = detailDrgCnamId;
	}
	public Facture getFacture() {
		return facture;
	}
	public void setFacture(Facture facture) {
		this.facture = facture;
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
	
	public Date getDateDetail() {
		return dateDetail;
	}
	public void setDateDetail(Date dateDetail) {
		this.dateDetail = dateDetail;
	}
	public Patient getPatient() {
		return patient;
	}
	public void setPatient(Patient patient) {
		this.patient = patient;
	}
	public DrgCnam getDrgCnam() {
		return drgCnam;
	}
	public void setDrgCnam(DrgCnam drgCnam) {
		this.drgCnam = drgCnam;
	}
	public double getPetitMonnaie() {
		return petitMonnaie;
	}
	public void setPetitMonnaie(double petitMonnaie) {
		this.petitMonnaie = petitMonnaie;
	}
	
	

	
	
}
