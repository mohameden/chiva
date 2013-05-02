package clinique.mapping;

public class PatientPcActuel extends Entity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5222062935526915704L;

	private String patientPcActuelId;

	private String statut;
	private String operateur;

	private Badge badge;
	private Patient patient;
	private PriseEnCharge priseEnCharge;
	private String type;

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

	public Badge getBadge() {
		return badge;
	}

	public void setBadge(Badge badge) {
		this.badge = badge;
	}

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	public PriseEnCharge getPriseEnCharge() {
		return priseEnCharge;
	}

	public void setPriseEnCharge(PriseEnCharge priseEnCharge) {
		this.priseEnCharge = priseEnCharge;
	}

	public String getPatientPcActuelId() {
		return patientPcActuelId;
	}

	public void setPatientPcActuelId(String patientPcActuelId) {
		this.patientPcActuelId = patientPcActuelId;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (badge == null ? 0 : badge.hashCode());
		result = prime * result
				+ (operateur == null ? 0 : operateur.hashCode());
		result = prime * result + (patient == null ? 0 : patient.hashCode());
		result = prime
				* result
				+ (patientPcActuelId == null ? 0 : patientPcActuelId.hashCode());
		result = prime * result
				+ (priseEnCharge == null ? 0 : priseEnCharge.hashCode());
		result = prime * result + (statut == null ? 0 : statut.hashCode());
		result = prime * result + (type == null ? 0 : type.hashCode());
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
		PatientPcActuel other = (PatientPcActuel) obj;
		if (badge == null) {
			if (other.badge != null) {
				return false;
			}
		} else if (!badge.equals(other.badge)) {
			return false;
		}
		if (operateur == null) {
			if (other.operateur != null) {
				return false;
			}
		} else if (!operateur.equals(other.operateur)) {
			return false;
		}
		if (patient == null) {
			if (other.patient != null) {
				return false;
			}
		} else if (!patient.equals(other.patient)) {
			return false;
		}
		if (patientPcActuelId == null) {
			if (other.patientPcActuelId != null) {
				return false;
			}
		} else if (!patientPcActuelId.equals(other.patientPcActuelId)) {
			return false;
		}
		if (priseEnCharge == null) {
			if (other.priseEnCharge != null) {
				return false;
			}
		} else if (!priseEnCharge.equals(other.priseEnCharge)) {
			return false;
		}
		if (statut == null) {
			if (other.statut != null) {
				return false;
			}
		} else if (!statut.equals(other.statut)) {
			return false;
		}
		if (type == null) {
			if (other.type != null) {
				return false;
			}
		} else if (!type.equals(other.type)) {
			return false;
		}
		return true;
	}

}
