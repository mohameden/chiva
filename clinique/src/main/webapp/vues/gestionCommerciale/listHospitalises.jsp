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

 
		$(window).load(function(){

			});


		$.fx.speeds._default = 1000;
		$(function() {

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
						document.forms[0].dispatch.value = "ajouterChambreAncienHosp";
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
				height:100,
				show: "slide",
		        hide: "slide"
			});
			
		
		});


function changerChambre(var1)
{
	document.forms[0].hospitalisaionId.value = var1;
	document.forms[0].dispatch.value = "showHospForChangeChambre";
	document.forms[0].submit();
	
}



function ajouterPrestation(var1)
{
	document.forms[0].hospitalisaionId.value = var1;
	document.forms[0].dispatch.value = "addPrestationHosp";
	document.forms[0].submit();
	
}

function sortieHosp(var1)
{
	document.forms[0].hospitalisaionId.value = var1;
	document.forms[0].dispatch.value = "showSortieHosp";
	document.forms[0].submit();
	
}

function libererChambre(var1)
{
	document.forms[0].hospitalisaionId.value = var1;
	document.forms[0].dispatch.value = "showLibererChambreHosp";
	document.forms[0].submit();
	
}

function regHosp(var1)
{
	document.forms[0].hospitalisaionId.value = var1;
	document.forms[0].dispatch.value = "showSortieHospChambreDejaLibre";
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
<input type="hidden" name="patientId"/>
<input type="hidden" name="hospitalisaionId"/>
<input type="hidden" name="subAction"/>
<input type="hidden" name="typeSortie"/>

<input type="hidden" name="operation" value="<bean:write name="formInfosPatient" property="operation" />"/>



<html:errors bundle="erreurGestionCommerciale"/>



<table width="100%"   align="center" style="background:#00253E; ">   
		 <tr><td>
		  
		  <table width="80%" align="center" bgcolor="#00253E">
		  <tr> 
		  <td colspan="2">
		  <table cellspacing="0" width="100%"   align="left"  style=" border-color:#FF6600; border-width:1px; border-style:solid; border-left:none;   border-right:none; border-top:none;">
		  <tr>
		 <td colspan="5">
<font  style="oblique" color="#FF6600"  size="5">Hospitalisation</font></td>

		  </tr>
		 
		
		  </table>
		  </td>
		  </tr>
		  <tr><td colspan="2"></td></tr>
		  <tr>
		  <td colspan="2">	  
		  
		  <table width="100%"   align="center" style="background:#0B415F; ">
		  <tr><td>
		  <table width="100%" align="center" style="background:#00253E; font-size:14; font-weight:bold; color: white;">
		  <tr  align="center" style="background:#0B415F; border-left-color:#CBE4F4; border-left-style:solid;" >
            <td colspan="4" style="font-weight:bold"><font style="oblique" color="#FFFFFF"  size="4"> Liste des hospitalisés </font></td>
          </tr>
		  <tr align="center">
		   <td colspan="4" align="center">
		     <display:table id="row"  name="sessionScope.formInfosPatient.hopitalises"  class="mars" pagesize="5" defaultsort="1" defaultorder="descending" >
		<display:setProperty name="paging.banner.placement" value="bottom"></display:setProperty>
		<display:setProperty name="css.tr.even" value="even"></display:setProperty>
		   
				<display:column style=" text-decoration: underline;" title="Réglement">
				  <logic:equal name="row" property="encours" value="2">
					<a id="dialog_link" style="cursor: pointer" onclick="regHosp('<bean:write name="row" property="hospitalisationId"/>');">
					<img align="middle"    src="<%=request.getContextPath()%>/<bean:message key="image.fin" />" />
					</a>
				  </logic:equal>
				</display:column>
				
				<display:column style=" text-decoration: underline;" title="Sortie">
				<logic:equal name="row" property="encours" value="1">
					<a id="dialog_link" style="cursor: pointer" onclick="sortieHosp('<bean:write name="row" property="hospitalisationId"/>');">
					<img align="middle"    src="<%=request.getContextPath()%>/<bean:message key="image.fin" />" />
					</a>
				</logic:equal>
				</display:column>
				
				<display:column style=" text-decoration: underline;" title="Libérer la chambre">
				<logic:equal name="row" property="encours" value="1">
					<a id="dialog_link" style="cursor: pointer" onclick="libererChambre('<bean:write name="row" property="hospitalisationId"/>');">
					<img align="middle"    src="<%=request.getContextPath()%>/<bean:message key="image.fin" />" />
					</a>
				</logic:equal>
				</display:column>
				
				<display:column style=" text-decoration: underline;" title="Changer chambre">
				<logic:equal name="row" property="encours" value="1">
					<a id="dialog_link" style="cursor: pointer" onclick="changerChambre('<bean:write name="row" property="hospitalisationId"/>');">
					<img align="middle"    src="<%=request.getContextPath()%>/<bean:message key="image.edit" />" />
					</a>
					</logic:equal>
				</display:column>
				
				<display:column style=" text-decoration: underline;" title="ajouter prestation">
				<logic:equal name="row" property="encours" value="1">
					<a id="dialog_link" style="cursor: pointer" onclick="ajouterPrestation('<bean:write name="row" property="hospitalisationId"/>');">
					<img align="middle"    src="<%=request.getContextPath()%>/<bean:message key="image.add" />" />
					</a>
					</logic:equal>
				</display:column>
		 	 
		 	<display:column  property="patient.patientId" title="Num patient" sortProperty="nom"/>
			<display:column  property="patient.nom" title="Nom" sortProperty="nom"/>
			<display:column  property="patient.prenom" title="Prénom"  />
			<display:column  property="chambre.chambreLibelle" title="Chambre"  />
			<display:column property="dateEntree" title="date entree" format="{0,date,dd/MM/yyyy}"/>
			
					</display:table>
		   </td>
		  </tr>

       
		  </table>
		   </td></tr>
		  </table>

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