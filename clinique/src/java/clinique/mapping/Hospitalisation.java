package clinique.mapping;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class Hospitalisation {
	
	private  String hospitalisationId;
	private  Date dateEntree;
	private  Date dateSortie;
	private  String statut;
	private  String operateur;
	private String encours;
	
	private Patient patient;
	private Chambre chambre;
	private Facture facture;
	
	private List <ChambresHospitalisation> chambresHospitalisation=new ArrayList<ChambresHospitalisation>();

	
    
	
	
	public String getHospitalisationId() {
		return hospitalisationId;
	}
	public void setHospitalisationId(String hospitalisationId) {
		this.hospitalisationId = hospitalisationId;
	}
	public String getStatut() {
		return statut;
	}
	public Patient getPatient() {
		return patient;
	}
	public void setPatient(Patient patient) {
		this.patient = patient;
	}
	public Chambre getChambre() {
		return chambre;
	}
	public void setChambre(Chambre chambre) {
		this.chambre = chambre;
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
	public List<ChambresHospitalisation> getChambresHospitalisation() {
		return chambresHospitalisation;
	}
	public void setChambresHospitalisation(
			List<ChambresHospitalisation> chambresHospitalisation) {
		this.chambresHospitalisation = chambresHospitalisation;
	}
	public String getEncours() {
		return encours;
	}
	public void setEncours(String encours) {
		this.encours = encours;
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
	public Facture getFacture() {
		return facture;
	}
	public void setFacture(Facture facture) {
		this.facture = facture;
	}
	
	
	
	


}
