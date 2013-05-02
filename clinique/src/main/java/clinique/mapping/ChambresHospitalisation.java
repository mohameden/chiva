package clinique.mapping;

import java.util.Date;

public class ChambresHospitalisation extends Entity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 267613133182352530L;
	private String chambreHospitalisationId;
	private Date dateEntree;
	private Date dateSortie;
	private String statut;
	private String operateur;
	private int heureEntree;
	private int heureSortie;
	private double total;
	private double totalReel;

	private Hospitalisation hospitalisation;
	private Chambre chambre;

	public String getChambreHospitalisationId() {
		return chambreHospitalisationId;
	}

	public void setChambreHospitalisationId(String chambreHospitalisationId) {
		this.chambreHospitalisationId = chambreHospitalisationId;
	}

	public Date getDateEntree() {
		return dateEntree;
	}

	public void setDateEntree(Date dateEntree) {
		this.dateEntree = dateEntree;
	}

	public Date getDateSortie() {
		return dateSortie;
	}

	public void setDateSortie(Date dateSortie) {
		this.dateSortie = dateSortie;
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

	public Hospitalisation getHospitalisation() {
		return hospitalisation;
	}

	public void setHospitalisation(Hospitalisation hospitalisation) {
		this.hospitalisation = hospitalisation;
	}

	public Chambre getChambre() {
		return chambre;
	}

	public void setChambre(Chambre chambre) {
		this.chambre = chambre;
	}

	public int getHeureEntree() {
		return heureEntree;
	}

	public void setHeureEntree(int heureEntree) {
		this.heureEntree = heureEntree;
	}

	public int getHeureSortie() {
		return heureSortie;
	}

	public void setHeureSortie(int heureSortie) {
		this.heureSortie = heureSortie;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public double getTotalReel() {
		return totalReel;
	}

	public void setTotalReel(double totalReel) {
		this.totalReel = totalReel;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (chambre == null ? 0 : chambre.hashCode());
		result = prime
				* result
				+ (chambreHospitalisationId == null ? 0
						: chambreHospitalisationId.hashCode());
		result = prime * result
				+ (dateEntree == null ? 0 : dateEntree.hashCode());
		result = prime * result
				+ (dateSortie == null ? 0 : dateSortie.hashCode());
		result = prime * result + heureEntree;
		result = prime * result + heureSortie;
		result = prime * result
				+ (hospitalisation == null ? 0 : hospitalisation.hashCode());
		result = prime * result
				+ (operateur == null ? 0 : operateur.hashCode());
		result = prime * result + (statut == null ? 0 : statut.hashCode());
		long temp;
		temp = Double.doubleToLongBits(total);
		result = prime * result + (int) (temp ^ temp >>> 32);
		temp = Double.doubleToLongBits(totalReel);
		result = prime * result + (int) (temp ^ temp >>> 32);
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
		ChambresHospitalisation other = (ChambresHospitalisation) obj;
		if (chambre == null) {
			if (other.chambre != null) {
				return false;
			}
		} else if (!chambre.equals(other.chambre)) {
			return false;
		}
		if (chambreHospitalisationId == null) {
			if (other.chambreHospitalisationId != null) {
				return false;
			}
		} else if (!chambreHospitalisationId
				.equals(other.chambreHospitalisationId)) {
			return false;
		}
		if (dateEntree == null) {
			if (other.dateEntree != null) {
				return false;
			}
		} else if (!dateEntree.equals(other.dateEntree)) {
			return false;
		}
		if (dateSortie == null) {
			if (other.dateSortie != null) {
				return false;
			}
		} else if (!dateSortie.equals(other.dateSortie)) {
			return false;
		}
		if (heureEntree != other.heureEntree) {
			return false;
		}
		if (heureSortie != other.heureSortie) {
			return false;
		}
		if (hospitalisation == null) {
			if (other.hospitalisation != null) {
				return false;
			}
		} else if (!hospitalisation.equals(other.hospitalisation)) {
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
		if (Double.doubleToLongBits(total) != Double
				.doubleToLongBits(other.total)) {
			return false;
		}
		if (Double.doubleToLongBits(totalReel) != Double
				.doubleToLongBits(other.totalReel)) {
			return false;
		}
		return true;
	}

}
