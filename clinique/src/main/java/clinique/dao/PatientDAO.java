package clinique.dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import clinique.mapping.Patient;
import clinique.utils.UtilDate;

@Repository
public class PatientDAO extends CliniqueHibernateDaoSupport<Patient> {

	private static Logger log = Logger.getLogger(PatientDAO.class);

	public Patient getPatient(String patientId) {
		log.debug("********** Debut getPatient PatientDAO **********");
		try {
			Patient patient = null;
			Session session = getSession();
			patient = (Patient) session.get(Patient.class, patientId);
			return patient;
		} catch (Exception e) {
			e.printStackTrace();
			log.fatal(e.getMessage());
			return null;
		} finally {
			log.debug("********** Fin getPatient PatientDAO **********");
		}
	}

	public void savePatient(Patient patient) {
		log.debug("********** Debut savePatient PatientDAO **********");
		try {
			Session session = getSession();
			patient.setStatut(STATUT_VALIDE);
			session.save(patient);
		} catch (Exception e) {
			e.printStackTrace();
			log.fatal(e.getMessage());
		} finally {
			log.debug("********** Fin savePatient PatientDAO **********");
		}
	}

	public void updatePatient(Patient patient) {
		log.debug("********** Debut updatePatient PatientDAO **********");
		try {
			Session session = getSession();
			session.update(patient);
		} catch (Exception e) {
			e.printStackTrace();
			log.fatal(e.getMessage());
		} finally {
			log.debug("********** Fin updatePatient PatientDAO **********");
		}
	}

	public void deletePatient(Patient patient) {
		log.debug("********** Debut deletePatient PatientDAO **********");
		try {
			Session session = getSession();
			patient.setStatut(STATUT_SUPPRIME);
			session.update(patient);
		} catch (Exception e) {
			e.printStackTrace();
			log.fatal(e.getMessage());
		} finally {
			log.debug("********** Fin deletePatient PatientDAO **********");
		}
	}

	@SuppressWarnings({ "unchecked" })
	public List<Patient> listPatientsFactures() {
		log.debug("********** Debut listPatientsFactures PatientDAO **********");
		try {
			List<Patient> patientsFactures = null;
			Session session = getSession();
			String strQuery = "select distinct patient ";
			strQuery += "from Patient patient, Facture facture";
			strQuery += "where patient.patientId = facture.patient.patientId ";
			strQuery += "and patient.statut = " + STATUT_VALIDE;
			strQuery += " and facture.statut = " + STATUT_VALIDE;
			strQuery += " order by patient.patientId asc";
			org.hibernate.Query query = session.createQuery(strQuery);
			patientsFactures = query.list();
			return patientsFactures;
		} catch (Exception e) {
			e.printStackTrace();
			log.fatal(e.getMessage());
			return null;
		} finally {
			log.debug("********** Fin listPatientsFactures PatientDAO **********");
		}
	}

	@SuppressWarnings({ "unchecked" })
	public List<Patient> listPatientsDetailFactures() {
		log.debug("********** Debut listPatientsDetailFactures PatientDAO **********");
		try {
			List<Patient> patientsDetailFactures = null;
			Session session = getSession();
			String strQuery = "select distinct patient ";
			strQuery += "from Patient patient, Facture facture,DetailFacture detailFacture";
			strQuery += "where patient.patientId = facture.patient.patientId ";
			strQuery += "and facture.factureId = detailFacture.facture.factureId ";
			strQuery += "and patient.statut = " + STATUT_VALIDE;
			strQuery += " and facture.statut = " + STATUT_VALIDE;
			strQuery += " and detailFacture.statut = " + STATUT_VALIDE;
			strQuery += " order by patient.patientId asc";
			org.hibernate.Query query = session.createQuery(strQuery);
			patientsDetailFactures = query.list();
			return patientsDetailFactures;
		} catch (Exception e) {
			e.printStackTrace();
			log.fatal(e.getMessage());
			return null;
		} finally {
			log.debug("********** Fin listPatientsDetailFactures PatientDAO **********");
		}
	}

	@SuppressWarnings({ "unchecked" })
	public List<Patient> listPatients() {
		log.debug("********** Debut listPatients PatientDAO **********");
		try {
			List<Patient> patients = null;
			Session session = getSession();
			String strQuery = "select distinct patient ";
			strQuery += "from Patient patient";
			strQuery += "where patient.statut = " + STATUT_VALIDE;
			strQuery += " order by patient.patientId asc";
			org.hibernate.Query query = session.createQuery(strQuery);
			patients = query.list();
			return patients;
		} catch (Exception e) {
			e.printStackTrace();
			log.fatal(e.getMessage());
			return null;
		} finally {
			log.debug("********** Fin listPatients PatientDAO **********");
		}
	}

	@SuppressWarnings({ "unchecked" })
	public List<Patient> listPatientsSupprimes() {
		log.debug("********** Debut listPatientsSupprimes PatientDAO **********");
		try {
			List<Patient> patients = null;
			Session session = getSession();
			String strQuery = "select distinct patient ";
			strQuery += "from Patient patient";
			strQuery += "where patient.statut = " + STATUT_SUPPRIME;
			strQuery += " order by patient.patientId asc";
			org.hibernate.Query query = session.createQuery(strQuery);
			patients = query.list();
			return patients;
		} catch (Exception e) {
			e.printStackTrace();
			log.fatal(e.getMessage());
			return null;
		} finally {
			log.debug("********** Fin listPatientsSupprimes PatientDAO **********");
		}
	}

	@SuppressWarnings({ "unchecked" })
	public List<Patient> listPatientsRecherches(String patientId, String nom,
			String prenom, String dateNaissance, String dateDerniereVisite,
			String telephone, String cni, String nni, String numeroBadge) {
		log.debug("********** Debut listPatientsRecherches PatientDAO **********");
		try {
			boolean first = true;

			List<Patient> patients = null;
			Session session = getSession();
			String strQuery = "select distinct patient ";
			strQuery += "from Patient patient";

			// traitement patientId
			if (!UtilDate.getInstance().isVide(patientId)) {
				if (first) {
					strQuery += " where patient.patientId = "
							+ Integer.parseInt(patientId);
				} else {
					strQuery += " and patient.patientId = "
							+ Integer.parseInt(patientId);
				}
			}

			// traitement nom
			if (!UtilDate.getInstance().isVide(nom)) {
				if (first) {
					strQuery += " where patient.nom = '" + nom + "'";
				} else {
					strQuery += " and patient.nom = '" + nom + "'";
				}
			}

			// traitement prénom
			if (!UtilDate.getInstance().isVide(prenom)) {
				if (first) {
					strQuery += " where patient.prenom = '" + prenom + "'";
				} else {
					strQuery += " and patient.prenom = '" + prenom + "'";
				}
			}

			// traitement dateNaissance
			if (!UtilDate.getInstance().isVide(dateNaissance)) {
				if (first) {
					strQuery += " where patient.dateNaissance = '"
							+ UtilDate.getInstance().stringToDateMysql(
									dateNaissance) + "'";
				} else {
					strQuery += " and patient.dateNaissance = '"
							+ UtilDate.getInstance().stringToDateMysql(
									dateNaissance) + "'";
				}
			}

			// traitement dateDerniereViste
			if (!UtilDate.getInstance().isVide(dateDerniereVisite)) {
				if (first) {
					strQuery += " where patient.dateDerniereVisite = '"
							+ UtilDate.getInstance().stringToDateMysql(
									dateDerniereVisite) + "'";
				} else {
					strQuery += " and patient.dateDerniereVisite = '"
							+ UtilDate.getInstance().stringToDateMysql(
									dateDerniereVisite) + "'";
				}
			}

			// traitement telephone
			if (!UtilDate.getInstance().isVide(telephone)) {
				if (first) {
					strQuery += " where patient.telephone = '" + telephone
							+ "'";
				} else {
					strQuery += " and patient.telephone = '" + telephone + "'";
				}
			}

			// traitement cni
			if (!UtilDate.getInstance().isVide(cni)) {
				if (first) {
					strQuery += " where patient.cni = '" + cni + "'";
				} else {
					strQuery += " and patient.cni = '" + cni + "'";
				}
			}

			// traitement nni
			if (!UtilDate.getInstance().isVide(nni)) {
				if (first) {
					strQuery += " where patient.nni = '" + nni + "'";
				} else {
					strQuery += " and patient.nni = '" + nni + "'";
				}
			}

			// traitement numeroBadge
			if (!UtilDate.getInstance().isVide(numeroBadge)) {
				if (first) {
					strQuery += " where patient.numeroBadge = '" + numeroBadge
							+ "'";
				} else {
					strQuery += " and patient.numeroBadge = '" + numeroBadge
							+ "'";
				}
			}

			strQuery += " order by patient.patientId asc";
			org.hibernate.Query query = session.createQuery(strQuery);
			patients = query.list();
			return patients;
		} catch (Exception e) {
			e.printStackTrace();
			log.fatal(e.getMessage());
			return null;
		} finally {
			log.debug("********** Fin listPatientsRecherches PatientDAO **********");
		}
	}

	public void saveAndReturnPatient(Patient patient) {
		log.debug("********** Debut savePatient PatientDAO **********");
		try {
			Session session = getSession();
			patient.setStatut(STATUT_VALIDE);
			session.save(patient);
		} catch (Exception e) {
			e.printStackTrace();
			log.fatal(e.getMessage());
		} finally {
			log.debug("********** Fin savePatient PatientDAO **********");
		}
	}

	public int listPatientsByTelephone(String telephone) {
		log.debug("********** Debut listPatientsByTelephone PatientDAO **********");
		try {

			Session session = getSession();
			String strQuery = "select distinct patient ";
			strQuery += "from Patient patient";

			strQuery += " where patient.telephone = '" + telephone + "'";

			strQuery += " order by patient.patientId asc";
			org.hibernate.Query query = session.createQuery(strQuery);

			return query.list().size();
		} catch (Exception e) {
			e.printStackTrace();
			log.fatal(e.getMessage());
			return 0;
		} finally {
			log.debug("********** Fin listPatientsByTelephone PatientDAO **********");
		}
	}

	@Override
	protected Class<?> getEntityClass() {
		return Patient.class;
	}

}
