package clinique.mapping;


public class Entreprise extends Entity<Entreprise> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -671633466712383999L;
	private int entrepriseId;
	private String nomEntreprise;
	private String adresse;

	private String statut;
	private String operateur;

	private Assureur assureur;

	public int getEntrepriseId() {
		return entrepriseId;
	}

	public void setEntrepriseId(int entrepriseId) {
		this.entrepriseId = entrepriseId;
	}

	public String getNomEntreprise() {
		return nomEntreprise;
	}

	public void setNomEntreprise(String nomEntreprise) {
		this.nomEntreprise = nomEntreprise;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
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

	public Assureur getAssureur() {
		return assureur;
	}

	public void setAssureur(Assureur assureur) {
		this.assureur = assureur;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (adresse == null ? 0 : adresse.hashCode());
		result = prime * result + (assureur == null ? 0 : assureur.hashCode());
		result = prime * result + entrepriseId;
		result = prime * result
				+ (nomEntreprise == null ? 0 : nomEntreprise.hashCode());
		result = prime * result
				+ (operateur == null ? 0 : operateur.hashCode());
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
		Entreprise other = (Entreprise) obj;
		if (adresse == null) {
			if (other.adresse != null) {
				return false;
			}
		} else if (!adresse.equals(other.adresse)) {
			return false;
		}
		if (assureur == null) {
			if (other.assureur != null) {
				return false;
			}
		} else if (!assureur.equals(other.assureur)) {
			return false;
		}
		if (entrepriseId != other.entrepriseId) {
			return false;
		}
		if (nomEntreprise == null) {
			if (other.nomEntreprise != null) {
				return false;
			}
		} else if (!nomEntreprise.equals(other.nomEntreprise)) {
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
		return true;
	}

	@Override
	protected Entreprise createEntity() {
		return new Entreprise();
	}

	@Override
	public void updateWith(Entreprise entity) {
		entrepriseId = entity.getEntrepriseId();
		nomEntreprise = entity.getNomEntreprise();
		adresse = entity.getAdresse();
		statut = entity.getStatut();
		operateur = entity.getOperateur();
		EntityCopier<Assureur> aCopier = new EntityCopier<Assureur>();
		assureur = aCopier.copy(entity.getAssureur());
	}

}
