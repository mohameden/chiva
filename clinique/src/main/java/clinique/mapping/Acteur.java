package clinique.mapping;

import java.util.ArrayList;
import java.util.List;

public class Acteur extends Entity {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5832870621628322740L;
	private int acteurId;
	private String nom;
	private String designation;
	private String assistant;
	private String telephone;
	private String email;
	private String statut;
	private String operateur;

	private List<ActeurActe> acteurActes = new ArrayList<ActeurActe>();

	public int getActeurId() {
		return acteurId;
	}

	public void setActeurId(int acteurId) {
		this.acteurId = acteurId;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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

	public List<ActeurActe> getActeurActes() {
		return acteurActes;
	}

	public void setActeurActes(List<ActeurActe> acteurActes) {
		this.acteurActes = acteurActes;
	}

	public String getAssistant() {
		return assistant;
	}

	public void setAssistant(String assistant) {
		this.assistant = assistant;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ (acteurActes == null ? 0 : acteurActes.hashCode());
		result = prime * result + acteurId;
		result = prime * result
				+ (assistant == null ? 0 : assistant.hashCode());
		result = prime * result
				+ (designation == null ? 0 : designation.hashCode());
		result = prime * result + (email == null ? 0 : email.hashCode());
		result = prime * result + (nom == null ? 0 : nom.hashCode());
		result = prime * result
				+ (operateur == null ? 0 : operateur.hashCode());
		result = prime * result + (statut == null ? 0 : statut.hashCode());
		result = prime * result
				+ (telephone == null ? 0 : telephone.hashCode());
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
		Acteur other = (Acteur) obj;
		if (acteurActes == null) {
			if (other.acteurActes != null) {
				return false;
			}
		} else if (!acteurActes.equals(other.acteurActes)) {
			return false;
		}
		if (acteurId != other.acteurId) {
			return false;
		}
		if (assistant == null) {
			if (other.assistant != null) {
				return false;
			}
		} else if (!assistant.equals(other.assistant)) {
			return false;
		}
		if (designation == null) {
			if (other.designation != null) {
				return false;
			}
		} else if (!designation.equals(other.designation)) {
			return false;
		}
		if (email == null) {
			if (other.email != null) {
				return false;
			}
		} else if (!email.equals(other.email)) {
			return false;
		}
		if (nom == null) {
			if (other.nom != null) {
				return false;
			}
		} else if (!nom.equals(other.nom)) {
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
		if (telephone == null) {
			if (other.telephone != null) {
				return false;
			}
		} else if (!telephone.equals(other.telephone)) {
			return false;
		}
		return true;
	}

}
