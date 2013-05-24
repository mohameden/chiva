package clinique.impression;

public interface IImpressionBO {

	public static final String NAME = "IImpressionBO";

	public byte[] genererFacture(String numFacture, String mention);

	public byte[] genererRecu(String numRecu, String mention);

	public byte[] genererFactureHosp(String numFacture, String mention);

	public byte[] genererDevisAssureur(String numDevis, String mention);

}