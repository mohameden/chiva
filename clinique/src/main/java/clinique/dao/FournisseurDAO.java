package clinique.dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import clinique.mapping.Fournisseur;

@Repository
public class FournisseurDAO extends CliniqueHibernateDaoSupport<Fournisseur> {

	private static Logger log = Logger.getLogger(FournisseurDAO.class);

	public Fournisseur getFournisseur(int fournisseurId) {
		log.debug("********** Debut getFournisseur FournisseurDAO **********");

		try {
			Fournisseur fournisseur = null;
			Session session = getSession();
			fournisseur = (Fournisseur) session.get(Fournisseur.class,
					fournisseurId);
			return fournisseur;
		} catch (Exception e) {
			e.printStackTrace();
			log.fatal(e.getMessage());
			return null;
		} finally {
			log.debug("********** Fin getFournisseur FournisseurDAO **********");
		}
	}

	public void saveFournisseur(Fournisseur fournisseur) {
		log.debug("********** Debut saveFournisseur FournisseurDAO **********");
		try {
			Session session = getSession();
			fournisseur.setStatut(STATUT_VALIDE);
			session.save(fournisseur);
		} catch (Exception e) {
			e.printStackTrace();
			log.fatal(e.getMessage());
		} finally {
			log.debug("********** Fin saveFournisseur FournisseurDAO **********");
		}

	}

	public void updateFournisseur(Fournisseur fournisseur) {
		log.debug("********** Debut updateFournisseur FournisseurDAO **********");
		try {
			Session session = getSession();
			session.update(fournisseur);
		} catch (Exception e) {
			e.printStackTrace();
			log.fatal(e.getMessage());
		} finally {
			log.debug("********** Fin updateFournisseur FournisseurDAO **********");
		}
	}

	public void deleteFournisseur(Fournisseur fournisseur) {
		log.debug("********** Debut deleteFournisseur FournisseurDAO **********");
		try {
			Session session = getSession();
			fournisseur.setStatut(STATUT_SUPPRIME);
			session.update(fournisseur);
		} catch (Exception e) {
			e.printStackTrace();
			log.fatal(e.getMessage());
		} finally {
			log.debug("********** Fin deleteFournisseur FournisseurDAO **********");
		}
	}

	@SuppressWarnings("unchecked")
	public Fournisseur getFournisseurByNom(String nomFournisseur) {
		log.debug("********** Debut getFournisseurByNom FournisseursDAO **********");
		if (nomFournisseur == null || nomFournisseur.equals("")) {
			return null;
		}
		try {
			List<Fournisseur> fournisseurs = null;
			Session session = getSession();
			String strQuery = "select distinct fournisseur ";
			strQuery += "from Fournisseur fournisseur";
			strQuery += " where fournisseur.statut = " + STATUT_VALIDE;
			strQuery += " and fournisseur.nomFournisseur = '" + nomFournisseur
					+ "'";
			strQuery += " order by fournisseur.fournisseurId asc";
			org.hibernate.Query query = session.createQuery(strQuery);
			fournisseurs = query.list();
			if (fournisseurs != null && fournisseurs.size() > 0) {
				return fournisseurs.get(0);
			} else {
				return null;
			}
		} catch (Exception e) {
			e.printStackTrace();
			log.fatal(e.getMessage());
			return null;
		} finally {
			log.debug("********** Fin getFournisseurByNom FournisseursDAO **********");
		}
	}

	@SuppressWarnings("unchecked")
	public List<Fournisseur> listFournisseurs() {
		log.debug("********** Debut listFournisseurs FournisseursDAO **********");

		try {
			List<Fournisseur> fournisseurs = null;
			Session session = getSession();
			String strQuery = "select distinct fournisseur ";
			strQuery += "from Fournisseur fournisseur ";
			strQuery += "where fournisseur.statut = " + STATUT_VALIDE;
			strQuery += " order by fournisseur.fournisseurId asc";
			org.hibernate.Query query = session.createQuery(strQuery);
			fournisseurs = query.list();
			return fournisseurs;
		} catch (Exception e) {
			e.printStackTrace();
			log.fatal(e.getMessage());
			return null;
		} finally {
			log.debug("********** Fin listFournisseurs FournisseursDAO **********");
		}
	}

	@SuppressWarnings({ "unchecked" })
	public List<Fournisseur> listFournisseursSupprimes() {
		log.debug("********** Debut listFournisseursSupprimes FournisseurDAO **********");

		try {
			List<Fournisseur> fournisseurs = null;
			Session session = getSession();
			String strQuery = "select distinct fournisseur ";
			strQuery += "from Fournisseur fournisseur";
			strQuery += "where fournisseur.statut = " + STATUT_SUPPRIME;
			strQuery += " order by fournisseur.fournisseurId asc";
			org.hibernate.Query query = session.createQuery(strQuery);
			fournisseurs = query.list();
			return fournisseurs;
		} catch (Exception e) {
			e.printStackTrace();
			log.fatal(e.getMessage());
			return null;
		} finally {
			log.debug("********** Fin listFournisseursSupprimes FournisseurDAO **********");
		}
	}

	@Override
	protected Class<?> getEntityClass() {
		return Fournisseur.class;
	}

}
