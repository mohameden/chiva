package clinique.mapping;

import java.util.ArrayList;
import java.util.List;

public class PcPersonnel extends Entity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2663217562839268430L;
	private int pcPersonnelId;
	private String pcNom;

	private String statut;
	private String operateur;

	private Compte compte;
	private List<Reglement> reglements = new ArrayList<Reglement>();

	public int getPcPersonnelId() {
		return pcPersonnelId;
	}

	public void setPcPersonnelId(int pcPersonnelId) {
		this.pcPersonnelId = pcPersonnelId;
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

	public String getPcNom() {
		return pcNom;
	}

	public void setPcNom(String pcNom) {
		this.pcNom = pcNom;
	}

	public List<Reglement> getReglements() {
		return reglements;
	}

	public void setReglements(List<Reglement> reglements) {
		this.reglements = reglements;
	}

	public Compte getCompte() {
		return compte;
	}

	public void setCompte(Compte compte) {
		this.compte = compte;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (compte == null ? 0 : compte.hashCode());
		result = prime * result
				+ (operateur == null ? 0 : operateur.hashCode());
		result = prime * result + (pcNom == null ? 0 : pcNom.hashCode());
		result = prime * result + pcPersonnelId;
		result = prime * result
				+ (reglements == null ? 0 : reglements.hashCode());
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
		PcPersonnel other = (PcPersonnel) obj;
		if (compte == null) {
			if (other.compte != null) {
				return false;
			}
		} else if (!compte.equals(other.compte)) {
			return false;
		}
		if (operateur == null) {
			if (other.operateur != null) {
				return false;
			}
		} else if (!operateur.equals(other.operateur)) {
			return false;
		}
		if (pcNom == null) {
			if (other.pcNom != null) {
				return false;
			}
		} else if (!pcNom.equals(other.pcNom)) {
			return false;
		}
		if (pcPersonnelId != other.pcPersonnelId) {
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
		return true;
	}

}
