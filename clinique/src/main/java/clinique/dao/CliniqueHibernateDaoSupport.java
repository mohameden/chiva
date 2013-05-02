package clinique.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.metadata.ClassMetadata;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import clinique.mapping.Entity;
import clinique.utils.ConstantesMetier;

public abstract class CliniqueHibernateDaoSupport<T extends Entity> extends
		HibernateDaoSupport implements ConstantesMetier {
	@Autowired
	public void init(SessionFactory factory) {
		setSessionFactory(factory);
	}

	public T findById(final int id) {
		return getHibernateTemplate().execute(new HibernateCallback<T>() {

			@SuppressWarnings("unchecked")
			@Override
			public T doInHibernate(Session session) throws HibernateException,
					SQLException {
				StringBuilder sb = new StringBuilder();
				sb.append("from ");
				sb.append(getEntityClass().getName());
				sb.append(" where id=");
				sb.append(id);
				Query query = session.createQuery(sb.toString());

				return (T) query.uniqueResult();
			}
		});
	}

	public void refresh(T t) {
		getHibernateTemplate().refresh(t);
	}

	public void merge(T t) {
		getHibernateTemplate().merge(t);
	}

	public void evict(T t) {
		getHibernateTemplate().evict(t);
	}

	@SuppressWarnings("unchecked")
	public T load(int id) {
		return (T) getHibernateTemplate().load(getEntityClass(), id);
	}

	@SuppressWarnings("unchecked")
	public List<T> findByIds(Collection<Integer> idList) {
		ClassMetadata cmd = getHibernateTemplate().getSessionFactory()
				.getClassMetadata(getEntityClass());
		String idProp = cmd.getIdentifierPropertyName();

		if (idList.size() > 0) {
			Criteria criteria = getHibernateTemplate().getSessionFactory()
					.getCurrentSession().createCriteria(getEntityClass());
			criteria.add(Restrictions.in(idProp, idList));

			return criteria.list();
		} else {
			return new ArrayList<T>();
		}
	}

	public void update(T t) {
		getHibernateTemplate().update(t);
	}

	public void save(T t) {
		getHibernateTemplate().saveOrUpdate(t);
	}

	public void saveAll(Collection<T> list) {
		if (list != null && !list.isEmpty()) {
			getHibernateTemplate().saveOrUpdateAll(list);
		}
	}

	public void delete(T t) {
		getHibernateTemplate().delete(t);
	}

	@SuppressWarnings("unchecked")
	public List<T> findAll() {
		StringBuilder sb = new StringBuilder();
		sb.append("from ");
		sb.append(getEntityClass().getName());
		sb.append(" x");
		return getHibernateTemplate().find(sb.toString());
	}

	public List<T> findAllOrderById() {
		ClassMetadata cmd = getHibernateTemplate().getSessionFactory()
				.getClassMetadata(getEntityClass());
		String idProp = cmd.getIdentifierPropertyName();

		return findAllOrderByProp(idProp, true);
	}

	@SuppressWarnings("unchecked")
	public List<T> findAllOrderByProp(String propertyName, Boolean asc) {

		Criteria criteria = getHibernateTemplate().getSessionFactory()
				.getCurrentSession().createCriteria(getEntityClass());
		if (asc) {
			criteria.addOrder(Order.asc(propertyName));
		} else {
			criteria.addOrder(Order.desc(propertyName));
		}

		return criteria.list();
	}

	public void deleteById(int id) {
		Object obj = load(id);
		getHibernateTemplate().delete(obj);
	}

	public int deleteByIds(Collection<Integer> ids) {
		int count = 0;

		if (ids != null && ids.isEmpty()) {

			ClassMetadata cmd = getHibernateTemplate().getSessionFactory()
					.getClassMetadata(getEntityClass());
			String idProp = cmd.getIdentifierPropertyName();

			StringBuilder sb = new StringBuilder();
			sb.append("delete ");
			sb.append(getEntityClass().getName());
			sb.append(" x where x.");
			sb.append(idProp);
			sb.append(" in ( :ids )");
			String hqlDelete = sb.toString();

			Query deleteQuery = getHibernateTemplate().getSessionFactory()
					.getCurrentSession().createQuery(hqlDelete);
			deleteQuery.setParameterList("ids", ids);

			count = deleteQuery.executeUpdate();

		}
		return count;
	}

	public void deleteAll(Collection<T> objects) {
		if (objects != null && objects.isEmpty()) {
			getHibernateTemplate().deleteAll(objects);
		}
	}

	public int deleteAll() {

		String hqlDelete = "delete " + getEntityClass().getName();
		Query deleteQuery = getHibernateTemplate().getSessionFactory()
				.getCurrentSession().createQuery(hqlDelete);

		int count = deleteQuery.executeUpdate();
		return count;
	}

	public int count() {
		ClassMetadata cmd = getHibernateTemplate().getSessionFactory()
				.getClassMetadata(getEntityClass());
		String idProp = cmd.getIdentifierPropertyName();

		Criteria criteria = getHibernateTemplate().getSessionFactory()
				.getCurrentSession().createCriteria(getEntityClass());
		criteria.setProjection(Projections.countDistinct(idProp));
		Object countValue = criteria.uniqueResult();

		return Integer.parseInt(countValue.toString());
	}

	public void create(T o) {
		getHibernateTemplate().save(o);
	}

	protected abstract Class<?> getEntityClass();

}
