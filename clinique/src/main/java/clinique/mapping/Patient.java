package clinique.mapping;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import clinique.utils.UtilDate;

public class Patient {
	
	private  String patientId;
	private  String nom;
	private  String prenom;
	private  Date dateNaissance;
	private  String lieuNaissance;
	private  String telephone;
	private  String adresse;
	private  String cni;
	private  String nni;
	
	private  Date datePremiereViste;
	private  Date dateDerniereVisite;
	private  String statut;
	private  String operateur;
	
	private  Categorie categorie;
	
	private String priseEnChargeFlag;
	
	private List <Facture> factures=new ArrayList<Facture>();
	private List <PriseEnCharge> priseEnCharges=new ArrayList<PriseEnCharge>();
	private List <Hospitalisation> hospitalisations=new ArrayList<Hospitalisation>();
	private List <Badge> badges=new ArrayList<Badge>();

	
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getLieuNaissance() {
		return lieuNaissance;
	}
	
	public void setLieuNaissance(String lieuNaissance) {
		this.lieuNaissance = lieuNaissance;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	public String getCni() {
		return cni;
	}
	public void setCni(String cni) {
		this.cni = cni;
	}
	public String getNni() {
		return nni;
	}
	public void setNni(String nni) {
		this.nni = nni;
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
	public List<Facture> getFactures() {
		return factures;
	}
	public void setFactures(List<Facture> factures) {
		this.factures = factures;
	}
	public List<PriseEnCharge> getPriseEnCharges() {
		return priseEnCharges;
	}
	public void setPriseEnCharges(List<PriseEnCharge> priseEnCharges) {
		this.priseEnCharges = priseEnCharges;
	}
	public List<Hospitalisation> getHospitalisations() {
		return hospitalisations;
	}
	public void setHospitalisations(List<Hospitalisation> hospitalisations) {
		this.hospitalisations = hospitalisations;
	}
	public Date getDateNaissance() {
		return dateNaissance;
	}
	public void setDateNaissance(Date dateNaissance) {
		this.dateNaissance = dateNaissance;
	}
	public Date getDatePremiereViste() {
		return datePremiereViste;
	}
	public void setDatePremiereViste(Date datePremiereViste) {
		this.datePremiereViste = datePremiereViste;
	}
	public Date getDateDerniereVisite() {
		return dateDerniereVisite;
	}
	public void setDateDerniereVisite(Date dateDerniereVisite) {
		this.dateDerniereVisite = dateDerniereVisite;
	}
	public Categorie getCategorie() {
		return categorie;
	}
	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}
	public String getPatientId() {
		return patientId;
	}
	public void setPatientId(String patientId) {
		this.patientId = patientId;
	}

	public String getPriseEnChargeFlag() {
		return priseEnChargeFlag;
	}
	public void setPriseEnChargeFlag(String priseEnChargeFlag) {
		this.priseEnChargeFlag = priseEnChargeFlag;
	}
	public List<Badge> getBadges() {
		return badges;
	}
	public void setBadges(List<Badge> badges) {
		this.badges = badges;
	}
	
	
	
	/*public Badge getBadge()
	{
		Badge badge=null;
		
		if (!getBadges().isEmpty() && getBadges().size()!=0)
		{
			for (Iterator iter = getBadges().iterator(); iter.hasNext();) 
			{	
				Badge element = (Badge) iter.next();
				if (element.getStatut().equals("1")) 
				{
					if (badge!=null)
					{
						if (UtilDate.getInstance().date1AfterDate2(element.getDateDebut(), badge.getDateDebut()))
						badge=element;
					}
					else badge=element;
				}
			}
		}
		
		return badge;
	}*/
	
	
	
	

}
