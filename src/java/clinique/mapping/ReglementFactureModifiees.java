package clinique.mapping;

import java.util.Date;

public class ReglementFactureModifiees {
	
	private  String reglementId;
	private  double montant;
	private  Date dateReglement;
	private  String statut;
	private  String operateur;
	private String description;
	private double petitMonnaie=0;
	private String typePC="";
	
	
	private FactureModifiees facture;
	private TypePayement typePayement;
	private PcPersonnel pcPersonnel;
	private Categorie categorie;
	private PriseEnCharge priseEnCharge;
	private Badge badge;
	private PriseEnChargeModifiee priseEnChargeM;
	

	
	public String getReglementId() {
		return reglementId;
	}
	public void setReglementId(String reglementId) {
		this.reglementId = reglementId;
	}
	public double getMontant() {
		return montant;
	}

	public void setMontant(double montant) {
		this.montant = montant;
	}
	public Date getDateReglement() {
		return dateReglement;
	}
	public void setDateReglement(Date dateReglement) {
		this.dateReglement = dateReglement;
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
	public TypePayement getTypePayement() {
		return typePayement;
	}
	public void setTypePayement(TypePayement typePayement) {
		this.typePayement = typePayement;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public double getPetitMonnaie() {
		return petitMonnaie;
	}
	public void setPetitMonnaie(double petitMonnaie) {
		this.petitMonnaie = petitMonnaie;
	}
	public String getTypePC() {
		return typePC;
	}
	public void setTypePC(String typePC) {
		this.typePC = typePC;
	}
	public PcPersonnel getPcPersonnel() {
		return pcPersonnel;
	}
	public void setPcPersonnel(PcPersonnel pcPersonnel) {
		this.pcPersonnel = pcPersonnel;
	}
	public Categorie getCategorie() {
		return categorie;
	}
	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}
	public PriseEnCharge getPriseEnCharge() {
		return priseEnCharge;
	}
	public void setPriseEnCharge(PriseEnCharge priseEnCharge) {
		this.priseEnCharge = priseEnCharge;
	}
	public Badge getBadge() {
		return badge;
	}
	public void setBadge(Badge badge) {
		this.badge = badge;
	}
	public FactureModifiees getFacture() {
		return facture;
	}
	public void setFacture(FactureModifiees facture) {
		this.facture = facture;
	}
	public PriseEnChargeModifiee getPriseEnChargeM() {
		return priseEnChargeM;
	}
	public void setPriseEnChargeM(PriseEnChargeModifiee priseEnChargeM) {
		this.priseEnChargeM = priseEnChargeM;
	}
	

	
	


}
