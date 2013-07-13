package clinique.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import clinique.mapping.DetailFactureServices;
import clinique.mapping.Facture;
import clinique.mapping.HasDetailFactureInfo;
import clinique.mapping.Recu;

@Repository
public class DetailFactureServicesDAO extends
		CliniqueHibernateDaoSupport<DetailFactureServices> {

	@SuppressWarnings("unchecked")
	public List<DetailFactureServices> findDetailFactureServicesByFacture(final Facture facture) {
		String queryString = "from DetailFactureServices d where d.facture = :fac";
		Session session = getSession();
		Query query = session.createQuery(queryString);
		query.setEntity("fac", facture);
		return query.list();
	}
	@SuppressWarnings("unchecked")
	public List<DetailFactureServices> findDetailFactureServicesByRecu(final Recu recu) {
		String queryString = "from DetailFactureServices d where d.recu = :recu";
		Session session = getSession();
		Query query = session.createQuery(queryString);
		query.setEntity("recu", recu);
		return query.list();
	}
	@SuppressWarnings("unchecked")
	public List<DetailFactureServices> findDetailFactureServicesByDetailFacture(final HasDetailFactureInfo detail) {
		String queryString = "from DetailFactureServices d where d.detailFacture = :dfac";
		Session session = getSession();
		Query query = session.createQuery(queryString);
		query.setEntity("dfac", detail);
		return query.list();
	}

	@Override
	protected Class<?> getEntityClass() {
		return DetailFactureServices.class;
	}
}
