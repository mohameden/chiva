package clinique.mapping;

import java.util.Date;

public class Badge extends Entity<Badge> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8272983907864867201L;
	private String badgeId;
	private String numeroBadge;

	private Date dateDebut;
	private Date dateFin;
	private String statut;
	private String operateur;

	private Categorie categorie;
	private Patient patient;

	public String getBadgeId() {
		return badgeId;
	}

	public void setBadgeId(String badgeId) {
		this.badgeId = badgeId;
	}

	public String getNumeroBadge() {
		return numeroBadge;
	}

	public void setNumeroBadge(String numeroBadge) {
		this.numeroBadge = numeroBadge;
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

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (badgeId == null ? 0 : badgeId.hashCode());
		result = prime * result
				+ (categorie == null ? 0 : categorie.hashCode());
		result = prime * result
				+ (dateDebut == null ? 0 : dateDebut.hashCode());
		result = prime * result + (dateFin == null ? 0 : dateFin.hashCode());
		result = prime * result
				+ (numeroBadge == null ? 0 : numeroBadge.hashCode());
		result = prime * result
				+ (operateur == null ? 0 : operateur.hashCode());
		result = prime * result + (patient == null ? 0 : patient.hashCode());
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
		Badge other = (Badge) obj;
		if (badgeId == null) {
			if (other.badgeId != null) {
				return false;
			}
		} else if (!badgeId.equals(other.badgeId)) {
			return false;
		}
		if (categorie == null) {
			if (other.categorie != null) {
				return false;
			}
		} else if (!categorie.equals(other.categorie)) {
			return false;
		}
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
		if (numeroBadge == null) {
			if (other.numeroBadge != null) {
				return false;
			}
		} else if (!numeroBadge.equals(other.numeroBadge)) {
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
		if (statut == null) {
			if (other.statut != null) {
				return false;
			}
		} else if (!statut.equals(other.statut)) {
			return false;
		}
		return true;
	}

	@Override
	protected Badge createEntity() {
		return new Badge();
	}

	@Override
	public void updateWith(Badge entity) {
		badgeId = entity.getBadgeId();
		numeroBadge = entity.getNumeroBadge();
		dateDebut = entity.getDateDebut();
		dateFin = entity.getDateFin();
		statut = entity.getStatut();
		operateur = entity.getOperateur();
		EntityCopier<Categorie> cCopier = new EntityCopier<Categorie>();
		categorie = cCopier.copy(entity.getCategorie());
		EntityCopier<Patient> pCopier = new EntityCopier<Patient>();
		patient = pCopier.copy(entity.getPatient());
	}

}
