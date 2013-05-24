package clinique.mapping;

import java.util.Date;

public class DetailFactureModifiees extends Entity<DetailFactureModifiees> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5510277146542092768L;
	private String detailFactId;
	private String nomActe;
	private int nbrActes;
	private int urgenceActe;
	private int depl;
	private double prix;
	private double prixUrg;
	private double prixDepl;
	private String statut;
	private String operateur;
	private double montantTotal;
	private String type;
	private Recu recu;
	private Acte acte;
	private FactureModifiees facture;
	private Hospitalisation hospitalisation;
	private Acteur medecin;
	private Acteur infirmier;
	private String medecinExiste;
	private String infirmierExiste;
	private int qpActeur;
	private int qpAssistant;
	private double prixReel;
	private double coteClinique;
	private double coteCliniqueMajore;

	private Date dateDetail;

	public String getNomActe() {
		return nomActe;
	}

	public void setNomActe(String nomActe) {
		this.nomActe = nomActe;
	}

	public int getNbrActes() {
		return nbrActes;
	}

	public void setNbrActes(int nbrActes) {
		this.nbrActes = nbrActes;
	}

	public int getUrgenceActe() {
		return urgenceActe;
	}

	public void setUrgenceActe(int urgenceActe) {
		this.urgenceActe = urgenceActe;
	}

	public int getDepl() {
		return depl;
	}

	public void setDepl(int depl) {
		this.depl = depl;
	}

	public double getPrix() {
		return prix;
	}

	public void setPrix(double prix) {
		this.prix = prix;
	}

	public double getPrixUrg() {
		return prixUrg;
	}

	public void setPrixUrg(double prixUrg) {
		this.prixUrg = prixUrg;
	}

	public double getPrixDepl() {
		return prixDepl;
	}

	public void setPrixDepl(double prixDepl) {
		this.prixDepl = prixDepl;
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

	public Recu getRecu() {
		return recu;
	}

	public void setRecu(Recu recu) {
		this.recu = recu;
	}

	public Acte getActe() {
		return acte;
	}

	public void setActe(Acte acte) {
		this.acte = acte;
	}

	public Hospitalisation getHospitalisation() {
		return hospitalisation;
	}

	public void setHospitalisation(Hospitalisation hospitalisation) {
		this.hospitalisation = hospitalisation;
	}

	public double getMontantTotal() {
		return montantTotal;
	}

	public void setMontantTotal(double montantTotal) {
		this.montantTotal = montantTotal;
	}

	public String getDetailFactId() {
		return detailFactId;
	}

	public void setDetailFactId(String detailFactId) {
		this.detailFactId = detailFactId;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Acteur getMedecin() {
		return medecin;
	}

	public void setMedecin(Acteur medecin) {
		this.medecin = medecin;
	}

	public Acteur getInfirmier() {
		return infirmier;
	}

	public void setInfirmier(Acteur infirmier) {
		this.infirmier = infirmier;
	}

	public String getMedecinExiste() {
		return medecinExiste;
	}

	public void setMedecinExiste(String medecinExiste) {
		this.medecinExiste = medecinExiste;
	}

	public String getInfirmierExiste() {
		return infirmierExiste;
	}

	public void setInfirmierExiste(String infirmierExiste) {
		this.infirmierExiste = infirmierExiste;
	}

	public FactureModifiees getFacture() {
		return facture;
	}

	public void setFacture(FactureModifiees facture) {
		this.facture = facture;
	}

	public int getQpActeur() {
		return qpActeur;
	}

	public void setQpActeur(int qpActeur) {
		this.qpActeur = qpActeur;
	}

	public int getQpAssistant() {
		return qpAssistant;
	}

	public void setQpAssistant(int qpAssistant) {
		this.qpAssistant = qpAssistant;
	}

	public double getPrixReel() {
		return prixReel;
	}

	public void setPrixReel(double prixReel) {
		this.prixReel = prixReel;
	}

	public double getCoteClinique() {
		return coteClinique;
	}

	public void setCoteClinique(double coteClinique) {
		this.coteClinique = coteClinique;
	}

	public double getCoteCliniqueMajore() {
		return coteCliniqueMajore;
	}

	public void setCoteCliniqueMajore(double coteCliniqueMajore) {
		this.coteCliniqueMajore = coteCliniqueMajore;
	}

	public Date getDateDetail() {
		return dateDetail;
	}

	public void setDateDetail(Date dateDetail) {
		this.dateDetail = dateDetail;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (acte == null ? 0 : acte.hashCode());
		long temp;
		temp = Double.doubleToLongBits(coteClinique);
		result = prime * result + (int) (temp ^ temp >>> 32);
		temp = Double.doubleToLongBits(coteCliniqueMajore);
		result = prime * result + (int) (temp ^ temp >>> 32);
		result = prime * result
				+ (dateDetail == null ? 0 : dateDetail.hashCode());
		result = prime * result + depl;
		result = prime * result
				+ (detailFactId == null ? 0 : detailFactId.hashCode());
		result = prime * result + (facture == null ? 0 : facture.hashCode());
		result = prime * result
				+ (hospitalisation == null ? 0 : hospitalisation.hashCode());
		result = prime * result
				+ (infirmier == null ? 0 : infirmier.hashCode());
		result = prime * result
				+ (infirmierExiste == null ? 0 : infirmierExiste.hashCode());
		result = prime * result + (medecin == null ? 0 : medecin.hashCode());
		result = prime * result
				+ (medecinExiste == null ? 0 : medecinExiste.hashCode());
		temp = Double.doubleToLongBits(montantTotal);
		result = prime * result + (int) (temp ^ temp >>> 32);
		result = prime * result + nbrActes;
		result = prime * result + (nomActe == null ? 0 : nomActe.hashCode());
		result = prime * result
				+ (operateur == null ? 0 : operateur.hashCode());
		temp = Double.doubleToLongBits(prix);
		result = prime * result + (int) (temp ^ temp >>> 32);
		temp = Double.doubleToLongBits(prixDepl);
		result = prime * result + (int) (temp ^ temp >>> 32);
		temp = Double.doubleToLongBits(prixReel);
		result = prime * result + (int) (temp ^ temp >>> 32);
		temp = Double.doubleToLongBits(prixUrg);
		result = prime * result + (int) (temp ^ temp >>> 32);
		result = prime * result + qpActeur;
		result = prime * result + qpAssistant;
		result = prime * result + (recu == null ? 0 : recu.hashCode());
		result = prime * result + (statut == null ? 0 : statut.hashCode());
		result = prime * result + (type == null ? 0 : type.hashCode());
		result = prime * result + urgenceActe;
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
		DetailFactureModifiees other = (DetailFactureModifiees) obj;
		if (acte == null) {
			if (other.acte != null) {
				return false;
			}
		} else if (!acte.equals(other.acte)) {
			return false;
		}
		if (Double.doubleToLongBits(coteClinique) != Double
				.doubleToLongBits(other.coteClinique)) {
			return false;
		}
		if (Double.doubleToLongBits(coteCliniqueMajore) != Double
				.doubleToLongBits(other.coteCliniqueMajore)) {
			return false;
		}
		if (dateDetail == null) {
			if (other.dateDetail != null) {
				return false;
			}
		} else if (!dateDetail.equals(other.dateDetail)) {
			return false;
		}
		if (depl != other.depl) {
			return false;
		}
		if (detailFactId == null) {
			if (other.detailFactId != null) {
				return false;
			}
		} else if (!detailFactId.equals(other.detailFactId)) {
			return false;
		}
		if (facture == null) {
			if (other.facture != null) {
				return false;
			}
		} else if (!facture.equals(other.facture)) {
			return false;
		}
		if (hospitalisation == null) {
			if (other.hospitalisation != null) {
				return false;
			}
		} else if (!hospitalisation.equals(other.hospitalisation)) {
			return false;
		}
		if (infirmier == null) {
			if (other.infirmier != null) {
				return false;
			}
		} else if (!infirmier.equals(other.infirmier)) {
			return false;
		}
		if (infirmierExiste == null) {
			if (other.infirmierExiste != null) {
				return false;
			}
		} else if (!infirmierExiste.equals(other.infirmierExiste)) {
			return false;
		}
		if (medecin == null) {
			if (other.medecin != null) {
				return false;
			}
		} else if (!medecin.equals(other.medecin)) {
			return false;
		}
		if (medecinExiste == null) {
			if (other.medecinExiste != null) {
				return false;
			}
		} else if (!medecinExiste.equals(other.medecinExiste)) {
			return false;
		}
		if (Double.doubleToLongBits(montantTotal) != Double
				.doubleToLongBits(other.montantTotal)) {
			return false;
		}
		if (nbrActes != other.nbrActes) {
			return false;
		}
		if (nomActe == null) {
			if (other.nomActe != null) {
				return false;
			}
		} else if (!nomActe.equals(other.nomActe)) {
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
		if (Double.doubleToLongBits(prixDepl) != Double
				.doubleToLongBits(other.prixDepl)) {
			return false;
		}
		if (Double.doubleToLongBits(prixReel) != Double
				.doubleToLongBits(other.prixReel)) {
			return false;
		}
		if (Double.doubleToLongBits(prixUrg) != Double
				.doubleToLongBits(other.prixUrg)) {
			return false;
		}
		if (qpActeur != other.qpActeur) {
			return false;
		}
		if (qpAssistant != other.qpAssistant) {
			return false;
		}
		if (recu == null) {
			if (other.recu != null) {
				return false;
			}
		} else if (!recu.equals(other.recu)) {
			return false;
		}
		if (statut == null) {
			if (other.statut != null) {
				return false;
			}
		} else if (!statut.equals(other.statut)) {
			return false;
		}
		if (type == null) {
			if (other.type != null) {
				return false;
			}
		} else if (!type.equals(other.type)) {
			return false;
		}
		if (urgenceActe != other.urgenceActe) {
			return false;
		}
		return true;
	}

	@Override
	protected DetailFactureModifiees createEntity() {
		return new DetailFactureModifiees();
	}

	@Override
	public void updateWith(DetailFactureModifiees entity) {
		detailFactId = entity.getDetailFactId();
		nomActe = entity.getNomActe();
		nbrActes = entity.getNbrActes();
		urgenceActe = entity.getUrgenceActe();
		depl = entity.getDepl();
		prix = entity.getPrix();
		prixUrg = entity.getPrixUrg();
		prixDepl = entity.getPrixDepl();
		statut = entity.getStatut();
		operateur = entity.getOperateur();
		montantTotal = entity.getMontantTotal();
		type = entity.getType();
		EntityCopier<Recu> rCopier = new EntityCopier<Recu>();
		recu = rCopier.copy(entity.getRecu());
		EntityCopier<Acte> aCopier = new EntityCopier<Acte>();
		acte = aCopier.copy(entity.getActe());
		EntityCopier<FactureModifiees> fCopier = new EntityCopier<FactureModifiees>();
		facture = fCopier.copy(entity.getFacture());
		EntityCopier<Hospitalisation> hCopier = new EntityCopier<Hospitalisation>();
		hospitalisation = hCopier.copy(entity.getHospitalisation());
		EntityCopier<Acteur> acCopier = new EntityCopier<Acteur>();
		medecin = acCopier.copy(entity.getMedecin());
		infirmier = acCopier.copy(entity.getInfirmier());
		medecinExiste = entity.getMedecinExiste();
		infirmierExiste = entity.getInfirmierExiste();
		qpActeur = entity.getQpActeur();
		qpAssistant = entity.getQpAssistant();
		prixReel = entity.getPrixReel();
		coteClinique = entity.getCoteClinique();
		coteCliniqueMajore = entity.getCoteCliniqueMajore();
		dateDetail = entity.getDateDetail();
	}

}
