<%@ taglib uri="/WEB-INF/tld/struts-html.tld" prefix="html" %>
<%@ taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@ taglib uri="/WEB-INF/tld/struts-bean.tld" prefix="bean"%>
 <%@ taglib uri="/WEB-INF/tld/struts-logic.tld" prefix="logic" %>
 <%@ page import="java.util.prefs.Preferences" %>

<%
    String hideToolbar = (String) Preferences.systemRoot().node("Browser").get("hidetoolbar", "true").toLowerCase();
%>

<html>
<head>
<meta http-equiv="pragma" content="no-cache" />

<title>Infos patient</title>

<script src="<%=request.getContextPath()%>/js/commun.js" ></script>
<script src="<%=request.getContextPath()%>/js/browsers.js" ></script>

<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/styleBoutonsMenu.css" />
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/alternative.css" />
<link type="text/css" href="<%=request.getContextPath()%>/js/jquery-ui-1.8.18.custom/css/ui-lightness/jquery-ui-1.8.18.custom.css" rel="stylesheet" />	
<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery-ui-1.8.18.custom/js/jquery-1.7.1.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery-ui-1.8.18.custom/js/jquery-ui-1.8.18.custom.min.js"></script>
<link type="text/css" href="<%=request.getContextPath()%>/js/jquery-ui-1.8.18.custom/development-bundle/demos/demos.css" rel="stylesheet" />	
<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery-ui-1.8.18.custom/development-bundle/ui/i18n/jquery.ui.datepicker-fr.js"></script>	


<script type="text/javascript">

  

  function chargerActesParFamille(var1)
  {
  	 var url="<%=request.getContextPath()%>/InitServlet?actionXML=chargerActesParFamille&id_famille_prestation="+var1.value;
  	 remplirHtmlSelectFromAjaxRequest(url,document.forms[0].acteId);
  	  
  }


  function chargerActes(var1)
  {
  	var url="<%=request.getContextPath()%>/InitServlet?actionXML=chargerActes&id_classe="+var1.value;
  	 remplirHtmlSelectFromAjaxRequest(url,document.forms[0].acteId);
  }
    


   function chargerEntreprises(var1)
	{
	   
		 var url="<%=request.getContextPath()%>/InitServlet?actionXML=chargerEntreprises&id_assureur="+var1.value;
		 remplirHtmlSelectFromAjaxRequest(url,document.forms[0].entrepriseId);
		 chargerCategories(document.forms[0].entrepriseId);
	   
	}

	function chargerCategories(var1)
	{ 
		 var url="<%=request.getContextPath()%>/InitServlet?actionXML=chargerCategories&id_entreprise="+var1.value;
		 remplirHtmlSelectFromAjaxRequest(url,document.forms[0].categorieId);
	}

   function checkDateNaiss()
   {
	   if (document.forms[0].dateNaissance.value!="")
	     {
	      if(verifierDate(document.forms[0].dateNaissance.value)==false)
	      {
		   couleurRouge(document.forms[0].dateNaissance);
		   document.forms[0].dateNaissance.value="";
	       document.getElementById('Err2DateNaiss').style.display='block';
	       return true;
	       }
	       else return false;
	     }
	   else return false;
   }

  function checkDatesPC()
  {
	  
	  if (document.forms[0].dateCreation.value!="")
	  {
		  if(verifierDate(document.forms[0].dateCreation.value)==false)
	      {
		   couleurRouge(document.forms[0].dateCreation);
	       document.getElementById('ErrDateCreation').style.display='block';
	       return true;
	       }  
		  else 
		  {
			  if (document.forms[0].finValidite.value!="")
			  {
				  if(verifierDate(document.forms[0].finValidite.value)==false)
			      {
				   couleurRouge(document.forms[0].finValidite);
			       document.getElementById('ErrFinValidite').style.display='block';
			       return true;
			       }
				  else if (document.forms[0].finValidite.value <= document.forms[0].dateCreation.value)
					{
						document.getElementById('ErrDatePC').style.display='block';
						return true;
					}
			  }
			  
				else return false;
		  }
	  }
	  else 
	  {
		  if (document.forms[0].finValidite.value!="")
		  {
			  if(verifierDate(document.forms[0].finValidite.value)==false)
		      {
			   couleurRouge(document.forms[0].finValidite);
		       document.getElementById('ErrFinValidite').style.display='block';
		       return true;
		       }
			  else return false;
		  }
		  else return false;
	  }
  }

  function chargerPatients(var1)
	{ 
		
	     if (var1.value.length==8)
	     {
		    
		  var url="<%=request.getContextPath()%>/InitServlet?actionXML=recherchePatient&telephone="+var1.value;
		  var objXML=getXMLResponse(url);
		 
		  if (getNombrePatients(objXML)>0)
		  {
			   var tel=var1.value;
			   document.forms[0].typePatient[1].checked=true;
			   activerAncien();
			   document.forms[0].telephoneR.value=tel;
			   rechercher();
		  }
        
		     }
	}
   
   
   function checkLieuNaiss()
   {
	   
	   if (document.forms[0].lieuNaissance.value=="")
	     {
	    	 couleurRouge(document.forms[0].lieuNaissance);
	    	 document.getElementById('ErrLieuNaiss').style.display='block';
	    	 return true;
	     }
	   else return false;
	   
   }

   function checkTelephone()
   {
	   
	   if (document.forms[0].telephone.value=="")
	     {
	    	 couleurRouge(document.forms[0].telephone);
	    	 document.getElementById('ErrTelephone').style.display='block';
	    	 return true;
	     }
	   else return false;
	   
   }

   function checkAdresse()
   {
	   
	   if (document.forms[0].adresse.value=="")
	     {
	    	 couleurRouge(document.forms[0].adresse);
	    	 document.getElementById('ErrAdresse').style.display='block';
	    	 return true;
	     }
	   else return false;
	   
   }

   function checkNni()
   {
	   
	   if (document.forms[0].nni.value=="")
	     {
	    	 couleurRouge(document.forms[0].nni);
	    	 document.getElementById('ErrNni').style.display='block';
	    	 return true;
	     }
	   else return false;
	   
   }

   function checkCni()
   {
	   
	   if (document.forms[0].cni.value=="")
	     {
	    	 couleurRouge(document.forms[0].cni);
	    	 document.getElementById('ErrCni').style.display='block';
	    	 return true;
	     }
	   else return false;
	   
   }
   
   function checkNom()
   {
	   
	   if (document.forms[0].nom.value=="")
	     {
	    	 couleurRouge(document.forms[0].nom);
	    	 document.getElementById('ErrNom').style.display='block';
	    	 return true;
	     }
	   else return false;
	   
   }

   function effacer()
   {
  	 if((event.keyCode != 8)||(event.keyCode != 46)) event.returnValue = false;
  	 if((event.which != 8) ||(event.which != 46) )  return false;
     }


   function checkPrenom()
   {
	   
	   if (document.forms[0].prenom.value=="")
	     {
	    	 couleurRouge(document.forms[0].prenom);
	    	 document.getElementById('ErrPrenom').style.display='block';
	    	 return true;
	     }
	   else return false;
	   
   }

   function checkPC()
   {
	   var result=false;
	   if (document.forms[0].priseEnChargeFlag[0].checked)
	   {
	      document.getElementById("dialogPC").innerHTML = "<font style=\"oblique\" color=\"#FFFFFF\"  size=\"4\">Veuillez choisir un assureur, Le devis ne concerne que les patients assurés<\/font>";
		   $('#dialogPC').dialog('open');
		   result=true;
  
		   return result;
	   }
	   else if (document.forms[0].priseEnChargeFlag[1].checked)
	   {
			   
				   if (checkAssureur()) result=true;
				  
				   return result;
			  
	   }
	   else if (document.forms[0].priseEnChargeFlag[2].checked)
	   {
		   if(checkAssureur()) result=true;
		   else return result;
	   }
   }

   function checkAssureur()
   {
	   result=false;
	   if (document.forms[0].assureurId.value=="aucun")
	   { 
		   document.getElementById("dialogPC").innerHTML = "<font style=\"oblique\" color=\"#FFFFFF\"  size=\"4\">Veuillez choisir un assureur<\/font>";
		   $('#dialogPC').dialog('open');
		   result=true;
	   }

	   return result;
   }
   

   function checkNumPC()
   {
	   
	   if (document.forms[0].numPC.value=="")
	     {
	    	 couleurRouge(document.forms[0].numPC);
	    	 document.getElementById('ErrNumPC').style.display='block';
	    	 return true;
	     }
	   else return false;
	   
   }

   function checkPourcentagePC()
   {
	   if (document.forms[0].pourcentage.value!="")
	     {
		     
		     if (document.forms[0].pourcentage.value<=0 || document.forms[0].pourcentage.value>100)
		     {
		    	 couleurRouge(document.forms[0].pourcentage);
		    	 document.getElementById('ErrPourcentage').style.display='block';
		    	 return true;
		     }
		     
		     else return false;
	     }
	   else if  (document.forms[0].plafond.value=="")
	   {
		     couleurRouge(document.forms[0].pourcentage);
	    	 document.getElementById('ErrPourcentage2').style.display='block';
	    	 return true;
	   }
	   else return false;
	   
   }

   function checkPlafond()
   {
	   if (document.forms[0].plafond.value!="")
	     {
		     
		     if (document.forms[0].plafond.value<=0)
		     {
		    	 couleurRouge(document.forms[0].plafond);
		    	 document.getElementById('ErrPlafond').style.display='block';
		    	 return true;
		     }
		     else return false;
	     }
	   else return false;
	   
   }

   function checkNombreActes()
   {
	   if (document.forms[0].nombreActesPC.value!="")
	     {
		     
		     if (document.forms[0].nombreActesPC.value<=0)
		     {
		    	 couleurRouge(document.forms[0].nombreActesPC);
		    	 document.getElementById('ErrNombreActes').style.display='block';
		    	 return true;
		     }
		     else return false;
	     }
	   else return false;
	   
   }

   

   function checkChamps()
   {
     var msg=false;
     if (checkNom())
     {
    	 msg=true;
     }
     if (checkPrenom())
     {
    	 msg=true;
     }
     if (checkDateNaiss())
     {
    	 msg=true;
     }
   
     if (checkTelephone())
     {
    	 msg=true;
     }
     if (checkPC())
     {
    	 msg=true;
     }
    
     if (msg==false)
     {
	     document.forms[0].dispatch.value="savePatientForActesDevis"; 
	     document.forms[0].submit();
     } 
   }

   function ajouterPrestCouv()
   {
	   if (!checkNombreActes())
	   {
	   afficherAddPcPrestation();
	   document.forms[0].dispatch.value="construireListePrestCouvertes"; 
	   document.forms[0].submit();
	   }
   }

	function couleurBlanc(obj,var1) {
		obj.style.border= "solid 1px white";
		document.getElementById(var1).style.display='none';  
		 
	}

	function couleurRouge(obj) {
	     obj.style.border= "solid 1px red";   
	}
	
	

    function activerNouveau()
    {
    	var idDivNouveau = document.getElementById ("formulNouveau");
    	var idDivAncien = document.getElementById ("formulAncien");
    	idDivNouveau.style.display = 'block';
    	idDivAncien.style.display = 'none';
    }

    function activerAncien()
    {
        
    	var idDivNouveau = document.getElementById ("formulNouveau");
    	var idDivAncien = document.getElementById ("formulAncien");
    	idDivNouveau.style.display = 'none';
    	idDivAncien.style.display = 'block';
    }

    function activerPriseEncharge()
    {
    	activerAssureur();
    	//desactiverBadge();
    	//var idDivPC = document.getElementById ("divPriseEncharge");
    	//idDivPC.style.display = 'block';
    	
    }
    
    function activerBadge()
    {
    	activerAssureur();
    	//desactiverPriseEncharge();
    	//document.getElementById('divBadge').style.display='block';
      	
    }

    function desactiverBadge()
    {
    	
    	document.getElementById('divBadge').style.display='none';
      	
    }
    
    function activerAssureur()
    {
    	var idDivPC = document.getElementById ("divAssureur");
    	idDivPC.style.display = 'block';
    }

    function desactiverAssureur()
    {
    	var idDivPC = document.getElementById ("divAssureur");
    	idDivPC.style.display = 'none';
    }

    function desactiverPriseEncharge()
    {
    	var idDivPC = document.getElementById ("divPriseEncharge");
    	idDivPC.style.display = 'none';
    	
    }

    function desactiverPC()
    {
    	//desactiverPriseEncharge();
    	desactiverAssureur();
    	//desactiverBadge();
    }

    function supprimerPrest(var1)
    {
    	afficherAddPcPrestation();
    	document.forms[0].idPrestAsupprimer.value=var1;
 	   document.forms[0].dispatch.value="supprimerPrestFromListePrestCouvertes"; 
 	   document.forms[0].submit(); 
    }

    function choixActeParFamille()
    {
        	var idDivPC = document.getElementById ("selectFamille");
        	idDivPC.style.display = 'block';
    		
    		var idDivPC = document.getElementById ("selectClasse");
        	idDivPC.style.display = 'none';

        	chargerActesParFamille(document.forms[0].famillePrestationId);
    }

    function choixActeParClasse()
    {
        	var idDivPC = document.getElementById ("selectClasse");
        	idDivPC.style.display = 'block';
    		
    		var idDivPC = document.getElementById ("selectFamille");
        	idDivPC.style.display = 'none';

        	chargerActes(document.forms[0].classeId);
    }
    

		$(window).load(function(){
			
			
			if (document.forms[0].typePatient[0].checked)
			{
				activerNouveau();
			}
			else  
			{
				activerAncien();
			}

			
			if (document.forms[0].priseEnChargeFlag[0].checked)
			{
				
				desactiverPC();
			}
			else if (document.forms[0].priseEnChargeFlag[1].checked)
			{
				activerPriseEncharge();
			}
			else{
				activerBadge();
			}

			if (document.forms[0].choixActePar[0].checked)
			{
				
				choixActeParFamille();
			}	
			else
			{
				choixActeParClasse();
			}
			
		
			});
		
		function selectPatient2(IdPatient)
    	{

			    document.forms[0].patientId.value = IdPatient;
			    document.forms[0].dispatch.value = "ajouterPrestationsFormulaireDevisAncien";
	        	document.forms[0].submit();
				
				
    	}

		function selectPatient(IdPatient)
    	{
			var url="<%=request.getContextPath()%>/InitServlet?actionXML=selectPatient&PatientIdSelected="+IdPatient;
			 var objXML=getXMLResponse(url);
			 var patient=new Patient();
			 patient.loadPatient(objXML);
			 if (patient!=null)
			 {
				    document.forms[0].patientId.value=patient.patientId;
				    
                 	document.getElementById("dialog").innerHTML = "<table border=\"1\" bordercolor=\"\#FFFFFF\"  width=\"100%\" align=\"center\" style=\"background:\#00253E; font-size:14;"
					+ "font-weight:bold; color: white;  \"><tr align=\"center\"><td  width=\"20%\" >Nom<\/td><td  width=\"28%\" style=\"color: \#FF6600;\">"+patient.nom+
					"<\/td><td width=\"4%\"><\/td><td  width=\"20%\" >Prénom<\/td><td  width=\"28%\" style=\"color: \#FF6600;\">"+patient.prenom+"<\/td><\/tr>"+
					"<tr align=\"center\"><td  width=\"20%\" >Date Naissance<\/td><td  width=\"28%\" style=\"color: \#FF6600;\">"+patient.dateNaissance+
					"<\/td><td width=\"4%\"><\/td><td  width=\"20%\" >Lieu Naissance<\/td><td  width=\"28%\" style=\"color: \#FF6600;\">"+patient.lieuNaissance+"<\/td><\/tr>"+
					"<tr align=\"center\"><td  width=\"20%\" >Telephone<\/td><td  width=\"28%\" style=\"color: \#FF6600;\">"+patient.telephone+
					"<\/td><td width=\"4%\"><\/td><td  width=\"20%\" >Adresse<\/td><td  width=\"28%\" style=\"color: \#FF6600;\">"+patient.adresse+"<\/td><\/tr>"+
					"<tr align=\"center\"><td  width=\"20%\" >CNI<\/td><td  width=\"28%\" style=\"color: \#FF6600;\">"+patient.cni+
					"<\/td><td width=\"4%\"><\/td><td  width=\"20%\" >NNI<\/td><td  width=\"28%\" style=\"color: \#FF6600;\">"+patient.nni+"<\/td><\/tr>"+
					"<tr align=\"center\"><td  width=\"20%\" >Numéro Badge<\/td><td  width=\"28%\" style=\"color: \#FF6600;\">"+patient.numeroBadge+
					"<\/td><td width=\"4%\"><\/td><td  width=\"20%\" >Date Premiere Visite<\/td><td  width=\"28%\" style=\"color: \#FF6600;\">"+patient.datePremiereVisite+"<\/td><\/tr>"+
					"<tr align=\"center\"><td  width=\"20%\" >Date Derniere Visite<\/td><td  width=\"28%\" style=\"color: \#FF6600;\">"+patient.dateDerniereVisite+
					"<\/td><td width=\"4%\"><\/td><td  width=\"20%\" >Numéro patient<\/td><td  width=\"28%\" style=\"color: \#FF6600;\">"+patient.patientId+"<\/td><\/tr>"+
					"</table>";

					
                 	$('#dialog').dialog('open');
                 	
					
			 }
			 else alert('aucun patient trouvé');
    	}
				
		function rechercher ()
    	{
        	
        	document.forms[0].dispatch.value = "chercherPatientDevis";
        	document.forms[0].submit();
    	}

		$.fx.speeds._default = 1000;
		$(function() {
			$.datepicker.setDefaults($.datepicker.regional['fr']);
			
			$.datepicker.setDefaults({
				showOn: 'button',
				buttonImage: '<%=request.getContextPath()%>/images/calendar.gif',
				buttonImageOnly: true,
				changeMonth: true,
				changeYear: true,
				showAnim: "blind",
				yearRange: '1930:2030' });
			
			$("#dateNaissance").datepicker({});
			$("#dateNaissanceR").datepicker({});
			$("#dateDerniereVisiteR").datepicker({yearRange: '1990:2030'});
			$("#finValidite").datepicker({yearRange: '2010:2030'});
			$("#dateCreation").datepicker({yearRange: '2010:2030'});
			

			// Dialog			
			$('#dialog').dialog({
				autoOpen: false,
				modal: true,
				width: 800,
				height:400,
				show: "slide",
		        hide: "slide",
				buttons: {
					"Suivant": function() { 
						$(this).dialog("close"); 
						document.forms[0].dispatch.value = "ajouterPrestationsFormulaireDevisAncien";
			        	document.forms[0].submit();
					}, 
					"Annuler": function() { 
						$(this).dialog("close"); 
						document.forms[0].patientId.value="";
					} 
				}
			});

			$('#dialogPC').dialog({
				autoOpen: false,
				modal: true,
				width: 400,
				height:150,
				show: "slide",
		        hide: "slide"
			});
			
		
		});

	function afficherAddPcPrestation()
	{
		var idDivPC = document.getElementById ("AddPrestation");
		var idBtnAdd = document.getElementById ("btnAdd");
		var idBtnNext = document.getElementById ("btnNext");
    	idDivPC.style.display = 'block';
    	idBtnAdd.style.display = 'none';
    	idBtnNext.style.display = 'none';
	}

	function cacherAddPcPrestation()
	{
		var idDivPC = document.getElementById ("AddPrestation");
		var idBtnAdd = document.getElementById ("btnAdd");
		var idBtnNext = document.getElementById ("btnNext");
    	
		idBtnAdd.style.display = 'block';
    	idBtnNext.style.display = 'block';
    	idDivPC.style.display = 'none';
	}

			


		
</script>

</head>

<body>
<div class=demos>
<table bordercolor="#FF6600;" height="100%"  width="100%" align="center" style="border-right-style:solid; border-left-style:solid; border-top-style:solid; border-bottom-style:solid;">
<jsp:include page="/template/header.jsp" />
<tr style="background:#0B415F;">
<td height="20">
<table width="100%">
<tr>
<td width="70%"></td>

	<td>
	  <span class="accueil">
			<a href="javascript:document.forms[0].dispatch.value='precedent';
	 document.forms[0].subAction.value='accueil';  
	document.forms[0].submit();" ></a>
	  </span>
	</td>
	<td>
	  <span class="authentification">
					<a href="javascript:document.forms[0].dispatch.value='precedent';
	 document.forms[0].subAction.value='authentification';  
	document.forms[0].submit();" ></a>
	  </span>
	</td>
	<td>
	  <span class="deconnexion">
					<a href="javascript:document.forms[0].dispatch.value='infosPatient'; document.forms[0].submit();" ></a>
	  </span>
	</td>
</tr>
</table>
</td>
</tr>
<tr >
<td style="background:#00253E;">
<table   align="center"  width="80%">


<tr >
<td  colspan="4" >
<table width="100%"   align="center" style="background:#00253E;  ">
<tr>
<td>
<html:form action="/patientAction">
<input type="hidden" name="dispatch"/>
<input type="hidden" name="subAction"/>
<input type="hidden" name="patientId"/>
<input type="hidden" name="pcId"/>
<input type="hidden" name="idPrestAsupprimer"/>
<input type="hidden" name="operation" value="<bean:write name="formInfosPatient" property="operation" />"/>

<table  align="center" bgcolor="#00253E" style="color:#E70739; font-weight:bold;  font-size:16; margin-bottom: 5px;">
	<tr bgcolor="white" align="left" id="ErrNom" style="display: none">
	<td> Veuillez saisir le nom du patient </td>
	</tr>
	<tr bgcolor="white" align="left" id="ErrPrenom" style="display: none">
	<td> Veuillez saisir le prénom du patient </td>
	</tr>
	<tr bgcolor="white" align="left" id="ErrLieuNaiss" style="display: none">
	<td> Veuillez saisir le lieu de naissance </td>
	</tr>
	<tr bgcolor="white" align="left" id="ErrDateNaiss" style="display: none">
	<td> Veuillez saisir la date de naissance </td>
	</tr>
	<tr bgcolor="white" align="left" id="Err2DateNaiss" style="display: none">
	<td> La date de naissance est incorrect</td>
	</tr>
	<tr bgcolor="white" align="left" id="ErrTelephone" style="display: none">
	<td> Veuillez saisir le numéro du téléphone</td>
	</tr>
	<tr bgcolor="white" align="left" id="ErrAdresse" style="display: none">
	<td> Veuillez saisir l'adresse du patient</td>
	</tr>
	<tr bgcolor="white" align="left" id="ErrNni" style="display: none">
	<td> Veuillez saisir le NNI du patient</td>
	</tr>
	<tr bgcolor="white" align="left" id="ErrCni" style="display: none">
	<td> Veuillez saisir le CNI du patient</td>
	</tr>
	<tr bgcolor="white" align="left" id="ErrNumPC" style="display: none">
	<td> Veuillez saisir le numéro de la prise en charge</td>
	</tr>
	<tr bgcolor="white" align="left" id="ErrPourcentage" style="display: none">
	<td> Veuillez saisir un pourcentage correct(entre 0 et 100)</td>
	</tr>
	<tr bgcolor="white" align="left" id="ErrPourcentage2" style="display: none">
	<td> Veuillez saisir un pourcentage ou un plafond</td>
	</tr>
	<tr bgcolor="white" align="left" id="ErrPlafond" style="display: none">
	<td> Veuillez saisir un plafond correct(superieur à 0)</td>
	</tr>
	<tr bgcolor="white" align="left" id="ErrNombreActes" style="display: none">
	<td> Veuillez saisir un "Nombre acte" correct(superieur à 0)</td>
	</tr>
	<tr bgcolor="white" align="left" id="ErrNumBadge" style="display: none">
	<td> Veuillez saisir le numéro du badge</td>
	</tr>
	<tr bgcolor="white" align="left" id="ErrDateCreation" style="display: none">
	<td> Verifiez date creation</td>
	</tr>
	<tr bgcolor="white" align="left" id="ErrFinValidite" style="display: none">
	<td> Verifiez dfin validité</td>
	</tr>
	<tr bgcolor="white" align="left" id="ErrDatePC" style="display: none">
	<td> Verifiez date creation et fin validité</td>
	</tr>
</table>

<html:errors bundle="erreurGestionCommerciale"/>


<table  align="center" bgcolor="#00253E" style="color:#E70739; font-weight:bold;  font-size:16; margin-bottom: 5px;">
	<tr  align="left" id="ErrNom" style="display: none">
	<td> Veuillez saisir le nom du patient </td>
	</tr>
	</table>


<table width="100%"   align="center" style="background:#00253E; ">   
		 <tr><td>
		  
		  <table width="80%" align="center" bgcolor="#00253E">
		  <tr> 
		  <td colspan="2">
		  <table cellspacing="0" width="100%"   align="left"  style=" border-color:#FF6600; border-width:1px; border-style:solid; border-left:none;   border-right:none; border-top:none;">
		  <tr>
		 <td colspan="2">
<font  style="oblique" color="#FF6600"  size="5">Informations patient</font></td>
<td width="15%"></td>
		  <td width="20%" style="background-color: #0B415F; font-size:14;  font-weight:bold; color:white;">
		  <html:radio property="typePatient" name="formInfosPatient" onclick="activerNouveau();" value="nouveau"/>Nouveau patient
		  </td>
		  <td width="5%" style="background-color: #0B415F;"></td>
		  <td width="20%" style="background-color: #0B415F; font-weight:bold; font-size:14; color:white;">
		  <html:radio property="typePatient" name="formInfosPatient" onclick="activerAncien();" value="ancien"/>Ancien patient
		  </td>
		  </tr>
		 
		
		  </table>
		  </td>
		  </tr>
		  <tr><td colspan="2"></td></tr>
		  <tr>
		  <td colspan="2">	  
		  <div id="formulNouveau" style="display: block">
		  <table width="100%"   align="center" style="background:#0B415F; ">
		  <tr><td>
		  <table width="100%" align="left" style="background:#00253E; font-size:14; font-weight:bold; color: white;">
		  <tr  align="center" style="background:#0B415F; border-left-color:#CBE4F4; border-left-style:solid;" >
            <td colspan="4" style="font-weight:bold"><font style="oblique" color="#FFFFFF"  size="4"> Ajouter nouveau patient </font></td>
          </tr>
		  <tr>
		  <td width="19%" >Nom</td>
		  <td width="31%"><html:text styleClass="champText"  property="nom" onfocus="couleurBlanc(this,'ErrNom');"  size ="23"  /></td>
		  <td width="19%">Prénom</td>
		  <td width="31%"><html:text styleClass="champText" property="prenom" onfocus="couleurBlanc(this,'ErrPrenom');" size ="23"/></td>
		  </tr>
		   <tr>
		  <td width="19%">Date Naissance</td>
		  <td width="31%"><html:text styleClass="champText" property="dateNaissance" onfocus="couleurBlanc(this,'ErrDateNaiss'); couleurBlanc(this,'Err2DateNaiss');" onkeypress="effacer();"  styleId="dateNaissance" size ="23"/>
		  </td>
		  <td width="19%">Lieu Naissance</td>
		  <td width="31%"><html:text styleClass="champText" property="lieuNaissance" onfocus="couleurBlanc(this,'ErrLieuNaiss');" size ="23"/></td>
		  </tr>	   
		   <tr>
		  <td width="19%">Téléphone</td>
		  <td width="31%"><html:text styleClass="champText" property="telephone" onkeyup=" chargerPatients(this);" onkeypress="Numerique();" onfocus="couleurBlanc(this,'ErrTelephone');" size ="23"/></td>
		  <td width="19%">Adresse</td>
		  <td width="31%"><html:text styleClass="champText" property="adresse" onfocus="couleurBlanc(this,'ErrAdresse');" size ="23"/></td>
		  </tr>
		  <tr>
		  <td width="19%">CNI</td>
		  <td width="31%"><html:text styleClass="champText" property="cni" onkeypress="Numerique();" onfocus="couleurBlanc(this,'ErrCni');" size ="23"/></td>
		  <td width="19%">NNI</td>
		  <td width="31%"><html:text styleClass="champText" property="nni" onkeypress="Numerique();" onfocus="couleurBlanc(this,'ErrNni');"  size ="23"/></td>
		  </tr>
		  
		  
		   <tr >
		  <td width="100%" colspan="4"></td>
		  </tr>
		    <tr >
		    <td width="100%" colspan="2">
			    <table width="100%" style="background:#0B415F; font-size:14; font-weight:bold; color: white;">
			       <tr>
			       <td >Prise en charge</td>
			      <td >
			      <html:radio property="priseEnChargeFlag" name="formInfosPatient" onclick="desactiverPC();" value="aucune"/>Aucune
			      </td>
			      <td>
			       <html:radio property="priseEnChargeFlag" name="formInfosPatient" onclick="activerPriseEncharge();" value="priseEnCharge"/>Prise en charge
			       </td>
			       <td>
			       <html:radio property="priseEnChargeFlag" name="formInfosPatient" onclick="activerBadge();" value="badge"/>Badge
	                </td>
	                </tr>
	                </table>
	                </td>
	                <td colspan="2"></td>
                </tr>
                <tr >
		  <td colspan="4" width="100%">
		  <div id="divAssureur" style="display:none;">
		                <table width="100%" style="background:#00253E; font-size:14; font-weight:bold; color: white;">
		 
		  
		  <tr bgcolor="#0B415F" >
		  <td width="100%" colspan="4"></td>
		  </tr>
		   <tr bgcolor="#0B415F">
		  <td width="100%" colspan="4"></td>
		  </tr>
		  <tr>
		  <td width="19%">Assureur</td>
		  <td width="31%">
		  <html:select styleClass="champText" property="assureurId" onchange="chargerEntreprises(this);">
			<html:optionsCollection name="formInfosPatient" property="assureurListe" label="label" value="value" />
		  </html:select>
		  </td>
		  <td width="19%">Entreprise</td>
		  <td width="31%">
		  <html:select styleClass="champText" property="entrepriseId" onchange="chargerCategories(this);">
			<html:optionsCollection name="formInfosPatient" property="entrepriseList" label="label" value="value" />
		  </html:select>
		  </td>
		  </tr>
		   <tr>
		  <td width="19%">Catégorie</td>
		  <td width="31%">
		   <html:select styleClass="champText" property="categorieId" onchange="">
			<html:optionsCollection name="formInfosPatient" property="categorieList" label="label" value="value" />
		  </html:select>
		  </td>
		  <td colspan="2"></td>		  
		  </tr>
		  
		  </table>
		  </div>
		  </td>
		  </tr>
		  
		  
                 <tr bgcolor="#0B415F" >
		  <td width="100%" colspan="4"></td>
		  </tr>
		   <tr bgcolor="#0B415F">
		  <td width="100%" colspan="4"></td>
		  </tr>

		  <tr>
		  <td id="btnNext" colspan="4" align="center">
		  <input type="button"  onclick="checkChamps();" value="Suivant" size ="50" style="font-weight:bold; background-color:#00253E; color:#FFFFFF; cursor:hand; border:solid 2px #FF6600;"  />
		  </td>
		  </tr>
		  </table>
		   </td></tr>
		  </table>
		  </div>
		  <div id="formulAncien" style="display: none">
		  <table width="100%"   align="center" style="background:#0B415F; ">
		  <tr><td>
		  <table width="100%" align="left" style="background:#00253E; font-size:14; font-weight:bold; color: white;">
		  <tr  align="center" style="background:#0B415F; border-left-color:#CBE4F4; border-left-style:solid;" >
            <td colspan="4" style="font-weight:bold"><font style="oblique" color="#FFFFFF"  size="4"> Rechercher ancien patient </font></td>
          </tr>
		  <tr>
		  <td width="19%">Nom</td>
		  <td width="31%"><html:text styleClass="champText" property="nomR" size ="23" /></td>
		  <td width="19%">Prénom</td>
		  <td width="31%"><html:text styleClass="champText" property="prenomR" size ="23"/></td>
		  </tr>
		   <tr>
		  <td width="19%">Date Naissance</td>
		  <td width="31%"><html:text styleClass="champText" property="dateNaissanceR" styleId="dateNaissanceR" size ="23"/></td>
		  <td width="19%">Date Dernière Visite</td>
		  <td width="31%"><html:text styleClass="champText" property="dateDerniereVisiteR" styleId="dateDerniereVisiteR" size ="23"/></td>
		  </tr>	   
		   <tr>
		  <td width="19%">Téléphone</td>
		  <td width="31%"><html:text styleClass="champText" property="telephoneR" size ="23"/></td>
		  <td width="19%">Numéro patient</td>
		  <td width="31%"><html:text styleClass="champText" property="patientIdR" size ="23"/></td>
		  </tr>
		  <tr>
		  <td width="19%">CNI</td>
		  <td width="31%"><html:text styleClass="champText" property="cniR" size ="23"/></td>
		  <td width="19%">NNI</td>
		  <td width="31%"><html:text styleClass="champText" property="nniR" size ="23"/></td>
		  </tr>
		  <tr>
		  <td width="19%">Numéro badge</td>
		  <td width="31%"><html:text styleClass="champText" property="numeroBadgeR" size ="23"/></td>
		  <td width="19%"></td>
		  <td width="31%"></td>
		  </tr>
		  <tr>
		  <td colspan="4" align="center">
		  <input type="button" onclick="rechercher();" value="Rechercher" size ="50" style="font-weight:bold; background-color:#00253E; color:#FFFFFF; cursor:hand; border:solid 2px #FF6600;"  />
		  </td>
		  </tr>
		  </table>
		  
		  		  </td></tr>
		  		  
		  		  
		  		  <tr>
		  		  <td>
		  		  <table width="100%" align="left" style="background:#00253E; font-size:14; font-weight:bold; color: white;">
		  <tr  align="center" style="background:#0B415F; border-left-color:#CBE4F4; border-left-style:solid;" >
            <td colspan="4" style="font-weight:bold"><font style="oblique" color="#FFFFFF"  size="4"> Liste des patients trouvés </font></td>
          </tr>
	<tr><td colspan="4" align="center" width="100%">
  <display:table id="row"  name="sessionScope.formInfosPatient.patients"  class="mars" pagesize="5" defaultsort="1" defaultorder="descending" >
		<display:setProperty name="paging.banner.placement" value="bottom"></display:setProperty>
		<display:setProperty name="css.tr.even" value="even"></display:setProperty>
		   
				<display:column style=" text-decoration: underline;" title="Choisir">
					<a id="dialog_link" style="cursor: pointer" onclick="selectPatient2('<bean:write name="row" property="patientId"/>');">
					<img align="middle" width="30"   src="<%=request.getContextPath()%>/<bean:message key="image.fin" />" />
					</a>
				</display:column>
				
				<display:column style=" text-decoration: underline;" title="Voir infos">
					<a id="dialog_link" style="cursor: pointer" onclick="selectPatient('<bean:write name="row" property="patientId"/>');">
					<img align="middle" width="30"   src="<%=request.getContextPath()%>/<bean:message key="image.search" />" />
					</a>
				</display:column>
		 	 
			<display:column  property="nom" title="Nom" sortProperty="nom"/>
			<display:column  property="prenom" title="Prénom"  />
			<display:column  property="nni" title="Nni" />
			<display:column  property="cni" title="Cni" />
			<display:column property="dateNaissance" title="dateNaissance" format="{0,date,dd/MM/yyyy}"/>
			<display:column property="dateDerniereVisite" title="dateDerniereVisite" format="{0,date,dd/MM/yyyy}"/>
			
			
					</display:table>
		  		  </td>
		  		  </tr>
		  		  </table>
		  		  </td>
		  		  </tr>
		  </table>
		  
		  <!-- ui-dialog -->
		  
		  
		<div id="dialog" title="Informations Patient"  style="background:#00253E;" >
         </div>
         
         <div id="dialogPC" title="Message d'erreur"  style="background:#00253E;" >
        
         </div>
			   
		  </div>
		  </td>
		  </tr>
		  </table>

         </td></tr>
</table>

</html:form>


</td>
</tr>
</table>
</td>
</tr>
</table>
</td>

</tr>
<jsp:include page="/template/footer.jsp" />
</table>

</div>

</body>
</html>