package clinique.dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import clinique.mapping.DetailDgrCnamFacture;

@Repository
public class DetailDgrCnamFactureDAO extends
		CliniqueHibernateDaoSupport<DetailDgrCnamFacture> {

	private static Logger log = Logger.getLogger(DetailDgrCnamFactureDAO.class);

	public DetailDgrCnamFacture getDetailDgrCnamFacture(
			String detailDgrCnamFactureId) {
		log.debug("********** Debut getDetailDgrCnamFacture DetailDgrCnamFactureDAO **********");
		try {
			DetailDgrCnamFacture detailDgrCnamFacture = null;
			Session session = getSession();
			detailDgrCnamFacture = (DetailDgrCnamFacture) session.get(
					DetailDgrCnamFacture.class, detailDgrCnamFactureId);
			return detailDgrCnamFacture;
		} catch (Exception e) {
			e.printStackTrace();
			log.fatal(e.getMessage());
			return null;
		} finally {
			log.debug("********** Fin getDetailDgrCnamFacture DetailDgrCnamFactureDAO **********");
		}
	}

	public void saveDetailDgrCnamFacture(
			DetailDgrCnamFacture detailDgrCnamFacture) {
		log.debug("********** Debut saveDetailDgrCnamFacture DetailDgrCnamFactureDAO **********");
		try {
			Session session = getSession();
			detailDgrCnamFacture.setStatut(STATUT_SUPPRIME);
			session.save(detailDgrCnamFacture);

		} catch (Exception e) {
			e.printStackTrace();
			log.fatal(e.getMessage());
		} finally {
			log.debug("********** Fin saveDetailDgrCnamFacture DetailDgrCnamFactureDAO **********");
		}
	}

	public void updateDetailDgrCnamFacture(
			DetailDgrCnamFacture detailDgrCnamFacture) {
		log.debug("********** Debut updateDetailDgrCnamFacture DetailDgrCnamFactureDAO **********");
		try {
			Session session = getSession();
			session.update(detailDgrCnamFacture);
		} catch (Exception e) {
			e.printStackTrace();
			log.fatal(e.getMessage());
		} finally {
			log.debug("********** Fin updateDetailDgrCnamFacture DetailDgrCnamFactureDAO **********");
		}
	}

	public void deleteDetailDgrCnamFacture(
			DetailDgrCnamFacture detailDgrCnamFacture) {
		log.debug("********** Debut deleteDetailDgrCnamFacture DetailDgrCnamFactureDAO **********");
		try {
			Session session = getSession();
			detailDgrCnamFacture.setStatut(STATUT_SUPPRIME);
			session.update(detailDgrCnamFacture);
		} catch (Exception e) {
			e.printStackTrace();
			log.fatal(e.getMessage());
		} finally {
			log.debug("********** Fin deleteDetailDgrCnamFacture DetailDgrCnamFactureDAO **********");
		}
	}

	@SuppressWarnings({ "unchecked" })
	public List<DetailDgrCnamFacture> listDetailDgrCnamFactures() {
		log.debug("********** Debut listDetailDgrCnamFactures DetailDgrCnamFactureDAO **********");
		try {
			List<DetailDgrCnamFacture> detailDgrCnamFactures = null;
			Session session = getSession();
			String strQuery = "select distinct detailDgrCnamFacture ";
			strQuery += "from DetailDgrCnamFacture detailDgrCnamFacture";
			strQuery += "where detailDgrCnamFacture.statut = " + STATUT_VALIDE;
			strQuery += " order by detailDgrCnamFacture.detailDgrCnamFactureId asc";
			org.hibernate.Query query = session.createQuery(strQuery);
			detailDgrCnamFactures = query.list();
			return detailDgrCnamFactures;
		} catch (Exception e) {
			e.printStackTrace();
			log.fatal(e.getMessage());
			return null;
		} finally {
			log.debug("********** Fin listDetailDgrCnamFactures DetailDgrCnamFactureDAO **********");
		}
	}

	@SuppressWarnings({ "unchecked" })
	public List<DetailDgrCnamFacture> listDetailDgrCnamFacturesSupprimees() {
		log.debug("********** Debut listDetailDgrCnamFacturesSupprimees DetailDgrCnamFactureDAO **********");
		try {
			List<DetailDgrCnamFacture> detailDgrCnamFacturesSupprimees = null;
			Session session = getSession();
			String strQuery = "select distinct detailDgrCnamFacture ";
			strQuery += "from DetailDgrCnamFacture detailDgrCnamFacture";
			strQuery += "where detailDgrCnamFacture.statut = "
					+ STATUT_SUPPRIME;
			strQuery += " order by detailDgrCnamFacture.detailDgrCnamFactureId asc";
			org.hibernate.Query query = session.createQuery(strQuery);
			detailDgrCnamFacturesSupprimees = query.list();
			return detailDgrCnamFacturesSupprimees;
		} catch (Exception e) {
			e.printStackTrace();
			log.fatal(e.getMessage());
			return null;
		} finally {
			log.debug("********** Fin listDetailDgrCnamFacturesSupprimees DetailDgrCnamFactureDAO **********");
		}
	}

	@Override
	protected Class<?> getEntityClass() {
		return DetailDgrCnamFacture.class;
	}

}
