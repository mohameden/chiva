package clinique.dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import clinique.mapping.Patient;
import clinique.mapping.PriseEnCharge;

@Repository
public class PriseEnChargeDAO extends
		CliniqueHibernateDaoSupport<PriseEnCharge> {

	private static Logger log = Logger.getLogger(PriseEnChargeDAO.class);

	public PriseEnCharge getPriseEnCharge(String priseEnChargeId) {
		log.debug("********** Debut getPriseEnCharge PriseEnChargeDAO **********");
		try {
			PriseEnCharge priseEnCharge = null;
			System.out.println("function " + priseEnChargeId);
			Session session = getSession();
			priseEnCharge = (PriseEnCharge) session.get(PriseEnCharge.class,
					priseEnChargeId);
			System.out.println("function n°" + priseEnCharge.getPcNum());
			return priseEnCharge;
		} catch (Exception e) {
			e.printStackTrace();
			log.fatal(e.getMessage());
			return null;
		} finally {
			log.debug("********** Fin getPriseEnCharge PriseEnChargeDAO **********");
		}
	}

	public void savePriseEnCharge(PriseEnCharge priseEnCharge) {
		log.debug("********** Debut savePriseEnCharge PriseEnChargeDAO **********");
		try {
			Session session = getSession();
			priseEnCharge.setStatut(STATUT_VALIDE);
			session.save(priseEnCharge);
		} catch (Exception e) {
			e.printStackTrace();
			log.fatal(e.getMessage());
		} finally {
			log.debug("********** Fin savePriseEnCharge PriseEnChargeDAO **********");
		}
	}

	public void updatePriseEnCharge(PriseEnCharge priseEnCharge) {
		log.debug("********** Debut updatePriseEnCharge PriseEnChargeDAO **********");
		try {
			Session session = getSession();
			session.update(priseEnCharge);
		} catch (Exception e) {
			e.printStackTrace();
			log.fatal(e.getMessage());
		} finally {
			log.debug("********** Fin updatePriseEnCharge PriseEnChargeDAO **********");
		}
	}

	public void deletePriseEnCharge(PriseEnCharge priseEnCharge) {
		log.debug("********** Debut deletePriseEnCharge PriseEnChargeDAO **********");
		try {
			Session session = getSession();
			priseEnCharge.setStatut(STATUT_SUPPRIME);
			session.update(priseEnCharge);
		} finally {
			log.debug("********** Fin deletePriseEnCharge PriseEnChargeDAO **********");
		}
	}

	@SuppressWarnings({ "unchecked" })
	public List<PriseEnCharge> listPrisesEnChargesPrestationsCouvertesPcs() {
		log.debug("********** Debut listPrisesEnChargesPrestationsCouvertesPcs PriseEnChargeDAO **********");
		try {
			List<PriseEnCharge> prisesEnChargesPrestationsCouvertesPcs = null;
			Session session = getSession();
			String strQuery = "select distinct priseEnCharge ";
			strQuery += "from PriseEnCharge priseEnCharge, PrestationCouvertesPc prestationCouvertesPc";
			strQuery += "where priseEnCharge.pcId = prestationCouvertesPc.priseEnCharge.pcId ";
			strQuery += "and priseEnCharge.statut = " + STATUT_VALIDE;
			strQuery += " and prestationCouvertesPc.statut = " + STATUT_VALIDE;
			strQuery += " order by classe.classeId asc";
			org.hibernate.Query query = session.createQuery(strQuery);
			prisesEnChargesPrestationsCouvertesPcs = query.list();
			return prisesEnChargesPrestationsCouvertesPcs;
		} catch (Exception e) {
			e.printStackTrace();
			log.fatal(e.getMessage());
			return null;
		} finally {
			log.debug("********** Fin listPrisesEnChargesPrestationsCouvertesPcs PriseEnChargeDAO **********");
		}
	}

	@SuppressWarnings({ "unchecked" })
	public List<PriseEnCharge> listPriseEnCharges() {
		log.debug("********** Debut listPriseEnCharges PriseEnChargeDAO **********");
		try {
			List<PriseEnCharge> priseEnCharges = null;
			Session session = getSession();
			String strQuery = "select distinct priseEnCharge ";
			strQuery += "from PriseEnCharge priseEnCharge";
			strQuery += "where priseEnCharge.statut = " + STATUT_VALIDE;
			strQuery += " order by priseEnCharge.pcId asc";
			org.hibernate.Query query = session.createQuery(strQuery);
			priseEnCharges = query.list();
			return priseEnCharges;
		} catch (Exception e) {
			e.printStackTrace();
			log.fatal(e.getMessage());
			return null;
		} finally {
			log.debug("********** Fin listPriseEnCharges PriseEnChargeDAO **********");
		}
	}

	@SuppressWarnings({ "unchecked" })
	public List<PriseEnCharge> listPriseEnChargesSupprimees() {
		log.debug("********** Debut listPriseEnChargesSupprimees PriseEnChargeDAO **********");
		try {
			List<PriseEnCharge> priseEnCharges = null;
			Session session = getSession();
			String strQuery = "select distinct priseEnCharge ";
			strQuery += "from PriseEnCharge priseEnCharge";
			strQuery += "where priseEnCharge.statut = " + STATUT_SUPPRIME;
			strQuery += " order by PriseEnCharge.pcId asc";
			org.hibernate.Query query = session.createQuery(strQuery);
			priseEnCharges = query.list();
			return priseEnCharges;
		} catch (Exception e) {
			e.printStackTrace();
			log.fatal(e.getMessage());
			return null;
		} finally {
			log.debug("********** Fin listPriseEnChargesSupprimees PriseEnChargeDAO **********");
		}
	}

	@SuppressWarnings("unchecked")
	public List<PriseEnCharge> findPriseEnChargeByPatient(final Patient patient) {
		String queryString = "from PriseEnCharge where patient = :patient";
		Session session = getSession();
		Query query = session.createQuery(queryString);
		query.setParameter("patient", patient);
		return query.list();
	}

	@Override
	protected Class<?> getEntityClass() {
		return PriseEnCharge.class;
	}
}
