package clinique.mapping;

import java.util.Date;

public class DevisAssureur extends Entity<DevisAssureur> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4285657705181419010L;
	private String devisAssureurId;
	private double total;

	private Date dateDevis;

	private String statut;
	private String operateur;

	private Categorie categorie;
	private Patient patient;

	public String getDevisAssureurId() {
		return devisAssureurId;
	}

	public void setDevisAssureurId(String devisAssureurId) {
		this.devisAssureurId = devisAssureurId;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public Date getDateDevis() {
		return dateDevis;
	}

	public void setDateDevis(Date dateDevis) {
		this.dateDevis = dateDevis;
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

	public Categorie getCategorie() {
		return categorie;
	}

	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ (categorie == null ? 0 : categorie.hashCode());
		result = prime * result
				+ (dateDevis == null ? 0 : dateDevis.hashCode());
		result = prime * result
				+ (devisAssureurId == null ? 0 : devisAssureurId.hashCode());
		result = prime * result
				+ (operateur == null ? 0 : operateur.hashCode());
		result = prime * result + (patient == null ? 0 : patient.hashCode());
		result = prime * result + (statut == null ? 0 : statut.hashCode());
		long temp;
		temp = Double.doubleToLongBits(total);
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
		DevisAssureur other = (DevisAssureur) obj;
		if (categorie == null) {
			if (other.categorie != null) {
				return false;
			}
		} else if (!categorie.equals(other.categorie)) {
			return false;
		}
		if (dateDevis == null) {
			if (other.dateDevis != null) {
				return false;
			}
		} else if (!dateDevis.equals(other.dateDevis)) {
			return false;
		}
		if (devisAssureurId == null) {
			if (other.devisAssureurId != null) {
				return false;
			}
		} else if (!devisAssureurId.equals(other.devisAssureurId)) {
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
		if (Double.doubleToLongBits(total) != Double
				.doubleToLongBits(other.total)) {
			return false;
		}
		return true;
	}

	@Override
	protected DevisAssureur createEntity() {
		return new DevisAssureur();
	}

	@Override
	public void updateWith(DevisAssureur entity) {
		devisAssureurId = entity.getDevisAssureurId();
		total = entity.getTotal();
		dateDevis = entity.getDateDevis();
		statut = entity.getStatut();
		operateur = entity.getOperateur();
		EntityCopier<Categorie> cCopier = new EntityCopier<Categorie>();
		categorie = cCopier.copy(entity.getCategorie());
		EntityCopier<Patient> pCopier = new EntityCopier<Patient>();
		patient = pCopier.copy(entity.getPatient());
	}

}
