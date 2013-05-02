package clinique.dao;

import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import clinique.mapping.Acte;
import clinique.mapping.Acteur;
import clinique.mapping.ActeurActeAssureur;
import clinique.mapping.Categorie;
import clinique.utils.UtilDate;

@Repository
public class ActeurActeAssureurDAO extends
		CliniqueHibernateDaoSupport<ActeurActeAssureur> {

	private static Logger log = Logger.getLogger(ActeurActeAssureurDAO.class);

	public ActeurActeAssureur getActeurActeAssureur(String acteurActeAssureurId) {
		log.debug("********** Debut getActeurActeAssureur ActeurActeAssureurDAO **********");
		try {
			ActeurActeAssureur acteurActeAssureur = null;
			Session session = getSession();
			acteurActeAssureur = (ActeurActeAssureur) session.get(
					ActeurActeAssureur.class, acteurActeAssureurId);
			return acteurActeAssureur;
		} catch (Exception e) {
			e.printStackTrace();
			log.fatal(e.getMessage());
			return null;
		} finally {
			log.debug("********** Fin getActeurActeAssureur ActeurActeAssureurDAO **********");
		}
	}

	@SuppressWarnings("unchecked")
	public ActeurActeAssureur getActeurActeAssureurByDate(Acteur acteur,
			Date date1, Acte acte, Categorie categorie) {
		log.debug("********** Debut getActeurActeAssureurByDate ActeurActeAssureurDAO **********");
		try {
			if (acteur != null && date1 != null && acte != null
					&& categorie != null) {
				List<ActeurActeAssureur> acteurActes = null;
				String dateFacture = UtilDate.getInstance().stringToDateMysql(
						UtilDate.getInstance().dateToString(date1));
				Session session = getSession();
				String strQuery = "select distinct acteurActeAssureur ";
				strQuery += "from ActeurActeAssureur acteurActeAssureur ";
				strQuery += " where acteurActeAssureur.acte.acteId = "
						+ acte.getActeId();
				strQuery += " and acteurActeAssureur.acteur.acteurId = "
						+ acteur.getActeurId();
				strQuery += " and acteurActeAssureur.categorie.categorieId = "
						+ categorie.getCategorieId();
				strQuery += " and acteurActeAssureur.isException = "
						+ STATUT_VALIDE;
				strQuery += " and acteurActeAssureur.statut = " + STATUT_VALIDE;
				strQuery += " and acteurActeAssureur.dateDebut <= '"
						+ dateFacture + "'";
				strQuery += " and acteurActeAssureur.dateFin >= '"
						+ dateFacture + "'";
				// strQuery+=" order by facture.factureId asc";
				System.out.println(strQuery);
				org.hibernate.Query query = session.createQuery(strQuery);
				acteurActes = query.list();
				if (acteurActes.size() == 0) {
					return null;
				} else {
					return acteurActes.get(0);
				}
			} else {
				return null;
			}

		} catch (Exception e) {
			e.printStackTrace();
			log.fatal(e.getMessage());
			return null;
		} finally {
			log.debug("********** Fin getActeurActeAssureurByDate ActeurActeAssureurDAO **********");
		}
	}

	public void saveActeurActeAssureur(ActeurActeAssureur acteurActeAssureur) {
		log.debug("********** Debut saveActeurActeAssureur ActeurActeAssureurDAO **********");
		try {
			Session session = getSession();
			acteurActeAssureur.setStatut(STATUT_VALIDE);
			session.save(acteurActeAssureur);
		} catch (Exception e) {
			e.printStackTrace();
			log.fatal(e.getMessage());
		} finally {
			log.debug("********** Fin saveActeurActeAssureur ActeurActeAssureurDAO **********");
		}
	}

	public void deleteActeurActeAssureur(ActeurActeAssureur acteurActeAssureur) {
		log.debug("********** Debut deleteActeurActeAssureur ActeurActeAssureurDAO **********");
		try {
			Session session = getSession();
			acteurActeAssureur.setStatut(STATUT_SUPPRIME);
			session.update(acteurActeAssureur);
		} catch (Exception e) {
			e.printStackTrace();
			log.fatal(e.getMessage());
		} finally {
			log.debug("********** Fin deleteActeurActeAssureur ActeurActeAssureurDAO **********");
		}
	}

	@SuppressWarnings({ "unchecked" })
	public List<ActeurActeAssureur> listActeurActeAssureursActeurActeAssureururs() {
		log.debug("********** Debut listActeurActeAssureursActeurActeAssureururs ActeurActeAssureurDAO **********");
		try {
			List<ActeurActeAssureur> acteurActeAssureursActeurActeAssureururs = null;
			Session session = getSession();
			String strQuery = "select distinct acteurActeAssureur ";
			strQuery += "from ActeurActeAssureur acteurActeAssureur, ActeurActeAssureururActeurActeAssureur acteurActeAssureururActeurActeAssureur ";
			strQuery += "where acteurActeAssureur.acteurActeAssureurId = acteurActeAssureururActeurActeAssureur.acteurActeAssureur.acteurActeAssureurId ";
			strQuery += "and acteurActeAssureur.statut = " + STATUT_VALIDE;
			strQuery += " and acteurActeAssureururActeurActeAssureur.statut = "
					+ STATUT_VALIDE;
			strQuery += " order by acteurActeAssureur.acteurActeAssureurId asc";
			org.hibernate.Query query = session.createQuery(strQuery);
			acteurActeAssureursActeurActeAssureururs = query.list();
			return acteurActeAssureursActeurActeAssureururs;
		} catch (Exception e) {
			e.printStackTrace();
			log.fatal(e.getMessage());
			return null;
		} finally {
			log.debug("********** Fin listActeurActeAssureursActeurActeAssureururs ActeurActeAssureurDAO **********");
		}
	}

	@SuppressWarnings({ "unchecked" })
	public List<ActeurActeAssureur> listActeurActeAssureursDetailFactures() {
		log.debug("********** Debut listActeurActeAssureursDetailFactures ActeurActeAssureurDAO **********");
		try {
			List<ActeurActeAssureur> acteurActeAssureursDetailFactures = null;
			Session session = getSession();
			String strQuery = "select distinct acteurActeAssureur ";
			strQuery += "from ActeurActeAssureur acteurActeAssureur, DetailFacture detailFacture ";
			strQuery += "where acteurActeAssureur.acteurActeAssureurId = DetailFacture.acteurActeAssureur.acteurActeAssureurId ";
			strQuery += "and acteurActeAssureur.statut = " + STATUT_VALIDE;
			strQuery += " and DetailFacture.statut = " + STATUT_VALIDE;
			strQuery += " order by acteurActeAssureur.acteurActeAssureurId asc";
			org.hibernate.Query query = session.createQuery(strQuery);
			acteurActeAssureursDetailFactures = query.list();
			return acteurActeAssureursDetailFactures;
		} catch (Exception e) {
			e.printStackTrace();
			log.fatal(e.getMessage());
			return null;
		} finally {
			log.debug("********** Fin listActeurActeAssureursDetailFactures ActeurActeAssureurDAO **********");
		}
	}

	@SuppressWarnings({ "unchecked" })
	public List<ActeurActeAssureur> listActeurActeAssureurs() {
		log.debug("********** Debut listActeurActeAssureurs ActeurActeAssureurDAO **********");
		try {
			List<ActeurActeAssureur> acteurActeAssureurs = null;
			Session session = getSession();
			String strQuery = "select distinct acteurActeAssureur ";
			strQuery += "from ActeurActeAssureur acteurActeAssureur ";
			strQuery += "where acteurActeAssureur.statut = " + STATUT_VALIDE;
			strQuery += " order by acteurActeAssureur.acteurActeAssureurId asc";
			org.hibernate.Query query = session.createQuery(strQuery);
			acteurActeAssureurs = query.list();
			return acteurActeAssureurs;
		} catch (Exception e) {
			e.printStackTrace();
			log.fatal(e.getMessage());
			return null;
		} finally {
			log.debug("********** Fin listActeurActeAssureurs ActeurActeAssureurDAO **********");
		}
	}

	@SuppressWarnings({ "unchecked" })
	public List<ActeurActeAssureur> listActeurActeAssureursSupprimes() {
		log.debug("********** Debut listActeurActeAssureursSupprimes ActeurActeAssureurDAO **********");
		try {
			List<ActeurActeAssureur> acteurActeAssureurs = null;
			Session session = getSession();
			String strQuery = "select distinct acteurActeAssureur ";
			strQuery += "from ActeurActeAssureur acteurActeAssureur ";
			strQuery += "where acteurActeAssureur.statut = " + STATUT_SUPPRIME;
			strQuery += " order by acteurActeAssureur.acteurActeAssureurId asc";
			org.hibernate.Query query = session.createQuery(strQuery);
			acteurActeAssureurs = query.list();
			return acteurActeAssureurs;
		} catch (Exception e) {
			e.printStackTrace();
			log.fatal(e.getMessage());
			return null;
		} finally {
			log.debug("********** Fin listActeurActeAssureursSupprimes ActeurActeAssureurDAO **********");
		}
	}

	@Override
	protected Class<?> getEntityClass() {
		return ActeurActeAssureur.class;
	}
}
