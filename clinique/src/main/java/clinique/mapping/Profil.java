package clinique.mapping;

public class Profil extends Entity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5328968249218317404L;
	private int profilId;
	private String nomProfil;
	private String statut;
	private String operateur;

	public int getProfilId() {
		return profilId;
	}

	public void setProfilId(int profilId) {
		this.profilId = profilId;
	}

	public String getNomProfil() {
		return nomProfil;
	}

	public void setNomProfil(String nomProfil) {
		this.nomProfil = nomProfil;
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
		result = prime * result
				+ (nomProfil == null ? 0 : nomProfil.hashCode());
		result = prime * result
				+ (operateur == null ? 0 : operateur.hashCode());
		result = prime * result + profilId;
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
		Profil other = (Profil) obj;
		if (nomProfil == null) {
			if (other.nomProfil != null) {
				return false;
			}
		} else if (!nomProfil.equals(other.nomProfil)) {
			return false;
		}
		if (operateur == null) {
			if (other.operateur != null) {
				return false;
			}
		} else if (!operateur.equals(other.operateur)) {
			return false;
		}
		if (profilId != other.profilId) {
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
