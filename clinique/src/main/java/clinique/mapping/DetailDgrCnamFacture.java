package clinique.mapping;

import java.util.Date;

public class DetailDgrCnamFacture extends Entity {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6675424587385214547L;
	private String detailDrgCnamId;
	private Facture facture;
	private Patient patient;
	private DrgCnam drgCnam;

	private String statut;
	private String operateur;
	private double petitMonnaie = 0;

	private Date dateDetail;

	public String getDetailDrgCnamId() {
		return detailDrgCnamId;
	}

	public void setDetailDrgCnamId(String detailDrgCnamId) {
		this.detailDrgCnamId = detailDrgCnamId;
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

	public Date getDateDetail() {
		return dateDetail;
	}

	public void setDateDetail(Date dateDetail) {
		this.dateDetail = dateDetail;
	}

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	public DrgCnam getDrgCnam() {
		return drgCnam;
	}

	public void setDrgCnam(DrgCnam drgCnam) {
		this.drgCnam = drgCnam;
	}

	public double getPetitMonnaie() {
		return petitMonnaie;
	}

	public void setPetitMonnaie(double petitMonnaie) {
		this.petitMonnaie = petitMonnaie;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ (dateDetail == null ? 0 : dateDetail.hashCode());
		result = prime * result
				+ (detailDrgCnamId == null ? 0 : detailDrgCnamId.hashCode());
		result = prime * result + (drgCnam == null ? 0 : drgCnam.hashCode());
		result = prime * result + (facture == null ? 0 : facture.hashCode());
		result = prime * result
				+ (operateur == null ? 0 : operateur.hashCode());
		result = prime * result + (patient == null ? 0 : patient.hashCode());
		long temp;
		temp = Double.doubleToLongBits(petitMonnaie);
		result = prime * result + (int) (temp ^ temp >>> 32);
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
		DetailDgrCnamFacture other = (DetailDgrCnamFacture) obj;
		if (dateDetail == null) {
			if (other.dateDetail != null) {
				return false;
			}
		} else if (!dateDetail.equals(other.dateDetail)) {
			return false;
		}
		if (detailDrgCnamId == null) {
			if (other.detailDrgCnamId != null) {
				return false;
			}
		} else if (!detailDrgCnamId.equals(other.detailDrgCnamId)) {
			return false;
		}
		if (drgCnam == null) {
			if (other.drgCnam != null) {
				return false;
			}
		} else if (!drgCnam.equals(other.drgCnam)) {
			return false;
		}
		if (facture == null) {
			if (other.facture != null) {
				return false;
			}
		} else if (!facture.equals(other.facture)) {
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
		if (Double.doubleToLongBits(petitMonnaie) != Double
				.doubleToLongBits(other.petitMonnaie)) {
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
