package clinique.mapping;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Compte {
	
	private  String compteId;
	private  String numeroCompte;
	
	private  double soldeAvant;
	private double solde;
	private Personnel personnel;
	private  String etat;
	private  String statut;
	private  String operateur;
	private Date dateTransaction;
	
	private List <TransactionCompte> transactionsCompte=new ArrayList<TransactionCompte>();

	private List <PcPersonnel> pcPersonnels=new ArrayList<PcPersonnel>();
	

	
	
	public String getCompteId() {
		return compteId;
	}
	public void setCompteId(String compteId) {
		this.compteId = compteId;
	}
	public String getNumeroCompte() {
		return numeroCompte;
	}
	public void setNumeroCompte(String numeroCompte) {
		this.numeroCompte = numeroCompte;
	}
	public double getSoldeAvant() {
		return soldeAvant;
	}
	public void setSoldeAvant(double soldeAvant) {
		this.soldeAvant = soldeAvant;
	}
	public double getSolde() {
		return solde;
	}
	public void setSolde(double solde) {
		this.solde = solde;
	}
	public Personnel getPersonnel() {
		return personnel;
	}
	public void setPersonnel(Personnel personnel) {
		this.personnel = personnel;
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
	public String getOperateur() {
		return operateur;
	}
	public void setOperateur(String operateur) {
		this.operateur = operateur;
	}
	public Date getDateTransaction() {
		return dateTransaction;
	}
	public void setDateTransaction(Date dateTransaction) {
		this.dateTransaction = dateTransaction;
	}
	public List<TransactionCompte> getTransactionsCompte() {
		return transactionsCompte;
	}
	public void setTransactionsCompte(List<TransactionCompte> transactionsCompte) {
		this.transactionsCompte = transactionsCompte;
	}
	public List<PcPersonnel> getPcPersonnels() {
		return pcPersonnels;
	}
	public void setPcPersonnels(List<PcPersonnel> pcPersonnels) {
		this.pcPersonnels = pcPersonnels;
	}
	

}
