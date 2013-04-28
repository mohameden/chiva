package clinique.model.gestion.stock;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.apache.struts.action.ActionForm;

public class GestionStockForm extends ActionForm implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private  String fournisseurId ;
	private  String nomFournisseur;
	private  String adresseFournisseur;
	private  String telephone1Fournisseur ;
	private  String telephone2Fournisseur ;
	private  String statut ;
	private  String operateur ;
	private  String estEffWithSuccess ;
	private  String produitId ;
	private  String nomProduit;
	private  String prixProduit;
	private  String quantiteDisponibleProduit ;
	private  String seuilMinimumProduit ;
	private  String classeId;
	private  String dateStockEntree ;
	private  String dateStockSortie ;
	private  String quantiteStockEntrante ;
	private  String quantiteStockSortie ;
	private  String prixUnitaireAchat ;
	private  String numeroDestinataire ;
	private  String numeroSource ;
	private  String entreeStockId ;
	private ArrayList fournisseursList;
	private ArrayList produitsList;
	private ArrayList classesList;
	private Collection journalStockList;
	private String dispatch;
	private String facturable="0";
	private String facturableCheckBox;

	
	public String getNomFournisseur() {
		return nomFournisseur;
	}
	public void setNomFournisseur(String nomFournisseur) {
		this.nomFournisseur = nomFournisseur;
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
	public String getEstEffWithSuccess() {
		return estEffWithSuccess;
	}
	public void setEstEffWithSuccess(String estEffWithSuccess) {
		this.estEffWithSuccess = estEffWithSuccess;
	}
	public String getAdresseFournisseur() {
		return adresseFournisseur;
	}
	public void setAdresseFournisseur(String adresseFournisseur) {
		this.adresseFournisseur = adresseFournisseur;
	}
	public String getNomProduit() {
		return nomProduit;
	}
	public void setNomProduit(String nomProduit) {
		this.nomProduit = nomProduit;
	}
	public String getFournisseurId() {
		return fournisseurId;
	}
	public void setFournisseurId(String fournisseurId) {
		this.fournisseurId = fournisseurId;
	}
	public String getTelephone1Fournisseur() {
		return telephone1Fournisseur;
	}
	public void setTelephone1Fournisseur(String telephone1Fournisseur) {
		this.telephone1Fournisseur = telephone1Fournisseur;
	}
	public String getTelephone2Fournisseur() {
		return telephone2Fournisseur;
	}
	public void setTelephone2Fournisseur(String telephone2Fournisseur) {
		this.telephone2Fournisseur = telephone2Fournisseur;
	}
	public String getProduitId() {
		return produitId;
	}
	public void setProduitId(String produitId) {
		this.produitId = produitId;
	}
	public String getPrixProduit() {
		return prixProduit;
	}
	public void setPrixProduit(String prixProduit) {
		this.prixProduit = prixProduit;
	}
	public String getQuantiteDisponibleProduit() {
		return quantiteDisponibleProduit;
	}
	public void setQuantiteDisponibleProduit(String quantiteDisponibleProduit) {
		this.quantiteDisponibleProduit = quantiteDisponibleProduit;
	}
	public String getSeuilMinimumProduit() {
		return seuilMinimumProduit;
	}
	public void setSeuilMinimumProduit(String seuilMinimumProduit) {
		this.seuilMinimumProduit = seuilMinimumProduit;
	}
	public String getClasseId() {
		return classeId;
	}
	public void setClasseId(String classeId) {
		this.classeId = classeId;
	}
	public String getDateStockEntree() {
		return dateStockEntree;
	}
	public void setDateStockEntree(String dateStockEntree) {
		this.dateStockEntree = dateStockEntree;
	}
	public String getQuantiteStockEntrante() {
		return quantiteStockEntrante;
	}
	public void setQuantiteStockEntrante(String quantiteStockEntrante) {
		this.quantiteStockEntrante = quantiteStockEntrante;
	}
	public String getPrixUnitaireAchat() {
		return prixUnitaireAchat;
	}
	public void setPrixUnitaireAchat(String prixUnitaireAchat) {
		this.prixUnitaireAchat = prixUnitaireAchat;
	}
	public String getNumeroDestinataire() {
		return numeroDestinataire;
	}
	public void setNumeroDestinataire(String numeroDestinataire) {
		this.numeroDestinataire = numeroDestinataire;
	}
	public String getNumeroSource() {
		return numeroSource;
	}
	public void setNumeroSource(String numeroSource) {
		this.numeroSource = numeroSource;
	}
	public String getEntreeStockId() {
		return entreeStockId;
	}
	public void setEntreeStockId(String entreeStockId) {
		this.entreeStockId = entreeStockId;
	}
	public String getDateStockSortie() {
		return dateStockSortie;
	}
	public void setDateStockESortie(String dateStockSortie) {
		this.dateStockSortie = dateStockSortie;
	}
	public String getQuantiteStockSortie() {
		return quantiteStockSortie;
	}
	public void setQuantiteStockSortie(String quantiteStockSortie) {
		this.quantiteStockSortie = quantiteStockSortie;
	}
	public ArrayList getFournisseursList() {
		return fournisseursList;
	}
	public void setFournisseursList(ArrayList fournisseursList) {
		this.fournisseursList = fournisseursList;
	}
	public ArrayList getProduitsList() {
		return produitsList;
	}
	public void setProduitsList(ArrayList produitsList) {
		this.produitsList = produitsList;
	}
	public ArrayList getClassesList() {
		return classesList;
	}
	public void setClassesList(ArrayList classesList) {
		this.classesList = classesList;
	}
	public String getDispatch() {
		return dispatch;
	}
	public void setDispatch(String dispatch) {
		this.dispatch = dispatch;
	}
	public String getFacturable() {
		return facturable;
	}
	public void setFacturable(String facturable) {
		this.facturable = facturable;
	}
	public String getFacturableCheckBox() {
		return facturableCheckBox;
	}
	public void setFacturableCheckBox(String facturableCheckBox) {
		this.facturableCheckBox = facturableCheckBox;
	}
	public void setDateStockSortie(String dateStockSortie) {
		this.dateStockSortie = dateStockSortie;
	}
	public Collection getJournalStockList() {
		return journalStockList;
	}
	public void setJournalStockList(Collection journalStockList) {
		this.journalStockList = journalStockList;
	}
	
}
