package clinique.mapping;

import java.util.Date;

public class Acte extends Entity<Acte> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4655277180920655599L;
	private int acteId;
	private String nomActe;
	private double prix;
	private double prixUrg;
	private double prixDepl;
	private int pck;
	private String coef;
	private int tauxPraticien;
	private int tauxAssistant;
	private int tauxPraticienUrg;
	private int tauxAssistantUrg;
	private int tauxDepAssistant;
	private String statut;
	private String operateur;
	private String reductible;
	private Date dateDebut;
	private Date dateFin;

	private Classe classe;
	private FamillePrestation famillePrestation;

	public int getActeId() {
		return acteId;
	}

	public void setActeId(int acteId) {
		this.acteId = acteId;
	}

	public String getNomActe() {
		return nomActe;
	}

	public void setNomActe(String nomActe) {
		this.nomActe = nomActe;
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

	public int getPck() {
		return pck;
	}

	public void setPck(int pck) {
		this.pck = pck;
	}

	public int getTauxPraticien() {
		return tauxPraticien;
	}

	public void setTauxPraticien(int tauxPraticien) {
		this.tauxPraticien = tauxPraticien;
	}

	public int getTauxAssistant() {
		return tauxAssistant;
	}

	public void setTauxAssistant(int tauxAssistant) {
		this.tauxAssistant = tauxAssistant;
	}

	public int getTauxPraticienUrg() {
		return tauxPraticienUrg;
	}

	public void setTauxPraticienUrg(int tauxPraticienUrg) {
		this.tauxPraticienUrg = tauxPraticienUrg;
	}

	public int getTauxAssistantUrg() {
		return tauxAssistantUrg;
	}

	public void setTauxAssistantUrg(int tauxAssistantUrg) {
		this.tauxAssistantUrg = tauxAssistantUrg;
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

	public Classe getClasse() {
		return classe;
	}

	public void setClasse(Classe classe) {
		this.classe = classe;
	}

	public FamillePrestation getFamillePrestation() {
		return famillePrestation;
	}

	public void setFamillePrestation(FamillePrestation famillePrestation) {
		this.famillePrestation = famillePrestation;
	}

	public int getTauxDepAssistant() {
		return tauxDepAssistant;
	}

	public void setTauxDepAssistant(int tauxDepAssistant) {
		this.tauxDepAssistant = tauxDepAssistant;
	}

	public String getReductible() {
		return reductible;
	}

	public void setReductible(String reductible) {
		this.reductible = reductible;
	}

	public String getCoef() {
		return coef;
	}

	public void setCoef(String coef) {
		this.coef = coef;
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
		result = prime * result + acteId;
		result = prime * result + (classe == null ? 0 : classe.hashCode());
		result = prime * result + (coef == null ? 0 : coef.hashCode());
		result = prime * result
				+ (dateDebut == null ? 0 : dateDebut.hashCode());
		result = prime * result + (dateFin == null ? 0 : dateFin.hashCode());
		result = prime
				* result
				+ (famillePrestation == null ? 0 : famillePrestation.hashCode());
		result = prime * result + (nomActe == null ? 0 : nomActe.hashCode());
		result = prime * result
				+ (operateur == null ? 0 : operateur.hashCode());
		result = prime * result + pck;
		long temp;
		temp = Double.doubleToLongBits(prix);
		result = prime * result + (int) (temp ^ temp >>> 32);
		temp = Double.doubleToLongBits(prixDepl);
		result = prime * result + (int) (temp ^ temp >>> 32);
		temp = Double.doubleToLongBits(prixUrg);
		result = prime * result + (int) (temp ^ temp >>> 32);
		result = prime * result
				+ (reductible == null ? 0 : reductible.hashCode());
		result = prime * result + (statut == null ? 0 : statut.hashCode());
		result = prime * result + tauxAssistant;
		result = prime * result + tauxAssistantUrg;
		result = prime * result + tauxDepAssistant;
		result = prime * result + tauxPraticien;
		result = prime * result + tauxPraticienUrg;
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
		Acte other = (Acte) obj;
		if (acteId != other.acteId) {
			return false;
		}
		if (classe == null) {
			if (other.classe != null) {
				return false;
			}
		} else if (!classe.equals(other.classe)) {
			return false;
		}
		if (coef == null) {
			if (other.coef != null) {
				return false;
			}
		} else if (!coef.equals(other.coef)) {
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
		if (famillePrestation == null) {
			if (other.famillePrestation != null) {
				return false;
			}
		} else if (!famillePrestation.equals(other.famillePrestation)) {
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
		if (pck != other.pck) {
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
		if (Double.doubleToLongBits(prixUrg) != Double
				.doubleToLongBits(other.prixUrg)) {
			return false;
		}
		if (reductible == null) {
			if (other.reductible != null) {
				return false;
			}
		} else if (!reductible.equals(other.reductible)) {
			return false;
		}
		if (statut == null) {
			if (other.statut != null) {
				return false;
			}
		} else if (!statut.equals(other.statut)) {
			return false;
		}
		if (tauxAssistant != other.tauxAssistant) {
			return false;
		}
		if (tauxAssistantUrg != other.tauxAssistantUrg) {
			return false;
		}
		if (tauxDepAssistant != other.tauxDepAssistant) {
			return false;
		}
		if (tauxPraticien != other.tauxPraticien) {
			return false;
		}
		if (tauxPraticienUrg != other.tauxPraticienUrg) {
			return false;
		}
		return true;
	}

	@Override
	protected Acte createEntity() {
		return new Acte();
	}

	@Override
	public void updateWith(Acte entity) {

		acteId = entity.getActeId();
		nomActe = entity.getNomActe();
		prix = entity.getPrix();
		prixUrg = entity.getPrixUrg();
		prixDepl = entity.getPrixDepl();
		pck = entity.getPck();
		coef = entity.getCoef();
		tauxPraticien = entity.getTauxPraticien();
		tauxAssistant = entity.getTauxAssistant();
		tauxPraticienUrg = entity.getTauxPraticienUrg();
		tauxAssistantUrg = entity.getTauxAssistantUrg();
		tauxDepAssistant = entity.getTauxDepAssistant();
		statut = entity.getStatut();
		operateur = entity.getOperateur();
		reductible = entity.getReductible();
		dateDebut = entity.getDateDebut();
		dateFin = entity.getDateFin();
		EntityCopier<Classe> classeCopier = new EntityCopier<Classe>();
		classe = classeCopier.copy(entity.getClasse());
		EntityCopier<FamillePrestation> fpCopier = new EntityCopier<FamillePrestation>();
		famillePrestation = fpCopier.copy(entity.getFamillePrestation());
	}
}
