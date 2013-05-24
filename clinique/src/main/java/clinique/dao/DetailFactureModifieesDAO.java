package clinique.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import clinique.mapping.DetailFactureModifiees;
import clinique.mapping.FactureModifiees;

@Repository
public class DetailFactureModifieesDAO extends
		CliniqueHibernateDaoSupport<DetailFactureModifiees> {
	@Override
	protected Class<?> getEntityClass() {
		return DetailFactureModifiees.class;
	}

	@SuppressWarnings("unchecked")
	public List<DetailFactureModifiees> findDetailFactureModifieesByFacture(
			final FactureModifiees facture) {
		String queryString = "from DetailFactureModifiees where facture = :facture";
		Session session = getSession();
		Query query = session.createQuery(queryString);
		query.setParameter("facture", facture);
		return query.list();
	}

}
