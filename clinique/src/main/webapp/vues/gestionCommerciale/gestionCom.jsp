<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="/WEB-INF/tld/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/tld/struts-bean.tld" prefix="bean"%>
 <%@ taglib uri="/WEB-INF/tld/struts-logic.tld" prefix="logic" %>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Page de modules</title>
<script src="<%=request.getContextPath()%>/js/commun.js" ></script>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/styleBoutonsMenu.css" />
</head>

<body>
<div class=demos>
<table bordercolor="#FF6600;" height="100%"  width="100%" align="center" style="border-right-style:solid; border-left-style:solid; border-top-style:solid; border-bottom-style:solid;">

<jsp:include page="/template/header.jsp" />
<html:form action="/patientAction">
<input type="hidden" name="dispatch"/>
<input type="hidden" name="subAction"/>
<input name="login" type="hidden" value="<bean:write name="formInfosPatient" property="login" />"/>  
<input name="profil" type="hidden" value="<bean:write name="formInfosPatient" property="profil" />"/> 

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
					<a href="javascript:document.forms[0].dispatch.value='infosPatient'; document.forms[0].submit();" />
	  </span>
	</td>
</tr>
</table>
</td>
</tr>

<tr>
<td style="background:#00253E;">
<table width="90%"   align="center" style="background:#00253E;">
<tr>
<td>
<logic:equal name="formInfosPatient" property="profil" value="administrateur">
<table width="60%"   align="center" cellpadding="10"  style="background:#00253E;">
				  
 	  <tr style="background:#00253E;" align="center" >
			<td  align="center" >
			<span class="prestations">
			<a href="javascript:document.forms[0].dispatch.value='infosPatient'; document.forms[0].submit();" />
			</span>
			</td>
			
		
		  </tr>
		  
		  <tr style="background:#00253E;" align="center"  >
			<td  align="center" >
			<span class="hospitalisation">
			<a href="javascript:document.forms[0].dispatch.value='mainPageHospit'; document.forms[0].submit();" ></a>
			</span>
			</td>
		  </tr>
		  
		     <tr style="background:#00253E;" >
			<td align="center">
			<span class="ImpFact">
			<a href="javascript:document.forms[0].dispatch.value='impressionFactures'; document.forms[0].submit();" ></a>
			</span>
			</td>

		  </tr>
		  
		   <tr style="background:#00253E;" >
			<td align="center">
			<span class="GenFact">
			<a href="javascript:document.forms[0].dispatch.value='pageFactureAgenerer'; document.forms[0].submit();" ></a>
			</span>
			</td>

		  </tr>
		  
		   <tr style="background:#00253E;" align="center"  >
			<td  align="center" >
			<span class="devis">
			<a href="javascript:document.forms[0].dispatch.value='infosPatientDevis'; document.forms[0].submit();" ></a>
			</span>
			</td>
		  </tr>
</table>
</logic:equal>

<logic:equal name="formInfosPatient" property="profil" value="operateurSaisie">
<table width="60%"   align="center" cellpadding="10"  style="background:#00253E;">
				  
 	  <tr style="background:#00253E;" align="center" >
			<td  align="center" >
			<span class="prestations">
			<a href="javascript:document.forms[0].dispatch.value='infosPatient'; document.forms[0].submit();" />
			</span>
			</td>
		  </tr>
		  
		  <tr style="background:#00253E;" align="center"  >
			<td  align="center" >
			<span class="hospitalisation">
			<a href="javascript:document.forms[0].dispatch.value='mainPageHospit'; document.forms[0].submit();" ></a>
			</span>
			</td>
		  </tr>
		  
		   <tr style="background:#00253E;" align="center"  >
			<td  align="center" >
			<span class="devis">
			<a href="javascript:document.forms[0].dispatch.value='mainPageHospit'; document.forms[0].submit();" ></a>
			</span>
			</td>
		  </tr>
		  
		  
		 
</table>
</logic:equal>


<!-- Impression Factures  -->
<logic:equal name="formInfosPatient" property="profil" value="impressionFacture">
<table width="60%"   align="center" cellpadding="10"  style="background:#00253E;">				  
 	    <tr style="background:#00253E;" >
			<td align="center"  colspan="2">
			<span class="ImpFact">
			<a href="javascript:document.forms[0].dispatch.value='impressionFactures'; document.forms[0].submit();" ></a>
			</span>
			</td>

		  </tr>
</table>
</logic:equal>

<!-- Modification factures  -->
<logic:equal name="formInfosPatient" property="profil" value="modificationFacture">
<table width="60%"   align="center" cellpadding="10"  style="background:#00253E;">				  
 	  <tr style="background:#00253E;" >
			<td  align="center" colspan="2">
			<span class="ModFact">
			<a href="javascript:document.forms[0].dispatch.value='listFacturesGenerees';
			document.forms[0].submit();" ></a>
			</span>
			</td>

		  </tr>
</table>
</logic:equal>

<!-- validation1 factures  -->
<logic:equal name="formInfosPatient" property="profil" value="validationFacture1">
<table width="60%"   align="center" cellpadding="10"  style="background:#00253E;">				  
 	  <tr style="background:#00253E;" >
			<td  align="center" colspan="2">
			<span class="Val1Fac">
			<a href="" ></a>
			</span>
			</td>

		  </tr>
</table>
</logic:equal>

<!-- validation2 factures  -->
<logic:equal name="formInfosPatient" property="profil" value="validationFacture2">
<table width="60%"   align="center" cellpadding="10"  style="background:#00253E;">				  
 	  <tr style="background:#00253E;" >
			<td  align="center" colspan="2">
			<span class="Val2Fac">
			<a href="" ></a>
			</span>
			</td>
		  </tr>
</table>
</logic:equal>
</td>
</tr>

</table>

</td>
</tr>




</html:form>
<jsp:include page="/template/footer.jsp" />
</table>
</div>
</body>
</html>