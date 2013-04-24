package clinique.dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Session;

import clinique.mapping.Badge;

import clinique.utils.ConstantesMetier;

public class BadgeDAO implements ConstantesMetier {
	
	private static Logger log = Logger.getLogger(BadgeDAO.class);
	private static final BadgeDAO INSTANCE = new BadgeDAO();

	public static BadgeDAO getInstance() {
		  return INSTANCE;
		 }

	private BadgeDAO () {}
	public Badge getBadge(String badgeId)
	{
        log.debug("********** Debut getBadge BadgeDAO **********");
        try
        {
		     Badge badge=null;
		     Session session = SessionFactoryUtil.getInstance().openSession();
		     badge = (Badge) session.get(Badge.class, badgeId);
		     return badge;
        }
        catch(Exception e)
        {
        	e.printStackTrace();
        	log.fatal(e.getMessage());
        	return null;
        }
        finally
        {
            log.debug("********** Fin getBadge BadgeDAO **********");
        }
	}
	public void saveBadge(Badge badge)
	{
        log.debug("********** Debut saveBadge BadgeDAO **********");
        try
        {
		     Session session = SessionFactoryUtil.getInstance().openSession();
		     badge.setStatut(STATUT_SUPPRIME);
		     session.save(badge);
		     
        }
        catch(Exception e)
        {
             e.printStackTrace();
             log.fatal(e.getMessage());
        }
        finally
        {
            log.debug("********** Fin saveBadge BadgeDAO **********");
        }
	}
	public void updateBadge(Badge badge)
	{
        log.debug("********** Debut updateBadge BadgeDAO **********");
        try
        {
		     Session session = SessionFactoryUtil.getInstance().openSession();
		     session.update(badge);
        }
        catch(Exception e)
        {
        	e.printStackTrace();
        	log.fatal(e.getMessage());
        }
        finally
        {
            log.debug("********** Fin updateBadge BadgeDAO **********");
        }
	}
	public void deleteBadge(Badge badge)
	{
        log.debug("********** Debut deleteBadge BadgeDAO **********");
        try
        {
		     Session session = SessionFactoryUtil.getInstance().openSession();
		     badge.setStatut(STATUT_SUPPRIME);
		     session.update(badge);
        }
        catch(Exception e)
        {
        	e.printStackTrace();
        	log.fatal(e.getMessage());
        }
        finally
        {
            log.debug("********** Fin deleteBadge BadgeDAO **********");
        }
	}
	
	@SuppressWarnings({ "unchecked"})
	public List<Badge> listBadges() 
	{
        log.debug("********** Debut listBadges BadgeDAO **********");
		try 
	    {
			List<Badge> badges=null;
		    Session session = SessionFactoryUtil.getInstance().openSession();
	    	String strQuery = "select distinct badge ";
	    	strQuery+="from Badge badge";
	    	strQuery+="where badge.statut = "+STATUT_VALIDE;
	    	strQuery+=" order by badge.badgeId asc";
	    	org.hibernate.Query query=session.createQuery(strQuery);
	    	badges = query.list();
	    	return badges;
	    } 
	    catch (Exception e) 
	    {
	    	e.printStackTrace();
	    	log.fatal(e.getMessage());
	    	return null;
	    }
	    finally
	    {
	        log.debug("********** Fin listBadges BadgeDAO **********");
	    }
	}
	
	@SuppressWarnings({ "unchecked"})
	public List<Badge> listBadgesSupprimees() 
	{
        log.debug("********** Debut listBadgesSupprimees BadgeDAO **********");
		try 
	    {
			List<Badge> badgesSupprimees=null;
		    Session session = SessionFactoryUtil.getInstance().openSession();
	    	String strQuery = "select distinct badge ";
	    	strQuery+="from Badge badge";
	    	strQuery+="where badge.statut = "+STATUT_SUPPRIME;
	    	strQuery+=" order by badge.badgeId asc";
	    	org.hibernate.Query query=session.createQuery(strQuery);
	    	badgesSupprimees = query.list();
	    	return badgesSupprimees;
	    } 
	    catch (Exception e) 
	    {
	    	e.printStackTrace();
	    	log.fatal(e.getMessage());
	    	return null;
	    }
	    finally
	    {
	        log.debug("********** Fin listBadgesSupprimees BadgeDAO **********");
	    }
	}
	
	}
