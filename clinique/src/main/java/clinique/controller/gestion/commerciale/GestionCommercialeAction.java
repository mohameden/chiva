package clinique.controller.gestion.commerciale;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessages;
import org.springframework.web.struts.DispatchActionSupport;

import clinique.impression.IImpressionBO;
import clinique.metier.gestion.commerciale.IGestionCommercialeBO;
import clinique.model.gestion.commerciale.GestionCommercialeForm;

public class GestionCommercialeAction extends DispatchActionSupport {
	private static Logger log = Logger
			.getLogger(GestionCommercialeAction.class);

	public static final String KEY_USER = "userConnected";
	private static final String FORWARD = "succes";
	private static final String FORWARD_ERR = "erreur";

	// private final String CONTENT_PDF = "application/pdf";
	// private final String RECU_FR =
	// InitServlet.CHEMIN_ROOT+"/reports/Recu_Saisie_Acte_fr.jrxml";

	private IGestionCommercialeBO getGestionCommercialeBO() {
		return (IGestionCommercialeBO) getWebApplicationContext().getBean(
				IGestionCommercialeBO.NAME);
	}

	private IImpressionBO getImpressionBO() {
		return (IImpressionBO) getWebApplicationContext().getBean(
				IImpressionBO.NAME);
	}

	@SuppressWarnings("unchecked")
	public ActionForward chercher(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		// log.debug("********** Debut chercher GestionCommercialeAction **********");
		try {
			GestionCommercialeForm formulaire = (GestionCommercialeForm) form;
			// User
			// user=(User)request.getSession().getAttribute("userConnected");
			// formulaire.setOperateur(user.getLogin());
			formulaire.setPatients(new ArrayList());
			IGestionCommercialeBO gestionCommercialeBO = getGestionCommercialeBO();
			if (gestionCommercialeBO.getListPatientsMulti(formulaire)) {
				return mapping.findForward("initMulti");
			} else {
				return mapping.findForward("initMulti");
			}
		} catch (Exception e) {
			log.fatal(e.getMessage());
			return mapping.findForward("error");
		} finally {
			log.debug("********** Fin chercher GestionCommercialeAction **********");
		}
	}

	@SuppressWarnings("unchecked")
	public ActionForward chercherPatientDevis(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		try {
			GestionCommercialeForm formulaire = (GestionCommercialeForm) form;
			// User
			// user=(User)request.getSession().getAttribute("userConnected");
			// formulaire.setOperateur(user.getLogin());
			formulaire.setPatients(new ArrayList());
			IGestionCommercialeBO gestionCommercialeBO = getGestionCommercialeBO();
			if (gestionCommercialeBO.getListPatientsMulti(formulaire)) {

				return mapping.findForward("infosPatientDevis");
			}

			else {
				return mapping.findForward("infosPatientDevis");
			}
		} catch (Exception e) {
			log.fatal(e.getMessage());
			return mapping.findForward("error");
		} finally {
			log.debug("********** Fin chercher GestionCommercialeAction **********");
		}

	}

	@SuppressWarnings("unchecked")
	public ActionForward chercherHosp(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		log.debug("********** Debut chercher GestionCommercialeAction **********");
		try {
			GestionCommercialeForm formulaire = (GestionCommercialeForm) form;
			// User
			// user=(User)request.getSession().getAttribute("userConnected");
			// formulaire.setOperateur(user.getLogin());
			formulaire.setPatients(new ArrayList());
			IGestionCommercialeBO gestionCommercialeBO = getGestionCommercialeBO();
			if (gestionCommercialeBO.getListPatientsMultiForHosp(formulaire)) {

				return mapping.findForward("infosPatientHosp");
			}

			else {

				return mapping.findForward("infosPatientHosp");
			}
		} catch (Exception e) {
			log.fatal(e.getMessage());
			return mapping.findForward("error");
		} finally {
			log.debug("********** Fin chercher GestionCommercialeAction **********");
		}

	}

	@SuppressWarnings("unchecked")
	public ActionForward ajouterPrestationsFormulaire(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		log.debug("********** Debut chercher GestionCommercialeAction **********");
		try {
			GestionCommercialeForm formulaire = (GestionCommercialeForm) form;
			// User
			// user=(User)request.getSession().getAttribute("userConnected");
			// formulaire.setOperateur(user.getLogin());
			formulaire.setPatients(new ArrayList());
			formulaire.setDetailsFactureList(new ArrayList());
			IGestionCommercialeBO gestionCommercialeBO = getGestionCommercialeBO();
			if (gestionCommercialeBO.patientPrestationsFormulaire(formulaire)) {
				gestionCommercialeBO.initialiserCombosPrestations(formulaire);

				return mapping.findForward(FORWARD);
			}

			else {
				return mapping.findForward(FORWARD);
			}
		} catch (Exception e) {
			log.fatal(e.getMessage());
			return mapping.findForward("error");
		} finally {
			log.debug("********** Fin chercher GestionCommercialeAction **********");
		}

	}

	@SuppressWarnings("unchecked")
	public ActionForward ajouterPrestationsFormulaireAncien(
			ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		log.debug("********** Debut ajouterPrestationsFormulaireAncien GestionCommercialeAction **********");
		try {
			GestionCommercialeForm formulaire = (GestionCommercialeForm) form;
			// User
			// user=(User)request.getSession().getAttribute("userConnected");
			// formulaire.setOperateur(user.getLogin());
			formulaire.setPatients(new ArrayList());
			formulaire.setDetailsFactureList(new ArrayList());

			IGestionCommercialeBO gestionCommercialeBO = getGestionCommercialeBO();
			if (gestionCommercialeBO
					.patientPrestationsFormulaireAncien(formulaire)) {

				gestionCommercialeBO.initialiserCombosPrestations(formulaire);

				if (formulaire.getPriseEnChargeFlag().equals("aucune")) {

					return mapping.findForward("infosAncienWithoutPC");
				} else {

					return mapping.findForward("infosAncienWithAssurance");
				}
			}

			else {
				return mapping.findForward(FORWARD);
			}
		} catch (Exception e) {
			log.fatal(e.getMessage());
			return mapping.findForward("error");
		} finally {
			log.debug("********** Fin ajouterPrestationsFormulaireAncien GestionCommercialeAction **********");
		}

	}

	@SuppressWarnings("unchecked")
	public ActionForward ajouterPrestationsFormulaireDevisAncien(
			ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		log.debug("********** Debut ajouterPrestationsFormulaireAncien GestionCommercialeAction **********");
		try {
			GestionCommercialeForm formulaire = (GestionCommercialeForm) form;
			// User
			// user=(User)request.getSession().getAttribute("userConnected");
			// formulaire.setOperateur(user.getLogin());
			formulaire.setPatients(new ArrayList());
			formulaire.setDetailsFactureList(new ArrayList());

			IGestionCommercialeBO gestionCommercialeBO = getGestionCommercialeBO();
			if (gestionCommercialeBO
					.patientPrestationsFormulaireAncien(formulaire)) {

				gestionCommercialeBO.initialiserCombosPrestations(formulaire);

				if (formulaire.getPriseEnChargeFlag().equals("aucune")) {

					return mapping.findForward("infosDevisAncienWithoutPC");
				} else {

					return mapping.findForward("infosDevisAncienWithAssurance");
				}
			}

			else {

				return mapping.findForward(FORWARD);
			}
		} catch (Exception e) {
			log.fatal(e.getMessage());
			return mapping.findForward("error");
		} finally {
			log.debug("********** Fin ajouterPrestationsFormulaireAncien GestionCommercialeAction **********");
		}

	}

	public ActionForward showInfosHospAncien(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		log.debug("********** Debut ajouterPrestationsFormulaireAncien GestionCommercialeAction **********");
		try {
			GestionCommercialeForm formulaire = (GestionCommercialeForm) form;
			// User
			// user=(User)request.getSession().getAttribute("userConnected");
			// formulaire.setOperateur(user.getLogin());
			formulaire.setPatients(new ArrayList());
			formulaire.setDetailsFactureList(new ArrayList());

			IGestionCommercialeBO gestionCommercialeBO = getGestionCommercialeBO();
			if (gestionCommercialeBO
					.patientPrestationsFormulaireAncien(formulaire)) {

				gestionCommercialeBO.initialiserCombosPrestations(formulaire);

				if (formulaire.getPriseEnChargeFlag().equals("aucune")) {

					return mapping.findForward("infosHospAncienWithoutPC");
				} else {

					return mapping.findForward("infosHospAncienWithAssurance");
				}
			}

			else {
				return mapping.findForward(FORWARD);
			}
		} catch (Exception e) {
			log.fatal(e.getMessage());
			return mapping.findForward("error");
		} finally {
			log.debug("********** Fin ajouterPrestationsFormulaireAncien GestionCommercialeAction **********");
		}

	}

	public ActionForward ajouterActe(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		log.debug("********** Debut ajouterActe GestionCommercialeAction **********");
		try {
			GestionCommercialeForm formulaire = (GestionCommercialeForm) form;
			// User
			// user=(User)request.getSession().getAttribute("userConnected");
			// formulaire.setOperateur(user.getLogin());
			IGestionCommercialeBO gestionCommercialeBO = getGestionCommercialeBO();
			ActionMessages errors = new ActionMessages();

			errors = gestionCommercialeBO.checkActeAdd(formulaire);
			if (errors.isEmpty()) {
				if (gestionCommercialeBO.ajouterActe(formulaire)) {

					gestionCommercialeBO
							.initialiserCombosPrestations(formulaire);
					gestionCommercialeBO
							.initialiserChampsAjouterPrestations(formulaire);
					gestionCommercialeBO.initialiserCombosDrgCnam(formulaire);
					return mapping.findForward(FORWARD);
				}

				else {

					return mapping.findForward(FORWARD);
				}
			} else {
				this.saveErrors(request, errors);

				return mapping.findForward(FORWARD);
			}
		} catch (Exception e) {
			e.printStackTrace();
			log.fatal(e.getMessage());
			return mapping.findForward(FORWARD);
		} finally {
			log.debug("********** Fin ajouterActe GestionCommercialeAction **********");
		}

	}

	public ActionForward ajouterDrgPage(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		log.debug("********** Debut ajouterDrgPage GestionCommercialeAction **********");
		try {
			GestionCommercialeForm formulaire = (GestionCommercialeForm) form;
			// User
			// user=(User)request.getSession().getAttribute("userConnected");
			// formulaire.setOperateur(user.getLogin());
			IGestionCommercialeBO gestionCommercialeBO = getGestionCommercialeBO();

			gestionCommercialeBO.initialiserCombosDrgCnam(formulaire);
			formulaire.setTotalMontantDrg("0");
			formulaire.setCoteAssureur("0");

			return mapping.findForward("ajouterDRG");

		} catch (Exception e) {
			e.printStackTrace();
			log.fatal(e.getMessage());
			return mapping.findForward("ajouterDRG");
		} finally {
			log.debug("********** Fin ajouterDrgPage GestionCommercialeAction **********");
		}

	}

	public ActionForward ajouterDrgPageHosp(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		log.debug("********** Debut ajouterDrgPage GestionCommercialeAction **********");
		try {
			GestionCommercialeForm formulaire = (GestionCommercialeForm) form;
			// User
			// user=(User)request.getSession().getAttribute("userConnected");
			// formulaire.setOperateur(user.getLogin());
			IGestionCommercialeBO gestionCommercialeBO = getGestionCommercialeBO();

			if (gestionCommercialeBO.ajouterActesHosp(formulaire)) {
				gestionCommercialeBO.setSortie(formulaire);
				// gestionCommercialeBO.checkRemise(formulaire);
				gestionCommercialeBO.setValeursResteApyerHosp(formulaire);
				gestionCommercialeBO.initialiserCombosDrgCnam(formulaire);

				return mapping.findForward("ajouterDRGHosp");
			} else {

				return mapping.findForward("ajouterDRGHosp");
			}

		} catch (Exception e) {
			e.printStackTrace();
			log.fatal(e.getMessage());
			return mapping.findForward("ajouterDRGHosp");
		} finally {
			log.debug("********** Fin ajouterDrgPage GestionCommercialeAction **********");
		}

	}

	public ActionForward ajouterActeDevis(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		log.debug("********** Debut ajouterActeDevis GestionCommercialeAction **********");
		try {
			GestionCommercialeForm formulaire = (GestionCommercialeForm) form;
			// User
			// user=(User)request.getSession().getAttribute("userConnected");
			// formulaire.setOperateur(user.getLogin());
			IGestionCommercialeBO gestionCommercialeBO = getGestionCommercialeBO();

			if (gestionCommercialeBO.ajouterActeDevis(formulaire)) {

				gestionCommercialeBO.initialiserCombosPrestations(formulaire);
				gestionCommercialeBO
						.initialiserChampsAjouterPrestations(formulaire);

			}

			return mapping.findForward("ajoutPrestationDevis");

		} catch (Exception e) {
			e.printStackTrace();
			log.fatal(e.getMessage());
			return mapping.findForward("ajoutPrestationDevis");
		} finally {
			log.debug("********** Fin ajouterActeDevis GestionCommercialeAction **********");
		}

	}

	public ActionForward ajouterActeForHosp(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		log.debug("********** Debut ajouterActe GestionCommercialeAction **********");
		try {
			GestionCommercialeForm formulaire = (GestionCommercialeForm) form;
			// User
			// user=(User)request.getSession().getAttribute("userConnected");
			// formulaire.setOperateur(user.getLogin());
			IGestionCommercialeBO gestionCommercialeBO = getGestionCommercialeBO();
			ActionMessages errors = new ActionMessages();

			errors = gestionCommercialeBO.checkActeAdd(formulaire);
			if (errors.isEmpty()) {
				if (gestionCommercialeBO.ajouterActeForHosp(formulaire)) {

					gestionCommercialeBO
							.initialiserCombosPrestations(formulaire);
					gestionCommercialeBO
							.initialiserChampsAjouterPrestations(formulaire);

					return mapping.findForward("addPrestationHosp");
				}

				else {

					return mapping.findForward("addPrestationHosp");
				}
			} else {
				this.saveErrors(request, errors);

				return mapping.findForward("addPrestationHosp");
			}
		} catch (Exception e) {
			e.printStackTrace();
			log.fatal(e.getMessage());
			return mapping.findForward(FORWARD);
		} finally {
			log.debug("********** Fin ajouterActe GestionCommercialeAction **********");
		}

	}

	public ActionForward construireListePrestCouvertes(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		log.debug("********** Debut construireListePrestCouvertes GestionCommercialeAction **********");
		try {
			GestionCommercialeForm formulaire = (GestionCommercialeForm) form;
			// User
			// user=(User)request.getSession().getAttribute("userConnected");
			// formulaire.setOperateur(user.getLogin());

			IGestionCommercialeBO gestionCommercialeBO = getGestionCommercialeBO();
			ActionMessages errors = new ActionMessages();
			errors = gestionCommercialeBO.checkPrestCouvAdd(formulaire);
			if (errors.isEmpty()) {
				if (gestionCommercialeBO
						.construireListePrestCouvertes(formulaire)) {

					gestionCommercialeBO
							.initialiserCombosPrestations(formulaire);
					gestionCommercialeBO
							.RechargerCombosEntreprisesAndCategories(formulaire);

					return mapping.findForward("infosPatient");
				}

				else {

					return mapping.findForward("infosPatient");
				}
			} else {
				this.saveErrors(request, errors);

				return mapping.findForward("infosPatient");
			}

		} catch (Exception e) {
			log.fatal(e.getMessage());
			return mapping.findForward("error");
		} finally {
			log.debug("********** Fin construireListePrestCouvertes GestionCommercialeAction **********");
		}

	}

	public ActionForward construireListePrestCouvertesAncien(
			ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		log.debug("********** Debut construireListePrestCouvertesAncien GestionCommercialeAction **********");
		try {
			GestionCommercialeForm formulaire = (GestionCommercialeForm) form;
			// User
			// user=(User)request.getSession().getAttribute("userConnected");
			// formulaire.setOperateur(user.getLogin());

			IGestionCommercialeBO gestionCommercialeBO = getGestionCommercialeBO();
			ActionMessages errors = new ActionMessages();
			errors = gestionCommercialeBO.checkPrestCouvAdd(formulaire);
			if (errors.isEmpty()) {
				if (gestionCommercialeBO
						.construireListePrestCouvertes(formulaire)) {

					gestionCommercialeBO
							.initialiserCombosPrestations(formulaire);
					gestionCommercialeBO
							.RechargerCombosEntreprisesAndCategories(formulaire);

					return mapping.findForward("infosAncienWithoutPC");
				}

				else {

					return mapping.findForward("infosAncienWithoutPC");
				}
			} else {
				this.saveErrors(request, errors);

				return mapping.findForward("infosAncienWithoutPC");
			}

		} catch (Exception e) {
			log.fatal(e.getMessage());
			return mapping.findForward("error");
		} finally {
			log.debug("********** Fin construireListePrestCouvertesAncien GestionCommercialeAction **********");
		}

	}

	public ActionForward construireListePrestCouvertesAncienHosp(
			ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		log.debug("********** Debut construireListePrestCouvertesAncienHosp GestionCommercialeAction **********");
		try {
			GestionCommercialeForm formulaire = (GestionCommercialeForm) form;
			// User
			// user=(User)request.getSession().getAttribute("userConnected");
			// formulaire.setOperateur(user.getLogin());

			IGestionCommercialeBO gestionCommercialeBO = getGestionCommercialeBO();
			ActionMessages errors = new ActionMessages();
			errors = gestionCommercialeBO.checkPrestCouvAdd(formulaire);
			if (errors.isEmpty()) {
				if (gestionCommercialeBO
						.construireListePrestCouvertes(formulaire)) {

					gestionCommercialeBO
							.initialiserCombosPrestations(formulaire);
					gestionCommercialeBO
							.RechargerCombosEntreprisesAndCategories(formulaire);

					return mapping.findForward("infosHospAncienWithoutPC");
				}

				else {

					return mapping.findForward("infosHospAncienWithoutPC");
				}
			} else {
				this.saveErrors(request, errors);

				return mapping.findForward("infosHospAncienWithoutPC");
			}

		} catch (Exception e) {
			log.fatal(e.getMessage());
			return mapping.findForward("error");
		} finally {
			log.debug("********** Fin construireListePrestCouvertesAncienHosp GestionCommercialeAction **********");
		}

	}

	public ActionForward construireListePrestCouvertesHosp(
			ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		log.debug("********** Debut construireListePrestCouvertesHosp GestionCommercialeAction **********");
		try {
			GestionCommercialeForm formulaire = (GestionCommercialeForm) form;
			// User
			// user=(User)request.getSession().getAttribute("userConnected");
			// formulaire.setOperateur(user.getLogin());

			IGestionCommercialeBO gestionCommercialeBO = getGestionCommercialeBO();
			ActionMessages errors = new ActionMessages();
			errors = gestionCommercialeBO.checkPrestCouvAdd(formulaire);
			if (errors.isEmpty()) {
				if (gestionCommercialeBO
						.construireListePrestCouvertes(formulaire)) {

					gestionCommercialeBO
							.initialiserCombosPrestations(formulaire);
					gestionCommercialeBO
							.RechargerCombosEntreprisesAndCategories(formulaire);

					return mapping.findForward("infosPatientHosp");
				}

				else {

					return mapping.findForward("infosPatientHosp");
				}
			} else {
				this.saveErrors(request, errors);

				return mapping.findForward("infosPatientHosp");
			}

		} catch (Exception e) {
			log.fatal(e.getMessage());
			return mapping.findForward("error");
		} finally {
			log.debug("********** Fin construireListePrestCouvertesHosp GestionCommercialeAction **********");
		}

	}

	public ActionForward supprimerPrestFromListePrestCouvertes(
			ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		log.debug("********** Debut ajouterActe GestionCommercialeAction **********");
		try {
			GestionCommercialeForm formulaire = (GestionCommercialeForm) form;
			// User
			// user=(User)request.getSession().getAttribute("userConnected");
			// formulaire.setOperateur(user.getLogin());

			IGestionCommercialeBO gestionCommercialeBO = getGestionCommercialeBO();
			if (gestionCommercialeBO
					.supprimerPrestFromListePrestCouvertes(formulaire)) {

				gestionCommercialeBO.initialiserCombosPrestations(formulaire);
				gestionCommercialeBO
						.RechargerCombosEntreprisesAndCategories(formulaire);

				return mapping.findForward("infosPatient");
			}

			else {

				return mapping.findForward("infosPatient");
			}
		} catch (Exception e) {
			log.fatal(e.getMessage());
			return mapping.findForward("error");
		} finally {
			log.debug("********** Fin ajouterActe GestionCommercialeAction **********");
		}

	}

	public ActionForward supprimerPrestFromListeDevis(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		log.debug("********** Debut supprimerPrestFromListeDevis GestionCommercialeAction **********");
		try {
			GestionCommercialeForm formulaire = (GestionCommercialeForm) form;
			// User
			// user=(User)request.getSession().getAttribute("userConnected");
			// formulaire.setOperateur(user.getLogin());

			IGestionCommercialeBO gestionCommercialeBO = getGestionCommercialeBO();
			if (gestionCommercialeBO.supprimerPrestFromListeDevis(formulaire)) {

				gestionCommercialeBO.initialiserCombosPrestations(formulaire);
				gestionCommercialeBO
						.RechargerCombosEntreprisesAndCategories(formulaire);

				return mapping.findForward("ajoutPrestationDevis");
			}

			else {

				return mapping.findForward("ajoutPrestationDevis");
			}
		} catch (Exception e) {
			log.fatal(e.getMessage());
			return mapping.findForward("error");
		} finally {
			log.debug("********** Fin supprimerPrestFromListeDevis GestionCommercialeAction **********");
		}

	}

	public ActionForward imprimer(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		log.debug("********** Debut imprimer GestionCommercialeAction **********");
		try {
			GestionCommercialeForm formulaire = (GestionCommercialeForm) form;
			// User
			// user=(User)request.getSession().getAttribute("userConnected");
			// formulaire.setOperateur(user.getLogin());

			IImpressionBO impressionBO = getImpressionBO();
			// impressionBO

			return mapping.findForward(FORWARD);

		} catch (Exception e) {
			e.printStackTrace();
			log.fatal(e.getMessage());
			return mapping.findForward("error");
		} finally {
			log.debug("********** Fin imprimer GestionCommercialeAction **********");
		}

	}

	@SuppressWarnings("unchecked")
	public ActionForward gestionCom(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		log.debug("********** Debut gestionCom GestionCommercialeAction **********");
		try {
			GestionCommercialeForm formulaire = (GestionCommercialeForm) form;

			formulaire.setOperateur(formulaire.getLogin());
			formulaire.setPatients(null);
			formulaire.setPrestationCouvertesPcs(new ArrayList());
			formulaire.setDetailsFactureList(new ArrayList());

			IGestionCommercialeBO gestionCommercialeBO = getGestionCommercialeBO();
			ActionMessages errors = new ActionMessages();
			errors = gestionCommercialeBO.getUser(formulaire);
			if (errors.isEmpty()) {
				return mapping.findForward("gestionCom");
			} else {
				return mapping.findForward("error");
			}

		} catch (Exception e) {
			log.fatal(e.getMessage());
			return mapping.findForward("error");
		} finally {
			log.debug("********** Fin gestionCom GestionCommercialeAction **********");
		}

	}

	@SuppressWarnings("unchecked")
	public ActionForward precedent(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		log.debug("********** Debut infosPatient GestionCommercialeAction **********");
		try {
			GestionCommercialeForm formulaire = (GestionCommercialeForm) form;

			formulaire.setOperateur(formulaire.getLogin());

			String subAction = formulaire.getSubAction();

			if (subAction.equals("infosPatient")) {
				formulaire.setDetailsFactureList(new ArrayList());
				return mapping.findForward("infosPatient");
			}

			else if (subAction.equals("hospitalises")) {

				return listHospitalises(mapping, formulaire, request, response);
			}

			else if (subAction.equals("accueil")) {
				IGestionCommercialeBO gestionCommercialeBO = getGestionCommercialeBO();
				gestionCommercialeBO.initialiserForm(formulaire);
				return mapping.findForward("modules");
			}

			else if (subAction.equals("authentification")) {
				IGestionCommercialeBO gestionCommercialeBO = getGestionCommercialeBO();
				gestionCommercialeBO.initialiserForm(formulaire);
				return mapping.findForward("authentification");
			}

			return mapping.findForward("error");

		} catch (Exception e) {
			log.fatal(e.getMessage());
			return mapping.findForward("error");
		} finally {
			log.debug("********** Fin infosPatient GestionCommercialeAction **********");
		}

	}

	public ActionForward infosPatientHosp(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		log.debug("********** Debut infosPatient GestionCommercialeAction **********");
		try {
			GestionCommercialeForm formulaire = (GestionCommercialeForm) form;
			// User
			// user=(User)request.getSession().getAttribute("userConnected");
			// formulaire.setOperateur(user.getLogin());
			formulaire.setPatients(null);
			formulaire.setPrestationCouvertesPcs(new ArrayList());
			formulaire.setDetailsFactureList(new ArrayList());

			IGestionCommercialeBO gestionCommercialeBO = getGestionCommercialeBO();
			ActionMessages errors = new ActionMessages();
			errors = gestionCommercialeBO.getUser(formulaire);
			if (errors.isEmpty()) {
				gestionCommercialeBO.initialiserForm(formulaire);
				gestionCommercialeBO.initialiserCombosAssureur(formulaire);
				gestionCommercialeBO.initialiserCombosPrestations(formulaire);

				return mapping.findForward("infosPatientHosp");
			}

			{
				return mapping.findForward("error");
			}

		} catch (Exception e) {
			log.fatal(e.getMessage());
			return mapping.findForward("error");
		} finally {
			log.debug("********** Fin infosPatient GestionCommercialeAction **********");
		}

	}

	public ActionForward mainPageHospit(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		log.debug("********** Debut infosPatient GestionCommercialeAction **********");
		try {
			GestionCommercialeForm formulaire = (GestionCommercialeForm) form;
			// User
			// user=(User)request.getSession().getAttribute("userConnected");
			// formulaire.setOperateur(user.getLogin());

			IGestionCommercialeBO gestionCommercialeBO = getGestionCommercialeBO();
			ActionMessages errors = new ActionMessages();
			errors = gestionCommercialeBO.getUser(formulaire);
			if (errors.isEmpty()) {
				gestionCommercialeBO.initialiserForm(formulaire);

				return mapping.findForward("mainPageHospit");
			} else {
				return mapping.findForward("error");
			}

		} catch (Exception e) {
			log.fatal(e.getMessage());
			return mapping.findForward("error");
		} finally {
			log.debug("********** Fin infosPatient GestionCommercialeAction **********");
		}

	}

	@SuppressWarnings("unchecked")
	public ActionForward reglementRecu(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		log.debug("********** Debut reglementRecu GestionCommercialeAction **********");
		try {
			GestionCommercialeForm formulaire = (GestionCommercialeForm) form;
			// User
			// user=(User)request.getSession().getAttribute("userConnected");
			// formulaire.setOperateur(user.getLogin());
			formulaire.setReglementsList(new ArrayList());
			IGestionCommercialeBO gestionCommercialeBO = getGestionCommercialeBO();
			gestionCommercialeBO.checkRemise(formulaire);
			gestionCommercialeBO.setValeursResteApyer(formulaire);
			gestionCommercialeBO.initialiserCombosTypePyement(formulaire);
			gestionCommercialeBO.initialiserCombosPcPersonnel(formulaire);

			return mapping.findForward("reglement");

		} catch (Exception e) {
			e.printStackTrace();
			log.fatal(e.getMessage());
			return mapping.findForward("error");
		} finally {
			log.debug("********** Fin reglementRecu GestionCommercialeAction **********");
		}

	}

	public ActionForward addReglement(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		log.debug("********** Debut Addreglement GestionCommercialeAction **********");
		try {
			GestionCommercialeForm formulaire = (GestionCommercialeForm) form;
			// User
			// user=(User)request.getSession().getAttribute("userConnected");
			// formulaire.setOperateur(user.getLogin());

			IGestionCommercialeBO gestionCommercialeBO = getGestionCommercialeBO();
			gestionCommercialeBO.ajouterRegelement(formulaire);
			gestionCommercialeBO.initialiserCombosTypePyement(formulaire);
			gestionCommercialeBO.initialiserCombosPcPersonnel(formulaire);

			return mapping.findForward("reglement");

		} catch (Exception e) {
			log.fatal(e.getMessage());
			return mapping.findForward("error");
		} finally {
			log.debug("********** Fin Addreglement GestionCommercialeAction **********");
		}

	}

	public ActionForward addReglementHosp(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		log.debug("********** Debut Addreglement GestionCommercialeAction **********");
		try {
			GestionCommercialeForm formulaire = (GestionCommercialeForm) form;
			// User
			// user=(User)request.getSession().getAttribute("userConnected");
			// formulaire.setOperateur(user.getLogin());

			IGestionCommercialeBO gestionCommercialeBO = getGestionCommercialeBO();
			gestionCommercialeBO.ajouterRegelement(formulaire);
			gestionCommercialeBO.initialiserCombosTypePyement(formulaire);
			gestionCommercialeBO.initialiserCombosPcPersonnel(formulaire);

			return mapping.findForward("showReglementHosp");

		} catch (Exception e) {
			log.fatal(e.getMessage());
			return mapping.findForward("error");
		} finally {
			log.debug("********** Fin Addreglement GestionCommercialeAction **********");
		}

	}

	public ActionForward supprimerReglement(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		log.debug("********** Debut supprimerReglement GestionCommercialeAction **********");
		try {
			GestionCommercialeForm formulaire = (GestionCommercialeForm) form;
			// User
			// user=(User)request.getSession().getAttribute("userConnected");
			// formulaire.setOperateur(user.getLogin());

			IGestionCommercialeBO gestionCommercialeBO = getGestionCommercialeBO();
			gestionCommercialeBO
					.supprimerReglementFromListeReglement(formulaire);
			gestionCommercialeBO.initialiserCombosTypePyement(formulaire);
			gestionCommercialeBO.initialiserCombosPcPersonnel(formulaire);

			return mapping.findForward("reglement");

		} catch (Exception e) {
			log.fatal(e.getMessage());
			return mapping.findForward("error");
		} finally {
			log.debug("********** Fin supprimerReglement GestionCommercialeAction **********");
		}

	}

	public ActionForward supprimerReglementHosp(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		log.debug("********** Debut supprimerReglement GestionCommercialeAction **********");
		try {
			GestionCommercialeForm formulaire = (GestionCommercialeForm) form;
			// User
			// user=(User)request.getSession().getAttribute("userConnected");
			// formulaire.setOperateur(user.getLogin());

			IGestionCommercialeBO gestionCommercialeBO = getGestionCommercialeBO();
			gestionCommercialeBO
					.supprimerReglementHospFromListeReglement(formulaire);
			gestionCommercialeBO.initialiserCombosTypePyement(formulaire);
			gestionCommercialeBO.initialiserCombosPcPersonnel(formulaire);

			return mapping.findForward("showReglementHosp");

		} catch (Exception e) {
			e.printStackTrace();
			log.fatal(e.getMessage());
			return mapping.findForward("error");
		} finally {
			log.debug("********** Fin supprimerReglement GestionCommercialeAction **********");
		}

	}

	public ActionForward afficherRecu(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		log.debug("********** Debut afficherRecu GestionCommercialeAction **********");
		try {
			GestionCommercialeForm formulaire = (GestionCommercialeForm) form;
			// User
			// user=(User)request.getSession().getAttribute("userConnected");
			// formulaire.setOperateur(user.getLogin());

			IGestionCommercialeBO gestionCommercialeBO = getGestionCommercialeBO();
			gestionCommercialeBO.checkReglementPCByAssureur(formulaire);
			if (gestionCommercialeBO.ajouterRecuFacture(formulaire)) {

				return mapping.findForward("modules");
			} else {

				return mapping.findForward("modules");
			}

		} catch (Exception e) {
			log.fatal(e.getMessage());
			return mapping.findForward("error");
		} finally {
			log.debug("********** Fin afficherRecu GestionCommercialeAction **********");
		}

	}

	public ActionForward afficherRecuCNAM(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		log.debug("********** Debut afficherRecuCNAM GestionCommercialeAction **********");
		try {
			GestionCommercialeForm formulaire = (GestionCommercialeForm) form;
			// User
			// user=(User)request.getSession().getAttribute("userConnected");
			// formulaire.setOperateur(user.getLogin());

			IGestionCommercialeBO gestionCommercialeBO = getGestionCommercialeBO();
			gestionCommercialeBO.checkReglementPCByAssureurCNAM(formulaire);
			if (gestionCommercialeBO.ajouterRecuFacture(formulaire)) {

				return mapping.findForward("modules");
			} else {

				return mapping.findForward("modules");
			}

		} catch (Exception e) {
			log.fatal(e.getMessage());
			return mapping.findForward("error");
		} finally {
			log.debug("********** Fin afficherRecuCNAM GestionCommercialeAction **********");
		}

	}

	public ActionForward afficherRecuHosp(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		log.debug("********** Debut afficherRecuHosp GestionCommercialeAction **********");
		try {
			GestionCommercialeForm formulaire = (GestionCommercialeForm) form;
			// User
			// user=(User)request.getSession().getAttribute("userConnected");
			// formulaire.setOperateur(user.getLogin());

			IGestionCommercialeBO gestionCommercialeBO = getGestionCommercialeBO();
			// gestionCommercialeBO.fermerSession();
			gestionCommercialeBO.checkReglementPCByAssureur(formulaire);
			gestionCommercialeBO.addReglementAvance(formulaire);
			if (gestionCommercialeBO.ajouterRecuFactureHosp(formulaire)) {
				// ImpressionBO impressionBO =ImpressionBO.getInstance();
				// impressionBO.genererFacture(formulaire.getFactureId(),
				// "ORIGINAL");

				return mapping.findForward("modules");
			} else {

				return mapping.findForward("showRecuHosp");
			}

		} catch (Exception e) {
			log.fatal(e.getMessage());
			return mapping.findForward("error");
		} finally {
			log.debug("********** Fin afficherRecuHosp GestionCommercialeAction **********");
		}

	}

	public ActionForward afficherRecuCNAMHosp(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		log.debug("********** Debut afficherRecuCNAMHosp GestionCommercialeAction **********");
		try {
			GestionCommercialeForm formulaire = (GestionCommercialeForm) form;
			// User
			// user=(User)request.getSession().getAttribute("userConnected");
			// formulaire.setOperateur(user.getLogin());

			IGestionCommercialeBO gestionCommercialeBO = getGestionCommercialeBO();
			gestionCommercialeBO.checkReglementPCByAssureurCNAM(formulaire);
			gestionCommercialeBO.addReglementAvance(formulaire);
			if (gestionCommercialeBO.ajouterRecuFactureHosp(formulaire)) {

				return mapping.findForward("modules");
			} else {

				return mapping.findForward("modules");
			}

		} catch (Exception e) {
			log.fatal(e.getMessage());
			return mapping.findForward("error");
		} finally {
			log.debug("********** Fin afficherRecuCNAMHosp GestionCommercialeAction **********");
		}

	}

	public ActionForward creerRecuHosp(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		log.debug("********** Debut creerRecuHosp GestionCommercialeAction **********");
		try {
			GestionCommercialeForm formulaire = (GestionCommercialeForm) form;
			// User
			// user=(User)request.getSession().getAttribute("userConnected");
			// formulaire.setOperateur(user.getLogin());

			IGestionCommercialeBO gestionCommercialeBO = getGestionCommercialeBO();

			if (gestionCommercialeBO.creerRecuHosp(formulaire)) {

				/*
				 * ImpressionBO impressionBO =ImpressionBO.getInstance(); byte[]
				 * bytes
				 * =impressionBO.genererRecu(formulaire.getRecu().getRecuId(),
				 * "ORIGNINAL");
				 * 
				 * ByteArrayOutputStream bos = new
				 * ByteArrayOutputStream(bytes.length); bos.write(bytes);
				 * 
				 * response.setContentType("application/pdf");
				 * response.setContentLength(bos.size());
				 * 
				 * OutputStream os = response.getOutputStream();
				 * os.write(bos.toByteArray(), 0, bos.size()); os.flush();
				 * os.close();
				 */
				return mapping.findForward("listHospitalises");
			} else {

				return mapping.findForward("listHospitalises");
			}

		} catch (Exception e) {
			log.fatal(e.getMessage());
			return mapping.findForward("error");
		} finally {
			log.debug("********** Fin creerRecuHosp GestionCommercialeAction **********");
		}

	}

	public ActionForward imprimerRecuHosp(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		log.debug("********** Debut imprimerRecuHosp GestionCommercialeAction **********");
		try {
			GestionCommercialeForm formulaire = (GestionCommercialeForm) form;
			// User
			// user=(User)request.getSession().getAttribute("userConnected");
			// formulaire.setOperateur(user.getLogin());

			IImpressionBO impressionBO = getImpressionBO();
			byte[] bytes = impressionBO.genererRecu(formulaire.getRecu()
					.getRecuId(), "ORIGNINAL");

			ByteArrayOutputStream bos = new ByteArrayOutputStream(bytes.length);
			bos.write(bytes);

			response.setContentType("application/pdf");
			response.setContentLength(bos.size());

			OutputStream os = response.getOutputStream();
			os.write(bos.toByteArray(), 0, bos.size());
			os.flush();
			os.close();

			return mapping.findForward(null);

		} catch (Exception e) {
			log.fatal(e.getMessage());
			return mapping.findForward("error");
		} finally {
			log.debug("********** Fin imprimerRecuHosp GestionCommercialeAction **********");
		}

	}

	public ActionForward imprimerRecuHospRegle(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		log.debug("********** Debut imprimerRecuHospRegle GestionCommercialeAction **********");
		try {
			GestionCommercialeForm formulaire = (GestionCommercialeForm) form;
			// User
			// user=(User)request.getSession().getAttribute("userConnected");
			// formulaire.setOperateur(user.getLogin());

			System.out.println(" id hosp" + formulaire.getFactureId());

			IImpressionBO impressionBO = getImpressionBO();
			byte[] bytes = impressionBO.genererFactureHosp(
					formulaire.getFactureId(), "ORIGNINAL");

			ByteArrayOutputStream bos = new ByteArrayOutputStream(bytes.length);
			bos.write(bytes);

			response.setContentType("application/pdf");
			response.setContentLength(bos.size());

			OutputStream os = response.getOutputStream();
			os.write(bos.toByteArray(), 0, bos.size());
			os.flush();
			os.close();

			return mapping.findForward(null);

		} catch (Exception e) {
			log.fatal(e.getMessage());
			return mapping.findForward("error");
		} finally {
			log.debug("********** Fin imprimerRecuHospRegle GestionCommercialeAction **********");
		}

	}

	public ActionForward imprimerRecu(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		log.debug("********** Debut imprimerRecu GestionCommercialeAction **********");
		try {
			GestionCommercialeForm formulaire = (GestionCommercialeForm) form;
			// User
			// user=(User)request.getSession().getAttribute("userConnected");
			// formulaire.setOperateur(user.getLogin());

			IImpressionBO impressionBO = getImpressionBO();
			byte[] bytes = impressionBO.genererFacture(
					formulaire.getFactureId(), "ORIGINAL");

			ByteArrayOutputStream bos = new ByteArrayOutputStream(bytes.length);
			bos.write(bytes);

			response.setContentType("application/pdf");
			response.setContentLength(bos.size());

			OutputStream os = response.getOutputStream();
			os.write(bos.toByteArray(), 0, bos.size());
			os.flush();
			os.close();

			return mapping.findForward(null);

		} catch (Exception e) {
			log.fatal(e.getMessage());
			e.printStackTrace();
			return mapping.findForward("error");
		} finally {
			log.debug("********** Fin imprimerRecu GestionCommercialeAction **********");
		}

	}

	public ActionForward creerDevis(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		log.debug("********** Debut creerDevis GestionCommercialeAction **********");
		try {
			GestionCommercialeForm formulaire = (GestionCommercialeForm) form;

			IGestionCommercialeBO gestionCommercialeBO = getGestionCommercialeBO();

			if (gestionCommercialeBO.creerDevis(formulaire)) {

				return mapping.findForward("modules");
			} else {

				return mapping.findForward("modules");
			}

		} catch (Exception e) {
			log.fatal(e.getMessage());
			return mapping.findForward("error");
		} finally {
			log.debug("********** Fin creerDevis GestionCommercialeAction **********");
		}

	}

	@SuppressWarnings("unchecked")
	public ActionForward savePatientForActesHosp(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		log.debug("********** Debut savePatientForActesHosp GestionCommercialeAction **********");
		try {
			GestionCommercialeForm formulaire = (GestionCommercialeForm) form;
			// User
			// user=(User)request.getSession().getAttribute("userConnected");
			// formulaire.setOperateur(user.getLogin());
			formulaire.setPatients(new ArrayList());

			IGestionCommercialeBO gestionCommercialeBO = getGestionCommercialeBO();
			ActionMessages errors = new ActionMessages();
			errors = gestionCommercialeBO.checkBadge(formulaire,
					formulaire.getPatient());
			if (errors.isEmpty()) {
				if (gestionCommercialeBO.addPatientForPrestations(formulaire)) {
					if (gestionCommercialeBO
							.patientPrestationsFormulaire(formulaire)) {
						gestionCommercialeBO
								.initialiserCombosPrestations(formulaire);
						gestionCommercialeBO
								.initialiserCombosChambres(formulaire);

						return mapping.findForward("choisirChambre");
					}

					else {

						return mapping.findForward("infosPatientHosp");
					}
				} else {

					return mapping.findForward("infosPatientHosp");
				}
			} else {
				this.saveErrors(request, errors);
				gestionCommercialeBO
						.RechargerCombosEntreprisesAndCategories(formulaire);
				return mapping.findForward("infosPatientHosp");
			}

		} catch (Exception e) {
			log.fatal(e.getMessage());
			return mapping.findForward("error");
		} finally {
			log.debug("********** Fin savePatientForActesHosp GestionCommercialeAction **********");
		}

	}

	@SuppressWarnings("unchecked")
	public ActionForward savePatientForActes(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		log.debug("********** Debut savePatientForActes GestionCommercialeAction **********");
		try {
			GestionCommercialeForm formulaire = (GestionCommercialeForm) form;
			// User
			// user=(User)request.getSession().getAttribute("userConnected");
			// formulaire.setOperateur(user.getLogin());
			formulaire.setPatients(new ArrayList());

			IGestionCommercialeBO gestionCommercialeBO = getGestionCommercialeBO();
			ActionMessages errors = new ActionMessages();
			errors = gestionCommercialeBO.checkBadge(formulaire,
					formulaire.getPatient());
			if (errors.isEmpty()) {
				if (gestionCommercialeBO.addPatientForPrestations(formulaire)) {
					if (gestionCommercialeBO
							.patientPrestationsFormulaire(formulaire)) {
						gestionCommercialeBO
								.initialiserCombosPrestations(formulaire);
						gestionCommercialeBO
								.initialiserCombosDrgCnam(formulaire);
						return mapping.findForward(FORWARD);
					}

					else {
						return mapping.findForward(FORWARD);
					}
				} else {

					return mapping.findForward(FORWARD);
				}
			} else {
				this.saveErrors(request, errors);
				gestionCommercialeBO
						.RechargerCombosEntreprisesAndCategories(formulaire);

				return mapping.findForward("infosPatient");
			}

		} catch (Exception e) {
			log.fatal(e.getMessage());
			return mapping.findForward("error");
		} finally {
			log.debug("********** Fin savePatientForActes GestionCommercialeAction **********");
		}

	}

	@SuppressWarnings("unchecked")
	public ActionForward savePatientForActesDevis(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		log.debug("********** Debut savePatientForActesDevis GestionCommercialeAction **********");
		try {
			GestionCommercialeForm formulaire = (GestionCommercialeForm) form;
			// User
			// user=(User)request.getSession().getAttribute("userConnected");
			// formulaire.setOperateur(user.getLogin());
			formulaire.setPatients(new ArrayList());

			IGestionCommercialeBO gestionCommercialeBO = getGestionCommercialeBO();
			ActionMessages errors = new ActionMessages();
			errors = gestionCommercialeBO.checkBadge(formulaire,
					formulaire.getPatient());
			if (errors.isEmpty()) {
				if (gestionCommercialeBO
						.addPatientForPrestationsDevis(formulaire)) {
					if (gestionCommercialeBO
							.patientPrestationsFormulaire(formulaire)) {
						gestionCommercialeBO
								.initialiserCombosPrestations(formulaire);
						gestionCommercialeBO
								.initialiserCombosDrgCnam(formulaire);
						return mapping.findForward("ajoutPrestationDevis");
					}

					else {
						return mapping.findForward("ajoutPrestationDevis");
					}
				} else {

					return mapping.findForward("ajoutPrestationDevis");
				}
			} else {
				this.saveErrors(request, errors);
				gestionCommercialeBO
						.RechargerCombosEntreprisesAndCategories(formulaire);

				return mapping.findForward("infosPatientDevis");
			}

		} catch (Exception e) {
			log.fatal(e.getMessage());
			return mapping.findForward("error");
		} finally {
			log.debug("********** Fin savePatientForActesDevis GestionCommercialeAction **********");
		}

	}

	@SuppressWarnings("unchecked")
	public ActionForward saveAncienPatientHospWithoutPC(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		log.debug("********** Debut savePatientForActes GestionCommercialeAction **********");
		try {
			GestionCommercialeForm formulaire = (GestionCommercialeForm) form;
			// User
			// user=(User)request.getSession().getAttribute("userConnected");
			// formulaire.setOperateur(user.getLogin());
			formulaire.setPatients(new ArrayList());

			IGestionCommercialeBO gestionCommercialeBO = getGestionCommercialeBO();
			ActionMessages errors = new ActionMessages();
			errors = gestionCommercialeBO.checkBadge(formulaire,
					formulaire.getPatient());
			if (errors.isEmpty()) {
				if (gestionCommercialeBO
						.addAncienPatientWithoutPCInfos(formulaire)) {
					if (gestionCommercialeBO
							.patientPrestationsFormulaire(formulaire)) {
						gestionCommercialeBO
								.initialiserCombosChambres(formulaire);

						return mapping.findForward("choisirChambre");
					}

					else {

						return mapping.findForward("choisirChambre");
					}
				} else {

					return mapping.findForward("choisirChambre");
				}
			} else {
				this.saveErrors(request, errors);
				gestionCommercialeBO
						.RechargerCombosEntreprisesAndCategories(formulaire);

				return mapping.findForward("infosPatientHosp");
			}

		} catch (Exception e) {
			log.fatal(e.getMessage());
			return mapping.findForward("error");
		} finally {
			log.debug("********** Fin savePatientForActes GestionCommercialeAction **********");
		}

	}

	public ActionForward saveAncienPatientWithoutPC(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		log.debug("********** Debut saveAncienPatientWithoutPC GestionCommercialeAction **********");
		try {
			GestionCommercialeForm formulaire = (GestionCommercialeForm) form;
			// User
			// user=(User)request.getSession().getAttribute("userConnected");
			// formulaire.setOperateur(user.getLogin());
			formulaire.setPatients(new ArrayList());

			IGestionCommercialeBO gestionCommercialeBO = getGestionCommercialeBO();
			ActionMessages errors = new ActionMessages();
			errors = gestionCommercialeBO.checkBadge(formulaire,
					formulaire.getPatient());
			if (errors.isEmpty()) {
				if (gestionCommercialeBO
						.addAncienPatientWithoutPCInfos(formulaire)) {
					if (gestionCommercialeBO
							.patientPrestationsFormulaire(formulaire)) {
						gestionCommercialeBO
								.initialiserCombosPrestations(formulaire);

						return mapping.findForward(FORWARD);
					}

					else {

						return mapping.findForward(FORWARD);
					}
				} else {

					return mapping.findForward(FORWARD);
				}
			} else {
				this.saveErrors(request, errors);
				gestionCommercialeBO
						.RechargerCombosEntreprisesAndCategories(formulaire);

				return mapping.findForward("infosPatient");
			}

		} catch (Exception e) {
			log.fatal(e.getMessage());
			return mapping.findForward("error");
		} finally {
			log.debug("********** Fin saveAncienPatientWithoutPC GestionCommercialeAction **********");
		}

	}

	public ActionForward saveAncienDevisPatientWithoutPC(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		log.debug("********** Debut saveAncienDevisPatientWithoutPC GestionCommercialeAction **********");
		try {
			GestionCommercialeForm formulaire = (GestionCommercialeForm) form;
			// User
			// user=(User)request.getSession().getAttribute("userConnected");
			// formulaire.setOperateur(user.getLogin());
			formulaire.setPatients(new ArrayList());

			IGestionCommercialeBO gestionCommercialeBO = getGestionCommercialeBO();

			if (gestionCommercialeBO
					.addAncienDevisPatientWithoutPCInfos(formulaire)) {
				if (gestionCommercialeBO
						.patientPrestationsFormulaire(formulaire)) {
					gestionCommercialeBO
							.initialiserCombosPrestations(formulaire);

					return mapping.findForward("ajoutPrestationDevis");
				}

				else {

					return mapping.findForward("ajoutPrestationDevis");
				}
			} else {

				return mapping.findForward("ajoutPrestationDevis");
			}

		} catch (Exception e) {
			log.fatal(e.getMessage());
			return mapping.findForward("error");
		} finally {
			log.debug("********** Fin saveAncienDevisPatientWithoutPC GestionCommercialeAction **********");
		}

	}

	@SuppressWarnings("unchecked")
	public ActionForward saveAncienDevisPatientWithPC(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		log.debug("********** Debut saveAncienDevisPatientWithPC GestionCommercialeAction **********");
		try {
			GestionCommercialeForm formulaire = (GestionCommercialeForm) form;
			// User
			// user=(User)request.getSession().getAttribute("userConnected");
			// formulaire.setOperateur(user.getLogin());
			formulaire.setPatients(new ArrayList());

			IGestionCommercialeBO gestionCommercialeBO = getGestionCommercialeBO();

			if (gestionCommercialeBO.addAncienPatientWithPC(formulaire)) {
				if (gestionCommercialeBO
						.patientPrestationsFormulaire(formulaire)) {
					gestionCommercialeBO
							.initialiserCombosPrestations(formulaire);

					return mapping.findForward("ajoutPrestationDevis");
				}

				else {

					return mapping.findForward("ajoutPrestationDevis");
				}
			} else {

				return mapping.findForward("ajoutPrestationDevis");
			}

		} catch (Exception e) {
			log.fatal(e.getMessage());
			return mapping.findForward("error");
		} finally {
			log.debug("********** Fin saveAncienDevisPatientWithPC GestionCommercialeAction **********");
		}

	}

	public ActionForward saveAncienPatientWithPC(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		log.debug("********** Debut savePatientForActes GestionCommercialeAction **********");
		try {
			GestionCommercialeForm formulaire = (GestionCommercialeForm) form;
			// User
			// user=(User)request.getSession().getAttribute("userConnected");
			// formulaire.setOperateur(user.getLogin());
			formulaire.setPatients(new ArrayList());

			IGestionCommercialeBO gestionCommercialeBO = getGestionCommercialeBO();
			ActionMessages errors = new ActionMessages();
			errors = gestionCommercialeBO.checkBadge(formulaire,
					formulaire.getPatient());
			if (errors.isEmpty()) {

				if (gestionCommercialeBO.addAncienPatientWithPC(formulaire)) {
					if (gestionCommercialeBO
							.patientPrestationsFormulaire(formulaire)) {
						gestionCommercialeBO
								.initialiserCombosPrestations(formulaire);

						return mapping.findForward(FORWARD);
					}

					else {

						return mapping.findForward(FORWARD);
					}
				} else {

					return mapping.findForward(FORWARD);
				}
			} else {
				this.saveErrors(request, errors);
				gestionCommercialeBO
						.RechargerCombosEntreprisesAndCategories(formulaire);

				return mapping.findForward("infosPatient");
			}

		} catch (Exception e) {
			log.fatal(e.getMessage());
			return mapping.findForward("error");
		} finally {
			log.debug("********** Fin savePatientForActes GestionCommercialeAction **********");
		}

	}

	@SuppressWarnings("unchecked")
	public ActionForward saveAncienPatientHospWithPC(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		log.debug("********** Debut savePatientForActes GestionCommercialeAction **********");
		try {
			GestionCommercialeForm formulaire = (GestionCommercialeForm) form;
			// User
			// user=(User)request.getSession().getAttribute("userConnected");
			// formulaire.setOperateur(user.getLogin());
			formulaire.setPatients(new ArrayList());

			IGestionCommercialeBO gestionCommercialeBO = getGestionCommercialeBO();
			ActionMessages errors = new ActionMessages();
			errors = gestionCommercialeBO.checkBadge(formulaire,
					formulaire.getPatient());
			if (errors.isEmpty()) {
				if (gestionCommercialeBO.addAncienPatientWithPC(formulaire)) {
					if (gestionCommercialeBO
							.patientPrestationsFormulaire(formulaire)) {
						gestionCommercialeBO
								.initialiserCombosChambres(formulaire);

						return mapping.findForward("choisirChambre");
					}

					else {

						return mapping.findForward("choisirChambre");
					}
				} else {

					return mapping.findForward("choisirChambre");
				}
			} else {
				this.saveErrors(request, errors);
				gestionCommercialeBO
						.RechargerCombosEntreprisesAndCategories(formulaire);

				return mapping.findForward("infosPatientHosp");
			}

		} catch (Exception e) {
			log.fatal(e.getMessage());
			return mapping.findForward("error");
		} finally {
			log.debug("********** Fin savePatientForActes GestionCommercialeAction **********");
		}

	}

	@SuppressWarnings("unchecked")
	public ActionForward listHospitalises(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		log.debug("********** Debut listHospitalises GestionCommercialeAction **********");
		try {
			GestionCommercialeForm formulaire = (GestionCommercialeForm) form;
			// User
			// user=(User)request.getSession().getAttribute("userConnected");
			// formulaire.setOperateur(user.getLogin());
			formulaire.setHopitalises(new ArrayList());
			IGestionCommercialeBO gestionCommercialeBO = getGestionCommercialeBO();
			gestionCommercialeBO.initialiserForm(formulaire);
			ActionMessages errors = new ActionMessages();
			errors = gestionCommercialeBO.getUser(formulaire);
			if (errors.isEmpty()) {
				if (gestionCommercialeBO.getListHopitalises(formulaire)) {

					return mapping.findForward("listHospitalises");
				}

				else {

					return mapping.findForward("listHospitalises");
				}
			}
			{
				return mapping.findForward("error");
			}

		} catch (Exception e) {
			log.fatal(e.getMessage());
			return mapping.findForward("error");
		} finally {
			log.debug("********** Fin listHospitalises GestionCommercialeAction **********");
		}

	}

	public ActionForward reserverChambre(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		log.debug("********** Debut reserverChambre GestionCommercialeAction **********");
		try {
			GestionCommercialeForm formulaire = (GestionCommercialeForm) form;
			// User
			// user=(User)request.getSession().getAttribute("userConnected");
			// formulaire.setOperateur(user.getLogin());

			IGestionCommercialeBO gestionCommercialeBO = getGestionCommercialeBO();
			if (gestionCommercialeBO.reserverChambre(formulaire)) {

				gestionCommercialeBO.getListHopitalises(formulaire);

				return mapping.findForward("listHospitalises");
			} else {

				return mapping.findForward("listHospitalises");
			}

		} catch (Exception e) {
			log.fatal(e.getMessage());
			return mapping.findForward("error");
		} finally {
			log.debug("********** Fin reserverChambre GestionCommercialeAction **********");
		}

	}

	public ActionForward changerChambre(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		log.debug("********** Debut reserverChambre GestionCommercialeAction **********");
		try {
			GestionCommercialeForm formulaire = (GestionCommercialeForm) form;
			// User
			// user=(User)request.getSession().getAttribute("userConnected");
			// formulaire.setOperateur(user.getLogin());

			IGestionCommercialeBO gestionCommercialeBO = getGestionCommercialeBO();
			if (gestionCommercialeBO.changerChambre(formulaire)) {
				gestionCommercialeBO.initialiserForm(formulaire);

				gestionCommercialeBO.getListHopitalises(formulaire);

				return mapping.findForward("listHospitalises");
			} else {

				gestionCommercialeBO.initialiserForm(formulaire);

				return mapping.findForward("listHospitalises");
			}

		} catch (Exception e) {
			log.fatal(e.getMessage());
			return mapping.findForward("error");
		} finally {
			log.debug("********** Fin reserverChambre GestionCommercialeAction **********");
		}

	}

	public ActionForward addPrestationHosp(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		log.debug("********** Debut addPrestationHosp GestionCommercialeAction **********");
		try {
			GestionCommercialeForm formulaire = (GestionCommercialeForm) form;
			// User
			// user=(User)request.getSession().getAttribute("userConnected");
			// formulaire.setOperateur(user.getLogin());

			IGestionCommercialeBO gestionCommercialeBO = getGestionCommercialeBO();

			if (gestionCommercialeBO.showHospForAddPrestation(formulaire)) {
				gestionCommercialeBO.initialiserCombosPrestations(formulaire);

				return mapping.findForward("addPrestationHosp");
			} else {

				return mapping.findForward("error");
			}

		} catch (Exception e) {
			log.fatal(e.getMessage());
			return mapping.findForward("error");
		} finally {
			log.debug("********** Fin addPrestationHosp GestionCommercialeAction **********");
		}

	}

	public ActionForward showHospForChangeChambre(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		log.debug("********** Debut showHospForChangeChambre GestionCommercialeAction **********");
		try {
			GestionCommercialeForm formulaire = (GestionCommercialeForm) form;
			// User
			// user=(User)request.getSession().getAttribute("userConnected");
			// formulaire.setOperateur(user.getLogin());

			IGestionCommercialeBO gestionCommercialeBO = getGestionCommercialeBO();

			if (gestionCommercialeBO.showHospForChangeChambre(formulaire)) {
				gestionCommercialeBO.initialiserCombosChambres(formulaire);

				return mapping.findForward("changerChambre");
			} else {

				return mapping.findForward("error");
			}

		} catch (Exception e) {
			log.fatal(e.getMessage());
			return mapping.findForward("error");
		} finally {
			log.debug("********** Fin showHospForChangeChambre GestionCommercialeAction **********");
		}

	}

	public ActionForward showSortieHosp(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		log.debug("********** Debut showSortieHosp GestionCommercialeAction **********");
		try {
			GestionCommercialeForm formulaire = (GestionCommercialeForm) form;
			// User
			// user=(User)request.getSession().getAttribute("userConnected");
			// formulaire.setOperateur(user.getLogin());

			IGestionCommercialeBO gestionCommercialeBO = getGestionCommercialeBO();

			if (gestionCommercialeBO.showHospForSortie(formulaire)) {

				return mapping.findForward("sortieHospitalisation");
			} else {

				return mapping.findForward("error");
			}

		} catch (Exception e) {
			log.fatal(e.getMessage());
			return mapping.findForward("error");
		} finally {
			log.debug("********** Fin showSortieHosp GestionCommercialeAction **********");
		}

	}

	public ActionForward showSortieHospChambreDejaLibre(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		log.debug("********** Debut showSortieHospChambreDejaLibre GestionCommercialeAction **********");
		try {
			GestionCommercialeForm formulaire = (GestionCommercialeForm) form;
			// User
			// user=(User)request.getSession().getAttribute("userConnected");
			// formulaire.setOperateur(user.getLogin());

			IGestionCommercialeBO gestionCommercialeBO = getGestionCommercialeBO();

			if (gestionCommercialeBO.showHospInfosForSortie(formulaire)) {

				return mapping.findForward("sortieHospitalisationInfos");
			} else {

				return mapping.findForward("error");
			}

		} catch (Exception e) {
			log.fatal(e.getMessage());
			return mapping.findForward("error");
		} finally {
			log.debug("********** Fin showSortieHospChambreDejaLibre GestionCommercialeAction **********");
		}

	}

	public ActionForward showLibererChambreHosp(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		log.debug("********** Debut showLibererChambreHosp GestionCommercialeAction **********");
		try {
			GestionCommercialeForm formulaire = (GestionCommercialeForm) form;
			// User
			// user=(User)request.getSession().getAttribute("userConnected");
			// formulaire.setOperateur(user.getLogin());

			IGestionCommercialeBO gestionCommercialeBO = getGestionCommercialeBO();

			if (gestionCommercialeBO.showHospForSortie(formulaire)) {

				return mapping.findForward("libererChambreHosp");
			} else {

				return mapping.findForward("error");
			}

		} catch (Exception e) {
			log.fatal(e.getMessage());
			return mapping.findForward("error");
		} finally {
			log.debug("********** Fin showLibererChambreHosp GestionCommercialeAction **********");
		}

	}

	@SuppressWarnings("unchecked")
	public ActionForward showReglementHosp(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		log.debug("********** Debut showHospForChangeChambre GestionCommercialeAction **********");
		try {
			GestionCommercialeForm formulaire = (GestionCommercialeForm) form;
			// User
			// user=(User)request.getSession().getAttribute("userConnected");
			// formulaire.setOperateur(user.getLogin());

			IGestionCommercialeBO gestionCommercialeBO = getGestionCommercialeBO();

			if (gestionCommercialeBO.ajouterActesHosp(formulaire)) {
				formulaire.setReglementsList(new ArrayList());
				gestionCommercialeBO.setSortie(formulaire);
				gestionCommercialeBO.checkRemise(formulaire);
				gestionCommercialeBO.setValeursResteApyerHosp(formulaire);
				gestionCommercialeBO.initialiserCombosTypePyement(formulaire);
				gestionCommercialeBO.initialiserCombosPcPersonnel(formulaire);

				return mapping.findForward("showReglementHosp");
			} else {

				return mapping.findForward("showReglementHosp");
			}

		} catch (Exception e) {
			log.fatal(e.getMessage());
			return mapping.findForward("error");
		} finally {
			log.debug("********** Fin showHospForChangeChambre GestionCommercialeAction **********");
		}

	}

	public ActionForward libererChambre(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		log.debug("********** Debut libererChambre GestionCommercialeAction **********");
		try {
			GestionCommercialeForm formulaire = (GestionCommercialeForm) form;
			// User
			// user=(User)request.getSession().getAttribute("userConnected");
			// formulaire.setOperateur(user.getLogin());

			IGestionCommercialeBO gestionCommercialeBO = getGestionCommercialeBO();

			gestionCommercialeBO.setLibererChambre(formulaire);
			gestionCommercialeBO.setSortieSansReglement(formulaire);

			gestionCommercialeBO.getListHopitalises(formulaire);

			return mapping.findForward("listHospitalises");

		} catch (Exception e) {
			log.fatal(e.getMessage());
			return mapping.findForward("error");
		} finally {
			log.debug("********** Fin libererChambre GestionCommercialeAction **********");
		}

	}

	@SuppressWarnings("unchecked")
	public ActionForward infosPatient(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		log.debug("********** Debut infosPatient GestionCommercialeAction **********");
		try {
			GestionCommercialeForm formulaire = (GestionCommercialeForm) form;

			formulaire.setOperateur(formulaire.getLogin());
			formulaire.setPatients(null);
			formulaire.setPrestationCouvertesPcs(new ArrayList());
			formulaire.setDetailsFactureList(new ArrayList());

			IGestionCommercialeBO gestionCommercialeBO = getGestionCommercialeBO();
			ActionMessages errors = new ActionMessages();
			errors = gestionCommercialeBO.getUser(formulaire);
			if (errors.isEmpty()) {
				gestionCommercialeBO.initialiserForm(formulaire);
				gestionCommercialeBO.initialiserCombosAssureur(formulaire);
				gestionCommercialeBO.initialiserCombosPrestations(formulaire);

				return mapping.findForward("infosPatient");
			} else {
				return mapping.findForward("error");
			}

		} catch (Exception e) {
			log.fatal(e.getMessage());
			return mapping.findForward("error");
		} finally {
			log.debug("********** Fin infosPatient GestionCommercialeAction **********");
		}

	}

	public ActionForward impressionFactures(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		log.debug("********** Debut impressionFactures GestionCommercialeAction **********");
		try {
			GestionCommercialeForm formulaire = (GestionCommercialeForm) form;

			formulaire.setOperateur(formulaire.getLogin());

			IGestionCommercialeBO gestionCommercialeBO = getGestionCommercialeBO();

			gestionCommercialeBO.initialiserForm(formulaire);
			return mapping.findForward("impressionFact");

		} catch (Exception e) {
			log.fatal(e.getMessage());
			return mapping.findForward("error");
		} finally {
			log.debug("********** Fin impressionFactures GestionCommercialeAction **********");
		}

	}

	public ActionForward modificationFactures(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		log.debug("********** Debut modificationFactures GestionCommercialeAction **********");
		try {
			GestionCommercialeForm formulaire = (GestionCommercialeForm) form;

			formulaire.setOperateur(formulaire.getLogin());

			IGestionCommercialeBO gestionCommercialeBO = getGestionCommercialeBO();

			gestionCommercialeBO.initialiserForm(formulaire);
			return mapping.findForward("modificationFact");

		} catch (Exception e) {
			log.fatal(e.getMessage());
			return mapping.findForward("error");
		} finally {
			log.debug("********** Fin modificationFactures GestionCommercialeAction **********");
		}

	}

	@SuppressWarnings("unchecked")
	public ActionForward listFacturesGenerees(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		log.debug("********** Debut listFacturesAgenerer GestionCommercialeAction **********");
		try {
			GestionCommercialeForm formulaire = (GestionCommercialeForm) form;
			// User
			// user=(User)request.getSession().getAttribute("userConnected");
			// formulaire.setOperateur(user.getLogin());
			formulaire.setFacturesAgenererList(new ArrayList());
			IGestionCommercialeBO gestionCommercialeBO = getGestionCommercialeBO();
			gestionCommercialeBO.initialiserForm(formulaire);

			gestionCommercialeBO.getListFacturesGenerees(formulaire);

			return mapping.findForward("listFacturesGenerees");

		} catch (Exception e) {
			log.fatal(e.getMessage());
			return mapping.findForward("error");
		} finally {
			log.debug("********** Fin listFacturesAgenerer GestionCommercialeAction **********");
		}

	}

	@SuppressWarnings("unchecked")
	public ActionForward listFacturesAgenerer(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		log.debug("********** Debut listFacturesAgenerer GestionCommercialeAction **********");
		try {
			GestionCommercialeForm formulaire = (GestionCommercialeForm) form;
			// User
			// user=(User)request.getSession().getAttribute("userConnected");
			// formulaire.setOperateur(user.getLogin());
			formulaire.setFacturesAgenererList(new ArrayList());
			IGestionCommercialeBO gestionCommercialeBO = getGestionCommercialeBO();
			gestionCommercialeBO.initialiserForm(formulaire);
			formulaire.setIsFirst("false");
			if (gestionCommercialeBO.getListFacturesAgenerer(formulaire)) {

				formulaire.setDateDebutRechFact("");
				formulaire.setDateFinRechFact("");

				return mapping.findForward("listFacturesAgenerer");
			}

			else {

				return mapping.findForward("listFacturesAgenerer");
			}

		} catch (Exception e) {
			log.fatal(e.getMessage());
			return mapping.findForward("error");
		} finally {
			log.debug("********** Fin listFacturesAgenerer GestionCommercialeAction **********");
		}

	}

	public ActionForward pageFactureAgenerer(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		log.debug("********** Debut pageFactureAgenerer GestionCommercialeAction **********");
		try {

			GestionCommercialeForm formulaire = (GestionCommercialeForm) form;
			// User
			// user=(User)request.getSession().getAttribute("userConnected");
			// formulaire.setOperateur(user.getLogin());
			formulaire.setFacturesAgenererList(new ArrayList());
			IGestionCommercialeBO gestionCommercialeBO = getGestionCommercialeBO();
			gestionCommercialeBO.initialiserForm(formulaire);
			formulaire.setIsFirst("true");

			return mapping.findForward("listFacturesAgenerer");

		} catch (Exception e) {
			log.fatal(e.getMessage());
			return mapping.findForward("error");
		} finally {
			log.debug("********** Fin pageFactureAgenerer GestionCommercialeAction **********");
		}

	}

	public ActionForward genererFactureAssureur(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		log.debug("********** Debut genererFactureAssureur GestionCommercialeAction **********");
		try {

			GestionCommercialeForm formulaire = (GestionCommercialeForm) form;
			IGestionCommercialeBO gestionCommercialeBO = getGestionCommercialeBO();
			gestionCommercialeBO.genererFacture(formulaire);
			gestionCommercialeBO.initialiserForm(formulaire);

			return mapping.findForward("modules");

		} catch (Exception e) {
			log.fatal(e.getMessage());
			return mapping.findForward("error");
		} finally {
			log.debug("********** Fin genererFactureAssureur GestionCommercialeAction **********");
		}

	}

	public ActionForward showPatientForModifiationFacture(
			ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		log.debug("********** Debut showPatientForModifiationFacture GestionCommercialeAction **********");
		try {
			GestionCommercialeForm formulaire = (GestionCommercialeForm) form;

			IGestionCommercialeBO gestionCommercialeBO = getGestionCommercialeBO();
			gestionCommercialeBO.infosForModificationFacture(formulaire);
			gestionCommercialeBO.initialiserCombosPrestations(formulaire);
			gestionCommercialeBO.initialiserCombosDrgCnam(formulaire);

			if (formulaire.getIsHospitalisation().equals("0")) {
				return mapping.findForward("infosFactureAmodifier");
			} else {
				return mapping.findForward("infosFactureHospAmodifier");
			}

		} catch (Exception e) {
			log.fatal(e.getMessage());
			return mapping.findForward("error");
		} finally {
			log.debug("********** Fin showPatientForModifiationFacture GestionCommercialeAction **********");
		}

	}

	public ActionForward ajouterActeModificationFactureAssureur(
			ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		log.debug("********** Debut ajouterActeModificationFactureAssureur GestionCommercialeAction **********");
		try {
			GestionCommercialeForm formulaire = (GestionCommercialeForm) form;
			// User
			// user=(User)request.getSession().getAttribute("userConnected");
			// formulaire.setOperateur(user.getLogin());
			IGestionCommercialeBO gestionCommercialeBO = getGestionCommercialeBO();
			ActionMessages errors = new ActionMessages();

			errors = gestionCommercialeBO
					.checkActeAddForModificationFacture(formulaire);
			if (errors.isEmpty()) {
				if (gestionCommercialeBO
						.ajouterActeForModificationFacture(formulaire)) {

					gestionCommercialeBO
							.initialiserCombosPrestations(formulaire);
					gestionCommercialeBO
							.initialiserChampsAjouterPrestations(formulaire);

					return mapping.findForward("infosFactureAmodifier");
				}

				else {

					return mapping.findForward("infosFactureAmodifier");
				}
			} else {
				this.saveErrors(request, errors);

				return mapping.findForward("infosFactureAmodifier");
			}
		} catch (Exception e) {
			e.printStackTrace();
			log.fatal(e.getMessage());
			return mapping.findForward("infosFactureAmodifier");
		} finally {
			log.debug("********** Fin ajouterActeModificationFactureAssureur GestionCommercialeAction **********");
		}

	}

	@SuppressWarnings("unchecked")
	public ActionForward infosPatientDevis(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		log.debug("********** Debut infosPatient GestionCommercialeAction **********");
		try {
			GestionCommercialeForm formulaire = (GestionCommercialeForm) form;

			formulaire.setOperateur(formulaire.getLogin());
			formulaire.setPatients(null);
			formulaire.setPrestationCouvertesPcs(new ArrayList());
			formulaire.setDetailsFactureList(new ArrayList());

			IGestionCommercialeBO gestionCommercialeBO = getGestionCommercialeBO();
			ActionMessages errors = new ActionMessages();
			errors = gestionCommercialeBO.getUser(formulaire);
			if (errors.isEmpty()) {
				gestionCommercialeBO.initialiserForm(formulaire);
				gestionCommercialeBO.initialiserCombosAssureur(formulaire);
				gestionCommercialeBO.initialiserCombosPrestations(formulaire);

				return mapping.findForward("infosPatientDevis");
			} else {
				return mapping.findForward("error");
			}

		} catch (Exception e) {
			log.fatal(e.getMessage());
			return mapping.findForward("error");
		} finally {
			log.debug("********** Fin infosPatient GestionCommercialeAction **********");
		}

	}

	public ActionForward ajouterDetailDrgCnam(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		log.debug("********** Debut ajouterDetailDrgCnam GestionCommercialeAction **********");
		try {
			GestionCommercialeForm formulaire = (GestionCommercialeForm) form;
			// User
			// user=(User)request.getSession().getAttribute("userConnected");
			// formulaire.setOperateur(user.getLogin());
			IGestionCommercialeBO gestionCommercialeBO = getGestionCommercialeBO();
			if (gestionCommercialeBO
					.ajouterDrgCnamDansDetailDrgCnamList(formulaire)) {

				gestionCommercialeBO.initialiserCombosPrestations(formulaire);
				gestionCommercialeBO
						.initialiserChampsAjouterPrestations(formulaire);
				gestionCommercialeBO.initialiserCombosDrgCnam(formulaire);
				return mapping.findForward("ajouterDRG");
			}

			else {

				return mapping.findForward("ajouterDRG");
			}

		} catch (Exception e) {
			e.printStackTrace();
			log.fatal(e.getMessage());
			return mapping.findForward(FORWARD);
		} finally {
			log.debug("********** Fin ajouterDetailDrgCnam GestionCommercialeAction **********");
		}

	}

	public ActionForward ajouterDetailDrgCnamHosp(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		log.debug("********** Debut ajouterDetailDrgCnamHosp GestionCommercialeAction **********");
		try {
			GestionCommercialeForm formulaire = (GestionCommercialeForm) form;
			// User
			// user=(User)request.getSession().getAttribute("userConnected");
			// formulaire.setOperateur(user.getLogin());
			IGestionCommercialeBO gestionCommercialeBO = getGestionCommercialeBO();
			if (gestionCommercialeBO
					.ajouterDrgCnamDansDetailDrgCnamList(formulaire)) {

				gestionCommercialeBO.initialiserCombosPrestations(formulaire);
				gestionCommercialeBO
						.initialiserChampsAjouterPrestations(formulaire);
				gestionCommercialeBO.initialiserCombosDrgCnam(formulaire);
				return mapping.findForward("ajouterDRGHosp");
			}

			else {

				return mapping.findForward("ajouterDRGHosp");
			}

		} catch (Exception e) {
			e.printStackTrace();
			log.fatal(e.getMessage());
			return mapping.findForward("ajouterDRGHosp");
		} finally {
			log.debug("********** Fin ajouterDetailDrgCnamHosp GestionCommercialeAction **********");
		}

	}

	public ActionForward supprimerDetailDrgCnam(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		log.debug("********** Debut supprimerDetailDrgCnam GestionCommercialeAction **********");
		try {
			GestionCommercialeForm formulaire = (GestionCommercialeForm) form;
			// User
			// user=(User)request.getSession().getAttribute("userConnected");
			// formulaire.setOperateur(user.getLogin());
			IGestionCommercialeBO gestionCommercialeBO = getGestionCommercialeBO();
			if (gestionCommercialeBO
					.supprimerDetailDrgFromListeDetailDrgCnamFacture(formulaire)) {

				gestionCommercialeBO.initialiserCombosPrestations(formulaire);
				gestionCommercialeBO
						.initialiserChampsAjouterPrestations(formulaire);
				gestionCommercialeBO.initialiserCombosDrgCnam(formulaire);
				return mapping.findForward("ajouterDRG");
			}

			else {

				return mapping.findForward("ajouterDRG");
			}

		} catch (Exception e) {
			e.printStackTrace();
			log.fatal(e.getMessage());
			return mapping.findForward(FORWARD);
		} finally {
			log.debug("********** Fin supprimerDetailDrgCnam GestionCommercialeAction **********");
		}

	}

	public ActionForward supprimerDetailDrgCnamHosp(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		log.debug("********** Debut supprimerDetailDrgCnamHosp GestionCommercialeAction **********");
		try {
			GestionCommercialeForm formulaire = (GestionCommercialeForm) form;
			// User
			// user=(User)request.getSession().getAttribute("userConnected");
			// formulaire.setOperateur(user.getLogin());
			IGestionCommercialeBO gestionCommercialeBO = getGestionCommercialeBO();
			if (gestionCommercialeBO
					.supprimerDetailDrgFromListeDetailDrgCnamFacture(formulaire)) {

				gestionCommercialeBO.initialiserCombosPrestations(formulaire);
				gestionCommercialeBO
						.initialiserChampsAjouterPrestations(formulaire);
				gestionCommercialeBO.initialiserCombosDrgCnam(formulaire);
				return mapping.findForward("ajouterDRGHosp");
			}

			else {

				return mapping.findForward("ajouterDRGHosp");
			}

		} catch (Exception e) {
			e.printStackTrace();
			log.fatal(e.getMessage());
			return mapping.findForward(FORWARD);
		} finally {
			log.debug("********** Fin supprimerDetailDrgCnamHosp GestionCommercialeAction **********");
		}

	}

	@SuppressWarnings("unchecked")
	public ActionForward listFacturesAimprimer(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		log.debug("********** Debut listFacturesAimprimer GestionCommercialeAction **********");
		try {
			GestionCommercialeForm formulaire = (GestionCommercialeForm) form;
			// User
			// user=(User)request.getSession().getAttribute("userConnected");
			// formulaire.setOperateur(user.getLogin());
			formulaire.setFacturesAimprimerList(new ArrayList());
			IGestionCommercialeBO gestionCommercialeBO = getGestionCommercialeBO();
			gestionCommercialeBO.initialiserForm(formulaire);
			formulaire.setIsFirst("false");
			if (gestionCommercialeBO.getListFacturesAimprimer(formulaire)) {

				formulaire.setDateDebutRechFact("");
				formulaire.setDateFinRechFact("");
				formulaire.setIsFirst("false");
				return mapping.findForward("listFacturesAimprimer");
			}

			else {
				formulaire.setDateDebutRechFact("");
				formulaire.setDateFinRechFact("");
				formulaire.setIsFirst("false");
				return mapping.findForward("listFacturesAimprimer");
			}

		} catch (Exception e) {
			log.fatal(e.getMessage());
			return mapping.findForward("error");
		} finally {
			log.debug("********** Fin listFacturesAimprimer GestionCommercialeAction **********");
		}

	}

	@SuppressWarnings("unchecked")
	public ActionForward listFacturesAimprimeAjourdhui(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		log.debug("********** Debut listFacturesAimprimeAjourdhui GestionCommercialeAction **********");
		try {
			GestionCommercialeForm formulaire = (GestionCommercialeForm) form;
			// User
			// user=(User)request.getSession().getAttribute("userConnected");
			// formulaire.setOperateur(user.getLogin());
			formulaire.setFacturesAgenererList(new ArrayList());
			IGestionCommercialeBO gestionCommercialeBO = getGestionCommercialeBO();
			gestionCommercialeBO.initialiserForm(formulaire);

			gestionCommercialeBO.getListFacturesAimprimer(formulaire);

			return mapping.findForward("listFacturesAimprimer");

		} catch (Exception e) {
			log.fatal(e.getMessage());
			return mapping.findForward("error");
		} finally {
			log.debug("********** Fin listFacturesAimprimeAjourdhui GestionCommercialeAction **********");
		}

	}

	// imprimerFacture

	public ActionForward imprimerFacture(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		log.debug("********** Debut imprimerFacture GestionCommercialeAction **********");
		try {
			GestionCommercialeForm formulaire = (GestionCommercialeForm) form;
			// User
			// user=(User)request.getSession().getAttribute("userConnected");
			// formulaire.setOperateur(user.getLogin());

			IImpressionBO impressionBO = getImpressionBO();
			byte[] bytes = impressionBO.genererFacture(
					formulaire.getFactureId(), "ORIGINAL");

			ByteArrayOutputStream bos = new ByteArrayOutputStream(bytes.length);
			bos.write(bytes);

			response.setContentType("application/pdf");
			response.setContentLength(bos.size());

			OutputStream os = response.getOutputStream();
			os.write(bos.toByteArray(), 0, bos.size());
			os.flush();
			os.close();

			return mapping.findForward("listFacturesAimprimer");

		} catch (Exception e) {
			log.fatal(e.getMessage());
			return mapping.findForward("error");
		} finally {
			log.debug("********** Fin imprimerFacture GestionCommercialeAction **********");
		}

	}

	@SuppressWarnings("unchecked")
	public ActionForward listDevisAimprimeAjourdhui(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		log.debug("********** Debut listDevisAimprimeAjourdhui GestionCommercialeAction **********");
		try {
			GestionCommercialeForm formulaire = (GestionCommercialeForm) form;
			// User
			// user=(User)request.getSession().getAttribute("userConnected");
			// formulaire.setOperateur(user.getLogin());
			formulaire.setDevisAimprimerList(new ArrayList());
			IGestionCommercialeBO gestionCommercialeBO = getGestionCommercialeBO();
			gestionCommercialeBO.initialiserForm(formulaire);

			gestionCommercialeBO.getListDevisAimprimer(formulaire);

			return mapping.findForward("listDevisAimprimer");

		} catch (Exception e) {
			log.fatal(e.getMessage());
			return mapping.findForward("error");
		} finally {
			log.debug("********** Fin listDevisAimprimeAjourdhui GestionCommercialeAction **********");
		}

	}

	public ActionForward imprimerDevis(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		log.debug("********** Debut imprimerDevis GestionCommercialeAction **********");
		try {
			GestionCommercialeForm formulaire = (GestionCommercialeForm) form;
			// User
			// user=(User)request.getSession().getAttribute("userConnected");
			// formulaire.setOperateur(user.getLogin());

			IImpressionBO impressionBO = getImpressionBO();
			byte[] bytes = impressionBO.genererDevisAssureur(
					formulaire.getDevisAssureurId(), "ORIGINAL");

			ByteArrayOutputStream bos = new ByteArrayOutputStream(bytes.length);
			bos.write(bytes);

			response.setContentType("application/pdf");
			response.setContentLength(bos.size());

			OutputStream os = response.getOutputStream();
			os.write(bos.toByteArray(), 0, bos.size());
			os.flush();
			os.close();

			return mapping.findForward("listDevisAimprimer");

		} catch (Exception e) {
			log.fatal(e.getMessage());
			return mapping.findForward("error");
		} finally {
			log.debug("********** Fin imprimerDevis GestionCommercialeAction **********");
		}

	}

	@SuppressWarnings("unchecked")
	public ActionForward listDevisAimprimer(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		log.debug("********** Debut listDevisAimprimer GestionCommercialeAction **********");
		try {
			GestionCommercialeForm formulaire = (GestionCommercialeForm) form;
			// User
			// user=(User)request.getSession().getAttribute("userConnected");
			// formulaire.setOperateur(user.getLogin());
			formulaire.setDevisAimprimerList(new ArrayList());
			IGestionCommercialeBO gestionCommercialeBO = getGestionCommercialeBO();
			gestionCommercialeBO.initialiserForm(formulaire);
			formulaire.setIsFirst("false");
			if (gestionCommercialeBO.getListDevisAimprimer(formulaire)) {

				formulaire.setDateDebutRechFact("");
				formulaire.setDateFinRechFact("");
				formulaire.setIsFirst("false");
				return mapping.findForward("listDevisAimprimer");
			}

			else {
				formulaire.setDateDebutRechFact("");
				formulaire.setDateFinRechFact("");
				formulaire.setIsFirst("false");
				return mapping.findForward("listDevisAimprimer");
			}

		} catch (Exception e) {
			log.fatal(e.getMessage());
			return mapping.findForward("error");
		} finally {
			log.debug("********** Fin listDevisAimprimer GestionCommercialeAction **********");
		}

	}

}