package clinique.mapping;

import java.util.Date;

public class Hospitalisation extends Entity<Hospitalisation> {

	private static final long serialVersionUID = -9222994556707937186L;
	private String hospitalisationId;
	private Date dateEntree;
	private Date dateSortie;
	private String statut;
	private String operateur;
	private String encours;

	private Patient patient;
	private Chambre chambre;
	private Facture facture;

	public String getHospitalisationId() {
		return hospitalisationId;
	}

	public void setHospitalisationId(String hospitalisationId) {
		this.hospitalisationId = hospitalisationId;
	}

	public String getStatut() {
		return statut;
	}

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	public Chambre getChambre() {
		return chambre;
	}

	public void setChambre(Chambre chambre) {
		this.chambre = chambre;
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

	public String getEncours() {
		return encours;
	}

	public void setEncours(String encours) {
		this.encours = encours;
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

	public Facture getFacture() {
		return facture;
	}

	public void setFacture(Facture facture) {
		this.facture = facture;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (chambre == null ? 0 : chambre.hashCode());
		result = prime * result
				+ (dateEntree == null ? 0 : dateEntree.hashCode());
		result = prime * result
				+ (dateSortie == null ? 0 : dateSortie.hashCode());
		result = prime * result + (encours == null ? 0 : encours.hashCode());
		result = prime * result + (facture == null ? 0 : facture.hashCode());
		result = prime
				* result
				+ (hospitalisationId == null ? 0 : hospitalisationId.hashCode());
		result = prime * result
				+ (operateur == null ? 0 : operateur.hashCode());
		result = prime * result + (patient == null ? 0 : patient.hashCode());
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
		Hospitalisation other = (Hospitalisation) obj;
		if (chambre == null) {
			if (other.chambre != null) {
				return false;
			}
		} else if (!chambre.equals(other.chambre)) {
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
		if (encours == null) {
			if (other.encours != null) {
				return false;
			}
		} else if (!encours.equals(other.encours)) {
			return false;
		}
		if (facture == null) {
			if (other.facture != null) {
				return false;
			}
		} else if (!facture.equals(other.facture)) {
			return false;
		}
		if (hospitalisationId == null) {
			if (other.hospitalisationId != null) {
				return false;
			}
		} else if (!hospitalisationId.equals(other.hospitalisationId)) {
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
	protected Hospitalisation createEntity() {
		return new Hospitalisation();
	}

	@Override
	public void updateWith(Hospitalisation entity) {
		hospitalisationId = entity.getHospitalisationId();
		dateEntree = entity.getDateEntree();
		dateSortie = entity.getDateSortie();
		statut = entity.getStatut();
		operateur = entity.getOperateur();
		encours = entity.getEncours();
		EntityCopier<Patient> pCopier = new EntityCopier<Patient>();
		patient = pCopier.copy(entity.getPatient());
		EntityCopier<Chambre> cCopier = new EntityCopier<Chambre>();
		chambre = cCopier.copy(entity.getChambre());
		EntityCopier<Facture> fCopier = new EntityCopier<Facture>();
		facture = fCopier.copy(entity.getFacture());
	}

}
