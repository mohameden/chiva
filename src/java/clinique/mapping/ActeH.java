package clinique.mapping;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ActeH {
	
	private  String acteHId ;
	private  Acte acte ;
	private  String nomActe;
	private  double prix;
	private  double prixUrg;
	private  double prixDepl;
	private  int pck;
	private  String coef;
	private  int tauxPraticien;
	private  int tauxAssistant;
	private  int tauxPraticienUrg;
	private  int tauxAssistantUrg;
	private  int tauxDepAssistant;
	private  String statut;
	private  String operateur;
	private String reductible;
	private  Date dateDebut;
	private  Date dateFin;
	
	private Classe classe;
	private FamillePrestation famillePrestation;
	
	
	
	public String getNomActe() {
		return nomActe;
	}
	public void setNomActe(String nomActe) {
		this.nomActe = nomActe;
	}
	public double getPrix() {
		return prix;
	}
	public void setPrix(double prix) {
		this.prix = prix;
	}
	public double getPrixUrg() {
		return prixUrg;
	}
	public void setPrixUrg(double prixUrg) {
		this.prixUrg = prixUrg;
	}
	public double getPrixDepl() {
		return prixDepl;
	}
	public void setPrixDepl(double prixDepl) {
		this.prixDepl = prixDepl;
	}
	public int getPck() {
		return pck;
	}
	public void setPck(int pck) {
		this.pck = pck;
	}

	public int getTauxPraticien() {
		return tauxPraticien;
	}
	public void setTauxPraticien(int tauxPraticien) {
		this.tauxPraticien = tauxPraticien;
	}
	public int getTauxAssistant() {
		return tauxAssistant;
	}
	public void setTauxAssistant(int tauxAssistant) {
		this.tauxAssistant = tauxAssistant;
	}
	public int getTauxPraticienUrg() {
		return tauxPraticienUrg;
	}
	public void setTauxPraticienUrg(int tauxPraticienUrg) {
		this.tauxPraticienUrg = tauxPraticienUrg;
	}
	public int getTauxAssistantUrg() {
		return tauxAssistantUrg;
	}
	public void setTauxAssistantUrg(int tauxAssistantUrg) {
		this.tauxAssistantUrg = tauxAssistantUrg;
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
	public Classe getClasse() {
		return classe;
	}
	public void setClasse(Classe classe) {
		this.classe = classe;
	}

	
	public FamillePrestation getFamillePrestation() {
		return famillePrestation;
	}
	public void setFamillePrestation(FamillePrestation famillePrestation) {
		this.famillePrestation = famillePrestation;
	}
	public int getTauxDepAssistant() {
		return tauxDepAssistant;
	}
	public void setTauxDepAssistant(int tauxDepAssistant) {
		this.tauxDepAssistant = tauxDepAssistant;
	}
	public String getReductible() {
		return reductible;
	}
	public void setReductible(String reductible) {
		this.reductible = reductible;
	}
	public String getCoef() {
		return coef;
	}
	public void setCoef(String coef) {
		this.coef = coef;
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
	public String getActeHId() {
		return acteHId;
	}
	public void setActeHId(String acteHId) {
		this.acteHId = acteHId;
	}
	public Acte getActe() {
		return acte;
	}
	public void setActe(Acte acte) {
		this.acte = acte;
	}
	

}
