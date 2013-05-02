package clinique.mapping;

import java.util.ArrayList;
import java.util.List;

public class TypePayement extends Entity {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5980355282673436013L;
	private int typePayementId;
	private String typePayement;
	private String statut;
	private String operateur;

	private List<Reglement> reglements = new ArrayList<Reglement>();

	public int getTypePayementId() {
		return typePayementId;
	}

	public void setTypePayementId(int typePayementId) {
		this.typePayementId = typePayementId;
	}

	public String getTypePayement() {
		return typePayement;
	}

	public void setTypePayement(String typePayement) {
		this.typePayement = typePayement;
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

	public List<Reglement> getReglements() {
		return reglements;
	}

	public void setReglements(List<Reglement> reglements) {
		this.reglements = reglements;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ (operateur == null ? 0 : operateur.hashCode());
		result = prime * result
				+ (reglements == null ? 0 : reglements.hashCode());
		result = prime * result + (statut == null ? 0 : statut.hashCode());
		result = prime * result
				+ (typePayement == null ? 0 : typePayement.hashCode());
		result = prime * result + typePayementId;
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
		TypePayement other = (TypePayement) obj;
		if (operateur == null) {
			if (other.operateur != null) {
				return false;
			}
		} else if (!operateur.equals(other.operateur)) {
			return false;
		}
		if (reglements == null) {
			if (other.reglements != null) {
				return false;
			}
		} else if (!reglements.equals(other.reglements)) {
			return false;
		}
		if (statut == null) {
			if (other.statut != null) {
				return false;
			}
		} else if (!statut.equals(other.statut)) {
			return false;
		}
		if (typePayement == null) {
			if (other.typePayement != null) {
				return false;
			}
		} else if (!typePayement.equals(other.typePayement)) {
			return false;
		}
		if (typePayementId != other.typePayementId) {
			return false;
		}
		return true;
	}

}
