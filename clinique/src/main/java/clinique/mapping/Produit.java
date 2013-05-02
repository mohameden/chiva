package clinique.mapping;

public class Produit extends Entity {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7715442303516597019L;
	private int produitId;
	private String nomProduit;
	private String facturable;
	private double prix;
	private int quantiteDisponible;
	private int seuilMinimum;
	private String statut;
	private String operateur;

	private Classe classe;
	private Acte acte;

	public int getProduitId() {
		return produitId;
	}

	public void setProduitId(int produitId) {
		this.produitId = produitId;
	}

	public String getNomProduit() {
		return nomProduit;
	}

	public void setNomProduit(String nomProduit) {
		this.nomProduit = nomProduit;
	}

	public double getPrix() {
		return prix;
	}

	public String getFacturable() {
		return facturable;
	}

	public void setFacturable(String facturable) {
		this.facturable = facturable;
	}

	public void setPrix(double prix) {
		this.prix = prix;
	}

	public int getQuantiteDisponible() {
		return quantiteDisponible;
	}

	public void setQuantiteDisponible(int quantiteDisponible) {
		this.quantiteDisponible = quantiteDisponible;
	}

	public int getSeuilMinimum() {
		return seuilMinimum;
	}

	public void setSeuilMinimum(int seuilMinimum) {
		this.seuilMinimum = seuilMinimum;
	}

	public Classe getClasse() {
		return classe;
	}

	public void setClasse(Classe classe) {
		this.classe = classe;
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (acte == null ? 0 : acte.hashCode());
		result = prime * result + (classe == null ? 0 : classe.hashCode());
		result = prime * result
				+ (facturable == null ? 0 : facturable.hashCode());
		result = prime * result
				+ (nomProduit == null ? 0 : nomProduit.hashCode());
		result = prime * result
				+ (operateur == null ? 0 : operateur.hashCode());
		long temp;
		temp = Double.doubleToLongBits(prix);
		result = prime * result + (int) (temp ^ temp >>> 32);
		result = prime * result + produitId;
		result = prime * result + quantiteDisponible;
		result = prime * result + seuilMinimum;
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
		Produit other = (Produit) obj;
		if (acte == null) {
			if (other.acte != null) {
				return false;
			}
		} else if (!acte.equals(other.acte)) {
			return false;
		}
		if (classe == null) {
			if (other.classe != null) {
				return false;
			}
		} else if (!classe.equals(other.classe)) {
			return false;
		}
		if (facturable == null) {
			if (other.facturable != null) {
				return false;
			}
		} else if (!facturable.equals(other.facturable)) {
			return false;
		}
		if (nomProduit == null) {
			if (other.nomProduit != null) {
				return false;
			}
		} else if (!nomProduit.equals(other.nomProduit)) {
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
		if (produitId != other.produitId) {
			return false;
		}
		if (quantiteDisponible != other.quantiteDisponible) {
			return false;
		}
		if (seuilMinimum != other.seuilMinimum) {
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

}
