package clinique.mapping;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CompteCategorie extends Entity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3389147699943423773L;
	private String compteId;
	private String numeroCompte;

	private double soldeAvant;
	private double solde;
	private Categorie categorie;
	private String etat;
	private String statut;
	private String operateur;
	private Date dateTransaction;

	private List<TransactionCompteCategorie> transactionsCompte = new ArrayList<TransactionCompteCategorie>();

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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ (categorie == null ? 0 : categorie.hashCode());
		result = prime * result + (compteId == null ? 0 : compteId.hashCode());
		result = prime * result
				+ (dateTransaction == null ? 0 : dateTransaction.hashCode());
		result = prime * result + (etat == null ? 0 : etat.hashCode());
		result = prime * result
				+ (numeroCompte == null ? 0 : numeroCompte.hashCode());
		result = prime * result
				+ (operateur == null ? 0 : operateur.hashCode());
		long temp;
		temp = Double.doubleToLongBits(solde);
		result = prime * result + (int) (temp ^ temp >>> 32);
		temp = Double.doubleToLongBits(soldeAvant);
		result = prime * result + (int) (temp ^ temp >>> 32);
		result = prime * result + (statut == null ? 0 : statut.hashCode());
		result = prime
				* result
				+ (transactionsCompte == null ? 0 : transactionsCompte
						.hashCode());
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
		CompteCategorie other = (CompteCategorie) obj;
		if (categorie == null) {
			if (other.categorie != null) {
				return false;
			}
		} else if (!categorie.equals(other.categorie)) {
			return false;
		}
		if (compteId == null) {
			if (other.compteId != null) {
				return false;
			}
		} else if (!compteId.equals(other.compteId)) {
			return false;
		}
		if (dateTransaction == null) {
			if (other.dateTransaction != null) {
				return false;
			}
		} else if (!dateTransaction.equals(other.dateTransaction)) {
			return false;
		}
		if (etat == null) {
			if (other.etat != null) {
				return false;
			}
		} else if (!etat.equals(other.etat)) {
			return false;
		}
		if (numeroCompte == null) {
			if (other.numeroCompte != null) {
				return false;
			}
		} else if (!numeroCompte.equals(other.numeroCompte)) {
			return false;
		}
		if (operateur == null) {
			if (other.operateur != null) {
				return false;
			}
		} else if (!operateur.equals(other.operateur)) {
			return false;
		}
		if (Double.doubleToLongBits(solde) != Double
				.doubleToLongBits(other.solde)) {
			return false;
		}
		if (Double.doubleToLongBits(soldeAvant) != Double
				.doubleToLongBits(other.soldeAvant)) {
			return false;
		}
		if (statut == null) {
			if (other.statut != null) {
				return false;
			}
		} else if (!statut.equals(other.statut)) {
			return false;
		}
		if (transactionsCompte == null) {
			if (other.transactionsCompte != null) {
				return false;
			}
		} else if (!transactionsCompte.equals(other.transactionsCompte)) {
			return false;
		}
		return true;
	}

}
