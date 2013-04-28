package clinique.mapping;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Chambre {
	
	private  int chambreId;
	private  String chambreNum;
	private  String chambreLibelle;
	private  double tarif;
	private  String etat;
	private  String statut;
	private  Date dateDebut;
	private  Date dateFin;
	
	
	private List <Hospitalisation> hospitalisations=new ArrayList<Hospitalisation>();
	private List <ChambresHospitalisation> chambresHospitalisation=new ArrayList<ChambresHospitalisation>();

	public List<Hospitalisation> getHospitalisations() {
		return hospitalisations;
	}
	public void setHospitalisations(List<Hospitalisation> hospitalisations) {
		this.hospitalisations = hospitalisations;
	}
	public int getChambreId() {
		return chambreId;
	}
	public void setChambreId(int chambreId) {
		this.chambreId = chambreId;
	}
	public String getChambreNum() {
		return chambreNum;
	}
	public void setChambreNum(String chambreNum) {
		this.chambreNum = chambreNum;
	}
	public String getChambreLibelle() {
		return chambreLibelle;
	}
	public void setChambreLibelle(String chambreLibelle) {
		this.chambreLibelle = chambreLibelle;
	}
	public double getTarif() {
		return tarif;
	}
	public void setTarif(double tarif) {
		this.tarif = tarif;
	}
	public String getEtat() {
		return etat;
	}
	public void setEtat(String etat) {
		this.etat = etat;
	}
	public String getStatut() {
		return statut;
	}
	public void setStatut(String statut) {
		this.statut = statut;
	}
	public List<ChambresHospitalisation> getChambresHospitalisation() {
		return chambresHospitalisation;
	}
	public void setChambresHospitalisation(
			List<ChambresHospitalisation> chambresHospitalisation) {
		this.chambresHospitalisation = chambresHospitalisation;
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
	
	


}
