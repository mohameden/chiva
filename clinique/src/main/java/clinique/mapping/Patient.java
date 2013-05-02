package clinique.mapping;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Patient extends Entity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2873526656715185052L;
	private String patientId;
	private String nom;
	private String prenom;
	private Date dateNaissance;
	private String lieuNaissance;
	private String telephone;
	private String adresse;
	private String cni;
	private String nni;

	private Date datePremiereViste;
	private Date dateDerniereVisite;
	private String statut;
	private String operateur;

	private Categorie categorie;

	private String priseEnChargeFlag;

	private List<Facture> factures = new ArrayList<Facture>();
	private List<PriseEnCharge> priseEnCharges = new ArrayList<PriseEnCharge>();
	private List<Hospitalisation> hospitalisations = new ArrayList<Hospitalisation>();
	private List<Badge> badges = new ArrayList<Badge>();

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getLieuNaissance() {
		return lieuNaissance;
	}

	public void setLieuNaissance(String lieuNaissance) {
		this.lieuNaissance = lieuNaissance;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getCni() {
		return cni;
	}

	public void setCni(String cni) {
		this.cni = cni;
	}

	public String getNni() {
		return nni;
	}

	public void setNni(String nni) {
		this.nni = nni;
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

	public List<Facture> getFactures() {
		return factures;
	}

	public void setFactures(List<Facture> factures) {
		this.factures = factures;
	}

	public List<PriseEnCharge> getPriseEnCharges() {
		return priseEnCharges;
	}

	public void setPriseEnCharges(List<PriseEnCharge> priseEnCharges) {
		this.priseEnCharges = priseEnCharges;
	}

	public List<Hospitalisation> getHospitalisations() {
		return hospitalisations;
	}

	public void setHospitalisations(List<Hospitalisation> hospitalisations) {
		this.hospitalisations = hospitalisations;
	}

	public Date getDateNaissance() {
		return dateNaissance;
	}

	public void setDateNaissance(Date dateNaissance) {
		this.dateNaissance = dateNaissance;
	}

	public Date getDatePremiereViste() {
		return datePremiereViste;
	}

	public void setDatePremiereViste(Date datePremiereViste) {
		this.datePremiereViste = datePremiereViste;
	}

	public Date getDateDerniereVisite() {
		return dateDerniereVisite;
	}

	public void setDateDerniereVisite(Date dateDerniereVisite) {
		this.dateDerniereVisite = dateDerniereVisite;
	}

	public Categorie getCategorie() {
		return categorie;
	}

	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}

	public String getPatientId() {
		return patientId;
	}

	public void setPatientId(String patientId) {
		this.patientId = patientId;
	}

	public String getPriseEnChargeFlag() {
		return priseEnChargeFlag;
	}

	public void setPriseEnChargeFlag(String priseEnChargeFlag) {
		this.priseEnChargeFlag = priseEnChargeFlag;
	}

	public List<Badge> getBadges() {
		return badges;
	}

	public void setBadges(List<Badge> badges) {
		this.badges = badges;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (adresse == null ? 0 : adresse.hashCode());
		result = prime * result + (badges == null ? 0 : badges.hashCode());
		result = prime * result
				+ (categorie == null ? 0 : categorie.hashCode());
		result = prime * result + (cni == null ? 0 : cni.hashCode());
		result = prime
				* result
				+ (dateDerniereVisite == null ? 0 : dateDerniereVisite
						.hashCode());
		result = prime * result
				+ (dateNaissance == null ? 0 : dateNaissance.hashCode());
		result = prime
				* result
				+ (datePremiereViste == null ? 0 : datePremiereViste.hashCode());
		result = prime * result + (factures == null ? 0 : factures.hashCode());
		result = prime * result
				+ (hospitalisations == null ? 0 : hospitalisations.hashCode());
		result = prime * result
				+ (lieuNaissance == null ? 0 : lieuNaissance.hashCode());
		result = prime * result + (nni == null ? 0 : nni.hashCode());
		result = prime * result + (nom == null ? 0 : nom.hashCode());
		result = prime * result
				+ (operateur == null ? 0 : operateur.hashCode());
		result = prime * result
				+ (patientId == null ? 0 : patientId.hashCode());
		result = prime * result + (prenom == null ? 0 : prenom.hashCode());
		result = prime
				* result
				+ (priseEnChargeFlag == null ? 0 : priseEnChargeFlag.hashCode());
		result = prime * result
				+ (priseEnCharges == null ? 0 : priseEnCharges.hashCode());
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
		Patient other = (Patient) obj;
		if (adresse == null) {
			if (other.adresse != null) {
				return false;
			}
		} else if (!adresse.equals(other.adresse)) {
			return false;
		}
		if (badges == null) {
			if (other.badges != null) {
				return false;
			}
		} else if (!badges.equals(other.badges)) {
			return false;
		}
		if (categorie == null) {
			if (other.categorie != null) {
				return false;
			}
		} else if (!categorie.equals(other.categorie)) {
			return false;
		}
		if (cni == null) {
			if (other.cni != null) {
				return false;
			}
		} else if (!cni.equals(other.cni)) {
			return false;
		}
		if (dateDerniereVisite == null) {
			if (other.dateDerniereVisite != null) {
				return false;
			}
		} else if (!dateDerniereVisite.equals(other.dateDerniereVisite)) {
			return false;
		}
		if (dateNaissance == null) {
			if (other.dateNaissance != null) {
				return false;
			}
		} else if (!dateNaissance.equals(other.dateNaissance)) {
			return false;
		}
		if (datePremiereViste == null) {
			if (other.datePremiereViste != null) {
				return false;
			}
		} else if (!datePremiereViste.equals(other.datePremiereViste)) {
			return false;
		}
		if (factures == null) {
			if (other.factures != null) {
				return false;
			}
		} else if (!factures.equals(other.factures)) {
			return false;
		}
		if (hospitalisations == null) {
			if (other.hospitalisations != null) {
				return false;
			}
		} else if (!hospitalisations.equals(other.hospitalisations)) {
			return false;
		}
		if (lieuNaissance == null) {
			if (other.lieuNaissance != null) {
				return false;
			}
		} else if (!lieuNaissance.equals(other.lieuNaissance)) {
			return false;
		}
		if (nni == null) {
			if (other.nni != null) {
				return false;
			}
		} else if (!nni.equals(other.nni)) {
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
		if (patientId == null) {
			if (other.patientId != null) {
				return false;
			}
		} else if (!patientId.equals(other.patientId)) {
			return false;
		}
		if (prenom == null) {
			if (other.prenom != null) {
				return false;
			}
		} else if (!prenom.equals(other.prenom)) {
			return false;
		}
		if (priseEnChargeFlag == null) {
			if (other.priseEnChargeFlag != null) {
				return false;
			}
		} else if (!priseEnChargeFlag.equals(other.priseEnChargeFlag)) {
			return false;
		}
		if (priseEnCharges == null) {
			if (other.priseEnCharges != null) {
				return false;
			}
		} else if (!priseEnCharges.equals(other.priseEnCharges)) {
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

	/*
	 * public Badge getBadge() { Badge badge=null;
	 * 
	 * if (!getBadges().isEmpty() && getBadges().size()!=0) { for (Iterator iter
	 * = getBadges().iterator(); iter.hasNext();) { Badge element = (Badge)
	 * iter.next(); if (element.getStatut().equals("1")) { if (badge!=null) { if
	 * (UtilDate.getInstance().date1AfterDate2(element.getDateDebut(),
	 * badge.getDateDebut())) badge=element; } else badge=element; } } }
	 * 
	 * return badge; }
	 */

}
