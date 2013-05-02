package clinique.dao;

import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import clinique.mapping.DevisAssureur;
import clinique.utils.UtilDate;

@Repository
public class DevisAssureurDAO extends
		CliniqueHibernateDaoSupport<DevisAssureur> {

	private static Logger log = Logger.getLogger(DevisAssureurDAO.class);

	public DevisAssureur getDevisAssureur(String devisAssureurId) {
		log.debug("********** Debut getDevisAssureur DevisAssureurDAO **********");
		try {
			DevisAssureur devisAssureur = null;
			Session session = getSession();
			devisAssureur = (DevisAssureur) session.get(DevisAssureur.class,
					devisAssureurId);
			return devisAssureur;
		} catch (Exception e) {
			e.printStackTrace();
			log.fatal(e.getMessage());
			return null;
		} finally {
			log.debug("********** Fin getDevisAssureur DevisAssureurDAO **********");
		}
	}

	public void saveDevisAssureur(DevisAssureur devisAssureur) {
		log.debug("********** Debut saveDevisAssureur DevisAssureurDAO **********");
		try {
			Session session = getSession();
			devisAssureur.setStatut(STATUT_VALIDE);
			session.save(devisAssureur);
		} catch (Exception e) {
			e.printStackTrace();
			log.fatal(e.getMessage());
		} finally {
			log.debug("********** Fin saveDevisAssureur DevisAssureurDAO **********");
		}
	}

	public void updateDevisAssureur(DevisAssureur devisAssureur) {
		log.debug("********** Debut updateDevisAssureur DevisAssureurDAO **********");
		try {
			Session session = getSession();
			session.update(devisAssureur);
		} catch (Exception e) {
			e.printStackTrace();
			log.fatal(e.getMessage());
		} finally {
			log.debug("********** Fin updateDevisAssureur DevisAssureurDAO **********");
		}
	}

	public void deleteDevisAssureur(DevisAssureur devisAssureur) {
		log.debug("********** Debut deleteDevisAssureur DevisAssureurDAO **********");
		try {
			Session session = getSession();
			devisAssureur.setStatut(STATUT_SUPPRIME);
			session.update(devisAssureur);
		} catch (Exception e) {
			e.printStackTrace();
			log.fatal(e.getMessage());
		} finally {
			log.debug("********** Fin deleteDevisAssureur DevisAssureurDAO **********");
		}
	}

	@SuppressWarnings({ "unchecked" })
	public List<DevisAssureur> listDevisAssureurs(String patientId) {
		log.debug("********** Debut listDevisAssureurs DevisAssureurDAO **********");
		try {

			List<DevisAssureur> devis = null;

			Date date1 = UtilDate.getInstance().getDateToday();
			Date date2 = UtilDate.getInstance().moinUnMois(date1);

			Session session = getSession();
			String strQuery = "select distinct devisAssureur ";
			strQuery += "from DevisAssureur devisAssureur ";
			strQuery += "where devisAssureur.patient.patientId = " + patientId;
			strQuery += " and devisAssureur.statut = " + STATUT_VALIDE;
			strQuery += " and devisAssureur.dateDevis between '"
					+ UtilDate.getInstance().stringToDateMysql(
							UtilDate.getInstance().dateToString(date2))
					+ "' and '"
					+ UtilDate.getInstance().stringToDateMysql(
							UtilDate.getInstance().dateToString(date1)) + "'";
			strQuery += " order by devisAssureur.devisAssureurId asc";
			System.out.println(strQuery);
			org.hibernate.Query query = session.createQuery(strQuery);
			devis = query.list();
			return devis;
		} catch (Exception e) {
			e.printStackTrace();
			log.fatal(e.getMessage());
			return null;
		} finally {
			log.debug("********** Fin listDevisAssureurs DevisAssureurDAO **********");
		}
	}

	@SuppressWarnings("unchecked")
	public List<DevisAssureur> listDevisAimprimer(String date1, String date2) {
		log.debug("********** Debut listDevisAimprimer FactureDAO **********");
		try {

			List<DevisAssureur> devisList = null;
			Session session = getSession();
			String strQuery = "select distinct devis ";
			strQuery += "from DevisAssureur devis ";
			strQuery += " where devis.statut = " + STATUT_VALIDE;
			strQuery += " and devis.dateDevis between '"
					+ UtilDate.getInstance().stringToDateMysql(date1)
					+ "' and '"
					+ UtilDate.getInstance().stringToDateMysql(date2) + "'";
			strQuery += " order by devis.devisAssureurId asc";
			System.out.println(strQuery);
			org.hibernate.Query query = session.createQuery(strQuery);
			devisList = query.list();
			return devisList;
		} catch (Exception e) {
			e.printStackTrace();
			log.fatal(e.getMessage());
			return null;
		} finally {
			log.debug("********** Fin listDevisAimprimer FactureDAO **********");
		}
	}

	@SuppressWarnings("unchecked")
	public List<DevisAssureur> listDevisAimprimerFromBO(String date1,
			String date2) {
		log.debug("********** Debut listDevisAimprimer FactureDAO **********");
		try {

			List<DevisAssureur> devisList = null;
			String strQuery = "select distinct devis ";
			strQuery += " from DevisAssureur devis ";
			strQuery += " where devis.statut = " + STATUT_VALIDE;
			strQuery += " and devis.dateDevis between '"
					+ UtilDate.getInstance().stringToDateMysql(date1)
					+ "' and '"
					+ UtilDate.getInstance().stringToDateMysql(date2) + "'";
			strQuery += " order by devis.devisAssureurId asc";
			// System.out.println(strQuery);
			org.hibernate.Query query = getSession().createQuery(strQuery);
			devisList = query.list();
			return devisList;
		} catch (Exception e) {
			e.printStackTrace();
			log.fatal(e.getMessage());
			return null;
		} finally {
			log.debug("********** Fin listDevisAimprimer FactureDAO **********");
		}
	}

	@Override
	protected Class<?> getEntityClass() {
		return DevisAssureur.class;
	}

}
