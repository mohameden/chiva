package clinique.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import clinique.mapping.DevisActes;
import clinique.mapping.DevisAssureur;

@Repository
public class DevisActesDAO extends CliniqueHibernateDaoSupport<DevisActes> {

	@Override
	protected Class<?> getEntityClass() {
		return DevisActes.class;
	}

	@SuppressWarnings("unchecked")
	public List<DevisActes> findDevisActesByDevisAssureur(
			final DevisAssureur devisAssureur) {
		String queryString = "from DevisActes where devisAssureur = :devisAssureur";
		Session session = getSession();
		Query query = session.createQuery(queryString);
		query.setParameter("devisAssureur", devisAssureur);
		return query.list();
	}

}
