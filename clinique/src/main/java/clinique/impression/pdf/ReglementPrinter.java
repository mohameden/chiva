package clinique.impression.pdf;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import clinique.mapping.Reglement;

public class ReglementPrinter {
	private String modeReglement;
	private String description;
	private Date dateReglement;
	private double montant;
	private String drg;

	public static List<ReglementPrinter> toReglementPrinter(List<Reglement> list) {
		List<ReglementPrinter> result = new ArrayList<ReglementPrinter>();
		for (Reglement reglement : list) {
			result.add(new ReglementPrinter(reglement));
		}
		return result;
	}

	public ReglementPrinter() {
	}

	public ReglementPrinter(Reglement reglement) {
		modeReglement = reglement.getTypePayement().getTypePayement();
		description = reglement.getDescription();
		dateReglement = reglement.getDateReglement();
		montant = reglement.getMontant();
		drg = reglement.getDrgCnam() != null ? reglement.getDrgCnam()
				.getNomDrg() : "";
	}

	public String getModeReglement() {
		return modeReglement;
	}

	public void setModeReglement(String modeReglement) {
		this.modeReglement = modeReglement;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getDateReglement() {
		return dateReglement;
	}

	public void setDateReglement(Date dateReglement) {
		this.dateReglement = dateReglement;
	}

	public double getMontant() {
		return montant;
	}

	public void setMontant(double montant) {
		this.montant = montant;
	}

	public String getDrg() {
		return drg;
	}

	public void setDrg(String drg) {
		this.drg = drg;
	}

}
