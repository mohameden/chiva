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

function afficherRecu()
{
	document.forms[0].dispatch.value = "afficherRecu";
	document.forms[0].submit();

	document.forms[1].dispatch.value = "imprimerRecu";
	document.forms[1].submit();
}

function afficherRecuCNAM()
{
	
	document.forms[0].dispatch.value = "afficherRecuCNAM";
	document.forms[0].submit();

	document.forms[1].dispatch.value = "imprimerRecu";
	document.forms[1].submit();
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
			var IdTypePayment=document.forms[0].typePayementId;
			var resteApayer=document.forms[0].resteApayer.value;
			var resteApayerMajoration=document.forms[0].resteApayerMajoration.value;
			var divMontant=document.getElementById ("typePayementValeur");
			var divMontant=document.getElementById ("ErrMontant");

            if (IdTypePayment.value=="1")
            {
            	
				if ((montant.value=="") || (parseInt(montant.value) > (parseInt(resteApayer)+999)))
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
            else
            {
                
            	if ((montant.value=="") || (parseInt(montant.value) > (parseInt(resteApayerMajoration)+999)))
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
	var divCash=document.getElementById ("divCash");
	var divMajoration=document.getElementById ("divMajoration");

    var id=var1.value;
    
	switch (id)
	{
		case '1':
			divPayement1.style.display = 'none';
			divPayement2.style.display = 'none';
			//divCash.style.display = 'block';
			//divMajoration.style.display = 'none';
			document.forms[0].typePayementValeur.value = "";	
			break;
		case '2':
			divPayement1.style.display = 'block';
			divCheque.style.display = 'block';
			divPayElec.style.display = 'none';
			divPayement2.style.display = 'none';
			//divCash.style.display = 'none';
			//divMajoration.style.display = 'block';
			document.forms[0].typePayementValeur.value = "";
			document.forms[0].description.value = "";
			break;
		case '3':
			divPayement1.style.display = 'block';
			divCheque.style.display = 'none';
			divPayElec.style.display = 'block';
			divPayement2.style.display = 'none';
			//divCash.style.display = 'none';
			//divMajoration.style.display = 'block';
			document.forms[0].typePayementValeur.value = "";
			document.forms[0].description.value = "";
			break;
		case '4':
			divPayement1.style.display = 'none';
			divCheque.style.display = 'none';
			divPayElec.style.display = 'none';
			divPayement2.style.display = 'block';
			//divCash.style.display = 'none';
			//divMajoration.style.display = 'block';
			document.forms[0].typePayementValeur.value = "";
			break;
		default : 
			break;
	}

    if (document.forms[0].modeReglement[0].checked)
    {
	divCash.style.display = 'block';
	divMajoration.style.display = 'none';
    }
    
    else
    {
    	divCash.style.display = 'none';
    	divMajoration.style.display = 'block';
    }
}

function afficherModeReglement(var1)
{
	var url="<%=request.getContextPath()%>/InitServlet?actionXML=afficherReglement&modeReglement="+var1;
	remplirHtmlSelectFromAjaxRequest(url,document.forms[0].typePayementId);
	afficherTypePayement();
	//afficherModeImmediat(document.forms[0].typePayementId);
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
<tr style="background:#0B415F;">
<td height="20">
<table width="100%">
<tr>
<td width="70%"></td>
	<td>
	  <span class="prestations2">
	<a href="javascript:document.forms[0].dispatch.value='infosPatient'; document.forms[0].submit();" ></a>
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
<input type="hidden" name="idReglementAsupprimer"/>
<input type="hidden" name="resteApayer" value="<bean:write name="formInfosPatient" property="resteApayer" />"/>
<input type="hidden" name="recuRegle" />
<input type="hidden" name="resteApayerMajoration" value="<bean:write name="formInfosPatient" property="resteApayerMajoration" />"/>
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
<font  style="oblique" color="#FF6600"  size="5">Réglement reçu</font></td>
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
		  <table width="100%"   align="center" style="background:#0B415F; ">
		  		  
		  		  <tr>
		  		  <td>
		  <table width="100%" align="left" style="background:#00253E; font-size:14; font-weight:bold; color: white;">
		 
          
          <tr>
          <td align="center" width="100%"><logic:equal name="formInfosPatient" property="recuRegle" value="0">
          <input type="button" id="btnAddTypePay"  onclick="afficherTypePayement();" value="Ajouter type payement" size ="50" style="font-weight:bold; background-color:#00253E; color:#FFFFFF; cursor:hand; border:solid 2px #FF6600;"  />
          </logic:equal></td>
          </tr>
      
          <tr>
          <td colspan="5" align="center">
          
          </td>
          </tr>
          </table>
		  </td>
		  </tr>
		  </table>
		  </td>
		  </tr>
		  <tr id="divReglement" style="display:none;">
			  <td colspan="2">
			  <table width="100%"   align="center" style="background:#0B415F; ">
		  		  <tr>
		  		  <td>
			  <table width="100%" align="center" style="background:#00253E; font-size:14; font-weight:bold; color: white;">
		  <tr  align="center" style="background:#0B415F; border-left-color:#CBE4F4; border-left-style:solid;" >
            <td colspan="2" style="font-weight:bold"><font style="oblique" color="#FFFFFF"  size="4"> Mode réglement  </font></td>
          </tr>
          <tr>
          <td width="50%">Mode réglement</td>
          <td width="50%" style="color: #FF6600;">
	          <html:radio property="modeReglement" name="formInfosPatient" onclick="afficherModeReglement('immediat');" value="immediat"/>Immédiat
		      <html:radio property="modeReglement" name="formInfosPatient" onclick="afficherModeReglement('differe');" value="differe"/>Différé
          </td>
          </tr>
          <tr>
          <td width="50%">Type payement</td>
          <td width="50%" style="color: #FF6600;">
	          <html:select  styleClass="champText"  property="typePayementId" onchange="afficherDivPay(this); cacherDivErr(); ">
				<html:optionsCollection name="formInfosPatient" property="typePayementList"  label="label" value="value" />
			  </html:select>
          </td>
          </tr>
          <tr id="divPayement1" style="display: none">
           <td>
	           <div id="cheque" style="display: none">Cheque</div>
	           <div id="payElec" style="display: none">Carte bancaire</div>
           </td>
           <td>
            <html:text styleClass="champText" property="description" onfocus="couleurBlanc(this,'ErrDescription');"  size ="23"/>
           </td>
          </tr>
           <tr id="divPayement2" style="display: none">
           <td>
           PC personne
           </td>
           <td>
             <html:select  styleClass="champText"  property="pcPersonnelId">
				<html:optionsCollection name="formInfosPatient" property="pcPersonnelList"  label="label" value="value" />
			  </html:select>
           </td>
          </tr>
          <tr>
          <td width="50%">Montant</td>
          <td width="50%">
          <html:text styleClass="champText" property="typePayementValeur" onkeypress="Numerique();" onfocus="couleurBlanc(this,'ErrMontant');"  size ="23"/>
          </td>
          </tr>
          <tr id="divCash" style="display: none">
           <td>Reste a payer</td>
           <td><bean:write name="formInfosPatient" property="resteApayer" /></td>
          </tr>
          <tr id="divMajoration" style="display: none">
           <td>Reste a payer</td>
           <td><bean:write name="formInfosPatient" property="resteApayerMajoration" /></td>
          </tr>
          <tr>
          <td colspan="2" align="center">
         
          <input type="button"   value="Valider" onclick="checkReglement();" size ="50" style="font-weight:bold; background-color:#00253E; color:#FFFFFF; cursor:hand; border:solid 2px #FF6600;"  />
          
          <input type="button"   value="Annuler" onclick="cacherDivErr(); masquerTypePayement();" size ="50" style="font-weight:bold; background-color:#00253E; color:#FFFFFF; cursor:hand; border:solid 2px #FF6600;"  />

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
							<display:column style=" text-decoration: underline;" title="Supprimer">
							 <a  style="cursor: pointer" onclick="supprimerReglement('<bean:write name="row" property="reglementId"/>');">
							   <img align="middle" height="10" width="10"   src="<%=request.getContextPath()%>/<bean:message key="image.delete" />" />
							 </a> 
							</display:column>
							
							
							
									</display:table>
					</td>
				  </tr>
				   <tr  align="center">
					<td colspan="4"> 
					<logic:notEqual name="formInfosPatient" property="recuRegle" value="0">
					
					 <logic:notEqual name="formInfosPatient" property="libeleAssureur" value="CNAM">
					    <input type="button"   onclick="afficherRecu();" value="Valider Réglement" size ="50" style="font-weight:bold; background-color:#00253E; color:#FFFFFF; cursor:hand; border:solid 2px #FF6600;"  />
					 </logic:notEqual>
					 
					 <logic:equal name="formInfosPatient" property="libeleAssureur" value="CNAM">
					    <input type="button"   onclick="afficherRecuCNAM();" value="Valider Réglement" size ="50" style="font-weight:bold; background-color:#00253E; color:#FFFFFF; cursor:hand; border:solid 2px #FF6600;"  />
					 </logic:equal>
					 
					</logic:notEqual>
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

<html:form action="/patientAction" target="_blank">
<input type="hidden" name="dispatch"/>

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