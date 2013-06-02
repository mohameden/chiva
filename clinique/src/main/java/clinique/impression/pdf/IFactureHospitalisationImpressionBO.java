package clinique.impression.pdf;

import java.io.OutputStream;

public interface IFactureHospitalisationImpressionBO {
	String NAME = "IFactureHospitalisationImpressionBO";

	void imprimerPDF(String numFacture, String mention, String user,
			OutputStream out);

}