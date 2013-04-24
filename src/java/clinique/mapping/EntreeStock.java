package clinique.mapping;

import java.util.Date;

public class EntreeStock {
	
	private  int entreeStockId ;
	private  Date dateEntree ;
	private  int quantite ;
	private  int prixUnitaire ;
	private  String numeroDestinataire ;
	private  String statut ;
	private  String operateur ;

	private Fournisseur fournisseur;
	private Produit produit;
	
	public int getEntreeStockId() {
		return entreeStockId;
	}
	public void setEntreeStockId(int entreeStockId) {
		this.entreeStockId = entreeStockId;
	}
	public Date getDateEntree() {
		return dateEntree;
	}
	public void setDateEntree(Date dateEntree) {
		this.dateEntree = dateEntree;
	}
	public int getQuantite() {
		return quantite;
	}
	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}
	public int getPrixUnitaire() {
		return prixUnitaire;
	}
	public void setPrixUnitaire(int prixUnitaire) {
		this.prixUnitaire = prixUnitaire;
	}
	public String getNumeroDestinataire() {
		return numeroDestinataire;
	}
	public void setNumeroDestinataire(String numeroDestinataire) {
		this.numeroDestinataire = numeroDestinataire;
	}
	public Fournisseur getFournisseur() {
		return fournisseur;
	}
	public void setFournisseur(Fournisseur fournisseur) {
		this.fournisseur = fournisseur;
	}
	public Produit getProduit() {
		return produit;
	}
	public void setProduit(Produit produit) {
		this.produit = produit;
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
	
	

}
