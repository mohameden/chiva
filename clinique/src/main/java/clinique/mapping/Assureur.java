package clinique.mapping;

import java.util.ArrayList;
import java.util.List;

public class Assureur extends Entity {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8821215481533026423L;
	private int assureurId;
	private String nomAssureur;
	private String adresse;
	private String statut;
	private String operateur;
	private List<Entreprise> entreprises = new ArrayList<Entreprise>();

	public int getAssureurId() {
		return assureurId;
	}

	public void setAssureurId(int assureurId) {
		this.assureurId = assureurId;
	}

	public String getNomAssureur() {
		return nomAssureur;
	}

	public void setNomAssureur(String nomAssureur) {
		this.nomAssureur = nomAssureur;
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

	public List<Entreprise> getEntreprises() {
		return entreprises;
	}

	public void setEntreprises(List<Entreprise> entreprises) {
		this.entreprises = entreprises;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (adresse == null ? 0 : adresse.hashCode());
		result = prime * result + assureurId;
		result = prime * result
				+ (entreprises == null ? 0 : entreprises.hashCode());
		result = prime * result
				+ (nomAssureur == null ? 0 : nomAssureur.hashCode());
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
		Assureur other = (Assureur) obj;
		if (adresse == null) {
			if (other.adresse != null) {
				return false;
			}
		} else if (!adresse.equals(other.adresse)) {
			return false;
		}
		if (assureurId != other.assureurId) {
			return false;
		}
		if (entreprises == null) {
			if (other.entreprises != null) {
				return false;
			}
		} else if (!entreprises.equals(other.entreprises)) {
			return false;
		}
		if (nomAssureur == null) {
			if (other.nomAssureur != null) {
				return false;
			}
		} else if (!nomAssureur.equals(other.nomAssureur)) {
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
