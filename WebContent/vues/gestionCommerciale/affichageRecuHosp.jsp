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

function imprimer(var1)
{
	document.forms[0].recuId.value=var1;
	document.forms[0].dispatch.value = "imprimer";
	document.forms[0].submit();
	
}

function couleurBlanc(obj,var1) {
	obj.style.border= "solid 1px white";
	document.getElementById(var1).style.display='none';  
	 
}

function couleurRouge(obj) {
     obj.style.border= "solid 1px red";   
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

function cacherDivErr()
{
	var id=document.forms[0].typePayementId.value;
	var description=document.forms[0].description;
	var montant=document.forms[0].typePayementValeur;
    
	switch (id)
	{
		case '1':
			couleurBlanc(montant,'ErrMontant');	
			 document.getElementById('ErrDescription').style.display='none';
			break;
		case '2':
			couleurBlanc(montant,'ErrMontant');	
			couleurBlanc(description,'ErrDescription');	
			break;
		case '3':
			couleurBlanc(montant,'ErrMontant');	
			couleurBlanc(description,'ErrDescription');	
			break;
		case '4':
			couleurBlanc(montant,'ErrMontant');
			document.getElementById('ErrDescription').style.display='none';
			break;
		default : 
			break;
	}
}

function supprimerReglement(var1)
{
	
	document.forms[0].idReglementAsupprimer.value=var1;
	   document.forms[0].dispatch.value="supprimerReglement"; 
	   document.forms[0].submit(); 
}




		$(window).load(function(){
			
			});

		function checkDescription()
		{
			var description=document.forms[0].description;
			var divDescription=document.getElementById ("ErrDescription");

			if (description.value.replace(/^\s+|\s+$/g, "")=="")
			{
				couleurRouge(montant);
				divDescription.style.display='block';
			   return false;
			}
			else
			{
			 return true;
			}
			
		}

		function checkMontant()
		{
			var montant=document.forms[0].typePayementValeur;
			var resteApayer=document.forms[0].resteApayer.value;
			var divMontant=document.getElementById ("typePayementValeur");
			var divMontant=document.getElementById ("ErrMontant");
    
			if ((montant.value=="") || (parseInt(montant.value) > (parseInt(resteApayer)+5)))
			{
				couleurRouge(montant);
				divMontant.style.display='block';
			   return false;
			}
			else
			{
			 return true;
			}
			
		}

		function checkReglement()
		{
			var id=document.forms[0].typePayementId.value;
			switch (id)
			{
				case '1':
					if (checkMontant())
					{
						document.forms[0].dispatch.value = "addReglement";
						document.forms[0].submit();
					}	
						
					break;
				case '2':
					
					if (checkMontant() && checkDescription())
					{
						document.forms[0].dispatch.value = "addReglement";
						document.forms[0].submit();
					}	
					break;
				case '3':
					if (checkMontant() && checkDescription())
					{
						document.forms[0].dispatch.value = "addReglement";
						document.forms[0].submit();
					}	
					break;
				case '4':
					if (checkMontant())
					{
						document.forms[0].dispatch.value = "addReglement";
						document.forms[0].submit();
					}	
					
					break;
				default : 
					break;
			}
					
		}

function afficherDivPay(var1)
{
	var divPayement1=document.getElementById ("divPayement1");
	var divCheque=document.getElementById ("cheque");
	var divPayElec=document.getElementById ("payElec");
	var divPayement2=document.getElementById ("divPayement2");

    var id=var1.value;
    
	switch (id)
	{
		case '1':
			divPayement1.style.display = 'none';
			divPayement2.style.display = 'none';		
			break;
		case '2':
			divPayement1.style.display = 'block';
			divCheque.style.display = 'block';
			divPayElec.style.display = 'none';
			divPayement2.style.display = 'none';
			break;
		case '3':
			divPayement1.style.display = 'block';
			divCheque.style.display = 'none';
			divPayElec.style.display = 'block';
			divPayement2.style.display = 'none';
			break;
		case '4':
			divPayement1.style.display = 'none';
			divCheque.style.display = 'none';
			divPayElec.style.display = 'none';
			divPayement2.style.display = 'block';
			break;
		default : 
			break;
	}
}


function afficherTypePayement()
{
	var idDiv = document.getElementById ("divReglement");
	idDiv.style.display = 'block';

	afficherDivPay(document.getElementById ("typePayementId"));
	
	var btnAddTypePay = document.getElementById ("btnAddTypePay");
	btnAddTypePay.style.display = 'none';
}

function masquerTypePayement()
{
	var idDiv = document.getElementById ("divReglement");
	idDiv.style.display = 'none';

	var btnAddTypePay = document.getElementById ("btnAddTypePay");
	btnAddTypePay.style.display = 'block';

	

}


	
</script>

</head>

<body>
<div class=demos>
<table bordercolor="#FF6600;" height="100%"  width="100%" align="center" style="border-right-style:solid; border-left-style:solid; border-top-style:solid; border-bottom-style:solid;">
<jsp:include page="/template/header.jsp" />
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
<input type="hidden" name="resteApayer" value="<bean:write name="formInfosPatient" property="resteApayer" />"/>
<input type="hidden" name="patientId" value="<bean:write name="formInfosPatient" property="patientId" />"/>
<input type="hidden" name="idReglementAsupprimer"/>
<input type="hidden" name="operation" value="<bean:write name="formInfosPatient" property="operation" />"/>

<table  align="center" bgcolor="#00253E" style="color:#E70739; font-weight:bold;  font-size:16; margin-bottom: 5px;">
	<tr bgcolor="white" align="left" id="ErrNombre" style="display: none">
	<td> Le nombre  doit etre superieur ou egal a 0 </td>
	</tr>
	<tr bgcolor="white" align="left" id="ErrMontant" style="display: none">
	<td> Le nombre  doit etre superieur ou egal a 0 et inférieur ou égal a "reste à payer"  </td>
	</tr>
	<tr bgcolor="white" align="left" id="ErrDescription" style="display: none">
	<td> Veuillez remplir le champ vide  </td>
	</tr>
	</table>

<table width="100%"   align="center" style="background:#00253E; ">
           
          
		 <tr><td>
		  
		  <table width="80%" align="center" bgcolor="#00253E">
		 
		  <tr> 
		  <td colspan="2">
		  <table cellspacing="0" width="100%" align="center"  align="left"  style=" border-color:#FF6600; border-width:1px; border-style:solid; border-left:none;   border-right:none; border-top:none;">
		  <tr>
		 <td colspan="2">
<font  style="oblique" color="#FF6600"  size="5">Reçu</font></td>
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
		  </table>
		  
		  </td>
		  </tr>
		
		  <tr>
		  <td colspan="2">
		  <table width="100%"   align="center" style="background:#0B415F; ">
		  		  
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
		  
		  <!-- ui-dialog -->

		  </td>
		  </tr>
		  
		   <tr>
		  		  <td colspan="2">
		  		  <table width="100%" align="left" style="background:#00253E; font-size:14; font-weight:bold; color: white;">
		  <tr  align="center" style="background:#0B415F; border-left-color:#CBE4F4; border-left-style:solid;" >
            <td colspan="4" style="font-weight:bold"><font style="oblique" color="#FFFFFF"  size="4"> Frais des chambres </font></td>
          </tr>
	<tr><td colspan="4" align="center" width="100%">
  <display:table id="row"  name="sessionScope.formInfosPatient.chambresHospList"  class="mars" pagesize="5" defaultsort="1" defaultorder="descending" >
		<display:setProperty name="paging.banner.placement" value="bottom"></display:setProperty>
		<display:setProperty name="css.tr.even" value="even"></display:setProperty>
		   

		 	
			<display:column  property="chambre.chambreLibelle" title="chambre" />
				
			<display:column property="dateEntree" title="date entree" format="{0,date,dd/MM/yyyy}"/>
			<display:column  property="heureEntree" title="heure entree" />
			<display:column  property="heureSortie" title="heure sortie" />
			<display:column property="dateSortie" title="date sortie" format="{0,date,dd/MM/yyyy}"/>

			<display:column  property="total" title="montant" />
			
			
					</display:table>
		  		  </td>
		  		  </tr>
		  		    
		  		  </table>
		  		  </td>
		  		  </tr>
		  
		  
		  <tr>
		  <td colspan="2">
		  <table width="100%"   align="center" style="background:#0B415F; ">
		  		  
		  		  <tr>
		  		  <td>
		  <table width="100%" align="left" style="background:#00253E; font-size:14; font-weight:bold; color: white;">
		  <tr  align="center" style="background:#0B415F; border-left-color:#CBE4F4; border-left-style:solid;" >
            <td colspan="5" style="font-weight:bold"><font style="oblique" color="#FFFFFF"  size="4"> Réglement  </font></td>
          </tr>
          <tr>
          <td width="22%">Total A payer</td>
          <td width="25%" style="color: #FF6600;"><bean:write name="formInfosPatient" property="totalApayer" /></td>
          <td width="6%"></td>
          <td width="22%">quote Part Clinique</td>
          <td width="25%" style="color: #FF6600;"><bean:write name="formInfosPatient" property="coteClinique" /></td>
          </tr>
          
          <tr>
          <td width="22%">A payer par assureur</td>
          <td width="25%" style="color: #FF6600;"><bean:write name="formInfosPatient" property="coteAssureur" /></td>
          <td width="6%"></td>
          <td width="22%">
           Remise
          </td>
          <td width="25%" style="color: #FF6600;">
            <bean:write name="formInfosPatient" property="remiseMontant" /> 
          </td>
          </tr>

          </table>
		  </td>
		  </tr>
		  </table>
		  </td>
		  </tr>
		  <tr>
			  <td colspan="2" align="center" width="100%">
			  
			  <table width="100%"   align="center" style="background:#0B415F; ">
		  		  
		  		  <tr>
		  		  <td>
			  
				  <table width="100%" align="left" style="background:#00253E; font-size:14; font-weight:bold; color: white;">
				  <tr  align="center" style="background:#0B415F; border-left-color:#CBE4F4; border-left-style:solid;" >
					<td colspan="4" style="font-weight:bold"><font style="oblique" color="#FFFFFF"  size="4"> Liste des réglements </font></td>
				  </tr>
				  <tr  align="center">
					<td colspan="4"> 
					  <display:table id="row"  name="sessionScope.formInfosPatient.reglementsList"  class="mars" pagesize="5" defaultsort="1" defaultorder="descending" >
						<display:setProperty name="paging.banner.placement" value="bottom"></display:setProperty>
						<display:setProperty name="css.tr.even" value="even"></display:setProperty>
						   

							
							<display:column  property="typePayement.typePayement" title="Type Payement" />
							<display:column  property="montant" title="Montant" />	
							<display:column  property="description" title="Description" />
						</display:table>
					</td>
				  </tr>
				  <tr  align="center">
					<td colspan="4"> 
					
					<input type="button"   onclick="" value="Imprimer" size ="50" style="font-weight:bold; background-color:#00253E; color:#FFFFFF; cursor:hand; border:solid 2px #FF6600;"  />
					
					</td>
					</tr>
				   
				  </table>
				  </td>
				  </tr>
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