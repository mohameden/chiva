import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTransactionalTestNGSpringContextTests;
import org.springframework.test.context.transaction.TransactionConfiguration;

@ContextConfiguration(locations = { "classpath*:ApplicationContext-test.xml" })
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = true)
public abstract class AbstractCliniqueTestNGSpringContextTests extends
		AbstractTransactionalTestNGSpringContextTests {
	@Autowired
	protected SessionFactory sessionFactory;

	protected void flush() {
		sessionFactory.getCurrentSession().flush();
	}
}
