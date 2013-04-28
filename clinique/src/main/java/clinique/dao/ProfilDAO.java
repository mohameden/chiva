package clinique.dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Session;

import clinique.mapping.Profil;
import clinique.utils.ConstantesMetier;

public class ProfilDAO implements ConstantesMetier {
	
	private static Logger log = Logger.getLogger(ProfilDAO.class);
	private static final ProfilDAO INSTANCE = new ProfilDAO();

	public static ProfilDAO getInstance() {
		  return INSTANCE;
		 }

	private ProfilDAO () {}
	public Profil getProfil(int profilId)
	{
	     log.debug("********** Debut getProfil ProfilDAO **********");
         try
         {
		     Profil profil=null;
		     Session session = SessionFactoryUtil.getInstance().openSession();
		     profil = (Profil) session.get(Profil.class, profilId);
		     return profil;
         }
         catch(Exception e)
         {
        	 e.printStackTrace();
        	 log.fatal(e.getMessage());
        	 return null;
         }
         finally
         {
    	     log.debug("********** Fin getProfil ProfilDAO **********"); 
         }
	}
	public void saveProfil(Profil profil)
	{
	     log.debug("********** Debut saveProfil ProfilDAO **********");
         try
         {
		     Session session = SessionFactoryUtil.getInstance().openSession();
		     profil.setStatut(STATUT_VALIDE);
		     session.save(profil);
         }
         catch(Exception e)
         {
        	 e.printStackTrace();
        	 log.fatal(e.getMessage());
         }
         finally
         {
    	     log.debug("********** Fin saveProfil ProfilDAO **********");
         }
	}
	public void updateProfil(Profil profil)
	{
	     log.debug("********** Debut updateProfil ProfilDAO **********");
         try
         {
		     Session session = SessionFactoryUtil.getInstance().openSession();
		     session.update(profil);
         }
         catch(Exception e)
         {
        	 e.printStackTrace();
        	 log.fatal(e.getMessage());
         }
         finally
         {
    	     log.debug("********** Fin updateProfil ProfilDAO **********");
         }
	}
	public void deleteProfil(Profil profil)
	{
	     log.debug("********** Debut deleteProfil ProfilDAO **********");
         try
         {
		     Session session = SessionFactoryUtil.getInstance().openSession();
		     profil.setStatut(STATUT_SUPPRIME);
		     session.update(profil);
         }
         catch(Exception e)
         {
        	 e.printStackTrace();
        	 log.fatal(e.getMessage());
         }
         finally
         {
    	     log.debug("********** Fin deleteProfil ProfilDAO **********");
         }
	}
	@SuppressWarnings({ "unchecked"})
	public List<Profil> listProfilsUsers() 
	{
	    log.debug("********** Debut listProfilsUsers ProfilDAO **********");
		try 
	    {
			List<Profil> profilsUsers=null;
		    Session session = SessionFactoryUtil.getInstance().openSession();
	    	String strQuery = "select distinct profil ";
	    	strQuery+="from Profil profil, User user ";
	    	strQuery+="where profil.profilId = user.profil.profilId ";
	    	strQuery+="and profil.statut = "+STATUT_VALIDE;
	    	strQuery+=" and user.statut = "+STATUT_VALIDE;
	    	strQuery+=" order by profil.profilId asc";
	    	org.hibernate.Query query=session.createQuery(strQuery);
	    	profilsUsers = query.list();
	    	return profilsUsers;
	    } 
	    catch (Exception e) 
	    {
	    	e.printStackTrace();
	    	log.fatal(e.getMessage());
	    	return null;
	    }
	    finally
	    {
		    log.debug("********** Fin listProfilsUsers ProfilDAO **********");
	    }
	}
	@SuppressWarnings({ "unchecked"})
	public List<Profil> listProfils() 
	{
	    log.debug("********** Debut listProfils ProfilDAO **********");
		try 
	    {
			List<Profil> profils=null;
		    Session session = SessionFactoryUtil.getInstance().openSession();
	    	String strQuery = "select distinct profil ";
	    	strQuery+="from Profil profil";
	    	strQuery+="where profil.statut = "+STATUT_VALIDE;
	    	strQuery+=" order by profil.profilId asc";
	    	org.hibernate.Query query=session.createQuery(strQuery);
	    	profils = query.list();
	    	return profils;
	    } 
	    catch (Exception e) 
	    {
	    	e.printStackTrace();
	    	log.fatal(e.getMessage());
	    	return null;
	    }
	    finally
	    {
		    log.debug("********** Fin listProfils ProfilDAO **********");
	    }
	}
	@SuppressWarnings({ "unchecked"})
	public List<Profil> listProfilsSupprimes() 
	{
	    log.debug("********** Debut listProfilsSupprimes ProfilDAO **********");
		try 
	    {
			List<Profil> profils=null;
		    Session session = SessionFactoryUtil.getInstance().openSession();
	    	String strQuery = "select distinct profil ";
	    	strQuery+="from Profil profil";
	    	strQuery+="where profil.statut = "+STATUT_SUPPRIME;
	    	strQuery+=" order by profil.profilId asc";
	    	org.hibernate.Query query=session.createQuery(strQuery);
	    	profils = query.list();	
	    	return profils;
	    } 
	    catch (Exception e) 
	    {
	    	e.printStackTrace();
	    	log.fatal(e.getMessage());
	    	return null;
	    }
	    finally
	    {
		    log.debug("********** Fin listProfilsSupprimes ProfilDAO **********");
	    }
	}
}
