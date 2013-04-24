package clinique.mapping;






public class FactureGlobalFacture {
	
	private String factureGlobalFactureId;
	
	private FactureGlobal factureGlobal;
	private Facture facture;
	private  String statut;
	private  String operateur;
	
	
	public String getFactureGlobalFactureId() {
		return factureGlobalFactureId;
	}
	public void setFactureGlobalFactureId(String factureGlobalFactureId) {
		this.factureGlobalFactureId = factureGlobalFactureId;
	}
	public FactureGlobal getFactureGlobal() {
		return factureGlobal;
	}
	public void setFactureGlobal(FactureGlobal factureGlobal) {
		this.factureGlobal = factureGlobal;
	}
	public Facture getFacture() {
		return facture;
	}
	public void setFacture(Facture facture) {
		this.facture = facture;
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
