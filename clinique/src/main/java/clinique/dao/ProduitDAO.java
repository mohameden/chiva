package clinique.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import clinique.mapping.Produit;

@Repository
public class ProduitDAO extends CliniqueHibernateDaoSupport<Produit> {

	private static Logger log = Logger.getLogger(ProduitDAO.class);

	public Produit getProduit(int produitId) {
		log.debug("********** Debut getProduit ProduitDAO **********");

		try {
			Produit produit = null;
			Session session = getSession();
			produit = (Produit) session.get(Produit.class, produitId);
			return produit;
		} catch (Exception e) {
			e.printStackTrace();
			log.fatal(e.getMessage());
			return null;
		} finally {
			log.debug("********** Fin getProduit ProduitDAO **********");
		}
	}

	public void saveProduit(Produit produit) {
		log.debug("********** Debut saveProduit ProduitDAO **********");
		try {
			Session session = getSession();
			produit.setStatut(STATUT_VALIDE);
			session.save(produit);
		} catch (Exception e) {
			e.printStackTrace();
			log.fatal(e.getMessage());
		} finally {
			log.debug("********** Fin saveProduit ProduitDAO **********");
		}

	}

	public void updateProduit(Produit produit) {
		log.debug("********** Debut updateProduit ProduitDAO **********");
		try {
			Session session = getSession();
			session.update(produit);
		} catch (Exception e) {
			e.printStackTrace();
			log.fatal(e.getMessage());
		} finally {
			log.debug("********** Fin updateProduit ProduitDAO **********");
		}
	}

	public void deleteProduit(Produit produit) {
		log.debug("********** Debut deleteProduit ProduitDAO **********");
		try {
			Session session = getSession();
			produit.setStatut(STATUT_SUPPRIME);
			session.update(produit);
		} catch (Exception e) {
			e.printStackTrace();
			log.fatal(e.getMessage());
		} finally {
			log.debug("********** Fin deleteProduit ProduitDAO **********");
		}
	}

	@SuppressWarnings("unchecked")
	public Produit getProduitByNom(String nomProduit) {
		log.debug("********** Debut getProduitByNom FournisseursDAO **********");

		try {
			List<Produit> produits = null;
			Session session = getSession();
			String strQuery = "select distinct produit ";
			strQuery += "from Produit produit ";
			strQuery += "where produit.statut = " + STATUT_VALIDE;
			strQuery += " and produit.nomProduit = '" + nomProduit + "'";
			strQuery += " order by produit.produitId asc";
			org.hibernate.Query query = session.createQuery(strQuery);
			produits = query.list();
			if (produits != null && produits.size() > 0) {
				return produits.get(0);
			} else {
				return null;
			}
		} catch (Exception e) {
			e.printStackTrace();
			log.fatal(e.getMessage());
			return null;
		} finally {
			log.debug("********** Fin getProduitByNom FournisseursDAO **********");
		}
	}

	@SuppressWarnings("unchecked")
	public ArrayList<Produit> listProduits() {
		log.debug("********** Debut listProduits ProduitDAO **********");

		try {
			ArrayList<Produit> produits = null;
			Session session = getSession();
			String strQuery = "select distinct produit ";
			strQuery += "from Produit produit ";
			strQuery += "where produit.statut = " + STATUT_VALIDE;
			strQuery += " order by produit.classe.classeId asc";
			org.hibernate.Query query = session.createQuery(strQuery);
			produits = (ArrayList) query.list();
			return produits;
		} catch (Exception e) {
			e.printStackTrace();
			log.fatal(e.getMessage());
			return null;
		} finally {
			log.debug("********** Fin listProduits ProduitDAO **********");
		}
	}

	@SuppressWarnings("unchecked")
	public ArrayList<Produit> listProduitsFacturables() {
		log.debug("********** Debut listProduitsFacturables ProduitDAO **********");

		try {
			ArrayList<Produit> produits = null;
			Session session = getSession();
			String strQuery = "select distinct produit ";
			strQuery += "from Produit produit ";
			strQuery += "where produit.statut = " + STATUT_VALIDE;
			strQuery += " and produit.facturable = " + FACTURABLE;
			strQuery += " order by produit.classe.classeId asc";
			org.hibernate.Query query = session.createQuery(strQuery);
			produits = (ArrayList) query.list();
			return produits;
		} catch (Exception e) {
			e.printStackTrace();
			log.fatal(e.getMessage());
			return null;
		} finally {
			log.debug("********** Fin listProduitsFacturables ProduitDAO **********");
		}
	}

	@SuppressWarnings("unchecked")
	public ArrayList<Produit> listProduitsNonFacturables() {
		log.debug("********** Debut listProduitsNonFacturables ProduitDAO **********");

		try {
			ArrayList<Produit> produits = null;
			Session session = getSession();
			String strQuery = "select distinct produit ";
			strQuery += "from Produit produit ";
			strQuery += "where produit.statut = " + STATUT_VALIDE;
			strQuery += " and produit.facturable = " + NON_FACTURABLE;
			strQuery += " order by produit.classe.classeId asc";
			org.hibernate.Query query = session.createQuery(strQuery);
			produits = (ArrayList) query.list();
			return produits;
		} catch (Exception e) {
			e.printStackTrace();
			log.fatal(e.getMessage());
			return null;
		} finally {
			log.debug("********** Fin listProduitsNonFacturables ProduitDAO **********");
		}
	}

	@SuppressWarnings({ "unchecked" })
	public List<Produit> listProduitsSupprimes() {
		log.debug("********** Debut listProduitsSupprimes ProduitDAO **********");

		try {
			List<Produit> produits = null;
			Session session = getSession();
			String strQuery = "select distinct produit ";
			strQuery += "from Produit produit";
			strQuery += "where produit.statut = " + STATUT_SUPPRIME;
			strQuery += " order by produit.produitId asc";
			org.hibernate.Query query = session.createQuery(strQuery);
			produits = query.list();
			return produits;
		} catch (Exception e) {
			e.printStackTrace();
			log.fatal(e.getMessage());
			return null;
		} finally {
			log.debug("********** Fin listProduitsSupprimes ProduitDAO **********");
		}
	}

	@Override
	protected Class<?> getEntityClass() {
		return Produit.class;
	}

}
