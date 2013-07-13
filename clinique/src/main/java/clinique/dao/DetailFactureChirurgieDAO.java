package clinique.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import clinique.mapping.DetailFactureChirurgie;
import clinique.mapping.Facture;
import clinique.mapping.HasDetailFactureInfo;

@Repository
public class DetailFactureChirurgieDAO extends
		CliniqueHibernateDaoSupport<DetailFactureChirurgie> {

	@SuppressWarnings("unchecked")
	public List<DetailFactureChirurgie> findDetailFactureChirurgieByFacture(final Facture facture) {
		String queryString = "from DetailFactureChirurgie d where d.facture = :fac";
		Session session = getSession();
		Query query = session.createQuery(queryString);
		query.setEntity("fac", facture);
		return query.list();
	}
	@SuppressWarnings("unchecked")
	public List<DetailFactureChirurgie> findDetailFactureChirurgieByDetailFacture(final HasDetailFactureInfo detail) {
		String queryString = "from DetailFactureChirurgie d where d.detailFacture = :dfac";
		Session session = getSession();
		Query query = session.createQuery(queryString);
		query.setEntity("dfac", detail);
		return query.list();
	}

	@Override
	protected Class<?> getEntityClass() {
		return DetailFactureChirurgie.class;
	}
}
