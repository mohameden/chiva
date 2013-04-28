package clinique.dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Session;

import clinique.mapping.PcPersonnel;
import clinique.utils.ConstantesMetier;

public class PcPersonnelDAO implements ConstantesMetier {
	
	private static Logger log = Logger.getLogger(PcPersonnelDAO.class);
	private static final PcPersonnelDAO INSTANCE = new PcPersonnelDAO();

	public static PcPersonnelDAO getInstance() {
		  return INSTANCE;
		 }

	private PcPersonnelDAO () {}
	public PcPersonnel getPcPersonnel(int pcPersonnelId)
	{
	     log.debug("********** Debut getPcPersonnel PcPersonnelDAO **********");
         try
         {
		     PcPersonnel pcPersonnel=null;
		     Session session = SessionFactoryUtil.getInstance().openSession();
		     pcPersonnel = (PcPersonnel) session.get(PcPersonnel.class, pcPersonnelId);
		     return pcPersonnel;
         }
         catch(Exception e)
         {
        	 e.printStackTrace();
        	 log.fatal(e.getMessage());
        	 return null;
         }
         finally
         {
    	     log.debug("********** Fin getPcPersonnel PcPersonnelDAO **********"); 
         }
	}
	public void savePcPersonnel(PcPersonnel pcPersonnel)
	{
	     log.debug("********** Debut savePcPersonnel PcPersonnelDAO **********");
         try
         {
		     Session session = SessionFactoryUtil.getInstance().openSession();
		     pcPersonnel.setStatut(STATUT_VALIDE);
		     session.save(pcPersonnel);
         }
         catch(Exception e)
         {
        	 e.printStackTrace();
        	 log.fatal(e.getMessage());
         }
         finally
         {
    	     log.debug("********** Fin savePcPersonnel PcPersonnelDAO **********");
         }
	}
	public void updatePcPersonnel(PcPersonnel pcPersonnel)
	{
	     log.debug("********** Debut updatePcPersonnel PcPersonnelDAO **********");
         try
         {
		     Session session = SessionFactoryUtil.getInstance().openSession();
		     session.update(pcPersonnel);
         }
         catch(Exception e)
         {
        	 e.printStackTrace();
        	 log.fatal(e.getMessage());
         }
         finally
         {
    	     log.debug("********** Fin updatePcPersonnel PcPersonnelDAO **********");
         }
	}
	public void deletePcPersonnel(PcPersonnel pcPersonnel)
	{
	     log.debug("********** Debut deletePcPersonnel PcPersonnelDAO **********");
         try
         {
		     Session session = SessionFactoryUtil.getInstance().openSession();
		     pcPersonnel.setStatut(STATUT_SUPPRIME);
		     session.update(pcPersonnel);
         }
         catch(Exception e)
         {
        	 e.printStackTrace();
        	 log.fatal(e.getMessage());
         }
         finally
         {
    	     log.debug("********** Fin deletePcPersonnel PcPersonnelDAO **********");
         }
	}
	@SuppressWarnings({ "unchecked"})
		public List<PcPersonnel> listPcPersonnels() 
	{
	    log.debug("********** Debut listPcPersonnels PcPersonnelDAO **********");
		try 
	    {
			List<PcPersonnel> pcPersonnels=null;
		    Session session = SessionFactoryUtil.getInstance().openSession();
	    	String strQuery = "select distinct pcPersonnel ";
	    	strQuery+="from PcPersonnel pcPersonnel";
	    	strQuery+=" where pcPersonnel.statut = "+STATUT_VALIDE;
	    	strQuery+=" and pcPersonnel.compte.statut = "+STATUT_VALIDE;
	    	strQuery+=" order by pcPersonnel.pcPersonnelId asc";
	    	org.hibernate.Query query=session.createQuery(strQuery);
	    	pcPersonnels = query.list();
	    	return pcPersonnels;
	    } 
	    catch (Exception e) 
	    {
	    	e.printStackTrace();
	    	log.fatal(e.getMessage());
	    	return null;
	    }
	    finally
	    {
		    log.debug("********** Fin listPcPersonnels PcPersonnelDAO **********");
	    }
	}
	
	}
