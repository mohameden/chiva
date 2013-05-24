package clinique.mapping;

import java.util.Date;

public class TransactionCompte extends Entity<TransactionCompte> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3805768451643717346L;

	private String transactionId;

	private String operation;
	private double montant;
	private Compte compte;
	private String etat;
	private String statut;
	private String operateur;
	private Date dateTransaction;

	public String getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}

	public String getOperation() {
		return operation;
	}

	public void setOperation(String operation) {
		this.operation = operation;
	}

	public double getMontant() {
		return montant;
	}

	public void setMontant(double montant) {
		this.montant = montant;
	}

	public Compte getCompte() {
		return compte;
	}

	public void setCompte(Compte compte) {
		this.compte = compte;
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (compte == null ? 0 : compte.hashCode());
		result = prime * result
				+ (dateTransaction == null ? 0 : dateTransaction.hashCode());
		result = prime * result + (etat == null ? 0 : etat.hashCode());
		long temp;
		temp = Double.doubleToLongBits(montant);
		result = prime * result + (int) (temp ^ temp >>> 32);
		result = prime * result
				+ (operateur == null ? 0 : operateur.hashCode());
		result = prime * result
				+ (operation == null ? 0 : operation.hashCode());
		result = prime * result + (statut == null ? 0 : statut.hashCode());
		result = prime * result
				+ (transactionId == null ? 0 : transactionId.hashCode());
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
		TransactionCompte other = (TransactionCompte) obj;
		if (compte == null) {
			if (other.compte != null) {
				return false;
			}
		} else if (!compte.equals(other.compte)) {
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
		if (Double.doubleToLongBits(montant) != Double
				.doubleToLongBits(other.montant)) {
			return false;
		}
		if (operateur == null) {
			if (other.operateur != null) {
				return false;
			}
		} else if (!operateur.equals(other.operateur)) {
			return false;
		}
		if (operation == null) {
			if (other.operation != null) {
				return false;
			}
		} else if (!operation.equals(other.operation)) {
			return false;
		}
		if (statut == null) {
			if (other.statut != null) {
				return false;
			}
		} else if (!statut.equals(other.statut)) {
			return false;
		}
		if (transactionId == null) {
			if (other.transactionId != null) {
				return false;
			}
		} else if (!transactionId.equals(other.transactionId)) {
			return false;
		}
		return true;
	}

	@Override
	protected TransactionCompte createEntity() {
		return new TransactionCompte();
	}

	@Override
	public void updateWith(TransactionCompte entity) {
		operation = entity.getOperation();
		montant = entity.getMontant();
		EntityCopier<Compte> aCopier = new EntityCopier<Compte>();
		compte = aCopier.copy(entity.getCompte());
		etat = entity.getEtat();
		statut = entity.getStatut();
		operateur = entity.getOperateur();
		dateTransaction = entity.getDateTransaction();
	}

}
