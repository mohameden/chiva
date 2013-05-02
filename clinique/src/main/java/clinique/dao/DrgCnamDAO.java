package clinique.dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import clinique.mapping.DrgCnam;

@Repository
public class DrgCnamDAO extends CliniqueHibernateDaoSupport<DrgCnam> {

	private static Logger log = Logger.getLogger(DrgCnamDAO.class);

	public DrgCnam getDrgCnam(String drgCnamId) {
		log.debug("********** Debut getDrgCnam DrgCnamDAO **********");
		try {
			DrgCnam drgCnam = null;
			Session session = getSession();
			drgCnam = (DrgCnam) session.get(DrgCnam.class, drgCnamId);
			return drgCnam;
		} catch (Exception e) {
			e.printStackTrace();
			log.fatal(e.getMessage());
			return null;
		} finally {
			log.debug("********** Fin getDrgCnam DrgCnamDAO **********");
		}
	}

	public void saveDrgCnam(DrgCnam drgCnam) {
		log.debug("********** Debut saveDrgCnam DrgCnamDAO **********");
		try {
			Session session = getSession();
			drgCnam.setStatut(STATUT_VALIDE);
			session.save(drgCnam);
		} catch (Exception e) {
			e.printStackTrace();
			log.fatal(e.getMessage());
		} finally {
			log.debug("********** Fin saveDrgCnam DrgCnamDAO **********");
		}
	}

	public void updateDrgCnam(DrgCnam drgCnam) {
		log.debug("********** Debut updateDrgCnam DrgCnamDAO **********");
		try {
			Session session = getSession();
			session.update(drgCnam);
		} catch (Exception e) {
			e.printStackTrace();
			log.fatal(e.getMessage());
		} finally {
			log.debug("********** Fin updateDrgCnam DrgCnamDAO **********");
		}
	}

	public void deleteDrgCnam(DrgCnam drgCnam) {
		log.debug("********** Debut deleteDrgCnam DrgCnamDAO **********");
		try {
			Session session = getSession();
			drgCnam.setStatut(STATUT_SUPPRIME);
			session.update(drgCnam);
		} catch (Exception e) {
			e.printStackTrace();
			log.fatal(e.getMessage());
		} finally {
			log.debug("********** Fin deleteDrgCnam DrgCnamDAO **********");
		}
	}

	@SuppressWarnings({ "unchecked" })
	public List<DrgCnam> listDrgCnams() {
		log.debug("********** Debut listDrgCnams DrgCnamDAO **********");
		try {
			List<DrgCnam> drgCnams = null;
			Session session = getSession();
			String strQuery = "select distinct drgCnam ";
			strQuery += "from DrgCnam drgCnam ";
			strQuery += "where drgCnam.statut = " + STATUT_VALIDE;
			strQuery += " order by drgCnam.numDrg asc";
			org.hibernate.Query query = session.createQuery(strQuery);
			drgCnams = query.list();
			return drgCnams;
		} catch (Exception e) {
			e.printStackTrace();
			log.fatal(e.getMessage());
			return null;
		} finally {
			log.debug("********** Fin listDrgCnams DrgCnamDAO **********");
		}
	}

	@Override
	protected Class<?> getEntityClass() {
		return DrgCnam.class;
	}

}
