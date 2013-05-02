package clinique.dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import clinique.mapping.ParametresClinique;

@Repository
public class ParametresCliniqueDAO extends
		CliniqueHibernateDaoSupport<ParametresClinique> {

	private static Logger log = Logger.getLogger(ParametresCliniqueDAO.class);

	public ParametresClinique getParametresClinique(String parametresCliniqueId) {
		log.debug("********** Debut getParametresClinique ParametresCliniqueDAO **********");
		try {
			ParametresClinique parametresClinique = null;
			Session session = getSession();
			parametresClinique = (ParametresClinique) session.get(
					ParametresClinique.class, parametresCliniqueId);
			return parametresClinique;
		} catch (Exception e) {
			e.printStackTrace();
			log.fatal(e.getMessage());
			return null;
		} finally {
			log.debug("********** Fin getParametresClinique ParametresCliniqueDAO **********");
		}
	}

	@SuppressWarnings("unchecked")
	public ParametresClinique getParametresCliniqueByParametreNom(
			String parametre) {
		log.debug("********** Debut getParametresClinique ParametresCliniqueDAO **********");
		try {
			@SuppressWarnings("unused")
			ParametresClinique parametresClinique = null;
			List<ParametresClinique> parametresCliniques = null;
			Session session = getSession();
			String strQuery = "select distinct parametresClinique ";
			strQuery += "from ParametresClinique parametresClinique";
			strQuery += " where parametresClinique.parametre = '" + parametre
					+ "'";
			strQuery += " and parametresClinique.statut = " + STATUT_VALIDE;
			strQuery += " order by parametresClinique.parametreId asc";
			org.hibernate.Query query = session.createQuery(strQuery);
			parametresCliniques = query.list();

			return parametresClinique = parametresCliniques.get(0);
		} catch (Exception e) {
			e.printStackTrace();
			log.fatal(e.getMessage());
			return null;
		} finally {
			log.debug("********** Fin getParametresClinique ParametresCliniqueDAO **********");
		}
	}

	public void saveParametresClinique(ParametresClinique parametresClinique) {
		log.debug("********** Debut saveParametresClinique ParametresCliniqueDAO **********");
		try {
			Session session = getSession();
			parametresClinique.setStatut(STATUT_SUPPRIME);
			session.save(parametresClinique);

		} catch (Exception e) {
			e.printStackTrace();
			log.fatal(e.getMessage());
		} finally {
			log.debug("********** Fin saveParametresClinique ParametresCliniqueDAO **********");
		}
	}

	public void updateParametresClinique(ParametresClinique parametresClinique) {
		log.debug("********** Debut updateParametresClinique ParametresCliniqueDAO **********");
		try {
			Session session = getSession();
			session.update(parametresClinique);
		} catch (Exception e) {
			e.printStackTrace();
			log.fatal(e.getMessage());
		} finally {
			log.debug("********** Fin updateParametresClinique ParametresCliniqueDAO **********");
		}
	}

	public void deleteParametresClinique(ParametresClinique parametresClinique) {
		log.debug("********** Debut deleteParametresClinique ParametresCliniqueDAO **********");
		try {
			Session session = getSession();
			parametresClinique.setStatut(STATUT_SUPPRIME);
			session.update(parametresClinique);
		} catch (Exception e) {
			e.printStackTrace();
			log.fatal(e.getMessage());
		} finally {
			log.debug("********** Fin deleteParametresClinique ParametresCliniqueDAO **********");
		}
	}

	@SuppressWarnings({ "unchecked" })
	public List<ParametresClinique> listParametresCliniques() {
		log.debug("********** Debut listParametresCliniques ParametresCliniqueDAO **********");
		try {
			List<ParametresClinique> parametresCliniques = null;
			Session session = getSession();
			String strQuery = "select distinct parametresClinique ";
			strQuery += "from ParametresClinique parametresClinique";
			strQuery += "where parametresClinique.statut = " + STATUT_VALIDE;
			strQuery += " order by parametresClinique.parametresCliniqueId asc";
			org.hibernate.Query query = session.createQuery(strQuery);
			parametresCliniques = query.list();
			return parametresCliniques;
		} catch (Exception e) {
			e.printStackTrace();
			log.fatal(e.getMessage());
			return null;
		} finally {
			log.debug("********** Fin listParametresCliniques ParametresCliniqueDAO **********");
		}
	}

	@SuppressWarnings({ "unchecked" })
	public List<ParametresClinique> listParametresCliniquesSupprimees() {
		log.debug("********** Debut listParametresCliniquesSupprimees ParametresCliniqueDAO **********");
		try {
			List<ParametresClinique> parametresCliniquesSupprimees = null;
			Session session = getSession();
			String strQuery = "select distinct parametresClinique ";
			strQuery += "from ParametresClinique parametresClinique";
			strQuery += "where parametresClinique.statut = " + STATUT_SUPPRIME;
			strQuery += " order by parametresClinique.parametresCliniqueId asc";
			org.hibernate.Query query = session.createQuery(strQuery);
			parametresCliniquesSupprimees = query.list();
			return parametresCliniquesSupprimees;
		} catch (Exception e) {
			e.printStackTrace();
			log.fatal(e.getMessage());
			return null;
		} finally {
			log.debug("********** Fin listParametresCliniquesSupprimees ParametresCliniqueDAO **********");
		}
	}

	@Override
	protected Class<?> getEntityClass() {
		return ParametresClinique.class;
	}

}
