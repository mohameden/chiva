package clinique.model.gestion.commerciale;

import java.util.ArrayList;
import java.util.List;

import org.apache.struts.action.ActionForm;

import clinique.mapping.Badge;
import clinique.mapping.ChambresHospitalisation;
import clinique.mapping.DetailFacture;
import clinique.mapping.DetailFactureModifiees;
import clinique.mapping.DevisActes;
import clinique.mapping.DevisAssureur;
import clinique.mapping.DrgCnam;
import clinique.mapping.Entity.EntityCopier;
import clinique.mapping.Facture;
import clinique.mapping.FactureModifiees;
import clinique.mapping.Hospitalisation;
import clinique.mapping.Patient;
import clinique.mapping.PrestationCouvertesPc;
import clinique.mapping.PriseEnCharge;
import clinique.mapping.Recu;
import clinique.mapping.Reglement;

public class GestionCommercialeForm extends ActionForm {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	private String acteId;
	private String actesLimite = "oui";
	@SuppressWarnings("unchecked")
	private List actesListe = new ArrayList();
	private String acteurActeId;
	private String acteurActeIdInf;
	@SuppressWarnings("unchecked")
	private List acteurActeInfList = new ArrayList();
	@SuppressWarnings("unchecked")
	private List acteurActeList = new ArrayList();
	private String adresse = "";
	private String adresseR = "";
	private String aRendre = "0";
	private String assureurId;
	@SuppressWarnings("unchecked")
	private List assureurListe = new ArrayList();
	private String avance = "0";
	private String avanceChoix = "non";
	private Badge badge;

	private String cashDejaSaisi = "0";
	private String categorieId;
	@SuppressWarnings("unchecked")
	private List categorieList = new ArrayList();
	private String chambreActuelle = "";
	private String chambreId;
	@SuppressWarnings("unchecked")
	private List chambreList = new ArrayList();
	@SuppressWarnings("unchecked")
	private List chambresHospList = new ArrayList();
	private String choixActePar = "famille";
	private String classeId;
	@SuppressWarnings("unchecked")
	private List classesListe = new ArrayList();
	private String cni = "";
	private String cniR = "";
	private String coteAssureur = "0";
	private String coteClinique = "0";

	private String coteCliniqueReductible = "0";
	private String dateCreation = "";
	private String dateDebutRechFact;
	private String dateDerniereVisite = "";;
	private String dateDerniereVisiteR = "";

	private String dateEntree = "";

	private String dateEntreeChambre = "";

	private String dateFinRechFact;
	private String dateNaissance = "";
	private String dateNaissanceR = "";
	private String datePremiereVisite = "";

	private String datePremiereVisiteR = "";

	private String dateSortie = "";
	private String dejapaye = "0";
	private String description;
	@SuppressWarnings("unchecked")
	private List detailDrgCnamListFacture = new ArrayList();
	@SuppressWarnings("unchecked")
	private List detailsFactureList = new ArrayList();
	@SuppressWarnings("unchecked")
	private List detailsFactureModifieesList = new ArrayList();
	@SuppressWarnings("unchecked")
	private List devisActesList = new ArrayList();
	@SuppressWarnings("unchecked")
	private List devisAimprimerList = new ArrayList();
	private String devisAssureurId;
	@SuppressWarnings("unchecked")
	private List devisList = new ArrayList();

	private String dispatch;
	private String drgCnamId;
	@SuppressWarnings("unchecked")
	private List drgCnamListe = new ArrayList();
	private String entrepriseId;
	@SuppressWarnings("unchecked")
	private List entrepriseList = new ArrayList();
	private Facture facture;
	private String factureId = "";
	private String factureModifieeId;
	@SuppressWarnings("unchecked")
	private List facturesAgenererList = new ArrayList();
	@SuppressWarnings("unchecked")
	private List facturesAimprimerList = new ArrayList();

	@SuppressWarnings("unchecked")
	private List facturesAmodifierList = new ArrayList();
	private String famillePrestationId;
	@SuppressWarnings("unchecked")
	private List famillesPrestList = new ArrayList();
	private String finValidite = "";
	private String heureHosp;
	@SuppressWarnings("unchecked")
	private List hopitalises = new ArrayList();
	private String hospitalisaionId = "";
	private Hospitalisation hospitalisation = new Hospitalisation();
	private String idDetailDrgAsupprimer;
	private String idPrestAsupprimer = "";
	private String idReglementAsupprimer;
	private String infirmierChoix = "non";
	private String isFirst = "true";
	private String isHospitalisation = "0";
	private String libeleAssureur;
	private String lieuNaissance = "";
	private String lieuNaissanceR = "";
	private String login = "Tolba";
	private String logoPath;
	private String majorationCoef = "0";
	private String medecinChoix = "non";
	private String modeReglement = "immediat";
	private double montantPaye;
	private double montantTotal;
	private String nni = "";
	private String nniR = "";

	private String nom = "";
	private String nomActe;
	private String nomAssureur;

	private String nombreActe = "1";
	private String nombreActesPC = "";
	private String nomCategorie;
	private String nomEntreprise;
	private String nomProfil = "";
	private String nomR = "";
	private String numeroBadge = "";
	private String numeroBadgeR = "";
	private String numPC = "";
	private String operateur = "";
	private String operation = "";

	private Patient patient = new Patient();
	private String patientId = "";
	private String patientIdR = "";
	@SuppressWarnings("unchecked")
	private List patients = new ArrayList();
	private String pcId = "";
	private String pcPersonnelId;
	@SuppressWarnings("unchecked")
	private List pcPersonnelList = new ArrayList();
	private String plafond = "";
	private String pourcentage = "";
	private String prenom = "";
	private String prenomR = "";
	@SuppressWarnings("unchecked")
	private List prestationCouvertesPcs = new ArrayList();
	private PriseEnCharge priseEnCharge = new PriseEnCharge();

	private String priseEnChargeFlag = "aucune";

	private String profil;
	private Recu recu;

	private String recuId = "";
	private String recuRegle = "0";

	@SuppressWarnings("unchecked")
	private List reglementsList = new ArrayList();

	private int remise = 0;

	private String remiseFlag = "oui";
	private String remiseMontant = "0";
	private String remiseValeur;

	private String rendu = "0";
	private String reportsPath;

	private String resteApayer = "0";
	private String resteApayerMajoration = "0";
	private String statut = "";
	private String subAction;
	private String telephone = "";
	private String telephoneR = "";

	private String totalApayer = "0";

	private String totalDevis = "0";

	private String totalMontantDrg = "0";

	private double totalReglement;
	private String typeActe = "normal";
	private String typePatient = "nouveau";
	private String typePayementId;

	@SuppressWarnings("unchecked")
	private List typePayementList = new ArrayList();

	private String typePayementValeur;

	private String typePcCouverte = "famille";

	private String typeSortie;

	private int urgenceActe;

	public String getActeId() {
		return acteId;
	}

	public String getActesLimite() {
		return actesLimite;
	}

	@SuppressWarnings("unchecked")
	public List getActesListe() {
		return actesListe;
	}

	public String getActeurActeId() {
		return acteurActeId;
	}

	public String getActeurActeIdInf() {
		return acteurActeIdInf;
	}

	@SuppressWarnings("unchecked")
	public List getActeurActeInfList() {
		return acteurActeInfList;
	}

	@SuppressWarnings("unchecked")
	public List getActeurActeList() {
		return acteurActeList;
	}

	public String getAdresse() {
		return adresse;
	}

	public String getAdresseR() {
		return adresseR;
	}

	public String getaRendre() {
		return aRendre;
	}

	public String getAssureurId() {
		return assureurId;
	}

	@SuppressWarnings("unchecked")
	public List getAssureurListe() {
		return assureurListe;
	}

	public String getAvance() {
		return avance;
	}

	public String getAvanceChoix() {
		return avanceChoix;
	}

	public Badge getBadge() {
		return badge;
	}

	public String getCashDejaSaisi() {
		return cashDejaSaisi;
	}

	public String getCategorieId() {
		return categorieId;
	}

	@SuppressWarnings("unchecked")
	public List getCategorieList() {
		return categorieList;
	}

	public String getChambreActuelle() {
		return chambreActuelle;
	}

	public String getChambreId() {
		return chambreId;
	}

	public List getChambreList() {
		return chambreList;
	}

	public List getChambresHospList() {
		return chambresHospList;
	}

	public String getChoixActePar() {
		return choixActePar;
	}

	public String getClasseId() {
		return classeId;
	}

	@SuppressWarnings("unchecked")
	public List getClassesListe() {
		return classesListe;
	}

	public String getCni() {
		return cni;
	}

	public String getCniR() {
		return cniR;
	}

	public String getCoteAssureur() {
		return coteAssureur;
	}

	public String getCoteClinique() {
		return coteClinique;
	}

	public String getCoteCliniqueReductible() {
		return coteCliniqueReductible;
	}

	public String getDateCreation() {
		return dateCreation;
	}

	public String getDateDebutRechFact() {
		return dateDebutRechFact;
	}

	public String getDateDerniereVisite() {
		return dateDerniereVisite;
	}

	public String getDateDerniereVisiteR() {
		return dateDerniereVisiteR;
	}

	public String getDateEntree() {
		return dateEntree;
	}

	public String getDateEntreeChambre() {
		return dateEntreeChambre;
	}

	public String getDateFinRechFact() {
		return dateFinRechFact;
	}

	public String getDateNaissance() {
		return dateNaissance;
	}

	public String getDateNaissanceR() {
		return dateNaissanceR;
	}

	public String getDatePremiereVisite() {
		return datePremiereVisite;
	}

	public String getDatePremiereVisiteR() {
		return datePremiereVisiteR;
	}

	public String getDateSortie() {
		return dateSortie;
	}

	public String getDejapaye() {
		return dejapaye;
	}

	public String getDescription() {
		return description;
	}

	public List getDetailDrgCnamListFacture() {
		return detailDrgCnamListFacture;
	}

	@SuppressWarnings("unchecked")
	public List getDetailsFactureList() {
		return detailsFactureList;
	}

	public List getDetailsFactureModifieesList() {
		return detailsFactureModifieesList;
	}

	public List getDevisActesList() {
		return devisActesList;
	}

	public List getDevisAimprimerList() {
		return devisAimprimerList;
	}

	public String getDevisAssureurId() {
		return devisAssureurId;
	}

	public List getDevisList() {
		return devisList;
	}

	public String getDispatch() {
		return dispatch;
	}

	public String getDrgCnamId() {
		return drgCnamId;
	}

	public List getDrgCnamListe() {
		return drgCnamListe;
	}

	public String getEntrepriseId() {
		return entrepriseId;
	}

	@SuppressWarnings("unchecked")
	public List getEntrepriseList() {
		return entrepriseList;
	}

	public Facture getFacture() {
		return facture;
	}

	public String getFactureId() {
		return factureId;
	}

	public String getFactureModifieeId() {
		return factureModifieeId;
	}

	public List getFacturesAgenererList() {
		return facturesAgenererList;
	}

	public List getFacturesAimprimerList() {
		return facturesAimprimerList;
	}

	public List getFacturesAmodifierList() {
		return facturesAmodifierList;
	}

	public String getFamillePrestationId() {
		return famillePrestationId;
	}

	@SuppressWarnings("unchecked")
	public List getFamillesPrestList() {
		return famillesPrestList;
	}

	public String getFinValidite() {
		return finValidite;
	}

	public String getHeureHosp() {
		return heureHosp;
	}

	public List getHopitalises() {
		return hopitalises;
	}

	public String getHospitalisaionId() {
		return hospitalisaionId;
	}

	public Hospitalisation getHospitalisation() {
		return hospitalisation;
	}

	public String getIdDetailDrgAsupprimer() {
		return idDetailDrgAsupprimer;
	}

	public String getIdPrestAsupprimer() {
		return idPrestAsupprimer;
	}

	public String getIdReglementAsupprimer() {
		return idReglementAsupprimer;
	}

	public String getInfirmierChoix() {
		return infirmierChoix;
	}

	public String getIsFirst() {
		return isFirst;
	}

	public String getIsHospitalisation() {
		return isHospitalisation;
	}

	public String getLibeleAssureur() {
		return libeleAssureur;
	}

	public String getLieuNaissance() {
		return lieuNaissance;
	}

	public String getLieuNaissanceR() {
		return lieuNaissanceR;
	}

	public String getLogin() {
		return login;
	}

	public String getLogoPath() {
		return logoPath;
	}

	public String getMajorationCoef() {
		return majorationCoef;
	}

	public String getMedecinChoix() {
		return medecinChoix;
	}

	public String getModeReglement() {
		return modeReglement;
	}

	public double getMontantPaye() {
		return montantPaye;
	}

	public double getMontantTotal() {
		return montantTotal;
	}

	public String getNni() {
		return nni;
	}

	public String getNniR() {
		return nniR;
	}

	public String getNom() {
		return nom;
	}

	public String getNomActe() {
		return nomActe;
	}

	public String getNomAssureur() {
		return nomAssureur;
	}

	public String getNombreActe() {
		return nombreActe;
	}

	public String getNombreActesPC() {
		return nombreActesPC;
	}

	public String getNomCategorie() {
		return nomCategorie;
	}

	public String getNomEntreprise() {
		return nomEntreprise;
	}

	public String getNomProfil() {
		return nomProfil;
	}

	public String getNomR() {
		return nomR;
	}

	public String getNumeroBadge() {
		return numeroBadge;
	}

	public String getNumeroBadgeR() {
		return numeroBadgeR;
	}

	public String getNumPC() {
		return numPC;
	}

	public String getOperateur() {
		return operateur;
	}

	public String getOperation() {
		return operation;
	}

	public Patient getPatient() {
		return patient;
	}

	public String getPatientId() {
		return patientId;
	}

	public String getPatientIdR() {
		return patientIdR;
	}

	@SuppressWarnings("unchecked")
	public List getPatients() {
		return patients;
	}

	public String getPcId() {
		return pcId;
	}

	public String getPcPersonnelId() {
		return pcPersonnelId;
	}

	public List getPcPersonnelList() {
		return pcPersonnelList;
	}

	public String getPlafond() {
		return plafond;
	}

	public String getPourcentage() {
		return pourcentage;
	}

	public String getPrenom() {
		return prenom;
	}

	public String getPrenomR() {
		return prenomR;
	}

	@SuppressWarnings("unchecked")
	public List getPrestationCouvertesPcs() {
		return prestationCouvertesPcs;
	}

	public PriseEnCharge getPriseEnCharge() {
		return priseEnCharge;
	}

	public String getPriseEnChargeFlag() {
		return priseEnChargeFlag;
	}

	public String getProfil() {
		return profil;
	}

	public Recu getRecu() {
		return recu;
	}

	public String getRecuId() {
		return recuId;
	}

	public String getRecuRegle() {
		return recuRegle;
	}

	public List getReglementsList() {
		return reglementsList;
	}

	public int getRemise() {
		return remise;
	}

	public String getRemiseFlag() {
		return remiseFlag;
	}

	public String getRemiseMontant() {
		return remiseMontant;
	}

	public String getRemiseValeur() {
		return remiseValeur;
	}

	public String getRendu() {
		return rendu;
	}

	public String getReportsPath() {
		return reportsPath;
	}

	public String getResteApayer() {
		return resteApayer;
	}

	public String getResteApayerMajoration() {
		return resteApayerMajoration;
	}

	public String getStatut() {
		return statut;
	}

	public String getSubAction() {
		return subAction;
	}

	public String getTelephone() {
		return telephone;
	}

	public String getTelephoneR() {
		return telephoneR;
	}

	public String getTotalApayer() {
		return totalApayer;
	}

	public String getTotalDevis() {
		return totalDevis;
	}

	public String getTotalMontantDrg() {
		return totalMontantDrg;
	}

	public double getTotalReglement() {
		return totalReglement;
	}

	public String getTypeActe() {
		return typeActe;
	}

	public String getTypePatient() {
		return typePatient;
	}

	public String getTypePayementId() {
		return typePayementId;
	}

	public List getTypePayementList() {
		return typePayementList;
	}

	public String getTypePayementValeur() {
		return typePayementValeur;
	}

	public String getTypePcCouverte() {
		return typePcCouverte;
	}

	public String getTypeSortie() {
		return typeSortie;
	}

	public int getUrgenceActe() {
		return urgenceActe;
	}

	public void setActeId(String acteId) {
		this.acteId = acteId;
	}

	public void setActesLimite(String actesLimite) {
		this.actesLimite = actesLimite;
	}

	@SuppressWarnings("unchecked")
	public void setActesListe(List actesListe) {
		this.actesListe = actesListe;
	}

	public void setActeurActeId(String acteurActeId) {
		this.acteurActeId = acteurActeId;
	}

	public void setActeurActeIdInf(String acteurActeIdInf) {
		this.acteurActeIdInf = acteurActeIdInf;
	}

	@SuppressWarnings("unchecked")
	public void setActeurActeInfList(List acteurActeInfList) {
		this.acteurActeInfList = acteurActeInfList;
	}

	@SuppressWarnings("unchecked")
	public void setActeurActeList(List acteurActeList) {
		// EntityCopier<ActeurActe> copier = new EntityCopier<ActeurActe>();
		this.acteurActeList = acteurActeList;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public void setAdresseR(String adresseR) {
		this.adresseR = adresseR;
	}

	public void setaRendre(String aRendre) {
		this.aRendre = aRendre;
	}

	public void setAssureurId(String assureurId) {
		this.assureurId = assureurId;
	}

	@SuppressWarnings("unchecked")
	public void setAssureurListe(List assureurListe) {
		this.assureurListe = assureurListe;
	}

	public void setAvance(String avance) {
		this.avance = avance;
	}

	public void setAvanceChoix(String avanceChoix) {
		this.avanceChoix = avanceChoix;
	}

	public void setBadge(Badge badge) {
		EntityCopier<Badge> copier = new EntityCopier<Badge>();
		this.badge = copier.copy(badge);
	}

	public void setCashDejaSaisi(String cashDejaSaisi) {
		this.cashDejaSaisi = cashDejaSaisi;
	}

	public void setCategorieId(String categorieId) {
		this.categorieId = categorieId;
	}

	@SuppressWarnings("unchecked")
	public void setCategorieList(List categorieList) {
		this.categorieList = categorieList;
	}

	public void setChambreActuelle(String chambreActuelle) {
		this.chambreActuelle = chambreActuelle;
	}

	public void setChambreId(String chambreId) {
		this.chambreId = chambreId;
	}

	public void setChambreList(List chambreList) {
		this.chambreList = chambreList;
	}

	public void setChambresHospList(List chambresHospList) {
		EntityCopier<ChambresHospitalisation> copier = new EntityCopier<ChambresHospitalisation>();
		this.chambresHospList = copier.copyList(chambresHospList);
	}

	public void setChoixActePar(String choixActePar) {
		this.choixActePar = choixActePar;
	}

	public void setClasseId(String classeId) {
		this.classeId = classeId;
	}

	@SuppressWarnings("unchecked")
	public void setClassesListe(List classesListe) {
		this.classesListe = classesListe;
	}

	public void setCni(String cni) {
		this.cni = cni;
	}

	public void setCniR(String cniR) {
		this.cniR = cniR;
	}

	public void setCoteAssureur(String coteAssureur) {
		this.coteAssureur = coteAssureur;
	}

	public void setCoteClinique(String coteClinique) {
		this.coteClinique = coteClinique;
	}

	public void setCoteCliniqueReductible(String coteCliniqueReductible) {
		this.coteCliniqueReductible = coteCliniqueReductible;
	}

	public void setDateCreation(String dateCreation) {
		this.dateCreation = dateCreation;
	}

	public void setDateDebutRechFact(String dateDebutRechFact) {
		this.dateDebutRechFact = dateDebutRechFact;
	}

	public void setDateDerniereVisite(String dateDerniereVisite) {
		this.dateDerniereVisite = dateDerniereVisite;
	}

	public void setDateDerniereVisiteR(String dateDerniereVisiteR) {
		this.dateDerniereVisiteR = dateDerniereVisiteR;
	}

	public void setDateEntree(String dateEntree) {
		this.dateEntree = dateEntree;
	}

	public void setDateEntreeChambre(String dateEntreeChambre) {
		this.dateEntreeChambre = dateEntreeChambre;
	}

	public void setDateFinRechFact(String dateFinRechFact) {
		this.dateFinRechFact = dateFinRechFact;
	}

	public void setDateNaissance(String dateNaissance) {
		this.dateNaissance = dateNaissance;
	}

	public void setDateNaissanceR(String dateNaissanceR) {
		this.dateNaissanceR = dateNaissanceR;
	}

	public void setDatePremiereVisite(String datePremiereVisite) {
		this.datePremiereVisite = datePremiereVisite;
	}

	public void setDatePremiereVisiteR(String datePremiereVisiteR) {
		this.datePremiereVisiteR = datePremiereVisiteR;
	}

	public void setDateSortie(String dateSortie) {
		this.dateSortie = dateSortie;
	}

	public void setDejapaye(String dejapaye) {
		this.dejapaye = dejapaye;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setDetailDrgCnamListFacture(List detailDrgCnamListFacture) {
		EntityCopier<DrgCnam> copier = new EntityCopier<DrgCnam>();
		this.detailDrgCnamListFacture = copier
				.copyList(detailDrgCnamListFacture);
	}

	@SuppressWarnings("unchecked")
	public void setDetailsFactureList(List detailsFactureList) {
		EntityCopier<DetailFacture> copier = new EntityCopier<DetailFacture>();
		this.detailsFactureList = copier.copyList(detailsFactureList);
		System.out.println("lol");
	}

	public void setDetailsFactureModifieesList(List detailsFactureModifieesList) {
		EntityCopier<DetailFactureModifiees> copier = new EntityCopier<DetailFactureModifiees>();
		this.detailsFactureModifieesList = copier
				.copyList(detailsFactureModifieesList);
	}

	public void setDevisActesList(List devisActesList) {
		EntityCopier<DevisActes> copier = new EntityCopier<DevisActes>();
		this.devisActesList = copier.copyList(devisActesList);
	}

	public void setDevisAimprimerList(List devisAimprimerList) {
		EntityCopier<DevisAssureur> copier = new EntityCopier<DevisAssureur>();
		this.devisAimprimerList = copier.copyList(devisAimprimerList);
	}

	public void setDevisAssureurId(String devisAssureurId) {
		this.devisAssureurId = devisAssureurId;
	}

	public void setDevisList(List devisList) {
		EntityCopier<DevisAssureur> copier = new EntityCopier<DevisAssureur>();
		this.devisList = copier.copyList(devisList);
	}

	public void setDispatch(String dispatch) {
		this.dispatch = dispatch;
	}

	public void setDrgCnamId(String drgCnamId) {
		this.drgCnamId = drgCnamId;
	}

	public void setDrgCnamListe(List drgCnamListe) {
		this.drgCnamListe = drgCnamListe;
	}

	public void setEntrepriseId(String entrepriseId) {
		this.entrepriseId = entrepriseId;
	}

	@SuppressWarnings("unchecked")
	public void setEntrepriseList(List entrepriseList) {
		this.entrepriseList = entrepriseList;
	}

	public void setFacture(Facture facture) {
		EntityCopier<Facture> copier = new EntityCopier<Facture>();
		this.facture = copier.copy(facture);
	}

	public void setFactureId(String factureId) {
		this.factureId = factureId;
	}

	public void setFactureModifieeId(String factureModifieeId) {
		this.factureModifieeId = factureModifieeId;
	}

	public void setFacturesAgenererList(List facturesAgenererList) {
		EntityCopier<Facture> copier = new EntityCopier<Facture>();
		this.facturesAgenererList = copier.copyList(facturesAgenererList);
	}

	public void setFacturesAimprimerList(List facturesAimprimerList) {
		EntityCopier<Facture> copier = new EntityCopier<Facture>();
		this.facturesAimprimerList = copier.copyList(facturesAimprimerList);
	}

	public void setFacturesAmodifierList(List facturesAmodifierList) {
		EntityCopier<FactureModifiees> copier = new EntityCopier<FactureModifiees>();
		this.facturesAmodifierList = copier.copyList(facturesAmodifierList);
	}

	public void setFamillePrestationId(String famillePrestationId) {
		this.famillePrestationId = famillePrestationId;
	}

	@SuppressWarnings("unchecked")
	public void setFamillesPrestList(List famillesPrestList) {
		this.famillesPrestList = famillesPrestList;
	}

	public void setFinValidite(String finValidite) {
		this.finValidite = finValidite;
	}

	public void setHeureHosp(String heureHosp) {
		this.heureHosp = heureHosp;
	}

	public void setHopitalises(List hopitalises) {
		EntityCopier<Hospitalisation> copier = new EntityCopier<Hospitalisation>();
		this.hopitalises = copier.copyList(hopitalises);
	}

	public void setHospitalisaionId(String hospitalisaionId) {
		this.hospitalisaionId = hospitalisaionId;
	}

	public void setHospitalisation(Hospitalisation hospitalisation) {
		EntityCopier<Hospitalisation> copier = new EntityCopier<Hospitalisation>();
		this.hospitalisation = copier.copy(hospitalisation);
	}

	public void setIdDetailDrgAsupprimer(String idDetailDrgAsupprimer) {
		this.idDetailDrgAsupprimer = idDetailDrgAsupprimer;
	}

	public void setIdPrestAsupprimer(String idPrestAsupprimer) {
		this.idPrestAsupprimer = idPrestAsupprimer;
	}

	public void setIdReglementAsupprimer(String idReglementAsupprimer) {
		this.idReglementAsupprimer = idReglementAsupprimer;
	}

	public void setInfirmierChoix(String infirmierChoix) {
		this.infirmierChoix = infirmierChoix;
	}

	public void setIsFirst(String isFirst) {
		this.isFirst = isFirst;
	}

	public void setIsHospitalisation(String isHospitalisation) {
		this.isHospitalisation = isHospitalisation;
	}

	public void setLibeleAssureur(String libeleAssureur) {
		this.libeleAssureur = libeleAssureur;
	}

	public void setLieuNaissance(String lieuNaissance) {
		this.lieuNaissance = lieuNaissance;
	}

	public void setLieuNaissanceR(String lieuNaissanceR) {
		this.lieuNaissanceR = lieuNaissanceR;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public void setLogoPath(String logoPath) {
		this.logoPath = logoPath;
	}

	public void setMajorationCoef(String majorationCoef) {
		this.majorationCoef = majorationCoef;
	}

	public void setMedecinChoix(String medecinChoix) {
		this.medecinChoix = medecinChoix;
	}

	public void setModeReglement(String modeReglement) {
		this.modeReglement = modeReglement;
	}

	public void setMontantPaye(double montantPaye) {
		this.montantPaye = montantPaye;
	}

	public void setMontantTotal(double montantTotal) {
		this.montantTotal = montantTotal;
	}

	public void setNni(String nni) {
		this.nni = nni;
	}

	public void setNniR(String nniR) {
		this.nniR = nniR;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public void setNomActe(String nomActe) {
		this.nomActe = nomActe;
	}

	public void setNomAssureur(String nomAssureur) {
		this.nomAssureur = nomAssureur;
	}

	public void setNombreActe(String nombreActe) {
		this.nombreActe = nombreActe;
	}

	public void setNombreActesPC(String nombreActesPC) {
		this.nombreActesPC = nombreActesPC;
	}

	public void setNomCategorie(String nomCategorie) {
		this.nomCategorie = nomCategorie;
	}

	public void setNomEntreprise(String nomEntreprise) {
		this.nomEntreprise = nomEntreprise;
	}

	public void setNomProfil(String nomProfil) {
		this.nomProfil = nomProfil;
	}

	public void setNomR(String nomR) {
		this.nomR = nomR;
	}

	public void setNumeroBadge(String numeroBadge) {
		this.numeroBadge = numeroBadge;
	}

	public void setNumeroBadgeR(String numeroBadgeR) {
		this.numeroBadgeR = numeroBadgeR;
	}

	public void setNumPC(String numPC) {
		this.numPC = numPC;
	}

	public void setOperateur(String operateur) {
		this.operateur = operateur;
	}

	public void setOperation(String operation) {
		this.operation = operation;
	}

	public void setPatient(Patient patient) {
		EntityCopier<Patient> copier = new EntityCopier<Patient>();
		this.patient = copier.copy(patient);
	}

	public void setPatientId(String patientId) {
		this.patientId = patientId;
	}

	public void setPatientIdR(String patientIdR) {
		this.patientIdR = patientIdR;
	}

	@SuppressWarnings("unchecked")
	public void setPatients(List patients) {
		EntityCopier<Patient> copier = new EntityCopier<Patient>();
		this.patients = copier.copyList(patients);
	}

	public void setPcId(String pcId) {
		this.pcId = pcId;
	}

	public void setPcPersonnelId(String pcPersonnelId) {
		this.pcPersonnelId = pcPersonnelId;
	}

	public void setPcPersonnelList(List pcPersonnelList) {
		this.pcPersonnelList = pcPersonnelList;
	}

	public void setPlafond(String plafond) {
		this.plafond = plafond;
	}

	public void setPourcentage(String pourcentage) {
		this.pourcentage = pourcentage;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public void setPrenomR(String prenomR) {
		this.prenomR = prenomR;
	}

	@SuppressWarnings("unchecked")
	public void setPrestationCouvertesPcs(List prestationCouvertesPcs) {
		EntityCopier<PrestationCouvertesPc> copier = new EntityCopier<PrestationCouvertesPc>();
		this.prestationCouvertesPcs = copier.copyList(prestationCouvertesPcs);
	}

	public void setPriseEnCharge(PriseEnCharge priseEnCharge) {
		EntityCopier<PriseEnCharge> copier = new EntityCopier<PriseEnCharge>();
		this.priseEnCharge = copier.copy(priseEnCharge);
	}

	public void setPriseEnChargeFlag(String priseEnChargeFlag) {
		this.priseEnChargeFlag = priseEnChargeFlag;
	}

	public void setProfil(String profil) {
		this.profil = profil;
	}

	public void setRecu(Recu recu) {
		EntityCopier<Recu> copier = new EntityCopier<Recu>();
		this.recu = copier.copy(recu);
	}

	public void setRecuId(String recuId) {
		this.recuId = recuId;
	}

	public void setRecuRegle(String recuRegle) {
		this.recuRegle = recuRegle;
	}

	public void setReglementsList(List reglementsList) {
		EntityCopier<Reglement> copier = new EntityCopier<Reglement>();
		this.reglementsList = copier.copyList(reglementsList);
	}

	public void setRemise(int remise) {
		this.remise = remise;
	}

	public void setRemiseFlag(String remiseFlag) {
		this.remiseFlag = remiseFlag;
	}

	public void setRemiseMontant(String remiseMontant) {
		this.remiseMontant = remiseMontant;
	}

	public void setRemiseValeur(String remiseValeur) {
		this.remiseValeur = remiseValeur;
	}

	public void setRendu(String rendu) {
		this.rendu = rendu;
	}

	public void setReportsPath(String reportsPath) {
		this.reportsPath = reportsPath;
	}

	public void setResteApayer(String resteApayer) {
		this.resteApayer = resteApayer;
	}

	public void setResteApayerMajoration(String resteApayerMajoration) {
		this.resteApayerMajoration = resteApayerMajoration;
	}

	public void setStatut(String statut) {
		this.statut = statut;
	}

	public void setSubAction(String subAction) {
		this.subAction = subAction;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public void setTelephoneR(String telephoneR) {
		this.telephoneR = telephoneR;
	}

	public void setTotalApayer(String totalApayer) {
		this.totalApayer = totalApayer;
	}

	public void setTotalDevis(String totalDevis) {
		this.totalDevis = totalDevis;
	}

	public void setTotalMontantDrg(String totalMontantDrg) {
		this.totalMontantDrg = totalMontantDrg;
	}

	public void setTotalReglement(double totalReglement) {
		this.totalReglement = totalReglement;
	}

	public void setTypeActe(String typeActe) {
		this.typeActe = typeActe;
	}

	public void setTypePatient(String typePatient) {
		this.typePatient = typePatient;
	}

	public void setTypePayementId(String typePayementId) {
		this.typePayementId = typePayementId;
	}

	public void setTypePayementList(List typePayementList) {
		this.typePayementList = typePayementList;
	}

	public void setTypePayementValeur(String typePayementValeur) {
		this.typePayementValeur = typePayementValeur;
	}

	public void setTypePcCouverte(String typePcCouverte) {
		this.typePcCouverte = typePcCouverte;
	}

	public void setTypeSortie(String typeSortie) {
		this.typeSortie = typeSortie;
	}

	public void setUrgenceActe(int urgenceActe) {
		this.urgenceActe = urgenceActe;
	}

}
