package clinique.mapping;

public class Fournisseur {
	
	private  int fournisseurId ;
	private  String nomFournisseur;
	private  String adresse;
	private  int telephone1 ;
	private  int telephone2 ;
	private  String statut ;
	private  String operateur ;
	
	public int getFournisseurId() {
		return fournisseurId;
	}
	public void setFournisseurId(int fournisseurId) {
		this.fournisseurId = fournisseurId;
	}
	public String getNomFournisseur() {
		return nomFournisseur;
	}
	public void setNomFournisseur(String nomFournisseur) {
		this.nomFournisseur = nomFournisseur;
	}
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	public int getTelephone1() {
		return telephone1;
	}
	public void setTelephone1(int telephone1) {
		this.telephone1 = telephone1;
	}
	public int getTelephone2() {
		return telephone2;
	}
	public void setTelephone2(int telephone2) {
		this.telephone2 = telephone2;
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
