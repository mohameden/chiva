package clinique.dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Session;

import clinique.mapping.Acte;
import clinique.mapping.ExclusionActeAssureur;

import clinique.utils.ConstantesMetier;

public class ExclusionActeAssureurDAO implements ConstantesMetier {
	
	private static Logger log = Logger.getLogger(ExclusionActeAssureurDAO.class);
	private static final ExclusionActeAssureurDAO INSTANCE = new ExclusionActeAssureurDAO();

	public static ExclusionActeAssureurDAO getInstance() {
		  return INSTANCE;
		 }

	private ExclusionActeAssureurDAO () {}
	public ExclusionActeAssureur getExclusionActeAssureur(String exclusionActeAssureurId)
	{
        log.debug("********** Debut getExclusionActeAssureur ExclusionActeAssureurDAO **********");
        try
        {
		     ExclusionActeAssureur exclusionActeAssureur=null;
		     Session session = SessionFactoryUtil.getInstance().openSession();
		     exclusionActeAssureur = (ExclusionActeAssureur) session.get(ExclusionActeAssureur.class, exclusionActeAssureurId);
		     return exclusionActeAssureur;
        }
        catch(Exception e)
        {
        	e.printStackTrace();
        	log.fatal(e.getMessage());
        	return null;
        }
        finally
        {
            log.debug("********** Fin getExclusionActeAssureur ExclusionActeAssureurDAO **********");
        }
	}
	
	@SuppressWarnings("unchecked")
	public ExclusionActeAssureur getExclusionActeAssureurByActe(Acte acte)
	{
        log.debug("********** Debut getExclusionActeAssureur ExclusionActeAssureurDAO **********");
        try
        {
		     @SuppressWarnings("unused")
			ExclusionActeAssureur exclusionActeAssureur=null;
		     List<ExclusionActeAssureur> exclusionActeAssureurs=null;
			    Session session = SessionFactoryUtil.getInstance().openSession();
		    	String strQuery = "select distinct exclusionActeAssureur ";
		    	strQuery+="from ExclusionActeAssureur exclusionActeAssureur";
		    	strQuery+=" where exclusionActeAssureur.statut = "+STATUT_VALIDE;
		    	strQuery+=" and exclusionActeAssureur.acte.acteId = "+acte.getActeId();
		    	strQuery+=" order by exclusionActeAssureur.exclusionId asc";
		    	org.hibernate.Query query=session.createQuery(strQuery);
		    	exclusionActeAssureurs = query.list();
		    	
		    	if (exclusionActeAssureurs.size()==0) return null;
		    	else return exclusionActeAssureur=exclusionActeAssureurs.get(0);
        }
        catch(Exception e)
        {
        	e.printStackTrace();
        	log.fatal(e.getMessage());
        	return null;
        }
        finally
        {
            log.debug("********** Fin getExclusionActeAssureur ExclusionActeAssureurDAO **********");
        }
	}
	
	public void saveExclusionActeAssureur(ExclusionActeAssureur exclusionActeAssureur)
	{
        log.debug("********** Debut saveExclusionActeAssureur ExclusionActeAssureurDAO **********");
        try
        {
		     Session session = SessionFactoryUtil.getInstance().openSession();
		     exclusionActeAssureur.setStatut(STATUT_SUPPRIME);
		     session.save(exclusionActeAssureur);
		     
        }
        catch(Exception e)
        {
             e.printStackTrace();
             log.fatal(e.getMessage());
        }
        finally
        {
            log.debug("********** Fin saveExclusionActeAssureur ExclusionActeAssureurDAO **********");
        }
	}
	public void updateExclusionActeAssureur(ExclusionActeAssureur exclusionActeAssureur)
	{
        log.debug("********** Debut updateExclusionActeAssureur ExclusionActeAssureurDAO **********");
        try
        {
		     Session session = SessionFactoryUtil.getInstance().openSession();
		     session.update(exclusionActeAssureur);
        }
        catch(Exception e)
        {
        	e.printStackTrace();
        	log.fatal(e.getMessage());
        }
        finally
        {
            log.debug("********** Fin updateExclusionActeAssureur ExclusionActeAssureurDAO **********");
        }
	}
	public void deleteExclusionActeAssureur(ExclusionActeAssureur exclusionActeAssureur)
	{
        log.debug("********** Debut deleteExclusionActeAssureur ExclusionActeAssureurDAO **********");
        try
        {
		     Session session = SessionFactoryUtil.getInstance().openSession();
		     exclusionActeAssureur.setStatut(STATUT_SUPPRIME);
		     session.update(exclusionActeAssureur);
        }
        catch(Exception e)
        {
        	e.printStackTrace();
        	log.fatal(e.getMessage());
        }
        finally
        {
            log.debug("********** Fin deleteExclusionActeAssureur ExclusionActeAssureurDAO **********");
        }
	}
	
	@SuppressWarnings({ "unchecked"})
	public List<ExclusionActeAssureur> listExclusionActeAssureurs() 
	{
        log.debug("********** Debut listExclusionActeAssureurs ExclusionActeAssureurDAO **********");
		try 
	    {
			List<ExclusionActeAssureur> exclusionActeAssureurs=null;
		    Session session = SessionFactoryUtil.getInstance().openSession();
	    	String strQuery = "select distinct exclusionActeAssureur ";
	    	strQuery+="from ExclusionActeAssureur exclusionActeAssureur";
	    	strQuery+="where exclusionActeAssureur.statut = "+STATUT_VALIDE;
	    	strQuery+=" order by exclusionActeAssureur.exclusionActeAssureurId asc";
	    	org.hibernate.Query query=session.createQuery(strQuery);
	    	exclusionActeAssureurs = query.list();
	    	return exclusionActeAssureurs;
	    } 
	    catch (Exception e) 
	    {
	    	e.printStackTrace();
	    	log.fatal(e.getMessage());
	    	return null;
	    }
	    finally
	    {
	        log.debug("********** Fin listExclusionActeAssureurs ExclusionActeAssureurDAO **********");
	    }
	}
	
	@SuppressWarnings({ "unchecked"})
	public List<ExclusionActeAssureur> listExclusionActeAssureursSupprimees() 
	{
        log.debug("********** Debut listExclusionActeAssureursSupprimees ExclusionActeAssureurDAO **********");
		try 
	    {
			List<ExclusionActeAssureur> exclusionActeAssureursSupprimees=null;
		    Session session = SessionFactoryUtil.getInstance().openSession();
	    	String strQuery = "select distinct exclusionActeAssureur ";
	    	strQuery+="from ExclusionActeAssureur exclusionActeAssureur";
	    	strQuery+="where exclusionActeAssureur.statut = "+STATUT_SUPPRIME;
	    	strQuery+=" order by exclusionActeAssureur.exclusionActeAssureurId asc";
	    	org.hibernate.Query query=session.createQuery(strQuery);
	    	exclusionActeAssureursSupprimees = query.list();
	    	return exclusionActeAssureursSupprimees;
	    } 
	    catch (Exception e) 
	    {
	    	e.printStackTrace();
	    	log.fatal(e.getMessage());
	    	return null;
	    }
	    finally
	    {
	        log.debug("********** Fin listExclusionActeAssureursSupprimees ExclusionActeAssureurDAO **********");
	    }
	}
	
	}
