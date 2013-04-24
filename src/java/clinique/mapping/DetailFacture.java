package clinique.mapping;

import java.util.Date;

public class DetailFacture {
	
	private  String detailFactId;
	private  String nomActe;
	private  int nbrActes;
	private  int urgenceActe;
	private  int depl;
	private  double prix;
	private  double prixUrg;
	private  double prixDepl;
	private  String statut;
	private  String operateur;
	private double montantTotal;
	private String type;
	private Recu recu;
	private Acte acte;
	private Facture facture;
	private Hospitalisation hospitalisation;
	private Acteur medecin;
	private Acteur infirmier;
	private String medecinExiste;
	private String infirmierExiste;
	
	private int qpActeur;
	private int qpAssistant;
	private double prixReel;
	private double coteClinique;
	private double coteCliniqueMajore;
	
	private Date dateDetail;

	
	public String getNomActe() {
		return nomActe;
	}
	public void setNomActe(String nomActe) {
		this.nomActe = nomActe;
	}
	public int getNbrActes() {
		return nbrActes;
	}
	public void setNbrActes(int nbrActes) {
		this.nbrActes = nbrActes;
	}
	public int getUrgenceActe() {
		return urgenceActe;
	}
	public void setUrgenceActe(int urgenceActe) {
		this.urgenceActe = urgenceActe;
	}
	public int getDepl() {
		return depl;
	}
	public void setDepl(int depl) {
		this.depl = depl;
	}
	public double getPrix() {
		return prix;
	}
	public void setPrix(double prix) {
		this.prix = prix;
	}
	public double getPrixUrg() {
		return prixUrg;
	}
	public void setPrixUrg(double prixUrg) {
		this.prixUrg = prixUrg;
	}
	public double getPrixDepl() {
		return prixDepl;
	}
	public void setPrixDepl(double prixDepl) {
		this.prixDepl = prixDepl;
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

	public Recu getRecu() {
		return recu;
	}
	public void setRecu(Recu recu) {
		this.recu = recu;
	}
	public Acte getActe() {
		return acte;
	}
	public void setActe(Acte acte) {
		this.acte = acte;
	}
	public Hospitalisation getHospitalisation() {
		return hospitalisation;
	}
	public void setHospitalisation(Hospitalisation hospitalisation) {
		this.hospitalisation = hospitalisation;
	}
	public double getMontantTotal() {
		return montantTotal;
	}
	public void setMontantTotal(double montantTotal) {
		this.montantTotal = montantTotal;
	}
	public String getDetailFactId() {
		return detailFactId;
	}
	public void setDetailFactId(String detailFactId) {
		this.detailFactId = detailFactId;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Facture getFacture() {
		return facture;
	}
	public void setFacture(Facture facture) {
		this.facture = facture;
	}
	public Acteur getMedecin() {
		return medecin;
	}
	public void setMedecin(Acteur medecin) {
		this.medecin = medecin;
	}
	public Acteur getInfirmier() {
		return infirmier;
	}
	public void setInfirmier(Acteur infirmier) {
		this.infirmier = infirmier;
	}
	public String getMedecinExiste() {
		return medecinExiste;
	}
	public void setMedecinExiste(String medecinExiste) {
		this.medecinExiste = medecinExiste;
	}
	public String getInfirmierExiste() {
		return infirmierExiste;
	}
	public void setInfirmierExiste(String infirmierExiste) {
		this.infirmierExiste = infirmierExiste;
	}
	public int getQpActeur() {
		return qpActeur;
	}
	public void setQpActeur(int qpActeur) {
		this.qpActeur = qpActeur;
	}
	public int getQpAssistant() {
		return qpAssistant;
	}
	public void setQpAssistant(int qpAssistant) {
		this.qpAssistant = qpAssistant;
	}
	public double getPrixReel() {
		return prixReel;
	}
	public void setPrixReel(double prixReel) {
		this.prixReel = prixReel;
	}
	public double getCoteClinique() {
		return coteClinique;
	}
	public void setCoteClinique(double coteClinique) {
		this.coteClinique = coteClinique;
	}
	public double getCoteCliniqueMajore() {
		return coteCliniqueMajore;
	}
	public void setCoteCliniqueMajore(double coteCliniqueMajore) {
		this.coteCliniqueMajore = coteCliniqueMajore;
	}
	public Date getDateDetail() {
		return dateDetail;
	}
	public void setDateDetail(Date dateDetail) {
		this.dateDetail = dateDetail;
	}

	


}
