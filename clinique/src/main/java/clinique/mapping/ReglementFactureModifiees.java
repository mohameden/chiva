package clinique.mapping;

import java.util.Date;

public class ReglementFactureModifiees extends
		Entity<ReglementFactureModifiees> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6583285173052297413L;
	private String reglementId;
	private double montant;
	private Date dateReglement;
	private String statut;
	private String operateur;
	private String description;
	private double petitMonnaie = 0;
	private String typePC = "";

	private FactureModifiees facture;
	private TypePayement typePayement;
	private PcPersonnel pcPersonnel;
	private Categorie categorie;
	private PriseEnCharge priseEnCharge;
	private Badge badge;
	private PriseEnChargeModifiee priseEnChargeM;

	public String getReglementId() {
		return reglementId;
	}

	public void setReglementId(String reglementId) {
		this.reglementId = reglementId;
	}

	public double getMontant() {
		return montant;
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

	public FactureModifiees getFacture() {
		return facture;
	}

	public void setFacture(FactureModifiees facture) {
		this.facture = facture;
	}

	public PriseEnChargeModifiee getPriseEnChargeM() {
		return priseEnChargeM;
	}

	public void setPriseEnChargeM(PriseEnChargeModifiee priseEnChargeM) {
		this.priseEnChargeM = priseEnChargeM;
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
		result = prime * result + (facture == null ? 0 : facture.hashCode());
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
				+ (priseEnChargeM == null ? 0 : priseEnChargeM.hashCode());
		result = prime * result
				+ (reglementId == null ? 0 : reglementId.hashCode());
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
		ReglementFactureModifiees other = (ReglementFactureModifiees) obj;
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
		if (facture == null) {
			if (other.facture != null) {
				return false;
			}
		} else if (!facture.equals(other.facture)) {
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
		if (priseEnChargeM == null) {
			if (other.priseEnChargeM != null) {
				return false;
			}
		} else if (!priseEnChargeM.equals(other.priseEnChargeM)) {
			return false;
		}
		if (reglementId == null) {
			if (other.reglementId != null) {
				return false;
			}
		} else if (!reglementId.equals(other.reglementId)) {
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
	protected ReglementFactureModifiees createEntity() {
		return new ReglementFactureModifiees();
	}

	@Override
	public void updateWith(ReglementFactureModifiees entity) {
		reglementId = entity.getReglementId();
		montant = entity.getMontant();
		dateReglement = entity.getDateReglement();
		statut = entity.getStatut();
		operateur = entity.getOperateur();
		description = entity.getDescription();
		petitMonnaie = entity.getPetitMonnaie();
		typePC = entity.getTypePC();
		EntityCopier<Categorie> cCopier = new EntityCopier<Categorie>();
		categorie = cCopier.copy(entity.getCategorie());
		EntityCopier<PcPersonnel> pCopier = new EntityCopier<PcPersonnel>();
		pcPersonnel = pCopier.copy(entity.getPcPersonnel());
		EntityCopier<TypePayement> tCopier = new EntityCopier<TypePayement>();
		typePayement = tCopier.copy(entity.getTypePayement());

		EntityCopier<FactureModifiees> fCopier = new EntityCopier<FactureModifiees>();
		facture = fCopier.copy(entity.getFacture());
		EntityCopier<PriseEnCharge> pcCopier = new EntityCopier<PriseEnCharge>();
		priseEnCharge = pcCopier.copy(entity.getPriseEnCharge());
		EntityCopier<Badge> bCopier = new EntityCopier<Badge>();
		badge = bCopier.copy(entity.getBadge());
		EntityCopier<PriseEnChargeModifiee> pcmCopier = new EntityCopier<PriseEnChargeModifiee>();
		priseEnChargeM = pcmCopier.copy(entity.getPriseEnChargeM());
	}

}
