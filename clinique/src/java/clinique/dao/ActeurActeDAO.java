package clinique.dao;

import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Session;

import clinique.mapping.Acte;
import clinique.mapping.Acteur;
import clinique.mapping.ActeurActe;
import clinique.mapping.ActeurActeAssureur;
import clinique.mapping.Categorie;
import clinique.utils.ConstantesMetier;
import clinique.utils.UtilDate;

public class ActeurActeDAO implements ConstantesMetier {
	
	private static Logger log = Logger.getLogger(ActeurActeDAO.class);
	private static final ActeurActeDAO INSTANCE = new ActeurActeDAO();

	public static ActeurActeDAO getInstance() {
		  return INSTANCE;
		 }

	private ActeurActeDAO () {}
	public ActeurActe getActeurActe(int acteurActeId)
	{
	     log.debug("********** Debut getActeurActe ActeurActeDAO **********");
		try
		{
		     ActeurActe acteurActe=null;
		     Session session = SessionFactoryUtil.getInstance().openSession();
		     acteurActe = (ActeurActe) session.get(ActeurActe.class, acteurActeId);
		     return acteurActe;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			log.fatal(e.getMessage());
			return null;
		}
		finally
		{
		     log.debug("********** Fin getActeurActe ActeurActeDAO **********");
		     
		}
	}
	public void saveActeurActe(ActeurActe acteurActe)
	{
	         log.debug("********** Debut saveActeurActe ActeurActeDAO **********");
             try
             {
		     Session session = SessionFactoryUtil.getInstance().openSession();
		     acteurActe.setStatut(STATUT_VALIDE);
		     session.save(acteurActe);
             }
             catch(Exception e)
             {
            	 e.printStackTrace();
            	 log.fatal(e.getMessage());
             }
             finally
             {
    	         log.debug("********** Fin saveActeurActe ActeurActeDAO **********");
             }
	}
	public void updateActeurActe(ActeurActe acteurActe)
	{
             log.debug("********** Debut updateActeurActe ActeurActeDAO **********");

		     try
		     {
		     Session session = SessionFactoryUtil.getInstance().openSession();
		     session.update(acteurActe);
		     }
		     catch(Exception e)
		     {
		    	 e.printStackTrace();
		    	 log.fatal(e.getMessage());
		     }
		     finally
		     {
		            log.debug("********** Fin updateActeurActe ActeurActeDAO **********");
		     }
	}
	public void deleteActeurActe(ActeurActe acteurActe)
	{
        log.debug("********** Debut deleteActeurActe ActeurActeDAO **********");

		try
		{
		     Session session = SessionFactoryUtil.getInstance().openSession();
		     acteurActe.setStatut(STATUT_SUPPRIME);
		     session.update(acteurActe);
		}
		catch(Exception e)
		{
			e.printStackTrace();
			log.fatal(e.getMessage());
		}
		finally
		{
	        log.debug("********** Fin deleteActeurActe ActeurActeDAO **********");
		}
	}
	@SuppressWarnings({ "unchecked"})
	public List<ActeurActe> listActeurActes() 
	{
        log.debug("********** Debut listActeurActes ActeurActeDAO **********");

		try 
	    {
			List<ActeurActe> acteurActes=null;
		    Session session = SessionFactoryUtil.getInstance().openSession();
	    	String strQuery = "select distinct acteurActe ";
	    	strQuery+="from ActeurActe acteurActe";
	    	strQuery+="and acteurActe.statut = "+STATUT_VALIDE;
	    	strQuery+=" order by acteurActe.acteurActeId asc";
	    	org.hibernate.Query query=session.createQuery(strQuery);
	    	acteurActes = query.list();	  
	    	return acteurActes;
	    } 
	    catch (Exception e) 
	    {
	    	e.printStackTrace();
	    	log.fatal(e.getMessage());
	    	return null;
	    }
	    finally
	    {
	        log.debug("********** Fin listActeurActes ActeurActeDAO **********");
	    }
	}
	
	@SuppressWarnings({ "unchecked"})
	public ActeurActe getActeurActe(Acteur acteur,Acte acte) 
	{
        log.debug("********** Debut getActeurActe ActeurActeDAO **********");

		try 
	    {
			List<ActeurActe> acteurActes=null;
		    Session session = SessionFactoryUtil.getInstance().openSession();
	    	String strQuery = "select distinct acteurActe ";
	    	strQuery+="from ActeurActe acteurActe";
	    	strQuery+=" where  acteurActe.acte.acteId = "+acte.getActeId();
	    	strQuery+=" and  acteurActe.acteur.acteurId = "+acteur.getActeurId();
	    	strQuery+=" and acteurActe.statut = "+STATUT_VALIDE;
	    	strQuery+=" order by acteurActe.acteurActeId asc";
	    	org.hibernate.Query query=session.createQuery(strQuery);
	    	acteurActes = query.list();
	    	if (acteurActes.size()>0) return acteurActes.get(0);
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
	        log.debug("********** Fin getActeurActe ActeurActeDAO **********");
	    }
	}
	
	@SuppressWarnings({ "unchecked"})
	public List<ActeurActe> listActeurActesSupprimes() 
	{
        log.debug("********** Debut listActeurActesSupprimes ActeurActeDAO **********");
		try 
	    {
			List<ActeurActe> acteurActes=null;
		    Session session = SessionFactoryUtil.getInstance().openSession();
	    	String strQuery = "select distinct acteurActe ";
	    	strQuery+="from ActeurActe acteurActe";
	    	strQuery+="and acteurActe.statut = "+STATUT_SUPPRIME;
	    	strQuery+=" order by acteurActe.acteurActeId asc";
	    	org.hibernate.Query query=session.createQuery(strQuery);
	    	acteurActes = query.list();	
	     	return acteurActes;
	    } 
	    catch (Exception e) 
	    {
	    	e.printStackTrace();
	    	log.fatal(e.getMessage());
	    	return null;
	    }
	    finally
	    {
	        log.debug("********** Fin listActeurActesSupprimes ActeurActeDAO **********");
	    }
	}
	
	@SuppressWarnings("unchecked")
	public ActeurActe getActeurActeByDate(Acteur acteur,Date date1,Acte acte)
	{
		     log.debug("********** Debut getActeurActeAssureurByDate ActeurActeAssureurDAO **********");
		     try
		     {
		    	 if (acteur!=null && date1!=null && acte!=null)
		    	   {
		    	    List<ActeurActe> acteurActes=null;
		    	    String dateFacture=UtilDate.getInstance().
							stringToDateMysql(UtilDate.getInstance().dateToString(date1));
				    Session session = SessionFactoryUtil.getInstance().openSession();
			    	String strQuery = "select distinct acteurActe ";
			    	strQuery+="from ActeurActe acteurActe ";
			    	strQuery+=" where acteurActe.acte.acteId = "+acte.getActeId();
			    	strQuery+=" and acteurActe.acteur.acteurId = "+acteur.getActeurId();
			    	strQuery+=" and acteurActe.isException = "+STATUT_VALIDE;
			    	strQuery+=" and acteurActe.statut = "+STATUT_VALIDE;
			    	strQuery+=" and acteurActe.dateDebut <= '"+ dateFacture+"'";
			    	strQuery+=" and acteurActe.dateFin >= '"+ dateFacture+"'";
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
			     log.debug("********** Fin getActeurActeAssureurByDate ActeurActeAssureurDAO **********");
		    }
	}
}
