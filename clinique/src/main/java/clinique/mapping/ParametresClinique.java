package clinique.mapping;

import java.util.Date;

public class ParametresClinique extends Entity<ParametresClinique> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1826776651329244362L;
	private String parametreId;
	private String parametre;
	private String valeur;

	private String operateur;
	private String statut;
	private Date dateDebut;
	private Date dateFin;

	public String getParametreId() {
		return parametreId;
	}

	public void setParametreId(String parametreId) {
		this.parametreId = parametreId;
	}

	public String getParametre() {
		return parametre;
	}

	public void setParametre(String parametre) {
		this.parametre = parametre;
	}

	public String getValeur() {
		return valeur;
	}

	public void setValeur(String valeur) {
		this.valeur = valeur;
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
				+ (operateur == null ? 0 : operateur.hashCode());
		result = prime * result
				+ (parametre == null ? 0 : parametre.hashCode());
		result = prime * result
				+ (parametreId == null ? 0 : parametreId.hashCode());
		result = prime * result + (statut == null ? 0 : statut.hashCode());
		result = prime * result + (valeur == null ? 0 : valeur.hashCode());
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
		ParametresClinique other = (ParametresClinique) obj;
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
		if (operateur == null) {
			if (other.operateur != null) {
				return false;
			}
		} else if (!operateur.equals(other.operateur)) {
			return false;
		}
		if (parametre == null) {
			if (other.parametre != null) {
				return false;
			}
		} else if (!parametre.equals(other.parametre)) {
			return false;
		}
		if (parametreId == null) {
			if (other.parametreId != null) {
				return false;
			}
		} else if (!parametreId.equals(other.parametreId)) {
			return false;
		}
		if (statut == null) {
			if (other.statut != null) {
				return false;
			}
		} else if (!statut.equals(other.statut)) {
			return false;
		}
		if (valeur == null) {
			if (other.valeur != null) {
				return false;
			}
		} else if (!valeur.equals(other.valeur)) {
			return false;
		}
		return true;
	}

	@Override
	protected ParametresClinique createEntity() {
		return new ParametresClinique();
	}

	@Override
	public void updateWith(ParametresClinique entity) {
		parametreId = entity.getParametreId();
		parametre = entity.getParametre();
		valeur = entity.getValeur();
		operateur = entity.getOperateur();
		statut = entity.getStatut();
		dateDebut = entity.getDateDebut();
		dateFin = entity.getDateFin();
	}

}
