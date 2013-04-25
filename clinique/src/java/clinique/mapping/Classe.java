package clinique.mapping;

import java.util.ArrayList;
import java.util.List;

public class Classe {
	
	private  int classeId;
	private  String nomClasse;
	private  int qpc;
	private  String statut;
	private  String operateur;
	
	
	
	private List <Acte> actes=new ArrayList<Acte>();
	private List <PrestationCouvertesPc> prestationCouvertesPcs=new ArrayList<PrestationCouvertesPc>();

	public int getClasseId() {
		return classeId;
	}
	public void setClasseId(int classeId) {
		this.classeId = classeId;
	}
	public String getNomClasse() {
		return nomClasse;
	}
	public void setNomClasse(String nomClasse) {
		this.nomClasse = nomClasse;
	}
	public int getQpc() {
		return qpc;
	}
	public void setQpc(int qpc) {
		this.qpc = qpc;
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
	public List<Acte> getActes() {
		return actes;
	}
	
	public void setActes(List<Acte> actes) {
		this.actes = actes;
	}
	public List<PrestationCouvertesPc> getPrestationCouvertesPcs() {
		return prestationCouvertesPcs;
	}
	public void setPrestationCouvertesPcs(
			List<PrestationCouvertesPc> prestationCouvertesPcs) {
		this.prestationCouvertesPcs = prestationCouvertesPcs;
	}
	
	


}
