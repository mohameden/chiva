package clinique.mapping;

import java.util.Date;

public class DrgCnamH {
	
	private  String drgCnamHId;
	private  int numDrg;
	private  String nomDrg;
	private  double montant;
	private  String operateur;
	private  String statut;
	private  Date dateDebut;
	private  Date dateFin;
	private DrgCnam drgCnam;

	
	public String getNomDrg() {
		return nomDrg;
	}
	public void setNomDrg(String nomDrg) {
		this.nomDrg = nomDrg;
	}
	public double getMontant() {
		return montant;
	}
	public void setMontant(double montant) {
		this.montant = montant;
	}
	public String getOperateur() {
		return operateur;
	}
	public void setOperateur(String operateur) {
		this.operateur = operateur;
	}
	public String getStatut() {
		return statut;
	}
	public void setStatut(String statut) {
		this.statut = statut;
	}
	public Date getDateDebut() {
		return dateDebut;
	}
	public void setDateDebut(Date dateDebut) {
		this.dateDebut = dateDebut;
	}
	public Date getDateFin() {
		return dateFin;
	}
	public void setDateFin(Date dateFin) {
		this.dateFin = dateFin;
	}
	
	
	public DrgCnam getDrgCnam() {
		return drgCnam;
	}
	public void setDrgCnam(DrgCnam drgCnam) {
		this.drgCnam = drgCnam;
	}
	public String getDrgCnamHId() {
		return drgCnamHId;
	}
	public void setDrgCnamHId(String drgCnamHId) {
		this.drgCnamHId = drgCnamHId;
	}
	public int getNumDrg() {
		return numDrg;
	}
	public void setNumDrg(int numDrg) {
		this.numDrg = numDrg;
	}
	
	
	


}
