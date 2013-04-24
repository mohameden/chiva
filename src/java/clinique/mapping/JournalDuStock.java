package clinique.mapping;

import java.util.Date;

public class JournalDuStock {
	
	private String operateur;
	private Date dateStockEntree;
	private Date dateStockSortie;
	private String nomProduit;
	private int quantiteStockEntrante;
	private int quantiteStockSortie;
	private int quantiteDisponible;

	
	public String getOperateur() {
		return operateur;
	}
	public void setOperateur(String operateur) {
		this.operateur = operateur;
	}
	public String getNomProduit() {
		return nomProduit;
	}
	public void setNomProduit(String nomProduit) {
		this.nomProduit = nomProduit;
	}
	public Date getDateStockEntree() {
		return dateStockEntree;
	}
	public void setDateStockEntree(Date dateStockEntree) {
		this.dateStockEntree = dateStockEntree;
	}
	public Date getDateStockSortie() {
		return dateStockSortie;
	}
	public void setDateStockSortie(Date dateStockSortie) {
		this.dateStockSortie = dateStockSortie;
	}
	public int getQuantiteStockEntrante() {
		return quantiteStockEntrante;
	}
	public void setQuantiteStockEntrante(int quantiteStockEntrante) {
		this.quantiteStockEntrante = quantiteStockEntrante;
	}
	public int getQuantiteStockSortie() {
		return quantiteStockSortie;
	}
	public void setQuantiteStockSortie(int quantiteStockSortie) {
		this.quantiteStockSortie = quantiteStockSortie;
	}
	public int getQuantiteDisponible() {
		return quantiteDisponible;
	}
	public void setQuantiteDisponible(int quantiteDisponible) {
		this.quantiteDisponible = quantiteDisponible;
	}
	
	
}
