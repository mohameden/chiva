
package clinique.dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Session;

import clinique.mapping.Personnel;
import clinique.utils.ConstantesMetier;

public class PersonnelDAO implements ConstantesMetier {
	
	private static Logger log = Logger.getLogger(PersonnelDAO.class);
	private static final PersonnelDAO INSTANCE = new PersonnelDAO();

	public static PersonnelDAO getInstance() {
		  return INSTANCE;
		 }

	private PersonnelDAO () {}
	public Personnel getPersonnel(int personnelId)
	{
	     log.debug("********** Debut getPersonnel PersonnelDAO **********");
         try
         {
		     Personnel personnel=null;
		     Session session = SessionFactoryUtil.getInstance().openSession();
		     personnel = (Personnel) session.get(Personnel.class, personnelId);
		     return personnel;
         }
         catch(Exception e)
         {
        	 e.printStackTrace();
        	 log.fatal(e.getMessage());
        	 return null;
         }
         finally
         {
    	     log.debug("********** Fin getPersonnel PersonnelDAO **********"); 
         }
	}
	public void savePersonnel(Personnel personnel)
	{
	     log.debug("********** Debut savePersonnel PersonnelDAO **********");
         try
         {
		     Session session = SessionFactoryUtil.getInstance().openSession();
		     personnel.setStatut(STATUT_VALIDE);
		     session.save(personnel);
         }
         catch(Exception e)
         {
        	 e.printStackTrace();
        	 log.fatal(e.getMessage());
         }
         finally
         {
    	     log.debug("********** Fin savePersonnel PersonnelDAO **********");
         }
	}
	public void updatePersonnel(Personnel personnel)
	{
	     log.debug("********** Debut updatePersonnel PersonnelDAO **********");
         try
         {
		     Session session = SessionFactoryUtil.getInstance().openSession();
		     session.update(personnel);
         }
         catch(Exception e)
         {
        	 e.printStackTrace();
        	 log.fatal(e.getMessage());
         }
         finally
         {
    	     log.debug("********** Fin updatePersonnel PersonnelDAO **********");
         }
	}
	public void deletePersonnel(Personnel personnel)
	{
	     log.debug("********** Debut deletePersonnel PersonnelDAO **********");
         try
         {
		     Session session = SessionFactoryUtil.getInstance().openSession();
		     personnel.setStatut(STATUT_SUPPRIME);
		     session.update(personnel);
         }
         catch(Exception e)
         {
        	 e.printStackTrace();
        	 log.fatal(e.getMessage());
         }
         finally
         {
    	     log.debug("********** Fin deletePersonnel PersonnelDAO **********");
         }
	}

	@SuppressWarnings({ "unchecked"})
	public List<Personnel> listPersonnels() 
	{
	    log.debug("********** Debut listPersonnels PersonnelDAO **********");
		try 
	    {
			List<Personnel> personnels=null;
		    Session session = SessionFactoryUtil.getInstance().openSession();
	    	String strQuery = "select distinct personnel ";
	    	strQuery+="from Personnel personnel";
	    	strQuery+=" where personnel.statut = "+STATUT_VALIDE;
	    	strQuery+=" order by personnel.personnelId asc";
	    	org.hibernate.Query query=session.createQuery(strQuery);
	    	personnels = query.list();
	    	return personnels;
	    } 
	    catch (Exception e) 
	    {
	    	e.printStackTrace();
	    	log.fatal(e.getMessage());
	    	return null;
	    }
	    finally
	    {
		    log.debug("********** Fin listPersonnels PersonnelDAO **********");
	    }
	}
	
	}

	
