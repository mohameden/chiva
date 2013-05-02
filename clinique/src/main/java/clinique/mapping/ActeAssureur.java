package clinique.mapping;

import java.util.Date;

public class ActeAssureur extends Entity {

	/**
	 * 
	 */
	private static final long serialVersionUID = -389997580917832276L;
	private String acteAssureurId;
	private String nomActe;
	private double prix;
	private double prixUrg;
	private double prixDepl;
	private int pck;
	private String coef;

	private String statut;
	private String operateur;
	private Date dateDebut;
	private Date dateFin;

	private Categorie categorie;
	private Acte acte;

	public String getActeAssureurId() {
		return acteAssureurId;
	}

	public void setActeAssureurId(String acteAssureurId) {
		this.acteAssureurId = acteAssureurId;
	}

	public String getNomActe() {
		return nomActe;
	}

	public void setNomActe(String nomActe) {
		this.nomActe = nomActe;
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

	public double getPrixDepl() {
		return prixDepl;
	}

	public void setPrixDepl(double prixDepl) {
		this.prixDepl = prixDepl;
	}

	public int getPck() {
		return pck;
	}

	public void setPck(int pck) {
		this.pck = pck;
	}

	public String getCoef() {
		return coef;
	}

	public void setCoef(String coef) {
		this.coef = coef;
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

	public Acte getActe() {
		return acte;
	}

	public void setActe(Acte acte) {
		this.acte = acte;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (acte == null ? 0 : acte.hashCode());
		result = prime * result
				+ (acteAssureurId == null ? 0 : acteAssureurId.hashCode());
		result = prime * result
				+ (categorie == null ? 0 : categorie.hashCode());
		result = prime * result + (coef == null ? 0 : coef.hashCode());
		result = prime * result
				+ (dateDebut == null ? 0 : dateDebut.hashCode());
		result = prime * result + (dateFin == null ? 0 : dateFin.hashCode());
		result = prime * result + (nomActe == null ? 0 : nomActe.hashCode());
		result = prime * result
				+ (operateur == null ? 0 : operateur.hashCode());
		result = prime * result + pck;
		long temp;
		temp = Double.doubleToLongBits(prix);
		result = prime * result + (int) (temp ^ temp >>> 32);
		temp = Double.doubleToLongBits(prixDepl);
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
		ActeAssureur other = (ActeAssureur) obj;
		if (acte == null) {
			if (other.acte != null) {
				return false;
			}
		} else if (!acte.equals(other.acte)) {
			return false;
		}
		if (acteAssureurId == null) {
			if (other.acteAssureurId != null) {
				return false;
			}
		} else if (!acteAssureurId.equals(other.acteAssureurId)) {
			return false;
		}
		if (categorie == null) {
			if (other.categorie != null) {
				return false;
			}
		} else if (!categorie.equals(other.categorie)) {
			return false;
		}
		if (coef == null) {
			if (other.coef != null) {
				return false;
			}
		} else if (!coef.equals(other.coef)) {
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
		if (nomActe == null) {
			if (other.nomActe != null) {
				return false;
			}
		} else if (!nomActe.equals(other.nomActe)) {
			return false;
		}
		if (operateur == null) {
			if (other.operateur != null) {
				return false;
			}
		} else if (!operateur.equals(other.operateur)) {
			return false;
		}
		if (pck != other.pck) {
			return false;
		}
		if (Double.doubleToLongBits(prix) != Double
				.doubleToLongBits(other.prix)) {
			return false;
		}
		if (Double.doubleToLongBits(prixDepl) != Double
				.doubleToLongBits(other.prixDepl)) {
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
