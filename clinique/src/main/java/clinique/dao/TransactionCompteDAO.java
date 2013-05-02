package clinique.dao;

import org.springframework.stereotype.Repository;

import clinique.mapping.TransactionCompte;

@Repository
public class TransactionCompteDAO extends
		CliniqueHibernateDaoSupport<TransactionCompte> {

	@Override
	protected Class<?> getEntityClass() {
		return TransactionCompte.class;
	}
}
