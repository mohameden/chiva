package clinique.mapping;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Recu {
	
	private  String recuId;
	private  Date dateRecu;
	private  String statut;
	private  String operateur;
	private double total;
	
	
	private Facture facture;
	private List <DetailFacture> detailFactures=new ArrayList<DetailFacture>();
	private Reglement reglement;



	public Date getDateRecu() {
		return dateRecu;
	}

	public void setDateRecu(Date dateRecu) {
		this.dateRecu = dateRecu;
	}

	public String getStatut() {
		return statut;
	}

	public void setStatut(String statut) {
		this.statut = statut;
	}

	public String getOperateur() {
		return operateur;
	}

	public void setOperateur(String operateur) {
		this.operateur = operateur;
	}


	public Facture getFacture() {
		return facture;
	}

	public void setFacture(Facture facture) {
		this.facture = facture;
	}

	public List<DetailFacture> getDetailFactures() {
		return detailFactures;
	}

	public void setDetailFactures(List<DetailFacture> detailFactures) {
		this.detailFactures = detailFactures;
	}

	public String getRecuId() {
		return recuId;
	}

	public void setRecuId(String recuId) {
		this.recuId = recuId;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public Reglement getReglement() {
		return reglement;
	}

	public void setReglement(Reglement reglement) {
		this.reglement = reglement;
	}





}
