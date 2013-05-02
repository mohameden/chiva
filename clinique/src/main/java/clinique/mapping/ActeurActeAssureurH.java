package clinique.mapping;

import java.util.Date;

public class ActeurActeAssureurH extends Entity {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4617449599132347677L;
	private String acteurActeAsureurHId;
	private int pourcentage;
	private String statut;
	private String operateur;
	private int pourcentageUrg;
	private String isException;
	private double prix;
	private double prixUrg;
	private Date dateDebut;
	private Date dateFin;

	private ActeurActeAssureur acteurActeAssureur;
	private Categorie categorie;
	private Acte acte;
	private Acteur acteur;

	public int getPourcentage() {
		return pourcentage;
	}

	public Acte getActe() {
		return acte;
	}

	public void setActe(Acte acte) {
		this.acte = acte;
	}

	public void setPourcentage(int pourcentage) {
		this.pourcentage = pourcentage;
	}

	public Acteur getActeur() {
		return acteur;
	}

	public void setActeur(Acteur acteur) {
		this.acteur = acteur;
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

	public int getPourcentageUrg() {
		return pourcentageUrg;
	}

	public void setPourcentageUrg(int pourcentageUrg) {
		this.pourcentageUrg = pourcentageUrg;
	}

	public String getIsException() {
		return isException;
	}

	public void setIsException(String isException) {
		this.isException = isException;
	}

	public double getPrix() {
		return prix;
	}

	public void setPrix(double prix) {
		this.prix = prix;
	}

	public double getPrixUrg() {
		return prixUrg;
	}

	public void setPrixUrg(double prixUrg) {
		this.prixUrg = prixUrg;
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

	public Categorie getCategorie() {
		return categorie;
	}

	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}

	public String getActeurActeAsureurHId() {
		return acteurActeAsureurHId;
	}

	public void setActeurActeAsureurHId(String acteurActeAsureurHId) {
		this.acteurActeAsureurHId = acteurActeAsureurHId;
	}

	public ActeurActeAssureur getActeurActeAssureur() {
		return acteurActeAssureur;
	}

	public void setActeurActeAssureur(ActeurActeAssureur acteurActeAssureur) {
		this.acteurActeAssureur = acteurActeAssureur;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (acte == null ? 0 : acte.hashCode());
		result = prime * result + (acteur == null ? 0 : acteur.hashCode());
		result = prime
				* result
				+ (acteurActeAssureur == null ? 0 : acteurActeAssureur
						.hashCode());
		result = prime
				* result
				+ (acteurActeAsureurHId == null ? 0 : acteurActeAsureurHId
						.hashCode());
		result = prime * result
				+ (categorie == null ? 0 : categorie.hashCode());
		result = prime * result
				+ (dateDebut == null ? 0 : dateDebut.hashCode());
		result = prime * result + (dateFin == null ? 0 : dateFin.hashCode());
		result = prime * result
				+ (isException == null ? 0 : isException.hashCode());
		result = prime * result
				+ (operateur == null ? 0 : operateur.hashCode());
		result = prime * result + pourcentage;
		result = prime * result + pourcentageUrg;
		long temp;
		temp = Double.doubleToLongBits(prix);
		result = prime * result + (int) (temp ^ temp >>> 32);
		temp = Double.doubleToLongBits(prixUrg);
		result = prime * result + (int) (temp ^ temp >>> 32);
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
		ActeurActeAssureurH other = (ActeurActeAssureurH) obj;
		if (acte == null) {
			if (other.acte != null) {
				return false;
			}
		} else if (!acte.equals(other.acte)) {
			return false;
		}
		if (acteur == null) {
			if (other.acteur != null) {
				return false;
			}
		} else if (!acteur.equals(other.acteur)) {
			return false;
		}
		if (acteurActeAssureur == null) {
			if (other.acteurActeAssureur != null) {
				return false;
			}
		} else if (!acteurActeAssureur.equals(other.acteurActeAssureur)) {
			return false;
		}
		if (acteurActeAsureurHId == null) {
			if (other.acteurActeAsureurHId != null) {
				return false;
			}
		} else if (!acteurActeAsureurHId.equals(other.acteurActeAsureurHId)) {
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
		if (isException == null) {
			if (other.isException != null) {
				return false;
			}
		} else if (!isException.equals(other.isException)) {
			return false;
		}
		if (operateur == null) {
			if (other.operateur != null) {
				return false;
			}
		} else if (!operateur.equals(other.operateur)) {
			return false;
		}
		if (pourcentage != other.pourcentage) {
			return false;
		}
		if (pourcentageUrg != other.pourcentageUrg) {
			return false;
		}
		if (Double.doubleToLongBits(prix) != Double
				.doubleToLongBits(other.prix)) {
			return false;
		}
		if (Double.doubleToLongBits(prixUrg) != Double
				.doubleToLongBits(other.prixUrg)) {
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
