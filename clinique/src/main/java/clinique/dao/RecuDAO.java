package clinique.dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import clinique.mapping.Recu;

@Repository
public class RecuDAO extends CliniqueHibernateDaoSupport<Recu> {

	private static Logger log = Logger.getLogger(RecuDAO.class);

	public Recu getRecu(String recuId) {
		log.debug("********** Debut getRecu RecuDAO **********");
		try {
			Recu recu = null;
			Session session = getSession();
			recu = (Recu) session.get(Recu.class, recuId);
			return recu;
		} catch (Exception e) {
			e.printStackTrace();
			log.fatal(e.getMessage());
			return null;
		} finally {
			log.debug("********** Fin getRecu RecuDAO **********");
		}
	}

	public void saveRecu(Recu recu) {
		log.debug("********** Debut saveRecu RecuDAO **********");
		try {
			Session session = getSession();

			session.save(recu);

		} catch (Exception e) {
			e.printStackTrace();
			log.fatal(e.getMessage());
		} finally {
			log.debug("********** Fin saveRecu RecuDAO **********");
		}
	}

	public void updateRecu(Recu recu) {
		log.debug("********** Debut updateRecu RecuDAO **********");
		try {
			Session session = getSession();
			session.update(recu);
		} catch (Exception e) {
			e.printStackTrace();
			log.fatal(e.getMessage());
		} finally {
			log.debug("********** Fin updateRecu RecuDAO **********");
		}
	}

	public void deleteRecu(Recu recu) {
		log.debug("********** Debut deleteRecu RecuDAO **********");
		try {
			Session session = getSession();
			recu.setStatut(STATUT_SUPPRIME);
			session.update(recu);
		} catch (Exception e) {
			e.printStackTrace();
			log.fatal(e.getMessage());
		} finally {
			log.debug("********** Fin deleteRecu RecuDAO **********");
		}
	}

	@SuppressWarnings({ "unchecked" })
	public List<Recu> listRecus() {
		log.debug("********** Debut listRecus RecuDAO **********");
		try {
			List<Recu> recus = null;
			Session session = getSession();
			String strQuery = "select distinct recu ";
			strQuery += "from Recu recu";
			strQuery += "where recu.statut = " + STATUT_VALIDE;
			strQuery += " order by recu.recuId asc";
			org.hibernate.Query query = session.createQuery(strQuery);
			recus = query.list();
			return recus;
		} catch (Exception e) {
			e.printStackTrace();
			log.fatal(e.getMessage());
			return null;
		} finally {
			log.debug("********** Fin listRecus RecuDAO **********");
		}
	}

	@Override
	protected Class<?> getEntityClass() {
		return Recu.class;
	}

}
