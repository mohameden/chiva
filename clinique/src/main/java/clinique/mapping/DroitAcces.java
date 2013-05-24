package clinique.mapping;

public class DroitAcces extends Entity<DroitAcces> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6081619779213405935L;
	private int dAccId;
	private String statut;
	private String operateur;

	private Profil profil;
	private Menu menu;

	public int getdAccId() {
		return dAccId;
	}

	public void setdAccId(int dAccId) {
		this.dAccId = dAccId;
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

	public Profil getProfil() {
		return profil;
	}

	public void setProfil(Profil profil) {
		this.profil = profil;
	}

	public Menu getMenu() {
		return menu;
	}

	public void setMenu(Menu menu) {
		this.menu = menu;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + dAccId;
		result = prime * result + (menu == null ? 0 : menu.hashCode());
		result = prime * result
				+ (operateur == null ? 0 : operateur.hashCode());
		result = prime * result + (profil == null ? 0 : profil.hashCode());
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
		DroitAcces other = (DroitAcces) obj;
		if (dAccId != other.dAccId) {
			return false;
		}
		if (menu == null) {
			if (other.menu != null) {
				return false;
			}
		} else if (!menu.equals(other.menu)) {
			return false;
		}
		if (operateur == null) {
			if (other.operateur != null) {
				return false;
			}
		} else if (!operateur.equals(other.operateur)) {
			return false;
		}
		if (profil == null) {
			if (other.profil != null) {
				return false;
			}
		} else if (!profil.equals(other.profil)) {
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
	protected DroitAcces createEntity() {
		return new DroitAcces();
	}

	@Override
	public void updateWith(DroitAcces entity) {
		dAccId = entity.getdAccId();
		statut = entity.getStatut();
		operateur = entity.getOperateur();
		EntityCopier<Profil> aCopier = new EntityCopier<Profil>();
		profil = aCopier.copy(entity.getProfil());
		EntityCopier<Menu> mCopier = new EntityCopier<Menu>();
		menu = mCopier.copy(entity.getMenu());
	}

}
