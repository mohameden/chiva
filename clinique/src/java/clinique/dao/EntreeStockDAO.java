package clinique.dao;

import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Session;

import clinique.mapping.EntreeStock;
import clinique.utils.ConstantesMetier;

public class EntreeStockDAO implements ConstantesMetier{
	
	private static Logger log = Logger.getLogger(EntreeStockDAO.class);
	private static final EntreeStockDAO INSTANCE = new EntreeStockDAO();

	public static EntreeStockDAO getInstance() {
		  return INSTANCE;
		 }

	private EntreeStockDAO () {}
	public EntreeStock getEntreeStock(int entreeStockId)
	{
		     log.debug("********** Debut getEntreeStock EntreeStockDAO **********");
		     
		     try
		     {
		     EntreeStock entreeStock=null;
		     Session session = SessionFactoryUtil.getInstance().openSession();
		     entreeStock = (EntreeStock) session.get(EntreeStock.class, entreeStockId);
		     return entreeStock;
		     }
		     catch(Exception e)
		     {
		       e.printStackTrace();
		       log.fatal(e.getMessage());
		       return null;
		     }
		     finally
		     {
			     log.debug("********** Fin getEntreeStock EntreeStockDAO **********");
		     }
	}
    public void saveEntreeStock(EntreeStock entreeStock)
	{
	     log.debug("********** Debut saveEntreeStock EntreeStockDAO **********");
             try
             {
		     Session session = SessionFactoryUtil.getInstance().openSession();
		     entreeStock.setStatut(STATUT_VALIDE);
		     session.save(entreeStock);
             }
             catch(Exception e)
             {
            	 e.printStackTrace();
            	 log.fatal(e.getMessage());
             }
             finally
             {
        	     log.debug("********** Fin saveEntreeStock EntreeStockDAO **********");
             }

	}
	public void updateEntreeStock(EntreeStock entreeStock)
	{
	     log.debug("********** Debut updateEntreeStock EntreeStockDAO **********");
             try
             {
		     Session session = SessionFactoryUtil.getInstance().openSession();
		     session.update(entreeStock);
             }
             catch(Exception e)
             {
            	 e.printStackTrace();
            	 log.fatal(e.getMessage());
             }
             finally
             {
        	     log.debug("********** Fin updateEntreeStock EntreeStockDAO **********");
             }
	}
	public void deleteEntreeStock(EntreeStock entreeStock)
	{
	         log.debug("********** Debut deleteEntreeStock EntreeStockDAO **********");
             try
             {
		     Session session = SessionFactoryUtil.getInstance().openSession();
		     entreeStock.setStatut(STATUT_SUPPRIME);
		     session.update(entreeStock);
             }
             catch(Exception e)
             {
            	 e.printStackTrace();
            	 log.fatal(e.getMessage());
             }
             finally
             {
    	         log.debug("********** Fin deleteEntreeStock EntreeStockDAO **********");
             }
	}
	@SuppressWarnings("unchecked")
	public EntreeStock getEntreeStockByProduitAndDateAndFournisseur(int produitId,Date dateEntree,int fournisseurId) 
	{
        log.debug("********** Debut getEntreeStockByProduitAndDateAndFournisseur EntreeStockDAO **********");
        if((dateEntree==null))
        	return null;
		try 
	    {
			List<EntreeStock> entreeStocks=null;
		    Session session = SessionFactoryUtil.getInstance().openSession();
	    	String strQuery = "select distinct entreeStock ";
	    	strQuery+="from EntreeStock entreeStock";
	    	strQuery+=" where entreeStock.statut = "+STATUT_VALIDE;
	    	strQuery+=" and entreeStock.produit.produitId = "+produitId;
	    	strQuery+=" and entreeStock.dateEntree = '"+dateEntree+"'";
	    	strQuery+=" and entreeStock.fournisseur.fournisseurId = "+fournisseurId;
	    	strQuery+=" order by entreeStock.entreeStockId asc";
	    	org.hibernate.Query query=session.createQuery(strQuery);
	    	entreeStocks = query.list();
	    	if(entreeStocks!=null && entreeStocks.size()>0)
	    		return entreeStocks.get(0);
		    return null;
	    } 
	    catch (Exception e) 
	    {
	    	e.printStackTrace();
	    	log.fatal(e.getMessage());
	    	return null;
	    }
	    finally
	    {
	        log.debug("********** Fin getEntreeStockByProduitAndDateAndFournisseur EntreeStockDAO **********");
	    }
	}
	@SuppressWarnings("unchecked")
	public List<EntreeStock> listEntreeStocks() 
	{
        log.debug("********** Debut listEntreeStocks EntreeStockDAO **********");

		try 
	    {
			List<EntreeStock> entreeStocks=null;
		    Session session = SessionFactoryUtil.getInstance().openSession();
	    	String strQuery = "select distinct entreeStock ";
	    	strQuery+="from EntreeStock entreeStock";
	    	strQuery+="where entreeStock.statut = "+STATUT_VALIDE;
	    	strQuery+=" order by entreeStock.entreeStockId asc";
	    	org.hibernate.Query query=session.createQuery(strQuery);
	    	entreeStocks = query.list();	
		    return entreeStocks;
	    } 
	    catch (Exception e) 
	    {
	    	e.printStackTrace();
	    	log.fatal(e.getMessage());
	    	return null;
	    }
	    finally
	    {
	        log.debug("********** Fin listEntreeStocks EntreeStockDAO **********");
	    }
	}
	@SuppressWarnings({ "unchecked"})
	public List<EntreeStock> listProduitsSupprimes() 
	{
        log.debug("********** Debut listEntreeStocksSupprimes EntreeStockDAO **********");

		try 
	    {
			List<EntreeStock> entreeStocks=null;
		    Session session = SessionFactoryUtil.getInstance().openSession();
	    	String strQuery = "select distinct entreeStock ";
	    	strQuery+="from EntreeStock entreeStock";
	    	strQuery+="where entreeStock.statut = "+STATUT_SUPPRIME;
	    	strQuery+=" order by entreeStock.entreeStockId asc";
	    	org.hibernate.Query query=session.createQuery(strQuery);
	    	entreeStocks = query.list();	
		    return entreeStocks;
	    } 
	    catch (Exception e) 
	    {
	    	e.printStackTrace();
	    	log.fatal(e.getMessage());
	    	return null;
	    }
	    finally
	    {
	        log.debug("********** Debut listEntreeStocksSupprimes EntreeStockDAO **********");
	    }
	}


}
