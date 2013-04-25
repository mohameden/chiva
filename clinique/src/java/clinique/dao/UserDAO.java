package clinique.dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Session;

import clinique.mapping.User;
import clinique.utils.ConstantesMetier;

public class UserDAO implements ConstantesMetier {
	
	private static Logger log = Logger.getLogger(UserDAO.class);
	private static final UserDAO INSTANCE = new UserDAO();

	public static UserDAO getInstance() {
		  return INSTANCE;
		 }

	private UserDAO () {}
	public User getUser(int userId)
	{
		     log.debug("********** Debut getUser UserDAO **********");
		     
		     try
		     {
			 User user=null;
		     Session session = SessionFactoryUtil.getInstance().openSession();
		     user = (User) session.get(User.class, userId);
		     return user;
		     }
		     catch(Exception e)
		     {
		       e.printStackTrace();
		       log.fatal(e.getMessage());
		       return null;
		     }
		     finally
		     {
			     log.debug("********** Fin getUser UserDAO **********");
		     }
	}
	@SuppressWarnings("unchecked")
	public User getUserByLoginEtPassword(String login,String password)
	{
	     log.debug("********** Debut getUserByLoginEtPassword UserDAO **********");

		try
		{ 
		     Session session = SessionFactoryUtil.getInstance().openSession();
		     List<User> users=session.createQuery("select user from User user where user.login='"+login+"' and user.password='"+password+"'").list();
		     if(users!=null && users.size()>0)
		    	 return (User) users.get(0);
		     return null;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			log.fatal(e.getMessage());
			return null;
		}
		finally
		{
		     log.debug("********** Fin getUserByLoginEtPassword UserDAO **********");
		}
	}
	
	@SuppressWarnings("unchecked")
	public User getUserByLogin(String login)
	{
	     log.debug("********** Debut getUserByLogin UserDAO **********");

		try
		{ 
		     Session session = SessionFactoryUtil.getInstance().openSession();
		     List<User> users=session.createQuery("select user from User user where user.login='"+login+"'").list();
		     if(users!=null && users.size()>0)
		    	 return (User) users.get(0);
		     return null;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			log.fatal(e.getMessage());
			return null;
		}
		finally
		{
		     log.debug("********** Fin getUserByLogin UserDAO **********");
		}
	}
	
	
	public void saveUser(User user)
	{
	         log.debug("********** Debut saveUser UserDAO **********");
             try
             {
		     Session session = SessionFactoryUtil.getInstance().openSession();
		     user.setStatut(STATUT_VALIDE);
		     session.save(user);
             }
             catch(Exception e)
             {
            	 e.printStackTrace();
            	 log.fatal(e.getMessage());
             }
             finally
             {
        	     log.debug("********** Fin saveUser UserDAO **********");
             }

	}
	public void updateUser(User user)
	{
	     log.debug("********** Debut updateUser UserDAO **********");
             try
             {
		     Session session = SessionFactoryUtil.getInstance().openSession();
		     session.update(user);
             }
             catch(Exception e)
             {
            	 e.printStackTrace();
            	 log.fatal(e.getMessage());
             }
             finally
             {
        	     log.debug("********** Fin updateUser UserDAO **********");
             }
	}
	public void deleteUser(User user)
	{
	         log.debug("********** Debut deleteUser UserDAO **********");
             try
             {
		     Session session = SessionFactoryUtil.getInstance().openSession();
		     user.setStatut(STATUT_SUPPRIME);
		     session.update(user);
             }
             catch(Exception e)
             {
            	 e.printStackTrace();
            	 log.fatal(e.getMessage());
             }
             finally
             {
    	         log.debug("********** Fin deleteUser UserDAO **********");
             }
	}
	@SuppressWarnings("unchecked")
	public List<User> listUsers() 
	{
        log.debug("********** Debut listUsers UserDAO **********");

		try 
	    {
			List<User> users=null;
		    Session session = SessionFactoryUtil.getInstance().openSession();
	    	String strQuery = "select distinct user ";
	    	strQuery+="from User user";
	    	strQuery+="where user.statut = "+STATUT_VALIDE;
	    	strQuery+=" order by user.userId asc";
	    	org.hibernate.Query query=session.createQuery(strQuery);
	    	users = query.list();	
	    	
	    	
	    	
		    return users;
	    } 
	    catch (Exception e) 
	    {
	    	e.printStackTrace();
	    	log.fatal(e.getMessage());
	    	return null;
	    }
	    finally
	    {
	        log.debug("********** Fin listUsers UserDAO **********");
	    }
	}
	@SuppressWarnings({ "unchecked"})
	public List<User> listUsersSupprimes() 
	{
        log.debug("********** Debut listUsersSupprimes UserDAO **********");

		try 
	    {
			List<User> users=null;
		    Session session = SessionFactoryUtil.getInstance().openSession();
	    	String strQuery = "select distinct user ";
	    	strQuery+="from User user";
	    	strQuery+="where user.statut = "+STATUT_SUPPRIME;
	    	strQuery+=" order by user.userId asc";
	    	org.hibernate.Query query=session.createQuery(strQuery);
	    	users = query.list();	
		    return users;
	    } 
	    catch (Exception e) 
	    {
	    	e.printStackTrace();
	    	log.fatal(e.getMessage());
	    	return null;
	    }
	    finally
	    {
	        log.debug("********** Fin listUsersSupprimes UserDAO **********");
	    }
	}
}
