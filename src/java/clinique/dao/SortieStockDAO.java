package clinique.dao;

import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Session;

import clinique.mapping.SortieStock;
import clinique.utils.ConstantesMetier;

public class SortieStockDAO implements ConstantesMetier {
	
	private static Logger log = Logger.getLogger(SortieStockDAO.class);
	private static final SortieStockDAO INSTANCE = new SortieStockDAO();

	public static SortieStockDAO getInstance() {
		  return INSTANCE;
		 }

	private SortieStockDAO () {}
	public SortieStock getSortieStock(int sortieStockId)
	{
		     log.debug("********** Debut getSortieStock SortieStockDAO **********");
		     
		     try
		     {
		     SortieStock sortieStock=null;
		     Session session = SessionFactoryUtil.getInstance().openSession();
		     sortieStock = (SortieStock) session.get(SortieStock.class, sortieStockId);
		     return sortieStock;
		     }
		     catch(Exception e)
		     {
		       e.printStackTrace();
		       log.fatal(e.getMessage());
		       return null;
		     }
		     finally
		     {
			     log.debug("********** Fin getSortieStock SortieStockDAO **********");
		     }
	}
    public void saveSortieStock(SortieStock sortieStock)
	{
	     log.debug("********** Debut saveSortieStock SortieStockDAO **********");
             try
             {
		     Session session = SessionFactoryUtil.getInstance().openSession();
		     sortieStock.setStatut(STATUT_VALIDE);
		     session.save(sortieStock);
             }
             catch(Exception e)
             {
            	 e.printStackTrace();
            	 log.fatal(e.getMessage());
             }
             finally
             {
        	     log.debug("********** Fin saveSortieStock SortieStockDAO **********");
             }

	}
	public void updateSortieStock(SortieStock sortieStock)
	{
	     log.debug("********** Debut updateSortieStock SortieStockDAO **********");
             try
             {
		     Session session = SessionFactoryUtil.getInstance().openSession();
		     session.update(sortieStock);
             }
             catch(Exception e)
             {
            	 e.printStackTrace();
            	 log.fatal(e.getMessage());
             }
             finally
             {
        	     log.debug("********** Fin updateSortieStock SortieStockDAO **********");
             }
	}
	public void deleteSortieStock(SortieStock sortieStock)
	{
	         log.debug("********** Debut deleteSortieStock SortieStockDAO **********");
             try
             {
		     Session session = SessionFactoryUtil.getInstance().openSession();
		     sortieStock.setStatut(STATUT_SUPPRIME);
		     session.update(sortieStock);
             }
             catch(Exception e)
             {
            	 e.printStackTrace();
            	 log.fatal(e.getMessage());
             }
             finally
             {
    	         log.debug("********** Fin deleteSortieStock SortieStockDAO **********");
             }
	}
	@SuppressWarnings("unchecked")
	public SortieStock getSortieStockByProduitAndDateAndQuantite(int ProduitId,Date dateSortie,int quantite) 
	{
        log.debug("********** Debut getSortieStockByProduitAndDateAndQuantite SortieStockDAO **********");
        if(dateSortie==null)
        	return null;
		try 
	    {
			List<SortieStock> sortieStocks=null;
		    Session session = SessionFactoryUtil.getInstance().openSession();
	    	String strQuery = "select distinct sortieStock ";
	    	strQuery+="from SortieStock sortieStock";
	    	strQuery+=" where sortieStock.statut = "+STATUT_VALIDE;
	    	strQuery+=" and sortieStock.dateSortie = '"+dateSortie+"'";
	    	strQuery+=" and sortieStock.quantite = "+quantite;
	    	strQuery+=" order by sortieStock.sortieStockId asc";
	    	org.hibernate.Query query=session.createQuery(strQuery);
	    	sortieStocks = query.list();
	    	if(sortieStocks!=null && sortieStocks.size()>0)
	    		return sortieStocks.get(0);
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
	        log.debug("********** Fin getSortieStockByProduitAndDateAndQuantite SortieStockDAO **********");
	    }
	}
	@SuppressWarnings("unchecked")
	public List<SortieStock> listSortieStocks() 
	{
        log.debug("********** Debut listSortieStocks SortieStockDAO **********");

		try 
	    {
			List<SortieStock> sortieStocks=null;
		    Session session = SessionFactoryUtil.getInstance().openSession();
	    	String strQuery = "select distinct sortieStock ";
	    	strQuery+="from SortieStock sortieStock";
	    	strQuery+="where sortieStock.statut = "+STATUT_VALIDE;
	    	strQuery+=" order by sortieStock.sortieStockId asc";
	    	org.hibernate.Query query=session.createQuery(strQuery);
	    	sortieStocks = query.list();	
		    return sortieStocks;
	    } 
	    catch (Exception e) 
	    {
	    	e.printStackTrace();
	    	log.fatal(e.getMessage());
	    	return null;
	    }
	    finally
	    {
	        log.debug("********** Fin listSortieStocks SortieStockDAO **********");
	    }
	}
	@SuppressWarnings({ "unchecked"})
	public List<SortieStock> listProduitsSupprimes() 
	{
        log.debug("********** Debut listSortieStocksSupprimes SortieStockDAO **********");

		try 
	    {
			List<SortieStock> sortieStocks=null;
		    Session session = SessionFactoryUtil.getInstance().openSession();
	    	String strQuery = "select distinct sortieStock ";
	    	strQuery+="from SortieStock sortieStock";
	    	strQuery+="where sortieStock.statut = "+STATUT_SUPPRIME;
	    	strQuery+=" order by sortieStock.sortieStockId asc";
	    	org.hibernate.Query query=session.createQuery(strQuery);
	    	sortieStocks = query.list();	
		    return sortieStocks;
	    } 
	    catch (Exception e) 
	    {
	    	e.printStackTrace();
	    	log.fatal(e.getMessage());
	    	return null;
	    }
	    finally
	    {
	        log.debug("********** Debut listSortieStocksSupprimes SortieStockDAO **********");
	    }
	}



}
