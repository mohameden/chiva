package clinique.mapping;


public class Module extends Entity<Module> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -154707334238495013L;
	private int moduleId;
	private String nomModule;
	private String statut;
	private String operateur;

	public int getModuleId() {
		return moduleId;
	}

	public void setModuleId(int moduleId) {
		this.moduleId = moduleId;
	}

	public String getNomModule() {
		return nomModule;
	}

	public void setNomModule(String nomModule) {
		this.nomModule = nomModule;
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
		result = prime * result + moduleId;
		result = prime * result
				+ (nomModule == null ? 0 : nomModule.hashCode());
		result = prime * result
				+ (operateur == null ? 0 : operateur.hashCode());
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
		Module other = (Module) obj;
		if (moduleId != other.moduleId) {
			return false;
		}
		if (nomModule == null) {
			if (other.nomModule != null) {
				return false;
			}
		} else if (!nomModule.equals(other.nomModule)) {
			return false;
		}
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
		return true;
	}

	@Override
	protected Module createEntity() {
		return new Module();
	}

	@Override
	public void updateWith(Module entity) {
		moduleId = entity.getModuleId();
		nomModule = entity.getNomModule();
		statut = entity.getStatut();
		operateur = entity.getOperateur();
	}

}
