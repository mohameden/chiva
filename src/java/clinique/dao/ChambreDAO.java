package clinique.dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.CacheMode;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Expression;

import clinique.mapping.Chambre;
import clinique.utils.ConstantesMetier;

public class ChambreDAO implements ConstantesMetier {
	private static Logger log = Logger.getLogger(ChambreDAO.class);
	private static final ChambreDAO INSTANCE = new ChambreDAO();

	public static ChambreDAO getInstance() {
		  return INSTANCE;
		 }

	private ChambreDAO () {}
	public Chambre getChambre(int chambreId)
	{
        log.debug("********** Debut getChambre ChambreDAO **********");
        
        try
        {
		     Chambre chambre=null;
		     Session session = SessionFactoryUtil.getInstance().openSession();
		     chambre = (Chambre) session.get(Chambre.class, chambreId);
		     //SessionFactoryUtil.getInstance().close();
		     
		     return chambre;
        }
        catch(Exception e)
        {
        	e.printStackTrace();
        	log.fatal(e.getMessage());
        	return null;
        }
        finally
        {
        	
            log.debug("********** Fin getChambre ChambreDAO **********");
            //session.close();
        }
	}
	public void saveChambre(Chambre chambre)
	{
		log.debug("********** Debut saveChambre ChambreDAO **********");
        try
        {
		     
		     Session session = SessionFactoryUtil.getInstance().openSession();
		     chambre.setStatut(STATUT_VALIDE);
		     session.save(chambre);
        }
        catch (Exception e) 
        {
			e.printStackTrace();
			log.fatal(e.getMessage());
		}
		finally
		        {
		            log.debug("********** Fin saveChambre ChambreDAO **********");
		        }
	}
	public void updateChambre(Chambre chambre)
	{
		log.debug("********** Debut updateChambre ChambreDAO **********");
        try
        {
		     Session session = SessionFactoryUtil.getInstance().openSession();
		     session.update(chambre);
		     //SessionFactoryUtil.getInstance().close();
        }
        catch(Exception e)
        {
        	e.printStackTrace();
        	log.fatal(e.getMessage());
        }
        finally
        {
    		log.debug("********** Fin updateChambre ChambreDAO **********");
        }
	}
	
	public void updateChambreLibre(Chambre chambre)
	{
		log.debug("********** Debut updateChambreLibre ChambreDAO **********");
        try
        {
		     Session session = SessionFactoryUtil.getInstance().openSession();
		     chambre.setEtat(STATUT_VALIDE);
		     System.out.println("testttttttttttttttt");
		     session.update(chambre);
		     System.out.println("mmmmmmmmmmmmmmmmmmmm");
		     //SessionFactoryUtil.getInstance().close();
        }
        catch(Exception e)
        {
        	e.printStackTrace();
        	log.fatal(e.getMessage());
        }
        finally
        {
    		log.debug("********** Fin updateChambreLibre ChambreDAO **********");
        }
	}
	
	public void updateChambreOccupee(Chambre chambre)
	{
		log.debug("********** Debut updateChambre ChambreDAO **********");
        try
        {
		     Session session = SessionFactoryUtil.getInstance().openSession();
		     System.out.println("testtttttttttooooo");
		     chambre.setEtat(STATUT_SUPPRIME);
		     session.update(chambre);
		     System.out.println("nnnnnnnnnnnnnnnnnn");
		     //SessionFactoryUtil.getInstance().close();
        }
        catch(Exception e)
        {
        	e.printStackTrace();
        	log.fatal(e.getMessage());
        }
        finally
        {
    		log.debug("********** Fin updateChambre ChambreDAO **********");
        }
	}
	
	public void deleteChambre(Chambre chambre)
	{
		     log.debug("********** Debut deleteChambre ChambreDAO **********");
		     try
		     {
		     Session session = SessionFactoryUtil.getInstance().openSession();
		     chambre.setStatut(STATUT_SUPPRIME);
		     session.update(chambre);
		     }
		     catch(Exception e)
		     {
		    	 e.printStackTrace();
		    	 log.fatal(e.getMessage());
		     }
		     finally
		     {
			     log.debug("********** Debut deleteChambre ChambreDAO **********");
		     }
	}
	@SuppressWarnings({ "unchecked"})
	public List<Chambre> listChambresHospitalisations() 
	{
	    log.debug("********** Debut listChambresHospitalisations ChambreDAO **********");
		try 
	    {
			List<Chambre> chambresHospitalisations=null;
		    Session session = SessionFactoryUtil.getInstance().openSession();
	    	String strQuery = "select distinct chambre ";
	    	strQuery+="from Chambre chambre, Hospitalisation hospitalisation";
	    	strQuery+="where chambre.chambreId = hospitalisation.chambre.chambreId ";
	    	strQuery+="and chambre.statut = "+STATUT_VALIDE;
	    	strQuery+=" and hospitalisation.statut = "+STATUT_VALIDE;
	    	strQuery+=" order by chambre.chambreId asc";
	    	org.hibernate.Query query=session.createQuery(strQuery);
	    	chambresHospitalisations = query.list();
	    	return chambresHospitalisations;
	    } 
	    catch (Exception e) 
	    {
	    	e.printStackTrace();
	    	log.fatal(e.getMessage());
	    	return null;
	    }
	    finally
	    {
		    log.debug("********** Fin listChambresHospitalisations ChambreDAO **********");
	    }
	}
	@SuppressWarnings({"unchecked" })
	public List<Chambre> listChambres() 
	{
	    log.debug("********** Debut listChambres ChambreDAO **********");
		try 
	    {
			List<Chambre> chambres=null;
		    Session session = SessionFactoryUtil.getInstance().openSession();
	    	String strQuery = "select distinct chambre ";
	    	strQuery+="from Chambre chambre ";
	    	strQuery+="and chambre.statut = "+STATUT_VALIDE;
	    	strQuery+=" order by chambre.chambreId asc";
	    	org.hibernate.Query query=session.createQuery(strQuery);
	    	chambres = query.list();
	    	return chambres;
	    } 
	    catch (Exception e) 
	    {
	    	e.printStackTrace();
	    	log.fatal(e.getMessage());
	    	return null;
	    }
	    finally
	    {
		    log.debug("********** Fin listChambres ChambreDAO **********");
	    }
	}
	@SuppressWarnings({"unchecked", "null" })
	public List<Chambre> listChambresLibres() 
	{
	    log.debug("********** Debut listChambresLibres ChambreDAO **********");
		try 
	    {
			List<Chambre> chambres=null;
			 SessionFactoryUtil.getInstance().getCurrentSession().disconnect();
		    Session session = SessionFactoryUtil.getInstance().openSession();
	    	String strQuery = "select distinct chambre ";
	    	strQuery+=" from Chambre chambre ";
	    	strQuery+=" where chambre.statut =  "+STATUT_VALIDE;
	    	strQuery+=" and chambre.etat = "+ETAT_CHAMBRE_LIBRE;
	    	strQuery+=" order by chambre.chambreId asc";
	        
	    	chambres=session.createQuery(strQuery)
	    	.setCacheable(false)
	    	.list();
	    	/*
		    chambres =session.createCriteria(Chambre.class)
		      .add( Expression.like("statut", STATUT_VALIDE) )
		      .add( Expression.like("etat", ETAT_CHAMBRE_LIBRE) )
		      .list();
		     */
	    	return chambres;
	    } 
	    catch (Exception e) 
	    {
	    	e.printStackTrace();
	    	log.fatal(e.getMessage());
	    	return null;
	    }
	    finally
	    {
		    log.debug("********** Fin listChambresLibres ChambreDAO **********");
		    
	    }
	}
	@SuppressWarnings({"unchecked" })
	public List<Chambre> listChambresOccupes() 
	{
	    log.debug("********** Debut listChambresOccupes ChambreDAO **********");
	    try 
	    {
	    	Session session = SessionFactoryUtil.getInstance().openSession();
			List<Chambre> chambres=null;
	    	String strQuery = "select distinct chambre ";
	    	strQuery+="from Chambre chambre ";
	    	strQuery+="and chambre.statut =  "+STATUT_VALIDE;
	    	strQuery+=" and chambre.etat = "+ETAT_CHAMBRE_OCCUPE;
	    	strQuery+=" order by chambre.chambreId asc";
	    	org.hibernate.Query query=session.createQuery(strQuery);
	    	chambres = query.list();
	    	return chambres;
	    } 
	    catch (Exception e) 
	    {
	    	e.printStackTrace();
	    	log.fatal(e.getMessage());
	    	return null;
	    }
	    finally
	    {
		    log.debug("********** Fin listChambresOccupes ChambreDAO **********");
	    }
	}
	@SuppressWarnings({"unchecked" })
	public List<Chambre> listChambresSupprimes() 
	{
	    log.debug("********** Debut listChambresSupprimes ChambreDAO **********");
		try 
	    {
			List<Chambre> chambres=null;
		    Session session = SessionFactoryUtil.getInstance().openSession();
	    	String strQuery = "select distinct chambre ";
	    	strQuery+="from Chambre chambre ";
	    	strQuery+="and chambre.statut = "+STATUT_SUPPRIME;
	    	strQuery+=" order by chambre.chambreId asc";
	    	org.hibernate.Query query=session.createQuery(strQuery);
	    	chambres = query.list();
	    	return chambres;
	    } 
	    catch (Exception e) 
	    {
	    	e.printStackTrace();
	    	log.fatal(e.getMessage());
	    	return null;
	    }
	    finally
	    {
		    log.debug("********** Fin listChambresSupprimes ChambreDAO **********");
	    }
	}
}
