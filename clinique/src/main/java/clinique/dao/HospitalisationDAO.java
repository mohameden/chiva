package clinique.dao;

import java.util.Iterator;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.CacheMode;
import org.hibernate.Session;

import clinique.mapping.ChambresHospitalisation;
import clinique.mapping.Hospitalisation;
import clinique.utils.ConstantesMetier;

public class HospitalisationDAO implements ConstantesMetier {
	
	private static Logger log = Logger.getLogger(HospitalisationDAO.class);
	private static final HospitalisationDAO INSTANCE = new HospitalisationDAO();

	public static HospitalisationDAO getInstance() {
		  return INSTANCE;
		 }

	private HospitalisationDAO () {}
	public Hospitalisation getHospitalisation(String hospitalisationId)
	{
        log.debug("********** Debut getHospitalisation HospitalisationDAO **********");
        try
        {
		     Hospitalisation hospitalisation;
		     System.out.println("hospitalisation Id :'"+hospitalisationId+"'");
		     
		     Session session = SessionFactoryUtil.getInstance().openSession();
		     hospitalisation = (Hospitalisation) session.get(Hospitalisation.class, hospitalisationId);
		     
		     session.evict(hospitalisation);
		     
		     hospitalisation = (Hospitalisation) session.get(Hospitalisation.class, hospitalisationId);
		     
		     
		     if (hospitalisation!=null) System.out.println("okkkkkkkkkkkkkkkkkkkkkkk");
		     else System.out.println("Nooooooooooooookkkkkkkkkkkkkk");
		     return hospitalisation;
        }
        catch(Exception e)
        {
        	e.printStackTrace();
        	log.fatal(e.getMessage());
        	return null;
        }
        finally
        {
            log.debug("********** Fin getHospitalisation HospitalisationDAO **********");
        }
	}
	
	
	@SuppressWarnings("unchecked")
	public Hospitalisation getHospitalisationById(String hospitalisationId)
	{
        log.debug("********** Debut getHospitalisation HospitalisationDAO **********");
        try
        {
		     Hospitalisation hospitalisation=null;
		     
		     Session session = SessionFactoryUtil.getInstance().openSession();
		     //hospitalisation = (Hospitalisation) session.get(Hospitalisation.class, hospitalisationId);
		    
		     String strQuery = "from Hospitalisation h where h.hospitalisationId=";
		     strQuery+=hospitalisationId;
		     List list=session.createQuery(strQuery)
		    	.setCacheable(false)
		    	.list();
		     if (list.size()>0) hospitalisation=(Hospitalisation) list.get(0);
		     return hospitalisation;
        }
        catch(Exception e)
        {
        	e.printStackTrace();
        	log.fatal(e.getMessage());
        	return null;
        }
        finally
        {
            log.debug("********** Fin getHospitalisation HospitalisationDAO **********");
        }
	}
	
	
	public void saveHospitalisation(Hospitalisation hospitalisation)
	{
        log.debug("********** Debut saveHospitalisation HospitalisationDAO **********");
        try
        {
		     Session session = SessionFactoryUtil.getInstance().openSession();
		     hospitalisation.setStatut(STATUT_VALIDE);
		     session.save(hospitalisation);
        }
        catch(Exception e)
        {
        	e.printStackTrace();
        	log.fatal(e.getMessage());
        }
        finally
        {
            log.debug("********** Fin saveHospitalisation HospitalisationDAO **********");
        }
	}
	public void updateHospitalisation(Hospitalisation hospitalisation)
	{
        log.debug("********** Debut updateHospitalisation HospitalisationDAO **********");
		try
		{
		     Session session = SessionFactoryUtil.getInstance().openSession();
		     session.update(hospitalisation);
		    // SessionFactoryUtil.getInstance().close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
			log.fatal(e.getMessage());
		}
		finally
		{
	        log.debug("********** Fin updateHospitalisation HospitalisationDAO **********");
		}
	}
	public void deleteHospitalisation(Hospitalisation hospitalisation)
	{
		     Session session = SessionFactoryUtil.getInstance().openSession();
		     hospitalisation.setStatut(STATUT_SUPPRIME);
		     session.update(hospitalisation);
	}
	@SuppressWarnings({ "unchecked"})
	public List<Hospitalisation> listHospitalisationsDetailFactures() 
	{
        log.debug("********** Debut listHospitalisationsDetailFactures HospitalisationDAO **********");
		try 
	    {
			List<Hospitalisation> hospitalisationsDetailFactures=null;
		    Session session = SessionFactoryUtil.getInstance().openSession();
	    	String strQuery = "select distinct hospitalisation ";
	    	strQuery+="from Hospitalisation hospitalisation, DetailFacture detailFacture";
	    	strQuery+="where hospitalisation.hosId = detailFacture.hospitalisation.hosId ";
	    	strQuery+="and classe.statut = "+STATUT_VALIDE;
	    	strQuery+=" and acte.statut = "+STATUT_VALIDE;
	    	strQuery+=" order by hospitalisation.hosId asc";
	    	org.hibernate.Query query=session.createQuery(strQuery);
	    	hospitalisationsDetailFactures = query.list();
	    	return hospitalisationsDetailFactures;
	    } 
	    catch (Exception e) 
	    {
	    	e.printStackTrace();
	    	log.fatal(e.getMessage());
	    	return null;
	    }
	    finally
	    {
	        log.debug("********** Fin listHospitalisationsDetailFactures HospitalisationDAO **********");
	    }
	}
	@SuppressWarnings({ "unchecked"})
	public List<Hospitalisation> listHospitalisationsFactures() 
	{
        log.debug("********** Debut listHospitalisationsFactures HospitalisationDAO **********");
		try 
	    {
			List<Hospitalisation> hospitalisationsFactures=null;
		    Session session = SessionFactoryUtil.getInstance().openSession();
	    	String strQuery = "select distinct hospitalisation ";
	    	strQuery+="from Hospitalisation hospitalisation, DetailFacture detailFacture,Facture facture";
	    	strQuery+="where hospitalisation.hosId = detailFacture.hospitalisation.hosId ";
	    	strQuery+="and detailFacture.detailFactId = facture.detailFacture.detailFactId ";
	    	strQuery+="and hospitalisation.statut = "+STATUT_VALIDE;
	    	strQuery+=" and detailFacture.statut = "+STATUT_VALIDE;
	    	strQuery+=" and facture.statut = "+STATUT_VALIDE;
	    	strQuery+=" order by hospitalisation.hosId asc";
	    	org.hibernate.Query query=session.createQuery(strQuery);
	    	hospitalisationsFactures = query.list();
	    	return hospitalisationsFactures;
	    } 
	    catch (Exception e) 
	    {
	    	e.printStackTrace();
	    	log.fatal(e.getMessage());
	    	return null;
	    }
	    finally
	    {
	        log.debug("********** Fin listHospitalisationsFactures HospitalisationDAO **********");
	    }
	}
	@SuppressWarnings({ "unchecked"})
	public List<Hospitalisation> listHospitalisationsPatients() 
	{
        log.debug("********** Debut listHospitalisationsPatients HospitalisationDAO **********");
		try 
	    {
			List<Hospitalisation> hospitalisationsPatients=null;
		    Session session = SessionFactoryUtil.getInstance().openSession();
	    	String strQuery = "select distinct hospitalisation ";
	    	strQuery+="from Hospitalisation hospitalisation, DetailFacture detailFacture,Facture facture,Patient patient";
	    	strQuery+="where hospitalisation.hosId = detailFacture.hospitalisation.hosId ";
	    	strQuery+="and detailFacture.detailFactId = facture.detailFacture.detailFactId ";
	    	strQuery+="and facture.factureId = patient.facture.factureId ";
	    	strQuery+="and hospitalisation.statut = "+STATUT_VALIDE;
	    	strQuery+=" and detailFacture.statut = "+STATUT_VALIDE;
	    	strQuery+=" and facture.statut = "+STATUT_VALIDE;
	    	strQuery+=" and patient.statut = "+STATUT_VALIDE;
	    	strQuery+=" order by hospitalisation.hosId asc";
	    	org.hibernate.Query query=session.createQuery(strQuery);
	    	hospitalisationsPatients = query.list();	 
	    	return hospitalisationsPatients;
	    } 
	    catch (Exception e) 
	    {
	    	e.printStackTrace();
	    	log.fatal(e.getMessage());
	    	return null;
	    }
	    finally
	    {
	        log.debug("********** Fin listHospitalisationsPatients HospitalisationDAO **********");
	    }
	}
	@SuppressWarnings({ "unchecked", "null"})
	public List<Hospitalisation> listHospitalisationsEncours() 
	{
        log.debug("********** Debut listHospitalisations HospitalisationDAO **********");
		try 
	    {
			List<Hospitalisation> hospitalisations=null;
			
		    Session session = SessionFactoryUtil.getInstance().openSession();
	    	String strQuery = "select distinct hospitalisation ";
	    	strQuery+="from Hospitalisation hospitalisation";
	    	strQuery+=" where hospitalisation.statut = "+STATUT_VALIDE;
	    	strQuery+=" and ( hospitalisation.encours = "+STATUT_VALIDE;
	    	strQuery+=" or hospitalisation.encours = "+STATUT_HOSPITALISATION_NO_REGLE;
	    	strQuery+=" ) order by hospitalisation.hospitalisationId asc";
	    	org.hibernate.Query query=session.createQuery(strQuery);
	    	hospitalisations = query
	    	.setCacheable(false)
	    	.list();
	    	
	    	int i=0;
	    	
	    	for (Iterator iter = hospitalisations.iterator(); iter.hasNext();) 
			{
	    		
	    		Hospitalisation element = (Hospitalisation) iter.next();
	    		
	    		String id=element.getHospitalisationId();
	    		
	    		element = (Hospitalisation) session.get(Hospitalisation.class, id);
			     
			     session.evict(element);
			     
			     element = (Hospitalisation) session.get(Hospitalisation.class, id);

			     hospitalisations.set(i, element);
			     
			     i++;
				
			}
	    	
	    	
	    	return hospitalisations;
	    } 
	    catch (Exception e) 
	    {
	    	e.printStackTrace();
	    	log.fatal(e.getMessage());
	    	return null;
	    }
	    finally
	    {
	        log.debug("********** Fin listHospitalisations HospitalisationDAO **********");
	    }
	}
	@SuppressWarnings({ "unchecked"})
	public List<Hospitalisation> listHospitalisationsSupprimes() 
	{
        log.debug("********** Debut listHospitalisationsSupprimes HospitalisationDAO **********");
		try 
	    {
			List<Hospitalisation> hospitalisationsSupprimes=null;
		    Session session = SessionFactoryUtil.getInstance().openSession();
	    	String strQuery = "select distinct hospitalisation ";
	    	strQuery+="from Hospitalisation hospitalisation";
	    	strQuery+="where hospitalisation.statut = "+STATUT_SUPPRIME;
	    	strQuery+=" order by Hospitalisation.hosId asc";
	    	org.hibernate.Query query=session.createQuery(strQuery);
	    	hospitalisationsSupprimes = query.list();	
	    	return hospitalisationsSupprimes;
	    } 
	    catch (Exception e) 
	    {
	    	e.printStackTrace();
	    	log.fatal(e.getMessage());
	    	return null;
	    }
	    finally
	    {
	        log.debug("********** Fin listHospitalisationsSupprimes HospitalisationDAO **********");
	    }
	}
}
