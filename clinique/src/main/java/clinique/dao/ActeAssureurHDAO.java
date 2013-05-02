package clinique.dao;

import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import clinique.mapping.Acte;
import clinique.mapping.ActeAssureurH;
import clinique.mapping.Categorie;
import clinique.utils.UtilDate;

@Repository
public class ActeAssureurHDAO extends
		CliniqueHibernateDaoSupport<ActeAssureurH> {

	private static Logger log = Logger.getLogger(ActeAssureurHDAO.class);

	public ActeAssureurH getActeAssureurH(String acteAssureurHId) {
		log.debug("********** Debut getActeAssureurH ActeAssureurHDAO **********");
		try {
			ActeAssureurH acteAssureurH = null;
			Session session = getHibernateSession();
			acteAssureurH = (ActeAssureurH) session.get(ActeAssureurH.class,
					acteAssureurHId);
			return acteAssureurH;
		} catch (Exception e) {
			e.printStackTrace();
			log.fatal(e.getMessage());
			return null;
		} finally {
			log.debug("********** Fin getActeAssureurH ActeAssureurHDAO **********");
		}
	}

	@SuppressWarnings("unchecked")
	public ActeAssureurH getActeAssureurHByDate(Date date1, Acte acte,
			Categorie categorie) {
		log.debug("********** Debut getActeAssureurHByDate ActeAssureurDAO **********");
		try {
			if (date1 != null && acte != null && categorie != null) {
				List<ActeAssureurH> actes = null;
				String dateFacture = UtilDate.getInstance().stringToDateMysql(
						UtilDate.getInstance().dateToString(date1));
				Session session = getHibernateSession();
				String strQuery = "select distinct acteAssureurH ";
				strQuery += " from ActeAssureurH acteAssureurH ";
				strQuery += " where acteAssureurH.acte.acteId = "
						+ acte.getActeId();
				strQuery += " and acteAssureurH.categorie.categorieId = "
						+ categorie.getCategorieId();
				strQuery += " and acteAssureurH.statut = " + STATUT_VALIDE;
				strQuery += " and acteAssureurH.dateDebut <= '" + dateFacture
						+ "'";
				strQuery += " and acteAssureurH.dateFin >= '" + dateFacture
						+ "'";
				// strQuery+=" order by facture.factureId asc";
				// System.out.println(strQuery);
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
			log.debug("********** Fin getActeAssureurHByDate ActeAssureurDAO **********");
		}
	}

	public void deleteActeAssureurH(ActeAssureurH acteAssureurH) {
		acteAssureurH.setStatut(STATUT_SUPPRIME);
		update(acteAssureurH);
	}

	@SuppressWarnings({ "unchecked" })
	public List<ActeAssureurH> listActeAssureurHsActeAssureurHurs() {
		log.debug("********** Debut listActeAssureurHsActeAssureurHurs ActeAssureurHDAO **********");
		try {
			List<ActeAssureurH> acteAssureurHsActeAssureurHurs = null;
			Session session = getHibernateSession();
			String strQuery = "select distinct acteAssureurH ";
			strQuery += "from ActeAssureurH acteAssureurH, ActeAssureurHurActeAssureurH acteAssureurHurActeAssureurH ";
			strQuery += "where acteAssureurH.acteAssureurHId = acteAssureurHurActeAssureurH.acteAssureurH.acteAssureurHId ";
			strQuery += "and acteAssureurH.statut = " + STATUT_VALIDE;
			strQuery += " and acteAssureurHurActeAssureurH.statut = "
					+ STATUT_VALIDE;
			strQuery += " order by acteAssureurH.acteAssureurHId asc";
			org.hibernate.Query query = session.createQuery(strQuery);
			acteAssureurHsActeAssureurHurs = query.list();
			return acteAssureurHsActeAssureurHurs;
		} catch (Exception e) {
			e.printStackTrace();
			log.fatal(e.getMessage());
			return null;
		} finally {
			log.debug("********** Fin listActeAssureurHsActeAssureurHurs ActeAssureurHDAO **********");
		}
	}

	@SuppressWarnings({ "unchecked" })
	public List<ActeAssureurH> listActeAssureurHsDetailFactures() {
		log.debug("********** Debut listActeAssureurHsDetailFactures ActeAssureurHDAO **********");
		try {
			List<ActeAssureurH> acteAssureurHsDetailFactures = null;
			Session session = getHibernateSession();
			String strQuery = "select distinct acteAssureurH ";
			strQuery += "from ActeAssureurH acteAssureurH, DetailFacture detailFacture ";
			strQuery += "where acteAssureurH.acteAssureurHId = DetailFacture.acteAssureurH.acteAssureurHId ";
			strQuery += "and acteAssureurH.statut = " + STATUT_VALIDE;
			strQuery += " and DetailFacture.statut = " + STATUT_VALIDE;
			strQuery += " order by acteAssureurH.acteAssureurHId asc";
			org.hibernate.Query query = session.createQuery(strQuery);
			acteAssureurHsDetailFactures = query.list();
			return acteAssureurHsDetailFactures;
		} catch (Exception e) {
			e.printStackTrace();
			log.fatal(e.getMessage());
			return null;
		} finally {
			log.debug("********** Fin listActeAssureurHsDetailFactures ActeAssureurHDAO **********");
		}
	}

	@SuppressWarnings({ "unchecked" })
	public List<ActeAssureurH> listActeAssureurHs() {
		log.debug("********** Debut listActeAssureurHs ActeAssureurHDAO **********");
		try {
			List<ActeAssureurH> acteAssureurHs = null;
			Session session = getHibernateSession();
			String strQuery = "select distinct acteAssureurH ";
			strQuery += "from ActeAssureurH acteAssureurH ";
			strQuery += "where acteAssureurH.statut = " + STATUT_VALIDE;
			strQuery += " order by acteAssureurH.acteAssureurHId asc";
			org.hibernate.Query query = session.createQuery(strQuery);
			acteAssureurHs = query.list();
			return acteAssureurHs;
		} catch (Exception e) {
			e.printStackTrace();
			log.fatal(e.getMessage());
			return null;
		} finally {
			log.debug("********** Fin listActeAssureurHs ActeAssureurHDAO **********");
		}
	}

	@SuppressWarnings({ "unchecked" })
	public List<ActeAssureurH> listActeAssureurHsSupprimes() {
		log.debug("********** Debut listActeAssureurHsSupprimes ActeAssureurHDAO **********");
		try {
			List<ActeAssureurH> acteAssureurHs = null;
			Session session = getHibernateSession();
			String strQuery = "select distinct acteAssureurH ";
			strQuery += "from ActeAssureurH acteAssureurH ";
			strQuery += "where acteAssureurH.statut = " + STATUT_SUPPRIME;
			strQuery += " order by acteAssureurH.acteAssureurHId asc";
			org.hibernate.Query query = session.createQuery(strQuery);
			acteAssureurHs = query.list();
			return acteAssureurHs;
		} catch (Exception e) {
			e.printStackTrace();
			log.fatal(e.getMessage());
			return null;
		} finally {
			log.debug("********** Fin listActeAssureurHsSupprimes ActeAssureurHDAO **********");
		}
	}

	private Session getHibernateSession() {
		return getSession();
	}

	@Override
	protected Class<?> getEntityClass() {
		return ActeAssureurH.class;
	}
}
