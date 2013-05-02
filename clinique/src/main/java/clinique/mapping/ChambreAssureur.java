package clinique.mapping;

import java.util.Date;

public class ChambreAssureur extends Entity {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7464722040133450807L;

	private String chambreAssureurId;

	private double tarif;

	private String statut;
	private Date dateDebut;
	private Date dateFin;

	private Chambre chambre;
	private Categorie categorie;

	public double getTarif() {
		return tarif;
	}

	public void setTarif(double tarif) {
		this.tarif = tarif;
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

	public Chambre getChambre() {
		return chambre;
	}

	public void setChambre(Chambre chambre) {
		this.chambre = chambre;
	}

	public Categorie getCategorie() {
		return categorie;
	}

	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}

	public String getChambreAssureurId() {
		return chambreAssureurId;
	}

	public void setChambreAssureurId(String chambreAssureurId) {
		this.chambreAssureurId = chambreAssureurId;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ (categorie == null ? 0 : categorie.hashCode());
		result = prime * result + (chambre == null ? 0 : chambre.hashCode());
		result = prime
				* result
				+ (chambreAssureurId == null ? 0 : chambreAssureurId.hashCode());
		result = prime * result
				+ (dateDebut == null ? 0 : dateDebut.hashCode());
		result = prime * result + (dateFin == null ? 0 : dateFin.hashCode());
		result = prime * result + (statut == null ? 0 : statut.hashCode());
		long temp;
		temp = Double.doubleToLongBits(tarif);
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
		ChambreAssureur other = (ChambreAssureur) obj;
		if (categorie == null) {
			if (other.categorie != null) {
				return false;
			}
		} else if (!categorie.equals(other.categorie)) {
			return false;
		}
		if (chambre == null) {
			if (other.chambre != null) {
				return false;
			}
		} else if (!chambre.equals(other.chambre)) {
			return false;
		}
		if (chambreAssureurId == null) {
			if (other.chambreAssureurId != null) {
				return false;
			}
		} else if (!chambreAssureurId.equals(other.chambreAssureurId)) {
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
		if (statut == null) {
			if (other.statut != null) {
				return false;
			}
		} else if (!statut.equals(other.statut)) {
			return false;
		}
		if (Double.doubleToLongBits(tarif) != Double
				.doubleToLongBits(other.tarif)) {
			return false;
		}
		return true;
	}

}
