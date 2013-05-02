package clinique.mapping;

import java.util.Date;

public class SortieStock extends Entity {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5574603884722425651L;
	private int sortieStockId;
	private Date dateSortie;
	private int quantite;
	private int prixUnitaire;
	private int numeroSource;
	private String statut;
	private String operateur;

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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ (dateSortie == null ? 0 : dateSortie.hashCode());
		result = prime * result + numeroSource;
		result = prime * result
				+ (operateur == null ? 0 : operateur.hashCode());
		result = prime * result + prixUnitaire;
		result = prime * result + (produit == null ? 0 : produit.hashCode());
		result = prime * result + quantite;
		result = prime * result + sortieStockId;
		result = prime * result + (statut == null ? 0 : statut.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		SortieStock other = (SortieStock) obj;
		if (dateSortie == null) {
			if (other.dateSortie != null) {
				return false;
			}
		} else if (!dateSortie.equals(other.dateSortie)) {
			return false;
		}
		if (numeroSource != other.numeroSource) {
			return false;
		}
		if (operateur == null) {
			if (other.operateur != null) {
				return false;
			}
		} else if (!operateur.equals(other.operateur)) {
			return false;
		}
		if (prixUnitaire != other.prixUnitaire) {
			return false;
		}
		if (produit == null) {
			if (other.produit != null) {
				return false;
			}
		} else if (!produit.equals(other.produit)) {
			return false;
		}
		if (quantite != other.quantite) {
			return false;
		}
		if (sortieStockId != other.sortieStockId) {
			return false;
		}
		if (statut == null) {
			if (other.statut != null) {
				return false;
			}
		} else if (!statut.equals(other.statut)) {
			return false;
		}
		return true;
	}

}
