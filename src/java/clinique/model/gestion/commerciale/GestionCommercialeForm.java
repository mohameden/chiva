package clinique.model.gestion.commerciale;

import java.util.ArrayList;

import java.util.List;

import org.apache.struts.action.ActionForm;

import clinique.mapping.Badge;
import clinique.mapping.Facture;
import clinique.mapping.Hospitalisation;
import clinique.mapping.Patient;
import clinique.mapping.PrestationCouvertesPc;
import clinique.mapping.PriseEnCharge;
import clinique.mapping.Recu;



public class GestionCommercialeForm extends ActionForm {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String typePatient="nouveau";
	private  String patientId="";
	private  String nom="";
	private  String prenom="";
	private  String dateNaissance="";
	private  String lieuNaissance="";
	private  String telephone="";
	private  String adresse="";
	private  String cni="";
	private  String nni="";
	private  String numeroBadge="";
	private  String datePremiereVisite="";
	private  String dateDerniereVisite="";
	private  String statut="";
	private  String operateur="";
	private String dispatch;
	
	private  String patientIdR="";
	private  String nomR="";
	private  String prenomR="";
	private  String dateNaissanceR="";
	private  String lieuNaissanceR="";
	private  String telephoneR="";
	private  String adresseR="";
	private  String cniR="";
	private  String nniR="";
	private  String numeroBadgeR="";
	private  String datePremiereVisiteR="";
	private  String dateDerniereVisiteR="";
	private String avanceChoix="non";
	private String avance="0";
	
	
	
	
	@SuppressWarnings("unchecked")
	private List patients=new ArrayList();
	@SuppressWarnings("unchecked")
	private List famillesPrestList=new ArrayList();
	@SuppressWarnings("unchecked")
	private List classesListe=new ArrayList();
	@SuppressWarnings("unchecked")
	private List actesListe=new ArrayList();;
	@SuppressWarnings("unchecked")
	private List acteurActeList=new ArrayList();
	
	
	@SuppressWarnings("unchecked")
	private List detailsFactureList=new ArrayList();
	
	@SuppressWarnings("unchecked")
	private List detailDrgCnamListFacture=new ArrayList();
	
	@SuppressWarnings("unchecked")
	private List assureurListe=new ArrayList();
	@SuppressWarnings("unchecked")
	private List entrepriseList=new ArrayList();
	@SuppressWarnings("unchecked")
	private List categorieList=new ArrayList();
	@SuppressWarnings("unchecked")
	private List acteurActeInfList=new ArrayList();
	
	private String factureId="";
	
	private String acteurActeIdInf;
	private String assureurId;
	private String entrepriseId;
	private String categorieId;
	private String famillePrestationId;
	private String classeId;
	private String acteId;
	private String acteurActeId;
	private String typeActe="normal";
	private String nombreActe="1";
	
	private  String nomActe;
	private  double montantTotal;
	private  int remise=0;
	private  double montantPaye;
	private String login="Tolba";
	private String logoPath;
	private String reportsPath;
	private  int urgenceActe;
	private  double totalReglement;
	private String  recuId="";
    
	private String totalApayer="0";
	private String coteClinique="0";
	private String dejapaye="0";
	private String resteApayer="0";
	private String coteAssureur="0";
	private String priseEnChargeFlag="aucune";
	private String numPC="";
	private String plafond="";
	private String pourcentage="";
	private String nombreActesPC="";
	private String dateCreation="";
	private String finValidite="";
	private String typePcCouverte="famille";
	@SuppressWarnings("unchecked")
	private  List prestationCouvertesPcs=new ArrayList();
	private String pcId="";
	private String idPrestAsupprimer="";
	private String remiseFlag="oui";
	private String remiseValeur;
	private String remiseMontant="0";
	private String typePayementId;
	@SuppressWarnings("unchecked")
	private List typePayementList=new ArrayList();
	private String typePayementValeur;
	private String choixActePar="famille";
	private String infirmierChoix="non";
	private String medecinChoix="non";
	private String coteCliniqueReductible="0";
	
	@SuppressWarnings("unchecked")
	private List pcPersonnelList=new ArrayList();
	private String pcPersonnelId;
	private String description;
	
	@SuppressWarnings("unchecked")
	private List reglementsList=new ArrayList();
	private String idReglementAsupprimer;
	private PriseEnCharge priseEnCharge=new PriseEnCharge();
	private Patient patient=new Patient();
	private String resteApayerMajoration="0";
	private String recuRegle="0";
	private String majorationCoef="0";
	private String nomAssureur;
	private String nomEntreprise;
	private String nomCategorie;
	private String operation="";
	
	@SuppressWarnings("unchecked")
	private List chambreList=new ArrayList();
	private String chambreId;
	private String dateEntree="";
	@SuppressWarnings("unchecked")
	private List hopitalises=new ArrayList();
	private String dateEntreeChambre="";
	private String chambreActuelle="";
	private Hospitalisation hospitalisation=new Hospitalisation();
    private String hospitalisaionId="";
    private Facture facture;
    private String dateSortie="";
    private Recu recu;
    private String heureHosp;
    @SuppressWarnings("unchecked")
	private List chambresHospList=new ArrayList();
    
    @SuppressWarnings("unchecked")
	private List facturesAgenererList=new ArrayList();
   
    private String profil;
    private String subAction;
    
    private String aRendre="0";
    private String rendu="0";
    
    private String nomProfil="";
    
    private Badge badge;
    
	private String libeleAssureur;
	private String drgCnamId;
	@SuppressWarnings("unchecked")
	private List drgCnamListe=new ArrayList();
	
	@SuppressWarnings("unchecked")
	private List detailsFactureModifieesList=new ArrayList();
	@SuppressWarnings("unchecked")
	private List facturesAmodifierList=new ArrayList();
	
	private String dateDebutRechFact;
	private String dateFinRechFact;
	private String isFirst="true";
	private String factureModifieeId;
	private String isHospitalisation="0";
	private String actesLimite="oui";
	
	private String idDetailDrgAsupprimer;
	
	@SuppressWarnings("unchecked")
	private List devisActesList=new ArrayList();
	
	@SuppressWarnings("unchecked")
	private List devisList=new ArrayList();
	
	private String totalDevis="0";
	private String totalMontantDrg="0";
	private String modeReglement="immediat";
	private String cashDejaSaisi="0";
	
	@SuppressWarnings("unchecked")
	private List facturesAimprimerList=new ArrayList();
	
	
	@SuppressWarnings("unchecked")
	private List devisAimprimerList=new ArrayList();
	
	private String devisAssureurId;
	
	private String typeSortie;

	public Patient getPatient() {
		return patient;
	}
	public void setPatient(Patient patient) {
		this.patient = patient;
	}
	public String getTypePatient() {
		return typePatient;
	}
	public void setTypePatient(String typePatient) {
		this.typePatient = typePatient;
	}
	public String getPatientId() {
		return patientId;
	}
	public void setPatientId(String patientId) {
		this.patientId = patientId;
	}
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
	public String getDateNaissance() {
		return dateNaissance;
	}
	public void setDateNaissance(String dateNaissance) {
		this.dateNaissance = dateNaissance;
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
	public String getNumeroBadge() {
		return numeroBadge;
	}
	public void setNumeroBadge(String numeroBadge) {
		this.numeroBadge = numeroBadge;
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
	@SuppressWarnings("unchecked")
	public List getPatients() {
		return patients;
	}
	@SuppressWarnings("unchecked")
	public void setPatients(List patients) {
		this.patients = patients;
	}
	public String getDispatch() {
		return dispatch;
	}
	public void setDispatch(String dispatch) {
		this.dispatch = dispatch;
	}
	public String getPatientIdR() {
		return patientIdR;
	}
	public void setPatientIdR(String patientIdR) {
		this.patientIdR = patientIdR;
	}
	public String getNomR() {
		return nomR;
	}
	public void setNomR(String nomR) {
		this.nomR = nomR;
	}
	public String getPrenomR() {
		return prenomR;
	}
	public void setPrenomR(String prenomR) {
		this.prenomR = prenomR;
	}
	public String getDateNaissanceR() {
		return dateNaissanceR;
	}
	public void setDateNaissanceR(String dateNaissanceR) {
		this.dateNaissanceR = dateNaissanceR;
	}
	public String getLieuNaissanceR() {
		return lieuNaissanceR;
	}
	public void setLieuNaissanceR(String lieuNaissanceR) {
		this.lieuNaissanceR = lieuNaissanceR;
	}
	public String getTelephoneR() {
		return telephoneR;
	}
	public void setTelephoneR(String telephoneR) {
		this.telephoneR = telephoneR;
	}
	public String getAdresseR() {
		return adresseR;
	}
	public void setAdresseR(String adresseR) {
		this.adresseR = adresseR;
	}
	public String getCniR() {
		return cniR;
	}
	public void setCniR(String cniR) {
		this.cniR = cniR;
	}
	public String getNniR() {
		return nniR;
	}
	public void setNniR(String nniR) {
		this.nniR = nniR;
	}
	public String getNumeroBadgeR() {
		return numeroBadgeR;
	}
	public void setNumeroBadgeR(String numeroBadgeR) {
		this.numeroBadgeR = numeroBadgeR;
	}
	public String getDatePremiereVisite() {
		return datePremiereVisite;
	}
	public void setDatePremiereVisite(String datePremiereVisite) {
		this.datePremiereVisite = datePremiereVisite;
	}
	public String getDateDerniereVisite() {
		return dateDerniereVisite;
	}
	public void setDateDerniereVisite(String dateDerniereVisite) {
		this.dateDerniereVisite = dateDerniereVisite;
	}
	public String getDatePremiereVisiteR() {
		return datePremiereVisiteR;
	}
	public void setDatePremiereVisiteR(String datePremiereVisiteR) {
		this.datePremiereVisiteR = datePremiereVisiteR;
	}
	public String getDateDerniereVisiteR() {
		return dateDerniereVisiteR;
	}
	public void setDateDerniereVisiteR(String dateDerniereVisiteR) {
		this.dateDerniereVisiteR = dateDerniereVisiteR;
	}
	
	@SuppressWarnings("unchecked")
	public List getClassesListe() {
		return classesListe;
	}
	@SuppressWarnings("unchecked")
	public void setClassesListe(List classesListe) {
		this.classesListe = classesListe;
	}
	@SuppressWarnings("unchecked")
	public List getActesListe() {
		return actesListe;
	}
	@SuppressWarnings("unchecked")
	public void setActesListe(List actesListe) {
		this.actesListe = actesListe;
	}
	
	public String getClasseId() {
		return classeId;
	}
	public void setClasseId(String classeId) {
		this.classeId = classeId;
	}
	public String getActeId() {
		return acteId;
	}
	public void setActeId(String acteId) {
		this.acteId = acteId;
	}
	@SuppressWarnings("unchecked")
	public List getFamillesPrestList() {
		return famillesPrestList;
	}
	@SuppressWarnings("unchecked")
	public void setFamillesPrestList(List famillesPrestList) {
		this.famillesPrestList = famillesPrestList;
	}
	
	public String getActeurActeId() {
		return acteurActeId;
	}
	public void setActeurActeId(String acteurActeId) {
		this.acteurActeId = acteurActeId;
	}
	@SuppressWarnings("unchecked")
	public List getActeurActeList() {
		return acteurActeList;
	}
	@SuppressWarnings("unchecked")
	public void setActeurActeList(List acteurActeList) {
		this.acteurActeList = acteurActeList;
	}
	
	public String getNombreActe() {
		return nombreActe;
	}
	public void setNombreActe(String nombreActe) {
		this.nombreActe = nombreActe;
	}
	public String getTypeActe() {
		return typeActe;
	}
	public void setTypeActe(String typeActe) {
		this.typeActe = typeActe;
	}
	public String getNomActe() {
		return nomActe;
	}
	public void setNomActe(String nomActe) {
		this.nomActe = nomActe;
	}
	public double getMontantTotal() {
		return montantTotal;
	}
	public void setMontantTotal(double montantTotal) {
		this.montantTotal = montantTotal;
	}
	
	public int getRemise() {
		return remise;
	}
	public void setRemise(int remise) {
		this.remise = remise;
	}
	public double getMontantPaye() {
		return montantPaye;
	}
	public void setMontantPaye(double montantPaye) {
		this.montantPaye = montantPaye;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getLogoPath() {
		return logoPath;
	}
	public void setLogoPath(String logoPath) {
		this.logoPath = logoPath;
	}
	public String getReportsPath() {
		return reportsPath;
	}
	public void setReportsPath(String reportsPath) {
		this.reportsPath = reportsPath;
	}
	public int getUrgenceActe() {
		return urgenceActe;
	}
	public void setUrgenceActe(int urgenceActe) {
		this.urgenceActe = urgenceActe;
	}
	public double getTotalReglement() {
		return totalReglement;
	}
	public void setTotalReglement(double totalReglement) {
		this.totalReglement = totalReglement;
	}
	
	public String getFactureId() {
		return factureId;
	}
	public void setFactureId(String factureId) {
		this.factureId = factureId;
	}
	public String getRecuId() {
		return recuId;
	}
	public void setRecuId(String recuId) {
		this.recuId = recuId;
	}
	@SuppressWarnings("unchecked")
	public List getAssureurListe() {
		return assureurListe;
	}
	@SuppressWarnings("unchecked")
	public void setAssureurListe(List assureurListe) {
		this.assureurListe = assureurListe;
	}
	@SuppressWarnings("unchecked")
	public List getEntrepriseList() {
		return entrepriseList;
	}
	@SuppressWarnings("unchecked")
	public void setEntrepriseList(List entrepriseList) {
		this.entrepriseList = entrepriseList;
	}
	@SuppressWarnings("unchecked")
	public List getCategorieList() {
		return categorieList;
	}
	@SuppressWarnings("unchecked")
	public void setCategorieList(List categorieList) {
		this.categorieList = categorieList;
	}
	public String getAssureurId() {
		return assureurId;
	}
	public void setAssureurId(String assureurId) {
		this.assureurId = assureurId;
	}
	public String getEntrepriseId() {
		return entrepriseId;
	}
	public void setEntrepriseId(String entrepriseId) {
		this.entrepriseId = entrepriseId;
	}
	public String getCategorieId() {
		return categorieId;
	}
	public void setCategorieId(String categorieId) {
		this.categorieId = categorieId;
	}
	@SuppressWarnings("unchecked")
	public List getActeurActeInfList() {
		return acteurActeInfList;
	}
	@SuppressWarnings("unchecked")
	public void setActeurActeInfList(List acteurActeInfList) {
		this.acteurActeInfList = acteurActeInfList;
	}
	public String getActeurActeIdInf() {
		return acteurActeIdInf;
	}
	public void setActeurActeIdInf(String acteurActeIdInf) {
		this.acteurActeIdInf = acteurActeIdInf;
	}
	@SuppressWarnings("unchecked")
	public List getDetailsFactureList() {
		return detailsFactureList;
	}
	@SuppressWarnings("unchecked")
	public void setDetailsFactureList(List detailsFactureList) {
		this.detailsFactureList = detailsFactureList;
	}
	public String getTotalApayer() {
		return totalApayer;
	}
	public void setTotalApayer(String totalApayer) {
		this.totalApayer = totalApayer;
	}
	public String getCoteClinique() {
		return coteClinique;
	}
	public void setCoteClinique(String coteClinique) {
		this.coteClinique = coteClinique;
	}
	public String getDejapaye() {
		return dejapaye;
	}
	public void setDejapaye(String dejapaye) {
		this.dejapaye = dejapaye;
	}
	public String getResteApayer() {
		return resteApayer;
	}
	public void setResteApayer(String resteApayer) {
		this.resteApayer = resteApayer;
	}
	public String getCoteAssureur() {
		return coteAssureur;
	}
	public void setCoteAssureur(String coteAssureur) {
		this.coteAssureur = coteAssureur;
	}
	public String getPriseEnChargeFlag() {
		return priseEnChargeFlag;
	}
	public void setPriseEnChargeFlag(String priseEnChargeFlag) {
		this.priseEnChargeFlag = priseEnChargeFlag;
	}
	public String getNumPC() {
		return numPC;
	}
	public void setNumPC(String numPC) {
		this.numPC = numPC;
	}
	public String getPlafond() {
		return plafond;
	}
	public void setPlafond(String plafond) {
		this.plafond = plafond;
	}
	public String getPourcentage() {
		return pourcentage;
	}
	public void setPourcentage(String pourcentage) {
		this.pourcentage = pourcentage;
	}

	public String getDateCreation() {
		return dateCreation;
	}
	public void setDateCreation(String dateCreation) {
		this.dateCreation = dateCreation;
	}
	public String getFinValidite() {
		return finValidite;
	}
	public void setFinValidite(String finValidite) {
		this.finValidite = finValidite;
	}
	public String getTypePcCouverte() {
		return typePcCouverte;
	}
	public void setTypePcCouverte(String typePcCouverte) {
		this.typePcCouverte = typePcCouverte;
	}
	
	public String getPcId() {
		return pcId;
	}
	public void setPcId(String pcId) {
		this.pcId = pcId;
	}
	@SuppressWarnings("unchecked")
	public List getPrestationCouvertesPcs() {
		return prestationCouvertesPcs;
	}
	@SuppressWarnings("unchecked")
	public void setPrestationCouvertesPcs(List prestationCouvertesPcs) {
		this.prestationCouvertesPcs = prestationCouvertesPcs;
	}
	public String getIdPrestAsupprimer() {
		return idPrestAsupprimer;
	}
	public void setIdPrestAsupprimer(String idPrestAsupprimer) {
		this.idPrestAsupprimer = idPrestAsupprimer;
	}
	public String getNombreActesPC() {
		return nombreActesPC;
	}
	public void setNombreActesPC(String nombreActesPC) {
		this.nombreActesPC = nombreActesPC;
	}
	public String getRemiseFlag() {
		return remiseFlag;
	}
	public void setRemiseFlag(String remiseFlag) {
		this.remiseFlag = remiseFlag;
	}
	public String getRemiseValeur() {
		return remiseValeur;
	}
	public void setRemiseValeur(String remiseValeur) {
		this.remiseValeur = remiseValeur;
	}
	public String getRemiseMontant() {
		return remiseMontant;
	}
	public void setRemiseMontant(String remiseMontant) {
		this.remiseMontant = remiseMontant;
	}
	public String getTypePayementId() {
		return typePayementId;
	}
	public void setTypePayementId(String typePayementId) {
		this.typePayementId = typePayementId;
	}
	public List getTypePayementList() {
		return typePayementList;
	}
	public void setTypePayementList(List typePayementList) {
		this.typePayementList = typePayementList;
	}
	public String getTypePayementValeur() {
		return typePayementValeur;
	}
	public void setTypePayementValeur(String typePayementValeur) {
		this.typePayementValeur = typePayementValeur;
	}
	public String getFamillePrestationId() {
		return famillePrestationId;
	}
	public void setFamillePrestationId(String famillePrestationId) {
		this.famillePrestationId = famillePrestationId;
	}
	public String getChoixActePar() {
		return choixActePar;
	}
	public void setChoixActePar(String choixActePar) {
		this.choixActePar = choixActePar;
	}
	public String getInfirmierChoix() {
		return infirmierChoix;
	}
	public void setInfirmierChoix(String infirmierChoix) {
		this.infirmierChoix = infirmierChoix;
	}
	public String getMedecinChoix() {
		return medecinChoix;
	}
	public void setMedecinChoix(String medecinChoix) {
		this.medecinChoix = medecinChoix;
	}
	public String getCoteCliniqueReductible() {
		return coteCliniqueReductible;
	}
	public void setCoteCliniqueReductible(String coteCliniqueReductible) {
		this.coteCliniqueReductible = coteCliniqueReductible;
	}
	public List getPcPersonnelList() {
		return pcPersonnelList;
	}
	public void setPcPersonnelList(List pcPersonnelList) {
		this.pcPersonnelList = pcPersonnelList;
	}
	public String getPcPersonnelId() {
		return pcPersonnelId;
	}
	public void setPcPersonnelId(String pcPersonnelId) {
		this.pcPersonnelId = pcPersonnelId;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public List getReglementsList() {
		return reglementsList;
	}
	public void setReglementsList(List reglementsList) {
		this.reglementsList = reglementsList;
	}
	public String getIdReglementAsupprimer() {
		return idReglementAsupprimer;
	}
	public void setIdReglementAsupprimer(String idReglementAsupprimer) {
		this.idReglementAsupprimer = idReglementAsupprimer;
	}
	public PriseEnCharge getPriseEnCharge() {
		return priseEnCharge;
	}
	public void setPriseEnCharge(PriseEnCharge priseEnCharge) {
		this.priseEnCharge = priseEnCharge;
	}
	public String getResteApayerMajoration() {
		return resteApayerMajoration;
	}
	public void setResteApayerMajoration(String resteApayerMajoration) {
		this.resteApayerMajoration = resteApayerMajoration;
	}
	public String getRecuRegle() {
		return recuRegle;
	}
	public void setRecuRegle(String recuRegle) {
		this.recuRegle = recuRegle;
	}
	public String getMajorationCoef() {
		return majorationCoef;
	}
	public void setMajorationCoef(String majorationCoef) {
		this.majorationCoef = majorationCoef;
	}
	public String getNomAssureur() {
		return nomAssureur;
	}
	public void setNomAssureur(String nomAssureur) {
		this.nomAssureur = nomAssureur;
	}
	public String getNomEntreprise() {
		return nomEntreprise;
	}
	public void setNomEntreprise(String nomEntreprise) {
		this.nomEntreprise = nomEntreprise;
	}
	public String getNomCategorie() {
		return nomCategorie;
	}
	public void setNomCategorie(String nomCategorie) {
		this.nomCategorie = nomCategorie;
	}
	public String getOperation() {
		return operation;
	}
	public void setOperation(String operation) {
		this.operation = operation;
	}
	public String getAvanceChoix() {
		return avanceChoix;
	}
	public void setAvanceChoix(String avanceChoix) {
		this.avanceChoix = avanceChoix;
	}
	public String getAvance() {
		return avance;
	}
	public void setAvance(String avance) {
		this.avance = avance;
	}
	public List getChambreList() {
		return chambreList;
	}
	public void setChambreList(List chambreList) {
		this.chambreList = chambreList;
	}
	public String getChambreId() {
		return chambreId;
	}
	public void setChambreId(String chambreId) {
		this.chambreId = chambreId;
	}
	public String getDateEntree() {
		return dateEntree;
	}
	public void setDateEntree(String dateEntree) {
		this.dateEntree = dateEntree;
	}
	public List getHopitalises() {
		return hopitalises;
	}
	public void setHopitalises(List hopitalises) {
		this.hopitalises = hopitalises;
	}
	public String getDateEntreeChambre() {
		return dateEntreeChambre;
	}
	public void setDateEntreeChambre(String dateEntreeChambre) {
		this.dateEntreeChambre = dateEntreeChambre;
	}
	public String getChambreActuelle() {
		return chambreActuelle;
	}
	public void setChambreActuelle(String chambreActuelle) {
		this.chambreActuelle = chambreActuelle;
	}
	public Hospitalisation getHospitalisation() {
		return hospitalisation;
	}
	public void setHospitalisation(Hospitalisation hospitalisation) {
		this.hospitalisation = hospitalisation;
	}
	public String getHospitalisaionId() {
		return hospitalisaionId;
	}
	public void setHospitalisaionId(String hospitalisaionId) {
		this.hospitalisaionId = hospitalisaionId;
	}
	public Facture getFacture() {
		return facture;
	}
	public void setFacture(Facture facture) {
		this.facture = facture;
	}
	public String getDateSortie() {
		return dateSortie;
	}
	public void setDateSortie(String dateSortie) {
		this.dateSortie = dateSortie;
	}
	public Recu getRecu() {
		return recu;
	}
	public void setRecu(Recu recu) {
		this.recu = recu;
	}
	public String getHeureHosp() {
		return heureHosp;
	}
	public void setHeureHosp(String heureHosp) {
		this.heureHosp = heureHosp;
	}
	public List getChambresHospList() {
		return chambresHospList;
	}
	public void setChambresHospList(List chambresHospList) {
		this.chambresHospList = chambresHospList;
	}
	public String getaRendre() {
		return aRendre;
	}
	public void setaRendre(String aRendre) {
		this.aRendre = aRendre;
	}
	public String getRendu() {
		return rendu;
	}
	public void setRendu(String rendu) {
		this.rendu = rendu;
	}
	public String getNomProfil() {
		return nomProfil;
	}
	public void setNomProfil(String nomProfil) {
		this.nomProfil = nomProfil;
	}

	public String getProfil() {
		return profil;
	}
	public void setProfil(String profil) {
		this.profil = profil;
	}
	public String getSubAction() {
		return subAction;
	}
	public void setSubAction(String subAction) {
		this.subAction = subAction;
	}
	public List getFacturesAgenererList() {
		return facturesAgenererList;
	}
	public void setFacturesAgenererList(List facturesAgenererList) {
		this.facturesAgenererList = facturesAgenererList;
	}
	public Badge getBadge() {
		return badge;
	}
	public void setBadge(Badge badge) {
		this.badge = badge;
	}
	public String getLibeleAssureur() {
		return libeleAssureur;
	}
	public String getDrgCnamId() {
		return drgCnamId;
	}
	public void setDrgCnamId(String drgCnamId) {
		this.drgCnamId = drgCnamId;
	}
	
	public void setLibeleAssureur(String libeleAssureur) {
		this.libeleAssureur = libeleAssureur;
	}
	public List getDrgCnamListe() {
		return drgCnamListe;
	}
	public void setDrgCnamListe(List drgCnamListe) {
		this.drgCnamListe = drgCnamListe;
	}
	public String getDateDebutRechFact() {
		return dateDebutRechFact;
	}
	public void setDateDebutRechFact(String dateDebutRechFact) {
		this.dateDebutRechFact = dateDebutRechFact;
	}
	public String getDateFinRechFact() {
		return dateFinRechFact;
	}
	public void setDateFinRechFact(String dateFinRechFact) {
		this.dateFinRechFact = dateFinRechFact;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public String getIsFirst() {
		return isFirst;
	}
	public void setIsFirst(String isFirst) {
		this.isFirst = isFirst;
	}
	public List getDetailsFactureModifieesList() {
		return detailsFactureModifieesList;
	}
	public void setDetailsFactureModifieesList(List detailsFactureModifieesList) {
		this.detailsFactureModifieesList = detailsFactureModifieesList;
	}
	public List getFacturesAmodifierList() {
		return facturesAmodifierList;
	}
	public void setFacturesAmodifierList(List facturesAmodifierList) {
		this.facturesAmodifierList = facturesAmodifierList;
	}
	public String getFactureModifieeId() {
		return factureModifieeId;
	}
	public void setFactureModifieeId(String factureModifieeId) {
		this.factureModifieeId = factureModifieeId;
	}
	public String getIsHospitalisation() {
		return isHospitalisation;
	}
	public List getDevisActesList() {
		return devisActesList;
	}
	public void setDevisActesList(List devisActesList) {
		this.devisActesList = devisActesList;
	}
	public void setIsHospitalisation(String isHospitalisation) {
		this.isHospitalisation = isHospitalisation;
	}
	public String getTotalDevis() {
		return totalDevis;
	}
	public void setTotalDevis(String totalDevis) {
		this.totalDevis = totalDevis;
	}
	public List getDevisList() {
		return devisList;
	}
	public void setDevisList(List devisList) {
		this.devisList = devisList;
	}
	public String getActesLimite() {
		return actesLimite;
	}
	public void setActesLimite(String actesLimite) {
		this.actesLimite = actesLimite;
	}
	public List getDetailDrgCnamListFacture() {
		return detailDrgCnamListFacture;
	}
	public void setDetailDrgCnamListFacture(List detailDrgCnamListFacture) {
		this.detailDrgCnamListFacture = detailDrgCnamListFacture;
	}
	public String getIdDetailDrgAsupprimer() {
		return idDetailDrgAsupprimer;
	}
	public void setIdDetailDrgAsupprimer(String idDetailDrgAsupprimer) {
		this.idDetailDrgAsupprimer = idDetailDrgAsupprimer;
	}
	public String getTotalMontantDrg() {
		return totalMontantDrg;
	}
	public void setTotalMontantDrg(String totalMontantDrg) {
		this.totalMontantDrg = totalMontantDrg;
	}
	public String getModeReglement() {
		return modeReglement;
	}
	public void setModeReglement(String modeReglement) {
		this.modeReglement = modeReglement;
	}
	public String getCashDejaSaisi() {
		return cashDejaSaisi;
	}
	public void setCashDejaSaisi(String cashDejaSaisi) {
		this.cashDejaSaisi = cashDejaSaisi;
	}
	public List getFacturesAimprimerList() {
		return facturesAimprimerList;
	}
	public void setFacturesAimprimerList(List facturesAimprimerList) {
		this.facturesAimprimerList = facturesAimprimerList;
	}
	public List getDevisAimprimerList() {
		return devisAimprimerList;
	}
	public void setDevisAimprimerList(List devisAimprimerList) {
		this.devisAimprimerList = devisAimprimerList;
	}
	public String getDevisAssureurId() {
		return devisAssureurId;
	}
	public void setDevisAssureurId(String devisAssureurId) {
		this.devisAssureurId = devisAssureurId;
	}
	public String getTypeSortie() {
		return typeSortie;
	}
	public void setTypeSortie(String typeSortie) {
		this.typeSortie = typeSortie;
	}
	
	
	

	

}
