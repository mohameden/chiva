package clinique.mapping;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class FactureGlobal extends Entity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 9080366002644087711L;
	private String factureGlobalId;
	private Categorie categorie;
	private String numeroFacture;
	private Date dateFacture;
	private String statut;
	private String operateur;

	private List<FactureGlobalFacture> factureGlobalFactures = new ArrayList<FactureGlobalFacture>();

	public String getFactureGlobalId() {
		return factureGlobalId;
	}

	public void setFactureGlobalId(String factureGlobalId) {
		this.factureGlobalId = factureGlobalId;
	}

	public Categorie getCategorie() {
		return categorie;
	}

	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}

	public String getNumeroFacture() {
		return numeroFacture;
	}

	public void setNumeroFacture(String numeroFacture) {
		this.numeroFacture = numeroFacture;
	}

	public Date getDateFacture() {
		return dateFacture;
	}

	public void setDateFacture(Date dateFacture) {
		this.dateFacture = dateFacture;
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

	public List<FactureGlobalFacture> getFactureGlobalFactures() {
		return factureGlobalFactures;
	}

	public void setFactureGlobalFactures(
			List<FactureGlobalFacture> factureGlobalFactures) {
		this.factureGlobalFactures = factureGlobalFactures;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ (categorie == null ? 0 : categorie.hashCode());
		result = prime * result
				+ (dateFacture == null ? 0 : dateFacture.hashCode());
		result = prime
				* result
				+ (factureGlobalFactures == null ? 0 : factureGlobalFactures
						.hashCode());
		result = prime * result
				+ (factureGlobalId == null ? 0 : factureGlobalId.hashCode());
		result = prime * result
				+ (numeroFacture == null ? 0 : numeroFacture.hashCode());
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
		FactureGlobal other = (FactureGlobal) obj;
		if (categorie == null) {
			if (other.categorie != null) {
				return false;
			}
		} else if (!categorie.equals(other.categorie)) {
			return false;
		}
		if (dateFacture == null) {
			if (other.dateFacture != null) {
				return false;
			}
		} else if (!dateFacture.equals(other.dateFacture)) {
			return false;
		}
		if (factureGlobalFactures == null) {
			if (other.factureGlobalFactures != null) {
				return false;
			}
		} else if (!factureGlobalFactures.equals(other.factureGlobalFactures)) {
			return false;
		}
		if (factureGlobalId == null) {
			if (other.factureGlobalId != null) {
				return false;
			}
		} else if (!factureGlobalId.equals(other.factureGlobalId)) {
			return false;
		}
		if (numeroFacture == null) {
			if (other.numeroFacture != null) {
				return false;
			}
		} else if (!numeroFacture.equals(other.numeroFacture)) {
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
