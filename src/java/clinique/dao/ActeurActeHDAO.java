package clinique.dao;

import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Session;

import clinique.mapping.Acte;
import clinique.mapping.Acteur;
import clinique.mapping.ActeurActeH;
import clinique.mapping.Categorie;
import clinique.utils.ConstantesMetier;
import clinique.utils.UtilDate;

public class ActeurActeHDAO implements ConstantesMetier {
	
	private static Logger log = Logger.getLogger(ActeurActeHDAO.class);
	private static final ActeurActeHDAO INSTANCE = new ActeurActeHDAO();

	public static ActeurActeHDAO getInstance() {
		  return INSTANCE;
		 }

	private ActeurActeHDAO () {}
	public ActeurActeH getActeurActeH(int acteurActeHId)
	{
	     log.debug("********** Debut getActeurActeH ActeurActeHDAO **********");
		try
		{
		     ActeurActeH acteurActeH=null;
		     Session session = SessionFactoryUtil.getInstance().openSession();
		     acteurActeH = (ActeurActeH) session.get(ActeurActeH.class, acteurActeHId);
		     return acteurActeH;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			log.fatal(e.getMessage());
			return null;
		}
		finally
		{
		     log.debug("********** Fin getActeurActeH ActeurActeHDAO **********");
		     
		}
	}
	public void saveActeurActeH(ActeurActeH acteurActeH)
	{
	         log.debug("********** Debut saveActeurActeH ActeurActeHDAO **********");
             try
             {
		     Session session = SessionFactoryUtil.getInstance().openSession();
		     acteurActeH.setStatut(STATUT_VALIDE);
		     session.save(acteurActeH);
             }
             catch(Exception e)
             {
            	 e.printStackTrace();
            	 log.fatal(e.getMessage());
             }
             finally
             {
    	         log.debug("********** Fin saveActeurActeH ActeurActeHDAO **********");
             }
	}
	public void updateActeurActeH(ActeurActeH acteurActeH)
	{
             log.debug("********** Debut updateActeurActeH ActeurActeHDAO **********");

		     try
		     {
		     Session session = SessionFactoryUtil.getInstance().openSession();
		     session.update(acteurActeH);
		     }
		     catch(Exception e)
		     {
		    	 e.printStackTrace();
		    	 log.fatal(e.getMessage());
		     }
		     finally
		     {
		            log.debug("********** Fin updateActeurActeH ActeurActeHDAO **********");
		     }
	}
	public void deleteActeurActeH(ActeurActeH acteurActeH)
	{
        log.debug("********** Debut deleteActeurActeH ActeurActeHDAO **********");

		try
		{
		     Session session = SessionFactoryUtil.getInstance().openSession();
		     acteurActeH.setStatut(STATUT_SUPPRIME);
		     session.update(acteurActeH);
		}
		catch(Exception e)
		{
			e.printStackTrace();
			log.fatal(e.getMessage());
		}
		finally
		{
	        log.debug("********** Fin deleteActeurActeH ActeurActeHDAO **********");
		}
	}
	@SuppressWarnings({ "unchecked"})
	public List<ActeurActeH> listActeurActeHs() 
	{
        log.debug("********** Debut listActeurActeHs ActeurActeHDAO **********");

		try 
	    {
			List<ActeurActeH> acteurActeHs=null;
		    Session session = SessionFactoryUtil.getInstance().openSession();
	    	String strQuery = "select distinct acteurActeH ";
	    	strQuery+="from ActeurActeH acteurActeH";
	    	strQuery+="and acteurActeH.statut = "+STATUT_VALIDE;
	    	strQuery+=" order by acteurActeH.acteurActeHId asc";
	    	org.hibernate.Query query=session.createQuery(strQuery);
	    	acteurActeHs = query.list();	  
	    	return acteurActeHs;
	    } 
	    catch (Exception e) 
	    {
	    	e.printStackTrace();
	    	log.fatal(e.getMessage());
	    	return null;
	    }
	    finally
	    {
	        log.debug("********** Fin listActeurActeHs ActeurActeHDAO **********");
	    }
	}
	
	@SuppressWarnings({ "unchecked"})
	public ActeurActeH getActeurActeH(Acteur acteur,Acte acte) 
	{
        log.debug("********** Debut getActeurActeH ActeurActeHDAO **********");

		try 
	    {
			List<ActeurActeH> acteurActeHs=null;
		    Session session = SessionFactoryUtil.getInstance().openSession();
	    	String strQuery = "select distinct acteurActeH ";
	    	strQuery+="from ActeurActeH acteurActeH";
	    	strQuery+=" where  acteurActeH.acte.acteId = "+acte.getActeId();
	    	strQuery+=" and  acteurActeH.acteur.acteurId = "+acteur.getActeurId();
	    	strQuery+=" and acteurActeH.statut = "+STATUT_VALIDE;
	    	strQuery+=" order by acteurActeH.acteurActeHId asc";
	    	org.hibernate.Query query=session.createQuery(strQuery);
	    	acteurActeHs = query.list();
	    	if (acteurActeHs.size()>0) return acteurActeHs.get(0);
	    	else return null;
	    	
	    } 
	    catch (Exception e) 
	    {
	    	e.printStackTrace();
	    	log.fatal(e.getMessage());
	    	return null;
	    }
	    finally
	    {
	        log.debug("********** Fin getActeurActeH ActeurActeHDAO **********");
	    }
	}
	
	@SuppressWarnings({ "unchecked"})
	public List<ActeurActeH> listActeurActeHsSupprimes() 
	{
        log.debug("********** Debut listActeurActeHsSupprimes ActeurActeHDAO **********");
		try 
	    {
			List<ActeurActeH> acteurActeHs=null;
		    Session session = SessionFactoryUtil.getInstance().openSession();
	    	String strQuery = "select distinct acteurActeH ";
	    	strQuery+="from ActeurActeH acteurActeH";
	    	strQuery+="and acteurActeH.statut = "+STATUT_SUPPRIME;
	    	strQuery+=" order by acteurActeH.acteurActeHId asc";
	    	org.hibernate.Query query=session.createQuery(strQuery);
	    	acteurActeHs = query.list();	
	     	return acteurActeHs;
	    } 
	    catch (Exception e) 
	    {
	    	e.printStackTrace();
	    	log.fatal(e.getMessage());
	    	return null;
	    }
	    finally
	    {
	        log.debug("********** Fin listActeurActeHsSupprimes ActeurActeHDAO **********");
	    }
	}
	
	@SuppressWarnings("unchecked")
	public ActeurActeH getActeurActeHByDate(Acteur acteur,Date date1,Acte acte)
	{
		     log.debug("********** Debut getActeurActeHAssureurByDate ActeurActeHAssureurDAO **********");
		     try
		     {
		    	 if (acteur!=null && date1!=null && acte!=null)
		    	   {
		    	    List<ActeurActeH> acteurActes=null;
		    	    String dateFacture=UtilDate.getInstance().
							stringToDateMysql(UtilDate.getInstance().dateToString(date1));
				    Session session = SessionFactoryUtil.getInstance().openSession();
			    	String strQuery = "select distinct acteurActeH ";
			    	strQuery+="from ActeurActeH acteurActeH ";
			    	strQuery+=" where acteurActeH.acte.acteId = "+acte.getActeId();
			    	strQuery+=" and acteurActeH.acteur.acteurId = "+acteur.getActeurId();
			    	strQuery+=" and acteurActeH.isException = "+STATUT_VALIDE;
			    	strQuery+=" and acteurActeH.statut = "+STATUT_VALIDE;
			    	strQuery+=" and acteurActeH.dateDebut <= '"+ dateFacture+"'";
			    	strQuery+=" and acteurActeH.dateFin >= '"+ dateFacture+"'";
			    	//strQuery+=" order by facture.factureId asc";
			    	System.out.println(strQuery);
			    	org.hibernate.Query query=session.createQuery(strQuery);
			    	acteurActes = query.list();
			    	if (acteurActes.size()==0) return null;
			    	else return acteurActes.get(0);
		    	   }
		    	 else return null;
			    	
		     }
		     catch (Exception e) {
				e.printStackTrace();
				log.fatal(e.getMessage());
				return null;
			}
		    finally
		    {
			     log.debug("********** Fin getActeurActeHAssureurByDate ActeurActeHAssureurDAO **********");
		    }
	}
}
