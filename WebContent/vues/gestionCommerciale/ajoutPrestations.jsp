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

<title>Ajout Prestations</title>

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

$.fx.speeds._default = 1000;
$(function() {

	// Dialog			

	$('#dialog').dialog({
		autoOpen: false,
		modal: true,
		width: 400,
		height:100,
		show: "slide",
        hide: "slide"
	});


});


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


function imprimer(var1)
{
	document.forms[0].recuId.value=var1;
	document.forms[0].dispatch.value = "imprimer";
	document.forms[0].submit();
	
}

function regler()
{
	if (!checkValeurRemise())
	{
	document.forms[0].dispatch.value = "reglementRecu";
	document.forms[0].submit();
	}
	
}

function reglerCnamWithDrg()
{
	if (!checkMontant)
	{	
		if (!checkValeurRemise())
		{
		document.forms[0].dispatch.value = "reglementRecu";
		document.forms[0].submit();
		}
	}	
}


function couleurBlanc(obj,var1) {
	obj.style.border= "solid 1px white";
	document.getElementById(var1).style.display='none';  
	 
}

function couleurRouge(obj) {
     obj.style.border= "solid 1px red";   
}

function checkMontant()
{
	var montantDrg=document.forms[0].resteApayerMajoration;
	var totalApayer=document.forms[0].totalMontantDrg;
	

    	if (parseInt(montantDrg.value) > (parseInt(totalApayer)+999))
		{
    		document.getElementById("dialog").innerHTML = "<font style=\"oblique\" color=\"#FFFFFF\"  size=\"4\">La différence entre le total DRG et le total a payer ne dois pas dépasser 1000UM<\/font>";
			   
 		   $('#dialog').dialog('open');
		   return true;
		}
		else
		{
		 return false;
		}
	
 }

function checkValeurRemise()
{	
	if  (document.forms[0].remiseFlag[0].checked)
	{
	   if (document.forms[0].remiseValeur.value=="")
	     {
	    	 
		   document.getElementById("dialog").innerHTML = "<font style=\"oblique\" color=\"#FFFFFF\"  size=\"4\">Veuillez saisir la valeur remise<\/font>";
			   
		   $('#dialog').dialog('open');
	    	 return true;
	     }
	   else if (document.forms[0].remiseValeur.value>10)
	   {
		   document.getElementById("dialog").innerHTML = "<font style=\"oblique\" color=\"#FFFFFF\"  size=\"4\">Valeur remise doit etre < 10<\/font>";
		   $('#dialog').dialog('open');
	    	 return true;
	   }
	}
	   else return false;   
}



function checkNombre()
{	   
	   if (document.forms[0].nombreActe.value=="")
	     {
	    	 couleurRouge(document.forms[0].nombreActe);
	    	 document.getElementById('ErrNombre').style.display='block';
	    	 return true;
	     }
	   else if (document.forms[0].nombreActe.value=="0")
	   {
		   couleurRouge(document.forms[0].nombreActe);
	    	 document.getElementById('ErrNombre').style.display='block';
	    	 return true;
	   }
	   else return false;   
}

function chargerActesParFamille(var1)
{
	 var url="<%=request.getContextPath()%>/InitServlet?actionXML=chargerActesParFamille&id_famille_prestation="+var1.value;
	 remplirHtmlSelectFromAjaxRequest(url,document.forms[0].acteId);
	 chargerActeursInf(document.forms[0].acteId);
	 chargerActeursMed(document.forms[0].acteId);
	  
}


function chargerActes(var1)
{
	var url="<%=request.getContextPath()%>/InitServlet?actionXML=chargerActes&id_classe="+var1.value;
	 remplirHtmlSelectFromAjaxRequest(url,document.forms[0].acteId);
	 chargerActeursInf(document.forms[0].acteId);
	 chargerActeursMed(document.forms[0].acteId);
}



function chargerActeursInf(var1)
{
	if(document.forms[0].infirmierChoix[0].checked)
	{
	var url="<%=request.getContextPath()%>/InitServlet?actionXML=chargerActeursInf&id_acte="+var1.value;
	 remplirHtmlSelectFromAjaxRequest(url,document.forms[0].acteurActeIdInf);
	}
}

function chargerActeursMed(var1)
{
	if(document.forms[0].medecinChoix[0].checked)
	{
	var url="<%=request.getContextPath()%>/InitServlet?actionXML=chargerActeursMed&id_acte="+var1.value;
	 remplirHtmlSelectFromAjaxRequest(url,document.forms[0].acteurActeId);
	}
}


function afficherActes()
{
	if (document.forms[0].choixActePar[0].checked)
	{
		
		choixActeParFamille();
	}	
	else
	{
		choixActeParClasse();
	}
}



		$(window).load(function(){

		
			afficherActes();
			
			});

function OuvrirDivPrestation()
{
	var idDiv = document.getElementById ("formulPrest");
	idDiv.style.display = 'block';

	afficherActes();
}

function ouvrirDivRemiseValeur()
{
	var idDiv = document.getElementById ("remiseValeur");
	idDiv.style.display = 'block';
}

function fermerDivRemiseValeur()
{
	var idDiv = document.getElementById ("remiseValeur");
	idDiv.style.display = 'none';

	
}

function ouvrirDivRemise()
{
	document.forms[0].remiseFlag[1].checked=true;
	var idDiv = document.getElementById ("divRemise");
	idDiv.style.display = 'block';
    if  (document.forms[0].remiseFlag[0].checked)
    {
	 ouvrirDivRemiseValeur();
    }
    else fermerDivRemiseValeur();

	document.getElementById ("btnAddActe").style.display = 'none';
	document.getElementById ("btnRegler").style.display = 'none';
}

function FermerDivPrestation()
{
	
	if (!checkNombre())
	{
	var idDiv = document.getElementById ("formulPrest");
	idDiv.style.display = 'none';
	
	document.forms[0].dispatch.value = "ajouterActe";
	document.forms[0].submit();
	
	}
	
}

function CacherDivPrestation()
{
	var idDiv = document.getElementById ("formulPrest");
	idDiv.style.display = 'block';
}

function activerMedecinChoix()
{
	var idDiv = document.getElementById ("divMedecin");
	idDiv.style.display = 'block';

	var url="<%=request.getContextPath()%>/InitServlet?actionXML=chargerActeursMed&id_acte="+document.forms[0].acteId.value;
	 remplirHtmlSelectFromAjaxRequest(url,document.forms[0].acteurActeId);
	 
	
}

function desactiverMedecinChoix()
{
	var idDiv = document.getElementById ("divMedecin");
	idDiv.style.display = 'none';

	
}

function activerInfirmierChoix()
{
	var idDiv = document.getElementById ("divInfirmier");
	idDiv.style.display = 'block';

	var url="<%=request.getContextPath()%>/InitServlet?actionXML=chargerActeursInf&id_acte="+document.forms[0].acteId.value;
	 remplirHtmlSelectFromAjaxRequest(url,document.forms[0].acteurActeIdInf);
}

function desactiverInfirmierChoix()
{
	var idDiv = document.getElementById ("divInfirmier");
	idDiv.style.display = 'none';
}

function ajouterDrg()
{
	//
	document.forms[0].dispatch.value = "ajouterDrgPage";
	document.forms[0].submit();

}

function supprimerDrg(var1)
{
	//
	document.forms[0].idDetailDrgAsupprimer.value=var1;
	document.forms[0].dispatch.value = "supprimerDetailDrgCnam";
	document.forms[0].submit();

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
	  <span class="infosPatient">
	<a href="javascript:document.forms[0].dispatch.value='precedent';
	 document.forms[0].subAction.value='infosPatient';  
	document.forms[0].submit();" ></a>
	  </span>
	</td>
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
<table   align="center"  width="80%" >


<tr >
<td  colspan="4" >
<table width="100%"   align="center" style="background:#00253E; ">
<tr>
<td>
<html:form action="/patientAction">
<input type="hidden" name="dispatch"/>
<input type="hidden" name="subAction"/>
<input type="hidden" name="patientId" value="<bean:write name="formInfosPatient" property="patientId" />"/>
<input type="hidden" name="operation" value="<bean:write name="formInfosPatient" property="operation" />"/>

<input type="hidden" name="idDetailDrgAsupprimer"/>
<input type="hidden" name="resteApayerMajoration" value="<bean:write name="formInfosPatient" property="resteApayerMajoration" />"/>
<input type="hidden" name="totalMontantDrg"/>



<table  align="center" bgcolor="#00253E" style="color:#E70739; font-weight:bold;  font-size:16; margin-bottom: 5px;">
	<tr bgcolor="white" align="left" id="ErrNombre" style="display: none">
	<td> Le nombre  doit etre superieur ou egal a 0 </td>
	</tr>
	</table>
	
	

<table width="100%"   align="center" style="background:#00253E; ">
           
          
		 <tr><td>
		  
		  <table width="80%" align="center" bgcolor="#00253E">
		 
		  <tr> 
		  <td colspan="2" >
		  <table cellspacing="0" width="100%" align="center"  align="left"  style=" border-color:#FF6600; border-width:1px; border-style:solid; border-left:none;   border-right:none; border-top:none;">
		  <tr>
		 <td colspan="2">
<font  style="oblique" color="#FF6600"  size="5">Nouvelles prestations</font></td>
<td width="15%"></td>
		  </table>
		  </td>
		  </tr>
		  
		  <tr><td colspan="2"></td></tr>
		  
		  <tr>
		  <td colspan="2" style="background:#0B415F;">	  
		  
		  <table width="100%"   align="center" style="background:#00253E; font-size:14; font-weight:bold; color: white;">
		  <tr><td>
		  <table width="100%" align="left" style="background:#00253E; font-size:14; font-weight:bold; color: white;">
		  <tr  align="center" style="background:#0B415F; border-left-color:#CBE4F4; border-left-style:solid;" >
            <td colspan="5" style="font-weight:bold"><font style="oblique" color="#FFFFFF"  size="4"> Informations patient </font></td>
          </tr>
		  <tr>
		  <td width="22%" >Nom</td>
		  <td width="25%" style="color: #FF6600;"><bean:write name="formInfosPatient" property="nom"  /></td>
		  <td width="6%"></td>
		  <td width="22%">Prénom</td>
		  <td width="25%" style="color: #FF6600;"><bean:write name="formInfosPatient" property="prenom" /></td>
		  </tr>
		   <tr>
		  <td width="22%">Date Naissance</td>
		  <td width="25%" style="color: #FF6600;"><bean:write name="formInfosPatient" property="dateNaissance"  /></td>
		  <td width="6%"></td>
		  <td width="22%">Lieu Naissance</td>
		  <td width="25%" style="color: #FF6600;"><bean:write name="formInfosPatient" property="lieuNaissance" /></td>
		  </tr>	   
		   <tr>
		  <td width="22%">Téléphone</td>
		  <td width="25%" style="color: #FF6600;"><bean:write name="formInfosPatient" property="telephone" /></td>
		  <td width="6%"></td>
		  <td width="22%">Adresse</td>
		  <td width="25%" style="color: #FF6600;"><bean:write name="formInfosPatient" property="adresse" /></td>
		  </tr>
		  <tr>
		  <td width="22%">CNI</td>
		  <td width="25%" style="color: #FF6600;"><bean:write name="formInfosPatient" property="cni" /></td>
		  <td width="6%"></td>
		  <td width="22%">NNI</td>
		  <td width="25%" style="color: #FF6600;"><bean:write name="formInfosPatient" property="nni" /></td>
		  </tr>
		  <tr>
		  <td width="22%">Numéro badge</td>
		  <td width="25%" style="color: #FF6600;"><bean:write name="formInfosPatient" property="numeroBadge" /></td>
		  <td width="6%"></td>
		  <td width="22%">Date Premiere Visite</td>
		  <td width="25%" style="color: #FF6600;"><bean:write name="formInfosPatient" property="datePremiereVisite" /></td>
		  </tr>
		  <tr>
		  <td width="22%">Date Dernière Visite</td>
		  <td width="25%" style="color: #FF6600;"><bean:write name="formInfosPatient" property="dateDerniereVisite" /></td>
		  <td width="6%"></td>
		  <td width="22%">Numéro patient</td>
		  <td width="25%" style="color: #FF6600;"><bean:write name="formInfosPatient" property="patientId" /></td>
		  </tr>  
		  <tr id="btnAddActe" style="display:block">
		  <td colspan="5" align="center" style="display:none">
		  <input type="button" onclick="OuvrirDivPrestation();" value="Ajouter un acte" size ="50" style="font-weight:bold; background-color:#00253E; color:#FFFFFF; cursor:hand; border:solid 2px #FF6600;"  />
		  </td>
		  </tr>
		  </table>
		   </td></tr>
		  </table>
		  
		  </td>
		  </tr>
		  <tr>
		  <td colspan="2" style="background:#0B415F;">
		  <div id="formulPrest" style="display: block;">
		  <table width="100%" align="left" style="background:#00253E; font-size:14; font-weight:bold; color: white;">
		  <tr  align="center" style="background:#0B415F; border-left-color:#CBE4F4; border-left-style:solid;" >
            <td colspan="3" style="font-weight:bold"><font style="oblique" color="#FFFFFF"  size="4"> Informations Prestation </font></td>
          </tr>
          <tr>
	          <td colspan="3" align="center">
	          Choisir par :  
			      <html:radio property="choixActePar" name="formInfosPatient" onclick="choixActeParFamille();" value="famille"/>Famille prestations
			      <html:radio property="choixActePar" name="formInfosPatient" onclick="choixActeParClasse();" value="classe"/>Classe
	          </td>
          </tr>
          <tr id="selectFamille" style="display: block;">
			<td >Familles prestations</td>
			 <td>
			 <html:select  styleClass="champText"  property="famillePrestationId" onchange="chargerActesParFamille(this);">
				<html:optionsCollection name="formInfosPatient" property="famillesPrestList"  label="label" value="value" />
			 </html:select>
			</td>
			<td></td>
			</tr>
			<tr id="selectClasse" style="display: none;">
			 <td >Classes prestations</td>
			 <td>
			  <html:select styleClass="champText" property="classeId"  onchange="chargerActes(this);">
				<html:optionsCollection name="formInfosPatient" property="classesListe" label="label" value="value" />
			  </html:select>
			 </td>
			 <td></td>
			</tr>
			 
			 <tr>
			  <td >Actes</td>
			  <td>
				<html:select styleClass="champText" property="acteId" onchange="chargerActeursInf(this); chargerActeursMed(this);" >
				 <html:optionsCollection name="formInfosPatient" property="actesListe" label="label" value="value" />
				</html:select>
			  </td>
			  <td></td>
			 </tr>
			 <tr>
			  <td >Nombre</td>
			  <td>
				<html:text styleClass="champText" property="nombreActe" value="0" maxlength="2" onkeypress="Numerique();" onfocus="couleurBlanc(this,'ErrNombre');"/>
			  </td>
			  <td></td>
			 </tr>
			 <tr>
			  <td >Type prestation</td>
			  <td>
				<html:radio property="typeActe" name="formInfosPatient" onclick="activerNormal();" value="normal"/> Normal
				<html:radio property="typeActe" name="formInfosPatient" onclick="activerUrgence();" value="urgence"/> Urgence
				<html:radio property="typeActe" name="formInfosPatient" onclick="activerDeplacement();" value="deplacement"/> Déplacement
			  </td>
			  <td></td>
			 </tr>
			 
			 <tr >
			  <td  colspan="3" style="background:#0B415F;">
			  </td>
		     </tr>
		     
			 <tr>
			  <td >Medecin/praticien</td>
			  <td>
				  <table width="100%" align="left" style="background:#00253E; font-size:14; font-weight:bold; color: white;">
				  <tr>
				    <td width="20%" align="left">
				      <html:radio property="medecinChoix" name="formInfosPatient" onclick="activerMedecinChoix();" value="oui"/> Oui
					  <html:radio property="medecinChoix" name="formInfosPatient" onclick="desactiverMedecinChoix();" value="non"/> Non
				    </td>
				    <td width="20%" align="left">
				      <html:select styleClass="champText" property="acteurActeId" styleId="divMedecin" style="display: none;" >
					     <html:optionsCollection name="formInfosPatient" property="acteurActeList" label="label" value="value" />
			         </html:select>
				    </td>
				    <td></td>
				  </tr>
				  </table>
			  </td>
			  <td>
			   
			  </td>
			 </tr>
			 
			  <tr>
			  <td >Infirmier/assistant</td>
			  <td>
				       <table width="100%" align="left" style="background:#00253E; font-size:14; font-weight:bold; color: white;">
					  <tr>
					    <td width="20%" align="left">
					      <html:radio property="infirmierChoix" name="formInfosPatient" onclick="activerInfirmierChoix();" value="oui"/> Oui
				            <html:radio property="infirmierChoix" name="formInfosPatient" onclick="desactiverInfirmierChoix();" value="non"/> Non
				
					    </td>
					    <td width="20%" align="left">
					       <html:select styleClass="champText" property="acteurActeIdInf" styleId="divInfirmier" style="display: none;">
						      <html:optionsCollection name="formInfosPatient" property="acteurActeInfList" label="label" value="value" />
					        </html:select>
					     </td>
					     <td>
					     </td>
					  </tr>
					  </table>

			  </td>
			  <td> 
			  </td>
			 </tr>
			 
			 <tr >
			  <td  colspan="3" style="background:#0B415F;">
			  </td>
		  </tr>
		
		  <tr><td align="center" colspan="4">
		  <input type="button" onclick="FermerDivPrestation();" value="Valider" size ="50" style="font-weight:bold; background-color:#00253E; color:#FFFFFF; cursor:hand; border:solid 2px #FF6600;"  />
		  <input type="button" onclick="CacherDivPrestation();" value="Annuler" size ="50" style="display:none; font-weight:bold; background-color:#00253E; color:#FFFFFF; cursor:hand; border:solid 2px #FF6600;"  />
		  </td></tr>
		  
		  </table>
		 </div>
		
		  </td>
		  </tr>
		  <tr>
		  <td colspan="2" style="background:#0B415F;">
		  
		  <table width="100%"   align="center" style="background:#00253E; font-size:14; font-weight:bold; color: white;">
		  		  
		  		  <tr>
		  		  <td>
		  		  <table width="100%" align="left" style="background:#00253E; font-size:14; font-weight:bold; color: white;">
		  <tr  align="center" style="background:#0B415F; border-left-color:#CBE4F4; border-left-style:solid;" >
            <td colspan="4" style="font-weight:bold"><font style="oblique" color="#FFFFFF"  size="4"> Liste des Prestations </font></td>
          </tr>
	      <tr><td colspan="4" align="center" width="100%">
  <display:table id="row"  name="sessionScope.formInfosPatient.detailsFactureList"  class="mars" pagesize="5" defaultsort="1" defaultorder="descending" >
		<display:setProperty name="paging.banner.placement" value="bottom"></display:setProperty>
		<display:setProperty name="css.tr.even" value="even"></display:setProperty>
		   

		 	
			<display:column  property="nomActe" title="Acte" />
				
			<display:column  property="nbrActes" title="Nombre Actes" />
			<display:column  property="montantTotal" title="Prix" />
			
			
					</display:table>
		  		  </td>
		  		  </tr>
		  

		  </table>
		  		  </td>
		  		  </tr>
		  		
		  </table>
		  
		  </td>
		  </tr>
		 
		  
		  <tr>
		  <td >
		  
		  <logic:notEmpty name="formInfosPatient" property="detailsFactureList">
		   <table width="100%"   align="center" style="background:#00253E; font-size:14; font-weight:bold; color: white;">
		  		  
		  		  <tr>
		  		  <td style="background:#0B415F;">
		  		  <table width="100%" align="left" style="background:#00253E; font-size:14; font-weight:bold; color: white;">
		  		 
		  		  
		  	        <tr id="btnRegler" style="display:block">
		  		  <td colspan="4" align="center">
		  		  
		  		   <logic:notEqual name="formInfosPatient" property="libeleAssureur" value="CNAM">
		  		     <input type="button" onclick="ouvrirDivRemise();" value="Régler" size ="50" style="font-weight:bold; background-color:#00253E; color:#FFFFFF; cursor:hand; border:solid 2px #FF6600;"  />
		  		  </logic:notEqual>
		  		  
		  		  <logic:equal name="formInfosPatient" property="libeleAssureur" value="CNAM">

		  		     <input type="button" onclick="ajouterDrg();" value="Ajout des DRG" size ="50" style="font-weight:bold; background-color:#00253E; color:#FFFFFF; cursor:hand; border:solid 2px #FF6600;"  />

		  		  </logic:equal>
		  		  
		  		  </td>
		  		  </tr>
		  		  <tr id="divRemise" style="display: none">
		  		  <td colspan="4">
		  		  <table width="100%" align="left" style="background:#00253E; font-size:14; font-weight:bold; color: white;">
			  		  <tr>
			  		  <td colspan="2" align="center">
			  		  Remise 
			  		  <html:radio property="remiseFlag" name="formInfosPatient" onclick="ouvrirDivRemiseValeur();" value="oui"/> Oui
			  		  <html:radio property="remiseFlag" name="formInfosPatient" onclick="fermerDivRemiseValeur();" value="non"/> Non
			  		  </td>
			  		  <td colspan="2">
			  		  
			  		  </td>
			  		  </tr>
			  		  <tr id="remiseValeur" style="display: none">
			  		  <td colspan="4" align="center">
			  		  <html:text styleClass="champText" maxlength="2" property="remiseValeur" onkeypress="Numerique();" />
			  		  
			  		  </td>
			  		  </tr>
			  		  <tr>
			  		  <td colspan="4" align="center">
		  		     <input type="button" onclick="regler();" value="Valider" size ="50" style="font-weight:bold; background-color:#00253E; color:#FFFFFF; cursor:hand; border:solid 2px #FF6600;"  />
		  		    
			  	      </td>
			  		 </tr>
			  		 </table>
			  		  </td>
			  		  </tr>
		  		  </table>
		  		  </td>
		  		  </tr>
		  		
		  </table>
		  </logic:notEmpty>
		  
		  <!-- ui-dialog -->
		  <div id="dialog" title="Information"  style="background:#00253E;" >
         </div>
         
         <div id="dialogMontant" title="Information"  style="background:#00253E;" >
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