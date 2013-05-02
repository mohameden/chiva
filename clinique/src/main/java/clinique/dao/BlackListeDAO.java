package clinique.dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import clinique.mapping.BlackListe;

@Repository
public class BlackListeDAO extends CliniqueHibernateDaoSupport<BlackListe> {
	private static Logger log = Logger.getLogger(BlackListeDAO.class);

	public BlackListe getBlackListe(int blackListeId) {
		log.debug("********** Debut getBlackListe BlackListeDAO **********");
		try {
			BlackListe blackListe = null;
			Session session = getSession();
			blackListe = (BlackListe) session.get(BlackListe.class,
					blackListeId);
			return blackListe;
		} catch (Exception e) {
			e.printStackTrace();
			log.fatal(e.getMessage());
			return null;
		} finally {
			log.debug("********** Fin getBlackListe BlackListeDAO **********");
		}
	}

	public void saveBlackListe(BlackListe blackListe) {
		log.debug("********** Debut saveBlackListe BlackListeDAO **********");
		try {
			Session session = getSession();
			blackListe.setStatut(STATUT_VALIDE);
			session.save(blackListe);
		} catch (Exception e) {
			e.printStackTrace();
			log.fatal(e.getMessage());
		} finally {
			log.debug("********** Fin saveBlackListe BlackListeDAO **********");
		}
	}

	public void updateBlackListe(BlackListe blackListe) {
		log.debug("********** Debut updateBlackListe BlackListeDAO **********");
		try {

			Session session = getSession();
			session.update(blackListe);
		} catch (Exception e) {
			e.printStackTrace();
			log.fatal(e.getMessage());
		} finally {
			log.debug("********** Fin updateBlackListe BlackListeDAO **********");
		}
	}

	public void deleteBlackListe(BlackListe blackListe) {
		log.debug("********** Debut deleteBlackListe BlackListeDAO **********");
		try {

			Session session = getSession();
			blackListe.setStatut(STATUT_SUPPRIME);
			session.update(blackListe);
		} catch (Exception e) {
			e.printStackTrace();
			log.fatal(e.getMessage());
		} finally {
			log.debug("********** Fin deleteBlackListe BlackListeDAO **********");
		}
	}

	@SuppressWarnings({ "unchecked" })
	public List<BlackListe> listBlackListes() {
		log.debug("********** Debut listBlackListes BlackListeDAO **********");
		try {
			List<BlackListe> blackListes = null;
			Session session = getSession();
			String strQuery = "select distinct blackListe ";
			strQuery += "from BlackListe blackListe ";
			strQuery += "and blackListe.statut = " + STATUT_VALIDE;
			strQuery += " order by blackListe.blackListeId asc";
			org.hibernate.Query query = session.createQuery(strQuery);
			blackListes = query.list();
			return blackListes;
		} catch (Exception e) {
			e.printStackTrace();
			log.fatal(e.getMessage());
			return null;
		} finally {
			log.debug("********** Fin listBlackListes BlackListeDAO **********");
		}
	}

	@SuppressWarnings({ "unchecked" })
	public List<BlackListe> listBlackListesSupprimees() {
		log.debug("********** Debut listBlackListesSupprimees BlackListeDAO **********");
		try {
			List<BlackListe> blackListes = null;
			Session session = getSession();
			String strQuery = "select distinct blackListe ";
			strQuery += "from BlackListe blackListe ";
			strQuery += "and blackListe.statut = " + STATUT_SUPPRIME;
			strQuery += " order by blackListe.blackListeId asc";
			org.hibernate.Query query = session.createQuery(strQuery);
			blackListes = query.list();
			return blackListes;
		} catch (Exception e) {
			e.printStackTrace();
			log.fatal(e.getMessage());
			return null;
		} finally {
			log.debug("********** Fin listBlackListesSupprimees BlackListeDAO **********");
		}
	}

	@Override
	protected Class<?> getEntityClass() {
		return BlackListe.class;
	}
}
