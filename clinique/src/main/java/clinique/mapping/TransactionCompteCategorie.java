package clinique.mapping;

import java.util.Date;

public class TransactionCompteCategorie extends
		Entity<TransactionCompteCategorie> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6364353009570938079L;

	private String transactionId;

	private String operation;
	private double montant;
	private CompteCategorie compte;
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

	public CompteCategorie getCompte() {
		return compte;
	}

	public void setCompte(CompteCategorie compte) {
		this.compte = compte;
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
		TransactionCompteCategorie other = (TransactionCompteCategorie) obj;
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
	protected TransactionCompteCategorie createEntity() {
		return new TransactionCompteCategorie();
	}

	@Override
	public void updateWith(TransactionCompteCategorie entity) {
		transactionId = entity.getTransactionId();
		operation = entity.getOperation();
		montant = entity.getMontant();
		EntityCopier<CompteCategorie> aCopier = new EntityCopier<CompteCategorie>();
		compte = aCopier.copy(entity.getCompte());
		etat = entity.getEtat();
		statut = entity.getStatut();
		operateur = entity.getOperateur();
		dateTransaction = entity.getDateTransaction();
	}

}
