package clinique.dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import clinique.mapping.DetailFacture;
import clinique.mapping.Facture;
import clinique.mapping.HasDetailFactureInfo;
import clinique.mapping.Recu;

@Repository
public class DetailFactureDAO extends
		CliniqueHibernateDaoSupport<DetailFacture> {
	private static Logger log = Logger.getLogger(DetailFactureDAO.class);

	public HasDetailFactureInfo getDetailFacture(int detailFactureId) {
		log.debug("********** Debut getDetailFacture DetailFactureDAO **********");
		try {
			HasDetailFactureInfo detailFacture = null;
			Session session = getSession();
			detailFacture = (HasDetailFactureInfo) session.get(DetailFacture.class,
					detailFactureId);
			return detailFacture;
		} catch (Exception e) {
			e.printStackTrace();
			log.fatal(e.getMessage());
			return null;
		} finally {
			log.debug("********** Fin getDetailFacture DetailFactureDAO **********");
		}
	}

	public void saveDetailFacture(DetailFacture detailFacture) {
		log.debug("********** Debut saveDetailFacture DetailFactureDAO **********");
		try {
			Session session = getSession();
			detailFacture.setStatut(STATUT_VALIDE);
			session.save(detailFacture);
		} catch (Exception e) {
			e.printStackTrace();
			log.fatal(e.getMessage());
		} finally {
			log.debug("********** Fin saveDetailFacture DetailFactureDAO **********");
		}
	}

	public void updateDetailFacture(HasDetailFactureInfo detailFacture) {
		log.debug("********** Debut updateDetailFacture DetailFactureDAO **********");
		try {
			Session session = getSession();
			session.update(detailFacture);
		} catch (Exception e) {
			e.printStackTrace();
			log.fatal(e.getMessage());
		} finally {
			log.debug("********** Fin updateDetailFacture DetailFactureDAO **********");
		}
	}

	public void deleteDetailFacture(DetailFacture detailFacture) {
		log.debug("********** Debut deleteDetailFacture DetailFactureDAO **********");
		try {
			Session session = getSession();
			detailFacture.setStatut(STATUT_SUPPRIME);
			session.update(detailFacture);
		} catch (Exception e) {
			e.printStackTrace();
			log.fatal(e.getMessage());
		} finally {
			log.debug("********** Fin deleteDetailFacture DetailFactureDAO **********");
		}
	}

	@SuppressWarnings({ "unchecked" })
	public List<DetailFacture> listDetailFactures() {
		log.debug("********** Debut listDetailFactures DetailFactureDAO **********");
		try {
			List<DetailFacture> detailFactures = null;
			Session session = getSession();
			String strQuery = "select distinct detailFacture ";
			strQuery += "from DetailFacture detailFacture";
			strQuery += "where detailFacture.statut = " + STATUT_VALIDE;
			strQuery += " order by detailFacture.detailFactIdId asc";
			org.hibernate.Query query = session.createQuery(strQuery);
			detailFactures = query.list();
			return detailFactures;
		} catch (Exception e) {
			e.printStackTrace();
			log.fatal(e.getMessage());
			return null;
		} finally {
			log.debug("********** Fin listDetailFactures DetailFactureDAO **********");
		}
	}

	@SuppressWarnings({ "unchecked" })
	public List<DetailFacture> listDetailFacturesSupprimes() {
		log.debug("********** Debut listDetailFacturesSupprimes DetailFactureDAO **********");
		try {
			List<DetailFacture> detailFactures = null;
			Session session = getSession();
			String strQuery = "select distinct detailFacture ";
			strQuery += "from DetailFacture detailFacture";
			strQuery += "where detailFacture.statut = " + STATUT_SUPPRIME;
			strQuery += " order by detailFacture.detailFactIdId asc";
			org.hibernate.Query query = session.createQuery(strQuery);
			detailFactures = query.list();
			return detailFactures;
		} catch (Exception e) {
			e.printStackTrace();
			log.fatal(e.getMessage());
			return null;
		} finally {
			log.debug("********** Fin listDetailFacturesSupprimes DetailFactureDAO **********");
		}
	}

	@SuppressWarnings("unchecked")
	public List<DetailFacture> findDetailFactureByFacture(final Facture facture) {
		String queryString = "from DetailFacture d where d.facture = :fac";
		Session session = getSession();
		Query query = session.createQuery(queryString);
		query.setEntity("fac", facture);
		return query.list();
	}
	@SuppressWarnings("unchecked")
	public List<DetailFacture> findDetailFactureByRecu(final Recu recu) {
		String queryString = "from DetailFacture d where d.recu = :recu";
		Session session = getSession();
		Query query = session.createQuery(queryString);
		query.setEntity("recu", recu);
		return query.list();
	}

	@Override
	protected Class<?> getEntityClass() {
		return DetailFacture.class;
	}
}
