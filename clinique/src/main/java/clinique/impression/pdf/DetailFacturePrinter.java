package clinique.impression.pdf;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.apache.commons.collections.MultiHashMap;
import org.apache.commons.collections.MultiMap;

import clinique.mapping.DetailFacture;

public class DetailFacturePrinter {
	private String acteName;
	private int nbr;
	private double tarif;
	private boolean acte;

	public static MultiMap groupDetailFatures(List<DetailFacture> list) {
		MultiMap multimap = new MultiHashMap();
		for (DetailFacture detailFacture : list) {
			multimap.put(detailFacture.getActe().getFamillePrestation()
					.getLibelle(), detailFacture);
		}
		return multimap;
	}

	public static List<DetailFacturePrinter> toDetailPrinter(
			List<DetailFacture> list) {
		MultiMap groupDetailFatures = groupDetailFatures(list);
		return toDetailPrinter(groupDetailFatures);
	}

	public static List<DetailFacturePrinter> toDetailPrinter(MultiMap multiMap) {

		List<DetailFacturePrinter> list = new ArrayList<DetailFacturePrinter>();
		for (Object o : multiMap.keySet()) {
			Object value = multiMap.get(o);
			String s = (String) o;
			list.add(new DetailFacturePrinter(s));
			Collection<DetailFacture> c = (Collection) value;
			for (DetailFacture detailFacture : c) {
				list.add(new DetailFacturePrinter(detailFacture));
			}

		}
		return list;
	}

	public DetailFacturePrinter() {
	}

	public DetailFacturePrinter(DetailFacture detailFacture) {
		acteName = detailFacture.getActe().getNomActe();
		nbr = detailFacture.getNbrActes();
		tarif = detailFacture.getMontantTotal();
		acte = true;
	}

	public DetailFacturePrinter(String famillePrestation) {
		acteName = famillePrestation;
		acte = false;
	}

	public String getActeName() {
		return acteName;
	}

	public void setActeName(String acteName) {
		this.acteName = acteName;
	}

	public int getNbr() {
		return nbr;
	}

	public void setNbr(int nbr) {
		this.nbr = nbr;
	}

	public double getTarif() {
		return tarif;
	}

	public void setTarif(double tarif) {
		this.tarif = tarif;
	}

	public boolean isActe() {
		return acte;
	}

	public void setActe(boolean acte) {
		this.acte = acte;
	}

}
