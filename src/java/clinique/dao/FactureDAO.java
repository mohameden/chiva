package clinique.dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Session;

import clinique.mapping.Facture;
import clinique.mapping.Patient;
import clinique.utils.ConstantesMetier;
import clinique.utils.UtilDate;

public class FactureDAO implements ConstantesMetier {
	
	private static Logger log = Logger.getLogger(FactureDAO.class);
	private static final FactureDAO INSTANCE = new FactureDAO();

	public static FactureDAO getInstance() {
		  return INSTANCE;
		 }

	private FactureDAO () {}
	public Facture getFacture(String factureId)
	{
        log.debug("********** Debut getFacture FactureDAO **********");
        try
        {
		     Facture facture=null;
		     Session session = SessionFactoryUtil.getInstance().openSession();
		     facture = (Facture) session.get(Facture.class, factureId);
		     return facture;
        }
        catch(Exception e)
        {
        	e.printStackTrace();
        	log.fatal(e.getMessage());
        	return null;
        }
        finally
        {
            log.debug("********** Fin getFacture FactureDAO **********");
        }
	}
	public void saveFacture(Facture facture)
	{
        log.debug("********** Debut saveFacture FactureDAO **********");
        try
        {
		     Session session = SessionFactoryUtil.getInstance().openSession();
		     facture.setStatut(STATUT_SUPPRIME);
		     session.save(facture);
		     
        }
        catch(Exception e)
        {
             e.printStackTrace();
             log.fatal(e.getMessage());
        }
        finally
        {
            log.debug("********** Fin saveFacture FactureDAO **********");
        }
	}
	public void updateFacture(Facture facture)
	{
        log.debug("********** Debut updateFacture FactureDAO **********");
        try
        {
		     Session session = SessionFactoryUtil.getInstance().openSession();
		     session.update(facture);
        }
        catch(Exception e)
        {
        	e.printStackTrace();
        	log.fatal(e.getMessage());
        }
        finally
        {
            log.debug("********** Fin updateFacture FactureDAO **********");
        }
	}
	public void deleteFacture(Facture facture)
	{
        log.debug("********** Debut deleteFacture FactureDAO **********");
        try
        {
		     Session session = SessionFactoryUtil.getInstance().openSession();
		     facture.setStatut(STATUT_SUPPRIME);
		     session.update(facture);
        }
        catch(Exception e)
        {
        	e.printStackTrace();
        	log.fatal(e.getMessage());
        }
        finally
        {
            log.debug("********** Fin deleteFacture FactureDAO **********");
        }
	}
	@SuppressWarnings({ "unchecked"})
	public List<Facture> listFacturesReglements() 
	{
        log.debug("********** Debut listFacturesReglements FactureDAO **********");
		try 
	    {
			List<Facture> facturesReglements=null;
		    Session session = SessionFactoryUtil.getInstance().openSession();
	    	String strQuery = "select distinct facture ";
	    	strQuery+="from Facture facture, Reglement reglement";
	    	strQuery+="where facture.factureId = reglement.facture.factureId ";
	    	strQuery+="and facture.statut = "+STATUT_VALIDE;
	    	strQuery+=" and reglement.statut = "+STATUT_VALIDE;
	    	strQuery+=" order by facture.factureId asc";
	    	org.hibernate.Query query=session.createQuery(strQuery);
	    	facturesReglements = query.list();
	    	return facturesReglements;
	    } 
	    catch (Exception e) 
	    {
	    	e.printStackTrace();
	    	log.fatal(e.getMessage());
	    	return null;
	    }
	    finally
	    {
	        log.debug("********** Fin listFacturesReglements FactureDAO **********");
	    }
	}
	@SuppressWarnings({ "unchecked"})
	public List<Facture> listFactures() 
	{
        log.debug("********** Debut listFactures FactureDAO **********");
		try 
	    {
			List<Facture> factures=null;
		    Session session = SessionFactoryUtil.getInstance().openSession();
	    	String strQuery = "select distinct facture ";
	    	strQuery+="from Facture facture";
	    	strQuery+="where facture.statut = "+STATUT_VALIDE;
	    	strQuery+=" order by facture.factureId asc";
	    	org.hibernate.Query query=session.createQuery(strQuery);
	    	factures = query.list();
	    	return factures;
	    } 
	    catch (Exception e) 
	    {
	    	e.printStackTrace();
	    	log.fatal(e.getMessage());
	    	return null;
	    }
	    finally
	    {
	        log.debug("********** Fin listFactures FactureDAO **********");
	    }
	}
	
	@SuppressWarnings({ "unchecked"})
	public List<Facture> listFacturesNoException(String date1,String date2) 
	{
        log.debug("********** Debut listFactures FactureDAO **********");
		try 
	    {
			
			List<Facture> factures=null;
		    Session session = SessionFactoryUtil.getInstance().openSession();
	    	String strQuery = "select distinct facture ";
	    	strQuery+="from Facture facture ";
	    	strQuery+="where facture.statut = "+STATUT_VALIDE;
	    	strQuery+=" and facture.isException = "+STATUT_SUPPRIME;
	    	strQuery+=" and facture.dateFact between '"+
	    	UtilDate.getInstance().stringToDateMysql(date1) +"' and '"+
	    	UtilDate.getInstance().stringToDateMysql(date2)+"'";
	    	strQuery+=" order by facture.factureId asc";
	    	System.out.println(strQuery);
	    	org.hibernate.Query query=session.createQuery(strQuery);
	    	factures = query.list();
	    	return factures;
	    } 
	    catch (Exception e) 
	    {
	    	e.printStackTrace();
	    	log.fatal(e.getMessage());
	    	return null;
	    }
	    finally
	    {
	        log.debug("********** Fin listFactures FactureDAO **********");
	    }
	}
	
	@SuppressWarnings({ "unchecked"})
	public List<Facture> listFacturesSupprimees() 
	{
        log.debug("********** Debut listFacturesSupprimees FactureDAO **********");
		try 
	    {
			List<Facture> facturesSupprimees=null;
		    Session session = SessionFactoryUtil.getInstance().openSession();
	    	String strQuery = "select distinct facture ";
	    	strQuery+="from Facture facture";
	    	strQuery+="where facture.statut = "+STATUT_SUPPRIME;
	    	strQuery+=" order by facture.factureId asc";
	    	org.hibernate.Query query=session.createQuery(strQuery);
	    	facturesSupprimees = query.list();
	    	return facturesSupprimees;
	    } 
	    catch (Exception e) 
	    {
	    	e.printStackTrace();
	    	log.fatal(e.getMessage());
	    	return null;
	    }
	    finally
	    {
	        log.debug("********** Fin listFacturesSupprimees FactureDAO **********");
	    }
	}
	
	
	@SuppressWarnings("unchecked")
	public List<Facture> listFacturesAimprimer(String date1,String date2) 
	{
        log.debug("********** Debut listFactures FactureDAO **********");
		try 
	    {
			
			List<Facture> factures=null;
		    Session session = SessionFactoryUtil.getInstance().openSession();
	    	String strQuery = "select distinct facture ";
	    	strQuery+="from Facture facture ";
	    	strQuery+=" where facture.statut = "+STATUT_VALIDE;
	    	strQuery+=" and facture.dateFact between '"+
	    	UtilDate.getInstance().stringToDateMysql(date1) +"' and '"+
	    	UtilDate.getInstance().stringToDateMysql(date2)+"'";
	    	strQuery+=" order by facture.factureId asc";
	    	System.out.println(strQuery);
	    	org.hibernate.Query query=session.createQuery(strQuery);
	    	factures = query.list();
	    	return factures;
	    } 
	    catch (Exception e) 
	    {
	    	e.printStackTrace();
	    	log.fatal(e.getMessage());
	    	return null;
	    }
	    finally
	    {
	        log.debug("********** Fin listFactures FactureDAO **********");
	    }
	}
	
	}
