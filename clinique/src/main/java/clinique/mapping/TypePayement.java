package clinique.mapping;

import java.util.ArrayList;
import java.util.List;

public class TypePayement {
	
	private  int typePayementId;
	private  String typePayement;
	private  String statut;
	private  String operateur;
	
	private List <Reglement> reglements=new ArrayList<Reglement>();

	public int getTypePayementId() {
		return typePayementId;
	}
	public void setTypePayementId(int typePayementId) {
		this.typePayementId = typePayementId;
	}
	public String getTypePayement() {
		return typePayement;
	}
	public void setTypePayement(String typePayement) {
		this.typePayement = typePayement;
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
	public List<Reglement> getReglements() {
		return reglements;
	}
	public void setReglements(List<Reglement> reglements) {
		this.reglements = reglements;
	}
	
	


}
