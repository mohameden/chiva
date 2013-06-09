package clinique.metier.gestion.commerciale;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.List;

import org.apache.log4j.Logger;
import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionMessages;
import org.apache.struts.util.LabelValueBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import clinique.dao.ActeAssureurDAO;
import clinique.dao.ActeAssureurHDAO;
import clinique.dao.ActeDAO;
import clinique.dao.ActeHDAO;
import clinique.dao.ActeurActeAssureurDAO;
import clinique.dao.ActeurActeAssureurHDAO;
import clinique.dao.ActeurActeDAO;
import clinique.dao.ActeurActeHDAO;
import clinique.dao.ActeurDAO;
import clinique.dao.AssureurDAO;
import clinique.dao.BadgeDAO;
import clinique.dao.BlackListeDAO;
import clinique.dao.CategorieDAO;
import clinique.dao.ChambreDAO;
import clinique.dao.ChambresHospitalisationDAO;
import clinique.dao.ClasseDAO;
import clinique.dao.CompteCategorieDAO;
import clinique.dao.CompteDAO;
import clinique.dao.DetailFactureDAO;
import clinique.dao.DetailFactureModifieesDAO;
import clinique.dao.DevisActesDAO;
import clinique.dao.DevisAssureurDAO;
import clinique.dao.DrgCnamDAO;
import clinique.dao.EntrepriseDAO;
import clinique.dao.ExclusionActeAssureurDAO;
import clinique.dao.FactureDAO;
import clinique.dao.FactureModifieesDAO;
import clinique.dao.FamillePrestationDAO;
import clinique.dao.HospitalisationDAO;
import clinique.dao.ParametresCliniqueDAO;
import clinique.dao.PatientDAO;
import clinique.dao.PatientPcActuelDAO;
import clinique.dao.PcPersonnelDAO;
import clinique.dao.PrestationCouvertesPcDAO;
import clinique.dao.PriseEnChargeDAO;
import clinique.dao.RecuDAO;
import clinique.dao.ReglementDAO;
import clinique.dao.TransactionCompteCategorieDAO;
import clinique.dao.TransactionCompteDAO;
import clinique.dao.TypePayementDAO;
import clinique.dao.UserDAO;
import clinique.mapping.Acte;
import clinique.mapping.ActeAssureur;
import clinique.mapping.ActeAssureurH;
import clinique.mapping.ActeH;
import clinique.mapping.Acteur;
import clinique.mapping.ActeurActe;
import clinique.mapping.ActeurActeAssureur;
import clinique.mapping.ActeurActeAssureurH;
import clinique.mapping.ActeurActeH;
import clinique.mapping.Assureur;
import clinique.mapping.Badge;
import clinique.mapping.BlackListe;
import clinique.mapping.Categorie;
import clinique.mapping.Chambre;
import clinique.mapping.ChambresHospitalisation;
import clinique.mapping.Classe;
import clinique.mapping.Compte;
import clinique.mapping.CompteCategorie;
import clinique.mapping.DetailDgrCnamFacture;
import clinique.mapping.DetailFacture;
import clinique.mapping.DetailFactureModifiees;
import clinique.mapping.DevisActes;
import clinique.mapping.DevisAssureur;
import clinique.mapping.DrgCnam;
import clinique.mapping.Entity.EntityCopier;
import clinique.mapping.Entreprise;
import clinique.mapping.Facture;
import clinique.mapping.FactureModifiees;
import clinique.mapping.FamillePrestation;
import clinique.mapping.Hospitalisation;
import clinique.mapping.Patient;
import clinique.mapping.PatientPcActuel;
import clinique.mapping.PcPersonnel;
import clinique.mapping.PrestationCouvertesPc;
import clinique.mapping.PrestationCouvertesPcModifiee;
import clinique.mapping.PriseEnCharge;
import clinique.mapping.PriseEnChargeModifiee;
import clinique.mapping.Recu;
import clinique.mapping.Reglement;
import clinique.mapping.TransactionCompte;
import clinique.mapping.TransactionCompteCategorie;
import clinique.mapping.TypePayement;
import clinique.mapping.User;
import clinique.metier.TransactionalBO;
import clinique.model.gestion.commerciale.GestionCommercialeForm;
import clinique.utils.ConstantesMetier;
import clinique.utils.UtilDate;

@Service(IGestionCommercialeBO.NAME)
public class GestionCommercialeBO extends TransactionalBO implements
		IGestionCommercialeBO {

	private static Logger log = Logger.getLogger(GestionCommercialeBO.class);

	@Autowired
	private ActeAssureurDAO acteAssureurDAO;
	@Autowired
	private ActeAssureurHDAO acteAssureurHDAO;
	@Autowired
	private ActeDAO acteDAO;
	@Autowired
	private ActeHDAO acteHDAO;
	@Autowired
	private ActeurActeAssureurDAO acteurActeAssureurDAO;
	@Autowired
	private ActeurActeDAO acteurActeDAO;
	@Autowired
	private ActeurActeHDAO acteurActeHDAO;
	@Autowired
	private ActeurDAO acteurDAO;
	@Autowired
	private AssureurDAO assureurDAO;
	@Autowired
	private BadgeDAO badgeDAO;
	@Autowired
	private BlackListeDAO blackListeDAO;
	@Autowired
	private CategorieDAO categorieDAO;
	@Autowired
	private ChambreDAO chambreDAO;
	@Autowired
	private ChambresHospitalisationDAO chambresHospitalisationDAO;
	@Autowired
	private ClasseDAO classeDAO;
	@Autowired
	private CompteDAO compteDAO;
	@Autowired
	private DetailFactureDAO detailFactureDAO;
	@Autowired
	private DetailFactureModifieesDAO detailFactureModifieesDAO;
	@Autowired
	private DevisActesDAO devisActesDAO;
	@Autowired
	private DevisAssureurDAO devisAssureurDAO;
	@Autowired
	private DrgCnamDAO drgCnamDAO;
	@Autowired
	private EntrepriseDAO entrepriseDAO;
	@Autowired
	private ExclusionActeAssureurDAO exclusionActeAssureurDAO;
	@Autowired
	private FactureDAO factureDAO;
	@Autowired
	private FactureModifieesDAO factureModifieesDAO;
	@Autowired
	private FamillePrestationDAO famillePrestationDAO;
	@Autowired
	private HospitalisationDAO hospitalisationDAO;
	@Autowired
	private ParametresCliniqueDAO parametresCliniqueDAO;
	@Autowired
	private PatientDAO patientDAO;
	@Autowired
	private PatientPcActuelDAO patientPcActuelDAO;
	@Autowired
	private PcPersonnelDAO pcPersonnelDAO;
	@Autowired
	private PriseEnChargeDAO priseEnChargeDAO;
	@Autowired
	private PrestationCouvertesPcDAO prestationCouvertesPcDAO;
	@Autowired
	private RecuDAO recuDAO;
	@Autowired
	private ReglementDAO reglementDAO;
	@Autowired
	private TransactionCompteCategorieDAO transactionCompteCategorieDAO;
	@Autowired
	private TransactionCompteDAO transactionCompteDAO;
	@Autowired
	private TypePayementDAO typePayementDAO;
	@Autowired
	private UserDAO userDAO;
	@Autowired
	private ActeurActeAssureurHDAO acteurActeAssureurHDAO;
	@Autowired
	private CompteCategorieDAO compteCategorieDAO;

	private ActeAssureurDAO getActeAssureurDAO() {
		return acteAssureurDAO;
	}

	private ActeAssureurHDAO getActeAssureurHDAO() {
		return acteAssureurHDAO;
	}

	private ActeDAO getActeDAO() {
		return acteDAO;
	}

	private ActeHDAO getActeHDAO() {
		return acteHDAO;
	}

	private ActeurActeAssureurDAO getActeurActeAssureurDAO() {
		return acteurActeAssureurDAO;
	}

	private ActeurActeDAO getActeurActeDAO() {
		return acteurActeDAO;
	}

	private ActeurActeHDAO getActeurActeHDAO() {
		return acteurActeHDAO;
	}

	private ActeurDAO getActeurDAO() {
		return acteurDAO;
	}

	private AssureurDAO getAssureurDAO() {
		return assureurDAO;
	}

	private CategorieDAO getCategorieDAO() {
		return categorieDAO;
	}

	private ChambreDAO getChambreDAO() {
		return chambreDAO;
	}

	private ClasseDAO getClasseDAO() {
		return classeDAO;
	}

	private CompteDAO getCompteDAO() {
		return compteDAO;
	}

	private DevisAssureurDAO getDevisAssureurDAO() {
		return devisAssureurDAO;
	}

	private DrgCnamDAO getDrgCnamDAO() {
		return drgCnamDAO;
	}

	private ExclusionActeAssureurDAO getExclusionActeAssureurDAO() {
		return exclusionActeAssureurDAO;
	}

	private FactureDAO getFactureDAO() {
		return factureDAO;
	}

	private FamillePrestationDAO getFamillePrestationDAO() {
		return famillePrestationDAO;
	}

	private HospitalisationDAO getHospitalisationDAO() {
		return hospitalisationDAO;
	}

	private ParametresCliniqueDAO getParametresCliniqueDAO() {
		return parametresCliniqueDAO;
	}

	private PatientDAO getPatientDAO() {
		return patientDAO;
	}

	private PatientPcActuelDAO getPatientPcActuelDAO() {
		return patientPcActuelDAO;
	}

	private PcPersonnelDAO getPcPersonnelDAO() {
		return pcPersonnelDAO;
	}

	private TypePayementDAO getTypePayementDAO() {
		return typePayementDAO;
	}

	private UserDAO getUserDao() {
		return userDAO;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * clinique.metier.gestion.commerciale.IGestionCommercialeBO#addActeBadge
	 * (clinique.model.gestion.commerciale.GestionCommercialeForm, double)
	 */
	@Override
	public void addActeBadge(GestionCommercialeForm formulaire, double prixActe) {
		int pourcentage = getCategorieDAO().getCategorie(
				Integer.parseInt(formulaire.getCategorieId())).getPourcentage();
		int nbreActe = Integer.parseInt(formulaire.getNombreActe());

		formulaire.setCoteAssureur(String.valueOf(Double.parseDouble(formulaire
				.getCoteAssureur()) + prixActe * nbreActe * pourcentage / 100));

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see clinique.metier.gestion.commerciale.IGestionCommercialeBO#
	 * addActeBadgeFromDetailFacture
	 * (clinique.model.gestion.commerciale.GestionCommercialeForm, double,
	 * clinique.mapping.DetailFacture)
	 */
	@Override
	public void addActeBadgeFromDetailFacture(
			GestionCommercialeForm formulaire, double prixActe, DetailFacture df) {
		int pourcentage = getCategorieDAO().getCategorie(
				Integer.parseInt(formulaire.getCategorieId())).getPourcentage();
		int nbreActe = df.getNbrActes();

		formulaire.setCoteAssureur(String.valueOf(Double.parseDouble(formulaire
				.getCoteAssureur()) + prixActe * nbreActe * pourcentage / 100));

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see clinique.metier.gestion.commerciale.IGestionCommercialeBO#
	 * addActeNombreActeLimiteAvecPlafond
	 * (clinique.model.gestion.commerciale.GestionCommercialeForm, int, int,
	 * clinique.mapping.PrestationCouvertesPc, double, int, double)
	 */
	@Override
	public void addActeNombreActeLimiteAvecPlafond(
			GestionCommercialeForm formulaire, int pourcentage, int nbreActe,
			PrestationCouvertesPc pcCouv, double prixActe, int nbreActeRestant,
			double plafondRestant) {
		nbreActeRestant = pcCouv.getNbreActesRestant();
		double prixActes = prixActe * nbreActe;
		// nbre acte restant < nbre acte saisi
		if (nbreActe > nbreActeRestant) {
			prixActes = prixActe * nbreActeRestant;
			// pourcentage non defini
			if (pourcentage == 0) {

				if (prixActes > plafondRestant) {
					formulaire.setCoteAssureur(String.valueOf(Double
							.parseDouble(formulaire.getCoteAssureur())
							+ plafondRestant));
				} else {
					formulaire.setCoteAssureur(String.valueOf(Double
							.parseDouble(formulaire.getCoteAssureur())
							+ prixActes));
				}

				pcCouv.setNbreActesRestant(0);
				setPrestCouvAtList(pcCouv, formulaire);
			}

			// pourcentage defini
			else {
				if (prixActes > plafondRestant) {
					formulaire.setCoteAssureur(String.valueOf(Double
							.parseDouble(formulaire.getCoteAssureur())
							+ plafondRestant * pourcentage / 100));
				} else {
					formulaire.setCoteAssureur(String.valueOf(Double
							.parseDouble(formulaire.getCoteAssureur())
							+ prixActes * pourcentage / 100));
				}
				pcCouv.setNbreActesRestant(0);
				setPrestCouvAtList(pcCouv, formulaire);
			}
		}

		// nbre acte restant >= nbre acte saisi
		else {

			// pourcentage non defini
			if (pourcentage == 0) {
				if (prixActes > plafondRestant) {
					formulaire.setCoteAssureur(String.valueOf(Double
							.parseDouble(formulaire.getCoteAssureur())
							+ plafondRestant));
				} else {
					formulaire.setCoteAssureur(String.valueOf(Double
							.parseDouble(formulaire.getCoteAssureur())
							+ prixActes));
				}
				pcCouv.setNbreActesRestant(nbreActeRestant - nbreActe);
				setPrestCouvAtList(pcCouv, formulaire);

			}
			// pourcentage defini
			else {
				if (prixActes > plafondRestant) {
					formulaire.setCoteAssureur(String.valueOf(Double
							.parseDouble(formulaire.getCoteAssureur())
							+ plafondRestant * pourcentage / 100));
				} else {
					formulaire.setCoteAssureur(String.valueOf(Double
							.parseDouble(formulaire.getCoteAssureur())
							+ prixActes * pourcentage / 100));
				}
				pcCouv.setNbreActesRestant(nbreActeRestant - nbreActe);
				setPrestCouvAtList(pcCouv, formulaire);
			}
		}

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see clinique.metier.gestion.commerciale.IGestionCommercialeBO#
	 * addActeNombreActeLimiteSansPlafond
	 * (clinique.model.gestion.commerciale.GestionCommercialeForm, int, int,
	 * clinique.mapping.PrestationCouvertesPc, double, int)
	 */
	@Override
	public void addActeNombreActeLimiteSansPlafond(
			GestionCommercialeForm formulaire, int pourcentage, int nbreActe,
			PrestationCouvertesPc pcCouv, double prixActe, int nbreActeRestant) {
		nbreActeRestant = pcCouv.getNbreActesRestant();
		// nbre acte restant < nbre acte saisi
		if (nbreActe > nbreActeRestant) {
			// pourcentage non defini
			if (pourcentage == 0) {
				formulaire.setCoteAssureur(String.valueOf(Double
						.parseDouble(formulaire.getCoteAssureur())
						+ prixActe
						* nbreActeRestant));
				pcCouv.setNbreActesRestant(0);
				setPrestCouvAtList(pcCouv, formulaire);
			}
			// pourcentage defini
			else {
				formulaire.setCoteAssureur(String.valueOf(Double
						.parseDouble(formulaire.getCoteAssureur())
						+ prixActe
						* nbreActeRestant * pourcentage / 100));
				pcCouv.setNbreActesRestant(0);
				setPrestCouvAtList(pcCouv, formulaire);
			}
		}

		// nbre acte restant >= nbre acte saisi
		else {
			// pourcentage non defini
			if (pourcentage == 0) {
				formulaire.setCoteAssureur(String.valueOf(Double
						.parseDouble(formulaire.getCoteAssureur())
						+ prixActe
						* nbreActe));
				pcCouv.setNbreActesRestant(nbreActeRestant - nbreActe);
				setPrestCouvAtList(pcCouv, formulaire);

			}
			// pourcentage defini
			else {
				formulaire.setCoteAssureur(String.valueOf(Double
						.parseDouble(formulaire.getCoteAssureur())
						+ prixActe
						* nbreActe * pourcentage / 100));
				pcCouv.setNbreActesRestant(nbreActeRestant - nbreActe);
				setPrestCouvAtList(pcCouv, formulaire);
			}
		}

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * clinique.metier.gestion.commerciale.IGestionCommercialeBO#addActePC(clinique
	 * .model.gestion.commerciale.GestionCommercialeForm, double)
	 */
	@Override
	public void addActePC(GestionCommercialeForm formulaire, double prixActe) {
		PrestationCouvertesPc pcCouv = getPrestationCouverte(formulaire);
		int nbreActeRestant = 0;
		int pourcentage = formulaire.getPriseEnCharge().getPourcentage();
		int nbreActe = Integer.parseInt(formulaire.getNombreActe());
		@SuppressWarnings("unused")
		double montantFacture = Double.parseDouble(formulaire.getTotalApayer())
				+ formulaire.getPriseEnCharge().getMontantFact();
		// plafond defini
		if (pcCouv != null) {
			if (formulaire.getPriseEnCharge().getPlafond() == 0) {

				// nbre actes limité
				if (pcCouv.getLimite().equals("1")
						&& pcCouv.getNbreActesRestant() > 0) {

					addActeNombreActeLimiteSansPlafond(formulaire, pourcentage,
							nbreActe, pcCouv, prixActe, nbreActeRestant);
				}

				// nbre actes non limité
				else {
					// pourcentage non defini
					if (pourcentage == 0) {
						formulaire.setCoteAssureur(String.valueOf(Double
								.parseDouble(formulaire.getCoteAssureur())
								+ prixActe * nbreActe));
					}
					// pourcentage defini
					else {
						formulaire.setCoteAssureur(String.valueOf(Double
								.parseDouble(formulaire.getCoteAssureur())
								+ prixActe * nbreActe * pourcentage / 100));

					}
				}

			}

			// palfond defini
			else {

				double plafondRestant = formulaire.getPriseEnCharge()
						.getPlafond()
						- (formulaire.getPriseEnCharge().getMontantFact() + Double
								.parseDouble(formulaire.getTotalApayer()));
				if (plafondRestant >= 0) {
					// nbre actes limité
					if (pcCouv.getLimite().equals("1")
							&& pcCouv.getNbreActesRestant() > 0) {
						addActeNombreActeLimiteAvecPlafond(formulaire,
								pourcentage, nbreActe, pcCouv, prixActe,
								nbreActeRestant, plafondRestant);
					}

					// nbre actes non limité
					else {
						// pourcentage non defini
						if (pourcentage == 0) {
							if (prixActe * nbreActe > plafondRestant) {
								formulaire.setCoteAssureur(String
										.valueOf(Double.parseDouble(formulaire
												.getCoteAssureur())
												+ plafondRestant));
							} else {
								formulaire.setCoteAssureur(String
										.valueOf(Double.parseDouble(formulaire
												.getCoteAssureur())
												+ prixActe
												* nbreActe));
							}

						}
						// pourcentage defini
						else {
							if (prixActe * nbreActe > plafondRestant) {
								formulaire.setCoteAssureur(String
										.valueOf(Double.parseDouble(formulaire
												.getCoteAssureur())
												+ plafondRestant
												* pourcentage
												/ 100));
							} else {
								formulaire
										.setCoteAssureur(String.valueOf(Double
												.parseDouble(formulaire
														.getCoteAssureur())
												+ prixActe
												* nbreActe
												* pourcentage / 100));
							}

						}
					}
				}
			}

		}

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see clinique.metier.gestion.commerciale.IGestionCommercialeBO#
	 * addActePCFromDetailFacture
	 * (clinique.model.gestion.commerciale.GestionCommercialeForm, double,
	 * clinique.mapping.DetailFacture)
	 */
	@Override
	public void addActePCFromDetailFacture(GestionCommercialeForm formulaire,
			double prixActe, DetailFacture df) {
		PrestationCouvertesPc pcCouv = getPrestationCouverte(formulaire);
		int nbreActeRestant = 0;
		int pourcentage = formulaire.getPriseEnCharge().getPourcentage();
		int nbreActe = df.getNbrActes();
		@SuppressWarnings("unused")
		double montantFacture = Double.parseDouble(formulaire.getTotalApayer())
				+ formulaire.getPriseEnCharge().getMontantFact();
		// plafond defini
		if (pcCouv != null) {
			if (formulaire.getPriseEnCharge().getPlafond() == 0) {

				// nbre actes limité
				if (pcCouv.getLimite().equals("1")
						&& pcCouv.getNbreActesRestant() > 0) {

					addActeNombreActeLimiteSansPlafond(formulaire, pourcentage,
							nbreActe, pcCouv, prixActe, nbreActeRestant);
				}

				// nbre actes non limité
				else {
					// pourcentage non defini
					if (pourcentage == 0) {
						formulaire.setCoteAssureur(String.valueOf(Double
								.parseDouble(formulaire.getCoteAssureur())
								+ prixActe * nbreActe));

					}
					// pourcentage defini
					else {
						formulaire.setCoteAssureur(String.valueOf(Double
								.parseDouble(formulaire.getCoteAssureur())
								+ prixActe * nbreActe * pourcentage / 100));

					}
				}

			}

			// palfond defini
			else {

				double plafondRestant = formulaire.getPriseEnCharge()
						.getPlafond()
						- (formulaire.getPriseEnCharge().getMontantFact() + Double
								.parseDouble(formulaire.getTotalApayer()));
				if (plafondRestant >= 0) {
					// nbre actes limité
					if (pcCouv.getLimite().equals("1")
							&& pcCouv.getNbreActesRestant() > 0) {

						addActeNombreActeLimiteAvecPlafond(formulaire,
								pourcentage, nbreActe, pcCouv, prixActe,
								nbreActeRestant, plafondRestant);
					}

					// nbre actes non limité
					else {
						// pourcentage non defini
						if (pourcentage == 0) {
							if (prixActe * nbreActe > plafondRestant) {
								formulaire.setCoteAssureur(String
										.valueOf(Double.parseDouble(formulaire
												.getCoteAssureur())
												+ plafondRestant));
							} else {
								formulaire.setCoteAssureur(String
										.valueOf(Double.parseDouble(formulaire
												.getCoteAssureur())
												+ prixActe
												* nbreActe));
							}

						}
						// pourcentage defini
						else {
							if (prixActe * nbreActe > plafondRestant) {
								formulaire.setCoteAssureur(String
										.valueOf(Double.parseDouble(formulaire
												.getCoteAssureur())
												+ plafondRestant
												* pourcentage
												/ 100));
							} else {
								formulaire
										.setCoteAssureur(String.valueOf(Double
												.parseDouble(formulaire
														.getCoteAssureur())
												+ prixActe
												* nbreActe
												* pourcentage / 100));
							}

						}
					}
				}
			}

		}

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see clinique.metier.gestion.commerciale.IGestionCommercialeBO#
	 * addActePCWithoutPrestationCouv
	 * (clinique.model.gestion.commerciale.GestionCommercialeForm, double)
	 */
	@Override
	public void addActePCWithoutPrestationCouv(
			GestionCommercialeForm formulaire, double prixActe) {

		// int nbreActeRestant=0;
		int pourcentage = formulaire.getPriseEnCharge().getPourcentage();
		int nbreActe = Integer.parseInt(formulaire.getNombreActe());
		@SuppressWarnings("unused")
		double montantFacture = Double.parseDouble(formulaire.getTotalApayer())
				+ formulaire.getPriseEnCharge().getMontantFact();
		// plafond non defini
		if (formulaire.getPriseEnCharge().getPlafond() == 0) {

			// pourcentage defini
			if (pourcentage > 0) {
				formulaire.setCoteAssureur(String.valueOf(Double
						.parseDouble(formulaire.getCoteAssureur())
						+ prixActe
						* nbreActe * pourcentage / 100));

			}

		}

		// palfond defini
		else {
			double plafondRestant = formulaire.getPriseEnCharge().getPlafond()
					- (formulaire.getPriseEnCharge().getMontantFact() + Double
							.parseDouble(formulaire.getTotalApayer()));
			if (plafondRestant >= 0) {

				// pourcentage non defini
				if (pourcentage == 0) {
					if (prixActe * nbreActe > plafondRestant) {
						formulaire.setCoteAssureur(String.valueOf(Double
								.parseDouble(formulaire.getCoteAssureur())
								+ plafondRestant));
					} else {
						formulaire.setCoteAssureur(String.valueOf(Double
								.parseDouble(formulaire.getCoteAssureur())
								+ prixActe * nbreActe));
					}

				}
				// pourcentage defini
				else {
					if (prixActe * nbreActe > plafondRestant) {
						formulaire.setCoteAssureur(String.valueOf(Double
								.parseDouble(formulaire.getCoteAssureur())
								+ plafondRestant * pourcentage / 100));
					} else {
						formulaire.setCoteAssureur(String.valueOf(Double
								.parseDouble(formulaire.getCoteAssureur())
								+ prixActe * nbreActe * pourcentage / 100));
					}

				}

			}
		}

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see clinique.metier.gestion.commerciale.IGestionCommercialeBO#
	 * addActePCWithoutPrestationCouvFromDetailFacture
	 * (clinique.model.gestion.commerciale.GestionCommercialeForm, double,
	 * clinique.mapping.DetailFacture)
	 */
	@Override
	public void addActePCWithoutPrestationCouvFromDetailFacture(
			GestionCommercialeForm formulaire, double prixActe, DetailFacture df) {

		// int nbreActeRestant=0;
		int pourcentage = formulaire.getPriseEnCharge().getPourcentage();
		int nbreActe = df.getNbrActes();
		@SuppressWarnings("unused")
		double montantFacture = Double.parseDouble(formulaire.getTotalApayer())
				+ formulaire.getPriseEnCharge().getMontantFact();
		// plafond non defini
		if (formulaire.getPriseEnCharge().getPlafond() == 0) {

			// pourcentage defini
			if (pourcentage > 0) {
				formulaire.setCoteAssureur(String.valueOf(Double
						.parseDouble(formulaire.getCoteAssureur())
						+ prixActe
						* nbreActe * pourcentage / 100));

			}

		}

		// palfond defini
		else {
			double plafondRestant = formulaire.getPriseEnCharge().getPlafond()
					- (formulaire.getPriseEnCharge().getMontantFact() + Double
							.parseDouble(formulaire.getTotalApayer()));
			if (plafondRestant >= 0) {

				// pourcentage non defini
				if (pourcentage == 0) {
					if (prixActe * nbreActe > plafondRestant) {
						formulaire.setCoteAssureur(String.valueOf(Double
								.parseDouble(formulaire.getCoteAssureur())
								+ plafondRestant));
					} else {
						formulaire.setCoteAssureur(String.valueOf(Double
								.parseDouble(formulaire.getCoteAssureur())
								+ prixActe * nbreActe));
					}

				}
				// pourcentage defini
				else {
					if (prixActe * nbreActe > plafondRestant) {
						formulaire.setCoteAssureur(String.valueOf(Double
								.parseDouble(formulaire.getCoteAssureur())
								+ plafondRestant * pourcentage / 100));
					} else {
						formulaire.setCoteAssureur(String.valueOf(Double
								.parseDouble(formulaire.getCoteAssureur())
								+ prixActe * nbreActe * pourcentage / 100));
					}

				}

			}
		}

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see clinique.metier.gestion.commerciale.IGestionCommercialeBO#
	 * addAncienDevisPatientWithoutPCInfos
	 * (clinique.model.gestion.commerciale.GestionCommercialeForm)
	 */
	@Override
	@SuppressWarnings({ "finally", "unchecked" })
	public boolean addAncienDevisPatientWithoutPCInfos(
			GestionCommercialeForm formulaire) throws Exception {

		log.debug("********** Debut addAncienPatientWithoutPCInfos GestionCommercialeBO **********");
		boolean result = false;

		try {

			Patient patient = formulaire.getPatient();
			patient.setDateDerniereVisite(UtilDate.getInstance().getDateToday());

			formulaire.setPatient(patient);
			formulaire.setOperation("ancienWithoutPC");
			result = true;
		} catch (Exception e) {
			result = false;
			log.fatal(e.getMessage());
		}

		finally {
			log.debug("********** Debut addAncienPatientWithoutPCInfos GestionCommercialeBO **********");
			return result;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see clinique.metier.gestion.commerciale.IGestionCommercialeBO#
	 * addAncienPatientWithoutPCInfos
	 * (clinique.model.gestion.commerciale.GestionCommercialeForm)
	 */
	@Override
	@SuppressWarnings({ "finally", "unchecked" })
	public boolean addAncienPatientWithoutPCInfos(
			GestionCommercialeForm formulaire) throws Exception {

		log.debug("********** Debut addAncienPatientWithoutPCInfos GestionCommercialeBO **********");
		boolean result = false;

		try {

			Patient patient = formulaire.getPatient();
			patient.setDateDerniereVisite(UtilDate.getInstance().getDateToday());

			if (formulaire.getPriseEnChargeFlag().equals("priseEnCharge")) {
				PriseEnCharge pc = new PriseEnCharge();
				patient.setCategorie(getCategorieDAO().getCategorie(
						Integer.parseInt(formulaire.getCategorieId())));

				// debut id pc 14
				formulaire.setPcId(ConstantesMetier.ID_PRISEENCHARGE
						+ UtilDate.getInstance().getDateForId()
						+ ""
						+ getUserDao()
								.getUserByLogin(formulaire.getOperateur())
								.getUserId());

				pc.setPcId(formulaire.getPcId());
				pc.setPatient(patient);
				pc.setPcNum(formulaire.getNumPC());

				if (!UtilDate.getInstance().isVide(formulaire.getPlafond())) {
					pc.setPlafond(Double.parseDouble(formulaire.getPlafond()));
				}

				if (!UtilDate.getInstance().isVide(formulaire.getPourcentage())) {
					pc.setPourcentage(Integer.parseInt(formulaire
							.getPourcentage()));
				}

				if (!UtilDate.getInstance()
						.isVide(formulaire.getDateCreation())) {
					pc.setDateCreation(UtilDate.getInstance().stringToDate(
							formulaire.getDateCreation()));

					if (!UtilDate.getInstance().isVide(
							formulaire.getFinValidite())) {
						pc.setFinValidite(UtilDate.getInstance().stringToDate(
								formulaire.getFinValidite()));
					} else {
						pc.setFinValidite(UtilDate.getInstance().plusUnMois(
								UtilDate.getInstance().stringToDate(
										formulaire.getDateCreation())));
					}
				}

				else {
					pc.setFinValidite(UtilDate.getInstance().plusUnMois(
							UtilDate.getInstance().getDateToday()));
				}

				pc.setStatut("1");
				pc.setMontantFact(0);
				pc.setOperateur(formulaire.getOperateur());

				List prestCouvList = formulaire.getPrestationCouvertesPcs();

				for (Iterator iter = prestCouvList.iterator(); iter.hasNext();) {
					PrestationCouvertesPc element = (PrestationCouvertesPc) iter
							.next();
					element.setStatut("1");
					element.setPriseEnCharge(pc);
					prestationCouvertesPcDAO.save(element);
				}

				formulaire.setPriseEnCharge(pc);

			}

			else if (formulaire.getPriseEnChargeFlag().equals("badge")) {
				patient.setCategorie(getCategorieDAO().getCategorie(
						Integer.parseInt(formulaire.getCategorieId())));

				Badge badge = new Badge();
				// debut id badge 19
				badge.setBadgeId(ConstantesMetier.ID_BADGE
						+ UtilDate.getInstance().getDateForId()
						+ ""
						+ getUserDao()
								.getUserByLogin(formulaire.getOperateur())
								.getUserId());
				badge.setCategorie(getCategorieDAO().getCategorie(
						Integer.parseInt(formulaire.getCategorieId())));
				badge.setDateDebut(UtilDate.getInstance().getDateToday());
				badge.setStatut("1");
				badge.setPatient(patient);
				formulaire.setBadge(badge);
			}

			formulaire.setPatient(patient);
			formulaire.setOperation("ancienWithoutPC");
			result = true;
		} catch (Exception e) {
			result = false;
			log.fatal(e.getMessage());
		}

		finally {
			// session.close();
			log.debug("********** Debut addAncienPatientWithoutPCInfos GestionCommercialeBO **********");
			return result;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see clinique.metier.gestion.commerciale.IGestionCommercialeBO#
	 * addAncienPatientWithPC
	 * (clinique.model.gestion.commerciale.GestionCommercialeForm)
	 */
	@Override
	@SuppressWarnings({ "finally", "unchecked" })
	public boolean addAncienPatientWithPC(GestionCommercialeForm formulaire)
			throws Exception {

		log.debug("********** Debut addAncienPatientWithPC GestionCommercialeBO **********");
		boolean result = false;

		try {

			Patient patient = formulaire.getPatient();
			patient.setDateDerniereVisite(UtilDate.getInstance().getDateToday());

			formulaire.setPatient(patient);
			formulaire.setOperation("ancienWithPC");
			result = true;
		} catch (Exception e) {
			result = false;
			log.fatal(e.getMessage());
		}

		finally {
			log.debug("********** Fin addAncienPatientWithPC GestionCommercialeBO **********");
			return result;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * clinique.metier.gestion.commerciale.IGestionCommercialeBO#addFraisChambre
	 * (clinique.model.gestion.commerciale.GestionCommercialeForm, double)
	 */
	@Override
	public void addFraisChambre(GestionCommercialeForm formulaire, double frais) {
		double totalApayer = Double.parseDouble(formulaire.getTotalApayer())
				+ frais;
		formulaire.setTotalApayer(String.valueOf(totalApayer));

		double coteClinique = Double.parseDouble(formulaire.getCoteClinique())
				+ frais;
		formulaire.setCoteClinique(String.valueOf(coteClinique));

		double coteCliniqueReductible = Double.parseDouble(formulaire
				.getCoteCliniqueReductible()) + frais;
		formulaire.setCoteCliniqueReductible(String
				.valueOf(coteCliniqueReductible));

		formulaire.setResteApayer(String.valueOf(totalApayer
				- Double.parseDouble(formulaire.getCoteAssureur())));

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see clinique.metier.gestion.commerciale.IGestionCommercialeBO#
	 * addPatientForPrestations
	 * (clinique.model.gestion.commerciale.GestionCommercialeForm)
	 */
	@Override
	@SuppressWarnings({ "finally", "unchecked" })
	public boolean addPatientForPrestations(GestionCommercialeForm formulaire)
			throws Exception {

		log.debug("********** Debut addPatientForPrestations GestionCommercialeBO **********");
		boolean result = false;
		String idPatient = null;
		try {

			Patient patient = new Patient();
			idPatient = UtilDate.getInstance().getDateForId()
					+ ""
					+ getUserDao().getUserByLogin(formulaire.getOperateur())
							.getUserId();
			patient.setPatientId(idPatient);

			if (!UtilDate.getInstance().isVide(formulaire.getAdresse())) {
				patient.setAdresse(formulaire.getAdresse());
			}
			if (!UtilDate.getInstance().isVide(formulaire.getNom())) {
				patient.setNom(formulaire.getNom());
			}

			if (!UtilDate.getInstance().isVide(formulaire.getPrenom())) {
				patient.setPrenom(formulaire.getPrenom());
			}

			if (!UtilDate.getInstance().isVide(formulaire.getLieuNaissance())) {
				patient.setLieuNaissance(formulaire.getLieuNaissance());
			}

			if (!UtilDate.getInstance().isVide(formulaire.getTelephone())) {
				patient.setTelephone(formulaire.getTelephone());
			}

			if (!UtilDate.getInstance().isVide(formulaire.getDateNaissance())) {
				patient.setDateNaissance(UtilDate.getInstance().stringToDate(
						formulaire.getDateNaissance()));
			}

			if (!UtilDate.getInstance().isVide(formulaire.getNni())) {
				patient.setNni(formulaire.getNni());
			}

			if (!UtilDate.getInstance().isVide(formulaire.getCni())) {
				patient.setNni(formulaire.getCni());
			}

			patient.setDatePremiereViste(UtilDate.getInstance().getDateToday());
			patient.setDateDerniereVisite(UtilDate.getInstance().getDateToday());

			patient.setPriseEnChargeFlag("aucune");

			if (formulaire.getPriseEnChargeFlag().equals("priseEnCharge")) {
				PriseEnCharge pc = new PriseEnCharge();
				patient.setCategorie(getCategorieDAO().getCategorie(
						Integer.parseInt(formulaire.getCategorieId())));

				formulaire.setPcId(ConstantesMetier.ID_PRISEENCHARGE
						+ UtilDate.getInstance().getDateForId()
						+ ""
						+ getUserDao()
								.getUserByLogin(formulaire.getOperateur())
								.getUserId());

				pc.setPcId(formulaire.getPcId());
				pc.setPatient(patient);
				pc.setPcNum(formulaire.getNumPC());

				if (!UtilDate.getInstance().isVide(formulaire.getPlafond())) {
					pc.setPlafond(Double.parseDouble(formulaire.getPlafond()));
				}

				if (!UtilDate.getInstance().isVide(formulaire.getPourcentage())) {
					pc.setPourcentage(Integer.parseInt(formulaire
							.getPourcentage()));
				}

				if (!UtilDate.getInstance()
						.isVide(formulaire.getDateCreation())) {
					pc.setDateCreation(UtilDate.getInstance().stringToDate(
							formulaire.getDateCreation()));

					if (!UtilDate.getInstance().isVide(
							formulaire.getFinValidite())) {
						pc.setFinValidite(UtilDate.getInstance().stringToDate(
								formulaire.getFinValidite()));
					} else {
						pc.setFinValidite(UtilDate.getInstance().plusUnMois(
								UtilDate.getInstance().stringToDate(
										formulaire.getDateCreation())));
					}

				}

				else {
					pc.setFinValidite(UtilDate.getInstance().plusUnMois(
							UtilDate.getInstance().getDateToday()));
				}

				pc.setStatut("1");
				pc.setMontantFact(0);
				pc.setOperateur(formulaire.getOperateur());

				List prestCouvList = formulaire.getPrestationCouvertesPcs();

				for (Iterator iter = prestCouvList.iterator(); iter.hasNext();) {
					PrestationCouvertesPc element = (PrestationCouvertesPc) iter
							.next();
					element.setStatut("1");
					element.setPriseEnCharge(pc);
					prestationCouvertesPcDAO.save(element);
				}

				formulaire.setPriseEnCharge(pc);
				formulaire.setLibeleAssureur(patient.getCategorie()
						.getNomCategorie());
				patient.setPriseEnChargeFlag("priseEnCharge");
				// patient.setPriseEnChargeActuelle(pc);

			}

			else if (formulaire.getPriseEnChargeFlag().equals("badge")) {
				patient.setCategorie(getCategorieDAO().getCategorie(
						Integer.parseInt(formulaire.getCategorieId())));

				Badge badge = new Badge();
				// debut id badge 19
				badge.setBadgeId(ConstantesMetier.ID_BADGE
						+ UtilDate.getInstance().getDateForId()
						+ ""
						+ getUserDao()
								.getUserByLogin(formulaire.getOperateur())
								.getUserId());
				badge.setCategorie(getCategorieDAO().getCategorie(
						Integer.parseInt(formulaire.getCategorieId())));
				badge.setDateDebut(UtilDate.getInstance().getDateToday());
				badge.setStatut("1");
				badge.setPatient(patient);
				badge.setNumeroBadge(formulaire.getNumeroBadge());
				patient.setPriseEnChargeFlag("badge");
				formulaire.setLibeleAssureur(patient.getCategorie()
						.getNomCategorie());
				formulaire.setBadge(badge);
				patient.setPriseEnChargeFlag("badge");
				// patient.setBadgeActuel(badge);

			}

			formulaire.setOperation("nouveau");
			formulaire.setPatient(patient);
			formulaire.setPatientId(idPatient);

			result = true;
		} catch (Exception e) {
			result = false;
			log.fatal(e.getMessage());
		}

		finally {
			// session.close();
			log.debug("********** Debut addPatientForPrestations GestionCommercialeBO **********");
			return result;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see clinique.metier.gestion.commerciale.IGestionCommercialeBO#
	 * addPatientForPrestationsDevis
	 * (clinique.model.gestion.commerciale.GestionCommercialeForm)
	 */
	@Override
	@SuppressWarnings({ "finally", "unchecked" })
	public boolean addPatientForPrestationsDevis(
			GestionCommercialeForm formulaire) throws Exception {

		log.debug("********** Debut addPatientForPrestationsDevis GestionCommercialeBO **********");
		boolean result = false;
		String idPatient = null;
		try {

			Patient patient = new Patient();
			idPatient = UtilDate.getInstance().getDateForId()
					+ ""
					+ getUserDao().getUserByLogin(formulaire.getOperateur())
							.getUserId();
			patient.setPatientId(idPatient);

			if (!UtilDate.getInstance().isVide(formulaire.getAdresse())) {
				patient.setAdresse(formulaire.getAdresse());
			}
			if (!UtilDate.getInstance().isVide(formulaire.getNom())) {
				patient.setNom(formulaire.getNom());
			}

			if (!UtilDate.getInstance().isVide(formulaire.getPrenom())) {
				patient.setPrenom(formulaire.getPrenom());
			}

			if (!UtilDate.getInstance().isVide(formulaire.getLieuNaissance())) {
				patient.setLieuNaissance(formulaire.getLieuNaissance());
			}

			if (!UtilDate.getInstance().isVide(formulaire.getTelephone())) {
				patient.setTelephone(formulaire.getTelephone());
			}

			if (!UtilDate.getInstance().isVide(formulaire.getDateNaissance())) {
				patient.setDateNaissance(UtilDate.getInstance().stringToDate(
						formulaire.getDateNaissance()));
			}

			if (!UtilDate.getInstance().isVide(formulaire.getNni())) {
				patient.setNni(formulaire.getNni());
			}

			if (!UtilDate.getInstance().isVide(formulaire.getCni())) {
				patient.setNni(formulaire.getCni());
			}

			patient.setDatePremiereViste(UtilDate.getInstance().getDateToday());
			patient.setDateDerniereVisite(UtilDate.getInstance().getDateToday());

			patient.setPriseEnChargeFlag("aucune");

			formulaire.setOperation("nouveau");
			formulaire.setPatient(patient);
			formulaire.setPatientId(idPatient);

			result = true;
		} catch (Exception e) {
			result = false;
			log.fatal(e.getMessage());
		}

		finally {
			// session.close();
			log.debug("********** Debut addPatientForPrestationsDevis GestionCommercialeBO **********");
			return result;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * clinique.metier.gestion.commerciale.IGestionCommercialeBO#addReglementAvance
	 * (clinique.model.gestion.commerciale.GestionCommercialeForm)
	 */
	@Override
	@SuppressWarnings({ "finally", "unchecked" })
	public boolean addReglementAvance(GestionCommercialeForm formulaire)
			throws Exception {

		boolean result = false;
		log.debug("********** Debut addReglementAvance GestionCommercialeBO **********");

		try {
			if (Double.parseDouble(formulaire.getAvance()) > 0) {
				List reglementsList = formulaire.getReglementsList();

				Reglement reglement = new Reglement();
				reglement.setReglementId(ConstantesMetier.ID_REGLEMENT
						+ UtilDate.getInstance().getDateForId()
						+ ""
						+ getUserDao()
								.getUserByLogin(formulaire.getOperateur())
								.getUserId());

				if (Double.parseDouble(formulaire.getaRendre()) == 0) {
					reglement.setMontant(Double.parseDouble(formulaire
							.getAvance()));
					reglement.setPetitMonnaie(0);
				} else {
					reglement.setMontant(Double.parseDouble(formulaire
							.getAvance())
							- Double.parseDouble(formulaire.getaRendre()));
					reglement.setPetitMonnaie(Double.parseDouble(formulaire
							.getaRendre())
							- Double.parseDouble(formulaire.getRendu()));
				}

				reglement.setDateReglement(UtilDate.getInstance()
						.getDateToday());
				reglement.setDescription("avance");

				reglement.setTypePayement(getTypePayementDAO().getTypePayement(
						1));
				reglement.setStatut("1");
				reglementsList.add(reglement);
				formulaire.setReglementsList(reglementsList);

			}

			result = true;

		} catch (Exception e) {

			e.printStackTrace();
			log.fatal(e.getMessage());

		}

		finally {
			// session.close();
			log.debug("********** Fin addReglementAvance GestionCommercialeBO **********");
			return result;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * clinique.metier.gestion.commerciale.IGestionCommercialeBO#ajouterActe
	 * (clinique.model.gestion.commerciale.GestionCommercialeForm)
	 */
	@Override
	@SuppressWarnings({ "finally", "unchecked" })
	public boolean ajouterActe(GestionCommercialeForm formulaire)
			throws Exception {

		boolean result = false;
		log.debug("********** Debut ajouterActe GestionCommercialeBO **********");
		// Session session=SessionFactoryUtil.getInstance().openSession();
		try {
			List detailsFactureList = formulaire.getDetailsFactureList();
			if (formulaire.getFactureId().equals("")) {
				// debut id facture 11
				formulaire.setFactureId(ConstantesMetier.ID_FACTURE
						+ UtilDate.getInstance().getDateForId()
						+ ""
						+ getUserDao()
								.getUserByLogin(formulaire.getOperateur())
								.getUserId());
			}

			int majoration = calculMajoration(formulaire);

			// ajouter une prestation dans détails facture

			DetailFacture df = new DetailFacture();

			// debut id detail facture 13
			df.setDetailFactId(ConstantesMetier.ID_DETAILFACTURE
					+ UtilDate.getInstance().getDateForId()
					+ ""
					+ getUserDao().getUserByLogin(formulaire.getOperateur())
							.getUserId());
			df.setActe(getActeDAO().getActe(
					Integer.parseInt(formulaire.getActeId())));
			df.setNomActe(getActeDAO().getActe(
					Integer.parseInt(formulaire.getActeId())).getNomActe());
			df.setNbrActes(Integer.parseInt(formulaire.getNombreActe()));

			// calcul QPC
			df.setQpActeur(calculQPActeur(formulaire));
			df.setQpAssistant(calculQPAssistant(formulaire));
			// int qpc=100-(df.getQpActeur()+df.getQpAssistant());
			double montantQPC = 0;

			if (formulaire.getInfirmierChoix().equals("oui")
					&& !UtilDate.getInstance().isVide(
							formulaire.getActeurActeIdInf())) {
				df.setInfirmier(getActeurDAO().getActeur(
						Integer.parseInt(formulaire.getActeurActeIdInf())));
				df.setInfirmierExiste("1");
			} else {
				df.setInfirmierExiste("0");
			}

			double montantTotal;
			double prixActe;
			if (formulaire.getTypeActe().equals("normal")) {
				if (formulaire.getMedecinChoix().equals("oui")
						&& !UtilDate.getInstance().isVide(
								formulaire.getActeurActeId())) {
					ActeurActe medecin = getActeurActeDAO().getActeurActe(
							Integer.parseInt(formulaire.getActeurActeId()));
					if (medecin.getIsException().equals("1")) {
						prixActe = medecin.getPrix();
					} else {
						prixActe = getActeDAO().getActe(
								Integer.parseInt(formulaire.getActeId()))
								.getPrix();
					}

					df.setMedecin(medecin.getActeur());
					df.setMedecinExiste("1");
				} else {
					prixActe = getActeDAO().getActe(
							Integer.parseInt(formulaire.getActeId())).getPrix();
					df.setMedecinExiste("0");
				}
				df.setUrgenceActe(0);
				df.setDepl(0);

				df.setPrixReel(prixActe);

				prixActe = prixActe + majoration * prixActe / 100;
				df.setPrix(prixActe);

				montantTotal = prixActe
						* Integer.parseInt(formulaire.getNombreActe());
				df.setMontantTotal(montantTotal);

				df.setType("normal");
			} else if (formulaire.getTypeActe().equals("urgence")) {
				if (formulaire.getMedecinChoix().equals("oui")
						&& !UtilDate.getInstance().isVide(
								formulaire.getActeurActeId())) {
					ActeurActe medecin = getActeurActeDAO().getActeurActe(
							Integer.parseInt(formulaire.getActeurActeId()));
					if (medecin.getIsException().equals("1")) {
						prixActe = medecin.getPrixUrg();
					} else {
						prixActe = getActeDAO().getActe(
								Integer.parseInt(formulaire.getActeId()))
								.getPrixUrg();
					}

					df.setMedecin(medecin.getActeur());
					df.setMedecinExiste("1");
				} else {
					prixActe = getActeDAO().getActe(
							Integer.parseInt(formulaire.getActeId()))
							.getPrixUrg();
					df.setMedecinExiste("0");
				}
				df.setUrgenceActe(1);
				df.setDepl(0);

				df.setPrixReel(prixActe);

				prixActe = prixActe + majoration * prixActe / 100;
				df.setPrixUrg(prixActe);

				montantTotal = prixActe
						* Integer.parseInt(formulaire.getNombreActe());
				df.setMontantTotal(montantTotal);

				df.setType("urgence");

			} else {
				if (formulaire.getMedecinChoix().equals("oui")
						&& !UtilDate.getInstance().isVide(
								formulaire.getActeurActeId())) {
					ActeurActe medecin = getActeurActeDAO().getActeurActe(
							Integer.parseInt(formulaire.getActeurActeId()));
					if (medecin.getIsException().equals("1")) {
						prixActe = medecin.getPrixUrg();
					} else {
						prixActe = getActeDAO().getActe(
								Integer.parseInt(formulaire.getActeId()))
								.getPrixUrg();
					}

					df.setMedecin(medecin.getActeur());
					df.setMedecinExiste("1");
				} else {
					prixActe = getActeDAO().getActe(
							Integer.parseInt(formulaire.getActeId()))
							.getPrixUrg();
					df.setMedecinExiste("0");
				}
				df.setUrgenceActe(0);
				df.setDepl(1);

				df.setPrixReel(prixActe);

				prixActe = prixActe + majoration * prixActe / 100;
				df.setPrixDepl(prixActe);

				montantTotal = prixActe
						* Integer.parseInt(formulaire.getNombreActe());
				df.setMontantTotal(montantTotal);
				df.setType("deplacement");

			}

			montantQPC = montantTotal
					- (df.getQpActeur() + df.getQpAssistant())
					* df.getPrixReel() * df.getNbrActes() / 100;
			double montantQpcNonMajore = df.getPrixReel() * df.getNbrActes()
					- (df.getQpActeur() + df.getQpAssistant())
					* df.getPrixReel() * df.getNbrActes() / 100;

			df.setCoteClinique(montantQpcNonMajore);
			df.setCoteCliniqueMajore(montantQPC);

			if (UtilDate.getInstance().isVide(formulaire.getTotalApayer())) {
				formulaire.setTotalApayer("0");
			}

			if (UtilDate.getInstance().isVide(formulaire.getCoteClinique())) {
				formulaire.setCoteClinique("0");
			}

			if (UtilDate.getInstance().isVide(formulaire.getCoteAssureur())) {
				formulaire.setCoteAssureur("0");
			}

			if (formulaire.getPriseEnChargeFlag().equals("priseEnCharge")
					&& !formulaire.getLibeleAssureur().equals("CNAM")) {
				if (checkPcValide(formulaire.getPriseEnCharge(), formulaire)) {
					if (checkActePC(formulaire)) {
						addActePC(formulaire, prixActe);
					} else if (prestationCouvertesPcDAO
							.findPrestationCouvertesByPc(
									formulaire.getPriseEnCharge()).size() == 0) {
						addActePCWithoutPrestationCouv(formulaire, prixActe);
					}

				}
			}

			System.out.println(" libele CNAM" + formulaire.getLibeleAssureur());

			if (formulaire.getPriseEnChargeFlag().equals("badge")
					&& !formulaire.getLibeleAssureur().equals("CNAM")) {
				if (getExclusionActeAssureurDAO()
						.getExclusionActeAssureurByActe(
								getActeDAO()
										.getActe(
												Integer.parseInt(formulaire
														.getActeId()))) == null) {
					addActeBadge(formulaire, prixActe);
				}
			}

			double totalApayer = Double
					.parseDouble(formulaire.getTotalApayer()) + montantTotal;
			formulaire.setTotalApayer(String.valueOf(totalApayer));

			double coteClinique = Double.parseDouble(formulaire
					.getCoteClinique()) + montantQPC;
			formulaire.setCoteClinique(String.valueOf(coteClinique));

			if (getActeDAO().getActe(Integer.parseInt(formulaire.getActeId()))
					.getReductible().equals("1")) {
				double coteCliniqueReductible = Double.parseDouble(formulaire
						.getCoteCliniqueReductible()) + montantQPC;
				formulaire.setCoteCliniqueReductible(String
						.valueOf(coteCliniqueReductible));
			}

			formulaire.setResteApayer(String.valueOf(totalApayer
					- Double.parseDouble(formulaire.getCoteAssureur())));
			formulaire.setTotalApayer(String.valueOf(totalApayer));

			df.setDateDetail(UtilDate.getInstance().getDateToday());
			df.setOperateur(formulaire.getOperateur());
			detailsFactureList.add(df);
			formulaire.setDetailsFactureList(detailsFactureList);
			result = true;

		} catch (Throwable e) {

			e.printStackTrace();
			log.fatal(e.getMessage());

		}

		finally {
			// session.close();
			log.debug("********** Fin ajouterActe GestionCommercialeBO **********");
			// SessionFactoryUtil.getInstance().close();
			return result;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * clinique.metier.gestion.commerciale.IGestionCommercialeBO#ajouterActeDevis
	 * (clinique.model.gestion.commerciale.GestionCommercialeForm)
	 */
	@Override
	@SuppressWarnings({ "finally", "unchecked" })
	public boolean ajouterActeDevis(GestionCommercialeForm formulaire)
			throws Exception {

		boolean result = false;
		log.debug("********** Debut ajouterActeDevis GestionCommercialeBO **********");
		// Session session=SessionFactoryUtil.getInstance().openSession();
		try {
			List devisActesList = formulaire.getDevisActesList();

			// int
			// pourcentageAssureur=CategorieDAO.getInstance().getCategorie(Integer.parseInt(formulaire.getCategorieId())).getPourcentage();

			// ajouter une prestation dans détails facture
			// debut id detail facture 13
			DevisActes da = new DevisActes();
			da.setDevisActesId(ConstantesMetier.ID_DEVISACTE
					+ UtilDate.getInstance().getDateForId()
					+ ""
					+ getUserDao().getUserByLogin(formulaire.getOperateur())
							.getUserId());
			da.setActe(getActeDAO().getActe(
					Integer.parseInt(formulaire.getActeId())));

			da.setNbre(Integer.parseInt(formulaire.getNombreActe()));

			double montantTotal;
			double prixActe;
			if (formulaire.getTypeActe().equals("normal")) {
				if (formulaire.getMedecinChoix().equals("oui")
						&& !UtilDate.getInstance().isVide(
								formulaire.getActeurActeId())) {
					ActeurActe medecin = getActeurActeDAO().getActeurActe(
							Integer.parseInt(formulaire.getActeurActeId()));
					if (medecin.getIsException().equals("1")) {
						prixActe = medecin.getPrix();
					} else {
						prixActe = getActeDAO().getActe(
								Integer.parseInt(formulaire.getActeId()))
								.getPrix();
					}

				} else {
					prixActe = getActeDAO().getActe(
							Integer.parseInt(formulaire.getActeId())).getPrix();

				}

				da.setPrix(prixActe);

				montantTotal = prixActe
						* Integer.parseInt(formulaire.getNombreActe());
				da.setTotal(montantTotal);

			} else if (formulaire.getTypeActe().equals("urgence")) {
				if (formulaire.getMedecinChoix().equals("oui")
						&& !UtilDate.getInstance().isVide(
								formulaire.getActeurActeId())) {
					ActeurActe medecin = getActeurActeDAO().getActeurActe(
							Integer.parseInt(formulaire.getActeurActeId()));
					if (medecin.getIsException().equals("1")) {
						prixActe = medecin.getPrixUrg();
					} else {
						prixActe = getActeDAO().getActe(
								Integer.parseInt(formulaire.getActeId()))
								.getPrixUrg();
					}

				} else {
					prixActe = getActeDAO().getActe(
							Integer.parseInt(formulaire.getActeId()))
							.getPrixUrg();

				}

				da.setPrix(prixActe);

				montantTotal = prixActe
						* Integer.parseInt(formulaire.getNombreActe());
				da.setTotal(montantTotal);

			} else {
				if (formulaire.getMedecinChoix().equals("oui")
						&& !UtilDate.getInstance().isVide(
								formulaire.getActeurActeId())) {
					ActeurActe medecin = getActeurActeDAO().getActeurActe(
							Integer.parseInt(formulaire.getActeurActeId()));
					if (medecin.getIsException().equals("1")) {
						prixActe = medecin.getPrixUrg();
					} else {
						prixActe = getActeDAO().getActe(
								Integer.parseInt(formulaire.getActeId()))
								.getPrixUrg();
					}

				} else {
					prixActe = getActeDAO().getActe(
							Integer.parseInt(formulaire.getActeId()))
							.getPrixUrg();

				}

				da.setPrix(prixActe);

				montantTotal = prixActe
						* Integer.parseInt(formulaire.getNombreActe());
				da.setTotal(montantTotal);

			}

			devisActesList.add(da);
			double totalDevis = Double.valueOf(formulaire.getTotalDevis());
			totalDevis = totalDevis + da.getTotal();
			formulaire.setTotalDevis(String.valueOf(totalDevis));
			formulaire.setDevisActesList(devisActesList);
			result = true;

		} catch (Exception e) {

			e.printStackTrace();
			log.fatal(e.getMessage());

		}

		finally {
			// session.close();
			log.debug("********** Fin ajouterActeDevis GestionCommercialeBO **********");
			// SessionFactoryUtil.getInstance().close();
			return result;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see clinique.metier.gestion.commerciale.IGestionCommercialeBO#
	 * ajouterActeForFactureHosp
	 * (clinique.model.gestion.commerciale.GestionCommercialeForm,
	 * clinique.mapping.DetailFacture)
	 */
	@Override
	@SuppressWarnings({ "finally" })
	public boolean ajouterActeForFactureHosp(GestionCommercialeForm formulaire,
			DetailFacture df) throws Exception {

		boolean result = false;
		log.debug("********** Debut ajouterActeForFactureHosp GestionCommercialeBO **********");

		try {
			double montantQPC = 0;

			double montantTotal = df.getMontantTotal();
			double prixActe = getPrixActeFromDetailFacture(df);
			formulaire.setNombreActe(String.valueOf(df.getNbrActes()));

			montantQPC = montantTotal
					- (df.getQpActeur() + df.getQpAssistant())
					* df.getPrixReel() * df.getNbrActes() / 100;

			if (formulaire.getPriseEnChargeFlag().equals("priseEnCharge")
					&& !formulaire.getLibeleAssureur().equals("CNAM")) {
				if (checkPcValide(formulaire.getPriseEnCharge(), formulaire)) {
					if (checkActePC(formulaire)) {
						addActePC(formulaire, prixActe);
					} else if (prestationCouvertesPcDAO
							.findPrestationCouvertesByPc(
									formulaire.getPriseEnCharge()).size() == 0) {
						addActePCWithoutPrestationCouv(formulaire, prixActe);
					}

				}
			}

			System.out.println(" libele CNAM" + formulaire.getLibeleAssureur());

			if (formulaire.getPriseEnChargeFlag().equals("badge")
					&& !formulaire.getLibeleAssureur().equals("CNAM")) {
				if (getExclusionActeAssureurDAO()
						.getExclusionActeAssureurByActe(df.getActe()) == null) {
					addActeBadge(formulaire, prixActe);
				}
			}

			double totalApayer = Double
					.parseDouble(formulaire.getTotalApayer()) + montantTotal;
			formulaire.setTotalApayer(String.valueOf(totalApayer));

			double coteClinique = Double.parseDouble(formulaire
					.getCoteClinique()) + montantQPC;
			formulaire.setCoteClinique(String.valueOf(coteClinique));

			if (df.getActe().getReductible().equals("1")) {
				double coteCliniqueReductible = Double.parseDouble(formulaire
						.getCoteCliniqueReductible()) + montantQPC;
				formulaire.setCoteCliniqueReductible(String
						.valueOf(coteCliniqueReductible));
			}

			formulaire.setResteApayer(String.valueOf(totalApayer
					- Double.parseDouble(formulaire.getCoteAssureur())));
			formulaire.setTotalApayer(String.valueOf(totalApayer));

			result = true;

		} catch (Exception e) {

			e.printStackTrace();
			log.fatal(e.getMessage());

		}

		finally {
			log.debug("********** Fin ajouterActeForFactureHosp GestionCommercialeBO **********");
			return result;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see clinique.metier.gestion.commerciale.IGestionCommercialeBO#
	 * ajouterActeForFactureModifiee
	 * (clinique.model.gestion.commerciale.GestionCommercialeForm,
	 * clinique.mapping.DetailFacture)
	 */
	@Override
	@SuppressWarnings({ "finally" })
	public boolean ajouterActeForFactureModifiee(
			GestionCommercialeForm formulaire, DetailFacture df)
			throws Exception {

		boolean result = false;
		log.debug("********** Debut ajouterActeForFactureModifiee GestionCommercialeBO **********");

		try {
			// calcul QPC
			int qpc = 100 - (calculQPActeur(df) + calculQPAssistant(df));

			double montantTotal = df.getMontantTotal();
			double prixActe;

			prixActe = getPrixActeFromDetailFacture(df);

			if (formulaire.getPriseEnChargeFlag().equals("priseEnCharge")) {
				if (checkPcValide(formulaire.getPriseEnCharge(), formulaire)) {
					if (checkActePC(formulaire)) {
						addActePCFromDetailFacture(formulaire, prixActe, df);
					} else if (prestationCouvertesPcDAO
							.findPrestationCouvertesByPc(
									formulaire.getPriseEnCharge()).size() == 0) {
						addActePCWithoutPrestationCouvFromDetailFacture(
								formulaire, prixActe, df);
					}

				}
			}

			if (formulaire.getPriseEnChargeFlag().equals("badge")) {
				addActeBadgeFromDetailFacture(formulaire, prixActe, df);
			}

			double totalApayer = Double
					.parseDouble(formulaire.getTotalApayer()) + montantTotal;
			formulaire.setTotalApayer(String.valueOf(totalApayer));

			double coteClinique = Double.parseDouble(formulaire
					.getCoteClinique()) + montantTotal * qpc / 100;
			formulaire.setCoteClinique(String.valueOf(coteClinique));

			if (df.getActe().getReductible().equals("1")) {
				double coteCliniqueReductible = Double.parseDouble(formulaire
						.getCoteCliniqueReductible())
						+ montantTotal
						* qpc
						/ 100;
				formulaire.setCoteCliniqueReductible(String
						.valueOf(coteCliniqueReductible));
			}
			formulaire.setResteApayer(String.valueOf(totalApayer
					- Double.parseDouble(formulaire.getCoteAssureur())));

			result = true;

		} catch (Exception e) {

			e.printStackTrace();
			log.fatal(e.getMessage());

		}

		finally {
			log.debug("********** Fin ajouterActeForFactureModifiee GestionCommercialeBO **********");
			// SessionFactoryUtil.getInstance().close();
			return result;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * clinique.metier.gestion.commerciale.IGestionCommercialeBO#ajouterActeForHosp
	 * (clinique.model.gestion.commerciale.GestionCommercialeForm)
	 */
	@Override
	@SuppressWarnings({ "finally", "unchecked" })
	public boolean ajouterActeForHosp(GestionCommercialeForm formulaire)
			throws Exception {

		boolean result = false;
		log.debug("********** Debut ajouterActeForHosp GestionCommercialeBO **********");

		try {
			List detailsFactureList = formulaire.getDetailsFactureList();
			if (formulaire.getFactureId().equals("")) {
				// debut id facture 11
				formulaire.setFactureId(ConstantesMetier.ID_FACTURE
						+ UtilDate.getInstance().getDateForId()
						+ ""
						+ getUserDao()
								.getUserByLogin(formulaire.getOperateur())
								.getUserId());
			}

			int majoration = calculMajoration(formulaire);
			System.out.println("majoration : " + majoration);

			// ajouter une prestation dans détails facture

			DetailFacture df = new DetailFacture();

			// debut id detail facture 13
			df.setDetailFactId(ConstantesMetier.ID_DETAILFACTURE
					+ UtilDate.getInstance().getDateForId()
					+ ""
					+ getUserDao().getUserByLogin(formulaire.getOperateur())
							.getUserId());
			df.setActe(getActeDAO().getActe(
					Integer.parseInt(formulaire.getActeId())));
			df.setNomActe(getActeDAO().getActe(
					Integer.parseInt(formulaire.getActeId())).getNomActe());
			df.setNbrActes(Integer.parseInt(formulaire.getNombreActe()));

			// calcul QPC
			df.setQpActeur(calculQPActeur(formulaire));
			df.setQpAssistant(calculQPAssistant(formulaire));
			// int qpc=100-(df.getQpActeur()+df.getQpAssistant());
			double montantQPC = 0;

			if (formulaire.getInfirmierChoix().equals("oui")
					&& !UtilDate.getInstance().isVide(
							formulaire.getActeurActeIdInf())) {
				df.setInfirmier(getActeurDAO().getActeur(
						Integer.parseInt(formulaire.getActeurActeIdInf())));
				df.setInfirmierExiste("1");
			} else {
				df.setInfirmierExiste("0");
			}

			double montantTotal;
			double prixActe;
			if (formulaire.getTypeActe().equals("normal")) {
				if (formulaire.getMedecinChoix().equals("oui")
						&& !UtilDate.getInstance().isVide(
								formulaire.getActeurActeId())) {
					ActeurActe medecin = getActeurActeDAO().getActeurActe(
							Integer.parseInt(formulaire.getActeurActeId()));
					if (medecin.getIsException().equals("1")) {
						prixActe = medecin.getPrix();
					} else {
						prixActe = getActeDAO().getActe(
								Integer.parseInt(formulaire.getActeId()))
								.getPrix();
					}

					df.setMedecin(medecin.getActeur());
					df.setMedecinExiste("1");
				} else {
					prixActe = getActeDAO().getActe(
							Integer.parseInt(formulaire.getActeId())).getPrix();
					df.setMedecinExiste("0");
				}
				df.setUrgenceActe(0);
				df.setDepl(0);

				df.setPrixReel(prixActe);

				prixActe = prixActe + majoration * prixActe / 100;
				df.setPrix(prixActe);

				montantTotal = prixActe
						* Integer.parseInt(formulaire.getNombreActe());
				df.setMontantTotal(montantTotal);

				df.setType("normal");
			} else if (formulaire.getTypeActe().equals("urgence")) {
				if (formulaire.getMedecinChoix().equals("oui")
						&& !UtilDate.getInstance().isVide(
								formulaire.getActeurActeId())) {
					ActeurActe medecin = getActeurActeDAO().getActeurActe(
							Integer.parseInt(formulaire.getActeurActeId()));
					if (medecin.getIsException().equals("1")) {
						prixActe = medecin.getPrixUrg();
					} else {
						prixActe = getActeDAO().getActe(
								Integer.parseInt(formulaire.getActeId()))
								.getPrixUrg();
					}

					df.setMedecin(medecin.getActeur());
					df.setMedecinExiste("1");
				} else {
					prixActe = getActeDAO().getActe(
							Integer.parseInt(formulaire.getActeId()))
							.getPrixUrg();
					df.setMedecinExiste("0");
				}
				df.setUrgenceActe(1);
				df.setDepl(0);

				df.setPrixReel(prixActe);

				prixActe = prixActe + majoration * prixActe / 100;
				df.setPrixUrg(prixActe);

				montantTotal = prixActe
						* Integer.parseInt(formulaire.getNombreActe());
				df.setMontantTotal(montantTotal);

				df.setType("urgence");

			} else {
				if (formulaire.getMedecinChoix().equals("oui")
						&& !UtilDate.getInstance().isVide(
								formulaire.getActeurActeId())) {
					ActeurActe medecin = getActeurActeDAO().getActeurActe(
							Integer.parseInt(formulaire.getActeurActeId()));
					if (medecin.getIsException().equals("1")) {
						prixActe = medecin.getPrixUrg();
					} else {
						prixActe = getActeDAO().getActe(
								Integer.parseInt(formulaire.getActeId()))
								.getPrixUrg();
					}

					df.setMedecin(medecin.getActeur());
					df.setMedecinExiste("1");
				} else {
					prixActe = getActeDAO().getActe(
							Integer.parseInt(formulaire.getActeId()))
							.getPrixUrg();
					df.setMedecinExiste("0");
				}
				df.setUrgenceActe(0);
				df.setDepl(1);

				df.setPrixReel(prixActe);

				prixActe = prixActe + majoration * prixActe / 100;
				df.setPrixDepl(prixActe);

				montantTotal = prixActe
						* Integer.parseInt(formulaire.getNombreActe());
				df.setMontantTotal(montantTotal);

				df.setType("deplacement");

			}

			montantQPC = montantTotal
					- (df.getQpActeur() + df.getQpAssistant())
					* df.getPrixReel() * df.getNbrActes() / 100;
			double montantQpcNonMajore = df.getPrixReel() * df.getNbrActes()
					- (df.getQpActeur() + df.getQpAssistant())
					* df.getPrixReel() * df.getNbrActes() / 100;

			df.setCoteClinique(montantQpcNonMajore);
			df.setCoteCliniqueMajore(montantQPC);

			df.setDateDetail(UtilDate.getInstance().getDateToday());
			df.setOperateur(formulaire.getOperateur());

			df.setFacture(formulaire.getFacture());

			detailsFactureList.add(df);
			formulaire.setDetailsFactureList(detailsFactureList);
			result = true;

		} catch (Exception e) {

			e.printStackTrace();
			log.fatal(e.getMessage());

		}

		finally {
			log.debug("********** Fin ajouterActeForHosp GestionCommercialeBO **********");
			return result;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see clinique.metier.gestion.commerciale.IGestionCommercialeBO#
	 * ajouterActeForHosp_Old
	 * (clinique.model.gestion.commerciale.GestionCommercialeForm)
	 */
	@Override
	@SuppressWarnings("finally")
	public boolean ajouterActeForHosp_Old(GestionCommercialeForm formulaire)
			throws Exception {

		boolean result = false;
		log.debug("********** Debut ajouterActeForHosp GestionCommercialeBO **********");

		try {
			List detailsFactureList = formulaire.getDetailsFactureList();
			formulaire.setFactureId(formulaire.getFacture().getFactureId());
			// ajouter une prestation dans détails facture
			DetailFacture df = new DetailFacture();
			df.setDetailFactId(ConstantesMetier.ID_DETAILFACTURE
					+ UtilDate.getInstance().getDateForId()
					+ ""
					+ getUserDao().getUserByLogin(formulaire.getOperateur())
							.getUserId());
			df.setActe(getActeDAO().getActe(
					Integer.parseInt(formulaire.getActeId())));
			df.setNomActe(getActeDAO().getActe(
					Integer.parseInt(formulaire.getActeId())).getNomActe());
			df.setNbrActes(Integer.parseInt(formulaire.getNombreActe()));

			double montantTotal;
			double prixActe;

			if (formulaire.getInfirmierChoix().equals("oui")
					&& !UtilDate.getInstance().isVide(
							formulaire.getActeurActeIdInf())) {
				df.setInfirmier(getActeurDAO().getActeur(
						Integer.parseInt(formulaire.getActeurActeIdInf())));
				df.setInfirmierExiste("1");
			} else {
				df.setInfirmierExiste("0");
			}

			if (formulaire.getTypeActe().equals("normal")) {
				if (formulaire.getMedecinChoix().equals("oui")
						&& !UtilDate.getInstance().isVide(
								formulaire.getActeurActeId())) {
					ActeurActe medecin = getActeurActeDAO().getActeurActe(
							Integer.parseInt(formulaire.getActeurActeId()));
					if (medecin.getIsException().equals("1")) {
						prixActe = medecin.getPrix();
					} else {
						prixActe = getActeDAO().getActe(
								Integer.parseInt(formulaire.getActeId()))
								.getPrix();
					}

					df.setMedecin(medecin.getActeur());
					df.setMedecinExiste("1");
				} else {
					prixActe = getActeDAO().getActe(
							Integer.parseInt(formulaire.getActeId())).getPrix();
					df.setMedecinExiste("0");
				}
				df.setUrgenceActe(0);
				df.setDepl(0);
				df.setPrix(prixActe);
				df.setType("normal");

				montantTotal = prixActe
						* Integer.parseInt(formulaire.getNombreActe());
				df.setMontantTotal(montantTotal);
			} else if (formulaire.getTypeActe().equals("urgence")) {
				if (formulaire.getMedecinChoix().equals("oui")
						&& !UtilDate.getInstance().isVide(
								formulaire.getActeurActeId())) {
					ActeurActe medecin = getActeurActeDAO().getActeurActe(
							Integer.parseInt(formulaire.getActeurActeId()));
					if (medecin.getIsException().equals("1")) {
						prixActe = medecin.getPrixUrg();
					} else {
						prixActe = getActeDAO().getActe(
								Integer.parseInt(formulaire.getActeId()))
								.getPrixUrg();
					}

					df.setMedecin(medecin.getActeur());
					df.setMedecinExiste("1");
				} else {
					prixActe = getActeDAO().getActe(
							Integer.parseInt(formulaire.getActeId()))
							.getPrixUrg();
					df.setMedecinExiste("0");
				}
				df.setUrgenceActe(1);
				df.setDepl(0);
				df.setPrixUrg(prixActe);
				df.setType("urgence");

				montantTotal = prixActe
						* Integer.parseInt(formulaire.getNombreActe());
				df.setMontantTotal(montantTotal);

			} else {
				if (formulaire.getMedecinChoix().equals("oui")
						&& !UtilDate.getInstance().isVide(
								formulaire.getActeurActeId())) {
					ActeurActe medecin = getActeurActeDAO().getActeurActe(
							Integer.parseInt(formulaire.getActeurActeId()));
					if (medecin.getIsException().equals("1")) {
						prixActe = medecin.getPrixUrg();
					} else {
						prixActe = getActeDAO().getActe(
								Integer.parseInt(formulaire.getActeId()))
								.getPrixUrg();
					}

					df.setMedecin(medecin.getActeur());
					df.setMedecinExiste("1");
				} else {
					prixActe = getActeDAO().getActe(
							Integer.parseInt(formulaire.getActeId()))
							.getPrixUrg();
					df.setMedecinExiste("0");
				}
				df.setUrgenceActe(0);
				df.setDepl(1);
				df.setPrixDepl(prixActe);
				df.setType("deplacement");

				montantTotal = prixActe
						* Integer.parseInt(formulaire.getNombreActe());
				df.setMontantTotal(montantTotal);

			}

			df.setFacture(formulaire.getFacture());

			detailsFactureList.add(df);
			formulaire.setDetailsFactureList(detailsFactureList);
			result = true;

		} catch (Exception e) {

			e.printStackTrace();
			log.fatal(e.getMessage());

		}

		finally {
			// session.close();
			log.debug("********** Fin ajouterActeForHosp GestionCommercialeBO **********");
			return result;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see clinique.metier.gestion.commerciale.IGestionCommercialeBO#
	 * ajouterActeForModificationFacture
	 * (clinique.model.gestion.commerciale.GestionCommercialeForm)
	 */
	@Override
	@SuppressWarnings({ "finally", "unchecked" })
	public boolean ajouterActeForModificationFacture(
			GestionCommercialeForm formulaire) throws Exception {

		boolean result = false;
		log.debug("********** Debut ajouterActeForModificationFacture GestionCommercialeBO **********");
		try {
			List detailsFactureMList = formulaire
					.getDetailsFactureModifieesList();

			FactureModifiees factureM = factureModifieesDAO
					.getFactureModifiees(formulaire.getFactureModifieeId()
							.trim());

			// ajouter une prestation dans détails facture
			// debut id detail facture 13
			DetailFactureModifiees df = new DetailFactureModifiees();
			df.setDetailFactId(ConstantesMetier.ID_DETAILFACTURE
					+ UtilDate.getInstance().getDateForId()
					+ ""
					+ getUserDao().getUserByLogin(formulaire.getOperateur())
							.getUserId());
			df.setActe(getActeDAO().getActe(
					Integer.parseInt(formulaire.getActeId())));
			df.setNomActe(getActeDAO().getActe(
					Integer.parseInt(formulaire.getActeId())).getNomActe());
			df.setNbrActes(Integer.parseInt(formulaire.getNombreActe()));
			df.setFacture(factureM);

			if (formulaire.getInfirmierChoix().equals("oui")
					&& !UtilDate.getInstance().isVide(
							formulaire.getActeurActeIdInf())) {
				df.setInfirmier(getActeurDAO().getActeur(
						Integer.parseInt(formulaire.getActeurActeIdInf())));
				df.setInfirmierExiste("1");
			} else {
				df.setInfirmierExiste("0");
			}

			if (formulaire.getTypeActe().equals("normal")) {
				if (formulaire.getMedecinChoix().equals("oui")
						&& !UtilDate.getInstance().isVide(
								formulaire.getActeurActeId())) {
					ActeurActe medecin = getActeurActeDAO().getActeurActe(
							Integer.parseInt(formulaire.getActeurActeId()));

					df.setMedecin(medecin.getActeur());
					df.setMedecinExiste("1");
				} else {
					df.setMedecinExiste("0");
				}
				df.setUrgenceActe(0);
				df.setDepl(0);

				df.setType("normal");
			} else if (formulaire.getTypeActe().equals("urgence")) {
				if (formulaire.getMedecinChoix().equals("oui")
						&& !UtilDate.getInstance().isVide(
								formulaire.getActeurActeId())) {
					ActeurActe medecin = getActeurActeDAO().getActeurActe(
							Integer.parseInt(formulaire.getActeurActeId()));

					df.setMedecin(medecin.getActeur());
					df.setMedecinExiste("1");
				} else {
					df.setMedecinExiste("0");
				}
				df.setUrgenceActe(1);
				df.setDepl(0);

				df.setType("urgence");

			} else {
				if (formulaire.getMedecinChoix().equals("oui")
						&& !UtilDate.getInstance().isVide(
								formulaire.getActeurActeId())) {
					ActeurActe medecin = getActeurActeDAO().getActeurActe(
							Integer.parseInt(formulaire.getActeurActeId()));

					df.setMedecin(medecin.getActeur());
					df.setMedecinExiste("1");
				} else {
					// prixActe=ActeDAO.getInstance().getActe(Integer.parseInt(formulaire.getActeId())).getPrixUrg();
					df.setMedecinExiste("0");
				}
				df.setUrgenceActe(0);
				df.setDepl(1);

				df.setType("deplacement");

			}

			setInfosDfm(df);

			if (df.getType().equals("normal")) {
				df.setMontantTotal(df.getNbrActes() * df.getPrix());
			} else if (df.getType().equals("urgence")) {
				df.setMontantTotal(df.getNbrActes() * df.getPrixUrg());
			} else {
				df.setMontantTotal(df.getNbrActes() * df.getPrixDepl());
			}

			detailsFactureMList.add(df);
			formulaire.setDetailsFactureModifieesList(detailsFactureMList);
			result = true;

		} catch (Exception e) {

			e.printStackTrace();
			log.fatal(e.getMessage());

		}

		finally {
			// session.close();
			log.debug("********** Fin ajouterActeForModificationFacture GestionCommercialeBO **********");
			// SessionFactoryUtil.getInstance().close();
			return result;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * clinique.metier.gestion.commerciale.IGestionCommercialeBO#ajouterActesHosp
	 * (clinique.model.gestion.commerciale.GestionCommercialeForm)
	 */
	@Override
	@SuppressWarnings({ "finally", "unchecked" })
	public boolean ajouterActesHosp(GestionCommercialeForm formulaire)
			throws Exception {

		boolean result = false;
		log.debug("********** Debut ajouterActesHosp GestionCommercialeBO **********");

		try {
			getInfosPC(formulaire);
			initialiserElementsPaymentHospFacture(formulaire);
			List detailsFactureList = formulaire.getDetailsFactureList();

			for (Iterator iter = detailsFactureList.iterator(); iter.hasNext();) {
				DetailFacture df = (DetailFacture) iter.next();
				ajouterActeForFactureHosp(formulaire, df);
			}

			result = true;

		} catch (Exception e) {

			e.printStackTrace();
			log.fatal(e.getMessage());

		}

		finally {
			log.debug("********** Fin ajouterActesHosp GestionCommercialeBO **********");
			return result;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see clinique.metier.gestion.commerciale.IGestionCommercialeBO#
	 * ajouterDrgCnamDansDetailDrgCnamList
	 * (clinique.model.gestion.commerciale.GestionCommercialeForm)
	 */
	@Override
	@SuppressWarnings({ "finally", "unchecked" })
	public boolean ajouterDrgCnamDansDetailDrgCnamList(
			GestionCommercialeForm formulaire) throws Exception {

		boolean result = false;
		log.debug("********** Debut ajouterDrgCnamDansDetailDrgCnamList GestionCommercialeBO **********");
		// Session session=SessionFactoryUtil.getInstance().openSession();

		try {
			List detailDrgCnamListFacture = formulaire
					.getDetailDrgCnamListFacture();
			DetailDgrCnamFacture detailDrg = new DetailDgrCnamFacture();
			DrgCnam drg = getDrgCnamDAO().getDrgCnam(formulaire.getDrgCnamId());
			int pourcentage = getCategorieDAO().getCategorie(
					Integer.parseInt(formulaire.getCategorieId()))
					.getPourcentage();
			// debut id reglement 16
			detailDrg
					.setDetailDrgCnamId(ConstantesMetier.ID_DETAILDRGCNAMLISTFACTURE
							+ UtilDate.getInstance().getDateForId()
							+ ""
							+ getUserDao().getUserByLogin(
									formulaire.getOperateur()).getUserId());

			detailDrg.setDateDetail(UtilDate.getInstance().getDateToday());
			detailDrg.setStatut("1");
			detailDrg.setOperateur(formulaire.getOperateur());
			detailDrg.setDrgCnam(drg);

			detailDrgCnamListFacture.add(detailDrg);

			double montantDrg = drg.getMontant() * pourcentage / 100;
			double totalMontantDrg = 0;

			double cotePartAssureur;

			if (formulaire.getTotalMontantDrg().isEmpty()) {
				totalMontantDrg = 0;
				formulaire.setTotalMontantDrg("0");
			}

			totalMontantDrg = Double.parseDouble(formulaire
					.getTotalMontantDrg()) + drg.getMontant();
			formulaire.setTotalMontantDrg(String.valueOf(totalMontantDrg));

			if (formulaire.getCoteAssureur().isEmpty()) {
				cotePartAssureur = 0;
				formulaire.setCoteAssureur("0");
			}

			cotePartAssureur = Double.parseDouble(formulaire.getCoteAssureur());

			double totalApayer = Double
					.parseDouble(formulaire.getTotalApayer());
			double resteApayer = totalApayer - cotePartAssureur;
			double petitMonnaie = 0;

			if (montantDrg > resteApayer) {
				resteApayer = 0;
				petitMonnaie = montantDrg - (totalApayer - cotePartAssureur);
			}

			detailDrg.setPetitMonnaie(petitMonnaie);

			cotePartAssureur = Double.parseDouble(formulaire.getCoteAssureur())
					+ montantDrg;
			formulaire.setCoteAssureur(String.valueOf(cotePartAssureur));
			if (resteApayer != 0) {
				resteApayer = totalApayer - cotePartAssureur;
			}
			formulaire.setResteApayer(String.valueOf(resteApayer));

			formulaire.setDetailDrgCnamListFacture(detailDrgCnamListFacture);
			result = true;

		} catch (Exception e) {
			e.printStackTrace();
			log.fatal(e.getMessage());

		}

		finally {
			// session.close();
			log.debug("********** Fin ajouterDrgCnamDansDetailDrgCnamList GestionCommercialeBO **********");
			return result;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * clinique.metier.gestion.commerciale.IGestionCommercialeBO#ajouterRecuFacture
	 * (clinique.model.gestion.commerciale.GestionCommercialeForm)
	 */
	@Override
	@SuppressWarnings({ "finally", "unchecked" })
	public boolean ajouterRecuFacture(GestionCommercialeForm formulaire)
			throws Exception {

		boolean result = false;
		log.debug("********** Debut AjouterRecuFacture GestionCommercialeBO **********");
		try {
			List transactionComptes = new ArrayList();
			List transactionCompteCategories = new ArrayList();
			// List comptes=new ArrayList();
			// List compteCategories=new ArrayList();

			// enregistrer facture
			if (formulaire.getFactureId().equals("")) {
				formulaire.setFactureId(ConstantesMetier.ID_FACTURE
						+ UtilDate.getInstance().getDateForId()
						+ ""
						+ getUserDao()
								.getUserByLogin(formulaire.getOperateur())
								.getUserId());
			}
			Patient patient = formulaire.getPatient();
			Facture facture = new Facture();
			facture.setFactureId(formulaire.getFactureId());
			facture.setDateFact(UtilDate.getInstance().getDateToday());
			facture.setPatient(patient);
			facture.setQpc(Double.parseDouble(formulaire.getCoteClinique()));

			if (Double.parseDouble(formulaire.getRemiseMontant()) > 0) {
				facture.setRemise(Double.parseDouble(formulaire
						.getRemiseMontant()));
				facture.setTauxRemise(Integer.parseInt(formulaire
						.getRemiseValeur()));
			} else {
				facture.setRemise(0);
			}

			double total_HT = 0;
			double montantReglement = 0;

			for (Iterator iter = formulaire.getDetailsFactureList().iterator(); iter
					.hasNext();) {
				DetailFacture element = (DetailFacture) iter.next();
				total_HT = total_HT + element.getMontantTotal();
				element.setStatut("1");
				element.setFacture(facture);
				detailFactureDAO.save(element);
			}

			double remiseCash = 0;

			for (Iterator iter = formulaire.getReglementsList().iterator(); iter
					.hasNext();) {
				Reglement element = (Reglement) iter.next();

				montantReglement = montantReglement + element.getMontant();
				remiseCash = remiseCash + element.getRemiseCash();
				element.setStatut("1");
				element.setFacture(facture);
				reglementDAO.save(element);
			}

			facture.setRemiseCash(remiseCash);

			int idkey = 0;
			// makeTransactionActeurs(transactionComptes, formulaire);
			makeTransactionActeurs(transactionComptes, formulaire, idkey);
			makeTransactionCliniqueAndAssureur(transactionComptes,
					transactionCompteCategories, formulaire, idkey);

			double majoration = total_HT
					- (facture.getRemise() + facture.getRemiseCash() + montantReglement);
			double total_tva = total_HT * 0 / 100;
			double netApayer = total_HT + total_tva - facture.getRemise()
					- facture.getRemiseCash();

			facture.setMajoration(majoration);
			facture.setTotalHT(total_HT);
			facture.setTotalTva(total_tva);
			facture.setNetApayer(netApayer);
			facture.setAvance(0);

			PatientPcActuel patientPcActuel = new PatientPcActuel();
			patientPcActuel
					.setPatientPcActuelId(ConstantesMetier.ID_PATIENTPCACTUEL
							+ UtilDate.getInstance().getDateForId()
							+ ""
							+ getUserDao().getUserByLogin(
									formulaire.getOperateur()).getUserId());

			if (formulaire.getOperation().equals("ancienWithPC")
					|| formulaire.getOperation().equals("ancienWithoutPC")) {
				getPatientDAO().update(patient);
			} else {
				getPatientDAO().save(patient);
			}

			facture.setTypePc("aucune");
			patientPcActuel.setType("aucune");
			patientPcActuel.setPatient(patient);

			if (formulaire.getPriseEnChargeFlag().equals("priseEnCharge")) {

				PriseEnCharge pc = formulaire.getPriseEnCharge();
				pc.setMontantFact(Double.parseDouble(formulaire
						.getCoteAssureur()) + pc.getMontantFact());
				facture.setTotalReglementPc(Double.parseDouble(formulaire
						.getCoteAssureur()));

				if (formulaire.getOperation().equals("ancienWithPC")) {
					if (pc != null) {
						priseEnChargeDAO.update(pc);
					}
				} else {
					pc.setCategorie(patient.getCategorie());
					priseEnChargeDAO.save(pc);
				}

				patientPcActuel.setType("priseEnCharge");
				patientPcActuel.setPriseEnCharge(pc);

				facture.setTypePc("priseEnCharge");
				facture.setPriseEnCharge(pc);

			}

			else if (formulaire.getPriseEnChargeFlag().equals("badge")) {
				Badge badge = formulaire.getBadge();

				if (!formulaire.getOperation().equals("ancienWithPC")) {
					badgeDAO.save(badge);
				}

				else {
					if (badge != null) {
						badgeDAO.update(badge);
					}
				}

				patientPcActuel.setBadge(badge);
				patientPcActuel.setType("badge");

				facture.setTypePc("badge");
				facture.setBadge(badge);

			}

			patientPcActuel.setStatut("1");
			getPatientPcActuelDAO().deletePatientPcByPatient(patient);
			getPatientPcActuelDAO().save(patientPcActuel);

			facture.setTauxMajoration(calculMajoration(formulaire));
			facture.setStatut("1");
			facture.setDateFact(UtilDate.getInstance().getDateToday());
			facture.setOperateur(formulaire.getOperateur());
			getFactureDAO().save(facture);

			for (Iterator iter = transactionComptes.iterator(); iter.hasNext();) {
				TransactionCompte element = (TransactionCompte) iter.next();
				transactionCompteDAO.save(element);

			}

			for (Iterator iter = transactionCompteCategories.iterator(); iter
					.hasNext();) {
				TransactionCompteCategorie element = (TransactionCompteCategorie) iter
						.next();

				transactionCompteCategorieDAO.save(element);

			}

			result = true;

		} catch (Exception e) {
			log.fatal(e.getMessage());

		}

		finally {
			log.debug("********** Fin AjouterRecuFacture GestionCommercialeBO **********");
			return result;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see clinique.metier.gestion.commerciale.IGestionCommercialeBO#
	 * ajouterRecuFactureHosp
	 * (clinique.model.gestion.commerciale.GestionCommercialeForm)
	 */
	@Override
	@SuppressWarnings({ "finally", "unchecked" })
	public boolean ajouterRecuFactureHosp(GestionCommercialeForm formulaire)
			throws Exception {

		boolean result = false;
		log.debug("********** Debut AjouterRecuFacture GestionCommercialeBO **********");
		try {

			// enregistrer facture

			Hospitalisation hospitalisation = getHospitalisationDAO()
					.getHospitalisation(
							formulaire.getHospitalisation()
									.getHospitalisationId());
			Facture facture = hospitalisation.getFacture();
			formulaire.setFactureId(facture.getFactureId());
			Chambre chambre = hospitalisation.getChambre();

			facture.setDateFact(UtilDate.getInstance().getDateToday());
			facture.setQpc(Double.parseDouble(formulaire.getCoteClinique()));
			facture.setTotalReglementPc(Double.parseDouble(formulaire
					.getCoteAssureur()));

			if (Double.parseDouble(formulaire.getRemiseMontant()) > 0) {
				facture.setRemise(Double.parseDouble(formulaire
						.getRemiseMontant()));
				facture.setTauxRemise(Integer.parseInt(formulaire
						.getRemiseValeur()));
			} else {
				facture.setRemise(0);
			}

			double total_HT = 0;
			double montantReglement = 0;

			for (Iterator iter = formulaire.getDetailsFactureList().iterator(); iter
					.hasNext();) {
				DetailFacture element = (DetailFacture) iter.next();
				total_HT = total_HT + element.getMontantTotal();
				element.setStatut("1");
				element.setFacture(facture);
				detailFactureDAO.save(element);
			}

			int nbreChambresHosp = 0;
			for (Iterator iter = formulaire.getChambresHospList().iterator(); iter
					.hasNext();) {
				ChambresHospitalisation element = (ChambresHospitalisation) iter
						.next();
				total_HT = total_HT + element.getTotal();
				nbreChambresHosp++;
			}

			double remiseCash = 0;

			for (Iterator iter = formulaire.getReglementsList().iterator(); iter
					.hasNext();) {
				Reglement element = (Reglement) iter.next();

				montantReglement = montantReglement + element.getMontant();
				remiseCash = remiseCash + element.getRemiseCash();
				element.setStatut("1");
				element.setFacture(facture);
				reglementDAO.save(element);
			}

			facture.setRemiseCash(remiseCash);

			double majoration = facture.getRemise() + montantReglement
					- total_HT;
			double total_tva = total_HT * 0 / 100;
			double netApayer = total_HT + total_tva - facture.getRemise()
					+ majoration;

			facture.setMajoration(majoration);
			facture.setTotalHT(total_HT);
			facture.setTotalTva(total_tva);
			facture.setNetApayer(netApayer);

			if (formulaire.getPriseEnChargeFlag().equals("priseEnCharge")) {
				if (formulaire.getOperation().equals("ancienWithPC")) {

					PriseEnCharge pc = formulaire.getPriseEnCharge();
					pc.setMontantFact(Double.parseDouble(formulaire
							.getCoteAssureur()) + pc.getMontantFact());

					// session.update(pc);

				} else {
					PriseEnCharge pc = formulaire.getPriseEnCharge();
					pc.setMontantFact(Double.parseDouble(formulaire
							.getCoteAssureur()) + pc.getMontantFact());
					// session.save(pc);

				}
			}

			facture.setTauxMajoration(calculMajoration(formulaire));
			facture.setStatut("1");
			facture.setDateFact(UtilDate.getInstance().getDateToday());
			facture.setOperateur(formulaire.getOperateur());

			chambre.setEtat("1");
			getChambreDAO().update(chambre);

			getFactureDAO().update(facture);

			List<ChambresHospitalisation> list = chambresHospitalisationDAO
					.findChambresHospitalisationByHospitalisation(hospitalisation);

			for (int i = 0; i < nbreChambresHosp; i++) {
				ChambresHospitalisation element = (ChambresHospitalisation) formulaire
						.getChambresHospList().get(i);
				list.set(i, element);
			}

			hospitalisation.setDateSortie(UtilDate.getInstance().stringToDate(
					formulaire.getDateSortie()));
			hospitalisation.setEncours("0");
			// session.update(hospitalisation);

			result = true;

		} catch (Exception e) {
			log.fatal(e.getMessage());

		}

		finally {
			log.debug("********** Fin AjouterRecuFacture GestionCommercialeBO **********");
			return result;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * clinique.metier.gestion.commerciale.IGestionCommercialeBO#ajouterRegelement
	 * (clinique.model.gestion.commerciale.GestionCommercialeForm)
	 */
	@Override
	@SuppressWarnings({ "finally", "unchecked" })
	public boolean ajouterRegelement(GestionCommercialeForm formulaire)
			throws Exception {

		boolean result = false;
		log.debug("********** Debut ajouterRegelement GestionCommercialeBO **********");

		try {
			List reglementsList = formulaire.getReglementsList();
			Reglement reglement = new Reglement();
			// debut id reglement 16
			reglement.setReglementId(ConstantesMetier.ID_REGLEMENT
					+ UtilDate.getInstance().getDateForId()
					+ ""
					+ getUserDao().getUserByLogin(formulaire.getOperateur())
							.getUserId());

			double montant = Double.parseDouble(formulaire
					.getTypePayementValeur());
			double resteApayer = Double
					.parseDouble(formulaire.getResteApayer());
			double resteApayerMajoration = Double.parseDouble(formulaire
					.getResteApayerMajoration());
			int pourcentageMaj = calculMajoration(formulaire);
			// double dejapayer=Double.parseDouble(formulaire.getDejapaye());

			// =============== Calcul de petite monnaie ===================
			if (formulaire.getModeReglement().equals("immediat")) {
				if (montant > resteApayer) {

					reglement.setPetitMonnaie(montant - resteApayer);
					montant = resteApayer;
					formulaire.setRecuRegle("1");
				} else {
					if (montant == resteApayer) {
						formulaire.setRecuRegle("1");
					} else {
						formulaire.setRecuRegle("0");
					}
					reglement.setPetitMonnaie(0);
				}

				resteApayer = resteApayer - montant;
				resteApayerMajoration = resteApayer + resteApayer
						* pourcentageMaj / 100;
				reglement.setRemiseCash(montant * pourcentageMaj / 100);
				reglement.setMajore("0");
			} else {
				if (montant > resteApayerMajoration) {

					reglement.setPetitMonnaie(montant - resteApayerMajoration);
					montant = resteApayerMajoration;
					formulaire.setRecuRegle("1");
				} else {
					if (montant == resteApayerMajoration) {
						formulaire.setRecuRegle("1");
					} else {
						formulaire.setRecuRegle("0");
					}
					reglement.setPetitMonnaie(0);
				}

				resteApayerMajoration = resteApayerMajoration - montant;
				resteApayer = 100 * resteApayerMajoration
						/ (100 + pourcentageMaj);
				reglement.setMajore("1");
			}
			// =============== Fin calcul de petite monnaie ===================

			reglement.setMontant(montant);
			reglement.setDateReglement(UtilDate.getInstance().getDateToday());

			if (formulaire.getTypePayementId().equals("2")
					|| formulaire.getTypePayementId().equals("3")) {
				reglement.setDescription(formulaire.getDescription());
			} else if (formulaire.getTypePayementId().equals("4")) {
				reglement.setDescription(getPcPersonnelDAO().getPcPersonnel(
						Integer.parseInt(formulaire.getPcPersonnelId()))
						.getPcNom());
				reglement.setPcPersonnel(getPcPersonnelDAO().getPcPersonnel(
						Integer.parseInt(formulaire.getPcPersonnelId())));
				reglement.setTypePC("personne");
			}

			reglement.setTypePayement(getTypePayementDAO().getTypePayement(
					Integer.parseInt(formulaire.getTypePayementId())));
			reglementsList.add(reglement);

			// dejapayer=dejapayer+montant;
			formulaire.setResteApayer(String.valueOf(resteApayer));
			formulaire.setResteApayerMajoration(String
					.valueOf(resteApayerMajoration));
			// formulaire.setDejapaye(String.valueOf(dejapayer));
			formulaire.setReglementsList(reglementsList);
			result = true;

		} catch (Exception e) {
			e.printStackTrace();
			log.fatal(e.getMessage());

		}

		finally {
			// session.close();
			log.debug("********** Fin ajouterRegelement GestionCommercialeBO **********");
			return result;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * clinique.metier.gestion.commerciale.IGestionCommercialeBO#calculCoteAssureur
	 * (clinique.model.gestion.commerciale.GestionCommercialeForm, double)
	 */
	@Override
	public void calculCoteAssureur(GestionCommercialeForm formulaire,
			double prixActe) {
		// PriseEnCharge
		// pc=PriseEnChargeDAO.getInstance().getPriseEnCharge(sformulaire.getPcId())
		// ;

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * clinique.metier.gestion.commerciale.IGestionCommercialeBO#calculMajoration
	 * (clinique.model.gestion.commerciale.GestionCommercialeForm)
	 */
	@Override
	public int calculMajoration(GestionCommercialeForm formulaire) {
		int majoration = 0;

		if (!formulaire.getPriseEnChargeFlag().equals("aucune")) {
			Categorie categorie = formulaire.getPatient().getCategorie();
			if (categorie != null) {
				majoration = categorie.getMajoration();
			}

			if (majoration == 0) {
				majoration = Integer.valueOf(getParametresCliniqueDAO()
						.getParametresCliniqueByParametreNom("majoration")
						.getValeur()) / 100;
			}
		} else {
			majoration = Integer.valueOf(getParametresCliniqueDAO()
					.getParametresCliniqueByParametreNom("majoration")
					.getValeur()) / 100;
		}

		return majoration;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * clinique.metier.gestion.commerciale.IGestionCommercialeBO#calculQPActeur
	 * (clinique.mapping.DetailFacture)
	 */
	@Override
	public int calculQPActeur(DetailFacture df) {
		// calcul qp praticien
		int qpActeur = 0;
		if (df.getMedecinExiste().equals("1")) {
			ActeurActe praticien = getActeurActeDAO().getActeurActe(
					df.getMedecin(), df.getActe());

			if (praticien != null) {
				if (df.getType().equals("normal")) {
					if (praticien.getPourcentage() != 0) {
						qpActeur = praticien.getPourcentage();
					} else {
						qpActeur = df.getActe().getTauxPraticien();
					}
				} else {
					if (praticien.getPourcentageUrg() != 0) {
						qpActeur = praticien.getPourcentageUrg();
					} else {
						qpActeur = df.getActe().getTauxPraticienUrg();
					}
				}
			} else {
				if (df.getType().equals("normal")) {
					qpActeur = df.getActe().getTauxPraticien();
				} else {
					qpActeur = df.getActe().getTauxPraticienUrg();
					// else qpActeur=acte.getTauxDepPraticien();
				}
			}
		}

		return qpActeur;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * clinique.metier.gestion.commerciale.IGestionCommercialeBO#calculQPActeur
	 * (clinique.model.gestion.commerciale.GestionCommercialeForm)
	 */
	@Override
	public int calculQPActeur(GestionCommercialeForm formulaire) {
		// calcul qp praticien
		int qpActeur = 0;
		if (formulaire.getMedecinChoix().equals("oui")
				&& !UtilDate.getInstance().isVide(formulaire.getActeurActeId())) {
			ActeurActe praticien = getActeurActeDAO().getActeurActe(
					Integer.parseInt(formulaire.getActeurActeId()));

			if (praticien != null) {
				if (formulaire.getTypeActe().equals("normal")) {
					if (praticien.getPourcentage() != 0) {
						qpActeur = praticien.getPourcentage();
					} else {
						Acte acte = getActeDAO().getActe(
								Integer.parseInt(formulaire.getActeId()));
						qpActeur = acte.getTauxPraticien();
					}
				} else {
					if (praticien.getPourcentageUrg() != 0) {
						qpActeur = praticien.getPourcentageUrg();
					} else {
						Acte acte = getActeDAO().getActe(
								Integer.parseInt(formulaire.getActeId()));
						qpActeur = acte.getTauxPraticienUrg();
					}
				}
			} else {
				Acte acte = getActeDAO().getActe(
						Integer.parseInt(formulaire.getActeId()));
				if (formulaire.getTypeActe().equals("normal")) {
					qpActeur = acte.getTauxPraticien();
				} else {
					qpActeur = acte.getTauxPraticienUrg();
					// else qpActeur=acte.getTauxDepPraticien();
				}
			}
		}

		return qpActeur;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * clinique.metier.gestion.commerciale.IGestionCommercialeBO#calculQPAssistant
	 * (clinique.mapping.DetailFacture)
	 */
	@Override
	public int calculQPAssistant(DetailFacture df) {
		// calcul qp praticien
		int qpAssistant = 0;
		if (df.getInfirmierExiste().equals("1")) {
			Acte acte = df.getActe();
			if (df.getType().equals("normal")) {
				qpAssistant = acte.getTauxAssistant();
			} else if (df.getType().equals("urgence")) {
				qpAssistant = acte.getTauxAssistantUrg();
			} else {
				qpAssistant = acte.getTauxDepAssistant();
			}
		}
		return qpAssistant;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * clinique.metier.gestion.commerciale.IGestionCommercialeBO#calculQPAssistant
	 * (clinique.model.gestion.commerciale.GestionCommercialeForm)
	 */
	@Override
	public int calculQPAssistant(GestionCommercialeForm formulaire) {
		// calcul qp praticien
		int qpAssistant = 0;
		if (formulaire.getInfirmierChoix().equals("oui")
				&& !UtilDate.getInstance().isVide(
						formulaire.getActeurActeIdInf())) {
			Acte acte = getActeDAO().getActe(
					Integer.parseInt(formulaire.getActeId()));
			if (formulaire.getTypeActe().equals("normal")) {
				qpAssistant = acte.getTauxAssistant();
			} else if (formulaire.getTypeActe().equals("urgence")) {
				qpAssistant = acte.getTauxAssistantUrg();
			} else {
				qpAssistant = acte.getTauxDepAssistant();
			}
		}
		return qpAssistant;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * clinique.metier.gestion.commerciale.IGestionCommercialeBO#changerChambre
	 * (clinique.model.gestion.commerciale.GestionCommercialeForm)
	 */
	@Override
	@SuppressWarnings({ "finally", "unchecked" })
	public boolean changerChambre(GestionCommercialeForm formulaire)
			throws Exception {

		boolean result = false;
		log.debug("********** Debut changerChambre GestionCommercialeBO **********");
		try {

			Hospitalisation hospitalisation = getHospitalisationDAO()
					.getHospitalisation(formulaire.getHospitalisaionId().trim());
			Chambre ancienneChambre = hospitalisation.getChambre();

			Chambre Nvellechambre = getChambreDAO().getChambre(
					Integer.parseInt(formulaire.getChambreId().trim()));

			if (ancienneChambre != null) {
				System.out.println("ancienneChambre");
				ancienneChambre.setEtat("1");
				getChambreDAO().update(ancienneChambre);
			}

			int i = 0, j = 0;
			List<ChambresHospitalisation> list = chambresHospitalisationDAO
					.findChambresHospitalisationByHospitalisation(hospitalisation);
			boolean chambresHospitalisationExiste = false;
			ChambresHospitalisation chambresHospitalisation = null;
			for (Object element2 : chambresHospitalisationDAO
					.findChambresHospitalisationByHospitalisation(hospitalisation)) {
				ChambresHospitalisation element = (ChambresHospitalisation) element2;
				if (element.getChambre().getChambreId() == ancienneChambre
						.getChambreId()
						&& element.getStatut().equals(STATUT_SUPPRIME)) {
					System.out.println("ChambresHospitalisation");
					element.setStatut("1");
					element.setDateSortie(UtilDate.getInstance().stringToDate(
							formulaire.getDateEntreeChambre()));
					element.setHeureSortie(Integer.parseInt(formulaire
							.getHeureHosp()));
					j = i;
					chambresHospitalisationExiste = true;
				}
				i++;
			}

			if (chambresHospitalisationExiste
					&& chambresHospitalisation != null) {
				list.set(j, chambresHospitalisation);
			}

			if (Nvellechambre != null) {
				System.out.println("Nvellechambre1");
				Nvellechambre.setEtat("0");
				getChambreDAO().merge(Nvellechambre);
				System.out.println("Nvellechambre");

				ChambresHospitalisation chaHospitalisation = new ChambresHospitalisation();
				chaHospitalisation
						.setChambreHospitalisationId(ConstantesMetier.ID_HOSPITALISATIONCHAMBRE
								+ UtilDate.getInstance().getDateForId()
								+ ""
								+ getUserDao().getUserByLogin(
										formulaire.getOperateur()).getUserId());
				if (!UtilDate.getInstance().isVide(formulaire.getDateEntree())) {
					chaHospitalisation.setDateEntree(UtilDate.getInstance()
							.stringToDate(formulaire.getDateEntreeChambre()));
				}
				chaHospitalisation.setStatut("0");
				chaHospitalisation.setChambre(Nvellechambre);
				chaHospitalisation.setHeureEntree(Integer.parseInt(formulaire
						.getHeureHosp()));
				chaHospitalisation.setHospitalisation(hospitalisation);
				chambresHospitalisationDAO.save(chaHospitalisation);

			}

			hospitalisation.setChambre(Nvellechambre);
			getHospitalisationDAO().update(hospitalisation);

			initialiserInfosChambre(formulaire);
			result = true;

		} catch (Exception e) {
			e.printStackTrace();
			log.fatal(e.getMessage());

		}

		finally {

			log.debug("********** Fin changerChambre GestionCommercialeBO **********");
			return result;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * clinique.metier.gestion.commerciale.IGestionCommercialeBO#chargerPrestations
	 * (clinique.model.gestion.commerciale.GestionCommercialeForm)
	 */
	@Override
	public void chargerPrestations(GestionCommercialeForm formulaire) {
		// if (!UtilDate.getInstance().isVide(formulaire.getFactureId()))
		// formulaire.setDetailsFactureList(FactureDAO.getInstance().getFacture(Integer.parseInt(formulaire.getFactureId())).getDetailFactures());
		// else formulaire.setDetailsFactureList(null);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * clinique.metier.gestion.commerciale.IGestionCommercialeBO#checkActe(clinique
	 * .mapping.Acte)
	 */
	@Override
	@SuppressWarnings({ "unchecked", "finally" })
	public boolean checkActe(Acte acte) {

		boolean result = false;
		// int nbreMedecin=0;
		// int nbreInf=0;
		try {

			if (acte.getStatut().equals("1")) {
				result = true;
			}
		} catch (Exception e) {
			result = false;
		} finally {
			return result;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * clinique.metier.gestion.commerciale.IGestionCommercialeBO#checkActeAdd
	 * (clinique.model.gestion.commerciale.GestionCommercialeForm)
	 */
	@Override
	@SuppressWarnings({ "unchecked", "finally" })
	public ActionMessages checkActeAdd(GestionCommercialeForm formulaire) {
		ActionMessages errors1 = new ActionMessages();

		log.debug("********** Debut checkActeAdd GestionCommercialeBO **********");
		// Session session=SessionFactoryUtil.getInstance().openSession();
		try {
			List detailsFactureList = formulaire.getDetailsFactureList();
			if (detailsFactureList.size() > 0) {
				Acteur medecin = getActeurActeDAO().getActeurActe(
						Integer.parseInt(formulaire.getActeurActeId()))
						.getActeur();
				for (Iterator iter = detailsFactureList.iterator(); iter
						.hasNext();) {
					DetailFacture element = (DetailFacture) iter.next();
					if (element.getMedecinExiste().equals("1")) {
						if (element.getMedecin().getActeurId() != medecin
								.getActeurId()) {
							ActionError error = new ActionError(
									"formulaire.acte.medecinDifferent");
							errors1.add("errorMsg", error);
						}
					}

				}
			}
		} catch (Exception e) {
			e.getStackTrace();
			log.fatal(e.getMessage());
		}

		finally {
			// session.close();
			log.debug("********** Fin checkActeAdd GestionCommercialeBO **********");
			return errors1;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see clinique.metier.gestion.commerciale.IGestionCommercialeBO#
	 * checkActeAddForModificationFacture
	 * (clinique.model.gestion.commerciale.GestionCommercialeForm)
	 */
	@Override
	@SuppressWarnings({ "unchecked", "finally" })
	public ActionMessages checkActeAddForModificationFacture(
			GestionCommercialeForm formulaire) {
		ActionMessages errors1 = new ActionMessages();

		log.debug("********** Debut checkActeAddForModificationFacture GestionCommercialeBO **********");
		// Session session=SessionFactoryUtil.getInstance().openSession();
		try {
			List detailsFactureList = formulaire
					.getDetailsFactureModifieesList();
			if (detailsFactureList.size() > 0) {
				Acteur medecin = getActeurActeDAO().getActeurActe(
						Integer.parseInt(formulaire.getActeurActeId()))
						.getActeur();
				for (Iterator iter = detailsFactureList.iterator(); iter
						.hasNext();) {
					DetailFactureModifiees element = (DetailFactureModifiees) iter
							.next();
					if (element.getMedecinExiste().equals("1")) {
						if (element.getMedecin().getActeurId() != medecin
								.getActeurId()) {
							ActionError error = new ActionError(
									"formulaire.acte.medecinDifferent");
							errors1.add("errorMsg", error);
						}
					}

				}
			}
		} catch (Exception e) {
			e.getStackTrace();
			log.fatal(e.getMessage());
		}

		finally {
			// session.close();
			log.debug("********** Fin checkActeAddForModificationFacture GestionCommercialeBO **********");
			return errors1;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * clinique.metier.gestion.commerciale.IGestionCommercialeBO#checkActePC
	 * (clinique.model.gestion.commerciale.GestionCommercialeForm)
	 */
	@Override
	@SuppressWarnings({ "finally", "unchecked" })
	public boolean checkActePC(GestionCommercialeForm formulaire) {
		boolean result = false;
		try {
			@SuppressWarnings("unused")
			PrestationCouvertesPc pc = new PrestationCouvertesPc();
			if (formulaire.getPrestationCouvertesPcs().size() > 0) {

				for (Iterator iter = formulaire.getPrestationCouvertesPcs()
						.iterator(); iter.hasNext();) {
					PrestationCouvertesPc element = (PrestationCouvertesPc) iter
							.next();
					if (element.getActe().getActeId() == Integer
							.parseInt(formulaire.getActeId())) {
						result = true;

					}
				}

			}
		} catch (Exception e) {
			result = false;
		} finally {
			return result;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * clinique.metier.gestion.commerciale.IGestionCommercialeBO#checkActeur
	 * (clinique.mapping.ActeurActe)
	 */
	@Override
	@SuppressWarnings({ "finally" })
	public boolean checkActeur(ActeurActe acteurActe) {
		boolean result = false;
		try {

			if (acteurActe.getStatut().equals("1")) {
				if (getCompteDAO().getCompteFromActeur(acteurActe.getActeur()) != null) {
					result = true;
				}

			}
		} catch (Exception e) {

		} finally {
			return result;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * clinique.metier.gestion.commerciale.IGestionCommercialeBO#checkAddActePc
	 * (clinique.model.gestion.commerciale.GestionCommercialeForm)
	 */
	@SuppressWarnings({ "rawtypes", "deprecation" })
	@Override
	public ActionMessages checkAddActePc(GestionCommercialeForm formulaire) {
		ActionMessages errors2 = new ActionMessages();

		log.debug("********** Debut checkAddActePc GestionCommercialeAction **********");
		// Session session=SessionFactoryUtil.getInstance().openSession();

		try {
			Acte acte = getActeDAO().getActe(
					Integer.parseInt(formulaire.getActeId()));

			List prestCouvList = formulaire.getPrestationCouvertesPcs();
			if (prestCouvList.size() > 0) {
				for (Iterator iter = prestCouvList.iterator(); iter.hasNext();) {
					PrestationCouvertesPc element = (PrestationCouvertesPc) iter
							.next();

					if (element.getActe().getActeId() == acte.getActeId()) {
						ActionError error = new ActionError(
								"formulaire.acte.dejaCouvert");
						errors2.add("errorMsg", error);
					}

				}
			}
		} catch (Exception e) {

			e.printStackTrace();
			log.fatal(e.getMessage());

		}

		finally {
			// session.close();
			log.debug("********** Fin checkAddActePc GestionCommercialeBO **********");
			// SessionFactoryUtil.getInstance().close();
			return errors2;
		}

	}

	/*
	 * @SuppressWarnings({ "unchecked", "deprecation" }) public ActionMessages
	 * checkAddClassePc(GestionCommercialeForm formulaire) {
	 * 
	 * ActionMessages errors2=new ActionMessages(); Classe
	 * classe=ClasseDAO.getInstance
	 * ().getClasse(Integer.parseInt(formulaire.getClasseId()));
	 * 
	 * List prestCouvList=formulaire.getPrestationCouvertesPcs(); if
	 * (prestCouvList.size()>0) { for (Iterator iter = prestCouvList.iterator();
	 * iter.hasNext();) { PrestationCouvertesPc element =
	 * (PrestationCouvertesPc) iter.next();
	 * 
	 * if (element.getType().equals("classe")) { if
	 * (element.getClasse().getClasseId()==classe.getClasseId()) { ActionError
	 * error = new ActionError("formulaire.classe.dejaCouverte");
	 * errors2.add("errorMsg", error); } }
	 * 
	 * 
	 * if (element.getType().equals("acte")) { if
	 * (element.getActe().getClasse().getClasseId()==classe.getClasseId()) {
	 * ActionError error = new
	 * ActionError("formulaire.acteClasse.dejaCouverte");
	 * errors2.add("errorMsg", error); } }
	 * 
	 * if (element.getType().equals("famille")) { if
	 * (classe.getFamillePrestation
	 * ().getFamillepId()==element.getFamille().getFamillepId()) { ActionError
	 * error = new ActionError("formulaire.familleClasse.dejaCouverte");
	 * errors2.add("errorMsg", error); } }
	 * 
	 * } } return errors2;
	 * 
	 * }
	 */
	/*
	 * @SuppressWarnings({ "unchecked", "deprecation" }) public ActionMessages
	 * checkAddFamillePc(GestionCommercialeForm formulaire) {
	 * 
	 * ActionMessages errors2=new ActionMessages(); FamillePrestation
	 * famille=FamillePrestationDAO
	 * .getInstance().getFamillePrestation(Integer.parseInt
	 * (formulaire.getFamillepId()));
	 * 
	 * List prestCouvList=formulaire.getPrestationCouvertesPcs();
	 * 
	 * if (prestCouvList.size()>0) { for (Iterator iter =
	 * prestCouvList.iterator(); iter.hasNext();) { PrestationCouvertesPc
	 * element = (PrestationCouvertesPc) iter.next();
	 * 
	 * if (element.getType().equals("famille")) { if
	 * (element.getFamille().getFamillepId()==famille.getFamillepId()) {
	 * 
	 * ActionError error = new ActionError("formulaire.famille.dejaCouverte");
	 * errors2.add("formulaire.famille.dejaCouverte", error); } }
	 * 
	 * 
	 * if (element.getType().equals("acte")) { if
	 * (element.getActe().getClasse().
	 * getFamillePrestation().getFamillepId()==famille.getFamillepId()) {
	 * ActionError error = new
	 * ActionError("formulaire.acteFamille.dejaCouverte");
	 * errors2.add("errorMsg", error); } }
	 * 
	 * if (element.getType().equals("classe")) { if
	 * (element.getClasse().getFamillePrestation
	 * ().getFamillepId()==famille.getFamillepId()) { ActionError error = new
	 * ActionError("formulaire.classeFamille.dejaCouverte");
	 * errors2.add("errorMsg", error); } }
	 * 
	 * } }
	 * 
	 * return errors2;
	 * 
	 * }
	 */

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * clinique.metier.gestion.commerciale.IGestionCommercialeBO#checkAssureur
	 * (clinique.mapping.Assureur)
	 */
	@Override
	@SuppressWarnings({ "finally", "unchecked" })
	public boolean checkAssureur(Assureur assureur) {
		boolean result = false;
		try {

			if (assureur.getStatut().equals("1")) {

				List<Entreprise> entreprisesByAssureur = entrepriseDAO
						.findEntreprisesByAssureur(assureur);
				if (entreprisesByAssureur.size() > 0) {
					for (Object element : entreprisesByAssureur) {

						Entreprise ent = (Entreprise) element;

						result = checkEntreprise(ent);
					}
				}
			}
		} catch (Exception e) {

		} finally {
			return result;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * clinique.metier.gestion.commerciale.IGestionCommercialeBO#checkBadge(
	 * clinique.model.gestion.commerciale.GestionCommercialeForm,
	 * clinique.mapping.Patient)
	 */
	@Override
	@SuppressWarnings({ "unchecked", "finally" })
	public ActionMessages checkBadge(GestionCommercialeForm formulaire,
			Patient patient) {
		ActionMessages errors1 = new ActionMessages();
		// Session session=SessionFactoryUtil.getInstance().openSession();
		try {
			if (formulaire.getPriseEnChargeFlag().equals("badge")) {
				PatientPcActuel patientPcActuel = getPatientPcActuelDAO()
						.getPatientPcByPatient(patient);

				Categorie categorie = getCategorieDAO().getCategorie(
						Integer.parseInt(formulaire.getCategorieId()));
				for (BlackListe blackListe : blackListeDAO
						.findBlackListesByCategorie(categorie)) {

					if (patientPcActuel.getType().equals("badge")
							&& patientPcActuel.getBadge() != null) {

						if (blackListe.getStatut().equals(STATUT_VALIDE)
								&& blackListe.getNumeroBadge().equals(
										patientPcActuel.getBadge()
												.getNumeroBadge())) {
							ActionError error = new ActionError(
									"formulaire.badge.nonValide");
							errors1.add("errorMsg", error);

						}

					}

				}
				if (patientPcActuel.getType().equals("badge")
						&& patientPcActuel.getBadge() != null) {
					formulaire.setBadge(patientPcActuel.getBadge());
				}
			}
		} catch (Exception e) {
			throw e;
		} finally {
			// session.close();
			return errors1;
		}

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * clinique.metier.gestion.commerciale.IGestionCommercialeBO#checkCategorie
	 * (clinique.mapping.Categorie)
	 */
	@Override
	@SuppressWarnings({ "finally" })
	public boolean checkCategorie(Categorie categorie) {
		boolean result = false;
		try {

			if (categorie.getStatut().equals("1")) {
				result = true;

			}
		} catch (Exception e) {

		} finally {
			return result;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * clinique.metier.gestion.commerciale.IGestionCommercialeBO#checkClasse
	 * (clinique.mapping.Classe)
	 */
	@Override
	@SuppressWarnings({ "finally", "unchecked" })
	public boolean checkClasse(Classe classe) {
		boolean result = false;
		try {

			if (classe.getStatut().equals("1")) {

				if (acteDAO.findActesByClasse(classe).size() > 0) {
					for (Object element : acteDAO.findActesByClasse(classe)) {

						Acte acte = (Acte) element;

						result = checkActe(acte);
					}
				}
			}
		} catch (Exception e) {

		} finally {
			return result;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * clinique.metier.gestion.commerciale.IGestionCommercialeBO#checkEntreprise
	 * (clinique.mapping.Entreprise)
	 */
	@Override
	@SuppressWarnings({ "unchecked", "finally" })
	public boolean checkEntreprise(Entreprise entreprise) {
		boolean result = false;
		try {

			if (entreprise.getStatut().equals("1")) {

				List<Categorie> categoriesByEntreprise = categorieDAO
						.findCategoriesByEntreprise(entreprise);
				if (categoriesByEntreprise.size() > 0) {
					for (Categorie categorie : categoriesByEntreprise) {

						if (categorie.getStatut().equals("1")) {
							result = true;
						}
					}
				}
			}
		} catch (Exception e) {

		} finally {
			return result;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * clinique.metier.gestion.commerciale.IGestionCommercialeBO#checkFacture
	 * (clinique.model.gestion.commerciale.GestionCommercialeForm)
	 */
	@Override
	public boolean checkFacture(GestionCommercialeForm formulaire)
			throws Exception {

		boolean result = false;
		log.debug("********** Debut checkFacture GestionCommercialeBO **********");
		try {

			int nbreFact = 0;
			Facture facture = new Facture();
			Patient patientf = getPatientDAO().getPatient(
					formulaire.getPatientId());
			List<Facture> factures = factureDAO.findFacturesByPatient(patientf);
			if (factures.size() > 0) {
				for (Facture fact : factures) {
					if (fact.getStatut().equals(STATUT_SUPPRIME)) {
						if (nbreFact == 0) {
							facture = fact;
						}
						nbreFact++;
					}

				}
			}

			if (nbreFact > 1) {
				return result = false;
			} else {

				if (nbreFact == 1) {
					formulaire.setFactureId(String.valueOf(facture
							.getFactureId()));
				} else {
					Patient patient = getPatientDAO().getPatient(
							formulaire.getPatientId());
					facture.setPatient(patient);
					getFactureDAO().save(facture);
					// session.merge(facture);
					formulaire.setFactureId("");
				}

				result = true;
			}

		} catch (Exception e) {
			log.fatal(e.getMessage());

		} finally {
			log.debug("********** Fin checkFacture GestionCommercialeBO **********");
			return result;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * clinique.metier.gestion.commerciale.IGestionCommercialeBO#checkFamillePres
	 * (clinique.mapping.FamillePrestation)
	 */
	@Override
	@SuppressWarnings({ "finally", "unchecked" })
	public boolean checkFamillePres(FamillePrestation famillePres) {
		boolean result = false;
		try {

			if (famillePres.getStatut().equals("1")) {
				for (Object element : acteDAO
						.findActesByFamillePrestation(famillePres)) {

					Acte acte = (Acte) element;

					result = checkActe(acte);
				}

			}
		} catch (Exception e) {

		} finally {
			return result;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see clinique.metier.gestion.commerciale.IGestionCommercialeBO#
	 * checkNbreActesRestant
	 * (clinique.model.gestion.commerciale.GestionCommercialeForm)
	 */
	@Override
	@SuppressWarnings("unchecked")
	public boolean checkNbreActesRestant(GestionCommercialeForm formulaire) {
		if (formulaire.getPrestationCouvertesPcs().size() > 0) {
			int nbreActesRestant = 0;
			int limit = 1;
			for (Iterator iter = formulaire.getPrestationCouvertesPcs()
					.iterator(); iter.hasNext();) {
				PrestationCouvertesPc element = (PrestationCouvertesPc) iter
						.next();
				if (element.getLimite().equals("1")) {
					nbreActesRestant = nbreActesRestant
							+ element.getNbreActesRestant();
				} else {
					limit = 0;
				}
			}

			if (limit == 1) {
				if (nbreActesRestant != 0) {
					return true;
				} else {
					return false;
				}
			} else {
				return true;
			}
		} else {
			return true;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * clinique.metier.gestion.commerciale.IGestionCommercialeBO#checkPC(clinique
	 * .mapping.PriseEnCharge)
	 */
	@Override
	public boolean checkPC(PriseEnCharge pc) {
		boolean result = false;
		if (pc.getStatut().equals("1")
				&& !UtilDate.getInstance().beforeDateJour(pc.getFinValidite())) {
			// if plafond
			if (pc.getPlafond() > 0) {
				if (pc.getPlafond() > pc.getMontantFact()) {

					if (prestationCouvertesPcDAO
							.findPrestationCouvertesByPc(pc).size() > 0) {
						result = checkPrestationCouvertesPC(pc);

					} else {
						result = true;
					}

				}
			} else {
				result = true;
			}
		}

		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * clinique.metier.gestion.commerciale.IGestionCommercialeBO#checkPcValide
	 * (clinique.mapping.PriseEnCharge,
	 * clinique.model.gestion.commerciale.GestionCommercialeForm)
	 */
	@Override
	public boolean checkPcValide(PriseEnCharge pc,
			GestionCommercialeForm formulaire) {
		boolean result = false;
		if (pc.getStatut().equals(STATUT_VALIDE)) {
			if (!UtilDate.getInstance().beforeDateJour(pc.getFinValidite())) {
				if (pc.getPlafond() == 0) {

					result = checkNbreActesRestant(formulaire);
				} else {
					if (pc.getMontantFact()
							+ Double.parseDouble(formulaire.getTotalApayer()) < pc
								.getPlafond()) {
						result = checkNbreActesRestant(formulaire);
					}
				}
			}
		}

		return result;

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see clinique.metier.gestion.commerciale.IGestionCommercialeBO#
	 * checkPrestationCouvertesPC(clinique.mapping.PriseEnCharge)
	 */
	@Override
	@SuppressWarnings("unchecked")
	public boolean checkPrestationCouvertesPC(PriseEnCharge pc) {
		boolean result = false;
		for (Object element2 : prestationCouvertesPcDAO
				.findPrestationCouvertesByPc(pc)) {
			PrestationCouvertesPc element = (PrestationCouvertesPc) element2;
			if (element.getStatut().equals("1")) {
				if (element.getLimite().equals("1")) {
					if (element.getNbreActesRestant() > 0) {
						result = true;
					}

				} else {
					result = true;
				}
			}
		}

		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * clinique.metier.gestion.commerciale.IGestionCommercialeBO#checkPrestCouvAdd
	 * (clinique.model.gestion.commerciale.GestionCommercialeForm)
	 */
	@Override
	public ActionMessages checkPrestCouvAdd(GestionCommercialeForm formulaire) {
		ActionMessages errors1 = new ActionMessages();

		errors1 = checkAddActePc(formulaire);
		return errors1;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see clinique.metier.gestion.commerciale.IGestionCommercialeBO#
	 * checkReglementPCByAssureur
	 * (clinique.model.gestion.commerciale.GestionCommercialeForm)
	 */
	@Override
	@SuppressWarnings({ "unchecked", "finally" })
	public boolean checkReglementPCByAssureur(GestionCommercialeForm formulaire)
			throws Exception {

		boolean result = false;
		log.debug("********** Debut ajouterRegelement GestionCommercialeBO **********");
		// Session session=SessionFactoryUtil.getInstance().openSession();

		try {
			List reglementsList = formulaire.getReglementsList();
			double payerParAssureur = Double.parseDouble(formulaire
					.getCoteAssureur());
			if (payerParAssureur > 0) {
				Reglement reglement = new Reglement();
				reglement.setReglementId(ConstantesMetier.ID_REGLEMENT
						+ UtilDate.getInstance().getDateForId()
						+ ""
						+ getUserDao()
								.getUserByLogin(formulaire.getOperateur())
								.getUserId());

				// payerParAssureur=payerParAssureur+payerParAssureur*30/100;
				reglement.setMontant(payerParAssureur);
				reglement.setDateReglement(UtilDate.getInstance()
						.getDateToday());
				reglement.setDescription(getCategorieDAO().getCategorie(
						Integer.parseInt(formulaire.getCategorieId()))
						.getNomCategorie());

				reglement.setCategorie(getCategorieDAO().getCategorie(
						Integer.parseInt(formulaire.getCategorieId())));

				if (formulaire.getPriseEnChargeFlag().equals("priseEnCharge")) {
					PriseEnCharge pc = formulaire.getPriseEnCharge();
					reglement.setTypePC("priseEnCharge");
					reglement.setPriseEnCharge(pc);
				} else if (formulaire.getPriseEnChargeFlag().equals("badge")) {
					Badge badge = formulaire.getBadge();
					reglement.setTypePC("badge");
					reglement.setBadge(badge);
				}

				reglement.setTypePayement(getTypePayementDAO().getTypePayement(
						4));
				reglement.setStatut("1");
				reglementsList.add(reglement);
				formulaire.setReglementsList(reglementsList);
			}
			result = true;

		} catch (Exception e) {

			e.printStackTrace();
			log.fatal(e.getMessage());

		}

		finally {
			// session.close();
			log.debug("********** Fin ajouterRegelement GestionCommercialeBO **********");
			return result;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see clinique.metier.gestion.commerciale.IGestionCommercialeBO#
	 * checkReglementPCByAssureurCNAM
	 * (clinique.model.gestion.commerciale.GestionCommercialeForm)
	 */
	@Override
	@SuppressWarnings({ "unchecked", "finally" })
	public boolean checkReglementPCByAssureurCNAM(
			GestionCommercialeForm formulaire) throws Exception {

		boolean result = false;
		log.debug("********** Debut checkReglementPCByAssureurCNAM GestionCommercialeBO **********");
		// Session session=SessionFactoryUtil.getInstance().openSession();

		try {
			List reglementsList = formulaire.getReglementsList();
			double payerParAssureur = Double.parseDouble(formulaire
					.getCoteAssureur());
			Categorie categorie = getCategorieDAO().getCategorie(
					Integer.parseInt(formulaire.getCategorieId()));
			int pourcentage = categorie.getPourcentage();

			if (payerParAssureur > 0) {
				for (Iterator iter = formulaire.getDetailDrgCnamListFacture()
						.iterator(); iter.hasNext();) {
					DetailDgrCnamFacture element = (DetailDgrCnamFacture) iter
							.next();

					Reglement reglement = new Reglement();
					reglement.setReglementId(ConstantesMetier.ID_REGLEMENT
							+ UtilDate.getInstance().getDateForId()
							+ ""
							+ getUserDao().getUserByLogin(
									formulaire.getOperateur()).getUserId());

					DrgCnam drg = element.getDrgCnam();
					// payerParAssureur=payerParAssureur+payerParAssureur*30/100;
					reglement.setPetitMonnaie(element.getPetitMonnaie());
					reglement.setMontant(drg.getMontant() * pourcentage / 100);
					reglement.setDateReglement(UtilDate.getInstance()
							.getDateToday());
					reglement.setDescription("DRG " + drg.getNumDrg());
					reglement.setDrgCnam(drg);

					reglement.setCategorie(categorie);

					if (formulaire.getPriseEnChargeFlag().equals(
							"priseEnCharge")) {
						PriseEnCharge pc = formulaire.getPriseEnCharge();
						reglement.setTypePC("priseEnCharge");
						reglement.setPriseEnCharge(pc);
					} else if (formulaire.getPriseEnChargeFlag()
							.equals("badge")) {
						Badge badge = formulaire.getBadge();
						reglement.setTypePC("badge");
						reglement.setBadge(badge);
					}

					reglement.setTypePayement(getTypePayementDAO()
							.getTypePayement(4));
					reglement.setStatut("1");
					reglementsList.add(reglement);
					formulaire.setReglementsList(reglementsList);

				}

			}
			result = true;

		} catch (Exception e) {

			e.printStackTrace();
			log.fatal(e.getMessage());

		}

		finally {
			// session.close();
			log.debug("********** Fin checkReglementPCByAssureurCNAM GestionCommercialeBO **********");
			return result;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * clinique.metier.gestion.commerciale.IGestionCommercialeBO#checkRemise
	 * (clinique.model.gestion.commerciale.GestionCommercialeForm)
	 */
	@Override
	public void checkRemise(GestionCommercialeForm formulaire) {
		if (formulaire.getRemiseFlag().equals("oui")) {
			double resteApayer = Double
					.parseDouble(formulaire.getResteApayer());
			double remise = Double.parseDouble(formulaire
					.getCoteCliniqueReductible())
					* Integer.parseInt(formulaire.getRemiseValeur()) / 100;
			if (remise <= resteApayer) {
				formulaire.setRemiseMontant(String.valueOf(remise));
				formulaire.setResteApayer(String.valueOf(resteApayer - remise));

			} else {
				remise = resteApayer;
				formulaire.setRemiseMontant(String.valueOf(remise));
				formulaire.setResteApayer(String.valueOf(resteApayer - remise));
			}

		}

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see clinique.metier.gestion.commerciale.IGestionCommercialeBO#
	 * construireListePrestCouvertes
	 * (clinique.model.gestion.commerciale.GestionCommercialeForm)
	 */
	@Override
	@SuppressWarnings({ "unchecked", "finally" })
	public boolean construireListePrestCouvertes(
			GestionCommercialeForm formulaire) throws Exception {

		boolean result = false;
		log.debug("********** Debut ajouterActe GestionCommercialeBO **********");

		try {
			List prestCouvList = formulaire.getPrestationCouvertesPcs();

			// ajouter classe ou famille ou acte

			// debut id prestation couverte 15
			PrestationCouvertesPc pc = new PrestationCouvertesPc();
			pc.setPresCouvId(ConstantesMetier.ID_PRESTATIONCOUVERTEPC
					+ UtilDate.getInstance().getDateForId()
					+ ""
					+ getUserDao().getUserByLogin(formulaire.getOperateur())
							.getUserId());

			Acte a = getActeDAO().getActe(
					Integer.parseInt(formulaire.getActeId()));
			pc.setType("acte");
			pc.setLibelle(a.getNomActe());
			pc.setActe(a);
			// }

			if (formulaire.getActesLimite().equals("non")) {
				pc.setLimite("0");
			} else {
				pc.setNbreActes(Integer.parseInt(formulaire.getNombreActesPC()));
				pc.setNbreActesRestant(Integer.parseInt(formulaire
						.getNombreActesPC()));
				pc.setLimite("1");
			}
			pc.setStatut("1");
			prestCouvList.add(pc);
			formulaire.setPrestationCouvertesPcs(prestCouvList);
			// formulaire.setTypePcCouverte("famille");
			result = true;

		} catch (Exception e) {

			e.printStackTrace();
			log.fatal(e.getMessage());

		}

		finally {
			log.debug("********** Fin ajouterActe GestionCommercialeBO **********");
			return result;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * clinique.metier.gestion.commerciale.IGestionCommercialeBO#creerDevis(
	 * clinique.model.gestion.commerciale.GestionCommercialeForm)
	 */
	@Override
	@SuppressWarnings({ "finally", "unchecked" })
	public boolean creerDevis(GestionCommercialeForm formulaire)
			throws Exception {

		boolean result = false;
		log.debug("********** Debut creerDevis GestionCommercialeBO **********");
		try {

			Patient patient = formulaire.getPatient();
			DevisAssureur devisAssureur = new DevisAssureur();
			devisAssureur.setDevisAssureurId(ConstantesMetier.ID_DEVISASSUREUR
					+ UtilDate.getInstance().getDateForId()
					+ ""
					+ getUserDao().getUserByLogin(formulaire.getOperateur())
							.getUserId());
			devisAssureur.setCategorie(getCategorieDAO().getCategorie(
					Integer.valueOf(formulaire.getCategorieId().trim())));

			devisAssureur.setDateDevis(UtilDate.getInstance().getDateToday());
			devisAssureur.setTotal(Double.valueOf(formulaire.getTotalDevis()));

			if (formulaire.getOperation().equals("ancienWithPC")
					|| formulaire.getOperation().equals("ancienWithoutPC")) {
				getPatientDAO().update(patient);

			} else {
				patient.setStatut("1");
				getPatientDAO().save(patient);

				PatientPcActuel patientPcActuel = new PatientPcActuel();
				patientPcActuel
						.setPatientPcActuelId(ConstantesMetier.ID_PATIENTPCACTUEL
								+ UtilDate.getInstance().getDateForId()
								+ ""
								+ getUserDao().getUserByLogin(
										formulaire.getOperateur()).getUserId());

				patientPcActuel.setType("aucune");
				patientPcActuel.setPatient(patient);
				patientPcActuel.setStatut("1");
				getPatientPcActuelDAO().save(patientPcActuel);

			}

			devisAssureur.setPatient(patient);
			devisAssureur.setStatut("1");
			devisAssureur.setOperateur(formulaire.getOperateur().trim());
			devisAssureurDAO.save(devisAssureur);

			for (Iterator iter = formulaire.getDevisActesList().iterator(); iter
					.hasNext();) {
				DevisActes element = (DevisActes) iter.next();
				element.setDevisAssureur(devisAssureur);
				element.setStatut("1");
				element.setOperateur(formulaire.getOperateur().trim());
				devisActesDAO.create(element);
			}

			result = true;

		} catch (Exception e) {
			log.fatal(e.getMessage());

		}

		finally {
			log.debug("********** Fin creerDevis GestionCommercialeBO **********");
			return result;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * clinique.metier.gestion.commerciale.IGestionCommercialeBO#creerRecuHosp
	 * (clinique.model.gestion.commerciale.GestionCommercialeForm)
	 */
	@Override
	@SuppressWarnings({ "finally", "unchecked" })
	public boolean creerRecuHosp(GestionCommercialeForm formulaire)
			throws Exception {

		boolean result = false;
		log.debug("********** Debut AjouterRecuFacture GestionCommercialeBO **********");
		try {

			double total_HT = 0;

			for (Iterator iter = formulaire.getDetailsFactureList().iterator(); iter
					.hasNext();) {
				DetailFacture element = (DetailFacture) iter.next();
				total_HT = total_HT + element.getMontantTotal();
				element.setStatut("1");
				element.setFacture(formulaire.getFacture());
				element.setRecu(formulaire.getRecu());
				element.setHospitalisation(formulaire.getHospitalisation());
				detailFactureDAO.save(element);
			}

			// System.out.println("voila "+UserDAO.getInstance().getUserByLogin(formulaire.getOperateur()).getUserId());
			Reglement reglement = new Reglement();
			reglement.setReglementId(ConstantesMetier.ID_REGLEMENT
					+ UtilDate.getInstance().getDateForId()
					+ ""
					+ getUserDao().getUserByLogin(formulaire.getOperateur())
							.getUserId());
			reglement.setTypePayement(getTypePayementDAO().getTypePayement(4));
			reglement.setDateReglement(UtilDate.getInstance().getDateToday());
			reglement.setDescription(formulaire.getHospitalisation()
					.getChambre().getChambreLibelle());
			reglement.setMontant(total_HT);

			formulaire.getRecu().setReglement(reglement);
			formulaire.getRecu().setTotal(total_HT);
			formulaire.getRecu().setStatut("1");
			reglementDAO.save(reglement);

			Recu recu = formulaire.getRecu();
			recuDAO.save(recu);

			result = true;

		} catch (Exception e) {
			e.printStackTrace();
			log.fatal(e.getMessage());

		}

		finally {
			log.debug("********** Fin AjouterRecuFacture GestionCommercialeBO **********");
			return result;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * clinique.metier.gestion.commerciale.IGestionCommercialeBO#genererFacture
	 * (clinique.model.gestion.commerciale.GestionCommercialeForm)
	 */
	@Override
	@SuppressWarnings({ "finally", "unchecked" })
	public boolean genererFacture(GestionCommercialeForm formulaire)
			throws Exception {

		boolean result = false;
		log.debug("********** Debut genererFacture GestionCommercialeBO **********");
		try {

			Facture facture = getFactureDAO().getFacture(
					formulaire.getFactureId().trim());
			FactureModifiees factureM = new FactureModifiees();
			factureM.setFactureModifieeId(ConstantesMetier.ID_FACTUREMODIFIE
					+ UtilDate.getInstance().getDateForId()
					+ ""
					+ getUserDao().getUserByLogin(formulaire.getOperateur())
							.getUserId());
			factureM.setPatient(facture.getPatient());
			factureM.setDateFact(facture.getDateFact());
			factureM.setDateModification(UtilDate.getInstance().getDateToday());
			factureM.setRemise(facture.getRemise());
			factureM.setMajoration(facture.getMajoration());
			factureM.setAvance(facture.getAvance());
			factureM.setTauxRemise(facture.getTauxRemise());
			factureM.setTypePc(facture.getTypePc());
			factureM.setFacture(facture);
			factureM.setBadge(facture.getBadge());
			factureM.setPriseEnCharge(facture.getPriseEnCharge());
			if (facture.getTypePc().equals("priseEnCharge")) {
				PriseEnChargeModifiee pcM = new PriseEnChargeModifiee();
				pcM.setPcId(ConstantesMetier.ID_PRISEENCHARGE
						+ UtilDate.getInstance().getDateForId()
						+ ""
						+ getUserDao()
								.getUserByLogin(formulaire.getOperateur())
								.getUserId());

			}
			factureM.setIsHospitalisation(facture.getIsHospitalisation());
			factureModifieesDAO.save(factureM);

			for (Object element2 : detailFactureDAO
					.findDetailFactureByFacture(facture)) {
				DetailFacture element = (DetailFacture) element2;
				DetailFactureModifiees dfM = new DetailFactureModifiees();

				dfM.setDetailFactId(element.getDetailFactId());
				dfM.setActe(element.getActe());
				dfM.setNomActe(element.getNomActe());
				dfM.setNbrActes(element.getNbrActes());
				dfM.setUrgenceActe(element.getUrgenceActe());
				dfM.setDepl(element.getDepl());

				if (factureM.getIsHospitalisation().equals("1")) {
					dfM.setHospitalisation(element.getHospitalisation());
				}

				dfM.setPrix(element.getPrix());
				dfM.setPrixUrg(element.getPrixUrg());
				dfM.setPrixDepl(element.getPrixDepl());
				dfM.setStatut("1");
				dfM.setFacture(factureM);
				dfM.setType(element.getType());
				dfM.setMedecinExiste(element.getMedecinExiste());
				dfM.setInfirmierExiste(element.getInfirmierExiste());
				dfM.setMedecin(element.getMedecin());
				dfM.setInfirmier(element.getInfirmier());
				// session.save(dfM);

				// *********** calculer montant total *****************
				setInfosDfm(dfM);
				if (dfM.getType().equals("normal")) {
					dfM.setMontantTotal(element.getNbrActes() * dfM.getPrix());
				} else if (dfM.getType().equals("urgence")) {
					dfM.setMontantTotal(element.getNbrActes()
							* dfM.getPrixUrg());
				} else {
					dfM.setMontantTotal(element.getNbrActes()
							* dfM.getPrixDepl());
					// *******************************
				}
				detailFactureModifieesDAO.save(dfM);
			}

			result = true;

		} catch (Exception e) {
			log.fatal(e.getMessage());

		}

		finally {
			log.debug("********** Fin genererFacture GestionCommercialeBO **********");
			return result;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see clinique.metier.gestion.commerciale.IGestionCommercialeBO#
	 * getAncienPatientInfosAssureur(clinique.mapping.Patient,
	 * clinique.model.gestion.commerciale.GestionCommercialeForm)
	 */
	@Override
	@SuppressWarnings("unchecked")
	public void getAncienPatientInfosAssureur(Patient patient,
			GestionCommercialeForm formulaire) {
		if (patient.getCategorie() != null) {
			formulaire
					.setNomCategorie(patient.getCategorie().getNomCategorie());
			formulaire.setCategorieId(String.valueOf(patient.getCategorie()
					.getCategorieId()));

			formulaire.setNomEntreprise(patient.getCategorie().getEntreprise()
					.getNomEntreprise());
			formulaire.setEntrepriseId(String.valueOf(patient.getCategorie()
					.getEntreprise().getEntrepriseId()));

			formulaire.setNomAssureur(patient.getCategorie().getEntreprise()
					.getAssureur().getNomAssureur());
			formulaire.setAssureurId(String.valueOf(patient.getCategorie()
					.getEntreprise().getAssureur().getAssureurId()));
			formulaire.setLibeleAssureur(patient.getCategorie()
					.getNomCategorie());

			if (patient.getPriseEnChargeFlag().equals("aucune")) {
				formulaire.setPriseEnChargeFlag("aucune");
				formulaire.setPrestationCouvertesPcs(new ArrayList());
			} else if (patient.getPriseEnChargeFlag().equals("badge")) {
				if (checkBadge(formulaire, patient).isEmpty()) {
					PatientPcActuel patientPcActuel = getPatientPcActuelDAO()
							.getPatientPcByPatient(patient);
					if (patientPcActuel.getType().equals("badge")
							&& patientPcActuel.getBadge() != null) {
						formulaire.setPriseEnChargeFlag("badge");
						formulaire.setNumeroBadge(patientPcActuel.getBadge()
								.getNumeroBadge());
						formulaire.setPrestationCouvertesPcs(new ArrayList());
					}
				} else {
					formulaire.setPriseEnChargeFlag("aucune");
					formulaire.setPrestationCouvertesPcs(new ArrayList());
				}
			}
			// verifer prise en charge
			else {
				formulaire.setPriseEnChargeFlag("aucune");
				formulaire.setPrestationCouvertesPcs(new ArrayList());

				for (Object element2 : priseEnChargeDAO
						.findPriseEnChargeByPatient(patient)) {
					PriseEnCharge element = (PriseEnCharge) element2;
					if (checkPC(element)) {
						formulaire.setPriseEnChargeFlag("priseEnCharge");
						formulaire.setPriseEnCharge(element);
						formulaire
								.setPrestationCouvertesPcs(prestationCouvertesPcDAO
										.findPrestationCouvertesByPc(element));

						formulaire.setNumPC(element.getPcNum());

						if (element.getPlafond() > 0) {
							formulaire.setPlafond(String.valueOf(element
									.getPlafond()));
						}

						if (element.getPourcentage() > 0) {
							formulaire.setPourcentage(String.valueOf(element
									.getPourcentage()));
						}

						if (element.getDateCreation() != null) {
							formulaire.setDateCreation(UtilDate.getInstance()
									.dateToString(element.getDateCreation()));
						}

						if (element.getFinValidite() != null) {
							formulaire.setFinValidite(UtilDate.getInstance()
									.dateToString(element.getFinValidite()));
						}

						break;

					}

				}
			}
			// fin verifcation prise en charge
		}

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * clinique.metier.gestion.commerciale.IGestionCommercialeBO#getChambreFrais
	 * (clinique.mapping.ChambresHospitalisation)
	 */
	@Override
	public double getChambreFrais(ChambresHospitalisation chambreHospitalisation) {
		double frais = 0;

		Chambre chambre = chambreHospitalisation.getChambre();
		if (chambre != null) {
			double tarif = chambre.getTarif();
			Date dateEntree = chambreHospitalisation.getDateEntree();
			Date dateSortie = chambreHospitalisation.getDateSortie();
			int heureEntree = chambreHospitalisation.getHeureEntree();
			int heureSortie = chambreHospitalisation.getHeureSortie();

			Date date1 = new GregorianCalendar(dateEntree.getYear(),
					dateEntree.getMonth(), dateEntree.getDate(), heureEntree,
					00).getTime();
			Date date2 = new GregorianCalendar(dateSortie.getYear(),
					dateSortie.getMonth(), dateSortie.getDate(), heureSortie,
					00).getTime();

			long diff = date2.getTime() - date1.getTime();
			double nbreHeures = diff / (1000 * 60 * 60) % 24;
			double nbreJours = diff / (1000 * 60 * 60) / 24;

			if (nbreHeures > 0 && nbreHeures <= 2) {
				nbreHeures = 6;
			}

			else if (nbreHeures > 2 && nbreHeures <= 6) {
				nbreHeures = 12;
			}

			else if (nbreHeures > 6) {
				nbreHeures = 24;
			}

			frais = tarif * 24 * nbreJours + tarif * nbreHeures;

		}

		return frais;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * clinique.metier.gestion.commerciale.IGestionCommercialeBO#getInfosPC(
	 * clinique.model.gestion.commerciale.GestionCommercialeForm)
	 */
	@Override
	@SuppressWarnings("unchecked")
	public void getInfosPC(GestionCommercialeForm formulaire) {
		formulaire.setPriseEnChargeFlag("aucune");

		if (formulaire.getPatient().getPriseEnChargeFlag().equals("aucune")) {
			formulaire.setPriseEnChargeFlag("aucune");
		} else if (formulaire.getPatient().getPriseEnChargeFlag()
				.equals("badge")) {
			PatientPcActuel patientPcActuel = getPatientPcActuelDAO()
					.getPatientPcByPatient(formulaire.getPatient());
			if (patientPcActuel.getType().equals("badge")
					&& patientPcActuel.getBadge() != null) {
				formulaire.setPriseEnChargeFlag("badge");
				formulaire.setBadge(patientPcActuel.getBadge());
			}
		} else {
			PatientPcActuel patientPcActuel = getPatientPcActuelDAO()
					.getPatientPcByPatient(formulaire.getPatient());
			if (patientPcActuel.getType().equals("priseEnCharge")
					&& patientPcActuel.getPriseEnCharge() != null) {
				PriseEnCharge element = patientPcActuel.getPriseEnCharge();
				if (checkPC(element)) {
					formulaire.setPriseEnChargeFlag("priseEnCharge");
					formulaire.setPriseEnCharge(element);
					formulaire
							.setPrestationCouvertesPcs(prestationCouvertesPcDAO
									.findPrestationCouvertesByPc(element));
				}
			}
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see clinique.metier.gestion.commerciale.IGestionCommercialeBO#
	 * getListDevisAimprimer
	 * (clinique.model.gestion.commerciale.GestionCommercialeForm)
	 */
	@Override
	@SuppressWarnings({ "finally", "unchecked" })
	public boolean getListDevisAimprimer(GestionCommercialeForm formulaire)
			throws Exception {

		log.debug("********** Debut getListDevisAimprimer GestionCommercialeBO **********");
		// Session session=SessionFactoryUtil.getInstance().openSession();
		boolean result = false;
		try {
			if (formulaire.getIsFirst().equals("true")) {
				String dateR = UtilDate.getInstance().dateToString(
						UtilDate.getInstance().getDateToday());
				formulaire.setDateDebutRechFact(dateR);
				formulaire.setDateFinRechFact(dateR);
				System.out.println("datttttttttttttttte :" + dateR);
			}

			Collection<DevisAssureur> list = getDevisAssureurDAO()
					.listDevisAimprimer(formulaire.getDateDebutRechFact(),
							formulaire.getDateFinRechFact());

			if (list != null) {
				initialiserForm(formulaire);
				formulaire.setDateDebutRechFact("");
				formulaire.setDateFinRechFact("");

				formulaire.setDevisAimprimerList((List) list);
				result = true;
			}

		} catch (Exception e) {

			log.fatal(e.getMessage());
		}

		finally {
			log.debug("********** Debut getListDevisAimprimer GestionCommercialeBO **********");
			return result;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see clinique.metier.gestion.commerciale.IGestionCommercialeBO#
	 * getListFacturesAgenerer
	 * (clinique.model.gestion.commerciale.GestionCommercialeForm)
	 */
	@Override
	@SuppressWarnings({ "finally", "unchecked" })
	public boolean getListFacturesAgenerer(GestionCommercialeForm formulaire)
			throws Exception {

		log.debug("********** Debut getListFacturesAgenerer GestionCommercialeBO **********");
		// Session session=SessionFactoryUtil.getInstance().openSession();
		boolean result = false;
		try {
			Collection<Facture> list = getFactureDAO().listFacturesNoException(
					formulaire.getDateDebutRechFact(),
					formulaire.getDateFinRechFact());

			if (list != null) {
				initialiserForm(formulaire);

				formulaire.setFacturesAgenererList((List) list);
				result = true;
			}

		} catch (Exception e) {

			log.fatal(e.getMessage());
		}

		finally {
			// session.close();
			log.debug("********** Debut getListFacturesAgenerer GestionCommercialeBO **********");
			return result;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see clinique.metier.gestion.commerciale.IGestionCommercialeBO#
	 * getListFacturesAimprimer
	 * (clinique.model.gestion.commerciale.GestionCommercialeForm)
	 */
	@Override
	@SuppressWarnings({ "unchecked", "finally" })
	public boolean getListFacturesAimprimer(GestionCommercialeForm formulaire)
			throws Exception {

		log.debug("********** Debut getListFacturesAimprimer GestionCommercialeBO **********");
		// Session session=SessionFactoryUtil.getInstance().openSession();
		boolean result = false;
		try {
			if (formulaire.getIsFirst().equals("true")) {
				String dateR = UtilDate.getInstance().dateToString(
						UtilDate.getInstance().getDateToday());
				formulaire.setDateDebutRechFact(dateR);
				formulaire.setDateFinRechFact(dateR);
			}

			Collection<Facture> list = getFactureDAO().listFacturesAimprimer(
					formulaire.getDateDebutRechFact(),
					formulaire.getDateFinRechFact());

			if (list != null) {
				initialiserForm(formulaire);
				formulaire.setDateDebutRechFact("");
				formulaire.setDateFinRechFact("");

				formulaire.setFacturesAimprimerList((List) list);
				result = true;
			}

		} catch (Exception e) {

			log.fatal(e.getMessage());
		}

		finally {
			// session.close();
			log.debug("********** Debut getListFacturesAimprimer GestionCommercialeBO **********");
			return result;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see clinique.metier.gestion.commerciale.IGestionCommercialeBO#
	 * getListFacturesGenerees
	 * (clinique.model.gestion.commerciale.GestionCommercialeForm)
	 */
	@Override
	@SuppressWarnings({ "finally", "unchecked" })
	public boolean getListFacturesGenerees(GestionCommercialeForm formulaire)
			throws Exception {

		log.debug("********** Debut getListFacturesGenerees GestionCommercialeBO **********");
		// Session session=SessionFactoryUtil.getInstance().openSession();
		boolean result = false;
		try {
			Collection<FactureModifiees> list = factureModifieesDAO
					.listFactureModifieesEncours();

			if (list != null) {
				initialiserForm(formulaire);

				formulaire.setFacturesAmodifierList((List) list);
				result = true;
			}

		} catch (Exception e) {

			log.fatal(e.getMessage());
		}

		finally {
			// session.close();
			log.debug("********** Debut getListFacturesGenerees GestionCommercialeBO **********");
			return result;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * clinique.metier.gestion.commerciale.IGestionCommercialeBO#getListHopitalises
	 * (clinique.model.gestion.commerciale.GestionCommercialeForm)
	 */
	@Override
	@SuppressWarnings({ "unchecked", "finally" })
	public boolean getListHopitalises(GestionCommercialeForm formulaire)
			throws Exception {

		log.debug("********** Debut getListHopitalises GestionCommercialeBO **********");
		// Session session=SessionFactoryUtil.getInstance().openSession();
		boolean result = false;
		try {
			Collection<Hospitalisation> list = getHospitalisationDAO()
					.listHospitalisationsEncours();

			if (list != null) {
				initialiserForm(formulaire);
				formulaire.setHopitalises((List) list);
				result = true;
			}

		} catch (Exception e) {

			log.fatal(e.getMessage());
		}

		finally {
			// session.close();
			log.debug("********** Debut getListHopitalises GestionCommercialeBO **********");
			return result;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see clinique.metier.gestion.commerciale.IGestionCommercialeBO#
	 * getListHopitalisesPatients
	 * (clinique.model.gestion.commerciale.GestionCommercialeForm)
	 */
	@Override
	@SuppressWarnings({ "unchecked", "finally" })
	public List getListHopitalisesPatients(GestionCommercialeForm formulaire)
			throws Exception {
		List patients = new ArrayList();

		log.debug("********** Debut getListHopitalises GestionCommercialeBO **********");

		try {
			Collection<Hospitalisation> list = getHospitalisationDAO()
					.listHospitalisationsEncours();

			if (list != null) {

				for (Object element2 : list) {
					Hospitalisation element = (Hospitalisation) element2;
					patients.add(element.getPatient());
				}

			}

		} catch (Exception e) {
			log.fatal(e.getMessage());
		}

		finally {
			log.debug("********** Debut getListHopitalises GestionCommercialeBO **********");
			return patients;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see clinique.metier.gestion.commerciale.IGestionCommercialeBO#
	 * getListPatientsMulti
	 * (clinique.model.gestion.commerciale.GestionCommercialeForm)
	 */
	@Override
	@SuppressWarnings({ "unchecked", "finally" })
	public boolean getListPatientsMulti(GestionCommercialeForm formulaire)
			throws Exception {

		log.debug("********** Debut getListPatientsMulti GestionCommercialeBO **********");
		boolean result = false;

		try {
			Collection<Patient> list = getPatientDAO().listPatientsRecherches(
					formulaire.getPatientIdR(), formulaire.getNomR(),
					formulaire.getPrenomR(), formulaire.getDateNaissanceR(),
					formulaire.getDateDerniereVisiteR(),
					formulaire.getTelephoneR(), formulaire.getCniR(),
					formulaire.getNniR(), formulaire.getNumeroBadgeR());

			if (list != null) {
				formulaire.setPatients((List) list);
				result = true;
			}

		} catch (Exception e) {
			log.fatal(e.getMessage());
		}

		finally {
			// session.close();
			log.debug("********** Fin getListPatientsMulti GestionCommercialeBO **********");
			return result;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see clinique.metier.gestion.commerciale.IGestionCommercialeBO#
	 * getListPatientsMultiForHosp
	 * (clinique.model.gestion.commerciale.GestionCommercialeForm)
	 */
	@Override
	@SuppressWarnings({ "finally", "unchecked" })
	public boolean getListPatientsMultiForHosp(GestionCommercialeForm formulaire)
			throws Exception {

		log.debug("********** Debut getListPatientsMulti GestionCommercialeBO **********");
		boolean result = false;

		// Session session=SessionFactoryUtil.getInstance().openSession();
		try {
			Collection<Patient> list = getPatientDAO().listPatientsRecherches(
					formulaire.getPatientIdR(), formulaire.getNomR(),
					formulaire.getPrenomR(), formulaire.getDateNaissanceR(),
					formulaire.getDateDerniereVisiteR(),
					formulaire.getTelephoneR(), formulaire.getCniR(),
					formulaire.getNniR(), formulaire.getNumeroBadgeR());

			formulaire.setPatients(new ArrayList());
			if (list != null) {
				int i = 0;
				for (Object element : list) {
					i = 0;
					Patient patient = (Patient) element;
					for (Iterator iter1 = getListHopitalisesPatients(formulaire)
							.iterator(); iter1.hasNext();) {
						Patient patient1 = (Patient) iter1.next();
						if (patient1.getPatientId().equals(
								patient.getPatientId())) {
							i++;
						}
					}

					if (i == 0) {
						EntityCopier<Patient> copier = new EntityCopier<Patient>();
						formulaire.getPatients().add(copier.copy(patient));
					}

				}
				result = true;
			}

		} catch (Exception e) {
			log.fatal(e.getMessage());
		}

		finally {
			// session.close();
			log.debug("********** Fin getListPatientsMulti GestionCommercialeBO **********");
			return result;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see clinique.metier.gestion.commerciale.IGestionCommercialeBO#
	 * getPrestationCouverte
	 * (clinique.model.gestion.commerciale.GestionCommercialeForm)
	 */
	@Override
	@SuppressWarnings("unchecked")
	public PrestationCouvertesPc getPrestationCouverte(
			GestionCommercialeForm formulaire) {
		PrestationCouvertesPc pc = new PrestationCouvertesPc();
		if (formulaire.getPrestationCouvertesPcs().size() > 0) {

			for (Iterator iter = formulaire.getPrestationCouvertesPcs()
					.iterator(); iter.hasNext();) {
				PrestationCouvertesPc element = (PrestationCouvertesPc) iter
						.next();
				if (element.getActe().getActeId() == Integer
						.parseInt(formulaire.getActeId())) {
					pc = element;

				}
			}

		}
		return pc;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see clinique.metier.gestion.commerciale.IGestionCommercialeBO#
	 * getPrixActeFromDetailFacture(clinique.mapping.DetailFacture)
	 */
	@Override
	public double getPrixActeFromDetailFacture(DetailFacture df) {
		double prix = 0;
		if (df.getType().equals("normal")) {
			prix = df.getPrix();
		} else if (df.getType().equals("urgence")) {
			prix = df.getPrixUrg();
		} else {
			prix = df.getPrixDepl();
		}

		return prix;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * clinique.metier.gestion.commerciale.IGestionCommercialeBO#getUser(clinique
	 * .model.gestion.commerciale.GestionCommercialeForm)
	 */
	@Override
	public ActionMessages getUser(GestionCommercialeForm formulaire)
			throws Exception {
		log.debug("********** Debut getUser GestionCommercialeBO **********");
		ActionMessages errors1 = new ActionMessages();
		try {
			System.out.println("voila  " + formulaire.getLogin());
			User user = getUserDao().getUserByLogin(formulaire.getLogin());

			if (user == null) {
				ActionError error = new ActionError("formulaire.login.error");
				errors1.add("errorMsg", error);
			} else {
				formulaire.setLogin(user.getLogin());
				formulaire.setProfil(user.getProfil().getNomProfil());
			}

			return errors1;
		} catch (Exception e) {
			e.printStackTrace();
			log.fatal(e.getMessage());
			return errors1;
		} finally {
			// SessionFactoryUtil.getInstance().close();
			log.debug("********** Fin getUser GestionCommercialeBO **********");
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see clinique.metier.gestion.commerciale.IGestionCommercialeBO#
	 * infosForModificationFacture
	 * (clinique.model.gestion.commerciale.GestionCommercialeForm)
	 */
	@Override
	@SuppressWarnings("finally")
	public boolean infosForModificationFacture(GestionCommercialeForm formulaire)
			throws Exception {

		log.debug("********** Debut infosForModifiationFacture GestionCommercialeBO **********");

		boolean result = false;
		try {
			FactureModifiees factureM = factureModifieesDAO
					.getFactureModifiees(formulaire.getFactureModifieeId()
							.trim());
			Patient patient = factureM.getPatient();
			if (patient != null) {
				formulaire.setPatientId(String.valueOf(patient.getPatientId()));
				formulaire.setNom(patient.getNom());
				formulaire.setPrenom(patient.getPrenom());
				formulaire.setAdresse(patient.getAdresse());
				formulaire.setCni(patient.getCni());
				formulaire.setDateNaissance(UtilDate.getInstance()
						.dateToString(patient.getDateNaissance()));

				formulaire.setDateDerniereVisite(UtilDate.getInstance()
						.dateToString(patient.getDateDerniereVisite()));
				formulaire.setDatePremiereVisite(UtilDate.getInstance()
						.dateToString(patient.getDatePremiereViste()));
				formulaire.setLieuNaissance(patient.getLieuNaissance());
				formulaire.setNni(patient.getNni());
				if (factureM.getTypePc().equals("badge")) {
					formulaire.setNumeroBadge(factureM.getBadge()
							.getNumeroBadge());
				} else {
					formulaire.setNumeroBadge("");
				}

				if (factureM.getTypePc() != "aucune") {
					formulaire.setLibeleAssureur(patient.getCategorie()
							.getNomCategorie());
				}

				formulaire.setTelephone(patient.getTelephone());

				formulaire
						.setDetailsFactureModifieesList(detailFactureModifieesDAO
								.findDetailFactureModifieesByFacture(factureM));

				if (factureM.getIsHospitalisation().equals("1")) {
					formulaire.setIsHospitalisation("1");
				} else {
					formulaire.setIsHospitalisation("0");
				}

				result = true;

			}

		} catch (Exception e) {
			e.getStackTrace();
			log.fatal(e.getMessage());
		}

		finally {
			log.debug("********** Debut infosForModifiationFacture GestionCommercialeBO **********");
			return result;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see clinique.metier.gestion.commerciale.IGestionCommercialeBO#
	 * initialiserChampsAjouterPrestations
	 * (clinique.model.gestion.commerciale.GestionCommercialeForm)
	 */
	@Override
	public void initialiserChampsAjouterPrestations(
			GestionCommercialeForm formulaire) {
		formulaire.setInfirmierChoix("non");
		formulaire.setMedecinChoix("non");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see clinique.metier.gestion.commerciale.IGestionCommercialeBO#
	 * initialiserCombosAssureur
	 * (clinique.model.gestion.commerciale.GestionCommercialeForm)
	 */
	@Override
	@SuppressWarnings("unchecked")
	public void initialiserCombosAssureur(GestionCommercialeForm formulaire)
			throws Exception {
		log.debug("********** Debut initialiserCombosAssureur GestionCommercialeBO **********");
		try {
			ArrayList assureurList = new ArrayList();
			ArrayList entrepriseList = new ArrayList();
			ArrayList categorieListe = new ArrayList();

			AssureurDAO assureurDAO = getAssureurDAO();

			Assureur FirstSelectedAssureur = null;
			Entreprise FirstSelectedEntreprise = null;

			int i = 0;

			// charger combo assureur
			for (Object element2 : assureurDAO.listAssureurs()) {
				Assureur element = (Assureur) element2;
				if (checkAssureur(element)) {
					if (i == 0) {
						FirstSelectedAssureur = element;
						i++;
					}
					assureurList.add(new LabelValueBean(element
							.getNomAssureur(), String.valueOf(element
							.getAssureurId())));
				}
			}

			i = 0;
			// charger combo entreprise
			Assureur assureur = assureurDAO.getAssureur(FirstSelectedAssureur
					.getAssureurId());
			for (Entreprise element : entrepriseDAO
					.findEntreprisesByAssureur(assureur)) {
				if (checkEntreprise(element)) {
					if (i == 0) {
						FirstSelectedEntreprise = element;
						i++;

					}
					entrepriseList.add(new LabelValueBean(element
							.getNomEntreprise(), String.valueOf(element
							.getEntrepriseId())));
				}
			}

			// charger combo categorie
			for (Object element2 : categorieDAO
					.findCategoriesByEntreprise(FirstSelectedEntreprise)) {
				Categorie element = (Categorie) element2;
				if (checkCategorie(element)) {

					categorieListe.add(new LabelValueBean(element
							.getNomCategorie(), String.valueOf(element
							.getCategorieId())));

				}
			}

			formulaire.setAssureurListe(assureurList);
			formulaire.setEntrepriseList(entrepriseList);
			formulaire.setCategorieList(categorieListe);

		} catch (Exception e) {
			e.getStackTrace();
			log.fatal(e.getMessage());
		}

		finally {
			// session.close();
			log.debug("********** Fin initialiserCombosAssureur GestionCommercialeBO **********");
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see clinique.metier.gestion.commerciale.IGestionCommercialeBO#
	 * initialiserCombosChambres
	 * (clinique.model.gestion.commerciale.GestionCommercialeForm)
	 */
	@Override
	@SuppressWarnings("unchecked")
	public void initialiserCombosChambres(GestionCommercialeForm formulaire)
			throws Exception {
		log.debug("********** Debut initialiserCombosPrestations GestionCommercialeBO **********");
		// Session session=SessionFactoryUtil.getInstance().openSession();
		try {
			formulaire.getChambreList().clear();
			ArrayList chambresList = new ArrayList();

			// charger combo chambre
			for (Object element2 : getChambreDAO().listChambresLibres()) {
				Chambre element = (Chambre) element2;

				chambresList.add(new LabelValueBean(
						element.getChambreLibelle(), String.valueOf(element
								.getChambreId())));
			}

			formulaire.setChambreList(chambresList);
		} catch (Exception e) {
			e.printStackTrace();
			log.fatal(e.getMessage());
		}

		finally {
			// session.close();
			log.debug("********** Fin initialiserCombosPrestations GestionCommercialeBO **********");
		}

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see clinique.metier.gestion.commerciale.IGestionCommercialeBO#
	 * initialiserCombosDrgCnam
	 * (clinique.model.gestion.commerciale.GestionCommercialeForm)
	 */
	@Override
	@SuppressWarnings("unchecked")
	public void initialiserCombosDrgCnam(GestionCommercialeForm formulaire)
			throws Exception {
		log.debug("********** Debut initialiserCombosDrgCnam GestionCommercialeBO **********");
		// Session session=SessionFactoryUtil.getInstance().openSession();
		try {

			ArrayList drgCnamListe = new ArrayList();

			DrgCnamDAO drgCnamDAO = getDrgCnamDAO();

			// charger combo drgCnam
			for (Object element2 : drgCnamDAO.listDrgCnams()) {
				DrgCnam element = (DrgCnam) element2;

				drgCnamListe.add(new LabelValueBean(String.valueOf(element
						.getNumDrg()), element.getDrgCnamId()));

			}

			formulaire.setDrgCnamListe(drgCnamListe);

		} catch (Exception e) {
			e.getStackTrace();
			log.fatal(e.getMessage());
		}

		finally {
			// session.close();
			log.debug("********** Fin initialiserCombosDrgCnam GestionCommercialeBO **********");
		}

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see clinique.metier.gestion.commerciale.IGestionCommercialeBO#
	 * initialiserCombosPcPersonnel
	 * (clinique.model.gestion.commerciale.GestionCommercialeForm)
	 */
	@Override
	@SuppressWarnings("unchecked")
	public void initialiserCombosPcPersonnel(GestionCommercialeForm formulaire) {
		log.debug("********** Debut initialiserCombosPcPersonnel GestionCommercialeAction **********");
		// Session session=SessionFactoryUtil.getInstance().openSession();

		try {

			ArrayList pcPersonnelList = new ArrayList();
			for (Object element2 : getPcPersonnelDAO().listPcPersonnels()) {

				PcPersonnel element = (PcPersonnel) element2;

				pcPersonnelList.add(new LabelValueBean(element.getPcNom(),
						String.valueOf(element.getPcPersonnelId())));

			}
			formulaire.setPcPersonnelList(pcPersonnelList);
		} catch (Exception e) {

			e.printStackTrace();
			log.fatal(e.getMessage());

		}

		finally {
			// session.close();
			log.debug("********** Fin initialiserCombosPcPersonnel GestionCommercialeBO **********");
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see clinique.metier.gestion.commerciale.IGestionCommercialeBO#
	 * reinitialiserCombosPrestations
	 * (clinique.model.gestion.commerciale.GestionCommercialeForm)
	 */
	@Override
	@SuppressWarnings("unchecked")
	public void reinitialiserCombosPrestations(GestionCommercialeForm formulaire)
			throws Exception {
		log.debug("********** Debut reinitialiserCombosPrestations GestionCommercialeBO **********");
		try {

			Date date = new Date();
			int heure = date.getHours();

			if (heure > 20 && heure < 8) {
				formulaire.setTypeActe("urgence");
			} else {
				formulaire.setTypeActe("normal");
			}

			ArrayList famillePrestList = new ArrayList();
			ArrayList classeList = new ArrayList();
			ArrayList actesListe = new ArrayList();

			ArrayList acteursListe = new ArrayList();
			ArrayList acteursInfListe = new ArrayList();

			FamillePrestationDAO famillePrestDAO = getFamillePrestationDAO();
			ClasseDAO classeDAO = getClasseDAO();
			ActeDAO acteDAO = getActeDAO();

			FamillePrestation FirstSelectedFamillePrest = null;
			Classe FirstSelectedClasse = null;

			Acte FirstSelectedActe = null;

			int i = 0;

			// charger combo FamillePrest
			for (Object element2 : famillePrestDAO.listFamillePrestations()) {
				FamillePrestation element = (FamillePrestation) element2;
				if (checkFamillePres(element)) {
					if (element.getFamillePrestationId()==Integer.parseInt(formulaire.getFamillePrestationId())) {
						FirstSelectedFamillePrest = element;
						
					}
					famillePrestList.add(new LabelValueBean(element
							.getLibelle(), String.valueOf(element
							.getFamillePrestationId())));
				}
			}

			i = 0;
			// charger combo Classes
			for (Object element2 : classeDAO.listClasses()) {
				Classe element = (Classe) element2;
				if (checkClasse(element)) {
					if (element.getClasseId()==Integer.parseInt(formulaire.getClasseId())) {
						
						FirstSelectedClasse = element;
						i++;

					}
					classeList.add(new LabelValueBean(element.getNomClasse(),
							String.valueOf(element.getClasseId())));
				}
			}

			i = 0;
			// charger combo Actes
			List actes = null;
			if (formulaire.getChoixActePar().equals("famille")) {
				actes = acteDAO
						.findActesByFamillePrestation(FirstSelectedFamillePrest);
			} else if (formulaire.getChoixActePar().equals("classe")) {
				actes = acteDAO.findActesByClasse(FirstSelectedClasse);
			}
			for (Iterator iter = actes.iterator(); iter.hasNext();) {
				Acte element = (Acte) iter.next();
				if (checkActe(element)) {
					if (i == 0) {
						FirstSelectedActe = element;
						i++;

					}
					actesListe.add(new LabelValueBean(element.getNomActe(),
							String.valueOf(element.getActeId())));
				}
			}

			// charger combo ActeurActes
			for (Object element2 : acteurActeDAO
					.findActeurActesByActe(FirstSelectedActe)) {
				ActeurActe element = (ActeurActe) element2;
				if (checkActeur(element)) {
					if (element.getActeur().getAssistant().equals("0")) {
						acteursListe.add(new LabelValueBean(element.getActeur()
								.getNom(), String.valueOf(element
								.getActeurActeId())));
					} else {
						acteursInfListe.add(new LabelValueBean(element
								.getActeur().getNom(), String.valueOf(element
								.getActeurActeId())));
					}

				}
			}

			formulaire
					.setFamillePrestationId(String
							.valueOf(FirstSelectedFamillePrest
									.getFamillePrestationId()));
			formulaire.setFamillesPrestList(famillePrestList);
			formulaire.setClassesListe(classeList);
			formulaire.setActesListe(actesListe);
			formulaire.setActeurActeList(acteursListe);
			formulaire.setActeurActeInfList(acteursInfListe);
		} catch (Exception e) {
			e.printStackTrace();
			log.fatal(e.getMessage());
		}

		finally {
			// session.close();
			log.debug("********** Fin reinitialiserCombosPrestations GestionCommercialeBO **********");
		}

	}

	
	/*
	 * (non-Javadoc)
	 * 
	 * @see clinique.metier.gestion.commerciale.IGestionCommercialeBO#
	 * initialiserCombosPrestations
	 * (clinique.model.gestion.commerciale.GestionCommercialeForm)
	 */
	@Override
	@SuppressWarnings("unchecked")
	public void initialiserCombosPrestations(GestionCommercialeForm formulaire)
			throws Exception {
		log.debug("********** Debut initialiserCombosPrestations GestionCommercialeBO **********");
		try {

			Date date = new Date();
			int heure = date.getHours();

			if (heure > 20 && heure < 8) {
				formulaire.setTypeActe("urgence");
			} else {
				formulaire.setTypeActe("normal");
			}

			ArrayList famillePrestList = new ArrayList();
			ArrayList classeList = new ArrayList();
			ArrayList actesListe = new ArrayList();

			ArrayList acteursListe = new ArrayList();
			ArrayList acteursInfListe = new ArrayList();

			FamillePrestationDAO famillePrestDAO = getFamillePrestationDAO();
			ClasseDAO classeDAO = getClasseDAO();
			ActeDAO acteDAO = getActeDAO();

			FamillePrestation FirstSelectedFamillePrest = null;
			Classe FirstSelectedClasse = null;

			Acte FirstSelectedActe = null;

			int i = 0;

			// charger combo FamillePrest
			for (Object element2 : famillePrestDAO.listFamillePrestations()) {
				FamillePrestation element = (FamillePrestation) element2;
				if (checkFamillePres(element)) {
					if (i == 0) {
						FirstSelectedFamillePrest = element;
						i++;
					}
					famillePrestList.add(new LabelValueBean(element
							.getLibelle(), String.valueOf(element
							.getFamillePrestationId())));
				}
			}

			i = 0;
			// charger combo Classes
			for (Object element2 : classeDAO.listClasses()) {
				Classe element = (Classe) element2;
				if (checkClasse(element)) {
					if (i == 0) {
						FirstSelectedClasse = element;
						i++;

					}
					classeList.add(new LabelValueBean(element.getNomClasse(),
							String.valueOf(element.getClasseId())));
				}
			}

			i = 0;
			// charger combo Actes
			List actes = null;
			if (formulaire.getChoixActePar().equals("famille")) {
				actes = acteDAO
						.findActesByFamillePrestation(FirstSelectedFamillePrest);
			} else if (formulaire.getChoixActePar().equals("classe")) {
				actes = acteDAO.findActesByClasse(FirstSelectedClasse);
			}
			for (Iterator iter = actes.iterator(); iter.hasNext();) {
				Acte element = (Acte) iter.next();
				if (checkActe(element)) {
					if (i == 0) {
						FirstSelectedActe = element;
						i++;

					}
					actesListe.add(new LabelValueBean(element.getNomActe(),
							String.valueOf(element.getActeId())));
				}
			}

			// charger combo ActeurActes
			for (Object element2 : acteurActeDAO
					.findActeurActesByActe(FirstSelectedActe)) {
				ActeurActe element = (ActeurActe) element2;
				if (checkActeur(element)) {
					if (element.getActeur().getAssistant().equals("0")) {
						acteursListe.add(new LabelValueBean(element.getActeur()
								.getNom(), String.valueOf(element
								.getActeurActeId())));
					} else {
						acteursInfListe.add(new LabelValueBean(element
								.getActeur().getNom(), String.valueOf(element
								.getActeurActeId())));
					}

				}
			}

			formulaire
					.setFamillePrestationId(String
							.valueOf(FirstSelectedFamillePrest
									.getFamillePrestationId()));
			formulaire.setFamillesPrestList(famillePrestList);
			formulaire.setClassesListe(classeList);
			formulaire.setActesListe(actesListe);
			formulaire.setActeurActeList(acteursListe);
			formulaire.setActeurActeInfList(acteursInfListe);
		} catch (Exception e) {
			e.printStackTrace();
			log.fatal(e.getMessage());
		}

		finally {
			// session.close();
			log.debug("********** Fin initialiserCombosPrestations GestionCommercialeBO **********");
		}

	}

	
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see clinique.metier.gestion.commerciale.IGestionCommercialeBO#
	 * initialiserCombosTypePyement
	 * (clinique.model.gestion.commerciale.GestionCommercialeForm)
	 */
	@Override
	@SuppressWarnings("unchecked")
	public void initialiserCombosTypePyement(GestionCommercialeForm formulaire) {
		log.debug("********** Debut initialiserCombosTypePyement GestionCommercialeAction **********");
		// Session session=SessionFactoryUtil.getInstance().openSession();

		try {
			ArrayList typePayementList = new ArrayList();
			for (Object element2 : getTypePayementDAO().listTypePayements()) {

				TypePayement element = (TypePayement) element2;

				/*
				 * if (formulaire.getReglementsList().size()==0) {
				 * typePayementList.add(new
				 * LabelValueBean(element.getTypePayement
				 * (),String.valueOf(element.getTypePayementId())));
				 * formulaire.setCashDejaSaisi("0"); } else if
				 * (element.getTypePayementId()!=1)
				 */
				if (formulaire.getModeReglement().equals("differe")) {
					if (element.getTypePayementId() != 1) {
						typePayementList.add(new LabelValueBean(element
								.getTypePayement(), String.valueOf(element
								.getTypePayementId())));
					}
				} else {
					typePayementList.add(new LabelValueBean(element
							.getTypePayement(), String.valueOf(element
							.getTypePayementId())));
				}

			}
			formulaire.setTypePayementList(typePayementList);
		} catch (Exception e) {

			e.printStackTrace();
			log.fatal(e.getMessage());

		} finally {
			// session.close();
			log.debug("********** Fin initialiserCombosTypePyement GestionCommercialeBO **********");
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see clinique.metier.gestion.commerciale.IGestionCommercialeBO#
	 * initialiserElementsPaymentHospFacture
	 * (clinique.model.gestion.commerciale.GestionCommercialeForm)
	 */
	@Override
	public void initialiserElementsPaymentHospFacture(
			GestionCommercialeForm formulaire) {

		formulaire.setTotalApayer("0");

		formulaire.setCoteClinique("0");

		formulaire.setCoteAssureur("0");

		formulaire.setCoteCliniqueReductible("0");

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * clinique.metier.gestion.commerciale.IGestionCommercialeBO#initialiserForm
	 * (clinique.model.gestion.commerciale.GestionCommercialeForm)
	 */
	@Override
	@SuppressWarnings("unchecked")
	public void initialiserForm(GestionCommercialeForm formulaire) {
		formulaire.setTypePatient("nouveau");
		formulaire.setPatientId("");
		formulaire.setNom("");
		formulaire.setPrenom("");
		formulaire.setDateNaissance("");
		formulaire.setLieuNaissance("");
		formulaire.setTelephone("");
		formulaire.setAdresse("");
		formulaire.setCni("");
		formulaire.setNni("");
		formulaire.setNumeroBadge("");
		formulaire.setDatePremiereVisite("");
		formulaire.setDateDerniereVisite("");
		formulaire.setStatut("");
		formulaire.setDispatch("");

		formulaire.setPatientIdR("");
		formulaire.setNomR("");
		formulaire.setPrenomR("");
		formulaire.setDateNaissanceR("");
		formulaire.setLieuNaissanceR("");
		formulaire.setTelephoneR("");
		formulaire.setAdresseR("");
		formulaire.setCniR("");
		formulaire.setNniR("");
		formulaire.setNumeroBadgeR("");
		formulaire.setDatePremiereVisiteR("");
		formulaire.setDateDerniereVisiteR("");
		formulaire.setAvanceChoix("non");
		formulaire.setAvance("0");
		formulaire.setActesLimite("oui");

		formulaire.setPatients(new ArrayList());

		formulaire.setFamillesPrestList(new ArrayList());

		formulaire.setClassesListe(new ArrayList());

		formulaire.setActesListe(new ArrayList());
		;

		formulaire.setActeurActeList(new ArrayList());

		formulaire.setDetailsFactureList(new ArrayList());

		formulaire.setAssureurListe(new ArrayList());

		formulaire.setEntrepriseList(new ArrayList());

		formulaire.setCategorieList(new ArrayList());

		formulaire.setActeurActeInfList(new ArrayList());

		formulaire.setDevisActesList(new ArrayList());

		formulaire.setFactureId("");

		formulaire.setActeurActeIdInf("");
		formulaire.setAssureurId("");
		formulaire.setEntrepriseId("");
		formulaire.setCategorieId("");
		formulaire.setFamillePrestationId("");
		formulaire.setClasseId("");
		formulaire.setActeId("");
		formulaire.setActeurActeId("");
		formulaire.setTypeActe("normal");
		formulaire.setNombreActe("1");

		formulaire.setNomActe("");

		formulaire.setLogoPath("");
		formulaire.setReportsPath("");
		formulaire.setRecuId("");

		formulaire.setTotalApayer("0");
		formulaire.setCoteClinique("0");
		formulaire.setDejapaye("0");
		formulaire.setResteApayer("0");
		formulaire.setCoteAssureur("0");
		formulaire.setPriseEnChargeFlag("aucune");
		formulaire.setNumPC("");
		formulaire.setPlafond("");
		formulaire.setPourcentage("");
		formulaire.setNombreActesPC("");
		formulaire.setDateCreation("");
		formulaire.setFinValidite("");
		formulaire.setTypePcCouverte("famille");

		formulaire.setPrestationCouvertesPcs(new ArrayList());
		formulaire.setPcId("");
		formulaire.setIdPrestAsupprimer("");
		formulaire.setRemiseFlag("oui");
		formulaire.setRemiseValeur("");
		formulaire.setRemiseMontant("0");
		formulaire.setTypePayementId("");

		formulaire.setTypePayementList(new ArrayList());
		formulaire.setTypePayementValeur("");
		formulaire.setChoixActePar("famille");
		formulaire.setInfirmierChoix("non");
		formulaire.setMedecinChoix("non");
		formulaire.setCoteCliniqueReductible("0");

		formulaire.setPcPersonnelList(new ArrayList());
		formulaire.setPcPersonnelId("");
		formulaire.setDescription("");

		formulaire.setReglementsList(new ArrayList());
		formulaire.setIdReglementAsupprimer("");
		formulaire.setPriseEnCharge(new PriseEnCharge());
		formulaire.setPatient(new Patient());
		formulaire.setResteApayerMajoration("0");
		formulaire.setRecuRegle("0");
		formulaire.setMajorationCoef("0");
		formulaire.setNomAssureur("");
		formulaire.setNomEntreprise("");
		;
		formulaire.setNomCategorie("");
		formulaire.setOperation("");

		formulaire.setChambreList(new ArrayList());
		formulaire.setChambreId("");
		formulaire.setDateEntree("");

		formulaire.setHopitalises(new ArrayList());
		formulaire.setDateEntreeChambre("");
		formulaire.setChambreActuelle("");
		formulaire.setHospitalisation(new Hospitalisation());
		formulaire.setHospitalisaionId("");
		formulaire.setFacture(new Facture());
		formulaire.setDateSortie("");
		formulaire.setRecu(new Recu());
		formulaire.setHeureHosp("");

		formulaire.setChambresHospList(new ArrayList());
		formulaire.setDetailDrgCnamListFacture(new ArrayList());

		formulaire.setaRendre("0");
		formulaire.setRendu("0");
		formulaire.setIsFirst("true");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see clinique.metier.gestion.commerciale.IGestionCommercialeBO#
	 * initialiserInfosChambre
	 * (clinique.model.gestion.commerciale.GestionCommercialeForm)
	 */
	@Override
	@SuppressWarnings("unchecked")
	public void initialiserInfosChambre(GestionCommercialeForm formulaire) {
		formulaire.setChambreList(new ArrayList());
		formulaire.setDateEntree("");
		formulaire.setDateEntreeChambre("");
		formulaire.setDateSortie("");
		formulaire.setHeureHosp("");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * clinique.metier.gestion.commerciale.IGestionCommercialeBO#listDevisAimprimer
	 * (java.lang.String, java.lang.String)
	 */
	@Override
	public List<DevisAssureur> listDevisAimprimer(String date1, String date2) {
		return devisAssureurDAO.listDevisAimprimerFromBO(date1, date2);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see clinique.metier.gestion.commerciale.IGestionCommercialeBO#
	 * makeCopieOfPriseEnCharge(clinique.mapping.PriseEnCharge,
	 * clinique.mapping.PriseEnChargeModifiee, double, java.lang.String)
	 */
	@Override
	@SuppressWarnings("unchecked")
	public void makeCopieOfPriseEnCharge(PriseEnCharge pc,
			PriseEnChargeModifiee pcM, double montantPc, String userId) {
		pcM.setPcNum(pc.getPcNum());
		pcM.setPatient(pc.getPatient());
		pcM.setPlafond(pc.getPlafond());
		pcM.setPourcentage(pc.getPourcentage());
		pcM.setFinValidite(pc.getFinValidite());
		pcM.setDateCreation(pc.getDateCreation());
		pcM.setNombreActes(pc.getNombreActes());
		pcM.setMontantFact(pc.getMontantFact() - montantPc);
		pcM.setCategorie(pc.getCategorie());
		pcM.setStatut("1");
		List list = prestationCouvertesPcDAO.findPrestationCouvertesByPc(pc);
		if (list.size() != 0) {
			for (Iterator iter = list.iterator(); iter.hasNext();) {
				PrestationCouvertesPcModifiee pccouvM = new PrestationCouvertesPcModifiee();
				pccouvM.setPresCouvId(ConstantesMetier.ID_PRESTATIONCOUVERTEPC
						+ UtilDate.getInstance().getDateForId() + "" + userId);
				PrestationCouvertesPc element = (PrestationCouvertesPc) iter
						.next();
				makeCopieOfPrtationCouv(element, pccouvM);

			}

		}

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see clinique.metier.gestion.commerciale.IGestionCommercialeBO#
	 * makeCopieOfPrtationCouv(clinique.mapping.PrestationCouvertesPc,
	 * clinique.mapping.PrestationCouvertesPcModifiee)
	 */
	@Override
	public void makeCopieOfPrtationCouv(PrestationCouvertesPc pccouv,
			PrestationCouvertesPcModifiee pccouvM) {
		pccouvM.setActe(pccouv.getActe());
		pccouvM.setStatut("1");
		pccouvM.setType(pccouv.getType());
		pccouvM.setLibelle(pccouv.getLibelle());
		pccouvM.setLimite(pccouv.getLimite());
		pccouvM.setNbreActes(pccouv.getNbreActes());
		pccouvM.setNbreActesRestant(pccouv.getNbreActesRestant());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see clinique.metier.gestion.commerciale.IGestionCommercialeBO#
	 * makeTransactionActeurs(java.util.List,
	 * clinique.model.gestion.commerciale.GestionCommercialeForm, int)
	 */
	@Override
	@SuppressWarnings("unchecked")
	public void makeTransactionActeurs(List transactionComptes,
			GestionCommercialeForm formulaire, int idkey) {
		Acteur acteur;
		Acteur acteur1;
		Compte compte;
		Compte compte1;
		double montant = 0;
		String chaineKey;

		for (Iterator iter = formulaire.getDetailsFactureList().iterator(); iter
				.hasNext();) {

			DetailFacture element = (DetailFacture) iter.next();

			TransactionCompte transactionCompte = new TransactionCompte();
			TransactionCompte transactionCompte1 = new TransactionCompte();

			if (element.getMedecinExiste().equals("1")) {

				acteur = element.getMedecin();
				if (acteur != null) {
					idkey = idkey + 1;
					chaineKey = ConstantesMetier.ID_TRANSACTIONCOMPTE
							+ UtilDate.getInstance().getDateForId2()
							+ UtilDate.getInstance().getChaineKey(idkey)
							+ getUserDao().getUserByLogin(
									formulaire.getOperateur()).getUserId();

					compte = getCompteDAO().getCompteFromActeur(acteur);
					if (compte != null) {

						montant = element.getPrixReel() * element.getQpActeur()
								/ 100;

						compte.setSoldeAvant(compte.getSolde());
						compte.setSolde(compte.getSolde() + montant);

						transactionCompte.setTransactionId(chaineKey);
						transactionCompte.setDateTransaction(UtilDate
								.getInstance().getDateToday());
						transactionCompte.setCompte(compte);
						transactionCompte.setMontant(montant);
						transactionCompte.setOperation("credit");
						transactionCompte.setOperateur(formulaire
								.getOperateur());
						transactionCompte.setStatut("1");

						transactionComptes.add(transactionCompte);

						// compte.getTransactionsCompte().add(transactionCompte);

					}
				}
			}

			if (element.getInfirmierExiste().equals("1")) {
				acteur1 = element.getInfirmier();
				if (acteur1 != null) {
					idkey = idkey + 1;
					chaineKey = ConstantesMetier.ID_TRANSACTIONCOMPTE
							+ UtilDate.getInstance().getDateForId2()
							+ UtilDate.getInstance().getChaineKey(idkey)
							+ getUserDao().getUserByLogin(
									formulaire.getOperateur()).getUserId();

					compte1 = getCompteDAO().getCompteFromActeur(acteur1);
					if (compte1 != null) {

						montant = element.getPrixReel()
								* element.getQpAssistant() / 100;

						compte1.setSoldeAvant(compte1.getSolde());
						compte1.setSolde(compte1.getSolde() + montant);

						transactionCompte1.setTransactionId(chaineKey);
						transactionCompte1.setDateTransaction(UtilDate
								.getInstance().getDateToday());
						transactionCompte1.setCompte(compte1);
						transactionCompte1.setMontant(montant);
						transactionCompte1.setOperation("credit");
						transactionCompte1.setOperateur(formulaire
								.getOperateur());
						transactionCompte1.setStatut("1");

						transactionComptes.add(transactionCompte1);

						// compte1.getTransactionsCompte().add(transactionCompte1);

					}

				}
			}
		}

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see clinique.metier.gestion.commerciale.IGestionCommercialeBO#
	 * makeTransactionCliniqueAndAssureur(java.util.List, java.util.List,
	 * clinique.model.gestion.commerciale.GestionCommercialeForm, int)
	 */
	@Override
	@SuppressWarnings("unchecked")
	public void makeTransactionCliniqueAndAssureur(List transactionComptes,
			List transactionCompteCategories,
			GestionCommercialeForm formulaire, int idkey) {

		// Compte compte;
		double montant = 0;
		String chaineKey;

		Compte compteClinique = getCompteDAO().getCompte(
				ConstantesMetier.COMPTECLINIQUE_ID);

		for (Iterator iter = formulaire.getReglementsList().iterator(); iter
				.hasNext();) {

			Reglement element = (Reglement) iter.next();
			idkey = idkey + 1;
			chaineKey = ConstantesMetier.ID_TRANSACTIONCOMPTE
					+ UtilDate.getInstance().getDateForId2()
					+ UtilDate.getInstance().getChaineKey(idkey)
					+ getUserDao().getUserByLogin(formulaire.getOperateur())
							.getUserId();

			TransactionCompte transactionCompte = new TransactionCompte();

			montant = element.getMontant() + element.getPetitMonnaie();

			compteClinique.setSoldeAvant(compteClinique.getSolde());
			compteClinique.setSolde(compteClinique.getSolde() + montant);

			transactionCompte.setTransactionId(chaineKey);
			transactionCompte.setDateTransaction(UtilDate.getInstance()
					.getDateToday());
			transactionCompte.setCompte(compteClinique);
			transactionCompte.setMontant(montant);
			transactionCompte.setOperation("credit");
			transactionCompte.setOperateur(formulaire.getOperateur());
			transactionCompte.setStatut("1");

			transactionComptes.add(transactionCompte);

			if (element.getTypePayement().getTypePayementId() == 4) {

				if (element.getTypePC().equals("badge")
						|| element.getTypePC().equals("priseEnCharge")) {
					idkey = idkey + 1;
					chaineKey = ConstantesMetier.ID_TRANSACTIONCOMPTECATEGORIE
							+ UtilDate.getInstance().getDateForId2()
							+ UtilDate.getInstance().getChaineKey(idkey)
							+ getUserDao().getUserByLogin(
									formulaire.getOperateur()).getUserId();

					TransactionCompteCategorie transactionCompteCategorie = new TransactionCompteCategorie();

					CompteCategorie compteCategorie = compteCategorieDAO
							.getCompteCategorieFromCategorie(element
									.getCategorie());

					compteCategorie.setSoldeAvant(compteCategorie.getSolde());
					compteCategorie.setSolde(compteCategorie.getSolde()
							- montant);

					transactionCompteCategorie.setTransactionId(chaineKey);
					transactionCompteCategorie.setDateTransaction(UtilDate
							.getInstance().getDateToday());
					transactionCompteCategorie.setCompte(compteCategorie);
					transactionCompteCategorie.setMontant(montant);
					transactionCompteCategorie.setOperation("debit");
					transactionCompteCategorie.setOperateur(formulaire
							.getOperateur());
					transactionCompteCategorie.setStatut("1");

					transactionCompteCategories.add(transactionCompteCategorie);

				} else {
					Compte compte;
					PcPersonnel pc = element.getPcPersonnel();
					if (pc != null) {
						idkey = idkey + 1;
						chaineKey = ConstantesMetier.ID_TRANSACTIONCOMPTE
								+ UtilDate.getInstance().getDateForId2()
								+ UtilDate.getInstance().getChaineKey(idkey)
								+ getUserDao().getUserByLogin(
										formulaire.getOperateur()).getUserId();

						transactionCompte.setDateTransaction(UtilDate
								.getInstance().getDateToday());
						compte = getCompteDAO().getCompte(
								pc.getCompte().getCompteId());
						if (compte != null) {

							double solde = compte.getSolde();

							compte.setSoldeAvant(solde);
							compte.setSolde(solde - montant);

							transactionCompte.setTransactionId(chaineKey);
							transactionCompte.setCompte(compte);
							transactionCompte.setMontant(montant);
							transactionCompte.setOperation("debit");
							transactionCompte.setOperateur(formulaire
									.getOperateur());
							transactionCompte.setStatut("1");

							transactionComptes.add(transactionCompte);
						}

					}
				}
			}

		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see clinique.metier.gestion.commerciale.IGestionCommercialeBO#
	 * patientPrestationsFormulaire
	 * (clinique.model.gestion.commerciale.GestionCommercialeForm)
	 */
	@Override
	@SuppressWarnings("finally")
	public boolean patientPrestationsFormulaire(
			GestionCommercialeForm formulaire) throws Exception {

		log.debug("********** Debut patientPrestationsFormulaire GestionCommercialeBO **********");

		boolean result = false;
		try {
			Patient patient = formulaire.getPatient();
			if (patient != null) {
				formulaire.setPatientId(String.valueOf(patient.getPatientId()));
				formulaire.setNom(patient.getNom());
				formulaire.setPrenom(patient.getPrenom());
				formulaire.setAdresse(patient.getAdresse());
				formulaire.setCni(patient.getCni());
				formulaire.setDateNaissance(UtilDate.getInstance()
						.dateToString(patient.getDateNaissance()));

				formulaire.setDateDerniereVisite(UtilDate.getInstance()
						.dateToString(patient.getDateDerniereVisite()));
				formulaire.setDatePremiereVisite(UtilDate.getInstance()
						.dateToString(patient.getDatePremiereViste()));
				formulaire.setLieuNaissance(patient.getLieuNaissance());
				formulaire.setNni(patient.getNni());
				PatientPcActuel patientPcActuel = getPatientPcActuelDAO()
						.getPatientPcByPatient(patient);
				if (patientPcActuel != null) {
					if (patientPcActuel.getType().equals("badge")
							&& patientPcActuel.getBadge() != null) {
						formulaire.setNumeroBadge(patientPcActuel.getBadge()
								.getNumeroBadge());
					} else {
						formulaire.setNumeroBadge("");
					}
				}
				formulaire.setTelephone(patient.getTelephone());

				formulaire.setFactureId("");
				formulaire.setRecuId("");

				result = true;

			}

		} catch (Exception e) {

			e.printStackTrace();
			log.fatal(e.getMessage());
		}

		finally {
			log.debug("********** Debut patientPrestationsFormulaire GestionCommercialeBO **********");
			return result;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see clinique.metier.gestion.commerciale.IGestionCommercialeBO#
	 * patientPrestationsFormulaireAncien
	 * (clinique.model.gestion.commerciale.GestionCommercialeForm)
	 */
	@Override
	@SuppressWarnings("finally")
	public boolean patientPrestationsFormulaireAncien(
			GestionCommercialeForm formulaire) throws Exception {

		log.debug("********** Debut patientPrestationsFormulaire GestionCommercialeBO **********");
		boolean result = false;

		try {
			Patient patient;
			if (formulaire.getPatientId().equals("")
					|| formulaire.getPatientId().isEmpty()) {
				patient = null;

			} else {
				patient = getPatientDAO().getPatient(
						formulaire.getPatientId().trim());
				formulaire.setPatient(patient);
				formulaire.setTypePatient("ancien");
			}

			if (patient != null) {
				formulaire.setPatientId(String.valueOf(patient.getPatientId()));
				formulaire.setNom(patient.getNom());
				formulaire.setPrenom(patient.getPrenom());
				formulaire.setAdresse(patient.getAdresse());
				formulaire.setCni(patient.getCni());
				formulaire.setDateNaissance(UtilDate.getInstance()
						.dateToString(patient.getDateNaissance()));

				formulaire.setDateDerniereVisite(UtilDate.getInstance()
						.dateToString(patient.getDateDerniereVisite()));
				formulaire.setDatePremiereVisite(UtilDate.getInstance()
						.dateToString(patient.getDatePremiereViste()));
				formulaire.setLieuNaissance(patient.getLieuNaissance());
				formulaire.setNni(patient.getNni());

				formulaire.setTelephone(patient.getTelephone());
				getAncienPatientInfosAssureur(patient, formulaire);

				formulaire.setDevisList(getDevisAssureurDAO()
						.listDevisAssureurs(patient.getPatientId()));

				// formulaire.setDetailsFactureList(null);
				formulaire.setFactureId("");
				formulaire.setRecuId("");

				result = true;

			}

		} catch (Exception e) {
			e.printStackTrace();
			log.fatal(e.getMessage());
		}

		finally {
			log.debug("********** Debut patientPrestationsFormulaire GestionCommercialeBO **********");
			return result;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see clinique.metier.gestion.commerciale.IGestionCommercialeBO#
	 * RechargerCombosEntreprisesAndCategories
	 * (clinique.model.gestion.commerciale.GestionCommercialeForm)
	 */
	@Override
	@SuppressWarnings("unchecked")
	public void RechargerCombosEntreprisesAndCategories(
			GestionCommercialeForm formulaire) throws Exception {
		log.debug("********** Debut chargerCombosEntreprises GestionCommercialeBO **********");
		try {

			ArrayList entrepriseList = new ArrayList();
			ArrayList categorieListe = new ArrayList();

			AssureurDAO assureurDAO = getAssureurDAO();
			Entreprise FirstSelectedEntreprise = new Entreprise();

			// charger combo entreprise
			Assureur assureur = assureurDAO.getAssureur(Integer
					.parseInt(formulaire.getAssureurId()));
			for (Entreprise element : entrepriseDAO
					.findEntreprisesByAssureur(assureur)) {
				if (checkEntreprise(element)) {
					if (element.getEntrepriseId() == Integer
							.parseInt(formulaire.getEntrepriseId())) {
						FirstSelectedEntreprise = element;
					}
					entrepriseList.add(new LabelValueBean(element
							.getNomEntreprise(), String.valueOf(element
							.getEntrepriseId())));
				}
			}

			// charger combo categorie
			if (FirstSelectedEntreprise != null) {
				for (Object element2 : categorieDAO
						.findCategoriesByEntreprise(FirstSelectedEntreprise)) {
					Categorie element = (Categorie) element2;
					if (checkCategorie(element)) {

						categorieListe.add(new LabelValueBean(element
								.getNomCategorie(), String.valueOf(element
								.getCategorieId())));

					}
				}
			}

			formulaire.setEntrepriseList(entrepriseList);
			formulaire.setCategorieList(categorieListe);

		} catch (Exception e) {
			e.getStackTrace();
			log.fatal(e.getMessage());
		}

		finally {
			// session.close();
			log.debug("********** Fin chargerCombosEntreprises GestionCommercialeBO **********");
		}

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * clinique.metier.gestion.commerciale.IGestionCommercialeBO#reserverChambre
	 * (clinique.model.gestion.commerciale.GestionCommercialeForm)
	 */
	@Override
	@SuppressWarnings({ "finally", "unchecked" })
	public boolean reserverChambre(GestionCommercialeForm formulaire)
			throws Exception {

		boolean result = false;
		log.debug("********** Debut reserverChambre GestionCommercialeBO **********");
		try {

			Chambre chambre = getChambreDAO().getChambre(
					Integer.parseInt(formulaire.getChambreId().trim()));

			// enregistrer facture
			if (formulaire.getFactureId().equals("")) {
				formulaire.setFactureId(ConstantesMetier.ID_FACTURE
						+ UtilDate.getInstance().getDateForId()
						+ ""
						+ getUserDao()
								.getUserByLogin(formulaire.getOperateur())
								.getUserId());
			}
			Patient patient = formulaire.getPatient();
			Facture facture = new Facture();

			facture.setFactureId(formulaire.getFactureId());
			facture.setPatient(patient);

			if (formulaire.getOperation().equals("ancienWithPC")
					|| formulaire.getOperation().equals("ancienWithoutPC")) {
				getPatientDAO().update(patient);

			} else {
				getPatientDAO().save(patient);

			}

			if (chambre != null) {
				chambre.setEtat("0");
				getChambreDAO().update(chambre);

			}

			Hospitalisation hospitalisation = new Hospitalisation();
			// debut id hospitalisation 17
			hospitalisation
					.setHospitalisationId(ConstantesMetier.ID_HOSPITALISATION
							+ UtilDate.getInstance().getDateForId()
							+ ""
							+ getUserDao().getUserByLogin(
									formulaire.getOperateur()).getUserId());
			hospitalisation.setPatient(patient);
			hospitalisation.setChambre(chambre);
			if (!UtilDate.getInstance().isVide(formulaire.getDateEntree())) {
				hospitalisation.setDateEntree(UtilDate.getInstance()
						.stringToDate(formulaire.getDateEntree()));
			}

			hospitalisation.setStatut("1");
			hospitalisation.setEncours("1");
			hospitalisation.setFacture(facture);

			if (formulaire.getAvanceChoix().equals("oui")) {
				facture.setAvance(Double.parseDouble(formulaire.getAvance()));
			} else {
				facture.setAvance(0);
			}

			PatientPcActuel patientPcActuel = new PatientPcActuel();
			patientPcActuel
					.setPatientPcActuelId(ConstantesMetier.ID_PATIENTPCACTUEL
							+ UtilDate.getInstance().getDateForId()
							+ ""
							+ getUserDao().getUserByLogin(
									formulaire.getOperateur()).getUserId());

			patientPcActuel.setType("aucune");
			patientPcActuel.setPatient(patient);

			if (formulaire.getPriseEnChargeFlag().equals("priseEnCharge")) {
				if (!formulaire.getOperation().equals("ancienWithPC")) {
					PriseEnCharge pc = formulaire.getPriseEnCharge();
					priseEnChargeDAO.save(pc);

				}
				patientPcActuel.setType("priseEnCharge");
				patientPcActuel.setPriseEnCharge(formulaire.getPriseEnCharge());
			} else if (formulaire.getPriseEnChargeFlag().equals("badge")) {

				Badge badge = formulaire.getBadge();
				badgeDAO.save(badge);

				patientPcActuel.setBadge(badge);
				patientPcActuel.setType("badge");
			}

			facture.setStatut("1");
			getFactureDAO().save(facture);

			getPatientPcActuelDAO().deletePatientPcByPatient(patient);
			patientPcActuel.setStatut("1");
			getPatientPcActuelDAO().save(patientPcActuel);

			ChambresHospitalisation chaHospitalisation = new ChambresHospitalisation();
			// debut id chambreHospitalisation 18
			chaHospitalisation
					.setChambreHospitalisationId(ConstantesMetier.ID_HOSPITALISATIONCHAMBRE
							+ UtilDate.getInstance().getDateForId()
							+ ""
							+ getUserDao().getUserByLogin(
									formulaire.getOperateur()).getUserId());
			if (!UtilDate.getInstance().isVide(formulaire.getDateEntree())) {
				chaHospitalisation.setDateEntree(UtilDate.getInstance()
						.stringToDate(formulaire.getDateEntree()));
			}
			chaHospitalisation.setStatut("0");
			chaHospitalisation.setHeureEntree(Integer.parseInt(formulaire
					.getHeureHosp()));
			chaHospitalisation.setChambre(chambre);
			chaHospitalisation.setHospitalisation(hospitalisation);
			chambresHospitalisationDAO.save(chaHospitalisation);
			getHospitalisationDAO().save(hospitalisation);

			// session.flush();
			initialiserInfosChambre(formulaire);
			result = true;

		} catch (Exception e) {
			e.printStackTrace();
			log.fatal(e.getMessage());

		}

		finally {
			log.debug("********** Fin reserverChambre GestionCommercialeBO **********");
			return result;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * clinique.metier.gestion.commerciale.IGestionCommercialeBO#setInfosDfm
	 * (clinique.mapping.DetailFactureModifiees)
	 */
	@Override
	public void setInfosDfm(DetailFactureModifiees dfM) {
		Date dateF = dfM.getFacture().getDateFact();
		Acte acte = dfM.getActe();
		Acteur acteur = dfM.getMedecin();
		boolean categExiste = false;
		Categorie categorie = null;
		if (dfM.getFacture().getTypePc().equals("badge")) {
			categorie = dfM.getFacture().getBadge().getCategorie();
			categExiste = true;
		}

		else if (dfM.getFacture().getTypePc().equals("priseEnCharge")) {
			categorie = dfM.getFacture().getPriseEnCharge().getCategorie();
			categExiste = true;
		}

		if (dfM.getMedecinExiste().equals("1") && categExiste) {
			setInfosDfmActeurWithPc(dfM, dateF, acteur, acte, categorie);
			setTauxAssistantWithPc(dfM, dateF, acte, categorie);
		}

		else if (dfM.getMedecinExiste().equals("1") && !categExiste) {
			setInfosDfmActeurWithoutPc(dfM, dateF, acteur, acte);
			setTauxAssistantWithoutPc(dfM, dateF, acte);
		}

		else if (dfM.getMedecinExiste().equals("0") && categExiste) {
			setInfosDfmPcWithoutActeur(dfM, dateF, acte, categorie);
			setTauxAssistantWithPc(dfM, dateF, acte, categorie);
		}

		else if (dfM.getMedecinExiste().equals("0") && !categExiste) {
			setInfosDfmWithoutPcWithoutActeur(dfM, dateF, acte);
			setTauxAssistantWithoutPc(dfM, dateF, acte);
		}

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see clinique.metier.gestion.commerciale.IGestionCommercialeBO#
	 * setInfosDfmActeurWithoutPc(clinique.mapping.DetailFactureModifiees,
	 * java.util.Date, clinique.mapping.Acteur, clinique.mapping.Acte)
	 */
	@Override
	public void setInfosDfmActeurWithoutPc(DetailFactureModifiees dfM,
			Date dateF, Acteur acteur, Acte acte) {

		boolean trouve = false;

		ActeurActe acteurActe = getActeurActeDAO().getActeurActeByDate(acteur,
				dateF, acte);

		ActeurActeH acteurActeH = getActeurActeHDAO().getActeurActeHByDate(
				acteur, dateF, acte);

		Acte acteByDate = getActeDAO().getActeByDate(dateF, acte);

		ActeH acteH = getActeHDAO().getActeHByDate(dateF, acte);

		if (acteurActe != null) {
			trouve = true;
			dfM.setPrix(acteurActe.getPrix());
			dfM.setPrixUrg(acteurActe.getPrixUrg());
			dfM.setPrixDepl(acteurActe.getPrixUrg());

			if (dfM.getType().equals("normal")) {
				dfM.setQpActeur(acteurActe.getPourcentage());
			} else {
				dfM.setQpActeur(acteurActe.getPourcentageUrg());
			}

		}

		else if (acteurActeH != null && !trouve) {
			trouve = true;
			dfM.setPrix(acteurActeH.getPrix());
			dfM.setPrixUrg(acteurActeH.getPrixUrg());
			dfM.setPrixDepl(acteurActeH.getPrixUrg());

			if (dfM.getType().equals("normal")) {
				dfM.setQpActeur(acteurActeH.getPourcentage());
			} else {
				dfM.setQpActeur(acteurActeH.getPourcentageUrg());
			}
		}

		else if (acteByDate != null && !trouve) {
			trouve = true;
			dfM.setPrix(acteByDate.getPrix());
			dfM.setPrixUrg(acteByDate.getPrixUrg());
			dfM.setPrixDepl(acteByDate.getPrixUrg());

			if (dfM.getType().equals("normal")) {
				dfM.setQpActeur(acteByDate.getTauxPraticien());
			} else {
				dfM.setQpActeur(acteByDate.getTauxPraticienUrg());
			}
		}

		else if (acteH != null && !trouve) {
			trouve = true;
			dfM.setPrix(acteH.getPrix());
			dfM.setPrixUrg(acteH.getPrixUrg());
			dfM.setPrixDepl(acteH.getPrixUrg());

			if (dfM.getType().equals("normal")) {
				dfM.setQpActeur(acteH.getTauxPraticien());
			} else {
				dfM.setQpActeur(acteH.getTauxPraticienUrg());
			}
		}

		if (!trouve) {
			dfM.setPrix(acte.getPrix());
			dfM.setPrixUrg(acte.getPrixUrg());
			dfM.setPrixDepl(acte.getPrixUrg());

			if (dfM.getType().equals("normal")) {
				dfM.setQpActeur(acte.getTauxPraticien());
			} else {
				dfM.setQpActeur(acte.getTauxPraticienUrg());
			}
		}

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see clinique.metier.gestion.commerciale.IGestionCommercialeBO#
	 * setInfosDfmActeurWithPc(clinique.mapping.DetailFactureModifiees,
	 * java.util.Date, clinique.mapping.Acteur, clinique.mapping.Acte,
	 * clinique.mapping.Categorie)
	 */
	@Override
	public void setInfosDfmActeurWithPc(DetailFactureModifiees dfM, Date dateF,
			Acteur acteur, Acte acte, Categorie categorie) {

		boolean trouve = false;

		ActeurActeAssureur acteurActeAssureur = getActeurActeAssureurDAO()
				.getActeurActeAssureurByDate(acteur, dateF, acte, categorie);

		ActeurActeAssureurH acteurActeAssureurH = acteurActeAssureurHDAO
				.getActeurActeAssureurHByDate(acteur, dateF, acte, categorie);

		ActeurActe acteurActe = getActeurActeDAO().getActeurActeByDate(acteur,
				dateF, acte);

		ActeurActeH acteurActeH = getActeurActeHDAO().getActeurActeHByDate(
				acteur, dateF, acte);

		ActeAssureur acteAssureur = getActeAssureurDAO().getActeAssureurByDate(
				dateF, acte, categorie);

		ActeAssureurH acteAssureurH = getActeAssureurHDAO()
				.getActeAssureurHByDate(dateF, acte, categorie);

		Acte acteByDate = getActeDAO().getActeByDate(dateF, acte);

		ActeH acteH = getActeHDAO().getActeHByDate(dateF, acte);

		if (acteurActeAssureur != null) {
			trouve = true;
			dfM.setPrix(acteurActeAssureur.getPrix());
			dfM.setPrixUrg(acteurActeAssureur.getPrixUrg());
			dfM.setPrixDepl(acteurActeAssureur.getPrixUrg());

			if (dfM.getType().equals("normal")) {
				dfM.setQpActeur(acteurActeAssureur.getPourcentage());
			} else {
				dfM.setQpActeur(acteurActeAssureur.getPourcentageUrg());
			}
		}

		else if (acteurActeAssureurH != null && !trouve) {
			trouve = true;
			dfM.setPrix(acteurActeAssureurH.getPrix());
			dfM.setPrixUrg(acteurActeAssureurH.getPrixUrg());
			dfM.setPrixDepl(acteurActeAssureurH.getPrixUrg());

			if (dfM.getType().equals("normal")) {
				dfM.setQpActeur(acteurActeAssureurH.getPourcentage());
			} else {
				dfM.setQpActeur(acteurActeAssureurH.getPourcentageUrg());
			}
		}

		else if (acteAssureur != null && !trouve) {
			trouve = true;
			dfM.setPrix(acteAssureur.getPrix());
			dfM.setPrixUrg(acteAssureur.getPrixUrg());
			dfM.setPrixDepl(acteAssureur.getPrixUrg());

			if (dfM.getType().equals("normal")) {
				dfM.setQpActeur(acteAssureur.getActe().getTauxPraticien());
			} else {
				dfM.setQpActeur(acteAssureur.getActe().getTauxPraticienUrg());
			}
		}

		else if (acteAssureurH != null && !trouve) {
			trouve = true;
			dfM.setPrix(acteAssureurH.getPrix());
			dfM.setPrixUrg(acteAssureurH.getPrixUrg());
			dfM.setPrixDepl(acteAssureurH.getPrixUrg());

			if (dfM.getType().equals("normal")) {
				dfM.setQpActeur(acteAssureurH.getActe().getTauxPraticien());
			} else {
				dfM.setQpActeur(acteAssureurH.getActe().getTauxPraticienUrg());
			}
		}

		else if (acteurActe != null && !trouve) {
			trouve = true;
			dfM.setPrix(acteurActe.getPrix());
			dfM.setPrixUrg(acteurActe.getPrixUrg());
			dfM.setPrixDepl(acteurActe.getPrixUrg());

			if (dfM.getType().equals("normal")) {
				dfM.setQpActeur(acteurActe.getPourcentage());
			} else {
				dfM.setQpActeur(acteurActe.getPourcentageUrg());
			}
		}

		else if (acteurActeH != null && !trouve) {
			trouve = true;
			dfM.setPrix(acteurActeH.getPrix());
			dfM.setPrixUrg(acteurActeH.getPrixUrg());
			dfM.setPrixDepl(acteurActeH.getPrixUrg());

			if (dfM.getType().equals("normal")) {
				dfM.setQpActeur(acteurActeH.getPourcentage());
			} else {
				dfM.setQpActeur(acteurActeH.getPourcentageUrg());
			}
		}

		else if (acteByDate != null && !trouve) {
			trouve = true;
			dfM.setPrix(acteByDate.getPrix());
			dfM.setPrixUrg(acteByDate.getPrixUrg());
			dfM.setPrixDepl(acteByDate.getPrixUrg());

			if (dfM.getType().equals("normal")) {
				dfM.setQpActeur(acteByDate.getTauxPraticien());
			} else {
				dfM.setQpActeur(acteByDate.getTauxPraticienUrg());
			}
		}

		else if (acteH != null && !trouve) {
			trouve = true;
			dfM.setPrix(acteH.getPrix());
			dfM.setPrixUrg(acteH.getPrixUrg());
			dfM.setPrixDepl(acteH.getPrixUrg());

			if (dfM.getType().equals("normal")) {
				dfM.setQpActeur(acteH.getTauxPraticien());
			} else {
				dfM.setQpActeur(acteH.getTauxPraticienUrg());
			}

		}

		if (!trouve) {
			dfM.setPrix(acte.getPrix());
			dfM.setPrixUrg(acte.getPrixUrg());
			dfM.setPrixDepl(acte.getPrixUrg());

			if (dfM.getType().equals("normal")) {
				dfM.setQpActeur(acte.getTauxPraticien());
			} else {
				dfM.setQpActeur(acte.getTauxPraticienUrg());
			}
		}

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see clinique.metier.gestion.commerciale.IGestionCommercialeBO#
	 * setInfosDfmPcWithoutActeur(clinique.mapping.DetailFactureModifiees,
	 * java.util.Date, clinique.mapping.Acte, clinique.mapping.Categorie)
	 */
	@Override
	public void setInfosDfmPcWithoutActeur(DetailFactureModifiees dfM,
			Date dateF, Acte acte, Categorie categorie) {

		boolean trouve = false;

		ActeAssureur acteAssureur = getActeAssureurDAO().getActeAssureurByDate(
				dateF, acte, categorie);

		ActeAssureurH acteAssureurH = getActeAssureurHDAO()
				.getActeAssureurHByDate(dateF, acte, categorie);

		Acte acteByDate = getActeDAO().getActeByDate(dateF, acte);

		ActeH acteH = getActeHDAO().getActeHByDate(dateF, acte);

		if (acteAssureur != null) {
			trouve = true;
			dfM.setPrix(acteAssureur.getPrix());
			dfM.setPrixUrg(acteAssureur.getPrixUrg());
			dfM.setPrixDepl(acteAssureur.getPrixUrg());

			if (dfM.getType().equals("normal")) {
				dfM.setQpActeur(acteAssureur.getActe().getTauxPraticien());
			} else {
				dfM.setQpActeur(acteAssureur.getActe().getTauxPraticienUrg());
			}
		}

		else if (acteAssureurH != null && !trouve) {
			trouve = true;
			dfM.setPrix(acteAssureurH.getPrix());
			dfM.setPrixUrg(acteAssureurH.getPrixUrg());
			dfM.setPrixDepl(acteAssureurH.getPrixUrg());

			if (dfM.getType().equals("normal")) {
				dfM.setQpActeur(acteAssureurH.getActe().getTauxPraticien());
			} else {
				dfM.setQpActeur(acteAssureurH.getActe().getTauxPraticienUrg());
			}
		}

		else if (acteByDate != null && !trouve) {
			trouve = true;
			dfM.setPrix(acteByDate.getPrix());
			dfM.setPrixUrg(acteByDate.getPrixUrg());
			dfM.setPrixDepl(acteByDate.getPrixUrg());

			if (dfM.getType().equals("normal")) {
				dfM.setQpActeur(acteByDate.getTauxPraticien());
			} else {
				dfM.setQpActeur(acteByDate.getTauxPraticienUrg());
			}
		}

		else if (acteH != null && !trouve) {
			trouve = true;
			dfM.setPrix(acteH.getPrix());
			dfM.setPrixUrg(acteH.getPrixUrg());
			dfM.setPrixDepl(acteH.getPrixUrg());

			if (dfM.getType().equals("normal")) {
				dfM.setQpActeur(acteH.getTauxPraticien());
			} else {
				dfM.setQpActeur(acteH.getTauxPraticienUrg());
			}
		}

		if (!trouve) {
			dfM.setPrix(acte.getPrix());
			dfM.setPrixUrg(acte.getPrixUrg());
			dfM.setPrixDepl(acte.getPrixUrg());

			if (dfM.getType().equals("normal")) {
				dfM.setQpActeur(acte.getTauxPraticien());
			} else {
				dfM.setQpActeur(acte.getTauxPraticienUrg());
			}
		}

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see clinique.metier.gestion.commerciale.IGestionCommercialeBO#
	 * setInfosDfmWithoutPcWithoutActeur
	 * (clinique.mapping.DetailFactureModifiees, java.util.Date,
	 * clinique.mapping.Acte)
	 */
	@Override
	public void setInfosDfmWithoutPcWithoutActeur(DetailFactureModifiees dfM,
			Date dateF, Acte acte) {

		boolean trouve = false;

		Acte acteByDate = getActeDAO().getActeByDate(dateF, acte);

		ActeH acteH = getActeHDAO().getActeHByDate(dateF, acte);

		if (acteByDate != null) {
			trouve = true;
			dfM.setPrix(acteByDate.getPrix());
			dfM.setPrixUrg(acteByDate.getPrixUrg());
			dfM.setPrixDepl(acteByDate.getPrixUrg());

			if (dfM.getType().equals("normal")) {
				dfM.setQpActeur(acteByDate.getTauxPraticien());
			} else {
				dfM.setQpActeur(acteByDate.getTauxPraticienUrg());
			}
		}

		else if (acteH != null && !trouve) {
			trouve = true;
			dfM.setPrix(acteH.getPrix());
			dfM.setPrixUrg(acteH.getPrixUrg());
			dfM.setPrixDepl(acteH.getPrixUrg());

			if (dfM.getType().equals("normal")) {
				dfM.setQpActeur(acteH.getTauxPraticien());
			} else {
				dfM.setQpActeur(acteH.getTauxPraticienUrg());
			}
		}

		if (!trouve) {
			dfM.setPrix(acte.getPrix());
			dfM.setPrixUrg(acte.getPrixUrg());
			dfM.setPrixDepl(acte.getPrixUrg());

			if (dfM.getType().equals("normal")) {
				dfM.setQpActeur(acte.getTauxPraticien());
			} else {
				dfM.setQpActeur(acte.getTauxPraticienUrg());
			}
		}

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * clinique.metier.gestion.commerciale.IGestionCommercialeBO#setLibererChambre
	 * (clinique.model.gestion.commerciale.GestionCommercialeForm)
	 */
	@Override
	@SuppressWarnings({ "finally", "unchecked" })
	public boolean setLibererChambre(GestionCommercialeForm formulaire)
			throws Exception {

		boolean result = false;
		log.debug("********** Debut setLibererChambre GestionCommercialeBO **********");

		try {
			Hospitalisation hospitalisation = formulaire.getHospitalisation();

			formulaire
					.setChambresHospList(chambresHospitalisationDAO
							.findChambresHospitalisationByHospitalisation(hospitalisation));

			int i = 0;
			for (Iterator iter = formulaire.getChambresHospList().iterator(); iter
					.hasNext();) {
				ChambresHospitalisation element = (ChambresHospitalisation) iter
						.next();
				if (element.getStatut().equals("0")) {
					element.setStatut("1");
					element.setDateSortie(UtilDate.getInstance().stringToDate(
							formulaire.getDateSortie()));
					element.setHeureSortie(Integer.parseInt(formulaire
							.getHeureHosp()));
					formulaire.getChambresHospList().set(i, element);

				}
				i++;
			}

			int nbreChambresHosp = i;
			int majoration = calculMajoration(formulaire);
			i = 0;
			double frais = 0;
			for (Iterator iter = formulaire.getChambresHospList().iterator(); iter
					.hasNext();) {
				ChambresHospitalisation element = (ChambresHospitalisation) iter
						.next();
				frais = getChambreFrais(element);
				element.setTotalReel(frais);
				frais = frais + majoration * frais / 100;
				element.setTotal(frais);
				formulaire.getChambresHospList().set(i, element);

				i++;
			}
			List<ChambresHospitalisation> list = chambresHospitalisationDAO
					.findChambresHospitalisationByHospitalisation(hospitalisation);
			for (i = 0; i < nbreChambresHosp; i++) {
				ChambresHospitalisation element = (ChambresHospitalisation) formulaire
						.getChambresHospList().get(i);
				list.set(i, element);
			}

			formulaire.getHospitalisation().setEncours("2");

			result = true;

		} catch (Exception e) {

			e.printStackTrace();
			log.fatal(e.getMessage());

		}

		finally {
			log.debug("********** Fin setLibererChambre GestionCommercialeBO **********");
			return result;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * clinique.metier.gestion.commerciale.IGestionCommercialeBO#setPrestCouvAtList
	 * (clinique.mapping.PrestationCouvertesPc,
	 * clinique.model.gestion.commerciale.GestionCommercialeForm)
	 */
	@Override
	@SuppressWarnings("unchecked")
	public void setPrestCouvAtList(PrestationCouvertesPc pcCouv,
			GestionCommercialeForm formulaire) {
		int i = 0;
		List list = formulaire.getPrestationCouvertesPcs();
		for (Iterator iter = list.iterator(); iter.hasNext();) {
			PrestationCouvertesPc element = (PrestationCouvertesPc) iter.next();
			if (element.getPresCouvId().equals(pcCouv.getPresCouvId())) {
				formulaire.getPrestationCouvertesPcs().set(i, pcCouv);
				i++;
				break;
			}

		}

		PriseEnCharge pc = formulaire.getPriseEnCharge();
		prestationCouvertesPcDAO.findPrestationCouvertesByPc(pc).set(i - 1,
				pcCouv);
		formulaire.setPriseEnCharge(pc);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * clinique.metier.gestion.commerciale.IGestionCommercialeBO#setSortie(clinique
	 * .model.gestion.commerciale.GestionCommercialeForm)
	 */
	@Override
	@SuppressWarnings({ "finally", "unchecked" })
	public boolean setSortie(GestionCommercialeForm formulaire)
			throws Exception {

		boolean result = false;
		log.debug("********** Debut setSortie GestionCommercialeBO **********");

		try {
			Hospitalisation hospitalisation = formulaire.getHospitalisation();
			formulaire
					.setChambresHospList(chambresHospitalisationDAO
							.findChambresHospitalisationByHospitalisation(hospitalisation));

			int i = 0;
			for (Iterator iter = formulaire.getChambresHospList().iterator(); iter
					.hasNext();) {
				ChambresHospitalisation element = (ChambresHospitalisation) iter
						.next();
				if (element.getStatut().equals("0")) {
					element.setStatut("1");
					element.setDateSortie(UtilDate.getInstance().stringToDate(
							formulaire.getDateSortie()));
					element.setHeureSortie(Integer.parseInt(formulaire
							.getHeureHosp()));
					formulaire.getChambresHospList().set(i, element);

				}
				i++;
			}

			int nbreChambresHosp = i;
			int majoration = calculMajoration(formulaire);
			i = 0;
			double frais = 0;
			for (Iterator iter = formulaire.getChambresHospList().iterator(); iter
					.hasNext();) {
				ChambresHospitalisation element = (ChambresHospitalisation) iter
						.next();
				frais = getChambreFrais(element);
				element.setTotalReel(frais);
				frais = frais + majoration * frais / 100;
				element.setTotal(frais);
				formulaire.getChambresHospList().set(i, element);
				addFraisChambre(formulaire, frais);
				i++;
			}
			List<ChambresHospitalisation> list = chambresHospitalisationDAO
					.findChambresHospitalisationByHospitalisation(hospitalisation);
			for (i = 0; i < nbreChambresHosp; i++) {
				ChambresHospitalisation element = (ChambresHospitalisation) formulaire
						.getChambresHospList().get(i);
				list.set(i, element);
			}

			formulaire.getHospitalisation().setEncours("0");

			result = true;

		} catch (Exception e) {

			e.printStackTrace();
			log.fatal(e.getMessage());

		}

		finally {
			log.debug("********** Fin setSortie GestionCommercialeBO **********");
			return result;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see clinique.metier.gestion.commerciale.IGestionCommercialeBO#
	 * setSortieSansReglement
	 * (clinique.model.gestion.commerciale.GestionCommercialeForm)
	 */
	@Override
	@SuppressWarnings({ "finally", "unchecked" })
	public boolean setSortieSansReglement(GestionCommercialeForm formulaire)
			throws Exception {

		boolean result = false;
		log.debug("********** Debut setSortieSansReglement GestionCommercialeBO **********");
		try {

			// enregistrer facture

			Hospitalisation hospitalisation = getHospitalisationDAO()
					.getHospitalisation(
							formulaire.getHospitalisation()
									.getHospitalisationId());

			Chambre chambre = hospitalisation.getChambre();

			chambre.setEtat("1");
			getChambreDAO().update(chambre);

			int nbreChambresHosp = formulaire.getChambresHospList().size();
			List<ChambresHospitalisation> list = chambresHospitalisationDAO
					.findChambresHospitalisationByHospitalisation(hospitalisation);
			for (int i = 0; i < nbreChambresHosp; i++) {
				ChambresHospitalisation element = (ChambresHospitalisation) formulaire
						.getChambresHospList().get(i);
				list.set(i, element);
			}

			hospitalisation.setDateSortie(UtilDate.getInstance().stringToDate(
					formulaire.getDateSortie()));
			hospitalisation.setEncours("2");
			getHospitalisationDAO().update(hospitalisation);

			result = true;

		} catch (Exception e) {
			log.fatal(e.getMessage());

		}

		finally {
			log.debug("********** Fin setSortieSansReglement GestionCommercialeBO **********");
			return result;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see clinique.metier.gestion.commerciale.IGestionCommercialeBO#
	 * setTauxAssistantWithoutPc(clinique.mapping.DetailFactureModifiees,
	 * java.util.Date, clinique.mapping.Acte)
	 */
	@Override
	public void setTauxAssistantWithoutPc(DetailFactureModifiees dfM,
			Date dateF, Acte acte) {

		boolean trouve = false;

		Acte acteByDate = getActeDAO().getActeByDate(dateF, acte);

		ActeH acteH = getActeHDAO().getActeHByDate(dateF, acte);

		if (acteByDate != null) {
			trouve = true;
			dfM.setPrix(acteByDate.getPrix());
			dfM.setPrixUrg(acteByDate.getPrixUrg());
			dfM.setPrixDepl(acteByDate.getPrixUrg());

			if (dfM.getType().equals("normal")) {
				dfM.setQpAssistant(acteByDate.getTauxAssistant());
			} else if (dfM.getType().equals("urgence")) {
				dfM.setQpAssistant(acteByDate.getTauxAssistantUrg());
			} else {
				dfM.setQpAssistant(acteByDate.getTauxDepAssistant());
			}
		}

		else if (acteH != null && !trouve) {
			trouve = true;
			dfM.setPrix(acteH.getPrix());
			dfM.setPrixUrg(acteH.getPrixUrg());
			dfM.setPrixDepl(acteH.getPrixUrg());

			if (dfM.getType().equals("normal")) {
				dfM.setQpAssistant(acteH.getTauxAssistant());
			} else if (dfM.getType().equals("urgence")) {
				dfM.setQpAssistant(acteH.getTauxAssistantUrg());
			} else {
				dfM.setQpAssistant(acteH.getTauxDepAssistant());
			}
		}

		if (!trouve) {
			dfM.setPrix(acte.getPrix());
			dfM.setPrixUrg(acte.getPrixUrg());
			dfM.setPrixDepl(acte.getPrixUrg());

			if (dfM.getType().equals("normal")) {
				dfM.setQpAssistant(acte.getTauxAssistant());
			} else if (dfM.getType().equals("urgence")) {
				dfM.setQpAssistant(acte.getTauxAssistantUrg());
			} else {
				dfM.setQpAssistant(acte.getTauxDepAssistant());
			}
		}

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see clinique.metier.gestion.commerciale.IGestionCommercialeBO#
	 * setTauxAssistantWithPc(clinique.mapping.DetailFactureModifiees,
	 * java.util.Date, clinique.mapping.Acte, clinique.mapping.Categorie)
	 */
	@Override
	public void setTauxAssistantWithPc(DetailFactureModifiees dfM, Date dateF,
			Acte acte, Categorie categorie) {

		boolean trouve = false;

		ActeAssureur acteAssureur = getActeAssureurDAO().getActeAssureurByDate(
				dateF, acte, categorie);

		ActeAssureurH acteAssureurH = getActeAssureurHDAO()
				.getActeAssureurHByDate(dateF, acte, categorie);

		Acte acteByDate = getActeDAO().getActeByDate(dateF, acte);

		ActeH acteH = getActeHDAO().getActeHByDate(dateF, acte);

		if (acteAssureur != null) {
			trouve = true;
			dfM.setPrix(acteAssureur.getPrix());
			dfM.setPrixUrg(acteAssureur.getPrixUrg());
			dfM.setPrixDepl(acteAssureur.getPrixUrg());

			if (dfM.getType().equals("normal")) {
				dfM.setQpAssistant(acteAssureur.getActe().getTauxAssistant());
			} else if (dfM.getType().equals("urgence")) {
				dfM.setQpAssistant(acteAssureur.getActe().getTauxAssistantUrg());
			} else {
				dfM.setQpAssistant(acteAssureur.getActe().getTauxDepAssistant());
			}
		}

		else if (acteAssureurH != null && !trouve) {
			trouve = true;
			dfM.setPrix(acteAssureurH.getPrix());
			dfM.setPrixUrg(acteAssureurH.getPrixUrg());
			dfM.setPrixDepl(acteAssureurH.getPrixUrg());

			if (dfM.getType().equals("normal")) {
				dfM.setQpAssistant(acteAssureurH.getActe().getTauxAssistant());
			} else if (dfM.getType().equals("urgence")) {
				dfM.setQpAssistant(acteAssureurH.getActe()
						.getTauxAssistantUrg());
			} else {
				dfM.setQpAssistant(acteAssureurH.getActe()
						.getTauxDepAssistant());
			}
		}

		else if (acteByDate != null && !trouve) {
			trouve = true;
			dfM.setPrix(acteByDate.getPrix());
			dfM.setPrixUrg(acteByDate.getPrixUrg());
			dfM.setPrixDepl(acteByDate.getPrixUrg());

			if (dfM.getType().equals("normal")) {
				dfM.setQpAssistant(acteByDate.getTauxAssistant());
			} else if (dfM.getType().equals("urgence")) {
				dfM.setQpAssistant(acteByDate.getTauxAssistantUrg());
			} else {
				dfM.setQpAssistant(acteByDate.getTauxDepAssistant());
			}
		}

		else if (acteH != null && !trouve) {
			trouve = true;
			dfM.setPrix(acteH.getPrix());
			dfM.setPrixUrg(acteH.getPrixUrg());
			dfM.setPrixDepl(acteH.getPrixUrg());

			if (dfM.getType().equals("normal")) {
				dfM.setQpAssistant(acteH.getTauxAssistant());
			} else if (dfM.getType().equals("urgence")) {
				dfM.setQpAssistant(acteH.getTauxAssistantUrg());
			} else {
				dfM.setQpAssistant(acteH.getTauxDepAssistant());
			}
		}

		if (!trouve) {
			dfM.setPrix(acte.getPrix());
			dfM.setPrixUrg(acte.getPrixUrg());
			dfM.setPrixDepl(acte.getPrixUrg());

			if (dfM.getType().equals("normal")) {
				dfM.setQpAssistant(acte.getTauxAssistant());
			} else if (dfM.getType().equals("urgence")) {
				dfM.setQpAssistant(acte.getTauxAssistantUrg());
			} else {
				dfM.setQpAssistant(acte.getTauxDepAssistant());
			}
		}

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see clinique.metier.gestion.commerciale.IGestionCommercialeBO#
	 * setValeursResteApyer
	 * (clinique.model.gestion.commerciale.GestionCommercialeForm)
	 */
	@Override
	@SuppressWarnings("unchecked")
	public void setValeursResteApyer(GestionCommercialeForm formulaire) {

		double resteApayer = Double.parseDouble(formulaire.getTotalApayer())
				- Double.parseDouble(formulaire.getCoteAssureur())
				- Double.parseDouble(formulaire.getRemiseMontant());

		if (!formulaire.getPriseEnChargeFlag().equals("aucune")) {
			if (formulaire.getLibeleAssureur().equals("CNAM")) {
				double petitMonnaieDrg = 0;

				for (Iterator iter = formulaire.getDetailDrgCnamListFacture()
						.iterator(); iter.hasNext();) {
					DetailDgrCnamFacture element = (DetailDgrCnamFacture) iter
							.next();

					petitMonnaieDrg = petitMonnaieDrg
							+ element.getPetitMonnaie();
				}

				resteApayer = resteApayer + petitMonnaieDrg;
			}
		}

		double resteApayerSansMajoration = 0;
		resteApayerSansMajoration = 100 * resteApayer
				/ (100 + calculMajoration(formulaire));

		formulaire.setResteApayer(String.valueOf(resteApayerSansMajoration));
		formulaire.setResteApayerMajoration(String.valueOf(resteApayer));

		if (resteApayer == 0) {
			formulaire.setRecuRegle("1");
		} else {
			formulaire.setRecuRegle("0");
		}

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see clinique.metier.gestion.commerciale.IGestionCommercialeBO#
	 * setValeursResteApyer2
	 * (clinique.model.gestion.commerciale.GestionCommercialeForm)
	 */
	@Override
	public void setValeursResteApyer2(GestionCommercialeForm formulaire) {
		double resteApayer = Double.parseDouble(formulaire.getTotalApayer())
				- Double.parseDouble(formulaire.getCoteAssureur())
				- Double.parseDouble(formulaire.getRemiseMontant());

		double resteApayerSansMajoration = 0;
		resteApayerSansMajoration = resteApayer - resteApayer
				* calculMajoration(formulaire) / 100;

		formulaire.setResteApayer(String.valueOf(resteApayerSansMajoration));
		formulaire.setResteApayerMajoration(String.valueOf(resteApayer));

		if (resteApayer == 0) {
			formulaire.setRecuRegle("1");
		} else {
			formulaire.setRecuRegle("0");
		}

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see clinique.metier.gestion.commerciale.IGestionCommercialeBO#
	 * setValeursResteApyerHosp
	 * (clinique.model.gestion.commerciale.GestionCommercialeForm)
	 */
	@Override
	@SuppressWarnings("unchecked")
	public void setValeursResteApyerHosp(GestionCommercialeForm formulaire)
			throws Exception {

		try {
			double resteApayer = Double
					.parseDouble(formulaire.getTotalApayer())
					- Double.parseDouble(formulaire.getCoteAssureur())
					- Double.parseDouble(formulaire.getRemiseMontant());

			if (!formulaire.getPriseEnChargeFlag().equals("aucune")) {
				if (formulaire.getLibeleAssureur().equals("CNAM")) {
					double petitMonnaieDrg = 0;

					for (Iterator iter = formulaire
							.getDetailDrgCnamListFacture().iterator(); iter
							.hasNext();) {
						DetailDgrCnamFacture element = (DetailDgrCnamFacture) iter
								.next();

						petitMonnaieDrg = petitMonnaieDrg
								+ element.getPetitMonnaie();
					}

					resteApayer = resteApayer + petitMonnaieDrg;
				}
			}

			double resteApayerSansMajoration = 0;
			int majoration = calculMajoration(formulaire);
			resteApayerSansMajoration = 100 * resteApayer / (100 + majoration);

			double avance = Double.parseDouble(formulaire.getAvance());
			if (resteApayerSansMajoration > avance) {
				resteApayerSansMajoration = resteApayerSansMajoration - avance;
				formulaire.setaRendre("0");
			} else {
				if (avance - resteApayerSansMajoration == 0) {
					formulaire.setaRendre("0");
				} else {
					formulaire.setaRendre(String.valueOf(avance
							- resteApayerSansMajoration));

				}
				resteApayerSansMajoration = 0;

			}

			resteApayer = resteApayerSansMajoration + resteApayerSansMajoration
					* majoration / 100;

			formulaire
					.setResteApayer(String.valueOf(resteApayerSansMajoration));
			formulaire.setResteApayerMajoration(String.valueOf(resteApayer));

			if (resteApayer == 0) {
				formulaire.setRecuRegle("1");
			} else {
				formulaire.setRecuRegle("0");
			}

		}

		catch (Exception e) {
			e.printStackTrace();
		}

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see clinique.metier.gestion.commerciale.IGestionCommercialeBO#
	 * showHospForAddPrestation
	 * (clinique.model.gestion.commerciale.GestionCommercialeForm)
	 */
	@Override
	@SuppressWarnings({ "finally", "unchecked" })
	public boolean showHospForAddPrestation(GestionCommercialeForm formulaire)
			throws Exception {

		log.debug("********** Debut patientPrestationsFormulaire GestionCommercialeBO **********");
		boolean result = false;
		try {

			Hospitalisation hospitalisation = getHospitalisationDAO()
					.getHospitalisation(formulaire.getHospitalisaionId());
			formulaire.setDetailsFactureList(new ArrayList());

			if (hospitalisation != null) {
				formulaire.setHospitalisation(hospitalisation);
				formulaire.setDateEntree(UtilDate.getInstance().dateToString(
						hospitalisation.getDateEntree()));
				formulaire.setChambreActuelle(hospitalisation.getChambre()
						.getChambreLibelle());
				formulaire.setAvance(String.valueOf(hospitalisation
						.getFacture().getAvance()));
				formulaire.setPatient(hospitalisation.getPatient());
				formulaire.setFacture(hospitalisation.getFacture());
			}

			System.out.println("bbbbbbbbbb " + formulaire.getOperateur());
			Recu recu = new Recu();
			recu.setRecuId(ConstantesMetier.ID_RECU
					+ UtilDate.getInstance().getDateForId()
					+ ""
					+ getUserDao().getUserByLogin(formulaire.getOperateur())
							.getUserId());
			recu.setDateRecu(UtilDate.getInstance().getDateToday());
			recu.setFacture(formulaire.getFacture());
			recu.setOperateur(formulaire.getOperateur());
			formulaire.setRecu(recu);

			Patient patient = formulaire.getPatient();
			if (patient != null) {
				formulaire.setPatientId(String.valueOf(patient.getPatientId()));
				formulaire.setNom(patient.getNom());
				formulaire.setPrenom(patient.getPrenom());
				formulaire.setAdresse(patient.getAdresse());
				formulaire.setCni(patient.getCni());
				formulaire.setDateNaissance(UtilDate.getInstance()
						.dateToString(patient.getDateNaissance()));

				formulaire.setDateDerniereVisite(UtilDate.getInstance()
						.dateToString(patient.getDateDerniereVisite()));
				formulaire.setDatePremiereVisite(UtilDate.getInstance()
						.dateToString(patient.getDatePremiereViste()));
				formulaire.setLieuNaissance(patient.getLieuNaissance());
				formulaire.setNni(patient.getNni());
				formulaire.setPriseEnChargeFlag(patient.getPriseEnChargeFlag());

				if (!formulaire.getPriseEnChargeFlag().equals("aucune")) {
					PatientPcActuel patientPcActuel = getPatientPcActuelDAO()
							.getPatientPcByPatient(patient);
					if (patientPcActuel != null) {
						if (patientPcActuel.getType().equals("badge")
								&& patientPcActuel.getBadge() != null) {

							formulaire.setNumeroBadge(patientPcActuel
									.getBadge().getNumeroBadge());
						} else {
							formulaire.setNumeroBadge("");
						}

						formulaire.setLibeleAssureur(patient.getCategorie()
								.getNomCategorie());
						formulaire.setCategorieId(String.valueOf(patient
								.getCategorie().getCategorieId()));
					}
				}
				formulaire.setTelephone(patient.getTelephone());

				// formulaire.setDetailsFactureList(null);

				result = true;

			}

		} catch (Exception e) {
			e.printStackTrace();
			log.fatal(e.getMessage());

		}

		finally {
			log.debug("********** Debut patientPrestationsFormulaire GestionCommercialeBO **********");
			return result;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see clinique.metier.gestion.commerciale.IGestionCommercialeBO#
	 * showHospForChangeChambre
	 * (clinique.model.gestion.commerciale.GestionCommercialeForm)
	 */
	@Override
	@SuppressWarnings("finally")
	public boolean showHospForChangeChambre(GestionCommercialeForm formulaire)
			throws Exception {

		log.debug("********** Debut patientPrestationsFormulaire GestionCommercialeBO **********");
		boolean result = false;
		try {

			HospitalisationDAO hospitalisationDAO = getHospitalisationDAO();

			Hospitalisation hospitalisation = hospitalisationDAO
					.getHospitalisation(formulaire.getHospitalisaionId().trim());

			if (hospitalisation != null) {
				formulaire.setHospitalisation(hospitalisation);
				formulaire.setDateEntree(UtilDate.getInstance().dateToString(
						hospitalisation.getDateEntree()));
				formulaire.setChambreActuelle(hospitalisation.getChambre()
						.getChambreLibelle());
				formulaire.setAvance(String.valueOf(hospitalisation
						.getFacture().getAvance()));
				formulaire.setPatient(hospitalisation.getPatient());
			}

			Patient patient = formulaire.getPatient();
			if (patient != null) {
				formulaire.setPatientId(String.valueOf(patient.getPatientId()));
				formulaire.setNom(patient.getNom());
				formulaire.setPrenom(patient.getPrenom());
				formulaire.setAdresse(patient.getAdresse());
				formulaire.setCni(patient.getCni());
				formulaire.setDateNaissance(UtilDate.getInstance()
						.dateToString(patient.getDateNaissance()));

				formulaire.setDateDerniereVisite(UtilDate.getInstance()
						.dateToString(patient.getDateDerniereVisite()));
				formulaire.setDatePremiereVisite(UtilDate.getInstance()
						.dateToString(patient.getDatePremiereViste()));
				formulaire.setLieuNaissance(patient.getLieuNaissance());
				formulaire.setNni(patient.getNni());
				PatientPcActuel patientPcActuel = getPatientPcActuelDAO()
						.getPatientPcByPatient(patient);
				if (patientPcActuel.getType().equals("badge")
						&& patientPcActuel.getBadge() != null) {
					formulaire.setNumeroBadge(patientPcActuel.getBadge()
							.getNumeroBadge());
				} else {
					formulaire.setNumeroBadge("");
				}
				formulaire.setTelephone(patient.getTelephone());

				// formulaire.setDetailsFactureList(null);

				result = true;

			}

		} catch (Exception e) {
			log.fatal(e.getMessage());
		}

		finally {
			log.debug("********** Debut patientPrestationsFormulaire GestionCommercialeBO **********");
			return result;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * clinique.metier.gestion.commerciale.IGestionCommercialeBO#showHospForSortie
	 * (clinique.model.gestion.commerciale.GestionCommercialeForm)
	 */
	@Override
	@SuppressWarnings("finally")
	public boolean showHospForSortie(GestionCommercialeForm formulaire)
			throws Exception {

		log.debug("********** Debut showHospForSortie GestionCommercialeBO **********");
		// Session session=SessionFactoryUtil.getInstance().openSession();
		boolean result = false;
		try {

			Hospitalisation hospitalisation = getHospitalisationDAO()
					.getHospitalisation(formulaire.getHospitalisaionId().trim());
			if (hospitalisation != null) {
				formulaire.setHospitalisation(hospitalisation);
				formulaire.setDateEntree(UtilDate.getInstance().dateToString(
						hospitalisation.getDateEntree()));
				formulaire.setChambreActuelle(hospitalisation.getChambre()
						.getChambreLibelle());
				formulaire.setAvance(String.valueOf(hospitalisation
						.getFacture().getAvance()));
				formulaire.setPatient(hospitalisation.getPatient());
				formulaire.setFacture(hospitalisation.getFacture());
				Facture facture = hospitalisation.getFacture();
				formulaire.setDetailsFactureList(detailFactureDAO
						.findDetailFactureByFacture(facture));
			}

			Patient patient = formulaire.getPatient();
			if (patient != null) {
				formulaire.setPatientId(String.valueOf(patient.getPatientId()));
				formulaire.setNom(patient.getNom());
				formulaire.setPrenom(patient.getPrenom());
				formulaire.setAdresse(patient.getAdresse());
				formulaire.setCni(patient.getCni());
				formulaire.setDateNaissance(UtilDate.getInstance()
						.dateToString(patient.getDateNaissance()));

				formulaire.setDateDerniereVisite(UtilDate.getInstance()
						.dateToString(patient.getDateDerniereVisite()));
				formulaire.setDatePremiereVisite(UtilDate.getInstance()
						.dateToString(patient.getDatePremiereViste()));
				formulaire.setLieuNaissance(patient.getLieuNaissance());
				formulaire.setNni(patient.getNni());
				formulaire.setPriseEnChargeFlag(patient.getPriseEnChargeFlag());
				PatientPcActuel patientPcActuel = getPatientPcActuelDAO()
						.getPatientPcByPatient(patient);

				if (!formulaire.getPriseEnChargeFlag().equals("aucune")) {
					if (patientPcActuel != null) {
						if (patientPcActuel.getType().equals("badge")
								&& patientPcActuel.getBadge() != null) {
							formulaire.setNumeroBadge(patientPcActuel
									.getBadge().getNumeroBadge());
						} else {
							formulaire.setNumeroBadge("");
						}

						formulaire.setLibeleAssureur(patient.getCategorie()
								.getNomCategorie());
						formulaire.setCategorieId(String.valueOf(patient
								.getCategorie().getCategorieId()));
					}
				}

				formulaire.setTelephone(patient.getTelephone());

				result = true;

			}

		} catch (Exception e) {
			e.printStackTrace();
			log.fatal(e.getMessage());
		}

		finally {
			log.debug("********** Debut showHospForSortie GestionCommercialeBO **********");
			return result;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see clinique.metier.gestion.commerciale.IGestionCommercialeBO#
	 * showHospInfosForSortie
	 * (clinique.model.gestion.commerciale.GestionCommercialeForm)
	 */
	@Override
	@SuppressWarnings("finally")
	public boolean showHospInfosForSortie(GestionCommercialeForm formulaire)
			throws Exception {

		log.debug("********** Debut showHospInfosForSortie GestionCommercialeBO **********");
		boolean result = false;
		try {

			Hospitalisation hospitalisation = getHospitalisationDAO()
					.getHospitalisation(formulaire.getHospitalisaionId().trim());
			if (hospitalisation != null) {
				formulaire.setHospitalisation(hospitalisation);
				formulaire.setDateEntree(UtilDate.getInstance().dateToString(
						hospitalisation.getDateEntree()));
				formulaire.setChambreActuelle(hospitalisation.getChambre()
						.getChambreLibelle());
				formulaire.setAvance(String.valueOf(hospitalisation
						.getFacture().getAvance()));
				formulaire.setPatient(hospitalisation.getPatient());
				formulaire.setFacture(hospitalisation.getFacture());
				Facture facture = hospitalisation.getFacture();
				formulaire.setDetailsFactureList(detailFactureDAO
						.findDetailFactureByFacture(facture));
				formulaire
						.setChambresHospList(chambresHospitalisationDAO
								.findChambresHospitalisationByHospitalisation(hospitalisation));
				formulaire.setDateSortie(UtilDate.getInstance().dateToString(
						hospitalisation.getDateSortie()));
			}

			Patient patient = formulaire.getPatient();
			if (patient != null) {
				formulaire.setPatientId(String.valueOf(patient.getPatientId()));
				formulaire.setNom(patient.getNom());
				formulaire.setPrenom(patient.getPrenom());
				formulaire.setAdresse(patient.getAdresse());
				formulaire.setCni(patient.getCni());
				formulaire.setDateNaissance(UtilDate.getInstance()
						.dateToString(patient.getDateNaissance()));

				formulaire.setDateDerniereVisite(UtilDate.getInstance()
						.dateToString(patient.getDateDerniereVisite()));
				formulaire.setDatePremiereVisite(UtilDate.getInstance()
						.dateToString(patient.getDatePremiereViste()));
				formulaire.setLieuNaissance(patient.getLieuNaissance());
				formulaire.setNni(patient.getNni());
				formulaire.setPriseEnChargeFlag(patient.getPriseEnChargeFlag());
				PatientPcActuel patientPcActuel = getPatientPcActuelDAO()
						.getPatientPcByPatient(patient);

				if (!formulaire.getPriseEnChargeFlag().equals("aucune")) {
					if (patientPcActuel != null) {
						if (patientPcActuel.getType().equals("badge")
								&& patientPcActuel.getBadge() != null) {
							formulaire.setNumeroBadge(patientPcActuel
									.getBadge().getNumeroBadge());
						} else {
							formulaire.setNumeroBadge("");
						}

						formulaire.setLibeleAssureur(patient.getCategorie()
								.getNomCategorie());
						formulaire.setCategorieId(String.valueOf(patient
								.getCategorie().getCategorieId()));
					}
				}

				formulaire.setTelephone(patient.getTelephone());

				result = true;

			}

		} catch (Exception e) {
			e.printStackTrace();
			log.fatal(e.getMessage());
		}

		finally {
			log.debug("********** Debut showHospInfosForSortie GestionCommercialeBO **********");
			return result;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see clinique.metier.gestion.commerciale.IGestionCommercialeBO#
	 * supprimerDetailDrgFromListeDetailDrgCnamFacture
	 * (clinique.model.gestion.commerciale.GestionCommercialeForm)
	 */
	@Override
	@SuppressWarnings({ "unchecked", "finally" })
	public boolean supprimerDetailDrgFromListeDetailDrgCnamFacture(
			GestionCommercialeForm formulaire) throws Exception {

		boolean result = false;
		log.debug("********** Debut supprimerDetailDrgFromListeDetailDrgCnamFacture GestionCommercialeBO **********");

		try {
			List detailDrgCnamFactureList = formulaire
					.getDetailDrgCnamListFacture();
			DetailDgrCnamFacture detail = new DetailDgrCnamFacture();
			int pourcentage = getCategorieDAO().getCategorie(
					Integer.parseInt(formulaire.getCategorieId()))
					.getPourcentage();

			for (Iterator iter = detailDrgCnamFactureList.iterator(); iter
					.hasNext();) {
				DetailDgrCnamFacture element = (DetailDgrCnamFacture) iter
						.next();

				if (element.getDetailDrgCnamId().equals(
						formulaire.getIdDetailDrgAsupprimer())) {
					detail = element;
				}
			}

			DrgCnam drg = detail.getDrgCnam();
			double montantDrg = drg.getMontant() * pourcentage / 100;
			double totalMontantDrg = 0;

			double cotePartAssureur;

			totalMontantDrg = Double.parseDouble(formulaire
					.getTotalMontantDrg()) - drg.getMontant();
			formulaire.setTotalMontantDrg(String.valueOf(totalMontantDrg));

			cotePartAssureur = Double.parseDouble(formulaire.getCoteAssureur())
					- montantDrg;
			formulaire.setCoteAssureur(String.valueOf(cotePartAssureur));

			double totalApayer = Double
					.parseDouble(formulaire.getTotalApayer());

			double resteApayer = totalApayer - cotePartAssureur;

			formulaire.setResteApayer(String.valueOf(resteApayer));

			System.out.println(" total a payer " + totalApayer);
			System.out.println(" total montant DRG " + totalMontantDrg);
			System.out.println(" cp Ass " + cotePartAssureur);
			System.out.println(" resteApayer " + resteApayer);

			detailDrgCnamFactureList.remove(detail);
			formulaire.setDetailDrgCnamListFacture(detailDrgCnamFactureList);

			result = true;

		} catch (Exception e) {

			e.printStackTrace();
			log.fatal(e.getMessage());

		}

		finally {
			log.debug("********** Fin supprimerDetailDrgFromListeDetailDrgCnamFacture GestionCommercialeBO **********");
			// SessionFactoryUtil.getInstance().close();
			return result;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see clinique.metier.gestion.commerciale.IGestionCommercialeBO#
	 * supprimerPrestFromListeDevis
	 * (clinique.model.gestion.commerciale.GestionCommercialeForm)
	 */
	@Override
	@SuppressWarnings({ "unchecked", "finally" })
	public boolean supprimerPrestFromListeDevis(
			GestionCommercialeForm formulaire) throws Exception {

		boolean result = false;
		log.debug("********** Debut supprimerPrestFromListeDevis GestionCommercialeBO **********");

		try {
			List actesDevisList = formulaire.getDevisActesList();
			DevisActes devis = new DevisActes();
			for (Iterator iter = actesDevisList.iterator(); iter.hasNext();) {
				DevisActes element = (DevisActes) iter.next();

				if (element.getDevisActesId().equals(
						formulaire.getIdPrestAsupprimer())) {
					devis = element;
				}
			}
			actesDevisList.remove(devis);
			formulaire.setDevisActesList(actesDevisList);

			double devisTotal = Double.valueOf(formulaire.getTotalDevis());
			devisTotal = devisTotal - devis.getTotal();

			formulaire.setTotalDevis(String.valueOf(devisTotal));

			result = true;

		} catch (Exception e) {

			e.printStackTrace();
			log.fatal(e.getMessage());

		}

		finally {
			log.debug("********** Fin supprimerPrestFromListeDevis GestionCommercialeBO **********");
			// SessionFactoryUtil.getInstance().close();
			return result;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see clinique.metier.gestion.commerciale.IGestionCommercialeBO#
	 * supprimerPrestFromListePrestCouvertes
	 * (clinique.model.gestion.commerciale.GestionCommercialeForm)
	 */
	@Override
	@SuppressWarnings({ "unchecked", "finally" })
	public boolean supprimerPrestFromListePrestCouvertes(
			GestionCommercialeForm formulaire) throws Exception {

		boolean result = false;
		log.debug("********** Debut ajouterActe GestionCommercialeBO **********");

		try {
			List prestCouvList = formulaire.getPrestationCouvertesPcs();
			PrestationCouvertesPc pcCouv = new PrestationCouvertesPc();
			for (Iterator iter = prestCouvList.iterator(); iter.hasNext();) {
				PrestationCouvertesPc element = (PrestationCouvertesPc) iter
						.next();

				if (element.getPresCouvId().equals(
						formulaire.getIdPrestAsupprimer())) {
					pcCouv = element;
				}
			}
			prestCouvList.remove(pcCouv);
			formulaire.setPrestationCouvertesPcs(prestCouvList);
			formulaire.setTypePcCouverte("famille");
			result = true;

		} catch (Exception e) {

			e.printStackTrace();
			log.fatal(e.getMessage());

		}

		finally {
			log.debug("********** Fin ajouterActe GestionCommercialeBO **********");
			return result;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see clinique.metier.gestion.commerciale.IGestionCommercialeBO#
	 * supprimerReglementFromListeReglement
	 * (clinique.model.gestion.commerciale.GestionCommercialeForm)
	 */
	@Override
	@SuppressWarnings({ "finally", "unchecked" })
	public boolean supprimerReglementFromListeReglement(
			GestionCommercialeForm formulaire) throws Exception {

		boolean result = false;
		log.debug("********** Debut supprimerReglementFromListeReglement GestionCommercialeBO **********");

		try {
			List reglementsList = formulaire.getReglementsList();
			Reglement reglement = new Reglement();
			double resteApayerMajoration = Double.parseDouble(formulaire
					.getResteApayerMajoration());
			double resteApayer = Double
					.parseDouble(formulaire.getResteApayer());

			for (Iterator iter = reglementsList.iterator(); iter.hasNext();) {
				Reglement element = (Reglement) iter.next();

				if (element.getReglementId().equals(
						formulaire.getIdReglementAsupprimer())) {
					reglement = element;
				}
			}

			if (reglement.getMajore().equals("0")) {
				resteApayer = resteApayer + reglement.getMontant();
				resteApayerMajoration = (1 + calculMajoration(formulaire))
						* resteApayer / 100;
				formulaire.setResteApayer(String.valueOf(resteApayer));
				formulaire.setResteApayerMajoration(String
						.valueOf(resteApayerMajoration));

				reglementsList.remove(reglement);
				formulaire.setReglementsList(reglementsList);
				formulaire.setRecuRegle("0");

			} else {
				resteApayerMajoration = resteApayerMajoration
						+ reglement.getMontant();
				resteApayer = 100 * resteApayerMajoration
						/ (100 + calculMajoration(formulaire));
				formulaire.setResteApayer(String.valueOf(resteApayer));
				formulaire.setResteApayerMajoration(String
						.valueOf(resteApayerMajoration));

				reglementsList.remove(reglement);
				formulaire.setReglementsList(reglementsList);
				formulaire.setRecuRegle("0");
			}

			result = true;

		} catch (Exception e) {

			e.printStackTrace();
			log.fatal(e.getMessage());

		}

		finally {
			log.debug("********** Fin supprimerReglementFromListeReglement GestionCommercialeBO **********");
			return result;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see clinique.metier.gestion.commerciale.IGestionCommercialeBO#
	 * supprimerReglementHospFromListeReglement
	 * (clinique.model.gestion.commerciale.GestionCommercialeForm)
	 */
	@Override
	@SuppressWarnings({ "finally", "unchecked" })
	public boolean supprimerReglementHospFromListeReglement(
			GestionCommercialeForm formulaire) throws Exception {

		boolean result = false;
		log.debug("********** Debut supprimerReglementHospFromListeReglement GestionCommercialeBO **********");
		// Session session=SessionFactoryUtil.getInstance().openSession();

		try {
			List reglementsList = formulaire.getReglementsList();
			Reglement reglement = new Reglement();
			// double
			// resteApayer=Double.parseDouble(formulaire.getResteApayer());
			double resteApayerMajoration = Double.parseDouble(formulaire
					.getResteApayerMajoration());
			// double dejapayer=Double.parseDouble(formulaire.getDejapaye());
			for (Iterator iter = reglementsList.iterator(); iter.hasNext();) {
				Reglement element = (Reglement) iter.next();

				if (element.getReglementId().equals(
						formulaire.getIdReglementAsupprimer())) {
					reglement = element;
				}
			}

			if (reglement.getTypePayement().getTypePayementId() == 1) {
				reglementsList.clear();
				if (ajouterActesHosp(formulaire)) {
					setSortie(formulaire);
					checkRemise(formulaire);
					setValeursResteApyerHosp(formulaire);
					initialiserCombosTypePyement(formulaire);
					initialiserCombosPcPersonnel(formulaire);
				}

			} else {
				resteApayerMajoration = resteApayerMajoration
						+ reglement.getMontant();
				formulaire.setResteApayerMajoration(String
						.valueOf(resteApayerMajoration));
				reglementsList.remove(reglement);
				formulaire.setReglementsList(reglementsList);
				formulaire.setRecuRegle("0");
			}

			result = true;

		} catch (Exception e) {

			e.printStackTrace();
			log.fatal(e.getMessage());

		}

		finally {
			// session.close();
			log.debug("********** Fin supprimerReglementHospFromListeReglement GestionCommercialeBO **********");
			// SessionFactoryUtil.getInstance().close();
			return result;
		}
	}

}
