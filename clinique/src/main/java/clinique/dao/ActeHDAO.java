package clinique.dao;

import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import clinique.mapping.Acte;
import clinique.mapping.ActeH;
import clinique.utils.UtilDate;

@Repository
public class ActeHDAO extends CliniqueHibernateDaoSupport<ActeH> {

	private static Logger log = Logger.getLogger(ActeHDAO.class);

	@SuppressWarnings("unchecked")
	public ActeH getActeHByDate(String acteAssureurHId, Date date1, Acte acte) {
		log.debug("********** Debut getActeHByDate ActeAssureurDAO **********");
		try {
			List<ActeH> actes = null;
			String dateFacture = UtilDate.getInstance().stringToDateMysql(
					UtilDate.getInstance().dateToString(date1));
			Session session = getSession();
			String strQuery = "select distinct acteH ";
			strQuery += "from ActeH acteH ";
			strQuery += "where acteH.acte.actId = " + acte.getActeId();
			strQuery += " and acteH.statut = " + STATUT_VALIDE;
			strQuery += " and acteH.dateDebut <= '" + dateFacture + "'";
			strQuery += " and acteH.dateFin >= '" + dateFacture + "'";
			// strQuery+=" order by facture.factureId asc";
			// System.out.println(strQuery);
			org.hibernate.Query query = session.createQuery(strQuery);
			actes = query.list();
			if (actes.size() == 0) {
				return null;
			} else {
				return actes.get(0);
			}

		} catch (Exception e) {
			e.printStackTrace();
			log.fatal(e.getMessage());
			return null;
		} finally {
			log.debug("********** Fin getActeHByDate ActeAssureurDAO **********");
		}
	}

	public void saveActeH(ActeH acteH) {
		acteH.setStatut(STATUT_VALIDE);
		save(acteH);
	}

	public void deleteActeH(ActeH acteH) {
		acteH.setStatut(STATUT_SUPPRIME);
		update(acteH);
	}

	@SuppressWarnings({ "unchecked" })
	public List<ActeH> listActeHsActeHurs() {
		log.debug("********** Debut listActeHsActeHurs ActeHDAO **********");
		try {
			List<ActeH> acteHsActeHurs = null;
			Session session = getSession();
			String strQuery = "select distinct acteH ";
			strQuery += "from ActeH acteH, ActeHurActeH acteHurActeH ";
			strQuery += "where acteH.acteHId = acteHurActeH.acteH.acteHId ";
			strQuery += "and acteH.statut = " + STATUT_VALIDE;
			strQuery += " and acteHurActeH.statut = " + STATUT_VALIDE;
			strQuery += " order by acteH.acteHId asc";
			org.hibernate.Query query = session.createQuery(strQuery);
			acteHsActeHurs = query.list();
			return acteHsActeHurs;
		} catch (Exception e) {
			e.printStackTrace();
			log.fatal(e.getMessage());
			return null;
		} finally {
			log.debug("********** Fin listActeHsActeHurs ActeHDAO **********");
		}
	}

	@SuppressWarnings({ "unchecked" })
	public List<ActeH> listActeHsDetailFactures() {
		log.debug("********** Debut listActeHsDetailFactures ActeHDAO **********");
		try {
			List<ActeH> acteHsDetailFactures = null;
			Session session = getSession();
			String strQuery = "select distinct acteH ";
			strQuery += "from ActeH acteH, DetailFacture detailFacture ";
			strQuery += "where acteH.acteHId = DetailFacture.acteH.acteHId ";
			strQuery += "and acteH.statut = " + STATUT_VALIDE;
			strQuery += " and DetailFacture.statut = " + STATUT_VALIDE;
			strQuery += " order by acteH.acteHId asc";
			org.hibernate.Query query = session.createQuery(strQuery);
			acteHsDetailFactures = query.list();
			return acteHsDetailFactures;
		} catch (Exception e) {
			e.printStackTrace();
			log.fatal(e.getMessage());
			return null;
		} finally {
			log.debug("********** Fin listActeHsDetailFactures ActeHDAO **********");
		}
	}

	@SuppressWarnings({ "unchecked" })
	public List<ActeH> listActeHs() {
		log.debug("********** Debut listActeHs ActeHDAO **********");
		try {
			List<ActeH> acteHs = null;
			Session session = getSession();
			String strQuery = "select distinct acteH ";
			strQuery += "from ActeH acteH ";
			strQuery += "where acteH.statut = " + STATUT_VALIDE;
			strQuery += " order by acteH.acteHId asc";
			org.hibernate.Query query = session.createQuery(strQuery);
			acteHs = query.list();
			return acteHs;
		} catch (Exception e) {
			e.printStackTrace();
			log.fatal(e.getMessage());
			return null;
		} finally {
			log.debug("********** Fin listActeHs ActeHDAO **********");
		}
	}

	@SuppressWarnings({ "unchecked" })
	public List<ActeH> listActeHsSupprimes() {
		log.debug("********** Debut listActeHsSupprimes ActeHDAO **********");
		try {
			List<ActeH> acteHs = null;
			Session session = getSession();
			String strQuery = "select distinct acteH ";
			strQuery += "from ActeH acteH ";
			strQuery += "where acteH.statut = " + STATUT_SUPPRIME;
			strQuery += " order by acteH.acteHId asc";
			org.hibernate.Query query = session.createQuery(strQuery);
			acteHs = query.list();
			return acteHs;
		} catch (Exception e) {
			e.printStackTrace();
			log.fatal(e.getMessage());
			return null;
		} finally {
			log.debug("********** Fin listActeHsSupprimes ActeHDAO **********");
		}
	}

	@SuppressWarnings("unchecked")
	public ActeH getActeHByDate(Date date1, Acte acte) {
		log.debug("********** Debut getActeHByDate ActeDAO **********");
		try {
			if (date1 != null && acte != null) {
				List<ActeH> actes = null;
				String dateFacture = UtilDate.getInstance().stringToDateMysql(
						UtilDate.getInstance().dateToString(date1));
				Session session = getSession();
				String strQuery = "select distinct acteH ";
				strQuery += "from ActeH acteH ";
				strQuery += " where acteH.acte.acteId = " + acte.getActeId();
				strQuery += " and acteH.statut = " + STATUT_VALIDE;
				strQuery += " and acteH.dateDebut <= '" + dateFacture + "'";
				strQuery += " and acteH.dateFin >= '" + dateFacture + "'";
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
			log.debug("********** Fin getActeHByDate ActeDAO **********");
		}
	}

	@Override
	protected Class<?> getEntityClass() {
		return ActeH.class;
	}
}
