package clinique.dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Session;

import clinique.mapping.DroitAcces;
import clinique.utils.ConstantesMetier;

public class DroitAccesDAO implements ConstantesMetier {
	
	private static Logger log = Logger.getLogger(DroitAccesDAO.class);
	private static final DroitAccesDAO INSTANCE = new DroitAccesDAO();

	public static DroitAccesDAO getInstance() {
		  return INSTANCE;
		 }

	private DroitAccesDAO () {}
	public DroitAcces getDroitAcces(int droitAccesId)
	{
        log.debug("********** Debut getDroitAcces DroitAccesDAO **********");
        try
        {
		     DroitAcces droitAcces=null;
		     Session session = SessionFactoryUtil.getInstance().openSession();
		     droitAcces = (DroitAcces) session.get(DroitAcces.class, droitAccesId);
		     return droitAcces;
        }
        catch(Exception e)
        {
        	e.printStackTrace();
        	log.fatal(e.getMessage());
        	return null;
        }
        finally
        {
            log.debug("********** Fin getDroitAcces DroitAccesDAO **********");
        }
	}
	public void saveDroitAcces(DroitAcces droitAcces)
	{
        log.debug("********** Debut saveDroitAcces DroitAccesDAO **********");
        try
        {
		     Session session = SessionFactoryUtil.getInstance().openSession();
		     session.save(droitAcces);
        }
        catch(Exception e)
        {
        	e.printStackTrace();
        	log.fatal(e.getMessage());
        }
        finally
        {
            log.debug("********** Fin saveDroitAcces DroitAccesDAO **********");
        }
	}
	public void updateDroitAcces(DroitAcces droitAcces)
	{
        log.debug("********** Debut updateDroitAcces DroitAccesDAO **********");
        try
        {
		     Session session = SessionFactoryUtil.getInstance().openSession();
		     droitAcces.setStatut(STATUT_VALIDE);
		     session.update(droitAcces);
        }
        catch(Exception e)
        {
        	e.printStackTrace();
        	log.fatal(e.getMessage());
        }
        finally
        {
            log.debug("********** Fin updateDroitAcces DroitAccesDAO **********");
        }
	}
	public void deleteDroitAcces(DroitAcces droitAcces)
	{
        log.debug("********** Debut deleteDroitAcces DroitAccesDAO **********");
        try
        {
		     Session session = SessionFactoryUtil.getInstance().openSession();
		     droitAcces.setStatut(STATUT_SUPPRIME);
		     session.update(droitAcces);
        }
        catch(Exception e)
        {
        	e.printStackTrace();
        	log.fatal(e.getMessage());
        }
        finally
        {
            log.debug("********** Fin deleteDroitAcces DroitAccesDAO **********");
        }
	}
	@SuppressWarnings({ "unchecked"})
	public List<DroitAcces> listDroitsAcces() 
	{
        log.debug("********** Debut listDroitsAcces DroitAccesDAO **********");
		try 
	    {
			List<DroitAcces> droitsAcces=null;
		    Session session = SessionFactoryUtil.getInstance().openSession();
	    	String strQuery = "select distinct droitAcces ";
	    	strQuery+="from DroitAcces droitAcces";
	    	strQuery+="where droitAcces.statut = "+STATUT_VALIDE;
	    	strQuery+=" order by droitAcces.dAccId asc";
	    	org.hibernate.Query query=session.createQuery(strQuery);
	    	droitsAcces = query.list();	 
	    	return droitsAcces;
	    } 
	    catch (Exception e) 
	    {
	    	e.printStackTrace();
	    	log.fatal(e.getMessage());
	    	return null;
	    }
	    finally
	    {
	        log.debug("********** Fin listDroitsAcces DroitAccesDAO **********");
	    }
	}
	@SuppressWarnings({ "unchecked"})
	public List<DroitAcces> listDroitsAccesSupprimes() 
	{
        log.debug("********** Debut listDroitsAccesSupprimes DroitAccesDAO **********");
		try 
	    {
			List<DroitAcces> droitsAcces=null;
		    Session session = SessionFactoryUtil.getInstance().openSession();
	    	String strQuery = "select distinct droitAcces ";
	    	strQuery+="from DroitAcces droitAcces";
	    	strQuery+="where droitAcces.statut = "+STATUT_SUPPRIME;
	    	strQuery+=" order by droitAcces.dAccId asc";
	    	org.hibernate.Query query=session.createQuery(strQuery);
	    	droitsAcces = query.list();
	    	return droitsAcces;
	    } 
	    catch (Exception e) 
	    {
	    	e.printStackTrace();
	    	log.fatal(e.getMessage());
	    	return null;
	    }
	    finally
	    {
	        log.debug("********** Fin listDroitsAccesSupprimes DroitAccesDAO **********");
	    }
	}
}
