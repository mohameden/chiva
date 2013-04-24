<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

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
<title>Retirer une quantité du produit du stock</title>

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
			if(document.forms[0].estEffWithSuccess.value=="true")
			{
				viderChamps();
			}
			});
		function rechercher ()
    	{
        	
        	document.forms[0].dispatch.value = "chercher";
        	document.forms[0].submit();
    	}

		
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
			$("#dateDerniereVisteR").datepicker({yearRange: '1990:2030'});

			
		});
		function check()
		{
			saved=true;
			if(document.forms[0].quantiteStockSortie.value=="")
			{
				document.getElementById("erreurQuantiteStockSortie").style.display='block';
				saved=false;
				return;
			}
			else
			{
				document.getElementById("erreurQuantiteStockSortie").style.display='none';
			}
			if(document.forms[0].dateStockEntree.value=="")
			{				
				document.getElementById("erreurDateStockSortie").style.display='block';
				saved=false;
				return;
			}
			else
			{
				document.getElementById("erreurDateStockSortie").style.display='none';
			}
			if(document.forms[0].prixProduit.value=="")
			{
				document.getElementById("erreurPrixProduit").style.display='block';
				saved=false;
				return;
			}
			else
			{
				document.getElementById("erreurPrixProduit").style.display='none';
			}
			if(saved==true)
			{
				save();
			}
			
		}
		function save()
		{
			document.forms[0].dispatch.value="saveSortieStock";
			document.forms[0].submit();
		}
		function hideErrors()
		{
			document.getElementById("erreurAjoutSortieStock").style.display='none';
			document.getElementById("succes").style.display='none';
			document.getElementById("erreurDateStockSortie").style.display='none';
			document.getElementById("erreurQuantiteStockSortie").style.display='none';
			document.getElementById("erreurPrixProduit").style.display='none';
		}
		function viderChamps()
		{
			document.forms[0].dateStockEntree.value="";
			document.forms[0].quantiteStockSortie.value="";
			document.forms[0].prixProduit.value="";
		}
		function chargerProduit()
		{
			var url="<%=request.getContextPath()%>/InitServlet?actionXML=getProduit&id_produit="+document.forms[0].produitId.value;
			var objXML=getXMLResponse(url);
			var produit=new Produit();
			produit.loadProduit(objXML);
			document.forms[0].quantiteDisponibleProduit.value=produit.quantite_disponible;
			document.forms[0].prixProduit.value=produit.prix;
			alert("2");
		}
</script>

</head>

<body>
<div class=demos>
<table bordercolor="#FF6600;" height="100%"  width="100%" align="center" style="border-right-style:solid; border-left-style:solid; border-top-style:solid; border-bottom-style:solid;">

<tr bgcolor="#00253E"  align="center" >
<td  align="center" height="80" > 
<table width="100%">
<tr>
<td width="33%"><img  height="75" align="bottom" style="margin-left:0; margin-bottom: 2; margin-top: 3;"   width="200" src="<%=request.getContextPath()%>/images/entete.jpg"  /></td>
<td width="33%" align="center">

 <img align="bottom"  src="<%=request.getContextPath()%>/images/titre3.gif" />
 </td>
 <td width="34%" align="center"></td>
 </tr>
 </table>
</td> 
</tr>

<tr style="background:#0B415F;">
<td height="20">
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
<html:form action="/gestionStockAction.do">
<input type="hidden" name="dispatch"/>
<html:hidden property="estEffWithSuccess"/>
<div id="erreurs" align="center">
<div id="erreurAjoutSortieStock">
<font color="#FF0000"  size="5">
<html:errors bundle="erreurGestionStock"/>
</font>
</div>
<logic:equal name="formGestionStock" property="estEffWithSuccess" value="true">
<div id="succes">
<table align="center"  WIDTH="300" style="margin-top:15px; font-size: 12px; color:red; ">
			<tr>
				<td align="center">
				<font color="#0000FF"  size="5">
				Opération efféctuée avec succès
				</font>
				</td>
			</tr>
</table>
</div>
</logic:equal>
<div id="erreurDateStockSortie" style="display: none">
<table align="center"  WIDTH="300" style="margin-top:15px; font-size: 12px; color:red; ">
		<tr align="center">
			<td>
			<font color="#FF0000"  size="5">
			Veuillez entrer la date du sortie du produit
			</font>
			</td>
		</tr>
</table>
</div>
<div id="erreurQuantiteStockSortie" style="display: none">
<table align="center"  WIDTH="300" style="margin-top:15px; font-size: 12px; color:red; ">
		<tr align="center">
			<td>
			<font color="#FF0000"  size="5">
			Veuillez saisir la quantite sortante du produit
			</font>
			</td>
		</tr>
</table>
</div>
<div id="erreurPrixProduit" style="display: none">
<table align="center"  WIDTH="300" style="margin-top:15px; font-size: 12px; color:red; ">
		<tr align="center">
			<td>
			<font color="#FF0000"  size="5">
			Veuillez saisir le prix du vente du produit
			</font>
			</td>
		</tr>
</table>
</div>
</div>
<table width="100%"   align="center" style="background:#00253E; ">
           
          
		 <tr><td>
		  
		  <table width="80%" align="center" bgcolor="#00253E">
		 
		  <tr> 
		  <td colspan="2">
		  <table cellspacing="0" width="100%" align="center"  align="left"  style=" border-color:#FF6600; border-width:1px; border-style:solid; border-left:none;   border-right:none; border-top:none;">
		  <tr>
		 <td colspan="2">
<font  style="oblique" color="#FF6600"  size="5">Ajouter une sortie du stock</font></td>
<td width="15%"></td>
		  </tr>
		 
		
		  </table>
		  </td>
		  </tr>
		  <tr><td colspan="2"></td></tr>
		  <tr>
		  <td colspan="2">	  
		  <div id="formulAjoutSortieStock" style="display: block">
		  <table width="100%"   align="center" style="background:#0B415F; ">
		  <tr><td>
		  <table width="100%" align="left" style="background:#00253E; font-size:14; font-weight:bold; color: white;">
		  <tr>
		  <td width="19%" >Produit</td>
		  <td width="31%">
		  <html:select property="produitId" onchange="chargerProduit();">
		  <html:optionsCollection name="formGestionStock" property="produitsList" label="label" value="value" />
		  </html:select>
		  </td>
		  </tr>
		  <tr>
		  <td width="19%" >Quantité Disponible</td>
		  <td width="31%"><html:text styleClass="champText" property="quantiteDisponibleProduit" size ="25" onkeypress="Numerique();" onfocus="hideErrors();" readonly="true"/></td>
		  <td width="19%">Prix Unitaire</td>
		  <td width="31%"><html:text styleClass="champText" property="prixProduit" size ="8" readonly="true"/></td>
		  </tr>
		  <tr>
		  <td width="19%" >Quantité Sortante</td>
		  <td width="31%"><html:text styleClass="champText" property="quantiteStockSortie" size ="25" onkeypress="Numerique();" onfocus="hideErrors();" /></td>
		  
		  <td width="19%">Date du sortie</td>
		  <td width="31%"><html:text styleClass="champText" property="dateStockEntree" styleId="dateNaissanceR" size ="23"/></td>
		  </tr>
		  <tr>
		  <td width="19%" >Source</td>
		  <td width="31%">
		  <html:select property="numeroSource">
			           <html:option value="2">Grand Magasin</html:option>
			           <html:option value="1">Petit Magasin</html:option>
		  </html:select>
		  </td>
		  </tr>
		  <tr>
		  <td colspan="4" align="center">
		  <input type="button" value="Enregistrer" size ="50" style="font-weight:bold; background-color:#00253E; color:#FFFFFF; cursor:hand; border:solid 2px #FF6600;"  onclick="check();" onfocus="hideErrors();"/>
		  </td>
		  </tr>
		  </table>
		   </td></tr>
		  </table>
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

<tr align="center"  bgcolor="#00253E"  style=" font-size:13;" >
	 
	    <td align="center" height="20" ><div align="center"><font style="oblique" color="#FFFFFF">Copyright  CLINIQUE CHIVA</font></div></td>

	 </tr>
	
</table>

</div>

</body>
</html>