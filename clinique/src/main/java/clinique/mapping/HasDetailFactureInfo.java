package clinique.mapping;

public interface HasDetailFactureInfo {

	 int getNbrActes();

	 Acte getActe();

	 Hospitalisation getHospitalisation();

	 double getMontantTotal();

	 Facture getFacture();

	Acteur getMedecin();

	Acteur getInfirmier();

}