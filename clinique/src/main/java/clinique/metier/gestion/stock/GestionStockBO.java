package clinique.metier.gestion.stock;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;
import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionMessages;
import org.apache.struts.util.LabelValueBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import clinique.dao.ClasseDAO;
import clinique.dao.EntreeStockDAO;
import clinique.dao.FournisseurDAO;
import clinique.dao.ProduitDAO;
import clinique.dao.SortieStockDAO;
import clinique.mapping.Classe;
import clinique.mapping.EntreeStock;
import clinique.mapping.Fournisseur;
import clinique.mapping.Produit;
import clinique.mapping.SortieStock;
import clinique.metier.TransactionalBO;
import clinique.model.gestion.stock.GestionStockForm;
import clinique.utils.UtilDate;

@Service(IGestionStockBO.NAME)
public class GestionStockBO extends TransactionalBO implements IGestionStockBO {
	private static Logger log = Logger.getLogger(GestionStockBO.class);

	private ActionMessages errors = new ActionMessages();

	@Autowired
	private EntreeStockDAO entreeStockDAO;
	@Autowired
	private FournisseurDAO fournisseurDAO;
	@Autowired
	private ProduitDAO produitDAO;
	@Autowired
	private SortieStockDAO sortieStockDAO;
	@Autowired
	private ClasseDAO classeDAO;

	private EntreeStockDAO getEntreeStockDAO() {
		return entreeStockDAO;
	}

	private FournisseurDAO getFournisseurDAO() {
		return fournisseurDAO;
	}

	private ProduitDAO getProduitDAO() {
		return produitDAO;
	}

	private SortieStockDAO getSortieStockDAO() {
		return sortieStockDAO;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * clinique.metier.gestion.stock.IGestionStockBO#checkEntreeStock(clinique
	 * .model.gestion.stock.GestionStockForm)
	 */
	@Override
	public ActionMessages checkEntreeStock(GestionStockForm formulaire) {
		errors.clear();
		EntreeStockDAO entreeStockDAO = getEntreeStockDAO();
		EntreeStock entreeStock = entreeStockDAO
				.getEntreeStockByProduitAndDateAndFournisseur(
						Integer.parseInt(formulaire.getProduitId()),
						UtilDate.getInstance().stringToDate(
								formulaire.getDateStockEntree()), Integer
								.parseInt(formulaire.getFournisseurId()));
		if (entreeStock != null) {
			ActionError error = new ActionError(
					"EntreeStock.tripleProduitDateFournisseurExiste");
			errors.add("EntreeStock.tripleProduitDateFournisseurExiste", error);
		}
		return errors;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * clinique.metier.gestion.stock.IGestionStockBO#checkFounisseur(clinique
	 * .model.gestion.stock.GestionStockForm)
	 */
	@Override
	public ActionMessages checkFounisseur(GestionStockForm formulaire) {
		errors.clear();
		FournisseurDAO fournisseurDAO = getFournisseurDAO();
		Fournisseur fournisseur = fournisseurDAO.getFournisseurByNom(formulaire
				.getNomFournisseur());
		if (fournisseur != null) {
			ActionError error = new ActionError("Fournisseur.nomExiste");
			errors.add("Fournisseur.nomExiste", error);
		}
		return errors;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * clinique.metier.gestion.stock.IGestionStockBO#checkProduit(clinique.model
	 * .gestion.stock.GestionStockForm)
	 */
	@Override
	public ActionMessages checkProduit(GestionStockForm formulaire) {
		errors.clear();
		ProduitDAO produitDAO = getProduitDAO();
		Produit produit = produitDAO
				.getProduitByNom(formulaire.getNomProduit());
		if (produit != null) {
			ActionError error = new ActionError("Produit.nomExiste");
			errors.add("Produit.nomExiste", error);
		}
		return errors;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * clinique.metier.gestion.stock.IGestionStockBO#checkSortieStock(clinique
	 * .model.gestion.stock.GestionStockForm)
	 */
	@Override
	public ActionMessages checkSortieStock(GestionStockForm formulaire) {
		errors.clear();
		SortieStockDAO sortieStockDAO = getSortieStockDAO();
		SortieStock sortieStock = sortieStockDAO
				.getSortieStockByProduitAndDateAndQuantite(
						Integer.parseInt(formulaire.getProduitId()),
						UtilDate.getInstance().stringToDate(
								formulaire.getDateStockEntree()), Integer
								.parseInt(formulaire.getQuantiteStockSortie()));
		if (sortieStock != null) {
			ActionError error = new ActionError(
					"SortieStock.tripleProduitDateQuantiteExiste");
			errors.add("SortieStock.tripleProduitDateQuantiteExiste", error);
		} else {
			ProduitDAO produitDAO = getProduitDAO();
			Produit produit = produitDAO.getProduit(Integer.parseInt(formulaire
					.getProduitId()));
			if (produit != null) {
				if (produit.getQuantiteDisponible() < Integer
						.parseInt(formulaire.getQuantiteStockSortie().trim())) {
					ActionError error = new ActionError(
							"SortieStock.quantiteSortanteSuperieureQuantiteDisponible");
					errors.add(
							"SortieStock.quantiteSortanteSuperieureQuantiteDisponible",
							error);
				}
			}
		}
		return errors;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see clinique.metier.gestion.stock.IGestionStockBO#getErrors()
	 */
	@Override
	public ActionMessages getErrors() {
		return errors;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * clinique.metier.gestion.stock.IGestionStockBO#getListJournalStock(clinique
	 * .model.gestion.stock.GestionStockForm)
	 */
	@Override
	public boolean getListJournalStock(GestionStockForm formulaire)
			throws Exception {

		Map mapParamValue = new HashMap<String, String>(2, 1);
		mapParamValue.put("operateur", formulaire.getOperateur());
		mapParamValue.put("dateJournal",
				UtilDate.getInstance().dateToString(new Date()));
		// mapParamValue.put("dateEntree",
		// UtilDate.getInstance().stringToDate(formulaire.getDateStockEntree()));
		// Collection<JournalDuStock> list = (Collection<JournalDuStock>)
		// QueryDao.getInstance().findResultQueryByNamedParams("query_filtre_journal_stock",
		// mapParamValue);
		// formulaire.setJournalStockList(list);
		return true;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * clinique.metier.gestion.stock.IGestionStockBO#getListProduits(clinique
	 * .model.gestion.stock.GestionStockForm)
	 */
	@Override
	public boolean getListProduits(GestionStockForm formulaire)
			throws Exception {

		ProduitDAO produitDAO = getProduitDAO();
		formulaire.setProduitsList(produitDAO.listProduits());
		return true;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * clinique.metier.gestion.stock.IGestionStockBO#initialiserCombosClasses
	 * (clinique.model.gestion.stock.GestionStockForm)
	 */
	@Override
	public void initialiserCombosClasses(GestionStockForm formulaire) {
		log.debug("********** Debut initialiserCombosClasses GestionStockBO **********");
		ArrayList classesList = new ArrayList();
		try {
			for (Object element : classeDAO.listClasses()) {
				Classe classe = (Classe) element;
				classesList.add(new LabelValueBean(classe.getNomClasse(),
						String.valueOf(classe.getClasseId())));
			}
			formulaire.setClassesList(classesList);
		} catch (Exception e) {
			e.printStackTrace();
			log.fatal(e.getMessage());
		} finally {
			log.debug("********** Fin initialiserCombosClasses GestionStockBO **********");
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * clinique.metier.gestion.stock.IGestionStockBO#initialiserCombosFournisseurs
	 * (clinique.model.gestion.stock.GestionStockForm)
	 */
	@Override
	public void initialiserCombosFournisseurs(GestionStockForm formulaire) {
		log.debug("********** Debut initialiserCombosFournisseurs GestionStockBO **********");
		FournisseurDAO fournisseurDAO = getFournisseurDAO();
		ArrayList fournisseursList = new ArrayList();
		try {
			for (Object element : fournisseurDAO.listFournisseurs()) {
				Fournisseur fournisseur = (Fournisseur) element;
				fournisseursList.add(new LabelValueBean(fournisseur
						.getNomFournisseur(), String.valueOf(fournisseur
						.getFournisseurId())));
			}
			formulaire.setFournisseursList(fournisseursList);
		} catch (Exception e) {
			e.printStackTrace();
			log.fatal(e.getMessage());
		} finally {
			log.debug("********** Fin initialiserCombosFournisseurs GestionStockBO **********");
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * clinique.metier.gestion.stock.IGestionStockBO#initialiserCombosProduits
	 * (clinique.model.gestion.stock.GestionStockForm)
	 */
	@Override
	public void initialiserCombosProduits(GestionStockForm formulaire) {
		log.debug("********** Debut initialiserCombosProduits GestionStockBO **********");
		ProduitDAO produitDAO = getProduitDAO();
		ArrayList produitsList = new ArrayList();
		Produit produit = null;
		boolean trouvee = false;
		try {
			for (Object element : produitDAO.listProduits()) {
				produit = (Produit) element;
				produitsList.add(new LabelValueBean(produit.getNomProduit(),
						String.valueOf(produit.getProduitId())));
				if (trouvee == false) {
					formulaire
							.setPrixProduit(String.valueOf(produit.getPrix()));
					formulaire.setQuantiteDisponibleProduit(String
							.valueOf(produit.getQuantiteDisponible()));
					trouvee = true;
				}
			}
			formulaire.setProduitsList(produitsList);
		} catch (Exception e) {
			e.printStackTrace();
			log.fatal(e.getMessage());
		} finally {
			log.debug("********** Fin initialiserCombosProduits GestionStockBO **********");
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * clinique.metier.gestion.stock.IGestionStockBO#saveEntreeStock(clinique
	 * .model.gestion.stock.GestionStockForm)
	 */
	@Override
	public String saveEntreeStock(GestionStockForm formulaire) {
		log.debug("********** Debut saveEntreeStock GestionStockBO **********");
		EntreeStockDAO entreeStockDAO = getEntreeStockDAO();
		EntreeStock entreeStock = new EntreeStock();
		Produit produit = null;
		Produit produit1 = null;
		ProduitDAO produitDAO = getProduitDAO();
		Fournisseur fournisseur = null;
		FournisseurDAO fournisseurDAO = getFournisseurDAO();
		try {
			entreeStock.setDateEntree(UtilDate.getInstance().stringToDate(
					formulaire.getDateStockEntree()));
			entreeStock.setNumeroDestinataire(formulaire
					.getNumeroDestinataire());
			entreeStock.setOperateur(formulaire.getOperateur());
			entreeStock.setPrixUnitaire(Integer.parseInt(formulaire
					.getPrixUnitaireAchat()));
			entreeStock.setQuantite(Integer.parseInt(formulaire
					.getQuantiteStockEntrante()));
			if (formulaire.getProduitId() != null
					&& !formulaire.getProduitId().equals("")) {
				produit = produitDAO.getProduit(Integer.parseInt(formulaire
						.getProduitId().trim()));
			}
			if (produit != null) {
				entreeStock.setProduit(produit);
			}
			if (formulaire.getFournisseurId() != null
					&& !formulaire.getFournisseurId().equals("")) {
				fournisseur = fournisseurDAO.getFournisseur(Integer
						.parseInt(formulaire.getFournisseurId().trim()));
			}
			if (fournisseur != null) {
				entreeStock.setFournisseur(fournisseur);
			}
			entreeStockDAO.saveEntreeStock(entreeStock);
			produit1 = produitDAO.getProduit(Integer.parseInt(formulaire
					.getProduitId()));
			if (produit1 != null) {
				int quantiteDisponible = produit1.getQuantiteDisponible()
						+ Integer.parseInt(formulaire
								.getQuantiteStockEntrante().trim());
				produit1.setQuantiteDisponible(quantiteDisponible);
				produitDAO.updateProduit(produit1);
			}
			return "true";
		} catch (Exception e) {
			e.printStackTrace();
			log.fatal(e.getMessage());
			return "false";

		} finally {
			entreeStock = null;
			produit = null;
			produit1 = null;
			fournisseur = null;
			log.debug("********** Fin saveEntreeStock GestionStockBO **********");
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * clinique.metier.gestion.stock.IGestionStockBO#saveFounisseur(clinique
	 * .model.gestion.stock.GestionStockForm)
	 */
	@Override
	public String saveFounisseur(GestionStockForm formulaire) {
		log.debug("********** Debut saveFounisseur GestionStockBO **********");
		Fournisseur fournisseur = new Fournisseur();
		FournisseurDAO fournisseurDAO = getFournisseurDAO();
		try {
			fournisseur.setNomFournisseur(formulaire.getNomFournisseur());
			fournisseur.setAdresse(formulaire.getAdresseFournisseur());
			if (formulaire.getTelephone1Fournisseur() != null
					&& !formulaire.getTelephone1Fournisseur().trim().equals("")) {
				int tel1 = Integer.parseInt(formulaire
						.getTelephone1Fournisseur().trim());
				fournisseur.setTelephone1(tel1);
			}
			if (formulaire.getTelephone2Fournisseur() != null
					&& !formulaire.getTelephone2Fournisseur().trim().equals("")) {
				int tel2 = Integer.parseInt(formulaire
						.getTelephone2Fournisseur().trim());
				fournisseur.setTelephone2(tel2);
			}
			fournisseur.setOperateur(formulaire.getOperateur());
			fournisseurDAO.saveFournisseur(fournisseur);
			return "true";
		} catch (Exception e) {
			e.printStackTrace();
			log.fatal(e.getMessage());
			return "false";

		} finally {
			fournisseur = null;
			log.debug("********** Fin saveFounisseur GestionStockBO **********");
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * clinique.metier.gestion.stock.IGestionStockBO#saveProduit(clinique.model
	 * .gestion.stock.GestionStockForm)
	 */
	@Override
	public String saveProduit(GestionStockForm formulaire) {
		log.debug("********** Debut saveProduit GestionStockBO **********");
		Produit produit = new Produit();
		ProduitDAO produitDAO = getProduitDAO();
		Classe classe = null;
		try {
			produit.setNomProduit(formulaire.getNomProduit());
			produit.setOperateur(formulaire.getOperateur());
			produit.setQuantiteDisponible(Integer.parseInt(formulaire
					.getQuantiteDisponibleProduit()));
			produit.setSeuilMinimum(Integer.parseInt(formulaire
					.getSeuilMinimumProduit()));
			if (formulaire.getFacturable().trim().equals("1")) {
				produit.setFacturable(FACTURABLE);
				produit.setPrix(Integer.parseInt(formulaire.getPrixProduit()));
			} else {
				produit.setFacturable(NON_FACTURABLE);
			}
			if (formulaire.getClasseId() != null
					&& !formulaire.getClasseId().equals("")) {
				classe = classeDAO.getClasse(Integer.parseInt(formulaire
						.getClasseId().trim()));
			}
			if (classe != null) {
				produit.setClasse(classe);
			}
			produitDAO.saveProduit(produit);
			return "true";
		} catch (Exception e) {
			e.printStackTrace();
			log.fatal(e.getMessage());
			return "false";

		} finally {
			produit = null;
			classe = null;
			log.debug("********** Fin saveProduit GestionStockBO **********");
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * clinique.metier.gestion.stock.IGestionStockBO#saveSortieStock(clinique
	 * .model.gestion.stock.GestionStockForm)
	 */
	@Override
	public String saveSortieStock(GestionStockForm formulaire) {
		log.debug("********** Debut saveSortieStock GestionStockBO **********");
		SortieStockDAO sortieStockDAO = getSortieStockDAO();
		SortieStock sortieStock = new SortieStock();
		Produit produit = null;
		Produit produit1 = null;
		ProduitDAO produitDAO = getProduitDAO();
		try {
			sortieStock.setDateSortie(UtilDate.getInstance().stringToDate(
					formulaire.getDateStockEntree()));
			sortieStock.setNumeroSource(Integer.parseInt(formulaire
					.getNumeroSource()));
			sortieStock.setOperateur(formulaire.getOperateur());
			sortieStock.setPrixUnitaire(Integer.parseInt(formulaire
					.getPrixProduit()));
			sortieStock.setQuantite(Integer.parseInt(formulaire
					.getQuantiteStockSortie()));
			if (formulaire.getProduitId() != null
					&& !formulaire.getProduitId().equals("")) {
				produit = produitDAO.getProduit(Integer.parseInt(formulaire
						.getProduitId().trim()));
			}
			if (produit != null) {
				sortieStock.setProduit(produit);
			}
			sortieStockDAO.saveSortieStock(sortieStock);
			produit1 = produitDAO.getProduit(Integer.parseInt(formulaire
					.getProduitId()));
			if (produit1 != null) {
				int quantiteDisponible = produit1.getQuantiteDisponible()
						- Integer.parseInt(formulaire.getQuantiteStockSortie()
								.trim());
				produit1.setQuantiteDisponible(quantiteDisponible);
				produitDAO.updateProduit(produit1);
			}
			return "true";
		} catch (Exception e) {
			e.printStackTrace();
			log.fatal(e.getMessage());
			return "false";

		} finally {
			sortieStock = null;
			produit = null;
			produit1 = null;
			log.debug("********** Fin saveSortieStock GestionStockBO **********");
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * clinique.metier.gestion.stock.IGestionStockBO#setErrors(org.apache.struts
	 * .action.ActionMessages)
	 */
	@Override
	public void setErrors(ActionMessages errors) {
		this.errors = errors;
	}
}
