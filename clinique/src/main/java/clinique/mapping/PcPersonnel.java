package clinique.mapping;

import java.util.ArrayList;
import java.util.List;



public class PcPersonnel {
	
	private  int pcPersonnelId ;
	private  String pcNom;
	
	
	private  String statut;
	private  String operateur;
	
	private Compte compte;
	private List <Reglement> reglements=new ArrayList<Reglement>();
	
	public int getPcPersonnelId() {
		return pcPersonnelId;
	}
	public void setPcPersonnelId(int pcPersonnelId) {
		this.pcPersonnelId = pcPersonnelId;
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
	
	public String getPcNom() {
		return pcNom;
	}
	public void setPcNom(String pcNom) {
		this.pcNom = pcNom;
	}
	public List<Reglement> getReglements() {
		return reglements;
	}
	public void setReglements(List<Reglement> reglements) {
		this.reglements = reglements;
	}
	public Compte getCompte() {
		return compte;
	}
	public void setCompte(Compte compte) {
		this.compte = compte;
	}
	
	
	
	
}
