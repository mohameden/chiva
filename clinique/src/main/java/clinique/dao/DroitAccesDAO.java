package clinique.dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import clinique.mapping.DroitAcces;

@Repository
public class DroitAccesDAO extends CliniqueHibernateDaoSupport<DroitAcces> {

	private static Logger log = Logger.getLogger(DroitAccesDAO.class);

	public DroitAcces getDroitAcces(int droitAccesId) {
		log.debug("********** Debut getDroitAcces DroitAccesDAO **********");
		try {
			DroitAcces droitAcces = null;
			Session session = getSession();
			droitAcces = (DroitAcces) session.get(DroitAcces.class,
					droitAccesId);
			return droitAcces;
		} catch (Exception e) {
			e.printStackTrace();
			log.fatal(e.getMessage());
			return null;
		} finally {
			log.debug("********** Fin getDroitAcces DroitAccesDAO **********");
		}
	}

	public void saveDroitAcces(DroitAcces droitAcces) {
		log.debug("********** Debut saveDroitAcces DroitAccesDAO **********");
		try {
			Session session = getSession();
			session.save(droitAcces);
		} catch (Exception e) {
			e.printStackTrace();
			log.fatal(e.getMessage());
		} finally {
			log.debug("********** Fin saveDroitAcces DroitAccesDAO **********");
		}
	}

	public void updateDroitAcces(DroitAcces droitAcces) {
		log.debug("********** Debut updateDroitAcces DroitAccesDAO **********");
		try {
			Session session = getSession();
			droitAcces.setStatut(STATUT_VALIDE);
			session.update(droitAcces);
		} catch (Exception e) {
			e.printStackTrace();
			log.fatal(e.getMessage());
		} finally {
			log.debug("********** Fin updateDroitAcces DroitAccesDAO **********");
		}
	}

	public void deleteDroitAcces(DroitAcces droitAcces) {
		log.debug("********** Debut deleteDroitAcces DroitAccesDAO **********");
		try {
			Session session = getSession();
			droitAcces.setStatut(STATUT_SUPPRIME);
			session.update(droitAcces);
		} catch (Exception e) {
			e.printStackTrace();
			log.fatal(e.getMessage());
		} finally {
			log.debug("********** Fin deleteDroitAcces DroitAccesDAO **********");
		}
	}

	@SuppressWarnings({ "unchecked" })
	public List<DroitAcces> listDroitsAcces() {
		log.debug("********** Debut listDroitsAcces DroitAccesDAO **********");
		try {
			List<DroitAcces> droitsAcces = null;
			Session session = getSession();
			String strQuery = "select distinct droitAcces ";
			strQuery += "from DroitAcces droitAcces";
			strQuery += "where droitAcces.statut = " + STATUT_VALIDE;
			strQuery += " order by droitAcces.dAccId asc";
			org.hibernate.Query query = session.createQuery(strQuery);
			droitsAcces = query.list();
			return droitsAcces;
		} catch (Exception e) {
			e.printStackTrace();
			log.fatal(e.getMessage());
			return null;
		} finally {
			log.debug("********** Fin listDroitsAcces DroitAccesDAO **********");
		}
	}

	@SuppressWarnings({ "unchecked" })
	public List<DroitAcces> listDroitsAccesSupprimes() {
		log.debug("********** Debut listDroitsAccesSupprimes DroitAccesDAO **********");
		try {
			List<DroitAcces> droitsAcces = null;
			Session session = getSession();
			String strQuery = "select distinct droitAcces ";
			strQuery += "from DroitAcces droitAcces";
			strQuery += "where droitAcces.statut = " + STATUT_SUPPRIME;
			strQuery += " order by droitAcces.dAccId asc";
			org.hibernate.Query query = session.createQuery(strQuery);
			droitsAcces = query.list();
			return droitsAcces;
		} catch (Exception e) {
			e.printStackTrace();
			log.fatal(e.getMessage());
			return null;
		} finally {
			log.debug("********** Fin listDroitsAccesSupprimes DroitAccesDAO **********");
		}
	}

	@Override
	protected Class<?> getEntityClass() {
		return DroitAcces.class;
	}
}
