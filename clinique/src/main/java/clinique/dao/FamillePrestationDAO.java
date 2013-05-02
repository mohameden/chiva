package clinique.dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import clinique.mapping.FamillePrestation;

@Repository
public class FamillePrestationDAO extends
		CliniqueHibernateDaoSupport<FamillePrestation> {

	private static Logger log = Logger.getLogger(FamillePrestationDAO.class);

	public FamillePrestation getFamillePrestation(int famillePrestationId) {
		log.debug("********** Debut getFamillePrestation FamillePrestationDAO **********");
		try {
			FamillePrestation famillePrestation = null;
			Session session = getSession();
			famillePrestation = (FamillePrestation) session.get(
					FamillePrestation.class, famillePrestationId);
			return famillePrestation;
		} catch (Exception e) {
			e.printStackTrace();
			log.fatal(e.getMessage());
			return null;
		} finally {
			log.debug("********** Fin getFamillePrestation FamillePrestationDAO **********");
		}
	}

	public void saveFamillePrestation(FamillePrestation famillePrestation) {
		log.debug("********** Debut saveFamillePrestation FamillePrestationDAO **********");
		try {
			Session session = getSession();
			famillePrestation.setStatut(STATUT_VALIDE);
			session.save(famillePrestation);
		} catch (Exception e) {
			e.printStackTrace();
			log.fatal(e.getMessage());
		} finally {
			log.debug("********** Fin saveFamillePrestation FamillePrestationDAO **********");
		}
	}

	public void updateFamillePrestation(FamillePrestation famillePrestation) {
		log.debug("********** Debut updateFamillePrestation FamillePrestationDAO **********");
		try {
			Session session = getSession();
			session.update(famillePrestation);
		} catch (Exception e) {
			e.printStackTrace();
			log.fatal(e.getMessage());
		} finally {
			log.debug("********** Fin updateFamillePrestation FamillePrestationDAO **********");
		}
	}

	public void deleteFamillePrestation(FamillePrestation famillePrestation) {
		log.debug("********** Debut updateFamillePrestation FamillePrestationDAO **********");
		try {
			Session session = getSession();
			famillePrestation.setStatut(STATUT_SUPPRIME);
			session.update(famillePrestation);
		} catch (Exception e) {
			e.printStackTrace();
			log.fatal(e.getMessage());
		} finally {
			log.debug("********** Fin updateFamillePrestation FamillePrestationDAO **********");
		}
	}

	@SuppressWarnings({ "unchecked" })
	public List<FamillePrestation> listFamillePrestationsActeurs() {
		log.debug("********** Debut listFamillePrestationsActeurs FamillePrestationDAO **********");
		try {
			List<FamillePrestation> famillePrestationsActeurs = null;
			Session session = getSession();
			String strQuery = "select distinct famillePrestation ";
			strQuery += "from FamillePrestation famillePrestation, Classe classe, Acte acte, ActeurActe acteurActe ";
			strQuery += "where famillePrestation.famillepId = classe.famillePrestation.famillepId ";
			strQuery += "and classe.classeId = acte.classe.classeId ";
			strQuery += "and acte.acteId = acteurActe.acte.acteId ";
			strQuery += "and famillePrestation.statut = " + STATUT_VALIDE;
			strQuery += " and classe.statut = " + STATUT_VALIDE;
			strQuery += " and acte.statut = " + STATUT_VALIDE;
			strQuery += " and acteurActe.statut = " + STATUT_VALIDE;
			strQuery += " order by famillePrestation.famillepId asc";
			org.hibernate.Query query = session.createQuery(strQuery);
			famillePrestationsActeurs = query.list();
			return famillePrestationsActeurs;
		} catch (Exception e) {
			e.printStackTrace();
			log.fatal(e.getMessage());
			return null;
		} finally {
			log.debug("********** Fin listFamillePrestationsActeurs FamillePrestationDAO **********");
		}
	}

	@SuppressWarnings({ "unchecked" })
	public List<FamillePrestation> listFamillePrestationsActes() {
		log.debug("********** Debut listFamillePrestationsActes FamillePrestationDAO **********");
		try {
			List<FamillePrestation> famillePrestationsActes = null;
			Session session = getSession();
			String strQuery = "select distinct famillePrestation ";
			strQuery += "from FamillePrestation famillePrestation,  Acte acte ";
			strQuery += "where  famillePrestation.famillePrestationId = acte.famillePrestation.famillePrestationId ";
			strQuery += "and famillePrestation.statut = " + STATUT_VALIDE;
			strQuery += " and acte.statut = 1 " + STATUT_VALIDE;
			strQuery += " order by famillePrestation.famillePrestationId asc";
			org.hibernate.Query query = session.createQuery(strQuery);
			famillePrestationsActes = query.list();
			return famillePrestationsActes;
		} catch (Exception e) {
			e.printStackTrace();
			log.fatal(e.getMessage());
			return null;
		} finally {
			log.debug("********** Fin listFamillePrestationsActes FamillePrestationDAO **********");
		}
	}

	@SuppressWarnings({ "unchecked" })
	public List<FamillePrestation> listFamillePrestationsClasses() {
		log.debug("********** Debut listFamillePrestationsClasses FamillePrestationDAO **********");
		try {
			List<FamillePrestation> famillePrestationsClasses = null;
			Session session = getSession();
			String strQuery = "select distinct famillePrestation ";
			strQuery += "from FamillePrestation famillePrestation, Classe classe ";
			strQuery += "where famillePrestation.famillepId = classe.famillePrestation.famillepId ";
			strQuery += "and famillePrestation.statut = " + STATUT_VALIDE;
			strQuery += " and classe.statut = " + STATUT_VALIDE;
			strQuery += " order by famillePrestation.famillepId asc";
			org.hibernate.Query query = session.createQuery(strQuery);
			famillePrestationsClasses = query.list();
			return famillePrestationsClasses;
		} catch (Exception e) {
			e.printStackTrace();
			log.fatal(e.getMessage());
			return null;
		} finally {
			log.debug("********** Fin listFamillePrestationsClasses FamillePrestationDAO **********");
		}
	}

	@SuppressWarnings({ "unchecked" })
	public List<FamillePrestation> listFamillePrestations() {
		log.debug("********** Debut listFamillePrestations FamillePrestationDAO **********");
		try {
			List<FamillePrestation> famillePrestations = null;
			Session session = getSession();
			String strQuery = "select distinct famillePrestation ";
			strQuery += "from FamillePrestation famillePrestation ";
			strQuery += "where famillePrestation.statut = " + STATUT_VALIDE;
			strQuery += " order by famillePrestation.famillePrestationId asc";
			org.hibernate.Query query = session.createQuery(strQuery);
			famillePrestations = query.list();
			return famillePrestations;
		} catch (Exception e) {
			e.printStackTrace();
			log.fatal(e.getMessage());
			return null;
		} finally {
			log.debug("********** Fin listFamillePrestations FamillePrestationDAO **********");
		}
	}

	@SuppressWarnings({ "unchecked" })
	public List<FamillePrestation> listFamillePrestationsSupprimees() {
		log.debug("********** Debut listFamillePrestationsSupprimees FamillePrestationDAO **********");
		try {
			List<FamillePrestation> famillePrestations = null;
			Session session = getSession();
			String strQuery = "select distinct famillePrestation ";
			strQuery += "from FamillePrestation famillePrestation ";
			strQuery += "where famillePrestation.statut = " + STATUT_SUPPRIME;
			strQuery += " order by famillePrestation.famillepId asc";
			org.hibernate.Query query = session.createQuery(strQuery);
			famillePrestations = query.list();
			return famillePrestations;
		} catch (Exception e) {
			e.printStackTrace();
			log.fatal(e.getMessage());
			return null;
		} finally {
			log.debug("********** Fin listFamillePrestationsSupprimees FamillePrestationDAO **********");
		}
	}

	@Override
	protected Class<?> getEntityClass() {
		return FamillePrestation.class;
	}
}
