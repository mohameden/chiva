package clinique.dao;

import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import clinique.mapping.Acte;
import clinique.mapping.ActeAssureur;
import clinique.mapping.Categorie;
import clinique.utils.UtilDate;

@Repository
public class ActeAssureurDAO extends CliniqueHibernateDaoSupport<ActeAssureur> {

	public ActeAssureur getActeAssureur(String acteAssureurId) {
		ActeAssureur acteAssureur = null;
		Session session = getHibernateSession();
		acteAssureur = (ActeAssureur) session.get(ActeAssureur.class,
				acteAssureurId);
		return acteAssureur;
	}

	private Session getHibernateSession() {
		return getSession();
	}

	@SuppressWarnings("unchecked")
	public ActeAssureur getActeAssureurByDate(Date date1, Acte acte,
			Categorie categorie) {
		if (date1 != null && acte != null && categorie != null) {
			List<ActeAssureur> actes = null;
			String dateFacture = UtilDate.getInstance().stringToDateMysql(
					UtilDate.getInstance().dateToString(date1));
			Session session = getHibernateSession();
			String strQuery = "select distinct acteAssureur ";
			strQuery += " from ActeAssureur acteAssureur ";
			strQuery += "where acteAssureur.acte.acteId = " + acte.getActeId();
			strQuery += " and acteAssureur.categorie.categorieId = "
					+ categorie.getCategorieId();
			strQuery += " and acteAssureur.statut = " + STATUT_VALIDE;
			strQuery += " and acteAssureur.dateDebut <= '" + dateFacture + "'";
			strQuery += " and acteAssureur.dateFin >= '" + dateFacture + "'";
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

	}

	public void saveActeAssureur(ActeAssureur acteAssureur) {
		acteAssureur.setStatut(STATUT_VALIDE);
		save(acteAssureur);
	}

	public void deleteActeAssureur(ActeAssureur acteAssureur) {
		acteAssureur.setStatut(STATUT_SUPPRIME);
		update(acteAssureur);
	}

	@SuppressWarnings({ "unchecked" })
	public List<ActeAssureur> listActeAssureursActeAssureururs() {
		List<ActeAssureur> acteAssureursActeAssureururs = null;
		Session session = getHibernateSession();
		String strQuery = "select distinct acteAssureur ";
		strQuery += "from ActeAssureur acteAssureur, ActeAssureururActeAssureur acteAssureururActeAssureur ";
		strQuery += "where acteAssureur.acteAssureurId = acteAssureururActeAssureur.acteAssureur.acteAssureurId ";
		strQuery += "and acteAssureur.statut = " + STATUT_VALIDE;
		strQuery += " and acteAssureururActeAssureur.statut = " + STATUT_VALIDE;
		strQuery += " order by acteAssureur.acteAssureurId asc";
		org.hibernate.Query query = session.createQuery(strQuery);
		acteAssureursActeAssureururs = query.list();
		return acteAssureursActeAssureururs;
	}

	@SuppressWarnings({ "unchecked" })
	public List<ActeAssureur> listActeAssureursDetailFactures() {
		List<ActeAssureur> acteAssureursDetailFactures = null;
		Session session = getHibernateSession();
		String strQuery = "select distinct acteAssureur ";
		strQuery += "from ActeAssureur acteAssureur, DetailFacture detailFacture ";
		strQuery += "where acteAssureur.acteAssureurId = DetailFacture.acteAssureur.acteAssureurId ";
		strQuery += "and acteAssureur.statut = " + STATUT_VALIDE;
		strQuery += " and DetailFacture.statut = " + STATUT_VALIDE;
		strQuery += " order by acteAssureur.acteAssureurId asc";
		org.hibernate.Query query = session.createQuery(strQuery);
		acteAssureursDetailFactures = query.list();
		return acteAssureursDetailFactures;
	}

	@SuppressWarnings({ "unchecked" })
	public List<ActeAssureur> listActeAssureurs() {
		List<ActeAssureur> acteAssureurs = null;
		Session session = getHibernateSession();
		String strQuery = "select distinct acteAssureur ";
		strQuery += "from ActeAssureur acteAssureur ";
		strQuery += "where acteAssureur.statut = " + STATUT_VALIDE;
		strQuery += " order by acteAssureur.acteAssureurId asc";
		org.hibernate.Query query = session.createQuery(strQuery);
		acteAssureurs = query.list();
		return acteAssureurs;
	}

	@SuppressWarnings({ "unchecked" })
	public List<ActeAssureur> listActeAssureursSupprimes() {
		List<ActeAssureur> acteAssureurs = null;
		Session session = getHibernateSession();
		String strQuery = "select distinct acteAssureur ";
		strQuery += "from ActeAssureur acteAssureur ";
		strQuery += "where acteAssureur.statut = " + STATUT_SUPPRIME;
		strQuery += " order by acteAssureur.acteAssureurId asc";
		org.hibernate.Query query = session.createQuery(strQuery);
		acteAssureurs = query.list();
		return acteAssureurs;
	}

	@Override
	protected Class<?> getEntityClass() {
		return ActeAssureur.class;
	}
}
