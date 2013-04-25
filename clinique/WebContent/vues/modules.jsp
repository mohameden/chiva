<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="/WEB-INF/tld/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/tld/struts-bean.tld" prefix="bean"%>
 <%@ taglib uri="/WEB-INF/tld/struts-logic.tld" prefix="logic" %>
<html>
<head>

<title>Page de modules</title>

<script src="<%=request.getContextPath()%>/js/commun.js" ></script>
<script src="<%=request.getContextPath()%>/js/browsers.js" ></script>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/styleBoutonsMenu.css" />

<link type="text/css" href="<%=request.getContextPath()%>/js/jquery-ui-1.8.18.custom/css/ui-lightness/jquery-ui-1.8.18.custom.css" rel="stylesheet" />	
<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery-ui-1.8.18.custom/js/jquery-1.7.1.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery-ui-1.8.18.custom/js/jquery-ui-1.8.18.custom.min.js"></script>
<link type="text/css" href="<%=request.getContextPath()%>/js/jquery-ui-1.8.18.custom/development-bundle/demos/demos.css" rel="stylesheet" />

<script type="text/javascript">


$(window).load(function(){

  // Le code plac? ici sera d?clench? au chargement complet de la page.
 	//getUser();
      //alert(document.forms[0].profil.value);
	//document.forms[0].submit();
});


function getUser()
{
	var wshshell=new ActiveXObject("wscript.shell");
	document.forms[0].loginUser.value=wshshell.ExpandEnvironmentStrings("%username%");
	alert(document.forms[0].loginUser.value);
}


</script>



</head>

<body>

<table bordercolor="#FF6600;" height="100%"  width="100%" align="center" style="border-right-style:solid; border-left-style:solid; border-top-style:solid; border-bottom-style:solid;">
<jsp:include page="/template/header.jsp" />
<tr>
<td style="background:#00253E;">
 <html:form action="/authentification.do">
<input name="dispatch" type="hidden" value=""/>
<input name="loginUser" type="hidden" value="<bean:write name="formSecurite" property="loginUser" />"/>  
<input name="profil" type="hidden" value="<bean:write name="formSecurite" property="profil" />"/> 

<table width="90%"   align="center" style="background:#00253E;">
<tr>
<td>

<!-- Administrateur  -->
<logic:equal name="formSecurite" property="profil" value="administrateur">
<table width="60%"   align="center" cellpadding="10"  style="background:#00253E;">				  
 	  <tr style="background:#00253E;" >
			<td  width="50%">
			<span class="commerciale">
			<a href="javascript:document.forms[1].dispatch.value='gestionCom';
			document.forms[1].submit();" ></a>
			</span>
			</td>
			
			<td  width="50%">
			<span class="labo">
			<a href="rien" ></a>
			</span>
			</td>
		  </tr>
		 
		 <tr style="background:#00253E;" >
			<td  width="50%">
			<span class="stock">
			<a href="vues/gestionStock/gestionStock.jsp" ></a>
			</span>
			</td>
			
			<td  width="50%">
			<span class="pers">
			<a href="rien" ></a>
			</span>
			</td>
		  </tr>
		  
		  
		  <tr style="background:#00253E;" >
			<td  width="50%">
			<span class="medical">
			<a href="rien" ></a>
			</span>
			</td>
			
			<td  width="50%">
			<span class="budget">
			<a href="rien" ></a>
			</span>
			</td>
		  </tr>
		  
		  
		  <tr style="background:#00253E;" >
			<td  width="50%">
			<span class="tresorie">
			<a href="rien" ></a>
			</span>
			</td>
			
			<td  width="50%">
			<span class="compt">
			<a href="rien" ></a>
			</span>
			</td>
		  </tr>
		  
  
  
</table>
</logic:equal>

<!-- operateur saisi  -->
<logic:equal name="formSecurite" property="profil" value="operateurSaisie">
<table width="60%"   align="center" cellpadding="10"  style="background:#00253E;">				  
 	  <tr style="background:#00253E;" >
			<td align="center"  colspan="2">
			<span class="commerciale">
			<a href="javascript:document.forms[1].dispatch.value='gestionCom';
			document.forms[1].submit();" ></a>
			</span>
			</td>

		  </tr>
</table>
</logic:equal>

<!-- Impression Factures  -->
<logic:equal name="formSecurite" property="profil" value="impressionFacture">
<table width="60%"   align="center" cellpadding="10"  style="background:#00253E;">				  
 	    <tr style="background:#00253E;" >
			<td align="center"  colspan="2">
			<span class="ImpFact">
			<a href="javascript:document.forms[1].dispatch.value='impressionFactures'; document.forms[1].submit();" ></a>
			</span>
			</td>

		  </tr>
</table>
</logic:equal>

<!-- Modification factures  -->
<logic:equal name="formSecurite" property="profil" value="modificationFacture">
<table width="60%"   align="center" cellpadding="10"  style="background:#00253E;">				  
 	  <tr style="background:#00253E;" >
			<td  align="center" colspan="2">
			<span class="commerciale">
			<a href="javascript:document.forms[1].dispatch.value='gestionCom';
			document.forms[1].submit();" ></a>
			</span>
			</td>

		  </tr>
</table>
</logic:equal>

<!-- validation1 factures  -->
<logic:equal name="formSecurite" property="profil" value="validationFacture1">
<table width="60%"   align="center" cellpadding="10"  style="background:#00253E;">				  
 	  <tr style="background:#00253E;" >
			<td  align="center" colspan="2">
			<span class="commerciale">
			<a href="javascript:document.forms[1].dispatch.value='gestionCom';
			document.forms[1].submit();" ></a>
			</span>
			</td>

		  </tr>
</table>
</logic:equal>

<!-- validation2 factures  -->
<logic:equal name="formSecurite" property="profil" value="validationFacture2">
<table width="60%"   align="center" cellpadding="10"  style="background:#00253E;">				  
 	  <tr style="background:#00253E;" >
			<td  align="center" colspan="2">
			<span class="commerciale">
			<a href="javascript:document.forms[1].dispatch.value='gestionCom';
			document.forms[1].submit();" ></a>
			</span>
			</td>
		  </tr>
</table>
</logic:equal>


</td>
</tr>

</table>
</html:form>

 <html:form action="/patientAction">
<input name="dispatch" type="hidden" value=""/>
<input name="login" type="hidden" value="<bean:write name="formSecurite" property="loginUser" />"/>  
<input name="profil" type="hidden" value="<bean:write name="formSecurite" property="profil" />"/> 
</html:form>


</td>
</tr>
<jsp:include page="/template/footer.jsp" />
</table>
</body>
</html>