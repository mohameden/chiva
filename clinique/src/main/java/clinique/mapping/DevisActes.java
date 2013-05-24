package clinique.mapping;

public class DevisActes extends Entity<DevisActes> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2138286476312352079L;
	private String devisActesId;
	private double total;
	private double prix;
	private int nbre;

	private String statut;
	private String operateur;

	private Acte acte;
	private DevisAssureur devisAssureur;

	public String getDevisActesId() {
		return devisActesId;
	}

	public void setDevisActesId(String devisActesId) {
		this.devisActesId = devisActesId;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public double getPrix() {
		return prix;
	}

	public void setPrix(double prix) {
		this.prix = prix;
	}

	public int getNbre() {
		return nbre;
	}

	public void setNbre(int nbre) {
		this.nbre = nbre;
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

	public Acte getActe() {
		return acte;
	}

	public void setActe(Acte acte) {
		this.acte = acte;
	}

	public DevisAssureur getDevisAssureur() {
		return devisAssureur;
	}

	public void setDevisAssureur(DevisAssureur devisAssureur) {
		this.devisAssureur = devisAssureur;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (acte == null ? 0 : acte.hashCode());
		result = prime * result
				+ (devisActesId == null ? 0 : devisActesId.hashCode());
		result = prime * result
				+ (devisAssureur == null ? 0 : devisAssureur.hashCode());
		result = prime * result + nbre;
		result = prime * result
				+ (operateur == null ? 0 : operateur.hashCode());
		long temp;
		temp = Double.doubleToLongBits(prix);
		result = prime * result + (int) (temp ^ temp >>> 32);
		result = prime * result + (statut == null ? 0 : statut.hashCode());
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
		DevisActes other = (DevisActes) obj;
		if (acte == null) {
			if (other.acte != null) {
				return false;
			}
		} else if (!acte.equals(other.acte)) {
			return false;
		}
		if (devisActesId == null) {
			if (other.devisActesId != null) {
				return false;
			}
		} else if (!devisActesId.equals(other.devisActesId)) {
			return false;
		}
		if (devisAssureur == null) {
			if (other.devisAssureur != null) {
				return false;
			}
		} else if (!devisAssureur.equals(other.devisAssureur)) {
			return false;
		}
		if (nbre != other.nbre) {
			return false;
		}
		if (operateur == null) {
			if (other.operateur != null) {
				return false;
			}
		} else if (!operateur.equals(other.operateur)) {
			return false;
		}
		if (Double.doubleToLongBits(prix) != Double
				.doubleToLongBits(other.prix)) {
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
	protected DevisActes createEntity() {
		return new DevisActes();
	}

	@Override
	public void updateWith(DevisActes entity) {
		devisActesId = entity.getDevisActesId();
		total = entity.getTotal();
		prix = entity.getPrix();
		nbre = entity.getNbre();
		statut = entity.getStatut();
		operateur = entity.getOperateur();
		EntityCopier<Acte> aCopier = new EntityCopier<Acte>();
		acte = aCopier.copy(entity.getActe());
		EntityCopier<DevisAssureur> dCopier = new EntityCopier<DevisAssureur>();
		devisAssureur = dCopier.copy(entity.getDevisAssureur());
	}

}
