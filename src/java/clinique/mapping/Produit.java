package clinique.mapping;

public class Produit {
	
	private  int produitId ;
	private  String nomProduit;
	private  String facturable ;
	private  double prix;
	private  int quantiteDisponible ;
	private  int seuilMinimum ;
	private  String statut ;
	private  String operateur ;

	private Classe classe;
	private Acte acte;
	
	public int getProduitId() {
		return produitId;
	}

	public void setProduitId(int produitId) {
		this.produitId = produitId;
	}

	public String getNomProduit() {
		return nomProduit;
	}

	public void setNomProduit(String nomProduit) {
		this.nomProduit = nomProduit;
	}

	public double getPrix() {
		return prix;
	}
	public String getFacturable() {
		return facturable;
	}

	public void setFacturable(String facturable) {
		this.facturable = facturable;
	}
	public void setPrix(double prix) {
		this.prix = prix;
	}

	public int getQuantiteDisponible() {
		return quantiteDisponible;
	}

	public void setQuantiteDisponible(int quantiteDisponible) {
		this.quantiteDisponible = quantiteDisponible;
	}

	public int getSeuilMinimum() {
		return seuilMinimum;
	}

	public void setSeuilMinimum(int seuilMinimum) {
		this.seuilMinimum = seuilMinimum;
	}

	public Classe getClasse() {
		return classe;
	}

	public void setClasse(Classe classe) {
		this.classe = classe;
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

	public Acte getActe() {
		return acte;
	}

	public void setActe(Acte acte) {
		this.acte = acte;
	}
	
	

	
	

}
