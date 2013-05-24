package clinique.mapping;


public class Personnel extends Entity<Personnel> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4099172583709619764L;
	private int personnelId;
	private String nom;
	private String prenom;
	private String isActeur;
	private Acteur acteur;

	private String statut;
	private String operateur;

	public int getPersonnelId() {
		return personnelId;
	}

	public void setPersonnelId(int personnelId) {
		this.personnelId = personnelId;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
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

	public String getIsActeur() {
		return isActeur;
	}

	public void setIsActeur(String isActeur) {
		this.isActeur = isActeur;
	}

	public Acteur getActeur() {
		return acteur;
	}

	public void setActeur(Acteur acteur) {
		this.acteur = acteur;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (acteur == null ? 0 : acteur.hashCode());
		result = prime * result + (isActeur == null ? 0 : isActeur.hashCode());
		result = prime * result + (nom == null ? 0 : nom.hashCode());
		result = prime * result
				+ (operateur == null ? 0 : operateur.hashCode());
		result = prime * result + personnelId;
		result = prime * result + (prenom == null ? 0 : prenom.hashCode());
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
		Personnel other = (Personnel) obj;
		if (acteur == null) {
			if (other.acteur != null) {
				return false;
			}
		} else if (!acteur.equals(other.acteur)) {
			return false;
		}
		if (isActeur == null) {
			if (other.isActeur != null) {
				return false;
			}
		} else if (!isActeur.equals(other.isActeur)) {
			return false;
		}
		if (nom == null) {
			if (other.nom != null) {
				return false;
			}
		} else if (!nom.equals(other.nom)) {
			return false;
		}
		if (operateur == null) {
			if (other.operateur != null) {
				return false;
			}
		} else if (!operateur.equals(other.operateur)) {
			return false;
		}
		if (personnelId != other.personnelId) {
			return false;
		}
		if (prenom == null) {
			if (other.prenom != null) {
				return false;
			}
		} else if (!prenom.equals(other.prenom)) {
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
	protected Personnel createEntity() {
		return new Personnel();
	}

	@Override
	public void updateWith(Personnel entity) {
		personnelId = entity.getPersonnelId();
		nom = entity.getNom();
		prenom = entity.getPrenom();
		isActeur = entity.getIsActeur();
		EntityCopier<Acteur> aCopier = new EntityCopier<Acteur>();
		acteur = aCopier.copy(entity.getActeur());
		statut = entity.getStatut();
		operateur = entity.getOperateur();
	}

}
