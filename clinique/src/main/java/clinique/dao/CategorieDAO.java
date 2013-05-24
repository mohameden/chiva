package clinique.dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import clinique.mapping.Categorie;
import clinique.mapping.Entreprise;

@Repository
public class CategorieDAO extends CliniqueHibernateDaoSupport<Categorie> {

	private static Logger log = Logger.getLogger(CategorieDAO.class);

	public Categorie getCategorie(int categorieId) {
		log.debug("********** Debut getCategorie CategorieDAO **********");
		try {
			Categorie categorie = null;
			Session session = getSession();
			categorie = (Categorie) session.get(Categorie.class, categorieId);
			return categorie;
		} catch (Exception e) {
			e.printStackTrace();
			log.fatal(e.getMessage());
			return null;
		} finally {
			log.debug("********** Fin getCategorie CategorieDAO **********");
		}
	}

	public void saveCategorie(Categorie categorie) {
		log.debug("********** Debut saveCategorie CategorieDAO **********");
		try {
			Session session = getSession();
			categorie.setStatut(STATUT_VALIDE);
			session.save(categorie);
		} catch (Exception e) {
			e.printStackTrace();
			log.fatal(e.getMessage());
		} finally {
			log.debug("********** Fin saveCategorie CategorieDAO **********");
		}
	}

	public void updateCategorie(Categorie categorie) {
		log.debug("********** Debut updateCategorie CategorieDAO **********");
		try {
			Session session = getSession();
			session.update(categorie);
		} catch (Exception e) {
			e.printStackTrace();
			log.fatal(e.getMessage());
		} finally {
			log.debug("********** Fin updateCategorie CategorieDAO **********");
		}
	}

	public void deleteCategorie(Categorie categorie) {
		log.debug("********** Debut deleteCategorie CategorieDAO **********");
		try {
			Session session = getSession();
			categorie.setStatut(STATUT_SUPPRIME);
			session.update(categorie);
		} catch (Exception e) {
			e.printStackTrace();
			log.fatal(e.getMessage());
		} finally {
			log.debug("********** Fin deleteCategorie CategorieDAO **********");
		}
	}

	@SuppressWarnings("unchecked")
	public List<Categorie> listCategories() {
		log.debug("********** Debut listCategories CategorieDAO **********");
		try {
			List<Categorie> categories = null;
			Session session = getSession();
			String strQuery = "select distinct categorie ";
			strQuery += "from Categorie categorie ";
			strQuery += "and categorie.statut = " + STATUT_VALIDE;
			strQuery += " order by categorie.categorieId asc";
			org.hibernate.Query query = session.createQuery(strQuery);
			categories = query.list();
			return categories;
		} catch (Exception e) {
			e.printStackTrace();
			log.fatal(e.getMessage());
			return null;
		} finally {
			log.debug("********** Fin listCategories CategorieDAO **********");
		}
	}

	@SuppressWarnings({ "unchecked" })
	public List<Categorie> listCategoriesSupprimees() {
		log.debug("********** Debut listCategoriesSupprimees CategorieDAO **********");
		try {
			List<Categorie> categories = null;
			Session session = getSession();
			String strQuery = "select distinct categorie ";
			strQuery += "from Categorie categorie ";
			strQuery += "and categorie.statut = " + STATUT_SUPPRIME;
			strQuery += " order by categorie.categorieId asc";
			org.hibernate.Query query = session.createQuery(strQuery);
			categories = query.list();
			return categories;
		} catch (Exception e) {
			e.printStackTrace();
			log.fatal(e.getMessage());
			return null;
		} finally {
			log.debug("********** Fin listCategoriesSupprimees CategorieDAO **********");
		}
	}

	@SuppressWarnings("unchecked")
	public List<Categorie> findCategoriesByEntreprise(
			final Entreprise entreprise) {
		String queryString = "from Categorie where entreprise = :entreprise";
		Session session = getSession();
		Query query = session.createQuery(queryString);
		query.setParameter("entreprise", entreprise);
		return query.list();
	}

	@Override
	protected Class<?> getEntityClass() {
		return Categorie.class;
	}
}
