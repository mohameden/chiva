package clinique.mapping;

import java.util.ArrayList;
import java.util.List;

public class FamillePrestation extends Entity {

	/**
	 * 
	 */
	private static final long serialVersionUID = -140262157783151002L;
	private int famillePrestationId;
	private String libelle;
	private String statut;
	private String operateur;
	private List<Acte> actes = new ArrayList<Acte>();

	private List<PrestationCouvertesPc> prestationCouvertesPcs = new ArrayList<PrestationCouvertesPc>();

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
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

	public List<PrestationCouvertesPc> getPrestationCouvertesPcs() {
		return prestationCouvertesPcs;
	}

	public void setPrestationCouvertesPcs(
			List<PrestationCouvertesPc> prestationCouvertesPcs) {
		this.prestationCouvertesPcs = prestationCouvertesPcs;
	}

	public int getFamillePrestationId() {
		return famillePrestationId;
	}

	public void setFamillePrestationId(int famillePrestationId) {
		this.famillePrestationId = famillePrestationId;
	}

	public List<Acte> getActes() {
		return actes;
	}

	public void setActes(List<Acte> actes) {
		this.actes = actes;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (actes == null ? 0 : actes.hashCode());
		result = prime * result + famillePrestationId;
		result = prime * result + (libelle == null ? 0 : libelle.hashCode());
		result = prime * result
				+ (operateur == null ? 0 : operateur.hashCode());
		result = prime
				* result
				+ (prestationCouvertesPcs == null ? 0 : prestationCouvertesPcs
						.hashCode());
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
		FamillePrestation other = (FamillePrestation) obj;
		if (actes == null) {
			if (other.actes != null) {
				return false;
			}
		} else if (!actes.equals(other.actes)) {
			return false;
		}
		if (famillePrestationId != other.famillePrestationId) {
			return false;
		}
		if (libelle == null) {
			if (other.libelle != null) {
				return false;
			}
		} else if (!libelle.equals(other.libelle)) {
			return false;
		}
		if (operateur == null) {
			if (other.operateur != null) {
				return false;
			}
		} else if (!operateur.equals(other.operateur)) {
			return false;
		}
		if (prestationCouvertesPcs == null) {
			if (other.prestationCouvertesPcs != null) {
				return false;
			}
		} else if (!prestationCouvertesPcs.equals(other.prestationCouvertesPcs)) {
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
