package clinique.mapping;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class FactureGlobal {
	
	private String factureGlobalId;
	private Categorie categorie;
	private String numeroFacture;
	private Date dateFacture;
	private  String statut;
	private  String operateur;
	
	private List <FactureGlobalFacture> factureGlobalFactures=new ArrayList<FactureGlobalFacture>();
	
	
	public String getFactureGlobalId() {
		return factureGlobalId;
	}
	public void setFactureGlobalId(String factureGlobalId) {
		this.factureGlobalId = factureGlobalId;
	}
	public Categorie getCategorie() {
		return categorie;
	}
	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}
	public String getNumeroFacture() {
		return numeroFacture;
	}
	public void setNumeroFacture(String numeroFacture) {
		this.numeroFacture = numeroFacture;
	}
	public Date getDateFacture() {
		return dateFacture;
	}
	public void setDateFacture(Date dateFacture) {
		this.dateFacture = dateFacture;
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
	public List<FactureGlobalFacture> getFactureGlobalFactures() {
		return factureGlobalFactures;
	}
	public void setFactureGlobalFactures(
			List<FactureGlobalFacture> factureGlobalFactures) {
		this.factureGlobalFactures = factureGlobalFactures;
	}
	
	

}
