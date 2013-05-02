package clinique.impression;

public interface IImpressionBO {

	public static final String NAME = "IImpressionBO";

	/**** Impression d'une facture ****/
	public abstract byte[] genererFacture(String numFacture, String mention);

	/**** Impression d'un reçu ****/
	public abstract byte[] genererRecu(String numRecu, String mention);

	/**** Impression d'une facture dans le cas d'hospitalisation ****/
	public abstract byte[] genererFactureHosp(String numFacture, String mention);

	public abstract byte[] genererDevisAssureur(String numDevis, String mention);

}