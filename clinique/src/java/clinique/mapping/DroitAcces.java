package clinique.mapping;

public class DroitAcces {
	
	private  int dAccId;
	private  String statut;
	private  String operateur;
	
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
	
	


}
