package clinique.impression.pdf;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

import clinique.mapping.DetailFacture;
import clinique.mapping.HasDetailFactureInfo;
import clinique.mapping.Hospitalisation;

public class HospitalisationPrinter {
	private String chambre;
	private Date dateEntree;
	private Date dateSortie;

	private static class PrinterComparator implements
			Comparator<HospitalisationPrinter> {

		@Override
		public int compare(HospitalisationPrinter o1, HospitalisationPrinter o2) {
			if (o1 == null) {
				return 1;
			}
			if (o2 == null) {
				return -1;
			}
			int chambreCompare = o1.chambre.compareTo(o2.chambre);
			if (chambreCompare == 0) {
				int entreeCompare = o1.dateEntree.compareTo(o2.dateEntree);
				if (entreeCompare == 0) {
					return o1.dateSortie.compareTo(o2.dateSortie);
				} else {
					return entreeCompare;
				}
			}
			return chambreCompare;
		}
	}

	public static List<HospitalisationPrinter> toHospitalisationPrinter(
			List<DetailFacture> list) {

		List<HospitalisationPrinter> result = new ArrayList<HospitalisationPrinter>();
		for (HasDetailFactureInfo detailFacture : list) {
			result.add(new HospitalisationPrinter(detailFacture));
		}
		Collections.sort(result, new PrinterComparator());
		return result;
	}

	public HospitalisationPrinter() {
	}

	public HospitalisationPrinter(HasDetailFactureInfo detailFacture) {
		Hospitalisation hospitalisation = detailFacture.getHospitalisation();
		if (hospitalisation != null) {
			chambre = hospitalisation.getChambre().getChambreLibelle();
			dateEntree = hospitalisation.getDateEntree();
			dateSortie = hospitalisation.getDateSortie();
		}
	}

	public String getChambre() {
		return chambre;
	}

	public void setChambre(String chambre) {
		this.chambre = chambre;
	}

	public Date getDateEntree() {
		return dateEntree;
	}

	public void setDateEntree(Date dateEntree) {
		this.dateEntree = dateEntree;
	}

	public Date getDateSortie() {
		return dateSortie;
	}

	public void setDateSortie(Date dateSortie) {
		this.dateSortie = dateSortie;
	}

}
