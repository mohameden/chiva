package clinique.mapping;

import java.util.Date;

public class PriseEnCharge extends Entity<PriseEnCharge> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5219779479164538788L;
	private String pcId;
	private String pcNum;
	private double plafond;
	private int pourcentage;
	private Date finValidite;
	private Date dateCreation;
	private int nombreActes;
	private double montantFact;
	private String statut;
	private String operateur;
	private String tout;

	private Patient patient;

	private Categorie categorie;

	public String getPcNum() {
		return pcNum;
	}

	public void setPcNum(String pcNum) {
		this.pcNum = pcNum;
	}

	public double getPlafond() {
		return plafond;
	}

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	public void setPlafond(double plafond) {
		this.plafond = plafond;
	}

	public int getPourcentage() {
		return pourcentage;
	}

	public void setPourcentage(int pourcentage) {
		this.pourcentage = pourcentage;
	}

	public Date getFinValidite() {
		return finValidite;
	}

	public void setFinValidite(Date finValidite) {
		this.finValidite = finValidite;
	}

	public Date getDateCreation() {
		return dateCreation;
	}

	public void setDateCreation(Date dateCreation) {
		this.dateCreation = dateCreation;
	}

	public int getNombreActes() {
		return nombreActes;
	}

	public void setNombreActes(int nombreActes) {
		this.nombreActes = nombreActes;
	}

	public double getMontantFact() {
		return montantFact;
	}

	public void setMontantFact(double montantFact) {
		this.montantFact = montantFact;
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

	public String getPcId() {
		return pcId;
	}

	public void setPcId(String pcId) {
		this.pcId = pcId;
	}

	public Categorie getCategorie() {
		return categorie;
	}

	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ (categorie == null ? 0 : categorie.hashCode());
		result = prime * result
				+ (dateCreation == null ? 0 : dateCreation.hashCode());
		result = prime * result
				+ (finValidite == null ? 0 : finValidite.hashCode());
		long temp;
		temp = Double.doubleToLongBits(montantFact);
		result = prime * result + (int) (temp ^ temp >>> 32);
		result = prime * result + nombreActes;
		result = prime * result
				+ (operateur == null ? 0 : operateur.hashCode());
		result = prime * result + (patient == null ? 0 : patient.hashCode());
		result = prime * result + (pcId == null ? 0 : pcId.hashCode());
		result = prime * result + (pcNum == null ? 0 : pcNum.hashCode());
		temp = Double.doubleToLongBits(plafond);
		result = prime * result + (int) (temp ^ temp >>> 32);
		result = prime * result + pourcentage;
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
		PriseEnCharge other = (PriseEnCharge) obj;
		if (categorie == null) {
			if (other.categorie != null) {
				return false;
			}
		} else if (!categorie.equals(other.categorie)) {
			return false;
		}
		if (dateCreation == null) {
			if (other.dateCreation != null) {
				return false;
			}
		} else if (!dateCreation.equals(other.dateCreation)) {
			return false;
		}
		if (finValidite == null) {
			if (other.finValidite != null) {
				return false;
			}
		} else if (!finValidite.equals(other.finValidite)) {
			return false;
		}
		if (Double.doubleToLongBits(montantFact) != Double
				.doubleToLongBits(other.montantFact)) {
			return false;
		}
		if (nombreActes != other.nombreActes) {
			return false;
		}
		if (operateur == null) {
			if (other.operateur != null) {
				return false;
			}
		} else if (!operateur.equals(other.operateur)) {
			return false;
		}
		if (patient == null) {
			if (other.patient != null) {
				return false;
			}
		} else if (!patient.equals(other.patient)) {
			return false;
		}
		if (pcId == null) {
			if (other.pcId != null) {
				return false;
			}
		} else if (!pcId.equals(other.pcId)) {
			return false;
		}
		if (pcNum == null) {
			if (other.pcNum != null) {
				return false;
			}
		} else if (!pcNum.equals(other.pcNum)) {
			return false;
		}
		if (Double.doubleToLongBits(plafond) != Double
				.doubleToLongBits(other.plafond)) {
			return false;
		}
		if (pourcentage != other.pourcentage) {
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

	@Override
	protected PriseEnCharge createEntity() {
		return new PriseEnCharge();
	}

	@Override
	public void updateWith(PriseEnCharge entity) {
		pcId = entity.getPcId();
		pcNum = entity.getPcNum();
		plafond = entity.getPlafond();
		pourcentage = entity.getPourcentage();
		finValidite = entity.getFinValidite();
		dateCreation = entity.getDateCreation();
		nombreActes = entity.getNombreActes();
		montantFact = entity.getMontantFact();
		statut = entity.getStatut();
		operateur = entity.getOperateur();
		EntityCopier<Categorie> cCopier = new EntityCopier<Categorie>();
		categorie = cCopier.copy(entity.getCategorie());
		EntityCopier<Patient> pCopier = new EntityCopier<Patient>();
		patient = pCopier.copy(entity.getPatient());
	}

	public String getTout() {
		return tout;
	}

	public void setTout(String tout) {
		this.tout = tout;
	}

}
