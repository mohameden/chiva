package clinique.dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Session;

import clinique.mapping.Entreprise;
import clinique.utils.ConstantesMetier;

public class EntrepriseDAO implements ConstantesMetier {
	
	private static Logger log = Logger.getLogger(EntrepriseDAO.class);
	private static final EntrepriseDAO INSTANCE = new EntrepriseDAO();

	public static EntrepriseDAO getInstance() {
		  return INSTANCE;
		 }

	private EntrepriseDAO () {}
	public Entreprise getEntreprise(int entrepriseId)
	{
        log.debug("********** Debut getEntreprise EntrepriseDAO **********");
        try
        {
		     Entreprise entreprise=null;
		     Session session = SessionFactoryUtil.getInstance().openSession();
		     entreprise = (Entreprise) session.get(Entreprise.class, entrepriseId);
		     return entreprise;
        }
        catch(Exception e)
        {
        	e.printStackTrace();
        	log.fatal(e.getMessage());
        	return null;
        }
        finally
        {
            log.debug("********** Fin getEntreprise EntrepriseDAO **********");
        }
	}
	public void saveEntreprise(Entreprise entreprise)
	{
        log.debug("********** Debut saveEntreprise EntrepriseDAO **********");
        try
        {
		     Session session = SessionFactoryUtil.getInstance().openSession();
		     entreprise.setStatut(STATUT_VALIDE);
		     session.save(entreprise);
        }
        catch(Exception e)
        {
        	e.printStackTrace();
        	log.fatal(e.getMessage());
        }
        finally
        {
            log.debug("********** Fin saveEntreprise EntrepriseDAO **********");
        }
	}
	public void updateEntreprise(Entreprise entreprise)
	{
        log.debug("********** Debut updateEntreprise EntrepriseDAO **********");
        try
        {
		     Session session = SessionFactoryUtil.getInstance().openSession();
		     session.update(entreprise);
        }
        catch(Exception e)
        {
        	e.printStackTrace();
        	log.fatal(e.getMessage());
        }
        finally
        {
            log.debug("********** Fin updateEntreprise EntrepriseDAO **********");
        }
	}
	public void deleteEntreprise(Entreprise entreprise)
	{
        log.debug("********** Debut deleteEntreprise EntrepriseDAO **********");
        try
        {
		     Session session = SessionFactoryUtil.getInstance().openSession();
		     entreprise.setStatut(STATUT_SUPPRIME);
		     session.update(entreprise);
        }
        catch(Exception e)
        {
        	e.printStackTrace();
        	log.fatal(e.getMessage());
        }
        finally
        {
            log.debug("********** Fin deleteEntreprise EntrepriseDAO **********");
        }
	}
	@SuppressWarnings({ "unchecked"})
	public List<Entreprise> listEntreprisesCategories() 
	{
        log.debug("********** Debut listEntreprisesCategories EntrepriseDAO **********");
		try 
	    {
			List<Entreprise> entreprisesCategories=null;
		    Session session = SessionFactoryUtil.getInstance().openSession();
	    	String strQuery = "select distinct entreprise ";
	    	strQuery+="from Entreprise entreprise, Categorie categorie";
	    	strQuery+="where entreprise.entrepriseId = categorie.entreprise.entrepriseId ";
	    	strQuery+="and entreprise.statut = "+STATUT_VALIDE;
	    	strQuery+=" and categorie.statut = "+STATUT_VALIDE;
	    	strQuery+=" order by entreprise.entrepriseId asc";
	    	org.hibernate.Query query=session.createQuery(strQuery);
	    	entreprisesCategories = query.list();
	    	return entreprisesCategories;
	    } 
	    catch (Exception e) 
	    {
	    	e.printStackTrace();
	    	log.fatal(e.getMessage());
	    	return null;
	    }
	    finally
	    {
	        log.debug("********** Fin listEntreprisesCategories EntrepriseDAO **********");
	    }
	}
	@SuppressWarnings({ "unchecked"})
	public List<Entreprise> listEntreprises() 
	{
        log.debug("********** Debut listEntreprises EntrepriseDAO **********");
		try 
	    {
			List<Entreprise> entreprises=null;
		    Session session = SessionFactoryUtil.getInstance().openSession();
	    	String strQuery = "select distinct entreprise ";
	    	strQuery+="from Entreprise entreprise, Categorie categorie";
	    	strQuery+="where entreprise.statut = "+STATUT_VALIDE;
	    	strQuery+=" order by entreprise.entrepriseId asc";
	    	org.hibernate.Query query=session.createQuery(strQuery);
	    	entreprises = query.list();	 
	    	return entreprises;
	    } 
	    catch (Exception e) 
	    {
	    	e.printStackTrace();
	    	log.fatal(e.getMessage());
	    	return null;
	    }
	    finally
	    {
	        log.debug("********** Fin listEntreprises EntrepriseDAO **********");
	    }
	}
	@SuppressWarnings({ "unchecked"})
	public List<Entreprise> listEntreprisesSupprimees() 
	{
        log.debug("********** Debut listEntreprisesSupprimees EntrepriseDAO **********");
		try 
	    {
			List<Entreprise> entreprisesSupprimees=null;
		    Session session = SessionFactoryUtil.getInstance().openSession();
	    	String strQuery = "select distinct entreprise ";
	    	strQuery+="from Entreprise entreprise, Categorie categorie";
	    	strQuery+="where entreprise.statut = "+STATUT_SUPPRIME;
	    	strQuery+=" order by entreprise.entrepriseId asc";
	    	org.hibernate.Query query=session.createQuery(strQuery);
	    	entreprisesSupprimees = query.list();
	    	return entreprisesSupprimees;
	    } 
	    catch (Exception e) 
	    {
	    	e.printStackTrace();
	    	log.fatal(e.getMessage());
	    	return null;
	    }
	    finally
	    {
	        log.debug("********** Fin listEntreprisesSupprimees EntrepriseDAO **********");
	    }
	}
}
