package clinique.dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Session;

import clinique.mapping.Acteur;
import clinique.mapping.Compte;

import clinique.utils.ConstantesMetier;

public class CompteDAO implements ConstantesMetier {
	
	private static Logger log = Logger.getLogger(CompteDAO.class);
	private static final CompteDAO INSTANCE = new CompteDAO();

	public static CompteDAO getInstance() {
		  return INSTANCE;
		 }

	private CompteDAO () {}
	public Compte getCompte(String compteId)
	{
        log.debug("********** Debut getCompte CompteDAO **********");
        try
        {
		     Compte compte=null;
		     Session session = SessionFactoryUtil.getInstance().openSession();
		     compte = (Compte) session.get(Compte.class, compteId);
		     return compte;
        }
        catch(Exception e)
        {
        	e.printStackTrace();
        	log.fatal(e.getMessage());
        	return null;
        }
        finally
        {
            log.debug("********** Fin getCompte CompteDAO **********");
        }
	}
	
	@SuppressWarnings("unchecked")
	public Compte getCompteFromActeur(Acteur acteur)
	{
        log.debug("********** Debut getCompte CompteDAO **********");
        try
        {
		     Compte compte=null;
		     List<Compte> comptes=null;
			    Session session = SessionFactoryUtil.getInstance().openSession();
		    	String strQuery = "select distinct compte ";
		    	strQuery+="from Compte compte";
		    	strQuery+=" where compte.statut = "+STATUT_VALIDE;
		    	strQuery+=" and compte.personnel.acteur.acteurId = "+acteur.getActeurId();
		    	strQuery+=" order by compte.compteId asc";
		    	org.hibernate.Query query=session.createQuery(strQuery);
		    	comptes = query.list();
		    	if (comptes.size()>0) compte=comptes.get(0);
		     return compte;
        }
        catch(Exception e)
        {
        	e.printStackTrace();
        	log.fatal(e.getMessage());
        	return null;
        }
        finally
        {
            log.debug("********** Fin getCompte CompteDAO **********");
        }
	}
	
	public void saveCompte(Compte compte)
	{
        log.debug("********** Debut saveCompte CompteDAO **********");
        try
        {
		     Session session = SessionFactoryUtil.getInstance().openSession();
		     compte.setStatut(STATUT_SUPPRIME);
		     session.save(compte);
		     
        }
        catch(Exception e)
        {
             e.printStackTrace();
             log.fatal(e.getMessage());
        }
        finally
        {
            log.debug("********** Fin saveCompte CompteDAO **********");
        }
	}
	public void updateCompte(Compte compte)
	{
        log.debug("********** Debut updateCompte CompteDAO **********");
        try
        {
		     Session session = SessionFactoryUtil.getInstance().openSession();
		     session.update(compte);
        }
        catch(Exception e)
        {
        	e.printStackTrace();
        	log.fatal(e.getMessage());
        }
        finally
        {
            log.debug("********** Fin updateCompte CompteDAO **********");
        }
	}
	public void deleteCompte(Compte compte)
	{
        log.debug("********** Debut deleteCompte CompteDAO **********");
        try
        {
		     Session session = SessionFactoryUtil.getInstance().openSession();
		     compte.setStatut(STATUT_SUPPRIME);
		     session.update(compte);
        }
        catch(Exception e)
        {
        	e.printStackTrace();
        	log.fatal(e.getMessage());
        }
        finally
        {
            log.debug("********** Fin deleteCompte CompteDAO **********");
        }
	}
	
	@SuppressWarnings({ "unchecked"})
	public List<Compte> listComptes() 
	{
        log.debug("********** Debut listComptes CompteDAO **********");
		try 
	    {
			List<Compte> comptes=null;
		    Session session = SessionFactoryUtil.getInstance().openSession();
	    	String strQuery = "select distinct compte ";
	    	strQuery+="from Compte compte";
	    	strQuery+="where compte.statut = "+STATUT_VALIDE;
	    	strQuery+=" order by compte.compteId asc";
	    	org.hibernate.Query query=session.createQuery(strQuery);
	    	comptes = query.list();
	    	return comptes;
	    } 
	    catch (Exception e) 
	    {
	    	e.printStackTrace();
	    	log.fatal(e.getMessage());
	    	return null;
	    }
	    finally
	    {
	        log.debug("********** Fin listComptes CompteDAO **********");
	    }
	}
	
	@SuppressWarnings({ "unchecked"})
	public List<Compte> listComptesSupprimees() 
	{
        log.debug("********** Debut listComptesSupprimees CompteDAO **********");
		try 
	    {
			List<Compte> comptesSupprimees=null;
		    Session session = SessionFactoryUtil.getInstance().openSession();
	    	String strQuery = "select distinct compte ";
	    	strQuery+="from Compte compte";
	    	strQuery+="where compte.statut = "+STATUT_SUPPRIME;
	    	strQuery+=" order by compte.compteId asc";
	    	org.hibernate.Query query=session.createQuery(strQuery);
	    	comptesSupprimees = query.list();
	    	return comptesSupprimees;
	    } 
	    catch (Exception e) 
	    {
	    	e.printStackTrace();
	    	log.fatal(e.getMessage());
	    	return null;
	    }
	    finally
	    {
	        log.debug("********** Fin listComptesSupprimees CompteDAO **********");
	    }
	}
	
	}
