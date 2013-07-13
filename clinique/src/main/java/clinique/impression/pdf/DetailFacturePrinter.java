package clinique.impression.pdf;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.apache.commons.collections.MultiHashMap;
import org.apache.commons.collections.MultiMap;
import org.apache.commons.lang.StringUtils;

import clinique.mapping.HasDetailFactureInfo;

public class DetailFacturePrinter {
	private String acteName;
	private int nbr;
	private double tarif;
	private boolean acte;
	private String medecin;
	private String infirmier;

	public static MultiMap groupDetailFatures(List<HasDetailFactureInfo> list) {
		MultiMap multimap = new MultiHashMap();
		for (HasDetailFactureInfo detailFacture : list) {
			multimap.put(detailFacture.getActe().getFamillePrestation()
					.getLibelle(), detailFacture);
		}
		return multimap;
	}

	public static List<DetailFacturePrinter> toDetailPrinter(
			List<HasDetailFactureInfo> list) {
		MultiMap groupDetailFatures = groupDetailFatures(list);
		return toDetailPrinter(groupDetailFatures);
	}

	public static List<DetailFacturePrinter> toDetailPrinter(MultiMap multiMap) {

		List<DetailFacturePrinter> list = new ArrayList<DetailFacturePrinter>();
		for (Object o : multiMap.keySet()) {
			Object value = multiMap.get(o);
			String s = (String) o;
			list.add(new DetailFacturePrinter(s));
			Collection<HasDetailFactureInfo> c = (Collection) value;
			for (HasDetailFactureInfo detailFacture : c) {
				list.add(new DetailFacturePrinter(detailFacture));
			}

		}
		return list;
	}

	public DetailFacturePrinter() {
	}

	public DetailFacturePrinter(HasDetailFactureInfo detailFacture) {
		acteName = detailFacture.getActe().getNomActe();
		nbr = detailFacture.getNbrActes();
		tarif = detailFacture.getMontantTotal();
		medecin = detailFacture.getMedecin() != null ? detailFacture
				.getMedecin().getNom() : "";
		infirmier = detailFacture.getInfirmier() != null ? detailFacture
				.getInfirmier().getNom() : "";
		acte = true;
	}

	public DetailFacturePrinter(String famillePrestation) {
		acteName = famillePrestation;
		acte = false;
	}

	public String toRecuString() {
		if (acte) {
			StringBuilder sb = new StringBuilder();
			sb.append(acteName);
			if (StringUtils.isNotEmpty(medecin)) {
				sb.append(" / ");
				sb.append(medecin);
			}
			if (StringUtils.isNotEmpty(infirmier)) {
				sb.append(" + ");
				sb.append(infirmier);
			}
			return sb.toString();
		}
		return acteName;
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

	public String getMedecin() {
		return medecin;
	}

	public void setMedecin(String medecin) {
		this.medecin = medecin;
	}

	public String getInfirmier() {
		return infirmier;
	}

	public void setInfirmier(String infirmier) {
		this.infirmier = infirmier;
	}

}
