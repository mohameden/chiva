package clinique.mapping;



public class PatientPcActuel {
	
	private  String patientPcActuelId;
	

	private  String statut;
	private  String operateur;
	
	private  Badge badge;
	private Patient patient;
	private PriseEnCharge priseEnCharge;
	private String type;
	
	
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
	public Badge getBadge() {
		return badge;
	}
	public void setBadge(Badge badge) {
		this.badge = badge;
	}
	public Patient getPatient() {
		return patient;
	}
	public void setPatient(Patient patient) {
		this.patient = patient;
	}
	public PriseEnCharge getPriseEnCharge() {
		return priseEnCharge;
	}
	public void setPriseEnCharge(PriseEnCharge priseEnCharge) {
		this.priseEnCharge = priseEnCharge;
	}
	public String getPatientPcActuelId() {
		return patientPcActuelId;
	}
	public void setPatientPcActuelId(String patientPcActuelId) {
		this.patientPcActuelId = patientPcActuelId;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}

	

}
