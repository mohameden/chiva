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

function valider()
{

	document.forms[0].dispatch.value = "saveAncienDevisPatientWithPC";
	document.forms[0].submit();

}

$(window).load(function(){
	
	
	if (document.forms[0].priseEnChargeFlag.value=="badge")
	{
		var badge = document.getElementById ("divBadge");
		var pc = document.getElementById ("divPriseEncharge");
    	badge.style.display = 'block';
    	pc.style.display = 'none';
	}
	else  
	{
		var badge = document.getElementById ("divBadge");
		var pc = document.getElementById ("divPriseEncharge");
    	badge.style.display = 'none';
    	pc.style.display = 'block';
	}

	});



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
<input type="hidden" name="priseEnChargeFlag" value="<bean:write name="formInfosPatient" property="priseEnChargeFlag" />"/>
<input type="hidden" name="operation" value="<bean:write name="formInfosPatient" property="operation" />"/>

<table width="100%"   align="center" style="background:#00253E; ">
           
          
		 <tr><td>
		  
		  <table width="80%" align="center" bgcolor="#00253E">
		 
		  <tr> 
		  <td colspan="2">
		  <table cellspacing="0" width="100%" align="center"  align="left"  style=" border-color:#FF6600; border-width:1px; border-style:solid; border-left:none;   border-right:none; border-top:none;">
		  <tr>
		 <td colspan="2">
			<font  style="oblique" color="#FF6600"  size="5">Ancien Patient</font></td>
			<td width="15%"></td>
		  </table>
		  </td>
		  </tr>
		  
		  <tr><td colspan="2"></td></tr>
		  
		  <tr>
		  <td colspan="2">	  
		  
		  <table width="100%"   align="center" >
		  <tr style="background:#0B415F"><td>
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
		  </table>
		  
		  </td>
		  </tr>
		  <tr style="background:#0B415F">
		  <td colspan="2" >
		  
		  <table width="100%" align="center" style="background:#00253E; font-size:14; font-weight:bold; color: white;">
		  <tr  align="center" style="background:#0B415F; border-left-color:#CBE4F4; border-left-style:solid;" >
            <td colspan="5" style="font-weight:bold"><font style="oblique" color="#FFFFFF"  size="4"> Informations Assureur </font></td>
          </tr>

			 <tr >
			  <td width="22%">
			  Assureur
			  </td>
			  <td width="25%" style="color: #FF6600;">
			  <bean:write name="formInfosPatient" property="nomAssureur"  />
			  </td>
			  <td colspan="3">
			  </td>
		     </tr>
			 
			  <tr >
			  <td width="22%">
			  Entreprise
			  </td>
			  <td width="25%" style="color: #FF6600;">
			  <bean:write name="formInfosPatient" property="nomEntreprise"  />
			  </td>
			  <td colspan="3">
			  </td>
		     </tr>
			 
			  <tr >
			  <td width="22%">
			  Categorie
			  </td>
			  <td width="25%" style="color: #FF6600;">
			  <bean:write name="formInfosPatient" property="nomCategorie"  />
			  </td>
			  <td colspan="3">
			  </td>
		     </tr>
		     
			 <tr align="center"  style="background:#00253E; ">
			  <td colspan="5" style="background:#00253E">
			  <div id="divBadge" style="display:none;">
		                <table align="center" width="100%" style="background:#00253E; font-size:14; font-weight:bold; color: white;">
		                <tr bgcolor="#0B415F" >
						  <td width="100%" colspan="5"></td>
						  </tr>
		                <tr>
		                <td width="22%">Numéro badge</td>
		                 <td width="25%" style="color: #FF6600;"> <bean:write name="formInfosPatient" property="numeroBadge"  /> </td>
                         <td colspan="3"></td>
		                </tr>
		                </table>
		          </div>
			  
			  </td>
		    </tr>
			<tr align="center" style="background:#00253E; ">
				<td colspan="5" style="background:#00253E">
				   <div id="divPriseEncharge" style="display:none;">
		                <table align="center" width="100%" style="background:#00253E; font-size:14; font-weight:bold; color: white;">
		                <tr bgcolor="#0B415F" >
						  <td width="100%" colspan="5"></td>
						  </tr>
		                <tr>
		                 <td width="22%">Numéro</td>
		                 <td width="25%" style="color: #FF6600;">
						    <bean:write name="formInfosPatient" property="numPC"  />
		                 </td>
		                 <td width="6%"></td>
		                 <td width="22%">Date création</td>
		                 <td width="25%" style="color: #FF6600;">
						 <bean:write name="formInfosPatient" property="dateCreation"  />
						  </td>
		                 </tr>
		                <tr>
		                 <td width="22%">Fin validité</td>
		                 <td width="25%" style="color: #FF6600;">
						    <bean:write name="formInfosPatient" property="finValidite"  />
						 </td>	
						 <td width="6%"></td>	                 
		                 <td width="22%">Plafond</td>
		                 <td width="25%" style="color: #FF6600;">
		                     <bean:write name="formInfosPatient" property="plafond"  />
						 </td>
		                 </tr>
		                <tr>
		                <td width="22%">Pourcentage</td>
		                 <td width="25%" style="color: #FF6600;">
						    <bean:write name="formInfosPatient" property="pourcentage"  />
						 </td>
		               	<td colspan="3"></td>
		                 </tr>
						</table>
					</div>
				</td>
			</tr>
		
		  <tr style="background:#00253E"><td align="center" colspan="5" style="background:#00253E">
		  <input type="button" onclick="valider();" value="Suivant" size ="50" style="font-weight:bold; background-color:#00253E; color:#FFFFFF; cursor:hand; border:solid 2px #FF6600;"  />
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