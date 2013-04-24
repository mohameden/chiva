package clinique.dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Session;

import clinique.mapping.Reglement;
import clinique.utils.ConstantesMetier;

public class ReglementDAO implements ConstantesMetier {
	
	private static Logger log = Logger.getLogger(ReglementDAO.class);
	private static final ReglementDAO INSTANCE = new ReglementDAO();

	public static ReglementDAO getInstance() {
		  return INSTANCE;
		 }

	private ReglementDAO () {}
	public Reglement getReglement(int reglementId)
	{
	     log.debug("********** Debut getReglement ReglementDAO **********");
         try
         {
		     Reglement reglement=null;
		     Session session = SessionFactoryUtil.getInstance().openSession();
		     reglement = (Reglement) session.get(Reglement.class, reglementId);
		     return reglement;
         }
         catch(Exception e)
         {
        	 e.printStackTrace();
        	 log.fatal(e.getMessage());
        	 return null;
         }
         finally
         {
    	     log.debug("********** Fin getReglement ReglementDAO **********");
         }
	}
	public void saveReglement(Reglement reglement)
	{
	     log.debug("********** Debut saveReglement ReglementDAO **********");
         try
         {
		     Session session = SessionFactoryUtil.getInstance().openSession();
		     reglement.setStatut(STATUT_VALIDE);
		     session.save(reglement);
         }
         catch(Exception e)
         {
        	 e.printStackTrace();
        	 log.fatal(e.getMessage());
         }
         finally
         {
    	     log.debug("********** Fin saveReglement ReglementDAO **********");
         }
          
	}
	public void updateReglement(Reglement reglement)
	{
	     log.debug("********** Debut updateReglement ReglementDAO **********");
		try
		{
		     Session session = SessionFactoryUtil.getInstance().openSession();
		     session.update(reglement);
		}
		catch(Exception e)
		{
			e.printStackTrace();
			log.fatal(e.getMessage());
		}
		finally
		{
		     log.debug("********** Fin updateReglement ReglementDAO **********");
		}
	}
	public void deleteReglement(Reglement reglement)
	{
	     log.debug("********** Debut deleteReglement ReglementDAO **********");
         try
         {
		     Session session = SessionFactoryUtil.getInstance().openSession();
		     reglement.setStatut(STATUT_SUPPRIME);
		     session.update(reglement);
         }
         catch(Exception e)
         {
        	 e.printStackTrace();
        	 log.fatal(e.getMessage());
         }
         finally
         {
    	     log.debug("********** Fin deleteReglement ReglementDAO **********");
         }
	}
	@SuppressWarnings({ "unchecked"})
	public List<Reglement> listReglements() 
	{
	    log.debug("********** Debut listReglements ReglementDAO **********");
		try 
	    {
			List<Reglement> reglements=null;
		    Session session = SessionFactoryUtil.getInstance().openSession();
	    	String strQuery = "select distinct reglement ";
	    	strQuery+="from Reglement reglement";
	    	strQuery+="where reglement.statut = "+STATUT_VALIDE;
	    	strQuery+=" order by reglement.reglementId asc";
	    	org.hibernate.Query query=session.createQuery(strQuery);
	    	reglements = query.list();	
	    	return reglements;
	    } 
	    catch (Exception e) 
	    {
	    	e.printStackTrace();
	    	log.fatal(e.getMessage());
	    	return null;
	    }
	    finally
	    {
		    log.debug("********** Fin listReglements ReglementDAO **********");
	    }
	}
	@SuppressWarnings({ "unchecked"})
	public List<Reglement> listReglementsSupprimes() 
	{
	    log.debug("********** Debut listReglementsSupprimes ReglementDAO **********");
		try 
	    {
			List<Reglement> reglements=null;
		    Session session = SessionFactoryUtil.getInstance().openSession();
	    	String strQuery = "select distinct reglement ";
	    	strQuery+="from Reglement reglement";
	    	strQuery+="where reglement.statut = "+STATUT_SUPPRIME;
	    	strQuery+=" order by reglement.reglementId asc";
	    	org.hibernate.Query query=session.createQuery(strQuery);
	    	reglements = query.list();
	    	return reglements;
	    } 
	    catch (Exception e) 
	    {
	    	e.printStackTrace();
	    	log.fatal(e.getMessage());
	    	return null;
	    }
	    finally
	    {
		    log.debug("********** Fin listReglementsSupprimes ReglementDAO **********");
	    }
	}
}
