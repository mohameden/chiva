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
<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery.ui.timepicker.js"></script>
<link type="text/css" href="<%=request.getContextPath()%>/css/jquery.ui.timepicker.css" rel="stylesheet" />




<script type="text/javascript">

function checkDateSortie()
{
	   if (document.forms[0].dateSortie.value!="")
	     {
	      if(verifierDate(document.forms[0].dateSortie.value)==false)
	      {
	    	  document.getElementById("dialog").innerHTML = "<font style=\"oblique\" color=\"#FFFFFF\"  size=\"4\">Veuillez saisir une date correcte<\/font>";
			   
			   $('#dialog').dialog('open');
	       return true;
	       }
	       else return false;
	     }
	   else 
	   {
		   document.getElementById("dialog").innerHTML = "<font style=\"oblique\" color=\"#FFFFFF\"  size=\"4\">Veuillez saisir une date<\/font>";
		   
		   $('#dialog').dialog('open');
		   return true;
	   }
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
		yearRange: '1930:2030'
		 });

	$("#dateSortie").datepicker({yearRange: '2010:2030'});

	$('#timepicker').timepicker({
	});

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


function regler()
{

	if (!checkValeurRemise())
			{
				document.forms[0].dispatch.value = "showReglementHosp";
				document.forms[0].submit();
			}

}

function ouvrirDivAvance()
{
	var idDiv = document.getElementById ("avance");
	idDiv.style.display = 'block';
}

function fermerDivAvance()
{
	var idDiv = document.getElementById ("avance");
	idDiv.style.display = 'none';
}





		$(window).load(function(){

			if  (document.forms[0].remiseFlag[0].checked)
		    {
			 ouvrirDivRemiseValeur();
		    }
		    else fermerDivRemiseValeur();


			});


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

			//document.getElementById ("btnAddActe").style.display = 'none';
			document.getElementById ("btnRegler").style.display = 'none';
		}

		function ajouterDrg()
		{
			//
		   
				document.forms[0].dispatch.value = "ajouterDrgPageHosp";
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
	    <span class="hospitalises">
	<a href="javascript:document.forms[0].dispatch.value='precedent';
	 document.forms[0].subAction.value='hospitalises';  
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
<input type="hidden" name="patientId" value="<bean:write name="formInfosPatient" property="patientId" />"/>
<input type="hidden" name="operation" value="<bean:write name="formInfosPatient" property="operation" />"/>
<input type="hidden" name="subAction"/>


<table width="100%"   align="center" style="background:#00253E; ">
           
          
		 <tr><td>
		  
		  <table width="80%" align="center" bgcolor="#00253E">
		 
		  <tr> 
		  <td colspan="2">
		  <table cellspacing="0" width="100%" align="center"  align="left"  style=" border-color:#FF6600; border-width:1px; border-style:solid; border-left:none;   border-right:none; border-top:none;">
		  <tr>
		 <td colspan="2">
<font  style="oblique" color="#FF6600"  size="5">Hospitalisation</font></td>
<td width="15%"></td>
		  </table>
		  </td>
		  </tr>
		  
		  <tr><td colspan="2"></td></tr>
		  
		  <tr>
		  <td colspan="2">	  
		  
		  <table width="100%"   align="center" style="background:#0B415F; ">
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
	
		  </table>
		   </td></tr>
		   
		   <tr><td>
		  <table width="100%" align="left" style="background:#00253E; font-size:14; font-weight:bold; color: white;">
		  <tr  align="center" style="background:#0B415F; border-left-color:#CBE4F4; border-left-style:solid;" >
            <td colspan="5" style="font-weight:bold"><font style="oblique" color="#FFFFFF"  size="4"> Informations Hospitalisation </font></td>
          </tr>
		  <tr>
		  <td width="22%">Chambre actuelle</td>
		  <td width="25%" style="color: #FF6600;">
		     <bean:write name="formInfosPatient" property="chambreActuelle" />
		  </td>
		  <td colspan="3"></td>
		  </tr>
		  <tr>
		  <td width="22%">Date entrée</td>
		  <td width="25%" style="color: #FF6600;">
		    <bean:write name="formInfosPatient" property="dateEntree" />
		  </td>
		  <td colspan="3"></td>
		  </tr>
		  <tr>
		  <td width="22%">Avance</td>
		  <td width="25%" style="color: #FF6600;">
		    <bean:write name="formInfosPatient" property="avance" />
		  </td>
		  <td colspan="3"></td>
		  </tr>
		  <tr>
		  <td width="22%">Date sortie</td>
		  <td width="25%" style="color: #FF6600;">
		  <bean:write name="formInfosPatient" property="dateSortie" />
		  </td>
		  <td colspan="3"></td>
		  </tr>
		  <tr>
		  <td width="22%"></td>
		  <td width="25%" style="color: #FF6600;">
		 	</td>
		  <td colspan="3">    </td>
		  </tr>
		   <tr>
			  <td colspan="5">
			  </td>
		  </tr>
		  <tr>
			  <td colspan="5">
			  </td>
		  </tr>
		  <tr bgcolor="#0B415F">
			  <td colspan="5">
			  </td>
		  </tr>
		  <tr bgcolor="#0B415F">
			  <td colspan="5">
			  </td>
		  </tr>
		  <tr id="btnRegler" style="display:block">
		  		  <td colspan="5" align="center">
		  		  
		  		   <logic:notEqual name="formInfosPatient" property="libeleAssureur" value="CNAM">
		  		     <input type="button" onclick="ouvrirDivRemise();" value="Régler" size ="50" style="font-weight:bold; background-color:#00253E; color:#FFFFFF; cursor:hand; border:solid 2px #FF6600;"  />
		  		  </logic:notEqual>
		  		  
		  		  <logic:equal name="formInfosPatient" property="libeleAssureur" value="CNAM">

		  		     <input type="button" onclick="ajouterDrg();" value="Ajout des DRG" size ="50" style="font-weight:bold; background-color:#00253E; color:#FFFFFF; cursor:hand; border:solid 2px #FF6600;"  />

		  		  </logic:equal>
		  		  
		  		  </td>
		  		  </tr>
		  <tr id="divRemise" style="display: none">
			  <td colspan="5">
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
		   </td></tr>
		   
		  </table>
		  
		  </td>
		  </tr>
		 
		  <tr>
		  <td colspan="2">
		  
		  <!-- ui-dialog -->
		  <div id="dialog" title="Information"  style="background:#00253E;" >
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