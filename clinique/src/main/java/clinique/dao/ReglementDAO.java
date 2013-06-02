package clinique.dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import clinique.mapping.Facture;
import clinique.mapping.Reglement;

@Repository
public class ReglementDAO extends CliniqueHibernateDaoSupport<Reglement> {

	private static Logger log = Logger.getLogger(ReglementDAO.class);

	public Reglement getReglement(int reglementId) {
		log.debug("********** Debut getReglement ReglementDAO **********");
		try {
			Reglement reglement = null;
			Session session = getSession();
			reglement = (Reglement) session.get(Reglement.class, reglementId);
			return reglement;
		} catch (Exception e) {
			e.printStackTrace();
			log.fatal(e.getMessage());
			return null;
		} finally {
			log.debug("********** Fin getReglement ReglementDAO **********");
		}
	}

	public void saveReglement(Reglement reglement) {
		log.debug("********** Debut saveReglement ReglementDAO **********");
		try {
			Session session = getSession();
			reglement.setStatut(STATUT_VALIDE);
			session.save(reglement);
		} catch (Exception e) {
			e.printStackTrace();
			log.fatal(e.getMessage());
		} finally {
			log.debug("********** Fin saveReglement ReglementDAO **********");
		}

	}

	public void updateReglement(Reglement reglement) {
		log.debug("********** Debut updateReglement ReglementDAO **********");
		try {
			Session session = getSession();
			session.update(reglement);
		} catch (Exception e) {
			e.printStackTrace();
			log.fatal(e.getMessage());
		} finally {
			log.debug("********** Fin updateReglement ReglementDAO **********");
		}
	}

	public void deleteReglement(Reglement reglement) {
		log.debug("********** Debut deleteReglement ReglementDAO **********");
		try {
			Session session = getSession();
			reglement.setStatut(STATUT_SUPPRIME);
			session.update(reglement);
		} catch (Exception e) {
			e.printStackTrace();
			log.fatal(e.getMessage());
		} finally {
			log.debug("********** Fin deleteReglement ReglementDAO **********");
		}
	}

	@SuppressWarnings({ "unchecked" })
	public List<Reglement> listReglements() {
		log.debug("********** Debut listReglements ReglementDAO **********");
		try {
			List<Reglement> reglements = null;
			Session session = getSession();
			String strQuery = "select distinct reglement ";
			strQuery += "from Reglement reglement";
			strQuery += "where reglement.statut = " + STATUT_VALIDE;
			strQuery += " order by reglement.reglementId asc";
			org.hibernate.Query query = session.createQuery(strQuery);
			reglements = query.list();
			return reglements;
		} catch (Exception e) {
			e.printStackTrace();
			log.fatal(e.getMessage());
			return null;
		} finally {
			log.debug("********** Fin listReglements ReglementDAO **********");
		}
	}

	@SuppressWarnings({ "unchecked" })
	public List<Reglement> listReglementsSupprimes() {
		log.debug("********** Debut listReglementsSupprimes ReglementDAO **********");
		try {
			List<Reglement> reglements = null;
			Session session = getSession();
			String strQuery = "select distinct reglement ";
			strQuery += "from Reglement reglement";
			strQuery += "where reglement.statut = " + STATUT_SUPPRIME;
			strQuery += " order by reglement.reglementId asc";
			org.hibernate.Query query = session.createQuery(strQuery);
			reglements = query.list();
			return reglements;
		} catch (Exception e) {
			e.printStackTrace();
			log.fatal(e.getMessage());
			return null;
		} finally {
			log.debug("********** Fin listReglementsSupprimes ReglementDAO **********");
		}
	}

	@Override
	protected Class<?> getEntityClass() {
		return Reglement.class;
	}

	@SuppressWarnings("unchecked")
	public List<Reglement> findReglementsByFacture(Facture facture) {
		String queryString = "from Reglement d where d.facture = :fac";
		Session session = getSession();
		Query query = session.createQuery(queryString);
		query.setEntity("fac", facture);
		return query.list();
	}
}
