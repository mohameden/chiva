package clinique.dao;

import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Session;

import clinique.mapping.Acte;
import clinique.mapping.ActeAssureurH;
import clinique.mapping.ActeH;
import clinique.mapping.Categorie;
import clinique.utils.ConstantesMetier;
import clinique.utils.UtilDate;

public class ActeHDAO implements ConstantesMetier {
	
	private static Logger log = Logger.getLogger(ActeHDAO.class);
	private static final ActeHDAO INSTANCE = new ActeHDAO();

	public static ActeHDAO getInstance() {
		  return INSTANCE;
		 }

	private ActeHDAO () {}
	public ActeH getActeH(int acteHId)
	{
		     log.debug("********** Debut getActeH ActeHDAO **********");
		     try
		     {
		     ActeH acteH=null;
		     Session session = SessionFactoryUtil.getInstance().openSession();
		     acteH = (ActeH) session.get(ActeH.class, acteHId);
		     return acteH;
		     }
		     catch (Exception e) {
				e.printStackTrace();
				log.fatal(e.getMessage());
				return null;
			}
		    finally
		    {
			     log.debug("********** Fin getActeH ActeHDAO **********");
		    }
	}
	
	@SuppressWarnings("unchecked")
	public ActeH getActeHByDate(String acteAssureurHId,Date date1,Acte acte)
	{
		     log.debug("********** Debut getActeHByDate ActeAssureurDAO **********");
		     try
		     {
		    	    List<ActeH> actes=null;
		    	    String dateFacture=UtilDate.getInstance().
							stringToDateMysql(UtilDate.getInstance().dateToString(date1));
				    Session session = SessionFactoryUtil.getInstance().openSession();
			    	String strQuery = "select distinct acteH ";
			    	strQuery+="from ActeH acteH ";
			    	strQuery+="where acteH.acte.actId = "+acte.getActeId();
			    	strQuery+=" and acteH.statut = "+STATUT_VALIDE;
			    	strQuery+=" and acteH.dateDebut <= '"+ dateFacture+"'";
			    	strQuery+=" and acteH.dateFin >= '"+ dateFacture+"'";
			    	//strQuery+=" order by facture.factureId asc";
			    	//System.out.println(strQuery);
			    	org.hibernate.Query query=session.createQuery(strQuery);
			    	actes = query.list();
			    	if (actes.size()==0) return null;
			    	else return actes.get(0);
			    	
		     }
		     catch (Exception e) {
				e.printStackTrace();
				log.fatal(e.getMessage());
				return null;
			}
		    finally
		    {
			     log.debug("********** Fin getActeHByDate ActeAssureurDAO **********");
		    }
	}
	
	
	public void saveActeH(ActeH acteH)
	{
	         log.debug("********** Debut saveActeH ActeHDAO **********");
		     try
		     {
		     Session session = SessionFactoryUtil.getInstance().openSession();
		     acteH.setStatut(STATUT_VALIDE);
		     session.save(acteH);
		     }
		     catch(Exception e)
		     {
		    	 e.printStackTrace();
		    	 log.fatal(e.getMessage());
		     }
		     finally
		     {
		         log.debug("********** Fin saveActeH ActeHDAO **********");
		     }
	}
	public void updateActeH(ActeH acteH)
	{
             log.debug("********** Debut updateActeH ActeHDAO **********");
		     try
		     {
		     Session session = SessionFactoryUtil.getInstance().openSession();
		     session.update(acteH);
		     }
		     catch(Exception e)
		     {
		    	 e.printStackTrace();
		    	 log.fatal(e.getMessage());
		     }
		     finally
		     {
	             log.debug("********** Fin updateActeH ActeHDAO **********");
		     }
	}
	public void deleteActeH(ActeH acteH)
	{
             log.debug("********** Debut deleteActeH ActeHDAO **********");
		     try
		     {
		     Session session = SessionFactoryUtil.getInstance().openSession();
		     acteH.setStatut(STATUT_SUPPRIME);
		     session.update(acteH);
		     }
		     catch(Exception e)
		     {
		    	 e.printStackTrace();
		    	 log.fatal(e.getMessage());
		     }
		     finally
		     {
	             log.debug("********** Fin deleteActeH ActeHDAO **********");
		     }
	}
	@SuppressWarnings({ "unchecked"})
	public List<ActeH> listActeHsActeHurs() 
	{
        log.debug("********** Debut listActeHsActeHurs ActeHDAO **********");
		try 
	    {
			List<ActeH> acteHsActeHurs=null;
		    Session session = SessionFactoryUtil.getInstance().openSession();
	    	String strQuery = "select distinct acteH ";
	    	strQuery+="from ActeH acteH, ActeHurActeH acteHurActeH ";
	    	strQuery+="where acteH.acteHId = acteHurActeH.acteH.acteHId ";
	    	strQuery+="and acteH.statut = "+STATUT_VALIDE;
	    	strQuery+=" and acteHurActeH.statut = "+STATUT_VALIDE;
	    	strQuery+=" order by acteH.acteHId asc";
	    	org.hibernate.Query query=session.createQuery(strQuery);
	    	acteHsActeHurs = query.list();
	    	return acteHsActeHurs;
	    } 
	    catch (Exception e) 
	    {
	    	e.printStackTrace();
	    	log.fatal(e.getMessage());
	    	return null;
	    }
	    finally
	    {
	        log.debug("********** Fin listActeHsActeHurs ActeHDAO **********");
	    }
	}
	@SuppressWarnings({ "unchecked" })
	public List<ActeH> listActeHsDetailFactures() 
	{
        log.debug("********** Debut listActeHsDetailFactures ActeHDAO **********");
		try 
	    {
			List<ActeH> acteHsDetailFactures=null;
		    Session session = SessionFactoryUtil.getInstance().openSession();
	    	String strQuery = "select distinct acteH ";
	    	strQuery+="from ActeH acteH, DetailFacture detailFacture ";
	    	strQuery+="where acteH.acteHId = DetailFacture.acteH.acteHId ";
	    	strQuery+="and acteH.statut = "+STATUT_VALIDE;
	    	strQuery+=" and DetailFacture.statut = "+STATUT_VALIDE;
	    	strQuery+=" order by acteH.acteHId asc";
	    	org.hibernate.Query query=session.createQuery(strQuery);
	    	acteHsDetailFactures = query.list();
	    	return acteHsDetailFactures;
	    } 
	    catch (Exception e) 
	    {
	    	e.printStackTrace();
	    	log.fatal(e.getMessage());
	    	return null;
	    }
	    finally
	    {
	        log.debug("********** Fin listActeHsDetailFactures ActeHDAO **********");
	    }
	}
	@SuppressWarnings({ "unchecked"})
	public List<ActeH> listActeHs() 
	{
        log.debug("********** Debut listActeHs ActeHDAO **********");
		try 
	    {
			List<ActeH> acteHs=null;
		    Session session = SessionFactoryUtil.getInstance().openSession();
	    	String strQuery = "select distinct acteH ";
	    	strQuery+="from ActeH acteH ";
	    	strQuery+="where acteH.statut = "+STATUT_VALIDE;
	    	strQuery+=" order by acteH.acteHId asc";
	    	org.hibernate.Query query=session.createQuery(strQuery);
	    	acteHs = query.list();
	    	return acteHs;
	    } 
	    catch (Exception e) 
	    {
	    	e.printStackTrace();
	    	log.fatal(e.getMessage());
	    	return null;
	    }
	    finally
	    {
	        log.debug("********** Fin listActeHs ActeHDAO **********");
	    }
	}
	@SuppressWarnings({ "unchecked" })
	public List<ActeH> listActeHsSupprimes() 
	{
        log.debug("********** Debut listActeHsSupprimes ActeHDAO **********");
		try 
	    {
			List<ActeH> acteHs=null;
		    Session session = SessionFactoryUtil.getInstance().openSession();
	    	String strQuery = "select distinct acteH ";
	    	strQuery+="from ActeH acteH ";
	    	strQuery+="where acteH.statut = "+STATUT_SUPPRIME;
	    	strQuery+=" order by acteH.acteHId asc";
	    	org.hibernate.Query query=session.createQuery(strQuery);
	    	acteHs = query.list();
	    	return acteHs;
	    } 
	    catch (Exception e) 
	    {
	    	e.printStackTrace();
	    	log.fatal(e.getMessage());
	    	return null;
	    }
	    finally
	    {
	        log.debug("********** Fin listActeHsSupprimes ActeHDAO **********");
	    }
	}
	
	@SuppressWarnings("unchecked")
	public ActeH getActeHByDate(Date date1,Acte acte)
	{
		     log.debug("********** Debut getActeHByDate ActeDAO **********");
		     try
		     {
		    	 if (date1!=null && acte!=null)
		    	   {
		    	    List<ActeH> actes=null;
		    	    String dateFacture=UtilDate.getInstance().
							stringToDateMysql(UtilDate.getInstance().dateToString(date1));
				    Session session = SessionFactoryUtil.getInstance().openSession();
			    	String strQuery = "select distinct acteH ";
			    	strQuery+="from ActeH acteH ";
			    	strQuery+=" where acteH.acte.acteId = "+acte.getActeId();
			    	strQuery+=" and acteH.statut = "+STATUT_VALIDE;
			    	strQuery+=" and acteH.dateDebut <= '"+ dateFacture+"'";
			    	strQuery+=" and acteH.dateFin >= '"+ dateFacture+"'";
			    	//strQuery+=" order by facture.factureId asc";
			    	System.out.println(strQuery);
			    	org.hibernate.Query query=session.createQuery(strQuery);
			    	actes = query.list();
			    	if (actes.size()==0) return null;
			    	else return actes.get(0);
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
			     log.debug("********** Fin getActeHByDate ActeDAO **********");
		    }
	}
}
