package clinique.dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import clinique.mapping.PcPersonnel;

@Repository
public class PcPersonnelDAO extends CliniqueHibernateDaoSupport<PcPersonnel> {

	private static Logger log = Logger.getLogger(PcPersonnelDAO.class);

	public PcPersonnel getPcPersonnel(int pcPersonnelId) {
		log.debug("********** Debut getPcPersonnel PcPersonnelDAO **********");
		try {
			PcPersonnel pcPersonnel = null;
			Session session = getSession();
			pcPersonnel = (PcPersonnel) session.get(PcPersonnel.class,
					pcPersonnelId);
			return pcPersonnel;
		} catch (Exception e) {
			e.printStackTrace();
			log.fatal(e.getMessage());
			return null;
		} finally {
			log.debug("********** Fin getPcPersonnel PcPersonnelDAO **********");
		}
	}

	public void savePcPersonnel(PcPersonnel pcPersonnel) {
		log.debug("********** Debut savePcPersonnel PcPersonnelDAO **********");
		try {
			Session session = getSession();
			pcPersonnel.setStatut(STATUT_VALIDE);
			session.save(pcPersonnel);
		} catch (Exception e) {
			e.printStackTrace();
			log.fatal(e.getMessage());
		} finally {
			log.debug("********** Fin savePcPersonnel PcPersonnelDAO **********");
		}
	}

	public void updatePcPersonnel(PcPersonnel pcPersonnel) {
		log.debug("********** Debut updatePcPersonnel PcPersonnelDAO **********");
		try {
			Session session = getSession();
			session.update(pcPersonnel);
		} catch (Exception e) {
			e.printStackTrace();
			log.fatal(e.getMessage());
		} finally {
			log.debug("********** Fin updatePcPersonnel PcPersonnelDAO **********");
		}
	}

	public void deletePcPersonnel(PcPersonnel pcPersonnel) {
		log.debug("********** Debut deletePcPersonnel PcPersonnelDAO **********");
		try {
			Session session = getSession();
			pcPersonnel.setStatut(STATUT_SUPPRIME);
			session.update(pcPersonnel);
		} catch (Exception e) {
			e.printStackTrace();
			log.fatal(e.getMessage());
		} finally {
			log.debug("********** Fin deletePcPersonnel PcPersonnelDAO **********");
		}
	}

	@SuppressWarnings({ "unchecked" })
	public List<PcPersonnel> listPcPersonnels() {
		log.debug("********** Debut listPcPersonnels PcPersonnelDAO **********");
		try {
			List<PcPersonnel> pcPersonnels = null;
			Session session = getSession();
			String strQuery = "select distinct pcPersonnel ";
			strQuery += "from PcPersonnel pcPersonnel";
			strQuery += " where pcPersonnel.statut = " + STATUT_VALIDE;
			strQuery += " and pcPersonnel.compte.statut = " + STATUT_VALIDE;
			strQuery += " order by pcPersonnel.pcPersonnelId asc";
			org.hibernate.Query query = session.createQuery(strQuery);
			pcPersonnels = query.list();
			return pcPersonnels;
		} catch (Exception e) {
			e.printStackTrace();
			log.fatal(e.getMessage());
			return null;
		} finally {
			log.debug("********** Fin listPcPersonnels PcPersonnelDAO **********");
		}
	}

	@Override
	protected Class<?> getEntityClass() {
		return PcPersonnel.class;
	}

}
