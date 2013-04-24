package clinique.mapping;


public class Menu {
	
	private  int menuId;
	private  String nomMenu;
	private  String fonctionnalite;
	private  String statut;
	private  String operateur;
	
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

}
