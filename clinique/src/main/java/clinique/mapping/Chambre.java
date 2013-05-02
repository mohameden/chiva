package clinique.mapping;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Chambre extends Entity {

	private static final long serialVersionUID = -3233278741088924234L;
	private int chambreId;
	private String chambreNum;
	private String chambreLibelle;
	private double tarif;
	private String etat;
	private String statut;
	private Date dateDebut;
	private Date dateFin;

	private List<Hospitalisation> hospitalisations = new ArrayList<Hospitalisation>();
	private List<ChambresHospitalisation> chambresHospitalisation = new ArrayList<ChambresHospitalisation>();

	public List<Hospitalisation> getHospitalisations() {
		return hospitalisations;
	}

	public void setHospitalisations(List<Hospitalisation> hospitalisations) {
		this.hospitalisations = hospitalisations;
	}

	public int getChambreId() {
		return chambreId;
	}

	public void setChambreId(int chambreId) {
		this.chambreId = chambreId;
	}

	public String getChambreNum() {
		return chambreNum;
	}

	public void setChambreNum(String chambreNum) {
		this.chambreNum = chambreNum;
	}

	public String getChambreLibelle() {
		return chambreLibelle;
	}

	public void setChambreLibelle(String chambreLibelle) {
		this.chambreLibelle = chambreLibelle;
	}

	public double getTarif() {
		return tarif;
	}

	public void setTarif(double tarif) {
		this.tarif = tarif;
	}

	public String getEtat() {
		return etat;
	}

	public void setEtat(String etat) {
		this.etat = etat;
	}

	public String getStatut() {
		return statut;
	}

	public void setStatut(String statut) {
		this.statut = statut;
	}

	public List<ChambresHospitalisation> getChambresHospitalisation() {
		return chambresHospitalisation;
	}

	public void setChambresHospitalisation(
			List<ChambresHospitalisation> chambresHospitalisation) {
		this.chambresHospitalisation = chambresHospitalisation;
	}

	public Date getDateDebut() {
		return dateDebut;
	}

	public void setDateDebut(Date dateDebut) {
		this.dateDebut = dateDebut;
	}

	public Date getDateFin() {
		return dateFin;
	}

	public void setDateFin(Date dateFin) {
		this.dateFin = dateFin;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + chambreId;
		result = prime * result
				+ (chambreLibelle == null ? 0 : chambreLibelle.hashCode());
		result = prime * result
				+ (chambreNum == null ? 0 : chambreNum.hashCode());
		result = prime
				* result
				+ (chambresHospitalisation == null ? 0
						: chambresHospitalisation.hashCode());
		result = prime * result
				+ (dateDebut == null ? 0 : dateDebut.hashCode());
		result = prime * result + (dateFin == null ? 0 : dateFin.hashCode());
		result = prime * result + (etat == null ? 0 : etat.hashCode());
		result = prime * result
				+ (hospitalisations == null ? 0 : hospitalisations.hashCode());
		result = prime * result + (statut == null ? 0 : statut.hashCode());
		long temp;
		temp = Double.doubleToLongBits(tarif);
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
		Chambre other = (Chambre) obj;
		if (chambreId != other.chambreId) {
			return false;
		}
		if (chambreLibelle == null) {
			if (other.chambreLibelle != null) {
				return false;
			}
		} else if (!chambreLibelle.equals(other.chambreLibelle)) {
			return false;
		}
		if (chambreNum == null) {
			if (other.chambreNum != null) {
				return false;
			}
		} else if (!chambreNum.equals(other.chambreNum)) {
			return false;
		}
		if (chambresHospitalisation == null) {
			if (other.chambresHospitalisation != null) {
				return false;
			}
		} else if (!chambresHospitalisation
				.equals(other.chambresHospitalisation)) {
			return false;
		}
		if (dateDebut == null) {
			if (other.dateDebut != null) {
				return false;
			}
		} else if (!dateDebut.equals(other.dateDebut)) {
			return false;
		}
		if (dateFin == null) {
			if (other.dateFin != null) {
				return false;
			}
		} else if (!dateFin.equals(other.dateFin)) {
			return false;
		}
		if (etat == null) {
			if (other.etat != null) {
				return false;
			}
		} else if (!etat.equals(other.etat)) {
			return false;
		}
		if (hospitalisations == null) {
			if (other.hospitalisations != null) {
				return false;
			}
		} else if (!hospitalisations.equals(other.hospitalisations)) {
			return false;
		}
		if (statut == null) {
			if (other.statut != null) {
				return false;
			}
		} else if (!statut.equals(other.statut)) {
			return false;
		}
		if (Double.doubleToLongBits(tarif) != Double
				.doubleToLongBits(other.tarif)) {
			return false;
		}
		return true;
	}

}
