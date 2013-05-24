package clinique.mapping;

import java.util.Date;

public class Categorie extends Entity<Categorie> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2487599480566394574L;
	private int categorieId;
	private String nomCategorie;
	private int pourcentage;
	private String statut;
	private String operateur;
	private Date datedebutAssurance;
	private Date datefinAssurance;
	private int majoration;
	private String prefixeFacture;

	private Entreprise entreprise;

	public int getPourcentage() {
		return pourcentage;
	}

	public String getNomCategorie() {
		return nomCategorie;
	}

	public void setNomCategorie(String nomCategorie) {
		this.nomCategorie = nomCategorie;
	}

	public void setPourcentage(int pourcentage) {
		this.pourcentage = pourcentage;
	}

	public String getStatut() {
		return statut;
	}

	public void setStatut(String statut) {
		this.statut = statut;
	}

	public Entreprise getEntreprise() {
		return entreprise;
	}

	public void setEntreprise(Entreprise entreprise) {
		this.entreprise = entreprise;
	}

	public int getCategorieId() {
		return categorieId;
	}

	public String getOperateur() {
		return operateur;
	}

	public void setOperateur(String operateur) {
		this.operateur = operateur;
	}

	public void setCategorieId(int categorieId) {
		this.categorieId = categorieId;
	}

	public Date getDatedebutAssurance() {
		return datedebutAssurance;
	}

	public void setDatedebutAssurance(Date datedebutAssurance) {
		this.datedebutAssurance = datedebutAssurance;
	}

	public Date getDatefinAssurance() {
		return datefinAssurance;
	}

	public void setDatefinAssurance(Date datefinAssurance) {
		this.datefinAssurance = datefinAssurance;
	}

	public int getMajoration() {
		return majoration;
	}

	public void setMajoration(int majoration) {
		this.majoration = majoration;
	}

	public String getPrefixeFacture() {
		return prefixeFacture;
	}

	public void setPrefixeFacture(String prefixeFacture) {
		this.prefixeFacture = prefixeFacture;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + categorieId;
		result = prime
				* result
				+ (datedebutAssurance == null ? 0 : datedebutAssurance
						.hashCode());
		result = prime * result
				+ (datefinAssurance == null ? 0 : datefinAssurance.hashCode());
		result = prime * result
				+ (entreprise == null ? 0 : entreprise.hashCode());
		result = prime * result + majoration;
		result = prime * result
				+ (nomCategorie == null ? 0 : nomCategorie.hashCode());
		result = prime * result
				+ (operateur == null ? 0 : operateur.hashCode());
		result = prime * result + pourcentage;
		result = prime * result
				+ (prefixeFacture == null ? 0 : prefixeFacture.hashCode());
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
		Categorie other = (Categorie) obj;
		if (categorieId != other.categorieId) {
			return false;
		}
		if (datedebutAssurance == null) {
			if (other.datedebutAssurance != null) {
				return false;
			}
		} else if (!datedebutAssurance.equals(other.datedebutAssurance)) {
			return false;
		}
		if (datefinAssurance == null) {
			if (other.datefinAssurance != null) {
				return false;
			}
		} else if (!datefinAssurance.equals(other.datefinAssurance)) {
			return false;
		}
		if (entreprise == null) {
			if (other.entreprise != null) {
				return false;
			}
		} else if (!entreprise.equals(other.entreprise)) {
			return false;
		}
		if (majoration != other.majoration) {
			return false;
		}
		if (nomCategorie == null) {
			if (other.nomCategorie != null) {
				return false;
			}
		} else if (!nomCategorie.equals(other.nomCategorie)) {
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
		if (prefixeFacture == null) {
			if (other.prefixeFacture != null) {
				return false;
			}
		} else if (!prefixeFacture.equals(other.prefixeFacture)) {
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
	protected Categorie createEntity() {
		return new Categorie();
	}

	@Override
	public void updateWith(Categorie entity) {
		categorieId = entity.getCategorieId();
		nomCategorie = entity.getNomCategorie();
		pourcentage = entity.getPourcentage();
		statut = entity.getStatut();
		operateur = entity.getOperateur();
		datedebutAssurance = entity.getDatedebutAssurance();
		datefinAssurance = entity.getDatefinAssurance();
		majoration = entity.getMajoration();
		prefixeFacture = entity.getPrefixeFacture();

		EntityCopier<Entreprise> eCopier = new EntityCopier<Entreprise>();
		entreprise = eCopier.copy(entity.getEntreprise());
	}

}
