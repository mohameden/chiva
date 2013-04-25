
package clinique.dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Session;

import clinique.mapping.Patient;
import clinique.mapping.PatientPcActuel;
import clinique.utils.ConstantesMetier;

public class PatientPcActuelDAO implements ConstantesMetier {
	
	private static Logger log = Logger.getLogger(PatientPcActuelDAO.class);
	private static final PatientPcActuelDAO INSTANCE = new PatientPcActuelDAO();

	public static PatientPcActuelDAO getInstance() {
		  return INSTANCE;
		 }

	private PatientPcActuelDAO () {}
	public PatientPcActuel getPatientPcActuel(String patientPcActuelId)
	{
		     log.debug("********** Debut getPatientPcActuel PatientPcActuelDAO **********");
		     try
		     {
		     PatientPcActuel patientPcActuel=null;
		     Session session = SessionFactoryUtil.getInstance().openSession();
		     patientPcActuel = (PatientPcActuel) session.get(PatientPcActuel.class, patientPcActuelId);
		     return patientPcActuel;
		     }
		     catch (Exception e) {
				e.printStackTrace();
				log.fatal(e.getMessage());
				return null;
			}
		    finally
		    {
			     log.debug("********** Fin getPatientPcActuel PatientPcActuelDAO **********");
		    }
	}
	
	public void savePatientPcActuel(PatientPcActuel patientPcActuel)
	{
	         log.debug("********** Debut savePatientPcActuel PatientPcActuelDAO **********");
		     try
		     {
		     Session session = SessionFactoryUtil.getInstance().openSession();
		     patientPcActuel.setStatut(STATUT_VALIDE);
		     session.save(patientPcActuel);
		     }
		     catch(Exception e)
		     {
		    	 e.printStackTrace();
		    	 log.fatal(e.getMessage());
		     }
		     finally
		     {
		         log.debug("********** Fin savePatientPcActuel PatientPcActuelDAO **********");
		     }
	}
	public void updatePatientPcActuel(PatientPcActuel patientPcActuel)
	{
             log.debug("********** Debut updatePatientPcActuel PatientPcActuelDAO **********");
		     try
		     {
		     Session session = SessionFactoryUtil.getInstance().openSession();
		     session.update(patientPcActuel);
		     }
		     catch(Exception e)
		     {
		    	 e.printStackTrace();
		    	 log.fatal(e.getMessage());
		     }
		     finally
		     {
	             log.debug("********** Fin updatePatientPcActuel PatientPcActuelDAO **********");
		     }
	}
	public void deletePatientPcActuel(PatientPcActuel patientPcActuel)
	{
             log.debug("********** Debut deletePatientPcActuel PatientPcActuelDAO **********");
		     try
		     {
		     Session session = SessionFactoryUtil.getInstance().openSession();
		     patientPcActuel.setStatut(STATUT_SUPPRIME);
		     session.update(patientPcActuel);
		     }
		     catch(Exception e)
		     {
		    	 e.printStackTrace();
		    	 log.fatal(e.getMessage());
		     }
		     finally
		     {
	             log.debug("********** Fin deletePatientPcActuel PatientPcActuelDAO **********");
		     }
	}
	
		@SuppressWarnings({ "unchecked"})
	public List<PatientPcActuel> listPatientPcActuels() 
	{
        log.debug("********** Debut listPatientPcActuels PatientPcActuelDAO **********");
		try 
	    {
			List<PatientPcActuel> patientPcActuels=null;
		    Session session = SessionFactoryUtil.getInstance().openSession();
	    	String strQuery = "select distinct patientPcActuel ";
	    	strQuery+="from PatientPcActuel patientPcActuel ";
	    	strQuery+="where patientPcActuel.statut = "+STATUT_VALIDE;
	    	strQuery+=" order by patientPcActuel.patientPcActuelId asc";
	    	org.hibernate.Query query=session.createQuery(strQuery);
	    	patientPcActuels = query.list();
	    	return patientPcActuels;
	    } 
	    catch (Exception e) 
	    {
	    	e.printStackTrace();
	    	log.fatal(e.getMessage());
	    	return null;
	    }
	    finally
	    {
	        log.debug("********** Fin listPatientPcActuels PatientPcActuelDAO **********");
	    }
	}
		

		@SuppressWarnings({ "unchecked"})
	public PatientPcActuel getPatientPcByPatient(Patient patient) 
	{
			PatientPcActuel patientPcActuel=null;
        log.debug("********** Debut getPatientPcByPatient PatientPcActuelDAO **********");
		try 
	    {
			
			List<PatientPcActuel> patientPcActuels=null;
		    Session session = SessionFactoryUtil.getInstance().openSession();
	    	String strQuery = "select distinct patientPcActuel ";
	    	strQuery+="from PatientPcActuel patientPcActuel ";
	    	strQuery+="where patientPcActuel.statut = "+STATUT_VALIDE;
	    	strQuery+=" and patientPcActuel.patient.patientId = "+patient.getPatientId();
	    	strQuery+=" order by patientPcActuel.patientPcActuelId asc";
	    	org.hibernate.Query query=session.createQuery(strQuery);
	    	patientPcActuels = query.list();
	    	if (patientPcActuels.size()>0)  patientPcActuel=patientPcActuels.get(0);
	    	return patientPcActuel;
	    } 
	    catch (Exception e) 
	    {
	    	e.printStackTrace();
	    	log.fatal(e.getMessage());
	    	return null;
	    }
	    finally
	    {
	        log.debug("********** Fin getPatientPcByPatient PatientPcActuelDAO **********");
	    }
	}
		
		
		public void deletePatientPcByPatient(Patient patient,Session session) 
		{
				
	        log.debug("********** Debut deletePatientPcByPatient PatientPcActuelDAO **********");
			try 
		    {
				
			     
		    	String strQuery = "delete from PatientPcActuel patientPcActuel ";
		    	strQuery+=" where patientPcActuel.patient.patientId = "+patient.getPatientId();
		    	
		    	session.createQuery(strQuery);

		    } 
		    catch (Exception e) 
		    {
		    	e.printStackTrace();
		    	log.fatal(e.getMessage());
		    	
		    }
		    finally
		    {
		        log.debug("********** Fin deletePatientPcByPatient PatientPcActuelDAO **********");
		    }
		}
			
		
		

}
