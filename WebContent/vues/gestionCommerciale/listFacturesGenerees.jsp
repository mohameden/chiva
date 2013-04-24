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

			$.datepicker.setDefaults($.datepicker.regional['fr']);
			
			$.datepicker.setDefaults({
				showOn: 'button',
				buttonImage: '<%=request.getContextPath()%>/images/calendar.gif',
				buttonImageOnly: true,
				changeMonth: true,
				changeYear: true,
				showAnim: "blind",
				yearRange: '1930:2030' });

			$("#dateDebutRechFact").datepicker({yearRange: '2010:2018'});
			$("#dateFinRechFact").datepicker({yearRange: '2010:2018'});			


			$('#dialog').dialog({
				autoOpen: false,
				modal: true,
				width: 400,
				height:150,
				show: "slide",
		        hide: "slide"
			});
			
		
		});

		 function checkDates()
		   {
			   if (document.forms[0].dateDebutRechFact.value!="")
			     {
				   if (document.forms[0].dateFinRechFact.value!="")
				    { 
					   if(verifierDate(document.forms[0].dateDebutRechFact.value)!=false)
					    {
						   if(verifierDate(document.forms[0].dateFinRechFact.value)!=false)
						    {
							  return true;    
						    }
						   else
						   {
							   document.getElementById("dialog").innerHTML = 
									"<font style=\"oblique\" color=\"#FFFFFF\"  size=\"2\">Date fin est incorrect!!!<\/font>";
								$('#dialog').dialog('open');
							   return false;
						   }   
					    }
					   else 
					   {
						   document.getElementById("dialog").innerHTML = 
								"<font style=\"oblique\" color=\"#FFFFFF\"  size=\"2\">Date début est incorrect!!!<\/font>";
							$('#dialog').dialog('open');
						   return false; 
					   }
				    }
				   else
				   {
					   document.getElementById("dialog").innerHTML = 
							"<font style=\"oblique\" color=\"#FFFFFF\"  size=\"2\">Veuillez saisir Date fin<\/font>";
						$('#dialog').dialog('open');
					   return false;
				   } 
			     }
			   else 
			   {
				   document.getElementById("dialog").innerHTML = 
						"<font style=\"oblique\" color=\"#FFFFFF\"  size=\"2\">Veuillez saisir Date début<\/font>";
					$('#dialog').dialog('open');
				   return false;
			   }
		   }

		function comparDate()
		{
		var sdate1 = document.getElementById('dateDebutRechFact').value;
		var date1 = new Date();
		date1.setFullYear(sdate1.substr(6,4));
		date1.setMonth(sdate1.substr(3,2));
		date1.setDate(sdate1.substr(0,2));
		date1.setHours(0);
		date1.setMinutes(0);
		date1.setSeconds(0);
		date1.setMilliseconds(0);
		var d1=date1.getTime();


		var sdate2 = document.getElementById('dateFinRechFact').value;
		var date2 = new Date();
		date2.setFullYear(sdate2.substr(6,4));
		date2.setMonth(sdate2.substr(3,2));
		date2.setDate(sdate2.substr(0,2));
		date2.setHours(0);
		date2.setMinutes(0);
		date2.setSeconds(0);
		date2.setMilliseconds(0);
		var d2=date2.getTime();
		d1 = d1 / 86400000;
		d2 = d2 / 86400000;

		var t2=Number(d2 - d1);

		
		//si la date d'arrviée et superieur a la date de depart en afficher un message d'erreur
		if(t2 >= 0)
		{	
			if(t2 <= 30) 
			{
				return true;
			}
			else
			{
				document.getElementById("dialog").innerHTML = 
					"<font style=\"oblique\" color=\"#FFFFFF\"  size=\"2\">La différence entre date début et date fin doit etre au max 30 jours<\/font>";
				$('#dialog').dialog('open');

				return false;
			}  
			
			
		}
		else
		{
			document.getElementById("dialog").innerHTML = 
				"<font style=\"oblique\" color=\"#FFFFFF\"  size=\"2\">La date début doit être postérieure à la date fin<\/font>";
			$('#dialog').dialog('open');
			return false;
		}

		}


		function checkChamps()
		   {
		     var msg=false;
		     if (!checkDates())
		     {
		    	 msg=true;
		     }
			 else if(!comparDate())
			 {
			    msg=true;
			 }

		    
		     if (msg==false)
		     {
			     document.forms[0].dispatch.value="listFacturesAgenerer"; 
			     document.forms[0].submit();
		     } 
		   }


function changerChambre(var1)
{
	document.forms[0].hospitalisaionId.value = var1;
	document.forms[0].dispatch.value = "showHospForChangeChambre";
	document.forms[0].submit();
	
}



function modifierFactureAssureur(var1)
{
	document.forms[0].factureModifieeId.value = var1;
	document.forms[0].dispatch.value = "showPatientForModifiationFacture";
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
<input type="hidden" name="factureModifieeId" /> 
<input type="hidden" name="subAction"/>


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
<font  style="oblique" color="#FF6600"  size="5">Facturation</font></td>

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
            <td colspan="4" style="font-weight:bold"><font style="oblique" color="#FFFFFF"  size="4"> Factures Assureurs </font></td>
          </tr>
		  <tr align="center">
		   <td colspan="4" align="center">
		     <display:table id="row"  name="sessionScope.formInfosPatient.facturesAmodifierList"  class="mars" pagesize="5" defaultsort="1" defaultorder="descending" >
		<display:setProperty name="paging.banner.placement" value="bottom"></display:setProperty>
		<display:setProperty name="css.tr.even" value="even"></display:setProperty>
		   	
				<display:column style=" text-decoration: underline;" title="modifier">
					<a id="dialog_link" style="cursor: pointer" onclick="modifierFactureAssureur('<bean:write name="row" property="factureModifieeId"/>');">
					<img align="middle"    src="<%=request.getContextPath()%>/<bean:message key="image.edit" />" />
					</a>
				</display:column>
		 	 
		 	<display:column  property="factureModifieeId" title="Num facture" sortProperty="nom"/>
		 	<display:column property="dateFact" title="date facture" format="{0,date,dd/MM/yyyy}"/>
			<display:column  property="patient.nom" title="Nom" sortProperty="nom"/>
			<display:column  property="patient.prenom" title="Prénom"  />
			
					</display:table>
		   </td>
		  </tr>

       
		  </table>
		   </td></tr>
		  </table>
           
		  </td>
		  </tr>
		  </table>
		  
		  <div id="dialog" title="Message"  style="background:#00253E;" >
         </div>

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