package clinique.mapping;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class Categorie {
	
	private  int categorieId;
	private  String nomCategorie;
	private  int pourcentage;
	private  String statut;
	private  String operateur;
	private  Date datedebutAssurance;
	private  Date datefinAssurance;
	private int majoration;
	private String prefixeFacture;

	private Entreprise entreprise;
	private List <BlackListe> blackListes=new ArrayList<BlackListe>();
	private List <Reglement> reglements=new ArrayList<Reglement>();
	
    public int getPourcentage() {
		return pourcentage;
	}
	public String getNomCategorie() {
		return nomCategorie;
	}
	public void setNomCategorie(String nomCategorie) {
		this.nomCategorie = nomCategorie;
	}
	public void setPourcentage(int pourcentage) {
		this.pourcentage = pourcentage;
	}
	public String getStatut() {
		return statut;
	}
	public void setStatut(String statut) {
		this.statut = statut;
	}
	public Entreprise getEntreprise() {
		return entreprise;
	}
	public void setEntreprise(Entreprise entreprise) {
		this.entreprise = entreprise;
	}
	public int getCategorieId() {
		return categorieId;
	}
	public String getOperateur() {
		return operateur;
	}
	public void setOperateur(String operateur) {
		this.operateur = operateur;
	}
	public void setCategorieId(int categorieId) {
		this.categorieId = categorieId;
	}
	public List<BlackListe> getBlackListes() {
		return blackListes;
	}
	public void setBlackListes(List<BlackListe> blackListes) {
		this.blackListes = blackListes;
	}
	public List<Reglement> getReglements() {
		return reglements;
	}
	public void setReglements(List<Reglement> reglements) {
		this.reglements = reglements;
	}
	public Date getDatedebutAssurance() {
		return datedebutAssurance;
	}
	public void setDatedebutAssurance(Date datedebutAssurance) {
		this.datedebutAssurance = datedebutAssurance;
	}
	public Date getDatefinAssurance() {
		return datefinAssurance;
	}
	public void setDatefinAssurance(Date datefinAssurance) {
		this.datefinAssurance = datefinAssurance;
	}
	public int getMajoration() {
		return majoration;
	}
	public void setMajoration(int majoration) {
		this.majoration = majoration;
	}
	public String getPrefixeFacture() {
		return prefixeFacture;
	}
	public void setPrefixeFacture(String prefixeFacture) {
		this.prefixeFacture = prefixeFacture;
	}
	
	


}
