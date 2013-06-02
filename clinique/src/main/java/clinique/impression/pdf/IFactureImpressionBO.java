package clinique.impression.pdf;

import java.io.OutputStream;

public interface IFactureImpressionBO {
	String NAME = "IFactureImpressionBO";

	void imprimerPDF(String numFacture, String mention, String user,
			OutputStream out);

}