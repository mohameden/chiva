package clinique.servlets;

import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.struts.util.LabelValueBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.HttpRequestHandler;

import clinique.dao.ActeDAO;
import clinique.dao.ActeurActeDAO;
import clinique.dao.AssureurDAO;
import clinique.dao.BlackListeDAO;
import clinique.dao.CategorieDAO;
import clinique.dao.ClasseDAO;
import clinique.dao.DevisActesDAO;
import clinique.dao.DevisAssureurDAO;
import clinique.dao.EntrepriseDAO;
import clinique.dao.FamillePrestationDAO;
import clinique.dao.PatientDAO;
import clinique.dao.PatientPcActuelDAO;
import clinique.dao.ProduitDAO;
import clinique.dao.TypePayementDAO;
import clinique.mapping.Acte;
import clinique.mapping.Acteur;
import clinique.mapping.ActeurActe;
import clinique.mapping.Assureur;
import clinique.mapping.BlackListe;
import clinique.mapping.Categorie;
import clinique.mapping.Classe;
import clinique.mapping.DevisActes;
import clinique.mapping.DevisAssureur;
import clinique.mapping.Entreprise;
import clinique.mapping.FamillePrestation;
import clinique.mapping.Patient;
import clinique.mapping.PatientPcActuel;
import clinique.mapping.Produit;
import clinique.mapping.TypePayement;
import clinique.utils.ConstantesMetier;
import clinique.utils.UtilDate;

/**
 * Servlet implementation class InitServlet
 */
@Component("InitServlet")
public class InitServlet implements HttpRequestHandler, ConstantesMetier {

	private static Logger log = Logger.getLogger(InitServlet.class);
	public static String CHEMIN_ROOT = "";
	public static String CHEMIN_ROOT_RELATIVE = "";

	@Autowired
	private ActeDAO acteDAO;
	@Autowired
	private AssureurDAO assureurDAO;
	@Autowired
	private BlackListeDAO blackListeDAO;
	@Autowired
	private CategorieDAO categorieDAO;
	@Autowired
	private ClasseDAO classeDAO;
	@Autowired
	private DevisActesDAO devisActesDAO;
	@Autowired
	private DevisAssureurDAO devisAssureurDAO;
	@Autowired
	private EntrepriseDAO entrepriseDAO;
	@Autowired
	private PatientDAO patientDAO;
	@Autowired
	private PatientPcActuelDAO patientPcActuelDAO;
	@Autowired
	private ProduitDAO produitDAO;
	@Autowired
	private TypePayementDAO typePayementDAO;
	@Autowired
	private FamillePrestationDAO famillePrestationDAO;
	@Autowired
	private ActeurActeDAO acteurActeDAO;

	private ActeDAO getActeDAO() {
		return acteDAO;
	}

	private AssureurDAO getAssureurDAO() {
		return assureurDAO;
	}

	private CategorieDAO getCategorieDAO() {
		return categorieDAO;
	}

	private ClasseDAO getClasseDAO() {
		return classeDAO;
	}

	private DevisAssureurDAO getDevisAssureurDAO() {
		return devisAssureurDAO;
	}

	private EntrepriseDAO getEntrepriseDAO() {
		return entrepriseDAO;
	}

	private PatientDAO getPatientDAO() {
		return patientDAO;
	}

	private PatientPcActuelDAO getPatientPcActuelDAO() {
		return patientPcActuelDAO;
	}

	private ProduitDAO getProduitDAO() {
		return produitDAO;
	}

	private TypePayementDAO getTypePayementDAO() {
		return typePayementDAO;
	}

	@SuppressWarnings({ "unused", "unchecked" })
	private String convertirDevisActesEntitiesToXml(Collection listEntities)
			throws Exception {
		log.debug("********** Debut convertirListEntitiesToXml InitServlet **********");
		String strXmlEntities = null;
		StringBuffer sb = new StringBuffer();
		try {
			// sb.append("<?xml version=\"1.0\" encoding=\"ISO-8859-1\"?>\n");
			sb.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n");
			sb.append("<entities>\n");
			if (listEntities != null) {
				for (Iterator iter = listEntities.iterator(); iter.hasNext();) {
					DevisActes entity = (DevisActes) iter.next();
					sb.append("<entity>\n");
					sb.append("<nom><![CDATA[");
					sb.append(entity.getActe().getNomActe());
					sb.append("]]></nom>\n");
					sb.append("<nombre><![CDATA[");
					sb.append(String.valueOf(entity.getNbre()));
					sb.append("]]></nombre>\n");
					sb.append("<prix><![CDATA[");
					sb.append(String.valueOf(entity.getPrix()));
					sb.append("]]></prix>\n");
					sb.append("<total><![CDATA[");
					sb.append(String.valueOf(entity.getTotal()));
					sb.append("]]></total>\n");
					sb.append("</entity>\n");
				}
			}
			sb.append("</entities>");
		} catch (Exception e) {
			e.printStackTrace();
			log.fatal(e.getMessage());
		}
		strXmlEntities = sb.toString();
		log.debug("********** Fin convertirListEntitiesToXml InitServlet **********");
		return strXmlEntities;
	}

	private String convertirExceptionToXml(Exception e) {
		String strXmlEntities = null;
		StringBuffer sb = new StringBuffer();
		sb.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n");
		sb.append("<errors>\n");
		sb.append("<error>\n");
		sb.append(e.getMessage());
		sb.append("\n</error>\n");
		sb.append("</errors>");
		strXmlEntities = sb.toString();
		return strXmlEntities;
	}

	private String convertirListEntitiesToXml(Collection listEntities)
			throws Exception {
		log.debug("********** Debut convertirListEntitiesToXml InitServlet **********");
		String strXmlEntities = null;
		StringBuffer sb = new StringBuffer();
		try {
			// sb.append("<?xml version=\"1.0\" encoding=\"ISO-8859-1\"?>\n");
			sb.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n");
			sb.append("<entities>\n");
			if (listEntities != null) {
				for (Iterator iter = listEntities.iterator(); iter.hasNext();) {
					LabelValueBean entity = (LabelValueBean) iter.next();
					sb.append("<entity>\n");
					sb.append("<code><![CDATA[");
					sb.append(entity.getValue());
					sb.append("]]></code>\n");
					sb.append("<libelle><![CDATA[");
					sb.append(entity.getLabel());
					sb.append("]]></libelle>\n");
					sb.append("</entity>\n");
				}
			}
			sb.append("</entities>");
		} catch (Exception e) {
			e.printStackTrace();
			log.fatal(e.getMessage());
		}
		strXmlEntities = sb.toString();
		log.debug("********** Fin convertirListEntitiesToXml InitServlet **********");
		return strXmlEntities;
	}

	@SuppressWarnings("unused")
	private String convertirNombrePatientsToXml(int nbre) throws Exception {
		log.debug("********** Debut convertirNombrePatientsToXml InitServlet **********");
		String strXmlEntities = null;
		StringBuffer sb = new StringBuffer();
		try {
			// sb.append("<?xml version=\"1.0\" encoding=\"ISO-8859-1\"?>\n");
			sb.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n");
			sb.append("<entities>\n");

			sb.append("<entity>\n");
			sb.append("<nbre><![CDATA[");
			sb.append(nbre);
			sb.append("]]></nbre>\n");
			sb.append("</entity>\n");

			sb.append("</entities>");
		} catch (Exception e) {
			e.printStackTrace();
			log.fatal(e.getMessage());
		}
		strXmlEntities = sb.toString();

		log.debug("********** Fin convertirNombrePatientsToXml InitServlet **********");
		return strXmlEntities;
	}

	private String convertirPatientToXml(Patient p) {
		if (p == null) {
			return null;
		}
		String strXmlEntities = null;
		StringBuffer sb = new StringBuffer();
		sb.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n");
		sb.append("<patients>\n");
		sb.append("<patient>\n");
		sb.append("<patientId><![CDATA[\n");
		sb.append(p.getPatientId());
		sb.append("]]></patientId>\n");
		sb.append("<nom><![CDATA[\n");
		sb.append(p.getNom());
		sb.append("]]></nom>\n");
		sb.append("<prenom><![CDATA[\n");
		sb.append(p.getPrenom());
		sb.append("]]></prenom>\n");
		sb.append("<dateNaissance><![CDATA[\n");
		sb.append(UtilDate.getInstance().dateToString(p.getDateNaissance()));
		sb.append("]]></dateNaissance>\n");
		sb.append("<lieuNaissance><![CDATA[\n");
		sb.append(p.getLieuNaissance());
		sb.append("]]></lieuNaissance>\n");
		sb.append("<telephone><![CDATA[\n");
		sb.append(p.getTelephone());
		sb.append("]]></telephone>\n");
		sb.append("<adresse><![CDATA[\n");
		sb.append(p.getAdresse());
		sb.append("]]></adresse>\n");
		sb.append("<cni><![CDATA[\n");
		sb.append(p.getCni());
		sb.append("]]></cni>\n");
		sb.append("<nni><![CDATA[\n");
		sb.append(p.getNni());
		sb.append("]]></nni>\n");
		sb.append("<numeroBadge><![CDATA[\n");
		PatientPcActuel patientPc = getPatientPcActuelDAO()
				.getPatientPcByPatient(p);
		if (patientPc != null) {
			if (patientPc.getType().equals("badge")) {
				sb.append(patientPc.getBadge().getNumeroBadge());
			} else {
				sb.append("");
			}
		} else {
			sb.append("");
		}
		sb.append("]]></numeroBadge>\n");
		sb.append("<datePremiereVisite><![CDATA[\n");
		sb.append(UtilDate.getInstance()
				.dateToString(p.getDateDerniereVisite()));
		sb.append("]]></datePremiereVisite>\n");
		sb.append("<dateDerniereVisite><![CDATA[\n");
		sb.append(UtilDate.getInstance()
				.dateToString(p.getDateDerniereVisite()));
		sb.append("]]></dateDerniereVisite>\n");
		sb.append("\n</patient>\n");
		sb.append("</patients>");
		strXmlEntities = sb.toString();
		return strXmlEntities;
	}

	private String convertirProduitToXml(Produit produit) {
		if (produit == null) {
			return null;
		}
		String strXmlEntities = null;
		StringBuffer sb = new StringBuffer();
		sb.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n");
		sb.append("<produits>\n");
		sb.append("<produit>\n");
		sb.append("<produit_id><![CDATA[\n");
		sb.append(produit.getProduitId());
		sb.append("]]></produit_id>\n");
		sb.append("<nom_produit><![CDATA[\n");
		sb.append(produit.getNomProduit());
		sb.append("]]></nom_produit>\n");
		sb.append("<nom_classe><![CDATA[\n");
		sb.append(produit.getClasse().getNomClasse());
		sb.append("]]></nom_classe>\n");
		sb.append("<prix><![CDATA[\n");
		sb.append(produit.getPrix());
		sb.append("]]></prix>\n");
		sb.append("<quantite_disponible><![CDATA[\n");
		sb.append(produit.getQuantiteDisponible());
		sb.append("]]></quantite_disponible>\n");
		sb.append("<seuil_minimum><![CDATA[\n");
		sb.append(produit.getSeuilMinimum());
		sb.append("]]></seuil_minimum>\n");

		produit = null;

		sb.append("\n</produit>\n");
		sb.append("</produits>");
		strXmlEntities = sb.toString();
		return strXmlEntities;
	}

	private Collection<LabelValueBean> getListActesFromClasse(int idClasse)
			throws Exception {
		log.debug("********** Debut getListActesFromClasse InitServlet **********");
		Collection<LabelValueBean> listEntities = new ArrayList<LabelValueBean>();
		Classe classe = getClasseDAO().getClasse(idClasse);
		if (classe == null) {
			return null;
		}
		try {
			for (Object element : acteDAO.findActesByClasse(classe)) {
				Acte acte = (Acte) element;
				if (acte.getStatut().equals(STATUT_VALIDE)) {
					listEntities.add(new LabelValueBean(acte.getNomActe(),
							String.valueOf(acte.getActeId())));

					/*
					 * for(Iterator
					 * iterator1=acte.getActeurActes().iterator();iterator1
					 * .hasNext();) { ActeurActe
					 * acteurActe=(ActeurActe)iterator1.next();
					 * if(acteurActe.getStatut().equals(STATUT_VALIDE)) {
					 * listEntities.add(new
					 * LabelValueBean(acte.getNomActe(),String
					 * .valueOf(acte.getActeId()))); break; } }
					 */
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
			log.fatal(e.getMessage());
		}

		if (listEntities.isEmpty()) {
			listEntities = null;
		}
		log.debug("********** Fin getListActesFromClasse InitServlet **********");
		return listEntities;
	}

	@SuppressWarnings("unchecked")
	private Collection<LabelValueBean> getListActesFromFamillePrestation(
			int idFamillePrestation) throws Exception {
		log.debug("********** Debut getListClassesFromFamillePrestation InitServlet **********");
		Collection<LabelValueBean> listEntities = new ArrayList<LabelValueBean>();
		FamillePrestation famillePrestation = famillePrestationDAO
				.getFamillePrestation(idFamillePrestation);
		if (famillePrestation == null) {
			return null;
		}
		try {
			for (Object element : acteDAO
					.findActesByFamillePrestation(famillePrestation)) {

				Acte acte = (Acte) element;
				if (acte.getStatut().equals(STATUT_VALIDE)) {
					/*
					 * for(Iterator
					 * iterator2=acte.getActeurActes().iterator();iterator2
					 * .hasNext();) { ActeurActe acteurActe=(ActeurActe)
					 * iterator2.next();
					 * if(acteurActe.getStatut().equals(STATUT_VALIDE)) {
					 */
					listEntities.add(new LabelValueBean(acte.getNomActe(),
							String.valueOf(acte.getActeId())));
					/*
					 * classeAjoutee=true; break; } } if(classeAjoutee==true) {
					 * break; }
					 */
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
			log.fatal(e.getMessage());
		}

		if (listEntities.isEmpty()) {
			listEntities = null;
		}
		log.debug("********** Fin getListClassesFromFamillePrestation InitServlet **********");
		return listEntities;
	}

	private Collection<LabelValueBean> getListActeursFromActe(int idActe)
			throws Exception {
		log.debug("********** Debut getListActeursFromActe InitServlet **********");
		Collection<LabelValueBean> listEntities = new ArrayList<LabelValueBean>();
		Acte acte = getActeDAO().getActe(idActe);
		if (acte == null) {
			return null;
		}
		try {
			for (ActeurActe acteurActe : acteurActeDAO
					.findActeurActesByActe(acte)) {
				if (acteurActe.getStatut().equals(STATUT_VALIDE)) {
					Acteur acteur = acteurActe.getActeur();
					if (acteur != null
							&& acteur.getStatut().equals(STATUT_VALIDE)) {
						listEntities.add(new LabelValueBean(acteur.getNom(),
								String.valueOf(acteur.getActeurId())));
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			log.fatal(e.getMessage());
		}

		if (listEntities.isEmpty()) {
			listEntities = null;
		}
		log.debug("********** Fin getListActeursFromActe InitServlet **********");
		return listEntities;
	}

	@SuppressWarnings({ "unused", "unchecked" })
	private Collection<LabelValueBean> getListActeursInfFromActe(int idActe)
			throws Exception {
		log.debug("********** Debut getListActeursFromActe InitServlet **********");
		Collection<LabelValueBean> listEntities = new ArrayList<LabelValueBean>();
		Acte acte = getActeDAO().getActe(idActe);
		if (acte == null) {
			return null;
		}
		try {
			for (ActeurActe acteurActe : acteurActeDAO
					.findActeurActesByActe(acte)) {
				if (acteurActe.getStatut().equals(STATUT_VALIDE)) {
					Acteur acteur = acteurActe.getActeur();
					if (acteur != null
							&& acteur.getStatut().equals(STATUT_VALIDE)
							&& !acteur.getAssistant().equals("0")) {
						listEntities.add(new LabelValueBean(acteur.getNom(),
								String.valueOf(acteur.getActeurId())));
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			log.fatal(e.getMessage());
		}

		if (listEntities.isEmpty()) {
			listEntities = null;
		}
		log.debug("********** Fin getListActeursFromActe InitServlet **********");
		return listEntities;
	}

	private Collection<LabelValueBean> getListActeursMedFromActe(int idActe)
			throws Exception {
		log.debug("********** Debut getListActeursFromActe InitServlet **********");
		Collection<LabelValueBean> listEntities = new ArrayList<LabelValueBean>();
		Acte acte = getActeDAO().getActe(idActe);
		if (acte == null) {
			return null;
		}
		try {
			for (ActeurActe acteurActe : acteurActeDAO
					.findActeurActesByActe(acte)) {
				if (acteurActe.getStatut().equals(STATUT_VALIDE)) {
					Acteur acteur = acteurActe.getActeur();
					if (acteur != null
							&& acteur.getStatut().equals(STATUT_VALIDE)
							&& acteur.getAssistant().equals("0")) {
						listEntities.add(new LabelValueBean(acteur.getNom(),
								String.valueOf(acteur.getActeurId())));
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			log.fatal(e.getMessage());
		}

		if (listEntities.isEmpty()) {
			listEntities = null;
		}
		log.debug("********** Fin getListActeursFromActe InitServlet **********");
		return listEntities;
	}

	private Collection<LabelValueBean> getListCategoriesFromEntreprise(
			int idEntreprise) throws Exception {
		log.debug("********** Debut getListCategoriesFromEntreprise InitServlet **********");
		Collection<LabelValueBean> listEntities = new ArrayList<LabelValueBean>();
		Entreprise entreprise = getEntrepriseDAO().getEntreprise(idEntreprise);
		if (entreprise == null) {
			return null;
		}
		try {
			for (Object element : categorieDAO
					.findCategoriesByEntreprise(entreprise)) {
				Categorie categorie = (Categorie) element;
				if (categorie.getStatut().equals(STATUT_VALIDE)) {
					listEntities.add(new LabelValueBean(categorie
							.getNomCategorie(), String.valueOf(categorie
							.getCategorieId())));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			log.fatal(e.getMessage());
		}

		if (listEntities.isEmpty()) {
			listEntities = null;
		}
		log.debug("********** Fin getListCategoriesFromEntreprise InitServlet **********");
		return listEntities;
	}

	private Collection<DevisActes> getListDevisActesFromDevis(String idDevis)
			throws Exception {
		log.debug("********** Debut getListDevisActesFromDevis InitServlet **********");
		Collection<DevisActes> listEntities = new ArrayList<DevisActes>();
		DevisAssureur devisAssureur = getDevisAssureurDAO().getDevisAssureur(
				idDevis);
		if (devisAssureur == null) {
			return null;
		}
		try {
			listEntities = devisActesDAO
					.findDevisActesByDevisAssureur(devisAssureur);
		} catch (Exception e) {
			e.printStackTrace();
			log.fatal(e.getMessage());
		}

		if (listEntities.isEmpty()) {
			listEntities = null;
		}
		log.debug("********** Fin getListDevisActesFromDevis InitServlet **********");
		return listEntities;
	}

	private Collection<LabelValueBean> getListEntreprisesFromAssureur(
			int idAssureur) throws Exception {
		log.debug("********** Debut getListEntreprisesFromAssureur InitServlet **********");
		Collection<LabelValueBean> listEntities = new ArrayList<LabelValueBean>();
		Assureur assureur = getAssureurDAO().getAssureur(idAssureur);
		if (assureur == null) {
			return null;
		}
		try {
			for (Entreprise entreprise : entrepriseDAO
					.findEntreprisesByAssureur(assureur)) {
				if (entreprise.getStatut().equals(STATUT_VALIDE)) {
					for (Object element2 : categorieDAO
							.findCategoriesByEntreprise(entreprise)) {
						Categorie categorie = (Categorie) element2;
						if (categorie.getStatut().equals(STATUT_VALIDE)) {
							listEntities.add(new LabelValueBean(entreprise
									.getNomEntreprise(), String
									.valueOf(entreprise.getEntrepriseId())));
							break;
						}
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			log.fatal(e.getMessage());
		}

		if (listEntities.isEmpty()) {
			listEntities = null;
		}
		log.debug("********** Fin getListEntreprisesFromAssureur InitServlet **********");
		return listEntities;
	}

	@SuppressWarnings({ "unchecked", "unused" })
	private Collection<LabelValueBean> getListTypesPayement(String modeReglement)
			throws Exception {
		log.debug("********** Debut getListTypesPayement InitServlet **********");
		Collection<LabelValueBean> listEntities = new ArrayList<LabelValueBean>();

		try {

			for (Object element2 : getTypePayementDAO().listTypePayements()) {

				TypePayement element = (TypePayement) element2;

				if (modeReglement.equals("differe")) {
					if (element.getTypePayementId() != 1) {
						listEntities.add(new LabelValueBean(element
								.getTypePayement(), String.valueOf(element
								.getTypePayementId())));
					}
				} else {
					listEntities.add(new LabelValueBean(element
							.getTypePayement(), String.valueOf(element
							.getTypePayementId())));
				}

			}
		} catch (Exception e) {
			e.printStackTrace();
			log.fatal(e.getMessage());
		}

		if (listEntities.isEmpty()) {
			listEntities = null;
		}
		log.debug("********** Fin getListTypesPayement InitServlet **********");
		return listEntities;
	}

	private int getPatientsNombre(String telephone) throws Exception {
		log.debug("********** Debut getPatientsNombre InitServlet **********");
		int nbre = 0;

		try {
			nbre = getPatientDAO().listPatientsByTelephone(telephone);

		} catch (Exception e) {
			e.printStackTrace();
			log.fatal(e.getMessage());
		}

		log.debug("********** Fin getPatientsNombre InitServlet **********");
		return nbre;
	}

	private Produit getProduitFromProduitId(int idProduit) throws Exception {
		log.debug("********** Debut getProduit InitServlet **********");
		Produit produit = getProduitDAO().getProduit(idProduit);
		log.debug("********** Fin getProduit InitServlet **********");
		return produit;
	}

	public boolean checkBlackListe(String idBadge, String categorieId)
			throws Exception {
		boolean result = false;
		if (idBadge == null || idBadge.isEmpty()) {
			return false;
		}
		try {
			Categorie categorie = getCategorieDAO().getCategorie(
					Integer.parseInt(categorieId));
			for (BlackListe blackListe : blackListeDAO
					.findBlackListesByCategorie(categorie)) {
				if (blackListe.getStatut().equals(STATUT_VALIDE)
						&& blackListe.getNumeroBadge().equals(idBadge)) {
					result = true;

				}

			}

		} catch (Exception e) {
			throw e;
		}
		return result;
	}

	public Patient getPatientFromId(String id) throws Exception {
		Patient pat = null;
		if (id == null || id.isEmpty()) {
			return null;
		}
		try {

			PatientDAO patientDAO = getPatientDAO();
			pat = patientDAO.getPatient(id);
		} catch (Exception e) {
			throw e;
		}
		return pat;
	}

	/**
	 * Default constructor.
	 */

	@Override
	public void handleRequest(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		log.debug("********** Debut doPost InitServlet **********");
		String actionXML = request.getParameter("actionXML");
		String repXML = null;
		if (actionXML != null && !actionXML.isEmpty()) {
			try {

				if (actionXML.trim().equalsIgnoreCase("chargerEntreprises")) {
					String param1 = request.getParameter("id_assureur");
					int idAssureur = Integer.parseInt(param1.trim());
					repXML = convertirListEntitiesToXml(getListEntreprisesFromAssureur(idAssureur));
				}
				if (actionXML.trim().equalsIgnoreCase("chargerCategories")) {
					String param1 = request.getParameter("id_entreprise");
					int idEntreprise = Integer.parseInt(param1.trim());
					repXML = convertirListEntitiesToXml(getListCategoriesFromEntreprise(idEntreprise));
				}
				if (actionXML.trim().equalsIgnoreCase("chargerActesParFamille")) {
					String param1 = request
							.getParameter("id_famille_prestation");
					int idFamillePrestation = Integer.parseInt(param1.trim());
					repXML = convertirListEntitiesToXml(getListActesFromFamillePrestation(idFamillePrestation));
				}
				if (actionXML.trim().equalsIgnoreCase("chargerActes")) {
					String param1 = request.getParameter("id_classe");
					int idClasse = Integer.parseInt(param1.trim());
					repXML = convertirListEntitiesToXml(getListActesFromClasse(idClasse));
				}
				if (actionXML.trim().equalsIgnoreCase("chargerActeurs")) {
					String param1 = request.getParameter("id_acte");
					int idActe = Integer.parseInt(param1.trim());
					repXML = convertirListEntitiesToXml(getListActeursFromActe(idActe));
				}
				if (actionXML.trim().equalsIgnoreCase("chargerActeursInf")) {
					String param1 = request.getParameter("id_acte");
					int idActe = Integer.parseInt(param1.trim());
					repXML = convertirListEntitiesToXml(getListActeursInfFromActe(idActe));
				}
				if (actionXML.trim().equalsIgnoreCase("chargerActeursMed")) {
					String param1 = request.getParameter("id_acte");
					int idActe = Integer.parseInt(param1.trim());
					repXML = convertirListEntitiesToXml(getListActeursMedFromActe(idActe));
				}
				if (actionXML.trim().equalsIgnoreCase("selectPatient")) {
					String idPatient = request
							.getParameter("PatientIdSelected");
					repXML = convertirPatientToXml(getPatientFromId(idPatient));
				}
				if (actionXML.trim().equalsIgnoreCase("getProduit")) {
					String param1 = request.getParameter("id_produit");
					int idProduit = Integer.parseInt(param1.trim());
					repXML = convertirProduitToXml(getProduitFromProduitId(idProduit));
				}

				if (actionXML.trim().equalsIgnoreCase("chargerEntreprises")) {
					String param1 = request.getParameter("id_assureur");
					int idAssureur = Integer.parseInt(param1.trim());
					repXML = convertirListEntitiesToXml(getListEntreprisesFromAssureur(idAssureur));
				}
				if (actionXML.trim().equalsIgnoreCase("chargerCategories")) {
					String param1 = request.getParameter("id_entreprise");
					int idEntreprise = Integer.parseInt(param1.trim());
					repXML = convertirListEntitiesToXml(getListCategoriesFromEntreprise(idEntreprise));
				}
				if (actionXML.trim().equalsIgnoreCase("chargerDevisActes")) {
					String param1 = request.getParameter("id_devis");
					String idDevis = param1.trim();
					repXML = convertirDevisActesEntitiesToXml(getListDevisActesFromDevis(idDevis));
				}
				if (actionXML.trim().equalsIgnoreCase("afficherReglement")) {
					String param1 = request.getParameter("modeReglement");
					String modeReglement = param1.trim();
					repXML = convertirListEntitiesToXml(getListTypesPayement(modeReglement));
				}

				if (actionXML.trim().equalsIgnoreCase("recherchePatient")) {
					String param1 = request.getParameter("telephone");
					String telephone = param1.trim();
					repXML = convertirNombrePatientsToXml(getPatientsNombre(telephone));

				}

			} catch (Exception e) {
				repXML = convertirExceptionToXml(e);
				e.printStackTrace();
				log.fatal(e.getMessage());
			} finally {
				try {
				} catch (Exception e) {
					e.printStackTrace();
					log.fatal(e.getMessage());
				}
			}
		}
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/xml; charset=utf-8");
		response.setCharacterEncoding("UTF-8");
		OutputStream out = response.getOutputStream();
		OutputStreamWriter outCharset = new OutputStreamWriter(out,
				Charset.forName("UTF-8"));
		if (repXML != null && !repXML.isEmpty()) {
			outCharset.write(repXML);
		}
		outCharset.flush();
		outCharset.close();
		log.debug("********** Fin doPost InitServlet **********");
	}

}
