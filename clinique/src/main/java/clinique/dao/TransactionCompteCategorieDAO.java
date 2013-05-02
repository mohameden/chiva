package clinique.dao;

import org.springframework.stereotype.Repository;

import clinique.mapping.TransactionCompteCategorie;

@Repository
public class TransactionCompteCategorieDAO extends
		CliniqueHibernateDaoSupport<TransactionCompteCategorie> {

	@Override
	protected Class<?> getEntityClass() {
		return TransactionCompteCategorie.class;
	}
}
