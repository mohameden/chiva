package clinique.dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import clinique.mapping.TypePayement;

@Repository
public class TypePayementDAO extends CliniqueHibernateDaoSupport<TypePayement> {

	private static Logger log = Logger.getLogger(TypePayementDAO.class);

	public TypePayement getTypePayement(int typePayementId) {
		log.debug("********** Debut getTypePayement TypePayementDAO **********");
		try {
			TypePayement typePayement = null;
			Session session = getSession();
			typePayement = (TypePayement) session.get(TypePayement.class,
					typePayementId);
			return typePayement;
		} catch (Exception e) {
			e.printStackTrace();
			log.fatal(e.getMessage());
			return null;
		} finally {
			log.debug("********** Fin getTypePayement TypePayementDAO **********");
		}
	}

	public void saveTypePayement(TypePayement typePayement) {
		log.debug("********** Debut saveTypePayement TypePayementDAO **********");
		try {
			Session session = getSession();
			typePayement.setStatut(STATUT_VALIDE);
			session.save(typePayement);
		} catch (Exception e) {
			e.printStackTrace();
			log.fatal(e.getMessage());
		} finally {
			log.debug("********** Fin saveTypePayement TypePayementDAO **********");
		}
	}

	public void updateTypePayement(TypePayement typePayement) {
		log.debug("********** Debut updateTypePayement TypePayementDAO **********");
		try {
			Session session = getSession();
			session.update(typePayement);
		} catch (Exception e) {
			e.printStackTrace();
			log.fatal(e.getMessage());
		} finally {
			log.debug("********** Fin updateTypePayement TypePayementDAO **********");
		}
	}

	public void deleteTypePayement(TypePayement typePayement) {
		log.debug("********** Debut deleteTypePayement TypePayementDAO **********");
		try {
			Session session = getSession();
			typePayement.setStatut(STATUT_SUPPRIME);
			session.update(typePayement);
		} catch (Exception e) {
			e.printStackTrace();
			log.fatal(e.getMessage());
		} finally {
			log.debug("********** Fin deleteTypePayement TypePayementDAO **********");
		}
	}

	@SuppressWarnings({ "unchecked" })
	public List<TypePayement> listTypePayements() {
		log.debug("********** Debut listTypePayements TypePayementDAO **********");
		try {
			List<TypePayement> typePayements = null;
			Session session = getSession();
			String strQuery = "select distinct typePayement ";
			strQuery += " from TypePayement typePayement";
			strQuery += " where typePayement.statut = " + STATUT_VALIDE;
			strQuery += " order by typePayement.typePayementId asc";
			org.hibernate.Query query = session.createQuery(strQuery);
			typePayements = query.list();
			return typePayements;
		} catch (Exception e) {
			e.printStackTrace();
			log.fatal(e.getMessage());
			return null;
		} finally {
			log.debug("********** Fin listTypePayements TypePayementDAO **********");
		}
	}

	@SuppressWarnings({ "unchecked" })
	public List<TypePayement> listTypePayementsSupprimes() {
		log.debug("********** Debut listTypePayementsSupprimes TypePayementDAO **********");
		try {
			List<TypePayement> typePayements = null;
			Session session = getSession();
			String strQuery = "select distinct typePayement ";
			strQuery += "from TypePayement typePayement";
			strQuery += "where typePayement.statut = " + STATUT_SUPPRIME;
			strQuery += " order by typePayement.typePayementId asc";
			org.hibernate.Query query = session.createQuery(strQuery);
			typePayements = query.list();
			return typePayements;
		} catch (Exception e) {
			e.printStackTrace();
			log.fatal(e.getMessage());
			return null;
		} finally {
			log.debug("********** Fin listTypePayementsSupprimes TypePayementDAO **********");
		}
	}

	@Override
	protected Class<?> getEntityClass() {
		return TypePayement.class;
	}
}
