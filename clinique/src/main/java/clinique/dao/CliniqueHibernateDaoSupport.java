package clinique.dao;

import java.sql.SQLException;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
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
				sb.append(getHandledCalss().getName());
				sb.append(" where id=");
				sb.append(id);
				Query query = session.createQuery(sb.toString());

				return (T) query.uniqueResult();
			}
		});
	}

	public void create(T o) {
		getHibernateTemplate().save(o);
	}

	protected abstract Class<?> getHandledCalss();

}
