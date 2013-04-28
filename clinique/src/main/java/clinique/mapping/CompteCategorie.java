package clinique.mapping;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CompteCategorie {
	
	private  String compteId;
	private  String numeroCompte;
	
	private  double soldeAvant;
	private double solde;
	private Categorie categorie;
	private  String etat;
	private  String statut;
	private  String operateur;
	private Date dateTransaction;
	
	private List <TransactionCompteCategorie> transactionsCompte=new ArrayList<TransactionCompteCategorie>();


	
	
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
	public Categorie getCategorie() {
		return categorie;
	}
	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}
	public Date getDateTransaction() {
		return dateTransaction;
	}
	public void setDateTransaction(Date dateTransaction) {
		this.dateTransaction = dateTransaction;
	}
	public List<TransactionCompteCategorie> getTransactionsCompte() {
		return transactionsCompte;
	}
	public void setTransactionsCompte(
			List<TransactionCompteCategorie> transactionsCompte) {
		this.transactionsCompte = transactionsCompte;
	}
	

}
