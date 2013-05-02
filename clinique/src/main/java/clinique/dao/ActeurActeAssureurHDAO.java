package clinique.dao;

import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import clinique.mapping.Acte;
import clinique.mapping.Acteur;
import clinique.mapping.ActeurActeAssureurH;
import clinique.mapping.Categorie;
import clinique.utils.UtilDate;

@Repository
public class ActeurActeAssureurHDAO extends
		CliniqueHibernateDaoSupport<ActeurActeAssureurH> {

	private static Logger log = Logger.getLogger(ActeurActeAssureurHDAO.class);

	public ActeurActeAssureurH getActeurActeAssureurH(
			String acteurActeAssureurHId) {
		log.debug("********** Debut getActeurActeAssureurH ActeurActeAssureurHDAO **********");
		try {
			ActeurActeAssureurH acteurActeAssureurH = null;
			Session session = getSession();
			acteurActeAssureurH = (ActeurActeAssureurH) session.get(
					ActeurActeAssureurH.class, acteurActeAssureurHId);
			return acteurActeAssureurH;
		} catch (Exception e) {
			e.printStackTrace();
			log.fatal(e.getMessage());
			return null;
		} finally {
			log.debug("********** Fin getActeurActeAssureurH ActeurActeAssureurHDAO **********");
		}
	}

	@SuppressWarnings("unchecked")
	public ActeurActeAssureurH getActeurActeAssureurHByDate(Acteur acteur,
			Date date1, Acte acte, Categorie categorie) {
		log.debug("********** Debut getActeurActeAssureurHByDate ActeurActeAssureurHDAO **********");
		try {
			if (acteur != null && date1 != null && acte != null
					&& categorie != null) {
				List<ActeurActeAssureurH> actes = null;
				String dateFacture = UtilDate.getInstance().stringToDateMysql(
						UtilDate.getInstance().dateToString(date1));
				Session session = getSession();
				String strQuery = "select distinct acteurActeAssureurH ";
				strQuery += "from ActeurActeAssureurH acteurActeAssureurH ";
				strQuery += "where acteurActeAssureurH.acte.acteId = "
						+ acte.getActeId();
				strQuery += " and acteurActeAssureurH.acteur.acteurId = "
						+ acteur.getActeurId();
				strQuery += " and acteurActeAssureurH.categorie.categorieId = "
						+ categorie.getCategorieId();
				strQuery += " and acteurActeAssureurH.isException = "
						+ STATUT_VALIDE;
				strQuery += " and acteurActeAssureurH.statut = "
						+ STATUT_VALIDE;
				strQuery += " and acteurActeAssureurH.dateDebut <= '"
						+ dateFacture + "'";
				strQuery += " and acteurActeAssureurH.dateFin >= '"
						+ dateFacture + "'";
				// strQuery+=" order by facture.factureId asc";
				System.out.println(strQuery);
				org.hibernate.Query query = session.createQuery(strQuery);
				actes = query.list();
				if (actes.size() == 0) {
					return null;
				} else {
					return actes.get(0);
				}
			} else {
				return null;
			}

		} catch (Exception e) {
			e.printStackTrace();
			log.fatal(e.getMessage());
			return null;
		} finally {
			log.debug("********** Fin getActeurActeAssureurHByDate ActeurActeAssureurHDAO **********");
		}
	}

	public void saveActeurActeAssureurH(ActeurActeAssureurH acteurActeAssureurH) {
		log.debug("********** Debut saveActeurActeAssureurH ActeurActeAssureurHDAO **********");
		try {
			Session session = getSession();
			acteurActeAssureurH.setStatut(STATUT_VALIDE);
			session.save(acteurActeAssureurH);
		} catch (Exception e) {
			e.printStackTrace();
			log.fatal(e.getMessage());
		} finally {
			log.debug("********** Fin saveActeurActeAssureurH ActeurActeAssureurHDAO **********");
		}
	}

	public void updateActeurActeAssureurH(
			ActeurActeAssureurH acteurActeAssureurH) {
		log.debug("********** Debut updateActeurActeAssureurH ActeurActeAssureurHDAO **********");
		try {
			Session session = getSession();
			session.update(acteurActeAssureurH);
		} catch (Exception e) {
			e.printStackTrace();
			log.fatal(e.getMessage());
		} finally {
			log.debug("********** Fin updateActeurActeAssureurH ActeurActeAssureurHDAO **********");
		}
	}

	public void deleteActeurActeAssureurH(
			ActeurActeAssureurH acteurActeAssureurH) {
		log.debug("********** Debut deleteActeurActeAssureurH ActeurActeAssureurHDAO **********");
		try {
			Session session = getSession();
			acteurActeAssureurH.setStatut(STATUT_SUPPRIME);
			session.update(acteurActeAssureurH);
		} catch (Exception e) {
			e.printStackTrace();
			log.fatal(e.getMessage());
		} finally {
			log.debug("********** Fin deleteActeurActeAssureurH ActeurActeAssureurHDAO **********");
		}
	}

	@SuppressWarnings({ "unchecked" })
	public List<ActeurActeAssureurH> listActeurActeAssureurHsActeurActeAssureurHurs() {
		log.debug("********** Debut listActeurActeAssureurHsActeurActeAssureurHurs ActeurActeAssureurHDAO **********");
		try {
			List<ActeurActeAssureurH> acteurActeAssureurHsActeurActeAssureurHurs = null;
			Session session = getSession();
			String strQuery = "select distinct acteurActeAssureurH ";
			strQuery += "from ActeurActeAssureurH acteurActeAssureurH, ActeurActeAssureurHurActeurActeAssureurH acteurActeAssureurHurActeurActeAssureurH ";
			strQuery += "where acteurActeAssureurH.acteurActeAssureurHId = acteurActeAssureurHurActeurActeAssureurH.acteurActeAssureurH.acteurActeAssureurHId ";
			strQuery += "and acteurActeAssureurH.statut = " + STATUT_VALIDE;
			strQuery += " and acteurActeAssureurHurActeurActeAssureurH.statut = "
					+ STATUT_VALIDE;
			strQuery += " order by acteurActeAssureurH.acteurActeAssureurHId asc";
			org.hibernate.Query query = session.createQuery(strQuery);
			acteurActeAssureurHsActeurActeAssureurHurs = query.list();
			return acteurActeAssureurHsActeurActeAssureurHurs;
		} catch (Exception e) {
			e.printStackTrace();
			log.fatal(e.getMessage());
			return null;
		} finally {
			log.debug("********** Fin listActeurActeAssureurHsActeurActeAssureurHurs ActeurActeAssureurHDAO **********");
		}
	}

	@SuppressWarnings({ "unchecked" })
	public List<ActeurActeAssureurH> listActeurActeAssureurHsDetailFactures() {
		log.debug("********** Debut listActeurActeAssureurHsDetailFactures ActeurActeAssureurHDAO **********");
		try {
			List<ActeurActeAssureurH> acteurActeAssureurHsDetailFactures = null;
			Session session = getSession();
			String strQuery = "select distinct acteurActeAssureurH ";
			strQuery += "from ActeurActeAssureurH acteurActeAssureurH, DetailFacture detailFacture ";
			strQuery += "where acteurActeAssureurH.acteurActeAssureurHId = DetailFacture.acteurActeAssureurH.acteurActeAssureurHId ";
			strQuery += "and acteurActeAssureurH.statut = " + STATUT_VALIDE;
			strQuery += " and DetailFacture.statut = " + STATUT_VALIDE;
			strQuery += " order by acteurActeAssureurH.acteurActeAssureurHId asc";
			org.hibernate.Query query = session.createQuery(strQuery);
			acteurActeAssureurHsDetailFactures = query.list();
			return acteurActeAssureurHsDetailFactures;
		} catch (Exception e) {
			e.printStackTrace();
			log.fatal(e.getMessage());
			return null;
		} finally {
			log.debug("********** Fin listActeurActeAssureurHsDetailFactures ActeurActeAssureurHDAO **********");
		}
	}

	@SuppressWarnings({ "unchecked" })
	public List<ActeurActeAssureurH> listActeurActeAssureurHs() {
		log.debug("********** Debut listActeurActeAssureurHs ActeurActeAssureurHDAO **********");
		try {
			List<ActeurActeAssureurH> acteurActeAssureurHs = null;
			Session session = getSession();
			String strQuery = "select distinct acteurActeAssureurH ";
			strQuery += "from ActeurActeAssureurH acteurActeAssureurH ";
			strQuery += "where acteurActeAssureurH.statut = " + STATUT_VALIDE;
			strQuery += " order by acteurActeAssureurH.acteurActeAssureurHId asc";
			org.hibernate.Query query = session.createQuery(strQuery);
			acteurActeAssureurHs = query.list();
			return acteurActeAssureurHs;
		} catch (Exception e) {
			e.printStackTrace();
			log.fatal(e.getMessage());
			return null;
		} finally {
			log.debug("********** Fin listActeurActeAssureurHs ActeurActeAssureurHDAO **********");
		}
	}

	@SuppressWarnings({ "unchecked" })
	public List<ActeurActeAssureurH> listActeurActeAssureurHsSupprimes() {
		log.debug("********** Debut listActeurActeAssureurHsSupprimes ActeurActeAssureurHDAO **********");
		try {
			List<ActeurActeAssureurH> acteurActeAssureurHs = null;
			Session session = getSession();
			String strQuery = "select distinct acteurActeAssureurH ";
			strQuery += "from ActeurActeAssureurH acteurActeAssureurH ";
			strQuery += "where acteurActeAssureurH.statut = " + STATUT_SUPPRIME;
			strQuery += " order by acteurActeAssureurH.acteurActeAssureurHId asc";
			org.hibernate.Query query = session.createQuery(strQuery);
			acteurActeAssureurHs = query.list();
			return acteurActeAssureurHs;
		} catch (Exception e) {
			e.printStackTrace();
			log.fatal(e.getMessage());
			return null;
		} finally {
			log.debug("********** Fin listActeurActeAssureurHsSupprimes ActeurActeAssureurHDAO **********");
		}
	}

	@Override
	protected Class<?> getEntityClass() {
		return ActeurActeAssureurH.class;
	}
}
