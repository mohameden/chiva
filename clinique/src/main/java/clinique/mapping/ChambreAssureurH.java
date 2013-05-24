package clinique.mapping;

import java.util.Date;

public class ChambreAssureurH extends Entity<ChambreAssureurH> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1600542460105653436L;

	private String chambreAssureurHId;

	private double tarif;

	private String statut;
	private Date dateDebut;
	private Date dateFin;

	private Chambre chambre;
	private Categorie categorie;
	private ChambreAssureur chambreAssureur;

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

	public String getChambreAssureurHId() {
		return chambreAssureurHId;
	}

	public void setChambreAssureurHId(String chambreAssureurHId) {
		this.chambreAssureurHId = chambreAssureurHId;
	}

	public ChambreAssureur getChambreAssureur() {
		return chambreAssureur;
	}

	public void setChambreAssureur(ChambreAssureur chambreAssureur) {
		this.chambreAssureur = chambreAssureur;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ (categorie == null ? 0 : categorie.hashCode());
		result = prime * result + (chambre == null ? 0 : chambre.hashCode());
		result = prime * result
				+ (chambreAssureur == null ? 0 : chambreAssureur.hashCode());
		result = prime
				* result
				+ (chambreAssureurHId == null ? 0 : chambreAssureurHId
						.hashCode());
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
		ChambreAssureurH other = (ChambreAssureurH) obj;
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
		if (chambreAssureur == null) {
			if (other.chambreAssureur != null) {
				return false;
			}
		} else if (!chambreAssureur.equals(other.chambreAssureur)) {
			return false;
		}
		if (chambreAssureurHId == null) {
			if (other.chambreAssureurHId != null) {
				return false;
			}
		} else if (!chambreAssureurHId.equals(other.chambreAssureurHId)) {
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

	@Override
	protected ChambreAssureurH createEntity() {
		return new ChambreAssureurH();
	}

	@Override
	public void updateWith(ChambreAssureurH entity) {
		chambreAssureurHId = entity.getChambreAssureurHId();
		tarif = entity.getTarif();
		statut = entity.getStatut();
		dateDebut = entity.getDateDebut();
		dateFin = entity.getDateFin();
		EntityCopier<Categorie> cCopier = new EntityCopier<Categorie>();
		categorie = cCopier.copy(entity.getCategorie());
		EntityCopier<Chambre> chCopier = new EntityCopier<Chambre>();
		chambre = chCopier.copy(entity.getChambre());
		EntityCopier<ChambreAssureur> chaCopier = new EntityCopier<ChambreAssureur>();
		chambreAssureur = chaCopier.copy(entity.getChambreAssureur());
	}
}
