package clinique.dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Session;

import clinique.mapping.Menu;
import clinique.utils.ConstantesMetier;

public class MenuDAO implements ConstantesMetier {
	
	private static Logger log = Logger.getLogger(MenuDAO.class);
	private static final MenuDAO INSTANCE = new MenuDAO();

	public static MenuDAO getInstance() {
		  return INSTANCE;
		 }

	private MenuDAO () {}
	public Menu getMenu(int menuId)
	{
        log.debug("********** Debut getMenu MenuDAO **********");
        try
        {
		     Menu menu=null;
		     Session session = SessionFactoryUtil.getInstance().openSession();
		     menu = (Menu) session.get(Menu.class, menuId);
		     return menu;
        }
        catch(Exception e)
        {
        	e.printStackTrace();
        	log.fatal(e.getMessage());
        	return null;
        }
        finally
        {
            log.debug("********** Fin getMenu MenuDAO **********");
        }
	}
	public void saveMenu(Menu menu)
	{
        log.debug("********** Debut saveMenu MenuDAO **********");
        try
        {
		     Session session = SessionFactoryUtil.getInstance().openSession();
		     menu.setStatut(STATUT_VALIDE);
		     session.save(menu);
        }
        catch(Exception e)
        {
        	e.printStackTrace();
        	log.fatal(e.getMessage());
        }
        finally
        {
            log.debug("********** Fin saveMenu MenuDAO **********");
        }
	}
	public void updateMenu(Menu menu)
	{
        log.debug("********** Debut updateMenu MenuDAO **********");
        try
        {
		     Session session = SessionFactoryUtil.getInstance().openSession();
		     session.update(menu);
        }
        catch(Exception e)
        {
        	e.printStackTrace();
        	log.fatal(e.getMessage());
        }
        finally
        {
            log.debug("********** Fin updateMenu MenuDAO **********");
        }
	}
	public void deleteMenu(Menu menu)
	{
        log.debug("********** Debut deleteMenu MenuDAO **********");
        try
        {
		     Session session = SessionFactoryUtil.getInstance().openSession();
		     menu.setStatut(STATUT_SUPPRIME);
		     session.update(menu);
        }
        catch(Exception e)
        {
        	e.printStackTrace();
        	log.fatal(e.getMessage());
        }
        finally
        {
            log.debug("********** Fin deleteMenu MenuDAO **********");
        }
	}
	@SuppressWarnings({ "unchecked"})
	public List<Menu> listMenus() 
	{
        log.debug("********** Debut listMenus MenuDAO **********");
		try 
	    {
			List<Menu> menus=null;
		    Session session = SessionFactoryUtil.getInstance().openSession();
	    	String strQuery = "select distinct menu ";
	    	strQuery+="from Menu menu";
	    	strQuery+="where menu.statut = "+STATUT_VALIDE;
	    	strQuery+=" order by menu.menuId asc";
	    	org.hibernate.Query query=session.createQuery(strQuery);
	    	menus = query.list();
	    	return menus;
	    } 
	    catch (Exception e) 
	    {
	    	e.printStackTrace();
	    	log.fatal(e.getMessage());
	    	return null;
	    }
	    finally
	    {
	        log.debug("********** Fin listMenus MenuDAO **********");
	    }
	}
	@SuppressWarnings({ "unchecked"})
	public List<Menu> listMenusSupprimes() 
	{
        log.debug("********** Debut listMenusSupprimes MenuDAO **********");
		try 
	    {
			List<Menu> menus=null;
		    Session session = SessionFactoryUtil.getInstance().openSession();
	    	String strQuery = "select distinct menu ";
	    	strQuery+="from Menu menu";
	    	strQuery+="where menu.statut = "+STATUT_SUPPRIME;
	    	strQuery+=" order by menu.menuId asc";
	    	org.hibernate.Query query=session.createQuery(strQuery);
	    	menus = query.list();
	    	return menus;
	    } 
	    catch (Exception e) 
	    {
	    	e.printStackTrace();
	    	log.fatal(e.getMessage());
	    	return null;
	    }
	    finally
	    {
	        log.debug("********** Fin listMenusSupprimes MenuDAO **********");
	    }
	}
}
