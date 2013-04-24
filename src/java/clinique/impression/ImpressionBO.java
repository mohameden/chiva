

package clinique.impression;



import java.awt.Desktop;






import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;

import org.apache.log4j.Logger;
import org.hibernate.Session;

import clinique.dao.DevisAssureurDAO;
import clinique.dao.FactureDAO;
import clinique.dao.SessionFactoryUtil;

import clinique.dao.RecuDAO;

import clinique.mapping.DevisAssureur;
import clinique.mapping.Facture;
import clinique.mapping.Patient;
import clinique.mapping.Recu;
import clinique.servlets.InitServlet;

import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;

import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;


public class ImpressionBO {
	
	private static Logger log = Logger.getLogger(ImpressionBO.class);
	private static final ImpressionBO INSTANCE = new ImpressionBO();

	public static ImpressionBO getInstance() {
		  return INSTANCE;
		 }

	private ImpressionBO () {}
	
	/**** Impression d'une facture ****/
@SuppressWarnings("deprecation")
public byte[] genererFacture(String numFacture,String mention){
	log.debug("********** Debut genererFacture ImpressionBO **********");
	        
	        
	        byte[] bytes;
	

	        java.util.HashMap<String, String> params = new  java.util.HashMap<String, String>();

	        Facture facture=FactureDAO.getInstance().getFacture(numFacture);
	        if (facture!=null) 
	        {
		        Patient patient=facture.getPatient();
		       
		        params.put("num_fact",String.valueOf(numFacture));
		        params.put("mention",mention);
		        params.put("numero_patient",patient.getPatientId()); 
		        params.put("nom_prenom",patient.getPrenom()+" "+patient.getNom());     
		        params.put("date_facture",facture.getDateFact().toString());
		        params.put("total_ht",String.valueOf(facture.getTotalHT()));
		        params.put("total_tva",String.valueOf(facture.getTotalTva()));
		        params.put("total_ttc",String.valueOf(facture.getTotalHT()+facture.getTotalTva()));
		        params.put("taux_remise_qpc",String.valueOf(facture.getTauxRemise()));
		        params.put("taux_remise_cash",String.valueOf(facture.getTauxMajoration()));
		        params.put("montant_remise",String.valueOf(facture.getRemise()+facture.getRemiseCash()));
		        params.put("avance",String.valueOf(facture.getAvance()));
		        params.put("net_a_payer",String.valueOf(facture.getNetApayer()));
		        params.put("op_impression",String.valueOf(facture.getOperateur()));
	        }
	        //params.put("net_a_payer",""+(facture.getTotalHT()+facture.getTotalTva()-facture.getRemise() -facture.getAvance()));
	        params.put("SUBREPORT_DIR",InitServlet.CHEMIN_ROOT+"\\reports\\");
	        params.put("logo_path",InitServlet.CHEMIN_ROOT+"\\images\\logo.jpg");
	        
	        

	        
	        
	        
	   
			try{

			     JasperDesign jasperDesign_reg = JRXmlLoader.load(InitServlet.CHEMIN_ROOT+"\\reports\\facture_reglement.jrxml");
			   
				 JasperCompileManager.compileReportToFile(jasperDesign_reg,InitServlet.CHEMIN_ROOT+"\\reports\\facture_reglement.jasper");
			     
			     
			  	 Session session = SessionFactoryUtil.getInstance().openSession();
				 Connection con =session.connection();
			  
			     JasperDesign jasperDesign = JRXmlLoader.load(InitServlet.CHEMIN_ROOT+"\\reports\\facture.jrxml");
			     JasperReport jasperReport = JasperCompileManager.compileReport(jasperDesign);
			     JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport,params,con);
			     
//			     JasperExportManager.exportReportToPdfFile(jasperPrint,InitServlet.CHEMIN_ROOT+"\\reports\\facture.pdf");
//			     
//			     Desktop desktop = Desktop.getDesktop();
//			    
//			     
//			     desktop.open(new File(InitServlet.CHEMIN_ROOT+"\\reports\\facture.pdf"));
			     
			     bytes=JasperExportManager.exportReportToPdf(jasperPrint);
			     con.close();
			     


	            
			
			}catch(Exception ex)
		       {
				log.fatal(ex.getMessage());
				bytes=null;
		       }
			
			
		log.debug("********** fin genererFacture ImpressionBO **********");
		return bytes;

}


/**** Impression d'un reçu ****/
@SuppressWarnings("deprecation")
public byte[] genererRecu(String numRecu,String mention){
	log.debug("********** Debut genererRecu ImpressionBO **********");
	        
	
	        byte[] bytes;

	        java.util.HashMap<String, String> params = new  java.util.HashMap<String, String>();

	        Recu recu=RecuDAO.getInstance().getRecu(numRecu);
	        Facture facture=recu.getFacture();
	        Patient patient=facture.getPatient();
	        
	        params.put("num_recu",numRecu);
	        params.put("mention",mention);
	        params.put("numero_patient",patient.getPatientId()); 
	        params.put("nom_prenom",patient.getPrenom()+" "+patient.getNom());     
	        params.put("date_recu",recu.getDateRecu().toString());
	        params.put("total",String.valueOf(recu.getTotal()));
	        params.put("op_impression",String.valueOf(recu.getOperateur()));
	        params.put("chambre",recu.getReglement().getDescription());
	        params.put("op_impression",String.valueOf(recu.getOperateur()));
	        params.put("logo_path",InitServlet.CHEMIN_ROOT+"\\images\\logo.jpg");
	   
			try{


			     Session session = SessionFactoryUtil.getInstance().openSession();
				 Connection con =session.connection();
				 
			     JasperDesign jasperDesign = JRXmlLoader.load(InitServlet.CHEMIN_ROOT+"\\reports\\recu.jrxml");
			     JasperReport jasperReport = JasperCompileManager.compileReport(jasperDesign);
			     JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport,params,con);
			     
			     bytes=JasperExportManager.exportReportToPdf(jasperPrint);

			}catch(Exception ex)
		       {
				log.fatal(ex.getMessage());
				bytes=null;
		       }
			
			
		log.debug("********** fin genererRecu ImpressionBO **********");
		return bytes;

}


/**** Impression d'une facture dans le cas d'hospitalisation****/
@SuppressWarnings("deprecation")
public byte[] genererFactureHosp(String numFacture,String mention){
	log.debug("********** Debut genererFactureHosp ImpressionBO **********");
	        
	        
	        byte[] bytes;
	

	        java.util.HashMap<String, String> params = new  java.util.HashMap<String, String>();

	        Facture facture=FactureDAO.getInstance().getFacture(numFacture);
	        Patient patient=facture.getPatient();
	        
	        params.put("num_fact",String.valueOf(numFacture));
	        params.put("mention",mention);
	        params.put("numero_patient",patient.getPatientId()); 
	        params.put("nom_prenom",patient.getPrenom()+" "+patient.getNom());     
	        params.put("date_facture",facture.getDateFact().toString());
	        params.put("total_ht",String.valueOf(facture.getTotalHT()));
	        params.put("total_tva",String.valueOf(facture.getTotalTva()));
	        params.put("total_ttc",String.valueOf(facture.getTotalHT()+facture.getTotalTva()));
	        params.put("taux_remise_qpc",String.valueOf(facture.getTauxRemise()));
	        params.put("taux_remise_cash",String.valueOf(facture.getTauxMajoration()));
	        params.put("montant_remise",String.valueOf(facture.getRemise()+facture.getRemiseCash()));
	        params.put("avance",String.valueOf(facture.getAvance()));
	        params.put("net_a_payer",String.valueOf(facture.getNetApayer()));
	        params.put("op_impression",String.valueOf(facture.getOperateur()));
	        //params.put("net_a_payer",""+(facture.getTotalHT()+facture.getTotalTva()-facture.getRemise() -facture.getAvance()));
	        params.put("SUBREPORT_DIR",InitServlet.CHEMIN_ROOT+"\\reports\\");
	        params.put("logo_path",InitServlet.CHEMIN_ROOT+"\\images\\logo.jpg");
	         
	
			try{

			     JasperDesign jasperDesign_reg = JRXmlLoader.load(InitServlet.CHEMIN_ROOT+"\\reports\\facture_hosp_reglement.jrxml");
			   
				 JasperCompileManager.compileReportToFile(jasperDesign_reg,InitServlet.CHEMIN_ROOT+"\\reports\\facture_hosp_reglement.jasper");
			     
			     JasperDesign jasperDesign_chambres = JRXmlLoader.load(InitServlet.CHEMIN_ROOT+"\\reports\\hospitalisation_chambres.jrxml");
				   
				 JasperCompileManager.compileReportToFile(jasperDesign_chambres,InitServlet.CHEMIN_ROOT+"\\reports\\hospitalisation_chambres.jasper");
				 
			     Session session = SessionFactoryUtil.getInstance().openSession();
				 Connection con =session.connection();
			     
			     JasperDesign jasperDesign = JRXmlLoader.load(InitServlet.CHEMIN_ROOT+"\\reports\\facture_hospitalisation.jrxml");
			     JasperReport jasperReport = JasperCompileManager.compileReport(jasperDesign);
			     JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport,params,con);
			     
//			     JasperExportManager.exportReportToPdfFile(jasperPrint,InitServlet.CHEMIN_ROOT+"\\reports\\facture.pdf");
//			     
//			     Desktop desktop = Desktop.getDesktop();
//			    
//			     
//			     desktop.open(new File(InitServlet.CHEMIN_ROOT+"\\reports\\facture.pdf"));
			     
			     bytes=JasperExportManager.exportReportToPdf(jasperPrint);
			     con.close();
			     


	            
			
			}catch(Exception ex)
		       {
				log.fatal(ex.getMessage());
				bytes=null;
		       }
			
			
		log.debug("********** fin genererFacture ImpressionBO **********");
		return bytes;

}



@SuppressWarnings("deprecation")
public byte[] genererDevisAssureur(String numDevis,String mention){
	
	log.debug("********** Debut genererDevisAssureur ImpressionBO **********");
	        
	        
	        byte[] bytes;
	

	        java.util.HashMap<String, String> params = new  java.util.HashMap<String, String>();

	        //DevisAssureur devis=DevisAssureurDAO.getInstance().getDevisAssureur(numDevis);
	        //Patient patient=facture.getPatient();
	       
	        params.put("num_devis",""+numDevis);
	        /*params.put("mention",mention);
	        params.put("numero_patient",patient.getPatientId()); 
	        params.put("nom_prenom",patient.getPrenom()+" "+patient.getNom());     
	        params.put("date_facture",facture.getDateFact().toString());
	        params.put("total_ht",String.valueOf(facture.getTotalHT()));
	        params.put("total_tva",String.valueOf(facture.getTotalTva()));
	        params.put("total_ttc",String.valueOf(facture.getTotalHT()+facture.getTotalTva()));
	        params.put("taux_remise_qpc",String.valueOf(facture.getTauxRemise()));
	        params.put("taux_remise_cash",String.valueOf(facture.getTauxMajoration()));
	        params.put("montant_remise",String.valueOf(facture.getRemise()+facture.getRemiseCash()));
	        params.put("avance",String.valueOf(facture.getAvance()));
	        params.put("net_a_payer",String.valueOf(facture.getNetApayer()));
	        params.put("op_impression",String.valueOf(facture.getOperateur()));
	        //params.put("net_a_payer",""+(facture.getTotalHT()+facture.getTotalTva()-facture.getRemise() -facture.getAvance()));
	        params.put("SUBREPORT_DIR",InitServlet.CHEMIN_ROOT+"\\reports\\");
	        params.put("logo_path",InitServlet.CHEMIN_ROOT+"\\images\\logo.jpg");*/
	        
	        

	        
	        
	        
	   
			try{

			     //JasperDesign jasperDesign_reg = JRXmlLoader.load(InitServlet.CHEMIN_ROOT+"\\reports\\devis_assu.jrxml");
			   
				 //JasperCompileManager.compileReportToFile(jasperDesign_reg,InitServlet.CHEMIN_ROOT+"\\reports\\devis_assu.jasper");
			     
			     
			     //Class.forName("com.mysql.jdbc.Driver");
				 //Connection con = //DriverManager.getConnection("jdbc:mysql://192.168.1.8:3306/clinique", "root", "1234");
					 Session session = SessionFactoryUtil.getInstance().openSession();
					 Connection con =session.connection();
			  
			     JasperDesign jasperDesign = JRXmlLoader.load(InitServlet.CHEMIN_ROOT+"\\reports\\devis_assu.jrxml");
			     JasperReport jasperReport = JasperCompileManager.compileReport(jasperDesign);
			     JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport,params,con);
			     
//			     JasperExportManager.exportReportToPdfFile(jasperPrint,InitServlet.CHEMIN_ROOT+"\\reports\\facture.pdf");
//			     
//			     Desktop desktop = Desktop.getDesktop();
//			    
//			     
//			     desktop.open(new File(InitServlet.CHEMIN_ROOT+"\\reports\\facture.pdf"));
			     
			     bytes=JasperExportManager.exportReportToPdf(jasperPrint);
			     con.close();
			     


	            
			
			}catch(Exception ex)
		       {
				log.fatal(ex.getMessage());
				bytes=null;
		       }
			
			
		log.debug("********** fin genererDevisAssureur ImpressionBO **********");
		return bytes;

}



}
