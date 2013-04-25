package clinique.dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Session;

import clinique.mapping.Assureur;
import clinique.utils.ConstantesMetier;

public class AssureurDAO implements ConstantesMetier {
	
	private static Logger log = Logger.getLogger(AssureurDAO.class);
	private static final AssureurDAO INSTANCE = new AssureurDAO();

	public static AssureurDAO getInstance() {
		  return INSTANCE;
		 }

	private AssureurDAO () {}
	public Assureur getAssureur(int assureurId)
	{
	     log.debug("********** Debut getAssureur AssureurDAO **********");
		try
		{
		     Assureur assureur=null;
		     Session session = SessionFactoryUtil.getInstance().openSession();
		     assureur = (Assureur) session.get(Assureur.class, assureurId);
		     return assureur;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			log.fatal(e.getMessage());
			return null;
		}
		finally
		{
		     log.debug("********** Fin getAssureur AssureurDAO **********");
		}
	}
	public void saveAssureur(Assureur assureur)
	{
	     log.debug("********** Debut saveAssureur AssureurDAO **********");
		try
		{
		     Session session = SessionFactoryUtil.getInstance().openSession();
		     session.save(assureur);
		}
		catch(Exception e)
		{
			e.printStackTrace();
			log.fatal(e.getMessage());
		}
		finally
		{
		     log.debug("********** Fin saveAssureur AssureurDAO **********");
		}
	}
	public void updateAssureur(Assureur assureur)
	{
	     log.debug("********** Debut updateAssureur AssureurDAO **********");
		try
		{
		     Session session = SessionFactoryUtil.getInstance().openSession();
		     session.update(assureur);
		}
		catch(Exception e)
		{
			e.printStackTrace();
			log.fatal(e.getMessage());
		}
		finally
		{
		     log.debug("********** Fin updateAssureur AssureurDAO **********");
		}
	}
	public void deleteAssureur(Assureur assureur)
	{
	     log.debug("********** Debut deleteAssureur AssureurDAO **********");
		try
		{
		     Session session = SessionFactoryUtil.getInstance().openSession();
		     assureur.setStatut(STATUT_SUPPRIME);
		     session.update(assureur);
		}
		catch(Exception e)
		{
			e.printStackTrace();
			log.fatal(e.getMessage());
		}
		finally
		{
		     log.debug("********** Fin deleteAssureur AssureurDAO **********");
		}
	}
	@SuppressWarnings({ "unchecked"})
	public List<Assureur> listAssureursCategories() 
	{
	    log.debug("********** Debut listAssureursCategories AssureurDAO **********");
		try 
	    {
			List<Assureur> assureursCategories=null;
		    Session session = SessionFactoryUtil.getInstance().openSession();
	    	String strQuery = "select distinct assureur ";
	    	strQuery+="from Assureur assureur, Entreprise entreprise, Categorie categorie ";
	    	strQuery+=" where assureur.assureurId = entreprise.Assureur.assureurId ";
	    	strQuery+=" and entreprise.entrepriseId = categorie.entrepriseId ";
	    	strQuery+=" and assureur.statut = "+STATUT_VALIDE;
	    	strQuery+=" and entreprise.statut = "+STATUT_VALIDE;
	    	strQuery+=" and categorie.statut = "+STATUT_VALIDE;
	    	strQuery+=" order by assureur.assureurId asc";
	    	org.hibernate.Query query=session.createQuery(strQuery);
	    	assureursCategories = query.list();
	    	return assureursCategories;
	    } 
	    catch (Exception e) 
	    {
	    	e.printStackTrace();
	    	log.fatal(e.getMessage());
	    	return null;
	    }
	    finally
	    {
		    log.debug("********** Fin listAssureursCategories AssureurDAO **********");
	    }
	}
	@SuppressWarnings({ "unchecked"})
	public List<Assureur> listAssureursBlackListes() 
	{
	    log.debug("********** Debut listAssureursBlackListes AssureurDAO **********");
		try 
	    {
			List<Assureur> assureursBlackListes=null;
		    Session session = SessionFactoryUtil.getInstance().openSession();
	    	String strQuery = "select distinct assureur ";
	    	strQuery+="from Assureur assureur, BlackListe blackListe ";
	    	strQuery+=" where assureur.assureurId = blackListe.assureur.assureurId ";
	    	strQuery+=" and assureur.statut = "+STATUT_VALIDE;
	    	strQuery+=" and blackListe.statut = "+STATUT_VALIDE;
	    	strQuery+=" order by assureur.assureurId asc";
	    	org.hibernate.Query query=session.createQuery(strQuery);
	    	assureursBlackListes = query.list();	
	    	return assureursBlackListes;
	    } 
	    catch (Exception e) 
	    {
	    	e.printStackTrace();
	    	log.fatal(e.getMessage());
	    	return null;
	    }
	    finally
	    {
		    log.debug("********** Fin listAssureursBlackListes AssureurDAO **********");
	    }
	}
	@SuppressWarnings({ "unchecked"})
	public List<Assureur> listAssureursEntreprises() 
	{
	    log.debug("********** Debut listAssureursEntreprises AssureurDAO **********");
		try 
	    {
			List<Assureur> assureursEntreprises=null;
		    Session session = SessionFactoryUtil.getInstance().openSession();
	    	String strQuery = "select distinct assureur ";
	    	strQuery+="from Assureur assureur, Entreprise entreprise ";
	    	strQuery+=" where assureur.assureurId = entreprise.assureur.assureurId ";
	    	strQuery+=" and assureur.statut = "+STATUT_VALIDE;
	    	strQuery+=" and entreprise.statut = "+STATUT_VALIDE;
	    	strQuery+=" order by assureur.assureurId asc";
	    	org.hibernate.Query query=session.createQuery(strQuery);
	    	assureursEntreprises = query.list();	    
	    	return assureursEntreprises;
	    } 
	    catch (Exception e) 
	    {
	    	e.printStackTrace();
	    	log.fatal(e.getMessage());
	    	return null;
	    }
	    finally
	    {
		    log.debug("********** Fin listAssureursEntreprises AssureurDAO **********");
	    }
	}
	@SuppressWarnings({ "unchecked"})
	public List<Assureur> listAssureurs() 
	{
	    log.debug("********** Debut listAssureurs AssureurDAO **********");
		try 
	    {
			List<Assureur> assureurs=null;
		    Session session = SessionFactoryUtil.getInstance().openSession();
	    	String strQuery = "select distinct assureur ";
	    	strQuery+="from Assureur assureur";
	    	strQuery+=" where assureur.statut = "+STATUT_VALIDE;
	    	strQuery+=" order by assureur.assureurId asc";
	    	org.hibernate.Query query=session.createQuery(strQuery);
	    	assureurs = query.list();	  
	    	return assureurs;
	    } 
	    catch (Exception e) 
	    {
	    	e.printStackTrace();
	    	log.fatal(e.getMessage());
	    	return null;
	    }
	    finally
	    {
		    log.debug("********** Fin listAssureurs AssureurDAO **********");
	    }
	}
	@SuppressWarnings({ "unchecked"})
	public List<Assureur> listAssureursSupprimes() 
	{
	    log.debug("********** Debut listAssureursSupprimes AssureurDAO **********");
		try 
	    {
			List<Assureur> assureurs=null;
		    Session session = SessionFactoryUtil.getInstance().openSession();
	    	String strQuery = "select distinct assureur ";
	    	strQuery+="from Assureur assureur";
	    	strQuery+=" where assureur.statut = "+STATUT_SUPPRIME;
	    	strQuery+=" order by assureur.assureurId asc";
	    	org.hibernate.Query query=session.createQuery(strQuery);
	    	assureurs = query.list();
	    	return assureurs;
	    } 
	    catch (Exception e) 
	    {
	    	e.printStackTrace();
	    	log.fatal(e.getMessage());
	     	return null;

	    }
	    finally
	    {
		    log.debug("********** Fin listAssureursSupprimes AssureurDAO **********");
	    }
	}
}
