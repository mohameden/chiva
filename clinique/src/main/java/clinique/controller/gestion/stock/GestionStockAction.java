package clinique.controller.gestion.stock;

import java.util.ArrayList;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

import clinique.dao.ProduitDAO;
import clinique.mapping.Produit;
import clinique.mapping.User;
import clinique.metier.gestion.stock.GestionStockBO;
import clinique.model.gestion.stock.GestionStockForm;
import clinique.utils.UtilDate;

public class GestionStockAction extends DispatchAction {
	
	
	private static Logger log = Logger.getLogger(GestionStockAction.class);
	public ActionForward affichJournalStock(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
	     log.debug("********** Debut affichJournalStock GestionStockAction **********");
		try
		{
			GestionStockForm formulaire = (GestionStockForm) form;
			User user=(User)request.getSession().getAttribute("userConnected");
			formulaire.setOperateur(user.getLogin());
			formulaire.setJournalStockList(new ArrayList());
			GestionStockBO gestionStockBO = new GestionStockBO();
			if (gestionStockBO.getListJournalStock(formulaire)) 
			{
					return mapping.findForward("affichJournalStock");
			}
				
			else
			{
					return mapping.findForward("affichJournalStock");
				
			}
		}
		catch (Exception e)
		{
			 e.printStackTrace();
			 log.fatal(e.getMessage());
			 return mapping.findForward("error");
		}
		finally
		{
			 System.gc();
		     log.debug("********** Fin affichJournalStock GestionStockAction **********");
		}
	
	}
	public ActionForward affichListeProduits(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
	     log.debug("********** Debut affichListeProduits GestionStockAction **********");
		try
		{
			GestionStockForm formulaire = (GestionStockForm) form;
			User user=(User)request.getSession().getAttribute("userConnected");
			formulaire.setOperateur(user.getLogin());
			formulaire.setProduitsList(new ArrayList());
			GestionStockBO gestionStockBO = new GestionStockBO();
			if (gestionStockBO.getListProduits(formulaire)) 
			{
					return mapping.findForward("affichListeProduits");
			}
				
			else
			{
					return mapping.findForward("affichListeProduits");
				
			}
		}
		catch (Exception e)
		{
			 e.printStackTrace();
			 log.fatal(e.getMessage());
			 return mapping.findForward("error");
		}
		finally
		{
			 System.gc();
		     log.debug("********** Fin affichListeProduits GestionStockAction **********");
		}
	
	}
	public ActionForward initSaveFournisseur(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
	     log.debug("********** Debut initSaveFournisseur GestionStockAction **********");
		try
		{
		 GestionStockForm formulaire = (GestionStockForm) form;
		 GestionStockBO gestionStockBO = new GestionStockBO();
		 return mapping.findForward("ajouterFournisseur");
		}
		catch (Exception e)
		{
			 e.printStackTrace();
			 log.fatal(e.getMessage());
			 return mapping.findForward("error");
		}
		finally
		{
			 System.gc();
		     log.debug("********** Fin initSaveFournisseur GestionStockAction **********");
		}
	
	}
	public ActionForward initSaveProduit(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
	     log.debug("********** Debut initSaveFournisseur GestionStockAction **********");
		try
		{
		 GestionStockForm formulaire = (GestionStockForm) form;
		 GestionStockBO gestionStockBO = new GestionStockBO();
		 gestionStockBO.initialiserCombosClasses(formulaire);
		 return mapping.findForward("ajouterProduit");
		}
		catch (Exception e)
		{
			 e.printStackTrace();
			 log.fatal(e.getMessage());
			 return mapping.findForward("error");
		}
		finally
		{
			 System.gc();
		     log.debug("********** Fin initSaveFournisseur GestionStockAction **********");
		}
	
	}
	public ActionForward initSaveEntreeStock(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
	     log.debug("********** Debut initSaveEntreeStock GestionStockAction **********");
		try
		{
		 GestionStockForm formulaire = (GestionStockForm) form;
		 GestionStockBO gestionStockBO = new GestionStockBO();
		 gestionStockBO.initialiserCombosFournisseurs(formulaire);
		 gestionStockBO.initialiserCombosProduits(formulaire);
		 return mapping.findForward("ajouterEntreeStock");
		}
		catch (Exception e)
		{
			 e.printStackTrace();
			 log.fatal(e.getMessage());
			 return mapping.findForward("error");
		}
		finally
		{
			 System.gc();
		     log.debug("********** Fin initSaveEntreeStock GestionStockAction **********");
		}
	
	}
	public ActionForward initSaveSortieStock(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
	     log.debug("********** Debut initSaveSortieStock GestionStockAction **********");
		try
		{
		 GestionStockForm formulaire = (GestionStockForm) form;
		 GestionStockBO gestionStockBO = new GestionStockBO();
		 gestionStockBO.initialiserCombosProduits(formulaire);
		 return mapping.findForward("ajouterSortieStock");
		}
		catch (Exception e)
		{
			 e.printStackTrace();
			 log.fatal(e.getMessage());
			 return mapping.findForward("error");
		}
		finally
		{
			 System.gc();
		     log.debug("********** Fin initSaveSortieStock GestionStockAction **********");
		}
	
	}
	public ActionForward saveFournisseur(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
	     log.debug("********** Debut saveFournisseur GestionStockAction **********");
		try
		{
		GestionStockForm formulaire = (GestionStockForm) form;
		User user=(User)request.getSession().getAttribute("userConnected");
		formulaire.setOperateur(user.getLogin());
		GestionStockBO gestionStockBO = new GestionStockBO();
		gestionStockBO.checkFounisseur(formulaire);
		if(gestionStockBO.getErrors().isEmpty())
		{
			formulaire.setEstEffWithSuccess(gestionStockBO.saveFounisseur(formulaire).trim());
			if(formulaire.getEstEffWithSuccess().equals("true"))
			{
				return mapping.findForward("ajouterFournisseur");
			}
			else
			{
				return mapping.findForward("ajouterFournisseur");
			}
		}
		else
		{
			formulaire.setEstEffWithSuccess("false");
			this.saveErrors(request, gestionStockBO.getErrors());
			return mapping.findForward("ajouterFournisseur");
		}
		}
		catch (Exception e)
		{
			 e.printStackTrace();
			 log.fatal(e.getMessage());
			 return mapping.findForward("ajouterFournisseur");
		}
		finally
		{
			 System.gc();
		     log.debug("********** Fin saveFournisseur GestionStockAction **********");
		}
	
	}
	
	public ActionForward saveProduit(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
	     log.debug("********** Debut saveProduit GestionStockAction **********");
		try
		{
		GestionStockForm formulaire = (GestionStockForm) form;
		User user=(User)request.getSession().getAttribute("userConnected");
		formulaire.setOperateur(user.getLogin());
		GestionStockBO gestionStockBO = new GestionStockBO();
		gestionStockBO.checkProduit(formulaire);
		if(gestionStockBO.getErrors().isEmpty())
		{
			formulaire.setEstEffWithSuccess(gestionStockBO.saveProduit(formulaire).trim());
			if(formulaire.getEstEffWithSuccess().equals("true"))
			{
				return mapping.findForward("ajouterProduit");
			}
			else
			{
				return mapping.findForward("ajouterProduit");
			}
		}
		else
		{
			formulaire.setEstEffWithSuccess("false");
			this.saveErrors(request, gestionStockBO.getErrors());
			return mapping.findForward("ajouterProduit");
		}
		}
		catch (Exception e)
		{
			 e.printStackTrace();
			 log.fatal(e.getMessage());
			 return mapping.findForward("ajouterProduit");
		}
		finally
		{
			 System.gc();
		     log.debug("********** Fin saveProduit GestionStockAction **********");
		}
	
	}
	public ActionForward saveEntreeStock(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
	     log.debug("********** Debut saveEntreeStock GestionStockAction **********");
		try
		{
		GestionStockForm formulaire = (GestionStockForm) form;
		User user=(User)request.getSession().getAttribute("userConnected");
		formulaire.setOperateur(user.getLogin());
		GestionStockBO gestionStockBO = new GestionStockBO();
		gestionStockBO.checkEntreeStock(formulaire);
		if(gestionStockBO.getErrors().isEmpty())
		{
			formulaire.setEstEffWithSuccess(gestionStockBO.saveEntreeStock(formulaire).trim());
			if(formulaire.getEstEffWithSuccess().equals("true"))
			{
				return mapping.findForward("ajouterEntreeStock");
			}
			else
			{
				return mapping.findForward("ajouterEntreeStock");
			}
		}
		else
		{
			formulaire.setEstEffWithSuccess("false");
			this.saveErrors(request, gestionStockBO.getErrors());
			return mapping.findForward("ajouterEntreeStock");
		}
		}
		catch (Exception e)
		{
			 e.printStackTrace();
			 log.fatal(e.getMessage());
			 return mapping.findForward("ajouterEntreeStock");
		}
		finally
		{
			 System.gc();
		     log.debug("********** Fin saveEntreeStock GestionStockAction **********");
		}
	
	}
	public ActionForward saveSortieStock(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
	     log.debug("********** Debut saveSortieStock GestionStockAction **********");
		try
		{
		GestionStockForm formulaire = (GestionStockForm) form;
		User user=(User)request.getSession().getAttribute("userConnected");
		formulaire.setOperateur(user.getLogin());
		GestionStockBO gestionStockBO = new GestionStockBO();
		gestionStockBO.checkSortieStock(formulaire);
		if(gestionStockBO.getErrors().isEmpty())
		{
			formulaire.setEstEffWithSuccess(gestionStockBO.saveSortieStock(formulaire).trim());
			if(formulaire.getEstEffWithSuccess().equals("true"))
			{
				return mapping.findForward("ajouterSortieStock");
			}
			else
			{
				return mapping.findForward("ajouterSortieStock");
			}
		}
		else
		{
			formulaire.setEstEffWithSuccess("false");
			this.saveErrors(request, gestionStockBO.getErrors());
			return mapping.findForward("ajouterSortieStock");
		}
		}
		catch (Exception e)
		{
			 e.printStackTrace();
			 log.fatal(e.getMessage());
			 return mapping.findForward("ajouterSortieStock");
		}
		finally
		{
			 System.gc();
		     log.debug("********** Fin saveSortieStock GestionStockAction **********");
		}
	
	}
}
