package clinique.mapping;

import java.util.Date;

public class DrgCnam extends Entity {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6504936471485770442L;
	private String drgCnamId;
	private int numDrg;
	private String nomDrg;
	private double montant;
	private String operateur;
	private String statut;
	private Date dateDebut;
	private Date dateFin;

	public String getDrgCnamId() {
		return drgCnamId;
	}

	public void setDrgCnamId(String drgCnamId) {
		this.drgCnamId = drgCnamId;
	}

	public int getNumDrg() {
		return numDrg;
	}

	public void setNumDrg(int numDrg) {
		this.numDrg = numDrg;
	}

	public String getNomDrg() {
		return nomDrg;
	}

	public void setNomDrg(String nomDrg) {
		this.nomDrg = nomDrg;
	}

	public double getMontant() {
		return montant;
	}

	public void setMontant(double montant) {
		this.montant = montant;
	}

	public String getOperateur() {
		return operateur;
	}

	public void setOperateur(String operateur) {
		this.operateur = operateur;
	}

	public String getStatut() {
		return statut;
	}

	public void setStatut(String statut) {
		this.statut = statut;
	}

	public Date getDateDebut() {
		return dateDebut;
	}

	public void setDateDebut(Date dateDebut) {
		this.dateDebut = dateDebut;
	}

	public Date getDateFin() {
		return dateFin;
	}

	public void setDateFin(Date dateFin) {
		this.dateFin = dateFin;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ (dateDebut == null ? 0 : dateDebut.hashCode());
		result = prime * result + (dateFin == null ? 0 : dateFin.hashCode());
		result = prime * result
				+ (drgCnamId == null ? 0 : drgCnamId.hashCode());
		long temp;
		temp = Double.doubleToLongBits(montant);
		result = prime * result + (int) (temp ^ temp >>> 32);
		result = prime * result + (nomDrg == null ? 0 : nomDrg.hashCode());
		result = prime * result + numDrg;
		result = prime * result
				+ (operateur == null ? 0 : operateur.hashCode());
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
		DrgCnam other = (DrgCnam) obj;
		if (dateDebut == null) {
			if (other.dateDebut != null) {
				return false;
			}
		} else if (!dateDebut.equals(other.dateDebut)) {
			return false;
		}
		if (dateFin == null) {
			if (other.dateFin != null) {
				return false;
			}
		} else if (!dateFin.equals(other.dateFin)) {
			return false;
		}
		if (drgCnamId == null) {
			if (other.drgCnamId != null) {
				return false;
			}
		} else if (!drgCnamId.equals(other.drgCnamId)) {
			return false;
		}
		if (Double.doubleToLongBits(montant) != Double
				.doubleToLongBits(other.montant)) {
			return false;
		}
		if (nomDrg == null) {
			if (other.nomDrg != null) {
				return false;
			}
		} else if (!nomDrg.equals(other.nomDrg)) {
			return false;
		}
		if (numDrg != other.numDrg) {
			return false;
		}
		if (operateur == null) {
			if (other.operateur != null) {
				return false;
			}
		} else if (!operateur.equals(other.operateur)) {
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
