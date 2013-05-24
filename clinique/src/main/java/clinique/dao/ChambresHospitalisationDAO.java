package clinique.dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import clinique.mapping.ChambresHospitalisation;
import clinique.mapping.Hospitalisation;

@Repository
public class ChambresHospitalisationDAO extends
		CliniqueHibernateDaoSupport<ChambresHospitalisation> {

	private static Logger log = Logger
			.getLogger(ChambresHospitalisationDAO.class);

	public ChambresHospitalisation getChambresHospitalisation(
			String chambresHospitalisationId) {
		log.debug("********** Debut getChambresHospitalisation ChambresHospitalisationDAO **********");
		try {
			ChambresHospitalisation chambresHospitalisation = null;
			Session session = getSession();
			chambresHospitalisation = (ChambresHospitalisation) session.get(
					ChambresHospitalisation.class, chambresHospitalisationId);
			return chambresHospitalisation;
		} catch (Exception e) {
			e.printStackTrace();
			log.fatal(e.getMessage());
			return null;
		} finally {
			log.debug("********** Fin getChambresHospitalisation ChambresHospitalisationDAO **********");
		}
	}

	public void saveChambresHospitalisation(
			ChambresHospitalisation chambresHospitalisation) {
		log.debug("********** Debut saveChambresHospitalisation ChambresHospitalisationDAO **********");
		try {
			Session session = getSession();
			chambresHospitalisation.setStatut(STATUT_SUPPRIME);
			session.save(chambresHospitalisation);
			// SessionFactoryUtil.getInstance().close();

		} catch (Exception e) {
			e.printStackTrace();
			log.fatal(e.getMessage());
		} finally {
			log.debug("********** Fin saveChambresHospitalisation ChambresHospitalisationDAO **********");
		}
	}

	public void updateChambresHospitalisation(
			ChambresHospitalisation chambresHospitalisation) {
		log.debug("********** Debut updateChambresHospitalisation ChambresHospitalisationDAO **********");
		try {
			Session session = getSession();
			session.update(chambresHospitalisation);
			// SessionFactoryUtil.getInstance().close();
		} catch (Exception e) {
			e.printStackTrace();
			log.fatal(e.getMessage());
		} finally {
			log.debug("********** Fin updateChambresHospitalisation ChambresHospitalisationDAO **********");
		}
	}

	public void deleteChambresHospitalisation(
			ChambresHospitalisation chambresHospitalisation) {
		log.debug("********** Debut deleteChambresHospitalisation ChambresHospitalisationDAO **********");
		try {
			Session session = getSession();
			chambresHospitalisation.setStatut(STATUT_SUPPRIME);
			session.update(chambresHospitalisation);
		} catch (Exception e) {
			e.printStackTrace();
			log.fatal(e.getMessage());
		} finally {
			log.debug("********** Fin deleteChambresHospitalisation ChambresHospitalisationDAO **********");
		}
	}

	@SuppressWarnings("unchecked")
	public List<ChambresHospitalisation> findChambresHospitalisationByHospitalisation(
			final Hospitalisation hospitalisation) {
		String queryString = "from ChambresHospitalisation where hospitalisation = :hospitalisation";
		Session session = getSession();
		Query query = session.createQuery(queryString);
		query.setParameter("hospitalisation", hospitalisation);
		return query.list();
	}

	@Override
	protected Class<?> getEntityClass() {
		return ChambresHospitalisation.class;
	}

}
