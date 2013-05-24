package clinique.dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import clinique.mapping.PrestationCouvertesPc;
import clinique.mapping.PriseEnCharge;

@Repository
public class PrestationCouvertesPcDAO extends
		CliniqueHibernateDaoSupport<PrestationCouvertesPc> {

	private static Logger log = Logger
			.getLogger(PrestationCouvertesPcDAO.class);

	public PrestationCouvertesPc getPrestationCouvertesPc(
			int prestationCouvertesPcId) {
		log.debug("********** Debut getPrestationCouvertesPc PrestationCouvertesPcDAO **********");
		try {
			PrestationCouvertesPc prestationCouvertesPc = null;
			Session session = getSession();
			prestationCouvertesPc = (PrestationCouvertesPc) session.get(
					PrestationCouvertesPc.class, prestationCouvertesPcId);
			return prestationCouvertesPc;
		} catch (Exception e) {
			e.printStackTrace();
			log.fatal(e.getMessage());
			return null;
		} finally {
			log.debug("********** Fin getPrestationCouvertesPc PrestationCouvertesPcDAO **********");
		}
	}

	public void savePrestationCouvertesPc(
			PrestationCouvertesPc prestationCouvertesPc) {
		log.debug("********** Debut savePrestationCouvertesPc PrestationCouvertesPcDAO **********");
		try {
			Session session = getSession();
			prestationCouvertesPc.setStatut(STATUT_VALIDE);
			session.save(prestationCouvertesPc);
		} catch (Exception e) {
			e.printStackTrace();
			log.fatal(e.getMessage());
		} finally {
			log.debug("********** Fin savePrestationCouvertesPc PrestationCouvertesPcDAO **********");
		}
	}

	public void saveOrUpdatePrestationCouvertesPc(
			PrestationCouvertesPc prestationCouvertesPc) {
		log.debug("********** Debut savePrestationCouvertesPc PrestationCouvertesPcDAO **********");
		try {
			Session session = getSession();
			prestationCouvertesPc.setStatut(STATUT_VALIDE);
			session.saveOrUpdate(prestationCouvertesPc);
		} catch (Exception e) {
			e.printStackTrace();
			log.fatal(e.getMessage());
		} finally {
			log.debug("********** Fin savePrestationCouvertesPc PrestationCouvertesPcDAO **********");
		}
	}

	public void updatePrestationCouvertesPc(
			PrestationCouvertesPc prestationCouvertesPc) {
		log.debug("********** Debut updatePrestationCouvertesPc PrestationCouvertesPcDAO **********");
		try {
			Session session = getSession();
			session.update(prestationCouvertesPc);
		} catch (Exception e) {
			e.printStackTrace();
			log.fatal(e.getMessage());
		} finally {
			log.debug("********** Fin updatePrestationCouvertesPc PrestationCouvertesPcDAO **********");
		}
	}

	public void deletePrestationCouvertesPc(
			PrestationCouvertesPc prestationCouvertesPc) {
		log.debug("********** Debut deletePrestationCouvertesPc PrestationCouvertesPcDAO **********");
		try {
			Session session = getSession();
			prestationCouvertesPc.setStatut(STATUT_SUPPRIME);
			session.update(prestationCouvertesPc);
		} catch (Exception e) {
			e.printStackTrace();
			log.fatal(e.getMessage());
		} finally {
			log.debug("********** Fin deletePrestationCouvertesPc PrestationCouvertesPcDAO **********");
		}
	}

	@SuppressWarnings({ "unchecked" })
	public List<PrestationCouvertesPc> listPrestationsCouvertesPcs() {
		log.debug("********** Debut listPrestationsCouvertesPcs PrestationCouvertesPcDAO **********");
		try {
			List<PrestationCouvertesPc> prestationCouvertesPcs = null;
			Session session = getSession();
			String strQuery = "select distinct prestationCouvertesPc ";
			strQuery += "from PrestationCouvertesPc prestationCouvertesPc";
			strQuery += "where PrestationCouvertesPc.statut = " + STATUT_VALIDE;
			strQuery += " order by PrestationCouvertesPc.presCouvId asc";
			org.hibernate.Query query = session.createQuery(strQuery);
			prestationCouvertesPcs = query.list();
			return prestationCouvertesPcs;
		} catch (Exception e) {
			e.printStackTrace();
			log.fatal(e.getMessage());
			return null;
		} finally {
			log.debug("********** Fin listPrestationsCouvertesPcs PrestationCouvertesPcDAO **********");
		}
	}

	@SuppressWarnings({ "unchecked" })
	public List<PrestationCouvertesPc> listPrestationsCouvertesPcsSupprimees() {
		log.debug("********** Debut listPrestationsCouvertesPcsSupprimees PrestationCouvertesPcDAO **********");
		try {
			List<PrestationCouvertesPc> prestationCouvertesPcs = null;
			Session session = getSession();
			String strQuery = "select distinct prestationCouvertesPc ";
			strQuery += "from PrestationCouvertesPc prestationCouvertesPc";
			strQuery += "where PrestationCouvertesPc.statut = "
					+ STATUT_SUPPRIME;
			strQuery += " order by PrestationCouvertesPc.presCouvId asc";
			org.hibernate.Query query = session.createQuery(strQuery);
			prestationCouvertesPcs = query.list();
			return prestationCouvertesPcs;
		} catch (Exception e) {
			e.printStackTrace();
			log.fatal(e.getMessage());
			return null;
		} finally {
			log.debug("********** Fin listPrestationsCouvertesPcsSupprimees PrestationCouvertesPcDAO **********");
		}
	}

	@SuppressWarnings("unchecked")
	public List<PrestationCouvertesPc> findPrestationCouvertesByPc(
			final PriseEnCharge priseEnCharge) {
		String queryString = "from PrestationCouvertesPc where priseEnCharge = :priseEnCharge";
		Session session = getSession();
		Query query = session.createQuery(queryString);
		query.setParameter("priseEnCharge", priseEnCharge);
		return query.list();
	}

	@Override
	protected Class<?> getEntityClass() {
		return PrestationCouvertesPc.class;
	}
}
