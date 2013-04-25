package clinique.mapping;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class FactureModifiees {
	
	private  String factureModifieeId;
	private  String numFact;
	private  Date dateFact;
	private  double totalHT;
	private  double remise;
	private  double majoration;
	private  double avance;
	private  double netApayer ;
	private  String statut;
	private  String operateur;
	private Date dateModification;
	
	private double totalTva;
	private double qpc;
	private int tauxRemise;
	private String isException;
	private String typePc;
	
	private double totalReglementPc=0;
	
    private Facture facture;
	private Badge badge;
	private PriseEnCharge priseEnCharge;
	private Patient patient;
	private String isHospitalisation;
	private PriseEnChargeModifiee priseEnChargeM;
	
	
    
	private List <ReglementFactureModifiees> reglements=new ArrayList<ReglementFactureModifiees>();
	
	private List <DetailFactureModifiees> detailFactures=new ArrayList<DetailFactureModifiees>();
   
	public String getNumFact() {
		return numFact;
	}
	public void setNumFact(String numFact) {
		this.numFact = numFact;
	}
	

	public double getAvance() {
		return avance;
	}
	public void setAvance(double avance) {
		this.avance = avance;
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
	public Patient getPatient() {
		return patient;
	}
	public void setPatient(Patient patient) {
		this.patient = patient;
	}
	
	
	public double getMajoration() {
		return majoration;
	}
	public void setMajoration(double majoration) {
		this.majoration = majoration;
	}

	public double getTotalHT() {
		return totalHT;
	}
	public void setTotalHT(double totalHT) {
		this.totalHT = totalHT;
	}

	public double getQpc() {
		return qpc;
	}
	public void setQpc(double qpc) {
		this.qpc = qpc;
	}
	public double getRemise() {
		return remise;
	}
	public String getIsException() {
		return isException;
	}
	public void setIsException(String isException) {
		this.isException = isException;
	}
	public void setRemise(double remise) {
		this.remise = remise;
	}

	public double getNetApayer() {
		return netApayer;
	}
	public void setNetApayer(double netApayer) {
		this.netApayer = netApayer;
	}
	public double getTotalTva() {
		return totalTva;
	}
	public void setTotalTva(double totalTva) {
		this.totalTva = totalTva;
	}
	public int getTauxRemise() {
		return tauxRemise;
	}
	public void setTauxRemise(int tauxRemise) {
		this.tauxRemise = tauxRemise;
	}
	public Date getDateFact() {
		return dateFact;
	}
	public void setDateFact(Date dateFact) {
		this.dateFact = dateFact;
	}
	public String getTypePc() {
		return typePc;
	}
	public void setTypePc(String typePc) {
		this.typePc = typePc;
	}
	
	public String getFactureModifieeId() {
		return factureModifieeId;
	}
	public void setFactureModifieeId(String factureModifieeId) {
		this.factureModifieeId = factureModifieeId;
	}
	public List<ReglementFactureModifiees> getReglements() {
		return reglements;
	}
	public void setReglements(List<ReglementFactureModifiees> reglements) {
		this.reglements = reglements;
	}
	public List<DetailFactureModifiees> getDetailFactures() {
		return detailFactures;
	}
	public void setDetailFactures(List<DetailFactureModifiees> detailFactures) {
		this.detailFactures = detailFactures;
	}
	public Facture getFacture() {
		return facture;
	}
	public void setFacture(Facture facture) {
		this.facture = facture;
	}
	public double getTotalReglementPc() {
		return totalReglementPc;
	}
	public void setTotalReglementPc(double totalReglementPc) {
		this.totalReglementPc = totalReglementPc;
	}
	public Date getDateModification() {
		return dateModification;
	}
	public void setDateModification(Date dateModification) {
		this.dateModification = dateModification;
	}
	
	public Badge getBadge() {
		return badge;
	}
	public void setBadge(Badge badge) {
		this.badge = badge;
	}
	public PriseEnCharge getPriseEnCharge() {
		return priseEnCharge;
	}
	public void setPriseEnCharge(PriseEnCharge priseEnCharge) {
		this.priseEnCharge = priseEnCharge;
	}
	public String getIsHospitalisation() {
		return isHospitalisation;
	}
	public void setIsHospitalisation(String isHospitalisation) {
		this.isHospitalisation = isHospitalisation;
	}
	public PriseEnChargeModifiee getPriseEnChargeM() {
		return priseEnChargeM;
	}
	public void setPriseEnChargeM(PriseEnChargeModifiee priseEnChargeM) {
		this.priseEnChargeM = priseEnChargeM;
	}
	
	

}
