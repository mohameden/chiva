package clinique.mapping;

import java.util.Date;

public class JournalDuStock extends Entity<JournalDuStock> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6477317010804887942L;
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ (dateStockEntree == null ? 0 : dateStockEntree.hashCode());
		result = prime * result
				+ (dateStockSortie == null ? 0 : dateStockSortie.hashCode());
		result = prime * result
				+ (nomProduit == null ? 0 : nomProduit.hashCode());
		result = prime * result
				+ (operateur == null ? 0 : operateur.hashCode());
		result = prime * result + quantiteDisponible;
		result = prime * result + quantiteStockEntrante;
		result = prime * result + quantiteStockSortie;
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
		JournalDuStock other = (JournalDuStock) obj;
		if (dateStockEntree == null) {
			if (other.dateStockEntree != null) {
				return false;
			}
		} else if (!dateStockEntree.equals(other.dateStockEntree)) {
			return false;
		}
		if (dateStockSortie == null) {
			if (other.dateStockSortie != null) {
				return false;
			}
		} else if (!dateStockSortie.equals(other.dateStockSortie)) {
			return false;
		}
		if (nomProduit == null) {
			if (other.nomProduit != null) {
				return false;
			}
		} else if (!nomProduit.equals(other.nomProduit)) {
			return false;
		}
		if (operateur == null) {
			if (other.operateur != null) {
				return false;
			}
		} else if (!operateur.equals(other.operateur)) {
			return false;
		}
		if (quantiteDisponible != other.quantiteDisponible) {
			return false;
		}
		if (quantiteStockEntrante != other.quantiteStockEntrante) {
			return false;
		}
		if (quantiteStockSortie != other.quantiteStockSortie) {
			return false;
		}
		return true;
	}

	@Override
	protected JournalDuStock createEntity() {
		return new JournalDuStock();
	}

	@Override
	public void updateWith(JournalDuStock entity) {
		operateur = entity.getOperateur();
		dateStockEntree = entity.getDateStockEntree();
		dateStockSortie = entity.getDateStockSortie();
		nomProduit = entity.getNomProduit();
		quantiteStockEntrante = entity.getQuantiteStockEntrante();
		quantiteStockSortie = entity.getQuantiteStockSortie();
		quantiteDisponible = entity.getQuantiteDisponible();
	}

}
