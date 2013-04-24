package clinique.mapping;


public class DevisActes {
	
	private  String devisActesId;
	private  double total;
    private double prix;
    private int nbre;

	
	private  String statut;
	private  String operateur;
	
	private Acte acte;
	private DevisAssureur devisAssureur;
	
	
	public String getDevisActesId() {
		return devisActesId;
	}
	public void setDevisActesId(String devisActesId) {
		this.devisActesId = devisActesId;
	}
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}
	public double getPrix() {
		return prix;
	}
	public void setPrix(double prix) {
		this.prix = prix;
	}
	public int getNbre() {
		return nbre;
	}
	public void setNbre(int nbre) {
		this.nbre = nbre;
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
	public DevisAssureur getDevisAssureur() {
		return devisAssureur;
	}
	public void setDevisAssureur(DevisAssureur devisAssureur) {
		this.devisAssureur = devisAssureur;
	}
	
	
}
