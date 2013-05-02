package clinique.dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import clinique.mapping.Acte;
import clinique.mapping.Classe;

@Repository
public class ClasseDAO extends CliniqueHibernateDaoSupport<Classe> {

	private static Logger log = Logger.getLogger(ClasseDAO.class);
	@Autowired
	private ActeDAO acteDAO;

	public Classe getClasse(int classeId) {
		log.debug("********** Debut getClasse ClasseDAO **********");
		try {
			Classe classe = null;
			Session session = getSession();
			classe = (Classe) session.get(Classe.class, classeId);
			return classe;
		} catch (Exception e) {
			e.printStackTrace();
			log.fatal(e.getMessage());
			return null;
		} finally {
			log.debug("********** Fin getClasse ClasseDAO **********");
		}
	}

	public void saveClasse(Classe classe) {
		log.debug("********** Debut saveClasse ClasseDAO **********");
		try {
			Session session = getSession();
			classe.setStatut(STATUT_VALIDE);
			session.save(classe);
		} catch (Exception e) {
			e.printStackTrace();
			log.fatal(e.getMessage());
		} finally {
			log.debug("********** Fin saveClasse ClasseDAO **********");
		}
	}

	public void updateClasse(Classe classe) {
		log.debug("********** Debut updateClasse ClasseDAO **********");
		try {
			Session session = getSession();
			session.update(classe);
		} catch (Exception e) {
			e.printStackTrace();
			log.fatal(e.getMessage());
		} finally {
			log.debug("********** Fin updateClasse ClasseDAO **********");
		}
	}

	public void deleteClasse(Classe classe) {
		log.debug("********** Debut deleteClasse ClasseDAO **********");
		try {
			Session session = getSession();
			classe.setStatut(STATUT_SUPPRIME);
			session.update(classe);
			List<Acte> actes = classe.getActes();
			if (actes != null && actes.size() > 0) {
				for (Acte acte : actes) {
					if (acte != null
							&& !acte.getStatut().equals(STATUT_SUPPRIME)) {
						acteDAO.deleteActe(acte);
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			log.fatal(e.getMessage());
		} finally {
			log.debug("********** Fin deleteClasse ClasseDAO **********");
		}
	}

	@SuppressWarnings({ "unchecked" })
	public List<Classe> listClasseActeurs() {
		log.debug("********** Debut listClasseActeurs ClasseDAO **********");
		try {
			List<Classe> classeActeurs = null;
			Session session = getSession();
			String strQuery = "select distinct classe ";
			strQuery += "from Classe classe, Acte acte,ActeurActe acteurActe";
			strQuery += "where classe.classeId = acte.classe.classeId ";
			strQuery += "and acte.acteId = acteurActe.acte.acteId ";
			strQuery += "and classe.statut = " + STATUT_VALIDE;
			strQuery += " and acte.statut = " + STATUT_VALIDE;
			strQuery += " and acteurActe.statut = " + STATUT_VALIDE;
			strQuery += " order by classe.classeId asc";
			org.hibernate.Query query = session.createQuery(strQuery);
			classeActeurs = query.list();
			return classeActeurs;
		} catch (Exception e) {
			e.printStackTrace();
			log.fatal(e.getMessage());
			return null;
		} finally {
			log.debug("********** Fin listClasseActeurs ClasseDAO **********");
		}
	}

	@SuppressWarnings({ "unchecked" })
	public List<Classe> listClasseActes() {
		log.debug("********** Debut listClasseActes ClasseDAO **********");
		try {
			List<Classe> classeActes = null;
			Session session = getSession();
			String strQuery = "select distinct classe ";
			strQuery += "from Classe classe, Acte acte";
			strQuery += "where classe.classeId = acte.classe.classeId ";
			strQuery += "and classe.statut = " + STATUT_VALIDE;
			strQuery += " and acte.statut = " + STATUT_VALIDE;
			strQuery += " order by classe.classeId asc";
			org.hibernate.Query query = session.createQuery(strQuery);
			classeActes = query.list();
			return classeActes;
		} catch (Exception e) {
			e.printStackTrace();
			log.fatal(e.getMessage());
			return null;
		} finally {
			log.debug("********** Fin listClasseActes ClasseDAO **********");
		}
	}

	@SuppressWarnings({ "unchecked" })
	public List<Classe> listClassePrestationsCouvertesPcs() {
		log.debug("********** Debut listClassePrestationsCouvertesPcs ClasseDAO **********");
		try {
			List<Classe> classePrestationsCouvertesPcs = null;
			Session session = getSession();
			String strQuery = "select distinct classe ";
			strQuery += "from Classe classe, PrestationCouvertesPc prestationCouvertesPc";
			strQuery += "where classe.classeId = prestationCouvertesPc.classe.classeId ";
			strQuery += "and classe.statut = " + STATUT_VALIDE;
			strQuery += " and prestationCouvertesPc.statut = " + STATUT_VALIDE;
			strQuery += " order by classe.classeId asc";
			org.hibernate.Query query = session.createQuery(strQuery);
			classePrestationsCouvertesPcs = query.list();
			return classePrestationsCouvertesPcs;
		} catch (Exception e) {
			e.printStackTrace();
			log.fatal(e.getMessage());
			return null;
		} finally {
			log.debug("********** Fin listClassePrestationsCouvertesPcs ClasseDAO **********");
		}
	}

	@SuppressWarnings({ "unchecked" })
	public List<Classe> listClasses() {
		List<Classe> classes = null;
		Session session = getSession();
		String strQuery = "select distinct classe ";
		strQuery += "from Classe classe ";
		strQuery += "where classe.statut = " + STATUT_VALIDE;
		strQuery += " order by classe.classeId asc";
		org.hibernate.Query query = session.createQuery(strQuery);
		classes = query.list();
		return classes;
	}

	@SuppressWarnings({ "unchecked" })
	public List<Classe> listClassesSupprimes() {
		log.debug("********** Debut listClassesSupprimes ClasseDAO **********");
		try {
			List<Classe> classes = null;
			Session session = getSession();
			String strQuery = "select distinct classe ";
			strQuery += "from Classe classe";
			strQuery += "where classe.statut = " + STATUT_SUPPRIME;
			strQuery += " order by classe.classeId asc";
			org.hibernate.Query query = session.createQuery(strQuery);
			classes = query.list();
			return classes;
		} catch (Exception e) {
			e.printStackTrace();
			log.fatal(e.getMessage());
			return null;
		} finally {
			log.debug("********** Fin listClassesSupprimes ClasseDAO **********");
		}
	}

	@Override
	protected Class<?> getEntityClass() {
		return Classe.class;
	}
}
