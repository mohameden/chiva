package clinique.mapping;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PriseEnChargeModifiee {
	
	private  String pcId;
	private  String pcNum;
	private  double plafond;
	private  int pourcentage;
	private  Date finValidite;
	private  Date dateCreation;
	private  int nombreActes;
	private  double montantFact;
	private  String statut;
	private  String operateur;
	
	private Patient patient;
	
	private Categorie categorie;
	
	private List <PrestationCouvertesPcModifiee> prestationCouvertesPcs=new ArrayList<PrestationCouvertesPcModifiee>();

	
	public String getPcNum() {
		return pcNum;
	}
	public void setPcNum(String pcNum) {
		this.pcNum = pcNum;
	}
	public double getPlafond() {
		return plafond;
	}
	public Patient getPatient() {
		return patient;
	}
	public void setPatient(Patient patient) {
		this.patient = patient;
	}
	public void setPlafond(double plafond) {
		this.plafond = plafond;
	}
	public int getPourcentage() {
		return pourcentage;
	}
	public void setPourcentage(int pourcentage) {
		this.pourcentage = pourcentage;
	}
	public Date getFinValidite() {
		return finValidite;
	}
	public void setFinValidite(Date finValidite) {
		this.finValidite = finValidite;
	}
	public Date getDateCreation() {
		return dateCreation;
	}
	public void setDateCreation(Date dateCreation) {
		this.dateCreation = dateCreation;
	}
	public int getNombreActes() {
		return nombreActes;
	}
	public void setNombreActes(int nombreActes) {
		this.nombreActes = nombreActes;
	}
	public double getMontantFact() {
		return montantFact;
	}
	public void setMontantFact(double montantFact) {
		this.montantFact = montantFact;
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

	public String getPcId() {
		return pcId;
	}
	public void setPcId(String pcId) {
		this.pcId = pcId;
	}
	public Categorie getCategorie() {
		return categorie;
	}
	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}
	public List<PrestationCouvertesPcModifiee> getPrestationCouvertesPcs() {
		return prestationCouvertesPcs;
	}
	public void setPrestationCouvertesPcs(
			List<PrestationCouvertesPcModifiee> prestationCouvertesPcs) {
		this.prestationCouvertesPcs = prestationCouvertesPcs;
	}
	
}
