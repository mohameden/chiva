package clinique.dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import clinique.mapping.Categorie;
import clinique.mapping.CompteCategorie;

import clinique.utils.ConstantesMetier;

public class CompteCategorieDAO implements ConstantesMetier {
	
	private static Logger log = Logger.getLogger(CompteCategorieDAO.class);
	private static final CompteCategorieDAO INSTANCE = new CompteCategorieDAO();

	public static CompteCategorieDAO getInstance() {
		  return INSTANCE;
		 }

	private CompteCategorieDAO () {}
	public CompteCategorie getCompteCategorie(String compteCategorieId)
	{
        log.debug("********** Debut getCompteCategorie CompteCategorieDAO **********");
        try
        {
		     CompteCategorie compteCategorie=null;
		     Session session = SessionFactoryUtil.getInstance().openSession();
		     compteCategorie = (CompteCategorie) session.get(CompteCategorie.class, compteCategorieId);
		     return compteCategorie;
        }
        catch(Exception e)
        {
        	e.printStackTrace();
        	log.fatal(e.getMessage());
        	return null;
        }
        finally
        {
            log.debug("********** Fin getCompteCategorie CompteCategorieDAO **********");
        }
	}
	
	@SuppressWarnings("unchecked")
	public CompteCategorie getCompteCategorieFromCategorie(Categorie categorie)
	{
        log.debug("********** Debut getCompteCategorie CompteCategorieDAO **********");
        try
        {
		     CompteCategorie compteCategorie=null;
		     List<CompteCategorie> compteCategories=null;
			    Session session = SessionFactoryUtil.getInstance().openSession();
		    	String strQuery = "select distinct compteCategorie ";
		    	strQuery+="from CompteCategorie compteCategorie";
		    	strQuery+=" where compteCategorie.statut = "+STATUT_VALIDE;
		    	strQuery+=" and compteCategorie.categorie.categorieId = "+categorie.getCategorieId();
		    	strQuery+=" order by compteCategorie.compteId asc";
		    	org.hibernate.Query query=session.createQuery(strQuery);
		    	compteCategories = query.list();
		    	if (compteCategories.size()>0) compteCategorie=compteCategories.get(0);
		     return compteCategorie;
        }
        catch(Exception e)
        {
        	e.printStackTrace();
        	log.fatal(e.getMessage());
        	return null;
        }
        finally
        {
            log.debug("********** Fin getCompteCategorie CompteCategorieDAO **********");
        }
	}
	
	@SuppressWarnings("unchecked")
	public CompteCategorie getCompteCategorieFromCategorie(int categorieId)
	{
        log.debug("********** Debut getCompteCategorie CompteCategorieDAO **********");
        try
        {
		     CompteCategorie compteCategorie=null;
		     List<CompteCategorie> compteCategories=null;
			    Session session = SessionFactoryUtil.getInstance().openSession();
		    	String strQuery = "select distinct compteCategorie ";
		    	strQuery+="from CompteCategorie compteCategorie";
		    	strQuery+=" where compteCategorie.statut = "+STATUT_VALIDE;
		    	strQuery+=" and compteCategorie.categorie.categorieId = "+categorieId;
		    	strQuery+=" order by compteCategorie.compteCategorieId asc";
		    	org.hibernate.Query query=session.createQuery(strQuery);
		    	compteCategories = query.list();
		    	if (compteCategories.size()>0) compteCategorie=compteCategories.get(0);
		     return compteCategorie;
        }
        catch(Exception e)
        {
        	e.printStackTrace();
        	log.fatal(e.getMessage());
        	return null;
        }
        finally
        {
            log.debug("********** Fin getCompteCategorie CompteCategorieDAO **********");
        }
	}
	
	public void saveCompteCategorie(CompteCategorie compteCategorie)
	{
        log.debug("********** Debut saveCompteCategorie CompteCategorieDAO **********");
        try
        {
		     Session session = SessionFactoryUtil.getInstance().openSession();
		     compteCategorie.setStatut(STATUT_SUPPRIME);
		     session.save(compteCategorie);
		     
        }
        catch(Exception e)
        {
             e.printStackTrace();
             log.fatal(e.getMessage());
        }
        finally
        {
            log.debug("********** Fin saveCompteCategorie CompteCategorieDAO **********");
        }
	}
	public void updateCompteCategorie(CompteCategorie compteCategorie)
	{
        log.debug("********** Debut updateCompteCategorie CompteCategorieDAO **********");
        try
        {
		     Session session = SessionFactoryUtil.getInstance().openSession();
		     session.update(compteCategorie);
        }
        catch(Exception e)
        {
        	e.printStackTrace();
        	log.fatal(e.getMessage());
        }
        finally
        {
            log.debug("********** Fin updateCompteCategorie CompteCategorieDAO **********");
        }
	}
	public void deleteCompteCategorie(CompteCategorie compteCategorie)
	{
        log.debug("********** Debut deleteCompteCategorie CompteCategorieDAO **********");
        try
        {
		     Session session = SessionFactoryUtil.getInstance().openSession();
		     compteCategorie.setStatut(STATUT_SUPPRIME);
		     session.update(compteCategorie);
        }
        catch(Exception e)
        {
        	e.printStackTrace();
        	log.fatal(e.getMessage());
        }
        finally
        {
            log.debug("********** Fin deleteCompteCategorie CompteCategorieDAO **********");
        }
	}
	
	@SuppressWarnings({ "unchecked"})
	public List<CompteCategorie> listCompteCategories() 
	{
        log.debug("********** Debut listCompteCategories CompteCategorieDAO **********");
		try 
	    {
			List<CompteCategorie> compteCategories=null;
		    Session session = SessionFactoryUtil.getInstance().openSession();
	    	String strQuery = "select distinct compteCategorie ";
	    	strQuery+="from CompteCategorie compteCategorie";
	    	strQuery+="where compteCategorie.statut = "+STATUT_VALIDE;
	    	strQuery+=" order by compteCategorie.compteCategorieId asc";
	    	org.hibernate.Query query=session.createQuery(strQuery);
	    	compteCategories = query.list();
	    	return compteCategories;
	    } 
	    catch (Exception e) 
	    {
	    	e.printStackTrace();
	    	log.fatal(e.getMessage());
	    	return null;
	    }
	    finally
	    {
	        log.debug("********** Fin listCompteCategories CompteCategorieDAO **********");
	    }
	}
	
	@SuppressWarnings({ "unchecked"})
	public List<CompteCategorie> listCompteCategoriesSupprimees() 
	{
        log.debug("********** Debut listCompteCategoriesSupprimees CompteCategorieDAO **********");
		try 
	    {
			List<CompteCategorie> compteCategoriesSupprimees=null;
		    Session session = SessionFactoryUtil.getInstance().openSession();
	    	String strQuery = "select distinct compteCategorie ";
	    	strQuery+="from CompteCategorie compteCategorie";
	    	strQuery+="where compteCategorie.statut = "+STATUT_SUPPRIME;
	    	strQuery+=" order by compteCategorie.compteCategorieId asc";
	    	org.hibernate.Query query=session.createQuery(strQuery);
	    	compteCategoriesSupprimees = query.list();
	    	return compteCategoriesSupprimees;
	    } 
	    catch (Exception e) 
	    {
	    	e.printStackTrace();
	    	log.fatal(e.getMessage());
	    	return null;
	    }
	    finally
	    {
	        log.debug("********** Fin listCompteCategoriesSupprimees CompteCategorieDAO **********");
	    }
	}
	
	}
