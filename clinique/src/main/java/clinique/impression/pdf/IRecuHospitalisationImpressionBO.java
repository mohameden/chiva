package clinique.impression.pdf;

import java.io.OutputStream;

public interface IRecuHospitalisationImpressionBO {
	String NAME = "IRecuHospitalisationImpressionBO";

	void imprimerPDF(String numFacture, String mention, String user,
			OutputStream out);

}