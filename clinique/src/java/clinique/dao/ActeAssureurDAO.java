package clinique.dao;

import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Session;

import clinique.mapping.Acte;
import clinique.mapping.ActeAssureur;
import clinique.mapping.Categorie;
import clinique.mapping.Facture;
import clinique.utils.ConstantesMetier;
import clinique.utils.UtilDate;

public class ActeAssureurDAO implements ConstantesMetier {
	
	private static Logger log = Logger.getLogger(ActeAssureurDAO.class);
	private static final ActeAssureurDAO INSTANCE = new ActeAssureurDAO();

	public static ActeAssureurDAO getInstance() {
		  return INSTANCE;
		 }

	private ActeAssureurDAO () {}
	public ActeAssureur getActeAssureur(String acteAssureurId)
	{
		     log.debug("********** Debut getActeAssureur ActeAssureurDAO **********");
		     try
		     {
		     ActeAssureur acteAssureur=null;
		     Session session = SessionFactoryUtil.getInstance().openSession();
		     acteAssureur = (ActeAssureur) session.get(ActeAssureur.class, acteAssureurId);
		     return acteAssureur;
		     }
		     catch (Exception e) {
				e.printStackTrace();
				log.fatal(e.getMessage());
				return null;
			}
		    finally
		    {
			     log.debug("********** Fin getActeAssureur ActeAssureurDAO **********");
		    }
	}
	
	
	@SuppressWarnings("unchecked")
	public ActeAssureur getActeAssureurByDate(Date date1,Acte acte,Categorie categorie)
	{
		     log.debug("********** Debut getActeAssureurByDate ActeAssureurDAO **********");
		     try
		     {
		    	 if (date1!=null && acte!=null && categorie!=null)
		    	   {
		    	    List<ActeAssureur> actes=null;
		    	    String dateFacture=UtilDate.getInstance().
							stringToDateMysql(UtilDate.getInstance().dateToString(date1));
				    Session session = SessionFactoryUtil.getInstance().openSession();
			    	String strQuery = "select distinct acteAssureur ";
			    	strQuery+=" from ActeAssureur acteAssureur ";
			    	strQuery+="where acteAssureur.acte.acteId = "+acte.getActeId();
			    	strQuery+=" and acteAssureur.categorie.categorieId = "+categorie.getCategorieId();
			    	strQuery+=" and acteAssureur.statut = "+STATUT_VALIDE;
			    	strQuery+=" and acteAssureur.dateDebut <= '"+ dateFacture+"'";
			    	strQuery+=" and acteAssureur.dateFin >= '"+ dateFacture+"'";
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
			     log.debug("********** Fin getActeAssureurByDate ActeAssureurDAO **********");
		    }
	}
	
	public void saveActeAssureur(ActeAssureur acteAssureur)
	{
	         log.debug("********** Debut saveActeAssureur ActeAssureurDAO **********");
		     try
		     {
		     Session session = SessionFactoryUtil.getInstance().openSession();
		     acteAssureur.setStatut(STATUT_VALIDE);
		     session.save(acteAssureur);
		     }
		     catch(Exception e)
		     {
		    	 e.printStackTrace();
		    	 log.fatal(e.getMessage());
		     }
		     finally
		     {
		         log.debug("********** Fin saveActeAssureur ActeAssureurDAO **********");
		     }
	}
	public void updateActeAssureur(ActeAssureur acteAssureur)
	{
             log.debug("********** Debut updateActeAssureur ActeAssureurDAO **********");
		     try
		     {
		     Session session = SessionFactoryUtil.getInstance().openSession();
		     session.update(acteAssureur);
		     }
		     catch(Exception e)
		     {
		    	 e.printStackTrace();
		    	 log.fatal(e.getMessage());
		     }
		     finally
		     {
	             log.debug("********** Fin updateActeAssureur ActeAssureurDAO **********");
		     }
	}
	public void deleteActeAssureur(ActeAssureur acteAssureur)
	{
             log.debug("********** Debut deleteActeAssureur ActeAssureurDAO **********");
		     try
		     {
		     Session session = SessionFactoryUtil.getInstance().openSession();
		     acteAssureur.setStatut(STATUT_SUPPRIME);
		     session.update(acteAssureur);
		     }
		     catch(Exception e)
		     {
		    	 e.printStackTrace();
		    	 log.fatal(e.getMessage());
		     }
		     finally
		     {
	             log.debug("********** Fin deleteActeAssureur ActeAssureurDAO **********");
		     }
	}
	@SuppressWarnings({ "unchecked"})
	public List<ActeAssureur> listActeAssureursActeAssureururs() 
	{
        log.debug("********** Debut listActeAssureursActeAssureururs ActeAssureurDAO **********");
		try 
	    {
			List<ActeAssureur> acteAssureursActeAssureururs=null;
		    Session session = SessionFactoryUtil.getInstance().openSession();
	    	String strQuery = "select distinct acteAssureur ";
	    	strQuery+="from ActeAssureur acteAssureur, ActeAssureururActeAssureur acteAssureururActeAssureur ";
	    	strQuery+="where acteAssureur.acteAssureurId = acteAssureururActeAssureur.acteAssureur.acteAssureurId ";
	    	strQuery+="and acteAssureur.statut = "+STATUT_VALIDE;
	    	strQuery+=" and acteAssureururActeAssureur.statut = "+STATUT_VALIDE;
	    	strQuery+=" order by acteAssureur.acteAssureurId asc";
	    	org.hibernate.Query query=session.createQuery(strQuery);
	    	acteAssureursActeAssureururs = query.list();
	    	return acteAssureursActeAssureururs;
	    } 
	    catch (Exception e) 
	    {
	    	e.printStackTrace();
	    	log.fatal(e.getMessage());
	    	return null;
	    }
	    finally
	    {
	        log.debug("********** Fin listActeAssureursActeAssureururs ActeAssureurDAO **********");
	    }
	}
	@SuppressWarnings({ "unchecked" })
	public List<ActeAssureur> listActeAssureursDetailFactures() 
	{
        log.debug("********** Debut listActeAssureursDetailFactures ActeAssureurDAO **********");
		try 
	    {
			List<ActeAssureur> acteAssureursDetailFactures=null;
		    Session session = SessionFactoryUtil.getInstance().openSession();
	    	String strQuery = "select distinct acteAssureur ";
	    	strQuery+="from ActeAssureur acteAssureur, DetailFacture detailFacture ";
	    	strQuery+="where acteAssureur.acteAssureurId = DetailFacture.acteAssureur.acteAssureurId ";
	    	strQuery+="and acteAssureur.statut = "+STATUT_VALIDE;
	    	strQuery+=" and DetailFacture.statut = "+STATUT_VALIDE;
	    	strQuery+=" order by acteAssureur.acteAssureurId asc";
	    	org.hibernate.Query query=session.createQuery(strQuery);
	    	acteAssureursDetailFactures = query.list();
	    	return acteAssureursDetailFactures;
	    } 
	    catch (Exception e) 
	    {
	    	e.printStackTrace();
	    	log.fatal(e.getMessage());
	    	return null;
	    }
	    finally
	    {
	        log.debug("********** Fin listActeAssureursDetailFactures ActeAssureurDAO **********");
	    }
	}
	@SuppressWarnings({ "unchecked"})
	public List<ActeAssureur> listActeAssureurs() 
	{
        log.debug("********** Debut listActeAssureurs ActeAssureurDAO **********");
		try 
	    {
			List<ActeAssureur> acteAssureurs=null;
		    Session session = SessionFactoryUtil.getInstance().openSession();
	    	String strQuery = "select distinct acteAssureur ";
	    	strQuery+="from ActeAssureur acteAssureur ";
	    	strQuery+="where acteAssureur.statut = "+STATUT_VALIDE;
	    	strQuery+=" order by acteAssureur.acteAssureurId asc";
	    	org.hibernate.Query query=session.createQuery(strQuery);
	    	acteAssureurs = query.list();
	    	return acteAssureurs;
	    } 
	    catch (Exception e) 
	    {
	    	e.printStackTrace();
	    	log.fatal(e.getMessage());
	    	return null;
	    }
	    finally
	    {
	        log.debug("********** Fin listActeAssureurs ActeAssureurDAO **********");
	    }
	}
	@SuppressWarnings({ "unchecked" })
	public List<ActeAssureur> listActeAssureursSupprimes() 
	{
        log.debug("********** Debut listActeAssureursSupprimes ActeAssureurDAO **********");
		try 
	    {
			List<ActeAssureur> acteAssureurs=null;
		    Session session = SessionFactoryUtil.getInstance().openSession();
	    	String strQuery = "select distinct acteAssureur ";
	    	strQuery+="from ActeAssureur acteAssureur ";
	    	strQuery+="where acteAssureur.statut = "+STATUT_SUPPRIME;
	    	strQuery+=" order by acteAssureur.acteAssureurId asc";
	    	org.hibernate.Query query=session.createQuery(strQuery);
	    	acteAssureurs = query.list();
	    	return acteAssureurs;
	    } 
	    catch (Exception e) 
	    {
	    	e.printStackTrace();
	    	log.fatal(e.getMessage());
	    	return null;
	    }
	    finally
	    {
	        log.debug("********** Fin listActeAssureursSupprimes ActeAssureurDAO **********");
	    }
	}
}
