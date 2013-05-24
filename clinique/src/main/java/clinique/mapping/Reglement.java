package clinique.mapping;

import java.util.Date;

public class Reglement extends Entity<Reglement> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7320991097409516299L;
	private String reglementId;
	private double montant;
	private Date dateReglement;
	private String statut;
	private String operateur;
	private String description;
	private double petitMonnaie = 0;
	private String typePC = "";
	private double remiseCash;
	private String majore;

	private Facture facture;
	private TypePayement typePayement;
	private PcPersonnel pcPersonnel;
	private Categorie categorie;
	private PriseEnCharge priseEnCharge;
	private Badge badge;
	private DrgCnam drgCnam;

	public DrgCnam getDrgCnam() {
		return drgCnam;
	}

	public void setDrgCnam(DrgCnam drgCnam) {
		this.drgCnam = drgCnam;
	}

	public String getReglementId() {
		return reglementId;
	}

	public void setReglementId(String reglementId) {
		this.reglementId = reglementId;
	}

	public double getMontant() {
		return montant;
	}

	public Facture getFacture() {
		return facture;
	}

	public void setFacture(Facture facture) {
		this.facture = facture;
	}

	public void setMontant(double montant) {
		this.montant = montant;
	}

	public Date getDateReglement() {
		return dateReglement;
	}

	public void setDateReglement(Date dateReglement) {
		this.dateReglement = dateReglement;
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

	public TypePayement getTypePayement() {
		return typePayement;
	}

	public void setTypePayement(TypePayement typePayement) {
		this.typePayement = typePayement;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getPetitMonnaie() {
		return petitMonnaie;
	}

	public void setPetitMonnaie(double petitMonnaie) {
		this.petitMonnaie = petitMonnaie;
	}

	public String getTypePC() {
		return typePC;
	}

	public void setTypePC(String typePC) {
		this.typePC = typePC;
	}

	public PcPersonnel getPcPersonnel() {
		return pcPersonnel;
	}

	public void setPcPersonnel(PcPersonnel pcPersonnel) {
		this.pcPersonnel = pcPersonnel;
	}

	public Categorie getCategorie() {
		return categorie;
	}

	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}

	public PriseEnCharge getPriseEnCharge() {
		return priseEnCharge;
	}

	public void setPriseEnCharge(PriseEnCharge priseEnCharge) {
		this.priseEnCharge = priseEnCharge;
	}

	public Badge getBadge() {
		return badge;
	}

	public void setBadge(Badge badge) {
		this.badge = badge;
	}

	public double getRemiseCash() {
		return remiseCash;
	}

	public void setRemiseCash(double remiseCash) {
		this.remiseCash = remiseCash;
	}

	public String getMajore() {
		return majore;
	}

	public void setMajore(String majore) {
		this.majore = majore;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (badge == null ? 0 : badge.hashCode());
		result = prime * result
				+ (categorie == null ? 0 : categorie.hashCode());
		result = prime * result
				+ (dateReglement == null ? 0 : dateReglement.hashCode());
		result = prime * result
				+ (description == null ? 0 : description.hashCode());
		result = prime * result + (drgCnam == null ? 0 : drgCnam.hashCode());
		result = prime * result + (facture == null ? 0 : facture.hashCode());
		result = prime * result + (majore == null ? 0 : majore.hashCode());
		long temp;
		temp = Double.doubleToLongBits(montant);
		result = prime * result + (int) (temp ^ temp >>> 32);
		result = prime * result
				+ (operateur == null ? 0 : operateur.hashCode());
		result = prime * result
				+ (pcPersonnel == null ? 0 : pcPersonnel.hashCode());
		temp = Double.doubleToLongBits(petitMonnaie);
		result = prime * result + (int) (temp ^ temp >>> 32);
		result = prime * result
				+ (priseEnCharge == null ? 0 : priseEnCharge.hashCode());
		result = prime * result
				+ (reglementId == null ? 0 : reglementId.hashCode());
		temp = Double.doubleToLongBits(remiseCash);
		result = prime * result + (int) (temp ^ temp >>> 32);
		result = prime * result + (statut == null ? 0 : statut.hashCode());
		result = prime * result + (typePC == null ? 0 : typePC.hashCode());
		result = prime * result
				+ (typePayement == null ? 0 : typePayement.hashCode());
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
		Reglement other = (Reglement) obj;
		if (badge == null) {
			if (other.badge != null) {
				return false;
			}
		} else if (!badge.equals(other.badge)) {
			return false;
		}
		if (categorie == null) {
			if (other.categorie != null) {
				return false;
			}
		} else if (!categorie.equals(other.categorie)) {
			return false;
		}
		if (dateReglement == null) {
			if (other.dateReglement != null) {
				return false;
			}
		} else if (!dateReglement.equals(other.dateReglement)) {
			return false;
		}
		if (description == null) {
			if (other.description != null) {
				return false;
			}
		} else if (!description.equals(other.description)) {
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
		if (majore == null) {
			if (other.majore != null) {
				return false;
			}
		} else if (!majore.equals(other.majore)) {
			return false;
		}
		if (Double.doubleToLongBits(montant) != Double
				.doubleToLongBits(other.montant)) {
			return false;
		}
		if (operateur == null) {
			if (other.operateur != null) {
				return false;
			}
		} else if (!operateur.equals(other.operateur)) {
			return false;
		}
		if (pcPersonnel == null) {
			if (other.pcPersonnel != null) {
				return false;
			}
		} else if (!pcPersonnel.equals(other.pcPersonnel)) {
			return false;
		}
		if (Double.doubleToLongBits(petitMonnaie) != Double
				.doubleToLongBits(other.petitMonnaie)) {
			return false;
		}
		if (priseEnCharge == null) {
			if (other.priseEnCharge != null) {
				return false;
			}
		} else if (!priseEnCharge.equals(other.priseEnCharge)) {
			return false;
		}
		if (reglementId == null) {
			if (other.reglementId != null) {
				return false;
			}
		} else if (!reglementId.equals(other.reglementId)) {
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
		if (typePC == null) {
			if (other.typePC != null) {
				return false;
			}
		} else if (!typePC.equals(other.typePC)) {
			return false;
		}
		if (typePayement == null) {
			if (other.typePayement != null) {
				return false;
			}
		} else if (!typePayement.equals(other.typePayement)) {
			return false;
		}
		return true;
	}

	@Override
	protected Reglement createEntity() {
		return new Reglement();
	}

	@Override
	public void updateWith(Reglement entity) {
		reglementId = entity.getReglementId();
		montant = entity.getMontant();
		dateReglement = entity.getDateReglement();
		statut = entity.getStatut();
		operateur = entity.getOperateur();
		description = entity.getDescription();
		petitMonnaie = entity.getPetitMonnaie();
		typePC = entity.getTypePC();
		remiseCash = entity.getRemiseCash();
		majore = entity.getMajore();

		EntityCopier<Categorie> cCopier = new EntityCopier<Categorie>();
		categorie = cCopier.copy(entity.getCategorie());
		EntityCopier<PcPersonnel> pCopier = new EntityCopier<PcPersonnel>();
		pcPersonnel = pCopier.copy(entity.getPcPersonnel());
		EntityCopier<TypePayement> tCopier = new EntityCopier<TypePayement>();
		typePayement = tCopier.copy(entity.getTypePayement());

		EntityCopier<Facture> fCopier = new EntityCopier<Facture>();
		facture = fCopier.copy(entity.getFacture());
		EntityCopier<PriseEnCharge> pcCopier = new EntityCopier<PriseEnCharge>();
		priseEnCharge = pcCopier.copy(entity.getPriseEnCharge());
		EntityCopier<Badge> bCopier = new EntityCopier<Badge>();
		badge = bCopier.copy(entity.getBadge());
		EntityCopier<DrgCnam> dCopier = new EntityCopier<DrgCnam>();
		drgCnam = dCopier.copy(entity.getDrgCnam());
	}

}
