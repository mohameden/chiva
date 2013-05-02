package clinique.mapping;

import java.util.Date;

public class EntreeStock extends Entity {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3358620903086124512L;
	private int entreeStockId;
	private Date dateEntree;
	private int quantite;
	private int prixUnitaire;
	private String numeroDestinataire;
	private String statut;
	private String operateur;

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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ (dateEntree == null ? 0 : dateEntree.hashCode());
		result = prime * result + entreeStockId;
		result = prime * result
				+ (fournisseur == null ? 0 : fournisseur.hashCode());
		result = prime
				* result
				+ (numeroDestinataire == null ? 0 : numeroDestinataire
						.hashCode());
		result = prime * result
				+ (operateur == null ? 0 : operateur.hashCode());
		result = prime * result + prixUnitaire;
		result = prime * result + (produit == null ? 0 : produit.hashCode());
		result = prime * result + quantite;
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
		EntreeStock other = (EntreeStock) obj;
		if (dateEntree == null) {
			if (other.dateEntree != null) {
				return false;
			}
		} else if (!dateEntree.equals(other.dateEntree)) {
			return false;
		}
		if (entreeStockId != other.entreeStockId) {
			return false;
		}
		if (fournisseur == null) {
			if (other.fournisseur != null) {
				return false;
			}
		} else if (!fournisseur.equals(other.fournisseur)) {
			return false;
		}
		if (numeroDestinataire == null) {
			if (other.numeroDestinataire != null) {
				return false;
			}
		} else if (!numeroDestinataire.equals(other.numeroDestinataire)) {
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
