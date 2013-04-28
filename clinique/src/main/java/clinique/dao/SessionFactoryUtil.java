package clinique.dao;

import java.sql.Connection;
import java.sql.SQLException;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.cfg.Configuration;

/**
 * Configures and provides access to Hibernate sessions, tied to the
 * current thread of execution.  Follows the Thread Local Session
 * pattern, see {@link http://hibernate.org/42.html}.
 */
public class SessionFactoryUtil {

	private static Logger log = Logger.getLogger(SessionFactoryUtil.class);
    /**
     * Location of hibernate.cfg.xml file.
     * NOTICE: Location should be on the classpath as Hibernate uses
     * #resourceAsStream style lookup for its configuration file. That
     * is place the config file in a Java package - the default location
     * is the default Java package.<br><br>
     * Examples: <br>
     * <code>CONFIG_FILE_LOCATION = "/hibernate.conf.xml".
     * CONFIG_FILE_LOCATION = "/com/foo/bar/myhiberstuff.conf.xml".</code>
     */
    /** Holds a single instance of Session */
	private static final ThreadLocal<Session> threadLocal = new ThreadLocal<Session>();

    /** The single instance of hibernate configuration */
    private static Configuration cfg = null;

    /** The single instance of hibernate SessionFactory */
    private static org.hibernate.SessionFactory sessionFactory;

    private static SessionFactoryUtil instance = new SessionFactoryUtil();
    public static SessionFactoryUtil getInstance ()
    {
    	return instance;
    }

    /**
     * Returns the ThreadLocal Session instance.  Lazy initialize
     * the <code>SessionFactory</code> if needed.
     *
     *  @return Session
     *  @throws HibernateException
     */
    public Session getCurrentSession() throws HibernateException {
        Session session = (Session) threadLocal.get();

		if (session == null || !session.isOpen()) {
			if (sessionFactory == null) {
				try {
					if (cfg == null)
					{
						cfg = new Configuration();
						cfg = cfg.configure();
					}
					sessionFactory = cfg.buildSessionFactory();
				} catch (Exception e) {
					System.err
							.println("%%%% Error Creating SessionFactory %%%%");
					e.printStackTrace();
				}
			}
			session = (sessionFactory != null) ? sessionFactory.openSession()
					: null;
			threadLocal.set(session);
		}
        return session;
    }
    public Session openSession() throws HibernateException {
    	return getCurrentSession();
    }

    /**
     *  Close the single hibernate session instance.
     *
     *  @throws HibernateException
     */
    public void close() throws Exception {
        Session session = (Session) threadLocal.get();
        threadLocal.set(null);

        if (session != null && session.isOpen()) {
        	try {
				Connection con = session.close();
				if (con != null && !con.isClosed())
				{
					con.close();
				}
			} catch (HibernateException e) {
				log.fatal(e.getMessage());
			} catch (SQLException e) {
				log.fatal(e.getMessage());
			}
        }
    }

    /**
     * Default constructor.
     */
    private SessionFactoryUtil() {
    }

}
