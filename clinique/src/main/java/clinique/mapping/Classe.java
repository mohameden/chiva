package clinique.mapping;

public class Classe extends Entity<Classe> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4268024907931330629L;
	private int classeId;
	private String nomClasse;
	private int qpc;
	private String statut;
	private String operateur;

	public int getClasseId() {
		return classeId;
	}

	public void setClasseId(int classeId) {
		this.classeId = classeId;
	}

	public String getNomClasse() {
		return nomClasse;
	}

	public void setNomClasse(String nomClasse) {
		this.nomClasse = nomClasse;
	}

	public int getQpc() {
		return qpc;
	}

	public void setQpc(int qpc) {
		this.qpc = qpc;
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
		result = prime * result + classeId;
		result = prime * result
				+ (nomClasse == null ? 0 : nomClasse.hashCode());
		result = prime * result
				+ (operateur == null ? 0 : operateur.hashCode());
		result = prime * result + qpc;
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
		Classe other = (Classe) obj;
		if (classeId != other.classeId) {
			return false;
		}
		if (nomClasse == null) {
			if (other.nomClasse != null) {
				return false;
			}
		} else if (!nomClasse.equals(other.nomClasse)) {
			return false;
		}
		if (operateur == null) {
			if (other.operateur != null) {
				return false;
			}
		} else if (!operateur.equals(other.operateur)) {
			return false;
		}
		if (qpc != other.qpc) {
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
	protected Classe createEntity() {
		return new Classe();
	}

	@Override
	public void updateWith(Classe entity) {
		classeId = entity.getClasseId();
		nomClasse = entity.getNomClasse();
		qpc = entity.getQpc();
		statut = entity.getStatut();
		operateur = entity.getOperateur();
	}

}
