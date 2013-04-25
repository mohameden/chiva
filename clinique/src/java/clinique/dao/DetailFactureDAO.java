package clinique.dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Session;

import clinique.mapping.DetailFacture;
import clinique.utils.ConstantesMetier;

public class DetailFactureDAO implements ConstantesMetier {
	private static Logger log = Logger.getLogger(DetailFactureDAO.class);
	private static final DetailFactureDAO INSTANCE = new DetailFactureDAO();

	public static DetailFactureDAO getInstance() {
		  return INSTANCE;
		 }

	private DetailFactureDAO () {}
	public DetailFacture getDetailFacture(int detailFactureId)
	{
        log.debug("********** Debut getDetailFacture DetailFactureDAO **********");
        try
        {
		     DetailFacture detailFacture=null;
		     Session session = SessionFactoryUtil.getInstance().openSession();
		     detailFacture = (DetailFacture) session.get(DetailFacture.class, detailFactureId);
		     return detailFacture;
        }
        catch(Exception e)
        {
        	e.printStackTrace();
        	log.fatal(e.getMessage());
        	return null;
        }
        finally
        {
            log.debug("********** Fin getDetailFacture DetailFactureDAO **********");
        }
	}
	public void saveDetailFacture(DetailFacture detailFacture)
	{
        log.debug("********** Debut saveDetailFacture DetailFactureDAO **********");
        try
        {
		     Session session = SessionFactoryUtil.getInstance().openSession();
		     detailFacture.setStatut(STATUT_VALIDE);
		     session.save(detailFacture);
        }
        catch(Exception e)
        {
        	e.printStackTrace();
        	log.fatal(e.getMessage());
        }
        finally
        {
            log.debug("********** Fin saveDetailFacture DetailFactureDAO **********");
        }
	}
	public void updateDetailFacture(DetailFacture detailFacture)
	{
        log.debug("********** Debut updateDetailFacture DetailFactureDAO **********");
        try
        {
		     Session session = SessionFactoryUtil.getInstance().openSession();
		     session.update(detailFacture);
        }
        catch(Exception e)
        {
        	e.printStackTrace();
        	log.fatal(e.getMessage());
        }
        finally
        {
            log.debug("********** Fin updateDetailFacture DetailFactureDAO **********");
        }
	}
	public void deleteDetailFacture(DetailFacture detailFacture)
	{
        log.debug("********** Debut deleteDetailFacture DetailFactureDAO **********");
        try
        {
		     Session session = SessionFactoryUtil.getInstance().openSession();
		     detailFacture.setStatut(STATUT_SUPPRIME);
		     session.update(detailFacture);
        }
        catch(Exception e)
        {
        	e.printStackTrace();
        	log.fatal(e.getMessage());
        }
        finally
        {
            log.debug("********** Fin deleteDetailFacture DetailFactureDAO **********");
        }
	}
	@SuppressWarnings({ "unchecked"})
	public List<DetailFacture> listDetailFactures() 
	{
        log.debug("********** Debut listDetailFactures DetailFactureDAO **********");
		try 
	    {
			List<DetailFacture> detailFactures=null;
		    Session session = SessionFactoryUtil.getInstance().openSession();
	    	String strQuery = "select distinct detailFacture ";
	    	strQuery+="from DetailFacture detailFacture";
	    	strQuery+="where detailFacture.statut = "+STATUT_VALIDE;
	    	strQuery+=" order by detailFacture.detailFactIdId asc";
	    	org.hibernate.Query query=session.createQuery(strQuery);
	    	detailFactures = query.list();
	    	return detailFactures;
	    } 
	    catch (Exception e) 
	    {
	    	e.printStackTrace();
	    	log.fatal(e.getMessage());
	    	return null;
	    }
	    finally
	    {
	        log.debug("********** Fin listDetailFactures DetailFactureDAO **********");
	    }
	}
	@SuppressWarnings({ "unchecked"})
	public List<DetailFacture> listDetailFacturesSupprimes() 
	{
        log.debug("********** Debut listDetailFacturesSupprimes DetailFactureDAO **********");
		try 
	    {
			List<DetailFacture> detailFactures=null;
		    Session session = SessionFactoryUtil.getInstance().openSession();
	    	String strQuery = "select distinct detailFacture ";
	    	strQuery+="from DetailFacture detailFacture";
	    	strQuery+="where detailFacture.statut = "+STATUT_SUPPRIME;
	    	strQuery+=" order by detailFacture.detailFactIdId asc";
	    	org.hibernate.Query query=session.createQuery(strQuery);
	    	detailFactures = query.list();	
	    	return detailFactures;
	    } 
	    catch (Exception e) 
	    {
	    	e.printStackTrace();
	    	log.fatal(e.getMessage());
	    	return null;
	    }
	    finally
	    {
	        log.debug("********** Fin listDetailFacturesSupprimes DetailFactureDAO **********");
	    }
	}
}
