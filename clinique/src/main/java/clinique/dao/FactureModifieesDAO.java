package clinique.dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import clinique.mapping.FactureModifiees;

@Repository
public class FactureModifieesDAO extends
		CliniqueHibernateDaoSupport<FactureModifiees> {

	private static Logger log = Logger.getLogger(FactureModifieesDAO.class);

	public FactureModifiees getFactureModifiees(String factureModifieeId) {
		log.debug("********** Debut getFactureModifiees FactureModifieesDAO **********");
		try {
			FactureModifiees factureModifiees = null;
			Session session = getSession();
			factureModifiees = (FactureModifiees) session.get(
					FactureModifiees.class, factureModifieeId);
			return factureModifiees;
		} catch (Exception e) {
			e.printStackTrace();
			log.fatal(e.getMessage());
			return null;
		} finally {
			log.debug("********** Fin getFactureModifiees FactureModifieesDAO **********");
		}
	}

	public void saveFactureModifiees(FactureModifiees factureModifiees) {
		log.debug("********** Debut saveFactureModifiees FactureModifieesDAO **********");
		try {
			Session session = getSession();
			factureModifiees.setStatut(STATUT_SUPPRIME);
			session.save(factureModifiees);

		} catch (Exception e) {
			e.printStackTrace();
			log.fatal(e.getMessage());
		} finally {
			log.debug("********** Fin saveFactureModifiees FactureModifieesDAO **********");
		}
	}

	public void updateFactureModifiees(FactureModifiees factureModifiees) {
		log.debug("********** Debut updateFactureModifiees FactureModifieesDAO **********");
		try {
			Session session = getSession();
			session.update(factureModifiees);
		} catch (Exception e) {
			e.printStackTrace();
			log.fatal(e.getMessage());
		} finally {
			log.debug("********** Fin updateFactureModifiees FactureModifieesDAO **********");
		}
	}

	public void deleteFactureModifiees(FactureModifiees factureModifiees) {
		log.debug("********** Debut deleteFactureModifiees FactureModifieesDAO **********");
		try {
			Session session = getSession();
			factureModifiees.setStatut(STATUT_SUPPRIME);
			session.update(factureModifiees);
		} catch (Exception e) {
			e.printStackTrace();
			log.fatal(e.getMessage());
		} finally {
			log.debug("********** Fin deleteFactureModifiees FactureModifieesDAO **********");
		}
	}

	@SuppressWarnings({ "unchecked" })
	public List<FactureModifiees> listFactureModifieessReglements() {
		log.debug("********** Debut listFactureModifieessReglements FactureModifieesDAO **********");
		try {
			List<FactureModifiees> factureModifieessReglements = null;
			Session session = getSession();
			String strQuery = "select distinct factureModifiees ";
			strQuery += "from FactureModifiees factureModifiees, Reglement reglement";
			strQuery += "where factureModifiees.factureModifieeId = reglement.factureModifiees.factureModifieeId ";
			strQuery += "and factureModifiees.statut = " + STATUT_VALIDE;
			strQuery += " and reglement.statut = " + STATUT_VALIDE;
			strQuery += " order by factureModifiees.factureModifieeId asc";
			org.hibernate.Query query = session.createQuery(strQuery);
			factureModifieessReglements = query.list();
			return factureModifieessReglements;
		} catch (Exception e) {
			e.printStackTrace();
			log.fatal(e.getMessage());
			return null;
		} finally {
			log.debug("********** Fin listFactureModifieessReglements FactureModifieesDAO **********");
		}
	}

	@SuppressWarnings({ "unchecked" })
	public List<FactureModifiees> listFactureModifieess() {
		log.debug("********** Debut listFactureModifieess FactureModifieesDAO **********");
		try {
			List<FactureModifiees> factureModifieess = null;
			Session session = getSession();
			String strQuery = "select distinct factureModifiees ";
			strQuery += "from FactureModifiees factureModifiees";
			strQuery += "where factureModifiees.statut = " + STATUT_VALIDE;
			strQuery += " order by factureModifiees.factureModifieeId asc";
			org.hibernate.Query query = session.createQuery(strQuery);
			factureModifieess = query.list();
			return factureModifieess;
		} catch (Exception e) {
			e.printStackTrace();
			log.fatal(e.getMessage());
			return null;
		} finally {
			log.debug("********** Fin listFactureModifieess FactureModifieesDAO **********");
		}
	}

	@SuppressWarnings({ "unchecked" })
	public List<FactureModifiees> listFactureModifieesEncours() {
		log.debug("********** Debut listFactureModifieess FactureModifieesDAO **********");
		try {

			List<FactureModifiees> factureModifieess = null;
			Session session = getSession();
			String strQuery = "select distinct factureModifiees ";
			strQuery += "from FactureModifiees factureModifiees ";
			strQuery += "where factureModifiees.statut = " + STATUT_VALIDE;
			strQuery += " order by factureModifiees.factureModifieeId asc";
			System.out.println(strQuery);
			org.hibernate.Query query = session.createQuery(strQuery);
			factureModifieess = query.list();
			return factureModifieess;
		} catch (Exception e) {
			e.printStackTrace();
			log.fatal(e.getMessage());
			return null;
		} finally {
			log.debug("********** Fin listFactureModifieess FactureModifieesDAO **********");
		}
	}

	@SuppressWarnings({ "unchecked" })
	public List<FactureModifiees> listFactureModifieessSupprimees() {
		log.debug("********** Debut listFactureModifieessSupprimees FactureModifieesDAO **********");
		try {
			List<FactureModifiees> factureModifieessSupprimees = null;
			Session session = getSession();
			String strQuery = "select distinct factureModifiees ";
			strQuery += "from FactureModifiees factureModifiees";
			strQuery += "where factureModifiees.statut = " + STATUT_SUPPRIME;
			strQuery += " order by factureModifiees.factureModifieeId asc";
			org.hibernate.Query query = session.createQuery(strQuery);
			factureModifieessSupprimees = query.list();
			return factureModifieessSupprimees;
		} catch (Exception e) {
			e.printStackTrace();
			log.fatal(e.getMessage());
			return null;
		} finally {
			log.debug("********** Fin listFactureModifieessSupprimees FactureModifieesDAO **********");
		}
	}

	@Override
	protected Class<?> getEntityClass() {
		return FactureModifiees.class;
	}

}
