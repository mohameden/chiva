package clinique.mapping;

import java.util.Date;

public class Recu extends Entity<Recu> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 302147021979339212L;
	private String recuId;
	private Date dateRecu;
	private String statut;
	private String operateur;
	private double total;

	private Facture facture;
	private Reglement reglement;

	public Date getDateRecu() {
		return dateRecu;
	}

	public void setDateRecu(Date dateRecu) {
		this.dateRecu = dateRecu;
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

	public Facture getFacture() {
		return facture;
	}

	public void setFacture(Facture facture) {
		this.facture = facture;
	}

	public String getRecuId() {
		return recuId;
	}

	public void setRecuId(String recuId) {
		this.recuId = recuId;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public Reglement getReglement() {
		return reglement;
	}

	public void setReglement(Reglement reglement) {
		this.reglement = reglement;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (dateRecu == null ? 0 : dateRecu.hashCode());
		result = prime * result
				+ (operateur == null ? 0 : operateur.hashCode());
		result = prime * result + (recuId == null ? 0 : recuId.hashCode());
		result = prime * result
				+ (reglement == null ? 0 : reglement.hashCode());
		result = prime * result + (statut == null ? 0 : statut.hashCode());
		long temp;
		temp = Double.doubleToLongBits(total);
		result = prime * result + (int) (temp ^ temp >>> 32);
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
		Recu other = (Recu) obj;
		if (dateRecu == null) {
			if (other.dateRecu != null) {
				return false;
			}
		} else if (!dateRecu.equals(other.dateRecu)) {
			return false;
		}
		if (facture == null) {
			if (other.facture != null) {
				return false;
			}
		} else if (!facture.equals(other.facture)) {
			return false;
		}
		if (operateur == null) {
			if (other.operateur != null) {
				return false;
			}
		} else if (!operateur.equals(other.operateur)) {
			return false;
		}
		if (recuId == null) {
			if (other.recuId != null) {
				return false;
			}
		} else if (!recuId.equals(other.recuId)) {
			return false;
		}
		if (reglement == null) {
			if (other.reglement != null) {
				return false;
			}
		} else if (!reglement.equals(other.reglement)) {
			return false;
		}
		if (statut == null) {
			if (other.statut != null) {
				return false;
			}
		} else if (!statut.equals(other.statut)) {
			return false;
		}
		if (Double.doubleToLongBits(total) != Double
				.doubleToLongBits(other.total)) {
			return false;
		}
		return true;
	}

	@Override
	protected Recu createEntity() {
		return new Recu();
	}

	@Override
	public void updateWith(Recu entity) {
		recuId = entity.getRecuId();
		dateRecu = entity.getDateRecu();
		statut = entity.getStatut();
		operateur = entity.getOperateur();
		total = entity.getTotal();
		EntityCopier<Facture> fCopier = new EntityCopier<Facture>();
		facture = fCopier.copy(entity.getFacture());
		EntityCopier<Reglement> rCopier = new EntityCopier<Reglement>();
		reglement = rCopier.copy(entity.getReglement());
	}

}
