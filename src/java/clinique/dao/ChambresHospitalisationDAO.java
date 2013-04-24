package clinique.dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Session;

import clinique.mapping.ChambresHospitalisation;
import clinique.mapping.Patient;
import clinique.utils.ConstantesMetier;

public class ChambresHospitalisationDAO implements ConstantesMetier {
	
	private static Logger log = Logger.getLogger(ChambresHospitalisationDAO.class);
	private static final ChambresHospitalisationDAO INSTANCE = new ChambresHospitalisationDAO();

	public static ChambresHospitalisationDAO getInstance() {
		  return INSTANCE;
		 }

	private ChambresHospitalisationDAO () {}
	public ChambresHospitalisation getChambresHospitalisation(String chambresHospitalisationId)
	{
        log.debug("********** Debut getChambresHospitalisation ChambresHospitalisationDAO **********");
        try
        {
		     ChambresHospitalisation chambresHospitalisation=null;
		     Session session = SessionFactoryUtil.getInstance().openSession();
		     chambresHospitalisation = (ChambresHospitalisation) session.get(ChambresHospitalisation.class, chambresHospitalisationId);
		     return chambresHospitalisation;
        }
        catch(Exception e)
        {
        	e.printStackTrace();
        	log.fatal(e.getMessage());
        	return null;
        }
        finally
        {
            log.debug("********** Fin getChambresHospitalisation ChambresHospitalisationDAO **********");
        }
	}
	public void saveChambresHospitalisation(ChambresHospitalisation chambresHospitalisation)
	{
        log.debug("********** Debut saveChambresHospitalisation ChambresHospitalisationDAO **********");
        try
        {
		     Session session = SessionFactoryUtil.getInstance().openSession();
		     chambresHospitalisation.setStatut(STATUT_SUPPRIME);
		     session.save(chambresHospitalisation);
		     //SessionFactoryUtil.getInstance().close();
		     
        }
        catch(Exception e)
        {
             e.printStackTrace();
             log.fatal(e.getMessage());
        }
        finally
        {
            log.debug("********** Fin saveChambresHospitalisation ChambresHospitalisationDAO **********");
        }
	}
	public void updateChambresHospitalisation(ChambresHospitalisation chambresHospitalisation)
	{
        log.debug("********** Debut updateChambresHospitalisation ChambresHospitalisationDAO **********");
        try
        {
		     Session session = SessionFactoryUtil.getInstance().openSession();
		     session.update(chambresHospitalisation);
		     //SessionFactoryUtil.getInstance().close();
        }
        catch(Exception e)
        {
        	e.printStackTrace();
        	log.fatal(e.getMessage());
        }
        finally
        {
            log.debug("********** Fin updateChambresHospitalisation ChambresHospitalisationDAO **********");
        }
	}
	public void deleteChambresHospitalisation(ChambresHospitalisation chambresHospitalisation)
	{
        log.debug("********** Debut deleteChambresHospitalisation ChambresHospitalisationDAO **********");
        try
        {
		     Session session = SessionFactoryUtil.getInstance().openSession();
		     chambresHospitalisation.setStatut(STATUT_SUPPRIME);
		     session.update(chambresHospitalisation);
        }
        catch(Exception e)
        {
        	e.printStackTrace();
        	log.fatal(e.getMessage());
        }
        finally
        {
            log.debug("********** Fin deleteChambresHospitalisation ChambresHospitalisationDAO **********");
        }
	}
	
	}
