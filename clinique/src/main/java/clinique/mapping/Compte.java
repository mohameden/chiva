package clinique.mapping;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Compte extends Entity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2109572146202959304L;
	private String compteId;
	private String numeroCompte;

	private double soldeAvant;
	private double solde;
	private Personnel personnel;
	private String etat;
	private String statut;
	private String operateur;
	private Date dateTransaction;

	private List<TransactionCompte> transactionsCompte = new ArrayList<TransactionCompte>();

	private List<PcPersonnel> pcPersonnels = new ArrayList<PcPersonnel>();

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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (compteId == null ? 0 : compteId.hashCode());
		result = prime * result
				+ (dateTransaction == null ? 0 : dateTransaction.hashCode());
		result = prime * result + (etat == null ? 0 : etat.hashCode());
		result = prime * result
				+ (numeroCompte == null ? 0 : numeroCompte.hashCode());
		result = prime * result
				+ (operateur == null ? 0 : operateur.hashCode());
		result = prime * result
				+ (pcPersonnels == null ? 0 : pcPersonnels.hashCode());
		result = prime * result
				+ (personnel == null ? 0 : personnel.hashCode());
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
		Compte other = (Compte) obj;
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
		if (pcPersonnels == null) {
			if (other.pcPersonnels != null) {
				return false;
			}
		} else if (!pcPersonnels.equals(other.pcPersonnels)) {
			return false;
		}
		if (personnel == null) {
			if (other.personnel != null) {
				return false;
			}
		} else if (!personnel.equals(other.personnel)) {
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
