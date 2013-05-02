package clinique.mapping;

public class FactureGlobalFacture extends Entity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1689865100746800048L;

	private String factureGlobalFactureId;

	private FactureGlobal factureGlobal;
	private Facture facture;
	private String statut;
	private String operateur;

	public String getFactureGlobalFactureId() {
		return factureGlobalFactureId;
	}

	public void setFactureGlobalFactureId(String factureGlobalFactureId) {
		this.factureGlobalFactureId = factureGlobalFactureId;
	}

	public FactureGlobal getFactureGlobal() {
		return factureGlobal;
	}

	public void setFactureGlobal(FactureGlobal factureGlobal) {
		this.factureGlobal = factureGlobal;
	}

	public Facture getFacture() {
		return facture;
	}

	public void setFacture(Facture facture) {
		this.facture = facture;
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
		result = prime * result + (facture == null ? 0 : facture.hashCode());
		result = prime * result
				+ (factureGlobal == null ? 0 : factureGlobal.hashCode());
		result = prime
				* result
				+ (factureGlobalFactureId == null ? 0 : factureGlobalFactureId
						.hashCode());
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
		FactureGlobalFacture other = (FactureGlobalFacture) obj;
		if (facture == null) {
			if (other.facture != null) {
				return false;
			}
		} else if (!facture.equals(other.facture)) {
			return false;
		}
		if (factureGlobal == null) {
			if (other.factureGlobal != null) {
				return false;
			}
		} else if (!factureGlobal.equals(other.factureGlobal)) {
			return false;
		}
		if (factureGlobalFactureId == null) {
			if (other.factureGlobalFactureId != null) {
				return false;
			}
		} else if (!factureGlobalFactureId.equals(other.factureGlobalFactureId)) {
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

}
