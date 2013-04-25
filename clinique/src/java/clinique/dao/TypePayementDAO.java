package clinique.dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Session;

import clinique.mapping.TypePayement;
import clinique.utils.ConstantesMetier;

public class TypePayementDAO implements ConstantesMetier {
	
	private static Logger log = Logger.getLogger(TypePayementDAO.class);
	private static final TypePayementDAO INSTANCE = new TypePayementDAO();

	public static TypePayementDAO getInstance() {
		  return INSTANCE;
		 }

	private TypePayementDAO () {}
	public TypePayement getTypePayement(int typePayementId)
	{
	     log.debug("********** Debut getTypePayement TypePayementDAO **********");
         try
         {
		     TypePayement typePayement=null;
		     Session session = SessionFactoryUtil.getInstance().openSession();
		     typePayement = (TypePayement) session.get(TypePayement.class, typePayementId);
		     return typePayement;
         }
         catch(Exception e)
         {
        	 e.printStackTrace();
        	 log.fatal(e.getMessage());
        	 return null;
         }
         finally
         {
    	     log.debug("********** Fin getTypePayement TypePayementDAO **********"); 
         }
	}
	public void saveTypePayement(TypePayement typePayement)
	{
	     log.debug("********** Debut saveTypePayement TypePayementDAO **********");
         try
         {
		     Session session = SessionFactoryUtil.getInstance().openSession();
		     typePayement.setStatut(STATUT_VALIDE);
		     session.save(typePayement);
         }
         catch(Exception e)
         {
        	 e.printStackTrace();
        	 log.fatal(e.getMessage());
         }
         finally
         {
    	     log.debug("********** Fin saveTypePayement TypePayementDAO **********");
         }
	}
	public void updateTypePayement(TypePayement typePayement)
	{
	     log.debug("********** Debut updateTypePayement TypePayementDAO **********");
         try
         {
		     Session session = SessionFactoryUtil.getInstance().openSession();
		     session.update(typePayement);
         }
         catch(Exception e)
         {
        	 e.printStackTrace();
        	 log.fatal(e.getMessage());
         }
         finally
         {
    	     log.debug("********** Fin updateTypePayement TypePayementDAO **********"); 
         }
	}
	public void deleteTypePayement(TypePayement typePayement)
	{
	    log.debug("********** Debut deleteTypePayement TypePayementDAO **********");
		try
		{
		     Session session = SessionFactoryUtil.getInstance().openSession();
		     typePayement.setStatut(STATUT_SUPPRIME);
		     session.update(typePayement);
		}
		catch(Exception e)
		{
			e.printStackTrace();
			log.fatal(e.getMessage());
		}
		finally
		{
		    log.debug("********** Fin deleteTypePayement TypePayementDAO **********");
		}
	}
	@SuppressWarnings({ "unchecked"})
	public List<TypePayement> listTypePayements() 
	{
	    log.debug("********** Debut listTypePayements TypePayementDAO **********");
		try 
	    {
			List<TypePayement> typePayements=null;
		    Session session = SessionFactoryUtil.getInstance().openSession();
	    	String strQuery = "select distinct typePayement ";
	    	strQuery+=" from TypePayement typePayement";
	    	strQuery+=" where typePayement.statut = "+STATUT_VALIDE;
	    	strQuery+=" order by typePayement.typePayementId asc";
	    	org.hibernate.Query query=session.createQuery(strQuery);
	    	typePayements = query.list();
	    	return typePayements;
	    } 
	    catch (Exception e) 
	    {
	    	e.printStackTrace();
	    	log.fatal(e.getMessage());
	    	return null;
	    }
	    finally
	    {
		    log.debug("********** Fin listTypePayements TypePayementDAO **********");
	    }
	}
	@SuppressWarnings({ "unchecked"})
	public List<TypePayement> listTypePayementsSupprimes() 
	{
	    log.debug("********** Debut listTypePayementsSupprimes TypePayementDAO **********");
		try 
	    {
			List<TypePayement> typePayements=null;
		    Session session = SessionFactoryUtil.getInstance().openSession();
	    	String strQuery = "select distinct typePayement ";
	    	strQuery+="from TypePayement typePayement";
	    	strQuery+="where typePayement.statut = "+STATUT_SUPPRIME;
	    	strQuery+=" order by typePayement.typePayementId asc";
	    	org.hibernate.Query query=session.createQuery(strQuery);
	    	typePayements = query.list();
	    	return typePayements;
	    } 
	    catch (Exception e) 
	    {
	    	e.printStackTrace();
	    	log.fatal(e.getMessage());
	    	return null;
	    }
	    finally
	    {
		    log.debug("********** Fin listTypePayementsSupprimes TypePayementDAO **********");
	    }
	}
}
