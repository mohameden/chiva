package clinique.mapping;

import java.util.ArrayList;
import java.util.List;

public class Classe extends Entity {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4268024907931330629L;
	private int classeId;
	private String nomClasse;
	private int qpc;
	private String statut;
	private String operateur;

	private List<Acte> actes = new ArrayList<Acte>();
	private List<PrestationCouvertesPc> prestationCouvertesPcs = new ArrayList<PrestationCouvertesPc>();

	public int getClasseId() {
		return classeId;
	}

	public void setClasseId(int classeId) {
		this.classeId = classeId;
	}

	public String getNomClasse() {
		return nomClasse;
	}

	public void setNomClasse(String nomClasse) {
		this.nomClasse = nomClasse;
	}

	public int getQpc() {
		return qpc;
	}

	public void setQpc(int qpc) {
		this.qpc = qpc;
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

	public List<Acte> getActes() {
		return actes;
	}

	public void setActes(List<Acte> actes) {
		this.actes = actes;
	}

	public List<PrestationCouvertesPc> getPrestationCouvertesPcs() {
		return prestationCouvertesPcs;
	}

	public void setPrestationCouvertesPcs(
			List<PrestationCouvertesPc> prestationCouvertesPcs) {
		this.prestationCouvertesPcs = prestationCouvertesPcs;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (actes == null ? 0 : actes.hashCode());
		result = prime * result + classeId;
		result = prime * result
				+ (nomClasse == null ? 0 : nomClasse.hashCode());
		result = prime * result
				+ (operateur == null ? 0 : operateur.hashCode());
		result = prime
				* result
				+ (prestationCouvertesPcs == null ? 0 : prestationCouvertesPcs
						.hashCode());
		result = prime * result + qpc;
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
		Classe other = (Classe) obj;
		if (actes == null) {
			if (other.actes != null) {
				return false;
			}
		} else if (!actes.equals(other.actes)) {
			return false;
		}
		if (classeId != other.classeId) {
			return false;
		}
		if (nomClasse == null) {
			if (other.nomClasse != null) {
				return false;
			}
		} else if (!nomClasse.equals(other.nomClasse)) {
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
		if (qpc != other.qpc) {
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
