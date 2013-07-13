package clinique.metier.gestion.commerciale;

import java.util.Date;
import java.util.List;

import org.apache.struts.action.ActionMessages;

import clinique.mapping.Acte;
import clinique.mapping.Acteur;
import clinique.mapping.ActeurActe;
import clinique.mapping.Assureur;
import clinique.mapping.Categorie;
import clinique.mapping.ChambresHospitalisation;
import clinique.mapping.Classe;
import clinique.mapping.DetailFacture;
import clinique.mapping.DetailFactureChirurgie;
import clinique.mapping.DetailFactureModifiees;
import clinique.mapping.DevisAssureur;
import clinique.mapping.Entreprise;
import clinique.mapping.FamillePrestation;
import clinique.mapping.HasDetailFactureInfo;
import clinique.mapping.Patient;
import clinique.mapping.PrestationCouvertesPc;
import clinique.mapping.PrestationCouvertesPcModifiee;
import clinique.mapping.PriseEnCharge;
import clinique.mapping.PriseEnChargeModifiee;
import clinique.model.gestion.commerciale.GestionCommercialeForm;

public interface IGestionCommercialeBO {

	public static final String NAME = "IGestionCommercialeBO";

	void addActeBadge(GestionCommercialeForm formulaire, double prixActe);

	void addActeBadgeFromDetailFacture(GestionCommercialeForm formulaire,
			double prixActe, HasDetailFactureInfo df);

	void addActeNombreActeLimiteAvecPlafond(GestionCommercialeForm formulaire,
			int pourcentage, int nbreActe, PrestationCouvertesPc pcCouv,
			double prixActe, int nbreActeRestant, double plafondRestant);

	void addActeNombreActeLimiteSansPlafond(GestionCommercialeForm formulaire,
			int pourcentage, int nbreActe, PrestationCouvertesPc pcCouv,
			double prixActe, int nbreActeRestant);

	void addActePC(GestionCommercialeForm formulaire, double prixActe);

	void addActePCFromDetailFacture(GestionCommercialeForm formulaire,
			double prixActe, HasDetailFactureInfo df);

	void addActePCWithoutPrestationCouv(GestionCommercialeForm formulaire,
			double prixActe);

	void addActePCWithoutPrestationCouvFromDetailFacture(
			GestionCommercialeForm formulaire, double prixActe, HasDetailFactureInfo df);

	boolean addAncienDevisPatientWithoutPCInfos(
			GestionCommercialeForm formulaire) throws Exception;

	boolean addAncienPatientWithoutPCInfos(GestionCommercialeForm formulaire)
			throws Exception;

	boolean addAncienPatientWithPC(GestionCommercialeForm formulaire)
			throws Exception;

	void addFraisChambre(GestionCommercialeForm formulaire, double frais);

	boolean addPatientForPrestations(GestionCommercialeForm formulaire)
			throws Exception;

	boolean addPatientForPrestationsDevis(GestionCommercialeForm formulaire)
			throws Exception;

	boolean addReglementAvance(GestionCommercialeForm formulaire)
			throws Exception;

	boolean ajouterActe(GestionCommercialeForm formulaire) throws Exception;
	
	boolean supprimerDeatilFacture(GestionCommercialeForm formulaire) throws Exception;
	

	boolean ajouterActeDevis(GestionCommercialeForm formulaire)
			throws Exception;

	boolean ajouterActeForFactureHosp(GestionCommercialeForm formulaire,
			DetailFacture df) throws Exception;

	boolean ajouterActeForFactureModifiee(GestionCommercialeForm formulaire,
			DetailFacture df) throws Exception;

	boolean ajouterActeForHosp(GestionCommercialeForm formulaire)
			throws Exception;

	boolean ajouterActeForHosp_Old(GestionCommercialeForm formulaire)
			throws Exception;

	boolean ajouterActeForModificationFacture(GestionCommercialeForm formulaire)
			throws Exception;

	boolean ajouterActesHosp(GestionCommercialeForm formulaire)
			throws Exception;

	boolean ajouterDrgCnamDansDetailDrgCnamList(
			GestionCommercialeForm formulaire) throws Exception;

	boolean ajouterRecuFacture(GestionCommercialeForm formulaire)
			throws Exception;

	boolean ajouterRecuFactureHosp(GestionCommercialeForm formulaire)
			throws Exception;

	boolean ajouterRegelement(GestionCommercialeForm formulaire)
			throws Exception;

	void calculCoteAssureur(GestionCommercialeForm formulaire, double prixActe);

	int calculMajoration(GestionCommercialeForm formulaire);

	int calculQPActeur(DetailFacture df);

	int calculQPActeur(GestionCommercialeForm formulaire);

	int calculQPAssistant(DetailFacture df);

	int calculQPAssistant(GestionCommercialeForm formulaire);

	boolean changerChambre(GestionCommercialeForm formulaire) throws Exception;

	void chargerPrestations(GestionCommercialeForm formulaire);

	boolean checkActe(Acte acte);

	ActionMessages checkActeAdd(GestionCommercialeForm formulaire);

	ActionMessages checkActeAddForModificationFacture(
			GestionCommercialeForm formulaire);

	boolean checkActePC(GestionCommercialeForm formulaire);

	boolean checkActeur(ActeurActe acteurActe);

	ActionMessages checkAddActePc(GestionCommercialeForm formulaire);

	boolean checkAssureur(Assureur assureur);

	ActionMessages checkBadge(GestionCommercialeForm formulaire, Patient patient);

	boolean checkCategorie(Categorie categorie);

	boolean checkClasse(Classe classe);

	boolean checkEntreprise(Entreprise entreprise);

	boolean checkFacture(GestionCommercialeForm formulaire) throws Exception;

	boolean checkFamillePres(FamillePrestation famillePres);

	boolean checkNbreActesRestant(GestionCommercialeForm formulaire);

	boolean checkPC(PriseEnCharge pc);

	boolean checkPcValide(PriseEnCharge pc, GestionCommercialeForm formulaire);

	boolean checkPrestationCouvertesPC(PriseEnCharge pc);

	ActionMessages checkPrestCouvAdd(GestionCommercialeForm formulaire);

	boolean checkReglementPCByAssureur(GestionCommercialeForm formulaire)
			throws Exception;

	boolean checkReglementPCByAssureurCNAM(GestionCommercialeForm formulaire)
			throws Exception;

	void checkRemise(GestionCommercialeForm formulaire);

	boolean construireListePrestCouvertes(GestionCommercialeForm formulaire)
			throws Exception;

	boolean creerDevis(GestionCommercialeForm formulaire) throws Exception;

	boolean creerRecuHosp(GestionCommercialeForm formulaire) throws Exception;

	boolean genererFacture(GestionCommercialeForm formulaire) throws Exception;

	void getAncienPatientInfosAssureur(Patient patient,
			GestionCommercialeForm formulaire);

	double getChambreFrais(ChambresHospitalisation chambreHospitalisation);

	double getChambreFraisAssureur(ChambresHospitalisation chambreHospitalisation); 
	
	void getInfosPC(GestionCommercialeForm formulaire);

	boolean getListDevisAimprimer(GestionCommercialeForm formulaire)
			throws Exception;

	boolean getListFacturesAgenerer(GestionCommercialeForm formulaire)
			throws Exception;

	boolean getListFacturesAimprimer(GestionCommercialeForm formulaire)
			throws Exception;

	boolean getListFacturesGenerees(GestionCommercialeForm formulaire)
			throws Exception;

	boolean getListHopitalises(GestionCommercialeForm formulaire)
			throws Exception;

	List getListHopitalisesPatients(GestionCommercialeForm formulaire)
			throws Exception;

	boolean getListPatientsMulti(GestionCommercialeForm formulaire)
			throws Exception;

	boolean getListPatientsMultiForHosp(GestionCommercialeForm formulaire)
			throws Exception;

	PrestationCouvertesPc getPrestationCouverte(
			GestionCommercialeForm formulaire);

	double getPrixActeFromDetailFacture(DetailFacture df);

	ActionMessages getUser(GestionCommercialeForm formulaire) throws Exception;

	boolean infosForModificationFacture(GestionCommercialeForm formulaire)
			throws Exception;

	void initialiserChampsAjouterPrestations(GestionCommercialeForm formulaire);

	void initialiserCombosAssureur(GestionCommercialeForm formulaire)
			throws Exception;

	void initialiserCombosChambres(GestionCommercialeForm formulaire)
			throws Exception;

	void initialiserCombosDrgCnam(GestionCommercialeForm formulaire)
			throws Exception;

	void initialiserCombosPcPersonnel(GestionCommercialeForm formulaire);

	void initialiserCombosPrestations(GestionCommercialeForm formulaire)
			throws Exception;
	
	void reinitialiserCombosPrestations(GestionCommercialeForm formulaire)
			throws Exception;

	void initialiserCombosTypePyement(GestionCommercialeForm formulaire);

	void initialiserElementsPaymentHospFacture(GestionCommercialeForm formulaire);

	void initialiserForm(GestionCommercialeForm formulaire);

	void initialiserInfosChambre(GestionCommercialeForm formulaire);

	List<DevisAssureur> listDevisAimprimer(String date1, String date2);

	void makeCopieOfPriseEnCharge(PriseEnCharge pc, PriseEnChargeModifiee pcM,
			double montantPc, String userId);

	void makeCopieOfPrtationCouv(PrestationCouvertesPc pccouv,
			PrestationCouvertesPcModifiee pccouvM);

	void makeTransactionActeurs(List transactionComptes,
			GestionCommercialeForm formulaire, int idkey);

	void makeTransactionCliniqueAndAssureur(List transactionComptes,
			List transactionCompteCategories,
			GestionCommercialeForm formulaire, int idkey);

	boolean patientPrestationsFormulaire(GestionCommercialeForm formulaire)
			throws Exception;

	boolean patientPrestationsFormulaireAncien(GestionCommercialeForm formulaire)
			throws Exception;

	void RechargerCombosEntreprisesAndCategories(
			GestionCommercialeForm formulaire) throws Exception;

	boolean reserverChambre(GestionCommercialeForm formulaire) throws Exception;

	void setInfosDfm(DetailFactureModifiees dfM);

	void setInfosDfmActeurWithoutPc(DetailFactureModifiees dfM, Date dateF,
			Acteur acteur, Acte acte);

	void setInfosDfmActeurWithPc(DetailFactureModifiees dfM, Date dateF,
			Acteur acteur, Acte acte, Categorie categorie);

	void setInfosDfmPcWithoutActeur(DetailFactureModifiees dfM, Date dateF,
			Acte acte, Categorie categorie);

	void setInfosDfmWithoutPcWithoutActeur(DetailFactureModifiees dfM,
			Date dateF, Acte acte);

	boolean setLibererChambre(GestionCommercialeForm formulaire)
			throws Exception;

	void setPrestCouvAtList(PrestationCouvertesPc pcCouv,
			GestionCommercialeForm formulaire);

	boolean setSortie(GestionCommercialeForm formulaire) throws Exception;

	boolean setSortieSansReglement(GestionCommercialeForm formulaire)
			throws Exception;

	void setTauxAssistantWithoutPc(DetailFactureModifiees dfM, Date dateF,
			Acte acte);

	void setTauxAssistantWithPc(DetailFactureModifiees dfM, Date dateF,
			Acte acte, Categorie categorie);

	void setValeursResteApyer(GestionCommercialeForm formulaire);

	void setValeursResteApyer2(GestionCommercialeForm formulaire);

	void setValeursResteApyerHosp(GestionCommercialeForm formulaire)
			throws Exception;

	boolean showHospForAddPrestation(GestionCommercialeForm formulaire)
			throws Exception;

	boolean showHospForChangeChambre(GestionCommercialeForm formulaire)
			throws Exception;

	boolean showHospForSortie(GestionCommercialeForm formulaire)
			throws Exception;

	boolean showHospInfosForSortie(GestionCommercialeForm formulaire)
			throws Exception;

	boolean supprimerDetailDrgFromListeDetailDrgCnamFacture(
			GestionCommercialeForm formulaire) throws Exception;

	boolean supprimerPrestFromListeDevis(GestionCommercialeForm formulaire)
			throws Exception;

	boolean supprimerPrestFromListePrestCouvertes(
			GestionCommercialeForm formulaire) throws Exception;

	boolean supprimerReglementFromListeReglement(
			GestionCommercialeForm formulaire) throws Exception;

	boolean supprimerReglementHospFromListeReglement(
			GestionCommercialeForm formulaire) throws Exception;
	
    boolean ajouterActeBloc(
			GestionCommercialeForm formulaire,DetailFacture detail) throws Exception;
    
    boolean ajouterActeAssistantBloc(
			GestionCommercialeForm formulaire,DetailFacture detail) throws Exception;
    
    boolean ajouterActeChirurgie(GestionCommercialeForm formulaire)
			throws Exception ;
    
    int calculQPChirurgien(GestionCommercialeForm formulaire);
    
    int calculQPAssistantChirurgie(DetailFactureChirurgie df);
    
    boolean ajouterActeAnesthesie(GestionCommercialeForm formulaire,DetailFacture detail)
			throws Exception;
    
    boolean ajouterActeAssistantAnesthesie(GestionCommercialeForm formulaire,DetailFacture detail)
			throws Exception;
    
    int calculQPAnesthesiste(GestionCommercialeForm formulaire);

}