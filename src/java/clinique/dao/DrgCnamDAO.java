package clinique.dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Session;

import clinique.mapping.DrgCnam;
import clinique.utils.ConstantesMetier;

public class DrgCnamDAO implements ConstantesMetier {
	
	private static Logger log = Logger.getLogger(DrgCnamDAO.class);
	private static final DrgCnamDAO INSTANCE = new DrgCnamDAO();

	public static DrgCnamDAO getInstance() {
		  return INSTANCE;
		 }

	private DrgCnamDAO () {}
	public DrgCnam getDrgCnam(String drgCnamId)
	{
		     log.debug("********** Debut getDrgCnam DrgCnamDAO **********");
		     try
		     {
		     DrgCnam drgCnam=null;
		     Session session = SessionFactoryUtil.getInstance().openSession();
		     drgCnam = (DrgCnam) session.get(DrgCnam.class, drgCnamId);
		     return drgCnam;
		     }
		     catch (Exception e) {
				e.printStackTrace();
				log.fatal(e.getMessage());
				return null;
			}
		    finally
		    {
			     log.debug("********** Fin getDrgCnam DrgCnamDAO **********");
		    }
	}
	
	public void saveDrgCnam(DrgCnam drgCnam)
	{
	         log.debug("********** Debut saveDrgCnam DrgCnamDAO **********");
		     try
		     {
		     Session session = SessionFactoryUtil.getInstance().openSession();
		     drgCnam.setStatut(STATUT_VALIDE);
		     session.save(drgCnam);
		     }
		     catch(Exception e)
		     {
		    	 e.printStackTrace();
		    	 log.fatal(e.getMessage());
		     }
		     finally
		     {
		         log.debug("********** Fin saveDrgCnam DrgCnamDAO **********");
		     }
	}
	public void updateDrgCnam(DrgCnam drgCnam)
	{
             log.debug("********** Debut updateDrgCnam DrgCnamDAO **********");
		     try
		     {
		     Session session = SessionFactoryUtil.getInstance().openSession();
		     session.update(drgCnam);
		     }
		     catch(Exception e)
		     {
		    	 e.printStackTrace();
		    	 log.fatal(e.getMessage());
		     }
		     finally
		     {
	             log.debug("********** Fin updateDrgCnam DrgCnamDAO **********");
		     }
	}
	public void deleteDrgCnam(DrgCnam drgCnam)
	{
             log.debug("********** Debut deleteDrgCnam DrgCnamDAO **********");
		     try
		     {
		     Session session = SessionFactoryUtil.getInstance().openSession();
		     drgCnam.setStatut(STATUT_SUPPRIME);
		     session.update(drgCnam);
		     }
		     catch(Exception e)
		     {
		    	 e.printStackTrace();
		    	 log.fatal(e.getMessage());
		     }
		     finally
		     {
	             log.debug("********** Fin deleteDrgCnam DrgCnamDAO **********");
		     }
	}
	

	

	@SuppressWarnings({ "unchecked"})
	public List<DrgCnam> listDrgCnams() 
	{
        log.debug("********** Debut listDrgCnams DrgCnamDAO **********");
		try 
	    {
			List<DrgCnam> drgCnams=null;
		    Session session = SessionFactoryUtil.getInstance().openSession();
	    	String strQuery = "select distinct drgCnam ";
	    	strQuery+="from DrgCnam drgCnam ";
	    	strQuery+="where drgCnam.statut = "+STATUT_VALIDE;
	    	strQuery+=" order by drgCnam.numDrg asc";
	    	org.hibernate.Query query=session.createQuery(strQuery);
	    	drgCnams = query.list();
	    	return drgCnams;
	    } 
	    catch (Exception e) 
	    {
	    	e.printStackTrace();
	    	log.fatal(e.getMessage());
	    	return null;
	    }
	    finally
	    {
	        log.debug("********** Fin listDrgCnams DrgCnamDAO **********");
	    }
	}
	
}
