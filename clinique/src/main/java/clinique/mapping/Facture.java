package clinique.mapping;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Facture extends Entity {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3426565593074915354L;
	private String factureId;
	private String numFact;
	private Date dateFact;
	private double totalHT;
	private double remise;
	private double majoration;
	private double avance;
	private double netApayer;
	private String statut;
	private String operateur;

	private double totalTva;
	private double qpc;
	private int tauxRemise = 0;
	private int tauxMajoration;
	private double remiseCash;
	private String isException;
	private String typePc;

	private Badge badge;
	private PriseEnCharge priseEnCharge;
	private String isHospitalisation;
	private double totalReglementPc = 0;

	private Patient patient;

	private List<Reglement> reglements = new ArrayList<Reglement>();
	private List<Recu> recus = new ArrayList<Recu>();
	private List<DetailFacture> detailFactures = new ArrayList<DetailFacture>();

	public String getNumFact() {
		return numFact;
	}

	public void setNumFact(String numFact) {
		this.numFact = numFact;
	}

	public double getAvance() {
		return avance;
	}

	public void setAvance(double avance) {
		this.avance = avance;
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

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	public List<Reglement> getReglements() {
		return reglements;
	}

	public void setReglements(List<Reglement> reglements) {
		this.reglements = reglements;
	}

	public double getMajoration() {
		return majoration;
	}

	public void setMajoration(double majoration) {
		this.majoration = majoration;
	}

	public double getTotalHT() {
		return totalHT;
	}

	public void setTotalHT(double totalHT) {
		this.totalHT = totalHT;
	}

	public List<Recu> getRecus() {
		return recus;
	}

	public void setRecus(List<Recu> recus) {
		this.recus = recus;
	}

	public String getFactureId() {
		return factureId;
	}

	public void setFactureId(String factureId) {
		this.factureId = factureId;
	}

	public List<DetailFacture> getDetailFactures() {
		return detailFactures;
	}

	public void setDetailFactures(List<DetailFacture> detailFactures) {
		this.detailFactures = detailFactures;
	}

	public double getQpc() {
		return qpc;
	}

	public void setQpc(double qpc) {
		this.qpc = qpc;
	}

	public double getRemise() {
		return remise;
	}

	public String getIsException() {
		return isException;
	}

	public void setIsException(String isException) {
		this.isException = isException;
	}

	public void setRemise(double remise) {
		this.remise = remise;
	}

	public double getNetApayer() {
		return netApayer;
	}

	public void setNetApayer(double netApayer) {
		this.netApayer = netApayer;
	}

	public double getTotalTva() {
		return totalTva;
	}

	public void setTotalTva(double totalTva) {
		this.totalTva = totalTva;
	}

	public int getTauxRemise() {
		return tauxRemise;
	}

	public void setTauxRemise(int tauxRemise) {
		this.tauxRemise = tauxRemise;
	}

	public Date getDateFact() {
		return dateFact;
	}

	public void setDateFact(Date dateFact) {
		this.dateFact = dateFact;
	}

	public String getTypePc() {
		return typePc;
	}

	public void setTypePc(String typePc) {
		this.typePc = typePc;
	}

	public Badge getBadge() {
		return badge;
	}

	public void setBadge(Badge badge) {
		this.badge = badge;
	}

	public PriseEnCharge getPriseEnCharge() {
		return priseEnCharge;
	}

	public void setPriseEnCharge(PriseEnCharge priseEnCharge) {
		this.priseEnCharge = priseEnCharge;
	}

	public String getIsHospitalisation() {
		return isHospitalisation;
	}

	public void setIsHospitalisation(String isHospitalisation) {
		this.isHospitalisation = isHospitalisation;
	}

	public double getTotalReglementPc() {
		return totalReglementPc;
	}

	public void setTotalReglementPc(double totalReglementPc) {
		this.totalReglementPc = totalReglementPc;
	}

	public int getTauxMajoration() {
		return tauxMajoration;
	}

	public void setTauxMajoration(int tauxMajoration) {
		this.tauxMajoration = tauxMajoration;
	}

	public double getRemiseCash() {
		return remiseCash;
	}

	public void setRemiseCash(double remiseCash) {
		this.remiseCash = remiseCash;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(avance);
		result = prime * result + (int) (temp ^ temp >>> 32);
		result = prime * result + (badge == null ? 0 : badge.hashCode());
		result = prime * result + (dateFact == null ? 0 : dateFact.hashCode());
		result = prime * result
				+ (detailFactures == null ? 0 : detailFactures.hashCode());
		result = prime * result
				+ (factureId == null ? 0 : factureId.hashCode());
		result = prime * result
				+ (isException == null ? 0 : isException.hashCode());
		result = prime
				* result
				+ (isHospitalisation == null ? 0 : isHospitalisation.hashCode());
		temp = Double.doubleToLongBits(majoration);
		result = prime * result + (int) (temp ^ temp >>> 32);
		temp = Double.doubleToLongBits(netApayer);
		result = prime * result + (int) (temp ^ temp >>> 32);
		result = prime * result + (numFact == null ? 0 : numFact.hashCode());
		result = prime * result
				+ (operateur == null ? 0 : operateur.hashCode());
		result = prime * result + (patient == null ? 0 : patient.hashCode());
		result = prime * result
				+ (priseEnCharge == null ? 0 : priseEnCharge.hashCode());
		temp = Double.doubleToLongBits(qpc);
		result = prime * result + (int) (temp ^ temp >>> 32);
		result = prime * result + (recus == null ? 0 : recus.hashCode());
		result = prime * result
				+ (reglements == null ? 0 : reglements.hashCode());
		temp = Double.doubleToLongBits(remise);
		result = prime * result + (int) (temp ^ temp >>> 32);
		temp = Double.doubleToLongBits(remiseCash);
		result = prime * result + (int) (temp ^ temp >>> 32);
		result = prime * result + (statut == null ? 0 : statut.hashCode());
		result = prime * result + tauxMajoration;
		result = prime * result + tauxRemise;
		temp = Double.doubleToLongBits(totalHT);
		result = prime * result + (int) (temp ^ temp >>> 32);
		temp = Double.doubleToLongBits(totalReglementPc);
		result = prime * result + (int) (temp ^ temp >>> 32);
		temp = Double.doubleToLongBits(totalTva);
		result = prime * result + (int) (temp ^ temp >>> 32);
		result = prime * result + (typePc == null ? 0 : typePc.hashCode());
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
		Facture other = (Facture) obj;
		if (Double.doubleToLongBits(avance) != Double
				.doubleToLongBits(other.avance)) {
			return false;
		}
		if (badge == null) {
			if (other.badge != null) {
				return false;
			}
		} else if (!badge.equals(other.badge)) {
			return false;
		}
		if (dateFact == null) {
			if (other.dateFact != null) {
				return false;
			}
		} else if (!dateFact.equals(other.dateFact)) {
			return false;
		}
		if (detailFactures == null) {
			if (other.detailFactures != null) {
				return false;
			}
		} else if (!detailFactures.equals(other.detailFactures)) {
			return false;
		}
		if (factureId == null) {
			if (other.factureId != null) {
				return false;
			}
		} else if (!factureId.equals(other.factureId)) {
			return false;
		}
		if (isException == null) {
			if (other.isException != null) {
				return false;
			}
		} else if (!isException.equals(other.isException)) {
			return false;
		}
		if (isHospitalisation == null) {
			if (other.isHospitalisation != null) {
				return false;
			}
		} else if (!isHospitalisation.equals(other.isHospitalisation)) {
			return false;
		}
		if (Double.doubleToLongBits(majoration) != Double
				.doubleToLongBits(other.majoration)) {
			return false;
		}
		if (Double.doubleToLongBits(netApayer) != Double
				.doubleToLongBits(other.netApayer)) {
			return false;
		}
		if (numFact == null) {
			if (other.numFact != null) {
				return false;
			}
		} else if (!numFact.equals(other.numFact)) {
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
		if (priseEnCharge == null) {
			if (other.priseEnCharge != null) {
				return false;
			}
		} else if (!priseEnCharge.equals(other.priseEnCharge)) {
			return false;
		}
		if (Double.doubleToLongBits(qpc) != Double.doubleToLongBits(other.qpc)) {
			return false;
		}
		if (recus == null) {
			if (other.recus != null) {
				return false;
			}
		} else if (!recus.equals(other.recus)) {
			return false;
		}
		if (reglements == null) {
			if (other.reglements != null) {
				return false;
			}
		} else if (!reglements.equals(other.reglements)) {
			return false;
		}
		if (Double.doubleToLongBits(remise) != Double
				.doubleToLongBits(other.remise)) {
			return false;
		}
		if (Double.doubleToLongBits(remiseCash) != Double
				.doubleToLongBits(other.remiseCash)) {
			return false;
		}
		if (statut == null) {
			if (other.statut != null) {
				return false;
			}
		} else if (!statut.equals(other.statut)) {
			return false;
		}
		if (tauxMajoration != other.tauxMajoration) {
			return false;
		}
		if (tauxRemise != other.tauxRemise) {
			return false;
		}
		if (Double.doubleToLongBits(totalHT) != Double
				.doubleToLongBits(other.totalHT)) {
			return false;
		}
		if (Double.doubleToLongBits(totalReglementPc) != Double
				.doubleToLongBits(other.totalReglementPc)) {
			return false;
		}
		if (Double.doubleToLongBits(totalTva) != Double
				.doubleToLongBits(other.totalTva)) {
			return false;
		}
		if (typePc == null) {
			if (other.typePc != null) {
				return false;
			}
		} else if (!typePc.equals(other.typePc)) {
			return false;
		}
		return true;
	}

}
