package clinique.mapping;

public class PrestationCouvertesPc {
	
	private  String presCouvId;
	private  String statut;
	private  String operateur;
	private String type;
	private String libelle;
	private String limite;
	private int nbreActes;
	private int nbreActesRestant;
	
	private PriseEnCharge priseEnCharge;
	private Classe classe;
	private FamillePrestation famille;
	private Acte acte;
	

	public String getStatut() {
		return statut;
	}
	public PriseEnCharge getPriseEnCharge() {
		return priseEnCharge;
	}
	public void setPriseEnCharge(PriseEnCharge priseEnCharge) {
		this.priseEnCharge = priseEnCharge;
	}
	public Classe getClasse() {
		return classe;
	}
	public void setClasse(Classe classe) {
		this.classe = classe;
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
	public String getPresCouvId() {
		return presCouvId;
	}
	public void setPresCouvId(String presCouvId) {
		this.presCouvId = presCouvId;
	}
	public FamillePrestation getFamille() {
		return famille;
	}
	public void setFamille(FamillePrestation famille) {
		this.famille = famille;
	}
	public Acte getActe() {
		return acte;
	}
	public void setActe(Acte acte) {
		this.acte = acte;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getLibelle() {
		return libelle;
	}
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	public String getLimite() {
		return limite;
	}
	public void setLimite(String limite) {
		this.limite = limite;
	}
	public int getNbreActes() {
		return nbreActes;
	}
	public void setNbreActes(int nbreActes) {
		this.nbreActes = nbreActes;
	}
	public int getNbreActesRestant() {
		return nbreActesRestant;
	}
	public void setNbreActesRestant(int nbreActesRestant) {
		this.nbreActesRestant = nbreActesRestant;
	}
	
	


}
