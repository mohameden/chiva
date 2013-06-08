package clinique.impression.pdf;

import java.io.OutputStream;

public interface IRecuImpressionBO {
	String NAME = "IRecuImpressionBO";

	void imprimerPDF(String numFacture, String mention, String user,
			OutputStream out);

}