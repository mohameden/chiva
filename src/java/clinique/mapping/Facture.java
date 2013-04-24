package clinique.mapping;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Facture {
	
	private  String factureId;
	private  String numFact;
	private  Date dateFact;
	private  double totalHT;
	private  double remise;
	private  double majoration;
	private  double avance;
	private  double netApayer ;
	private  String statut;
	private  String operateur;
	
	private double totalTva;
	private double qpc;
	private int tauxRemise=0;
	private int tauxMajoration;
	private double remiseCash;
	private String isException;
	private String typePc;
	
	private Badge badge;
	private PriseEnCharge priseEnCharge;
	private String isHospitalisation;
	private double totalReglementPc=0;
	
	
	private Patient patient;
    
	private List <Reglement> reglements=new ArrayList<Reglement>();
	private List <Recu> recus=new ArrayList<Recu>();
	private List <DetailFacture> detailFactures=new ArrayList<DetailFacture>();
   
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
	public List<Reglement> getReglements() {
		return reglements;
	}
	public void setReglements(List<Reglement> reglements) {
		this.reglements = reglements;
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
	public List<Recu> getRecus() {
		return recus;
	}
	public void setRecus(List<Recu> recus) {
		this.recus = recus;
	}

	public String getFactureId() {
		return factureId;
	}
	public void setFactureId(String factureId) {
		this.factureId = factureId;
	}
	public List<DetailFacture> getDetailFactures() {
		return detailFactures;
	}
	public void setDetailFactures(List<DetailFacture> detailFactures) {
		this.detailFactures = detailFactures;
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
	public double getTotalReglementPc() {
		return totalReglementPc;
	}
	public void setTotalReglementPc(double totalReglementPc) {
		this.totalReglementPc = totalReglementPc;
	}
	public int getTauxMajoration() {
		return tauxMajoration;
	}
	public void setTauxMajoration(int tauxMajoration) {
		this.tauxMajoration = tauxMajoration;
	}
	public double getRemiseCash() {
		return remiseCash;
	}
	public void setRemiseCash(double remiseCash) {
		this.remiseCash = remiseCash;
	}
	
	

}
