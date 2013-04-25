package clinique.dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Session;

import clinique.mapping.Module;
import clinique.utils.ConstantesMetier;

public class ModuleDAO implements ConstantesMetier {
	
	private static Logger log = Logger.getLogger(ModuleDAO.class);
	private static final ModuleDAO INSTANCE = new ModuleDAO();

	public static ModuleDAO getInstance() {
		  return INSTANCE;
		 }

	private ModuleDAO () {}
	public Module getModule(int moduleId)
	{
        log.debug("********** Debut getModule ModuleDAO **********");
        try
        {
		     Module module=null;
		     Session session = SessionFactoryUtil.getInstance().openSession();
		     module = (Module) session.get(Module.class, moduleId);
		     return module;
        }
        catch(Exception e)
        {
        	e.printStackTrace();
        	log.fatal(e.getMessage());
        	return null;
        }
        finally
        {
            log.debug("********** Fin getModule ModuleDAO **********");
        }
	}
	public void saveModule(Module module)
	{
        log.debug("********** Debut saveModule ModuleDAO **********");
        try
        {
		     Session session = SessionFactoryUtil.getInstance().openSession();
		     module.setStatut(STATUT_VALIDE);
		     session.save(module);
        }
        catch(Exception e)
        {
        	e.printStackTrace();
        	log.fatal(e.getMessage());
        }
        finally
        {
            log.debug("********** Fin saveModule ModuleDAO **********");
        }
	}
	public void updateModule(Module module)
	{
        log.debug("********** Debut updateModule ModuleDAO **********");
        try
        {
		     Session session = SessionFactoryUtil.getInstance().openSession();
		     session.update(module);
        }
        catch(Exception e)
        {
        	e.printStackTrace();
        	log.fatal(e.getMessage());
        }
        finally
        {
            log.debug("********** Fin updateModule ModuleDAO **********");
        }
	}
	public void deleteModule(Module module)
	{
        log.debug("********** Debut deleteModule ModuleDAO **********");
        try
        {
		     Session session = SessionFactoryUtil.getInstance().openSession();
		     module.setStatut(STATUT_SUPPRIME);
		     session.update(module);
        }
        catch(Exception e)
        {
        	e.printStackTrace();
        	log.fatal(e.getMessage());
        }
        finally
        {
            log.debug("********** Fin deleteModule ModuleDAO **********");
        }
	}
	@SuppressWarnings({ "unchecked"})
	public List<Module> listModulesMenus() 
	{
        log.debug("********** Debut listModulesMenus ModuleDAO **********");
		try 
	    {
			List<Module> modulesMenus=null;
		    Session session = SessionFactoryUtil.getInstance().openSession();
	    	String strQuery = "select distinct module ";
	    	strQuery+="from Module module, Menu menu";
	    	strQuery+="where module.moduleId = menu.module.moduleId ";
	    	strQuery+="and module.statut = "+STATUT_VALIDE;
	    	strQuery+=" and menu.statut = "+STATUT_VALIDE;
	    	strQuery+=" order by module.moduleId asc";
	    	org.hibernate.Query query=session.createQuery(strQuery);
	    	modulesMenus = query.list();
	    	return modulesMenus;
	    } 
	    catch (Exception e) 
	    {
	    	e.printStackTrace();
	    	log.fatal(e.getMessage());
	    	return null;
	    }
	    finally
	    {
	        log.debug("********** Fin listModulesMenus ModuleDAO **********");
	    }
	}
	@SuppressWarnings({ "unchecked"})
	public List<Module> listModules() 
	{
        log.debug("********** Debut listModules ModuleDAO **********");
		try 
	    {
			List<Module> modules=null;
		    Session session = SessionFactoryUtil.getInstance().openSession();
	    	String strQuery = "select distinct module ";
	    	strQuery+="from Module module";
	    	strQuery+="where module.statut = "+STATUT_VALIDE;
	    	strQuery+=" order by module.moduleId asc";
	    	org.hibernate.Query query=session.createQuery(strQuery);
	    	modules = query.list();
	    	return modules;
	    } 
	    catch (Exception e) 
	    {
	    	e.printStackTrace();
	    	log.fatal(e.getMessage());
	    	return null;
	    }
	    finally
	    {
	        log.debug("********** Fin listModules ModuleDAO **********");
	    }
	}
	@SuppressWarnings({ "unchecked"})
	public List<Module> listModulesSupprimes() 
	{
        log.debug("********** Debut listModulesSupprimes ModuleDAO **********");
		try 
	    {
			List<Module> modules=null;
		    Session session = SessionFactoryUtil.getInstance().openSession();
	    	String strQuery = "select distinct module ";
	    	strQuery+="from Module module";
	    	strQuery+="where module.statut = "+STATUT_SUPPRIME;
	    	strQuery+=" order by module.moduleId asc";
	    	org.hibernate.Query query=session.createQuery(strQuery);
	    	modules = query.list();	    
	    	return modules;
	    } 
	    catch (Exception e) 
	    {
	    	e.printStackTrace();
	    	log.fatal(e.getMessage());
	    	return null;
	    }
	    finally
	    {
	        log.debug("********** Fin listModulesSupprimes ModuleDAO **********");
	    }
	}
}
