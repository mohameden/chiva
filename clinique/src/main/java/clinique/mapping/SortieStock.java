package clinique.mapping;

import java.util.Date;

public class SortieStock {
	
	private  int sortieStockId ;
	private  Date dateSortie ;
	private  int quantite ;
	private  int prixUnitaire ;
	private  int numeroSource ;
	private  String statut ;
	private  String operateur ;

	private Produit produit;

	public int getSortieStockId() {
		return sortieStockId;
	}

	public void setSortieStockId(int sortieStockId) {
		this.sortieStockId = sortieStockId;
	}

	public Date getDateSortie() {
		return dateSortie;
	}

	public void setDateSortie(Date dateSortie) {
		this.dateSortie = dateSortie;
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

	public int getNumeroSource() {
		return numeroSource;
	}

	public void setNumeroSource(int numeroSource) {
		this.numeroSource = numeroSource;
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
