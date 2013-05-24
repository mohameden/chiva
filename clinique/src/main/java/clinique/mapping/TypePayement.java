package clinique.mapping;


public class TypePayement extends Entity<TypePayement> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5980355282673436013L;
	private int typePayementId;
	private String typePayement;
	private String statut;
	private String operateur;

	public int getTypePayementId() {
		return typePayementId;
	}

	public void setTypePayementId(int typePayementId) {
		this.typePayementId = typePayementId;
	}

	public String getTypePayement() {
		return typePayement;
	}

	public void setTypePayement(String typePayement) {
		this.typePayement = typePayement;
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ (operateur == null ? 0 : operateur.hashCode());
		result = prime * result + (statut == null ? 0 : statut.hashCode());
		result = prime * result
				+ (typePayement == null ? 0 : typePayement.hashCode());
		result = prime * result + typePayementId;
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
		TypePayement other = (TypePayement) obj;
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
		if (typePayement == null) {
			if (other.typePayement != null) {
				return false;
			}
		} else if (!typePayement.equals(other.typePayement)) {
			return false;
		}
		if (typePayementId != other.typePayementId) {
			return false;
		}
		return true;
	}

	@Override
	protected TypePayement createEntity() {
		return new TypePayement();
	}

	@Override
	public void updateWith(TypePayement entity) {
		typePayementId = entity.getTypePayementId();
		typePayement = entity.getTypePayement();
		statut = entity.getStatut();
		operateur = entity.getOperateur();
	}

}
