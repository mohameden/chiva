package clinique.mapping;

import java.util.ArrayList;
import java.util.List;

public class Acteur {
	
	private  int acteurId;
	private  String nom;
	private  String designation;
	private  String assistant;
	private  String telephone;
	private  String email;
	private  String statut;
	private  String operateur;
	
	
	
	private List <ActeurActe> acteurActes=new ArrayList<ActeurActe>();
	

	public int getActeurId() {
		return acteurId;
	}
	public void setActeurId(int acteurId) {
		this.acteurId = acteurId;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
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
	public List<ActeurActe> getActeurActes() {
		return acteurActes;
	}
	
	public void setActeurActes(List<ActeurActe> acteurActes) {
		this.acteurActes = acteurActes;
	}
	public String getAssistant() {
		return assistant;
	}
	public void setAssistant(String assistant) {
		this.assistant = assistant;
	}
	
	
	
	
	}
