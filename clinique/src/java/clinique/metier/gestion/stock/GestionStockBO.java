package clinique.metier.gestion.stock;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.apache.log4j.Logger;
import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionMessages;
import org.apache.struts.util.LabelValueBean;
import org.hibernate.Session;
import org.hibernate.Transaction;

import clinique.dao.ClasseDAO;
import clinique.dao.EntreeStockDAO;
import clinique.dao.FournisseurDAO;
import clinique.dao.ProduitDAO;
import clinique.dao.QueryDao;
import clinique.dao.SessionFactoryUtil;
import clinique.dao.SortieStockDAO;
import clinique.mapping.Classe;
import clinique.mapping.EntreeStock;
import clinique.mapping.Fournisseur;
import clinique.mapping.JournalDuStock;
import clinique.mapping.Produit;
import clinique.mapping.SortieStock;
import clinique.model.gestion.stock.GestionStockForm;
import clinique.utils.ConstantesMetier;
import clinique.utils.UtilDate;

public class GestionStockBO implements ConstantesMetier {
	
	private static Logger log = Logger.getLogger(GestionStockBO.class);

	
	private ActionMessages errors=new ActionMessages();

	public ActionMessages getErrors() {
		return errors;
	}

	public void setErrors(ActionMessages errors) {
		this.errors = errors;
	}
	
	public String saveFounisseur(GestionStockForm formulaire)
	{
	     log.debug("********** Debut saveFounisseur GestionStockBO **********");
	     Session session=SessionFactoryUtil.getInstance().openSession();
	     Transaction trx=null;
		 Fournisseur fournisseur=new Fournisseur();
		 FournisseurDAO fournisseurDAO=FournisseurDAO.getInstance();
		try
		{
	    trx=session.beginTransaction();
		fournisseur.setNomFournisseur(formulaire.getNomFournisseur());
		fournisseur.setAdresse(formulaire.getAdresseFournisseur());
		if(formulaire.getTelephone1Fournisseur()!=null && !formulaire.getTelephone1Fournisseur().trim().equals(""))
		{
		   int tel1=Integer.parseInt(formulaire.getTelephone1Fournisseur().trim());
		fournisseur.setTelephone1(tel1);
		}
		if(formulaire.getTelephone2Fournisseur()!=null && !formulaire.getTelephone2Fournisseur().trim().equals(""))
		{
			int tel2=Integer.parseInt(formulaire.getTelephone2Fournisseur().trim());
			fournisseur.setTelephone2(tel2);
		}
		fournisseur.setOperateur(formulaire.getOperateur());
		fournisseurDAO.saveFournisseur(fournisseur);
		trx.commit();
		return "true";
		}
		catch(Exception e)
		{
			e.printStackTrace();
			log.fatal(e.getMessage());
			if(trx!=null)
			{
				trx.rollback();
			}
			return "false";
			
		}
		finally
		{
			 session.close();
			 fournisseur=null;
		     log.debug("********** Fin saveFounisseur GestionStockBO **********");
		}
	}
	public String saveProduit(GestionStockForm formulaire)
	{
	     log.debug("********** Debut saveProduit GestionStockBO **********");
	     Session session=SessionFactoryUtil.getInstance().openSession();
	     Transaction trx=null;
		 Produit produit=new Produit();
		 ProduitDAO produitDAO=ProduitDAO.getInstance();
		 ClasseDAO classeDAO=ClasseDAO.getInstance();
		 Classe classe=null;
		try
		{
	    trx=session.beginTransaction();
	    produit.setNomProduit(formulaire.getNomProduit());
	    produit.setOperateur(formulaire.getOperateur());
	    produit.setQuantiteDisponible(Integer.parseInt(formulaire.getQuantiteDisponibleProduit()));
	    produit.setSeuilMinimum(Integer.parseInt(formulaire.getSeuilMinimumProduit()));
	    if(formulaire.getFacturable().trim().equals("1"))
	    {
	    	produit.setFacturable(FACTURABLE);
		    produit.setPrix(Integer.parseInt(formulaire.getPrixProduit()));
	    }
	    else
	    {
	    	produit.setFacturable(NON_FACTURABLE);
	    }
	    if(formulaire.getClasseId()!=null && !formulaire.getClasseId().equals(""))
	    	classe=classeDAO.getClasse(Integer.parseInt(formulaire.getClasseId().trim()));
	    if(classe!=null)
	    	produit.setClasse(classe);
	    produitDAO.saveProduit(produit);
		trx.commit();
		return "true";
		}
		catch(Exception e)
		{
			e.printStackTrace();
			log.fatal(e.getMessage());
			if(trx!=null)
			{
				trx.rollback();
			}
			return "false";
			
		}
		finally
		{
			 session.close();
			 produit=null;
			 classe=null;
		     log.debug("********** Fin saveProduit GestionStockBO **********");
		}
	}
	public String saveEntreeStock(GestionStockForm formulaire)
	{
	     log.debug("********** Debut saveEntreeStock GestionStockBO **********");
	     Session session=SessionFactoryUtil.getInstance().openSession();
	     Transaction trx=null;
	     EntreeStockDAO entreeStockDAO=EntreeStockDAO.getInstance();
	     EntreeStock entreeStock=new EntreeStock();
		 Produit produit=null;
		 Produit produit1=null;
		 ProduitDAO produitDAO=ProduitDAO.getInstance();
		 Fournisseur fournisseur=null;
		 FournisseurDAO fournisseurDAO=FournisseurDAO.getInstance();
		try
		{
	    trx=session.beginTransaction();
	    entreeStock.setDateEntree(UtilDate.getInstance().stringToDate(formulaire.getDateStockEntree()));
	    entreeStock.setNumeroDestinataire(formulaire.getNumeroDestinataire());
	    entreeStock.setOperateur(formulaire.getOperateur());
	    entreeStock.setPrixUnitaire(Integer.parseInt(formulaire.getPrixUnitaireAchat()));
	    entreeStock.setQuantite(Integer.parseInt(formulaire.getQuantiteStockEntrante()));
	    if(formulaire.getProduitId()!=null && !formulaire.getProduitId().equals(""))
	    	produit=produitDAO.getProduit(Integer.parseInt(formulaire.getProduitId().trim()));
	    if(produit!=null)
	    	entreeStock.setProduit(produit);
	    if(formulaire.getFournisseurId()!=null && !formulaire.getFournisseurId().equals(""))
	    	fournisseur=fournisseurDAO.getFournisseur(Integer.parseInt(formulaire.getFournisseurId().trim()));
	    if(fournisseur!=null)
	    	entreeStock.setFournisseur(fournisseur);
	    entreeStockDAO.saveEntreeStock(entreeStock);
	    produit1=produitDAO.getProduit(Integer.parseInt(formulaire.getProduitId()));
	    if(produit1!=null)
	    {
	    	int quantiteDisponible=produit1.getQuantiteDisponible()+Integer.parseInt(formulaire.getQuantiteStockEntrante().trim());
	    	produit1.setQuantiteDisponible(quantiteDisponible);
	    	produitDAO.updateProduit(produit1);
	    }
		trx.commit();
		return "true";
		}
		catch(Exception e)
		{
			e.printStackTrace();
			log.fatal(e.getMessage());
			if(trx!=null)
			{
				trx.rollback();
			}
			return "false";
			
		}
		finally
		{
			 session.close();
			 entreeStock=null;
			 produit=null;
			 produit1=null;
			 fournisseur=null;
		     log.debug("********** Fin saveEntreeStock GestionStockBO **********");
		}
	}
	public String saveSortieStock(GestionStockForm formulaire)
	{
	     log.debug("********** Debut saveSortieStock GestionStockBO **********");
	     Session session=SessionFactoryUtil.getInstance().openSession();
	     Transaction trx=null;
	     SortieStockDAO sortieStockDAO=SortieStockDAO.getInstance();
	     SortieStock sortieStock=new SortieStock();
		 Produit produit=null;
		 Produit produit1=null;
		 ProduitDAO produitDAO=ProduitDAO.getInstance();
		try
		{
	    trx=session.beginTransaction();
	    sortieStock.setDateSortie(UtilDate.getInstance().stringToDate(formulaire.getDateStockEntree()));
	    sortieStock.setNumeroSource(Integer.parseInt(formulaire.getNumeroSource()));
	    sortieStock.setOperateur(formulaire.getOperateur());
	    sortieStock.setPrixUnitaire(Integer.parseInt(formulaire.getPrixProduit()));
	    sortieStock.setQuantite(Integer.parseInt(formulaire.getQuantiteStockSortie()));
	    if(formulaire.getProduitId()!=null && !formulaire.getProduitId().equals(""))
	    	produit=produitDAO.getProduit(Integer.parseInt(formulaire.getProduitId().trim()));
	    if(produit!=null)
	    	sortieStock.setProduit(produit);
	    sortieStockDAO.saveSortieStock(sortieStock);
	    produit1=produitDAO.getProduit(Integer.parseInt(formulaire.getProduitId()));
	    if(produit1!=null)
	    {
	    	int quantiteDisponible=produit1.getQuantiteDisponible()-Integer.parseInt(formulaire.getQuantiteStockSortie().trim());
	    	produit1.setQuantiteDisponible(quantiteDisponible);
	    	produitDAO.updateProduit(produit1);
	    }
		trx.commit();
		return "true";
		}
		catch(Exception e)
		{
			e.printStackTrace();
			log.fatal(e.getMessage());
			if(trx!=null)
			{
				trx.rollback();
			}
			return "false";
			
		}
		finally
		{
			 session.close();
			 sortieStock=null;
			 produit=null;
			 produit1=null;
		     log.debug("********** Fin saveSortieStock GestionStockBO **********");
		}
	}
	public ActionMessages checkFounisseur(GestionStockForm formulaire)
	{
		errors.clear();
		FournisseurDAO fournisseurDAO=FournisseurDAO.getInstance();
		Fournisseur fournisseur=fournisseurDAO.getFournisseurByNom(formulaire.getNomFournisseur());
		if(fournisseur!=null)
		{
			ActionError error = new ActionError("Fournisseur.nomExiste");
			errors.add("Fournisseur.nomExiste", error);
		}
		return errors;
	}
	public ActionMessages checkProduit(GestionStockForm formulaire)
	{
		errors.clear();
		ProduitDAO produitDAO=ProduitDAO.getInstance();
		Produit produit=produitDAO.getProduitByNom(formulaire.getNomProduit());
		if(produit!=null)
		{
			ActionError error = new ActionError("Produit.nomExiste");
			errors.add("Produit.nomExiste", error);
		}
		return errors;
	}
	public ActionMessages checkEntreeStock(GestionStockForm formulaire)
	{
		errors.clear();
		EntreeStockDAO entreeStockDAO=EntreeStockDAO.getInstance();
		EntreeStock entreeStock=entreeStockDAO.getEntreeStockByProduitAndDateAndFournisseur(Integer.parseInt(formulaire.getProduitId()), UtilDate.getInstance().stringToDate(formulaire.getDateStockEntree()), Integer.parseInt(formulaire.getFournisseurId()));
		if(entreeStock!=null)
		{
			ActionError error = new ActionError("EntreeStock.tripleProduitDateFournisseurExiste");
			errors.add("EntreeStock.tripleProduitDateFournisseurExiste", error);
		}
		return errors;
	}
	public ActionMessages checkSortieStock(GestionStockForm formulaire)
	{
		errors.clear();
		SortieStockDAO sortieStockDAO=SortieStockDAO.getInstance();
		SortieStock sortieStock=sortieStockDAO.getSortieStockByProduitAndDateAndQuantite(Integer.parseInt(formulaire.getProduitId()), UtilDate.getInstance().stringToDate(formulaire.getDateStockEntree()), Integer.parseInt(formulaire.getQuantiteStockSortie()));
		if(sortieStock!=null)
		{
			ActionError error = new ActionError("SortieStock.tripleProduitDateQuantiteExiste");
			errors.add("SortieStock.tripleProduitDateQuantiteExiste", error);
		}
		else
		{
			ProduitDAO produitDAO=ProduitDAO.getInstance();
			Produit produit=produitDAO.getProduit(Integer.parseInt(formulaire.getProduitId()));
			if(produit!=null)
			{
				if(produit.getQuantiteDisponible()<Integer.parseInt(formulaire.getQuantiteStockSortie().trim()))
				{
					ActionError error = new ActionError("SortieStock.quantiteSortanteSuperieureQuantiteDisponible");
					errors.add("SortieStock.quantiteSortanteSuperieureQuantiteDisponible", error);
				}
			}
		}
		return errors;
	}
	public void initialiserCombosClasses(GestionStockForm formulaire)
	{
	    log.debug("********** Debut initialiserCombosClasses GestionStockBO **********");
	    Session session=SessionFactoryUtil.getInstance().openSession();
	    ClasseDAO classeDAO=ClasseDAO.getInstance();
	    ArrayList classesList = new ArrayList();
		try
		{
			for (Iterator iter = classeDAO.listClasses().iterator(); iter.hasNext();) 
			{
				Classe classe=(Classe) iter.next();
				classesList.add(new LabelValueBean(classe.getNomClasse(), String.valueOf(classe.getClasseId())));
			}
			formulaire.setClassesList(classesList);
		}
		catch(Exception e)
		{
			e.printStackTrace();
			log.fatal(e.getMessage());
		}
		finally
		{
			session.close();
		    log.debug("********** Fin initialiserCombosClasses GestionStockBO **********");
		}
	}
	public void initialiserCombosProduits(GestionStockForm formulaire)
	{
	    log.debug("********** Debut initialiserCombosProduits GestionStockBO **********");
	    Session session=SessionFactoryUtil.getInstance().openSession();
	    ProduitDAO produitDAO=ProduitDAO.getInstance();
	    ArrayList produitsList = new ArrayList();
	    Produit produit=null;
	    boolean trouvee=false;
		try
		{
			for (Iterator iter = produitDAO.listProduits().iterator(); iter.hasNext();) 
			{
				produit=(Produit) iter.next();
				produitsList.add(new LabelValueBean(produit.getNomProduit(), String.valueOf(produit.getProduitId())));
				if(trouvee==false)
				 {
					 formulaire.setPrixProduit(String.valueOf(produit.getPrix()));
					 formulaire.setQuantiteDisponibleProduit(String.valueOf(produit.getQuantiteDisponible()));
					 trouvee=true;
				 }
			}
			formulaire.setProduitsList(produitsList);
		}
		catch(Exception e)
		{
			e.printStackTrace();
			log.fatal(e.getMessage());
		}
		finally
		{
			session.close();
		    log.debug("********** Fin initialiserCombosProduits GestionStockBO **********");
		}
	}
	public void initialiserCombosFournisseurs(GestionStockForm formulaire)
	{
	    log.debug("********** Debut initialiserCombosFournisseurs GestionStockBO **********");
	    Session session=SessionFactoryUtil.getInstance().openSession();
	    FournisseurDAO fournisseurDAO=FournisseurDAO.getInstance();
	    ArrayList fournisseursList = new ArrayList();
		try
		{
			for (Iterator iter = fournisseurDAO.listFournisseurs().iterator(); iter.hasNext();) 
			{
				Fournisseur fournisseur=(Fournisseur) iter.next();
				fournisseursList.add(new LabelValueBean(fournisseur.getNomFournisseur(), String.valueOf(fournisseur.getFournisseurId())));
			}
			formulaire.setFournisseursList(fournisseursList);
		}
		catch(Exception e)
		{
			e.printStackTrace();
			log.fatal(e.getMessage());
		}
		finally
		{
			session.close();
		    log.debug("********** Fin initialiserCombosFournisseurs GestionStockBO **********");
		}
	}
	public boolean getListJournalStock(GestionStockForm formulaire) throws Exception {
		
		Map mapParamValue = new HashMap<String, String>(2,1);
	    mapParamValue.put("operateur", formulaire.getOperateur());
	    mapParamValue.put("dateJournal", UtilDate.getInstance().dateToString(new Date()));
	    //mapParamValue.put("dateEntree", UtilDate.getInstance().stringToDate(formulaire.getDateStockEntree()));
	    Collection<JournalDuStock> list = (Collection<JournalDuStock>) QueryDao.getInstance().findResultQueryByNamedParams("query_filtre_journal_stock", mapParamValue);
		formulaire.setJournalStockList(list);
	    return true;
	}
public boolean getListProduits(GestionStockForm formulaire) throws Exception {
		
		ProduitDAO produitDAO=ProduitDAO.getInstance();
		formulaire.setProduitsList(produitDAO.listProduits());
	    return true;
	}
}
