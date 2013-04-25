package clinique.mapping;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class DevisAssureur {
	
	private  String devisAssureurId;
	private  double total;

	private  Date dateDevis;
	
	private  String statut;
	private  String operateur;
	
	private  Categorie categorie;
	private Patient patient;
	
	private List <DevisActes> devisActes=new ArrayList<DevisActes>();
	
	
	public String getDevisAssureurId() {
		return devisAssureurId;
	}
	public void setDevisAssureurId(String devisAssureurId) {
		this.devisAssureurId = devisAssureurId;
	}
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}
	public Date getDateDevis() {
		return dateDevis;
	}
	public void setDateDevis(Date dateDevis) {
		this.dateDevis = dateDevis;
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
	public Patient getPatient() {
		return patient;
	}
	public void setPatient(Patient patient) {
		this.patient = patient;
	}
	public List<DevisActes> getDevisActes() {
		return devisActes;
	}
	public void setDevisActes(List<DevisActes> devisActes) {
		this.devisActes = devisActes;
	}

	
   
	
	

}
