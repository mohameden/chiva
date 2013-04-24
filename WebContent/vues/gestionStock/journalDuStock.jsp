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
<title>Journal du stock</title>

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
				
		function imprimer()
    	{
        	
        	document.forms[0].dispatch.value = "imprimerJournalStock";
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


<table width="100%" align="left" style="background:#00253E; font-size:14; font-weight:bold; color: white;">
<tr>
<td>
<div align="center"><input type="button" onclick="imprimer();" value="Imprimer" size ="50" style="font-weight:bold; background-color:#00253E; color:#FFFFFF; cursor:hand; border:solid 2px #FF6600;"  /></div>
</td>
</tr>
		  <tr  align="center" style="background:#0B415F; border-left-color:#CBE4F4; border-left-style:solid;" >
            <td colspan="4" style="font-weight:bold"><font style="oblique" color="#FFFFFF"  size="4"> Journal du stock </font></td>
          </tr>
	<tr><td colspan="4" align="center" width="100%">
  <display:table id="row"  name="sessionScope.formGestionStock.journalStockList"  class="mars" pagesize="3" defaultsort="1" defaultorder="descending" >
		<display:setProperty name="paging.banner.placement" value="bottom"></display:setProperty>
		<display:setProperty name="css.tr.even" value="even"></display:setProperty>
		   
		    <display:column  property="nomProduit" title="Produit" />
			<display:column  property="quantiteStockEntrante" title="Quantité entrante" sortable="true"/>
			<display:column  property="quantiteStockSortie" title="Quantité sortante" sortable="true"/>
			<display:column  property="quantiteDisponible" title="Quantité restante" sortable="true"/>
 </display:table>
		  		  </td>
		  		  </tr>
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