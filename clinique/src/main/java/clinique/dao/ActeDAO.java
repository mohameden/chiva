package clinique.dao;

import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import clinique.mapping.Acte;
import clinique.utils.UtilDate;

@Repository
public class ActeDAO extends CliniqueHibernateDaoSupport<Acte> {

	private static Logger log = Logger.getLogger(ActeDAO.class);

	public Acte getActe(int acteId) {
		return findById(acteId);
	}

	public void saveActe(Acte acte) {
		acte.setStatut(STATUT_VALIDE);
		save(acte);
	}

	public void updateActe(Acte acte) {
		update(acte);
	}

	public void deleteActe(Acte acte) {
		acte.setStatut(STATUT_SUPPRIME);
		update(acte);
	}

	@SuppressWarnings({ "unchecked" })
	public List<Acte> listActesActeurs() {
		log.debug("********** Debut listActesActeurs ActeDAO **********");
		try {
			List<Acte> actesActeurs = null;
			Session session = getSession();
			String strQuery = "select distinct acte ";
			strQuery += "from Acte acte, ActeurActe acteurActe ";
			strQuery += "where acte.acteId = acteurActe.acte.acteId ";
			strQuery += "and acte.statut = " + STATUT_VALIDE;
			strQuery += " and acteurActe.statut = " + STATUT_VALIDE;
			strQuery += " order by acte.acteId asc";
			org.hibernate.Query query = session.createQuery(strQuery);
			actesActeurs = query.list();
			return actesActeurs;
		} catch (Exception e) {
			e.printStackTrace();
			log.fatal(e.getMessage());
			return null;
		} finally {
			log.debug("********** Fin listActesActeurs ActeDAO **********");
		}
	}

	@SuppressWarnings({ "unchecked" })
	public List<Acte> listActesDetailFactures() {
		log.debug("********** Debut listActesDetailFactures ActeDAO **********");
		try {
			List<Acte> actesDetailFactures = null;
			Session session = getSession();
			String strQuery = "select distinct acte ";
			strQuery += "from Acte acte, DetailFacture detailFacture ";
			strQuery += "where acte.acteId = DetailFacture.acte.acteId ";
			strQuery += "and acte.statut = " + STATUT_VALIDE;
			strQuery += " and DetailFacture.statut = " + STATUT_VALIDE;
			strQuery += " order by acte.acteId asc";
			org.hibernate.Query query = session.createQuery(strQuery);
			actesDetailFactures = query.list();
			return actesDetailFactures;
		} catch (Exception e) {
			e.printStackTrace();
			log.fatal(e.getMessage());
			return null;
		} finally {
			log.debug("********** Fin listActesDetailFactures ActeDAO **********");
		}
	}

	@SuppressWarnings({ "unchecked" })
	public List<Acte> listActes() {
		log.debug("********** Debut listActes ActeDAO **********");
		try {
			List<Acte> actes = null;
			Session session = getSession();
			String strQuery = "select distinct acte ";
			strQuery += "from Acte acte ";
			strQuery += "where acte.statut = " + STATUT_VALIDE;
			strQuery += " order by acte.acteId asc";
			org.hibernate.Query query = session.createQuery(strQuery);
			actes = query.list();
			return actes;
		} catch (Exception e) {
			e.printStackTrace();
			log.fatal(e.getMessage());
			return null;
		} finally {
			log.debug("********** Fin listActes ActeDAO **********");
		}
	}

	@SuppressWarnings({ "unchecked" })
	public List<Acte> listActesSupprimes() {
		log.debug("********** Debut listActesSupprimes ActeDAO **********");
		try {
			List<Acte> actes = null;
			Session session = getSession();
			String strQuery = "select distinct acte ";
			strQuery += "from Acte acte ";
			strQuery += "where acte.statut = " + STATUT_SUPPRIME;
			strQuery += " order by acte.acteId asc";
			org.hibernate.Query query = session.createQuery(strQuery);
			actes = query.list();
			return actes;
		} catch (Exception e) {
			e.printStackTrace();
			log.fatal(e.getMessage());
			return null;
		} finally {
			log.debug("********** Fin listActesSupprimes ActeDAO **********");
		}
	}

	@SuppressWarnings("unchecked")
	public Acte getActeByDate(Date date1, Acte acte) {
		log.debug("********** Debut getActeByDate ActeDAO **********");
		try {
			if (date1 != null && acte != null) {
				List<Acte> actes = null;
				String dateFacture = UtilDate.getInstance().stringToDateMysql(
						UtilDate.getInstance().dateToString(date1));
				Session session = getSession();
				String strQuery = "select distinct acte ";
				strQuery += "from Acte acte ";
				strQuery += " where acte.acteId = " + acte.getActeId();
				strQuery += " and acte.statut = " + STATUT_VALIDE;
				strQuery += " and acte.dateDebut <= '" + dateFacture + "'";
				strQuery += " and acte.dateFin >= '" + dateFacture + "'";
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
			log.debug("********** Fin getActeByDate ActeDAO **********");
		}
	}

	@Override
	protected Class<?> getEntityClass() {
		return Acte.class;
	}
}
