package clinique.dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import clinique.mapping.Acteur;

@Repository
public class ActeurDAO extends CliniqueHibernateDaoSupport<Acteur> {
	private static Logger log = Logger.getLogger(ActeurDAO.class);

	public Acteur getActeur(int acteurId) {
		log.debug("********** Debut getActeur ActeurDAO **********");
		try {
			Acteur Acteur = null;
			Session session = getSession();
			Acteur = (Acteur) session.get(Acteur.class, acteurId);
			return Acteur;
		} catch (Exception e) {
			e.printStackTrace();
			log.fatal(e.getMessage());
			return null;
		} finally {
			log.debug("********** Fin getActeur ActeurDAO **********");
		}
	}

	public void saveActeur(Acteur acteur) {
		log.debug("********** Debut saveActeur ActeurDAO **********");
		try {
			Session session = getSession();
			acteur.setStatut(STATUT_VALIDE);
			session.save(acteur);
		} catch (Exception e) {
			e.printStackTrace();
			log.fatal(e.getMessage());
		} finally {
			log.debug("********** Fin saveActeur ActeurDAO **********");
		}
	}

	public void updateActeur(Acteur acteur) {
		log.debug("********** Debut updateActeur ActeurDAO **********");
		try {
			Session session = getSession();
			session.update(acteur);
		} catch (Exception e) {
			e.printStackTrace();
			log.fatal(e.getMessage());
		} finally {
			log.debug("********** Fin updateActeur ActeurDAO **********");
		}
	}

	public void deleteActeur(Acteur acteur) {
		log.debug("********** Debut deleteActeur ActeurDAO **********");
		try {
			Session session = getSession();
			acteur.setStatut(STATUT_SUPPRIME);
			session.update(acteur);
		} catch (Exception e) {
			e.printStackTrace();
			log.fatal(e.getMessage());
		} finally {
			log.debug("********** Fin deleteActeur ActeurDAO **********");
		}
	}

	@SuppressWarnings({ "unchecked" })
	public List<Acteur> listActeuresActes() {
		log.debug("********** Debut listActeuresActes ActeurDAO **********");
		try {
			List<Acteur> acteuresActes = null;
			Session session = getSession();
			String strQuery = "select distinct acteur ";
			strQuery += "from Acteur acteur, ActeurActe acteurActe";
			strQuery += "where acteur.acteurId = acteurActe.acteur.acteurId ";
			strQuery += "and acteur.statut = " + STATUT_VALIDE;
			strQuery += " and acteurActe.statut = " + STATUT_VALIDE;
			strQuery += " order by acteur.acteurId asc";
			org.hibernate.Query query = session.createQuery(strQuery);
			acteuresActes = query.list();
			return acteuresActes;
		} catch (Exception e) {
			e.printStackTrace();
			log.fatal(e.getMessage());
			return null;
		} finally {
			log.debug("********** Fin listActeuresActes ActeurDAO **********");
		}
	}

	@SuppressWarnings({ "unchecked" })
	public List<Acteur> listActeures() {
		log.debug("********** Debut listActeures ActeurDAO **********");
		try {
			List<Acteur> acteurs = null;
			Session session = getSession();
			String strQuery = "select distinct acteur ";
			strQuery += "from Acteur acteur";
			strQuery += " where statut = " + STATUT_VALIDE;
			strQuery += " order by acteur.acteurId asc";
			org.hibernate.Query query = session.createQuery(strQuery);
			acteurs = query.list();
			return acteurs;
		} catch (Exception e) {
			e.printStackTrace();
			log.fatal(e.getMessage());
			return null;
		} finally {
			log.debug("********** Fin listActeures ActeurDAO **********");
		}
	}

	@SuppressWarnings({ "unchecked" })
	public List<Acteur> listActeuresSupprimes() {
		log.debug("********** Debut listActeuresSupprimes ActeurDAO **********");
		try {
			List<Acteur> acteurs = null;
			Session session = getSession();
			String strQuery = "select distinct acteur ";
			strQuery += "from Acteur acteur";
			strQuery += "where classe.statut = " + STATUT_SUPPRIME;
			strQuery += " order by acteur.acteurId asc";
			org.hibernate.Query query = session.createQuery(strQuery);
			acteurs = query.list();
			return acteurs;
		} catch (Exception e) {
			e.printStackTrace();
			log.fatal(e.getMessage());
			return null;
		} finally {
			log.debug("********** Fin listActeuresSupprimes ActeurDAO **********");
		}
	}

	@Override
	protected Class<?> getEntityClass() {
		return Acteur.class;
	}
}
