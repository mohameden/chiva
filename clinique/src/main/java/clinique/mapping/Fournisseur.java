package clinique.mapping;

public class Fournisseur extends Entity<Fournisseur> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1309854599571004097L;
	private int fournisseurId;
	private String nomFournisseur;
	private String adresse;
	private int telephone1;
	private int telephone2;
	private String statut;
	private String operateur;

	public int getFournisseurId() {
		return fournisseurId;
	}

	public void setFournisseurId(int fournisseurId) {
		this.fournisseurId = fournisseurId;
	}

	public String getNomFournisseur() {
		return nomFournisseur;
	}

	public void setNomFournisseur(String nomFournisseur) {
		this.nomFournisseur = nomFournisseur;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public int getTelephone1() {
		return telephone1;
	}

	public void setTelephone1(int telephone1) {
		this.telephone1 = telephone1;
	}

	public int getTelephone2() {
		return telephone2;
	}

	public void setTelephone2(int telephone2) {
		this.telephone2 = telephone2;
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (adresse == null ? 0 : adresse.hashCode());
		result = prime * result + fournisseurId;
		result = prime * result
				+ (nomFournisseur == null ? 0 : nomFournisseur.hashCode());
		result = prime * result
				+ (operateur == null ? 0 : operateur.hashCode());
		result = prime * result + (statut == null ? 0 : statut.hashCode());
		result = prime * result + telephone1;
		result = prime * result + telephone2;
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
		Fournisseur other = (Fournisseur) obj;
		if (adresse == null) {
			if (other.adresse != null) {
				return false;
			}
		} else if (!adresse.equals(other.adresse)) {
			return false;
		}
		if (fournisseurId != other.fournisseurId) {
			return false;
		}
		if (nomFournisseur == null) {
			if (other.nomFournisseur != null) {
				return false;
			}
		} else if (!nomFournisseur.equals(other.nomFournisseur)) {
			return false;
		}
		if (operateur == null) {
			if (other.operateur != null) {
				return false;
			}
		} else if (!operateur.equals(other.operateur)) {
			return false;
		}
		if (statut == null) {
			if (other.statut != null) {
				return false;
			}
		} else if (!statut.equals(other.statut)) {
			return false;
		}
		if (telephone1 != other.telephone1) {
			return false;
		}
		if (telephone2 != other.telephone2) {
			return false;
		}
		return true;
	}

	@Override
	protected Fournisseur createEntity() {
		return new Fournisseur();
	}

	@Override
	public void updateWith(Fournisseur entity) {
		fournisseurId = entity.getFournisseurId();
		nomFournisseur = entity.getNomFournisseur();
		adresse = entity.getAdresse();
		telephone1 = entity.getTelephone1();
		telephone2 = entity.getTelephone2();
		statut = entity.getStatut();
		operateur = entity.getOperateur();
	}

}
