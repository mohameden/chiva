package clinique.mapping;

public class PrestationCouvertesPc extends Entity {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3881830162461702501L;
	private String presCouvId;
	private String statut;
	private String operateur;
	private String type;
	private String libelle;
	private String limite;
	private int nbreActes;
	private int nbreActesRestant;

	private PriseEnCharge priseEnCharge;
	private Classe classe;
	private FamillePrestation famille;
	private Acte acte;

	public String getStatut() {
		return statut;
	}

	public PriseEnCharge getPriseEnCharge() {
		return priseEnCharge;
	}

	public void setPriseEnCharge(PriseEnCharge priseEnCharge) {
		this.priseEnCharge = priseEnCharge;
	}

	public Classe getClasse() {
		return classe;
	}

	public void setClasse(Classe classe) {
		this.classe = classe;
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

	public String getPresCouvId() {
		return presCouvId;
	}

	public void setPresCouvId(String presCouvId) {
		this.presCouvId = presCouvId;
	}

	public FamillePrestation getFamille() {
		return famille;
	}

	public void setFamille(FamillePrestation famille) {
		this.famille = famille;
	}

	public Acte getActe() {
		return acte;
	}

	public void setActe(Acte acte) {
		this.acte = acte;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public String getLimite() {
		return limite;
	}

	public void setLimite(String limite) {
		this.limite = limite;
	}

	public int getNbreActes() {
		return nbreActes;
	}

	public void setNbreActes(int nbreActes) {
		this.nbreActes = nbreActes;
	}

	public int getNbreActesRestant() {
		return nbreActesRestant;
	}

	public void setNbreActesRestant(int nbreActesRestant) {
		this.nbreActesRestant = nbreActesRestant;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (acte == null ? 0 : acte.hashCode());
		result = prime * result + (classe == null ? 0 : classe.hashCode());
		result = prime * result + (famille == null ? 0 : famille.hashCode());
		result = prime * result + (libelle == null ? 0 : libelle.hashCode());
		result = prime * result + (limite == null ? 0 : limite.hashCode());
		result = prime * result + nbreActes;
		result = prime * result + nbreActesRestant;
		result = prime * result
				+ (operateur == null ? 0 : operateur.hashCode());
		result = prime * result
				+ (presCouvId == null ? 0 : presCouvId.hashCode());
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
		PrestationCouvertesPc other = (PrestationCouvertesPc) obj;
		if (acte == null) {
			if (other.acte != null) {
				return false;
			}
		} else if (!acte.equals(other.acte)) {
			return false;
		}
		if (classe == null) {
			if (other.classe != null) {
				return false;
			}
		} else if (!classe.equals(other.classe)) {
			return false;
		}
		if (famille == null) {
			if (other.famille != null) {
				return false;
			}
		} else if (!famille.equals(other.famille)) {
			return false;
		}
		if (libelle == null) {
			if (other.libelle != null) {
				return false;
			}
		} else if (!libelle.equals(other.libelle)) {
			return false;
		}
		if (limite == null) {
			if (other.limite != null) {
				return false;
			}
		} else if (!limite.equals(other.limite)) {
			return false;
		}
		if (nbreActes != other.nbreActes) {
			return false;
		}
		if (nbreActesRestant != other.nbreActesRestant) {
			return false;
		}
		if (operateur == null) {
			if (other.operateur != null) {
				return false;
			}
		} else if (!operateur.equals(other.operateur)) {
			return false;
		}
		if (presCouvId == null) {
			if (other.presCouvId != null) {
				return false;
			}
		} else if (!presCouvId.equals(other.presCouvId)) {
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
