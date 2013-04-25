package clinique.mapping;

import java.util.ArrayList;
import java.util.List;

public class FamillePrestation {
	
	private  int famillePrestationId;
	private  String libelle;
	private  String statut;
	private  String operateur;
	private List <Acte> actes=new ArrayList<Acte>();
	
	
	private List <PrestationCouvertesPc> prestationCouvertesPcs=new ArrayList<PrestationCouvertesPc>();

	
	public String getLibelle() {
		return libelle;
	}
	public void setLibelle(String libelle) {
		this.libelle = libelle;
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
	
	public List<PrestationCouvertesPc> getPrestationCouvertesPcs() {
		return prestationCouvertesPcs;
	}
	public void setPrestationCouvertesPcs(
			List<PrestationCouvertesPc> prestationCouvertesPcs) {
		this.prestationCouvertesPcs = prestationCouvertesPcs;
	}
	public int getFamillePrestationId() {
		return famillePrestationId;
	}
	public void setFamillePrestationId(int famillePrestationId) {
		this.famillePrestationId = famillePrestationId;
	}
	public List<Acte> getActes() {
		return actes;
	}
	public void setActes(List<Acte> actes) {
		this.actes = actes;
	}
	
	


}
