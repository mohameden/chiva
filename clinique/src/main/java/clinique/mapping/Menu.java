package clinique.mapping;

public class Menu extends Entity<Menu> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2864399105859361617L;
	private int menuId;
	private String nomMenu;
	private String fonctionnalite;
	private String statut;
	private String operateur;

	private Module module;

	public int getMenuId() {
		return menuId;
	}

	public void setMenuId(int menuId) {
		this.menuId = menuId;
	}

	public String getNomMenu() {
		return nomMenu;
	}

	public Module getModule() {
		return module;
	}

	public void setModule(Module module) {
		this.module = module;
	}

	public void setNomMenu(String nomMenu) {
		this.nomMenu = nomMenu;
	}

	public String getFonctionnalite() {
		return fonctionnalite;
	}

	public void setFonctionnalite(String fonctionnalite) {
		this.fonctionnalite = fonctionnalite;
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
				+ (fonctionnalite == null ? 0 : fonctionnalite.hashCode());
		result = prime * result + menuId;
		result = prime * result + (module == null ? 0 : module.hashCode());
		result = prime * result + (nomMenu == null ? 0 : nomMenu.hashCode());
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
		Menu other = (Menu) obj;
		if (fonctionnalite == null) {
			if (other.fonctionnalite != null) {
				return false;
			}
		} else if (!fonctionnalite.equals(other.fonctionnalite)) {
			return false;
		}
		if (menuId != other.menuId) {
			return false;
		}
		if (module == null) {
			if (other.module != null) {
				return false;
			}
		} else if (!module.equals(other.module)) {
			return false;
		}
		if (nomMenu == null) {
			if (other.nomMenu != null) {
				return false;
			}
		} else if (!nomMenu.equals(other.nomMenu)) {
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
	protected Menu createEntity() {
		return new Menu();
	}

	@Override
	public void updateWith(Menu entity) {
		menuId = entity.getMenuId();
		nomMenu = entity.getNomMenu();
		fonctionnalite = entity.getFonctionnalite();
		statut = entity.getStatut();
		operateur = entity.getOperateur();
		module = entity.getModule();
	}

}
